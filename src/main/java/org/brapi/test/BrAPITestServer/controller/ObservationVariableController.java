package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.ObservationVariable;
import org.brapi.test.BrAPITestServer.model.ObservationVariableSearchRequest;
import org.brapi.test.BrAPITestServer.model.Ontology;
import org.brapi.test.BrAPITestServer.model.metadata.SearchResults;
import org.brapi.test.BrAPITestServer.model.metadata.SearchResultsList;
import org.brapi.test.BrAPITestServer.service.ObservationVariableService;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value="variables", method= {RequestMethod.GET})
	public SearchResults<SearchResultsList<ObservationVariable>> getVariables(
			@RequestParam String traitClass,
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		List<ObservationVariable> variables = observationVariableService.getVariables(traitClass, page, pageSize);
		return SearchResults.withList(variables).withMetaData(mockMetaData(page, pageSize));
	}
	
	@RequestMapping(value="variables-search", method= {RequestMethod.POST})
	public SearchResults<SearchResultsList<ObservationVariable>> getVariables(
			@RequestBody ObservationVariableSearchRequest request) {
		List<ObservationVariable> variables = observationVariableService.getVariables(request);
		return SearchResults.withList(variables).withMetaData(mockMetaData(request.getPage(), request.getPageSize()));
	}
	
	@RequestMapping(value="variables/{observationVariableDbId}", method= {RequestMethod.GET})
	public SearchResults<ObservationVariable> getVariable(
			@PathVariable(value="observationVariableDbId") String observationVariableDbId) {
		ObservationVariable variable = observationVariableService.getVariable(observationVariableDbId);
		return SearchResults.withObject(variable).withMetaData(mockEmptyMetadata());
	}
	
	@RequestMapping(value="variables/datatypes", method= {RequestMethod.GET})
	public SearchResults<SearchResultsList<String>> getVariableDataTypes(
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		List<String> dataTypes = observationVariableService.getDataTypes(page, pageSize);
		return SearchResults.withList(dataTypes).withMetaData(mockMetaData(page, pageSize));
	}
	
	@RequestMapping(value="ontologies", method= {RequestMethod.GET})
	public SearchResults<SearchResultsList<Ontology>> getOntologies(
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		List<Ontology> ontologies = observationVariableService.getOntologies(page, pageSize);
		return SearchResults.withList(ontologies).withMetaData(mockMetaData(page, pageSize));
	}
}
