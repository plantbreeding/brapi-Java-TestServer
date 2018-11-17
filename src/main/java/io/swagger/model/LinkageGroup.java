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
 * LinkageGroup
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-11-06T17:40:52.157-05:00[America/New_York]")

public class LinkageGroup   {
  @JsonProperty("linkageGroupName")
  private String linkageGroupName = null;

  @JsonProperty("markerCount")
  private Integer markerCount = null;

  @JsonProperty("maxPosition")
  private Integer maxPosition = null;

  public LinkageGroup linkageGroupName(String linkageGroupName) {
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

  public LinkageGroup markerCount(Integer markerCount) {
    this.markerCount = markerCount;
    return this;
  }

  /**
   * The number of markers associated with this linkage group
   * @return markerCount
  **/
  @ApiModelProperty(value = "The number of markers associated with this linkage group")


  public Integer getMarkerCount() {
    return markerCount;
  }

  public void setMarkerCount(Integer markerCount) {
    this.markerCount = markerCount;
  }

  public LinkageGroup maxPosition(Integer maxPosition) {
    this.maxPosition = maxPosition;
    return this;
  }

  /**
   * The maximum position of a marker within this linkage group
   * @return maxPosition
  **/
  @ApiModelProperty(value = "The maximum position of a marker within this linkage group")


  public Integer getMaxPosition() {
    return maxPosition;
  }

  public void setMaxPosition(Integer maxPosition) {
    this.maxPosition = maxPosition;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LinkageGroup linkageGroup = (LinkageGroup) o;
    return Objects.equals(this.linkageGroupName, linkageGroup.linkageGroupName) &&
        Objects.equals(this.markerCount, linkageGroup.markerCount) &&
        Objects.equals(this.maxPosition, linkageGroup.maxPosition);
  }

  @Override
  public int hashCode() {
    return Objects.hash(linkageGroupName, markerCount, maxPosition);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LinkageGroup {\n");
    
    sb.append("    linkageGroupName: ").append(toIndentedString(linkageGroupName)).append("\n");
    sb.append("    markerCount: ").append(toIndentedString(markerCount)).append("\n");
    sb.append("    maxPosition: ").append(toIndentedString(maxPosition)).append("\n");
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

