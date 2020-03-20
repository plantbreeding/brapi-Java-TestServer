package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * GermplasmNewRequestDonors
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
public class GermplasmNewRequestDonors   {
  @JsonProperty("donorAccessionNumber")
  private String donorAccessionNumber = null;

  @JsonProperty("donorInstituteCode")
  private String donorInstituteCode = null;

  @JsonProperty("germplasmPUI")
  private String germplasmPUI = null;

  public GermplasmNewRequestDonors donorAccessionNumber(String donorAccessionNumber) {
    this.donorAccessionNumber = donorAccessionNumber;
    return this;
  }

  /**
   * The accession number assigned by the donor  MCPD (v2.1) (DONORNUMB) 23. Identifier assigned to an accession by the donor. Follows ACCENUMB standard.
   * @return donorAccessionNumber
  **/
  @ApiModelProperty(example = "A0000123", value = "The accession number assigned by the donor  MCPD (v2.1) (DONORNUMB) 23. Identifier assigned to an accession by the donor. Follows ACCENUMB standard.")
  
    public String getDonorAccessionNumber() {
    return donorAccessionNumber;
  }

  public void setDonorAccessionNumber(String donorAccessionNumber) {
    this.donorAccessionNumber = donorAccessionNumber;
  }

  public GermplasmNewRequestDonors donorInstituteCode(String donorInstituteCode) {
    this.donorInstituteCode = donorInstituteCode;
    return this;
  }

  /**
   * The institute code for the donor institute  MCPD (v2.1) (DONORCODE) 22. FAO WIEWS code of the donor institute. Follows INSTCODE standard.
   * @return donorInstituteCode
  **/
  @ApiModelProperty(example = "PER001", value = "The institute code for the donor institute  MCPD (v2.1) (DONORCODE) 22. FAO WIEWS code of the donor institute. Follows INSTCODE standard.")
  
    public String getDonorInstituteCode() {
    return donorInstituteCode;
  }

  public void setDonorInstituteCode(String donorInstituteCode) {
    this.donorInstituteCode = donorInstituteCode;
  }

  public GermplasmNewRequestDonors germplasmPUI(String germplasmPUI) {
    this.germplasmPUI = germplasmPUI;
    return this;
  }

  /**
   * Get germplasmPUI
   * @return germplasmPUI
  **/
  @ApiModelProperty(example = "http://pui.per/accession/A0000003", value = "")
  
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
    GermplasmNewRequestDonors germplasmNewRequestDonors = (GermplasmNewRequestDonors) o;
    return Objects.equals(this.donorAccessionNumber, germplasmNewRequestDonors.donorAccessionNumber) &&
        Objects.equals(this.donorInstituteCode, germplasmNewRequestDonors.donorInstituteCode) &&
        Objects.equals(this.germplasmPUI, germplasmNewRequestDonors.germplasmPUI);
  }

  @Override
  public int hashCode() {
    return Objects.hash(donorAccessionNumber, donorInstituteCode, germplasmPUI);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GermplasmNewRequestDonors {\n");
    
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
