package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.pheno.Observation;
import io.swagger.model.pheno.ObservationUnitNewRequest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * ObservationUnit
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
public class ObservationUnit extends ObservationUnitNewRequest  {
  @JsonProperty("observationUnitDbId")
  private String observationUnitDbId = null;

  @JsonProperty("observations")
  @Valid
  private List<Observation> observations = null;

  public ObservationUnit observationUnitDbId(String observationUnitDbId) {
    this.observationUnitDbId = observationUnitDbId;
    return this;
  }

  /**
   * The ID which uniquely identifies an observation unit  MIAPPE V1.1 (DM-70) Observation unit ID - Identifier used to identify the observation unit in data files containing the values observed or measured on that unit. Must be locally unique. 
   * @return observationUnitDbId
  **/
  @ApiModelProperty(example = "8c67503c", value = "The ID which uniquely identifies an observation unit  MIAPPE V1.1 (DM-70) Observation unit ID - Identifier used to identify the observation unit in data files containing the values observed or measured on that unit. Must be locally unique. ")
  
    public String getObservationUnitDbId() {
    return observationUnitDbId;
  }

  public void setObservationUnitDbId(String observationUnitDbId) {
    this.observationUnitDbId = observationUnitDbId;
  }

  public ObservationUnit observations(List<Observation> observations) {
    this.observations = observations;
    return this;
  }

  public ObservationUnit addObservationsItem(Observation observationsItem) {
    if (this.observations == null) {
      this.observations = new ArrayList<Observation>();
    }
    this.observations.add(observationsItem);
    return this;
  }

  /**
   * All observations attached to this observation unit.   Default for this field is null or omitted. Do NOT include data in this field unless the 'includeObservations' flag is explicitly set to True.
   * @return observations
  **/
  @ApiModelProperty(value = "All observations attached to this observation unit.   Default for this field is null or omitted. Do NOT include data in this field unless the 'includeObservations' flag is explicitly set to True.")
      @Valid
    public List<Observation> getObservations() {
    return observations;
  }

  public void setObservations(List<Observation> observations) {
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
    ObservationUnit observationUnit = (ObservationUnit) o;
    return Objects.equals(this.observationUnitDbId, observationUnit.observationUnitDbId) &&
        Objects.equals(this.observations, observationUnit.observations) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(observationUnitDbId, observations, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObservationUnit {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    observationUnitDbId: ").append(toIndentedString(observationUnitDbId)).append("\n");
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
