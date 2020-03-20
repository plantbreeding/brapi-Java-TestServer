package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.germ.CrossNewRequest;
import org.springframework.validation.annotation.Validated;

/**
 * Cross
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
public class Cross extends CrossNewRequest  {
  @JsonProperty("crossDbId")
  private String crossDbId = null;

  public Cross crossDbId(String crossDbId) {
    this.crossDbId = crossDbId;
    return this;
  }

  /**
   * the unique identifier for a cross
   * @return crossDbId
  **/
  @ApiModelProperty(example = "d105fd6f", value = "the unique identifier for a cross")
  
    public String getCrossDbId() {
    return crossDbId;
  }

  public void setCrossDbId(String crossDbId) {
    this.crossDbId = crossDbId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cross cross = (Cross) o;
    return Objects.equals(this.crossDbId, cross.crossDbId) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(crossDbId, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Cross {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    crossDbId: ").append(toIndentedString(crossDbId)).append("\n");
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
