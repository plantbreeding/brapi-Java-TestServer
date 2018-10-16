package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * MarkerSummaryMap
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class MarkerSummaryMap   {
  @JsonProperty("linkageGroupName")
  private String linkageGroupName = null;

  @JsonProperty("location")
  private String location = null;

  @JsonProperty("markerDbId")
  private String markerDbId = null;

  @JsonProperty("markerName")
  private String markerName = null;

  public MarkerSummaryMap linkageGroupName(String linkageGroupName) {
    this.linkageGroupName = linkageGroupName;
    return this;
  }

   /**
   * The Uniquely Identifiable name of this linkage group
   * @return linkageGroupName
  **/
  @ApiModelProperty(value = "The Uniquely Identifiable name of this linkage group")


  public String getLinkageGroupName() {
    return linkageGroupName;
  }

  public void setLinkageGroupName(String linkageGroupName) {
    this.linkageGroupName = linkageGroupName;
  }

  public MarkerSummaryMap location(String location) {
    this.location = location;
    return this;
  }

   /**
   * The position of a marker within a linkage group
   * @return location
  **/
  @ApiModelProperty(value = "The position of a marker within a linkage group")


  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public MarkerSummaryMap markerDbId(String markerDbId) {
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

  public MarkerSummaryMap markerName(String markerName) {
    this.markerName = markerName;
    return this;
  }

   /**
   * The human readable name for a marker
   * @return markerName
  **/
  @ApiModelProperty(value = "The human readable name for a marker")


  public String getMarkerName() {
    return markerName;
  }

  public void setMarkerName(String markerName) {
    this.markerName = markerName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MarkerSummaryMap markerSummaryMap = (MarkerSummaryMap) o;
    return Objects.equals(this.linkageGroupName, markerSummaryMap.linkageGroupName) &&
        Objects.equals(this.location, markerSummaryMap.location) &&
        Objects.equals(this.markerDbId, markerSummaryMap.markerDbId) &&
        Objects.equals(this.markerName, markerSummaryMap.markerName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(linkageGroupName, location, markerDbId, markerName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MarkerSummaryMap {\n");
    
    sb.append("    linkageGroupName: ").append(toIndentedString(linkageGroupName)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    markerDbId: ").append(toIndentedString(markerDbId)).append("\n");
    sb.append("    markerName: ").append(toIndentedString(markerName)).append("\n");
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

