package org.brapi.test.BrAPITestServer.model.entity.pheno;

import java.util.List;

public interface OntologyInterface {
	public OntologyEntity getOntology() ;
	public void setOntology(OntologyEntity ontology) ;
	public List<OntologyReferenceEntity> getOntologyReference() ;
	public void setOntologyReference(List<OntologyReferenceEntity> ontologyReference) ;
	public String getId();
}
