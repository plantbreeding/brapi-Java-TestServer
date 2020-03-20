package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * ObservationTableObservationVariables
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
public class ObservationTableObservationVariables   {
  @JsonProperty("observationVariableDbId")
  private String observationVariableDbId = null;

  @JsonProperty("observationVariableName")
  private String observationVariableName = null;

  public ObservationTableObservationVariables observationVariableDbId(String observationVariableDbId) {
    this.observationVariableDbId = observationVariableDbId;
    return this;
  }

  /**
   * Variable unique identifier
   * @return observationVariableDbId
  **/
  @ApiModelProperty(example = "367aa1a9", value = "Variable unique identifier")
  
    public String getObservationVariableDbId() {
    return observationVariableDbId;
  }

  public void setObservationVariableDbId(String observationVariableDbId) {
    this.observationVariableDbId = observationVariableDbId;
  }

  public ObservationTableObservationVariables observationVariableName(String observationVariableName) {
    this.observationVariableName = observationVariableName;
    return this;
  }

  /**
   * Variable name (usually a short name)
   * @return observationVariableName
  **/
  @ApiModelProperty(example = "Plant height", value = "Variable name (usually a short name)")
  
    public String getObservationVariableName() {
    return observationVariableName;
  }

  public void setObservationVariableName(String observationVariableName) {
    this.observationVariableName = observationVariableName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObservationTableObservationVariables observationTableObservationVariables = (ObservationTableObservationVariables) o;
    return Objects.equals(this.observationVariableDbId, observationTableObservationVariables.observationVariableDbId) &&
        Objects.equals(this.observationVariableName, observationTableObservationVariables.observationVariableName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(observationVariableDbId, observationVariableName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObservationTableObservationVariables {\n");
    
    sb.append("    observationVariableDbId: ").append(toIndentedString(observationVariableDbId)).append("\n");
    sb.append("    observationVariableName: ").append(toIndentedString(observationVariableName)).append("\n");
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
