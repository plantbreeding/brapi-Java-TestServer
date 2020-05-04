package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Sample
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class Sample   {
  @JsonProperty("germplasmDbId")
  private String germplasmDbId = null;

  @JsonProperty("notes")
  private String notes = null;

  @JsonProperty("observationUnitDbId")
  private String observationUnitDbId = null;

  @JsonProperty("plantDbId")
  private String plantDbId = null;

  @JsonProperty("plateDbId")
  private String plateDbId = null;

  @JsonProperty("plateIndex")
  private Integer plateIndex = null;

  @JsonProperty("plotDbId")
  private String plotDbId = null;

  @JsonProperty("sampleDbId")
  private String sampleDbId = null;

  @JsonProperty("sampleTimestamp")
  private OffsetDateTime sampleTimestamp = null;

  @JsonProperty("sampleType")
  private String sampleType = null;

  @JsonProperty("studyDbId")
  private String studyDbId = null;

  @JsonProperty("takenBy")
  private String takenBy = null;

  @JsonProperty("tissueType")
  private String tissueType = null;

  public Sample germplasmDbId(String germplasmDbId) {
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

  public Sample notes(String notes) {
    this.notes = notes;
    return this;
  }

  /**
   * Additional notes about a samle
   * @return notes
  **/
  @ApiModelProperty(value = "Additional notes about a samle")


  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public Sample observationUnitDbId(String observationUnitDbId) {
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

  public Sample plantDbId(String plantDbId) {
    this.plantDbId = plantDbId;
    return this;
  }

  /**
   * The ID which uniquely identifies a plant. Usually 'plantNumber'
   * @return plantDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies a plant. Usually 'plantNumber'")


  public String getPlantDbId() {
    return plantDbId;
  }

  public void setPlantDbId(String plantDbId) {
    this.plantDbId = plantDbId;
  }

  public Sample plateDbId(String plateDbId) {
    this.plateDbId = plateDbId;
    return this;
  }

  /**
   * The ID which uniquely identifies a plate of samples
   * @return plateDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies a plate of samples")


  public String getPlateDbId() {
    return plateDbId;
  }

  public void setPlateDbId(String plateDbId) {
    this.plateDbId = plateDbId;
  }

  public Sample plateIndex(Integer plateIndex) {
    this.plateIndex = plateIndex;
    return this;
  }

  /**
   * The index number of this sample on a plate
   * @return plateIndex
  **/
  @ApiModelProperty(value = "The index number of this sample on a plate")


  public Integer getPlateIndex() {
    return plateIndex;
  }

  public void setPlateIndex(Integer plateIndex) {
    this.plateIndex = plateIndex;
  }

  public Sample plotDbId(String plotDbId) {
    this.plotDbId = plotDbId;
    return this;
  }

  /**
   *  The ID which uniquely identifies a plot. Usually 'plotNumber'
   * @return plotDbId
  **/
  @ApiModelProperty(value = " The ID which uniquely identifies a plot. Usually 'plotNumber'")


  public String getPlotDbId() {
    return plotDbId;
  }

  public void setPlotDbId(String plotDbId) {
    this.plotDbId = plotDbId;
  }

  public Sample sampleDbId(String sampleDbId) {
    this.sampleDbId = sampleDbId;
    return this;
  }

  /**
   * The ID which uniquely identifies a sample
   * @return sampleDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies a sample")


  public String getSampleDbId() {
    return sampleDbId;
  }

  public void setSampleDbId(String sampleDbId) {
    this.sampleDbId = sampleDbId;
  }

  public Sample sampleTimestamp(OffsetDateTime sampleTimestamp) {
    this.sampleTimestamp = sampleTimestamp;
    return this;
  }

  /**
   * The date and time a sample was collected from the field
   * @return sampleTimestamp
  **/
  @ApiModelProperty(value = "The date and time a sample was collected from the field")

  @Valid

  public OffsetDateTime getSampleTimestamp() {
    return sampleTimestamp;
  }

  public void setSampleTimestamp(OffsetDateTime sampleTimestamp) {
    this.sampleTimestamp = sampleTimestamp;
  }

  public Sample sampleType(String sampleType) {
    this.sampleType = sampleType;
    return this;
  }

  /**
   * The type of sample taken. ex. 'DNA', 'RNA', 'Tissue', etc 
   * @return sampleType
  **/
  @ApiModelProperty(value = "The type of sample taken. ex. 'DNA', 'RNA', 'Tissue', etc ")


  public String getSampleType() {
    return sampleType;
  }

  public void setSampleType(String sampleType) {
    this.sampleType = sampleType;
  }

  public Sample studyDbId(String studyDbId) {
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

  public Sample takenBy(String takenBy) {
    this.takenBy = takenBy;
    return this;
  }

  /**
   * The name or identifier of the entity which took the sample from the field
   * @return takenBy
  **/
  @ApiModelProperty(value = "The name or identifier of the entity which took the sample from the field")


  public String getTakenBy() {
    return takenBy;
  }

  public void setTakenBy(String takenBy) {
    this.takenBy = takenBy;
  }

  public Sample tissueType(String tissueType) {
    this.tissueType = tissueType;
    return this;
  }

  /**
   * The type of tissue sampled. ex. 'Leaf', 'Root', etc.
   * @return tissueType
  **/
  @ApiModelProperty(value = "The type of tissue sampled. ex. 'Leaf', 'Root', etc.")


  public String getTissueType() {
    return tissueType;
  }

  public void setTissueType(String tissueType) {
    this.tissueType = tissueType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Sample sample = (Sample) o;
    return Objects.equals(this.germplasmDbId, sample.germplasmDbId) &&
        Objects.equals(this.notes, sample.notes) &&
        Objects.equals(this.observationUnitDbId, sample.observationUnitDbId) &&
        Objects.equals(this.plantDbId, sample.plantDbId) &&
        Objects.equals(this.plateDbId, sample.plateDbId) &&
        Objects.equals(this.plateIndex, sample.plateIndex) &&
        Objects.equals(this.plotDbId, sample.plotDbId) &&
        Objects.equals(this.sampleDbId, sample.sampleDbId) &&
        Objects.equals(this.sampleTimestamp, sample.sampleTimestamp) &&
        Objects.equals(this.sampleType, sample.sampleType) &&
        Objects.equals(this.studyDbId, sample.studyDbId) &&
        Objects.equals(this.takenBy, sample.takenBy) &&
        Objects.equals(this.tissueType, sample.tissueType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(germplasmDbId, notes, observationUnitDbId, plantDbId, plateDbId, plateIndex, plotDbId, sampleDbId, sampleTimestamp, sampleType, studyDbId, takenBy, tissueType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Sample {\n");
    
    sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    observationUnitDbId: ").append(toIndentedString(observationUnitDbId)).append("\n");
    sb.append("    plantDbId: ").append(toIndentedString(plantDbId)).append("\n");
    sb.append("    plateDbId: ").append(toIndentedString(plateDbId)).append("\n");
    sb.append("    plateIndex: ").append(toIndentedString(plateIndex)).append("\n");
    sb.append("    plotDbId: ").append(toIndentedString(plotDbId)).append("\n");
    sb.append("    sampleDbId: ").append(toIndentedString(sampleDbId)).append("\n");
    sb.append("    sampleTimestamp: ").append(toIndentedString(sampleTimestamp)).append("\n");
    sb.append("    sampleType: ").append(toIndentedString(sampleType)).append("\n");
    sb.append("    studyDbId: ").append(toIndentedString(studyDbId)).append("\n");
    sb.append("    takenBy: ").append(toIndentedString(takenBy)).append("\n");
    sb.append("    tissueType: ").append(toIndentedString(tissueType)).append("\n");
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

