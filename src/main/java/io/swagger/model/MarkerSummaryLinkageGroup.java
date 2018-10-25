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
 * MarkerSummaryLinkageGroup
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-10-25T15:57:44.669-04:00[America/New_York]")

public class MarkerSummaryLinkageGroup   {
  @JsonProperty("location")
  private String location = null;

  @JsonProperty("markerDbId")
  private String markerDbId = null;

  @JsonProperty("markerName")
  private String markerName = null;

  public MarkerSummaryLinkageGroup location(String location) {
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

  public MarkerSummaryLinkageGroup markerDbId(String markerDbId) {
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

  public MarkerSummaryLinkageGroup markerName(String markerName) {
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
    MarkerSummaryLinkageGroup markerSummaryLinkageGroup = (MarkerSummaryLinkageGroup) o;
    return Objects.equals(this.location, markerSummaryLinkageGroup.location) &&
        Objects.equals(this.markerDbId, markerSummaryLinkageGroup.markerDbId) &&
        Objects.equals(this.markerName, markerSummaryLinkageGroup.markerName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(location, markerDbId, markerName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MarkerSummaryLinkageGroup {\n");
    
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

