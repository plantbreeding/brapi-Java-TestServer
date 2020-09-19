package org.brapi.test.BrAPITestServer.controller.geno;

import io.swagger.model.Metadata;
import io.swagger.model.geno.CallSet;
import io.swagger.model.geno.CallSetResponse;
import io.swagger.model.geno.CallSetsListResponse;
import io.swagger.model.geno.CallSetsListResponseResult;
import io.swagger.model.geno.CallSetsSearchRequest;
import io.swagger.model.geno.CallsListResponse;
import io.swagger.model.geno.CallsListResponseResult;

import io.swagger.api.geno.CallSetsApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.geno.CallService;
import org.brapi.test.BrAPITestServer.service.geno.CallSetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
@Controller
public class CallSetsApiController extends BrAPIController implements CallSetsApi {

	private static final Logger log = LoggerFactory.getLogger(CallSetsApiController.class);

	private final CallSetService callSetService;
	private final CallService callService;

	private final HttpServletRequest request;

	@Autowired
	public CallSetsApiController(CallSetService callSetService, CallService callService, HttpServletRequest request) {
		this.callSetService = callSetService;
		this.callService = callService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<CallsListResponse> callsetsCallSetDbIdCallsGet(
			@PathVariable("callSetDbId") String callSetDbId,
			@Valid @RequestParam(value = "expandHomozygotes", required = false) Boolean expandHomozygotes,
			@Valid @RequestParam(value = "unknownString", required = false) String unknownString,
			@Valid @RequestParam(value = "sepPhased", required = false) String sepPhased,
			@Valid @RequestParam(value = "sepUnphased", required = false) String sepUnphased,
			@Valid @RequestParam(value = "pageToken", required = false) String pageToken,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(pageToken, pageSize);
		CallsListResponseResult data = callService.findCalls(callSetDbId, null, null, expandHomozygotes, unknownString,
				sepPhased, sepUnphased, metadata);
		return responseOK(new CallsListResponse(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<CallSetResponse> callsetsCallSetDbIdGet(@PathVariable("callSetDbId") String callSetDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		CallSet data = callSetService.getCallSet(callSetDbId);
		return responseOK(new CallSetResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<CallSetsListResponse> callsetsGet(
			@Valid @RequestParam(value = "callSetDbId", required = false) String callSetDbId,
			@Valid @RequestParam(value = "callSetName", required = false) String callSetName,
			@Valid @RequestParam(value = "variantSetDbId", required = false) String variantSetDbId,
			@Valid @RequestParam(value = "sampleDbId", required = false) String sampleDbId,
			@Valid @RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<CallSet> data = callSetService.findCallSets(callSetDbId, callSetName, variantSetDbId, sampleDbId,
				germplasmDbId, metadata);
		return responseOK(new CallSetsListResponse(), new CallSetsListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<CallSetsListResponse> searchCallsetsPost(@Valid @RequestBody CallSetsSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body);
		List<CallSet> data = callSetService.findCallSets(body, metadata);
		return responseOK(new CallSetsListResponse(), new CallSetsListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<CallSetsListResponse> searchCallsetsSearchResultsDbIdGet(
			@PathVariable("searchResultsDbId") String searchResultsDbId,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		return new ResponseEntity<CallSetsListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

}
