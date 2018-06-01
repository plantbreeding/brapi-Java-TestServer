package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.VendorPlateFile;
import io.swagger.model.VendorSample;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * VendorPlate
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-01T19:24:22.162Z")

public class VendorPlate   {
  @JsonProperty("clientPlateDbId")
  private String clientPlateDbId = null;

  @JsonProperty("files")
  @Valid
  private List<VendorPlateFile> files = null;

  @JsonProperty("plateFormat")
  private String plateFormat = null;

  @JsonProperty("sampleType")
  private String sampleType = null;

  @JsonProperty("samples")
  @Valid
  private List<VendorSample> samples = new ArrayList<VendorSample>();

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("statusTimeStamp")
  private OffsetDateTime statusTimeStamp = null;

  @JsonProperty("vendorBarcode")
  private String vendorBarcode = null;

  @JsonProperty("vendorBarcodeImageURL")
  private String vendorBarcodeImageURL = null;

  @JsonProperty("vendorPlateDbId")
  private String vendorPlateDbId = null;

  @JsonProperty("vendorProjectDbId")
  private String vendorProjectDbId = null;

  public VendorPlate clientPlateDbId(String clientPlateDbId) {
    this.clientPlateDbId = clientPlateDbId;
    return this;
  }

   /**
   * The ID which uniquely identifies this plate in the clients database
   * @return clientPlateDbId
  **/
  @ApiModelProperty(required = true, value = "The ID which uniquely identifies this plate in the clients database")
  @NotNull


  public String getClientPlateDbId() {
    return clientPlateDbId;
  }

  public void setClientPlateDbId(String clientPlateDbId) {
    this.clientPlateDbId = clientPlateDbId;
  }

  public VendorPlate files(List<VendorPlateFile> files) {
    this.files = files;
    return this;
  }

  public VendorPlate addFilesItem(VendorPlateFile filesItem) {
    if (this.files == null) {
      this.files = new ArrayList<VendorPlateFile>();
    }
    this.files.add(filesItem);
    return this;
  }

   /**
   * The array of data files produced by the vendors analysis
   * @return files
  **/
  @ApiModelProperty(value = "The array of data files produced by the vendors analysis")

  @Valid

  public List<VendorPlateFile> getFiles() {
    return files;
  }

  public void setFiles(List<VendorPlateFile> files) {
    this.files = files;
  }

  public VendorPlate plateFormat(String plateFormat) {
    this.plateFormat = plateFormat;
    return this;
  }

   /**
   * Defines the plate layout format, usually \"Plate_96\" for a 96 well plate or \"Tubes\" for plateless format
   * @return plateFormat
  **/
  @ApiModelProperty(value = "Defines the plate layout format, usually \"Plate_96\" for a 96 well plate or \"Tubes\" for plateless format")


  public String getPlateFormat() {
    return plateFormat;
  }

  public void setPlateFormat(String plateFormat) {
    this.plateFormat = plateFormat;
  }

  public VendorPlate sampleType(String sampleType) {
    this.sampleType = sampleType;
    return this;
  }

   /**
   * The type of sample. ie \"DNA\", \"RNA\", \"Tissue\", etc 
   * @return sampleType
  **/
  @ApiModelProperty(value = "The type of sample. ie \"DNA\", \"RNA\", \"Tissue\", etc ")


  public String getSampleType() {
    return sampleType;
  }

  public void setSampleType(String sampleType) {
    this.sampleType = sampleType;
  }

  public VendorPlate samples(List<VendorSample> samples) {
    this.samples = samples;
    return this;
  }

  public VendorPlate addSamplesItem(VendorSample samplesItem) {
    this.samples.add(samplesItem);
    return this;
  }

   /**
   * List of samples in the plate
   * @return samples
  **/
  @ApiModelProperty(required = true, value = "List of samples in the plate")
  @NotNull

  @Valid

  public List<VendorSample> getSamples() {
    return samples;
  }

  public void setSamples(List<VendorSample> samples) {
    this.samples = samples;
  }

  public VendorPlate status(String status) {
    this.status = status;
    return this;
  }

   /**
   * The status of the plate in the processing pipeline. Typically, \"Received\", \"Processing\", \"QC_passed\", QC_failed\", \"Completed\" (as per vendor specifications)
   * @return status
  **/
  @ApiModelProperty(required = true, value = "The status of the plate in the processing pipeline. Typically, \"Received\", \"Processing\", \"QC_passed\", QC_failed\", \"Completed\" (as per vendor specifications)")
  @NotNull


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public VendorPlate statusTimeStamp(OffsetDateTime statusTimeStamp) {
    this.statusTimeStamp = statusTimeStamp;
    return this;
  }

   /**
   * The time stamp of the most recent status update
   * @return statusTimeStamp
  **/
  @ApiModelProperty(required = true, value = "The time stamp of the most recent status update")
  @NotNull

  @Valid

  public OffsetDateTime getStatusTimeStamp() {
    return statusTimeStamp;
  }

  public void setStatusTimeStamp(OffsetDateTime statusTimeStamp) {
    this.statusTimeStamp = statusTimeStamp;
  }

  public VendorPlate vendorBarcode(String vendorBarcode) {
    this.vendorBarcode = vendorBarcode;
    return this;
  }

   /**
   * A string that can be represented as a barcode, identifying this plate 
   * @return vendorBarcode
  **/
  @ApiModelProperty(value = "A string that can be represented as a barcode, identifying this plate ")


  public String getVendorBarcode() {
    return vendorBarcode;
  }

  public void setVendorBarcode(String vendorBarcode) {
    this.vendorBarcode = vendorBarcode;
  }

  public VendorPlate vendorBarcodeImageURL(String vendorBarcodeImageURL) {
    this.vendorBarcodeImageURL = vendorBarcodeImageURL;
    return this;
  }

   /**
   * A URL pointing to an image file which has the bar code which identifies this plate
   * @return vendorBarcodeImageURL
  **/
  @ApiModelProperty(value = "A URL pointing to an image file which has the bar code which identifies this plate")


  public String getVendorBarcodeImageURL() {
    return vendorBarcodeImageURL;
  }

  public void setVendorBarcodeImageURL(String vendorBarcodeImageURL) {
    this.vendorBarcodeImageURL = vendorBarcodeImageURL;
  }

  public VendorPlate vendorPlateDbId(String vendorPlateDbId) {
    this.vendorPlateDbId = vendorPlateDbId;
    return this;
  }

   /**
   * The ID which uniquely identifies this plate in the vendors database
   * @return vendorPlateDbId
  **/
  @ApiModelProperty(required = true, value = "The ID which uniquely identifies this plate in the vendors database")
  @NotNull


  public String getVendorPlateDbId() {
    return vendorPlateDbId;
  }

  public void setVendorPlateDbId(String vendorPlateDbId) {
    this.vendorPlateDbId = vendorPlateDbId;
  }

  public VendorPlate vendorProjectDbId(String vendorProjectDbId) {
    this.vendorProjectDbId = vendorProjectDbId;
    return this;
  }

   /**
   * The ID which uniquely identifies this project in the vendors database
   * @return vendorProjectDbId
  **/
  @ApiModelProperty(required = true, value = "The ID which uniquely identifies this project in the vendors database")
  @NotNull


  public String getVendorProjectDbId() {
    return vendorProjectDbId;
  }

  public void setVendorProjectDbId(String vendorProjectDbId) {
    this.vendorProjectDbId = vendorProjectDbId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VendorPlate vendorPlate = (VendorPlate) o;
    return Objects.equals(this.clientPlateDbId, vendorPlate.clientPlateDbId) &&
        Objects.equals(this.files, vendorPlate.files) &&
        Objects.equals(this.plateFormat, vendorPlate.plateFormat) &&
        Objects.equals(this.sampleType, vendorPlate.sampleType) &&
        Objects.equals(this.samples, vendorPlate.samples) &&
        Objects.equals(this.status, vendorPlate.status) &&
        Objects.equals(this.statusTimeStamp, vendorPlate.statusTimeStamp) &&
        Objects.equals(this.vendorBarcode, vendorPlate.vendorBarcode) &&
        Objects.equals(this.vendorBarcodeImageURL, vendorPlate.vendorBarcodeImageURL) &&
        Objects.equals(this.vendorPlateDbId, vendorPlate.vendorPlateDbId) &&
        Objects.equals(this.vendorProjectDbId, vendorPlate.vendorProjectDbId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientPlateDbId, files, plateFormat, sampleType, samples, status, statusTimeStamp, vendorBarcode, vendorBarcodeImageURL, vendorPlateDbId, vendorProjectDbId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorPlate {\n");
    
    sb.append("    clientPlateDbId: ").append(toIndentedString(clientPlateDbId)).append("\n");
    sb.append("    files: ").append(toIndentedString(files)).append("\n");
    sb.append("    plateFormat: ").append(toIndentedString(plateFormat)).append("\n");
    sb.append("    sampleType: ").append(toIndentedString(sampleType)).append("\n");
    sb.append("    samples: ").append(toIndentedString(samples)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    statusTimeStamp: ").append(toIndentedString(statusTimeStamp)).append("\n");
    sb.append("    vendorBarcode: ").append(toIndentedString(vendorBarcode)).append("\n");
    sb.append("    vendorBarcodeImageURL: ").append(toIndentedString(vendorBarcodeImageURL)).append("\n");
    sb.append("    vendorPlateDbId: ").append(toIndentedString(vendorPlateDbId)).append("\n");
    sb.append("    vendorProjectDbId: ").append(toIndentedString(vendorProjectDbId)).append("\n");
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

