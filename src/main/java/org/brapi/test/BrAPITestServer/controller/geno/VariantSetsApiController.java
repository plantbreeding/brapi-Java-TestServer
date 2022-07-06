package org.brapi.test.BrAPITestServer.controller.geno;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.Metadata;
import io.swagger.model.geno.CallSet;
import io.swagger.model.geno.CallSetsListResponse;
import io.swagger.model.geno.CallSetsListResponseResult;
import io.swagger.model.geno.CallsListResponse;
import io.swagger.model.geno.CallsListResponseResult;
import io.swagger.model.geno.Variant;
import io.swagger.model.geno.VariantSet;
import io.swagger.model.geno.VariantSetResponse;
import io.swagger.model.geno.VariantSetsExtractRequest;
import io.swagger.model.geno.VariantSetsListResponse;
import io.swagger.model.geno.VariantSetsListResponseResult;
import io.swagger.model.geno.VariantSetsSearchRequest;
import io.swagger.model.geno.VariantsListResponse;
import io.swagger.model.geno.VariantsListResponseResult;
import io.swagger.model.germ.Germplasm;
import io.swagger.model.germ.GermplasmListResponse;
import io.swagger.model.germ.GermplasmListResponseResult;
import io.swagger.model.germ.GermplasmSearchRequest;
import io.swagger.annotations.ApiParam;
import io.swagger.api.geno.VariantSetsApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity.SearchRequestTypes;
import org.brapi.test.BrAPITestServer.service.SearchService;
import org.brapi.test.BrAPITestServer.service.geno.CallService;
import org.brapi.test.BrAPITestServer.service.geno.CallSetService;
import org.brapi.test.BrAPITestServer.service.geno.VariantService;
import org.brapi.test.BrAPITestServer.service.geno.VariantSetService;
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
import jakarta.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
@Controller
public class VariantSetsApiController extends BrAPIController implements VariantSetsApi {

	private static final Logger log = LoggerFactory.getLogger(VariantSetsApiController.class);

	private final CallService callService;
	private final CallSetService callSetService;
	private final VariantService variantService;
	private final VariantSetService variantSetService;
	private final SearchService searchService;
	private final HttpServletRequest request;

	@Autowired
	public VariantSetsApiController(CallService callService, CallSetService callSetService,
			VariantService variantService, VariantSetService variantSetService, SearchService searchService,
			HttpServletRequest request) {
		this.callService = callService;
		this.callSetService = callSetService;
		this.variantService = variantService;
		this.variantSetService = variantSetService;
		this.searchService = searchService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<VariantSetResponse> variantsetsExtractPost(@RequestBody VariantSetsExtractRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		VariantSet data = variantSetService.extractVariantSet(body);
		return responseOK(new VariantSetResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<VariantSetsListResponse> variantsetsGet(
			@Valid @RequestParam(value = "variantSetDbId", required = false) String variantSetDbId,
			@Valid @RequestParam(value = "variantDbId", required = false) String variantDbId,
			@Valid @RequestParam(value = "callSetDbId", required = false) String callSetDbId,
			@Valid @RequestParam(value = "studyDbId", required = false) String studyDbId,
			@Valid @RequestParam(value = "studyName", required = false) String studyName,
			@Valid @RequestParam(value = "referenceSetDbId", required = false) String referenceSetDbId,
			@Valid @RequestParam(value = "commonCropName", required = false) String commonCropName,
			@Valid @RequestParam(value = "programDbId", required = false) String programDbId,
			@Valid @RequestParam(value = "externalReferenceId", required = false) String externalReferenceId,
			@Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<VariantSet> data = variantSetService.findVariantSets(variantSetDbId, variantDbId, callSetDbId, studyDbId,
				studyName, referenceSetDbId, commonCropName, programDbId, externalReferenceId, externalReferenceSource,
				metadata);
		return responseOK(new VariantSetsListResponse(), new VariantSetsListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<CallsListResponse> variantsetsVariantSetDbIdCallsGet(
			@PathVariable("variantSetDbId") String variantSetDbId,
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
		CallsListResponseResult data = callService.findCalls(null, null, variantSetDbId, expandHomozygotes,
				unknownString, sepPhased, sepUnphased, metadata);
		return responseOK(new CallsListResponse(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<CallSetsListResponse> variantsetsVariantSetDbIdCallsetsGet(
			@PathVariable("variantSetDbId") String variantSetDbId,
			@Valid @RequestParam(value = "callSetDbId", required = false) String callSetDbId,
			@Valid @RequestParam(value = "callSetName", required = false) String callSetName,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<CallSet> data = callSetService.findCallSets(callSetDbId, callSetName, variantSetDbId, null, null, null,
				null, metadata);
		return responseOK(new CallSetsListResponse(), new CallSetsListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<VariantSetResponse> variantsetsVariantSetDbIdGet(
			@PathVariable("variantSetDbId") String variantSetDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		VariantSet data = variantSetService.getVariantSet(variantSetDbId);
		return responseOK(new VariantSetResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<VariantsListResponse> variantsetsVariantSetDbIdVariantsGet(
			@PathVariable("variantSetDbId") String variantSetDbId,
			@Valid @RequestParam(value = "variantDbId", required = false) String variantDbId,
			@Valid @RequestParam(value = "pageToken", required = false) String pageToken,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(pageToken, pageSize);
		List<Variant> data = variantService.findVariants(variantDbId, variantSetDbId, null, null, null, null, metadata);
		return responseOK(new VariantsListResponse(), new VariantsListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchVariantsetsPost(
			@Valid @RequestBody VariantSetsSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body);

		String searchReqDbId = searchService.saveSearchRequest(body, SearchRequestTypes.VARIANTSETS);
		if (searchReqDbId != null) {
			return responseAccepted(searchReqDbId);
		} else {
			List<VariantSet> data = variantSetService.findVariantSets(body, metadata);
			return responseOK(new VariantSetsListResponse(), new VariantSetsListResponseResult(), data, metadata);
		}
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchVariantsetsSearchResultsDbIdGet(
			@PathVariable("searchResultsDbId") String searchResultsDbId,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		SearchRequestEntity request = searchService.findById(searchResultsDbId);
		if (request != null) {
			VariantSetsSearchRequest body = request.getParameters(VariantSetsSearchRequest.class);
			List<VariantSet> data = variantSetService.findVariantSets(body, metadata);
			return responseOK(new VariantSetsListResponse(), new VariantSetsListResponseResult(), data, metadata);
		} else {
			return responseAccepted(searchResultsDbId);
		}
	}

}
