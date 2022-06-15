package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ObservationUnit extends ObservationUnitNewRequest {
	@JsonProperty("observationUnitDbId")
	private String observationUnitDbId = null;

	@JsonProperty("observations")
	private List<Observation> observations = null;

	public ObservationUnit observationUnitDbId(String observationUnitDbId) {
		this.observationUnitDbId = observationUnitDbId;
		return this;
	}

	public String getObservationUnitDbId() {
		return observationUnitDbId;
	}

	public void setObservationUnitDbId(String observationUnitDbId) {
		this.observationUnitDbId = observationUnitDbId;
	}

	public ObservationUnit observations(List<Observation> observations) {
		this.observations = observations;
		return this;
	}

	public ObservationUnit addObservationsItem(Observation observationsItem) {
		if (this.observations == null) {
			this.observations = new ArrayList<Observation>();
		}
		this.observations.add(observationsItem);
		return this;
	}

	public List<Observation> getObservations() {
		return observations;
	}

	public void setObservations(List<Observation> observations) {
		this.observations = observations;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ObservationUnit observationUnit = (ObservationUnit) o;
		return Objects.equals(this.observationUnitDbId, observationUnit.observationUnitDbId)
				&& Objects.equals(this.observations, observationUnit.observations) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(observationUnitDbId, observations, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ObservationUnit {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    observationUnitDbId: ").append(toIndentedString(observationUnitDbId)).append("\n");
		sb.append("    observations: ").append(toIndentedString(observations)).append("\n");
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
