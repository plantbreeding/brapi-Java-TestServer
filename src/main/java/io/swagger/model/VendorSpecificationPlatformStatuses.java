package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * VendorSpecificationPlatformStatuses
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class VendorSpecificationPlatformStatuses   {
  @JsonProperty("statusDescription")
  private String statusDescription = null;

  @JsonProperty("statusName")
  private String statusName = null;

  public VendorSpecificationPlatformStatuses statusDescription(String statusDescription) {
    this.statusDescription = statusDescription;
    return this;
  }

   /**
   * Get statusDescription
   * @return statusDescription
  **/
  @ApiModelProperty(value = "")


  public String getStatusDescription() {
    return statusDescription;
  }

  public void setStatusDescription(String statusDescription) {
    this.statusDescription = statusDescription;
  }

  public VendorSpecificationPlatformStatuses statusName(String statusName) {
    this.statusName = statusName;
    return this;
  }

   /**
   * Get statusName
   * @return statusName
  **/
  @ApiModelProperty(value = "")


  public String getStatusName() {
    return statusName;
  }

  public void setStatusName(String statusName) {
    this.statusName = statusName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VendorSpecificationPlatformStatuses vendorSpecificationPlatformStatuses = (VendorSpecificationPlatformStatuses) o;
    return Objects.equals(this.statusDescription, vendorSpecificationPlatformStatuses.statusDescription) &&
        Objects.equals(this.statusName, vendorSpecificationPlatformStatuses.statusName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statusDescription, statusName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorSpecificationPlatformStatuses {\n");
    
    sb.append("    statusDescription: ").append(toIndentedString(statusDescription)).append("\n");
    sb.append("    statusName: ").append(toIndentedString(statusName)).append("\n");
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

