package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.VendorContact;
import io.swagger.model.VendorSpecificationService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

/**
 * VendorSpecification
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class VendorSpecification   {
  @JsonProperty("additionalInfo")
  @Valid
  private Map<String, Object> additionalInfo = null;

  @JsonProperty("services")
  @Valid
  private List<VendorSpecificationService> services = null;

  @JsonProperty("vendorContact")
  private VendorContact vendorContact = null;

  public VendorSpecification additionalInfo(Map<String, Object> additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  public VendorSpecification putAdditionalInfoItem(String key, Object additionalInfoItem) {
    if (this.additionalInfo == null) {
      this.additionalInfo = null;
    }
    this.additionalInfo.put(key, additionalInfoItem);
    return this;
  }

  /**
   * Additional arbitrary information specific to a particular Vendor. Look for the Vedors specific API documentation for more details
   * @return additionalInfo
  **/
  @ApiModelProperty(value = "Additional arbitrary information specific to a particular Vendor. Look for the Vedors specific API documentation for more details")


  public Map<String, Object> getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(Map<String, Object> additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public VendorSpecification services(List<VendorSpecificationService> services) {
    this.services = services;
    return this;
  }

  public VendorSpecification addServicesItem(VendorSpecificationService servicesItem) {
    if (this.services == null) {
      this.services = new ArrayList<VendorSpecificationService>();
    }
    this.services.add(servicesItem);
    return this;
  }

  /**
   * List of platform specifications available at the vendor
   * @return services
  **/
  @ApiModelProperty(value = "List of platform specifications available at the vendor")

  @Valid

  public List<VendorSpecificationService> getServices() {
    return services;
  }

  public void setServices(List<VendorSpecificationService> services) {
    this.services = services;
  }

  public VendorSpecification vendorContact(VendorContact vendorContact) {
    this.vendorContact = vendorContact;
    return this;
  }

  /**
   * Get vendorContact
   * @return vendorContact
  **/
  @ApiModelProperty(value = "")

  @Valid

  public VendorContact getVendorContact() {
    return vendorContact;
  }

  public void setVendorContact(VendorContact vendorContact) {
    this.vendorContact = vendorContact;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VendorSpecification vendorSpecification = (VendorSpecification) o;
    return Objects.equals(this.additionalInfo, vendorSpecification.additionalInfo) &&
        Objects.equals(this.services, vendorSpecification.services) &&
        Objects.equals(this.vendorContact, vendorSpecification.vendorContact);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalInfo, services, vendorContact);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorSpecification {\n");
    
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    services: ").append(toIndentedString(services)).append("\n");
    sb.append("    vendorContact: ").append(toIndentedString(vendorContact)).append("\n");
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

