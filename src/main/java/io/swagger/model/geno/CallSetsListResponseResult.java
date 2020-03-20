package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CallSetsListResponseResult
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
public class CallSetsListResponseResult   {
  @JsonProperty("data")
  @Valid
  private List<CallSet> data = new ArrayList<CallSet>();

  public CallSetsListResponseResult data(List<CallSet> data) {
    this.data = data;
    return this;
  }

  public CallSetsListResponseResult addDataItem(CallSet dataItem) {
    this.data.add(dataItem);
    return this;
  }

  /**
   * Get data
   * @return data
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull
    @Valid
    public List<CallSet> getData() {
    return data;
  }

  public void setData(List<CallSet> data) {
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
    CallSetsListResponseResult callSetsListResponseResult = (CallSetsListResponseResult) o;
    return Objects.equals(this.data, callSetsListResponseResult.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CallSetsListResponseResult {\n");
    
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
