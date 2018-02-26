package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.rest.ObservationVariable;
import org.brapi.test.BrAPITestServer.model.rest.ObservationVariableSearchRequest;
import org.brapi.test.BrAPITestServer.model.rest.Ontology;
import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResults;
import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResultsDataList;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.brapi.test.BrAPITestServer.service.ObservationVariableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObservationVariableController  extends BrAPIController{
	private ObservationVariableService observationVariableService;
	
	@Autowired
	public ObservationVariableController(ObservationVariableService observationVariableService) {
		this.observationVariableService = observationVariableService;
	}
	
	@CrossOrigin
	@RequestMapping(path="brapi/v1/variables", method= {RequestMethod.GET})
	public GenericResults<GenericResultsDataList<ObservationVariable>> getVariables(
			@RequestParam(required=false) String traitClass,
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		List<ObservationVariable> variables = observationVariableService.getVariables(traitClass, metaData);
		return GenericResults.withList(variables).withMetaData(metaData);
	}
	
	@CrossOrigin
	@RequestMapping(path="brapi/v1/variables-search", method= {RequestMethod.POST})
	public GenericResults<GenericResultsDataList<ObservationVariable>> getVariables(
			@RequestBody ObservationVariableSearchRequest request) {
		MetaData metaData = generateMetaDataTemplate(request.getPage(), request.getPageSize());
		List<ObservationVariable> variables = observationVariableService.getVariables(request, metaData);
		return GenericResults.withList(variables).withMetaData(metaData);
	}
	
	@CrossOrigin
	@RequestMapping(path="brapi/v1/variables/{observationVariableDbId}", method= {RequestMethod.GET})
	public GenericResults<ObservationVariable> getVariable(
			@PathVariable(value="observationVariableDbId") String observationVariableDbId) {
		ObservationVariable variable = observationVariableService.getVariable(observationVariableDbId);
		return GenericResults.withObject(variable).withMetaData(generateEmptyMetadata());
	}
	
	@CrossOrigin
	@RequestMapping(path="brapi/v1/variables/datatypes", method= {RequestMethod.GET})
	public GenericResults<GenericResultsDataList<String>> getVariableDataTypes(
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		List<String> dataTypes = observationVariableService.getDataTypes(metaData);
		return GenericResults.withList(dataTypes).withMetaData(metaData);
	}
	
	@CrossOrigin
	@RequestMapping(path="brapi/v1/ontologies", method= {RequestMethod.GET})
	public GenericResults<GenericResultsDataList<Ontology>> getOntologies(
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		List<Ontology> ontologies = observationVariableService.getOntologies(metaData);
		return GenericResults.withList(ontologies).withMetaData(metaData);
	}
}
