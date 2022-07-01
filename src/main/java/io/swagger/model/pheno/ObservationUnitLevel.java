package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ObservationUnitLevel extends ObservationUnitHierarchyLevel {
	@JsonProperty("levelCode")
	private String levelCode = null;

	public String getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObservationUnitLevel other = (ObservationUnitLevel) obj;
		return Objects.equals(levelCode, other.levelCode);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(levelCode);
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ObservationUnitLevelRelationship {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    levelCode: ").append(toIndentedString(levelCode)).append("\n");
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
