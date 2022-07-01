package io.swagger.model.core;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.SearchRequest;
import java.util.ArrayList;
import java.util.List;

public class StudySearchRequest extends SearchRequest {
	@JsonProperty("commonCropNames")
	private List<String> commonCropNames = null;

	@JsonProperty("programDbIds")
	private List<String> programDbIds = null;

	@JsonProperty("programNames")
	private List<String> programNames = null;

	@JsonProperty("trialDbIds")
	private List<String> trialDbIds = null;

	@JsonProperty("trialNames")
	private List<String> trialNames = null;

	@JsonProperty("studyDbIds")
	private List<String> studyDbIds = null;

	@JsonProperty("studyNames")
	private List<String> studyNames = null;

	@JsonProperty("locationDbIds")
	private List<String> locationDbIds = null;

	@JsonProperty("locationNames")
	private List<String> locationNames = null;

	@JsonProperty("germplasmDbIds")
	private List<String> germplasmDbIds = null;

	@JsonProperty("germplasmNames")
	private List<String> germplasmNames = null;

	@JsonProperty("observationVariableDbIds")
	private List<String> observationVariableDbIds = null;

	@JsonProperty("observationVariableNames")
	private List<String> observationVariableNames = null;

	@JsonProperty("active")
	private Boolean active = null;

	@JsonProperty("seasonDbIds")
	private List<String> seasonDbIds = null;

	@JsonProperty("sortBy")
	private SortBy sortBy = null;

	@JsonProperty("sortOrder")
	private SortOrder sortOrder = null;

	@JsonProperty("studyCodes")
	private List<String> studyCodes = null;

	@JsonProperty("studyPUIs")
	private List<String> studyPUIs = null;

	@JsonProperty("studyTypes")
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

	public List<String> getObservationVariableNames() {
		return observationVariableNames;
	}

	public void setObservationVariableNames(List<String> observationVariableNames) {
		this.observationVariableNames = observationVariableNames;
	}

	public StudySearchRequest active(Boolean active) {
		this.active = active;
		return this;
	}

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
		return Objects.equals(this.commonCropNames, studySearchRequest.commonCropNames)
				&& Objects.equals(this.programDbIds, studySearchRequest.programDbIds)
				&& Objects.equals(this.programNames, studySearchRequest.programNames)
				&& Objects.equals(this.trialDbIds, studySearchRequest.trialDbIds)
				&& Objects.equals(this.trialNames, studySearchRequest.trialNames)
				&& Objects.equals(this.studyDbIds, studySearchRequest.studyDbIds)
				&& Objects.equals(this.studyNames, studySearchRequest.studyNames)
				&& Objects.equals(this.locationDbIds, studySearchRequest.locationDbIds)
				&& Objects.equals(this.locationNames, studySearchRequest.locationNames)
				&& Objects.equals(this.germplasmDbIds, studySearchRequest.germplasmDbIds)
				&& Objects.equals(this.germplasmNames, studySearchRequest.germplasmNames)
				&& Objects.equals(this.observationVariableDbIds, studySearchRequest.observationVariableDbIds)
				&& Objects.equals(this.observationVariableNames, studySearchRequest.observationVariableNames)
				&& Objects.equals(this.externalReferenceIds, studySearchRequest.externalReferenceIds)
				&& Objects.equals(this.externalReferenceSources, studySearchRequest.externalReferenceSources)
				&& Objects.equals(this.active, studySearchRequest.active)
				&& Objects.equals(this.seasonDbIds, studySearchRequest.seasonDbIds)
				&& Objects.equals(this.sortBy, studySearchRequest.sortBy)
				&& Objects.equals(this.sortOrder, studySearchRequest.sortOrder)
				&& Objects.equals(this.studyCodes, studySearchRequest.studyCodes)
				&& Objects.equals(this.studyPUIs, studySearchRequest.studyPUIs)
				&& Objects.equals(this.studyTypes, studySearchRequest.studyTypes) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(commonCropNames, programDbIds, programNames, trialDbIds, trialNames, studyDbIds, studyNames,
				locationDbIds, locationNames, germplasmDbIds, germplasmNames, observationVariableDbIds,
				observationVariableNames, externalReferenceIds, externalReferenceSources, active, seasonDbIds, sortBy,
				sortOrder, studyCodes, studyPUIs, studyTypes, super.hashCode());
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
		sb.append("    externalReferenceIDs: ").append(toIndentedString(externalReferenceIds)).append("\n");
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

	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	@Override
	public Integer getTotalParameterCount() {
		Integer count = 0;
		if (this.commonCropNames != null)
			count += this.commonCropNames.size();
		if (this.programDbIds != null)
			count += this.programDbIds.size();
		if (this.programNames != null)
			count += this.programNames.size();
		if (this.trialDbIds != null)
			count += this.trialDbIds.size();
		if (this.trialNames != null)
			count += this.trialNames.size();
		if (this.studyDbIds != null)
			count += this.studyDbIds.size();
		if (this.studyNames != null)
			count += this.studyNames.size();
		if (this.locationDbIds != null)
			count += this.locationDbIds.size();
		if (this.locationNames != null)
			count += this.locationNames.size();
		if (this.germplasmDbIds != null)
			count += this.germplasmDbIds.size();
		if (this.germplasmNames != null)
			count += this.germplasmNames.size();
		if (this.observationVariableDbIds != null)
			count += this.observationVariableDbIds.size();
		if (this.observationVariableNames != null)
			count += this.observationVariableNames.size();
		if (this.externalReferenceIds != null)
			count += this.externalReferenceIds.size();
		if (this.externalReferenceSources != null)
			count += this.externalReferenceSources.size();
		if (this.active != null)
			count += 1;
		if (this.seasonDbIds != null)
			count += this.seasonDbIds.size();
		if (this.sortBy != null)
			count += 1;
		if (this.sortOrder != null)
			count += 1;
		if (this.studyCodes != null)
			count += this.studyCodes.size();
		if (this.studyPUIs != null)
			count += this.studyPUIs.size();
		if (this.studyTypes != null)
			count += this.studyTypes.size();
		return count;
	}
}
