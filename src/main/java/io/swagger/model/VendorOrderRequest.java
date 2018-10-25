package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.VendorOrderRequestPlates;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Request object structure to submit plate data to a vendor
 */
@ApiModel(description = "Request object structure to submit plate data to a vendor")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-10-25T15:57:44.669-04:00[America/New_York]")

public class VendorOrderRequest   {
  @JsonProperty("clientId")
  private String clientId = null;

  @JsonProperty("numberOfSamples")
  private Integer numberOfSamples = null;

  @JsonProperty("plates")
  @Valid
  private List<VendorOrderRequestPlates> plates = null;

  @JsonProperty("requiredServiceInfo")
  @Valid
  private Map<String, String> requiredServiceInfo = null;

  /**
   * The type of Samples being submitted
   */
  public enum SampleTypeEnum {
    DNA("DNA"),
    
    RNA("RNA"),
    
    TISSUE("Tissue");

    private String value;

    SampleTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SampleTypeEnum fromValue(String text) {
      for (SampleTypeEnum b : SampleTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("sampleType")
  private SampleTypeEnum sampleType = null;

  @JsonProperty("serviceIds")
  @Valid
  private List<String> serviceIds = null;

  public VendorOrderRequest clientId(String clientId) {
    this.clientId = clientId;
    return this;
  }

  /**
   * A unique, alpha-numeric ID which identifies the client to the vendor. Used to connect the order to the contract, billing, and contact info.
   * @return clientId
  **/
  @ApiModelProperty(value = "A unique, alpha-numeric ID which identifies the client to the vendor. Used to connect the order to the contract, billing, and contact info.")


  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public VendorOrderRequest numberOfSamples(Integer numberOfSamples) {
    this.numberOfSamples = numberOfSamples;
    return this;
  }

  /**
   * The total number of samples contained in this request. Used for billing and basic validation of the request.
   * @return numberOfSamples
  **/
  @ApiModelProperty(value = "The total number of samples contained in this request. Used for billing and basic validation of the request.")


  public Integer getNumberOfSamples() {
    return numberOfSamples;
  }

  public void setNumberOfSamples(Integer numberOfSamples) {
    this.numberOfSamples = numberOfSamples;
  }

  public VendorOrderRequest plates(List<VendorOrderRequestPlates> plates) {
    this.plates = plates;
    return this;
  }

  public VendorOrderRequest addPlatesItem(VendorOrderRequestPlates platesItem) {
    if (this.plates == null) {
      this.plates = new ArrayList<VendorOrderRequestPlates>();
    }
    this.plates.add(platesItem);
    return this;
  }

  /**
   * Array of new plates to be submitted to a vendor
   * @return plates
  **/
  @ApiModelProperty(value = "Array of new plates to be submitted to a vendor")

  @Valid

  public List<VendorOrderRequestPlates> getPlates() {
    return plates;
  }

  public void setPlates(List<VendorOrderRequestPlates> plates) {
    this.plates = plates;
  }

  public VendorOrderRequest requiredServiceInfo(Map<String, String> requiredServiceInfo) {
    this.requiredServiceInfo = requiredServiceInfo;
    return this;
  }

  public VendorOrderRequest putRequiredServiceInfoItem(String key, String requiredServiceInfoItem) {
    if (this.requiredServiceInfo == null) {
      this.requiredServiceInfo = null;
    }
    this.requiredServiceInfo.put(key, requiredServiceInfoItem);
    return this;
  }

  /**
   * A map of additional data required by the requested service. This includes things like Volume and Concentration.
   * @return requiredServiceInfo
  **/
  @ApiModelProperty(value = "A map of additional data required by the requested service. This includes things like Volume and Concentration.")


  public Map<String, String> getRequiredServiceInfo() {
    return requiredServiceInfo;
  }

  public void setRequiredServiceInfo(Map<String, String> requiredServiceInfo) {
    this.requiredServiceInfo = requiredServiceInfo;
  }

  public VendorOrderRequest sampleType(SampleTypeEnum sampleType) {
    this.sampleType = sampleType;
    return this;
  }

  /**
   * The type of Samples being submitted
   * @return sampleType
  **/
  @ApiModelProperty(value = "The type of Samples being submitted")


  public SampleTypeEnum getSampleType() {
    return sampleType;
  }

  public void setSampleType(SampleTypeEnum sampleType) {
    this.sampleType = sampleType;
  }

  public VendorOrderRequest serviceIds(List<String> serviceIds) {
    this.serviceIds = serviceIds;
    return this;
  }

  public VendorOrderRequest addServiceIdsItem(String serviceIdsItem) {
    if (this.serviceIds == null) {
      this.serviceIds = new ArrayList<String>();
    }
    this.serviceIds.add(serviceIdsItem);
    return this;
  }

  /**
   * A list of unique, alpha-numeric ID which identify the requested services to be applied to this order. A Vendor Service defines what platform, technology, and markers will be used. A list of service IDs can be retrieved from the Vendor Specs.
   * @return serviceIds
  **/
  @ApiModelProperty(value = "A list of unique, alpha-numeric ID which identify the requested services to be applied to this order. A Vendor Service defines what platform, technology, and markers will be used. A list of service IDs can be retrieved from the Vendor Specs.")


  public List<String> getServiceIds() {
    return serviceIds;
  }

  public void setServiceIds(List<String> serviceIds) {
    this.serviceIds = serviceIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VendorOrderRequest vendorOrderRequest = (VendorOrderRequest) o;
    return Objects.equals(this.clientId, vendorOrderRequest.clientId) &&
        Objects.equals(this.numberOfSamples, vendorOrderRequest.numberOfSamples) &&
        Objects.equals(this.plates, vendorOrderRequest.plates) &&
        Objects.equals(this.requiredServiceInfo, vendorOrderRequest.requiredServiceInfo) &&
        Objects.equals(this.sampleType, vendorOrderRequest.sampleType) &&
        Objects.equals(this.serviceIds, vendorOrderRequest.serviceIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientId, numberOfSamples, plates, requiredServiceInfo, sampleType, serviceIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorOrderRequest {\n");
    
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    numberOfSamples: ").append(toIndentedString(numberOfSamples)).append("\n");
    sb.append("    plates: ").append(toIndentedString(plates)).append("\n");
    sb.append("    requiredServiceInfo: ").append(toIndentedString(requiredServiceInfo)).append("\n");
    sb.append("    sampleType: ").append(toIndentedString(sampleType)).append("\n");
    sb.append("    serviceIds: ").append(toIndentedString(serviceIds)).append("\n");
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

