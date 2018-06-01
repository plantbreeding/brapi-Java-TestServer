package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Call;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * CallsResponseResult
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-01T19:24:22.162Z")

public class CallsResponseResult   {
  @JsonProperty("data")
  @Valid
  private List<Call> data = null;

  public CallsResponseResult data(List<Call> data) {
    this.data = data;
    return this;
  }

  public CallsResponseResult addDataItem(Call dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<Call>();
    }
    this.data.add(dataItem);
    return this;
  }

   /**
   * Array of availible calls on this server
   * @return data
  **/
  @ApiModelProperty(value = "Array of availible calls on this server")

  @Valid

  public List<Call> getData() {
    return data;
  }

  public void setData(List<Call> data) {
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
    CallsResponseResult callsResponseResult = (CallsResponseResult) o;
    return Objects.equals(this.data, callsResponseResult.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CallsResponseResult {\n");
    
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

