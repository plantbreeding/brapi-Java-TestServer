package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CrossingProject extends CrossingProjectNewRequest {
	@JsonProperty("crossingProjectDbId")
	private String crossingProjectDbId = null;

	public CrossingProject crossingProjectDbId(String crossingProjectDbId) {
		this.crossingProjectDbId = crossingProjectDbId;
		return this;
	}

	public String getCrossingProjectDbId() {
		return crossingProjectDbId;
	}

	public void setCrossingProjectDbId(String crossingProjectDbId) {
		this.crossingProjectDbId = crossingProjectDbId;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CrossingProject crossingProject = (CrossingProject) o;
		return Objects.equals(this.crossingProjectDbId, crossingProject.crossingProjectDbId) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(crossingProjectDbId, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CrossingProject {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    crossingProjectDbId: ").append(toIndentedString(crossingProjectDbId)).append("\n");
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
