package org.brapi.test.BrAPITestServer.service.geno;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.geno.ReferenceSetEntity;
import org.brapi.test.BrAPITestServer.repository.geno.ReferenceSetRepository;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.geno.OntologyTerm;
import io.swagger.model.geno.ReferenceSet;
import io.swagger.model.geno.ReferenceSetsSearchRequest;

@Service
public class ReferenceSetService {
	
	private final ReferenceSetRepository referenceSetRepository;

	public ReferenceSetService(ReferenceSetRepository referenceSetRepository) {
		this.referenceSetRepository = referenceSetRepository;
	}

	public List<ReferenceSet> findReferenceSets(String referenceSetDbId, String accession,
			String assemblyPUI, String md5checksum, Metadata metadata) {
		ReferenceSetsSearchRequest request = new ReferenceSetsSearchRequest();
		if (referenceSetDbId != null)
			request.addReferenceSetDbIdsItem(referenceSetDbId);
		if (accession != null)
			request.addAccessionsItem(accession);
		if (assemblyPUI != null)
			request.addAssemblyPUIsItem(assemblyPUI);
		if (md5checksum != null)
			request.addMd5checksumsItem(md5checksum);

		return findReferenceSets(request, metadata);
	}

	public List<ReferenceSet> findReferenceSets(ReferenceSetsSearchRequest request, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<ReferenceSetEntity> searchQuery = new SearchQueryBuilder<ReferenceSetEntity>(ReferenceSetEntity.class)
				.appendList(request.getAccessions(), "sourceGermplasm.germplasmName")
				.appendList(request.getAssemblyPUIs(), "assemblyPUI")
				.appendList(request.getMd5checksums(), "md5checksum")
				.appendList(request.getReferenceSetDbIds(), "id");

		Page<ReferenceSetEntity> page = referenceSetRepository.findAllBySearch(searchQuery, pageReq);
		List<ReferenceSet> referenceSets = page.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, page);
		return referenceSets;
	}

	public ReferenceSet getReferenceSet(String referenceSetDbId) throws BrAPIServerException {
		return convertFromEntity(getReferenceSetEntity(referenceSetDbId));
	}

	public ReferenceSetEntity getReferenceSetEntity(String referenceSetDbId) throws BrAPIServerException {
		ReferenceSetEntity referenceSet = null;
		Optional<ReferenceSetEntity> entityOpt = referenceSetRepository.findById(referenceSetDbId);
		if (entityOpt.isPresent()) {
			referenceSet = entityOpt.get();
		} else {
			throw new BrAPIServerDbIdNotFoundException("referenceSet", referenceSetDbId);
		}
		return referenceSet;
	}

	private ReferenceSet convertFromEntity(ReferenceSetEntity entity) {
		ReferenceSet ref = new ReferenceSet();
		ref.setAdditionalInfo(entity.getAdditionalInfoMap());
		ref.setAssemblyPUI(entity.getAssemblyPUI());
		ref.setDescription(entity.getDescription());
		ref.setIsDerived(entity.getIsDerived());
		ref.setMd5checksum(entity.getMd5checksum());
		ref.setReferenceSetDbId(entity.getId());
		ref.setReferenceSetName(entity.getReferenceSetName());
		if (entity.getSourceGermplasm() != null && entity.getSourceGermplasm().getAccessionNumber() != null)
			ref.setSourceAccessions(Arrays.asList(entity.getSourceGermplasm().getAccessionNumber()));
		ref.setSourceURI(entity.getSourceURI());
		OntologyTerm term = new OntologyTerm().term(entity.getSpeciesOntologyTerm())
				.termURI(entity.getSpeciesOntologyTermURI());
		ref.setSpecies(term);
		return ref;
	}

}
