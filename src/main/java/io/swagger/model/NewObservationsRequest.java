package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.NewObservationsRequestObservations;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * NewObservationsRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class NewObservationsRequest   {
  @JsonProperty("observations")
  @Valid
  private List<NewObservationsRequestObservations> observations = null;

  public NewObservationsRequest observations(List<NewObservationsRequestObservations> observations) {
    this.observations = observations;
    return this;
  }

  public NewObservationsRequest addObservationsItem(NewObservationsRequestObservations observationsItem) {
    if (this.observations == null) {
      this.observations = new ArrayList<NewObservationsRequestObservations>();
    }
    this.observations.add(observationsItem);
    return this;
  }

  /**
   * List of observation references to be created or updated
   * @return observations
  **/
  @ApiModelProperty(value = "List of observation references to be created or updated")

  @Valid

  public List<NewObservationsRequestObservations> getObservations() {
    return observations;
  }

  public void setObservations(List<NewObservationsRequestObservations> observations) {
    this.observations = observations;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NewObservationsRequest newObservationsRequest = (NewObservationsRequest) o;
    return Objects.equals(this.observations, newObservationsRequest.observations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(observations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewObservationsRequest {\n");
    
    sb.append("    observations: ").append(toIndentedString(observations)).append("\n");
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

