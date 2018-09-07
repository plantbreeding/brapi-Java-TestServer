package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.AlleleMatrixDetails;
import io.swagger.model.Metadata;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AlleleMatrixDetailsResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class AlleleMatrixDetailsResponseResult   {
  @JsonProperty("data")
  @Valid
  private List<AlleleMatrixDetails> data = null;

  public AlleleMatrixDetailsResponseResult result(List<AlleleMatrixDetails> result) {
    this.data = result;
    return this;
  }

  public AlleleMatrixDetailsResponseResult addResultItem(AlleleMatrixDetails resultItem) {
    if (this.data == null) {
      this.data = new ArrayList<AlleleMatrixDetails>();
    }
    this.data.add(resultItem);
    return this;
  }

   /**
   * Get result
   * @return result
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AlleleMatrixDetails> getResult() {
    return data;
  }

  public void setData(List<AlleleMatrixDetails> result) {
    this.data = result;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AlleleMatrixDetailsResponseResult alleleMatrixDetailsResponse = (AlleleMatrixDetailsResponseResult) o;
    return Objects.equals(this.data, alleleMatrixDetailsResponse.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AlleleMatrixDetailsResponse {\n");
    
    sb.append("    result: ").append(toIndentedString(data)).append("\n");
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

