package org.brapi.test.BrAPITestServer.controller.pheno;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.Metadata;
import io.swagger.model.WSMIMEDataTypes;
import io.swagger.model.germ.Germplasm;
import io.swagger.model.germ.GermplasmListResponse;
import io.swagger.model.germ.GermplasmListResponseResult;
import io.swagger.model.germ.GermplasmSearchRequest;
import io.swagger.model.pheno.Observation;
import io.swagger.model.pheno.ObservationListResponse;
import io.swagger.model.pheno.ObservationListResponseResult;
import io.swagger.model.pheno.ObservationNewRequest;
import io.swagger.model.pheno.ObservationSearchRequest;
import io.swagger.model.pheno.ObservationSingleResponse;
import io.swagger.model.pheno.ObservationTable;
import io.swagger.model.pheno.ObservationTableResponse;
import io.swagger.api.pheno.ObservationsApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity.SearchRequestTypes;
import org.brapi.test.BrAPITestServer.service.SearchService;
import org.brapi.test.BrAPITestServer.service.pheno.ObservationService;
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
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
@Controller
public class ObservationsApiController extends BrAPIController implements ObservationsApi {

	private static final Logger log = LoggerFactory.getLogger(ObservationsApiController.class);

	private final ObservationService observationService;
	private final SearchService searchService;
	private final HttpServletRequest request;

	@Autowired
	public ObservationsApiController(ObservationService observationService, SearchService searchService, HttpServletRequest request) {
		this.observationService = observationService;
		this.searchService = searchService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationListResponse> observationsGet(
			@Valid @RequestParam(value = "observationDbId", required = false) String observationDbId,
			@Valid @RequestParam(value = "observationUnitDbId", required = false) String observationUnitDbId,
			@Valid @RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,
			@Valid @RequestParam(value = "observationVariableDbId", required = false) String observationVariableDbId,
			@Valid @RequestParam(value = "studyDbId", required = false) String studyDbId,
			@Valid @RequestParam(value = "locationDbId", required = false) String locationDbId,
			@Valid @RequestParam(value = "trialDbId", required = false) String trialDbId,
			@Valid @RequestParam(value = "programDbId", required = false) String programDbId,
			@Valid @RequestParam(value = "seasonDbId", required = false) String seasonDbId,
			@Valid @RequestParam(value = "observationUnitLevelName", required = false) String observationUnitLevelName,
			@Valid @RequestParam(value = "observationUnitLevelOrder", required = false) String observationUnitLevelOrder,
			@Valid @RequestParam(value = "observationUnitLevelCode", required = false) String observationUnitLevelCode,
			@Valid @RequestParam(value = "observationTimeStampRangeStart", required = false) String observationTimeStampRangeStart,
			@Valid @RequestParam(value = "observationTimeStampRangeEnd", required = false) String observationTimeStampRangeEnd,
			@Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceId,
			@Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<Observation> data = observationService.findObservations(observationDbId, observationUnitDbId, germplasmDbId,
				observationVariableDbId, studyDbId, locationDbId, trialDbId, programDbId, seasonDbId,
				observationUnitLevelName, observationUnitLevelOrder, observationUnitLevelCode,
				observationTimeStampRangeStart, observationTimeStampRangeEnd, externalReferenceId, externalReferenceID,
				externalReferenceSource, metadata);
		return responseOK(new ObservationListResponse(), new ObservationListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationSingleResponse> observationsObservationDbIdGet(
			@PathVariable("observationDbId") String observationDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Observation data = observationService.getObservation(observationDbId);
		return responseOK(new ObservationSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationSingleResponse> observationsObservationDbIdPut(
			@PathVariable("observationDbId") String observationDbId, @Valid @RequestBody ObservationNewRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Observation data = observationService.updateObservation(observationDbId, body);
		return responseOK(new ObservationSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationListResponse> observationsPost(
			@Valid @RequestBody List<ObservationNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		List<Observation> data = observationService.saveObservations(body);
		return responseOK(new ObservationListResponse(), new ObservationListResponseResult(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationListResponse> observationsPut(
			@Valid @RequestBody Map<String, ObservationNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		List<Observation> data = observationService.updateObservations(body);
		return responseOK(new ObservationListResponse(), new ObservationListResponseResult(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity observationsTableGet(
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
			@Valid @RequestParam(value = "searchResultsDbId", required = false) String searchResultsDbId,
			@Valid @RequestParam(value = "observationTimeStampRangeStart", required = false) String observationTimeStampRangeStart,
			@Valid @RequestParam(value = "observationTimeStampRangeEnd", required = false) String observationTimeStampRangeEnd,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		String sep = "";
		if("text/csv".equals(accept)) {
			sep = ",";
		}else if("text/tsv".equals(accept)) {
			sep = "\t";
		}else {
			validateAcceptHeader(request);
		}
		ObservationTable data = observationService.findObservationsTable(observationUnitDbId, germplasmDbId,
				observationVariableDbId, studyDbId, locationDbId, trialDbId, programDbId, seasonDbId,
				observationTimeStampRangeStart, observationTimeStampRangeEnd);
		if(sep.isEmpty()) {
			return responseOK(new ObservationTableResponse(), data);
		}else {
			String textTable = observationService.getObservationTableText(data, sep);
			return new ResponseEntity<String>(textTable, HttpStatus.OK);
		}
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchObservationsPost(
			@Valid @RequestBody ObservationSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body);

		String searchReqDbId = searchService.saveSearchRequest(body, SearchRequestTypes.OBSERVATIONS);
		if (searchReqDbId != null) {
			return responseAccepted(searchReqDbId);
		} else {
			List<Observation> data = observationService.findObservations(body, metadata);
			return responseOK(new ObservationListResponse(), new ObservationListResponseResult(), data, metadata);
		}
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchObservationsSearchResultsDbIdGet(
			@PathVariable("searchResultsDbId") String searchResultsDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		SearchRequestEntity request = searchService.findById(searchResultsDbId);
		if (request != null) {
			ObservationSearchRequest body = request.getParameters(ObservationSearchRequest.class);
			List<Observation> data = observationService.findObservations(body, metadata);
			return responseOK(new ObservationListResponse(), new ObservationListResponseResult(), data, metadata);
		}else {
			return responseAccepted(searchResultsDbId);
		}
	}

}
