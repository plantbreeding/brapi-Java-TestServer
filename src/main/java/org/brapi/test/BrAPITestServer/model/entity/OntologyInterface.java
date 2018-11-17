package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

public interface OntologyInterface {
	public OntologyEntity getOntology() ;
	public void setOntology(OntologyEntity ontology) ;
	public List<OntologyRefernceEntity> getOntologyRefernce() ;
	public void setOntologyRefernce(List<OntologyRefernceEntity> ontologyRefernce) ;
	public String getId();
}
