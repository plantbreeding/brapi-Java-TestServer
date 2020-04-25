package org.brapi.test.BrAPITestServer.service.geno;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.geno.VariantSetAnalysisEntity;
import org.brapi.test.BrAPITestServer.model.entity.geno.VariantSetAvailableFormatEntity;
import org.brapi.test.BrAPITestServer.model.entity.geno.VariantSetEntity;
import org.brapi.test.BrAPITestServer.repository.geno.VariantSetRepository;
import org.brapi.test.BrAPITestServer.service.DateUtility;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.geno.Analysis;
import io.swagger.model.geno.VariantSet;
import io.swagger.model.geno.VariantSetAvailableFormats;
import io.swagger.model.geno.VariantSetsSearchRequest;
import io.swagger.model.geno.VariantSetsExtractRequest;

@Service
public class VariantSetService {

	private final VariantSetRepository variantSetRepository;

	public VariantSetService(VariantSetRepository variantSetRepository) {
		this.variantSetRepository = variantSetRepository;
	}

	public List<VariantSet> findVariantSets(String variantSetDbId, String variantDbId, String callSetDbId,
			String studyDbId, String studyName, Metadata metadata) {
		VariantSetsSearchRequest request = new VariantSetsSearchRequest();
		if (variantSetDbId != null)
			request.addVariantSetDbIdsItem(variantSetDbId);
		if (variantDbId != null)
			request.addVariantDbIdsItem(variantDbId);
		if (callSetDbId != null)
			request.addCallSetDbIdsItem(callSetDbId);
		if (studyDbId != null)
			request.addStudyDbIdsItem(studyDbId);
		if (studyName != null)
			request.addStudyNamesItem(studyName);

		return findVariantSets(request, metadata);
	}

	public List<VariantSet> findVariantSets(VariantSetsSearchRequest request, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<VariantSetEntity> searchQuery = new SearchQueryBuilder<VariantSetEntity>(
				VariantSetEntity.class).appendList(request.getCallSetDbIds(), "id")
						.appendList(request.getStudyDbIds(), "id").appendList(request.getStudyNames(), "id")
						.appendList(request.getVariantDbIds(), "id").appendList(request.getVariantSetDbIds(), "id");

		Page<VariantSetEntity> page = variantSetRepository.findAllBySearch(searchQuery, pageReq);
		List<VariantSet> variantSets = page.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, page);
		return variantSets;
	}

	public VariantSet getVariantSet(String variantSetDbId) throws BrAPIServerException {
		return convertFromEntity(getVariantSetEntity(variantSetDbId));
	}

	public VariantSetEntity getVariantSetEntity(String variantSetDbId) throws BrAPIServerException {
		VariantSetEntity variantSet = null;
		Optional<VariantSetEntity> entityOpt = variantSetRepository.findById(variantSetDbId);
		if (entityOpt.isPresent()) {
			variantSet = entityOpt.get();
		} else {
			throw new BrAPIServerException(HttpStatus.NOT_FOUND, "DbId not found: " + variantSetDbId);
		}
		return variantSet;
	}

	private VariantSet convertFromEntity(VariantSetEntity entity) {
		VariantSet variantSet = new VariantSet();
		variantSet.setAdditionalInfo(entity.getAdditionalInfoMap());
		if (entity.getAnalysis() != null)
			variantSet.setAnalysis(
					entity.getAnalysis().stream().map(this::convertFromEntity).collect(Collectors.toList()));
		if (entity.getAvailableFormats() != null)
			variantSet.setAvailableFormats(
					entity.getAvailableFormats().stream().map(this::convertFromEntity).collect(Collectors.toList()));
		if (entity.getCallSets() != null)
			variantSet.setCallSetCount(entity.getCallSets().size());
		if (entity.getReferenceSet() != null)
			variantSet.setReferenceSetDbId(entity.getReferenceSet().getId());
		if (entity.getStudy() != null)
			variantSet.setStudyDbId(entity.getStudy().getId());
		if (entity.getVariants() != null)
			variantSet.setVariantCount(entity.getVariants().size());
		variantSet.setVariantSetDbId(entity.getId());
		variantSet.setVariantSetName(entity.getVariantSetName());

		return variantSet;
	}

	private Analysis convertFromEntity(VariantSetAnalysisEntity entity) {
		Analysis analysis = new Analysis();
		analysis.setAnalysisDbId(entity.getId());
		analysis.setAnalysisName(entity.getAnalysisName());
		analysis.setCreated(DateUtility.toOffsetDateTime(entity.getCreated()));
		analysis.setDescription(entity.getDescription());
		analysis.setSoftware(entity.getSoftware());
		analysis.setType(entity.getType());
		analysis.setUpdated(DateUtility.toOffsetDateTime(entity.getUpdated()));

		return analysis;
	}

	private VariantSetAvailableFormats convertFromEntity(VariantSetAvailableFormatEntity entity) {
		VariantSetAvailableFormats format = new VariantSetAvailableFormats();
		format.setDataFormat(entity.getDataFormat());
		format.setFileFormat(entity.getFileFormat());
		format.setFileURL(entity.getFileURL());
		
		return format;
	}

	public VariantSet extractVariantSet(VariantSetsExtractRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

}
