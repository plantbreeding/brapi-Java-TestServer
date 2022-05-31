package org.brapi.test.BrAPITestServer.controller.core;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.Metadata;
import io.swagger.model.core.Trial;
import io.swagger.model.core.TrialListResponse;
import io.swagger.model.core.TrialListResponseResult;
import io.swagger.model.core.TrialNewRequest;
import io.swagger.model.core.TrialSearchRequest;
import io.swagger.model.core.TrialSingleResponse;
import io.swagger.model.germ.Germplasm;
import io.swagger.model.germ.GermplasmListResponse;
import io.swagger.model.germ.GermplasmListResponseResult;
import io.swagger.model.germ.GermplasmSearchRequest;
import io.swagger.api.core.TrialsApi;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity.SearchRequestTypes;
import org.brapi.test.BrAPITestServer.service.DateUtility;
import org.brapi.test.BrAPITestServer.service.SearchService;
import org.brapi.test.BrAPITestServer.service.core.TrialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
@Controller
public class TrialsApiController extends BrAPIController implements TrialsApi {

	private static final Logger log = LoggerFactory.getLogger(TrialsApiController.class);

	private final HttpServletRequest request;
	private final TrialService trialService;
	private final SearchService searchService;

	@org.springframework.beans.factory.annotation.Autowired
	public TrialsApiController(TrialService trialService, SearchService searchService, HttpServletRequest request) {
		this.trialService = trialService;
		this.searchService = searchService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<TrialListResponse> trialsGet(
			@Valid @RequestParam(value = "active", required = false) Boolean active,
			@Valid @RequestParam(value = "commonCropName", required = false) String commonCropName,
			@Valid @RequestParam(value = "contactDbId", required = false) String contactDbId,
			@Valid @RequestParam(value = "programDbId", required = false) String programDbId,
			@Valid @RequestParam(value = "locationDbId", required = false) String locationDbId,
			@Valid @RequestParam(value = "searchDateRangeStart", required = false) String searchDateRangeStart,
			@Valid @RequestParam(value = "searchDateRangeEnd", required = false) String searchDateRangeEnd,
			@Valid @RequestParam(value = "studyDbId", required = false) String studyDbId,
			@Valid @RequestParam(value = "trialDbId", required = false) String trialDbId,
			@Valid @RequestParam(value = "trialName", required = false) String trialName,
			@Valid @RequestParam(value = "trialPUI", required = false) String trialPUI,
			@Valid @RequestParam(value = "sortBy", required = false) String sortBy,
			@Valid @RequestParam(value = "sortOrder", required = false) String sortOrder,
			@Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<Trial> data = trialService.findTrials(commonCropName, contactDbId, programDbId, locationDbId,
				DateUtility.toLocalDate(searchDateRangeStart), DateUtility.toLocalDate(searchDateRangeEnd), studyDbId, trialDbId, trialName, trialPUI,
				externalReferenceID, externalReferenceSource, active, sortBy, sortOrder, metadata);
		return responseOK(new TrialListResponse(), new TrialListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<TrialListResponse> trialsPost(@Valid @RequestBody List<TrialNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		List<Trial> data = trialService.saveTrials(body);
		return responseOK(new TrialListResponse(), new TrialListResponseResult(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<TrialSingleResponse> trialsTrialDbIdGet(@PathVariable("trialDbId") String trialDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Trial data = trialService.getTrial(trialDbId);
		return responseOK(new TrialSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<TrialSingleResponse> trialsTrialDbIdPut(@PathVariable("trialDbId") String trialDbId,
			@Valid @RequestBody TrialNewRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Trial data = trialService.updateTrial(trialDbId, body);
		return responseOK(new TrialSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchTrialsPost(@Valid @RequestBody TrialSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body);

		String searchReqDbId = searchService.saveSearchRequest(body, SearchRequestTypes.TRIALS);
		if (searchReqDbId != null) {
			return responseAccepted(searchReqDbId);
		} else {
			List<Trial> data = trialService.findTrials(body, metadata);
			return responseOK(new TrialListResponse(), new TrialListResponseResult(), data, metadata);
		}
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchTrialsSearchResultsDbIdGet(
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
			TrialSearchRequest body = request.getParameters(TrialSearchRequest.class);
			List<Trial> data = trialService.findTrials(body, metadata);
			return responseOK(new TrialListResponse(), new TrialListResponseResult(), data, metadata);
		}else {
			return responseAccepted(searchResultsDbId);
		}
	}
}
