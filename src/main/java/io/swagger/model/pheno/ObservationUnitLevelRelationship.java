package io.swagger.model.pheno;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ObservationUnitLevelRelationship extends ObservationUnitLevel {
	@JsonProperty("observationUnitDbId")
	private String observationUnitDbId = null;

	public String getObservationUnitDbId() {
		return observationUnitDbId;
	}

	public void setObservationUnitDbId(String observationUnitDbId) {
		this.observationUnitDbId = observationUnitDbId;
	}
}
