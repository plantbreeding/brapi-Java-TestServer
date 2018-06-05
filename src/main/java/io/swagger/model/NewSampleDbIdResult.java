package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * List of sample references which have been created or updated
 */
@ApiModel(description = "List of sample references which have been created or updated")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class NewSampleDbIdResult   {
  @JsonProperty("sampleDbId")
  private String sampleDbId = null;

  @JsonProperty("sampleId")
  private String sampleId = null;

  public NewSampleDbIdResult sampleDbId(String sampleDbId) {
    this.sampleDbId = sampleDbId;
    return this;
  }

   /**
   * Get sampleDbId
   * @return sampleDbId
  **/
  @ApiModelProperty(value = "")


  public String getSampleDbId() {
    return sampleDbId;
  }

  public void setSampleDbId(String sampleDbId) {
    this.sampleDbId = sampleDbId;
  }

  public NewSampleDbIdResult sampleId(String sampleId) {
    this.sampleId = sampleId;
    return this;
  }

   /**
   * ** Deprecated ** use sampleDbId
   * @return sampleId
  **/
  @ApiModelProperty(value = "** Deprecated ** use sampleDbId")


  public String getSampleId() {
    return sampleId;
  }

  public void setSampleId(String sampleId) {
    this.sampleId = sampleId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NewSampleDbIdResult newSampleDbIdResult = (NewSampleDbIdResult) o;
    return Objects.equals(this.sampleDbId, newSampleDbIdResult.sampleDbId) &&
        Objects.equals(this.sampleId, newSampleDbIdResult.sampleId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sampleDbId, sampleId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewSampleDbIdResult {\n");
    
    sb.append("    sampleDbId: ").append(toIndentedString(sampleDbId)).append("\n");
    sb.append("    sampleId: ").append(toIndentedString(sampleId)).append("\n");
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

