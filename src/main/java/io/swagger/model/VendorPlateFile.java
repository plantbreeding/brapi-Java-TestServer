package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * VendorPlateFile
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class VendorPlateFile   {
  @JsonProperty("URL")
  private String URL = null;

  @JsonProperty("additionalInfo")
  @Valid
  private Map<String, String> additionalInfo = null;

  @JsonProperty("fileType")
  private String fileType = null;

  @JsonProperty("filename")
  private String filename = null;

  @JsonProperty("md5sum")
  private String md5sum = null;

  @JsonProperty("sampleDbIds")
  @Valid
  private List<String> sampleDbIds = new ArrayList<String>();

  public VendorPlateFile URL(String URL) {
    this.URL = URL;
    return this;
  }

   /**
   * The URL to a file with the results of a vendor analysis
   * @return URL
  **/
  @ApiModelProperty(required = true, value = "The URL to a file with the results of a vendor analysis")
  @NotNull


  public String getURL() {
    return URL;
  }

  public void setURL(String URL) {
    this.URL = URL;
  }

  public VendorPlateFile additionalInfo(Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  public VendorPlateFile putAdditionalInfoItem(String key, String additionalInfoItem) {
    if (this.additionalInfo == null) {
      this.additionalInfo = new HashMap<String, String>();
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

  public VendorPlateFile fileType(String fileType) {
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

  public VendorPlateFile filename(String filename) {
    this.filename = filename;
    return this;
  }

   /**
   * Name of the file
   * @return filename
  **/
  @ApiModelProperty(required = true, value = "Name of the file")
  @NotNull


  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public VendorPlateFile md5sum(String md5sum) {
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

  public VendorPlateFile sampleDbIds(List<String> sampleDbIds) {
    this.sampleDbIds = sampleDbIds;
    return this;
  }

  public VendorPlateFile addSampleDbIdsItem(String sampleDbIdsItem) {
    this.sampleDbIds.add(sampleDbIdsItem);
    return this;
  }

   /**
   * The list of sampleDbIds included in the file
   * @return sampleDbIds
  **/
  @ApiModelProperty(required = true, value = "The list of sampleDbIds included in the file")
  @NotNull


  public List<String> getSampleDbIds() {
    return sampleDbIds;
  }

  public void setSampleDbIds(List<String> sampleDbIds) {
    this.sampleDbIds = sampleDbIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VendorPlateFile vendorPlateFile = (VendorPlateFile) o;
    return Objects.equals(this.URL, vendorPlateFile.URL) &&
        Objects.equals(this.additionalInfo, vendorPlateFile.additionalInfo) &&
        Objects.equals(this.fileType, vendorPlateFile.fileType) &&
        Objects.equals(this.filename, vendorPlateFile.filename) &&
        Objects.equals(this.md5sum, vendorPlateFile.md5sum) &&
        Objects.equals(this.sampleDbIds, vendorPlateFile.sampleDbIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(URL, additionalInfo, fileType, filename, md5sum, sampleDbIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorPlateFile {\n");
    
    sb.append("    URL: ").append(toIndentedString(URL)).append("\n");
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    fileType: ").append(toIndentedString(fileType)).append("\n");
    sb.append("    filename: ").append(toIndentedString(filename)).append("\n");
    sb.append("    md5sum: ").append(toIndentedString(md5sum)).append("\n");
    sb.append("    sampleDbIds: ").append(toIndentedString(sampleDbIds)).append("\n");
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

