package org.brapi.test.BrAPITestServer.controller.pheno;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.Metadata;
import io.swagger.model.pheno.ObservationVariable;
import io.swagger.model.pheno.ObservationVariableListResponse;
import io.swagger.model.pheno.ObservationVariableListResponseResult;
import io.swagger.model.pheno.ObservationVariableSingleResponse;
import io.swagger.model.pheno.ObservationVariableNewRequest;
import io.swagger.model.pheno.ObservationVariableSearchRequest;
import io.swagger.api.pheno.VariablesApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity.SearchRequestTypes;
import org.brapi.test.BrAPITestServer.service.SearchService;
import org.brapi.test.BrAPITestServer.service.pheno.ObservationVariableService;
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
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
@Controller
public class VariablesApiController extends BrAPIController implements VariablesApi {

	private static final Logger log = LoggerFactory.getLogger(VariablesApiController.class);

	private final ObservationVariableService observationVariableService;
	private final SearchService searchService;
	private final HttpServletRequest request;

	@Autowired
	public VariablesApiController(ObservationVariableService observationVariableService, SearchService searchService,
			HttpServletRequest request) {
		this.observationVariableService = observationVariableService;
		this.searchService = searchService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationVariableListResponse> variablesGet(
			@Valid @RequestParam(value = "observationVariableDbId", required = false) String observationVariableDbId,
			@Valid @RequestParam(value = "observationVariableName", required = false) String observationVariableName,
			@Valid @RequestParam(value = "observationVariablePUI", required = false) String observationVariablePUI,
			@Valid @RequestParam(value = "methodDbId", required = false) String methodDbId,
			@Valid @RequestParam(value = "methodName", required = false) String methodName,
			@Valid @RequestParam(value = "methodPUI", required = false) String methodPUI,
			@Valid @RequestParam(value = "scaleDbId", required = false) String scaleDbId,
			@Valid @RequestParam(value = "scaleName", required = false) String scaleName,
			@Valid @RequestParam(value = "scalePUI", required = false) String scalePUI,
			@Valid @RequestParam(value = "traitDbId", required = false) String traitDbId,
			@Valid @RequestParam(value = "traitName", required = false) String traitName,
			@Valid @RequestParam(value = "traitPUI", required = false) String traitPUI,
			@Valid @RequestParam(value = "traitClass", required = false) String traitClass,
			@Valid @RequestParam(value = "ontologyDbId", required = false) String ontologyDbId,
			@Valid @RequestParam(value = "commonCropName", required = false) String commonCropName,
			@Valid @RequestParam(value = "programDbId", required = false) String programDbId,
			@Valid @RequestParam(value = "trialDbId", required = false) String trialDbId,
			@Valid @RequestParam(value = "studyDbId", required = false) String studyDbId,
			@Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@Valid @RequestParam(value = "externalReferenceId", required = false) String externalReferenceId,
			@Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<ObservationVariable> data = observationVariableService.findObservationVariables(observationVariableDbId,
				observationVariableName, observationVariablePUI, methodDbId, methodName, methodPUI, scaleDbId,
				scaleName, scalePUI, traitDbId, traitName, traitPUI, traitClass, ontologyDbId, commonCropName,
				programDbId, trialDbId, studyDbId, externalReferenceId, externalReferenceID, externalReferenceSource,
				metadata);
		return responseOK(new ObservationVariableListResponse(), new ObservationVariableListResponseResult(), data,
				metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationVariableSingleResponse> variablesObservationVariableDbIdGet(
			@PathVariable("observationVariableDbId") String observationVariableDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		ObservationVariable data = observationVariableService.getObservationVariable(observationVariableDbId);
		return responseOK(new ObservationVariableSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationVariableSingleResponse> variablesObservationVariableDbIdPut(
			@Valid @RequestBody ObservationVariableNewRequest body,
			@PathVariable("observationVariableDbId") String observationVariableDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		ObservationVariable data = observationVariableService.updateObservationVariable(observationVariableDbId, body);
		return responseOK(new ObservationVariableSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationVariableListResponse> variablesPost(
			@Valid @RequestBody List<ObservationVariableNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		List<ObservationVariable> data = observationVariableService.saveObservationVariables(body);
		return responseOK(new ObservationVariableListResponse(), new ObservationVariableListResponseResult(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchVariablesPost(
			@Valid @RequestBody ObservationVariableSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body);

		String searchReqDbId = searchService.saveSearchRequest(body, SearchRequestTypes.VARIABLES);
		if (searchReqDbId != null) {
			return responseAccepted(searchReqDbId);
		} else {
			List<ObservationVariable> data = observationVariableService.findObservationVariables(body, metadata);
			return responseOK(new ObservationVariableListResponse(), new ObservationVariableListResponseResult(), data,
					metadata);
		}
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchVariablesSearchResultsDbIdGet(
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
			ObservationVariableSearchRequest body = request.getParameters(ObservationVariableSearchRequest.class);
			List<ObservationVariable> data = observationVariableService.findObservationVariables(body, metadata);
			return responseOK(new ObservationVariableListResponse(), new ObservationVariableListResponseResult(), data,
					metadata);
		} else {
			return responseAccepted(searchResultsDbId);
		}
	}

}
