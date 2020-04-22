package org.brapi.test.BrAPITestServer.controller.pheno;

import io.swagger.model.Metadata;
import io.swagger.model.WSMIMEDataTypes;
import io.swagger.model.pheno.Observation;
import io.swagger.model.pheno.ObservationListResponse;
import io.swagger.model.pheno.ObservationListResponseResult;
import io.swagger.model.pheno.ObservationNewRequest;
import io.swagger.model.pheno.ObservationSearchRequest;
import io.swagger.model.pheno.ObservationSingleResponse;
import io.swagger.model.pheno.ObservationTable;
import io.swagger.model.pheno.ObservationTableResponse;
import java.time.OffsetDateTime;

import io.swagger.api.pheno.ObservationsApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.pheno.ObservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
@Controller
public class ObservationsApiController extends BrAPIController implements ObservationsApi {

	private static final Logger log = LoggerFactory.getLogger(ObservationsApiController.class);

	private final ObservationService observationService;

	private final HttpServletRequest request;

	@Autowired
	public ObservationsApiController(ObservationService observationService, HttpServletRequest request) {
		this.observationService = observationService;
		this.request = request;
	}

	public ResponseEntity<ObservationListResponse> observationsGet(
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
			@Valid @RequestParam(value = "observationTimeStampRangeStart", required = false) OffsetDateTime observationTimeStampRangeStart,
			@Valid @RequestParam(value = "observationTimeStampRangeEnd", required = false) OffsetDateTime observationTimeStampRangeEnd,
			@Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<Observation> data = observationService.findObservations(observationUnitDbId, germplasmDbId,
				observationVariableDbId, studyDbId, locationDbId, trialDbId, programDbId, seasonDbId,
				observationUnitLevelName, observationUnitLevelOrder, observationUnitLevelCode,
				observationTimeStampRangeStart, observationTimeStampRangeEnd, externalReferenceID,
				externalReferenceSource, metadata);
		return responseOK(new ObservationListResponse(), new ObservationListResponseResult(), data, metadata);
	}

	public ResponseEntity<ObservationSingleResponse> observationsObservationDbIdGet(
			@PathVariable("observationDbId") String observationDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Observation data = observationService.getObservation(observationDbId);
		return responseOK(new ObservationSingleResponse(), data);
	}

	public ResponseEntity<ObservationSingleResponse> observationsObservationDbIdPut(
			@PathVariable("observationDbId") String observationDbId, @Valid @RequestBody ObservationNewRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Observation data = observationService.updateObservation(observationDbId, body);
		return responseOK(new ObservationSingleResponse(), data);
	}

	public ResponseEntity<ObservationListResponse> observationsPost(
			@Valid @RequestBody List<ObservationNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		List<Observation> data = observationService.saveObservations(body);
		return responseOK(new ObservationListResponse(), new ObservationListResponseResult(), data);
	}

	public ResponseEntity<ObservationListResponse> observationsPut(
			@Valid @RequestBody Map<String, ObservationNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		List<Observation> data = observationService.updateObservations(body);
		return responseOK(new ObservationListResponse(), new ObservationListResponseResult(), data);
	}

	public ResponseEntity<ObservationTableResponse> observationsTableGet(
			@RequestHeader(value = "Accept", required = true) WSMIMEDataTypes accept,
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
			@Valid @RequestParam(value = "observationTimeStampRangeStart", required = false) OffsetDateTime observationTimeStampRangeStart,
			@Valid @RequestParam(value = "observationTimeStampRangeEnd", required = false) OffsetDateTime observationTimeStampRangeEnd,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		ObservationTable data = observationService.findObservationsTable(accept, observationUnitDbId, germplasmDbId,
				observationVariableDbId, studyDbId, locationDbId, trialDbId, programDbId, seasonDbId,
				observationTimeStampRangeStart, observationTimeStampRangeEnd);
		return responseOK(new ObservationTableResponse(), data);
	}

	public ResponseEntity<ObservationListResponse> searchObservationsPost(
			@Valid @RequestBody ObservationSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body);
		List<Observation> data = observationService.findObservations(body, metadata);
		return responseOK(new ObservationListResponse(), new ObservationListResponseResult(), data, metadata);
	}

	public ResponseEntity<ObservationListResponse> searchObservationsSearchResultsDbIdGet(
			@RequestHeader(value = "Accept", required = true) WSMIMEDataTypes accept,
			@PathVariable("searchResultsDbId") String searchResultsDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		return new ResponseEntity<ObservationListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

}
