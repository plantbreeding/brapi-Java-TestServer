package org.brapi.test.BrAPITestServer.service.geno;

import java.util.List;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.model.entity.geno.CallEntity;
import org.brapi.test.BrAPITestServer.repository.geno.CallRepository;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.geno.Call;
import io.swagger.model.geno.CallsSearchRequest;

@Service
public class CallService {
	
	private final CallRepository callRepository;
	
	public CallService(CallRepository callRepository) {
		this.callRepository = callRepository;
	}

	public List<Call> findCalls(String callSetDbId, String variantDbId, String variantSetDbId,
			Boolean expandHomozygotes, String unknownString, String sepPhased,
			String sepUnphased, Metadata metadata) {
		CallsSearchRequest request = new CallsSearchRequest();
		if(callSetDbId != null)
			request.addCallSetDbIdsItem(callSetDbId);
		if(variantDbId != null)
			request.addVariantDbIdsItem(variantDbId);
		if(variantSetDbId != null)
			request.addVariantSetDbIdsItem(variantSetDbId);
		request.setExpandHomozygotes(expandHomozygotes);
		request.setUnknownString(unknownString);
		request.setSepPhased(sepPhased);
		request.setSepUnphased(sepUnphased);
		
		return findCalls(request, metadata);
	}

	public List<Call> findCalls(CallsSearchRequest request, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<CallEntity> searchQuery = new SearchQueryBuilder<CallEntity>(CallEntity.class)
				.appendList(request.getCallSetDbIds(), "callSet.id")
				.appendList(request.getVariantDbIds(), "variant.id")
				.appendList(request.getVariantSetDbIds(), "variant.variantSet.id");

		Page<CallEntity> page = callRepository.findAllBySearch(searchQuery, pageReq);
		List<Call> calls = page.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, page);
		return calls;
	}
	
	private Call convertFromEntity(CallEntity entity) {
		Call call = new Call();
		call.setAdditionalInfo(entity.getAdditionalInfoMap());
		if(entity.getCallSet() != null) {
		call.setCallSetDbId(entity.getCallSet().getId());
		call.setCallSetName(entity.getCallSet().getCallSetName());
		}
		call.set
		return call;
	}

}
