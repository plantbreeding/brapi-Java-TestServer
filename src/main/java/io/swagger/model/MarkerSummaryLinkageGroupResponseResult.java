package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.MarkerSummaryLinkageGroup;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MarkerSummaryLinkageGroupResponseResult
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-11-06T17:40:52.157-05:00[America/New_York]")

public class MarkerSummaryLinkageGroupResponseResult   {
  @JsonProperty("data")
  @Valid
  private List<MarkerSummaryLinkageGroup> data = null;

  public MarkerSummaryLinkageGroupResponseResult data(List<MarkerSummaryLinkageGroup> data) {
    this.data = data;
    return this;
  }

  public MarkerSummaryLinkageGroupResponseResult addDataItem(MarkerSummaryLinkageGroup dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<MarkerSummaryLinkageGroup>();
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

  public List<MarkerSummaryLinkageGroup> getData() {
    return data;
  }

  public void setData(List<MarkerSummaryLinkageGroup> data) {
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
    MarkerSummaryLinkageGroupResponseResult markerSummaryLinkageGroupResponseResult = (MarkerSummaryLinkageGroupResponseResult) o;
    return Objects.equals(this.data, markerSummaryLinkageGroupResponseResult.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MarkerSummaryLinkageGroupResponseResult {\n");
    
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

