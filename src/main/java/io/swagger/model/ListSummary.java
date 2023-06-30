package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ListTypes;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * ListSummary
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class ListSummary   {
  @JsonProperty("dateCreated")
  private OffsetDateTime dateCreated = null;

  @JsonProperty("dateModified")
  private OffsetDateTime dateModified = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("listDbId")
  private String listDbId = null;

  @JsonProperty("listName")
  private String listName = null;

  @JsonProperty("listOwnerName")
  private String listOwnerName = null;

  @JsonProperty("listOwnerPersonDbId")
  private String listOwnerPersonDbId = null;

  @JsonProperty("listSize")
  private Integer listSize = null;

  @JsonProperty("listSource")
  private String listSource = null;

  @JsonProperty("listType")
  private ListTypes listType = null;

  public ListSummary dateCreated(OffsetDateTime dateCreated) {
    this.dateCreated = dateCreated;
    return this;
  }

  /**
   * Get dateCreated
   * @return dateCreated
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(OffsetDateTime dateCreated) {
    this.dateCreated = dateCreated;
  }

  public ListSummary dateModified(OffsetDateTime dateModified) {
    this.dateModified = dateModified;
    return this;
  }

  /**
   * Get dateModified
   * @return dateModified
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getDateModified() {
    return dateModified;
  }

  public void setDateModified(OffsetDateTime dateModified) {
    this.dateModified = dateModified;
  }

  public ListSummary description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ListSummary listDbId(String listDbId) {
    this.listDbId = listDbId;
    return this;
  }

  /**
   * Get listDbId
   * @return listDbId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getListDbId() {
    return listDbId;
  }

  public void setListDbId(String listDbId) {
    this.listDbId = listDbId;
  }

  public ListSummary listName(String listName) {
    this.listName = listName;
    return this;
  }

  /**
   * Get listName
   * @return listName
  **/
  @ApiModelProperty(value = "")


  public String getListName() {
    return listName;
  }

  public void setListName(String listName) {
    this.listName = listName;
  }

  public ListSummary listOwnerName(String listOwnerName) {
    this.listOwnerName = listOwnerName;
    return this;
  }

  /**
   * Get listOwnerName
   * @return listOwnerName
  **/
  @ApiModelProperty(value = "")


  public String getListOwnerName() {
    return listOwnerName;
  }

  public void setListOwnerName(String listOwnerName) {
    this.listOwnerName = listOwnerName;
  }

  public ListSummary listOwnerPersonDbId(String listOwnerPersonDbId) {
    this.listOwnerPersonDbId = listOwnerPersonDbId;
    return this;
  }

  /**
   * Get listOwnerPersonDbId
   * @return listOwnerPersonDbId
  **/
  @ApiModelProperty(value = "")


  public String getListOwnerPersonDbId() {
    return listOwnerPersonDbId;
  }

  public void setListOwnerPersonDbId(String listOwnerPersonDbId) {
    this.listOwnerPersonDbId = listOwnerPersonDbId;
  }

  public ListSummary listSize(Integer listSize) {
    this.listSize = listSize;
    return this;
  }

  /**
   * Get listSize
   * @return listSize
  **/
  @ApiModelProperty(value = "")


  public Integer getListSize() {
    return listSize;
  }

  public void setListSize(Integer listSize) {
    this.listSize = listSize;
  }

  public ListSummary listSource(String listSource) {
    this.listSource = listSource;
    return this;
  }

  /**
   * Get listSource
   * @return listSource
  **/
  @ApiModelProperty(value = "")


  public String getListSource() {
    return listSource;
  }

  public void setListSource(String listSource) {
    this.listSource = listSource;
  }

  public ListSummary listType(ListTypes listType) {
    this.listType = listType;
    return this;
  }

  /**
   * Get listType
   * @return listType
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public ListTypes getListType() {
    return listType;
  }

  public void setListType(ListTypes listType) {
    this.listType = listType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListSummary listSummary = (ListSummary) o;
    return Objects.equals(this.dateCreated, listSummary.dateCreated) &&
        Objects.equals(this.dateModified, listSummary.dateModified) &&
        Objects.equals(this.description, listSummary.description) &&
        Objects.equals(this.listDbId, listSummary.listDbId) &&
        Objects.equals(this.listName, listSummary.listName) &&
        Objects.equals(this.listOwnerName, listSummary.listOwnerName) &&
        Objects.equals(this.listOwnerPersonDbId, listSummary.listOwnerPersonDbId) &&
        Objects.equals(this.listSize, listSummary.listSize) &&
        Objects.equals(this.listSource, listSummary.listSource) &&
        Objects.equals(this.listType, listSummary.listType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dateCreated, dateModified, description, listDbId, listName, listOwnerName, listOwnerPersonDbId, listSize, listSource, listType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListSummary {\n");
    
    sb.append("    dateCreated: ").append(toIndentedString(dateCreated)).append("\n");
    sb.append("    dateModified: ").append(toIndentedString(dateModified)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    listDbId: ").append(toIndentedString(listDbId)).append("\n");
    sb.append("    listName: ").append(toIndentedString(listName)).append("\n");
    sb.append("    listOwnerName: ").append(toIndentedString(listOwnerName)).append("\n");
    sb.append("    listOwnerPersonDbId: ").append(toIndentedString(listOwnerPersonDbId)).append("\n");
    sb.append("    listSize: ").append(toIndentedString(listSize)).append("\n");
    sb.append("    listSource: ").append(toIndentedString(listSource)).append("\n");
    sb.append("    listType: ").append(toIndentedString(listType)).append("\n");
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

