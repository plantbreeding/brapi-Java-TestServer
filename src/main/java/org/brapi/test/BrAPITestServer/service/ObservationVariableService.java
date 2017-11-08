package org.brapi.test.BrAPITestServer.service;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.rest.ObservationVariable;
import org.brapi.test.BrAPITestServer.model.rest.ObservationVariableSearchRequest;
import org.brapi.test.BrAPITestServer.model.rest.Ontology;
import org.springframework.stereotype.Service;

@Service
public class ObservationVariableService {

	public List<String> getDataTypes(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ObservationVariable> getVariables(String traitClass, int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public ObservationVariable getVariable(String observationVariableDbId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ObservationVariable> getVariables(ObservationVariableSearchRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Ontology> getOntologies(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
