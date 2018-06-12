package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Method;
import io.swagger.model.Scale;
import io.swagger.model.Trait;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ObservationVariable
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class ObservationVariable   {
  @JsonProperty("contextOfUse")
  @Valid
  private List<String> contextOfUse = null;

  @JsonProperty("crop")
  private String crop = null;

  @JsonProperty("date")
  private String date = null;

  @JsonProperty("defaultValue")
  private String defaultValue = null;

  @JsonProperty("growthStage")
  private String growthStage = null;

  @JsonProperty("institution")
  private String institution = null;

  @JsonProperty("language")
  private String language = null;

  @JsonProperty("method")
  private Method method = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("observationVariableDbId")
  private String observationVariableDbId = null;

  @JsonProperty("ontologyDbId")
  private String ontologyDbId = null;

  @JsonProperty("ontologyName")
  private String ontologyName = null;

  @JsonProperty("scale")
  private Scale scale = null;

  @JsonProperty("scientist")
  private String scientist = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("submissionTimestamp")
  private OffsetDateTime submissionTimeStamp = null;

  @JsonProperty("synonyms")
  @Valid
  private List<String> synonyms = null;

  @JsonProperty("trait")
  private Trait trait = null;

  @JsonProperty("xref")
  private String xref = null;

  public ObservationVariable contextOfUse(List<String> contextOfUse) {
    this.contextOfUse = contextOfUse;
    return this;
  }

  public ObservationVariable addContextOfUseItem(String contextOfUseItem) {
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

  public ObservationVariable crop(String crop) {
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

  public ObservationVariable date(String date) {
    this.date = date;
    return this;
  }

   /**
   * Date of submission of the variable (ISO 8601).
   * @return date
  **/
  @ApiModelProperty(value = "Date of submission of the variable (ISO 8601).")


  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public ObservationVariable defaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
    return this;
  }

   /**
   * Variable default value. (examples: \"red\", \"2.3\", etc.)
   * @return defaultValue
  **/
  @ApiModelProperty(required = true, value = "Variable default value. (examples: \"red\", \"2.3\", etc.)")
  @NotNull


  public String getDefaultValue() {
    return defaultValue;
  }

  public void setDefaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
  }

  public ObservationVariable growthStage(String growthStage) {
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

  public ObservationVariable institution(String institution) {
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

  public ObservationVariable language(String language) {
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

  public ObservationVariable method(Method method) {
    this.method = method;
    return this;
  }

   /**
   * The description of the method used to collect data for this variable
   * @return method
  **/
  @ApiModelProperty(required = true, value = "The description of the method used to collect data for this variable")
  @NotNull

  @Valid

  public Method getMethod() {
    return method;
  }

  public void setMethod(Method method) {
    this.method = method;
  }

  public ObservationVariable name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Variable name (usually a short name)
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Variable name (usually a short name)")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ObservationVariable observationVariableDbId(String observationVariableDbId) {
    this.observationVariableDbId = observationVariableDbId;
    return this;
  }

   /**
   * Variable unique identifier
   * @return observationVariableDbId
  **/
  @ApiModelProperty(required = true, value = "Variable unique identifier")
  @NotNull


  public String getObservationVariableDbId() {
    return observationVariableDbId;
  }

  public void setObservationVariableDbId(String observationVariableDbId) {
    this.observationVariableDbId = observationVariableDbId;
  }

  public ObservationVariable ontologyDbId(String ontologyDbId) {
    this.ontologyDbId = ontologyDbId;
    return this;
  }

   /**
   * Variable ontology unique identifier
   * @return ontologyDbId
  **/
  @ApiModelProperty(required = true, value = "Variable ontology unique identifier")
  @NotNull


  public String getOntologyDbId() {
    return ontologyDbId;
  }

  public void setOntologyDbId(String ontologyDbId) {
    this.ontologyDbId = ontologyDbId;
  }

  public ObservationVariable ontologyName(String ontologyName) {
    this.ontologyName = ontologyName;
    return this;
  }

   /**
   * Variable ontology name (usually a short name)
   * @return ontologyName
  **/
  @ApiModelProperty(required = true, value = "Variable ontology name (usually a short name)")
  @NotNull


  public String getOntologyName() {
    return ontologyName;
  }

  public void setOntologyName(String ontologyName) {
    this.ontologyName = ontologyName;
  }

  public ObservationVariable scale(Scale scale) {
    this.scale = scale;
    return this;
  }

   /**
   * The description of the reference scale and units used on the collected data for this variable
   * @return scale
  **/
  @ApiModelProperty(required = true, value = "The description of the reference scale and units used on the collected data for this variable")
  @NotNull

  @Valid

  public Scale getScale() {
    return scale;
  }

  public void setScale(Scale scale) {
    this.scale = scale;
  }

  public ObservationVariable scientist(String scientist) {
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

  public ObservationVariable status(String status) {
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

  public ObservationVariable submissionTimeStamp(OffsetDateTime submissionTimeStamp) {
    this.submissionTimeStamp = submissionTimeStamp;
    return this;
  }

   /**
   * Timestamp when the Variable was added
   * @return submissionTimeStamp
  **/
  @ApiModelProperty(value = "Timestamp when the Variable was added")

  @Valid

  public OffsetDateTime getSubmissionTimeStamp() {
    return submissionTimeStamp;
  }

  public void setSubmissionTimeStamp(OffsetDateTime submissionTimeStamp) {
    this.submissionTimeStamp = submissionTimeStamp;
  }

  public ObservationVariable synonyms(List<String> synonyms) {
    this.synonyms = synonyms;
    return this;
  }

  public ObservationVariable addSynonymsItem(String synonymsItem) {
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

  public ObservationVariable trait(Trait trait) {
    this.trait = trait;
    return this;
  }

   /**
   * The description of the trait which is being examined for this variable
   * @return trait
  **/
  @ApiModelProperty(required = true, value = "The description of the trait which is being examined for this variable")
  @NotNull

  @Valid

  public Trait getTrait() {
    return trait;
  }

  public void setTrait(Trait trait) {
    this.trait = trait;
  }

  public ObservationVariable xref(String xref) {
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
    ObservationVariable observationVariable = (ObservationVariable) o;
    return Objects.equals(this.contextOfUse, observationVariable.contextOfUse) &&
        Objects.equals(this.crop, observationVariable.crop) &&
        Objects.equals(this.date, observationVariable.date) &&
        Objects.equals(this.defaultValue, observationVariable.defaultValue) &&
        Objects.equals(this.growthStage, observationVariable.growthStage) &&
        Objects.equals(this.institution, observationVariable.institution) &&
        Objects.equals(this.language, observationVariable.language) &&
        Objects.equals(this.method, observationVariable.method) &&
        Objects.equals(this.name, observationVariable.name) &&
        Objects.equals(this.observationVariableDbId, observationVariable.observationVariableDbId) &&
        Objects.equals(this.ontologyDbId, observationVariable.ontologyDbId) &&
        Objects.equals(this.ontologyName, observationVariable.ontologyName) &&
        Objects.equals(this.scale, observationVariable.scale) &&
        Objects.equals(this.scientist, observationVariable.scientist) &&
        Objects.equals(this.status, observationVariable.status) &&
        Objects.equals(this.submissionTimeStamp, observationVariable.submissionTimeStamp) &&
        Objects.equals(this.synonyms, observationVariable.synonyms) &&
        Objects.equals(this.trait, observationVariable.trait) &&
        Objects.equals(this.xref, observationVariable.xref);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contextOfUse, crop, date, defaultValue, growthStage, institution, language, method, name, observationVariableDbId, ontologyDbId, ontologyName, scale, scientist, status, submissionTimeStamp, synonyms, trait, xref);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObservationVariable {\n");
    
    sb.append("    contextOfUse: ").append(toIndentedString(contextOfUse)).append("\n");
    sb.append("    crop: ").append(toIndentedString(crop)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    defaultValue: ").append(toIndentedString(defaultValue)).append("\n");
    sb.append("    growthStage: ").append(toIndentedString(growthStage)).append("\n");
    sb.append("    institution: ").append(toIndentedString(institution)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    observationVariableDbId: ").append(toIndentedString(observationVariableDbId)).append("\n");
    sb.append("    ontologyDbId: ").append(toIndentedString(ontologyDbId)).append("\n");
    sb.append("    ontologyName: ").append(toIndentedString(ontologyName)).append("\n");
    sb.append("    scale: ").append(toIndentedString(scale)).append("\n");
    sb.append("    scientist: ").append(toIndentedString(scientist)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    submissionTimeStamp: ").append(toIndentedString(submissionTimeStamp)).append("\n");
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

