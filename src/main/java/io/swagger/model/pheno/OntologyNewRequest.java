package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.BrAPIDataModel;

public class OntologyNewRequest extends BrAPIDataModel {
	@JsonProperty("authors")
	private String authors = null;

	@JsonProperty("copyright")
	private String copyright = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("documentationURL")
	private String documentationURL = null;

	@JsonProperty("licence")
	private String licence = null;

	@JsonProperty("ontologyName")
	private String ontologyName = null;

	@JsonProperty("version")
	private String version = null;

	public OntologyNewRequest authors(String authors) {
		this.authors = authors;
		return this;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public OntologyNewRequest copyright(String copyright) {
		this.copyright = copyright;
		return this;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public OntologyNewRequest description(String description) {
		this.description = description;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public OntologyNewRequest documentationURL(String documentationURL) {
		this.documentationURL = documentationURL;
		return this;
	}

	public String getDocumentationURL() {
		return documentationURL;
	}

	public void setDocumentationURL(String documentationURL) {
		this.documentationURL = documentationURL;
	}

	public OntologyNewRequest licence(String licence) {
		this.licence = licence;
		return this;
	}

	public String getLicence() {
		return licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

	public OntologyNewRequest ontologyName(String ontologyName) {
		this.ontologyName = ontologyName;
		return this;
	}

	public String getOntologyName() {
		return ontologyName;
	}

	public void setOntologyName(String ontologyName) {
		this.ontologyName = ontologyName;
	}

	public OntologyNewRequest version(String version) {
		this.version = version;
		return this;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		OntologyNewRequest ontologyNewRequest = (OntologyNewRequest) o;
		return Objects.equals(this.additionalInfo, ontologyNewRequest.additionalInfo)
				&& Objects.equals(this.authors, ontologyNewRequest.authors)
				&& Objects.equals(this.copyright, ontologyNewRequest.copyright)
				&& Objects.equals(this.description, ontologyNewRequest.description)
				&& Objects.equals(this.documentationURL, ontologyNewRequest.documentationURL)
				&& Objects.equals(this.licence, ontologyNewRequest.licence)
				&& Objects.equals(this.ontologyName, ontologyNewRequest.ontologyName)
				&& Objects.equals(this.version, ontologyNewRequest.version);
	}

	@Override
	public int hashCode() {
		return Objects.hash(additionalInfo, authors, copyright, description, documentationURL, licence, ontologyName,
				version);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class OntologyNewRequest {\n");

		sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
		sb.append("    authors: ").append(toIndentedString(authors)).append("\n");
		sb.append("    copyright: ").append(toIndentedString(copyright)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    documentationURL: ").append(toIndentedString(documentationURL)).append("\n");
		sb.append("    licence: ").append(toIndentedString(licence)).append("\n");
		sb.append("    ontologyName: ").append(toIndentedString(ontologyName)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
