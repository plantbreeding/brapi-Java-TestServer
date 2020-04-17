package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.SearchRequestParametersPaging;
import io.swagger.model.pheno.ObservationUnitLevelRelationship;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * ObservationUnitSearchRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
public class ObservationUnitSearchRequest extends SearchRequestParametersPaging {
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

	@JsonProperty("seasonDbIds")
	@Valid
	private List<String> seasonDbIds = null;

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

	@JsonProperty("includeObservations")
	private Boolean includeObservations = null;

	@JsonProperty("observationLevelRelationships")
	@Valid
	private List<ObservationUnitLevelRelationship> observationLevelRelationships = null;

	@JsonProperty("observationLevels")
	@Valid
	private List<ObservationUnitLevelRelationship> observationLevels = null;

	@JsonProperty("observationUnitDbIds")
	@Valid
	private List<String> observationUnitDbIds = null;

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

	/**
	 * A program identifier to search for
	 * 
	 * @return programDbIds
	 **/
	@ApiModelProperty(example = "[\"8f5de35b\",\"0e2d4a13\"]", value = "A program identifier to search for")

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

	/**
	 * A name of a program to search for
	 * 
	 * @return programNames
	 **/
	@ApiModelProperty(example = "[\"Better Breeding Program\",\"Best Breeding Program\"]", value = "A name of a program to search for")

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

	/**
	 * The ID which uniquely identifies a trial to search for
	 * 
	 * @return trialDbIds
	 **/
	@ApiModelProperty(example = "[\"d2593dc2\",\"9431a731\"]", value = "The ID which uniquely identifies a trial to search for")

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

	/**
	 * The human readable name of a trial to search for
	 * 
	 * @return trialNames
	 **/
	@ApiModelProperty(example = "[\"All Yield Trials 2016\",\"Disease Resistance Study Comparison Group\"]", value = "The human readable name of a trial to search for")

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

	/**
	 * List of study identifiers to search for
	 * 
	 * @return studyDbIds
	 **/
	@ApiModelProperty(example = "[\"cf6c4bd4\",\"691e69d6\"]", value = "List of study identifiers to search for")

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

	/**
	 * List of study names to filter search results
	 * 
	 * @return studyNames
	 **/
	@ApiModelProperty(example = "[\"The First Bob Study 2017\",\"Wheat Yield Trial 246\"]", value = "List of study names to filter search results")

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

	/**
	 * The location ids to search for
	 * 
	 * @return locationDbIds
	 **/
	@ApiModelProperty(example = "[\"b28911cf\",\"5071d1e4\"]", value = "The location ids to search for")

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

	/**
	 * A human readable names to search for
	 * 
	 * @return locationNames
	 **/
	@ApiModelProperty(example = "[\"Location Alpha\",\"The Large Hadron Collider\"]", value = "A human readable names to search for")

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

	/**
	 * List of IDs which uniquely identify germplasm to search for
	 * 
	 * @return germplasmDbIds
	 **/
	@ApiModelProperty(example = "[\"e9c6edd7\",\"1b1df4a6\"]", value = "List of IDs which uniquely identify germplasm to search for")

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

	/**
	 * List of human readable names to identify germplasm to search for
	 * 
	 * @return germplasmNames
	 **/
	@ApiModelProperty(example = "[\"A0000003\",\"A0000477\"]", value = "List of human readable names to identify germplasm to search for")

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

	/**
	 * The DbIds of Variables to search for
	 * 
	 * @return observationVariableDbIds
	 **/
	@ApiModelProperty(example = "[\"a646187d\",\"6d23513b\"]", value = "The DbIds of Variables to search for")

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

	/**
	 * The names of Variables to search for
	 * 
	 * @return observationVariableNames
	 **/
	@ApiModelProperty(example = "[\"Plant Height in meters\",\"Wheat rust score 1-5\"]", value = "The names of Variables to search for")

	public List<String> getObservationVariableNames() {
		return observationVariableNames;
	}

	public void setObservationVariableNames(List<String> observationVariableNames) {
		this.observationVariableNames = observationVariableNames;
	}

	public ObservationUnitSearchRequest externalReferenceIDs(List<String> externalReferenceIDs) {
		this.externalReferenceIDs = externalReferenceIDs;
		return this;
	}

	public ObservationUnitSearchRequest addExternalReferenceIDsItem(String externalReferenceIDsItem) {
		if (this.externalReferenceIDs == null) {
			this.externalReferenceIDs = new ArrayList<String>();
		}
		this.externalReferenceIDs.add(externalReferenceIDsItem);
		return this;
	}

	/**
	 * List of external references for the trait to search for
	 * 
	 * @return externalReferenceIDs
	 **/
	@ApiModelProperty(example = "[\"http://purl.obolibrary.org/obo/ro.owl\",\"14a19841\"]", value = "List of external references for the trait to search for")

	public List<String> getExternalReferenceIDs() {
		return externalReferenceIDs;
	}

	public void setExternalReferenceIDs(List<String> externalReferenceIDs) {
		this.externalReferenceIDs = externalReferenceIDs;
	}

	public ObservationUnitSearchRequest externalReferenceSources(List<String> externalReferenceSources) {
		this.externalReferenceSources = externalReferenceSources;
		return this;
	}

	public ObservationUnitSearchRequest addExternalReferenceSourcesItem(String externalReferenceSourcesItem) {
		if (this.externalReferenceSources == null) {
			this.externalReferenceSources = new ArrayList<String>();
		}
		this.externalReferenceSources.add(externalReferenceSourcesItem);
		return this;
	}

	/**
	 * List of external references sources for the trait to search for
	 * 
	 * @return externalReferenceSources
	 **/
	@ApiModelProperty(example = "[\"OBO Library\",\"Field App Name\"]", value = "List of external references sources for the trait to search for")

	public List<String> getExternalReferenceSources() {
		return externalReferenceSources;
	}

	public void setExternalReferenceSources(List<String> externalReferenceSources) {
		this.externalReferenceSources = externalReferenceSources;
	}

	public ObservationUnitSearchRequest includeObservations(Boolean includeObservations) {
		this.includeObservations = includeObservations;
		return this;
	}

	/**
	 * Use this parameter to include a list of observations embedded in each
	 * ObservationUnit object. CAUTION - Use this parameter at your own risk. It may
	 * return large, unpaginated lists of observation data. Only set this value to
	 * True if you are sure you need to.
	 * 
	 * @return includeObservations
	 **/
	@ApiModelProperty(example = "false", value = "Use this parameter to include a list of observations embedded in each ObservationUnit object.   CAUTION - Use this parameter at your own risk. It may return large, unpaginated lists of observation data. Only set this value to True if you are sure you need to.")

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

	/**
	 * Searches for values in
	 * ObservationUnit->observationUnitPosition->observationLevelRelationships
	 * 
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

	public ObservationUnitSearchRequest observationLevels(List<ObservationUnitLevelRelationship> observationLevels) {
		this.observationLevels = observationLevels;
		return this;
	}

	public ObservationUnitSearchRequest addObservationLevelsItem(
			ObservationUnitLevelRelationship observationLevelsItem) {
		if (this.observationLevels == null) {
			this.observationLevels = new ArrayList<ObservationUnitLevelRelationship>();
		}
		this.observationLevels.add(observationLevelsItem);
		return this;
	}

	/**
	 * Searches for values in
	 * ObservationUnit->observationUnitPosition->observationLevel
	 * 
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

	/**
	 * The unique id of an observation unit
	 * 
	 * @return observationUnitDbIds
	 **/
	@ApiModelProperty(example = "[\"66bab7e3\",\"0e5e7f99\"]", value = "The unique id of an observation unit")

	public List<String> getObservationUnitDbIds() {
		return observationUnitDbIds;
	}

	public void setObservationUnitDbIds(List<String> observationUnitDbIds) {
		this.observationUnitDbIds = observationUnitDbIds;
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
		return Objects.equals(this.programDbIds, observationUnitSearchRequest.programDbIds)
				&& Objects.equals(this.programNames, observationUnitSearchRequest.programNames)
				&& Objects.equals(this.trialDbIds, observationUnitSearchRequest.trialDbIds)
				&& Objects.equals(this.trialNames, observationUnitSearchRequest.trialNames)
				&& Objects.equals(this.studyDbIds, observationUnitSearchRequest.studyDbIds)
				&& Objects.equals(this.studyNames, observationUnitSearchRequest.studyNames)
				&& Objects.equals(this.locationDbIds, observationUnitSearchRequest.locationDbIds)
				&& Objects.equals(this.locationNames, observationUnitSearchRequest.locationNames)
				&& Objects.equals(this.germplasmDbIds, observationUnitSearchRequest.germplasmDbIds)
				&& Objects.equals(this.germplasmNames, observationUnitSearchRequest.germplasmNames)
				&& Objects.equals(this.observationVariableDbIds, observationUnitSearchRequest.observationVariableDbIds)
				&& Objects.equals(this.observationVariableNames, observationUnitSearchRequest.observationVariableNames)
				&& Objects.equals(this.externalReferenceIDs, observationUnitSearchRequest.externalReferenceIDs)
				&& Objects.equals(this.externalReferenceSources, observationUnitSearchRequest.externalReferenceSources)
				&& Objects.equals(this.includeObservations, observationUnitSearchRequest.includeObservations)
				&& Objects.equals(this.observationLevelRelationships,
						observationUnitSearchRequest.observationLevelRelationships)
				&& Objects.equals(this.observationLevels, observationUnitSearchRequest.observationLevels)
				&& Objects.equals(this.observationUnitDbIds, observationUnitSearchRequest.observationUnitDbIds)
				&& super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(programDbIds, programNames, trialDbIds, trialNames, studyDbIds, studyNames, locationDbIds,
				locationNames, germplasmDbIds, germplasmNames, observationVariableDbIds, observationVariableNames,
				externalReferenceIDs, externalReferenceSources, includeObservations, observationLevelRelationships,
				observationLevels, observationUnitDbIds, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ObservationUnitSearchRequest {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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
		sb.append("    includeObservations: ").append(toIndentedString(includeObservations)).append("\n");
		sb.append("    observationLevelRelationships: ").append(toIndentedString(observationLevelRelationships))
				.append("\n");
		sb.append("    observationLevels: ").append(toIndentedString(observationLevels)).append("\n");
		sb.append("    observationUnitDbIds: ").append(toIndentedString(observationUnitDbIds)).append("\n");
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
