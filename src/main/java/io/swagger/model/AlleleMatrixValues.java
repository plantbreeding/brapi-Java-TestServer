package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * AlleleMatrixValues
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class AlleleMatrixValues   {
  @JsonProperty("data")
  @Valid
  private List<List<String>> data = null;

  public AlleleMatrixValues data(List<List<String>> data) {
    this.data = data;
    return this;
  }

  public AlleleMatrixValues addDataItem(List<String> dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<List<String>>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * Is an array of arrays; each inner array has three entries: ```markerDbId```, ```markerProfileDbId```, ```alleleCall```. Scores have to be represented as described further up. e.g. unknown data as \"N\", etc. Missing data can be skipped.
   * @return data
  **/
  @ApiModelProperty(value = "Is an array of arrays; each inner array has three entries: ```markerDbId```, ```markerProfileDbId```, ```alleleCall```. Scores have to be represented as described further up. e.g. unknown data as \"N\", etc. Missing data can be skipped.")

  @Valid

  public List<List<String>> getData() {
    return data;
  }

  public void setData(List<List<String>> data) {
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
    AlleleMatrixValues alleleMatrixValues = (AlleleMatrixValues) o;
    return Objects.equals(this.data, alleleMatrixValues.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AlleleMatrixValues {\n");
    
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

