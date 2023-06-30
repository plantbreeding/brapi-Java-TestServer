package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.CallsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.api.CallsApi;
import io.swagger.model.Call;
import io.swagger.model.CallsResponse;
import io.swagger.model.CallsResponseResult;
import io.swagger.model.Metadata;
import io.swagger.model.WSMIMEDataTypes;

@RestController
public class CallsController extends BrAPIController implements CallsApi {

	CallsService callService;

	@Autowired
	public CallsController(CallsService callService) {
		super();
		this.callService = callService;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<CallsResponse> callsGet(@Valid String datatype, @Valid String dataType,
			@Valid Integer page, @Valid Integer pageSize, String authorization) throws BrAPIServerException {

		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		WSMIMEDataTypes dataTypeEnum = null;
		if(datatype != null) {
			dataTypeEnum = WSMIMEDataTypes.fromValue(datatype);
		}
		if(dataType != null) {
			dataTypeEnum = WSMIMEDataTypes.fromValue(dataType);
		}
		
		List<Call> calls = callService.getAvailableCalls(dataTypeEnum, metadata);

		CallsResponseResult result = new CallsResponseResult();
		result.setData(calls);
		CallsResponse response = new CallsResponse();
		response.setMetadata(metadata);
		response.setResult(result);
		return new ResponseEntity<CallsResponse>(response, HttpStatus.OK);
	}
}
