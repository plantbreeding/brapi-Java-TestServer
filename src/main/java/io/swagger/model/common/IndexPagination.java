package io.swagger.model.common;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.common.BasePagination;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * IndexPagination
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class IndexPagination extends BasePagination  {
  @JsonProperty("currentPage")
  private Integer currentPage = 0;

  public IndexPagination currentPage(Integer currentPage) {
    this.currentPage = currentPage;
    return this;
  }

  /**
   * The index number for the returned page of data. This should always match the requested page number or the default page (0).
   * @return currentPage
  **/
  @ApiModelProperty(example = "0", required = true, value = "The index number for the returned page of data. This should always match the requested page number or the default page (0).")
      @NotNull

    public Integer getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(Integer currentPage) {
    this.currentPage = currentPage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IndexPagination indexPagination = (IndexPagination) o;
    return Objects.equals(this.currentPage, indexPagination.currentPage) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentPage, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IndexPagination {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    currentPage: ").append(toIndentedString(currentPage)).append("\n");
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
