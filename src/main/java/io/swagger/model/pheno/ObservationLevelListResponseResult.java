package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.BrAPIResponseResult;
import io.swagger.model.pheno.ObservationUnitHierarchyLevel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;


/**
 * ObservationLevelListResponseResult
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
public class ObservationLevelListResponseResult implements BrAPIResponseResult<ObservationUnitHierarchyLevel>  {
  @JsonProperty("data")
  @Valid
  private List<ObservationUnitHierarchyLevel> data = new ArrayList<ObservationUnitHierarchyLevel>();

  public ObservationLevelListResponseResult data(List<ObservationUnitHierarchyLevel> data) {
    this.data = data;
    return this;
  }

  public ObservationLevelListResponseResult addDataItem(ObservationUnitHierarchyLevel dataItem) {
    this.data.add(dataItem);
    return this;
  }

  /**
   * Get data
   * @return data
  **/
  @ApiModelProperty(example = "[{\"levelName\":\"field\",\"levelOrder\":0},{\"levelName\":\"block\",\"levelOrder\":1},{\"levelName\":\"plot\",\"levelOrder\":2},{\"levelName\":\"sub-plot\",\"levelOrder\":3},{\"levelName\":\"plant\",\"levelOrder\":4}]", required = true, value = "")
      
    @Valid
    public List<ObservationUnitHierarchyLevel> getData() {
    return data;
  }

  public void setData(List<ObservationUnitHierarchyLevel> data) {
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
    ObservationLevelListResponseResult observationLevelListResponseResult = (ObservationLevelListResponseResult) o;
    return Objects.equals(this.data, observationLevelListResponseResult.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObservationLevelListResponseResult {\n");
    
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
