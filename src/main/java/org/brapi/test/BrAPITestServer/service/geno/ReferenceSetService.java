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
import org.brapi.test.BrAPITestServer.service.UpdateUtility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.geno.OntologyTerm;
import io.swagger.model.geno.ReferenceSet;
import io.swagger.model.geno.ReferenceSetsSearchRequest;
import io.swagger.model.geno.ReferenceSourceGermplasm;

@Service
public class ReferenceSetService {

	private final ReferenceSetRepository referenceSetRepository;

	public ReferenceSetService(ReferenceSetRepository referenceSetRepository) {
		this.referenceSetRepository = referenceSetRepository;
	}

	public List<ReferenceSet> findReferenceSets(String referenceSetDbId, String accession, String assemblyPUI,
			String md5checksum, String trialDbId, String studyDbId, String commonCropName, String programDbId,
			String externalReferenceId, String externalReferenceSource, Metadata metadata) {
		ReferenceSetsSearchRequest request = new ReferenceSetsSearchRequest();
		if (referenceSetDbId != null)
			request.addReferenceSetDbIdsItem(referenceSetDbId);
		if (accession != null)
			request.addAccessionsItem(accession);
		if (assemblyPUI != null)
			request.addAssemblyPUIsItem(assemblyPUI);
		if (md5checksum != null)
			request.addMd5checksumsItem(md5checksum);
		if (commonCropName != null)
			request.addCommonCropNamesItem(commonCropName);
		if (programDbId != null)
			request.addProgramDbIdsItem(programDbId);
		if (trialDbId != null)
			request.addTrialDbIdsItem(trialDbId);
		if (studyDbId != null)
			request.addStudyDbIdsItem(studyDbId);
		
		request.addExternalReferenceItem(externalReferenceId, null, externalReferenceSource);

		return findReferenceSets(request, metadata);
	}

	public List<ReferenceSet> findReferenceSets(ReferenceSetsSearchRequest request, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<ReferenceSetEntity> searchQuery = new SearchQueryBuilder<ReferenceSetEntity>(
				ReferenceSetEntity.class).appendList(request.getAccessions(), "sourceGermplasm.accessionNumber")
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
		ReferenceSet refSet = new ReferenceSet();
		UpdateUtility.convertFromEntity(entity, refSet);
		
		refSet.setAssemblyPUI(entity.getAssemblyPUI());
		refSet.setDescription(entity.getDescription());
		refSet.setIsDerived(entity.getIsDerived());
		refSet.setMd5checksum(entity.getMd5checksum());
		refSet.setReferenceSetDbId(entity.getId());
		refSet.setReferenceSetName(entity.getReferenceSetName());
		refSet.setSourceURI(entity.getSourceURI());
		
		OntologyTerm term = new OntologyTerm().term(entity.getSpeciesOntologyTerm())
				.termURI(entity.getSpeciesOntologyTermURI());
		refSet.setSpecies(term);
		
		if (entity.getSourceGermplasm() != null && entity.getSourceGermplasm().getAccessionNumber() != null)
			refSet.setSourceAccessions(Arrays.asList(entity.getSourceGermplasm().getAccessionNumber()));
		
		if (entity.getSourceGermplasm() != null) {
			if (entity.getSourceGermplasm().getAccessionNumber() != null) {
				refSet.setSourceAccessions(
						Arrays.asList(entity.getSourceGermplasm().getAccessionNumber()));
			}
			refSet.setCommonCropName(entity.getSourceGermplasm().getCrop().getCropName());
			ReferenceSourceGermplasm sourceGerm = new ReferenceSourceGermplasm();
			sourceGerm.setGermplasmDbId(entity.getSourceGermplasm().getId());
			sourceGerm.setGermplasmName(entity.getSourceGermplasm().getGermplasmName());
			refSet.setSourceGermplasm(Arrays.asList(sourceGerm));
		}
		
		return refSet;
	}

}
