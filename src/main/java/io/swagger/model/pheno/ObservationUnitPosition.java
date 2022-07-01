package io.swagger.model.pheno;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.GeoJSON;
import java.util.ArrayList;
import java.util.List;

public class ObservationUnitPosition {

	@JsonProperty("entryType")
	private EntryTypeEnum entryType = null;

	@JsonProperty("geoCoordinates")
	private GeoJSON geoCoordinates = null;

	@JsonProperty("observationLevel")
	private ObservationUnitLevel observationLevel = null;

	@JsonProperty("observationLevelRelationships")
	private List<ObservationUnitLevelRelationship> observationLevelRelationships = null;

	@JsonProperty("positionCoordinateX")
	private String positionCoordinateX = null;

	@JsonProperty("positionCoordinateXType")
	private PositionCoordinateTypeEnum positionCoordinateXType = null;

	@JsonProperty("positionCoordinateY")
	private String positionCoordinateY = null;

	@JsonProperty("positionCoordinateYType")
	private PositionCoordinateTypeEnum positionCoordinateYType = null;

	public ObservationUnitPosition entryType(EntryTypeEnum entryType) {
		this.entryType = entryType;
		return this;
	}

	public EntryTypeEnum getEntryType() {
		return entryType;
	}

	public void setEntryType(EntryTypeEnum entryType) {
		this.entryType = entryType;
	}

	public ObservationUnitPosition geoCoordinates(GeoJSON geoCoordinates) {
		this.geoCoordinates = geoCoordinates;
		return this;
	}

	public GeoJSON getGeoCoordinates() {
		return geoCoordinates;
	}

	public void setGeoCoordinates(GeoJSON geoCoordinates) {
		this.geoCoordinates = geoCoordinates;
	}

	public ObservationUnitPosition observationLevel(ObservationUnitLevel observationLevel) {
		this.observationLevel = observationLevel;
		return this;
	}

	public ObservationUnitLevel getObservationLevel() {
		return observationLevel;
	}

	public void setObservationLevel(ObservationUnitLevel observationLevel) {
		this.observationLevel = observationLevel;
	}

	public ObservationUnitPosition observationLevelRelationships(
			List<ObservationUnitLevelRelationship> observationLevelRelationships) {
		this.observationLevelRelationships = observationLevelRelationships;
		return this;
	}

	public ObservationUnitPosition addObservationLevelRelationshipsItem(
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

	public ObservationUnitPosition positionCoordinateX(String positionCoordinateX) {
		this.positionCoordinateX = positionCoordinateX;
		return this;
	}

	public String getPositionCoordinateX() {
		return positionCoordinateX;
	}

	public void setPositionCoordinateX(String positionCoordinateX) {
		this.positionCoordinateX = positionCoordinateX;
	}

	public ObservationUnitPosition positionCoordinateXType(PositionCoordinateTypeEnum positionCoordinateXType) {
		this.positionCoordinateXType = positionCoordinateXType;
		return this;
	}

	public PositionCoordinateTypeEnum getPositionCoordinateXType() {
		return positionCoordinateXType;
	}

	public void setPositionCoordinateXType(PositionCoordinateTypeEnum positionCoordinateXType) {
		this.positionCoordinateXType = positionCoordinateXType;
	}

	public ObservationUnitPosition positionCoordinateY(String positionCoordinateY) {
		this.positionCoordinateY = positionCoordinateY;
		return this;
	}

	public String getPositionCoordinateY() {
		return positionCoordinateY;
	}

	public void setPositionCoordinateY(String positionCoordinateY) {
		this.positionCoordinateY = positionCoordinateY;
	}

	public ObservationUnitPosition positionCoordinateYType(PositionCoordinateTypeEnum positionCoordinateYType) {
		this.positionCoordinateYType = positionCoordinateYType;
		return this;
	}

	public PositionCoordinateTypeEnum getPositionCoordinateYType() {
		return positionCoordinateYType;
	}

	public void setPositionCoordinateYType(PositionCoordinateTypeEnum positionCoordinateYType) {
		this.positionCoordinateYType = positionCoordinateYType;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ObservationUnitPosition observationUnitPosition = (ObservationUnitPosition) o;
		return Objects.equals(this.entryType, observationUnitPosition.entryType)
				&& Objects.equals(this.geoCoordinates, observationUnitPosition.geoCoordinates)
				&& Objects.equals(this.observationLevel, observationUnitPosition.observationLevel)
				&& Objects.equals(this.observationLevelRelationships,
						observationUnitPosition.observationLevelRelationships)
				&& Objects.equals(this.positionCoordinateX, observationUnitPosition.positionCoordinateX)
				&& Objects.equals(this.positionCoordinateXType, observationUnitPosition.positionCoordinateXType)
				&& Objects.equals(this.positionCoordinateY, observationUnitPosition.positionCoordinateY)
				&& Objects.equals(this.positionCoordinateYType, observationUnitPosition.positionCoordinateYType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(entryType, geoCoordinates, observationLevel, observationLevelRelationships,
				positionCoordinateX, positionCoordinateXType, positionCoordinateY, positionCoordinateYType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ObservationUnitPosition {\n");

		sb.append("    entryType: ").append(toIndentedString(entryType)).append("\n");
		sb.append("    geoCoordinates: ").append(toIndentedString(geoCoordinates)).append("\n");
		sb.append("    observationLevel: ").append(toIndentedString(observationLevel)).append("\n");
		sb.append("    observationLevelRelationships: ").append(toIndentedString(observationLevelRelationships))
				.append("\n");
		sb.append("    positionCoordinateX: ").append(toIndentedString(positionCoordinateX)).append("\n");
		sb.append("    positionCoordinateXType: ").append(toIndentedString(positionCoordinateXType)).append("\n");
		sb.append("    positionCoordinateY: ").append(toIndentedString(positionCoordinateY)).append("\n");
		sb.append("    positionCoordinateYType: ").append(toIndentedString(positionCoordinateYType)).append("\n");
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
