package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * A dataFile contains a URL and the relevant file metadata to represent a file
 */
@ApiModel(description = "A dataFile contains a URL and the relevant file metadata to represent a file")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class DataFile   {
  @JsonProperty("fileDescription")
  private String fileDescription = null;

  @JsonProperty("fileMD5Hash")
  private String fileMD5Hash = null;

  @JsonProperty("fileName")
  private String fileName = null;

  @JsonProperty("fileSize")
  private Integer fileSize = null;

  @JsonProperty("fileType")
  private String fileType = null;

  @JsonProperty("fileURL")
  private String fileURL = null;

  public DataFile fileDescription(String fileDescription) {
    this.fileDescription = fileDescription;
    return this;
  }

  /**
   * A human readable description of the file contents
   * @return fileDescription
  **/
  @ApiModelProperty(example = "This is an Excel data file", value = "A human readable description of the file contents")
  
    public String getFileDescription() {
    return fileDescription;
  }

  public void setFileDescription(String fileDescription) {
    this.fileDescription = fileDescription;
  }

  public DataFile fileMD5Hash(String fileMD5Hash) {
    this.fileMD5Hash = fileMD5Hash;
    return this;
  }

  /**
   * The MD5 Hash of the file contents to be used as a check sum
   * @return fileMD5Hash
  **/
  @ApiModelProperty(example = "c2365e900c81a89cf74d83dab60df146", value = "The MD5 Hash of the file contents to be used as a check sum")
  
    public String getFileMD5Hash() {
    return fileMD5Hash;
  }

  public void setFileMD5Hash(String fileMD5Hash) {
    this.fileMD5Hash = fileMD5Hash;
  }

  public DataFile fileName(String fileName) {
    this.fileName = fileName;
    return this;
  }

  /**
   * The name of the file
   * @return fileName
  **/
  @ApiModelProperty(example = "datafile.xlsx", value = "The name of the file")
  
    public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public DataFile fileSize(Integer fileSize) {
    this.fileSize = fileSize;
    return this;
  }

  /**
   * The size of the file in bytes
   * @return fileSize
  **/
  @ApiModelProperty(example = "4398", value = "The size of the file in bytes")
  
    public Integer getFileSize() {
    return fileSize;
  }

  public void setFileSize(Integer fileSize) {
    this.fileSize = fileSize;
  }

  public DataFile fileType(String fileType) {
    this.fileType = fileType;
    return this;
  }

  /**
   * The type or format of the file. Preferably MIME Type.
   * @return fileType
  **/
  @ApiModelProperty(example = "application/vnd.ms-excel", value = "The type or format of the file. Preferably MIME Type.")
  
    public String getFileType() {
    return fileType;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType;
  }

  public DataFile fileURL(String fileURL) {
    this.fileURL = fileURL;
    return this;
  }

  /**
   * The absolute URL where the file is located
   * @return fileURL
  **/
  @ApiModelProperty(example = "https://wiki.brapi.org/examples/datafile.xlsx", required = true, value = "The absolute URL where the file is located")
      @NotNull

    public String getFileURL() {
    return fileURL;
  }

  public void setFileURL(String fileURL) {
    this.fileURL = fileURL;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataFile dataFile = (DataFile) o;
    return Objects.equals(this.fileDescription, dataFile.fileDescription) &&
        Objects.equals(this.fileMD5Hash, dataFile.fileMD5Hash) &&
        Objects.equals(this.fileName, dataFile.fileName) &&
        Objects.equals(this.fileSize, dataFile.fileSize) &&
        Objects.equals(this.fileType, dataFile.fileType) &&
        Objects.equals(this.fileURL, dataFile.fileURL);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fileDescription, fileMD5Hash, fileName, fileSize, fileType, fileURL);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataFile {\n");
    
    sb.append("    fileDescription: ").append(toIndentedString(fileDescription)).append("\n");
    sb.append("    fileMD5Hash: ").append(toIndentedString(fileMD5Hash)).append("\n");
    sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
    sb.append("    fileSize: ").append(toIndentedString(fileSize)).append("\n");
    sb.append("    fileType: ").append(toIndentedString(fileType)).append("\n");
    sb.append("    fileURL: ").append(toIndentedString(fileURL)).append("\n");
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
