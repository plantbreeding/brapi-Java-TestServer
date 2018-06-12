package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.VendorPlate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * VendorPlatesResponseResult
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class VendorPlatesResponseResult   {
  @JsonProperty("data")
  @Valid
  private List<VendorPlate> plates = null;

  public VendorPlatesResponseResult plates(List<VendorPlate> plates) {
    this.plates = plates;
    return this;
  }

  public VendorPlatesResponseResult addPlatesItem(VendorPlate platesItem) {
    if (this.plates == null) {
      this.plates = new ArrayList<VendorPlate>();
    }
    this.plates.add(platesItem);
    return this;
  }

   /**
   * Get plates
   * @return plates
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<VendorPlate> getPlates() {
    return plates;
  }

  public void setPlates(List<VendorPlate> plates) {
    this.plates = plates;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VendorPlatesResponseResult vendorPlatesResponseResult = (VendorPlatesResponseResult) o;
    return Objects.equals(this.plates, vendorPlatesResponseResult.plates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(plates);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorPlatesResponseResult {\n");
    
    sb.append("    plates: ").append(toIndentedString(plates)).append("\n");
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

