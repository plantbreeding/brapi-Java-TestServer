package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Metadata;
import io.swagger.model.VendorOrderStatusResponseResult;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * VendorOrderStatusResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-10-25T15:57:44.669-04:00[America/New_York]")

public class VendorOrderStatusResponse   {
  @JsonProperty("metadata")
  private Metadata metadata = null;

  @JsonProperty("result")
  private VendorOrderStatusResponseResult result = null;

  public VendorOrderStatusResponse metadata(Metadata metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Get metadata
   * @return metadata
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Metadata getMetadata() {
    return metadata;
  }

  public void setMetadata(Metadata metadata) {
    this.metadata = metadata;
  }

  public VendorOrderStatusResponse result(VendorOrderStatusResponseResult result) {
    this.result = result;
    return this;
  }

  /**
   * Get result
   * @return result
  **/
  @ApiModelProperty(value = "")

  @Valid

  public VendorOrderStatusResponseResult getResult() {
    return result;
  }

  public void setResult(VendorOrderStatusResponseResult result) {
    this.result = result;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VendorOrderStatusResponse vendorOrderStatusResponse = (VendorOrderStatusResponse) o;
    return Objects.equals(this.metadata, vendorOrderStatusResponse.metadata) &&
        Objects.equals(this.result, vendorOrderStatusResponse.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metadata, result);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorOrderStatusResponse {\n");
    
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
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

