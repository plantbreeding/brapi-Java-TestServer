package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ObservationUnitPosition;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * ObservationUnitPositionsResponseResult
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-01T19:24:22.162Z")

public class ObservationUnitPositionsResponseResult   {
  @JsonProperty("data")
  @Valid
  private List<ObservationUnitPosition> data = null;

  public ObservationUnitPositionsResponseResult data(List<ObservationUnitPosition> data) {
    this.data = data;
    return this;
  }

  public ObservationUnitPositionsResponseResult addDataItem(ObservationUnitPosition dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<ObservationUnitPosition>();
    }
    this.data.add(dataItem);
    return this;
  }

   /**
   * Get data
   * @return data
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ObservationUnitPosition> getData() {
    return data;
  }

  public void setData(List<ObservationUnitPosition> data) {
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
    ObservationUnitPositionsResponseResult observationUnitPositionsResponseResult = (ObservationUnitPositionsResponseResult) o;
    return Objects.equals(this.data, observationUnitPositionsResponseResult.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObservationUnitPositionsResponseResult {\n");
    
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

