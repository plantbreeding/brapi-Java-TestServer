package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * a custom attributes associated with a cross
 */
@ApiModel(description = "a custom attributes associated with a cross")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
public class CrossNewRequestCrossAttributes   {
  @JsonProperty("crossAttributeName")
  private String crossAttributeName = null;

  @JsonProperty("crossAttributeValue")
  private String crossAttributeValue = null;

  public CrossNewRequestCrossAttributes crossAttributeName(String crossAttributeName) {
    this.crossAttributeName = crossAttributeName;
    return this;
  }

  /**
   * the human readable name of a cross attribute
   * @return crossAttributeName
  **/
  @ApiModelProperty(example = "Humidity Percentage", value = "the human readable name of a cross attribute")
  
    public String getCrossAttributeName() {
    return crossAttributeName;
  }

  public void setCrossAttributeName(String crossAttributeName) {
    this.crossAttributeName = crossAttributeName;
  }

  public CrossNewRequestCrossAttributes crossAttributeValue(String crossAttributeValue) {
    this.crossAttributeValue = crossAttributeValue;
    return this;
  }

  /**
   * the value of a cross attribute
   * @return crossAttributeValue
  **/
  @ApiModelProperty(example = "45", value = "the value of a cross attribute")
  
    public String getCrossAttributeValue() {
    return crossAttributeValue;
  }

  public void setCrossAttributeValue(String crossAttributeValue) {
    this.crossAttributeValue = crossAttributeValue;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CrossNewRequestCrossAttributes crossNewRequestCrossAttributes = (CrossNewRequestCrossAttributes) o;
    return Objects.equals(this.crossAttributeName, crossNewRequestCrossAttributes.crossAttributeName) &&
        Objects.equals(this.crossAttributeValue, crossNewRequestCrossAttributes.crossAttributeValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(crossAttributeName, crossAttributeValue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CrossNewRequestCrossAttributes {\n");
    
    sb.append("    crossAttributeName: ").append(toIndentedString(crossAttributeName)).append("\n");
    sb.append("    crossAttributeValue: ").append(toIndentedString(crossAttributeValue)).append("\n");
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
