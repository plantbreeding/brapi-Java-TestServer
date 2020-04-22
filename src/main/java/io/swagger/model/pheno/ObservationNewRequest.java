package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ExternalReferences;
import io.swagger.model.core.Season;

import java.util.HashMap;
import java.util.Map;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * ObservationNewRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
public class ObservationNewRequest   {
  @JsonProperty("additionalInfo")
  @Valid
  private Map<String, String> additionalInfo = null;

  @JsonProperty("collector")
  private String collector = null;

  @JsonProperty("externalReferences")
  private ExternalReferences externalReferences = null;

  @JsonProperty("germplasmDbId")
  private String germplasmDbId = null;

  @JsonProperty("germplasmName")
  private String germplasmName = null;

  @JsonProperty("observationTimeStamp")
  private OffsetDateTime observationTimeStamp = null;

  @JsonProperty("observationUnitDbId")
  private String observationUnitDbId = null;

  @JsonProperty("observationUnitName")
  private String observationUnitName = null;

  @JsonProperty("observationVariableDbId")
  private String observationVariableDbId = null;

  @JsonProperty("observationVariableName")
  private String observationVariableName = null;

  @JsonProperty("season")
  private Season season = null;

  @JsonProperty("studyDbId")
  private String studyDbId = null;

  @JsonProperty("uploadedBy")
  private String uploadedBy = null;

  @JsonProperty("value")
  private String value = null;

  public ObservationNewRequest additionalInfo(Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  public ObservationNewRequest putAdditionalInfoItem(String key, String additionalInfoItem) {
    if (this.additionalInfo == null) {
      this.additionalInfo = new HashMap<String, String>();
    }
    this.additionalInfo.put(key, additionalInfoItem);
    return this;
  }

  /**
   * Additional arbitrary info
   * @return additionalInfo
  **/
  @ApiModelProperty(value = "Additional arbitrary info")
  
    public Map<String, String> getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public ObservationNewRequest collector(String collector) {
    this.collector = collector;
    return this;
  }

  /**
   * The name or identifier of the entity which collected the observation
   * @return collector
  **/
  @ApiModelProperty(example = "917d3ae0", value = "The name or identifier of the entity which collected the observation")
  
    public String getCollector() {
    return collector;
  }

  public void setCollector(String collector) {
    this.collector = collector;
  }

  public ObservationNewRequest externalReferences(ExternalReferences externalReferences) {
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

  public ObservationNewRequest germplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
    return this;
  }

  /**
   * The ID which uniquely identifies a germplasm
   * @return germplasmDbId
  **/
  @ApiModelProperty(example = "2408ab11", value = "The ID which uniquely identifies a germplasm")
  
    public String getGermplasmDbId() {
    return germplasmDbId;
  }

  public void setGermplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
  }

  public ObservationNewRequest germplasmName(String germplasmName) {
    this.germplasmName = germplasmName;
    return this;
  }

  /**
   * Name of the germplasm. It can be the preferred name and does not have to be unique.
   * @return germplasmName
  **/
  @ApiModelProperty(example = "A0000003", value = "Name of the germplasm. It can be the preferred name and does not have to be unique.")
  
    public String getGermplasmName() {
    return germplasmName;
  }

  public void setGermplasmName(String germplasmName) {
    this.germplasmName = germplasmName;
  }

  public ObservationNewRequest observationTimeStamp(OffsetDateTime observationTimeStamp) {
    this.observationTimeStamp = observationTimeStamp;
    return this;
  }

  /**
   * The date and time when this observation was made
   * @return observationTimeStamp
  **/
  @ApiModelProperty(value = "The date and time when this observation was made")
  
    @Valid
    public OffsetDateTime getObservationTimeStamp() {
    return observationTimeStamp;
  }

  public void setObservationTimeStamp(OffsetDateTime observationTimeStamp) {
    this.observationTimeStamp = observationTimeStamp;
  }

  public ObservationNewRequest observationUnitDbId(String observationUnitDbId) {
    this.observationUnitDbId = observationUnitDbId;
    return this;
  }

  /**
   * The ID which uniquely identifies an observation unit
   * @return observationUnitDbId
  **/
  @ApiModelProperty(example = "598111d4", value = "The ID which uniquely identifies an observation unit")
  
    public String getObservationUnitDbId() {
    return observationUnitDbId;
  }

  public void setObservationUnitDbId(String observationUnitDbId) {
    this.observationUnitDbId = observationUnitDbId;
  }

  public ObservationNewRequest observationUnitName(String observationUnitName) {
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

  public ObservationNewRequest observationVariableDbId(String observationVariableDbId) {
    this.observationVariableDbId = observationVariableDbId;
    return this;
  }

  /**
   * The ID which uniquely identifies an observation variable
   * @return observationVariableDbId
  **/
  @ApiModelProperty(example = "c403d107", value = "The ID which uniquely identifies an observation variable")
  
    public String getObservationVariableDbId() {
    return observationVariableDbId;
  }

  public void setObservationVariableDbId(String observationVariableDbId) {
    this.observationVariableDbId = observationVariableDbId;
  }

  public ObservationNewRequest observationVariableName(String observationVariableName) {
    this.observationVariableName = observationVariableName;
    return this;
  }

  /**
   * A human readable name for an observation variable
   * @return observationVariableName
  **/
  @ApiModelProperty(example = "Plant Height in meters", value = "A human readable name for an observation variable")
  
    public String getObservationVariableName() {
    return observationVariableName;
  }

  public void setObservationVariableName(String observationVariableName) {
    this.observationVariableName = observationVariableName;
  }

  public ObservationNewRequest season(Season season) {
    this.season = season;
    return this;
  }

  /**
   * Get season
   * @return season
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Season getSeason() {
    return season;
  }

  public void setSeason(Season season) {
    this.season = season;
  }

  public ObservationNewRequest studyDbId(String studyDbId) {
    this.studyDbId = studyDbId;
    return this;
  }

  /**
   * The ID which uniquely identifies a study within the given database server
   * @return studyDbId
  **/
  @ApiModelProperty(example = "ef2829db", value = "The ID which uniquely identifies a study within the given database server")
  
    public String getStudyDbId() {
    return studyDbId;
  }

  public void setStudyDbId(String studyDbId) {
    this.studyDbId = studyDbId;
  }

  public ObservationNewRequest uploadedBy(String uploadedBy) {
    this.uploadedBy = uploadedBy;
    return this;
  }

  /**
   * The name or id of the user who uploaded the observation to the database system
   * @return uploadedBy
  **/
  @ApiModelProperty(example = "a2f7f60b", value = "The name or id of the user who uploaded the observation to the database system")
  
    public String getUploadedBy() {
    return uploadedBy;
  }

  public void setUploadedBy(String uploadedBy) {
    this.uploadedBy = uploadedBy;
  }

  public ObservationNewRequest value(String value) {
    this.value = value;
    return this;
  }

  /**
   * The value of the data collected as an observation
   * @return value
  **/
  @ApiModelProperty(example = "2.3", value = "The value of the data collected as an observation")
  
    public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObservationNewRequest observationNewRequest = (ObservationNewRequest) o;
    return Objects.equals(this.additionalInfo, observationNewRequest.additionalInfo) &&
        Objects.equals(this.collector, observationNewRequest.collector) &&
        Objects.equals(this.externalReferences, observationNewRequest.externalReferences) &&
        Objects.equals(this.germplasmDbId, observationNewRequest.germplasmDbId) &&
        Objects.equals(this.germplasmName, observationNewRequest.germplasmName) &&
        Objects.equals(this.observationTimeStamp, observationNewRequest.observationTimeStamp) &&
        Objects.equals(this.observationUnitDbId, observationNewRequest.observationUnitDbId) &&
        Objects.equals(this.observationUnitName, observationNewRequest.observationUnitName) &&
        Objects.equals(this.observationVariableDbId, observationNewRequest.observationVariableDbId) &&
        Objects.equals(this.observationVariableName, observationNewRequest.observationVariableName) &&
        Objects.equals(this.season, observationNewRequest.season) &&
        Objects.equals(this.studyDbId, observationNewRequest.studyDbId) &&
        Objects.equals(this.uploadedBy, observationNewRequest.uploadedBy) &&
        Objects.equals(this.value, observationNewRequest.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalInfo, collector, externalReferences, germplasmDbId, germplasmName, observationTimeStamp, observationUnitDbId, observationUnitName, observationVariableDbId, observationVariableName, season, studyDbId, uploadedBy, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObservationNewRequest {\n");
    
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    collector: ").append(toIndentedString(collector)).append("\n");
    sb.append("    externalReferences: ").append(toIndentedString(externalReferences)).append("\n");
    sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
    sb.append("    germplasmName: ").append(toIndentedString(germplasmName)).append("\n");
    sb.append("    observationTimeStamp: ").append(toIndentedString(observationTimeStamp)).append("\n");
    sb.append("    observationUnitDbId: ").append(toIndentedString(observationUnitDbId)).append("\n");
    sb.append("    observationUnitName: ").append(toIndentedString(observationUnitName)).append("\n");
    sb.append("    observationVariableDbId: ").append(toIndentedString(observationVariableDbId)).append("\n");
    sb.append("    observationVariableName: ").append(toIndentedString(observationVariableName)).append("\n");
    sb.append("    season: ").append(toIndentedString(season)).append("\n");
    sb.append("    studyDbId: ").append(toIndentedString(studyDbId)).append("\n");
    sb.append("    uploadedBy: ").append(toIndentedString(uploadedBy)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
