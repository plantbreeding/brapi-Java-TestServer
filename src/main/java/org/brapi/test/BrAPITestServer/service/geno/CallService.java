package org.brapi.test.BrAPITestServer.service.geno;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.math.NumberUtils;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.geno.CallEntity;
import org.brapi.test.BrAPITestServer.repository.geno.CallRepository;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.geno.Call;
import io.swagger.model.geno.CallGenotypeMetadata;
import io.swagger.model.geno.CallsListResponseResult;
import io.swagger.model.geno.CallsSearchRequest;
import io.swagger.model.geno.DataTypePrimitives;
import io.swagger.model.geno.ListValue;

@Service
public class CallService {

	public static final boolean EXPAND_HOMOZYFOTES_DEFAULT = true;
	public static final String SEP_PHASED_DEFAULT = "/";
	public static final String SEP_UNPHASED_DEFAULT = "|";
	public static final String UNKNOWN_STRING_DEFAULT = ".";

	private final CallRepository callRepository;

	public CallService(CallRepository callRepository) {
		this.callRepository = callRepository;
	}

	public CallsListResponseResult findCalls(String callSetDbId, String variantDbId, String variantSetDbId,
			Boolean expandHomozygotes, String unknownString, String sepPhased, String sepUnphased, Metadata metadata) {
		CallsSearchRequest request = new CallsSearchRequest();
		if (callSetDbId != null)
			request.addCallSetDbIdsItem(callSetDbId);
		if (variantDbId != null)
			request.addVariantDbIdsItem(variantDbId);
		if (variantSetDbId != null)
			request.addVariantSetDbIdsItem(variantSetDbId);
		request.setExpandHomozygotes(expandHomozygotes);
		request.setUnknownString(unknownString);
		request.setSepPhased(sepPhased);
		request.setSepUnphased(sepUnphased);

		return findCalls(request, metadata);
	}

	public CallsListResponseResult findCalls(CallsSearchRequest request, Metadata metadata) {
		List<Call> calls = findCallEntities(request, metadata).stream().map(e -> {
			return convertFromEntityWithFormatting(e, request);
		}).collect(Collectors.toList());
		CallsListResponseResult result = buildResult(request, calls);
		return result;
	}

	public List<CallEntity> findCallEntities(CallsSearchRequest request, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<CallEntity> searchQuery = new SearchQueryBuilder<CallEntity>(CallEntity.class)
				.appendList(request.getCallSetDbIds(), "callSet.id").appendList(request.getVariantDbIds(), "variant.id")
				.appendList(request.getVariantSetDbIds(), "variant.variantSet.id");

		Page<CallEntity> page = callRepository.findAllBySearch(searchQuery, pageReq);
		PagingUtility.calculateMetaData(metadata, page);
		return page.getContent();
	}

	private CallsListResponseResult buildResult(CallsSearchRequest request, List<Call> calls) {
		CallsListResponseResult result = new CallsListResponseResult();
		result.setData(calls);
		result.setExpandHomozygotes(EXPAND_HOMOZYFOTES_DEFAULT);
		if (request.isExpandHomozygotes() != null)
			result.setExpandHomozygotes(request.isExpandHomozygotes());
		result.setSepPhased(SEP_PHASED_DEFAULT);
		if (request.getSepPhased() != null)
			result.setSepPhased(request.getSepPhased());
		result.setSepUnphased(SEP_UNPHASED_DEFAULT);
		if (request.getSepUnphased() != null)
			result.setSepUnphased(request.getSepUnphased());
		result.setUnknownString(UNKNOWN_STRING_DEFAULT);
		if (request.getUnknownString() != null)
			result.setUnknownString(request.getUnknownString());

		return result;
	}

	public Call convertFromEntity(CallEntity entity) {
		return convertFromEntityWithFormatting(entity, new CallsSearchRequest());
	}

	private Call convertFromEntityWithFormatting(CallEntity entity, CallsSearchRequest request) {
		Call call = new Call();
		call.setAdditionalInfo(entity.getAdditionalInfo());
		if (entity.getCallSet() != null) {
			call.setCallSetDbId(entity.getCallSet().getId());
			call.setCallSetName(entity.getCallSet().getCallSetName());
		}
		if (entity.getGenotype() != null) {
			String genotypeString = entity.getGenotype();
			if(request.getSepPhased() != null)
				genotypeString = genotypeString.replace(SEP_PHASED_DEFAULT, request.getSepPhased());
			if(request.getSepUnphased() != null)
				genotypeString = genotypeString.replace(SEP_UNPHASED_DEFAULT, request.getSepUnphased());

			ListValue listValues = new ListValue();
			listValues.setValues(Arrays.asList(genotypeString));
			call.setGenotype(listValues);
			call.setGenotypeValue(genotypeString);
		}
		if (entity.getReadDepth() != null) {
			CallGenotypeMetadata metadata = new CallGenotypeMetadata();
			metadata.setDataType(DataTypePrimitives.INTEGER);
			metadata.setFieldAbbreviation("RD");
			metadata.setFieldName("Read Depth");
			metadata.setFieldValue(entity.getReadDepth().toString());
			call.addGenotypeMetadataItem(metadata);
		}
		if (entity.getGenotypeLikelihood() != null) {
			call.setGenotypeLikelihood(Arrays.asList(entity.getGenotypeLikelihood()));

			CallGenotypeMetadata metadata = new CallGenotypeMetadata();
			metadata.setDataType(DataTypePrimitives.INTEGER);
			metadata.setFieldAbbreviation("GL");
			metadata.setFieldName("Genotype Likelihood");
			metadata.setFieldValue(entity.getGenotypeLikelihood().toString());

			call.addGenotypeMetadataItem(metadata);
		}
		call.setPhaseSet(entity.getPhaseSet());
		if (entity.getVariant() != null) {
			call.setVariantDbId(entity.getVariant().getId());
			call.setVariantName(entity.getVariant().getVariantName());
			call.setVariantSetDbId(entity.getVariant().getVariantSet().getId());
			call.setVariantSetName(entity.getVariant().getVariantSet().getVariantSetName());
		}
		return call;
	}

	public void save(List<CallEntity> entities) {
		callRepository.saveAll(entities);
	}

	public CallsListResponseResult updateCalls(List<Call> body) throws BrAPIServerException {
		CallsSearchRequest searchReq = new CallsSearchRequest();
		Map<String, Call> callsMap = new HashMap<>();
		for (Call call : body) {
			if (call.getCallSetDbId() == null || call.getVariantDbId() == null || call.getVariantSetDbId() == null) {
				throw new BrAPIServerException(HttpStatus.BAD_REQUEST,
						"The request must contain a valid CallSetDbId, VariantDbId, and VariantSetDbId for every call.\nCallSetDbId: "
								+ call.getCallSetDbId() + "\nVariantDbId: " + call.getVariantDbId()
								+ "\nVariantSetDbId: " + call.getVariantSetDbId());
			}
			searchReq.addCallSetDbIdsItem(call.getCallSetDbId());
			searchReq.addVariantDbIdsItem(call.getVariantDbId());
			searchReq.addVariantSetDbIdsItem(call.getVariantSetDbId());
			String compositeKey = call.getVariantSetDbId() + call.getVariantDbId() + call.getCallSetDbId();
			callsMap.put(compositeKey, call);
		}

		List<CallEntity> entities = findCallEntities(searchReq, null);
		List<CallEntity> savedEntities = new ArrayList<>();
		for (CallEntity entity : entities) {
			String compositeKey = entity.getVariant().getVariantSet().getId() + entity.getVariant().getId()
					+ entity.getCallSet().getId();
			Call updateCall = callsMap.get(compositeKey);
			if (updateCall != null) {
				updateEntity(entity, updateCall);
				savedEntities.add(entity);
			}
		}
		savedEntities = callRepository.saveAll(savedEntities);

		List<Call> calls = savedEntities.stream().map(e -> {
			return convertFromEntityWithFormatting(e, searchReq);
		}).collect(Collectors.toList());
		CallsListResponseResult result = buildResult(searchReq, calls);
		return result;
	}

	private void updateEntity(CallEntity entity, Call call) {
		if (call.getAdditionalInfo() != null) {
			entity.setAdditionalInfo(call.getAdditionalInfo());
		}
		if (call.getPhaseSet() != null) {
			entity.setPhaseSet(call.getPhaseSet());
		}
		if (call.getGenotypeLikelihood() != null && !call.getGenotypeLikelihood().isEmpty()) {
			entity.setGenotypeLikelihood(call.getGenotypeLikelihood().get(0));
		}
		if (call.getGenotypeValue() != null) {
			entity.setGenotype(call.getGenotypeValue());
		}
		for (CallGenotypeMetadata meta : call.getGenotypeMetadata()) {
			if (meta.getFieldAbbreviation().equalsIgnoreCase("RD")) {
				entity.setReadDepth(NumberUtils.toInt(meta.getFieldValue()));
			}
			if (meta.getFieldAbbreviation().equalsIgnoreCase("GL")) {
				entity.setGenotypeLikelihood(NumberUtils.toDouble(meta.getFieldValue()));
			}
		}

	}

}
