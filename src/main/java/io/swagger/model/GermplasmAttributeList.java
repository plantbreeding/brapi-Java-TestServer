package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.GermplasmAttribute;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GermplasmAttributeList
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-11-06T17:40:52.157-05:00[America/New_York]")

public class GermplasmAttributeList   {
  @JsonProperty("data")
  @Valid
  private List<GermplasmAttribute> data = null;

  @JsonProperty("germplasmDbId")
  private String germplasmDbId = null;

  public GermplasmAttributeList data(List<GermplasmAttribute> data) {
    this.data = data;
    return this;
  }

  public GermplasmAttributeList addDataItem(GermplasmAttribute dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<GermplasmAttribute>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * List of attributes associated with the given germplasm
   * @return data
  **/
  @ApiModelProperty(value = "List of attributes associated with the given germplasm")

  @Valid

  public List<GermplasmAttribute> getData() {
    return data;
  }

  public void setData(List<GermplasmAttribute> data) {
    this.data = data;
  }

  public GermplasmAttributeList germplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
    return this;
  }

  /**
   * The ID which uniquely identifies a germplasm within the given database server
   * @return germplasmDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies a germplasm within the given database server")


  public String getGermplasmDbId() {
    return germplasmDbId;
  }

  public void setGermplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GermplasmAttributeList germplasmAttributeList = (GermplasmAttributeList) o;
    return Objects.equals(this.data, germplasmAttributeList.data) &&
        Objects.equals(this.germplasmDbId, germplasmAttributeList.germplasmDbId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, germplasmDbId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GermplasmAttributeList {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
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

