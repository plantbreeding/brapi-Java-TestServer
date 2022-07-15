package org.brapi.test.BrAPITestServer.controller.geno;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.Metadata;
import io.swagger.model.geno.Call;
import io.swagger.model.geno.CallsListResponse;
import io.swagger.model.geno.CallsListResponseResult;
import io.swagger.model.geno.CallsSearchRequest;
import io.swagger.api.geno.CallsApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity.SearchRequestTypes;
import org.brapi.test.BrAPITestServer.service.SearchService;
import org.brapi.test.BrAPITestServer.service.geno.CallService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
@Controller
public class CallsApiController extends BrAPIController implements CallsApi {

	private static final Logger log = LoggerFactory.getLogger(CallsApiController.class);

	private final CallService callService;
	private final SearchService searchService;
	private final HttpServletRequest request;

	@Autowired
	public CallsApiController(CallService callService, SearchService searchService, HttpServletRequest request) {
		this.callService = callService;
		this.searchService = searchService;
		this.request = request;
	}

	@CrossOrigin
	@Override
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
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(pageToken, pageSize);
		CallsListResponseResult data = callService.findCalls(callSetDbId, variantDbId, variantSetDbId,
				expandHomozygotes, unknownString, sepPhased, sepUnphased, metadata);
		return responseOK(new CallsListResponse(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchCallsPost(@Valid @RequestBody CallsSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body.getPageToken(), body.getPageSize());

		String searchReqDbId = searchService.saveSearchRequest(body, SearchRequestTypes.CALLS);
		if (searchReqDbId != null) {
			return responseAccepted(searchReqDbId);
		} else {
			CallsListResponseResult data = callService.findCalls(body, metadata);
			return responseOK(new CallsListResponse(), data, metadata);
		}
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchCallsSearchResultsDbIdGet(
			@PathVariable("searchResultsDbId") String searchResultsDbId,
			@Valid @RequestParam(value = "pageToken", required = false) String pageToken,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(pageToken, pageSize);
		SearchRequestEntity request = searchService.findById(searchResultsDbId);
		if (request != null) {
			CallsSearchRequest body = request.getParameters(CallsSearchRequest.class);
			CallsListResponseResult data = callService.findCalls(body, metadata);
			return responseOK(new CallsListResponse(), data, metadata);
		} else {
			return responseAccepted(searchResultsDbId);
		}
	}

	@Override
	public ResponseEntity<CallsListResponse> callsPut(List<Call> body, String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateEmptyMetadata();
		CallsListResponseResult data = callService.updateCalls(body);
		return responseOK(new CallsListResponse(), data, metadata);
	}

}
