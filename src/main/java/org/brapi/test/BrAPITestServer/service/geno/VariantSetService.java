package org.brapi.test.BrAPITestServer.service.geno;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.geno.CallEntity;
import org.brapi.test.BrAPITestServer.model.entity.geno.CallSetEntity;
import org.brapi.test.BrAPITestServer.model.entity.geno.VariantEntity;
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
import io.swagger.model.geno.CallSetsSearchRequest;
import io.swagger.model.geno.CallsSearchRequest;
import io.swagger.model.geno.VariantSet;
import io.swagger.model.geno.VariantSetAvailableFormats;
import io.swagger.model.geno.VariantSetsSearchRequest;
import io.swagger.model.geno.VariantsSearchRequest;
import io.swagger.model.geno.VariantSetsExtractRequest;

@Service
public class VariantSetService {

	private final VariantSetRepository variantSetRepository;
	private final VariantService variantService;
	private final CallSetService callSetService;
	private final CallService callService;

	public VariantSetService(VariantSetRepository variantSetRepository, VariantService variantService,
			CallSetService callSetService, CallService callService) {
		this.variantSetRepository = variantSetRepository;
		this.variantService = variantService;
		this.callSetService = callSetService;
		this.callService = callService;
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
		List<VariantSet> variantSets = findVariantSetEntities(request, metadata).stream().map(this::convertFromEntity)
				.collect(Collectors.toList());
		return variantSets;
	}

	private List<VariantSetEntity> findVariantSetEntities(VariantSetsSearchRequest request, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<VariantSetEntity> searchQuery = new SearchQueryBuilder<VariantSetEntity>(VariantSetEntity.class);
		if(request.getCallSetDbIds() != null) {
			searchQuery.join("callSets", "callSet")
			.appendList(request.getCallSetDbIds(), "*callSet.id");
		}
		if(request.getVariantDbIds() != null) {
			searchQuery.join("variants", "variant")
			.appendList(request.getVariantDbIds(), "*variant.id");
		}
		searchQuery.appendList(request.getStudyDbIds(), "study.id")
				.appendList(request.getStudyNames(), "study.studyName")
				.appendList(request.getVariantSetDbIds(), "id");

		Page<VariantSetEntity> page = variantSetRepository.findAllBySearch(searchQuery, pageReq);
		PagingUtility.calculateMetaData(metadata, page);
		return page.getContent();
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
			throw new BrAPIServerException(HttpStatus.NOT_FOUND, "variantSetDbId not found: " + variantSetDbId);
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

	public VariantSet extractVariantSet(VariantSetsExtractRequest request) throws BrAPIServerException {
		CallsSearchRequest callsRequest = new CallsSearchRequest();
		CallSetsSearchRequest callSetRequest = new CallSetsSearchRequest();
		VariantsSearchRequest variantRequest = new VariantsSearchRequest();
		VariantSetsSearchRequest variantSetsRequest = new VariantSetsSearchRequest();
		if (request.getCallSetDbIds() != null) {
			callsRequest.setCallSetDbIds(request.getCallSetDbIds());
			callSetRequest.setCallSetDbIds(request.getCallSetDbIds());
			variantSetsRequest.setCallSetDbIds(request.getCallSetDbIds());
		}
		if (request.getVariantDbIds() != null) {
			callsRequest.setVariantDbIds(request.getVariantDbIds());
			variantRequest.setVariantDbIds(request.getVariantDbIds());
			variantSetsRequest.setVariantDbIds(request.getVariantDbIds());
		}
		if (request.getVariantSetDbIds() != null) {
			callsRequest.setVariantSetDbIds(request.getVariantSetDbIds());
			callSetRequest.setVariantSetDbIds(request.getVariantSetDbIds());
			variantRequest.setVariantSetDbIds(request.getVariantSetDbIds());
			variantSetsRequest.setVariantSetDbIds(request.getVariantSetDbIds());
		}

		List<VariantSetEntity> variantSets = findVariantSetEntities(variantSetsRequest, null);
		List<VariantEntity> variants = variantService.findVariantEntities(variantRequest, null);
		List<CallSetEntity> callSets = callSetService.findCallSetEntities(callSetRequest, null);
		List<CallEntity> calls = callService.findCallEntities(callsRequest, null);

		VariantSetEntity variantSetEntity = copyVariantSet(variantSets);
		Map<String, VariantEntity> newVariantMap = copyVariants(variantSetEntity, variants);
		Map<String, CallSetEntity> newCallSetMap = copyCallSets(variantSetEntity, callSets);
		copyCalls(newVariantMap, newCallSetMap, calls);

		variantSetEntity = variantSetRepository.save(variantSetEntity);
		return convertFromEntity(variantSetEntity);
	}

	private VariantSetEntity copyVariantSet(List<VariantSetEntity> variantSets) throws BrAPIServerException {
		VariantSetEntity entity= new VariantSetEntity();;
		if (variantSets.size() == 1) {
			entity.setVariantSetName(variantSets.get(0).getVariantSetName() + "-Copy");
		} else if (variantSets.size() > 1) {
			entity.setVariantSetName(variantSets.get(0).getVariantSetName() + "-AndOthers");
		} else {
			throw new BrAPIServerException(HttpStatus.BAD_REQUEST, "No data matches the search parameters, new VariantSet not created");
		}
		entity.setId(null);
		entity.setCallSets(new ArrayList<>());
		entity.setVariants(new ArrayList<>());

		entity = variantSetRepository.save(entity);
		return entity;
	}

	private Map<String, VariantEntity> copyVariants(VariantSetEntity variantSetEntity, List<VariantEntity> variants) {
		Map<String, VariantEntity> newVariantMap = new HashMap<>();
		for(VariantEntity variant: variants) {
			VariantEntity entity = new VariantEntity(variant);
			String oldId = entity.getId();
			entity.setId(null);
			entity.setVariantSet(variantSetEntity);
			VariantEntity saved = variantService.save(entity);
			newVariantMap.put(oldId, saved);
			variantSetEntity.getVariants().add(saved);
		}
		return newVariantMap;
	}

	private Map<String, CallSetEntity> copyCallSets(VariantSetEntity variantSetEntity, List<CallSetEntity> callSets) {
		Map<String, CallSetEntity> newCallSetMap = new HashMap<>();
		for(CallSetEntity callSet: callSets) {
			CallSetEntity entity = new CallSetEntity(callSet);
			String oldId = entity.getId();
			entity.setId(null);
			entity.setVariantSets(new ArrayList<>());
			entity.getVariantSets().add(variantSetEntity);
			CallSetEntity saved = callSetService.save(entity);
			newCallSetMap.put(oldId, saved);
			variantSetEntity.getCallSets().add(saved);
		}
		return newCallSetMap;
	}

	private void copyCalls(Map<String, VariantEntity> newVariantMap, Map<String, CallSetEntity> newCallSetMap,
			List<CallEntity> calls) {
		List<CallEntity> newCalls = new ArrayList<>();
		for(CallEntity call: calls) {
			CallEntity entity = new CallEntity(call);
			entity.setId(null);
			entity.setCallSet(newCallSetMap.get(entity.getCallSet().getId()));
			entity.setVariant(newVariantMap.get(entity.getVariant().getId()));
			newCalls.add(entity);
		}
		callService.save(newCalls);
	}
}
