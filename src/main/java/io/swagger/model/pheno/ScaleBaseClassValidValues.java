package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.pheno.ScaleBaseClassValidValuesCategories;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * ScaleBaseClassValidValues
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class ScaleBaseClassValidValues   {
  @JsonProperty("categories")
  @Valid
  private List<ScaleBaseClassValidValuesCategories> categories = null;

  @JsonProperty("max")
  private Integer max = null;

  @JsonProperty("min")
  private Integer min = null;

  public ScaleBaseClassValidValues categories(List<ScaleBaseClassValidValuesCategories> categories) {
    this.categories = categories;
    return this;
  }

  public ScaleBaseClassValidValues addCategoriesItem(ScaleBaseClassValidValuesCategories categoriesItem) {
    if (this.categories == null) {
      this.categories = new ArrayList<ScaleBaseClassValidValuesCategories>();
    }
    this.categories.add(categoriesItem);
    return this;
  }

  /**
   * List of possible values with optional labels
   * @return categories
  **/
  @ApiModelProperty(example = "[{\"label\":\"low\",\"value\":\"0\"},{\"label\":\"medium\",\"value\":\"5\"},{\"label\":\"high\",\"value\":\"10\"}]", value = "List of possible values with optional labels")
      @Valid
    public List<ScaleBaseClassValidValuesCategories> getCategories() {
    return categories;
  }

  public void setCategories(List<ScaleBaseClassValidValuesCategories> categories) {
    this.categories = categories;
  }

  public ScaleBaseClassValidValues max(Integer max) {
    this.max = max;
    return this;
  }

  /**
   * Maximum value (used for field data capture control).
   * @return max
  **/
  @ApiModelProperty(example = "9999", value = "Maximum value (used for field data capture control).")
  
    public Integer getMax() {
    return max;
  }

  public void setMax(Integer max) {
    this.max = max;
  }

  public ScaleBaseClassValidValues min(Integer min) {
    this.min = min;
    return this;
  }

  /**
   * Minimum value (used for data capture control) for numerical and date scales
   * @return min
  **/
  @ApiModelProperty(example = "2", value = "Minimum value (used for data capture control) for numerical and date scales")
  
    public Integer getMin() {
    return min;
  }

  public void setMin(Integer min) {
    this.min = min;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ScaleBaseClassValidValues scaleBaseClassValidValues = (ScaleBaseClassValidValues) o;
    return Objects.equals(this.categories, scaleBaseClassValidValues.categories) &&
        Objects.equals(this.max, scaleBaseClassValidValues.max) &&
        Objects.equals(this.min, scaleBaseClassValidValues.min);
  }

  @Override
  public int hashCode() {
    return Objects.hash(categories, max, min);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ScaleBaseClassValidValues {\n");
    
    sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
    sb.append("    max: ").append(toIndentedString(max)).append("\n");
    sb.append("    min: ").append(toIndentedString(min)).append("\n");
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
