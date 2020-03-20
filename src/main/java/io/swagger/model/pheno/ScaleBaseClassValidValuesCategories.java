package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * ScaleBaseClassValidValuesCategories
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class ScaleBaseClassValidValuesCategories   {
  @JsonProperty("label")
  private String label = null;

  @JsonProperty("value")
  private String value = null;

  public ScaleBaseClassValidValuesCategories label(String label) {
    this.label = label;
    return this;
  }

  /**
   * A text label for a category
   * @return label
  **/
  @ApiModelProperty(value = "A text label for a category")
  
    public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public ScaleBaseClassValidValuesCategories value(String value) {
    this.value = value;
    return this;
  }

  /**
   * The actual value for a category
   * @return value
  **/
  @ApiModelProperty(value = "The actual value for a category")
  
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
    ScaleBaseClassValidValuesCategories scaleBaseClassValidValuesCategories = (ScaleBaseClassValidValuesCategories) o;
    return Objects.equals(this.label, scaleBaseClassValidValuesCategories.label) &&
        Objects.equals(this.value, scaleBaseClassValidValuesCategories.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(label, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ScaleBaseClassValidValuesCategories {\n");
    
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
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
