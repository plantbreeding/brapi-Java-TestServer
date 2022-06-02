package io.swagger.model.core;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.model.SearchRequest;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class TrialSearchRequest extends SearchRequest {
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

	@JsonProperty("active")
	private Boolean active = null;

	@JsonProperty("contactDbIds")
	private List<String> contactDbIds = null;

	@JsonProperty("searchDateRangeEnd")
	private LocalDate searchDateRangeEnd = null;

	@JsonProperty("searchDateRangeStart")
	private LocalDate searchDateRangeStart = null;

	@JsonProperty("trialPUIs")
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

	public List<String> getLocationNames() {
		return locationNames;
	}

	public void setLocationNames(List<String> locationNames) {
		this.locationNames = locationNames;
	}

	public TrialSearchRequest active(Boolean active) {
		this.active = active;
		return this;
	}

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
		return Objects.equals(this.commonCropNames, trialSearchRequest.commonCropNames)
				&& Objects.equals(this.programDbIds, trialSearchRequest.programDbIds)
				&& Objects.equals(this.programNames, trialSearchRequest.programNames)
				&& Objects.equals(this.trialDbIds, trialSearchRequest.trialDbIds)
				&& Objects.equals(this.trialNames, trialSearchRequest.trialNames)
				&& Objects.equals(this.studyDbIds, trialSearchRequest.studyDbIds)
				&& Objects.equals(this.studyNames, trialSearchRequest.studyNames)
				&& Objects.equals(this.locationDbIds, trialSearchRequest.locationDbIds)
				&& Objects.equals(this.locationNames, trialSearchRequest.locationNames)
				&& Objects.equals(this.externalReferenceIds, trialSearchRequest.externalReferenceIds)
				&& Objects.equals(this.externalReferenceSources, trialSearchRequest.externalReferenceSources)
				&& Objects.equals(this.active, trialSearchRequest.active)
				&& Objects.equals(this.contactDbIds, trialSearchRequest.contactDbIds)
				&& Objects.equals(this.searchDateRangeEnd, trialSearchRequest.searchDateRangeEnd)
				&& Objects.equals(this.searchDateRangeStart, trialSearchRequest.searchDateRangeStart)
				&& Objects.equals(this.trialPUIs, trialSearchRequest.trialPUIs) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(commonCropNames, programDbIds, programNames, trialDbIds, trialNames, studyDbIds, studyNames,
				locationDbIds, locationNames, externalReferenceIds, externalReferenceSources, active, contactDbIds,
				searchDateRangeEnd, searchDateRangeStart, trialPUIs, super.hashCode());
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
		sb.append("    externalReferenceIDs: ").append(toIndentedString(externalReferenceIds)).append("\n");
		sb.append("    externalReferenceSources: ").append(toIndentedString(externalReferenceSources)).append("\n");
		sb.append("    active: ").append(toIndentedString(active)).append("\n");
		sb.append("    contactDbIds: ").append(toIndentedString(contactDbIds)).append("\n");
		sb.append("    searchDateRangeEnd: ").append(toIndentedString(searchDateRangeEnd)).append("\n");
		sb.append("    searchDateRangeStart: ").append(toIndentedString(searchDateRangeStart)).append("\n");
		sb.append("    trialPUIs: ").append(toIndentedString(trialPUIs)).append("\n");
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
		if (this.externalReferenceIds != null)
			count += this.externalReferenceIds.size();
		if (this.externalReferenceSources != null)
			count += this.externalReferenceSources.size();
		if (this.active != null)
			count += 1;
		if (this.contactDbIds != null)
			count += this.contactDbIds.size();
		if (this.searchDateRangeEnd != null)
			count += 1;
		if (this.searchDateRangeStart != null)
			count += 1;
		if (this.trialPUIs != null)
			count += this.trialPUIs.size();
		return count;
	}
}
