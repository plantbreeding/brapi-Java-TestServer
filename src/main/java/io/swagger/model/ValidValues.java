package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * ValidValues
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class ValidValues   {
  @JsonProperty("categories")
  @Valid
  private List<String> categories = null;

  @JsonProperty("max")
  private Integer max = null;

  @JsonProperty("min")
  private Integer min = null;

  public ValidValues categories(List<String> categories) {
    this.categories = categories;
    return this;
  }

  public ValidValues addCategoriesItem(String categoriesItem) {
    if (this.categories == null) {
      this.categories = new ArrayList<String>();
    }
    this.categories.add(categoriesItem);
    return this;
  }

   /**
   * List of possible values and their meaning (examples: [\"0=low\", \"1=medium\", \"2=high\"]
   * @return categories
  **/
  @ApiModelProperty(value = "List of possible values and their meaning (examples: [\"0=low\", \"1=medium\", \"2=high\"]")


  public List<String> getCategories() {
    return categories;
  }

  public void setCategories(List<String> categories) {
    this.categories = categories;
  }

  public ValidValues max(Integer max) {
    this.max = max;
    return this;
  }

   /**
   * Maximum value (used for field data capture control).
   * @return max
  **/
  @ApiModelProperty(value = "Maximum value (used for field data capture control).")


  public Integer getMax() {
    return max;
  }

  public void setMax(Integer max) {
    this.max = max;
  }

  public ValidValues min(Integer min) {
    this.min = min;
    return this;
  }

   /**
   * Minimum value (used for data capture control) for numerical and date scales
   * @return min
  **/
  @ApiModelProperty(value = "Minimum value (used for data capture control) for numerical and date scales")


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
    ValidValues validValues = (ValidValues) o;
    return Objects.equals(this.categories, validValues.categories) &&
        Objects.equals(this.max, validValues.max) &&
        Objects.equals(this.min, validValues.min);
  }

  @Override
  public int hashCode() {
    return Objects.hash(categories, max, min);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValidValues {\n");
    
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

