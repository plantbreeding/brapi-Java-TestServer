package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * MarkerProfile
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-01T19:24:22.162Z")

public class MarkerProfile   {
  @JsonProperty("analysisMethod")
  private String analysisMethod = null;

  @JsonProperty("data")
  @Valid
  private List<Map<String, String>> data = null;

  @JsonProperty("extractDbId")
  private String extractDbId = null;

  @JsonProperty("germplasmDbId")
  private String germplasmDbId = null;

  @JsonProperty("markerprofileDbId")
  private String markerprofileDbId = null;

  @JsonProperty("uniqueDisplayName")
  private String uniqueDisplayName = null;

  public MarkerProfile analysisMethod(String analysisMethod) {
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

  public MarkerProfile data(List<Map<String, String>> data) {
    this.data = data;
    return this;
  }

  public MarkerProfile addDataItem(Map<String, String> dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<Map<String, String>>();
    }
    this.data.add(dataItem);
    return this;
  }

   /**
   * <strong>Required</strong> array of marker-name/score pairs
   * @return data
  **/
  @ApiModelProperty(value = "<strong>Required</strong> array of marker-name/score pairs")

  @Valid

  public List<Map<String, String>> getData() {
    return data;
  }

  public void setData(List<Map<String, String>> data) {
    this.data = data;
  }

  public MarkerProfile extractDbId(String extractDbId) {
    this.extractDbId = extractDbId;
    return this;
  }

   /**
   * <strong>Required</strong>
   * @return extractDbId
  **/
  @ApiModelProperty(value = "<strong>Required</strong>")


  public String getExtractDbId() {
    return extractDbId;
  }

  public void setExtractDbId(String extractDbId) {
    this.extractDbId = extractDbId;
  }

  public MarkerProfile germplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
    return this;
  }

   /**
   * <strong>Required</strong>
   * @return germplasmDbId
  **/
  @ApiModelProperty(value = "<strong>Required</strong>")


  public String getGermplasmDbId() {
    return germplasmDbId;
  }

  public void setGermplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
  }

  public MarkerProfile markerprofileDbId(String markerprofileDbId) {
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

  public MarkerProfile uniqueDisplayName(String uniqueDisplayName) {
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
    MarkerProfile markerProfile = (MarkerProfile) o;
    return Objects.equals(this.analysisMethod, markerProfile.analysisMethod) &&
        Objects.equals(this.data, markerProfile.data) &&
        Objects.equals(this.extractDbId, markerProfile.extractDbId) &&
        Objects.equals(this.germplasmDbId, markerProfile.germplasmDbId) &&
        Objects.equals(this.markerprofileDbId, markerProfile.markerprofileDbId) &&
        Objects.equals(this.uniqueDisplayName, markerProfile.uniqueDisplayName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(analysisMethod, data, extractDbId, germplasmDbId, markerprofileDbId, uniqueDisplayName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MarkerProfile {\n");
    
    sb.append("    analysisMethod: ").append(toIndentedString(analysisMethod)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    extractDbId: ").append(toIndentedString(extractDbId)).append("\n");
    sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
    sb.append("    markerprofileDbId: ").append(toIndentedString(markerprofileDbId)).append("\n");
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

