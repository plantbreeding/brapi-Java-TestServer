package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.LinkageGroup;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

/**
 * GenomeMapDetails
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class GenomeMapDetails   {
  @JsonProperty("data")
  @Valid
  private List<LinkageGroup> data = null;

  @JsonProperty("documentationURL")
  private String documentationURL = null;

  @JsonProperty("linkageGroups")
  @Valid
  private List<LinkageGroup> linkageGroups = null;

  @JsonProperty("mapDbId")
  private String mapDbId = null;

  @JsonProperty("mapName")
  private String mapName = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("unit")
  private String unit = null;

  public GenomeMapDetails data(List<LinkageGroup> data) {
    this.data = data;
    return this;
  }

  public GenomeMapDetails addDataItem(LinkageGroup dataItem) {
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

  public GenomeMapDetails documentationURL(String documentationURL) {
    this.documentationURL = documentationURL;
    return this;
  }

  /**
   * A URL to the human readable documentation of this object
   * @return documentationURL
  **/
  @ApiModelProperty(value = "A URL to the human readable documentation of this object")


  public String getDocumentationURL() {
    return documentationURL;
  }

  public void setDocumentationURL(String documentationURL) {
    this.documentationURL = documentationURL;
  }

  public GenomeMapDetails linkageGroups(List<LinkageGroup> linkageGroups) {
    this.linkageGroups = linkageGroups;
    return this;
  }

  public GenomeMapDetails addLinkageGroupsItem(LinkageGroup linkageGroupsItem) {
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

  public GenomeMapDetails mapDbId(String mapDbId) {
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

  public GenomeMapDetails mapName(String mapName) {
    this.mapName = mapName;
    return this;
  }

  /**
   * A human readable name for this map
   * @return mapName
  **/
  @ApiModelProperty(value = "A human readable name for this map")


  public String getMapName() {
    return mapName;
  }

  public void setMapName(String mapName) {
    this.mapName = mapName;
  }

  public GenomeMapDetails name(String name) {
    this.name = name;
    return this;
  }

  /**
   * DEPRECATED in v1.3 - Use \"mapName\"
   * @return name
  **/
  @ApiModelProperty(value = "DEPRECATED in v1.3 - Use \"mapName\"")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GenomeMapDetails type(String type) {
    this.type = type;
    return this;
  }

  /**
   * The type of map this represents, ussually \"Genetic\" or \"Physical\"
   * @return type
  **/
  @ApiModelProperty(value = "The type of map this represents, ussually \"Genetic\" or \"Physical\"")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public GenomeMapDetails unit(String unit) {
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
    GenomeMapDetails genomeMapDetails = (GenomeMapDetails) o;
    return Objects.equals(this.data, genomeMapDetails.data) &&
        Objects.equals(this.documentationURL, genomeMapDetails.documentationURL) &&
        Objects.equals(this.linkageGroups, genomeMapDetails.linkageGroups) &&
        Objects.equals(this.mapDbId, genomeMapDetails.mapDbId) &&
        Objects.equals(this.mapName, genomeMapDetails.mapName) &&
        Objects.equals(this.name, genomeMapDetails.name) &&
        Objects.equals(this.type, genomeMapDetails.type) &&
        Objects.equals(this.unit, genomeMapDetails.unit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, documentationURL, linkageGroups, mapDbId, mapName, name, type, unit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GenomeMapDetails {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    documentationURL: ").append(toIndentedString(documentationURL)).append("\n");
    sb.append("    linkageGroups: ").append(toIndentedString(linkageGroups)).append("\n");
    sb.append("    mapDbId: ").append(toIndentedString(mapDbId)).append("\n");
    sb.append("    mapName: ").append(toIndentedString(mapName)).append("\n");
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

