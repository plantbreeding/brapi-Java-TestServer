package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

/**
 * MarkerPosition
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
public class MarkerPosition   {
  @JsonProperty("additionalInfo")
  @Valid
  private Object additionalInfo = null;

  @JsonProperty("linkageGroupName")
  private String linkageGroupName = null;

  @JsonProperty("mapDbId")
  private String mapDbId = null;

  @JsonProperty("mapName")
  private String mapName = null;

  @JsonProperty("position")
  private Integer position = null;

  @JsonProperty("variantDbId")
  private String variantDbId = null;

  @JsonProperty("variantName")
  private String variantName = null;

  public MarkerPosition additionalInfo(Object additionalInfo) {
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

  public MarkerPosition linkageGroupName(String linkageGroupName) {
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

  public MarkerPosition mapDbId(String mapDbId) {
    this.mapDbId = mapDbId;
    return this;
  }

  /**
   * The unique ID of the map
   * @return mapDbId
  **/
  @ApiModelProperty(example = "3d52bdf3", value = "The unique ID of the map")
  
    public String getMapDbId() {
    return mapDbId;
  }

  public void setMapDbId(String mapDbId) {
    this.mapDbId = mapDbId;
  }

  public MarkerPosition mapName(String mapName) {
    this.mapName = mapName;
    return this;
  }

  /**
   * The human readable name of the map
   * @return mapName
  **/
  @ApiModelProperty(example = "Genome Map 1", value = "The human readable name of the map")
  
    public String getMapName() {
    return mapName;
  }

  public void setMapName(String mapName) {
    this.mapName = mapName;
  }

  public MarkerPosition position(Integer position) {
    this.position = position;
    return this;
  }

  /**
   * The position of a marker within a linkage group
   * @return position
  **/
  @ApiModelProperty(example = "2390", value = "The position of a marker within a linkage group")
  
    public Integer getPosition() {
    return position;
  }

  public void setPosition(Integer position) {
    this.position = position;
  }

  public MarkerPosition variantDbId(String variantDbId) {
    this.variantDbId = variantDbId;
    return this;
  }

  /**
   * Internal db identifier
   * @return variantDbId
  **/
  @ApiModelProperty(example = "a1eb250a", value = "Internal db identifier")
  
    public String getVariantDbId() {
    return variantDbId;
  }

  public void setVariantDbId(String variantDbId) {
    this.variantDbId = variantDbId;
  }

  public MarkerPosition variantName(String variantName) {
    this.variantName = variantName;
    return this;
  }

  /**
   * The human readable name for a marker
   * @return variantName
  **/
  @ApiModelProperty(example = "Marker_2390", value = "The human readable name for a marker")
  
    public String getVariantName() {
    return variantName;
  }

  public void setVariantName(String variantName) {
    this.variantName = variantName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MarkerPosition markerPosition = (MarkerPosition) o;
    return Objects.equals(this.additionalInfo, markerPosition.additionalInfo) &&
        Objects.equals(this.linkageGroupName, markerPosition.linkageGroupName) &&
        Objects.equals(this.mapDbId, markerPosition.mapDbId) &&
        Objects.equals(this.mapName, markerPosition.mapName) &&
        Objects.equals(this.position, markerPosition.position) &&
        Objects.equals(this.variantDbId, markerPosition.variantDbId) &&
        Objects.equals(this.variantName, markerPosition.variantName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalInfo, linkageGroupName, mapDbId, mapName, position, variantDbId, variantName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MarkerPosition {\n");
    
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    linkageGroupName: ").append(toIndentedString(linkageGroupName)).append("\n");
    sb.append("    mapDbId: ").append(toIndentedString(mapDbId)).append("\n");
    sb.append("    mapName: ").append(toIndentedString(mapName)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
    sb.append("    variantDbId: ").append(toIndentedString(variantDbId)).append("\n");
    sb.append("    variantName: ").append(toIndentedString(variantName)).append("\n");
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
