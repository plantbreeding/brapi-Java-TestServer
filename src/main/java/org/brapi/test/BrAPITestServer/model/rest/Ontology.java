package org.brapi.test.BrAPITestServer.model.rest;

public class Ontology {
	private String ontologyDbId;
	private String ontologyName;
	private String authors;
	private String version;
	private String description;
	private String copyright;
	private String licence;
	public String getOntologyDbId() {
		return ontologyDbId;
	}
	public void setOntologyDbId(String ontologyDbId) {
		this.ontologyDbId = ontologyDbId;
	}
	public String getOntologyName() {
		return ontologyName;
	}
	public void setOntologyName(String ontologyName) {
		this.ontologyName = ontologyName;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public String getLicence() {
		return licence;
	}
	public void setLicence(String licence) {
		this.licence = licence;
	}
}
