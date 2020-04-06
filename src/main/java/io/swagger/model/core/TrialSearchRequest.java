package io.swagger.model.core;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.SearchRequestParametersPaging;

import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * TrialSearchRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class TrialSearchRequest extends SearchRequestParametersPaging  {
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

  @JsonProperty("externalReferenceIDs")
  @Valid
  private List<String> externalReferenceIDs = null;

  @JsonProperty("externalReferenceSources")
  @Valid
  private List<String> externalReferenceSources = null;

  @JsonProperty("active")
  private Boolean active = null;

  @JsonProperty("contactDbIds")
  @Valid
  private List<String> contactDbIds = null;

  @JsonProperty("searchDateRangeEnd")
  private LocalDate searchDateRangeEnd = null;

  @JsonProperty("searchDateRangeStart")
  private LocalDate searchDateRangeStart = null;

  @JsonProperty("trialPUIs")
  @Valid
  private List<String> trialPUIs = null;

  @JsonProperty("sortBy")
  private SortBy sortBy = null;

  @JsonProperty("sortOrder")
  private SortOrder sortOrder = null;

  public SortBy getSortBy() {
	return sortBy;
}

public void setSortBy(SortBy sortBy) {
	this.sortBy = sortBy;
}

public SortOrder getSortOrder() {
	return sortOrder;
}

public void setSortOrder(SortOrder sortOrder) {
	this.sortOrder = sortOrder;
}

public TrialSearchRequest commonCropNames(List<String> commonCropNames) {
    this.commonCropNames = commonCropNames;
    return this;
  }

  public TrialSearchRequest addCommonCropNamesItem(String commonCropNamesItem) {
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

  public TrialSearchRequest programDbIds(List<String> programDbIds) {
    this.programDbIds = programDbIds;
    return this;
  }

  public TrialSearchRequest addProgramDbIdsItem(String programDbIdsItem) {
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

  public TrialSearchRequest programNames(List<String> programNames) {
    this.programNames = programNames;
    return this;
  }

  public TrialSearchRequest addProgramNamesItem(String programNamesItem) {
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

  public TrialSearchRequest trialDbIds(List<String> trialDbIds) {
    this.trialDbIds = trialDbIds;
    return this;
  }

  public TrialSearchRequest addTrialDbIdsItem(String trialDbIdsItem) {
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

  public TrialSearchRequest trialNames(List<String> trialNames) {
    this.trialNames = trialNames;
    return this;
  }

  public TrialSearchRequest addTrialNamesItem(String trialNamesItem) {
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

  public TrialSearchRequest studyDbIds(List<String> studyDbIds) {
    this.studyDbIds = studyDbIds;
    return this;
  }

  public TrialSearchRequest addStudyDbIdsItem(String studyDbIdsItem) {
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

  public TrialSearchRequest studyNames(List<String> studyNames) {
    this.studyNames = studyNames;
    return this;
  }

  public TrialSearchRequest addStudyNamesItem(String studyNamesItem) {
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

  public TrialSearchRequest locationDbIds(List<String> locationDbIds) {
    this.locationDbIds = locationDbIds;
    return this;
  }

  public TrialSearchRequest addLocationDbIdsItem(String locationDbIdsItem) {
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

  public TrialSearchRequest locationNames(List<String> locationNames) {
    this.locationNames = locationNames;
    return this;
  }

  public TrialSearchRequest addLocationNamesItem(String locationNamesItem) {
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

  public TrialSearchRequest externalReferenceIDs(List<String> externalReferenceIDs) {
    this.externalReferenceIDs = externalReferenceIDs;
    return this;
  }

  public TrialSearchRequest addExternalReferenceIDsItem(String externalReferenceIDsItem) {
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

  public TrialSearchRequest externalReferenceSources(List<String> externalReferenceSources) {
    this.externalReferenceSources = externalReferenceSources;
    return this;
  }

  public TrialSearchRequest addExternalReferenceSourcesItem(String externalReferenceSourcesItem) {
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

  public TrialSearchRequest active(Boolean active) {
    this.active = active;
    return this;
  }

  /**
   * Is this trail currently active
   * @return active
  **/
  @ApiModelProperty(example = "true", value = "Is this trail currently active")
  
    public Boolean isActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public TrialSearchRequest contactDbIds(List<String> contactDbIds) {
    this.contactDbIds = contactDbIds;
    return this;
  }

  public TrialSearchRequest addContactDbIdsItem(String contactDbIdsItem) {
    if (this.contactDbIds == null) {
      this.contactDbIds = new ArrayList<String>();
    }
    this.contactDbIds.add(contactDbIdsItem);
    return this;
  }

  /**
   * List of contact entities associated with this trial
   * @return contactDbIds
  **/
  @ApiModelProperty(example = "[\"e0f70c2a\",\"b82f0967\"]", value = "List of contact entities associated with this trial")
  
    public List<String> getContactDbIds() {
    return contactDbIds;
  }

  public void setContactDbIds(List<String> contactDbIds) {
    this.contactDbIds = contactDbIds;
  }

  public TrialSearchRequest searchDateRangeEnd(LocalDate searchDateRangeEnd) {
    this.searchDateRangeEnd = searchDateRangeEnd;
    return this;
  }

  /**
   * The end of the overlapping search date range. `searchDateRangeStart` must be before `searchDateRangeEnd`.  Return a Trial entity if any of the following cases are true  - `searchDateRangeStart` is before `trial.endDate` AND `searchDateRangeEnd` is null   - `searchDateRangeStart` is before `trial.endDate` AND `searchDateRangeEnd` is after `trial.startDate`  - `searchDateRangeEnd` is after `trial.startDate` AND `searchDateRangeStart` is null  - `searchDateRangeEnd` is after `trial.startDate` AND `searchDateRangeStart` is before `trial.endDate`
   * @return searchDateRangeEnd
  **/
  @ApiModelProperty(value = "The end of the overlapping search date range. `searchDateRangeStart` must be before `searchDateRangeEnd`.  Return a Trial entity if any of the following cases are true  - `searchDateRangeStart` is before `trial.endDate` AND `searchDateRangeEnd` is null   - `searchDateRangeStart` is before `trial.endDate` AND `searchDateRangeEnd` is after `trial.startDate`  - `searchDateRangeEnd` is after `trial.startDate` AND `searchDateRangeStart` is null  - `searchDateRangeEnd` is after `trial.startDate` AND `searchDateRangeStart` is before `trial.endDate`")
  
    @Valid
    public LocalDate getSearchDateRangeEnd() {
    return searchDateRangeEnd;
  }

  public void setSearchDateRangeEnd(LocalDate searchDateRangeEnd) {
    this.searchDateRangeEnd = searchDateRangeEnd;
  }

  public TrialSearchRequest searchDateRangeStart(LocalDate searchDateRangeStart) {
    this.searchDateRangeStart = searchDateRangeStart;
    return this;
  }

  /**
   * The start of the overlapping search date range. `searchDateRangeStart` must be before `searchDateRangeEnd`.  Return a Trial entity if any of the following cases are true  - `searchDateRangeStart` is before `trial.endDate` AND `searchDateRangeEnd` is null   - `searchDateRangeStart` is before `trial.endDate` AND `searchDateRangeEnd` is after `trial.startDate`  - `searchDateRangeEnd` is after `trial.startDate` AND `searchDateRangeStart` is null  - `searchDateRangeEnd` is after `trial.startDate` AND `searchDateRangeStart` is before `trial.endDate`
   * @return searchDateRangeStart
  **/
  @ApiModelProperty(value = "The start of the overlapping search date range. `searchDateRangeStart` must be before `searchDateRangeEnd`.  Return a Trial entity if any of the following cases are true  - `searchDateRangeStart` is before `trial.endDate` AND `searchDateRangeEnd` is null   - `searchDateRangeStart` is before `trial.endDate` AND `searchDateRangeEnd` is after `trial.startDate`  - `searchDateRangeEnd` is after `trial.startDate` AND `searchDateRangeStart` is null  - `searchDateRangeEnd` is after `trial.startDate` AND `searchDateRangeStart` is before `trial.endDate`")
  
    @Valid
    public LocalDate getSearchDateRangeStart() {
    return searchDateRangeStart;
  }

  public void setSearchDateRangeStart(LocalDate searchDateRangeStart) {
    this.searchDateRangeStart = searchDateRangeStart;
  }

  public TrialSearchRequest trialPUIs(List<String> trialPUIs) {
    this.trialPUIs = trialPUIs;
    return this;
  }

  public TrialSearchRequest addTrialPUIsItem(String trialPUIsItem) {
    if (this.trialPUIs == null) {
      this.trialPUIs = new ArrayList<String>();
    }
    this.trialPUIs.add(trialPUIsItem);
    return this;
  }

  /**
   * A permanent identifier for a trial. Could be DOI or other URI formatted identifier.
   * @return trialPUIs
  **/
  @ApiModelProperty(example = "[\"https://doi.org/01093190\",\"https://doi.org/11192409\"]", value = "A permanent identifier for a trial. Could be DOI or other URI formatted identifier.")
  
    public List<String> getTrialPUIs() {
    return trialPUIs;
  }

  public void setTrialPUIs(List<String> trialPUIs) {
    this.trialPUIs = trialPUIs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TrialSearchRequest trialSearchRequest = (TrialSearchRequest) o;
    return Objects.equals(this.commonCropNames, trialSearchRequest.commonCropNames) &&
        Objects.equals(this.programDbIds, trialSearchRequest.programDbIds) &&
        Objects.equals(this.programNames, trialSearchRequest.programNames) &&
        Objects.equals(this.trialDbIds, trialSearchRequest.trialDbIds) &&
        Objects.equals(this.trialNames, trialSearchRequest.trialNames) &&
        Objects.equals(this.studyDbIds, trialSearchRequest.studyDbIds) &&
        Objects.equals(this.studyNames, trialSearchRequest.studyNames) &&
        Objects.equals(this.locationDbIds, trialSearchRequest.locationDbIds) &&
        Objects.equals(this.locationNames, trialSearchRequest.locationNames) &&
        Objects.equals(this.externalReferenceIDs, trialSearchRequest.externalReferenceIDs) &&
        Objects.equals(this.externalReferenceSources, trialSearchRequest.externalReferenceSources) &&
        Objects.equals(this.active, trialSearchRequest.active) &&
        Objects.equals(this.contactDbIds, trialSearchRequest.contactDbIds) &&
        Objects.equals(this.searchDateRangeEnd, trialSearchRequest.searchDateRangeEnd) &&
        Objects.equals(this.searchDateRangeStart, trialSearchRequest.searchDateRangeStart) &&
        Objects.equals(this.trialPUIs, trialSearchRequest.trialPUIs) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commonCropNames, programDbIds, programNames, trialDbIds, trialNames, studyDbIds, studyNames, locationDbIds, locationNames, externalReferenceIDs, externalReferenceSources, active, contactDbIds, searchDateRangeEnd, searchDateRangeStart, trialPUIs, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TrialSearchRequest {\n");
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
    sb.append("    externalReferenceIDs: ").append(toIndentedString(externalReferenceIDs)).append("\n");
    sb.append("    externalReferenceSources: ").append(toIndentedString(externalReferenceSources)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    contactDbIds: ").append(toIndentedString(contactDbIds)).append("\n");
    sb.append("    searchDateRangeEnd: ").append(toIndentedString(searchDateRangeEnd)).append("\n");
    sb.append("    searchDateRangeStart: ").append(toIndentedString(searchDateRangeStart)).append("\n");
    sb.append("    trialPUIs: ").append(toIndentedString(trialPUIs)).append("\n");
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
