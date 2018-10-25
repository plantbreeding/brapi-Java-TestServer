package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Method;
import io.swagger.model.OntologyRefernce;
import io.swagger.model.Scale;
import io.swagger.model.Trait;
import io.swagger.model.VariableBaseClass;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ObservationVariable
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-10-25T15:57:44.669-04:00[America/New_York]")

public class ObservationVariable extends VariableBaseClass  {
  @JsonProperty("date")
  private String date = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("observationVariableDbId")
  private String observationVariableDbId = null;

  @JsonProperty("observationVariableName")
  private String observationVariableName = null;

  public ObservationVariable date(String date) {
    this.date = date;
    return this;
  }

  /**
   * DEPRECATED in v1.3 - see \"submissionTimestamp\"
   * @return date
  **/
  @ApiModelProperty(value = "DEPRECATED in v1.3 - see \"submissionTimestamp\"")


  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public ObservationVariable name(String name) {
    this.name = name;
    return this;
  }

  /**
   * DEPRECATED in v1.3 - Use \"observationVariableName\"
   * @return name
  **/
  @ApiModelProperty(value = "DEPRECATED in v1.3 - Use \"observationVariableName\"")


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

  public ObservationVariable observationVariableName(String observationVariableName) {
    this.observationVariableName = observationVariableName;
    return this;
  }

  /**
   * Variable name (usually a short name)
   * @return observationVariableName
  **/
  @ApiModelProperty(required = true, value = "Variable name (usually a short name)")
  @NotNull


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
    return Objects.equals(this.date, observationVariable.date) &&
        Objects.equals(this.name, observationVariable.name) &&
        Objects.equals(this.observationVariableDbId, observationVariable.observationVariableDbId) &&
        Objects.equals(this.observationVariableName, observationVariable.observationVariableName) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, name, observationVariableDbId, observationVariableName, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObservationVariable {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

