package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.pheno.ObservationUnitHierarchyLevel;
import org.springframework.validation.annotation.Validated;

/**
 * ObservationUnitLevelRelationship
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
public class ObservationUnitLevelRelationship extends ObservationUnitHierarchyLevel  {
  @JsonProperty("levelCode")
  private String levelCode = null;

  public ObservationUnitLevelRelationship levelCode(String levelCode) {
    this.levelCode = levelCode;
    return this;
  }

  /**
   * An ID code for this level tag. Identify this observation unit by each level of the hierarchy where it exists
   * @return levelCode
  **/
  @ApiModelProperty(example = "Plot_123", value = "An ID code for this level tag. Identify this observation unit by each level of the hierarchy where it exists")
  
    public String getLevelCode() {
    return levelCode;
  }

  public void setLevelCode(String levelCode) {
    this.levelCode = levelCode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObservationUnitLevelRelationship observationUnitLevelRelationship = (ObservationUnitLevelRelationship) o;
    return Objects.equals(this.levelCode, observationUnitLevelRelationship.levelCode) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(levelCode, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObservationUnitLevelRelationship {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    levelCode: ").append(toIndentedString(levelCode)).append("\n");
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
