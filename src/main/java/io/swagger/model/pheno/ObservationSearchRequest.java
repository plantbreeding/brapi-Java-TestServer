package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.pheno.ObservationUnitLevelRelationship;
import io.swagger.model.common.SearchRequestParametersPaging;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * ObservationSearchRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
public class ObservationSearchRequest extends SearchRequestParametersPaging  {
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

  @JsonProperty("germplasmDbIds")
  @Valid
  private List<String> germplasmDbIds = null;

  @JsonProperty("germplasmNames")
  @Valid
  private List<String> germplasmNames = null;

  @JsonProperty("locationDbIds")
  @Valid
  private List<String> locationDbIds = null;

  @JsonProperty("locationNames")
  @Valid
  private List<String> locationNames = null;

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

  @JsonProperty("observationDbIds")
  @Valid
  private List<String> observationDbIds = null;

  @JsonProperty("observationLevelRelationships")
  @Valid
  private List<ObservationUnitLevelRelationship> observationLevelRelationships = null;

  @JsonProperty("observationLevels")
  @Valid
  private List<ObservationUnitLevelRelationship> observationLevels = null;

  @JsonProperty("observationTimeStampRangeEnd")
  private OffsetDateTime observationTimeStampRangeEnd = null;

  @JsonProperty("observationTimeStampRangeStart")
  private OffsetDateTime observationTimeStampRangeStart = null;

  @JsonProperty("observationUnitDbIds")
  @Valid
  private List<String> observationUnitDbIds = null;

  @JsonProperty("seasonDbIds")
  @Valid
  private List<String> seasonDbIds = null;

  public ObservationSearchRequest programDbIds(List<String> programDbIds) {
    this.programDbIds = programDbIds;
    return this;
  }

  public ObservationSearchRequest addProgramDbIdsItem(String programDbIdsItem) {
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

  public ObservationSearchRequest programNames(List<String> programNames) {
    this.programNames = programNames;
    return this;
  }

  public ObservationSearchRequest addProgramNamesItem(String programNamesItem) {
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

  public ObservationSearchRequest trialDbIds(List<String> trialDbIds) {
    this.trialDbIds = trialDbIds;
    return this;
  }

  public ObservationSearchRequest addTrialDbIdsItem(String trialDbIdsItem) {
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

  public ObservationSearchRequest trialNames(List<String> trialNames) {
    this.trialNames = trialNames;
    return this;
  }

  public ObservationSearchRequest addTrialNamesItem(String trialNamesItem) {
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

  public ObservationSearchRequest studyDbIds(List<String> studyDbIds) {
    this.studyDbIds = studyDbIds;
    return this;
  }

  public ObservationSearchRequest addStudyDbIdsItem(String studyDbIdsItem) {
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

  public ObservationSearchRequest studyNames(List<String> studyNames) {
    this.studyNames = studyNames;
    return this;
  }

  public ObservationSearchRequest addStudyNamesItem(String studyNamesItem) {
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

  public ObservationSearchRequest germplasmDbIds(List<String> germplasmDbIds) {
    this.germplasmDbIds = germplasmDbIds;
    return this;
  }

  public ObservationSearchRequest addGermplasmDbIdsItem(String germplasmDbIdsItem) {
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

  public ObservationSearchRequest germplasmNames(List<String> germplasmNames) {
    this.germplasmNames = germplasmNames;
    return this;
  }

  public ObservationSearchRequest addGermplasmNamesItem(String germplasmNamesItem) {
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

  public ObservationSearchRequest locationDbIds(List<String> locationDbIds) {
    this.locationDbIds = locationDbIds;
    return this;
  }

  public ObservationSearchRequest addLocationDbIdsItem(String locationDbIdsItem) {
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

  public ObservationSearchRequest locationNames(List<String> locationNames) {
    this.locationNames = locationNames;
    return this;
  }

  public ObservationSearchRequest addLocationNamesItem(String locationNamesItem) {
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

  public ObservationSearchRequest observationVariableDbIds(List<String> observationVariableDbIds) {
    this.observationVariableDbIds = observationVariableDbIds;
    return this;
  }

  public ObservationSearchRequest addObservationVariableDbIdsItem(String observationVariableDbIdsItem) {
    if (this.observationVariableDbIds == null) {
      this.observationVariableDbIds = new ArrayList<String>();
    }
    this.observationVariableDbIds.add(observationVariableDbIdsItem);
    return this;
  }

  /**
   * The DbIds of Variables to search for
   * @return observationVariableDbIds
  **/
  @ApiModelProperty(example = "[\"a646187d\",\"6d23513b\"]", value = "The DbIds of Variables to search for")
  
    public List<String> getObservationVariableDbIds() {
    return observationVariableDbIds;
  }

  public void setObservationVariableDbIds(List<String> observationVariableDbIds) {
    this.observationVariableDbIds = observationVariableDbIds;
  }

  public ObservationSearchRequest observationVariableNames(List<String> observationVariableNames) {
    this.observationVariableNames = observationVariableNames;
    return this;
  }

  public ObservationSearchRequest addObservationVariableNamesItem(String observationVariableNamesItem) {
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

  public ObservationSearchRequest externalReferenceIDs(List<String> externalReferenceIDs) {
    this.externalReferenceIDs = externalReferenceIDs;
    return this;
  }

  public ObservationSearchRequest addExternalReferenceIDsItem(String externalReferenceIDsItem) {
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

  public ObservationSearchRequest externalReferenceSources(List<String> externalReferenceSources) {
    this.externalReferenceSources = externalReferenceSources;
    return this;
  }

  public ObservationSearchRequest addExternalReferenceSourcesItem(String externalReferenceSourcesItem) {
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

  public ObservationSearchRequest observationDbIds(List<String> observationDbIds) {
    this.observationDbIds = observationDbIds;
    return this;
  }

  public ObservationSearchRequest addObservationDbIdsItem(String observationDbIdsItem) {
    if (this.observationDbIds == null) {
      this.observationDbIds = new ArrayList<String>();
    }
    this.observationDbIds.add(observationDbIdsItem);
    return this;
  }

  /**
   * The unique id of an Observation
   * @return observationDbIds
  **/
  @ApiModelProperty(example = "[\"6a4a59d8\",\"3ff067e0\"]", value = "The unique id of an Observation")
  
    public List<String> getObservationDbIds() {
    return observationDbIds;
  }

  public void setObservationDbIds(List<String> observationDbIds) {
    this.observationDbIds = observationDbIds;
  }

  public ObservationSearchRequest observationLevelRelationships(List<ObservationUnitLevelRelationship> observationLevelRelationships) {
    this.observationLevelRelationships = observationLevelRelationships;
    return this;
  }

  public ObservationSearchRequest addObservationLevelRelationshipsItem(ObservationUnitLevelRelationship observationLevelRelationshipsItem) {
    if (this.observationLevelRelationships == null) {
      this.observationLevelRelationships = new ArrayList<ObservationUnitLevelRelationship>();
    }
    this.observationLevelRelationships.add(observationLevelRelationshipsItem);
    return this;
  }

  /**
   * Searches for values in ObservationUnit->observationUnitPosition->observationLevelRelationships
   * @return observationLevelRelationships
  **/
  @ApiModelProperty(example = "[{\"levelCode\":\"Field_1\",\"levelName\":\"field\"}]", value = "Searches for values in ObservationUnit->observationUnitPosition->observationLevelRelationships")
      @Valid
    public List<ObservationUnitLevelRelationship> getObservationLevelRelationships() {
    return observationLevelRelationships;
  }

  public void setObservationLevelRelationships(List<ObservationUnitLevelRelationship> observationLevelRelationships) {
    this.observationLevelRelationships = observationLevelRelationships;
  }

  public ObservationSearchRequest observationLevels(List<ObservationUnitLevelRelationship> observationLevels) {
    this.observationLevels = observationLevels;
    return this;
  }

  public ObservationSearchRequest addObservationLevelsItem(ObservationUnitLevelRelationship observationLevelsItem) {
    if (this.observationLevels == null) {
      this.observationLevels = new ArrayList<ObservationUnitLevelRelationship>();
    }
    this.observationLevels.add(observationLevelsItem);
    return this;
  }

  /**
   * Searches for values in ObservationUnit->observationUnitPosition->observationLevel
   * @return observationLevels
  **/
  @ApiModelProperty(example = "[{\"levelCode\":\"Plot_123\",\"levelName\":\"plot\"},{\"levelCode\":\"Plot_456\",\"levelName\":\"plot\"},{\"levelCode\":\"Plot_789\",\"levelName\":\"plot\"}]", value = "Searches for values in ObservationUnit->observationUnitPosition->observationLevel")
      @Valid
    public List<ObservationUnitLevelRelationship> getObservationLevels() {
    return observationLevels;
  }

  public void setObservationLevels(List<ObservationUnitLevelRelationship> observationLevels) {
    this.observationLevels = observationLevels;
  }

  public ObservationSearchRequest observationTimeStampRangeEnd(OffsetDateTime observationTimeStampRangeEnd) {
    this.observationTimeStampRangeEnd = observationTimeStampRangeEnd;
    return this;
  }

  /**
   * Timestamp range end
   * @return observationTimeStampRangeEnd
  **/
  @ApiModelProperty(value = "Timestamp range end")
  
    @Valid
    public OffsetDateTime getObservationTimeStampRangeEnd() {
    return observationTimeStampRangeEnd;
  }

  public void setObservationTimeStampRangeEnd(OffsetDateTime observationTimeStampRangeEnd) {
    this.observationTimeStampRangeEnd = observationTimeStampRangeEnd;
  }

  public ObservationSearchRequest observationTimeStampRangeStart(OffsetDateTime observationTimeStampRangeStart) {
    this.observationTimeStampRangeStart = observationTimeStampRangeStart;
    return this;
  }

  /**
   * Timestamp range start
   * @return observationTimeStampRangeStart
  **/
  @ApiModelProperty(value = "Timestamp range start")
  
    @Valid
    public OffsetDateTime getObservationTimeStampRangeStart() {
    return observationTimeStampRangeStart;
  }

  public void setObservationTimeStampRangeStart(OffsetDateTime observationTimeStampRangeStart) {
    this.observationTimeStampRangeStart = observationTimeStampRangeStart;
  }

  public ObservationSearchRequest observationUnitDbIds(List<String> observationUnitDbIds) {
    this.observationUnitDbIds = observationUnitDbIds;
    return this;
  }

  public ObservationSearchRequest addObservationUnitDbIdsItem(String observationUnitDbIdsItem) {
    if (this.observationUnitDbIds == null) {
      this.observationUnitDbIds = new ArrayList<String>();
    }
    this.observationUnitDbIds.add(observationUnitDbIdsItem);
    return this;
  }

  /**
   * The unique id of an Observation Unit
   * @return observationUnitDbIds
  **/
  @ApiModelProperty(example = "[\"76f559b5\",\"066bc5d3\"]", value = "The unique id of an Observation Unit")
  
    public List<String> getObservationUnitDbIds() {
    return observationUnitDbIds;
  }

  public void setObservationUnitDbIds(List<String> observationUnitDbIds) {
    this.observationUnitDbIds = observationUnitDbIds;
  }

  public ObservationSearchRequest seasonDbIds(List<String> seasonDbIds) {
    this.seasonDbIds = seasonDbIds;
    return this;
  }

  public ObservationSearchRequest addSeasonDbIdsItem(String seasonDbIdsItem) {
    if (this.seasonDbIds == null) {
      this.seasonDbIds = new ArrayList<String>();
    }
    this.seasonDbIds.add(seasonDbIdsItem);
    return this;
  }

  /**
   * The year or Phenotyping campaign of a multi-annual study (trees, grape, ...)
   * @return seasonDbIds
  **/
  @ApiModelProperty(example = "[\"Spring 2018\",\"Season A\"]", value = "The year or Phenotyping campaign of a multi-annual study (trees, grape, ...)")
  
    public List<String> getSeasonDbIds() {
    return seasonDbIds;
  }

  public void setSeasonDbIds(List<String> seasonDbIds) {
    this.seasonDbIds = seasonDbIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObservationSearchRequest observationSearchRequest = (ObservationSearchRequest) o;
    return Objects.equals(this.programDbIds, observationSearchRequest.programDbIds) &&
        Objects.equals(this.programNames, observationSearchRequest.programNames) &&
        Objects.equals(this.trialDbIds, observationSearchRequest.trialDbIds) &&
        Objects.equals(this.trialNames, observationSearchRequest.trialNames) &&
        Objects.equals(this.studyDbIds, observationSearchRequest.studyDbIds) &&
        Objects.equals(this.studyNames, observationSearchRequest.studyNames) &&
        Objects.equals(this.germplasmDbIds, observationSearchRequest.germplasmDbIds) &&
        Objects.equals(this.germplasmNames, observationSearchRequest.germplasmNames) &&
        Objects.equals(this.locationDbIds, observationSearchRequest.locationDbIds) &&
        Objects.equals(this.locationNames, observationSearchRequest.locationNames) &&
        Objects.equals(this.observationVariableDbIds, observationSearchRequest.observationVariableDbIds) &&
        Objects.equals(this.observationVariableNames, observationSearchRequest.observationVariableNames) &&
        Objects.equals(this.externalReferenceIDs, observationSearchRequest.externalReferenceIDs) &&
        Objects.equals(this.externalReferenceSources, observationSearchRequest.externalReferenceSources) &&
        Objects.equals(this.observationDbIds, observationSearchRequest.observationDbIds) &&
        Objects.equals(this.observationLevelRelationships, observationSearchRequest.observationLevelRelationships) &&
        Objects.equals(this.observationLevels, observationSearchRequest.observationLevels) &&
        Objects.equals(this.observationTimeStampRangeEnd, observationSearchRequest.observationTimeStampRangeEnd) &&
        Objects.equals(this.observationTimeStampRangeStart, observationSearchRequest.observationTimeStampRangeStart) &&
        Objects.equals(this.observationUnitDbIds, observationSearchRequest.observationUnitDbIds) &&
        Objects.equals(this.seasonDbIds, observationSearchRequest.seasonDbIds) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(programDbIds, programNames, trialDbIds, trialNames, studyDbIds, studyNames, germplasmDbIds, germplasmNames, locationDbIds, locationNames, observationVariableDbIds, observationVariableNames, externalReferenceIDs, externalReferenceSources, observationDbIds, observationLevelRelationships, observationLevels, observationTimeStampRangeEnd, observationTimeStampRangeStart, observationUnitDbIds, seasonDbIds, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObservationSearchRequest {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    programDbIds: ").append(toIndentedString(programDbIds)).append("\n");
    sb.append("    programNames: ").append(toIndentedString(programNames)).append("\n");
    sb.append("    trialDbIds: ").append(toIndentedString(trialDbIds)).append("\n");
    sb.append("    trialNames: ").append(toIndentedString(trialNames)).append("\n");
    sb.append("    studyDbIds: ").append(toIndentedString(studyDbIds)).append("\n");
    sb.append("    studyNames: ").append(toIndentedString(studyNames)).append("\n");
    sb.append("    germplasmDbIds: ").append(toIndentedString(germplasmDbIds)).append("\n");
    sb.append("    germplasmNames: ").append(toIndentedString(germplasmNames)).append("\n");
    sb.append("    locationDbIds: ").append(toIndentedString(locationDbIds)).append("\n");
    sb.append("    locationNames: ").append(toIndentedString(locationNames)).append("\n");
    sb.append("    observationVariableDbIds: ").append(toIndentedString(observationVariableDbIds)).append("\n");
    sb.append("    observationVariableNames: ").append(toIndentedString(observationVariableNames)).append("\n");
    sb.append("    externalReferenceIDs: ").append(toIndentedString(externalReferenceIDs)).append("\n");
    sb.append("    externalReferenceSources: ").append(toIndentedString(externalReferenceSources)).append("\n");
    sb.append("    observationDbIds: ").append(toIndentedString(observationDbIds)).append("\n");
    sb.append("    observationLevelRelationships: ").append(toIndentedString(observationLevelRelationships)).append("\n");
    sb.append("    observationLevels: ").append(toIndentedString(observationLevels)).append("\n");
    sb.append("    observationTimeStampRangeEnd: ").append(toIndentedString(observationTimeStampRangeEnd)).append("\n");
    sb.append("    observationTimeStampRangeStart: ").append(toIndentedString(observationTimeStampRangeStart)).append("\n");
    sb.append("    observationUnitDbIds: ").append(toIndentedString(observationUnitDbIds)).append("\n");
    sb.append("    seasonDbIds: ").append(toIndentedString(seasonDbIds)).append("\n");
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
