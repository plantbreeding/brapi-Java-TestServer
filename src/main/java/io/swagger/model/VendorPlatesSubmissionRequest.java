package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.VendorOrderRequestPlates;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Request object structure to submit plate data to a vendor
 */
@ApiModel(description = "Request object structure to submit plate data to a vendor")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-10-25T15:57:44.669-04:00[America/New_York]")

public class VendorPlatesSubmissionRequest   {
  @JsonProperty("clientId")
  private String clientId = null;

  @JsonProperty("numberOfSamples")
  private Integer numberOfSamples = null;

  @JsonProperty("plates")
  @Valid
  private List<VendorOrderRequestPlates> plates = null;

  /**
   * The type of Samples being submitted
   */
  public enum SampleTypeEnum {
    DNA("DNA"),
    
    RNA("RNA"),
    
    TISSUE("Tissue");

    private String value;

    SampleTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SampleTypeEnum fromValue(String text) {
      for (SampleTypeEnum b : SampleTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("sampleType")
  private SampleTypeEnum sampleType = null;

  public VendorPlatesSubmissionRequest clientId(String clientId) {
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

  public VendorPlatesSubmissionRequest numberOfSamples(Integer numberOfSamples) {
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

  public VendorPlatesSubmissionRequest plates(List<VendorOrderRequestPlates> plates) {
    this.plates = plates;
    return this;
  }

  public VendorPlatesSubmissionRequest addPlatesItem(VendorOrderRequestPlates platesItem) {
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

  public VendorPlatesSubmissionRequest sampleType(SampleTypeEnum sampleType) {
    this.sampleType = sampleType;
    return this;
  }

  /**
   * The type of Samples being submitted
   * @return sampleType
  **/
  @ApiModelProperty(value = "The type of Samples being submitted")


  public SampleTypeEnum getSampleType() {
    return sampleType;
  }

  public void setSampleType(SampleTypeEnum sampleType) {
    this.sampleType = sampleType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VendorPlatesSubmissionRequest vendorPlatesSubmissionRequest = (VendorPlatesSubmissionRequest) o;
    return Objects.equals(this.clientId, vendorPlatesSubmissionRequest.clientId) &&
        Objects.equals(this.numberOfSamples, vendorPlatesSubmissionRequest.numberOfSamples) &&
        Objects.equals(this.plates, vendorPlatesSubmissionRequest.plates) &&
        Objects.equals(this.sampleType, vendorPlatesSubmissionRequest.sampleType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientId, numberOfSamples, plates, sampleType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorPlatesSubmissionRequest {\n");
    
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    numberOfSamples: ").append(toIndentedString(numberOfSamples)).append("\n");
    sb.append("    plates: ").append(toIndentedString(plates)).append("\n");
    sb.append("    sampleType: ").append(toIndentedString(sampleType)).append("\n");
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

