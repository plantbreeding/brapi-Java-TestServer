package io.swagger.model.geno;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.WSMIMEDataTypes;

import org.springframework.validation.annotation.Validated;

/**
 * Each &#x27;availableFormat&#x27; object is a pairing of dataFormat and fileFormat. These must be communicated in pairs because they are not independant parameters and sometimes one influences the other.
 */
@ApiModel(description = "Each 'availableFormat' object is a pairing of dataFormat and fileFormat. These must be communicated in pairs because they are not independant parameters and sometimes one influences the other.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
public class VariantSetAvailableFormats   {

  @JsonProperty("dataFormat")
  private GenoFileDataFormatEnum dataFormat = null;

  @JsonProperty("fileFormat")
  private WSMIMEDataTypes fileFormat = null;

  @JsonProperty("fileURL")
  private String fileURL = null;

  public VariantSetAvailableFormats dataFormat(GenoFileDataFormatEnum dataFormat) {
    this.dataFormat = dataFormat;
    return this;
  }

  /**
   * dataFormat defines the structure of the data within a file (ie DartSeq, VCF, Hapmap, tabular, etc)
   * @return dataFormat
  **/
  @ApiModelProperty(value = "dataFormat defines the structure of the data within a file (ie DartSeq, VCF, Hapmap, tabular, etc)")
  
    public GenoFileDataFormatEnum getDataFormat() {
    return dataFormat;
  }

  public void setDataFormat(GenoFileDataFormatEnum dataFormat) {
    this.dataFormat = dataFormat;
  }

  public VariantSetAvailableFormats fileFormat(WSMIMEDataTypes fileFormat) {
    this.fileFormat = fileFormat;
    return this;
  }

  /**
   * fileFormat defines the MIME type of the file (ie text/csv, application/excel, application/zip). This should also be reflected in the Accept and ContentType HTTP headers for every relevant request and response.
   * @return fileFormat
  **/
  @ApiModelProperty(value = "fileFormat defines the MIME type of the file (ie text/csv, application/excel, application/zip). This should also be reflected in the Accept and ContentType HTTP headers for every relevant request and response.")
  
    public WSMIMEDataTypes getFileFormat() {
    return fileFormat;
  }

  public void setFileFormat(WSMIMEDataTypes fileFormat) {
    this.fileFormat = fileFormat;
  }

  public VariantSetAvailableFormats fileURL(String fileURL) {
    this.fileURL = fileURL;
    return this;
  }

  /**
   * A URL which indicates the location of the file version of this VariantSet. Could be a static file URL or an API endpoint which generates the file.
   * @return fileURL
  **/
  @ApiModelProperty(value = "A URL which indicates the location of the file version of this VariantSet. Could be a static file URL or an API endpoint which generates the file.")
  
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
    VariantSetAvailableFormats variantSetAvailableFormats = (VariantSetAvailableFormats) o;
    return Objects.equals(this.dataFormat, variantSetAvailableFormats.dataFormat) &&
        Objects.equals(this.fileFormat, variantSetAvailableFormats.fileFormat) &&
        Objects.equals(this.fileURL, variantSetAvailableFormats.fileURL);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataFormat, fileFormat, fileURL);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VariantSetAvailableFormats {\n");
    
    sb.append("    dataFormat: ").append(toIndentedString(dataFormat)).append("\n");
    sb.append("    fileFormat: ").append(toIndentedString(fileFormat)).append("\n");
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
