package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * VendorResultFile
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class VendorResultFile   {
  @JsonProperty("additionalInfo")
  @Valid
  private Map<String, String> additionalInfo = null;

  @JsonProperty("clientSampleIds")
  @Valid
  private List<String> clientSampleIds = new ArrayList<String>();

  @JsonProperty("fileName")
  private String fileName = null;

  @JsonProperty("fileType")
  private String fileType = null;

  @JsonProperty("fileURL")
  private String fileURL = null;

  @JsonProperty("md5sum")
  private String md5sum = null;

  public VendorResultFile additionalInfo(Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  public VendorResultFile putAdditionalInfoItem(String key, String additionalInfoItem) {
    if (this.additionalInfo == null) {
      this.additionalInfo = null;
    }
    this.additionalInfo.put(key, additionalInfoItem);
    return this;
  }

  /**
   * Additional arbitrary info
   * @return additionalInfo
  **/
  @ApiModelProperty(value = "Additional arbitrary info")


  public Map<String, String> getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public VendorResultFile clientSampleIds(List<String> clientSampleIds) {
    this.clientSampleIds = clientSampleIds;
    return this;
  }

  public VendorResultFile addClientSampleIdsItem(String clientSampleIdsItem) {
    this.clientSampleIds.add(clientSampleIdsItem);
    return this;
  }

  /**
   * The list of sampleDbIds included in the file
   * @return clientSampleIds
  **/
  @ApiModelProperty(required = true, value = "The list of sampleDbIds included in the file")
  @NotNull


  public List<String> getClientSampleIds() {
    return clientSampleIds;
  }

  public void setClientSampleIds(List<String> clientSampleIds) {
    this.clientSampleIds = clientSampleIds;
  }

  public VendorResultFile fileName(String fileName) {
    this.fileName = fileName;
    return this;
  }

  /**
   * Name of the file
   * @return fileName
  **/
  @ApiModelProperty(required = true, value = "Name of the file")
  @NotNull


  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public VendorResultFile fileType(String fileType) {
    this.fileType = fileType;
    return this;
  }

  /**
   * Format of the file
   * @return fileType
  **/
  @ApiModelProperty(required = true, value = "Format of the file")
  @NotNull


  public String getFileType() {
    return fileType;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType;
  }

  public VendorResultFile fileURL(String fileURL) {
    this.fileURL = fileURL;
    return this;
  }

  /**
   * The URL to a file with the results of a vendor analysis
   * @return fileURL
  **/
  @ApiModelProperty(required = true, value = "The URL to a file with the results of a vendor analysis")
  @NotNull


  public String getFileURL() {
    return fileURL;
  }

  public void setFileURL(String fileURL) {
    this.fileURL = fileURL;
  }

  public VendorResultFile md5sum(String md5sum) {
    this.md5sum = md5sum;
    return this;
  }

  /**
   * MD5 Hash Check Sum for the file to confirm download without error
   * @return md5sum
  **/
  @ApiModelProperty(value = "MD5 Hash Check Sum for the file to confirm download without error")


  public String getMd5sum() {
    return md5sum;
  }

  public void setMd5sum(String md5sum) {
    this.md5sum = md5sum;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VendorResultFile vendorResultFile = (VendorResultFile) o;
    return Objects.equals(this.additionalInfo, vendorResultFile.additionalInfo) &&
        Objects.equals(this.clientSampleIds, vendorResultFile.clientSampleIds) &&
        Objects.equals(this.fileName, vendorResultFile.fileName) &&
        Objects.equals(this.fileType, vendorResultFile.fileType) &&
        Objects.equals(this.fileURL, vendorResultFile.fileURL) &&
        Objects.equals(this.md5sum, vendorResultFile.md5sum);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalInfo, clientSampleIds, fileName, fileType, fileURL, md5sum);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorResultFile {\n");
    
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    clientSampleIds: ").append(toIndentedString(clientSampleIds)).append("\n");
    sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
    sb.append("    fileType: ").append(toIndentedString(fileType)).append("\n");
    sb.append("    fileURL: ").append(toIndentedString(fileURL)).append("\n");
    sb.append("    md5sum: ").append(toIndentedString(md5sum)).append("\n");
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

