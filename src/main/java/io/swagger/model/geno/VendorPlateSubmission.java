package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
public class VendorPlateSubmission   {
  @JsonProperty("clientId")
  private String clientId = null;

  @JsonProperty("numberOfSamples")
  private Integer numberOfSamples = null;

  @JsonProperty("plates")
  @Valid
  private List<VendorPlateSubmissionPlates> plates = new ArrayList<VendorPlateSubmissionPlates>();

  public VendorPlateSubmission clientId(String clientId) {
    this.clientId = clientId;
    return this;
  }

  /**
   * A unique, alpha-numeric ID which identifies the client to the vendor. Used to connect the order to the contract, billing, and contact info.
   * @return clientId
  **/
  @ApiModelProperty(example = "e470ae0d", required = true, value = "A unique, alpha-numeric ID which identifies the client to the vendor. Used to connect the order to the contract, billing, and contact info.")
      @NotNull

    public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public VendorPlateSubmission numberOfSamples(Integer numberOfSamples) {
    this.numberOfSamples = numberOfSamples;
    return this;
  }

  /**
   * The total number of samples contained in this request. Used for billing and basic validation of the request.
   * @return numberOfSamples
  **/
  @ApiModelProperty(example = "180", required = true, value = "The total number of samples contained in this request. Used for billing and basic validation of the request.")
      @NotNull

    public Integer getNumberOfSamples() {
    return numberOfSamples;
  }

  public void setNumberOfSamples(Integer numberOfSamples) {
    this.numberOfSamples = numberOfSamples;
  }

  public VendorPlateSubmission plates(List<VendorPlateSubmissionPlates> plates) {
    this.plates = plates;
    return this;
  }

  public VendorPlateSubmission addPlatesItem(VendorPlateSubmissionPlates platesItem) {
    this.plates.add(platesItem);
    return this;
  }

  /**
   * Array of new plates to be submitted to a vendor
   * @return plates
  **/
  @ApiModelProperty(required = true, value = "Array of new plates to be submitted to a vendor")
      @NotNull
    @Valid
    public List<VendorPlateSubmissionPlates> getPlates() {
    return plates;
  }

  public void setPlates(List<VendorPlateSubmissionPlates> plates) {
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
    VendorPlateSubmission vendorPlateSubmission = (VendorPlateSubmission) o;
    return Objects.equals(this.clientId, vendorPlateSubmission.clientId) &&
        Objects.equals(this.numberOfSamples, vendorPlateSubmission.numberOfSamples) &&
        Objects.equals(this.plates, vendorPlateSubmission.plates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientId, numberOfSamples, plates);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorPlateSubmission {\n");
    
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
