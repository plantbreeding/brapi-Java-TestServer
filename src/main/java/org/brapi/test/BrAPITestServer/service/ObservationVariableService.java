package org.brapi.test.BrAPITestServer.service;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.rest.ObservationVariable;
import org.brapi.test.BrAPITestServer.model.rest.ObservationVariableSearchRequest;
import org.brapi.test.BrAPITestServer.model.rest.Ontology;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.springframework.stereotype.Service;

@Service
public class ObservationVariableService {

	public List<String> getDataTypes(MetaData metaData) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ObservationVariable> getVariables(String traitClass, MetaData metaData) {
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

	public List<Ontology> getOntologies(MetaData metaData) {
		// TODO Auto-generated method stub
		return null;
	}

}
