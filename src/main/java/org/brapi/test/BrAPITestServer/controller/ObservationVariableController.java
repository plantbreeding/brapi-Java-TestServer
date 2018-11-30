package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.ObservationVariableService;
import org.brapi.test.BrAPITestServer.service.OntologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.api.MethodsApi;
import io.swagger.api.OntologiesApi;
import io.swagger.api.ScalesApi;
import io.swagger.api.TraitsApi;
import io.swagger.api.VariablesApi;
import io.swagger.api.VariablesSearchApi;
import io.swagger.model.DataTypesResponse;
import io.swagger.model.DataTypesResponseResult;
import io.swagger.model.Metadata;
import io.swagger.model.Method;
import io.swagger.model.MethodResponse;
import io.swagger.model.MethodsResponse;
import io.swagger.model.MethodsResponseResult;
import io.swagger.model.NewMethodRequest;
import io.swagger.model.NewScaleRequest;
import io.swagger.model.NewTraitRequest;
import io.swagger.model.ObservationVariable;
import io.swagger.model.ObservationVariableResponse;
import io.swagger.model.ObservationVariableSearchRequestDep;
import io.swagger.model.ObservationVariablesResponse;
import io.swagger.model.ObservationVariablesResponseResult;
import io.swagger.model.OntologiesResponse;
import io.swagger.model.OntologiesResponseResult;
import io.swagger.model.Ontology;
import io.swagger.model.Scale;
import io.swagger.model.ScaleResponse;
import io.swagger.model.ScalesResponse;
import io.swagger.model.ScalesResponseResult;
import io.swagger.model.Trait;
import io.swagger.model.TraitResponse;
import io.swagger.model.TraitSummary;
import io.swagger.model.TraitSummaryResponse;
import io.swagger.model.TraitsResponse;
import io.swagger.model.TraitsResponseResult;

@RestController
public class ObservationVariableController extends BrAPIController
		implements VariablesApi, VariablesSearchApi, OntologiesApi, TraitsApi, MethodsApi, ScalesApi {
	private ObservationVariableService observationVariableService;
	private OntologyService ontologyService;

	@Autowired
	public ObservationVariableController(ObservationVariableService observationVariableService,
			OntologyService ontologyService) {
		this.observationVariableService = observationVariableService;
		this.ontologyService = ontologyService;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<OntologiesResponse> ontologiesGet(@Valid Integer page, @Valid Integer pageSize,
			String authorization) throws BrAPIServerException {
		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<Ontology> data = ontologyService.getOntologies(metaData);

		OntologiesResponseResult result = new OntologiesResponseResult();
		result.setData(data);
		OntologiesResponse response = new OntologiesResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<OntologiesResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<DataTypesResponse> variablesDatatypesGet(@Valid Integer pageSize, @Valid Integer page)
			throws BrAPIServerException {

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
	public ResponseEntity<ObservationVariablesResponse> variablesGet(@Valid Integer page, @Valid Integer pageSize,
			String authorization, @Valid String observationVariableDbId, @Valid String traitClass)
			throws BrAPIServerException {
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
			@PathVariable("observationVariableDbId") String observationVariableDbId, String authorization)
			throws BrAPIServerException {
		ObservationVariable result = observationVariableService.getVariable(observationVariableDbId);

		ObservationVariableResponse response = new ObservationVariableResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<ObservationVariableResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ObservationVariablesResponse> variablesSearchPost(
			@Valid @RequestBody ObservationVariableSearchRequestDep request) throws BrAPIServerException {

		Metadata metaData = generateMetaDataTemplate(request.getPage(), request.getPageSize());
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
	public ResponseEntity<ScalesResponse> scalesGet(@Valid Integer page, @Valid Integer pageSize, String authorization)
			throws BrAPIServerException {
		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<Scale> data = ontologyService.getScales(metaData);

		ScalesResponseResult result = new ScalesResponseResult();
		result.setData(data);
		ScalesResponse response = new ScalesResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<ScalesResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@PreAuthorize("hasAuthority('ADMIN')")
	@Override
	public ResponseEntity<ScaleResponse> scalesPost(@Valid @RequestBody NewScaleRequest body, String authorization)
			throws BrAPIServerException {
		Scale data = ontologyService.saveNewScale(body);

		ScaleResponse response = new ScaleResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(data);
		return new ResponseEntity<ScaleResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ScaleResponse> scalesScaleDbIdGet(@PathVariable("scaleDbId") String scaleDbId,
			String authorization) throws BrAPIServerException {
		Scale data = ontologyService.getScale(scaleDbId);

		ScaleResponse response = new ScaleResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(data);
		return new ResponseEntity<ScaleResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@PreAuthorize("hasAuthority('ADMIN')")
	@Override
	public ResponseEntity<ScaleResponse> scalesScaleDbIdPut(@PathVariable("scaleDbId") String scaleDbId,
			@Valid @RequestBody NewScaleRequest body, String authorization) throws BrAPIServerException {

		Scale data = ontologyService.updateScale(scaleDbId, body);

		ScaleResponse response = new ScaleResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(data);
		return new ResponseEntity<ScaleResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<MethodsResponse> methodsGet(@Valid Integer page, @Valid Integer pageSize,
			String authorization) throws BrAPIServerException {
		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<Method> data = ontologyService.getMethods(metaData);

		MethodsResponseResult result = new MethodsResponseResult();
		result.setData(data);
		MethodsResponse response = new MethodsResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<MethodsResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<MethodResponse> methodsMethodDbIdGet(@PathVariable("methodDbId") String methodDbId,
			String authorization) throws BrAPIServerException {

		Method data = ontologyService.getMethod(methodDbId);

		MethodResponse response = new MethodResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(data);
		return new ResponseEntity<MethodResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@PreAuthorize("hasAuthority('ADMIN')")
	@Override
	public ResponseEntity<MethodResponse> methodsMethodDbIdPut(@PathVariable("methodDbId") String methodDbId,
			@Valid @RequestBody NewMethodRequest body, String authorization) throws BrAPIServerException {
		Method data = ontologyService.updateMethod(methodDbId, body);

		MethodResponse response = new MethodResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(data);
		return new ResponseEntity<MethodResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@PreAuthorize("hasAuthority('ADMIN')")
	@Override
	public ResponseEntity<MethodResponse> methodsPost(@Valid @RequestBody NewMethodRequest body, String authorization)
			throws BrAPIServerException {
		Method data = ontologyService.saveNewMethod(body);

		MethodResponse response = new MethodResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(data);
		return new ResponseEntity<MethodResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<TraitsResponse> traitsGet(@Valid Integer page, @Valid Integer pageSize, String authorization)
			throws BrAPIServerException {

		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<TraitSummary> data = ontologyService.getTraits(metaData);

		TraitsResponseResult result = new TraitsResponseResult();
		result.setData(data);
		TraitsResponse response = new TraitsResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<TraitsResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@PreAuthorize("hasAuthority('ADMIN')")
	@Override
	public ResponseEntity<TraitResponse> traitsPost(@Valid @RequestBody NewTraitRequest body, String authorization)
			throws BrAPIServerException {
		Trait data = ontologyService.saveNewTrait(body);

		TraitResponse response = new TraitResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(data);
		return new ResponseEntity<TraitResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<TraitSummaryResponse> traitsTraitDbIdGet(@PathVariable("traitDbId") String traitDbId,
			String authorization) throws BrAPIServerException {

		TraitSummary result = ontologyService.getTrait(traitDbId);

		TraitSummaryResponse response = new TraitSummaryResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<TraitSummaryResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@PreAuthorize("hasAuthority('ADMIN')")
	@Override
	public ResponseEntity<TraitResponse> traitsTraitDbIdPut(@PathVariable("traitDbId") String traitDbId,
			@Valid @RequestBody NewTraitRequest body, String authorization) throws BrAPIServerException {
		
		Trait data = ontologyService.updateTrait(traitDbId, body);

		TraitResponse response = new TraitResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(data);
		return new ResponseEntity<TraitResponse>(response, HttpStatus.OK);
	}
}
