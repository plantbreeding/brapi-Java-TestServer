package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.VendorPlateRequestSamples;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * VendorPlateRequestPlates
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class VendorPlateRequestPlates   {
  @JsonProperty("clientPlateDbId")
  private String clientPlateDbId = null;

  @JsonProperty("plateFormat")
  private String plateFormat = null;

  @JsonProperty("sampleType")
  private String sampleType = null;

  @JsonProperty("samples")
  @Valid
  private List<VendorPlateRequestSamples> samples = null;

  @JsonProperty("vendorProjectDbId")
  private String vendorProjectDbId = null;

  public VendorPlateRequestPlates clientPlateDbId(String clientPlateDbId) {
    this.clientPlateDbId = clientPlateDbId;
    return this;
  }

   /**
   * The ID which uniquely identifies this plate in the clients database
   * @return clientPlateDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies this plate in the clients database")


  public String getClientPlateDbId() {
    return clientPlateDbId;
  }

  public void setClientPlateDbId(String clientPlateDbId) {
    this.clientPlateDbId = clientPlateDbId;
  }

  public VendorPlateRequestPlates plateFormat(String plateFormat) {
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

  public VendorPlateRequestPlates sampleType(String sampleType) {
    this.sampleType = sampleType;
    return this;
  }

   /**
   * Get sampleType
   * @return sampleType
  **/
  @ApiModelProperty(value = "")


  public String getSampleType() {
    return sampleType;
  }

  public void setSampleType(String sampleType) {
    this.sampleType = sampleType;
  }

  public VendorPlateRequestPlates samples(List<VendorPlateRequestSamples> samples) {
    this.samples = samples;
    return this;
  }

  public VendorPlateRequestPlates addSamplesItem(VendorPlateRequestSamples samplesItem) {
    if (this.samples == null) {
      this.samples = new ArrayList<VendorPlateRequestSamples>();
    }
    this.samples.add(samplesItem);
    return this;
  }

   /**
   * Get samples
   * @return samples
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<VendorPlateRequestSamples> getSamples() {
    return samples;
  }

  public void setSamples(List<VendorPlateRequestSamples> samples) {
    this.samples = samples;
  }

  public VendorPlateRequestPlates vendorProjectDbId(String vendorProjectDbId) {
    this.vendorProjectDbId = vendorProjectDbId;
    return this;
  }

   /**
   * Get vendorProjectDbId
   * @return vendorProjectDbId
  **/
  @ApiModelProperty(value = "")


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
    VendorPlateRequestPlates vendorPlateRequestPlates = (VendorPlateRequestPlates) o;
    return Objects.equals(this.clientPlateDbId, vendorPlateRequestPlates.clientPlateDbId) &&
        Objects.equals(this.plateFormat, vendorPlateRequestPlates.plateFormat) &&
        Objects.equals(this.sampleType, vendorPlateRequestPlates.sampleType) &&
        Objects.equals(this.samples, vendorPlateRequestPlates.samples) &&
        Objects.equals(this.vendorProjectDbId, vendorPlateRequestPlates.vendorProjectDbId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientPlateDbId, plateFormat, sampleType, samples, vendorProjectDbId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorPlateRequestPlates {\n");
    
    sb.append("    clientPlateDbId: ").append(toIndentedString(clientPlateDbId)).append("\n");
    sb.append("    plateFormat: ").append(toIndentedString(plateFormat)).append("\n");
    sb.append("    sampleType: ").append(toIndentedString(sampleType)).append("\n");
    sb.append("    samples: ").append(toIndentedString(samples)).append("\n");
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

