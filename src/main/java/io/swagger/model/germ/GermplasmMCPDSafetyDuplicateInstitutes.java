package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * GermplasmMCPDSafetyDuplicateInstitutes
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
public class GermplasmMCPDSafetyDuplicateInstitutes   {
  @JsonProperty("instituteCode")
  private String instituteCode = null;

  @JsonProperty("instituteName")
  private String instituteName = null;

  public GermplasmMCPDSafetyDuplicateInstitutes instituteCode(String instituteCode) {
    this.instituteCode = instituteCode;
    return this;
  }

  /**
   * MCPD (v2.1) (DUPLSITE) 25. FAO WIEWS code of the institute(s) where a safety duplicate of the accession is maintained. Follows INSTCODE standard.
   * @return instituteCode
  **/
  @ApiModelProperty(example = "PER001", value = "MCPD (v2.1) (DUPLSITE) 25. FAO WIEWS code of the institute(s) where a safety duplicate of the accession is maintained. Follows INSTCODE standard.")
  
    public String getInstituteCode() {
    return instituteCode;
  }

  public void setInstituteCode(String instituteCode) {
    this.instituteCode = instituteCode;
  }

  public GermplasmMCPDSafetyDuplicateInstitutes instituteName(String instituteName) {
    this.instituteName = instituteName;
    return this;
  }

  /**
   * MCPD (v2.1) (DUPLINSTNAME) 25.1  Name of the institute where a safety duplicate of the accession is maintained.
   * @return instituteName
  **/
  @ApiModelProperty(example = "The BrAPI Institute", value = "MCPD (v2.1) (DUPLINSTNAME) 25.1  Name of the institute where a safety duplicate of the accession is maintained.")
  
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
    GermplasmMCPDSafetyDuplicateInstitutes germplasmMCPDSafetyDuplicateInstitutes = (GermplasmMCPDSafetyDuplicateInstitutes) o;
    return Objects.equals(this.instituteCode, germplasmMCPDSafetyDuplicateInstitutes.instituteCode) &&
        Objects.equals(this.instituteName, germplasmMCPDSafetyDuplicateInstitutes.instituteName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(instituteCode, instituteName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GermplasmMCPDSafetyDuplicateInstitutes {\n");
    
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
