package org.brapi.test.BrAPITestServer.controller.geno;

import io.swagger.model.BrAPIResponse;
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
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity.SearchRequestTypes;
import org.brapi.test.BrAPITestServer.service.SearchService;
import org.brapi.test.BrAPITestServer.service.geno.CallService;
import org.brapi.test.BrAPITestServer.service.geno.CallSetService;
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
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
@Controller
public class CallSetsApiController extends BrAPIController implements CallSetsApi {

	private static final Logger log = LoggerFactory.getLogger(CallSetsApiController.class);

	private final CallSetService callSetService;
	private final CallService callService;
	private final SearchService searchService;
	private final HttpServletRequest request;

	@Autowired
	public CallSetsApiController(CallSetService callSetService, CallService callService, SearchService searchService,
			HttpServletRequest request) {
		this.callSetService = callSetService;
		this.callService = callService;
		this.searchService = searchService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<CallsListResponse> callsetsCallSetDbIdCallsGet(
			@PathVariable("callSetDbId") String callSetDbId,
			@RequestParam(value = "expandHomozygotes", required = false) Boolean expandHomozygotes,
			@RequestParam(value = "unknownString", required = false) String unknownString,
			@RequestParam(value = "sepPhased", required = false) String sepPhased,
			@RequestParam(value = "sepUnphased", required = false) String sepUnphased,
			@RequestParam(value = "pageToken", required = false) String pageToken,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
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
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		CallSet data = callSetService.getCallSet(callSetDbId);
		return responseOK(new CallSetResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<CallSetsListResponse> callsetsGet(
			@RequestParam(value = "callSetDbId", required = false) String callSetDbId,
			@RequestParam(value = "callSetName", required = false) String callSetName,
			@RequestParam(value = "variantSetDbId", required = false) String variantSetDbId,
			@RequestParam(value = "sampleDbId", required = false) String sampleDbId,
			@RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,
			@RequestParam(value = "externalReferenceId", required = false) String externalReferenceId,
			@RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<CallSet> data = callSetService.findCallSets(callSetDbId, callSetName, variantSetDbId, sampleDbId,
				germplasmDbId, externalReferenceId, externalReferenceSource, metadata);
		return responseOK(new CallSetsListResponse(), new CallSetsListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchCallsetsPost(@RequestBody CallSetsSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body);

		String searchReqDbId = searchService.saveSearchRequest(body, SearchRequestTypes.CALLSETS);
		if (searchReqDbId != null) {
			return responseAccepted(searchReqDbId);
		} else {
			List<CallSet> data = callSetService.findCallSets(body, metadata);
			return responseOK(new CallSetsListResponse(), new CallSetsListResponseResult(), data, metadata);
		}
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchCallsetsSearchResultsDbIdGet(
			@PathVariable("searchResultsDbId") String searchResultsDbId,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		SearchRequestEntity request = searchService.findById(searchResultsDbId);
		if (request != null) {
			CallSetsSearchRequest body = request.getParameters(CallSetsSearchRequest.class);
			List<CallSet> data = callSetService.findCallSets(body, metadata);
			return responseOK(new CallSetsListResponse(), new CallSetsListResponseResult(), data, metadata);
		} else {
			return responseAccepted(searchResultsDbId);
		}
	}

}
