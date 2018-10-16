package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * GenomeMap
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class GenomeMap   {
  @JsonProperty("comments")
  private String comments = null;

  @JsonProperty("linkageGroupCount")
  private Integer linkageGroupCount = null;

  @JsonProperty("mapDbId")
  private String mapDbId = null;

  @JsonProperty("markerCount")
  private Integer markerCount = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("publishedDate")
  private LocalDate publishedDate = null;

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
  @ApiModelProperty(value = "The ID which uniquely identifies this genome map")


  public String getMapDbId() {
    return mapDbId;
  }

  public void setMapDbId(String mapDbId) {
    this.mapDbId = mapDbId;
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
   * A human readable name for this genome map
   * @return name
  **/
  @ApiModelProperty(value = "A human readable name for this genome map")


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

  public GenomeMap species(String species) {
    this.species = species;
    return this;
  }

   /**
   * The name of the species 
   * @return species
  **/
  @ApiModelProperty(value = "The name of the species ")


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
  @ApiModelProperty(value = "The type of map this represents, ussually \"Genetic\"")


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
        Objects.equals(this.linkageGroupCount, genomeMap.linkageGroupCount) &&
        Objects.equals(this.mapDbId, genomeMap.mapDbId) &&
        Objects.equals(this.markerCount, genomeMap.markerCount) &&
        Objects.equals(this.name, genomeMap.name) &&
        Objects.equals(this.publishedDate, genomeMap.publishedDate) &&
        Objects.equals(this.species, genomeMap.species) &&
        Objects.equals(this.type, genomeMap.type) &&
        Objects.equals(this.unit, genomeMap.unit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(comments, linkageGroupCount, mapDbId, markerCount, name, publishedDate, species, type, unit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GenomeMap {\n");
    
    sb.append("    comments: ").append(toIndentedString(comments)).append("\n");
    sb.append("    linkageGroupCount: ").append(toIndentedString(linkageGroupCount)).append("\n");
    sb.append("    mapDbId: ").append(toIndentedString(mapDbId)).append("\n");
    sb.append("    markerCount: ").append(toIndentedString(markerCount)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    publishedDate: ").append(toIndentedString(publishedDate)).append("\n");
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

