package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.germ.CrossingProjectNewRequest;
import org.springframework.validation.annotation.Validated;

/**
 * CrossingProject
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
public class CrossingProject extends CrossingProjectNewRequest  {
  @JsonProperty("crossingProjectDbId")
  private String crossingProjectDbId = null;

  public CrossingProject crossingProjectDbId(String crossingProjectDbId) {
    this.crossingProjectDbId = crossingProjectDbId;
    return this;
  }

  /**
   * the unique identifier for a crossing project
   * @return crossingProjectDbId
  **/
  @ApiModelProperty(example = "ce0e1c29", value = "the unique identifier for a crossing project")
  
    public String getCrossingProjectDbId() {
    return crossingProjectDbId;
  }

  public void setCrossingProjectDbId(String crossingProjectDbId) {
    this.crossingProjectDbId = crossingProjectDbId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CrossingProject crossingProject = (CrossingProject) o;
    return Objects.equals(this.crossingProjectDbId, crossingProject.crossingProjectDbId) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(crossingProjectDbId, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CrossingProject {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    crossingProjectDbId: ").append(toIndentedString(crossingProjectDbId)).append("\n");
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
