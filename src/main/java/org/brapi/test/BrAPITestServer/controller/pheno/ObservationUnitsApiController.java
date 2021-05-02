package org.brapi.test.BrAPITestServer.controller.pheno;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.Metadata;
import io.swagger.model.germ.Germplasm;
import io.swagger.model.germ.GermplasmListResponse;
import io.swagger.model.germ.GermplasmListResponseResult;
import io.swagger.model.germ.GermplasmSearchRequest;
import io.swagger.model.pheno.ObservationUnitListResponse;
import io.swagger.model.pheno.ObservationUnitNewRequest;
import io.swagger.model.pheno.ObservationUnitSearchRequest;
import io.swagger.model.pheno.ObservationUnitSingleResponse;
import io.swagger.model.pheno.ObservationUnitTable;
import io.swagger.model.pheno.ObservationUnitTableResponse;
import io.swagger.model.pheno.ObservationLevelListResponse;
import io.swagger.model.pheno.ObservationLevelListResponseResult;
import io.swagger.model.pheno.ObservationUnit;
import io.swagger.model.pheno.ObservationUnitHierarchyLevel;
import io.swagger.model.pheno.ObservationUnitListResponseResult;
import io.swagger.api.pheno.ObservationLevelsApi;
import io.swagger.api.pheno.ObservationUnitsApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity.SearchRequestTypes;
import org.brapi.test.BrAPITestServer.service.SearchService;
import org.brapi.test.BrAPITestServer.service.pheno.ObservationUnitService;
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
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
@Controller
public class ObservationUnitsApiController extends BrAPIController
		implements ObservationUnitsApi, ObservationLevelsApi {

	private static final Logger log = LoggerFactory.getLogger(ObservationUnitsApiController.class);

	private final ObservationUnitService observationUnitService;
	private final SearchService searchService;
	private final HttpServletRequest request;

	@Autowired
	public ObservationUnitsApiController(ObservationUnitService observationUnitService, SearchService searchService, HttpServletRequest request) {
		this.observationUnitService = observationUnitService;
		this.searchService = searchService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationUnitListResponse> observationunitsGet(
			@Valid @RequestParam(value = "observationUnitDbId", required = false) String observationUnitDbId,
			@Valid @RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,
			@Valid @RequestParam(value = "studyDbId", required = false) String studyDbId,
			@Valid @RequestParam(value = "locationDbId", required = false) String locationDbId,
			@Valid @RequestParam(value = "trialDbId", required = false) String trialDbId,
			@Valid @RequestParam(value = "programDbId", required = false) String programDbId,
			@Valid @RequestParam(value = "seasonDbId", required = false) String seasonDbId,
			@Valid @RequestParam(value = "observationUnitLevelName", required = false) String observationUnitLevelName,
			@Valid @RequestParam(value = "observationUnitLevelOrder", required = false) String observationUnitLevelOrder,
			@Valid @RequestParam(value = "observationUnitLevelCode", required = false) String observationUnitLevelCode,
			@Valid @RequestParam(value = "includeObservations", required = false) Boolean includeObservations,
			@Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<ObservationUnit> data = observationUnitService.findObservationUnits(observationUnitDbId, germplasmDbId,
				studyDbId, locationDbId, trialDbId, programDbId, seasonDbId, observationUnitLevelName,
				observationUnitLevelOrder, observationUnitLevelCode, includeObservations, externalReferenceID,
				externalReferenceSource, metadata);
		return responseOK(new ObservationUnitListResponse(), new ObservationUnitListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationUnitSingleResponse> observationunitsObservationUnitDbIdGet(
			@PathVariable("observationUnitDbId") String observationUnitDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		ObservationUnit data = observationUnitService.getObservationUnit(observationUnitDbId);
		return responseOK(new ObservationUnitSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationUnitSingleResponse> observationunitsObservationUnitDbIdPut(
			@PathVariable("observationUnitDbId") String observationUnitDbId,
			@Valid @RequestBody ObservationUnitNewRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		ObservationUnit data = observationUnitService.updateObservationUnit(observationUnitDbId, body);
		return responseOK(new ObservationUnitSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationUnitListResponse> observationunitsPost(
			@Valid @RequestBody List<ObservationUnitNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		List<ObservationUnit> data = observationUnitService.saveObservationUnits(body);
		return responseOK(new ObservationUnitListResponse(), new ObservationUnitListResponseResult(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationUnitListResponse> observationunitsPut(
			@Valid @RequestBody Map<String, ObservationUnitNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		List<ObservationUnit> data = observationUnitService.updateObservationUnits(body);
		return responseOK(new ObservationUnitListResponse(), new ObservationUnitListResponseResult(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity observationunitsTableGet(
			@RequestHeader(value = "Accept", required = false) String accept,
			@Valid @RequestParam(value = "observationUnitDbId", required = false) String observationUnitDbId,
			@Valid @RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,
			@Valid @RequestParam(value = "observationVariableDbId", required = false) String observationVariableDbId,
			@Valid @RequestParam(value = "studyDbId", required = false) String studyDbId,
			@Valid @RequestParam(value = "locationDbId", required = false) String locationDbId,
			@Valid @RequestParam(value = "trialDbId", required = false) String trialDbId,
			@Valid @RequestParam(value = "programDbId", required = false) String programDbId,
			@Valid @RequestParam(value = "seasonDbId", required = false) String seasonDbId,
			@Valid @RequestParam(value = "observationLevel", required = false) String observationLevel,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		String sep = "";
		if("text/csv".equals(accept)) {
			sep = ",";
		}else if("text/tsv".equals(accept)) {
			sep = "\t";
		}else {
			validateAcceptHeader(request);
		}
		ObservationUnitTable data = observationUnitService.findObservationUnitsTable(observationUnitDbId,
				germplasmDbId, observationVariableDbId, studyDbId, locationDbId, trialDbId, programDbId, seasonDbId,
				observationLevel);
		if(sep.isEmpty()) {
			return responseOK(new ObservationUnitTableResponse(), data);
		}else {
			String textTable = observationUnitService.getObservationUnitTableText(data, sep);
			return new ResponseEntity<String>(textTable, HttpStatus.OK);
		}
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationLevelListResponse> observationlevelsGet(
			@Valid @RequestParam(value = "studyDbId", required = false) String studyDbId,
			@Valid @RequestParam(value = "trialDbId", required = false) String trialDbId,
			@Valid @RequestParam(value = "programDbId", required = false) String programDbId,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {
		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<ObservationUnitHierarchyLevel> data = observationUnitService.findObservationLevels(studyDbId, trialDbId,
				programDbId, metadata);
		return responseOK(new ObservationLevelListResponse(), new ObservationLevelListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchObservationunitsPost(
			@Valid @RequestBody ObservationUnitSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body);

		String searchReqDbId = searchService.saveSearchRequest(body, SearchRequestTypes.OBSERVATION_UNITS);
		if (searchReqDbId != null) {
			return responseAccepted(searchReqDbId);
		} else {
			List<ObservationUnit> data = observationUnitService.findObservationUnits(body, metadata);
			return responseOK(new ObservationUnitListResponse(), new ObservationUnitListResponseResult(), data, metadata);
		}
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchObservationunitsSearchResultsDbIdGet(
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
			ObservationUnitSearchRequest body = request.getParameters(ObservationUnitSearchRequest.class);
			List<ObservationUnit> data = observationUnitService.findObservationUnits(body, metadata);
			return responseOK(new ObservationUnitListResponse(), new ObservationUnitListResponseResult(), data, metadata);
		}else {
			return responseAccepted(searchResultsDbId);
		}
	}

}
