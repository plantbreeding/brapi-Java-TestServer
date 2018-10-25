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
 * NewObservationsRequestObservations
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-10-25T15:57:44.669-04:00[America/New_York]")

public class NewObservationsRequestObservations   {
  @JsonProperty("collector")
  private String collector = null;

  @JsonProperty("observationDbId")
  private String observationDbId = null;

  @JsonProperty("observationTimeStamp")
  private OffsetDateTime observationTimeStamp = null;

  @JsonProperty("observationUnitDbId")
  private String observationUnitDbId = null;

  @JsonProperty("observationVariableDbId")
  private String observationVariableDbId = null;

  @JsonProperty("value")
  private String value = null;

  public NewObservationsRequestObservations collector(String collector) {
    this.collector = collector;
    return this;
  }

  /**
   * Get collector
   * @return collector
  **/
  @ApiModelProperty(value = "")


  public String getCollector() {
    return collector;
  }

  public void setCollector(String collector) {
    this.collector = collector;
  }

  public NewObservationsRequestObservations observationDbId(String observationDbId) {
    this.observationDbId = observationDbId;
    return this;
  }

  /**
   * Get observationDbId
   * @return observationDbId
  **/
  @ApiModelProperty(value = "")


  public String getObservationDbId() {
    return observationDbId;
  }

  public void setObservationDbId(String observationDbId) {
    this.observationDbId = observationDbId;
  }

  public NewObservationsRequestObservations observationTimeStamp(OffsetDateTime observationTimeStamp) {
    this.observationTimeStamp = observationTimeStamp;
    return this;
  }

  /**
   * Get observationTimeStamp
   * @return observationTimeStamp
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getObservationTimeStamp() {
    return observationTimeStamp;
  }

  public void setObservationTimeStamp(OffsetDateTime observationTimeStamp) {
    this.observationTimeStamp = observationTimeStamp;
  }

  public NewObservationsRequestObservations observationUnitDbId(String observationUnitDbId) {
    this.observationUnitDbId = observationUnitDbId;
    return this;
  }

  /**
   * Get observationUnitDbId
   * @return observationUnitDbId
  **/
  @ApiModelProperty(value = "")


  public String getObservationUnitDbId() {
    return observationUnitDbId;
  }

  public void setObservationUnitDbId(String observationUnitDbId) {
    this.observationUnitDbId = observationUnitDbId;
  }

  public NewObservationsRequestObservations observationVariableDbId(String observationVariableDbId) {
    this.observationVariableDbId = observationVariableDbId;
    return this;
  }

  /**
   * Get observationVariableDbId
   * @return observationVariableDbId
  **/
  @ApiModelProperty(value = "")


  public String getObservationVariableDbId() {
    return observationVariableDbId;
  }

  public void setObservationVariableDbId(String observationVariableDbId) {
    this.observationVariableDbId = observationVariableDbId;
  }

  public NewObservationsRequestObservations value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
  **/
  @ApiModelProperty(value = "")


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
    NewObservationsRequestObservations newObservationsRequestObservations = (NewObservationsRequestObservations) o;
    return Objects.equals(this.collector, newObservationsRequestObservations.collector) &&
        Objects.equals(this.observationDbId, newObservationsRequestObservations.observationDbId) &&
        Objects.equals(this.observationTimeStamp, newObservationsRequestObservations.observationTimeStamp) &&
        Objects.equals(this.observationUnitDbId, newObservationsRequestObservations.observationUnitDbId) &&
        Objects.equals(this.observationVariableDbId, newObservationsRequestObservations.observationVariableDbId) &&
        Objects.equals(this.value, newObservationsRequestObservations.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(collector, observationDbId, observationTimeStamp, observationUnitDbId, observationVariableDbId, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewObservationsRequestObservations {\n");
    
    sb.append("    collector: ").append(toIndentedString(collector)).append("\n");
    sb.append("    observationDbId: ").append(toIndentedString(observationDbId)).append("\n");
    sb.append("    observationTimeStamp: ").append(toIndentedString(observationTimeStamp)).append("\n");
    sb.append("    observationUnitDbId: ").append(toIndentedString(observationUnitDbId)).append("\n");
    sb.append("    observationVariableDbId: ").append(toIndentedString(observationVariableDbId)).append("\n");
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

