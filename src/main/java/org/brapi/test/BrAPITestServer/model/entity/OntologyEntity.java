package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ontology")
public class OntologyEntity extends BrAPIPrimaryEntity {
	@Column
	private String ontologyName;
	@Column
	private String authors;
	@Column
	private String version;
	@Column
	private String description;
	@Column
	private String copyright;
	@Column
	private String licence;
	@Column
	private String documentationURL;
	@OneToMany(mappedBy="ontology")
	private List<VariableBaseEntity> variables;
	@ElementCollection
	private List<String> documentationLinks;

	public List<String> getDocumentationLinks() {
		return documentationLinks;
	}
	public void setDocumentationLinks(List<String> documentationLinks) {
		this.documentationLinks = documentationLinks;
	}
	public String getDocumentationURL() {
		return documentationURL;
	}
	public void setDocumentationURL(String documentationURL) {
		this.documentationURL = documentationURL;
	}
	public List<VariableBaseEntity> getVariables() {
		return variables;
	}
	public void setVariables(List<VariableBaseEntity> variables) {
		this.variables = variables;
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
