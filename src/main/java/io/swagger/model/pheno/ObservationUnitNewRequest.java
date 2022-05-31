package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ExternalReferences;
import io.swagger.model.pheno.ObservationTreatment;
import io.swagger.model.pheno.ObservationUnitPosition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

/**
 * ObservationUnitNewRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
public class ObservationUnitNewRequest   {
  @JsonProperty("additionalInfo")
  @Valid
  private Map<String, Object> additionalInfo = null;

  @JsonProperty("externalReferences")
  private ExternalReferences externalReferences = null;

  @JsonProperty("germplasmDbId")
  private String germplasmDbId = null;

  @JsonProperty("germplasmName")
  private String germplasmName = null;

  @JsonProperty("locationDbId")
  private String locationDbId = null;

  @JsonProperty("locationName")
  private String locationName = null;

  @JsonProperty("observationUnitName")
  private String observationUnitName = null;

  @JsonProperty("observationUnitPUI")
  private String observationUnitPUI = null;

  @JsonProperty("observationUnitPosition")
  private ObservationUnitPosition observationUnitPosition = null;

  @JsonProperty("programDbId")
  private String programDbId = null;

  @JsonProperty("programName")
  private String programName = null;

  @JsonProperty("seedLotDbId")
  private String seedLotDbId = null;

  @JsonProperty("studyDbId")
  private String studyDbId = null;

  @JsonProperty("studyName")
  private String studyName = null;

  @JsonProperty("treatments")
  @Valid
  private List<ObservationTreatment> treatments = null;

  @JsonProperty("trialDbId")
  private String trialDbId = null;

  @JsonProperty("trialName")
  private String trialName = null;

  public ObservationUnitNewRequest additionalInfo(Map<String, Object> additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  public ObservationUnitNewRequest putAdditionalInfoItem(String key, String additionalInfoItem) {
    if (this.additionalInfo == null) {
      this.additionalInfo = new HashMap<String, Object>();
    }
    this.additionalInfo.put(key, additionalInfoItem);
    return this;
  }

  /**
   * Additional arbitrary info
   * @return additionalInfo
  **/
  @ApiModelProperty(value = "Additional arbitrary info")
  
    public Map<String, Object> getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(Map<String, Object> additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public ObservationUnitNewRequest externalReferences(ExternalReferences externalReferences) {
    this.externalReferences = externalReferences;
    return this;
  }

  /**
   * Get externalReferences
   * @return externalReferences
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public ExternalReferences getExternalReferences() {
    return externalReferences;
  }

  public void setExternalReferences(ExternalReferences externalReferences) {
    this.externalReferences = externalReferences;
  }

  public ObservationUnitNewRequest germplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
    return this;
  }

  /**
   * The ID which uniquely identifies a germplasm
   * @return germplasmDbId
  **/
  @ApiModelProperty(example = "e9d9ed57", value = "The ID which uniquely identifies a germplasm")
  
    public String getGermplasmDbId() {
    return germplasmDbId;
  }

  public void setGermplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
  }

  public ObservationUnitNewRequest germplasmName(String germplasmName) {
    this.germplasmName = germplasmName;
    return this;
  }

  /**
   * Name of the germplasm. It can be the preferred name and does not have to be unique.
   * @return germplasmName
  **/
  @ApiModelProperty(example = "A0000001", value = "Name of the germplasm. It can be the preferred name and does not have to be unique.")
  
    public String getGermplasmName() {
    return germplasmName;
  }

  public void setGermplasmName(String germplasmName) {
    this.germplasmName = germplasmName;
  }

  public ObservationUnitNewRequest locationDbId(String locationDbId) {
    this.locationDbId = locationDbId;
    return this;
  }

  /**
   * The ID which uniquely identifies a location, associated with this study
   * @return locationDbId
  **/
  @ApiModelProperty(example = "0e208b20", value = "The ID which uniquely identifies a location, associated with this study")
  
    public String getLocationDbId() {
    return locationDbId;
  }

  public void setLocationDbId(String locationDbId) {
    this.locationDbId = locationDbId;
  }

  public ObservationUnitNewRequest locationName(String locationName) {
    this.locationName = locationName;
    return this;
  }

  /**
   * The human readable name of a location associated with this study
   * @return locationName
  **/
  @ApiModelProperty(example = "Field Station Alpha", value = "The human readable name of a location associated with this study")
  
    public String getLocationName() {
    return locationName;
  }

  public void setLocationName(String locationName) {
    this.locationName = locationName;
  }

  public ObservationUnitNewRequest observationUnitName(String observationUnitName) {
    this.observationUnitName = observationUnitName;
    return this;
  }

  /**
   * A human readable name for an observation unit
   * @return observationUnitName
  **/
  @ApiModelProperty(example = "Plot 1", value = "A human readable name for an observation unit")
  
    public String getObservationUnitName() {
    return observationUnitName;
  }

  public void setObservationUnitName(String observationUnitName) {
    this.observationUnitName = observationUnitName;
  }

  public ObservationUnitNewRequest observationUnitPUI(String observationUnitPUI) {
    this.observationUnitPUI = observationUnitPUI;
    return this;
  }

  /**
   * A Permanent Unique Identifier for an observation unit  MIAPPE V1.1 (DM-72) External ID - Identifier for the observation unit in a persistent repository, comprises the name of the repository and the identifier of the observation unit therein. The EBI Biosamples repository can be used. URI are recommended when possible.
   * @return observationUnitPUI
  **/
  @ApiModelProperty(example = "http://pui.per/plot/1a9afc14", value = "A Permanent Unique Identifier for an observation unit  MIAPPE V1.1 (DM-72) External ID - Identifier for the observation unit in a persistent repository, comprises the name of the repository and the identifier of the observation unit therein. The EBI Biosamples repository can be used. URI are recommended when possible.")
  
    public String getObservationUnitPUI() {
    return observationUnitPUI;
  }

  public void setObservationUnitPUI(String observationUnitPUI) {
    this.observationUnitPUI = observationUnitPUI;
  }

  public ObservationUnitNewRequest observationUnitPosition(ObservationUnitPosition observationUnitPosition) {
    this.observationUnitPosition = observationUnitPosition;
    return this;
  }

  /**
   * Get observationUnitPosition
   * @return observationUnitPosition
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public ObservationUnitPosition getObservationUnitPosition() {
    return observationUnitPosition;
  }

  public void setObservationUnitPosition(ObservationUnitPosition observationUnitPosition) {
    this.observationUnitPosition = observationUnitPosition;
  }

  public ObservationUnitNewRequest programDbId(String programDbId) {
    this.programDbId = programDbId;
    return this;
  }

  /**
   * The ID which uniquely identifies a program
   * @return programDbId
  **/
  @ApiModelProperty(example = "2d763a7a", value = "The ID which uniquely identifies a program")
  
    public String getProgramDbId() {
    return programDbId;
  }

  public void setProgramDbId(String programDbId) {
    this.programDbId = programDbId;
  }

  public ObservationUnitNewRequest programName(String programName) {
    this.programName = programName;
    return this;
  }

  /**
   * The human readable name of a program
   * @return programName
  **/
  @ApiModelProperty(example = "The Perfect Breeding Program", value = "The human readable name of a program")
  
    public String getProgramName() {
    return programName;
  }

  public void setProgramName(String programName) {
    this.programName = programName;
  }

  public ObservationUnitNewRequest seedLotDbId(String seedLotDbId) {
    this.seedLotDbId = seedLotDbId;
    return this;
  }

  /**
   * The unique identifier for the originating Seed Lot
   * @return seedLotDbId
  **/
  @ApiModelProperty(example = "261ecb09", value = "The unique identifier for the originating Seed Lot")
  
    public String getSeedLotDbId() {
    return seedLotDbId;
  }

  public void setSeedLotDbId(String seedLotDbId) {
    this.seedLotDbId = seedLotDbId;
  }

  public ObservationUnitNewRequest studyDbId(String studyDbId) {
    this.studyDbId = studyDbId;
    return this;
  }

  /**
   * The ID which uniquely identifies a study within the given database server
   * @return studyDbId
  **/
  @ApiModelProperty(example = "9865addc", value = "The ID which uniquely identifies a study within the given database server")
  
    public String getStudyDbId() {
    return studyDbId;
  }

  public void setStudyDbId(String studyDbId) {
    this.studyDbId = studyDbId;
  }

  public ObservationUnitNewRequest studyName(String studyName) {
    this.studyName = studyName;
    return this;
  }

  /**
   * The human readable name for a study
   * @return studyName
  **/
  @ApiModelProperty(example = "Purple_Tomato_1", value = "The human readable name for a study")
  
    public String getStudyName() {
    return studyName;
  }

  public void setStudyName(String studyName) {
    this.studyName = studyName;
  }

  public ObservationUnitNewRequest treatments(List<ObservationTreatment> treatments) {
    this.treatments = treatments;
    return this;
  }

  public ObservationUnitNewRequest addTreatmentsItem(ObservationTreatment treatmentsItem) {
    if (this.treatments == null) {
      this.treatments = new ArrayList<ObservationTreatment>();
    }
    this.treatments.add(treatmentsItem);
    return this;
  }

  /**
   * List of treatments applied to an observation unit.  MIAPPE V1.1 (DM-74) Observation Unit factor value - List of values for each factor applied to the observation unit.
   * @return treatments
  **/
  @ApiModelProperty(value = "List of treatments applied to an observation unit.  MIAPPE V1.1 (DM-74) Observation Unit factor value - List of values for each factor applied to the observation unit.")
      @Valid
    public List<ObservationTreatment> getTreatments() {
    return treatments;
  }

  public void setTreatments(List<ObservationTreatment> treatments) {
    this.treatments = treatments;
  }

  public ObservationUnitNewRequest trialDbId(String trialDbId) {
    this.trialDbId = trialDbId;
    return this;
  }

  /**
   * The ID which uniquely identifies a trial
   * @return trialDbId
  **/
  @ApiModelProperty(example = "776a609c", value = "The ID which uniquely identifies a trial")
  
    public String getTrialDbId() {
    return trialDbId;
  }

  public void setTrialDbId(String trialDbId) {
    this.trialDbId = trialDbId;
  }

  public ObservationUnitNewRequest trialName(String trialName) {
    this.trialName = trialName;
    return this;
  }

  /**
   * The human readable name of a trial
   * @return trialName
  **/
  @ApiModelProperty(example = "Purple Tomato", value = "The human readable name of a trial")
  
    public String getTrialName() {
    return trialName;
  }

  public void setTrialName(String trialName) {
    this.trialName = trialName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObservationUnitNewRequest observationUnitNewRequest = (ObservationUnitNewRequest) o;
    return Objects.equals(this.additionalInfo, observationUnitNewRequest.additionalInfo) &&
        Objects.equals(this.externalReferences, observationUnitNewRequest.externalReferences) &&
        Objects.equals(this.germplasmDbId, observationUnitNewRequest.germplasmDbId) &&
        Objects.equals(this.germplasmName, observationUnitNewRequest.germplasmName) &&
        Objects.equals(this.locationDbId, observationUnitNewRequest.locationDbId) &&
        Objects.equals(this.locationName, observationUnitNewRequest.locationName) &&
        Objects.equals(this.observationUnitName, observationUnitNewRequest.observationUnitName) &&
        Objects.equals(this.observationUnitPUI, observationUnitNewRequest.observationUnitPUI) &&
        Objects.equals(this.observationUnitPosition, observationUnitNewRequest.observationUnitPosition) &&
        Objects.equals(this.programDbId, observationUnitNewRequest.programDbId) &&
        Objects.equals(this.programName, observationUnitNewRequest.programName) &&
        Objects.equals(this.seedLotDbId, observationUnitNewRequest.seedLotDbId) &&
        Objects.equals(this.studyDbId, observationUnitNewRequest.studyDbId) &&
        Objects.equals(this.studyName, observationUnitNewRequest.studyName) &&
        Objects.equals(this.treatments, observationUnitNewRequest.treatments) &&
        Objects.equals(this.trialDbId, observationUnitNewRequest.trialDbId) &&
        Objects.equals(this.trialName, observationUnitNewRequest.trialName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalInfo, externalReferences, germplasmDbId, germplasmName, locationDbId, locationName, observationUnitName, observationUnitPUI, observationUnitPosition, programDbId, programName, seedLotDbId, studyDbId, studyName, treatments, trialDbId, trialName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObservationUnitNewRequest {\n");
    
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    externalReferences: ").append(toIndentedString(externalReferences)).append("\n");
    sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
    sb.append("    germplasmName: ").append(toIndentedString(germplasmName)).append("\n");
    sb.append("    locationDbId: ").append(toIndentedString(locationDbId)).append("\n");
    sb.append("    locationName: ").append(toIndentedString(locationName)).append("\n");
    sb.append("    observationUnitName: ").append(toIndentedString(observationUnitName)).append("\n");
    sb.append("    observationUnitPUI: ").append(toIndentedString(observationUnitPUI)).append("\n");
    sb.append("    observationUnitPosition: ").append(toIndentedString(observationUnitPosition)).append("\n");
    sb.append("    programDbId: ").append(toIndentedString(programDbId)).append("\n");
    sb.append("    programName: ").append(toIndentedString(programName)).append("\n");
    sb.append("    seedLotDbId: ").append(toIndentedString(seedLotDbId)).append("\n");
    sb.append("    studyDbId: ").append(toIndentedString(studyDbId)).append("\n");
    sb.append("    studyName: ").append(toIndentedString(studyName)).append("\n");
    sb.append("    treatments: ").append(toIndentedString(treatments)).append("\n");
    sb.append("    trialDbId: ").append(toIndentedString(trialDbId)).append("\n");
    sb.append("    trialName: ").append(toIndentedString(trialName)).append("\n");
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
