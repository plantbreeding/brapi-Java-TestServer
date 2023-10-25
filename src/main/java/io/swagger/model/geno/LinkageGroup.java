package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

/**
 * a Linkage Group is the BrAPI generic term for a named section of a map. A Linkage Group can represent a Chromosome, Scaffold, or Linkage Group.
 */
@ApiModel(description = "a Linkage Group is the BrAPI generic term for a named section of a map. A Linkage Group can represent a Chromosome, Scaffold, or Linkage Group.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
public class LinkageGroup   {
  @JsonProperty("additionalInfo")
  @Valid
  private Object additionalInfo = null;

  @JsonProperty("linkageGroupName")
  private String linkageGroupName = null;

  @JsonProperty("markerCount")
  private Integer markerCount = null;

  @JsonProperty("maxPosition")
  private Integer maxPosition = null;

  public LinkageGroup additionalInfo(Object additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  /**
   * Additional arbitrary info
   * @return additionalInfo
  **/
  @ApiModelProperty(value = "Additional arbitrary info")
  
    public Object getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(Object additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public LinkageGroup linkageGroupName(String linkageGroupName) {
    this.linkageGroupName = linkageGroupName;
    return this;
  }

  /**
   * The Uniquely Identifiable name of this linkage group
   * @return linkageGroupName
  **/
  @ApiModelProperty(example = "Chromosome 3", value = "The Uniquely Identifiable name of this linkage group")
  
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
  @ApiModelProperty(example = "150", value = "The number of markers associated with this linkage group")
  
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
  @ApiModelProperty(example = "2500", value = "The maximum position of a marker within this linkage group")
  
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
    return Objects.equals(this.additionalInfo, linkageGroup.additionalInfo) &&
        Objects.equals(this.linkageGroupName, linkageGroup.linkageGroupName) &&
        Objects.equals(this.markerCount, linkageGroup.markerCount) &&
        Objects.equals(this.maxPosition, linkageGroup.maxPosition);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalInfo, linkageGroupName, markerCount, maxPosition);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LinkageGroup {\n");
    
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
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
