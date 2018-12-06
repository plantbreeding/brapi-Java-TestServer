package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Person;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PersonsResponseResult
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class PersonsResponseResult   {
  @JsonProperty("data")
  @Valid
  private List<Person> data = null;

  public PersonsResponseResult data(List<Person> data) {
    this.data = data;
    return this;
  }

  public PersonsResponseResult addDataItem(Person dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<Person>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * Array of people
   * @return data
  **/
  @ApiModelProperty(value = "Array of people")

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
    PersonsResponseResult personsResponseResult = (PersonsResponseResult) o;
    return Objects.equals(this.data, personsResponseResult.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonsResponseResult {\n");
    
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

