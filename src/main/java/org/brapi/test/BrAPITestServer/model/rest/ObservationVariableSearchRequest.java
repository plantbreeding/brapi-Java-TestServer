package org.brapi.test.BrAPITestServer.model.rest;

import java.util.List;

public class ObservationVariableSearchRequest {
	private int page;
	private int pageSize;
	private List<String> observationVariableDbIds;
	private List<String> ontologyXrefs;
	private List<String> ontologyDbIds;
	private List<String> methodDbIds;
	private List<String> scaleDbIds;
	private List<String> names;
	private List<String> datatypes;
	private List<String> traitClasses;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<String> getObservationVariableDbIds() {
		return observationVariableDbIds;
	}
	public void setObservationVariableDbIds(List<String> observationVariableDbIds) {
		this.observationVariableDbIds = observationVariableDbIds;
	}
	public List<String> getOntologyXrefs() {
		return ontologyXrefs;
	}
	public void setOntologyXrefs(List<String> ontologyXrefs) {
		this.ontologyXrefs = ontologyXrefs;
	}
	public List<String> getOntologyDbIds() {
		return ontologyDbIds;
	}
	public void setOntologyDbIds(List<String> ontologyDbIds) {
		this.ontologyDbIds = ontologyDbIds;
	}
	public List<String> getMethodDbIds() {
		return methodDbIds;
	}
	public void setMethodDbIds(List<String> methodDbIds) {
		this.methodDbIds = methodDbIds;
	}
	public List<String> getScaleDbIds() {
		return scaleDbIds;
	}
	public void setScaleDbIds(List<String> scaleDbIds) {
		this.scaleDbIds = scaleDbIds;
	}
	public List<String> getNames() {
		return names;
	}
	public void setNames(List<String> names) {
		this.names = names;
	}
	public List<String> getDatatypes() {
		return datatypes;
	}
	public void setDatatypes(List<String> datatypes) {
		this.datatypes = datatypes;
	}
	public List<String> getTraitClasses() {
		return traitClasses;
	}
	public void setTraitClasses(List<String> traitClasses) {
		this.traitClasses = traitClasses;
	}
}
