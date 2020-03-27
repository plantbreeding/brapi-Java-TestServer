package io.swagger.model.core;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.common.BrAPIResponseResult;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PersonListResponseResult
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class PersonListResponseResult implements BrAPIResponseResult<Person>  {
  @JsonProperty("data")
  @Valid
  private List<Person> data = new ArrayList<Person>();

  public PersonListResponseResult data(List<Person> data) {
    this.data = data;
    return this;
  }

  public PersonListResponseResult addDataItem(Person dataItem) {
    this.data.add(dataItem);
    return this;
  }

  /**
   * Array of people
   * @return data
  **/
  @ApiModelProperty(required = true, value = "Array of people")
      @NotNull
    @Valid
    public List<Person> getData() {
    return data;
  }

  public void setData(List<Person> data) {
    this.data = data;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonListResponseResult personListResponseResult = (PersonListResponseResult) o;
    return Objects.equals(this.data, personListResponseResult.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonListResponseResult {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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
