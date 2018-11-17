package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * VendorOrderResponseResultShipmentForms
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-11-06T17:40:52.157-05:00[America/New_York]")

public class VendorOrderResponseResultShipmentForms   {
  @JsonProperty("fileDescription")
  private String fileDescription = null;

  @JsonProperty("fileName")
  private String fileName = null;

  @JsonProperty("fileURL")
  private String fileURL = null;

  public VendorOrderResponseResultShipmentForms fileDescription(String fileDescription) {
    this.fileDescription = fileDescription;
    return this;
  }

  /**
   * The human readable long description for this form
   * @return fileDescription
  **/
  @ApiModelProperty(value = "The human readable long description for this form")


  public String getFileDescription() {
    return fileDescription;
  }

  public void setFileDescription(String fileDescription) {
    this.fileDescription = fileDescription;
  }

  public VendorOrderResponseResultShipmentForms fileName(String fileName) {
    this.fileName = fileName;
    return this;
  }

  /**
   * The human readable name for this form
   * @return fileName
  **/
  @ApiModelProperty(value = "The human readable name for this form")


  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public VendorOrderResponseResultShipmentForms fileURL(String fileURL) {
    this.fileURL = fileURL;
    return this;
  }

  /**
   * The URL to download this form
   * @return fileURL
  **/
  @ApiModelProperty(value = "The URL to download this form")


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
    VendorOrderResponseResultShipmentForms vendorOrderResponseResultShipmentForms = (VendorOrderResponseResultShipmentForms) o;
    return Objects.equals(this.fileDescription, vendorOrderResponseResultShipmentForms.fileDescription) &&
        Objects.equals(this.fileName, vendorOrderResponseResultShipmentForms.fileName) &&
        Objects.equals(this.fileURL, vendorOrderResponseResultShipmentForms.fileURL);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fileDescription, fileName, fileURL);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorOrderResponseResultShipmentForms {\n");
    
    sb.append("    fileDescription: ").append(toIndentedString(fileDescription)).append("\n");
    sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
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

