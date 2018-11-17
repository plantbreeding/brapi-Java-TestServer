package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.GermplasmMCPDDonorInfoDonorInstitute;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Information about the donor
 */
@ApiModel(description = "Information about the donor")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-11-06T17:40:52.157-05:00[America/New_York]")

public class GermplasmMCPDDonorInfo   {
  @JsonProperty("donorAccessionNumber")
  private String donorAccessionNumber = null;

  @JsonProperty("donorInstitute")
  private GermplasmMCPDDonorInfoDonorInstitute donorInstitute = null;

  public GermplasmMCPDDonorInfo donorAccessionNumber(String donorAccessionNumber) {
    this.donorAccessionNumber = donorAccessionNumber;
    return this;
  }

  /**
   * MCPD (v2.1) (DONORNUMB) 23. Identifier assigned to an accession by the donor. Follows ACCENUMB standard.
   * @return donorAccessionNumber
  **/
  @ApiModelProperty(value = "MCPD (v2.1) (DONORNUMB) 23. Identifier assigned to an accession by the donor. Follows ACCENUMB standard.")


  public String getDonorAccessionNumber() {
    return donorAccessionNumber;
  }

  public void setDonorAccessionNumber(String donorAccessionNumber) {
    this.donorAccessionNumber = donorAccessionNumber;
  }

  public GermplasmMCPDDonorInfo donorInstitute(GermplasmMCPDDonorInfoDonorInstitute donorInstitute) {
    this.donorInstitute = donorInstitute;
    return this;
  }

  /**
   * Get donorInstitute
   * @return donorInstitute
  **/
  @ApiModelProperty(value = "")

  @Valid

  public GermplasmMCPDDonorInfoDonorInstitute getDonorInstitute() {
    return donorInstitute;
  }

  public void setDonorInstitute(GermplasmMCPDDonorInfoDonorInstitute donorInstitute) {
    this.donorInstitute = donorInstitute;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GermplasmMCPDDonorInfo germplasmMCPDDonorInfo = (GermplasmMCPDDonorInfo) o;
    return Objects.equals(this.donorAccessionNumber, germplasmMCPDDonorInfo.donorAccessionNumber) &&
        Objects.equals(this.donorInstitute, germplasmMCPDDonorInfo.donorInstitute);
  }

  @Override
  public int hashCode() {
    return Objects.hash(donorAccessionNumber, donorInstitute);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GermplasmMCPDDonorInfo {\n");
    
    sb.append("    donorAccessionNumber: ").append(toIndentedString(donorAccessionNumber)).append("\n");
    sb.append("    donorInstitute: ").append(toIndentedString(donorInstitute)).append("\n");
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

