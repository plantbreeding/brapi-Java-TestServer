package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.TaxonID;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * VendorPlateRequestSamples
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class VendorPlateRequestSamples   {
  @JsonProperty("column")
  private String column = null;

  @JsonProperty("concentration")
  private String concentration = null;

  @JsonProperty("row")
  private String row = null;

  @JsonProperty("sampleDbId")
  private String sampleDbId = null;

  @JsonProperty("taxonId")
  private TaxonID taxonId = null;

  @JsonProperty("tissueType")
  private String tissueType = null;

  @JsonProperty("volume")
  private String volume = null;

  @JsonProperty("well")
  private String well = null;

  public VendorPlateRequestSamples column(String column) {
    this.column = column;
    return this;
  }

   /**
   * Get column
   * @return column
  **/
  @ApiModelProperty(value = "")


  public String getColumn() {
    return column;
  }

  public void setColumn(String column) {
    this.column = column;
  }

  public VendorPlateRequestSamples concentration(String concentration) {
    this.concentration = concentration;
    return this;
  }

   /**
   * Get concentration
   * @return concentration
  **/
  @ApiModelProperty(value = "")


  public String getConcentration() {
    return concentration;
  }

  public void setConcentration(String concentration) {
    this.concentration = concentration;
  }

  public VendorPlateRequestSamples row(String row) {
    this.row = row;
    return this;
  }

   /**
   * Get row
   * @return row
  **/
  @ApiModelProperty(value = "")


  public String getRow() {
    return row;
  }

  public void setRow(String row) {
    this.row = row;
  }

  public VendorPlateRequestSamples sampleDbId(String sampleDbId) {
    this.sampleDbId = sampleDbId;
    return this;
  }

   /**
   * Get sampleDbId
   * @return sampleDbId
  **/
  @ApiModelProperty(value = "")


  public String getSampleDbId() {
    return sampleDbId;
  }

  public void setSampleDbId(String sampleDbId) {
    this.sampleDbId = sampleDbId;
  }

  public VendorPlateRequestSamples taxonId(TaxonID taxonId) {
    this.taxonId = taxonId;
    return this;
  }

   /**
   * Get taxonId
   * @return taxonId
  **/
  @ApiModelProperty(value = "")

  @Valid

  public TaxonID getTaxonId() {
    return taxonId;
  }

  public void setTaxonId(TaxonID taxonId) {
    this.taxonId = taxonId;
  }

  public VendorPlateRequestSamples tissueType(String tissueType) {
    this.tissueType = tissueType;
    return this;
  }

   /**
   * Get tissueType
   * @return tissueType
  **/
  @ApiModelProperty(value = "")


  public String getTissueType() {
    return tissueType;
  }

  public void setTissueType(String tissueType) {
    this.tissueType = tissueType;
  }

  public VendorPlateRequestSamples volume(String volume) {
    this.volume = volume;
    return this;
  }

   /**
   * Get volume
   * @return volume
  **/
  @ApiModelProperty(value = "")


  public String getVolume() {
    return volume;
  }

  public void setVolume(String volume) {
    this.volume = volume;
  }

  public VendorPlateRequestSamples well(String well) {
    this.well = well;
    return this;
  }

   /**
   * Get well
   * @return well
  **/
  @ApiModelProperty(value = "")


  public String getWell() {
    return well;
  }

  public void setWell(String well) {
    this.well = well;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VendorPlateRequestSamples vendorPlateRequestSamples = (VendorPlateRequestSamples) o;
    return Objects.equals(this.column, vendorPlateRequestSamples.column) &&
        Objects.equals(this.concentration, vendorPlateRequestSamples.concentration) &&
        Objects.equals(this.row, vendorPlateRequestSamples.row) &&
        Objects.equals(this.sampleDbId, vendorPlateRequestSamples.sampleDbId) &&
        Objects.equals(this.taxonId, vendorPlateRequestSamples.taxonId) &&
        Objects.equals(this.tissueType, vendorPlateRequestSamples.tissueType) &&
        Objects.equals(this.volume, vendorPlateRequestSamples.volume) &&
        Objects.equals(this.well, vendorPlateRequestSamples.well);
  }

  @Override
  public int hashCode() {
    return Objects.hash(column, concentration, row, sampleDbId, taxonId, tissueType, volume, well);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorPlateRequestSamples {\n");
    
    sb.append("    column: ").append(toIndentedString(column)).append("\n");
    sb.append("    concentration: ").append(toIndentedString(concentration)).append("\n");
    sb.append("    row: ").append(toIndentedString(row)).append("\n");
    sb.append("    sampleDbId: ").append(toIndentedString(sampleDbId)).append("\n");
    sb.append("    taxonId: ").append(toIndentedString(taxonId)).append("\n");
    sb.append("    tissueType: ").append(toIndentedString(tissueType)).append("\n");
    sb.append("    volume: ").append(toIndentedString(volume)).append("\n");
    sb.append("    well: ").append(toIndentedString(well)).append("\n");
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

