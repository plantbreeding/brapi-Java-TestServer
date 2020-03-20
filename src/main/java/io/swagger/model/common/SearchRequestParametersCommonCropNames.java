package io.swagger.model.common;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * SearchRequestParametersCommonCropNames
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class SearchRequestParametersCommonCropNames   {
  @JsonProperty("commonCropNames")
  @Valid
  private List<String> commonCropNames = null;

  public SearchRequestParametersCommonCropNames commonCropNames(List<String> commonCropNames) {
    this.commonCropNames = commonCropNames;
    return this;
  }

  public SearchRequestParametersCommonCropNames addCommonCropNamesItem(String commonCropNamesItem) {
    if (this.commonCropNames == null) {
      this.commonCropNames = new ArrayList<String>();
    }
    this.commonCropNames.add(commonCropNamesItem);
    return this;
  }

  /**
   * Common name for the crop which this program is for
   * @return commonCropNames
  **/
  @ApiModelProperty(example = "[\"Tomatillo\",\"Paw Paw\"]", value = "Common name for the crop which this program is for")
  
    public List<String> getCommonCropNames() {
    return commonCropNames;
  }

  public void setCommonCropNames(List<String> commonCropNames) {
    this.commonCropNames = commonCropNames;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchRequestParametersCommonCropNames searchRequestParametersCommonCropNames = (SearchRequestParametersCommonCropNames) o;
    return Objects.equals(this.commonCropNames, searchRequestParametersCommonCropNames.commonCropNames);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commonCropNames);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchRequestParametersCommonCropNames {\n");
    
    sb.append("    commonCropNames: ").append(toIndentedString(commonCropNames)).append("\n");
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
