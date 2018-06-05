package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PhenotypesRequestObservation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class PhenotypesRequestObservation   {
  @JsonProperty("collector")
  private String collector = null;

  @JsonProperty("observationDbId")
  private String observationDbId = null;

  @JsonProperty("observationTimeStamp")
  private OffsetDateTime observationTimeStamp = null;

  @JsonProperty("observationVariableDbId")
  private String observationVariableDbId = null;

  @JsonProperty("observationVariableName")
  private String observationVariableName = null;

  @JsonProperty("season")
  private String season = null;

  @JsonProperty("value")
  private String value = null;

  public PhenotypesRequestObservation collector(String collector) {
    this.collector = collector;
    return this;
  }

   /**
   * The name or identifier of the entity which collected the observation
   * @return collector
  **/
  @ApiModelProperty(required = true, value = "The name or identifier of the entity which collected the observation")
  @NotNull


  public String getCollector() {
    return collector;
  }

  public void setCollector(String collector) {
    this.collector = collector;
  }

  public PhenotypesRequestObservation observationDbId(String observationDbId) {
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

  public PhenotypesRequestObservation observationTimeStamp(OffsetDateTime observationTimeStamp) {
    this.observationTimeStamp = observationTimeStamp;
    return this;
  }

   /**
   * The date and time  when this observation was made 
   * @return observationTimeStamp
  **/
  @ApiModelProperty(required = true, value = "The date and time  when this observation was made ")
  @NotNull

  @Valid

  public OffsetDateTime getObservationTimeStamp() {
    return observationTimeStamp;
  }

  public void setObservationTimeStamp(OffsetDateTime observationTimeStamp) {
    this.observationTimeStamp = observationTimeStamp;
  }

  public PhenotypesRequestObservation observationVariableDbId(String observationVariableDbId) {
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

  public PhenotypesRequestObservation observationVariableName(String observationVariableName) {
    this.observationVariableName = observationVariableName;
    return this;
  }

   /**
   * A human readable name for an observation variable
   * @return observationVariableName
  **/
  @ApiModelProperty(required = true, value = "A human readable name for an observation variable")
  @NotNull


  public String getObservationVariableName() {
    return observationVariableName;
  }

  public void setObservationVariableName(String observationVariableName) {
    this.observationVariableName = observationVariableName;
  }

  public PhenotypesRequestObservation season(String season) {
    this.season = season;
    return this;
  }

   /**
   * The season when the observation data was collected
   * @return season
  **/
  @ApiModelProperty(value = "The season when the observation data was collected")


  public String getSeason() {
    return season;
  }

  public void setSeason(String season) {
    this.season = season;
  }

  public PhenotypesRequestObservation value(String value) {
    this.value = value;
    return this;
  }

   /**
   * The value of the data collected as an observation
   * @return value
  **/
  @ApiModelProperty(required = true, value = "The value of the data collected as an observation")
  @NotNull


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
    PhenotypesRequestObservation phenotypesRequestObservation = (PhenotypesRequestObservation) o;
    return Objects.equals(this.collector, phenotypesRequestObservation.collector) &&
        Objects.equals(this.observationDbId, phenotypesRequestObservation.observationDbId) &&
        Objects.equals(this.observationTimeStamp, phenotypesRequestObservation.observationTimeStamp) &&
        Objects.equals(this.observationVariableDbId, phenotypesRequestObservation.observationVariableDbId) &&
        Objects.equals(this.observationVariableName, phenotypesRequestObservation.observationVariableName) &&
        Objects.equals(this.season, phenotypesRequestObservation.season) &&
        Objects.equals(this.value, phenotypesRequestObservation.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(collector, observationDbId, observationTimeStamp, observationVariableDbId, observationVariableName, season, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PhenotypesRequestObservation {\n");
    
    sb.append("    collector: ").append(toIndentedString(collector)).append("\n");
    sb.append("    observationDbId: ").append(toIndentedString(observationDbId)).append("\n");
    sb.append("    observationTimeStamp: ").append(toIndentedString(observationTimeStamp)).append("\n");
    sb.append("    observationVariableDbId: ").append(toIndentedString(observationVariableDbId)).append("\n");
    sb.append("    observationVariableName: ").append(toIndentedString(observationVariableName)).append("\n");
    sb.append("    season: ").append(toIndentedString(season)).append("\n");
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

