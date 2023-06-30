package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

/**
 * StudySearchRequestDep
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class StudySearchRequestDep   {
  @JsonProperty("active")
  private Boolean active = null;

  @JsonProperty("germplasmDbIds")
  @Valid
  private List<String> germplasmDbIds = null;

  @JsonProperty("locationDbIds")
  @Valid
  private List<String> locationDbIds = null;

  @JsonProperty("observationVariableDbIds")
  @Valid
  private List<String> observationVariableDbIds = null;

  @JsonProperty("page")
  private Integer page = null;

  @JsonProperty("pageSize")
  private Integer pageSize = null;

  @JsonProperty("programDbIds")
  @Valid
  private List<String> programDbIds = null;

  @JsonProperty("programNames")
  @Valid
  private List<String> programNames = null;

  @JsonProperty("seasonDbId")
  @Valid
  private List<String> seasonDbId = null;

  /**
   * Name of one of the fields within the study object on which results can be sorted
   */
  public enum SortByEnum {
    STUDYDBID("studyDbId"),
    
    TRIALDBID("trialDbId"),
    
    PROGRAMDBID("programDbId"),
    
    LOCATIONDBID("locationDbId"),
    
    SEASONDBID("seasonDbId"),
    
    STUDYTYPE("studyType"),
    
    STUDYNAME("studyName"),
    
    STUDYLOCATION("studyLocation"),
    
    PROGRAMNAME("programName"),
    
    GERMPLASMDBID("germplasmDbId"),
    
    OBSERVATIONVARIABLEDBID("observationVariableDbId");

    private String value;

    SortByEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SortByEnum fromValue(String text) {
      for (SortByEnum b : SortByEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("sortBy")
  private SortByEnum sortBy = null;

  /**
   * Order results should be sorted. ex. \"ASC\" or \"DESC\"
   */
  public enum SortOrderEnum {
    ASC("asc"),
    
    DESC("desc");

    private String value;

    SortOrderEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SortOrderEnum fromValue(String text) {
      for (SortOrderEnum b : SortOrderEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("sortOrder")
  private SortOrderEnum sortOrder = null;

  @JsonProperty("studyDbIds")
  @Valid
  private List<String> studyDbIds = null;

  @JsonProperty("studyLocations")
  @Valid
  private List<String> studyLocations = null;

  @JsonProperty("studyNames")
  @Valid
  private List<String> studyNames = null;

  @JsonProperty("studyType")
  private String studyType = null;

  @JsonProperty("trialDbIds")
  @Valid
  private List<String> trialDbIds = null;

  public StudySearchRequestDep active(Boolean active) {
    this.active = active;
    return this;
  }

  /**
   * Is this study currently active
   * @return active
  **/
  @ApiModelProperty(value = "Is this study currently active")


  public Boolean isActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public StudySearchRequestDep germplasmDbIds(List<String> germplasmDbIds) {
    this.germplasmDbIds = germplasmDbIds;
    return this;
  }

  public StudySearchRequestDep addGermplasmDbIdsItem(String germplasmDbIdsItem) {
    if (this.germplasmDbIds == null) {
      this.germplasmDbIds = new ArrayList<String>();
    }
    this.germplasmDbIds.add(germplasmDbIdsItem);
    return this;
  }

  /**
   * List of IDs which uniquely identify germplasm
   * @return germplasmDbIds
  **/
  @ApiModelProperty(value = "List of IDs which uniquely identify germplasm")


  public List<String> getGermplasmDbIds() {
    return germplasmDbIds;
  }

  public void setGermplasmDbIds(List<String> germplasmDbIds) {
    this.germplasmDbIds = germplasmDbIds;
  }

  public StudySearchRequestDep locationDbIds(List<String> locationDbIds) {
    this.locationDbIds = locationDbIds;
    return this;
  }

  public StudySearchRequestDep addLocationDbIdsItem(String locationDbIdsItem) {
    if (this.locationDbIds == null) {
      this.locationDbIds = new ArrayList<String>();
    }
    this.locationDbIds.add(locationDbIdsItem);
    return this;
  }

  /**
   * List of location identifiers to filter search results
   * @return locationDbIds
  **/
  @ApiModelProperty(value = "List of location identifiers to filter search results")


  public List<String> getLocationDbIds() {
    return locationDbIds;
  }

  public void setLocationDbIds(List<String> locationDbIds) {
    this.locationDbIds = locationDbIds;
  }

  public StudySearchRequestDep observationVariableDbIds(List<String> observationVariableDbIds) {
    this.observationVariableDbIds = observationVariableDbIds;
    return this;
  }

  public StudySearchRequestDep addObservationVariableDbIdsItem(String observationVariableDbIdsItem) {
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
  @ApiModelProperty(value = "List of observation variable IDs to search for")


  public List<String> getObservationVariableDbIds() {
    return observationVariableDbIds;
  }

  public void setObservationVariableDbIds(List<String> observationVariableDbIds) {
    this.observationVariableDbIds = observationVariableDbIds;
  }

  public StudySearchRequestDep page(Integer page) {
    this.page = page;
    return this;
  }

  /**
   * Which page of the \"data\" array to return. The page indexing starts at 0 (page=0 will return the first page). Default is 0.
   * @return page
  **/
  @ApiModelProperty(value = "Which page of the \"data\" array to return. The page indexing starts at 0 (page=0 will return the first page). Default is 0.")


  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public StudySearchRequestDep pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

  /**
   * The maximum number of items to return per page of the \"data\" array. Default is 1000.
   * @return pageSize
  **/
  @ApiModelProperty(value = "The maximum number of items to return per page of the \"data\" array. Default is 1000.")


  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public StudySearchRequestDep programDbIds(List<String> programDbIds) {
    this.programDbIds = programDbIds;
    return this;
  }

  public StudySearchRequestDep addProgramDbIdsItem(String programDbIdsItem) {
    if (this.programDbIds == null) {
      this.programDbIds = new ArrayList<String>();
    }
    this.programDbIds.add(programDbIdsItem);
    return this;
  }

  /**
   * List of program identifiers to filter search results
   * @return programDbIds
  **/
  @ApiModelProperty(value = "List of program identifiers to filter search results")


  public List<String> getProgramDbIds() {
    return programDbIds;
  }

  public void setProgramDbIds(List<String> programDbIds) {
    this.programDbIds = programDbIds;
  }

  public StudySearchRequestDep programNames(List<String> programNames) {
    this.programNames = programNames;
    return this;
  }

  public StudySearchRequestDep addProgramNamesItem(String programNamesItem) {
    if (this.programNames == null) {
      this.programNames = new ArrayList<String>();
    }
    this.programNames.add(programNamesItem);
    return this;
  }

  /**
   * List of program names to filter search results
   * @return programNames
  **/
  @ApiModelProperty(value = "List of program names to filter search results")


  public List<String> getProgramNames() {
    return programNames;
  }

  public void setProgramNames(List<String> programNames) {
    this.programNames = programNames;
  }

  public StudySearchRequestDep seasonDbId(List<String> seasonDbId) {
    this.seasonDbId = seasonDbId;
    return this;
  }

  public StudySearchRequestDep addSeasonDbIdItem(String seasonDbIdItem) {
    if (this.seasonDbId == null) {
      this.seasonDbId = new ArrayList<String>();
    }
    this.seasonDbId.add(seasonDbIdItem);
    return this;
  }

  /**
   * The ID which uniquely identifies a season
   * @return seasonDbId
  **/
  @ApiModelProperty(value = "The ID which uniquely identifies a season")


  public List<String> getSeasonDbId() {
    return seasonDbId;
  }

  public void setSeasonDbId(List<String> seasonDbId) {
    this.seasonDbId = seasonDbId;
  }

  public StudySearchRequestDep sortBy(SortByEnum sortBy) {
    this.sortBy = sortBy;
    return this;
  }

  /**
   * Name of one of the fields within the study object on which results can be sorted
   * @return sortBy
  **/
  @ApiModelProperty(value = "Name of one of the fields within the study object on which results can be sorted")


  public SortByEnum getSortBy() {
    return sortBy;
  }

  public void setSortBy(SortByEnum sortBy) {
    this.sortBy = sortBy;
  }

  public StudySearchRequestDep sortOrder(SortOrderEnum sortOrder) {
    this.sortOrder = sortOrder;
    return this;
  }

  /**
   * Order results should be sorted. ex. \"ASC\" or \"DESC\"
   * @return sortOrder
  **/
  @ApiModelProperty(value = "Order results should be sorted. ex. \"ASC\" or \"DESC\"")


  public SortOrderEnum getSortOrder() {
    return sortOrder;
  }

  public void setSortOrder(SortOrderEnum sortOrder) {
    this.sortOrder = sortOrder;
  }

  public StudySearchRequestDep studyDbIds(List<String> studyDbIds) {
    this.studyDbIds = studyDbIds;
    return this;
  }

  public StudySearchRequestDep addStudyDbIdsItem(String studyDbIdsItem) {
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
  @ApiModelProperty(value = "List of study identifiers to search for")


  public List<String> getStudyDbIds() {
    return studyDbIds;
  }

  public void setStudyDbIds(List<String> studyDbIds) {
    this.studyDbIds = studyDbIds;
  }

  public StudySearchRequestDep studyLocations(List<String> studyLocations) {
    this.studyLocations = studyLocations;
    return this;
  }

  public StudySearchRequestDep addStudyLocationsItem(String studyLocationsItem) {
    if (this.studyLocations == null) {
      this.studyLocations = new ArrayList<String>();
    }
    this.studyLocations.add(studyLocationsItem);
    return this;
  }

  /**
   * List of location names to filter search results
   * @return studyLocations
  **/
  @ApiModelProperty(value = "List of location names to filter search results")


  public List<String> getStudyLocations() {
    return studyLocations;
  }

  public void setStudyLocations(List<String> studyLocations) {
    this.studyLocations = studyLocations;
  }

  public StudySearchRequestDep studyNames(List<String> studyNames) {
    this.studyNames = studyNames;
    return this;
  }

  public StudySearchRequestDep addStudyNamesItem(String studyNamesItem) {
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
  @ApiModelProperty(value = "List of study names to filter search results")


  public List<String> getStudyNames() {
    return studyNames;
  }

  public void setStudyNames(List<String> studyNames) {
    this.studyNames = studyNames;
  }

  public StudySearchRequestDep studyType(String studyType) {
    this.studyType = studyType;
    return this;
  }

  /**
   * The type of study being performed. ex. \"Yeald Trial\", etc
   * @return studyType
  **/
  @ApiModelProperty(value = "The type of study being performed. ex. \"Yeald Trial\", etc")


  public String getStudyType() {
    return studyType;
  }

  public void setStudyType(String studyType) {
    this.studyType = studyType;
  }

  public StudySearchRequestDep trialDbIds(List<String> trialDbIds) {
    this.trialDbIds = trialDbIds;
    return this;
  }

  public StudySearchRequestDep addTrialDbIdsItem(String trialDbIdsItem) {
    if (this.trialDbIds == null) {
      this.trialDbIds = new ArrayList<String>();
    }
    this.trialDbIds.add(trialDbIdsItem);
    return this;
  }

  /**
   * List of trial identifiers to filter search results
   * @return trialDbIds
  **/
  @ApiModelProperty(value = "List of trial identifiers to filter search results")


  public List<String> getTrialDbIds() {
    return trialDbIds;
  }

  public void setTrialDbIds(List<String> trialDbIds) {
    this.trialDbIds = trialDbIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StudySearchRequestDep studySearchRequestDep = (StudySearchRequestDep) o;
    return Objects.equals(this.active, studySearchRequestDep.active) &&
        Objects.equals(this.germplasmDbIds, studySearchRequestDep.germplasmDbIds) &&
        Objects.equals(this.locationDbIds, studySearchRequestDep.locationDbIds) &&
        Objects.equals(this.observationVariableDbIds, studySearchRequestDep.observationVariableDbIds) &&
        Objects.equals(this.page, studySearchRequestDep.page) &&
        Objects.equals(this.pageSize, studySearchRequestDep.pageSize) &&
        Objects.equals(this.programDbIds, studySearchRequestDep.programDbIds) &&
        Objects.equals(this.programNames, studySearchRequestDep.programNames) &&
        Objects.equals(this.seasonDbId, studySearchRequestDep.seasonDbId) &&
        Objects.equals(this.sortBy, studySearchRequestDep.sortBy) &&
        Objects.equals(this.sortOrder, studySearchRequestDep.sortOrder) &&
        Objects.equals(this.studyDbIds, studySearchRequestDep.studyDbIds) &&
        Objects.equals(this.studyLocations, studySearchRequestDep.studyLocations) &&
        Objects.equals(this.studyNames, studySearchRequestDep.studyNames) &&
        Objects.equals(this.studyType, studySearchRequestDep.studyType) &&
        Objects.equals(this.trialDbIds, studySearchRequestDep.trialDbIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(active, germplasmDbIds, locationDbIds, observationVariableDbIds, page, pageSize, programDbIds, programNames, seasonDbId, sortBy, sortOrder, studyDbIds, studyLocations, studyNames, studyType, trialDbIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StudySearchRequestDep {\n");
    
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    germplasmDbIds: ").append(toIndentedString(germplasmDbIds)).append("\n");
    sb.append("    locationDbIds: ").append(toIndentedString(locationDbIds)).append("\n");
    sb.append("    observationVariableDbIds: ").append(toIndentedString(observationVariableDbIds)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    programDbIds: ").append(toIndentedString(programDbIds)).append("\n");
    sb.append("    programNames: ").append(toIndentedString(programNames)).append("\n");
    sb.append("    seasonDbId: ").append(toIndentedString(seasonDbId)).append("\n");
    sb.append("    sortBy: ").append(toIndentedString(sortBy)).append("\n");
    sb.append("    sortOrder: ").append(toIndentedString(sortOrder)).append("\n");
    sb.append("    studyDbIds: ").append(toIndentedString(studyDbIds)).append("\n");
    sb.append("    studyLocations: ").append(toIndentedString(studyLocations)).append("\n");
    sb.append("    studyNames: ").append(toIndentedString(studyNames)).append("\n");
    sb.append("    studyType: ").append(toIndentedString(studyType)).append("\n");
    sb.append("    trialDbIds: ").append(toIndentedString(trialDbIds)).append("\n");
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

