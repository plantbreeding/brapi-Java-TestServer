package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.service.ObservationVariableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.api.OntologiesApi;
import io.swagger.api.VariablesApi;
import io.swagger.api.VariablesSearchApi;
import io.swagger.model.DataTypesResponse;
import io.swagger.model.DataTypesResponseResult;
import io.swagger.model.Metadata;
import io.swagger.model.ObservationVariable;
import io.swagger.model.ObservationVariableResponse;
import io.swagger.model.ObservationVariableSearchRequest;
import io.swagger.model.ObservationVariablesResponse;
import io.swagger.model.ObservationVariablesResponseResult;
import io.swagger.model.OntologiesResponse;
import io.swagger.model.OntologiesResponseResult;
import io.swagger.model.Ontology;

@RestController
public class ObservationVariableController extends BrAPIController implements VariablesApi, VariablesSearchApi, OntologiesApi{
	private ObservationVariableService observationVariableService;
	
	@Autowired
	public ObservationVariableController(ObservationVariableService observationVariableService) {
		this.observationVariableService = observationVariableService;
	}
	
	@CrossOrigin
	@Override
	public ResponseEntity<OntologiesResponse> ontologiesGet(@Valid Integer pageSize, @Valid Integer page) {
		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<Ontology> data = observationVariableService.getOntologies(metaData);
		
		OntologiesResponseResult result = new OntologiesResponseResult();
		result.setData(data);
		OntologiesResponse response = new OntologiesResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<OntologiesResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationVariablesResponse> variablesSearchPost(@Valid ObservationVariableSearchRequest request) {

		Metadata metaData = generateMetaDataTemplate(request.getPage().intValue(), request.getPageSize().intValue());
		List<ObservationVariable> data = observationVariableService.getVariables(request, metaData);
		
		ObservationVariablesResponseResult result = new ObservationVariablesResponseResult();
		result.setData(data);
		ObservationVariablesResponse response = new ObservationVariablesResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<ObservationVariablesResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<DataTypesResponse> variablesDatatypesGet(@Valid Integer pageSize, @Valid Integer page) {

		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<String> data = observationVariableService.getDataTypes(metaData);
		
		DataTypesResponseResult result = new DataTypesResponseResult();
		result.setData(data);
		DataTypesResponse response = new DataTypesResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<DataTypesResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationVariablesResponse> variablesGet(@Valid Integer pageSize, @Valid Integer page,
			@Valid String traitClass) {
		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<ObservationVariable> data = observationVariableService.getVariables(traitClass, metaData);
		
		ObservationVariablesResponseResult result = new ObservationVariablesResponseResult();
		result.setData(data);
		ObservationVariablesResponse response = new ObservationVariablesResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<ObservationVariablesResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationVariableResponse> variablesObservationVariableDbIdGet(
			String observationVariableDbId) {
		ObservationVariable result = observationVariableService.getVariable(observationVariableDbId);
		
		ObservationVariableResponse response = new ObservationVariableResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<ObservationVariableResponse>(response, HttpStatus.OK);
	}
}
