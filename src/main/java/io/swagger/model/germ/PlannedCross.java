package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PlannedCross extends PlannedCrossNewRequest {
	@JsonProperty("plannedCrossDbId")
	private String plannedCrossDbId = null;

	public PlannedCross plannedCrossDbId(String plannedCrossDbId) {
		this.plannedCrossDbId = plannedCrossDbId;
		return this;
	}

	public String getPlannedCrossDbId() {
		return plannedCrossDbId;
	}

	public void setPlannedCrossDbId(String plannedCrossDbId) {
		this.plannedCrossDbId = plannedCrossDbId;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PlannedCross plannedCross = (PlannedCross) o;
		return Objects.equals(this.plannedCrossDbId, plannedCross.plannedCrossDbId) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(plannedCrossDbId, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PlannedCross {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    plannedCrossDbId: ").append(toIndentedString(plannedCrossDbId)).append("\n");
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
