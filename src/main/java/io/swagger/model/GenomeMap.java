package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * GenomeMap
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class GenomeMap   {
  @JsonProperty("comments")
  private String comments = null;

  @JsonProperty("commonCropName")
  private String commonCropName = null;

  @JsonProperty("documentationURL")
  private String documentationURL = null;

  @JsonProperty("linkageGroupCount")
  private Integer linkageGroupCount = null;

  @JsonProperty("mapDbId")
  private String mapDbId = null;

  @JsonProperty("mapName")
  private String mapName = null;

  @JsonProperty("markerCount")
  private Integer markerCount = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("publishedDate")
  private LocalDate publishedDate = null;

  @JsonProperty("scientificName")
  private String scientificName = null;

  @JsonProperty("species")
  private String species = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("unit")
  private String unit = null;

  public GenomeMap comments(String comments) {
    this.comments = comments;
    return this;
  }

  /**
   * Additional comments
   * @return comments
  **/
  @ApiModelProperty(value = "Additional comments")


  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public GenomeMap commonCropName(String commonCropName) {
    this.commonCropName = commonCropName;
    return this;
  }

  /**
   * The common name of the crop, found from \"GET /commoncropnames\"
   * @return commonCropName
  **/
  @ApiModelProperty(required = true, value = "The common name of the crop, found from \"GET /commoncropnames\"")
  @NotNull


  public String getCommonCropName() {
    return commonCropName;
  }

  public void setCommonCropName(String commonCropName) {
    this.commonCropName = commonCropName;
  }

  public GenomeMap documentationURL(String documentationURL) {
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

  public GenomeMap linkageGroupCount(Integer linkageGroupCount) {
    this.linkageGroupCount = linkageGroupCount;
    return this;
  }

  /**
   * The number of linkage groups present in this genome map
   * @return linkageGroupCount
  **/
  @ApiModelProperty(value = "The number of linkage groups present in this genome map")


  public Integer getLinkageGroupCount() {
    return linkageGroupCount;
  }

  public void setLinkageGroupCount(Integer linkageGroupCount) {
    this.linkageGroupCount = linkageGroupCount;
  }

  public GenomeMap mapDbId(String mapDbId) {
    this.mapDbId = mapDbId;
    return this;
  }

  /**
   * The ID which uniquely identifies this genome map
   * @return mapDbId
  **/
  @ApiModelProperty(required = true, value = "The ID which uniquely identifies this genome map")
  @NotNull


  public String getMapDbId() {
    return mapDbId;
  }

  public void setMapDbId(String mapDbId) {
    this.mapDbId = mapDbId;
  }

  public GenomeMap mapName(String mapName) {
    this.mapName = mapName;
    return this;
  }

  /**
   * A human readable name for this genome map
   * @return mapName
  **/
  @ApiModelProperty(value = "A human readable name for this genome map")


  public String getMapName() {
    return mapName;
  }

  public void setMapName(String mapName) {
    this.mapName = mapName;
  }

  public GenomeMap markerCount(Integer markerCount) {
    this.markerCount = markerCount;
    return this;
  }

  /**
   * The number of markers present in this genome map
   * @return markerCount
  **/
  @ApiModelProperty(value = "The number of markers present in this genome map")


  public Integer getMarkerCount() {
    return markerCount;
  }

  public void setMarkerCount(Integer markerCount) {
    this.markerCount = markerCount;
  }

  public GenomeMap name(String name) {
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

  public GenomeMap publishedDate(LocalDate publishedDate) {
    this.publishedDate = publishedDate;
    return this;
  }

  /**
   * The date this genome was published
   * @return publishedDate
  **/
  @ApiModelProperty(value = "The date this genome was published")

  @Valid

  public LocalDate getPublishedDate() {
    return publishedDate;
  }

  public void setPublishedDate(LocalDate publishedDate) {
    this.publishedDate = publishedDate;
  }

  public GenomeMap scientificName(String scientificName) {
    this.scientificName = scientificName;
    return this;
  }

  /**
   * Full scientific binomial format name. This includes Genus, Species, and Sub-species
   * @return scientificName
  **/
  @ApiModelProperty(value = "Full scientific binomial format name. This includes Genus, Species, and Sub-species")


  public String getScientificName() {
    return scientificName;
  }

  public void setScientificName(String scientificName) {
    this.scientificName = scientificName;
  }

  public GenomeMap species(String species) {
    this.species = species;
    return this;
  }

  /**
   * DEPRECATED in v1.3 - See \"scientificName\"
   * @return species
  **/
  @ApiModelProperty(value = "DEPRECATED in v1.3 - See \"scientificName\"")


  public String getSpecies() {
    return species;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  public GenomeMap type(String type) {
    this.type = type;
    return this;
  }

  /**
   * The type of map this represents, ussually \"Genetic\"
   * @return type
  **/
  @ApiModelProperty(required = true, value = "The type of map this represents, ussually \"Genetic\"")
  @NotNull


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public GenomeMap unit(String unit) {
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
    GenomeMap genomeMap = (GenomeMap) o;
    return Objects.equals(this.comments, genomeMap.comments) &&
        Objects.equals(this.commonCropName, genomeMap.commonCropName) &&
        Objects.equals(this.documentationURL, genomeMap.documentationURL) &&
        Objects.equals(this.linkageGroupCount, genomeMap.linkageGroupCount) &&
        Objects.equals(this.mapDbId, genomeMap.mapDbId) &&
        Objects.equals(this.mapName, genomeMap.mapName) &&
        Objects.equals(this.markerCount, genomeMap.markerCount) &&
        Objects.equals(this.name, genomeMap.name) &&
        Objects.equals(this.publishedDate, genomeMap.publishedDate) &&
        Objects.equals(this.scientificName, genomeMap.scientificName) &&
        Objects.equals(this.species, genomeMap.species) &&
        Objects.equals(this.type, genomeMap.type) &&
        Objects.equals(this.unit, genomeMap.unit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(comments, commonCropName, documentationURL, linkageGroupCount, mapDbId, mapName, markerCount, name, publishedDate, scientificName, species, type, unit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GenomeMap {\n");
    
    sb.append("    comments: ").append(toIndentedString(comments)).append("\n");
    sb.append("    commonCropName: ").append(toIndentedString(commonCropName)).append("\n");
    sb.append("    documentationURL: ").append(toIndentedString(documentationURL)).append("\n");
    sb.append("    linkageGroupCount: ").append(toIndentedString(linkageGroupCount)).append("\n");
    sb.append("    mapDbId: ").append(toIndentedString(mapDbId)).append("\n");
    sb.append("    mapName: ").append(toIndentedString(mapName)).append("\n");
    sb.append("    markerCount: ").append(toIndentedString(markerCount)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    publishedDate: ").append(toIndentedString(publishedDate)).append("\n");
    sb.append("    scientificName: ").append(toIndentedString(scientificName)).append("\n");
    sb.append("    species: ").append(toIndentedString(species)).append("\n");
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

