package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * VendorPlateSearchRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class VendorPlateSearchRequest   {
  @JsonProperty("clientPlateDbIds")
  @Valid
  private List<String> clientPlateDbIds = null;

  @JsonProperty("page")
  private Integer page = null;

  @JsonProperty("pageSize")
  private Integer pageSize = null;

  @JsonProperty("sampleInfo")
  private Boolean sampleInfo = null;

  @JsonProperty("vendorPlateDbIds")
  @Valid
  private List<String> vendorPlateDbIds = null;

  @JsonProperty("vendorProjectDbIds")
  @Valid
  private List<String> vendorProjectDbIds = null;

  public VendorPlateSearchRequest clientPlateDbIds(List<String> clientPlateDbIds) {
    this.clientPlateDbIds = clientPlateDbIds;
    return this;
  }

  public VendorPlateSearchRequest addClientPlateDbIdsItem(String clientPlateDbIdsItem) {
    if (this.clientPlateDbIds == null) {
      this.clientPlateDbIds = new ArrayList<String>();
    }
    this.clientPlateDbIds.add(clientPlateDbIdsItem);
    return this;
  }

   /**
   * List of plate ids from the client database to filter search
   * @return clientPlateDbIds
  **/
  @ApiModelProperty(value = "List of plate ids from the client database to filter search")


  public List<String> getClientPlateDbIds() {
    return clientPlateDbIds;
  }

  public void setClientPlateDbIds(List<String> clientPlateDbIds) {
    this.clientPlateDbIds = clientPlateDbIds;
  }

  public VendorPlateSearchRequest page(Integer page) {
    this.page = page;
    return this;
  }

   /**
   * Which page of the \"data\" array to return. The page indexing starts at 0 (page=0 will return the first page). Default is 0.
   * @return page
  **/
  @ApiModelProperty(value = "Which page of the \"data\" array to return. The page indexing starts at 0 (page=0 will return the first page). Default is 0.")


  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public VendorPlateSearchRequest pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

   /**
   * The maximum number of items to return per page of the \"data\" array. Default is 1000.
   * @return pageSize
  **/
  @ApiModelProperty(value = "The maximum number of items to return per page of the \"data\" array. Default is 1000.")


  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public VendorPlateSearchRequest sampleInfo(Boolean sampleInfo) {
    this.sampleInfo = sampleInfo;
    return this;
  }

   /**
   * Include array of sample information or not in response
   * @return sampleInfo
  **/
  @ApiModelProperty(value = "Include array of sample information or not in response")


  public Boolean isSampleInfo() {
    return sampleInfo;
  }

  public void setSampleInfo(Boolean sampleInfo) {
    this.sampleInfo = sampleInfo;
  }

  public VendorPlateSearchRequest vendorPlateDbIds(List<String> vendorPlateDbIds) {
    this.vendorPlateDbIds = vendorPlateDbIds;
    return this;
  }

  public VendorPlateSearchRequest addVendorPlateDbIdsItem(String vendorPlateDbIdsItem) {
    if (this.vendorPlateDbIds == null) {
      this.vendorPlateDbIds = new ArrayList<String>();
    }
    this.vendorPlateDbIds.add(vendorPlateDbIdsItem);
    return this;
  }

   /**
   * List of plate ids from the vendors database to filter search
   * @return vendorPlateDbIds
  **/
  @ApiModelProperty(value = "List of plate ids from the vendors database to filter search")


  public List<String> getVendorPlateDbIds() {
    return vendorPlateDbIds;
  }

  public void setVendorPlateDbIds(List<String> vendorPlateDbIds) {
    this.vendorPlateDbIds = vendorPlateDbIds;
  }

  public VendorPlateSearchRequest vendorProjectDbIds(List<String> vendorProjectDbIds) {
    this.vendorProjectDbIds = vendorProjectDbIds;
    return this;
  }

  public VendorPlateSearchRequest addVendorProjectDbIdsItem(String vendorProjectDbIdsItem) {
    if (this.vendorProjectDbIds == null) {
      this.vendorProjectDbIds = new ArrayList<String>();
    }
    this.vendorProjectDbIds.add(vendorProjectDbIdsItem);
    return this;
  }

   /**
   * List of project ids from the vendors database to filter search
   * @return vendorProjectDbIds
  **/
  @ApiModelProperty(value = "List of project ids from the vendors database to filter search")


  public List<String> getVendorProjectDbIds() {
    return vendorProjectDbIds;
  }

  public void setVendorProjectDbIds(List<String> vendorProjectDbIds) {
    this.vendorProjectDbIds = vendorProjectDbIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VendorPlateSearchRequest vendorPlateSearchRequest = (VendorPlateSearchRequest) o;
    return Objects.equals(this.clientPlateDbIds, vendorPlateSearchRequest.clientPlateDbIds) &&
        Objects.equals(this.page, vendorPlateSearchRequest.page) &&
        Objects.equals(this.pageSize, vendorPlateSearchRequest.pageSize) &&
        Objects.equals(this.sampleInfo, vendorPlateSearchRequest.sampleInfo) &&
        Objects.equals(this.vendorPlateDbIds, vendorPlateSearchRequest.vendorPlateDbIds) &&
        Objects.equals(this.vendorProjectDbIds, vendorPlateSearchRequest.vendorProjectDbIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientPlateDbIds, page, pageSize, sampleInfo, vendorPlateDbIds, vendorProjectDbIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorPlateSearchRequest {\n");
    
    sb.append("    clientPlateDbIds: ").append(toIndentedString(clientPlateDbIds)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    sampleInfo: ").append(toIndentedString(sampleInfo)).append("\n");
    sb.append("    vendorPlateDbIds: ").append(toIndentedString(vendorPlateDbIds)).append("\n");
    sb.append("    vendorProjectDbIds: ").append(toIndentedString(vendorProjectDbIds)).append("\n");
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

