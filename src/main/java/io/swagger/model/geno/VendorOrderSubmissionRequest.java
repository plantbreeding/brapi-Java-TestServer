package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;


/**
 * VendorOrderSubmissionRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
public class VendorOrderSubmissionRequest extends VendorPlateSubmissionRequest  {
  @JsonProperty("requiredServiceInfo")
  @Valid
  private Map<String, String> requiredServiceInfo = null;

  @JsonProperty("serviceIds")
  @Valid
  private List<String> serviceIds = new ArrayList<String>();

  public VendorOrderSubmissionRequest requiredServiceInfo(Map<String, String> requiredServiceInfo) {
    this.requiredServiceInfo = requiredServiceInfo;
    return this;
  }

  public VendorOrderSubmissionRequest putRequiredServiceInfoItem(String key, String requiredServiceInfoItem) {
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
  @ApiModelProperty(example = "{\"extractDNA\":true,\"genus\":\"Zea\",\"species\":\"mays\",\"volumePerWell\":\"2.3 ml\"}", value = "A map of additional data required by the requested service. This includes things like Volume and Concentration.")
  
    public Map<String, String> getRequiredServiceInfo() {
    return requiredServiceInfo;
  }

  public void setRequiredServiceInfo(Map<String, String> requiredServiceInfo) {
    this.requiredServiceInfo = requiredServiceInfo;
  }

  public VendorOrderSubmissionRequest serviceIds(List<String> serviceIds) {
    this.serviceIds = serviceIds;
    return this;
  }

  public VendorOrderSubmissionRequest addServiceIdsItem(String serviceIdsItem) {
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
    VendorOrderSubmissionRequest vendorOrderSubmissionRequest = (VendorOrderSubmissionRequest) o;
    return Objects.equals(this.requiredServiceInfo, vendorOrderSubmissionRequest.requiredServiceInfo) &&
        Objects.equals(this.serviceIds, vendorOrderSubmissionRequest.serviceIds) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requiredServiceInfo, serviceIds, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorOrderSubmissionRequest {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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
