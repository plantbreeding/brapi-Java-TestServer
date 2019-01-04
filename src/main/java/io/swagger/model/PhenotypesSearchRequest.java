package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * PhenotypesSearchRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class PhenotypesSearchRequest   {
  @JsonProperty("germplasmDbIds")
  @Valid
  private List<String> germplasmDbIds = null;

  @JsonProperty("locationDbIds")
  @Valid
  private List<String> locationDbIds = null;

  @JsonProperty("observationLevel")
  private String observationLevel = null;

  @JsonProperty("observationTimeStampRangeEnd")
  private OffsetDateTime observationTimeStampRangeEnd = null;

  @JsonProperty("observationTimeStampRangeStart")
  private OffsetDateTime observationTimeStampRangeStart = null;

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

  @JsonProperty("seasonDbIds")
  @Valid
  private List<String> seasonDbIds = null;

  @JsonProperty("studyDbIds")
  @Valid
  private List<String> studyDbIds = null;

  @JsonProperty("trialDbIds")
  @Valid
  private List<String> trialDbIds = null;

  public PhenotypesSearchRequest germplasmDbIds(List<String> germplasmDbIds) {
    this.germplasmDbIds = germplasmDbIds;
    return this;
  }

  public PhenotypesSearchRequest addGermplasmDbIdsItem(String germplasmDbIdsItem) {
    if (this.germplasmDbIds == null) {
      this.germplasmDbIds = new ArrayList<String>();
    }
    this.germplasmDbIds.add(germplasmDbIdsItem);
    return this;
  }

  /**
   * The name or synonym of external genebank accession identifiers
   * @return germplasmDbIds
  **/
  @ApiModelProperty(value = "The name or synonym of external genebank accession identifiers")


  public List<String> getGermplasmDbIds() {
    return germplasmDbIds;
  }

  public void setGermplasmDbIds(List<String> germplasmDbIds) {
    this.germplasmDbIds = germplasmDbIds;
  }

  public PhenotypesSearchRequest locationDbIds(List<String> locationDbIds) {
    this.locationDbIds = locationDbIds;
    return this;
  }

  public PhenotypesSearchRequest addLocationDbIdsItem(String locationDbIdsItem) {
    if (this.locationDbIds == null) {
      this.locationDbIds = new ArrayList<String>();
    }
    this.locationDbIds.add(locationDbIdsItem);
    return this;
  }

  /**
   * locations these traits were collected
   * @return locationDbIds
  **/
  @ApiModelProperty(value = "locations these traits were collected")


  public List<String> getLocationDbIds() {
    return locationDbIds;
  }

  public void setLocationDbIds(List<String> locationDbIds) {
    this.locationDbIds = locationDbIds;
  }

  public PhenotypesSearchRequest observationLevel(String observationLevel) {
    this.observationLevel = observationLevel;
    return this;
  }

  /**
   * The type of the observationUnit. Returns only the observation unit of the specified type; the parent levels ID can be accessed through observationUnit Structure.
   * @return observationLevel
  **/
  @ApiModelProperty(value = "The type of the observationUnit. Returns only the observation unit of the specified type; the parent levels ID can be accessed through observationUnit Structure.")


  public String getObservationLevel() {
    return observationLevel;
  }

  public void setObservationLevel(String observationLevel) {
    this.observationLevel = observationLevel;
  }

  public PhenotypesSearchRequest observationTimeStampRangeEnd(OffsetDateTime observationTimeStampRangeEnd) {
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

  public PhenotypesSearchRequest observationTimeStampRangeStart(OffsetDateTime observationTimeStampRangeStart) {
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

  public PhenotypesSearchRequest observationVariableDbIds(List<String> observationVariableDbIds) {
    this.observationVariableDbIds = observationVariableDbIds;
    return this;
  }

  public PhenotypesSearchRequest addObservationVariableDbIdsItem(String observationVariableDbIdsItem) {
    if (this.observationVariableDbIds == null) {
      this.observationVariableDbIds = new ArrayList<String>();
    }
    this.observationVariableDbIds.add(observationVariableDbIdsItem);
    return this;
  }

  /**
   * The IDs of traits, could be ontology ID, database ID or PUI
   * @return observationVariableDbIds
  **/
  @ApiModelProperty(value = "The IDs of traits, could be ontology ID, database ID or PUI")


  public List<String> getObservationVariableDbIds() {
    return observationVariableDbIds;
  }

  public void setObservationVariableDbIds(List<String> observationVariableDbIds) {
    this.observationVariableDbIds = observationVariableDbIds;
  }

  public PhenotypesSearchRequest page(Integer page) {
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

  public PhenotypesSearchRequest pageSize(Integer pageSize) {
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

  public PhenotypesSearchRequest programDbIds(List<String> programDbIds) {
    this.programDbIds = programDbIds;
    return this;
  }

  public PhenotypesSearchRequest addProgramDbIdsItem(String programDbIdsItem) {
    if (this.programDbIds == null) {
      this.programDbIds = new ArrayList<String>();
    }
    this.programDbIds.add(programDbIdsItem);
    return this;
  }

  /**
   * list of programs to search across
   * @return programDbIds
  **/
  @ApiModelProperty(value = "list of programs to search across")


  public List<String> getProgramDbIds() {
    return programDbIds;
  }

  public void setProgramDbIds(List<String> programDbIds) {
    this.programDbIds = programDbIds;
  }

  public PhenotypesSearchRequest seasonDbIds(List<String> seasonDbIds) {
    this.seasonDbIds = seasonDbIds;
    return this;
  }

  public PhenotypesSearchRequest addSeasonDbIdsItem(String seasonDbIdsItem) {
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
  @ApiModelProperty(value = "The year or Phenotyping campaign of a multi-annual study (trees, grape, ...)")


  public List<String> getSeasonDbIds() {
    return seasonDbIds;
  }

  public void setSeasonDbIds(List<String> seasonDbIds) {
    this.seasonDbIds = seasonDbIds;
  }

  public PhenotypesSearchRequest studyDbIds(List<String> studyDbIds) {
    this.studyDbIds = studyDbIds;
    return this;
  }

  public PhenotypesSearchRequest addStudyDbIdsItem(String studyDbIdsItem) {
    if (this.studyDbIds == null) {
      this.studyDbIds = new ArrayList<String>();
    }
    this.studyDbIds.add(studyDbIdsItem);
    return this;
  }

  /**
   * The database ID / PK of the studies search parameter
   * @return studyDbIds
  **/
  @ApiModelProperty(value = "The database ID / PK of the studies search parameter")


  public List<String> getStudyDbIds() {
    return studyDbIds;
  }

  public void setStudyDbIds(List<String> studyDbIds) {
    this.studyDbIds = studyDbIds;
  }

  public PhenotypesSearchRequest trialDbIds(List<String> trialDbIds) {
    this.trialDbIds = trialDbIds;
    return this;
  }

  public PhenotypesSearchRequest addTrialDbIdsItem(String trialDbIdsItem) {
    if (this.trialDbIds == null) {
      this.trialDbIds = new ArrayList<String>();
    }
    this.trialDbIds.add(trialDbIdsItem);
    return this;
  }

  /**
   * list of trials to search across
   * @return trialDbIds
  **/
  @ApiModelProperty(value = "list of trials to search across")


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
    PhenotypesSearchRequest phenotypesSearchRequest = (PhenotypesSearchRequest) o;
    return Objects.equals(this.germplasmDbIds, phenotypesSearchRequest.germplasmDbIds) &&
        Objects.equals(this.locationDbIds, phenotypesSearchRequest.locationDbIds) &&
        Objects.equals(this.observationLevel, phenotypesSearchRequest.observationLevel) &&
        Objects.equals(this.observationTimeStampRangeEnd, phenotypesSearchRequest.observationTimeStampRangeEnd) &&
        Objects.equals(this.observationTimeStampRangeStart, phenotypesSearchRequest.observationTimeStampRangeStart) &&
        Objects.equals(this.observationVariableDbIds, phenotypesSearchRequest.observationVariableDbIds) &&
        Objects.equals(this.page, phenotypesSearchRequest.page) &&
        Objects.equals(this.pageSize, phenotypesSearchRequest.pageSize) &&
        Objects.equals(this.programDbIds, phenotypesSearchRequest.programDbIds) &&
        Objects.equals(this.seasonDbIds, phenotypesSearchRequest.seasonDbIds) &&
        Objects.equals(this.studyDbIds, phenotypesSearchRequest.studyDbIds) &&
        Objects.equals(this.trialDbIds, phenotypesSearchRequest.trialDbIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(germplasmDbIds, locationDbIds, observationLevel, observationTimeStampRangeEnd, observationTimeStampRangeStart, observationVariableDbIds, page, pageSize, programDbIds, seasonDbIds, studyDbIds, trialDbIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PhenotypesSearchRequest {\n");
    
    sb.append("    germplasmDbIds: ").append(toIndentedString(germplasmDbIds)).append("\n");
    sb.append("    locationDbIds: ").append(toIndentedString(locationDbIds)).append("\n");
    sb.append("    observationLevel: ").append(toIndentedString(observationLevel)).append("\n");
    sb.append("    observationTimeStampRangeEnd: ").append(toIndentedString(observationTimeStampRangeEnd)).append("\n");
    sb.append("    observationTimeStampRangeStart: ").append(toIndentedString(observationTimeStampRangeStart)).append("\n");
    sb.append("    observationVariableDbIds: ").append(toIndentedString(observationVariableDbIds)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    programDbIds: ").append(toIndentedString(programDbIds)).append("\n");
    sb.append("    seasonDbIds: ").append(toIndentedString(seasonDbIds)).append("\n");
    sb.append("    studyDbIds: ").append(toIndentedString(studyDbIds)).append("\n");
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

