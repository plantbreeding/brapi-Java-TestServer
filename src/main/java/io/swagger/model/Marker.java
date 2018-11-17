package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Marker
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-11-06T17:40:52.157-05:00[America/New_York]")

public class Marker   {
  @JsonProperty("analysisMethods")
  @Valid
  private List<String> analysisMethods = null;

  @JsonProperty("defaultDisplayName")
  private String defaultDisplayName = null;

  @JsonProperty("markerDbId")
  private String markerDbId = null;

  @JsonProperty("markerName")
  private String markerName = null;

  @JsonProperty("refAlt")
  @Valid
  private List<String> refAlt = null;

  @JsonProperty("synonyms")
  @Valid
  private List<String> synonyms = null;

  @JsonProperty("type")
  private String type = null;

  public Marker analysisMethods(List<String> analysisMethods) {
    this.analysisMethods = analysisMethods;
    return this;
  }

  public Marker addAnalysisMethodsItem(String analysisMethodsItem) {
    if (this.analysisMethods == null) {
      this.analysisMethods = new ArrayList<String>();
    }
    this.analysisMethods.add(analysisMethodsItem);
    return this;
  }

  /**
   * List of the genotyping platforms used to interrogate the marker
   * @return analysisMethods
  **/
  @ApiModelProperty(value = "List of the genotyping platforms used to interrogate the marker")


  public List<String> getAnalysisMethods() {
    return analysisMethods;
  }

  public void setAnalysisMethods(List<String> analysisMethods) {
    this.analysisMethods = analysisMethods;
  }

  public Marker defaultDisplayName(String defaultDisplayName) {
    this.defaultDisplayName = defaultDisplayName;
    return this;
  }

  /**
   * DEPRECATED in v 1.3 - see \"markerName\"
   * @return defaultDisplayName
  **/
  @ApiModelProperty(value = "DEPRECATED in v 1.3 - see \"markerName\"")


  public String getDefaultDisplayName() {
    return defaultDisplayName;
  }

  public void setDefaultDisplayName(String defaultDisplayName) {
    this.defaultDisplayName = defaultDisplayName;
  }

  public Marker markerDbId(String markerDbId) {
    this.markerDbId = markerDbId;
    return this;
  }

  /**
   * Internal db identifier
   * @return markerDbId
  **/
  @ApiModelProperty(value = "Internal db identifier")


  public String getMarkerDbId() {
    return markerDbId;
  }

  public void setMarkerDbId(String markerDbId) {
    this.markerDbId = markerDbId;
  }

  public Marker markerName(String markerName) {
    this.markerName = markerName;
    return this;
  }

  /**
   * A string representing the marker that will be meaningful to the user
   * @return markerName
  **/
  @ApiModelProperty(value = "A string representing the marker that will be meaningful to the user")


  public String getMarkerName() {
    return markerName;
  }

  public void setMarkerName(String markerName) {
    this.markerName = markerName;
  }

  public Marker refAlt(List<String> refAlt) {
    this.refAlt = refAlt;
    return this;
  }

  public Marker addRefAltItem(String refAltItem) {
    if (this.refAlt == null) {
      this.refAlt = new ArrayList<String>();
    }
    this.refAlt.add(refAltItem);
    return this;
  }

  /**
   * List of the reference (as the first item) and alternatives (the remaining items)
   * @return refAlt
  **/
  @ApiModelProperty(value = "List of the reference (as the first item) and alternatives (the remaining items)")


  public List<String> getRefAlt() {
    return refAlt;
  }

  public void setRefAlt(List<String> refAlt) {
    this.refAlt = refAlt;
  }

  public Marker synonyms(List<String> synonyms) {
    this.synonyms = synonyms;
    return this;
  }

  public Marker addSynonymsItem(String synonymsItem) {
    if (this.synonyms == null) {
      this.synonyms = new ArrayList<String>();
    }
    this.synonyms.add(synonymsItem);
    return this;
  }

  /**
   * List of other names for this marker
   * @return synonyms
  **/
  @ApiModelProperty(value = "List of other names for this marker")


  public List<String> getSynonyms() {
    return synonyms;
  }

  public void setSynonyms(List<String> synonyms) {
    this.synonyms = synonyms;
  }

  public Marker type(String type) {
    this.type = type;
    return this;
  }

  /**
   * The type of marker, e.g. SNP
   * @return type
  **/
  @ApiModelProperty(value = "The type of marker, e.g. SNP")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Marker marker = (Marker) o;
    return Objects.equals(this.analysisMethods, marker.analysisMethods) &&
        Objects.equals(this.defaultDisplayName, marker.defaultDisplayName) &&
        Objects.equals(this.markerDbId, marker.markerDbId) &&
        Objects.equals(this.markerName, marker.markerName) &&
        Objects.equals(this.refAlt, marker.refAlt) &&
        Objects.equals(this.synonyms, marker.synonyms) &&
        Objects.equals(this.type, marker.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(analysisMethods, defaultDisplayName, markerDbId, markerName, refAlt, synonyms, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Marker {\n");
    
    sb.append("    analysisMethods: ").append(toIndentedString(analysisMethods)).append("\n");
    sb.append("    defaultDisplayName: ").append(toIndentedString(defaultDisplayName)).append("\n");
    sb.append("    markerDbId: ").append(toIndentedString(markerDbId)).append("\n");
    sb.append("    markerName: ").append(toIndentedString(markerName)).append("\n");
    sb.append("    refAlt: ").append(toIndentedString(refAlt)).append("\n");
    sb.append("    synonyms: ").append(toIndentedString(synonyms)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

