package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;


/**
 * The details of a vendor order
 */
@ApiModel(description = "The details of a vendor order")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
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

  @JsonProperty("serviceIds")
  @Valid
  private List<String> serviceIds = new ArrayList<String>();

  public VendorOrder clientId(String clientId) {
    this.clientId = clientId;
    return this;
  }

  /**
   * A unique, alpha-numeric ID which identifies the client to the vendor. Used to connect the order to the correct billing and contact info.
   * @return clientId
  **/
  @ApiModelProperty(example = "7b51ad15", required = true, value = "A unique, alpha-numeric ID which identifies the client to the vendor. Used to connect the order to the correct billing and contact info.")
      

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
  @ApiModelProperty(example = "180", required = true, value = "The total number of samples contained in this request. Used for billing and basic validation of the request.")
      

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
  @ApiModelProperty(example = "96ba0ca3", required = true, value = "The order id returned by the vendor when the order was successfully submitted.")
      

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
      this.requiredServiceInfo = new HashMap<String, String>();
    }
    this.requiredServiceInfo.put(key, requiredServiceInfoItem);
    return this;
  }

  /**
   * A map of additional data required by the requested service. This includes things like Volume and Concentration.
   * @return requiredServiceInfo
  **/
  @ApiModelProperty(example = "{\"extractDNA\":\"true\",\"genus\":\"Zea\",\"species\":\"mays\",\"volumePerWell\":\"2.3 ml\"}", value = "A map of additional data required by the requested service. This includes things like Volume and Concentration.")
  
    public Map<String, String> getRequiredServiceInfo() {
    return requiredServiceInfo;
  }

  public void setRequiredServiceInfo(Map<String, String> requiredServiceInfo) {
    this.requiredServiceInfo = requiredServiceInfo;
  }

  public VendorOrder serviceIds(List<String> serviceIds) {
    this.serviceIds = serviceIds;
    return this;
  }

  public VendorOrder addServiceIdsItem(String serviceIdsItem) {
    this.serviceIds.add(serviceIdsItem);
    return this;
  }

  /**
   * A list of unique, alpha-numeric ID which identify the requested services to be applied to this order.  A Vendor Service defines what platform, technology, and markers will be used.  A list of available service IDs can be retrieved from the Vendor Specs.
   * @return serviceIds
  **/
  @ApiModelProperty(example = "[\"e8f60f64\",\"05bd925a\",\"b698fb5e\"]", required = true, value = "A list of unique, alpha-numeric ID which identify the requested services to be applied to this order.  A Vendor Service defines what platform, technology, and markers will be used.  A list of available service IDs can be retrieved from the Vendor Specs.")
      

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
    VendorOrder vendorOrder = (VendorOrder) o;
    return Objects.equals(this.clientId, vendorOrder.clientId) &&
        Objects.equals(this.numberOfSamples, vendorOrder.numberOfSamples) &&
        Objects.equals(this.orderId, vendorOrder.orderId) &&
        Objects.equals(this.requiredServiceInfo, vendorOrder.requiredServiceInfo) &&
        Objects.equals(this.serviceIds, vendorOrder.serviceIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientId, numberOfSamples, orderId, requiredServiceInfo, serviceIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorOrder {\n");
    
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    numberOfSamples: ").append(toIndentedString(numberOfSamples)).append("\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    requiredServiceInfo: ").append(toIndentedString(requiredServiceInfo)).append("\n");
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
