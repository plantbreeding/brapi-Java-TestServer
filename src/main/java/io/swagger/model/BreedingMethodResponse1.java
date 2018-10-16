package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.BreedingMethod;
import io.swagger.model.Metadata;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * BreedingMethodResponse1
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class BreedingMethodResponse1   {
  @JsonProperty("metadata")
  private Metadata metadata = null;

  @JsonProperty("result")
  private BreedingMethod result = null;

  public BreedingMethodResponse1 metadata(Metadata metadata) {
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

  public BreedingMethodResponse1 result(BreedingMethod result) {
    this.result = result;
    return this;
  }

   /**
   * Get result
   * @return result
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BreedingMethod getResult() {
    return result;
  }

  public void setResult(BreedingMethod result) {
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
    BreedingMethodResponse1 breedingMethodResponse1 = (BreedingMethodResponse1) o;
    return Objects.equals(this.metadata, breedingMethodResponse1.metadata) &&
        Objects.equals(this.result, breedingMethodResponse1.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metadata, result);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BreedingMethodResponse1 {\n");
    
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

