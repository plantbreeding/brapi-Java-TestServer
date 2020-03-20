package io.swagger.model.geno;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * Each &#x27;availableFormat&#x27; object is a pairing of dataFormat and fileFormat. These must be communicated in pairs because they are not independant parameters and sometimes one influences the other.
 */
@ApiModel(description = "Each 'availableFormat' object is a pairing of dataFormat and fileFormat. These must be communicated in pairs because they are not independant parameters and sometimes one influences the other.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
public class VariantSetAvailableFormats   {
  /**
   * dataFormat defines the structure of the data within a file (ie DartSeq, VCF, Hapmap, tabular, etc)
   */
  public enum DataFormatEnum {
    DARTSEQ("DartSeq"),
    
    VCF("VCF"),
    
    HAPMAP("Hapmap"),
    
    TABULAR("tabular"),
    
    JSON("JSON");

    private String value;

    DataFormatEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static DataFormatEnum fromValue(String text) {
      for (DataFormatEnum b : DataFormatEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("dataFormat")
  private DataFormatEnum dataFormat = null;

  /**
   * fileFormat defines the MIME type of the file (ie text/csv, application/excel, application/zip). This should also be reflected in the Accept and ContentType HTTP headers for every relevant request and response.
   */
  public enum FileFormatEnum {
    TEXT_CSV("text/csv"),
    
    TEXT_TSV("text/tsv"),
    
    APPLICATION_EXCEL("application/excel"),
    
    APPLICATION_ZIP("application/zip"),
    
    APPLICATION_JSON("application/json");

    private String value;

    FileFormatEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static FileFormatEnum fromValue(String text) {
      for (FileFormatEnum b : FileFormatEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("fileFormat")
  private FileFormatEnum fileFormat = null;

  @JsonProperty("fileURL")
  private String fileURL = null;

  public VariantSetAvailableFormats dataFormat(DataFormatEnum dataFormat) {
    this.dataFormat = dataFormat;
    return this;
  }

  /**
   * dataFormat defines the structure of the data within a file (ie DartSeq, VCF, Hapmap, tabular, etc)
   * @return dataFormat
  **/
  @ApiModelProperty(value = "dataFormat defines the structure of the data within a file (ie DartSeq, VCF, Hapmap, tabular, etc)")
  
    public DataFormatEnum getDataFormat() {
    return dataFormat;
  }

  public void setDataFormat(DataFormatEnum dataFormat) {
    this.dataFormat = dataFormat;
  }

  public VariantSetAvailableFormats fileFormat(FileFormatEnum fileFormat) {
    this.fileFormat = fileFormat;
    return this;
  }

  /**
   * fileFormat defines the MIME type of the file (ie text/csv, application/excel, application/zip). This should also be reflected in the Accept and ContentType HTTP headers for every relevant request and response.
   * @return fileFormat
  **/
  @ApiModelProperty(value = "fileFormat defines the MIME type of the file (ie text/csv, application/excel, application/zip). This should also be reflected in the Accept and ContentType HTTP headers for every relevant request and response.")
  
    public FileFormatEnum getFileFormat() {
    return fileFormat;
  }

  public void setFileFormat(FileFormatEnum fileFormat) {
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
