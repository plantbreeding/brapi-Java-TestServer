package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Observation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class Observation   {
  @JsonProperty("germplasmDbId")
  private String germplasmDbId = null;

  @JsonProperty("germplasmName")
  private String germplasmName = null;

  @JsonProperty("observationDbId")
  private String observationDbId = null;

  @JsonProperty("observationLevel")
  private String observationLevel = null;

  @JsonProperty("observationTimestamp")
  private OffsetDateTime observationTimeStamp = null;

  @JsonProperty("observationUnitDbId")
  private String observationUnitDbId = null;

  @JsonProperty("observationUnitName")
  private String observationUnitName = null;

  @JsonProperty("observationVariableDbId")
  private String observationVariableDbId = null;

  @JsonProperty("observationVariableName")
  private String observationVariableName = null;

  @JsonProperty("operator")
  private String operator = null;

  @JsonProperty("studyDbId")
  private String studyDbId = null;

  @JsonProperty("uploadedBy")
  private String uploadedBy = null;

  @JsonProperty("value")
  private String value = null;

  public Observation germplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
    return this;
  }

   /**
   *  The ID which uniquely identifies a germplasm
   * @return germplasmDbId
  **/
  @ApiModelProperty(value = " The ID which uniquely identifies a germplasm")


  public String getGermplasmDbId() {
    return germplasmDbId;
  }

  public void setGermplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
  }

  public Observation germplasmName(String germplasmName) {
    this.germplasmName = germplasmName;
    return this;
  }

   /**
   * Name of the germplasm. It can be the prefered name and does not have to be unique.
   * @return germplasmName
  **/
  @ApiModelProperty(value = "Name of the germplasm. It can be the prefered name and does not have to be unique.")


  public String getGermplasmName() {
    return germplasmName;
  }

  public void setGermplasmName(String germplasmName) {
    this.germplasmName = germplasmName;
  }

  public Observation observationDbId(String observationDbId) {
    this.observationDbId = observationDbId;
    return this;
  }

   /**
   * The ID which uniquely identifies an observation
   * @return observationDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies an observation")


  public String getObservationDbId() {
    return observationDbId;
  }

  public void setObservationDbId(String observationDbId) {
    this.observationDbId = observationDbId;
  }

  public Observation observationLevel(String observationLevel) {
    this.observationLevel = observationLevel;
    return this;
  }

   /**
   * The level of an observation unit. ex. \"plot\", \"plant\"
   * @return observationLevel
  **/
  @ApiModelProperty(value = "The level of an observation unit. ex. \"plot\", \"plant\"")


  public String getObservationLevel() {
    return observationLevel;
  }

  public void setObservationLevel(String observationLevel) {
    this.observationLevel = observationLevel;
  }

  public Observation observationTimeStamp(OffsetDateTime observationTimeStamp) {
    this.observationTimeStamp = observationTimeStamp;
    return this;
  }

   /**
   * The date and time  when this observation was made 
   * @return observationTimeStamp
  **/
  @ApiModelProperty(value = "The date and time  when this observation was made ")

  @Valid

  public OffsetDateTime getObservationTimeStamp() {
    return observationTimeStamp;
  }

  public void setObservationTimeStamp(OffsetDateTime observationTimeStamp) {
    this.observationTimeStamp = observationTimeStamp;
  }

  public Observation observationUnitDbId(String observationUnitDbId) {
    this.observationUnitDbId = observationUnitDbId;
    return this;
  }

   /**
   * The ID which uniquely identifies an observation unit
   * @return observationUnitDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies an observation unit")


  public String getObservationUnitDbId() {
    return observationUnitDbId;
  }

  public void setObservationUnitDbId(String observationUnitDbId) {
    this.observationUnitDbId = observationUnitDbId;
  }

  public Observation observationUnitName(String observationUnitName) {
    this.observationUnitName = observationUnitName;
    return this;
  }

   /**
   * A human readable name for an observation unit
   * @return observationUnitName
  **/
  @ApiModelProperty(value = "A human readable name for an observation unit")


  public String getObservationUnitName() {
    return observationUnitName;
  }

  public void setObservationUnitName(String observationUnitName) {
    this.observationUnitName = observationUnitName;
  }

  public Observation observationVariableDbId(String observationVariableDbId) {
    this.observationVariableDbId = observationVariableDbId;
    return this;
  }

   /**
   * The ID which uniquely identifies an observation variable
   * @return observationVariableDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies an observation variable")


  public String getObservationVariableDbId() {
    return observationVariableDbId;
  }

  public void setObservationVariableDbId(String observationVariableDbId) {
    this.observationVariableDbId = observationVariableDbId;
  }

  public Observation observationVariableName(String observationVariableName) {
    this.observationVariableName = observationVariableName;
    return this;
  }

   /**
   * A human readable name for an observation variable
   * @return observationVariableName
  **/
  @ApiModelProperty(value = "A human readable name for an observation variable")


  public String getObservationVariableName() {
    return observationVariableName;
  }

  public void setObservationVariableName(String observationVariableName) {
    this.observationVariableName = observationVariableName;
  }

  public Observation operator(String operator) {
    this.operator = operator;
    return this;
  }

   /**
   * The name or identifier of the entity which collected the observation
   * @return operator
  **/
  @ApiModelProperty(value = "The name or identifier of the entity which collected the observation")


  public String getOperator() {
    return operator;
  }

  public void setOperator(String operator) {
    this.operator = operator;
  }

  public Observation studyDbId(String studyDbId) {
    this.studyDbId = studyDbId;
    return this;
  }

   /**
   * The ID which uniquely identifies a study within the given database server
   * @return studyDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies a study within the given database server")


  public String getStudyDbId() {
    return studyDbId;
  }

  public void setStudyDbId(String studyDbId) {
    this.studyDbId = studyDbId;
  }

  public Observation uploadedBy(String uploadedBy) {
    this.uploadedBy = uploadedBy;
    return this;
  }

   /**
   * The name or id of the user who uploaded the observation to the database system
   * @return uploadedBy
  **/
  @ApiModelProperty(value = "The name or id of the user who uploaded the observation to the database system")


  public String getUploadedBy() {
    return uploadedBy;
  }

  public void setUploadedBy(String uploadedBy) {
    this.uploadedBy = uploadedBy;
  }

  public Observation value(String value) {
    this.value = value;
    return this;
  }

   /**
   * The value of the data collected as an observation
   * @return value
  **/
  @ApiModelProperty(value = "The value of the data collected as an observation")


  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Observation observation = (Observation) o;
    return Objects.equals(this.germplasmDbId, observation.germplasmDbId) &&
        Objects.equals(this.germplasmName, observation.germplasmName) &&
        Objects.equals(this.observationDbId, observation.observationDbId) &&
        Objects.equals(this.observationLevel, observation.observationLevel) &&
        Objects.equals(this.observationTimeStamp, observation.observationTimeStamp) &&
        Objects.equals(this.observationUnitDbId, observation.observationUnitDbId) &&
        Objects.equals(this.observationUnitName, observation.observationUnitName) &&
        Objects.equals(this.observationVariableDbId, observation.observationVariableDbId) &&
        Objects.equals(this.observationVariableName, observation.observationVariableName) &&
        Objects.equals(this.operator, observation.operator) &&
        Objects.equals(this.studyDbId, observation.studyDbId) &&
        Objects.equals(this.uploadedBy, observation.uploadedBy) &&
        Objects.equals(this.value, observation.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(germplasmDbId, germplasmName, observationDbId, observationLevel, observationTimeStamp, observationUnitDbId, observationUnitName, observationVariableDbId, observationVariableName, operator, studyDbId, uploadedBy, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Observation {\n");
    
    sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
    sb.append("    germplasmName: ").append(toIndentedString(germplasmName)).append("\n");
    sb.append("    observationDbId: ").append(toIndentedString(observationDbId)).append("\n");
    sb.append("    observationLevel: ").append(toIndentedString(observationLevel)).append("\n");
    sb.append("    observationTimeStamp: ").append(toIndentedString(observationTimeStamp)).append("\n");
    sb.append("    observationUnitDbId: ").append(toIndentedString(observationUnitDbId)).append("\n");
    sb.append("    observationUnitName: ").append(toIndentedString(observationUnitName)).append("\n");
    sb.append("    observationVariableDbId: ").append(toIndentedString(observationVariableDbId)).append("\n");
    sb.append("    observationVariableName: ").append(toIndentedString(observationVariableName)).append("\n");
    sb.append("    operator: ").append(toIndentedString(operator)).append("\n");
    sb.append("    studyDbId: ").append(toIndentedString(studyDbId)).append("\n");
    sb.append("    uploadedBy: ").append(toIndentedString(uploadedBy)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

