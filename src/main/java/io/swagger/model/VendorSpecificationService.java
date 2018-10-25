package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * VendorSpecificationService
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-10-25T15:57:44.669-04:00[America/New_York]")

public class VendorSpecificationService   {
  @JsonProperty("serviceDescription")
  private String serviceDescription = null;

  @JsonProperty("serviceId")
  private String serviceId = null;

  @JsonProperty("serviceName")
  private String serviceName = null;

  /**
   * The type of markers used in this services platform
   */
  public enum ServicePlatformMarkerTypeEnum {
    FIXED("FIXED"),
    
    DISCOVERABLE("DISCOVERABLE");

    private String value;

    ServicePlatformMarkerTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ServicePlatformMarkerTypeEnum fromValue(String text) {
      for (ServicePlatformMarkerTypeEnum b : ServicePlatformMarkerTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("servicePlatformMarkerType")
  private ServicePlatformMarkerTypeEnum servicePlatformMarkerType = null;

  @JsonProperty("servicePlatformName")
  private String servicePlatformName = null;

  @JsonProperty("specificRequirements")
  private Object specificRequirements = null;

  public VendorSpecificationService serviceDescription(String serviceDescription) {
    this.serviceDescription = serviceDescription;
    return this;
  }

  /**
   * Description of the vendor platform
   * @return serviceDescription
  **/
  @ApiModelProperty(value = "Description of the vendor platform")


  public String getServiceDescription() {
    return serviceDescription;
  }

  public void setServiceDescription(String serviceDescription) {
    this.serviceDescription = serviceDescription;
  }

  public VendorSpecificationService serviceId(String serviceId) {
    this.serviceId = serviceId;
    return this;
  }

  /**
   * Unique identifier for this service
   * @return serviceId
  **/
  @ApiModelProperty(value = "Unique identifier for this service")


  public String getServiceId() {
    return serviceId;
  }

  public void setServiceId(String serviceId) {
    this.serviceId = serviceId;
  }

  public VendorSpecificationService serviceName(String serviceName) {
    this.serviceName = serviceName;
    return this;
  }

  /**
   * The human readable name of a platform
   * @return serviceName
  **/
  @ApiModelProperty(value = "The human readable name of a platform")


  public String getServiceName() {
    return serviceName;
  }

  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }

  public VendorSpecificationService servicePlatformMarkerType(ServicePlatformMarkerTypeEnum servicePlatformMarkerType) {
    this.servicePlatformMarkerType = servicePlatformMarkerType;
    return this;
  }

  /**
   * The type of markers used in this services platform
   * @return servicePlatformMarkerType
  **/
  @ApiModelProperty(value = "The type of markers used in this services platform")


  public ServicePlatformMarkerTypeEnum getServicePlatformMarkerType() {
    return servicePlatformMarkerType;
  }

  public void setServicePlatformMarkerType(ServicePlatformMarkerTypeEnum servicePlatformMarkerType) {
    this.servicePlatformMarkerType = servicePlatformMarkerType;
  }

  public VendorSpecificationService servicePlatformName(String servicePlatformName) {
    this.servicePlatformName = servicePlatformName;
    return this;
  }

  /**
   * The technology platform used by this service
   * @return servicePlatformName
  **/
  @ApiModelProperty(value = "The technology platform used by this service")


  public String getServicePlatformName() {
    return servicePlatformName;
  }

  public void setServicePlatformName(String servicePlatformName) {
    this.servicePlatformName = servicePlatformName;
  }

  public VendorSpecificationService specificRequirements(Object specificRequirements) {
    this.specificRequirements = specificRequirements;
    return this;
  }

  /**
   * Additional arbitrary requirements for a particular platform
   * @return specificRequirements
  **/
  @ApiModelProperty(value = "Additional arbitrary requirements for a particular platform")


  public Object getSpecificRequirements() {
    return specificRequirements;
  }

  public void setSpecificRequirements(Object specificRequirements) {
    this.specificRequirements = specificRequirements;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VendorSpecificationService vendorSpecificationService = (VendorSpecificationService) o;
    return Objects.equals(this.serviceDescription, vendorSpecificationService.serviceDescription) &&
        Objects.equals(this.serviceId, vendorSpecificationService.serviceId) &&
        Objects.equals(this.serviceName, vendorSpecificationService.serviceName) &&
        Objects.equals(this.servicePlatformMarkerType, vendorSpecificationService.servicePlatformMarkerType) &&
        Objects.equals(this.servicePlatformName, vendorSpecificationService.servicePlatformName) &&
        Objects.equals(this.specificRequirements, vendorSpecificationService.specificRequirements);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceDescription, serviceId, serviceName, servicePlatformMarkerType, servicePlatformName, specificRequirements);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorSpecificationService {\n");
    
    sb.append("    serviceDescription: ").append(toIndentedString(serviceDescription)).append("\n");
    sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
    sb.append("    serviceName: ").append(toIndentedString(serviceName)).append("\n");
    sb.append("    servicePlatformMarkerType: ").append(toIndentedString(servicePlatformMarkerType)).append("\n");
    sb.append("    servicePlatformName: ").append(toIndentedString(servicePlatformName)).append("\n");
    sb.append("    specificRequirements: ").append(toIndentedString(specificRequirements)).append("\n");
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

