package io.swagger.model.geno;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * VendorResultFile
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
public class VendorResultFile   {
  @JsonProperty("additionalInfo")
  @Valid
  private Object additionalInfo = null;

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

  public VendorResultFile additionalInfo(Object additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  /**
   * Additional arbitrary info
   * @return additionalInfo
  **/
  @ApiModelProperty(value = "Additional arbitrary info")
  
    public Object getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(Object additionalInfo) {
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
  @ApiModelProperty(example = "[\"3968733e\",\"e0de6391\",\"66854172\"]", required = true, value = "The list of sampleDbIds included in the file")
      

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
  @ApiModelProperty(example = "sequence_data_ce640bd3.csv", required = true, value = "Name of the file")
      

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
  @ApiModelProperty(example = "text/csv", required = true, value = "Format of the file")
      

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
  @ApiModelProperty(example = "https://vendor.org/data/sequence_data_ce640bd3.csv", required = true, value = "The URL to a file with the results of a vendor analysis")
      

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
  @ApiModelProperty(example = "c2365e900c81a89cf74d83dab60df146", value = "MD5 Hash Check Sum for the file to confirm download without error")
  
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
