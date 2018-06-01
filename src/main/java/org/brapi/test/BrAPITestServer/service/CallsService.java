package org.brapi.test.BrAPITestServer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.model.entity.CallEntity;
import org.brapi.test.BrAPITestServer.repository.CallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import io.swagger.model.Call;
import io.swagger.model.Metadata;

@Service
public class CallsService {
    private final CallRepository callRepository;

    @Autowired
    public CallsService(CallRepository callRepository) {
        this.callRepository = callRepository;
    }
    
	public List<Call> getAvailableCalls(String datatype, Metadata metadata) {
		List<Call> calls = findCalls(datatype, metadata)
				.stream()
				.map(ce -> {return convertToJSONModel(ce);})
				.collect(Collectors.toList());

		return calls;
	}
	
	private List<CallEntity> findCalls(String datatype, Metadata metadata) {
		Sort sort = Sort.by(Direction.fromString("asc"), "call");
		Pageable pageReq = PagingUtility.getPageRequest(metadata, sort);
		Page<CallEntity> page;
		if(datatype == null) {
			page = callRepository.findAll(pageReq);
		}else {
			page = callRepository.findByDataTypes_DataType(datatype, pageReq);
		}
		PagingUtility.calculateMetaData(metadata, page);
		return page.getContent();
	}

	private Call convertToJSONModel(CallEntity callEntity) {
		Call call = new Call();
		call.setCall(callEntity.getCall());
		call.setDatatypes(
				callEntity.getDataTypes()
				.stream()
				.map(c -> {return c.getDataType();})
				.collect(Collectors.toList()));
		call.setMethods(
				callEntity.getMethods()
				.stream()
				.map(c -> {return c.getMethod();})
				.collect(Collectors.toList()));
		return call;
	}
}
