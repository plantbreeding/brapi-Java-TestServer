package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GermplasmAttributeCategoryListResponseResult
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
public class GermplasmAttributeCategoryListResponseResult   {
  @JsonProperty("data")
  @Valid
  private List<String> data = new ArrayList<String>();

  public GermplasmAttributeCategoryListResponseResult data(List<String> data) {
    this.data = data;
    return this;
  }

  public GermplasmAttributeCategoryListResponseResult addDataItem(String dataItem) {
    this.data.add(dataItem);
    return this;
  }

  /**
   * Get data
   * @return data
  **/
  @ApiModelProperty(example = "[\"Morphological\",\"Agronomic\"]", required = true, value = "")
      @NotNull

    public List<String> getData() {
    return data;
  }

  public void setData(List<String> data) {
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
    GermplasmAttributeCategoryListResponseResult germplasmAttributeCategoryListResponseResult = (GermplasmAttributeCategoryListResponseResult) o;
    return Objects.equals(this.data, germplasmAttributeCategoryListResponseResult.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GermplasmAttributeCategoryListResponseResult {\n");
    
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
