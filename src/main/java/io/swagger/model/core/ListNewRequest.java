package io.swagger.model.core;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * ListNewRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class ListNewRequest extends ListBaseFields  {
  @JsonProperty("data")
  @Valid
  private List<String> data = null;

  public ListNewRequest data(List<String> data) {
    this.data = data;
    return this;
  }

  public ListNewRequest addDataItem(String dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<String>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * The list of DbIds contained in this list
   * @return data
  **/
  @ApiModelProperty(example = "[\"758a78c0\",\"2c78f9ee\"]", value = "The list of DbIds contained in this list")
  
    public List<String> getData() {
    return data;
  }

  public void setData(List<String> data) {
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
    ListNewRequest listNewRequest = (ListNewRequest) o;
    return Objects.equals(this.data, listNewRequest.data) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListNewRequest {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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
