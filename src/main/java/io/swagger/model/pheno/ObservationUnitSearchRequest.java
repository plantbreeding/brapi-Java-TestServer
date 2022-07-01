package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.SearchRequest;
import java.util.ArrayList;
import java.util.List;

public class ObservationUnitSearchRequest extends SearchRequest {
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

	@JsonProperty("seasonDbIds")
	private List<String> seasonDbIds = null;

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

	@JsonProperty("observationVariablePUIs")
	private List<String> observationVariablePUIs = null;

	@JsonProperty("includeObservations")
	private Boolean includeObservations = null;

	@JsonProperty("observationLevelRelationships")
	private List<ObservationUnitLevelRelationship> observationLevelRelationships = null;

	@JsonProperty("observationLevels")
	private List<ObservationUnitLevel> observationLevels = null;

	@JsonProperty("observationUnitDbIds")
	private List<String> observationUnitDbIds = null;

	@JsonProperty("observationUnitNames")
	private List<String> observationUnitNames = null;

	public ObservationUnitSearchRequest commonCropNames(List<String> commonCropNames) {
		this.commonCropNames = commonCropNames;
		return this;
	}

	public ObservationUnitSearchRequest addCommonCropNamesItem(String commonCropNamesItem) {
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

	public ObservationUnitSearchRequest seasonDbIds(List<String> seasonDbIds) {
		this.seasonDbIds = seasonDbIds;
		return this;
	}

	public ObservationUnitSearchRequest addSeasonDbIdsItem(String seasonDbIdsItem) {
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

	public ObservationUnitSearchRequest programDbIds(List<String> programDbIds) {
		this.programDbIds = programDbIds;
		return this;
	}

	public ObservationUnitSearchRequest addProgramDbIdsItem(String programDbIdsItem) {
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

	public ObservationUnitSearchRequest programNames(List<String> programNames) {
		this.programNames = programNames;
		return this;
	}

	public ObservationUnitSearchRequest addProgramNamesItem(String programNamesItem) {
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

	public ObservationUnitSearchRequest trialDbIds(List<String> trialDbIds) {
		this.trialDbIds = trialDbIds;
		return this;
	}

	public ObservationUnitSearchRequest addTrialDbIdsItem(String trialDbIdsItem) {
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

	public ObservationUnitSearchRequest trialNames(List<String> trialNames) {
		this.trialNames = trialNames;
		return this;
	}

	public ObservationUnitSearchRequest addTrialNamesItem(String trialNamesItem) {
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

	public ObservationUnitSearchRequest studyDbIds(List<String> studyDbIds) {
		this.studyDbIds = studyDbIds;
		return this;
	}

	public ObservationUnitSearchRequest addStudyDbIdsItem(String studyDbIdsItem) {
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

	public ObservationUnitSearchRequest studyNames(List<String> studyNames) {
		this.studyNames = studyNames;
		return this;
	}

	public ObservationUnitSearchRequest addStudyNamesItem(String studyNamesItem) {
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

	public ObservationUnitSearchRequest locationDbIds(List<String> locationDbIds) {
		this.locationDbIds = locationDbIds;
		return this;
	}

	public ObservationUnitSearchRequest addLocationDbIdsItem(String locationDbIdsItem) {
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

	public ObservationUnitSearchRequest locationNames(List<String> locationNames) {
		this.locationNames = locationNames;
		return this;
	}

	public ObservationUnitSearchRequest addLocationNamesItem(String locationNamesItem) {
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

	public ObservationUnitSearchRequest germplasmDbIds(List<String> germplasmDbIds) {
		this.germplasmDbIds = germplasmDbIds;
		return this;
	}

	public ObservationUnitSearchRequest addGermplasmDbIdsItem(String germplasmDbIdsItem) {
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

	public ObservationUnitSearchRequest germplasmNames(List<String> germplasmNames) {
		this.germplasmNames = germplasmNames;
		return this;
	}

	public ObservationUnitSearchRequest addGermplasmNamesItem(String germplasmNamesItem) {
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

	public ObservationUnitSearchRequest observationVariableDbIds(List<String> observationVariableDbIds) {
		this.observationVariableDbIds = observationVariableDbIds;
		return this;
	}

	public ObservationUnitSearchRequest addObservationVariableDbIdsItem(String observationVariableDbIdsItem) {
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

	public ObservationUnitSearchRequest observationVariableNames(List<String> observationVariableNames) {
		this.observationVariableNames = observationVariableNames;
		return this;
	}

	public ObservationUnitSearchRequest addObservationVariableNamesItem(String observationVariableNamesItem) {
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

	public ObservationUnitSearchRequest observationVariablePUIs(List<String> observationVariablePUIs) {
		this.observationVariablePUIs = observationVariablePUIs;
		return this;
	}

	public ObservationUnitSearchRequest addObservationVariablePUIsItem(String observationVariablePUIsItem) {
		if (this.observationVariablePUIs == null) {
			this.observationVariablePUIs = new ArrayList<String>();
		}
		this.observationVariablePUIs.add(observationVariablePUIsItem);
		return this;
	}

	public List<String> getObservationVariablePUIs() {
		return observationVariablePUIs;
	}

	public void setObservationVariablePUIs(List<String> observationVariablePUIs) {
		this.observationVariablePUIs = observationVariablePUIs;
	}

	public ObservationUnitSearchRequest includeObservations(Boolean includeObservations) {
		this.includeObservations = includeObservations;
		return this;
	}

	public Boolean isIncludeObservations() {
		return includeObservations;
	}

	public void setIncludeObservations(Boolean includeObservations) {
		this.includeObservations = includeObservations;
	}

	public ObservationUnitSearchRequest observationLevelRelationships(
			List<ObservationUnitLevelRelationship> observationLevelRelationships) {
		this.observationLevelRelationships = observationLevelRelationships;
		return this;
	}

	public ObservationUnitSearchRequest addObservationLevelRelationshipsItem(
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

	public ObservationUnitSearchRequest observationLevels(List<ObservationUnitLevel> observationLevels) {
		this.observationLevels = observationLevels;
		return this;
	}

	public ObservationUnitSearchRequest addObservationLevelsItem(
			ObservationUnitLevel observationLevelsItem) {
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

	public ObservationUnitSearchRequest observationUnitDbIds(List<String> observationUnitDbIds) {
		this.observationUnitDbIds = observationUnitDbIds;
		return this;
	}

	public ObservationUnitSearchRequest addObservationUnitDbIdsItem(String observationUnitDbIdsItem) {
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

	public ObservationUnitSearchRequest observationUnitNames(List<String> observationUnitNames) {
		this.observationUnitNames = observationUnitNames;
		return this;
	}

	public ObservationUnitSearchRequest addObservationUnitNamesItem(String observationUnitNamesItem) {
		if (this.observationUnitNames == null) {
			this.observationUnitNames = new ArrayList<String>();
		}
		this.observationUnitNames.add(observationUnitNamesItem);
		return this;
	}

	public List<String> getObservationUnitNames() {
		return observationUnitNames;
	}

	public void setObservationUnitNames(List<String> observationUnitNames) {
		this.observationUnitNames = observationUnitNames;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ObservationUnitSearchRequest observationUnitSearchRequest = (ObservationUnitSearchRequest) o;
		return Objects.equals(this.commonCropNames, observationUnitSearchRequest.commonCropNames)
				&& Objects.equals(this.seasonDbIds, observationUnitSearchRequest.seasonDbIds)
				&& Objects.equals(this.externalReferenceIds, observationUnitSearchRequest.externalReferenceIds)
				&& Objects.equals(this.externalReferenceSources, observationUnitSearchRequest.externalReferenceSources)
				&& Objects.equals(this.germplasmDbIds, observationUnitSearchRequest.germplasmDbIds)
				&& Objects.equals(this.germplasmNames, observationUnitSearchRequest.germplasmNames)
				&& Objects.equals(this.includeObservations, observationUnitSearchRequest.includeObservations)
				&& Objects.equals(this.locationDbIds, observationUnitSearchRequest.locationDbIds)
				&& Objects.equals(this.locationNames, observationUnitSearchRequest.locationNames)
				&& Objects.equals(this.observationLevelRelationships,
						observationUnitSearchRequest.observationLevelRelationships)
				&& Objects.equals(this.observationLevels, observationUnitSearchRequest.observationLevels)
				&& Objects.equals(this.observationUnitDbIds, observationUnitSearchRequest.observationUnitDbIds)
				&& Objects.equals(this.observationUnitNames, observationUnitSearchRequest.observationUnitNames)
				&& Objects.equals(this.observationVariableDbIds, observationUnitSearchRequest.observationVariableDbIds)
				&& Objects.equals(this.observationVariableNames, observationUnitSearchRequest.observationVariableNames)
				&& Objects.equals(this.observationVariablePUIs, observationUnitSearchRequest.observationVariablePUIs)
				&& Objects.equals(this.page, observationUnitSearchRequest.page)
				&& Objects.equals(this.pageSize, observationUnitSearchRequest.pageSize)
				&& Objects.equals(this.programDbIds, observationUnitSearchRequest.programDbIds)
				&& Objects.equals(this.programNames, observationUnitSearchRequest.programNames)
				&& Objects.equals(this.studyDbIds, observationUnitSearchRequest.studyDbIds)
				&& Objects.equals(this.studyNames, observationUnitSearchRequest.studyNames)
				&& Objects.equals(this.trialDbIds, observationUnitSearchRequest.trialDbIds)
				&& Objects.equals(this.trialNames, observationUnitSearchRequest.trialNames) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(commonCropNames, seasonDbIds, externalReferenceIds, externalReferenceSources,
				germplasmDbIds, germplasmNames, includeObservations, locationDbIds, locationNames,
				observationLevelRelationships, observationLevels, observationUnitDbIds, observationUnitNames,
				observationVariableDbIds, observationVariableNames, observationVariablePUIs, page, pageSize,
				programDbIds, programNames, studyDbIds, studyNames, trialDbIds, trialNames, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ObservationUnitSearchRequest {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    commonCropNames: ").append(toIndentedString(commonCropNames)).append("\n");
		sb.append("    seasonDbIds: ").append(toIndentedString(seasonDbIds)).append("\n");
		sb.append("    externalReferenceIds: ").append(toIndentedString(externalReferenceIds)).append("\n");
		sb.append("    externalReferenceSources: ").append(toIndentedString(externalReferenceSources)).append("\n");
		sb.append("    germplasmDbIds: ").append(toIndentedString(germplasmDbIds)).append("\n");
		sb.append("    germplasmNames: ").append(toIndentedString(germplasmNames)).append("\n");
		sb.append("    includeObservations: ").append(toIndentedString(includeObservations)).append("\n");
		sb.append("    locationDbIds: ").append(toIndentedString(locationDbIds)).append("\n");
		sb.append("    locationNames: ").append(toIndentedString(locationNames)).append("\n");
		sb.append("    observationLevelRelationships: ").append(toIndentedString(observationLevelRelationships))
				.append("\n");
		sb.append("    observationLevels: ").append(toIndentedString(observationLevels)).append("\n");
		sb.append("    observationUnitDbIds: ").append(toIndentedString(observationUnitDbIds)).append("\n");
		sb.append("    observationUnitNames: ").append(toIndentedString(observationUnitNames)).append("\n");
		sb.append("    observationVariableDbIds: ").append(toIndentedString(observationVariableDbIds)).append("\n");
		sb.append("    observationVariableNames: ").append(toIndentedString(observationVariableNames)).append("\n");
		sb.append("    observationVariablePUIs: ").append(toIndentedString(observationVariablePUIs)).append("\n");
		sb.append("    page: ").append(toIndentedString(page)).append("\n");
		sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
		sb.append("    programDbIds: ").append(toIndentedString(programDbIds)).append("\n");
		sb.append("    programNames: ").append(toIndentedString(programNames)).append("\n");
		sb.append("    studyDbIds: ").append(toIndentedString(studyDbIds)).append("\n");
		sb.append("    studyNames: ").append(toIndentedString(studyNames)).append("\n");
		sb.append("    trialDbIds: ").append(toIndentedString(trialDbIds)).append("\n");
		sb.append("    trialNames: ").append(toIndentedString(trialNames)).append("\n");
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
		if (this.seasonDbIds != null)
			count += this.seasonDbIds.size();
		if (this.externalReferenceIds != null)
			count += this.externalReferenceIds.size();
		if (this.externalReferenceSources != null)
			count += this.externalReferenceSources.size();
		if (this.germplasmDbIds != null)
			count += this.germplasmDbIds.size();
		if (this.germplasmNames != null)
			count += this.germplasmNames.size();
		if (this.includeObservations != null)
			count += 1;
		if (this.locationDbIds != null)
			count += this.locationDbIds.size();
		if (this.locationNames != null)
			count += this.locationNames.size();
		if (this.observationLevelRelationships != null)
			count += this.observationLevelRelationships.size();
		if (this.observationLevels != null)
			count += this.observationLevels.size();
		if (this.observationUnitDbIds != null)
			count += this.observationUnitDbIds.size();
		if (this.observationUnitNames != null)
			count += this.observationUnitNames.size();
		if (this.observationVariableDbIds != null)
			count += this.observationVariableDbIds.size();
		if (this.observationVariableNames != null)
			count += this.observationVariableNames.size();
		if (this.observationVariablePUIs != null)
			count += this.observationVariablePUIs.size();
		if (this.programDbIds != null)
			count += this.programDbIds.size();
		if (this.programNames != null)
			count += this.programNames.size();
		if (this.studyDbIds != null)
			count += this.studyDbIds.size();
		if (this.studyNames != null)
			count += this.studyNames.size();
		if (this.trialDbIds != null)
			count += this.trialDbIds.size();
		if (this.trialNames != null)
			count += this.trialNames.size();
		return count;
	}
}
