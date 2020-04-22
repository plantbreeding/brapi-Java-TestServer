package org.brapi.test.BrAPITestServer.controller.geno;

import io.swagger.model.Metadata;
import io.swagger.model.geno.Call;
import io.swagger.model.geno.CallsListResponse;
import io.swagger.model.geno.CallsListResponseResult;
import io.swagger.model.geno.CallsSearchRequest;

import io.swagger.api.geno.CallsApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.geno.CallService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
@Controller
public class CallsApiController extends BrAPIController implements CallsApi {

	private static final Logger log = LoggerFactory.getLogger(CallsApiController.class);

	private final CallService callService;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public CallsApiController(CallService callService, HttpServletRequest request) {
		this.callService = callService;
		this.request = request;
	}

	public ResponseEntity<CallsListResponse> callsGet(
			@Valid @RequestParam(value = "callSetDbId", required = false) String callSetDbId,
			@Valid @RequestParam(value = "variantDbId", required = false) String variantDbId,
			@Valid @RequestParam(value = "variantSetDbId", required = false) String variantSetDbId,
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
		CallsListResponseResult data = callService.findCalls(callSetDbId, variantDbId, variantSetDbId, expandHomozygotes,
				unknownString, sepPhased, sepUnphased, metadata);
		return responseOK(new CallsListResponse(), data, metadata);
	}

	public ResponseEntity<CallsListResponse> searchCallsPost(@Valid @RequestBody CallsSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body.getPageToken(), body.getPageSize());
		CallsListResponseResult data = callService.findCalls(body, metadata);
		return responseOK(new CallsListResponse(), data, metadata);
	}

	public ResponseEntity<CallsListResponse> searchCallsSearchResultsDbIdGet(
			@PathVariable("searchResultsDbId") String searchResultsDbId,
			@Valid @RequestParam(value = "pageToken", required = false) String pageToken,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		return new ResponseEntity<CallsListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

}
