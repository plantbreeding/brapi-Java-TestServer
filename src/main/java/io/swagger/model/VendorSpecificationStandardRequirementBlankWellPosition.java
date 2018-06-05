package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Position data for reference blank well
 */
@ApiModel(description = "Position data for reference blank well")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class VendorSpecificationStandardRequirementBlankWellPosition   {
  @JsonProperty("numberOfBlanksPerPlate")
  private Integer numberOfBlanksPerPlate = null;

  @JsonProperty("positions")
  @Valid
  private List<String> positions = null;

  public VendorSpecificationStandardRequirementBlankWellPosition numberOfBlanksPerPlate(Integer numberOfBlanksPerPlate) {
    this.numberOfBlanksPerPlate = numberOfBlanksPerPlate;
    return this;
  }

   /**
   * Get numberOfBlanksPerPlate
   * @return numberOfBlanksPerPlate
  **/
  @ApiModelProperty(value = "")


  public Integer getNumberOfBlanksPerPlate() {
    return numberOfBlanksPerPlate;
  }

  public void setNumberOfBlanksPerPlate(Integer numberOfBlanksPerPlate) {
    this.numberOfBlanksPerPlate = numberOfBlanksPerPlate;
  }

  public VendorSpecificationStandardRequirementBlankWellPosition positions(List<String> positions) {
    this.positions = positions;
    return this;
  }

  public VendorSpecificationStandardRequirementBlankWellPosition addPositionsItem(String positionsItem) {
    if (this.positions == null) {
      this.positions = new ArrayList<String>();
    }
    this.positions.add(positionsItem);
    return this;
  }

   /**
   * Get positions
   * @return positions
  **/
  @ApiModelProperty(value = "")


  public List<String> getPositions() {
    return positions;
  }

  public void setPositions(List<String> positions) {
    this.positions = positions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VendorSpecificationStandardRequirementBlankWellPosition vendorSpecificationStandardRequirementBlankWellPosition = (VendorSpecificationStandardRequirementBlankWellPosition) o;
    return Objects.equals(this.numberOfBlanksPerPlate, vendorSpecificationStandardRequirementBlankWellPosition.numberOfBlanksPerPlate) &&
        Objects.equals(this.positions, vendorSpecificationStandardRequirementBlankWellPosition.positions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numberOfBlanksPerPlate, positions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorSpecificationStandardRequirementBlankWellPosition {\n");
    
    sb.append("    numberOfBlanksPerPlate: ").append(toIndentedString(numberOfBlanksPerPlate)).append("\n");
    sb.append("    positions: ").append(toIndentedString(positions)).append("\n");
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

