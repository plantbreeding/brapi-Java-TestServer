package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * &#x60;ListValue&#x60; is a wrapper around a repeated field of values.  The JSON representation for &#x60;ListValue&#x60; is JSON array.
 */
@ApiModel(description = "`ListValue` is a wrapper around a repeated field of values.  The JSON representation for `ListValue` is JSON array.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
public class ListValue   {
  @JsonProperty("values")
  @Valid
  private List<OneOfListValueValuesItems> values = null;

  public ListValue values(List<OneOfListValueValuesItems> values) {
    this.values = values;
    return this;
  }

  public ListValue addValuesItem(OneOfListValueValuesItems valuesItem) {
    if (this.values == null) {
      this.values = new ArrayList<OneOfListValueValuesItems>();
    }
    this.values.add(valuesItem);
    return this;
  }

  /**
   * Repeated field of dynamically typed values.
   * @return values
  **/
  @ApiModelProperty(example = "[\"AA\"]", value = "Repeated field of dynamically typed values.")
  
    public List<OneOfListValueValuesItems> getValues() {
    return values;
  }

  public void setValues(List<OneOfListValueValuesItems> values) {
    this.values = values;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListValue listValue = (ListValue) o;
    return Objects.equals(this.values, listValue.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListValue {\n");
    
    sb.append("    values: ").append(toIndentedString(values)).append("\n");
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
