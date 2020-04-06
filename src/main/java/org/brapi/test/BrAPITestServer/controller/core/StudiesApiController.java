package org.brapi.test.BrAPITestServer.controller.core;

import io.swagger.model.common.Metadata;
import io.swagger.model.core.Study;
import io.swagger.model.core.StudyListResponse;
import io.swagger.model.core.StudyListResponseResult;
import io.swagger.model.core.StudyNewRequest;
import io.swagger.model.core.StudySearchRequest;
import io.swagger.model.core.StudySingleResponse;
import io.swagger.model.core.StudyTypesResponse;
import io.swagger.model.core.StudyTypesResponseResult;
import io.swagger.annotations.*;
import io.swagger.api.core.StudiesApi;
import io.swagger.api.core.StudytypesApi;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.StudyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
@Controller
public class StudiesApiController extends BrAPIController implements StudiesApi, StudytypesApi {

	private static final Logger log = LoggerFactory.getLogger(StudiesApiController.class);

	private final StudyService studyService;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public StudiesApiController(StudyService studyService, HttpServletRequest request) {
		this.studyService = studyService;
		this.request = request;
	}

	public ResponseEntity<StudyListResponse> studiesGet(
			@Valid @RequestParam(value = "commonCropName", required = false) String commonCropName,
			@Valid @RequestParam(value = "studyType", required = false) String studyType,
			@Valid @RequestParam(value = "programDbId", required = false) String programDbId,
			@Valid @RequestParam(value = "locationDbId", required = false) String locationDbId,
			@Valid @RequestParam(value = "seasonDbId", required = false) String seasonDbId,
			@Valid @RequestParam(value = "trialDbId", required = false) String trialDbId,
			@Valid @RequestParam(value = "studyDbId", required = false) String studyDbId,
			@Valid @RequestParam(value = "studyName", required = false) String studyName,
			@Valid @RequestParam(value = "studyCode", required = false) String studyCode,
			@Valid @RequestParam(value = "studyPUI", required = false) String studyPUI,
			@Valid @RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,
			@Valid @RequestParam(value = "observationVariableDbId", required = false) String observationVariableDbId,
			@Valid @RequestParam(value = "active", required = false) Boolean active,
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
		List<Study> data = studyService.findStudies(commonCropName, studyType, programDbId, locationDbId, seasonDbId,
				trialDbId, studyDbId, studyName, studyCode, studyPUI, germplasmDbId, observationVariableDbId,
				externalReferenceID, externalReferenceSource, active, sortBy, sortOrder, metadata);
		return responseOK(new StudyListResponse(), new StudyListResponseResult(), data, metadata);
	}

	public ResponseEntity<StudyListResponse> studiesPost(@Valid @RequestBody List<StudyNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		List<Study> data = studyService.saveStudies(body);
		return responseOK(new StudyListResponse(), new StudyListResponseResult(), data);
	}

	public ResponseEntity<StudySingleResponse> studiesStudyDbIdGet(@PathVariable("studyDbId") String studyDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Study data = studyService.getStudy(studyDbId);
		return responseOK(new StudySingleResponse(), data);
	}

	public ResponseEntity<StudySingleResponse> studiesStudyDbIdPut(@PathVariable("studyDbId") String studyDbId,
			@Valid @RequestBody StudyNewRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Study data = studyService.updateStudy(studyDbId, body);
		return responseOK(new StudySingleResponse(), data);
	}

	public ResponseEntity<StudyListResponse> searchStudiesPost(@Valid @RequestBody StudySearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body);
		List<Study> data = studyService.findStudies(body, metadata);
		return responseOK(new StudyListResponse(), new StudyListResponseResult(), data, metadata);
	}

	public ResponseEntity<StudyListResponse> searchStudiesSearchResultsDbIdGet(
			@PathVariable("searchResultsDbId") String searchResultsDbId,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		return new ResponseEntity<StudyListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<StudyTypesResponse> studytypesGet(
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<String> data = studyService.getStudyTypes(metadata);
		return responseOK(new StudyTypesResponse(), new StudyTypesResponseResult(), data, metadata);
	}
}
