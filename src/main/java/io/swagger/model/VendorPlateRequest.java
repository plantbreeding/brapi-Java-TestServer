package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.VendorPlateRequestPlates;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * VendorPlateRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-01T19:24:22.162Z")

public class VendorPlateRequest   {
  @JsonProperty("plates")
  @Valid
  private List<VendorPlateRequestPlates> plates = null;

  public VendorPlateRequest plates(List<VendorPlateRequestPlates> plates) {
    this.plates = plates;
    return this;
  }

  public VendorPlateRequest addPlatesItem(VendorPlateRequestPlates platesItem) {
    if (this.plates == null) {
      this.plates = new ArrayList<VendorPlateRequestPlates>();
    }
    this.plates.add(platesItem);
    return this;
  }

   /**
   * Array of new plates to be submitted to a vendor
   * @return plates
  **/
  @ApiModelProperty(value = "Array of new plates to be submitted to a vendor")

  @Valid

  public List<VendorPlateRequestPlates> getPlates() {
    return plates;
  }

  public void setPlates(List<VendorPlateRequestPlates> plates) {
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
    VendorPlateRequest vendorPlateRequest = (VendorPlateRequest) o;
    return Objects.equals(this.plates, vendorPlateRequest.plates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(plates);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorPlateRequest {\n");
    
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

