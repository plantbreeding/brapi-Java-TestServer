package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.GermplasmMCPDCollectingInfoCollectingInstitutes;
import io.swagger.model.GermplasmMCPDCollectingInfoCollectingSite;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Information about the collection of this germplasm
 */
@ApiModel(description = "Information about the collection of this germplasm")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-11-06T17:40:52.157-05:00[America/New_York]")

public class GermplasmMCPDCollectingInfo   {
  @JsonProperty("collectingDate")
  private String collectingDate = null;

  @JsonProperty("collectingInstitutes")
  @Valid
  private List<GermplasmMCPDCollectingInfoCollectingInstitutes> collectingInstitutes = null;

  @JsonProperty("collectingMissionIdentifier")
  private String collectingMissionIdentifier = null;

  @JsonProperty("collectingNumber")
  private String collectingNumber = null;

  @JsonProperty("collectingSite")
  private GermplasmMCPDCollectingInfoCollectingSite collectingSite = null;

  public GermplasmMCPDCollectingInfo collectingDate(String collectingDate) {
    this.collectingDate = collectingDate;
    return this;
  }

  /**
   * MCPD (v2.1) (COLLDATE) 17. Collecting date of the sample [YYYYMMDD] where YYYY is the year, MM is the month and DD is the day. Missing data (MM or DD) should be indicated with hyphens or \"00\" [double zero].
   * @return collectingDate
  **/
  @ApiModelProperty(value = "MCPD (v2.1) (COLLDATE) 17. Collecting date of the sample [YYYYMMDD] where YYYY is the year, MM is the month and DD is the day. Missing data (MM or DD) should be indicated with hyphens or \"00\" [double zero].")


  public String getCollectingDate() {
    return collectingDate;
  }

  public void setCollectingDate(String collectingDate) {
    this.collectingDate = collectingDate;
  }

  public GermplasmMCPDCollectingInfo collectingInstitutes(List<GermplasmMCPDCollectingInfoCollectingInstitutes> collectingInstitutes) {
    this.collectingInstitutes = collectingInstitutes;
    return this;
  }

  public GermplasmMCPDCollectingInfo addCollectingInstitutesItem(GermplasmMCPDCollectingInfoCollectingInstitutes collectingInstitutesItem) {
    if (this.collectingInstitutes == null) {
      this.collectingInstitutes = new ArrayList<GermplasmMCPDCollectingInfoCollectingInstitutes>();
    }
    this.collectingInstitutes.add(collectingInstitutesItem);
    return this;
  }

  /**
   * Institutes which collected the sample
   * @return collectingInstitutes
  **/
  @ApiModelProperty(value = "Institutes which collected the sample")

  @Valid

  public List<GermplasmMCPDCollectingInfoCollectingInstitutes> getCollectingInstitutes() {
    return collectingInstitutes;
  }

  public void setCollectingInstitutes(List<GermplasmMCPDCollectingInfoCollectingInstitutes> collectingInstitutes) {
    this.collectingInstitutes = collectingInstitutes;
  }

  public GermplasmMCPDCollectingInfo collectingMissionIdentifier(String collectingMissionIdentifier) {
    this.collectingMissionIdentifier = collectingMissionIdentifier;
    return this;
  }

  /**
   * MCPD (v2.1) (COLLMISSID) 4.2 Identifier of the collecting mission used by the Collecting Institute (4 or 4.1) (e.g. \"CIATFOR052\", \"CN426\").
   * @return collectingMissionIdentifier
  **/
  @ApiModelProperty(value = "MCPD (v2.1) (COLLMISSID) 4.2 Identifier of the collecting mission used by the Collecting Institute (4 or 4.1) (e.g. \"CIATFOR052\", \"CN426\").")


  public String getCollectingMissionIdentifier() {
    return collectingMissionIdentifier;
  }

  public void setCollectingMissionIdentifier(String collectingMissionIdentifier) {
    this.collectingMissionIdentifier = collectingMissionIdentifier;
  }

  public GermplasmMCPDCollectingInfo collectingNumber(String collectingNumber) {
    this.collectingNumber = collectingNumber;
    return this;
  }

  /**
   * MCPD (v2.1) (COLLNUMB) 3. Original identifier assigned by the collector(s) of the sample, normally composed of the name or initials of the collector(s) followed by a number (e.g. \"FM9909\"). This identifier is essential for identifying duplicates held in different collections.
   * @return collectingNumber
  **/
  @ApiModelProperty(value = "MCPD (v2.1) (COLLNUMB) 3. Original identifier assigned by the collector(s) of the sample, normally composed of the name or initials of the collector(s) followed by a number (e.g. \"FM9909\"). This identifier is essential for identifying duplicates held in different collections.")


  public String getCollectingNumber() {
    return collectingNumber;
  }

  public void setCollectingNumber(String collectingNumber) {
    this.collectingNumber = collectingNumber;
  }

  public GermplasmMCPDCollectingInfo collectingSite(GermplasmMCPDCollectingInfoCollectingSite collectingSite) {
    this.collectingSite = collectingSite;
    return this;
  }

  /**
   * Get collectingSite
   * @return collectingSite
  **/
  @ApiModelProperty(value = "")

  @Valid

  public GermplasmMCPDCollectingInfoCollectingSite getCollectingSite() {
    return collectingSite;
  }

  public void setCollectingSite(GermplasmMCPDCollectingInfoCollectingSite collectingSite) {
    this.collectingSite = collectingSite;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GermplasmMCPDCollectingInfo germplasmMCPDCollectingInfo = (GermplasmMCPDCollectingInfo) o;
    return Objects.equals(this.collectingDate, germplasmMCPDCollectingInfo.collectingDate) &&
        Objects.equals(this.collectingInstitutes, germplasmMCPDCollectingInfo.collectingInstitutes) &&
        Objects.equals(this.collectingMissionIdentifier, germplasmMCPDCollectingInfo.collectingMissionIdentifier) &&
        Objects.equals(this.collectingNumber, germplasmMCPDCollectingInfo.collectingNumber) &&
        Objects.equals(this.collectingSite, germplasmMCPDCollectingInfo.collectingSite);
  }

  @Override
  public int hashCode() {
    return Objects.hash(collectingDate, collectingInstitutes, collectingMissionIdentifier, collectingNumber, collectingSite);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GermplasmMCPDCollectingInfo {\n");
    
    sb.append("    collectingDate: ").append(toIndentedString(collectingDate)).append("\n");
    sb.append("    collectingInstitutes: ").append(toIndentedString(collectingInstitutes)).append("\n");
    sb.append("    collectingMissionIdentifier: ").append(toIndentedString(collectingMissionIdentifier)).append("\n");
    sb.append("    collectingNumber: ").append(toIndentedString(collectingNumber)).append("\n");
    sb.append("    collectingSite: ").append(toIndentedString(collectingSite)).append("\n");
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

