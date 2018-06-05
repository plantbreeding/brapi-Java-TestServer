package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.VendorSpecificationStandardRequirementBlankWellPosition;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * VendorSpecificationStandardRequirement
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class VendorSpecificationStandardRequirement   {
  @JsonProperty("blankWellPosition")
  private VendorSpecificationStandardRequirementBlankWellPosition blankWellPosition = null;

  @JsonProperty("inputFormatDetails")
  private String inputFormatDetails = null;

  @JsonProperty("inputFormats")
  @Valid
  private List<String> inputFormats = null;

  @JsonProperty("maxConcentration")
  private String maxConcentration = null;

  @JsonProperty("maxVolume")
  private String maxVolume = null;

  @JsonProperty("minConcentration")
  private String minConcentration = null;

  @JsonProperty("minSampleNumber")
  private String minSampleNumber = null;

  @JsonProperty("minVolume")
  private String minVolume = null;

  @JsonProperty("plateOrientation")
  private String plateOrientation = null;

  @JsonProperty("sampleTypeDetails")
  private String sampleTypeDetails = null;

  @JsonProperty("sampleTypes")
  @Valid
  private List<String> sampleTypes = null;

  public VendorSpecificationStandardRequirement blankWellPosition(VendorSpecificationStandardRequirementBlankWellPosition blankWellPosition) {
    this.blankWellPosition = blankWellPosition;
    return this;
  }

   /**
   * Get blankWellPosition
   * @return blankWellPosition
  **/
  @ApiModelProperty(value = "")

  @Valid

  public VendorSpecificationStandardRequirementBlankWellPosition getBlankWellPosition() {
    return blankWellPosition;
  }

  public void setBlankWellPosition(VendorSpecificationStandardRequirementBlankWellPosition blankWellPosition) {
    this.blankWellPosition = blankWellPosition;
  }

  public VendorSpecificationStandardRequirement inputFormatDetails(String inputFormatDetails) {
    this.inputFormatDetails = inputFormatDetails;
    return this;
  }

   /**
   * Human readable details about the accepted input formats
   * @return inputFormatDetails
  **/
  @ApiModelProperty(value = "Human readable details about the accepted input formats")


  public String getInputFormatDetails() {
    return inputFormatDetails;
  }

  public void setInputFormatDetails(String inputFormatDetails) {
    this.inputFormatDetails = inputFormatDetails;
  }

  public VendorSpecificationStandardRequirement inputFormats(List<String> inputFormats) {
    this.inputFormats = inputFormats;
    return this;
  }

  public VendorSpecificationStandardRequirement addInputFormatsItem(String inputFormatsItem) {
    if (this.inputFormats == null) {
      this.inputFormats = new ArrayList<String>();
    }
    this.inputFormats.add(inputFormatsItem);
    return this;
  }

   /**
   * List of accepted data formats
   * @return inputFormats
  **/
  @ApiModelProperty(value = "List of accepted data formats")


  public List<String> getInputFormats() {
    return inputFormats;
  }

  public void setInputFormats(List<String> inputFormats) {
    this.inputFormats = inputFormats;
  }

  public VendorSpecificationStandardRequirement maxConcentration(String maxConcentration) {
    this.maxConcentration = maxConcentration;
    return this;
  }

   /**
   * The maximum allowed concentration
   * @return maxConcentration
  **/
  @ApiModelProperty(value = "The maximum allowed concentration")


  public String getMaxConcentration() {
    return maxConcentration;
  }

  public void setMaxConcentration(String maxConcentration) {
    this.maxConcentration = maxConcentration;
  }

  public VendorSpecificationStandardRequirement maxVolume(String maxVolume) {
    this.maxVolume = maxVolume;
    return this;
  }

   /**
   * The minimum allowed volume of a sample
   * @return maxVolume
  **/
  @ApiModelProperty(value = "The minimum allowed volume of a sample")


  public String getMaxVolume() {
    return maxVolume;
  }

  public void setMaxVolume(String maxVolume) {
    this.maxVolume = maxVolume;
  }

  public VendorSpecificationStandardRequirement minConcentration(String minConcentration) {
    this.minConcentration = minConcentration;
    return this;
  }

   /**
   * the minimum allowed concentration of a sample
   * @return minConcentration
  **/
  @ApiModelProperty(value = "the minimum allowed concentration of a sample")


  public String getMinConcentration() {
    return minConcentration;
  }

  public void setMinConcentration(String minConcentration) {
    this.minConcentration = minConcentration;
  }

  public VendorSpecificationStandardRequirement minSampleNumber(String minSampleNumber) {
    this.minSampleNumber = minSampleNumber;
    return this;
  }

   /**
   * The first sample number 
   * @return minSampleNumber
  **/
  @ApiModelProperty(value = "The first sample number ")


  public String getMinSampleNumber() {
    return minSampleNumber;
  }

  public void setMinSampleNumber(String minSampleNumber) {
    this.minSampleNumber = minSampleNumber;
  }

  public VendorSpecificationStandardRequirement minVolume(String minVolume) {
    this.minVolume = minVolume;
    return this;
  }

   /**
   * The minimum allowed volume of a sample
   * @return minVolume
  **/
  @ApiModelProperty(value = "The minimum allowed volume of a sample")


  public String getMinVolume() {
    return minVolume;
  }

  public void setMinVolume(String minVolume) {
    this.minVolume = minVolume;
  }

  public VendorSpecificationStandardRequirement plateOrientation(String plateOrientation) {
    this.plateOrientation = plateOrientation;
    return this;
  }

   /**
   * The orientation of a plate
   * @return plateOrientation
  **/
  @ApiModelProperty(value = "The orientation of a plate")


  public String getPlateOrientation() {
    return plateOrientation;
  }

  public void setPlateOrientation(String plateOrientation) {
    this.plateOrientation = plateOrientation;
  }

  public VendorSpecificationStandardRequirement sampleTypeDetails(String sampleTypeDetails) {
    this.sampleTypeDetails = sampleTypeDetails;
    return this;
  }

   /**
   * Human readable details about the allowed sample types
   * @return sampleTypeDetails
  **/
  @ApiModelProperty(value = "Human readable details about the allowed sample types")


  public String getSampleTypeDetails() {
    return sampleTypeDetails;
  }

  public void setSampleTypeDetails(String sampleTypeDetails) {
    this.sampleTypeDetails = sampleTypeDetails;
  }

  public VendorSpecificationStandardRequirement sampleTypes(List<String> sampleTypes) {
    this.sampleTypes = sampleTypes;
    return this;
  }

  public VendorSpecificationStandardRequirement addSampleTypesItem(String sampleTypesItem) {
    if (this.sampleTypes == null) {
      this.sampleTypes = new ArrayList<String>();
    }
    this.sampleTypes.add(sampleTypesItem);
    return this;
  }

   /**
   * List of allowed sample types
   * @return sampleTypes
  **/
  @ApiModelProperty(value = "List of allowed sample types")


  public List<String> getSampleTypes() {
    return sampleTypes;
  }

  public void setSampleTypes(List<String> sampleTypes) {
    this.sampleTypes = sampleTypes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VendorSpecificationStandardRequirement vendorSpecificationStandardRequirement = (VendorSpecificationStandardRequirement) o;
    return Objects.equals(this.blankWellPosition, vendorSpecificationStandardRequirement.blankWellPosition) &&
        Objects.equals(this.inputFormatDetails, vendorSpecificationStandardRequirement.inputFormatDetails) &&
        Objects.equals(this.inputFormats, vendorSpecificationStandardRequirement.inputFormats) &&
        Objects.equals(this.maxConcentration, vendorSpecificationStandardRequirement.maxConcentration) &&
        Objects.equals(this.maxVolume, vendorSpecificationStandardRequirement.maxVolume) &&
        Objects.equals(this.minConcentration, vendorSpecificationStandardRequirement.minConcentration) &&
        Objects.equals(this.minSampleNumber, vendorSpecificationStandardRequirement.minSampleNumber) &&
        Objects.equals(this.minVolume, vendorSpecificationStandardRequirement.minVolume) &&
        Objects.equals(this.plateOrientation, vendorSpecificationStandardRequirement.plateOrientation) &&
        Objects.equals(this.sampleTypeDetails, vendorSpecificationStandardRequirement.sampleTypeDetails) &&
        Objects.equals(this.sampleTypes, vendorSpecificationStandardRequirement.sampleTypes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(blankWellPosition, inputFormatDetails, inputFormats, maxConcentration, maxVolume, minConcentration, minSampleNumber, minVolume, plateOrientation, sampleTypeDetails, sampleTypes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorSpecificationStandardRequirement {\n");
    
    sb.append("    blankWellPosition: ").append(toIndentedString(blankWellPosition)).append("\n");
    sb.append("    inputFormatDetails: ").append(toIndentedString(inputFormatDetails)).append("\n");
    sb.append("    inputFormats: ").append(toIndentedString(inputFormats)).append("\n");
    sb.append("    maxConcentration: ").append(toIndentedString(maxConcentration)).append("\n");
    sb.append("    maxVolume: ").append(toIndentedString(maxVolume)).append("\n");
    sb.append("    minConcentration: ").append(toIndentedString(minConcentration)).append("\n");
    sb.append("    minSampleNumber: ").append(toIndentedString(minSampleNumber)).append("\n");
    sb.append("    minVolume: ").append(toIndentedString(minVolume)).append("\n");
    sb.append("    plateOrientation: ").append(toIndentedString(plateOrientation)).append("\n");
    sb.append("    sampleTypeDetails: ").append(toIndentedString(sampleTypeDetails)).append("\n");
    sb.append("    sampleTypes: ").append(toIndentedString(sampleTypes)).append("\n");
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

