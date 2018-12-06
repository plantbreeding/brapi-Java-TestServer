package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Image;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ImagesResponseResult
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class ImagesResponseResult   {
  @JsonProperty("data")
  @Valid
  private List<Image> data = null;

  public ImagesResponseResult data(List<Image> data) {
    this.data = data;
    return this;
  }

  public ImagesResponseResult addDataItem(Image dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<Image>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * Array of image meta data
   * @return data
  **/
  @ApiModelProperty(value = "Array of image meta data")

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
    ImagesResponseResult imagesResponseResult = (ImagesResponseResult) o;
    return Objects.equals(this.data, imagesResponseResult.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImagesResponseResult {\n");
    
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

