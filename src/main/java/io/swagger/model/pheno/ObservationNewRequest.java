package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.BrAPIDataModel;
import io.swagger.model.GeoJSON;
import io.swagger.model.core.Season;

import java.time.OffsetDateTime;

public class ObservationNewRequest extends BrAPIDataModel {

	@JsonProperty("collector")
	private String collector = null;

	@JsonProperty("germplasmDbId")
	private String germplasmDbId = null;

	@JsonProperty("germplasmName")
	private String germplasmName = null;

	@JsonProperty("geoCoordinates")
	private GeoJSON geoCoordinates = null;
	
	@JsonProperty("observationTimeStamp")
	private OffsetDateTime observationTimeStamp = null;

	@JsonProperty("observationUnitDbId")
	private String observationUnitDbId = null;

	@JsonProperty("observationUnitName")
	private String observationUnitName = null;

	@JsonProperty("observationVariableDbId")
	private String observationVariableDbId = null;

	@JsonProperty("observationVariableName")
	private String observationVariableName = null;

	@JsonProperty("season")
	private Season season = null;

	@JsonProperty("studyDbId")
	private String studyDbId = null;

	@JsonProperty("uploadedBy")
	private String uploadedBy = null;

	@JsonProperty("value")
	private String value = null;

	public GeoJSON getGeoCoordinates() {
		return geoCoordinates;
	}

	public void setGeoCoordinates(GeoJSON geoCoordinates) {
		this.geoCoordinates = geoCoordinates;
	}

	public ObservationNewRequest collector(String collector) {
		this.collector = collector;
		return this;
	}

	public String getCollector() {
		return collector;
	}

	public void setCollector(String collector) {
		this.collector = collector;
	}

	public ObservationNewRequest germplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
		return this;
	}

	public String getGermplasmDbId() {
		return germplasmDbId;
	}

	public void setGermplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
	}

	public ObservationNewRequest germplasmName(String germplasmName) {
		this.germplasmName = germplasmName;
		return this;
	}

	public String getGermplasmName() {
		return germplasmName;
	}

	public void setGermplasmName(String germplasmName) {
		this.germplasmName = germplasmName;
	}

	public ObservationNewRequest observationTimeStamp(OffsetDateTime observationTimeStamp) {
		this.observationTimeStamp = observationTimeStamp;
		return this;
	}

	public OffsetDateTime getObservationTimeStamp() {
		return observationTimeStamp;
	}

	public void setObservationTimeStamp(OffsetDateTime observationTimeStamp) {
		this.observationTimeStamp = observationTimeStamp;
	}

	public ObservationNewRequest observationUnitDbId(String observationUnitDbId) {
		this.observationUnitDbId = observationUnitDbId;
		return this;
	}

	public String getObservationUnitDbId() {
		return observationUnitDbId;
	}

	public void setObservationUnitDbId(String observationUnitDbId) {
		this.observationUnitDbId = observationUnitDbId;
	}

	public ObservationNewRequest observationUnitName(String observationUnitName) {
		this.observationUnitName = observationUnitName;
		return this;
	}

	public String getObservationUnitName() {
		return observationUnitName;
	}

	public void setObservationUnitName(String observationUnitName) {
		this.observationUnitName = observationUnitName;
	}

	public ObservationNewRequest observationVariableDbId(String observationVariableDbId) {
		this.observationVariableDbId = observationVariableDbId;
		return this;
	}

	public String getObservationVariableDbId() {
		return observationVariableDbId;
	}

	public void setObservationVariableDbId(String observationVariableDbId) {
		this.observationVariableDbId = observationVariableDbId;
	}

	public ObservationNewRequest observationVariableName(String observationVariableName) {
		this.observationVariableName = observationVariableName;
		return this;
	}

	public String getObservationVariableName() {
		return observationVariableName;
	}

	public void setObservationVariableName(String observationVariableName) {
		this.observationVariableName = observationVariableName;
	}

	public ObservationNewRequest season(Season season) {
		this.season = season;
		return this;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public ObservationNewRequest studyDbId(String studyDbId) {
		this.studyDbId = studyDbId;
		return this;
	}

	public String getStudyDbId() {
		return studyDbId;
	}

	public void setStudyDbId(String studyDbId) {
		this.studyDbId = studyDbId;
	}

	public ObservationNewRequest uploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
		return this;
	}

	public String getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	public ObservationNewRequest value(String value) {
		this.value = value;
		return this;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ObservationNewRequest observationNewRequest = (ObservationNewRequest) o;
		return Objects.equals(this.additionalInfo, observationNewRequest.additionalInfo)
				&& Objects.equals(this.collector, observationNewRequest.collector)
				&& Objects.equals(this.externalReferences, observationNewRequest.externalReferences)
				&& Objects.equals(this.germplasmDbId, observationNewRequest.germplasmDbId)
				&& Objects.equals(this.germplasmName, observationNewRequest.germplasmName)
				&& Objects.equals(this.observationTimeStamp, observationNewRequest.observationTimeStamp)
				&& Objects.equals(this.observationUnitDbId, observationNewRequest.observationUnitDbId)
				&& Objects.equals(this.observationUnitName, observationNewRequest.observationUnitName)
				&& Objects.equals(this.observationVariableDbId, observationNewRequest.observationVariableDbId)
				&& Objects.equals(this.observationVariableName, observationNewRequest.observationVariableName)
				&& Objects.equals(this.season, observationNewRequest.season)
				&& Objects.equals(this.studyDbId, observationNewRequest.studyDbId)
				&& Objects.equals(this.uploadedBy, observationNewRequest.uploadedBy)
				&& Objects.equals(this.value, observationNewRequest.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(additionalInfo, collector, externalReferences, germplasmDbId, germplasmName,
				observationTimeStamp, observationUnitDbId, observationUnitName, observationVariableDbId,
				observationVariableName, season, studyDbId, uploadedBy, value);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ObservationNewRequest {\n");

		sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
		sb.append("    collector: ").append(toIndentedString(collector)).append("\n");
		sb.append("    externalReferences: ").append(toIndentedString(externalReferences)).append("\n");
		sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
		sb.append("    germplasmName: ").append(toIndentedString(germplasmName)).append("\n");
		sb.append("    observationTimeStamp: ").append(toIndentedString(observationTimeStamp)).append("\n");
		sb.append("    observationUnitDbId: ").append(toIndentedString(observationUnitDbId)).append("\n");
		sb.append("    observationUnitName: ").append(toIndentedString(observationUnitName)).append("\n");
		sb.append("    observationVariableDbId: ").append(toIndentedString(observationVariableDbId)).append("\n");
		sb.append("    observationVariableName: ").append(toIndentedString(observationVariableName)).append("\n");
		sb.append("    season: ").append(toIndentedString(season)).append("\n");
		sb.append("    studyDbId: ").append(toIndentedString(studyDbId)).append("\n");
		sb.append("    uploadedBy: ").append(toIndentedString(uploadedBy)).append("\n");
		sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
