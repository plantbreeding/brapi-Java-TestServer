package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ListTypes;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * NewListRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class NewListRequest   {
  @JsonProperty("data")
  @Valid
  private List<String> data = null;

  @JsonProperty("description")
  private String description = null;

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

  public NewListRequest data(List<String> data) {
    this.data = data;
    return this;
  }

  public NewListRequest addDataItem(String dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<String>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * Get data
   * @return data
  **/
  @ApiModelProperty(value = "")


  public List<String> getData() {
    return data;
  }

  public void setData(List<String> data) {
    this.data = data;
  }

  public NewListRequest description(String description) {
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

  public NewListRequest listName(String listName) {
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

  public NewListRequest listOwnerName(String listOwnerName) {
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

  public NewListRequest listOwnerPersonDbId(String listOwnerPersonDbId) {
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

  public NewListRequest listSize(Integer listSize) {
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

  public NewListRequest listSource(String listSource) {
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

  public NewListRequest listType(ListTypes listType) {
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
    NewListRequest newListRequest = (NewListRequest) o;
    return Objects.equals(this.data, newListRequest.data) &&
        Objects.equals(this.description, newListRequest.description) &&
        Objects.equals(this.listName, newListRequest.listName) &&
        Objects.equals(this.listOwnerName, newListRequest.listOwnerName) &&
        Objects.equals(this.listOwnerPersonDbId, newListRequest.listOwnerPersonDbId) &&
        Objects.equals(this.listSize, newListRequest.listSize) &&
        Objects.equals(this.listSource, newListRequest.listSource) &&
        Objects.equals(this.listType, newListRequest.listType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, description, listName, listOwnerName, listOwnerPersonDbId, listSize, listSource, listType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewListRequest {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

