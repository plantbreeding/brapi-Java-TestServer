package org.brapi.test.BrAPITestServer.service.geno;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.model.entity.geno.CallEntity;
import org.brapi.test.BrAPITestServer.repository.geno.CallRepository;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.geno.Call;
import io.swagger.model.geno.CallsListResponseResult;
import io.swagger.model.geno.CallsSearchRequest;
import io.swagger.model.geno.ListValue;

@Service
public class CallService {

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
		result.setExpandHomozygotes(false);
		if(request.isExpandHomozygotes() != null) 
			result.setExpandHomozygotes(request.isExpandHomozygotes());
		result.setSepPhased("/");
		if(request.getSepPhased() != null)
			result.setSepPhased(request.getSepPhased());
		result.setSepUnphased("|");
		if(request.getSepUnphased() != null)
			result.setSepUnphased(request.getSepUnphased());
		result.setUnknownString("-");
		if(request.getUnknownString() != null)
			result.setUnknownString(request.getUnknownString());
		
		return result;
	}

	public Call convertFromEntity(CallEntity entity) {
		return convertFromEntityWithFormatting(entity, new CallsSearchRequest());
	}

	private Call convertFromEntityWithFormatting(CallEntity entity, CallsSearchRequest request) {
		Call call = new Call();
		call.setAdditionalInfo(entity.getAdditionalInfoMap());
		if (entity.getCallSet() != null) {
			call.setCallSetDbId(entity.getCallSet().getId());
			call.setCallSetName(entity.getCallSet().getCallSetName());
		}
		if (entity.getGenotype() != null) {
			ListValue genotypeValues = new ListValue();
			genotypeValues.setValues(Arrays.asList(entity.getGenotype().split(":")));
			call.setGenotype(genotypeValues);
		}
		if (entity.getGenotypeLikelihood() != null) {
			call.setGenotypeLikelihood(Arrays.asList(entity.getGenotypeLikelihood()));
		}
		call.setPhaseSet(entity.getPhaseSet());
		if (entity.getVariant() != null) {
			call.setVariantDbId(entity.getVariant().getId());
			call.setVariantName(entity.getVariant().getVariantName());
		}
		return call;
	}

	public void save(List<CallEntity> entities) {
		callRepository.saveAll(entities);
	}

}
