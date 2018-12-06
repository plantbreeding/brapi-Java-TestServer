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
 * ObservationUnitXref
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class ObservationUnitXref   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("source")
  private String source = null;

  public ObservationUnitXref id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The unique ID in the external reference 'source' system
   * @return id
  **/
  @ApiModelProperty(value = "The unique ID in the external reference 'source' system")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ObservationUnitXref source(String source) {
    this.source = source;
    return this;
  }

  /**
   * The system identifier (name, URL, etc) which has an external reference to the observation unit
   * @return source
  **/
  @ApiModelProperty(value = "The system identifier (name, URL, etc) which has an external reference to the observation unit")


  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObservationUnitXref observationUnitXref = (ObservationUnitXref) o;
    return Objects.equals(this.id, observationUnitXref.id) &&
        Objects.equals(this.source, observationUnitXref.source);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, source);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObservationUnitXref {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
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

