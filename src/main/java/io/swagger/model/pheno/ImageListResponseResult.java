package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.BrAPIResponseResult;
import io.swagger.model.pheno.Image;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ImageListResponseResult
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
public class ImageListResponseResult implements BrAPIResponseResult<Image>  {
  @JsonProperty("data")
  @Valid
  private List<Image> data = new ArrayList<Image>();

  public ImageListResponseResult data(List<Image> data) {
    this.data = data;
    return this;
  }

  public ImageListResponseResult addDataItem(Image dataItem) {
    this.data.add(dataItem);
    return this;
  }

  /**
   * Array of image meta data
   * @return data
  **/
  @ApiModelProperty(required = true, value = "Array of image meta data")
      @NotNull
    @Valid
    public List<Image> getData() {
    return data;
  }

  public void setData(List<Image> data) {
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
    ImageListResponseResult imageListResponseResult = (ImageListResponseResult) o;
    return Objects.equals(this.data, imageListResponseResult.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImageListResponseResult {\n");
    
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
