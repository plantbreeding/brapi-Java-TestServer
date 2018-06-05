package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Observation;
import io.swagger.model.ObservationTreatment;
import io.swagger.model.ObservationUnitXref;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * NewObservationUnitRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

public class NewObservationUnitRequest   {
  @JsonProperty("X")
  private String X = null;

  @JsonProperty("Y")
  private String Y = null;

  @JsonProperty("blockNumber")
  private String blockNumber = null;

  @JsonProperty("entryNumber")
  private String entryNumber = null;

  @JsonProperty("entryType")
  private String entryType = null;

  @JsonProperty("germplasmDbId")
  private String germplasmDbId = null;

  @JsonProperty("observationLevel")
  private String observationLevel = null;

  @JsonProperty("observationUnitDbId")
  private String observationUnitDbId = null;

  @JsonProperty("observationUnitName")
  private String observationUnitName = null;

  @JsonProperty("observationUnitXref")
  @Valid
  private List<ObservationUnitXref> observationUnitXref = null;

  @JsonProperty("observations")
  @Valid
  private List<Observation> observations = null;

  @JsonProperty("plantNumber")
  private String plantNumber = null;

  @JsonProperty("plotNumber")
  private String plotNumber = null;

  @JsonProperty("replicate")
  private String replicate = null;

  @JsonProperty("studyDbId")
  private String studyDbId = null;

  @JsonProperty("treatments")
  @Valid
  private List<ObservationTreatment> treatments = null;

  public NewObservationUnitRequest X(String X) {
    this.X = X;
    return this;
  }

   /**
   * The X position coordinate for an observation unit. Different systems may use different coordinate systems.
   * @return X
  **/
  @ApiModelProperty(value = "The X position coordinate for an observation unit. Different systems may use different coordinate systems.")


  public String getX() {
    return X;
  }

  public void setX(String X) {
    this.X = X;
  }

  public NewObservationUnitRequest Y(String Y) {
    this.Y = Y;
    return this;
  }

   /**
   * The Y position coordinate for an observation unit. Different systems may use different coordinate systems.
   * @return Y
  **/
  @ApiModelProperty(value = "The Y position coordinate for an observation unit. Different systems may use different coordinate systems.")


  public String getY() {
    return Y;
  }

  public void setY(String Y) {
    this.Y = Y;
  }

  public NewObservationUnitRequest blockNumber(String blockNumber) {
    this.blockNumber = blockNumber;
    return this;
  }

   /**
   * The block number for an observation unit. Different systems may use different block designs.
   * @return blockNumber
  **/
  @ApiModelProperty(value = "The block number for an observation unit. Different systems may use different block designs.")


  public String getBlockNumber() {
    return blockNumber;
  }

  public void setBlockNumber(String blockNumber) {
    this.blockNumber = blockNumber;
  }

  public NewObservationUnitRequest entryNumber(String entryNumber) {
    this.entryNumber = entryNumber;
    return this;
  }

   /**
   * The entry number for an observation unit. Different systems may use different entry systems.
   * @return entryNumber
  **/
  @ApiModelProperty(value = "The entry number for an observation unit. Different systems may use different entry systems.")


  public String getEntryNumber() {
    return entryNumber;
  }

  public void setEntryNumber(String entryNumber) {
    this.entryNumber = entryNumber;
  }

  public NewObservationUnitRequest entryType(String entryType) {
    this.entryType = entryType;
    return this;
  }

   /**
   * The type of entry for this observation unit. ex. \"check\", \"test\", \"filler\"
   * @return entryType
  **/
  @ApiModelProperty(value = "The type of entry for this observation unit. ex. \"check\", \"test\", \"filler\"")


  public String getEntryType() {
    return entryType;
  }

  public void setEntryType(String entryType) {
    this.entryType = entryType;
  }

  public NewObservationUnitRequest germplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
    return this;
  }

   /**
   *  The ID which uniquely identifies a germplasm
   * @return germplasmDbId
  **/
  @ApiModelProperty(value = " The ID which uniquely identifies a germplasm")


  public String getGermplasmDbId() {
    return germplasmDbId;
  }

  public void setGermplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
  }

  public NewObservationUnitRequest observationLevel(String observationLevel) {
    this.observationLevel = observationLevel;
    return this;
  }

   /**
   * The level of an observation unit. ex. \"plot\", \"plant\"
   * @return observationLevel
  **/
  @ApiModelProperty(value = "The level of an observation unit. ex. \"plot\", \"plant\"")


  public String getObservationLevel() {
    return observationLevel;
  }

  public void setObservationLevel(String observationLevel) {
    this.observationLevel = observationLevel;
  }

  public NewObservationUnitRequest observationUnitDbId(String observationUnitDbId) {
    this.observationUnitDbId = observationUnitDbId;
    return this;
  }

   /**
   * The ID which uniquely identifies an observation unit
   * @return observationUnitDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies an observation unit")


  public String getObservationUnitDbId() {
    return observationUnitDbId;
  }

  public void setObservationUnitDbId(String observationUnitDbId) {
    this.observationUnitDbId = observationUnitDbId;
  }

  public NewObservationUnitRequest observationUnitName(String observationUnitName) {
    this.observationUnitName = observationUnitName;
    return this;
  }

   /**
   * A human readable name for an observation unit
   * @return observationUnitName
  **/
  @ApiModelProperty(value = "A human readable name for an observation unit")


  public String getObservationUnitName() {
    return observationUnitName;
  }

  public void setObservationUnitName(String observationUnitName) {
    this.observationUnitName = observationUnitName;
  }

  public NewObservationUnitRequest observationUnitXref(List<ObservationUnitXref> observationUnitXref) {
    this.observationUnitXref = observationUnitXref;
    return this;
  }

  public NewObservationUnitRequest addObservationUnitXrefItem(ObservationUnitXref observationUnitXrefItem) {
    if (this.observationUnitXref == null) {
      this.observationUnitXref = new ArrayList<ObservationUnitXref>();
    }
    this.observationUnitXref.add(observationUnitXrefItem);
    return this;
  }

   /**
   * A list of external references to this observation unit
   * @return observationUnitXref
  **/
  @ApiModelProperty(value = "A list of external references to this observation unit")

  @Valid

  public List<ObservationUnitXref> getObservationUnitXref() {
    return observationUnitXref;
  }

  public void setObservationUnitXref(List<ObservationUnitXref> observationUnitXref) {
    this.observationUnitXref = observationUnitXref;
  }

  public NewObservationUnitRequest observations(List<Observation> observations) {
    this.observations = observations;
    return this;
  }

  public NewObservationUnitRequest addObservationsItem(Observation observationsItem) {
    if (this.observations == null) {
      this.observations = new ArrayList<Observation>();
    }
    this.observations.add(observationsItem);
    return this;
  }

   /**
   * List of observations associated with this observation unit
   * @return observations
  **/
  @ApiModelProperty(value = "List of observations associated with this observation unit")

  @Valid

  public List<Observation> getObservations() {
    return observations;
  }

  public void setObservations(List<Observation> observations) {
    this.observations = observations;
  }

  public NewObservationUnitRequest plantNumber(String plantNumber) {
    this.plantNumber = plantNumber;
    return this;
  }

   /**
   * The plant number in a field. Applicable for observationLevel: \"plant\"
   * @return plantNumber
  **/
  @ApiModelProperty(value = "The plant number in a field. Applicable for observationLevel: \"plant\"")


  public String getPlantNumber() {
    return plantNumber;
  }

  public void setPlantNumber(String plantNumber) {
    this.plantNumber = plantNumber;
  }

  public NewObservationUnitRequest plotNumber(String plotNumber) {
    this.plotNumber = plotNumber;
    return this;
  }

   /**
   * The plot number in a field. Applicable for observationLevel: \"plot\"
   * @return plotNumber
  **/
  @ApiModelProperty(value = "The plot number in a field. Applicable for observationLevel: \"plot\"")


  public String getPlotNumber() {
    return plotNumber;
  }

  public void setPlotNumber(String plotNumber) {
    this.plotNumber = plotNumber;
  }

  public NewObservationUnitRequest replicate(String replicate) {
    this.replicate = replicate;
    return this;
  }

   /**
   * The replicate number of an observation unit. May be the same as blockNumber.
   * @return replicate
  **/
  @ApiModelProperty(value = "The replicate number of an observation unit. May be the same as blockNumber.")


  public String getReplicate() {
    return replicate;
  }

  public void setReplicate(String replicate) {
    this.replicate = replicate;
  }

  public NewObservationUnitRequest studyDbId(String studyDbId) {
    this.studyDbId = studyDbId;
    return this;
  }

   /**
   * The ID which uniquely identifies a study within the given database server
   * @return studyDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies a study within the given database server")


  public String getStudyDbId() {
    return studyDbId;
  }

  public void setStudyDbId(String studyDbId) {
    this.studyDbId = studyDbId;
  }

  public NewObservationUnitRequest treatments(List<ObservationTreatment> treatments) {
    this.treatments = treatments;
    return this;
  }

  public NewObservationUnitRequest addTreatmentsItem(ObservationTreatment treatmentsItem) {
    if (this.treatments == null) {
      this.treatments = new ArrayList<ObservationTreatment>();
    }
    this.treatments.add(treatmentsItem);
    return this;
  }

   /**
   * List of treatments applied to an observation unit.
   * @return treatments
  **/
  @ApiModelProperty(value = "List of treatments applied to an observation unit.")

  @Valid

  public List<ObservationTreatment> getTreatments() {
    return treatments;
  }

  public void setTreatments(List<ObservationTreatment> treatments) {
    this.treatments = treatments;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NewObservationUnitRequest newObservationUnitRequest = (NewObservationUnitRequest) o;
    return Objects.equals(this.X, newObservationUnitRequest.X) &&
        Objects.equals(this.Y, newObservationUnitRequest.Y) &&
        Objects.equals(this.blockNumber, newObservationUnitRequest.blockNumber) &&
        Objects.equals(this.entryNumber, newObservationUnitRequest.entryNumber) &&
        Objects.equals(this.entryType, newObservationUnitRequest.entryType) &&
        Objects.equals(this.germplasmDbId, newObservationUnitRequest.germplasmDbId) &&
        Objects.equals(this.observationLevel, newObservationUnitRequest.observationLevel) &&
        Objects.equals(this.observationUnitDbId, newObservationUnitRequest.observationUnitDbId) &&
        Objects.equals(this.observationUnitName, newObservationUnitRequest.observationUnitName) &&
        Objects.equals(this.observationUnitXref, newObservationUnitRequest.observationUnitXref) &&
        Objects.equals(this.observations, newObservationUnitRequest.observations) &&
        Objects.equals(this.plantNumber, newObservationUnitRequest.plantNumber) &&
        Objects.equals(this.plotNumber, newObservationUnitRequest.plotNumber) &&
        Objects.equals(this.replicate, newObservationUnitRequest.replicate) &&
        Objects.equals(this.studyDbId, newObservationUnitRequest.studyDbId) &&
        Objects.equals(this.treatments, newObservationUnitRequest.treatments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(X, Y, blockNumber, entryNumber, entryType, germplasmDbId, observationLevel, observationUnitDbId, observationUnitName, observationUnitXref, observations, plantNumber, plotNumber, replicate, studyDbId, treatments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewObservationUnitRequest {\n");
    
    sb.append("    X: ").append(toIndentedString(X)).append("\n");
    sb.append("    Y: ").append(toIndentedString(Y)).append("\n");
    sb.append("    blockNumber: ").append(toIndentedString(blockNumber)).append("\n");
    sb.append("    entryNumber: ").append(toIndentedString(entryNumber)).append("\n");
    sb.append("    entryType: ").append(toIndentedString(entryType)).append("\n");
    sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
    sb.append("    observationLevel: ").append(toIndentedString(observationLevel)).append("\n");
    sb.append("    observationUnitDbId: ").append(toIndentedString(observationUnitDbId)).append("\n");
    sb.append("    observationUnitName: ").append(toIndentedString(observationUnitName)).append("\n");
    sb.append("    observationUnitXref: ").append(toIndentedString(observationUnitXref)).append("\n");
    sb.append("    observations: ").append(toIndentedString(observations)).append("\n");
    sb.append("    plantNumber: ").append(toIndentedString(plantNumber)).append("\n");
    sb.append("    plotNumber: ").append(toIndentedString(plotNumber)).append("\n");
    sb.append("    replicate: ").append(toIndentedString(replicate)).append("\n");
    sb.append("    studyDbId: ").append(toIndentedString(studyDbId)).append("\n");
    sb.append("    treatments: ").append(toIndentedString(treatments)).append("\n");
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

