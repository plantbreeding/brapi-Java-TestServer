package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.SearchRequest;
import java.util.ArrayList;
import java.util.List;
import java.time.OffsetDateTime;

public class ObservationSearchRequest extends SearchRequest {
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

	@JsonProperty("germplasmDbIds")
	private List<String> germplasmDbIds = null;

	@JsonProperty("germplasmNames")
	private List<String> germplasmNames = null;

	@JsonProperty("locationDbIds")
	private List<String> locationDbIds = null;

	@JsonProperty("locationNames")
	private List<String> locationNames = null;

	@JsonProperty("observationVariableDbIds")
	private List<String> observationVariableDbIds = null;

	@JsonProperty("observationVariableNames")
	private List<String> observationVariableNames = null;

	@JsonProperty("observationDbIds")
	private List<String> observationDbIds = null;

	@JsonProperty("observationLevelRelationships")
	private List<ObservationUnitLevelRelationship> observationLevelRelationships = null;

	@JsonProperty("observationLevels")
	private List<ObservationUnitLevel> observationLevels = null;

	@JsonProperty("observationTimeStampRangeEnd")
	private OffsetDateTime observationTimeStampRangeEnd = null;

	@JsonProperty("observationTimeStampRangeStart")
	private OffsetDateTime observationTimeStampRangeStart = null;

	@JsonProperty("observationUnitDbIds")
	private List<String> observationUnitDbIds = null;

	@JsonProperty("seasonDbIds")
	private List<String> seasonDbIds = null;

	public List<String> getCommonCropNames() {
		return commonCropNames;
	}

	public void setCommonCropNames(List<String> commonCropNames) {
		this.commonCropNames = commonCropNames;
	}

	public ObservationSearchRequest addCommonCropNamesItem(String commonCropNamesItem) {
		if (this.commonCropNames == null) {
			this.commonCropNames = new ArrayList<String>();
		}
		this.commonCropNames.add(commonCropNamesItem);
		return this;
	}

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

	public List<String> getObservationVariableNames() {
		return observationVariableNames;
	}

	public void setObservationVariableNames(List<String> observationVariableNames) {
		this.observationVariableNames = observationVariableNames;
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

	public List<String> getObservationDbIds() {
		return observationDbIds;
	}

	public void setObservationDbIds(List<String> observationDbIds) {
		this.observationDbIds = observationDbIds;
	}

	public ObservationSearchRequest observationLevelRelationships(
			List<ObservationUnitLevelRelationship> observationLevelRelationships) {
		this.observationLevelRelationships = observationLevelRelationships;
		return this;
	}

	public ObservationSearchRequest addObservationLevelRelationshipsItem(
			ObservationUnitLevelRelationship observationLevelRelationshipsItem) {
		if (this.observationLevelRelationships == null) {
			this.observationLevelRelationships = new ArrayList<ObservationUnitLevelRelationship>();
		}
		this.observationLevelRelationships.add(observationLevelRelationshipsItem);
		return this;
	}

	public List<ObservationUnitLevelRelationship> getObservationLevelRelationships() {
		return observationLevelRelationships;
	}

	public void setObservationLevelRelationships(List<ObservationUnitLevelRelationship> observationLevelRelationships) {
		this.observationLevelRelationships = observationLevelRelationships;
	}

	public ObservationSearchRequest observationLevels(List<ObservationUnitLevel> observationLevels) {
		this.observationLevels = observationLevels;
		return this;
	}

	public ObservationSearchRequest addObservationLevelsItem(ObservationUnitLevel observationLevelsItem) {
		if (this.observationLevels == null) {
			this.observationLevels = new ArrayList<ObservationUnitLevel>();
		}
		this.observationLevels.add(observationLevelsItem);
		return this;
	}

	public List<ObservationUnitLevel> getObservationLevels() {
		return observationLevels;
	}

	public void setObservationLevels(List<ObservationUnitLevel> observationLevels) {
		this.observationLevels = observationLevels;
	}

	public ObservationSearchRequest observationTimeStampRangeEnd(OffsetDateTime observationTimeStampRangeEnd) {
		this.observationTimeStampRangeEnd = observationTimeStampRangeEnd;
		return this;
	}

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
		return Objects.equals(this.programDbIds, observationSearchRequest.programDbIds)
				&& Objects.equals(this.programNames, observationSearchRequest.programNames)
				&& Objects.equals(this.trialDbIds, observationSearchRequest.trialDbIds)
				&& Objects.equals(this.trialNames, observationSearchRequest.trialNames)
				&& Objects.equals(this.studyDbIds, observationSearchRequest.studyDbIds)
				&& Objects.equals(this.studyNames, observationSearchRequest.studyNames)
				&& Objects.equals(this.germplasmDbIds, observationSearchRequest.germplasmDbIds)
				&& Objects.equals(this.germplasmNames, observationSearchRequest.germplasmNames)
				&& Objects.equals(this.locationDbIds, observationSearchRequest.locationDbIds)
				&& Objects.equals(this.locationNames, observationSearchRequest.locationNames)
				&& Objects.equals(this.observationVariableDbIds, observationSearchRequest.observationVariableDbIds)
				&& Objects.equals(this.observationVariableNames, observationSearchRequest.observationVariableNames)
				&& Objects.equals(this.externalReferenceIds, observationSearchRequest.externalReferenceIds)
				&& Objects.equals(this.externalReferenceSources, observationSearchRequest.externalReferenceSources)
				&& Objects.equals(this.observationDbIds, observationSearchRequest.observationDbIds)
				&& Objects.equals(this.observationLevelRelationships,
						observationSearchRequest.observationLevelRelationships)
				&& Objects.equals(this.observationLevels, observationSearchRequest.observationLevels)
				&& Objects.equals(this.observationTimeStampRangeEnd,
						observationSearchRequest.observationTimeStampRangeEnd)
				&& Objects.equals(this.observationTimeStampRangeStart,
						observationSearchRequest.observationTimeStampRangeStart)
				&& Objects.equals(this.observationUnitDbIds, observationSearchRequest.observationUnitDbIds)
				&& Objects.equals(this.seasonDbIds, observationSearchRequest.seasonDbIds) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(programDbIds, programNames, trialDbIds, trialNames, studyDbIds, studyNames, germplasmDbIds,
				germplasmNames, locationDbIds, locationNames, observationVariableDbIds, observationVariableNames,
				externalReferenceIds, externalReferenceSources, observationDbIds, observationLevelRelationships,
				observationLevels, observationTimeStampRangeEnd, observationTimeStampRangeStart, observationUnitDbIds,
				seasonDbIds, super.hashCode());
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
		sb.append("    externalReferenceIds: ").append(toIndentedString(externalReferenceIds)).append("\n");
		sb.append("    externalReferenceSources: ").append(toIndentedString(externalReferenceSources)).append("\n");
		sb.append("    observationDbIds: ").append(toIndentedString(observationDbIds)).append("\n");
		sb.append("    observationLevelRelationships: ").append(toIndentedString(observationLevelRelationships))
				.append("\n");
		sb.append("    observationLevels: ").append(toIndentedString(observationLevels)).append("\n");
		sb.append("    observationTimeStampRangeEnd: ").append(toIndentedString(observationTimeStampRangeEnd))
				.append("\n");
		sb.append("    observationTimeStampRangeStart: ").append(toIndentedString(observationTimeStampRangeStart))
				.append("\n");
		sb.append("    observationUnitDbIds: ").append(toIndentedString(observationUnitDbIds)).append("\n");
		sb.append("    seasonDbIds: ").append(toIndentedString(seasonDbIds)).append("\n");
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
		if (this.germplasmDbIds != null)
			count += this.germplasmDbIds.size();
		if (this.germplasmNames != null)
			count += this.germplasmNames.size();
		if (this.locationDbIds != null)
			count += this.locationDbIds.size();
		if (this.locationNames != null)
			count += this.locationNames.size();
		if (this.observationVariableDbIds != null)
			count += this.observationVariableDbIds.size();
		if (this.observationVariableNames != null)
			count += this.observationVariableNames.size();
		if (this.externalReferenceIds != null)
			count += this.externalReferenceIds.size();
		if (this.externalReferenceSources != null)
			count += this.externalReferenceSources.size();
		if (this.observationDbIds != null)
			count += this.observationDbIds.size();
		if (this.observationLevelRelationships != null)
			count += this.observationLevelRelationships.size();
		if (this.observationLevels != null)
			count += this.observationLevels.size();
		if (this.observationTimeStampRangeEnd != null)
			count += 1;
		if (this.observationTimeStampRangeStart != null)
			count += 1;
		if (this.observationUnitDbIds != null)
			count += this.observationUnitDbIds.size();
		if (this.seasonDbIds != null)
			count += this.seasonDbIds.size();
		return count;
	}
}
