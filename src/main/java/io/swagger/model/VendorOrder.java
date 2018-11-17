package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The details of a vendor order
 */
@ApiModel(description = "The details of a vendor order")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-11-06T17:40:52.157-05:00[America/New_York]")

public class VendorOrder   {
  @JsonProperty("clientId")
  private String clientId = null;

  @JsonProperty("numberOfSamples")
  private Integer numberOfSamples = null;

  @JsonProperty("orderId")
  private String orderId = null;

  @JsonProperty("requiredServiceInfo")
  @Valid
  private Map<String, String> requiredServiceInfo = null;

  @JsonProperty("serviceId")
  private String serviceId = null;

  public VendorOrder clientId(String clientId) {
    this.clientId = clientId;
    return this;
  }

  /**
   * A unique, alpha-numeric ID which identifies the client to the vendor. Used to connect the order to the correct billing and contact info.
   * @return clientId
  **/
  @ApiModelProperty(value = "A unique, alpha-numeric ID which identifies the client to the vendor. Used to connect the order to the correct billing and contact info.")


  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public VendorOrder numberOfSamples(Integer numberOfSamples) {
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

  public VendorOrder orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

  /**
   * The order id returned by the vendor when the order was successfully submitted.
   * @return orderId
  **/
  @ApiModelProperty(value = "The order id returned by the vendor when the order was successfully submitted.")


  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public VendorOrder requiredServiceInfo(Map<String, String> requiredServiceInfo) {
    this.requiredServiceInfo = requiredServiceInfo;
    return this;
  }

  public VendorOrder putRequiredServiceInfoItem(String key, String requiredServiceInfoItem) {
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

  public VendorOrder serviceId(String serviceId) {
    this.serviceId = serviceId;
    return this;
  }

  /**
   * A unique, alpha-numeric ID which identifies the requested service to be used for this order. The service defines what platform, technology, and markers will be used. A list of service IDs can be retrieved from the Vendor Specs.
   * @return serviceId
  **/
  @ApiModelProperty(value = "A unique, alpha-numeric ID which identifies the requested service to be used for this order. The service defines what platform, technology, and markers will be used. A list of service IDs can be retrieved from the Vendor Specs.")


  public String getServiceId() {
    return serviceId;
  }

  public void setServiceId(String serviceId) {
    this.serviceId = serviceId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VendorOrder vendorOrder = (VendorOrder) o;
    return Objects.equals(this.clientId, vendorOrder.clientId) &&
        Objects.equals(this.numberOfSamples, vendorOrder.numberOfSamples) &&
        Objects.equals(this.orderId, vendorOrder.orderId) &&
        Objects.equals(this.requiredServiceInfo, vendorOrder.requiredServiceInfo) &&
        Objects.equals(this.serviceId, vendorOrder.serviceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientId, numberOfSamples, orderId, requiredServiceInfo, serviceId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorOrder {\n");
    
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    numberOfSamples: ").append(toIndentedString(numberOfSamples)).append("\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    requiredServiceInfo: ").append(toIndentedString(requiredServiceInfo)).append("\n");
    sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
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

