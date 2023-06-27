package org.brapi.test.BrAPITestServer.controller.pheno;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.Metadata;
import io.swagger.model.pheno.Observation;
import io.swagger.model.pheno.ObservationDeleteResponse;
import io.swagger.model.pheno.ObservationDeleteResponseResult;
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
	public ObservationsApiController(ObservationService observationService, SearchService searchService,
			HttpServletRequest request) {
		this.observationService = observationService;
		this.searchService = searchService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationListResponse> observationsGet(
			@RequestParam(value = "observationDbId", required = false) String observationDbId,
			@RequestParam(value = "observationUnitDbId", required = false) String observationUnitDbId,
			@RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,
			@RequestParam(value = "observationVariableDbId", required = false) String observationVariableDbId,
			@RequestParam(value = "studyDbId", required = false) String studyDbId,
			@RequestParam(value = "locationDbId", required = false) String locationDbId,
			@RequestParam(value = "trialDbId", required = false) String trialDbId,
			@RequestParam(value = "seasonDbId", required = false) String seasonDbId,
			@RequestParam(value = "observationTimeStampRangeStart", required = false) String observationTimeStampRangeStart,
			@RequestParam(value = "observationTimeStampRangeEnd", required = false) String observationTimeStampRangeEnd,
			@RequestParam(value = "observationUnitLevelName", required = false) String observationUnitLevelName,
			@RequestParam(value = "observationUnitLevelOrder", required = false) String observationUnitLevelOrder,
			@RequestParam(value = "observationUnitLevelCode", required = false) String observationUnitLevelCode,
			@RequestParam(value = "observationUnitLevelRelationshipName", required = false) String observationUnitLevelRelationshipName,
			@RequestParam(value = "observationUnitLevelRelationshipOrder", required = false) String observationUnitLevelRelationshipOrder,
			@RequestParam(value = "observationUnitLevelRelationshipCode", required = false) String observationUnitLevelRelationshipCode,
			@RequestParam(value = "observationUnitLevelRelationshipDbId", required = false) String observationUnitLevelRelationshipDbId,
			@RequestParam(value = "commonCropName", required = false) String commonCropName,
			@RequestParam(value = "programDbId", required = false) String programDbId,
			@RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
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
		List<Observation> data = observationService.findObservations(observationDbId, observationUnitDbId,
				germplasmDbId, observationVariableDbId, studyDbId, locationDbId, trialDbId, programDbId, seasonDbId,
				observationUnitLevelName, observationUnitLevelOrder, observationUnitLevelCode,
				observationTimeStampRangeStart, observationTimeStampRangeEnd, observationUnitLevelRelationshipName,
				observationUnitLevelRelationshipOrder, observationUnitLevelRelationshipCode,
				observationUnitLevelRelationshipDbId, commonCropName, externalReferenceId, externalReferenceID,
				externalReferenceSource, metadata);
		return responseOK(new ObservationListResponse(), new ObservationListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationSingleResponse> observationsObservationDbIdGet(
			@PathVariable("observationDbId") String observationDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Observation data = observationService.getObservation(observationDbId);
		return responseOK(new ObservationSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationSingleResponse> observationsObservationDbIdPut(
			@PathVariable("observationDbId") String observationDbId, @RequestBody ObservationNewRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		Observation data = observationService.updateObservation(observationDbId, body);
		return responseOK(new ObservationSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationListResponse> observationsPost(@RequestBody List<ObservationNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		List<Observation> data = observationService.saveObservations(body);
		return responseOK(new ObservationListResponse(), new ObservationListResponseResult(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationListResponse> observationsPut(@RequestBody Map<String, ObservationNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		List<Observation> data = observationService.updateObservations(body);
		return responseOK(new ObservationListResponse(), new ObservationListResponseResult(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity observationsTableGet(@RequestHeader(value = "Accept", required = false) String accept,
			@RequestParam(value = "observationUnitDbId", required = false) String observationUnitDbId,
			@RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,
			@RequestParam(value = "observationVariableDbId", required = false) String observationVariableDbId,
			@RequestParam(value = "studyDbId", required = false) String studyDbId,
			@RequestParam(value = "locationDbId", required = false) String locationDbId,
			@RequestParam(value = "trialDbId", required = false) String trialDbId,
			@RequestParam(value = "programDbId", required = false) String programDbId,
			@RequestParam(value = "seasonDbId", required = false) String seasonDbId,
			@RequestParam(value = "observationLevel", required = false) String observationLevel,
			@RequestParam(value = "searchResultsDbId", required = false) String searchResultsDbId,
			@RequestParam(value = "observationTimeStampRangeStart", required = false) String observationTimeStampRangeStart,
			@RequestParam(value = "observationTimeStampRangeEnd", required = false) String observationTimeStampRangeEnd,
			@RequestParam(value = "observationUnitLevelName", required = false) String observationUnitLevelName,
			@RequestParam(value = "observationUnitLevelOrder", required = false) String observationUnitLevelOrder,
			@RequestParam(value = "observationUnitLevelCode", required = false) String observationUnitLevelCode,
			@RequestParam(value = "observationUnitLevelRelationshipName", required = false) String observationUnitLevelRelationshipName,
			@RequestParam(value = "observationUnitLevelRelationshipOrder", required = false) String observationUnitLevelRelationshipOrder,
			@RequestParam(value = "observationUnitLevelRelationshipCode", required = false) String observationUnitLevelRelationshipCode,
			@RequestParam(value = "observationUnitLevelRelationshipDbId", required = false) String observationUnitLevelRelationshipDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");

		String sep = "";
		if ("text/csv".equals(accept)) {
			sep = ",";
		} else if ("text/tsv".equals(accept)) {
			sep = "\t";
		} else {
			validateAcceptHeader(request);
		}

		ObservationTable data;
		if (searchResultsDbId != null) {
			SearchRequestEntity request = searchService.findById(searchResultsDbId);
			if (request != null) {
				ObservationSearchRequest body = request.getParameters(ObservationSearchRequest.class);
				data = observationService.findObservationsTable(body);
			} else {
				return responseAccepted(searchResultsDbId);
			}
		} else {

			data = observationService.findObservationsTable(observationUnitDbId, germplasmDbId, observationVariableDbId,
					studyDbId, locationDbId, trialDbId, programDbId, seasonDbId, observationLevel,
					observationUnitLevelName, observationUnitLevelOrder, observationUnitLevelCode,
					observationUnitLevelRelationshipName, observationUnitLevelRelationshipOrder,
					observationUnitLevelRelationshipCode, observationUnitLevelRelationshipDbId,
					observationTimeStampRangeStart, observationTimeStampRangeEnd, searchResultsDbId);
		}

		if (sep.isEmpty()) {
			return responseOK(new ObservationTableResponse(), data);
		} else {
			String textTable = observationService.getObservationTableText(data, sep);
			return new ResponseEntity<String>(textTable, HttpStatus.OK);
		}
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchObservationsPost(@RequestBody ObservationSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
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
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pageSize", required = false) Integer pageSize) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		SearchRequestEntity request = searchService.findById(searchResultsDbId);
		if (request != null) {
			ObservationSearchRequest body = request.getParameters(ObservationSearchRequest.class);
			List<Observation> data = observationService.findObservations(body, metadata);
			return responseOK(new ObservationListResponse(), new ObservationListResponseResult(), data, metadata);
		} else {
			return responseAccepted(searchResultsDbId);
		}
	}

	@Override
	public ResponseEntity<ObservationDeleteResponse> deleteObservationsPost(
			@RequestHeader(value = "Authorization", required = false) String authorization,
			@RequestBody ObservationSearchRequest body) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body);

		List<String> data = observationService.deleteObservations(body, metadata);
		return responseOK(new ObservationDeleteResponse(), new ObservationDeleteResponseResult(), data, metadata);
	}

}
