package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.NewObservationsRequestObservations;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * NewObservationsRequestDeprecatedData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-01T19:24:22.162Z")

public class NewObservationsRequestDeprecatedData   {
  @JsonProperty("observatioUnitDbId")
  private String observatioUnitDbId = null;

  @JsonProperty("observations")
  @Valid
  private List<NewObservationsRequestObservations> observations = null;

  @JsonProperty("studyDbId")
  private BigDecimal studyDbId = null;

  public NewObservationsRequestDeprecatedData observatioUnitDbId(String observatioUnitDbId) {
    this.observatioUnitDbId = observatioUnitDbId;
    return this;
  }

   /**
   * Get observatioUnitDbId
   * @return observatioUnitDbId
  **/
  @ApiModelProperty(value = "")


  public String getObservatioUnitDbId() {
    return observatioUnitDbId;
  }

  public void setObservatioUnitDbId(String observatioUnitDbId) {
    this.observatioUnitDbId = observatioUnitDbId;
  }

  public NewObservationsRequestDeprecatedData observations(List<NewObservationsRequestObservations> observations) {
    this.observations = observations;
    return this;
  }

  public NewObservationsRequestDeprecatedData addObservationsItem(NewObservationsRequestObservations observationsItem) {
    if (this.observations == null) {
      this.observations = new ArrayList<NewObservationsRequestObservations>();
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

  public List<NewObservationsRequestObservations> getObservations() {
    return observations;
  }

  public void setObservations(List<NewObservationsRequestObservations> observations) {
    this.observations = observations;
  }

  public NewObservationsRequestDeprecatedData studyDbId(BigDecimal studyDbId) {
    this.studyDbId = studyDbId;
    return this;
  }

   /**
   * Get studyDbId
   * @return studyDbId
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getStudyDbId() {
    return studyDbId;
  }

  public void setStudyDbId(BigDecimal studyDbId) {
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
    NewObservationsRequestDeprecatedData newObservationsRequestDeprecatedData = (NewObservationsRequestDeprecatedData) o;
    return Objects.equals(this.observatioUnitDbId, newObservationsRequestDeprecatedData.observatioUnitDbId) &&
        Objects.equals(this.observations, newObservationsRequestDeprecatedData.observations) &&
        Objects.equals(this.studyDbId, newObservationsRequestDeprecatedData.studyDbId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(observatioUnitDbId, observations, studyDbId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewObservationsRequestDeprecatedData {\n");
    
    sb.append("    observatioUnitDbId: ").append(toIndentedString(observatioUnitDbId)).append("\n");
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

