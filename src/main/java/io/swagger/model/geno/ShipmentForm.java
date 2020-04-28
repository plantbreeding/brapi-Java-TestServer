package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;


/**
 * ShipmentForm
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
public class ShipmentForm   {
  @JsonProperty("fileDescription")
  private String fileDescription = null;

  @JsonProperty("fileName")
  private String fileName = null;

  @JsonProperty("fileURL")
  private String fileURL = null;

  public ShipmentForm fileDescription(String fileDescription) {
    this.fileDescription = fileDescription;
    return this;
  }

  /**
   * The human readable long description for this form
   * @return fileDescription
  **/
  @ApiModelProperty(example = "This is a shipment manifest form", value = "The human readable long description for this form")
  
    public String getFileDescription() {
    return fileDescription;
  }

  public void setFileDescription(String fileDescription) {
    this.fileDescription = fileDescription;
  }

  public ShipmentForm fileName(String fileName) {
    this.fileName = fileName;
    return this;
  }

  /**
   * The human readable name for this form
   * @return fileName
  **/
  @ApiModelProperty(example = "Shipment Manifest", value = "The human readable name for this form")
  
    public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public ShipmentForm fileURL(String fileURL) {
    this.fileURL = fileURL;
    return this;
  }

  /**
   * The URL to download this form
   * @return fileURL
  **/
  @ApiModelProperty(example = "https://vendor.org/forms/manifest.pdf", required = true, value = "The URL to download this form")
      

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
    ShipmentForm shipmentForm = (ShipmentForm) o;
    return Objects.equals(this.fileDescription, shipmentForm.fileDescription) &&
        Objects.equals(this.fileName, shipmentForm.fileName) &&
        Objects.equals(this.fileURL, shipmentForm.fileURL);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fileDescription, fileName, fileURL);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShipmentForm {\n");
    
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
