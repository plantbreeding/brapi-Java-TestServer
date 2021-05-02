package org.brapi.test.BrAPITestServer.controller.geno;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.Metadata;
import io.swagger.model.geno.Sample;
import io.swagger.model.geno.SampleListResponse;
import io.swagger.model.geno.SampleListResponseResult;
import io.swagger.model.geno.SampleNewRequest;
import io.swagger.model.geno.SampleSearchRequest;
import io.swagger.model.geno.SampleSingleResponse;
import io.swagger.model.germ.Germplasm;
import io.swagger.model.germ.GermplasmListResponse;
import io.swagger.model.germ.GermplasmListResponseResult;
import io.swagger.model.germ.GermplasmSearchRequest;
import io.swagger.api.geno.SamplesApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity.SearchRequestTypes;
import org.brapi.test.BrAPITestServer.service.SearchService;
import org.brapi.test.BrAPITestServer.service.geno.SampleService;
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
public class SamplesApiController extends BrAPIController implements SamplesApi {

	private static final Logger log = LoggerFactory.getLogger(SamplesApiController.class);

	private final SampleService sampleService;
	private final SearchService searchService;
	private final HttpServletRequest request;

	@Autowired
	public SamplesApiController(SampleService sampleService, SearchService searchService, HttpServletRequest request) {
		this.sampleService = sampleService;
		this.searchService = searchService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<SampleListResponse> samplesGet(
			@Valid @RequestParam(value = "sampleDbId", required = false) String sampleDbId,
			@Valid @RequestParam(value = "observationUnitDbId", required = false) String observationUnitDbId,
			@Valid @RequestParam(value = "plateDbId", required = false) String plateDbId,
			@Valid @RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,
			@Valid @RequestParam(value = "studyDbId", required = false) String studyDbId,
			@Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<Sample> data = sampleService.findSamples(sampleDbId, observationUnitDbId, plateDbId, germplasmDbId,
				studyDbId, externalReferenceID, externalReferenceSource, metadata);
		return responseOK(new SampleListResponse(), new SampleListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<SampleListResponse> samplesPost(@Valid @RequestBody List<SampleNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		List<Sample> data = sampleService.saveSamples(body);
		return responseOK(new SampleListResponse(), new SampleListResponseResult(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<SampleSingleResponse> samplesSampleDbIdGet(@PathVariable("sampleDbId") String sampleDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Sample data = sampleService.getSample(sampleDbId);
		return responseOK(new SampleSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<SampleSingleResponse> samplesSampleDbIdPut(@PathVariable("sampleDbId") String sampleDbId,
			@Valid @RequestBody SampleNewRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Sample data = sampleService.updateSample(sampleDbId, body);
		return responseOK(new SampleSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchSamplesPost(@Valid @RequestBody SampleSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body);

		String searchReqDbId = searchService.saveSearchRequest(body, SearchRequestTypes.GERMPLASM);
		if (searchReqDbId != null) {
			return responseAccepted(searchReqDbId);
		} else {
			List<Sample> data = sampleService.findSamples(body, metadata);
			return responseOK(new SampleListResponse(), new SampleListResponseResult(), data, metadata);
		}
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchSamplesSearchResultsDbIdGet(
			@PathVariable("searchResultsDbId") String searchResultsDbId,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		SearchRequestEntity request = searchService.findById(searchResultsDbId);
		if (request != null) {
			SampleSearchRequest body = request.getParameters(SampleSearchRequest.class);
			List<Sample> data = sampleService.findSamples(body, metadata);
			return responseOK(new SampleListResponse(), new SampleListResponseResult(), data, metadata);
		}else {
			return responseAccepted(searchResultsDbId);
		}
	}

}
