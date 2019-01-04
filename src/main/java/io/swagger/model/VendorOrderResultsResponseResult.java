package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.VendorResultFile;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * VendorOrderResultsResponseResult
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class VendorOrderResultsResponseResult   {
  @JsonProperty("data")
  @Valid
  private List<VendorResultFile> data = null;

  public VendorOrderResultsResponseResult data(List<VendorResultFile> data) {
    this.data = data;
    return this;
  }

  public VendorOrderResultsResponseResult addDataItem(VendorResultFile dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<VendorResultFile>();
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

  public List<VendorResultFile> getData() {
    return data;
  }

  public void setData(List<VendorResultFile> data) {
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
    VendorOrderResultsResponseResult vendorOrderResultsResponseResult = (VendorOrderResultsResponseResult) o;
    return Objects.equals(this.data, vendorOrderResultsResponseResult.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorOrderResultsResponseResult {\n");
    
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

