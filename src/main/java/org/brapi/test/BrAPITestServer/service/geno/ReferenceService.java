package org.brapi.test.BrAPITestServer.service.geno;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.lang3.math.NumberUtils;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.geno.ReferenceBasesPageEntity;
import org.brapi.test.BrAPITestServer.model.entity.geno.ReferenceEntity;
import org.brapi.test.BrAPITestServer.repository.geno.ReferenceBaseRepository;
import org.brapi.test.BrAPITestServer.repository.geno.ReferenceRepository;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.geno.OntologyTerm;
import io.swagger.model.geno.Reference;
import io.swagger.model.geno.ReferencesSearchRequest;
import io.swagger.model.geno.ReferenceBases;

@Service
public class ReferenceService {
	private final int pageSize = 2000;

	private final ReferenceRepository referenceRepository;
	private final ReferenceBaseRepository referenceBaseRepository;

	public ReferenceService(ReferenceRepository referenceRepository, ReferenceBaseRepository referenceBaseRepository) {
		this.referenceRepository = referenceRepository;
		this.referenceBaseRepository = referenceBaseRepository;
	}

	public List<Reference> findReferences(String referenceDbId, String referenceSetDbId, String accession,
			String md5checksum, Boolean isDerived, Integer minLength, Integer maxLength, Metadata metadata) {
		ReferencesSearchRequest request = new ReferencesSearchRequest();
		if (referenceDbId != null)
			request.addReferenceDbIdsItem(referenceDbId);
		if (referenceSetDbId != null)
			request.addReferenceSetDbIdsItem(referenceSetDbId);
		if (accession != null)
			request.addAccessionsItem(accession);
		if (md5checksum != null)
			request.addMd5checksumsItem(md5checksum);
		request.setIsDerived(isDerived);
		request.setMinLength(minLength);
		request.setMaxLength(maxLength);

		return findReferences(request, metadata);
	}

	public List<Reference> findReferences(@Valid ReferencesSearchRequest request, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<ReferenceEntity> searchQuery = new SearchQueryBuilder<ReferenceEntity>(ReferenceEntity.class)
				.appendList(request.getAccessions(), "referenceSet.sourceGermplasm.germplasmName")
				.appendList(request.getMd5checksums(), "md5checksum")
				.appendList(request.getReferenceDbIds(), "id")
				.appendList(request.getReferenceSetDbIds(), "referenceSet.id")
				.appendNumberRange(request.getMinLength(), request.getMaxLength(), "length")
				.appendSingle(request.isIsDerived(), "referenceSet.isDerived");

		Page<ReferenceEntity> page = referenceRepository.findAllBySearch(searchQuery, pageReq);
		List<Reference> references = page.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, page);
		return references;
	}

	public Reference getReference(String referenceDbId) throws BrAPIServerException {
		return convertFromEntity(getReferenceEntity(referenceDbId));
	}

	public ReferenceEntity getReferenceEntity(String referenceDbId) throws BrAPIServerException {
		ReferenceEntity reference = null;
		Optional<ReferenceEntity> entityOpt = referenceRepository.findById(referenceDbId);
		if (entityOpt.isPresent()) {
			reference = entityOpt.get();
		} else {
			throw new BrAPIServerDbIdNotFoundException("reference", referenceDbId);
		}
		return reference;
	}

	private Reference convertFromEntity(ReferenceEntity entity) {
		Reference ref = new Reference();
		ref.setAdditionalInfo(entity.getAdditionalInfoMap());
		ref.setLength(entity.getLength());
		ref.setMd5checksum(entity.getMd5checksum());
		ref.setReferenceDbId(entity.getId());
		ref.setReferenceName(entity.getReferenceName());
		if (entity.getReferenceSet() != null) {
			ref.setReferenceSetDbId(entity.getReferenceSet().getId());
			ref.setIsDerived(entity.getReferenceSet().getIsDerived());
			if (entity.getReferenceSet().getSourceGermplasm() != null
					&& entity.getReferenceSet().getSourceGermplasm().getAccessionNumber() != null)
				ref.setSourceAccessions(
						Arrays.asList(entity.getReferenceSet().getSourceGermplasm().getAccessionNumber()));
			ref.setSourceURI(entity.getReferenceSet().getSourceURI());
			OntologyTerm term = new OntologyTerm().term(entity.getReferenceSet().getSpeciesOntologyTerm())
					.termURI(entity.getReferenceSet().getSpeciesOntologyTermURI());
			ref.setSpecies(term);
		}
		if (entity.getSourceDivergence() != null)
			ref.setSourceDivergence(entity.getSourceDivergence().floatValue());

		return ref;
	}

	public ReferenceBases getReferenceBases(String referenceDbId, Integer start, Integer end, String pageTokenStr)
			throws BrAPIServerException {
		ReferenceEntity ref = getReferenceEntity(referenceDbId);
		Integer[] inputs = verifyInput(ref, start, end, pageTokenStr);
		start = inputs[0];
		end = inputs[1];
		int pageToken = inputs[2];

		int pageNumber = calculateDbPageNumber(start, pageToken);
		String bases = getBases(referenceDbId, pageNumber);
		bases = getPaginateBases(bases, start, end, pageNumber);

		ReferenceBases result = new ReferenceBases();
		result.setOffset(start + (pageToken * pageSize));
		if (bases.length() == pageSize)
			result.setNextPageToken(Integer.toString(pageToken + 1));
		result.setSequence(bases);

		return result;
	}

	private String getPaginateBases(String bases, Integer start, Integer end, int pageNumber) {
		int pageStart = start % pageSize;
		int pageEnd = pageStart + pageSize;
		if ((end - (pageNumber * pageSize)) < pageEnd)
			pageEnd = end - (pageNumber * pageSize);
		if (bases.length() < pageEnd)
			pageEnd = bases.length();

		return bases.substring(pageStart, pageEnd);
	}

	private Integer[] verifyInput(ReferenceEntity ref, Integer start, Integer end, String pageTokenStr)
			throws BrAPIServerException {
		if (start == null)
			start = 0;
		if (end == null) {
			if (ref.getLength() != null)
				end = ref.getLength();
			else
				end = 0;
		}
		if (ref.getLength() != null && end > ref.getLength())
			end = ref.getLength();
		if (!NumberUtils.isParsable(pageTokenStr))
			pageTokenStr = "0";
		if (start > end)
			throw new BrAPIServerException(HttpStatus.BAD_REQUEST, "start cannot be greater that end");
		if (start < 0 || end < 0 || Integer.parseInt(pageTokenStr) < 0)
			throw new BrAPIServerException(HttpStatus.BAD_REQUEST, "must be positive integer");

		return new Integer[] { start, end, Integer.parseInt(pageTokenStr) };
	}

	private int calculateDbPageNumber(Integer start, int pageToken) {
		int pageNumber = start / pageSize;
		pageNumber = pageNumber + pageToken;

		return pageNumber;
	}

	private String getBases(String referenceDbId, int pageNumber) {
		Pageable sort = PageRequest.of(0, 1, Sort.by(Direction.ASC, "pageNumber"));
		Page<ReferenceBasesPageEntity> firstPage = referenceBaseRepository.findByReferenceIdAndPageNumber(referenceDbId,
				pageNumber, sort);
		Page<ReferenceBasesPageEntity> secondPage = referenceBaseRepository
				.findByReferenceIdAndPageNumber(referenceDbId, pageNumber + 1, sort);

		String bases = "";
		if (firstPage.getNumberOfElements() == 1) {
			bases = firstPage.getContent().get(0).getBases();
			if (secondPage.getNumberOfElements() == 1) {
				bases = bases + secondPage.getContent().get(0).getBases();
			}
		}
		return bases;
	}

}
