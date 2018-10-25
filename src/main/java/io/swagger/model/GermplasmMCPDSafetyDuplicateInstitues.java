package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GermplasmMCPDSafetyDuplicateInstitues
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-10-25T15:57:44.669-04:00[America/New_York]")

public class GermplasmMCPDSafetyDuplicateInstitues   {
  @JsonProperty("instituteCode")
  private String instituteCode = null;

  @JsonProperty("instituteName")
  private String instituteName = null;

  public GermplasmMCPDSafetyDuplicateInstitues instituteCode(String instituteCode) {
    this.instituteCode = instituteCode;
    return this;
  }

  /**
   * MCPD (v2.1) (DUPLSITE) 25. FAO WIEWS code of the institute(s) where a safety duplicate of the accession is maintained. Follows INSTCODE standard.
   * @return instituteCode
  **/
  @ApiModelProperty(value = "MCPD (v2.1) (DUPLSITE) 25. FAO WIEWS code of the institute(s) where a safety duplicate of the accession is maintained. Follows INSTCODE standard.")


  public String getInstituteCode() {
    return instituteCode;
  }

  public void setInstituteCode(String instituteCode) {
    this.instituteCode = instituteCode;
  }

  public GermplasmMCPDSafetyDuplicateInstitues instituteName(String instituteName) {
    this.instituteName = instituteName;
    return this;
  }

  /**
   * MCPD (v2.1) (DUPLINSTNAME) 25.1  Name of the institute where a safety duplicate of the accession is maintained.
   * @return instituteName
  **/
  @ApiModelProperty(value = "MCPD (v2.1) (DUPLINSTNAME) 25.1  Name of the institute where a safety duplicate of the accession is maintained.")


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
    GermplasmMCPDSafetyDuplicateInstitues germplasmMCPDSafetyDuplicateInstitues = (GermplasmMCPDSafetyDuplicateInstitues) o;
    return Objects.equals(this.instituteCode, germplasmMCPDSafetyDuplicateInstitues.instituteCode) &&
        Objects.equals(this.instituteName, germplasmMCPDSafetyDuplicateInstitues.instituteName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(instituteCode, instituteName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GermplasmMCPDSafetyDuplicateInstitues {\n");
    
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

