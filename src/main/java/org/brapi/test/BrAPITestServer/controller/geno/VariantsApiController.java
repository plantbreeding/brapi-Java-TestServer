package org.brapi.test.BrAPITestServer.controller.geno;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.Metadata;
import io.swagger.model.geno.Variant;
import io.swagger.model.geno.VariantSingleResponse;
import io.swagger.model.geno.VariantsListResponse;
import io.swagger.model.geno.VariantsListResponseResult;
import io.swagger.model.geno.CallsListResponse;
import io.swagger.model.geno.CallsListResponseResult;
import io.swagger.model.geno.VariantsSearchRequest;
import io.swagger.model.germ.Germplasm;
import io.swagger.model.germ.GermplasmListResponse;
import io.swagger.model.germ.GermplasmListResponseResult;
import io.swagger.model.germ.GermplasmSearchRequest;
import io.swagger.api.geno.VariantsApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity.SearchRequestTypes;
import org.brapi.test.BrAPITestServer.service.SearchService;
import org.brapi.test.BrAPITestServer.service.geno.CallService;
import org.brapi.test.BrAPITestServer.service.geno.VariantService;
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

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
@Controller
public class VariantsApiController extends BrAPIController implements VariantsApi {

	private static final Logger log = LoggerFactory.getLogger(VariantsApiController.class);

	private final VariantService variantService;
	private final CallService callService;
	private final SearchService searchService;
	private final HttpServletRequest request;

	@Autowired
	public VariantsApiController(VariantService variantService, CallService callService, SearchService searchService, HttpServletRequest request) {
		this.variantService = variantService;
		this.callService = callService;
		this.searchService = searchService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<VariantsListResponse> variantsGet(
			@Valid @RequestParam(value = "variantDbId", required = false) String variantDbId,
			@Valid @RequestParam(value = "variantSetDbId", required = false) String variantSetDbId,
			@Valid @RequestParam(value = "pageToken", required = false) String pageToken,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(pageToken, pageSize);
		List<Variant> data = variantService.findVariants(variantDbId, variantSetDbId, metadata);
		return responseOK(new VariantsListResponse(), new VariantsListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<CallsListResponse> variantsVariantDbIdCallsGet(
			@PathVariable("variantDbId") String variantDbId,
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
		CallsListResponseResult data = callService.findCalls(null, variantDbId, null, expandHomozygotes, unknownString,
				sepPhased, sepUnphased, metadata);
		return responseOK(new CallsListResponse(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<VariantSingleResponse> variantsVariantDbIdGet(@PathVariable("variantDbId") String variantDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Variant data = variantService.getVariant(variantDbId);
		return responseOK(new VariantSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchVariantsPost(@Valid @RequestBody VariantsSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body.getPageToken(), body.getPageSize());
		
		String searchReqDbId = searchService.saveSearchRequest(body, SearchRequestTypes.VARIANTS);
		if (searchReqDbId != null) {
			return responseAccepted(searchReqDbId);
		} else {
			List<Variant> data = variantService.findVariants(body, metadata);
			return responseOK(new VariantsListResponse(), new VariantsListResponseResult(), data, metadata);
		}
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchVariantsSearchResultsDbIdGet(
			@PathVariable("searchResultsDbId") String searchResultsDbId,
			@Valid @RequestParam(value = "pageToken", required = false) String pageToken,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(pageToken, pageSize);
		SearchRequestEntity request = searchService.findById(searchResultsDbId);
		if (request != null) {
			VariantsSearchRequest body = request.getParameters(VariantsSearchRequest.class);
			List<Variant> data = variantService.findVariants(body, metadata);
			return responseOK(new VariantsListResponse(), new VariantsListResponseResult(), data, metadata);
		}else {
			return responseAccepted(searchResultsDbId);
		}
	}

}
