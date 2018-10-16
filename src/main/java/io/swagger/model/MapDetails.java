package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.LinkageGroup;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * MapDetails
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class MapDetails   {
  @JsonProperty("data")
  @Valid
  private List<LinkageGroup> data = null;

  @JsonProperty("linkageGroups")
  @Valid
  private List<LinkageGroup> linkageGroups = null;

  @JsonProperty("mapDbId")
  private String mapDbId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("unit")
  private String unit = null;

  public MapDetails data(List<LinkageGroup> data) {
    this.data = data;
    return this;
  }

  public MapDetails addDataItem(LinkageGroup dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<LinkageGroup>();
    }
    this.data.add(dataItem);
    return this;
  }

   /**
   * List of linkage group details associated with a given map
   * @return data
  **/
  @ApiModelProperty(value = "List of linkage group details associated with a given map")

  @Valid

  public List<LinkageGroup> getData() {
    return data;
  }

  public void setData(List<LinkageGroup> data) {
    this.data = data;
  }

  public MapDetails linkageGroups(List<LinkageGroup> linkageGroups) {
    this.linkageGroups = linkageGroups;
    return this;
  }

  public MapDetails addLinkageGroupsItem(LinkageGroup linkageGroupsItem) {
    if (this.linkageGroups == null) {
      this.linkageGroups = new ArrayList<LinkageGroup>();
    }
    this.linkageGroups.add(linkageGroupsItem);
    return this;
  }

   /**
   * **Deprecated** Use \"data\"
   * @return linkageGroups
  **/
  @ApiModelProperty(value = "**Deprecated** Use \"data\"")

  @Valid

  public List<LinkageGroup> getLinkageGroups() {
    return linkageGroups;
  }

  public void setLinkageGroups(List<LinkageGroup> linkageGroups) {
    this.linkageGroups = linkageGroups;
  }

  public MapDetails mapDbId(String mapDbId) {
    this.mapDbId = mapDbId;
    return this;
  }

   /**
   * The ID which uniquely identifies this genome map
   * @return mapDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies this genome map")


  public String getMapDbId() {
    return mapDbId;
  }

  public void setMapDbId(String mapDbId) {
    this.mapDbId = mapDbId;
  }

  public MapDetails name(String name) {
    this.name = name;
    return this;
  }

   /**
   * A human readable name for this map
   * @return name
  **/
  @ApiModelProperty(value = "A human readable name for this map")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MapDetails type(String type) {
    this.type = type;
    return this;
  }

   /**
   * The type of map this represents, ussually \"Genetic\"
   * @return type
  **/
  @ApiModelProperty(value = "The type of map this represents, ussually \"Genetic\"")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public MapDetails unit(String unit) {
    this.unit = unit;
    return this;
  }

   /**
   * The units used to describe the data in this map
   * @return unit
  **/
  @ApiModelProperty(value = "The units used to describe the data in this map")


  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MapDetails mapDetails = (MapDetails) o;
    return Objects.equals(this.data, mapDetails.data) &&
        Objects.equals(this.linkageGroups, mapDetails.linkageGroups) &&
        Objects.equals(this.mapDbId, mapDetails.mapDbId) &&
        Objects.equals(this.name, mapDetails.name) &&
        Objects.equals(this.type, mapDetails.type) &&
        Objects.equals(this.unit, mapDetails.unit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, linkageGroups, mapDbId, name, type, unit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MapDetails {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    linkageGroups: ").append(toIndentedString(linkageGroups)).append("\n");
    sb.append("    mapDbId: ").append(toIndentedString(mapDbId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
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

