package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * ObservationSummary
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class ObservationSummary   {
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

  @JsonProperty("value")
  private String value = null;

  public ObservationSummary collector(String collector) {
    this.collector = collector;
    return this;
  }

   /**
   * The name or identifier of the entity which collected the observation
   * @return collector
  **/
  @ApiModelProperty(value = "The name or identifier of the entity which collected the observation")


  public String getCollector() {
    return collector;
  }

  public void setCollector(String collector) {
    this.collector = collector;
  }

  public ObservationSummary observationDbId(String observationDbId) {
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

  public ObservationSummary observationTimeStamp(OffsetDateTime observationTimeStamp) {
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

  public ObservationSummary observationVariableDbId(String observationVariableDbId) {
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

  public ObservationSummary observationVariableName(String observationVariableName) {
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

  public ObservationSummary value(String value) {
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
    ObservationSummary observationSummary = (ObservationSummary) o;
    return Objects.equals(this.collector, observationSummary.collector) &&
        Objects.equals(this.observationDbId, observationSummary.observationDbId) &&
        Objects.equals(this.observationTimeStamp, observationSummary.observationTimeStamp) &&
        Objects.equals(this.observationVariableDbId, observationSummary.observationVariableDbId) &&
        Objects.equals(this.observationVariableName, observationSummary.observationVariableName) &&
        Objects.equals(this.value, observationSummary.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(collector, observationDbId, observationTimeStamp, observationVariableDbId, observationVariableName, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObservationSummary {\n");
    
    sb.append("    collector: ").append(toIndentedString(collector)).append("\n");
    sb.append("    observationDbId: ").append(toIndentedString(observationDbId)).append("\n");
    sb.append("    observationTimeStamp: ").append(toIndentedString(observationTimeStamp)).append("\n");
    sb.append("    observationVariableDbId: ").append(toIndentedString(observationVariableDbId)).append("\n");
    sb.append("    observationVariableName: ").append(toIndentedString(observationVariableName)).append("\n");
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

