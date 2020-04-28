package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;

import org.springframework.validation.annotation.Validated;


/**
 * Scale
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
public class Scale extends ScaleBaseClass  {
  @JsonProperty("scaleDbId")
  private String scaleDbId = null;

  public Scale scaleDbId(String scaleDbId) {
    this.scaleDbId = scaleDbId;
    return this;
  }

  /**
   * Unique identifier of the scale. If left blank, the upload system will automatically generate a scale ID.
   * @return scaleDbId
  **/
  @ApiModelProperty(example = "af730171", required = true, value = "Unique identifier of the scale. If left blank, the upload system will automatically generate a scale ID.")
      

    public String getScaleDbId() {
    return scaleDbId;
  }

  public void setScaleDbId(String scaleDbId) {
    this.scaleDbId = scaleDbId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Scale scale = (Scale) o;
    return Objects.equals(this.scaleDbId, scale.scaleDbId) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(scaleDbId, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Scale {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    scaleDbId: ").append(toIndentedString(scaleDbId)).append("\n");
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
