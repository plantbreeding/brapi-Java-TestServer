package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Method;
import io.swagger.model.OntologyReference;
import io.swagger.model.Scale;
import io.swagger.model.Trait;
import java.util.ArrayList;
import java.util.List;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * VariableBaseClass
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class VariableBaseClass   {
  @JsonProperty("contextOfUse")
  @Valid
  private List<String> contextOfUse = null;

  @JsonProperty("crop")
  private String crop = null;

  @JsonProperty("defaultValue")
  private String defaultValue = null;

  @JsonProperty("documentationURL")
  private String documentationURL = null;

  @JsonProperty("growthStage")
  private String growthStage = null;

  @JsonProperty("institution")
  private String institution = null;

  @JsonProperty("language")
  private String language = null;

  @JsonProperty("method")
  private Method method = null;

  @JsonProperty("ontologyDbId")
  private String ontologyDbId = null;

  @JsonProperty("ontologyName")
  private String ontologyName = null;

  @JsonProperty("ontologyReference")
  private OntologyReference ontologyReference = null;

  @JsonProperty("scale")
  private Scale scale = null;

  @JsonProperty("scientist")
  private String scientist = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("submissionTimestamp")
  private OffsetDateTime submissionTimestamp = null;

  @JsonProperty("synonyms")
  @Valid
  private List<String> synonyms = null;

  @JsonProperty("trait")
  private Trait trait = null;

  @JsonProperty("xref")
  private String xref = null;

  public VariableBaseClass contextOfUse(List<String> contextOfUse) {
    this.contextOfUse = contextOfUse;
    return this;
  }

  public VariableBaseClass addContextOfUseItem(String contextOfUseItem) {
    if (this.contextOfUse == null) {
      this.contextOfUse = new ArrayList<String>();
    }
    this.contextOfUse.add(contextOfUseItem);
    return this;
  }

  /**
   * Indication of how trait is routinely used. (examples: [\"Trial evaluation\", \"Nursery evaluation\"])
   * @return contextOfUse
  **/
  @ApiModelProperty(value = "Indication of how trait is routinely used. (examples: [\"Trial evaluation\", \"Nursery evaluation\"])")


  public List<String> getContextOfUse() {
    return contextOfUse;
  }

  public void setContextOfUse(List<String> contextOfUse) {
    this.contextOfUse = contextOfUse;
  }

  public VariableBaseClass crop(String crop) {
    this.crop = crop;
    return this;
  }

  /**
   * Crop name (examples: \"Maize\", \"Wheat\")
   * @return crop
  **/
  @ApiModelProperty(value = "Crop name (examples: \"Maize\", \"Wheat\")")


  public String getCrop() {
    return crop;
  }

  public void setCrop(String crop) {
    this.crop = crop;
  }

  public VariableBaseClass defaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
    return this;
  }

  /**
   * Variable default value. (examples: \"red\", \"2.3\", etc.)
   * @return defaultValue
  **/
  @ApiModelProperty(value = "Variable default value. (examples: \"red\", \"2.3\", etc.)")


  public String getDefaultValue() {
    return defaultValue;
  }

  public void setDefaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
  }

  public VariableBaseClass documentationURL(String documentationURL) {
    this.documentationURL = documentationURL;
    return this;
  }

  /**
   * A URL to the human readable documentation of this object
   * @return documentationURL
  **/
  @ApiModelProperty(value = "A URL to the human readable documentation of this object")


  public String getDocumentationURL() {
    return documentationURL;
  }

  public void setDocumentationURL(String documentationURL) {
    this.documentationURL = documentationURL;
  }

  public VariableBaseClass growthStage(String growthStage) {
    this.growthStage = growthStage;
    return this;
  }

  /**
   * Growth stage at which measurement is made (examples: \"flowering\")
   * @return growthStage
  **/
  @ApiModelProperty(value = "Growth stage at which measurement is made (examples: \"flowering\")")


  public String getGrowthStage() {
    return growthStage;
  }

  public void setGrowthStage(String growthStage) {
    this.growthStage = growthStage;
  }

  public VariableBaseClass institution(String institution) {
    this.institution = institution;
    return this;
  }

  /**
   * Name of institution submitting the variable
   * @return institution
  **/
  @ApiModelProperty(value = "Name of institution submitting the variable")


  public String getInstitution() {
    return institution;
  }

  public void setInstitution(String institution) {
    this.institution = institution;
  }

  public VariableBaseClass language(String language) {
    this.language = language;
    return this;
  }

  /**
   * 2 letter ISO code for the language of submission of the variable.
   * @return language
  **/
  @ApiModelProperty(value = "2 letter ISO code for the language of submission of the variable.")


  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public VariableBaseClass method(Method method) {
    this.method = method;
    return this;
  }

  /**
   * Get method
   * @return method
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Method getMethod() {
    return method;
  }

  public void setMethod(Method method) {
    this.method = method;
  }

  public VariableBaseClass ontologyDbId(String ontologyDbId) {
    this.ontologyDbId = ontologyDbId;
    return this;
  }

  /**
   * DEPRECATED in v1.3 - see \"this.ontologyReference.ontologyDbId\"
   * @return ontologyDbId
  **/
  @ApiModelProperty(value = "DEPRECATED in v1.3 - see \"this.ontologyReference.ontologyDbId\"")


  public String getOntologyDbId() {
    return ontologyDbId;
  }

  public void setOntologyDbId(String ontologyDbId) {
    this.ontologyDbId = ontologyDbId;
  }

  public VariableBaseClass ontologyName(String ontologyName) {
    this.ontologyName = ontologyName;
    return this;
  }

  /**
   * DEPRECATED in v1.3 - see \"this.ontologyReference.ontologyName\"
   * @return ontologyName
  **/
  @ApiModelProperty(value = "DEPRECATED in v1.3 - see \"this.ontologyReference.ontologyName\"")


  public String getOntologyName() {
    return ontologyName;
  }

  public void setOntologyName(String ontologyName) {
    this.ontologyName = ontologyName;
  }

  public VariableBaseClass ontologyReference(OntologyReference ontologyReference) {
    this.ontologyReference = ontologyReference;
    return this;
  }

  /**
   * Get ontologyReference
   * @return ontologyReference
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OntologyReference getOntologyReference() {
    return ontologyReference;
  }

  public void setOntologyReference(OntologyReference ontologyReference) {
    this.ontologyReference = ontologyReference;
  }

  public VariableBaseClass scale(Scale scale) {
    this.scale = scale;
    return this;
  }

  /**
   * Get scale
   * @return scale
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Scale getScale() {
    return scale;
  }

  public void setScale(Scale scale) {
    this.scale = scale;
  }

  public VariableBaseClass scientist(String scientist) {
    this.scientist = scientist;
    return this;
  }

  /**
   * Name of scientist submitting the variable.
   * @return scientist
  **/
  @ApiModelProperty(value = "Name of scientist submitting the variable.")


  public String getScientist() {
    return scientist;
  }

  public void setScientist(String scientist) {
    this.scientist = scientist;
  }

  public VariableBaseClass status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Variable status. (examples: \"recommended\", \"obsolete\", \"legacy\", etc.)
   * @return status
  **/
  @ApiModelProperty(value = "Variable status. (examples: \"recommended\", \"obsolete\", \"legacy\", etc.)")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public VariableBaseClass submissionTimestamp(OffsetDateTime submissionTimestamp) {
    this.submissionTimestamp = submissionTimestamp;
    return this;
  }

  /**
   * Timestamp when the Variable was added (ISO 8601)
   * @return submissionTimestamp
  **/
  @ApiModelProperty(value = "Timestamp when the Variable was added (ISO 8601)")

  @Valid

  public OffsetDateTime getSubmissionTimestamp() {
    return submissionTimestamp;
  }

  public void setSubmissionTimestamp(OffsetDateTime submissionTimestamp) {
    this.submissionTimestamp = submissionTimestamp;
  }

  public VariableBaseClass synonyms(List<String> synonyms) {
    this.synonyms = synonyms;
    return this;
  }

  public VariableBaseClass addSynonymsItem(String synonymsItem) {
    if (this.synonyms == null) {
      this.synonyms = new ArrayList<String>();
    }
    this.synonyms.add(synonymsItem);
    return this;
  }

  /**
   * Other variable names
   * @return synonyms
  **/
  @ApiModelProperty(value = "Other variable names")


  public List<String> getSynonyms() {
    return synonyms;
  }

  public void setSynonyms(List<String> synonyms) {
    this.synonyms = synonyms;
  }

  public VariableBaseClass trait(Trait trait) {
    this.trait = trait;
    return this;
  }

  /**
   * Get trait
   * @return trait
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Trait getTrait() {
    return trait;
  }

  public void setTrait(Trait trait) {
    this.trait = trait;
  }

  public VariableBaseClass xref(String xref) {
    this.xref = xref;
    return this;
  }

  /**
   * Cross reference of the variable term to a term from an external ontology or to a database of a major system.
   * @return xref
  **/
  @ApiModelProperty(value = "Cross reference of the variable term to a term from an external ontology or to a database of a major system.")


  public String getXref() {
    return xref;
  }

  public void setXref(String xref) {
    this.xref = xref;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VariableBaseClass variableBaseClass = (VariableBaseClass) o;
    return Objects.equals(this.contextOfUse, variableBaseClass.contextOfUse) &&
        Objects.equals(this.crop, variableBaseClass.crop) &&
        Objects.equals(this.defaultValue, variableBaseClass.defaultValue) &&
        Objects.equals(this.documentationURL, variableBaseClass.documentationURL) &&
        Objects.equals(this.growthStage, variableBaseClass.growthStage) &&
        Objects.equals(this.institution, variableBaseClass.institution) &&
        Objects.equals(this.language, variableBaseClass.language) &&
        Objects.equals(this.method, variableBaseClass.method) &&
        Objects.equals(this.ontologyDbId, variableBaseClass.ontologyDbId) &&
        Objects.equals(this.ontologyName, variableBaseClass.ontologyName) &&
        Objects.equals(this.ontologyReference, variableBaseClass.ontologyReference) &&
        Objects.equals(this.scale, variableBaseClass.scale) &&
        Objects.equals(this.scientist, variableBaseClass.scientist) &&
        Objects.equals(this.status, variableBaseClass.status) &&
        Objects.equals(this.submissionTimestamp, variableBaseClass.submissionTimestamp) &&
        Objects.equals(this.synonyms, variableBaseClass.synonyms) &&
        Objects.equals(this.trait, variableBaseClass.trait) &&
        Objects.equals(this.xref, variableBaseClass.xref);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contextOfUse, crop, defaultValue, documentationURL, growthStage, institution, language, method, ontologyDbId, ontologyName, ontologyReference, scale, scientist, status, submissionTimestamp, synonyms, trait, xref);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VariableBaseClass {\n");
    
    sb.append("    contextOfUse: ").append(toIndentedString(contextOfUse)).append("\n");
    sb.append("    crop: ").append(toIndentedString(crop)).append("\n");
    sb.append("    defaultValue: ").append(toIndentedString(defaultValue)).append("\n");
    sb.append("    documentationURL: ").append(toIndentedString(documentationURL)).append("\n");
    sb.append("    growthStage: ").append(toIndentedString(growthStage)).append("\n");
    sb.append("    institution: ").append(toIndentedString(institution)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    ontologyDbId: ").append(toIndentedString(ontologyDbId)).append("\n");
    sb.append("    ontologyName: ").append(toIndentedString(ontologyName)).append("\n");
    sb.append("    ontologyReference: ").append(toIndentedString(ontologyReference)).append("\n");
    sb.append("    scale: ").append(toIndentedString(scale)).append("\n");
    sb.append("    scientist: ").append(toIndentedString(scientist)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    submissionTimestamp: ").append(toIndentedString(submissionTimestamp)).append("\n");
    sb.append("    synonyms: ").append(toIndentedString(synonyms)).append("\n");
    sb.append("    trait: ").append(toIndentedString(trait)).append("\n");
    sb.append("    xref: ").append(toIndentedString(xref)).append("\n");
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

