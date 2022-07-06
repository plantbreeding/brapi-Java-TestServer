package io.swagger.model.geno;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;


/**
 * VendorSpecificationService
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
public class VendorSpecificationService   {
  @JsonProperty("serviceDescription")
  private String serviceDescription = null;

  @JsonProperty("serviceId")
  private String serviceId = null;

  @JsonProperty("serviceName")
  private String serviceName = null;

  @JsonProperty("servicePlatformMarkerType")
  private VendorServicePlatformMarkerTypeEnum servicePlatformMarkerType = null;

  @JsonProperty("servicePlatformName")
  private String servicePlatformName = null;

  @JsonProperty("specificRequirements")
  @Valid
  private List<VendorSpecificationServiceSpecificRequirements> specificRequirements = null;

  public VendorSpecificationService serviceDescription(String serviceDescription) {
    this.serviceDescription = serviceDescription;
    return this;
  }

  /**
   * Description of the vendor platform
   * @return serviceDescription
  **/
  @ApiModelProperty(example = "A combined DNA extract and Sequencing process using technology and science. Lots of automated pipet machines.", value = "Description of the vendor platform")
  
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
  @ApiModelProperty(example = "085d298f", required = true, value = "Unique identifier for this service")
      

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
  @ApiModelProperty(example = "The Deluxe Service", required = true, value = "The human readable name of a platform")
      

    public String getServiceName() {
    return serviceName;
  }

  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }

  public VendorSpecificationService servicePlatformMarkerType(VendorServicePlatformMarkerTypeEnum servicePlatformMarkerType) {
    this.servicePlatformMarkerType = servicePlatformMarkerType;
    return this;
  }

  /**
   * The type of markers used in this services platform
   * @return servicePlatformMarkerType
  **/
  @ApiModelProperty(example = "FIXED", value = "The type of markers used in this services platform")
  
    public VendorServicePlatformMarkerTypeEnum getServicePlatformMarkerType() {
    return servicePlatformMarkerType;
  }

  public void setServicePlatformMarkerType(VendorServicePlatformMarkerTypeEnum servicePlatformMarkerType) {
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
  @ApiModelProperty(example = "RNA-seq", value = "The technology platform used by this service")
  
    public String getServicePlatformName() {
    return servicePlatformName;
  }

  public void setServicePlatformName(String servicePlatformName) {
    this.servicePlatformName = servicePlatformName;
  }

  public VendorSpecificationService specificRequirements(List<VendorSpecificationServiceSpecificRequirements> specificRequirements) {
    this.specificRequirements = specificRequirements;
    return this;
  }

  public VendorSpecificationService addSpecificRequirementsItem(VendorSpecificationServiceSpecificRequirements specificRequirementsItem) {
    if (this.specificRequirements == null) {
      this.specificRequirements = new ArrayList<VendorSpecificationServiceSpecificRequirements>();
    }
    this.specificRequirements.add(specificRequirementsItem);
    return this;
  }

  /**
   * Additional arbitrary requirements for a particular platform
   * @return specificRequirements
  **/
  @ApiModelProperty(example = "[{\"description\":\"The genus of the samples\",\"key\":\"genus\"},{\"description\":\"The species of the samples\",\"key\":\"species\"},{\"description\":\"Approximate volume of each sample (ex 2.3 ml)\",\"key\":\"volumePerWell\"},{\"description\":\"Does DNA extraction need to happen before sequencing (ex true)\",\"key\":\"extractDNA\"}]", value = "Additional arbitrary requirements for a particular platform")
      @Valid
    public List<VendorSpecificationServiceSpecificRequirements> getSpecificRequirements() {
    return specificRequirements;
  }

  public void setSpecificRequirements(List<VendorSpecificationServiceSpecificRequirements> specificRequirements) {
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
