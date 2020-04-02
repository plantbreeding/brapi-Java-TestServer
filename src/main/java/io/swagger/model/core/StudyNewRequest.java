package io.swagger.model.core;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.common.DataLink;
import io.swagger.model.common.ExternalReferences;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * StudyNewRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class StudyNewRequest   {
  @JsonProperty("active")
  private Boolean active = null;

  @JsonProperty("additionalInfo")
  @Valid
  private Map<String, String> additionalInfo = null;

  @JsonProperty("commonCropName")
  private String commonCropName = null;

  @JsonProperty("contacts")
  @Valid
  private List<Contact> contacts = null;

  @JsonProperty("culturalPractices")
  private String culturalPractices = null;

  @JsonProperty("dataLinks")
  @Valid
  private List<DataLink> dataLinks = null;

  @JsonProperty("documentationURL")
  private String documentationURL = null;

  @JsonProperty("endDate")
  private OffsetDateTime endDate = null;

  @JsonProperty("environmentParameters")
  @Valid
  private List<EnvironmentParameter> environmentParameters = null;

  @JsonProperty("experimentalDesign")
  private StudyExperimentalDesign experimentalDesign = null;

  @JsonProperty("externalReferences")
  private ExternalReferences externalReferences = null;

  @JsonProperty("growthFacility")
  private StudyGrowthFacility growthFacility = null;

  @JsonProperty("lastUpdate")
  private StudyLastUpdate lastUpdate = null;

  @JsonProperty("license")
  private String license = null;

  @JsonProperty("locationDbId")
  private String locationDbId = null;

  @JsonProperty("locationName")
  private String locationName = null;

  @JsonProperty("observationLevels")
  @Valid
  private List<ObservationUnitHierarchyLevel> observationLevels = null;

  @JsonProperty("observationUnitsDescription")
  private String observationUnitsDescription = null;

  @JsonProperty("seasons")
  @Valid
  private List<String> seasons = null;

  @JsonProperty("startDate")
  private OffsetDateTime startDate = null;

  @JsonProperty("studyCode")
  private String studyCode = null;

  @JsonProperty("studyDescription")
  private String studyDescription = null;

  @JsonProperty("studyName")
  private String studyName = null;

  @JsonProperty("studyPUI")
  private String studyPUI = null;

  @JsonProperty("studyType")
  private String studyType = null;

  @JsonProperty("trialDbId")
  private String trialDbId = null;

  @JsonProperty("trialName")
  private String trialName = null;

  public StudyNewRequest active(Boolean active) {
    this.active = active;
    return this;
  }

  /**
   * Is this study currently active
   * @return active
  **/
  @ApiModelProperty(example = "true", value = "Is this study currently active")
  
    public Boolean isActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public StudyNewRequest additionalInfo(Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  public StudyNewRequest putAdditionalInfoItem(String key, String additionalInfoItem) {
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

  public StudyNewRequest commonCropName(String commonCropName) {
    this.commonCropName = commonCropName;
    return this;
  }

  /**
   * Common name for the crop associated with this study
   * @return commonCropName
  **/
  @ApiModelProperty(example = "Grape", value = "Common name for the crop associated with this study")
  
    public String getCommonCropName() {
    return commonCropName;
  }

  public void setCommonCropName(String commonCropName) {
    this.commonCropName = commonCropName;
  }

  public StudyNewRequest contacts(List<Contact> contacts) {
    this.contacts = contacts;
    return this;
  }

  public StudyNewRequest addContactsItem(Contact contactsItem) {
    if (this.contacts == null) {
      this.contacts = new ArrayList<Contact>();
    }
    this.contacts.add(contactsItem);
    return this;
  }

  /**
   * List of contact entities associated with this study
   * @return contacts
  **/
  @ApiModelProperty(value = "List of contact entities associated with this study")
      @Valid
    public List<Contact> getContacts() {
    return contacts;
  }

  public void setContacts(List<Contact> contacts) {
    this.contacts = contacts;
  }

  public StudyNewRequest culturalPractices(String culturalPractices) {
    this.culturalPractices = culturalPractices;
    return this;
  }

  /**
   * MIAPPE V1.1 (DM-28) Cultural practices - General description of the cultural practices of the study.
   * @return culturalPractices
  **/
  @ApiModelProperty(example = "Irrigation was applied according needs during summer to prevent water stress.", value = "MIAPPE V1.1 (DM-28) Cultural practices - General description of the cultural practices of the study.")
  
    public String getCulturalPractices() {
    return culturalPractices;
  }

  public void setCulturalPractices(String culturalPractices) {
    this.culturalPractices = culturalPractices;
  }

  public StudyNewRequest dataLinks(List<DataLink> dataLinks) {
    this.dataLinks = dataLinks;
    return this;
  }

  public StudyNewRequest addDataLinksItem(DataLink dataLinksItem) {
    if (this.dataLinks == null) {
      this.dataLinks = new ArrayList<DataLink>();
    }
    this.dataLinks.add(dataLinksItem);
    return this;
  }

  /**
   * List of links to extra data files associated with this study. Extra data could include notes, images, and reference data.
   * @return dataLinks
  **/
  @ApiModelProperty(value = "List of links to extra data files associated with this study. Extra data could include notes, images, and reference data.")
      @Valid
    public List<DataLink> getDataLinks() {
    return dataLinks;
  }

  public void setDataLinks(List<DataLink> dataLinks) {
    this.dataLinks = dataLinks;
  }

  public StudyNewRequest documentationURL(String documentationURL) {
    this.documentationURL = documentationURL;
    return this;
  }

  /**
   * A URL to the human readable documentation of this object
   * @return documentationURL
  **/
  @ApiModelProperty(example = "https://wiki.brapi.org", value = "A URL to the human readable documentation of this object")
  
    public String getDocumentationURL() {
    return documentationURL;
  }

  public void setDocumentationURL(String documentationURL) {
    this.documentationURL = documentationURL;
  }

  public StudyNewRequest endDate(OffsetDateTime endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * The date the study ends  MIAPPE V1.1 (DM-15) End date of study - Date and, if relevant, time when the experiment ended
   * @return endDate
  **/
  @ApiModelProperty(value = "The date the study ends  MIAPPE V1.1 (DM-15) End date of study - Date and, if relevant, time when the experiment ended")
  
    @Valid
    public OffsetDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(OffsetDateTime endDate) {
    this.endDate = endDate;
  }

  public StudyNewRequest environmentParameters(List<EnvironmentParameter> environmentParameters) {
    this.environmentParameters = environmentParameters;
    return this;
  }

  public StudyNewRequest addEnvironmentParametersItem(EnvironmentParameter environmentParametersItem) {
    if (this.environmentParameters == null) {
      this.environmentParameters = new ArrayList<EnvironmentParameter>();
    }
    this.environmentParameters.add(environmentParametersItem);
    return this;
  }

  /**
   * Environmental parameters that were kept constant throughout the study and did not change between observation units.
   * @return environmentParameters
  **/
  @ApiModelProperty(value = "Environmental parameters that were kept constant throughout the study and did not change between observation units.")
      @Valid
    public List<EnvironmentParameter> getEnvironmentParameters() {
    return environmentParameters;
  }

  public void setEnvironmentParameters(List<EnvironmentParameter> environmentParameters) {
    this.environmentParameters = environmentParameters;
  }

  public StudyNewRequest experimentalDesign(StudyExperimentalDesign experimentalDesign) {
    this.experimentalDesign = experimentalDesign;
    return this;
  }

  /**
   * Get experimentalDesign
   * @return experimentalDesign
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public StudyExperimentalDesign getExperimentalDesign() {
    return experimentalDesign;
  }

  public void setExperimentalDesign(StudyExperimentalDesign experimentalDesign) {
    this.experimentalDesign = experimentalDesign;
  }

  public StudyNewRequest externalReferences(ExternalReferences externalReferences) {
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

  public StudyNewRequest growthFacility(StudyGrowthFacility growthFacility) {
    this.growthFacility = growthFacility;
    return this;
  }

  /**
   * Get growthFacility
   * @return growthFacility
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public StudyGrowthFacility getGrowthFacility() {
    return growthFacility;
  }

  public void setGrowthFacility(StudyGrowthFacility growthFacility) {
    this.growthFacility = growthFacility;
  }

  public StudyNewRequest lastUpdate(StudyLastUpdate lastUpdate) {
    this.lastUpdate = lastUpdate;
    return this;
  }

  /**
   * Get lastUpdate
   * @return lastUpdate
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public StudyLastUpdate getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(StudyLastUpdate lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public StudyNewRequest license(String license) {
    this.license = license;
    return this;
  }

  /**
   * The usage license associated with the study data
   * @return license
  **/
  @ApiModelProperty(example = "MIT License", value = "The usage license associated with the study data")
  
    public String getLicense() {
    return license;
  }

  public void setLicense(String license) {
    this.license = license;
  }

  public StudyNewRequest locationDbId(String locationDbId) {
    this.locationDbId = locationDbId;
    return this;
  }

  /**
   * The unique identifier for a Location
   * @return locationDbId
  **/
  @ApiModelProperty(example = "3cfdd67d", value = "The unique identifier for a Location")
  
    public String getLocationDbId() {
    return locationDbId;
  }

  public void setLocationDbId(String locationDbId) {
    this.locationDbId = locationDbId;
  }

  public StudyNewRequest locationName(String locationName) {
    this.locationName = locationName;
    return this;
  }

  /**
   * A human readable name for this location  MIAPPE V1.1 (DM-18) Experimental site name - The name of the natural site, experimental field, greenhouse, phenotyping facility, etc. where the experiment took place.
   * @return locationName
  **/
  @ApiModelProperty(example = "Location 1", value = "A human readable name for this location  MIAPPE V1.1 (DM-18) Experimental site name - The name of the natural site, experimental field, greenhouse, phenotyping facility, etc. where the experiment took place.")
  
    public String getLocationName() {
    return locationName;
  }

  public void setLocationName(String locationName) {
    this.locationName = locationName;
  }

  public StudyNewRequest observationLevels(List<ObservationUnitHierarchyLevel> observationLevels) {
    this.observationLevels = observationLevels;
    return this;
  }

  public StudyNewRequest addObservationLevelsItem(ObservationUnitHierarchyLevel observationLevelsItem) {
    if (this.observationLevels == null) {
      this.observationLevels = new ArrayList<ObservationUnitHierarchyLevel>();
    }
    this.observationLevels.add(observationLevelsItem);
    return this;
  }

  /**
   * Observation levels indicate the granularity level at which the measurements are taken. `levelName` defines the level, `levelOrder` defines where that level exists in the hierarchy of levels. `levelOrder`s lower numbers are at the top of the hierarchy (ie field > 0) and higher numbers are at the bottom of the hierarchy (ie plant > 6). 
   * @return observationLevels
  **/
  @ApiModelProperty(example = "[{\"levelName\":\"field\",\"levelOrder\":0},{\"levelName\":\"block\",\"levelOrder\":1},{\"levelName\":\"plot\",\"levelOrder\":2}]", value = "Observation levels indicate the granularity level at which the measurements are taken. `levelName` defines the level, `levelOrder` defines where that level exists in the hierarchy of levels. `levelOrder`s lower numbers are at the top of the hierarchy (ie field > 0) and higher numbers are at the bottom of the hierarchy (ie plant > 6). ")
      @Valid
    public List<ObservationUnitHierarchyLevel> getObservationLevels() {
    return observationLevels;
  }

  public void setObservationLevels(List<ObservationUnitHierarchyLevel> observationLevels) {
    this.observationLevels = observationLevels;
  }

  public StudyNewRequest observationUnitsDescription(String observationUnitsDescription) {
    this.observationUnitsDescription = observationUnitsDescription;
    return this;
  }

  /**
   * MIAPPE V1.1 (DM-25) Observation unit description - General description of the observation units in the study.
   * @return observationUnitsDescription
  **/
  @ApiModelProperty(example = "Observation units consisted in individual plots themselves consisting of a row of 15 plants at a density of approximately six plants per square meter.", value = "MIAPPE V1.1 (DM-25) Observation unit description - General description of the observation units in the study.")
  
    public String getObservationUnitsDescription() {
    return observationUnitsDescription;
  }

  public void setObservationUnitsDescription(String observationUnitsDescription) {
    this.observationUnitsDescription = observationUnitsDescription;
  }

  public StudyNewRequest seasons(List<String> seasons) {
    this.seasons = seasons;
    return this;
  }

  public StudyNewRequest addSeasonsItem(String seasonsItem) {
    if (this.seasons == null) {
      this.seasons = new ArrayList<String>();
    }
    this.seasons.add(seasonsItem);
    return this;
  }

  /**
   * List of seasons over which this study was performed.
   * @return seasons
  **/
  @ApiModelProperty(example = "[\"Spring_2018\"]", value = "List of seasons over which this study was performed.")
  
    public List<String> getSeasons() {
    return seasons;
  }

  public void setSeasons(List<String> seasons) {
    this.seasons = seasons;
  }

  public StudyNewRequest startDate(OffsetDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * The date this study started  MIAPPE V1.1 (DM-14) Start date of study - Date and, if relevant, time when the experiment started
   * @return startDate
  **/
  @ApiModelProperty(value = "The date this study started  MIAPPE V1.1 (DM-14) Start date of study - Date and, if relevant, time when the experiment started")
  
    @Valid
    public OffsetDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(OffsetDateTime startDate) {
    this.startDate = startDate;
  }

  public StudyNewRequest studyCode(String studyCode) {
    this.studyCode = studyCode;
    return this;
  }

  /**
   * A short human readable code for a study
   * @return studyCode
  **/
  @ApiModelProperty(example = "Grape_Yield_Spring_2018", value = "A short human readable code for a study")
  
    public String getStudyCode() {
    return studyCode;
  }

  public void setStudyCode(String studyCode) {
    this.studyCode = studyCode;
  }

  public StudyNewRequest studyDescription(String studyDescription) {
    this.studyDescription = studyDescription;
    return this;
  }

  /**
   * The description of this study  MIAPPE V1.1 (DM-13) Study description - Human-readable text describing the study
   * @return studyDescription
  **/
  @ApiModelProperty(example = "This is a yield study for Spring 2018", value = "The description of this study  MIAPPE V1.1 (DM-13) Study description - Human-readable text describing the study")
  
    public String getStudyDescription() {
    return studyDescription;
  }

  public void setStudyDescription(String studyDescription) {
    this.studyDescription = studyDescription;
  }

  public StudyNewRequest studyName(String studyName) {
    this.studyName = studyName;
    return this;
  }

  /**
   * The human readable name for a study  MIAPPE V1.1 (DM-12) Study title - Human-readable text summarising the study
   * @return studyName
  **/
  @ApiModelProperty(example = "INRA's Walnut Genetic Resources Observation at Kenya", value = "The human readable name for a study  MIAPPE V1.1 (DM-12) Study title - Human-readable text summarising the study")
  
    public String getStudyName() {
    return studyName;
  }

  public void setStudyName(String studyName) {
    this.studyName = studyName;
  }

  public StudyNewRequest studyPUI(String studyPUI) {
    this.studyPUI = studyPUI;
    return this;
  }

  /**
   * A permanent unique identifier associated with this study data. For example, a URI or DOI
   * @return studyPUI
  **/
  @ApiModelProperty(example = "doi:10.155454/12349537312", value = "A permanent unique identifier associated with this study data. For example, a URI or DOI")
  
    public String getStudyPUI() {
    return studyPUI;
  }

  public void setStudyPUI(String studyPUI) {
    this.studyPUI = studyPUI;
  }

  public StudyNewRequest studyType(String studyType) {
    this.studyType = studyType;
    return this;
  }

  /**
   * The type of study being performed. ex. \"Yield Trial\", etc
   * @return studyType
  **/
  @ApiModelProperty(example = "Phenotyping", value = "The type of study being performed. ex. \"Yield Trial\", etc")
  
    public String getStudyType() {
    return studyType;
  }

  public void setStudyType(String studyType) {
    this.studyType = studyType;
  }

  public StudyNewRequest trialDbId(String trialDbId) {
    this.trialDbId = trialDbId;
    return this;
  }

  /**
   * The ID which uniquely identifies a trial
   * @return trialDbId
  **/
  @ApiModelProperty(example = "48b327ea", value = "The ID which uniquely identifies a trial")
  
    public String getTrialDbId() {
    return trialDbId;
  }

  public void setTrialDbId(String trialDbId) {
    this.trialDbId = trialDbId;
  }

  public StudyNewRequest trialName(String trialName) {
    this.trialName = trialName;
    return this;
  }

  /**
   * The human readable name of a trial
   * @return trialName
  **/
  @ApiModelProperty(example = "Grape_Yield_Trial", value = "The human readable name of a trial")
  
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
    StudyNewRequest studyNewRequest = (StudyNewRequest) o;
    return Objects.equals(this.active, studyNewRequest.active) &&
        Objects.equals(this.additionalInfo, studyNewRequest.additionalInfo) &&
        Objects.equals(this.commonCropName, studyNewRequest.commonCropName) &&
        Objects.equals(this.contacts, studyNewRequest.contacts) &&
        Objects.equals(this.culturalPractices, studyNewRequest.culturalPractices) &&
        Objects.equals(this.dataLinks, studyNewRequest.dataLinks) &&
        Objects.equals(this.documentationURL, studyNewRequest.documentationURL) &&
        Objects.equals(this.endDate, studyNewRequest.endDate) &&
        Objects.equals(this.environmentParameters, studyNewRequest.environmentParameters) &&
        Objects.equals(this.experimentalDesign, studyNewRequest.experimentalDesign) &&
        Objects.equals(this.externalReferences, studyNewRequest.externalReferences) &&
        Objects.equals(this.growthFacility, studyNewRequest.growthFacility) &&
        Objects.equals(this.lastUpdate, studyNewRequest.lastUpdate) &&
        Objects.equals(this.license, studyNewRequest.license) &&
        Objects.equals(this.locationDbId, studyNewRequest.locationDbId) &&
        Objects.equals(this.locationName, studyNewRequest.locationName) &&
        Objects.equals(this.observationLevels, studyNewRequest.observationLevels) &&
        Objects.equals(this.observationUnitsDescription, studyNewRequest.observationUnitsDescription) &&
        Objects.equals(this.seasons, studyNewRequest.seasons) &&
        Objects.equals(this.startDate, studyNewRequest.startDate) &&
        Objects.equals(this.studyCode, studyNewRequest.studyCode) &&
        Objects.equals(this.studyDescription, studyNewRequest.studyDescription) &&
        Objects.equals(this.studyName, studyNewRequest.studyName) &&
        Objects.equals(this.studyPUI, studyNewRequest.studyPUI) &&
        Objects.equals(this.studyType, studyNewRequest.studyType) &&
        Objects.equals(this.trialDbId, studyNewRequest.trialDbId) &&
        Objects.equals(this.trialName, studyNewRequest.trialName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(active, additionalInfo, commonCropName, contacts, culturalPractices, dataLinks, documentationURL, endDate, environmentParameters, experimentalDesign, externalReferences, growthFacility, lastUpdate, license, locationDbId, locationName, observationLevels, observationUnitsDescription, seasons, startDate, studyCode, studyDescription, studyName, studyPUI, studyType, trialDbId, trialName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StudyNewRequest {\n");
    
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    commonCropName: ").append(toIndentedString(commonCropName)).append("\n");
    sb.append("    contacts: ").append(toIndentedString(contacts)).append("\n");
    sb.append("    culturalPractices: ").append(toIndentedString(culturalPractices)).append("\n");
    sb.append("    dataLinks: ").append(toIndentedString(dataLinks)).append("\n");
    sb.append("    documentationURL: ").append(toIndentedString(documentationURL)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    environmentParameters: ").append(toIndentedString(environmentParameters)).append("\n");
    sb.append("    experimentalDesign: ").append(toIndentedString(experimentalDesign)).append("\n");
    sb.append("    externalReferences: ").append(toIndentedString(externalReferences)).append("\n");
    sb.append("    growthFacility: ").append(toIndentedString(growthFacility)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    license: ").append(toIndentedString(license)).append("\n");
    sb.append("    locationDbId: ").append(toIndentedString(locationDbId)).append("\n");
    sb.append("    locationName: ").append(toIndentedString(locationName)).append("\n");
    sb.append("    observationLevels: ").append(toIndentedString(observationLevels)).append("\n");
    sb.append("    observationUnitsDescription: ").append(toIndentedString(observationUnitsDescription)).append("\n");
    sb.append("    seasons: ").append(toIndentedString(seasons)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    studyCode: ").append(toIndentedString(studyCode)).append("\n");
    sb.append("    studyDescription: ").append(toIndentedString(studyDescription)).append("\n");
    sb.append("    studyName: ").append(toIndentedString(studyName)).append("\n");
    sb.append("    studyPUI: ").append(toIndentedString(studyPUI)).append("\n");
    sb.append("    studyType: ").append(toIndentedString(studyType)).append("\n");
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
