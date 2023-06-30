package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.PhenotypesRequestData;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

/**
 * PhenotypesRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class PhenotypesRequest   {
  @JsonProperty("data")
  @Valid
  private List<PhenotypesRequestData> data = null;

  public PhenotypesRequest data(List<PhenotypesRequestData> data) {
    this.data = data;
    return this;
  }

  public PhenotypesRequest addDataItem(PhenotypesRequestData dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<PhenotypesRequestData>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * Matrix of observation data recorded for different observation variables across different observation units
   * @return data
  **/
  @ApiModelProperty(value = "Matrix of observation data recorded for different observation variables across different observation units")

  @Valid

  public List<PhenotypesRequestData> getData() {
    return data;
  }

  public void setData(List<PhenotypesRequestData> data) {
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
    PhenotypesRequest phenotypesRequest = (PhenotypesRequest) o;
    return Objects.equals(this.data, phenotypesRequest.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PhenotypesRequest {\n");
    
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

