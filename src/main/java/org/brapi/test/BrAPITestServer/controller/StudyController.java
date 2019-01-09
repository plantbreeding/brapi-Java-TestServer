package org.brapi.test.BrAPITestServer.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipInputStream;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.api.ObservationLevelsApi_dep;
import io.swagger.api.ObservationlevelsApi;
import io.swagger.api.SeasonsApi;
import io.swagger.api.StudiesApi;
import io.swagger.api.StudiesSearchApi;
import io.swagger.api.StudyTypesApi_dep;
import io.swagger.api.StudytypesApi;
import io.swagger.model.GermplasmSummaryList;
import io.swagger.model.GermplasmSummaryListResponse;
import io.swagger.model.Metadata;
import io.swagger.model.NewObservationDbIds;
import io.swagger.model.NewObservationDbIdsResponse;
import io.swagger.model.NewObservationUnitDbIds;
import io.swagger.model.NewObservationUnitDbIdsResponse;
import io.swagger.model.NewObservationUnitRequest;
import io.swagger.model.NewObservationsRequest;
import io.swagger.model.NewObservationsRequestWrapperDeprecated;
import io.swagger.model.NewObservationsTableRequest;
import io.swagger.model.Observation;
import io.swagger.model.ObservationLevelsResponse;
import io.swagger.model.ObservationLevelsResponseResult;
import io.swagger.model.ObservationUnit;
import io.swagger.model.ObservationUnitPosition;
import io.swagger.model.ObservationUnitPositionsResponse;
import io.swagger.model.ObservationUnitPositionsResponseResult;
import io.swagger.model.ObservationUnitsResponse1;
import io.swagger.model.ObservationUnitsResponse1Result;
import io.swagger.model.ObservationsResponse;
import io.swagger.model.ObservationsResponseResult;
import io.swagger.model.ObservationsTable;
import io.swagger.model.Season;
import io.swagger.model.SeasonsResponse;
import io.swagger.model.SeasonsResponseResult;
import io.swagger.model.Status;
import io.swagger.model.Status.MessageTypeEnum;
import io.swagger.model.StudiesResponse;
import io.swagger.model.StudiesResponseResult;
import io.swagger.model.Study;
import io.swagger.model.StudyLayoutRequest;
import io.swagger.model.StudyObservationVariablesResponse;
import io.swagger.model.StudyObservationVariablesResponseResult;
import io.swagger.model.StudyResponse;
import io.swagger.model.StudySearchRequestDep;
import io.swagger.model.StudySummary;
import io.swagger.model.StudyType;
import io.swagger.model.StudyTypesResponse;
import io.swagger.model.StudyTypesResponseResult;
import io.swagger.model.StudyobservationsTableResponse;

@RestController
public class StudyController extends BrAPIController implements SeasonsApi, ObservationlevelsApi,
		ObservationLevelsApi_dep, StudiesApi, StudiesSearchApi, StudytypesApi, StudyTypesApi_dep {

	private StudyService studyService;

	@Autowired
	public StudyController(StudyService studyService) {
		this.studyService = studyService;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationLevelsResponse> observationlevelsGet(@Valid Integer page, @Valid Integer pageSize,
			String authorization) throws BrAPIServerException {
		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<String> data = studyService.getObservationLevels(metaData);

		ObservationLevelsResponseResult result = new ObservationLevelsResponseResult();
		result.setData(data);
		ObservationLevelsResponse response = new ObservationLevelsResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<ObservationLevelsResponse>(response, HttpStatus.OK);
	}

	@Deprecated
	@CrossOrigin
	@Override
	public ResponseEntity<ObservationLevelsResponse> observationLevelsGet(@Valid Integer pageSize, @Valid Integer page)
			throws BrAPIServerException {

		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<String> data = studyService.getObservationLevels(metaData);

		ObservationLevelsResponseResult result = new ObservationLevelsResponseResult();
		result.setData(data);
		ObservationLevelsResponse response = new ObservationLevelsResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<ObservationLevelsResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<SeasonsResponse> seasonsGet(@Valid String seasonDbId, @Valid String season,
			@Valid String year, @Valid Integer page, @Valid Integer pageSize, String authorization)
			throws BrAPIServerException {
		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<Season> data = studyService.getSeasons(seasonDbId, season, year, metaData);

		SeasonsResponseResult result = new SeasonsResponseResult();
		result.setData(data);
		SeasonsResponse response = new SeasonsResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<SeasonsResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<StudiesResponse> studiesGet(@Valid String commonCropName, @Valid String studyType,
			@Valid String studyTypeDbId, @Valid String programDbId, @Valid String locationDbId,
			@Valid String seasonDbId, @Valid String trialDbId, @Valid String studyDbId,
			@Valid ArrayList<String> germplasmDbIds, @Valid ArrayList<String> observationVariableDbIds, @Valid Boolean active,
			@Valid String sortBy, @Valid String sortOrder, @Valid Integer page, @Valid Integer pageSize,
			String authorization) throws BrAPIServerException {

		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<StudySummary> data = studyService.getStudies(commonCropName, studyType, studyTypeDbId, programDbId, trialDbId, studyDbId, locationDbId,
				seasonDbId, germplasmDbIds, observationVariableDbIds, active, sortBy, sortOrder, metaData);

		StudiesResponseResult result = new StudiesResponseResult();
		result.setData(data);
		StudiesResponse response = new StudiesResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<StudiesResponse>(response, HttpStatus.OK);
	}

	@Deprecated
	@CrossOrigin
	@Override
	public ResponseEntity<StudiesResponse> studiesSearchGet(@Valid String studyType, @Valid String programDbId,
			@Valid String locationDbId, @Valid String seasonDbId, @Valid String trialDbId, @Valid String studyDbId,
			@Valid ArrayList<String> germplasmDbIds, @Valid ArrayList<String> observationVariableDbIds, @Valid Integer page,
			@Valid Integer pageSize, @Valid Boolean active, @Valid String sortBy, @Valid String sortOrder)
			throws BrAPIServerException {
		return studiesGet(null, studyType, studyType, programDbId, locationDbId, seasonDbId, trialDbId, studyDbId, germplasmDbIds, 
				observationVariableDbIds, active, sortBy, sortOrder, page, pageSize, null);
	}

	@Deprecated
	@CrossOrigin
	@Override
	public ResponseEntity<StudiesResponse> studiesSearchPost(@Valid @RequestBody StudySearchRequestDep request)
			throws BrAPIServerException {
		Metadata metaData = generateMetaDataTemplate(request.getPage(), request.getPageSize());
		List<StudySummary> data = studyService.getStudies(request, metaData);

		StudiesResponseResult result = new StudiesResponseResult();
		result.setData(data);
		StudiesResponse response = new StudiesResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<StudiesResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmSummaryListResponse> studiesStudyDbIdGermplasmGet(@PathVariable("studyDbId") String studyDbId,
			@Valid Integer page, @Valid Integer pageSize, String authorization) throws BrAPIServerException {
		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		GermplasmSummaryList result = studyService.getStudyGermplasm(studyDbId, metaData);

		GermplasmSummaryListResponse response = new GermplasmSummaryListResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<GermplasmSummaryListResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<StudyResponse> studiesStudyDbIdGet(@PathVariable("studyDbId") String studyDbId, String authorization)
			throws BrAPIServerException {
		Study result = studyService.getStudy(studyDbId);

		StudyResponse response = new StudyResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<StudyResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Deprecated
	@Override
	public ResponseEntity<ObservationUnitPositionsResponse> studiesStudyDbIdLayoutGet(@PathVariable("studyDbId") String studyDbId,
			@Valid Integer page, @Valid Integer pageSize, String authorization) throws BrAPIServerException {
		return studiesStudyDbIdLayoutsGet(studyDbId, page, pageSize, authorization);
	}

	@Deprecated
	@CrossOrigin
	@PreAuthorize("hasAuthority('ADMIN')")
	@Override
	public ResponseEntity<ObservationUnitPositionsResponse> studiesStudyDbIdLayoutPut(@PathVariable("studyDbId") String studyDbId,
			@Valid @RequestBody StudyLayoutRequest studyLayoutRequest, String authorization) throws BrAPIServerException {
		return studiesStudyDbIdLayoutsPut(studyDbId, studyLayoutRequest, authorization);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationUnitPositionsResponse> studiesStudyDbIdLayoutsGet(@PathVariable("studyDbId") String studyDbId,
			@Valid Integer page, @Valid Integer pageSize, String authorization) throws BrAPIServerException {
		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<ObservationUnitPosition> data = studyService.getStudyPlotLayouts(studyDbId, metaData);

		ObservationUnitPositionsResponseResult result = new ObservationUnitPositionsResponseResult();
		result.setData(data);
		ObservationUnitPositionsResponse response = new ObservationUnitPositionsResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<ObservationUnitPositionsResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@PreAuthorize("hasAuthority('ADMIN')")
	@Override
	public ResponseEntity<ObservationUnitPositionsResponse> studiesStudyDbIdLayoutsPut(@PathVariable("studyDbId") String studyDbId,
			@Valid @RequestBody StudyLayoutRequest studyLayoutRequest, String authorization) throws BrAPIServerException {
		List<ObservationUnitPosition> data = studyService.saveStudyPlotLayout(studyDbId, studyLayoutRequest);
		Metadata metaData = generateEmptyMetadata();
		metaData.getPagination().setCurrentPage(0);
		metaData.getPagination().setPageSize(data.size());
		metaData.getPagination().setTotalCount(data.size());
		metaData.getPagination().setTotalPages(1);

		ObservationUnitPositionsResponseResult result = new ObservationUnitPositionsResponseResult();
		result.setData(data);
		ObservationUnitPositionsResponse response = new ObservationUnitPositionsResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<ObservationUnitPositionsResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationsResponse> studiesStudyDbIdObservationsGet(@PathVariable("studyDbId") String studyDbId,
			@Valid ArrayList<String> observationVariableDbIds, @Valid Integer page, @Valid Integer pageSize,
			String authorization) throws BrAPIServerException {
		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<Observation> data = studyService.getObservationUnits(studyDbId, observationVariableDbIds, metaData);

		ObservationsResponseResult result = new ObservationsResponseResult();
		result.setData(data);
		ObservationsResponse response = new ObservationsResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<ObservationsResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@PreAuthorize("hasAuthority('ADMIN')")
	@Override
	public ResponseEntity<NewObservationDbIdsResponse> studiesStudyDbIdObservationsPut(@PathVariable("studyDbId") String studyDbId,
			@Valid @RequestBody NewObservationsRequest newObservations, String authorization) throws BrAPIServerException {
		NewObservationDbIds result = studyService.saveObservations(studyDbId, newObservations);

		NewObservationDbIdsResponse response = new NewObservationDbIdsResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<NewObservationDbIdsResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationUnitsResponse1> studiesStudyDbIdObservationunitsGet(@PathVariable("studyDbId") String studyDbId,
			@Valid String observationLevel, @Valid Integer page, @Valid Integer pageSize, String authorization)
			throws BrAPIServerException {
		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<ObservationUnit> data = studyService.getStudyObservations(studyDbId, observationLevel, metaData);

		ObservationUnitsResponse1Result result = new ObservationUnitsResponse1Result();
		result.setData(data);
		ObservationUnitsResponse1 response = new ObservationUnitsResponse1();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<ObservationUnitsResponse1>(response, HttpStatus.OK);
	}

	@Deprecated
	@CrossOrigin
	@PreAuthorize("hasAuthority('ADMIN')")
	@Override
	public ResponseEntity<NewObservationUnitDbIdsResponse> studiesStudyDbIdObservationunitsPost(@PathVariable("studyDbId") String studyDbId,
			@NotNull @Valid String format, @Valid @RequestBody NewObservationsRequestWrapperDeprecated request, String authorization)
			throws BrAPIServerException {
		List<String> data = studyService.saveObservationUnits(studyDbId, request);
		Metadata metaData = generateEmptyMetadata();
		metaData.getPagination().setCurrentPage(0);
		metaData.getPagination().setPageSize(data.size());
		metaData.getPagination().setTotalCount(data.size());
		metaData.getPagination().setTotalPages(1);
		
		NewObservationUnitDbIds result = new NewObservationUnitDbIds();
		result.setObservationUnitDbIds(data);
		NewObservationUnitDbIdsResponse response = new NewObservationUnitDbIdsResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<NewObservationUnitDbIdsResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@PreAuthorize("hasAuthority('ADMIN')")
	@Override
	public ResponseEntity<NewObservationUnitDbIdsResponse> studiesStudyDbIdObservationunitsPut(@PathVariable("studyDbId") String studyDbId,
			@Valid @RequestBody ArrayList<NewObservationUnitRequest> request, String authorization) throws BrAPIServerException {
		NewObservationUnitDbIds result = studyService.saveObservationUnit(request);
		Metadata metadata = generateEmptyMetadata();
		Status status = new Status();
		status.setCode("200");
		status.setMessage("Upload Successful");
		status.setMessageType(MessageTypeEnum.INFO);
		metadata.getStatus().add(status);

		NewObservationUnitDbIdsResponse response = new NewObservationUnitDbIdsResponse();
		response.setMetadata(metadata);
		response.setResult(result);
		return new ResponseEntity<NewObservationUnitDbIdsResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@PreAuthorize("hasAuthority('ADMIN')")
	@Override
	public ResponseEntity<NewObservationUnitDbIdsResponse> studiesStudyDbIdObservationunitsZipPost(@PathVariable("studyDbId") String studyDbId,
			@Valid @RequestBody Object body, String authorization) throws BrAPIServerException {

		byte[] zipRequest = (byte[]) body;
		
		NewObservationUnitRequest request = null;
		try {
			ZipInputStream zis = new ZipInputStream(
					new BufferedInputStream(new ByteArrayInputStream(zipRequest), 8192));
			zis.getNextEntry();
			byte[] extractRaw = new byte[8192];
			zis.read(extractRaw);
			zis.close();
			request = new ObjectMapper().readValue(extractRaw, NewObservationUnitRequest.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return studiesStudyDbIdObservationunitsPut(studyDbId,
				(ArrayList<NewObservationUnitRequest>) Arrays.asList(request), null);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<StudyObservationVariablesResponse> studiesStudyDbIdObservationvariablesGet(@PathVariable("studyDbId") String studyDbId,
			@Valid Integer page, @Valid Integer pageSize, String authorization) throws BrAPIServerException {
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		StudyObservationVariablesResponseResult result = studyService.getStudyObservationVariables(studyDbId, metadata);

		StudyObservationVariablesResponse response = new StudyObservationVariablesResponse();
		response.setMetadata(metadata);
		response.setResult(result);
		return new ResponseEntity<StudyObservationVariablesResponse>(response, HttpStatus.OK);
	}

	@Deprecated
	@CrossOrigin
	@Override
	public ResponseEntity<StudyObservationVariablesResponse> studiesStudyDbIdObservationVariablesGet(
			@PathVariable("studyDbId") String studyDbId) {
		Metadata metadata = generateEmptyMetadata();
		StudyObservationVariablesResponseResult result = studyService.getStudyObservationVariables(studyDbId, metadata);

		StudyObservationVariablesResponse response = new StudyObservationVariablesResponse();
		response.setMetadata(metadata);
		response.setResult(result);
		return new ResponseEntity<StudyObservationVariablesResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<Object> studiesStudyDbIdTableGet(@PathVariable String studyDbId,
			@Valid String format, String authorization) throws BrAPIServerException {
		if ("csv".equals(format) || "CSV".equals(format)) {
			String result = studyService.getStudyObservationUnitTableText(studyDbId, ",");

			return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body(result);
		} else if ("tsv".equals(format) || "TSV".equals(format)) {
			String result = studyService.getStudyObservationUnitTableText(studyDbId, "\t");

			return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body(result);
		} else {
			Metadata metadata = generateEmptyMetadata();
			ObservationsTable result = studyService.getStudyObservationUnitTable(studyDbId, metadata);
			StudyobservationsTableResponse response = new StudyobservationsTableResponse();
			response.setMetadata(metadata);
			response.setResult(result);
			return new ResponseEntity<Object>(response, HttpStatus.OK);
		}
	}

	@CrossOrigin
	@PreAuthorize("hasAuthority('ADMIN')")
	@Override
	public ResponseEntity<NewObservationDbIdsResponse> studiesStudyDbIdTablePost(@PathVariable("studyDbId") String studyDbId,
			@Valid @RequestBody NewObservationsTableRequest request, String authorization) throws BrAPIServerException {
		NewObservationDbIds result = studyService.saveStudyObservationUnitsTable(studyDbId, request);
		Metadata metaData = generateEmptyMetadata();
		metaData.getPagination().setCurrentPage(0);
		metaData.getPagination().setPageSize(result.getObservations().size());
		metaData.getPagination().setTotalCount(result.getObservations().size());
		metaData.getPagination().setTotalPages(1);

		NewObservationDbIdsResponse response = new NewObservationDbIdsResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<NewObservationDbIdsResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<StudyTypesResponse> studytypesGet(@Valid String studyTypeDbId, @Valid Integer page,
			@Valid Integer pageSize, String authorization) throws BrAPIServerException {
		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<StudyType> data = studyService.getStudyTypes(studyTypeDbId, metaData);

		StudyTypesResponseResult result = new StudyTypesResponseResult();
		result.setData(data);
		StudyTypesResponse response = new StudyTypesResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<StudyTypesResponse>(response, HttpStatus.OK);
	}

	@Deprecated
	@CrossOrigin
	@Override
	public ResponseEntity<StudyTypesResponse> studyTypesGet(@Valid Integer pageSize, @Valid Integer page)
			throws BrAPIServerException {
		return studytypesGet(null, page, pageSize, null);
	}
}
