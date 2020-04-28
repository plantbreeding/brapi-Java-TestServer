package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;

import org.springframework.validation.annotation.Validated;


/**
 * ObservationVariable
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
public class ObservationVariable extends VariableBaseClass  {
  @JsonProperty("observationVariableDbId")
  private String observationVariableDbId = null;

  @JsonProperty("observationVariableName")
  private String observationVariableName = null;

  public ObservationVariable observationVariableDbId(String observationVariableDbId) {
    this.observationVariableDbId = observationVariableDbId;
    return this;
  }

  /**
   * Variable unique identifier  MIAPPE V1.1 (DM-83) Variable ID - Code used to identify the variable in the data file. We recommend using a variable definition from the Crop Ontology where possible. Otherwise, the Crop Ontology naming convention is recommended: <trait abbreviation>_<method abbreviation>_<scale abbreviation>). A variable ID must be unique within a given investigation.
   * @return observationVariableDbId
  **/
  @ApiModelProperty(example = "b9b7edd1", required = true, value = "Variable unique identifier  MIAPPE V1.1 (DM-83) Variable ID - Code used to identify the variable in the data file. We recommend using a variable definition from the Crop Ontology where possible. Otherwise, the Crop Ontology naming convention is recommended: <trait abbreviation>_<method abbreviation>_<scale abbreviation>). A variable ID must be unique within a given investigation.")
      

    public String getObservationVariableDbId() {
    return observationVariableDbId;
  }

  public void setObservationVariableDbId(String observationVariableDbId) {
    this.observationVariableDbId = observationVariableDbId;
  }

  public ObservationVariable observationVariableName(String observationVariableName) {
    this.observationVariableName = observationVariableName;
    return this;
  }

  /**
   * Variable name (usually a short name)  MIAPPE V1.1 (DM-84) Variable name - Name of the variable.
   * @return observationVariableName
  **/
  @ApiModelProperty(example = "Variable Name", required = true, value = "Variable name (usually a short name)  MIAPPE V1.1 (DM-84) Variable name - Name of the variable.")
      

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
    ObservationVariable observationVariable = (ObservationVariable) o;
    return Objects.equals(this.observationVariableDbId, observationVariable.observationVariableDbId) &&
        Objects.equals(this.observationVariableName, observationVariable.observationVariableName) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(observationVariableDbId, observationVariableName, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObservationVariable {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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
