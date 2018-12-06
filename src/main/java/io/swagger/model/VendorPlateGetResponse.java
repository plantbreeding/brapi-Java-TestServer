package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.VendorOrderRequestPlates;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Response of a plate submission
 */
@ApiModel(description = "Response of a plate submission")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class VendorPlateGetResponse   {
  @JsonProperty("clientId")
  private String clientId = null;

  @JsonProperty("numberOfSamples")
  private Integer numberOfSamples = null;

  @JsonProperty("plates")
  @Valid
  private List<VendorOrderRequestPlates> plates = null;

  public VendorPlateGetResponse clientId(String clientId) {
    this.clientId = clientId;
    return this;
  }

  /**
   * A unique, alpha-numeric ID which identifies the client to the vendor. Used to connect the order to the contract, billing, and contact info.
   * @return clientId
  **/
  @ApiModelProperty(value = "A unique, alpha-numeric ID which identifies the client to the vendor. Used to connect the order to the contract, billing, and contact info.")


  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public VendorPlateGetResponse numberOfSamples(Integer numberOfSamples) {
    this.numberOfSamples = numberOfSamples;
    return this;
  }

  /**
   * The total number of samples contained in this request. Used for billing and basic validation of the request.
   * @return numberOfSamples
  **/
  @ApiModelProperty(value = "The total number of samples contained in this request. Used for billing and basic validation of the request.")


  public Integer getNumberOfSamples() {
    return numberOfSamples;
  }

  public void setNumberOfSamples(Integer numberOfSamples) {
    this.numberOfSamples = numberOfSamples;
  }

  public VendorPlateGetResponse plates(List<VendorOrderRequestPlates> plates) {
    this.plates = plates;
    return this;
  }

  public VendorPlateGetResponse addPlatesItem(VendorOrderRequestPlates platesItem) {
    if (this.plates == null) {
      this.plates = new ArrayList<VendorOrderRequestPlates>();
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

  public List<VendorOrderRequestPlates> getPlates() {
    return plates;
  }

  public void setPlates(List<VendorOrderRequestPlates> plates) {
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
    VendorPlateGetResponse vendorPlateGetResponse = (VendorPlateGetResponse) o;
    return Objects.equals(this.clientId, vendorPlateGetResponse.clientId) &&
        Objects.equals(this.numberOfSamples, vendorPlateGetResponse.numberOfSamples) &&
        Objects.equals(this.plates, vendorPlateGetResponse.plates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientId, numberOfSamples, plates);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorPlateGetResponse {\n");
    
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    numberOfSamples: ").append(toIndentedString(numberOfSamples)).append("\n");
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

