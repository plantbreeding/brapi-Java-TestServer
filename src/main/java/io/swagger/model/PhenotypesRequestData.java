package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.PhenotypesRequestObservation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * new phenotypes
 */
@ApiModel(description = "new phenotypes")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class PhenotypesRequestData   {
  @JsonProperty("observationUnitDbId")
  private String observationUnitDbId = null;

  @JsonProperty("observations")
  @Valid
  private List<PhenotypesRequestObservation> observations = null;

  @JsonProperty("studyDbId")
  private String studyDbId = null;

  public PhenotypesRequestData observatioUnitDbId(String observatioUnitDbId) {
    this.observationUnitDbId = observatioUnitDbId;
    return this;
  }

  /**
   * Get observatioUnitDbId
   * @return observatioUnitDbId
  **/
  @ApiModelProperty(value = "")


  public String getObservationUnitDbId() {
    return observationUnitDbId;
  }

  public void setObservationUnitDbId(String observatioUnitDbId) {
    this.observationUnitDbId = observatioUnitDbId;
  }

  public PhenotypesRequestData observations(List<PhenotypesRequestObservation> observations) {
    this.observations = observations;
    return this;
  }

  public PhenotypesRequestData addObservationsItem(PhenotypesRequestObservation observationsItem) {
    if (this.observations == null) {
      this.observations = new ArrayList<PhenotypesRequestObservation>();
    }
    this.observations.add(observationsItem);
    return this;
  }

  /**
   * Get observations
   * @return observations
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<PhenotypesRequestObservation> getObservations() {
    return observations;
  }

  public void setObservations(List<PhenotypesRequestObservation> observations) {
    this.observations = observations;
  }

  public PhenotypesRequestData studyDbId(String studyDbId) {
    this.studyDbId = studyDbId;
    return this;
  }

  /**
   * Get studyDbId
   * @return studyDbId
  **/
  @ApiModelProperty(value = "")


  public String getStudyDbId() {
    return studyDbId;
  }

  public void setStudyDbId(String studyDbId) {
    this.studyDbId = studyDbId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PhenotypesRequestData phenotypesRequestData = (PhenotypesRequestData) o;
    return Objects.equals(this.observationUnitDbId, phenotypesRequestData.observationUnitDbId) &&
        Objects.equals(this.observations, phenotypesRequestData.observations) &&
        Objects.equals(this.studyDbId, phenotypesRequestData.studyDbId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(observationUnitDbId, observations, studyDbId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PhenotypesRequestData {\n");
    
    sb.append("    observatioUnitDbId: ").append(toIndentedString(observationUnitDbId)).append("\n");
    sb.append("    observations: ").append(toIndentedString(observations)).append("\n");
    sb.append("    studyDbId: ").append(toIndentedString(studyDbId)).append("\n");
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

