package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * GermplasmDonors
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-01T19:24:22.162Z")

public class GermplasmDonors   {
  @JsonProperty("donorAccessionNumber")
  private String donorAccessionNumber = null;

  @JsonProperty("donorInstituteCode")
  private String donorInstituteCode = null;

  @JsonProperty("germplasmPUI")
  private String germplasmPUI = null;

  public GermplasmDonors donorAccessionNumber(String donorAccessionNumber) {
    this.donorAccessionNumber = donorAccessionNumber;
    return this;
  }

   /**
   * Get donorAccessionNumber
   * @return donorAccessionNumber
  **/
  @ApiModelProperty(value = "")


  public String getDonorAccessionNumber() {
    return donorAccessionNumber;
  }

  public void setDonorAccessionNumber(String donorAccessionNumber) {
    this.donorAccessionNumber = donorAccessionNumber;
  }

  public GermplasmDonors donorInstituteCode(String donorInstituteCode) {
    this.donorInstituteCode = donorInstituteCode;
    return this;
  }

   /**
   * Get donorInstituteCode
   * @return donorInstituteCode
  **/
  @ApiModelProperty(value = "")


  public String getDonorInstituteCode() {
    return donorInstituteCode;
  }

  public void setDonorInstituteCode(String donorInstituteCode) {
    this.donorInstituteCode = donorInstituteCode;
  }

  public GermplasmDonors germplasmPUI(String germplasmPUI) {
    this.germplasmPUI = germplasmPUI;
    return this;
  }

   /**
   * Get germplasmPUI
   * @return germplasmPUI
  **/
  @ApiModelProperty(value = "")


  public String getGermplasmPUI() {
    return germplasmPUI;
  }

  public void setGermplasmPUI(String germplasmPUI) {
    this.germplasmPUI = germplasmPUI;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GermplasmDonors germplasmDonors = (GermplasmDonors) o;
    return Objects.equals(this.donorAccessionNumber, germplasmDonors.donorAccessionNumber) &&
        Objects.equals(this.donorInstituteCode, germplasmDonors.donorInstituteCode) &&
        Objects.equals(this.germplasmPUI, germplasmDonors.germplasmPUI);
  }

  @Override
  public int hashCode() {
    return Objects.hash(donorAccessionNumber, donorInstituteCode, germplasmPUI);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GermplasmDonors {\n");
    
    sb.append("    donorAccessionNumber: ").append(toIndentedString(donorAccessionNumber)).append("\n");
    sb.append("    donorInstituteCode: ").append(toIndentedString(donorInstituteCode)).append("\n");
    sb.append("    germplasmPUI: ").append(toIndentedString(germplasmPUI)).append("\n");
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

