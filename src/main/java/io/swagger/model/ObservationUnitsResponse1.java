package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Metadata;
import io.swagger.model.ObservationUnitsResponse1Result;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

/**
 * ObservationUnitsResponse1
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class ObservationUnitsResponse1   {
  @JsonProperty("metadata")
  private Metadata metadata = null;

  @JsonProperty("result")
  private ObservationUnitsResponse1Result result = null;

  public ObservationUnitsResponse1 metadata(Metadata metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Get metadata
   * @return metadata
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Metadata getMetadata() {
    return metadata;
  }

  public void setMetadata(Metadata metadata) {
    this.metadata = metadata;
  }

  public ObservationUnitsResponse1 result(ObservationUnitsResponse1Result result) {
    this.result = result;
    return this;
  }

  /**
   * Get result
   * @return result
  **/
  @ApiModelProperty(value = "")

  @Valid

  public ObservationUnitsResponse1Result getResult() {
    return result;
  }

  public void setResult(ObservationUnitsResponse1Result result) {
    this.result = result;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObservationUnitsResponse1 observationUnitsResponse1 = (ObservationUnitsResponse1) o;
    return Objects.equals(this.metadata, observationUnitsResponse1.metadata) &&
        Objects.equals(this.result, observationUnitsResponse1.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metadata, result);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObservationUnitsResponse1 {\n");
    
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
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

