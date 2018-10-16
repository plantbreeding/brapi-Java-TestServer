package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Marker;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * MarkersResponse2Result
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class MarkersResponse2Result   {
  @JsonProperty("data")
  @Valid
  private List<Marker> data = null;

  public MarkersResponse2Result data(List<Marker> data) {
    this.data = data;
    return this;
  }

  public MarkersResponse2Result addDataItem(Marker dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<Marker>();
    }
    this.data.add(dataItem);
    return this;
  }

   /**
   * Get data
   * @return data
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Marker> getData() {
    return data;
  }

  public void setData(List<Marker> data) {
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
    MarkersResponse2Result markersResponse2Result = (MarkersResponse2Result) o;
    return Objects.equals(this.data, markersResponse2Result.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MarkersResponse2Result {\n");
    
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

