package io.swagger.model.pheno;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ObservationUnitHierarchyLevel {

	@JsonProperty("levelName")
	private ObservationUnitHierarchyLevelEnum levelName = null;

	@JsonProperty("levelOrder")
	private Integer levelOrder = null;

	public ObservationUnitHierarchyLevel levelName(ObservationUnitHierarchyLevelEnum levelName) {
		this.levelName = levelName;
		return this;
	}

	public ObservationUnitHierarchyLevelEnum getLevelName() {
		return levelName;
	}

	public void setLevelName(ObservationUnitHierarchyLevelEnum levelName) {
		this.levelName = levelName;
	}

	public ObservationUnitHierarchyLevel levelOrder(Integer levelOrder) {
		this.levelOrder = levelOrder;
		return this;
	}

	public Integer getLevelOrder() {
		return levelOrder;
	}

	public void setLevelOrder(Integer levelOrder) {
		this.levelOrder = levelOrder;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ObservationUnitHierarchyLevel observationUnitHierarchyLevel = (ObservationUnitHierarchyLevel) o;
		return Objects.equals(this.levelName, observationUnitHierarchyLevel.levelName)
				&& Objects.equals(this.levelOrder, observationUnitHierarchyLevel.levelOrder);
	}

	@Override
	public int hashCode() {
		return Objects.hash(levelName, levelOrder);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ObservationUnitHierarchyLevel {\n");

		sb.append("    levelName: ").append(toIndentedString(levelName)).append("\n");
		sb.append("    levelOrder: ").append(toIndentedString(levelOrder)).append("\n");
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
