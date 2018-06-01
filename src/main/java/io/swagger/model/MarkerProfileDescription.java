package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * MarkerProfileDescription
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-01T19:24:22.162Z")

public class MarkerProfileDescription   {
  @JsonProperty("analysisMethod")
  private String analysisMethod = null;

  @JsonProperty("extractDbId")
  private String extractDbId = null;

  @JsonProperty("germplasmDbId")
  private String germplasmDbId = null;

  @JsonProperty("markerprofileDbId")
  private String markerprofileDbId = null;

  @JsonProperty("resultCount")
  private Integer resultCount = null;

  @JsonProperty("sampleDbId")
  private String sampleDbId = null;

  @JsonProperty("uniqueDisplayName")
  private String uniqueDisplayName = null;

  public MarkerProfileDescription analysisMethod(String analysisMethod) {
    this.analysisMethod = analysisMethod;
    return this;
  }

   /**
   * The type of analysis performed to determine a set of marker data
   * @return analysisMethod
  **/
  @ApiModelProperty(value = "The type of analysis performed to determine a set of marker data")


  public String getAnalysisMethod() {
    return analysisMethod;
  }

  public void setAnalysisMethod(String analysisMethod) {
    this.analysisMethod = analysisMethod;
  }

  public MarkerProfileDescription extractDbId(String extractDbId) {
    this.extractDbId = extractDbId;
    return this;
  }

   /**
   *  The ID which uniquely identifies this data extract
   * @return extractDbId
  **/
  @ApiModelProperty(value = " The ID which uniquely identifies this data extract")


  public String getExtractDbId() {
    return extractDbId;
  }

  public void setExtractDbId(String extractDbId) {
    this.extractDbId = extractDbId;
  }

  public MarkerProfileDescription germplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
    return this;
  }

   /**
   *  The ID which uniquely identifies a germplasm
   * @return germplasmDbId
  **/
  @ApiModelProperty(value = " The ID which uniquely identifies a germplasm")


  public String getGermplasmDbId() {
    return germplasmDbId;
  }

  public void setGermplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
  }

  public MarkerProfileDescription markerprofileDbId(String markerprofileDbId) {
    this.markerprofileDbId = markerprofileDbId;
    return this;
  }

   /**
   * Unique in the database. Can be a catenation of unique IDs for germplasm and extract. <strong>Required</strong>
   * @return markerprofileDbId
  **/
  @ApiModelProperty(value = "Unique in the database. Can be a catenation of unique IDs for germplasm and extract. <strong>Required</strong>")


  public String getMarkerprofileDbId() {
    return markerprofileDbId;
  }

  public void setMarkerprofileDbId(String markerprofileDbId) {
    this.markerprofileDbId = markerprofileDbId;
  }

  public MarkerProfileDescription resultCount(Integer resultCount) {
    this.resultCount = resultCount;
    return this;
  }

   /**
   * Number of markers present in the marker profile
   * @return resultCount
  **/
  @ApiModelProperty(value = "Number of markers present in the marker profile")


  public Integer getResultCount() {
    return resultCount;
  }

  public void setResultCount(Integer resultCount) {
    this.resultCount = resultCount;
  }

  public MarkerProfileDescription sampleDbId(String sampleDbId) {
    this.sampleDbId = sampleDbId;
    return this;
  }

   /**
   * The ID which uniquely identifies a sample
   * @return sampleDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies a sample")


  public String getSampleDbId() {
    return sampleDbId;
  }

  public void setSampleDbId(String sampleDbId) {
    this.sampleDbId = sampleDbId;
  }

  public MarkerProfileDescription uniqueDisplayName(String uniqueDisplayName) {
    this.uniqueDisplayName = uniqueDisplayName;
    return this;
  }

   /**
   * Human readable display name for this marker profile
   * @return uniqueDisplayName
  **/
  @ApiModelProperty(value = "Human readable display name for this marker profile")


  public String getUniqueDisplayName() {
    return uniqueDisplayName;
  }

  public void setUniqueDisplayName(String uniqueDisplayName) {
    this.uniqueDisplayName = uniqueDisplayName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MarkerProfileDescription markerProfileDescription = (MarkerProfileDescription) o;
    return Objects.equals(this.analysisMethod, markerProfileDescription.analysisMethod) &&
        Objects.equals(this.extractDbId, markerProfileDescription.extractDbId) &&
        Objects.equals(this.germplasmDbId, markerProfileDescription.germplasmDbId) &&
        Objects.equals(this.markerprofileDbId, markerProfileDescription.markerprofileDbId) &&
        Objects.equals(this.resultCount, markerProfileDescription.resultCount) &&
        Objects.equals(this.sampleDbId, markerProfileDescription.sampleDbId) &&
        Objects.equals(this.uniqueDisplayName, markerProfileDescription.uniqueDisplayName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(analysisMethod, extractDbId, germplasmDbId, markerprofileDbId, resultCount, sampleDbId, uniqueDisplayName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MarkerProfileDescription {\n");
    
    sb.append("    analysisMethod: ").append(toIndentedString(analysisMethod)).append("\n");
    sb.append("    extractDbId: ").append(toIndentedString(extractDbId)).append("\n");
    sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
    sb.append("    markerprofileDbId: ").append(toIndentedString(markerprofileDbId)).append("\n");
    sb.append("    resultCount: ").append(toIndentedString(resultCount)).append("\n");
    sb.append("    sampleDbId: ").append(toIndentedString(sampleDbId)).append("\n");
    sb.append("    uniqueDisplayName: ").append(toIndentedString(uniqueDisplayName)).append("\n");
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

