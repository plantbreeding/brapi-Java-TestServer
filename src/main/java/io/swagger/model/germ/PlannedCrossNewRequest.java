package io.swagger.model.germ;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.model.BrAPIDataModel;

public class PlannedCrossNewRequest extends BrAPIDataModel implements CrossInterface {

	@JsonProperty("crossType")
	private CrossType crossType = null;

	@JsonProperty("crossingProjectDbId")
	private String crossingProjectDbId = null;

	@JsonProperty("crossingProjectName")
	private String crossingProjectName = null;

	@JsonProperty("parent1")
	private CrossParent parent1 = null;

	@JsonProperty("parent2")
	private CrossParent parent2 = null;

	@JsonProperty("plannedCrossName")
	private String plannedCrossName = null;

	@JsonProperty("status")
	private PlannedCrossStatusEnum status = null;

	public PlannedCrossStatusEnum getStatus() {
		return status;
	}

	public void setStatus(PlannedCrossStatusEnum status) {
		this.status = status;
	}

	public PlannedCrossNewRequest crossType(CrossType crossType) {
		this.crossType = crossType;
		return this;
	}

	public CrossType getCrossType() {
		return crossType;
	}

	public void setCrossType(CrossType crossType) {
		this.crossType = crossType;
	}

	public PlannedCrossNewRequest crossingProjectDbId(String crossingProjectDbId) {
		this.crossingProjectDbId = crossingProjectDbId;
		return this;
	}

	public String getCrossingProjectDbId() {
		return crossingProjectDbId;
	}

	public void setCrossingProjectDbId(String crossingProjectDbId) {
		this.crossingProjectDbId = crossingProjectDbId;
	}

	public PlannedCrossNewRequest crossingProjectName(String crossingProjectName) {
		this.crossingProjectName = crossingProjectName;
		return this;
	}

	public String getCrossingProjectName() {
		return crossingProjectName;
	}

	public void setCrossingProjectName(String crossingProjectName) {
		this.crossingProjectName = crossingProjectName;
	}

	public PlannedCrossNewRequest parent1(CrossParent parent1) {
		this.parent1 = parent1;
		return this;
	}

	public CrossParent getParent1() {
		return parent1;
	}

	public void setParent1(CrossParent parent1) {
		this.parent1 = parent1;
	}

	public PlannedCrossNewRequest parent2(CrossParent parent2) {
		this.parent2 = parent2;
		return this;
	}

	public CrossParent getParent2() {
		return parent2;
	}

	public void setParent2(CrossParent parent2) {
		this.parent2 = parent2;
	}

	public PlannedCrossNewRequest plannedCrossName(String plannedCrossName) {
		this.plannedCrossName = plannedCrossName;
		return this;
	}

	public String getPlannedCrossName() {
		return plannedCrossName;
	}

	public void setPlannedCrossName(String plannedCrossName) {
		this.plannedCrossName = plannedCrossName;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PlannedCrossNewRequest plannedCrossNewRequest = (PlannedCrossNewRequest) o;
		return Objects.equals(this.additionalInfo, plannedCrossNewRequest.additionalInfo)
				&& Objects.equals(this.crossType, plannedCrossNewRequest.crossType)
				&& Objects.equals(this.crossingProjectDbId, plannedCrossNewRequest.crossingProjectDbId)
				&& Objects.equals(this.crossingProjectName, plannedCrossNewRequest.crossingProjectName)
				&& Objects.equals(this.externalReferences, plannedCrossNewRequest.externalReferences)
				&& Objects.equals(this.parent1, plannedCrossNewRequest.parent1)
				&& Objects.equals(this.parent2, plannedCrossNewRequest.parent2)
				&& Objects.equals(this.plannedCrossName, plannedCrossNewRequest.plannedCrossName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(additionalInfo, crossType, crossingProjectDbId, crossingProjectName, externalReferences,
				parent1, parent2, plannedCrossName);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PlannedCrossNewRequest {\n");

		sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
		sb.append("    crossType: ").append(toIndentedString(crossType)).append("\n");
		sb.append("    crossingProjectDbId: ").append(toIndentedString(crossingProjectDbId)).append("\n");
		sb.append("    crossingProjectName: ").append(toIndentedString(crossingProjectName)).append("\n");
		sb.append("    externalReferences: ").append(toIndentedString(externalReferences)).append("\n");
		sb.append("    parent1: ").append(toIndentedString(parent1)).append("\n");
		sb.append("    parent2: ").append(toIndentedString(parent2)).append("\n");
		sb.append("    plannedCrossName: ").append(toIndentedString(plannedCrossName)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	public enum PlannedCrossStatusEnum {
		TODO("TODO"),

		DONE("DONE"),

		SKIPPED("SKIPPED");

		private String value;

		PlannedCrossStatusEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static PlannedCrossStatusEnum fromValue(String text) {
			for (PlannedCrossStatusEnum b : PlannedCrossStatusEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}
}
