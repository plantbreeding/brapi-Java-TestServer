package io.swagger.model.common;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.common.MetadataBase;
import io.swagger.model.common.TokenPagination;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * MetadataTokenPagination
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class MetadataTokenPagination extends MetadataBase  {
  @JsonProperty("pagination")
  private TokenPagination pagination = null;

  public MetadataTokenPagination pagination(TokenPagination pagination) {
    this.pagination = pagination;
    return this;
  }

  /**
   * Get pagination
   * @return pagination
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public TokenPagination getPagination() {
    return pagination;
  }

  public void setPagination(TokenPagination pagination) {
    this.pagination = pagination;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MetadataTokenPagination metadataTokenPagination = (MetadataTokenPagination) o;
    return Objects.equals(this.pagination, metadataTokenPagination.pagination) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pagination, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MetadataTokenPagination {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    pagination: ").append(toIndentedString(pagination)).append("\n");
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
