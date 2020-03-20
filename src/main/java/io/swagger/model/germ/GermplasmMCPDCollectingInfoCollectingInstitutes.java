package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
/**
 * GermplasmMCPDCollectingInfoCollectingInstitutes
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
public class GermplasmMCPDCollectingInfoCollectingInstitutes   {
  @JsonProperty("instituteAddress")
  private String instituteAddress = null;

  @JsonProperty("instituteCode")
  private String instituteCode = null;

  @JsonProperty("instituteName")
  private String instituteName = null;

  public GermplasmMCPDCollectingInfoCollectingInstitutes instituteAddress(String instituteAddress) {
    this.instituteAddress = instituteAddress;
    return this;
  }

  /**
   * MCPD (v2.1) (COLLINSTADDRESS) 4.1.1  Address of the institute collecting the sample. This descriptor should be used only if COLLCODE can not be filled since the FAO WIEWS code for this institute is not available. Multiple values are separated by a semicolon without space.
   * @return instituteAddress
  **/
  @ApiModelProperty(example = "123 Main Street, Lima, Peru, 5555", value = "MCPD (v2.1) (COLLINSTADDRESS) 4.1.1  Address of the institute collecting the sample. This descriptor should be used only if COLLCODE can not be filled since the FAO WIEWS code for this institute is not available. Multiple values are separated by a semicolon without space.")
  
    public String getInstituteAddress() {
    return instituteAddress;
  }

  public void setInstituteAddress(String instituteAddress) {
    this.instituteAddress = instituteAddress;
  }

  public GermplasmMCPDCollectingInfoCollectingInstitutes instituteCode(String instituteCode) {
    this.instituteCode = instituteCode;
    return this;
  }

  /**
   * MCPD (v2.1) (COLLCODE) 4.  FAO WIEWS code of the institute collecting the sample. If the holding institute has collected the material, the collecting institute code (COLLCODE) should be the same as the holding institute code (INSTCODE). Follows INSTCODE standard. Multiple values are separated by a semicolon without space.
   * @return instituteCode
  **/
  @ApiModelProperty(example = "PER001", value = "MCPD (v2.1) (COLLCODE) 4.  FAO WIEWS code of the institute collecting the sample. If the holding institute has collected the material, the collecting institute code (COLLCODE) should be the same as the holding institute code (INSTCODE). Follows INSTCODE standard. Multiple values are separated by a semicolon without space.")
  
    public String getInstituteCode() {
    return instituteCode;
  }

  public void setInstituteCode(String instituteCode) {
    this.instituteCode = instituteCode;
  }

  public GermplasmMCPDCollectingInfoCollectingInstitutes instituteName(String instituteName) {
    this.instituteName = instituteName;
    return this;
  }

  /**
   * MCPD (v2.1) (COLLNAME) 4.1  Name of the institute collecting the sample. This descriptor should be used only if COLLCODE can not be filled because the FAO WIEWS code for this institute is not available. Multiple values are separated by a semicolon without space.
   * @return instituteName
  **/
  @ApiModelProperty(example = "The BrAPI Institute", value = "MCPD (v2.1) (COLLNAME) 4.1  Name of the institute collecting the sample. This descriptor should be used only if COLLCODE can not be filled because the FAO WIEWS code for this institute is not available. Multiple values are separated by a semicolon without space.")
  
    public String getInstituteName() {
    return instituteName;
  }

  public void setInstituteName(String instituteName) {
    this.instituteName = instituteName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GermplasmMCPDCollectingInfoCollectingInstitutes germplasmMCPDCollectingInfoCollectingInstitutes = (GermplasmMCPDCollectingInfoCollectingInstitutes) o;
    return Objects.equals(this.instituteAddress, germplasmMCPDCollectingInfoCollectingInstitutes.instituteAddress) &&
        Objects.equals(this.instituteCode, germplasmMCPDCollectingInfoCollectingInstitutes.instituteCode) &&
        Objects.equals(this.instituteName, germplasmMCPDCollectingInfoCollectingInstitutes.instituteName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(instituteAddress, instituteCode, instituteName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GermplasmMCPDCollectingInfoCollectingInstitutes {\n");
    
    sb.append("    instituteAddress: ").append(toIndentedString(instituteAddress)).append("\n");
    sb.append("    instituteCode: ").append(toIndentedString(instituteCode)).append("\n");
    sb.append("    instituteName: ").append(toIndentedString(instituteName)).append("\n");
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
