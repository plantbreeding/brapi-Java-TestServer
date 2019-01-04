package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * SuccessfulSearchResponseResult
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class SuccessfulSearchResponseResult   {
  @JsonProperty("searchResultDbId")
  private String searchResultDbId = null;

  public SuccessfulSearchResponseResult searchResultDbId(String searchResultDbId) {
    this.searchResultDbId = searchResultDbId;
    return this;
  }

  /**
   * Get searchResultDbId
   * @return searchResultDbId
  **/
  @ApiModelProperty(value = "")


  public String getSearchResultDbId() {
    return searchResultDbId;
  }

  public void setSearchResultDbId(String searchResultDbId) {
    this.searchResultDbId = searchResultDbId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessfulSearchResponseResult successfulSearchResponseResult = (SuccessfulSearchResponseResult) o;
    return Objects.equals(this.searchResultDbId, successfulSearchResponseResult.searchResultDbId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(searchResultDbId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessfulSearchResponseResult {\n");
    
    sb.append("    searchResultDbId: ").append(toIndentedString(searchResultDbId)).append("\n");
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

