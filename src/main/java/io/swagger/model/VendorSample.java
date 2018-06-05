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
 * VendorSample
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class VendorSample   {
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

  public VendorSample column(String column) {
    this.column = column;
    return this;
  }

   /**
   * The sample column index number in a plate
   * @return column
  **/
  @ApiModelProperty(value = "The sample column index number in a plate")


  public String getColumn() {
    return column;
  }

  public void setColumn(String column) {
    this.column = column;
  }

  public VendorSample concentration(String concentration) {
    this.concentration = concentration;
    return this;
  }

   /**
   * The concentration of a sample in solution
   * @return concentration
  **/
  @ApiModelProperty(value = "The concentration of a sample in solution")


  public String getConcentration() {
    return concentration;
  }

  public void setConcentration(String concentration) {
    this.concentration = concentration;
  }

  public VendorSample row(String row) {
    this.row = row;
    return this;
  }

   /**
   * the sample row index number in a plate
   * @return row
  **/
  @ApiModelProperty(value = "the sample row index number in a plate")


  public String getRow() {
    return row;
  }

  public void setRow(String row) {
    this.row = row;
  }

  public VendorSample sampleDbId(String sampleDbId) {
    this.sampleDbId = sampleDbId;
    return this;
  }

   /**
   * The ID which uniquely identifies a sample
   * @return sampleDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies a sample")


  public String getSampleDbId() {
    return sampleDbId;
  }

  public void setSampleDbId(String sampleDbId) {
    this.sampleDbId = sampleDbId;
  }

  public VendorSample taxonId(TaxonID taxonId) {
    this.taxonId = taxonId;
    return this;
  }

   /**
   * The identifier (name, ID, URI) of a particular taxonomy within the source provider
   * @return taxonId
  **/
  @ApiModelProperty(value = "The identifier (name, ID, URI) of a particular taxonomy within the source provider")

  @Valid

  public TaxonID getTaxonId() {
    return taxonId;
  }

  public void setTaxonId(TaxonID taxonId) {
    this.taxonId = taxonId;
  }

  public VendorSample tissueType(String tissueType) {
    this.tissueType = tissueType;
    return this;
  }

   /**
   * The type of tissue sampled. ex. 'Leaf', 'Root', etc.
   * @return tissueType
  **/
  @ApiModelProperty(value = "The type of tissue sampled. ex. 'Leaf', 'Root', etc.")


  public String getTissueType() {
    return tissueType;
  }

  public void setTissueType(String tissueType) {
    this.tissueType = tissueType;
  }

  public VendorSample volume(String volume) {
    this.volume = volume;
    return this;
  }

   /**
   * The physical volume of a sample
   * @return volume
  **/
  @ApiModelProperty(value = "The physical volume of a sample")


  public String getVolume() {
    return volume;
  }

  public void setVolume(String volume) {
    this.volume = volume;
  }

  public VendorSample well(String well) {
    this.well = well;
    return this;
  }

   /**
   * The plate well number where a sample is located
   * @return well
  **/
  @ApiModelProperty(value = "The plate well number where a sample is located")


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
    VendorSample vendorSample = (VendorSample) o;
    return Objects.equals(this.column, vendorSample.column) &&
        Objects.equals(this.concentration, vendorSample.concentration) &&
        Objects.equals(this.row, vendorSample.row) &&
        Objects.equals(this.sampleDbId, vendorSample.sampleDbId) &&
        Objects.equals(this.taxonId, vendorSample.taxonId) &&
        Objects.equals(this.tissueType, vendorSample.tissueType) &&
        Objects.equals(this.volume, vendorSample.volume) &&
        Objects.equals(this.well, vendorSample.well);
  }

  @Override
  public int hashCode() {
    return Objects.hash(column, concentration, row, sampleDbId, taxonId, tissueType, volume, well);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorSample {\n");
    
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

