package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * Ontology
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class Ontology   {
  @JsonProperty("authors")
  private String authors = null;

  @JsonProperty("copyright")
  private String copyright = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("licence")
  private String licence = null;

  @JsonProperty("ontologyDbId")
  private String ontologyDbId = null;

  @JsonProperty("ontologyName")
  private String ontologyName = null;

  @JsonProperty("version")
  private String version = null;

  public Ontology authors(String authors) {
    this.authors = authors;
    return this;
  }

   /**
   * Ontology's list of authors (no specific format)
   * @return authors
  **/
  @ApiModelProperty(value = "Ontology's list of authors (no specific format)")


  public String getAuthors() {
    return authors;
  }

  public void setAuthors(String authors) {
    this.authors = authors;
  }

  public Ontology copyright(String copyright) {
    this.copyright = copyright;
    return this;
  }

   /**
   * Ontology copyright
   * @return copyright
  **/
  @ApiModelProperty(value = "Ontology copyright")


  public String getCopyright() {
    return copyright;
  }

  public void setCopyright(String copyright) {
    this.copyright = copyright;
  }

  public Ontology description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Human readable description of Ontology
   * @return description
  **/
  @ApiModelProperty(value = "Human readable description of Ontology")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Ontology licence(String licence) {
    this.licence = licence;
    return this;
  }

   /**
   * Ontology licence
   * @return licence
  **/
  @ApiModelProperty(value = "Ontology licence")


  public String getLicence() {
    return licence;
  }

  public void setLicence(String licence) {
    this.licence = licence;
  }

  public Ontology ontologyDbId(String ontologyDbId) {
    this.ontologyDbId = ontologyDbId;
    return this;
  }

   /**
   * Ontology database unique identifier
   * @return ontologyDbId
  **/
  @ApiModelProperty(required = true, value = "Ontology database unique identifier")
  @NotNull


  public String getOntologyDbId() {
    return ontologyDbId;
  }

  public void setOntologyDbId(String ontologyDbId) {
    this.ontologyDbId = ontologyDbId;
  }

  public Ontology ontologyName(String ontologyName) {
    this.ontologyName = ontologyName;
    return this;
  }

   /**
   * Ontology name
   * @return ontologyName
  **/
  @ApiModelProperty(required = true, value = "Ontology name")
  @NotNull


  public String getOntologyName() {
    return ontologyName;
  }

  public void setOntologyName(String ontologyName) {
    this.ontologyName = ontologyName;
  }

  public Ontology version(String version) {
    this.version = version;
    return this;
  }

   /**
   * Ontology version (no specific format)
   * @return version
  **/
  @ApiModelProperty(value = "Ontology version (no specific format)")


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
    Ontology ontology = (Ontology) o;
    return Objects.equals(this.authors, ontology.authors) &&
        Objects.equals(this.copyright, ontology.copyright) &&
        Objects.equals(this.description, ontology.description) &&
        Objects.equals(this.licence, ontology.licence) &&
        Objects.equals(this.ontologyDbId, ontology.ontologyDbId) &&
        Objects.equals(this.ontologyName, ontology.ontologyName) &&
        Objects.equals(this.version, ontology.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(authors, copyright, description, licence, ontologyDbId, ontologyName, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ontology {\n");
    
    sb.append("    authors: ").append(toIndentedString(authors)).append("\n");
    sb.append("    copyright: ").append(toIndentedString(copyright)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    licence: ").append(toIndentedString(licence)).append("\n");
    sb.append("    ontologyDbId: ").append(toIndentedString(ontologyDbId)).append("\n");
    sb.append("    ontologyName: ").append(toIndentedString(ontologyName)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

