package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.GermplasmAttributeCategory;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * GermplasmAttributeCategoriesResponseResult
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-01T19:24:22.162Z")

public class GermplasmAttributeCategoriesResponseResult   {
  @JsonProperty("data")
  @Valid
  private List<GermplasmAttributeCategory> data = null;

  public GermplasmAttributeCategoriesResponseResult data(List<GermplasmAttributeCategory> data) {
    this.data = data;
    return this;
  }

  public GermplasmAttributeCategoriesResponseResult addDataItem(GermplasmAttributeCategory dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<GermplasmAttributeCategory>();
    }
    this.data.add(dataItem);
    return this;
  }

   /**
   * Get data
   * @return data
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<GermplasmAttributeCategory> getData() {
    return data;
  }

  public void setData(List<GermplasmAttributeCategory> data) {
    this.data = data;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GermplasmAttributeCategoriesResponseResult germplasmAttributeCategoriesResponseResult = (GermplasmAttributeCategoriesResponseResult) o;
    return Objects.equals(this.data, germplasmAttributeCategoriesResponseResult.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GermplasmAttributeCategoriesResponseResult {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

