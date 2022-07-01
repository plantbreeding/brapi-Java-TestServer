package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Observation extends ObservationNewRequest {
	@JsonProperty("observationDbId")
	private String observationDbId = null;

	public Observation observationDbId(String observationDbId) {
		this.observationDbId = observationDbId;
		return this;
	}

	public String getObservationDbId() {
		return observationDbId;
	}

	public void setObservationDbId(String observationDbId) {
		this.observationDbId = observationDbId;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Observation observation = (Observation) o;
		return Objects.equals(this.observationDbId, observation.observationDbId) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(observationDbId, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Observation {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    observationDbId: ").append(toIndentedString(observationDbId)).append("\n");
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
