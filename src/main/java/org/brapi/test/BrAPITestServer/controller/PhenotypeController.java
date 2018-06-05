package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.service.DateUtility;
import org.brapi.test.BrAPITestServer.service.PhenotypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.threeten.bp.OffsetDateTime;

import io.swagger.api.PhenotypesApi;
import io.swagger.api.PhenotypesSearchApi;
import io.swagger.model.Metadata;
import io.swagger.model.NewObservationDbIds;
import io.swagger.model.NewObservationDbIdsObservations;
import io.swagger.model.NewObservationDbIdsResponse;
import io.swagger.model.ObservationUnitPhenotype;
import io.swagger.model.ObservationUnitsResponse;
import io.swagger.model.ObservationUnitsResponseResult;
import io.swagger.model.ObservationUnitsTableResponse;
import io.swagger.model.ObservationUnitsTableResponse1;
import io.swagger.model.PhenotypesRequest;
import io.swagger.model.PhenotypesSearchRequest;

@RestController
public class PhenotypeController extends BrAPIController implements PhenotypesApi, PhenotypesSearchApi {

	private PhenotypeService phenotypeService;

	@Autowired
	public PhenotypeController(PhenotypeService phenotypeService) {
		this.phenotypeService = phenotypeService;
	}

	@CrossOrigin
	@PreAuthorize("hasAuthority('ADMIN')")
	@Override
	public ResponseEntity<NewObservationDbIdsResponse> phenotypesPost(@Valid String format,	@Valid PhenotypesRequest request) {
		List<NewObservationDbIdsObservations> data = phenotypeService.savePhenotypes(request);
		
		NewObservationDbIds result = new NewObservationDbIds();
		result.setObservations(data);
		NewObservationDbIdsResponse response = new NewObservationDbIdsResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<NewObservationDbIdsResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<String> phenotypesSearchCsvPost(@Valid PhenotypesSearchRequest request) {
		Metadata metaData = generateMetaDataTemplate(request.getPage(), request.getPageSize());
		String response = phenotypeService.getPhenotypesCsv(request, metaData);

		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationUnitsResponse> phenotypesSearchGet(@Valid String germplasmDbId,
			@Valid String observationVariableDbId, @Valid String studyDbId, @Valid String locationDbId,
			@Valid String trialDbId, @Valid String programDbId, @Valid String seasonDbId,
			@Valid String observationLevel, @Valid String observationTimeStampRangeStart,
			@Valid String observationTimeStampRangeEnd, @Valid Integer pageSize, @Valid Integer page) {
		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<ObservationUnitPhenotype> data = phenotypeService.getPhenotypes(germplasmDbId, observationVariableDbId,
				studyDbId, locationDbId, trialDbId, programDbId, seasonDbId, observationLevel,
				DateUtility.toOffsetDateTime(observationTimeStampRangeStart), 
				DateUtility.toOffsetDateTime(observationTimeStampRangeEnd), metaData);

		ObservationUnitsResponseResult result = new ObservationUnitsResponseResult();
		result.setData(data);
		ObservationUnitsResponse response = new ObservationUnitsResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<ObservationUnitsResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationUnitsResponse> phenotypesSearchPost(@Valid PhenotypesSearchRequest request) {
		Metadata metaData = generateMetaDataTemplate(request.getPage(), request.getPageSize());
		List<ObservationUnitPhenotype> data = phenotypeService.getPhenotypes(request, metaData);

		ObservationUnitsResponseResult result = new ObservationUnitsResponseResult();
		result.setData(data);
		ObservationUnitsResponse response = new ObservationUnitsResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<ObservationUnitsResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationUnitsTableResponse1> phenotypesSearchTablePost(
			@Valid PhenotypesSearchRequest request) {
		Metadata metaData = generateMetaDataTemplate(request.getPage(), request.getPageSize());
		ObservationUnitsTableResponse result = phenotypeService.getPhenotypesTable(request, metaData);

		ObservationUnitsTableResponse1 response = new ObservationUnitsTableResponse1();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<ObservationUnitsTableResponse1>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<String> phenotypesSearchTsvPost(@Valid PhenotypesSearchRequest request) {
		Metadata metaData = generateMetaDataTemplate(request.getPage(), request.getPageSize());
		String response = phenotypeService.getPhenotypesTsv(request, metaData);

		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
}
