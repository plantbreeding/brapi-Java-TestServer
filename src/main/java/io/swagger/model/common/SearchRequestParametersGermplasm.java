package io.swagger.model.common;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * SearchRequestParametersGermplasm
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class SearchRequestParametersGermplasm   {
  @JsonProperty("germplasmDbIds")
  @Valid
  private List<String> germplasmDbIds = null;

  @JsonProperty("germplasmNames")
  @Valid
  private List<String> germplasmNames = null;

  public SearchRequestParametersGermplasm germplasmDbIds(List<String> germplasmDbIds) {
    this.germplasmDbIds = germplasmDbIds;
    return this;
  }

  public SearchRequestParametersGermplasm addGermplasmDbIdsItem(String germplasmDbIdsItem) {
    if (this.germplasmDbIds == null) {
      this.germplasmDbIds = new ArrayList<String>();
    }
    this.germplasmDbIds.add(germplasmDbIdsItem);
    return this;
  }

  /**
   * List of IDs which uniquely identify germplasm to search for
   * @return germplasmDbIds
  **/
  @ApiModelProperty(example = "[\"e9c6edd7\",\"1b1df4a6\"]", value = "List of IDs which uniquely identify germplasm to search for")
  
    public List<String> getGermplasmDbIds() {
    return germplasmDbIds;
  }

  public void setGermplasmDbIds(List<String> germplasmDbIds) {
    this.germplasmDbIds = germplasmDbIds;
  }

  public SearchRequestParametersGermplasm germplasmNames(List<String> germplasmNames) {
    this.germplasmNames = germplasmNames;
    return this;
  }

  public SearchRequestParametersGermplasm addGermplasmNamesItem(String germplasmNamesItem) {
    if (this.germplasmNames == null) {
      this.germplasmNames = new ArrayList<String>();
    }
    this.germplasmNames.add(germplasmNamesItem);
    return this;
  }

  /**
   * List of human readable names to identify germplasm to search for
   * @return germplasmNames
  **/
  @ApiModelProperty(example = "[\"A0000003\",\"A0000477\"]", value = "List of human readable names to identify germplasm to search for")
  
    public List<String> getGermplasmNames() {
    return germplasmNames;
  }

  public void setGermplasmNames(List<String> germplasmNames) {
    this.germplasmNames = germplasmNames;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchRequestParametersGermplasm searchRequestParametersGermplasm = (SearchRequestParametersGermplasm) o;
    return Objects.equals(this.germplasmDbIds, searchRequestParametersGermplasm.germplasmDbIds) &&
        Objects.equals(this.germplasmNames, searchRequestParametersGermplasm.germplasmNames);
  }

  @Override
  public int hashCode() {
    return Objects.hash(germplasmDbIds, germplasmNames);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchRequestParametersGermplasm {\n");
    
    sb.append("    germplasmDbIds: ").append(toIndentedString(germplasmDbIds)).append("\n");
    sb.append("    germplasmNames: ").append(toIndentedString(germplasmNames)).append("\n");
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
