package io.swagger.model.common;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * SearchRequestParametersTokenPaging
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class SearchRequestParametersTokenPaging   {
  @JsonProperty("pageSize")
  private Integer pageSize = null;

  @JsonProperty("pageToken")
  private String pageToken = null;

  public SearchRequestParametersTokenPaging pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

  /**
   * The size of the pages to be returned. Default is `1000`.
   * @return pageSize
  **/
  @ApiModelProperty(example = "1000", value = "The size of the pages to be returned. Default is `1000`.")
  
    public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public SearchRequestParametersTokenPaging pageToken(String pageToken) {
    this.pageToken = pageToken;
    return this;
  }

  /**
   * Used to request a specific page of data to be returned.  Tokenized pages are for large data sets which can not be efficiently broken into indexed pages. Use the nextPageToken and prevPageToken from a prior response to construct a query and move to the next or previous page respectively. 
   * @return pageToken
  **/
  @ApiModelProperty(example = "33c27874", value = "Used to request a specific page of data to be returned.  Tokenized pages are for large data sets which can not be efficiently broken into indexed pages. Use the nextPageToken and prevPageToken from a prior response to construct a query and move to the next or previous page respectively. ")
  
    public String getPageToken() {
    return pageToken;
  }

  public void setPageToken(String pageToken) {
    this.pageToken = pageToken;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchRequestParametersTokenPaging searchRequestParametersTokenPaging = (SearchRequestParametersTokenPaging) o;
    return Objects.equals(this.pageSize, searchRequestParametersTokenPaging.pageSize) &&
        Objects.equals(this.pageToken, searchRequestParametersTokenPaging.pageToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pageSize, pageToken);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchRequestParametersTokenPaging {\n");
    
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    pageToken: ").append(toIndentedString(pageToken)).append("\n");
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
