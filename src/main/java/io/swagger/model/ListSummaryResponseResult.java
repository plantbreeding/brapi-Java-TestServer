package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ListSummary;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ListSummaryResponseResult
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class ListSummaryResponseResult   {
  @JsonProperty("data")
  @Valid
  private List<ListSummary> data = null;

  public ListSummaryResponseResult data(List<ListSummary> data) {
    this.data = data;
    return this;
  }

  public ListSummaryResponseResult addDataItem(ListSummary dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<ListSummary>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * Array of generic list summaries
   * @return data
  **/
  @ApiModelProperty(value = "Array of generic list summaries")

  @Valid

  public List<ListSummary> getData() {
    return data;
  }

  public void setData(List<ListSummary> data) {
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
    ListSummaryResponseResult listSummaryResponseResult = (ListSummaryResponseResult) o;
    return Objects.equals(this.data, listSummaryResponseResult.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListSummaryResponseResult {\n");
    
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

