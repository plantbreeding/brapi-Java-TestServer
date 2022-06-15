package io.swagger.model.core;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.BrAPIDataModel;
import io.swagger.model.DataLink;
import io.swagger.model.pheno.ObservationUnitHierarchyLevel;

import java.util.ArrayList;
import java.util.List;
import java.time.OffsetDateTime;

public class StudyNewRequest extends BrAPIDataModel{
	@JsonProperty("active")
	private Boolean active = null;

	@JsonProperty("commonCropName")
	private String commonCropName = null;

	@JsonProperty("contacts")
	private List<Contact> contacts = null;

	@JsonProperty("culturalPractices")
	private String culturalPractices = null;

	@JsonProperty("dataLinks")
	private List<DataLink> dataLinks = null;

	@JsonProperty("documentationURL")
	private String documentationURL = null;

	@JsonProperty("endDate")
	private OffsetDateTime endDate = null;

	@JsonProperty("environmentParameters")
	private List<EnvironmentParameter> environmentParameters = null;

	@JsonProperty("experimentalDesign")
	private StudyExperimentalDesign experimentalDesign = null;

	@JsonProperty("growthFacility")
	private StudyGrowthFacility growthFacility = null;

	@JsonProperty("lastUpdate")
	private StudyLastUpdate lastUpdate = null;

	@JsonProperty("license")
	private String license = null;

	@JsonProperty("locationDbId")
	private String locationDbId = null;

	@JsonProperty("locationName")
	private String locationName = null;

	@JsonProperty("observationLevels")
	private List<ObservationUnitHierarchyLevel> observationLevels = null;

	@JsonProperty("observationUnitsDescription")
	private String observationUnitsDescription = null;

	@JsonProperty("seasons")
	private List<String> seasons = null;

	@JsonProperty("startDate")
	private OffsetDateTime startDate = null;

	@JsonProperty("studyCode")
	private String studyCode = null;

	@JsonProperty("studyDescription")
	private String studyDescription = null;

	@JsonProperty("studyName")
	private String studyName = null;

	@JsonProperty("studyPUI")
	private String studyPUI = null;

	@JsonProperty("studyType")
	private String studyType = null;

	@JsonProperty("trialDbId")
	private String trialDbId = null;

	@JsonProperty("trialName")
	private String trialName = null;

	@JsonProperty("observationVariableDbIds")
	private List<String> observationVariableDbIds = null;

	public StudyNewRequest active(Boolean active) {
		this.active = active;
		return this;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public StudyNewRequest commonCropName(String commonCropName) {
		this.commonCropName = commonCropName;
		return this;
	}

	public String getCommonCropName() {
		return commonCropName;
	}

	public void setCommonCropName(String commonCropName) {
		this.commonCropName = commonCropName;
	}

	public StudyNewRequest contacts(List<Contact> contacts) {
		this.contacts = contacts;
		return this;
	}

	public StudyNewRequest addContactsItem(Contact contactsItem) {
		if (this.contacts == null) {
			this.contacts = new ArrayList<Contact>();
		}
		this.contacts.add(contactsItem);
		return this;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public StudyNewRequest culturalPractices(String culturalPractices) {
		this.culturalPractices = culturalPractices;
		return this;
	}

	public String getCulturalPractices() {
		return culturalPractices;
	}

	public void setCulturalPractices(String culturalPractices) {
		this.culturalPractices = culturalPractices;
	}

	public StudyNewRequest dataLinks(List<DataLink> dataLinks) {
		this.dataLinks = dataLinks;
		return this;
	}

	public StudyNewRequest addDataLinksItem(DataLink dataLinksItem) {
		if (this.dataLinks == null) {
			this.dataLinks = new ArrayList<DataLink>();
		}
		this.dataLinks.add(dataLinksItem);
		return this;
	}

	public List<DataLink> getDataLinks() {
		return dataLinks;
	}

	public void setDataLinks(List<DataLink> dataLinks) {
		this.dataLinks = dataLinks;
	}

	public StudyNewRequest documentationURL(String documentationURL) {
		this.documentationURL = documentationURL;
		return this;
	}

	public String getDocumentationURL() {
		return documentationURL;
	}

	public void setDocumentationURL(String documentationURL) {
		this.documentationURL = documentationURL;
	}

	public StudyNewRequest endDate(OffsetDateTime endDate) {
		this.endDate = endDate;
		return this;
	}

	public OffsetDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(OffsetDateTime endDate) {
		this.endDate = endDate;
	}

	public StudyNewRequest environmentParameters(List<EnvironmentParameter> environmentParameters) {
		this.environmentParameters = environmentParameters;
		return this;
	}

	public StudyNewRequest addEnvironmentParametersItem(EnvironmentParameter environmentParametersItem) {
		if (this.environmentParameters == null) {
			this.environmentParameters = new ArrayList<EnvironmentParameter>();
		}
		this.environmentParameters.add(environmentParametersItem);
		return this;
	}

	public List<EnvironmentParameter> getEnvironmentParameters() {
		return environmentParameters;
	}

	public void setEnvironmentParameters(List<EnvironmentParameter> environmentParameters) {
		this.environmentParameters = environmentParameters;
	}

	public StudyNewRequest experimentalDesign(StudyExperimentalDesign experimentalDesign) {
		this.experimentalDesign = experimentalDesign;
		return this;
	}

	public StudyExperimentalDesign getExperimentalDesign() {
		return experimentalDesign;
	}

	public void setExperimentalDesign(StudyExperimentalDesign experimentalDesign) {
		this.experimentalDesign = experimentalDesign;
	}

	public StudyNewRequest growthFacility(StudyGrowthFacility growthFacility) {
		this.growthFacility = growthFacility;
		return this;
	}

	public StudyGrowthFacility getGrowthFacility() {
		return growthFacility;
	}

	public void setGrowthFacility(StudyGrowthFacility growthFacility) {
		this.growthFacility = growthFacility;
	}

	public StudyNewRequest lastUpdate(StudyLastUpdate lastUpdate) {
		this.lastUpdate = lastUpdate;
		return this;
	}

	public StudyLastUpdate getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(StudyLastUpdate lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public StudyNewRequest license(String license) {
		this.license = license;
		return this;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public StudyNewRequest locationDbId(String locationDbId) {
		this.locationDbId = locationDbId;
		return this;
	}

	public String getLocationDbId() {
		return locationDbId;
	}

	public void setLocationDbId(String locationDbId) {
		this.locationDbId = locationDbId;
	}

	public StudyNewRequest locationName(String locationName) {
		this.locationName = locationName;
		return this;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public StudyNewRequest observationLevels(List<ObservationUnitHierarchyLevel> observationLevels) {
		this.observationLevels = observationLevels;
		return this;
	}

	public StudyNewRequest addObservationLevelsItem(ObservationUnitHierarchyLevel observationLevelsItem) {
		if (this.observationLevels == null) {
			this.observationLevels = new ArrayList<ObservationUnitHierarchyLevel>();
		}
		this.observationLevels.add(observationLevelsItem);
		return this;
	}

	public List<ObservationUnitHierarchyLevel> getObservationLevels() {
		return observationLevels;
	}

	public void setObservationLevels(List<ObservationUnitHierarchyLevel> observationLevels) {
		this.observationLevels = observationLevels;
	}

	public StudyNewRequest observationUnitsDescription(String observationUnitsDescription) {
		this.observationUnitsDescription = observationUnitsDescription;
		return this;
	}

	public String getObservationUnitsDescription() {
		return observationUnitsDescription;
	}

	public void setObservationUnitsDescription(String observationUnitsDescription) {
		this.observationUnitsDescription = observationUnitsDescription;
	}

	public StudyNewRequest seasons(List<String> seasons) {
		this.seasons = seasons;
		return this;
	}

	public StudyNewRequest addSeasonsItem(String seasonsItem) {
		if (this.seasons == null) {
			this.seasons = new ArrayList<String>();
		}
		this.seasons.add(seasonsItem);
		return this;
	}

	public List<String> getSeasons() {
		return seasons;
	}

	public void setSeasons(List<String> seasons) {
		this.seasons = seasons;
	}

	public StudyNewRequest observationVariableDbIds(List<String> observationVariableDbIds) {
		this.observationVariableDbIds = observationVariableDbIds;
		return this;
	}

	public StudyNewRequest addObservationVariableDbIdsItem(String observationVariableDbIdsItem) {
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

	public StudyNewRequest startDate(OffsetDateTime startDate) {
		this.startDate = startDate;
		return this;
	}

	public OffsetDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(OffsetDateTime startDate) {
		this.startDate = startDate;
	}

	public StudyNewRequest studyCode(String studyCode) {
		this.studyCode = studyCode;
		return this;
	}

	public String getStudyCode() {
		return studyCode;
	}

	public void setStudyCode(String studyCode) {
		this.studyCode = studyCode;
	}

	public StudyNewRequest studyDescription(String studyDescription) {
		this.studyDescription = studyDescription;
		return this;
	}

	public String getStudyDescription() {
		return studyDescription;
	}

	public void setStudyDescription(String studyDescription) {
		this.studyDescription = studyDescription;
	}

	public StudyNewRequest studyName(String studyName) {
		this.studyName = studyName;
		return this;
	}

	public String getStudyName() {
		return studyName;
	}

	public void setStudyName(String studyName) {
		this.studyName = studyName;
	}

	public StudyNewRequest studyPUI(String studyPUI) {
		this.studyPUI = studyPUI;
		return this;
	}

	public String getStudyPUI() {
		return studyPUI;
	}

	public void setStudyPUI(String studyPUI) {
		this.studyPUI = studyPUI;
	}

	public StudyNewRequest studyType(String studyType) {
		this.studyType = studyType;
		return this;
	}

	public String getStudyType() {
		return studyType;
	}

	public void setStudyType(String studyType) {
		this.studyType = studyType;
	}

	public StudyNewRequest trialDbId(String trialDbId) {
		this.trialDbId = trialDbId;
		return this;
	}

	public String getTrialDbId() {
		return trialDbId;
	}

	public void setTrialDbId(String trialDbId) {
		this.trialDbId = trialDbId;
	}

	public StudyNewRequest trialName(String trialName) {
		this.trialName = trialName;
		return this;
	}

	public String getTrialName() {
		return trialName;
	}

	public void setTrialName(String trialName) {
		this.trialName = trialName;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		StudyNewRequest studyNewRequest = (StudyNewRequest) o;
		return Objects.equals(this.active, studyNewRequest.active)
				&& Objects.equals(this.additionalInfo, studyNewRequest.additionalInfo)
				&& Objects.equals(this.commonCropName, studyNewRequest.commonCropName)
				&& Objects.equals(this.contacts, studyNewRequest.contacts)
				&& Objects.equals(this.culturalPractices, studyNewRequest.culturalPractices)
				&& Objects.equals(this.dataLinks, studyNewRequest.dataLinks)
				&& Objects.equals(this.documentationURL, studyNewRequest.documentationURL)
				&& Objects.equals(this.endDate, studyNewRequest.endDate)
				&& Objects.equals(this.environmentParameters, studyNewRequest.environmentParameters)
				&& Objects.equals(this.experimentalDesign, studyNewRequest.experimentalDesign)
				&& Objects.equals(this.externalReferences, studyNewRequest.externalReferences)
				&& Objects.equals(this.growthFacility, studyNewRequest.growthFacility)
				&& Objects.equals(this.lastUpdate, studyNewRequest.lastUpdate)
				&& Objects.equals(this.license, studyNewRequest.license)
				&& Objects.equals(this.locationDbId, studyNewRequest.locationDbId)
				&& Objects.equals(this.locationName, studyNewRequest.locationName)
				&& Objects.equals(this.observationLevels, studyNewRequest.observationLevels)
				&& Objects.equals(this.observationUnitsDescription, studyNewRequest.observationUnitsDescription)
				&& Objects.equals(this.seasons, studyNewRequest.seasons)
				&& Objects.equals(this.startDate, studyNewRequest.startDate)
				&& Objects.equals(this.studyCode, studyNewRequest.studyCode)
				&& Objects.equals(this.studyDescription, studyNewRequest.studyDescription)
				&& Objects.equals(this.studyName, studyNewRequest.studyName)
				&& Objects.equals(this.studyPUI, studyNewRequest.studyPUI)
				&& Objects.equals(this.studyType, studyNewRequest.studyType)
				&& Objects.equals(this.trialDbId, studyNewRequest.trialDbId)
				&& Objects.equals(this.trialName, studyNewRequest.trialName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(active, additionalInfo, commonCropName, contacts, culturalPractices, dataLinks,
				documentationURL, endDate, environmentParameters, experimentalDesign, externalReferences,
				growthFacility, lastUpdate, license, locationDbId, locationName, observationLevels,
				observationUnitsDescription, seasons, startDate, studyCode, studyDescription, studyName, studyPUI,
				studyType, trialDbId, trialName);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class StudyNewRequest {\n");

		sb.append("    active: ").append(toIndentedString(active)).append("\n");
		sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
		sb.append("    commonCropName: ").append(toIndentedString(commonCropName)).append("\n");
		sb.append("    contacts: ").append(toIndentedString(contacts)).append("\n");
		sb.append("    culturalPractices: ").append(toIndentedString(culturalPractices)).append("\n");
		sb.append("    dataLinks: ").append(toIndentedString(dataLinks)).append("\n");
		sb.append("    documentationURL: ").append(toIndentedString(documentationURL)).append("\n");
		sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
		sb.append("    environmentParameters: ").append(toIndentedString(environmentParameters)).append("\n");
		sb.append("    experimentalDesign: ").append(toIndentedString(experimentalDesign)).append("\n");
		sb.append("    externalReferences: ").append(toIndentedString(externalReferences)).append("\n");
		sb.append("    growthFacility: ").append(toIndentedString(growthFacility)).append("\n");
		sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
		sb.append("    license: ").append(toIndentedString(license)).append("\n");
		sb.append("    locationDbId: ").append(toIndentedString(locationDbId)).append("\n");
		sb.append("    locationName: ").append(toIndentedString(locationName)).append("\n");
		sb.append("    observationLevels: ").append(toIndentedString(observationLevels)).append("\n");
		sb.append("    observationUnitsDescription: ").append(toIndentedString(observationUnitsDescription))
				.append("\n");
		sb.append("    seasons: ").append(toIndentedString(seasons)).append("\n");
		sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
		sb.append("    studyCode: ").append(toIndentedString(studyCode)).append("\n");
		sb.append("    studyDescription: ").append(toIndentedString(studyDescription)).append("\n");
		sb.append("    studyName: ").append(toIndentedString(studyName)).append("\n");
		sb.append("    studyPUI: ").append(toIndentedString(studyPUI)).append("\n");
		sb.append("    studyType: ").append(toIndentedString(studyType)).append("\n");
		sb.append("    trialDbId: ").append(toIndentedString(trialDbId)).append("\n");
		sb.append("    trialName: ").append(toIndentedString(trialName)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
