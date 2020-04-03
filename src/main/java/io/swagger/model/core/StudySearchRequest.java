package io.swagger.model.core;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.common.SearchRequestParametersPaging;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * StudySearchRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class StudySearchRequest extends SearchRequestParametersPaging  {
  @JsonProperty("commonCropNames")
  @Valid
  private List<String> commonCropNames = null;

  @JsonProperty("programDbIds")
  @Valid
  private List<String> programDbIds = null;

  @JsonProperty("programNames")
  @Valid
  private List<String> programNames = null;

  @JsonProperty("trialDbIds")
  @Valid
  private List<String> trialDbIds = null;

  @JsonProperty("trialNames")
  @Valid
  private List<String> trialNames = null;

  @JsonProperty("studyDbIds")
  @Valid
  private List<String> studyDbIds = null;

  @JsonProperty("studyNames")
  @Valid
  private List<String> studyNames = null;

  @JsonProperty("locationDbIds")
  @Valid
  private List<String> locationDbIds = null;

  @JsonProperty("locationNames")
  @Valid
  private List<String> locationNames = null;

  @JsonProperty("germplasmDbIds")
  @Valid
  private List<String> germplasmDbIds = null;

  @JsonProperty("germplasmNames")
  @Valid
  private List<String> germplasmNames = null;

  @JsonProperty("observationVariableDbIds")
  @Valid
  private List<String> observationVariableDbIds = null;

  @JsonProperty("observationVariableNames")
  @Valid
  private List<String> observationVariableNames = null;

  @JsonProperty("externalReferenceIDs")
  @Valid
  private List<String> externalReferenceIDs = null;

  @JsonProperty("externalReferenceSources")
  @Valid
  private List<String> externalReferenceSources = null;

  @JsonProperty("active")
  private Boolean active = null;

  @JsonProperty("seasonDbIds")
  @Valid
  private List<String> seasonDbIds = null;

  @JsonProperty("sortBy")
  private SortBy sortBy = null;

  @JsonProperty("sortOrder")
  private SortOrder sortOrder = null;

  @JsonProperty("studyCodes")
  @Valid
  private List<String> studyCodes = null;

  @JsonProperty("studyPUIs")
  @Valid
  private List<String> studyPUIs = null;

  @JsonProperty("studyTypes")
  @Valid
  private List<String> studyTypes = null;

  public StudySearchRequest commonCropNames(List<String> commonCropNames) {
    this.commonCropNames = commonCropNames;
    return this;
  }

  public StudySearchRequest addCommonCropNamesItem(String commonCropNamesItem) {
    if (this.commonCropNames == null) {
      this.commonCropNames = new ArrayList<String>();
    }
    this.commonCropNames.add(commonCropNamesItem);
    return this;
  }

  /**
   * Common name for the crop which this program is for
   * @return commonCropNames
  **/
  @ApiModelProperty(example = "[\"Tomatillo\",\"Paw Paw\"]", value = "Common name for the crop which this program is for")
  
    public List<String> getCommonCropNames() {
    return commonCropNames;
  }

  public void setCommonCropNames(List<String> commonCropNames) {
    this.commonCropNames = commonCropNames;
  }

  public StudySearchRequest programDbIds(List<String> programDbIds) {
    this.programDbIds = programDbIds;
    return this;
  }

  public StudySearchRequest addProgramDbIdsItem(String programDbIdsItem) {
    if (this.programDbIds == null) {
      this.programDbIds = new ArrayList<String>();
    }
    this.programDbIds.add(programDbIdsItem);
    return this;
  }

  /**
   * A program identifier to search for
   * @return programDbIds
  **/
  @ApiModelProperty(example = "[\"8f5de35b\",\"0e2d4a13\"]", value = "A program identifier to search for")
  
    public List<String> getProgramDbIds() {
    return programDbIds;
  }

  public void setProgramDbIds(List<String> programDbIds) {
    this.programDbIds = programDbIds;
  }

  public StudySearchRequest programNames(List<String> programNames) {
    this.programNames = programNames;
    return this;
  }

  public StudySearchRequest addProgramNamesItem(String programNamesItem) {
    if (this.programNames == null) {
      this.programNames = new ArrayList<String>();
    }
    this.programNames.add(programNamesItem);
    return this;
  }

  /**
   * A name of a program to search for
   * @return programNames
  **/
  @ApiModelProperty(example = "[\"Better Breeding Program\",\"Best Breeding Program\"]", value = "A name of a program to search for")
  
    public List<String> getProgramNames() {
    return programNames;
  }

  public void setProgramNames(List<String> programNames) {
    this.programNames = programNames;
  }

  public StudySearchRequest trialDbIds(List<String> trialDbIds) {
    this.trialDbIds = trialDbIds;
    return this;
  }

  public StudySearchRequest addTrialDbIdsItem(String trialDbIdsItem) {
    if (this.trialDbIds == null) {
      this.trialDbIds = new ArrayList<String>();
    }
    this.trialDbIds.add(trialDbIdsItem);
    return this;
  }

  /**
   * The ID which uniquely identifies a trial to search for
   * @return trialDbIds
  **/
  @ApiModelProperty(example = "[\"d2593dc2\",\"9431a731\"]", value = "The ID which uniquely identifies a trial to search for")
  
    public List<String> getTrialDbIds() {
    return trialDbIds;
  }

  public void setTrialDbIds(List<String> trialDbIds) {
    this.trialDbIds = trialDbIds;
  }

  public StudySearchRequest trialNames(List<String> trialNames) {
    this.trialNames = trialNames;
    return this;
  }

  public StudySearchRequest addTrialNamesItem(String trialNamesItem) {
    if (this.trialNames == null) {
      this.trialNames = new ArrayList<String>();
    }
    this.trialNames.add(trialNamesItem);
    return this;
  }

  /**
   * The human readable name of a trial to search for
   * @return trialNames
  **/
  @ApiModelProperty(example = "[\"All Yield Trials 2016\",\"Disease Resistance Study Comparison Group\"]", value = "The human readable name of a trial to search for")
  
    public List<String> getTrialNames() {
    return trialNames;
  }

  public void setTrialNames(List<String> trialNames) {
    this.trialNames = trialNames;
  }

  public StudySearchRequest studyDbIds(List<String> studyDbIds) {
    this.studyDbIds = studyDbIds;
    return this;
  }

  public StudySearchRequest addStudyDbIdsItem(String studyDbIdsItem) {
    if (this.studyDbIds == null) {
      this.studyDbIds = new ArrayList<String>();
    }
    this.studyDbIds.add(studyDbIdsItem);
    return this;
  }

  /**
   * List of study identifiers to search for
   * @return studyDbIds
  **/
  @ApiModelProperty(example = "[\"cf6c4bd4\",\"691e69d6\"]", value = "List of study identifiers to search for")
  
    public List<String> getStudyDbIds() {
    return studyDbIds;
  }

  public void setStudyDbIds(List<String> studyDbIds) {
    this.studyDbIds = studyDbIds;
  }

  public StudySearchRequest studyNames(List<String> studyNames) {
    this.studyNames = studyNames;
    return this;
  }

  public StudySearchRequest addStudyNamesItem(String studyNamesItem) {
    if (this.studyNames == null) {
      this.studyNames = new ArrayList<String>();
    }
    this.studyNames.add(studyNamesItem);
    return this;
  }

  /**
   * List of study names to filter search results
   * @return studyNames
  **/
  @ApiModelProperty(example = "[\"The First Bob Study 2017\",\"Wheat Yield Trial 246\"]", value = "List of study names to filter search results")
  
    public List<String> getStudyNames() {
    return studyNames;
  }

  public void setStudyNames(List<String> studyNames) {
    this.studyNames = studyNames;
  }

  public StudySearchRequest locationDbIds(List<String> locationDbIds) {
    this.locationDbIds = locationDbIds;
    return this;
  }

  public StudySearchRequest addLocationDbIdsItem(String locationDbIdsItem) {
    if (this.locationDbIds == null) {
      this.locationDbIds = new ArrayList<String>();
    }
    this.locationDbIds.add(locationDbIdsItem);
    return this;
  }

  /**
   * The location ids to search for
   * @return locationDbIds
  **/
  @ApiModelProperty(example = "[\"b28911cf\",\"5071d1e4\"]", value = "The location ids to search for")
  
    public List<String> getLocationDbIds() {
    return locationDbIds;
  }

  public void setLocationDbIds(List<String> locationDbIds) {
    this.locationDbIds = locationDbIds;
  }

  public StudySearchRequest locationNames(List<String> locationNames) {
    this.locationNames = locationNames;
    return this;
  }

  public StudySearchRequest addLocationNamesItem(String locationNamesItem) {
    if (this.locationNames == null) {
      this.locationNames = new ArrayList<String>();
    }
    this.locationNames.add(locationNamesItem);
    return this;
  }

  /**
   * A human readable names to search for
   * @return locationNames
  **/
  @ApiModelProperty(example = "[\"Location Alpha\",\"The Large Hadron Collider\"]", value = "A human readable names to search for")
  
    public List<String> getLocationNames() {
    return locationNames;
  }

  public void setLocationNames(List<String> locationNames) {
    this.locationNames = locationNames;
  }

  public StudySearchRequest germplasmDbIds(List<String> germplasmDbIds) {
    this.germplasmDbIds = germplasmDbIds;
    return this;
  }

  public StudySearchRequest addGermplasmDbIdsItem(String germplasmDbIdsItem) {
    if (this.germplasmDbIds == null) {
      this.germplasmDbIds = new ArrayList<String>();
    }
    this.germplasmDbIds.add(germplasmDbIdsItem);
    return this;
  }

  /**
   * List of IDs which uniquely identify germplasm to search for
   * @return germplasmDbIds
  **/
  @ApiModelProperty(example = "[\"e9c6edd7\",\"1b1df4a6\"]", value = "List of IDs which uniquely identify germplasm to search for")
  
    public List<String> getGermplasmDbIds() {
    return germplasmDbIds;
  }

  public void setGermplasmDbIds(List<String> germplasmDbIds) {
    this.germplasmDbIds = germplasmDbIds;
  }

  public StudySearchRequest germplasmNames(List<String> germplasmNames) {
    this.germplasmNames = germplasmNames;
    return this;
  }

  public StudySearchRequest addGermplasmNamesItem(String germplasmNamesItem) {
    if (this.germplasmNames == null) {
      this.germplasmNames = new ArrayList<String>();
    }
    this.germplasmNames.add(germplasmNamesItem);
    return this;
  }

  /**
   * List of human readable names to identify germplasm to search for
   * @return germplasmNames
  **/
  @ApiModelProperty(example = "[\"A0000003\",\"A0000477\"]", value = "List of human readable names to identify germplasm to search for")
  
    public List<String> getGermplasmNames() {
    return germplasmNames;
  }

  public void setGermplasmNames(List<String> germplasmNames) {
    this.germplasmNames = germplasmNames;
  }

  public StudySearchRequest observationVariableDbIds(List<String> observationVariableDbIds) {
    this.observationVariableDbIds = observationVariableDbIds;
    return this;
  }

  public StudySearchRequest addObservationVariableDbIdsItem(String observationVariableDbIdsItem) {
    if (this.observationVariableDbIds == null) {
      this.observationVariableDbIds = new ArrayList<String>();
    }
    this.observationVariableDbIds.add(observationVariableDbIdsItem);
    return this;
  }

  /**
   * List of observation variable IDs to search for
   * @return observationVariableDbIds
  **/
  @ApiModelProperty(example = "[\"819e508f\",\"f540b703\"]", value = "List of observation variable IDs to search for")
  
    public List<String> getObservationVariableDbIds() {
    return observationVariableDbIds;
  }

  public void setObservationVariableDbIds(List<String> observationVariableDbIds) {
    this.observationVariableDbIds = observationVariableDbIds;
  }

  public StudySearchRequest observationVariableNames(List<String> observationVariableNames) {
    this.observationVariableNames = observationVariableNames;
    return this;
  }

  public StudySearchRequest addObservationVariableNamesItem(String observationVariableNamesItem) {
    if (this.observationVariableNames == null) {
      this.observationVariableNames = new ArrayList<String>();
    }
    this.observationVariableNames.add(observationVariableNamesItem);
    return this;
  }

  /**
   * The names of Variables to search for
   * @return observationVariableNames
  **/
  @ApiModelProperty(example = "[\"Plant Height in meters\",\"Wheat rust score 1-5\"]", value = "The names of Variables to search for")
  
    public List<String> getObservationVariableNames() {
    return observationVariableNames;
  }

  public void setObservationVariableNames(List<String> observationVariableNames) {
    this.observationVariableNames = observationVariableNames;
  }

  public StudySearchRequest externalReferenceIDs(List<String> externalReferenceIDs) {
    this.externalReferenceIDs = externalReferenceIDs;
    return this;
  }

  public StudySearchRequest addExternalReferenceIDsItem(String externalReferenceIDsItem) {
    if (this.externalReferenceIDs == null) {
      this.externalReferenceIDs = new ArrayList<String>();
    }
    this.externalReferenceIDs.add(externalReferenceIDsItem);
    return this;
  }

  /**
   * List of external references for the trait to search for
   * @return externalReferenceIDs
  **/
  @ApiModelProperty(example = "[\"http://purl.obolibrary.org/obo/ro.owl\",\"14a19841\"]", value = "List of external references for the trait to search for")
  
    public List<String> getExternalReferenceIDs() {
    return externalReferenceIDs;
  }

  public void setExternalReferenceIDs(List<String> externalReferenceIDs) {
    this.externalReferenceIDs = externalReferenceIDs;
  }

  public StudySearchRequest externalReferenceSources(List<String> externalReferenceSources) {
    this.externalReferenceSources = externalReferenceSources;
    return this;
  }

  public StudySearchRequest addExternalReferenceSourcesItem(String externalReferenceSourcesItem) {
    if (this.externalReferenceSources == null) {
      this.externalReferenceSources = new ArrayList<String>();
    }
    this.externalReferenceSources.add(externalReferenceSourcesItem);
    return this;
  }

  /**
   * List of external references sources for the trait to search for
   * @return externalReferenceSources
  **/
  @ApiModelProperty(example = "[\"OBO Library\",\"Field App Name\"]", value = "List of external references sources for the trait to search for")
  
    public List<String> getExternalReferenceSources() {
    return externalReferenceSources;
  }

  public void setExternalReferenceSources(List<String> externalReferenceSources) {
    this.externalReferenceSources = externalReferenceSources;
  }

  public StudySearchRequest active(Boolean active) {
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

  public StudySearchRequest seasonDbIds(List<String> seasonDbIds) {
    this.seasonDbIds = seasonDbIds;
    return this;
  }

  public StudySearchRequest addSeasonDbIdsItem(String seasonDbIdsItem) {
    if (this.seasonDbIds == null) {
      this.seasonDbIds = new ArrayList<String>();
    }
    this.seasonDbIds.add(seasonDbIdsItem);
    return this;
  }

  /**
   * The ID which uniquely identifies a season
   * @return seasonDbIds
  **/
  @ApiModelProperty(example = "[\"Harvest Two 2017\",\"Summer 2018\"]", value = "The ID which uniquely identifies a season")
  
    public List<String> getSeasonDbIds() {
    return seasonDbIds;
  }

  public void setSeasonDbIds(List<String> seasonDbIds) {
    this.seasonDbIds = seasonDbIds;
  }

  public StudySearchRequest sortBy(SortBy sortBy) {
    this.sortBy = sortBy;
    return this;
  }

  /**
   * Name of one of the fields within the study object on which results can be sorted
   * @return sortBy
  **/
  @ApiModelProperty(value = "Name of one of the fields within the study object on which results can be sorted")
  
    public SortBy getSortBy() {
    return sortBy;
  }

  public void setSortBy(SortBy sortBy) {
    this.sortBy = sortBy;
  }

  public StudySearchRequest sortOrder(SortOrder sortOrder) {
    this.sortOrder = sortOrder;
    return this;
  }

  /**
   * Order results should be sorted. ex. \"ASC\" or \"DESC\"
   * @return sortOrder
  **/
  @ApiModelProperty(value = "Order results should be sorted. ex. \"ASC\" or \"DESC\"")
  
    public SortOrder getSortOrder() {
    return sortOrder;
  }

  public void setSortOrder(SortOrder sortOrder) {
    this.sortOrder = sortOrder;
  }

  public StudySearchRequest studyCodes(List<String> studyCodes) {
    this.studyCodes = studyCodes;
    return this;
  }

  public StudySearchRequest addStudyCodesItem(String studyCodesItem) {
    if (this.studyCodes == null) {
      this.studyCodes = new ArrayList<String>();
    }
    this.studyCodes.add(studyCodesItem);
    return this;
  }

  /**
   * A short human readable code for a study
   * @return studyCodes
  **/
  @ApiModelProperty(example = "[\"Grape_Yield_Spring_2018\",\"Walnut_Kenya\"]", value = "A short human readable code for a study")
  
    public List<String> getStudyCodes() {
    return studyCodes;
  }

  public void setStudyCodes(List<String> studyCodes) {
    this.studyCodes = studyCodes;
  }

  public StudySearchRequest studyPUIs(List<String> studyPUIs) {
    this.studyPUIs = studyPUIs;
    return this;
  }

  public StudySearchRequest addStudyPUIsItem(String studyPUIsItem) {
    if (this.studyPUIs == null) {
      this.studyPUIs = new ArrayList<String>();
    }
    this.studyPUIs.add(studyPUIsItem);
    return this;
  }

  /**
   * Permanent unique identifier associated with study data. For example, a URI or DOI
   * @return studyPUIs
  **/
  @ApiModelProperty(example = "[\"doi:10.155454/12349537312\",\"https://pui.per/d8dd35e1\"]", value = "Permanent unique identifier associated with study data. For example, a URI or DOI")
  
    public List<String> getStudyPUIs() {
    return studyPUIs;
  }

  public void setStudyPUIs(List<String> studyPUIs) {
    this.studyPUIs = studyPUIs;
  }

  public StudySearchRequest studyTypes(List<String> studyTypes) {
    this.studyTypes = studyTypes;
    return this;
  }

  public StudySearchRequest addStudyTypesItem(String studyTypesItem) {
    if (this.studyTypes == null) {
      this.studyTypes = new ArrayList<String>();
    }
    this.studyTypes.add(studyTypesItem);
    return this;
  }

  /**
   * The type of study being performed. ex. \"Yield Trial\", etc
   * @return studyTypes
  **/
  @ApiModelProperty(example = "[\"Yield Trial\",\"Disease Resistance Trial\"]", value = "The type of study being performed. ex. \"Yield Trial\", etc")
  
    public List<String> getStudyTypes() {
    return studyTypes;
  }

  public void setStudyTypes(List<String> studyTypes) {
    this.studyTypes = studyTypes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StudySearchRequest studySearchRequest = (StudySearchRequest) o;
    return Objects.equals(this.commonCropNames, studySearchRequest.commonCropNames) &&
        Objects.equals(this.programDbIds, studySearchRequest.programDbIds) &&
        Objects.equals(this.programNames, studySearchRequest.programNames) &&
        Objects.equals(this.trialDbIds, studySearchRequest.trialDbIds) &&
        Objects.equals(this.trialNames, studySearchRequest.trialNames) &&
        Objects.equals(this.studyDbIds, studySearchRequest.studyDbIds) &&
        Objects.equals(this.studyNames, studySearchRequest.studyNames) &&
        Objects.equals(this.locationDbIds, studySearchRequest.locationDbIds) &&
        Objects.equals(this.locationNames, studySearchRequest.locationNames) &&
        Objects.equals(this.germplasmDbIds, studySearchRequest.germplasmDbIds) &&
        Objects.equals(this.germplasmNames, studySearchRequest.germplasmNames) &&
        Objects.equals(this.observationVariableDbIds, studySearchRequest.observationVariableDbIds) &&
        Objects.equals(this.observationVariableNames, studySearchRequest.observationVariableNames) &&
        Objects.equals(this.externalReferenceIDs, studySearchRequest.externalReferenceIDs) &&
        Objects.equals(this.externalReferenceSources, studySearchRequest.externalReferenceSources) &&
        Objects.equals(this.active, studySearchRequest.active) &&
        Objects.equals(this.seasonDbIds, studySearchRequest.seasonDbIds) &&
        Objects.equals(this.sortBy, studySearchRequest.sortBy) &&
        Objects.equals(this.sortOrder, studySearchRequest.sortOrder) &&
        Objects.equals(this.studyCodes, studySearchRequest.studyCodes) &&
        Objects.equals(this.studyPUIs, studySearchRequest.studyPUIs) &&
        Objects.equals(this.studyTypes, studySearchRequest.studyTypes) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commonCropNames, programDbIds, programNames, trialDbIds, trialNames, studyDbIds, studyNames, locationDbIds, locationNames, germplasmDbIds, germplasmNames, observationVariableDbIds, observationVariableNames, externalReferenceIDs, externalReferenceSources, active, seasonDbIds, sortBy, sortOrder, studyCodes, studyPUIs, studyTypes, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StudySearchRequest {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    commonCropNames: ").append(toIndentedString(commonCropNames)).append("\n");
    sb.append("    programDbIds: ").append(toIndentedString(programDbIds)).append("\n");
    sb.append("    programNames: ").append(toIndentedString(programNames)).append("\n");
    sb.append("    trialDbIds: ").append(toIndentedString(trialDbIds)).append("\n");
    sb.append("    trialNames: ").append(toIndentedString(trialNames)).append("\n");
    sb.append("    studyDbIds: ").append(toIndentedString(studyDbIds)).append("\n");
    sb.append("    studyNames: ").append(toIndentedString(studyNames)).append("\n");
    sb.append("    locationDbIds: ").append(toIndentedString(locationDbIds)).append("\n");
    sb.append("    locationNames: ").append(toIndentedString(locationNames)).append("\n");
    sb.append("    germplasmDbIds: ").append(toIndentedString(germplasmDbIds)).append("\n");
    sb.append("    germplasmNames: ").append(toIndentedString(germplasmNames)).append("\n");
    sb.append("    observationVariableDbIds: ").append(toIndentedString(observationVariableDbIds)).append("\n");
    sb.append("    observationVariableNames: ").append(toIndentedString(observationVariableNames)).append("\n");
    sb.append("    externalReferenceIDs: ").append(toIndentedString(externalReferenceIDs)).append("\n");
    sb.append("    externalReferenceSources: ").append(toIndentedString(externalReferenceSources)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    seasonDbIds: ").append(toIndentedString(seasonDbIds)).append("\n");
    sb.append("    sortBy: ").append(toIndentedString(sortBy)).append("\n");
    sb.append("    sortOrder: ").append(toIndentedString(sortOrder)).append("\n");
    sb.append("    studyCodes: ").append(toIndentedString(studyCodes)).append("\n");
    sb.append("    studyPUIs: ").append(toIndentedString(studyPUIs)).append("\n");
    sb.append("    studyTypes: ").append(toIndentedString(studyTypes)).append("\n");
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
