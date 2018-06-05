package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * NewObservationDbIdsObservations
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class NewObservationDbIdsObservations   {
  @JsonProperty("observationDbId")
  private String observationDbId = null;

  @JsonProperty("observationUnitDbId")
  private String observationUnitDbId = null;

  @JsonProperty("observationVariableDbId")
  private String observationVariableDbId = null;

  public NewObservationDbIdsObservations observationDbId(String observationDbId) {
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

  public NewObservationDbIdsObservations observationUnitDbId(String observationUnitDbId) {
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

  public NewObservationDbIdsObservations observationVariableDbId(String observationVariableDbId) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NewObservationDbIdsObservations newObservationDbIdsObservations = (NewObservationDbIdsObservations) o;
    return Objects.equals(this.observationDbId, newObservationDbIdsObservations.observationDbId) &&
        Objects.equals(this.observationUnitDbId, newObservationDbIdsObservations.observationUnitDbId) &&
        Objects.equals(this.observationVariableDbId, newObservationDbIdsObservations.observationVariableDbId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(observationDbId, observationUnitDbId, observationVariableDbId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewObservationDbIdsObservations {\n");
    
    sb.append("    observationDbId: ").append(toIndentedString(observationDbId)).append("\n");
    sb.append("    observationUnitDbId: ").append(toIndentedString(observationUnitDbId)).append("\n");
    sb.append("    observationVariableDbId: ").append(toIndentedString(observationVariableDbId)).append("\n");
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

