package io.swagger.model.germ;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.BrAPIDataModel;
import java.util.ArrayList;
import java.util.List;
import java.time.OffsetDateTime;

public class CrossNewRequest extends BrAPIDataModel implements CrossInterface {
	@JsonProperty("crossAttributes")
	private List<CrossNewRequestCrossAttributes> crossAttributes = null;

	@JsonProperty("crossName")
	private String crossName = null;

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

	@JsonProperty("pollinationTimeStamp")
	private OffsetDateTime pollinationTimeStamp = null;

	@JsonProperty("pollinationEvents")
	private List<CrossPollinationEvents> pollinationEvents = null;
	
	@JsonProperty("plannedCrossDbId")
	private String plannedCrossDbId = null;
	
	@JsonProperty("plannedCrossName")
	private String plannedCrossName = null;

	public List<CrossPollinationEvents> getPollinationEvents() {
		return pollinationEvents;
	}

	public void setPollinationEvents(List<CrossPollinationEvents> pollinationEvents) {
		this.pollinationEvents = pollinationEvents;
	}

	public String getPlannedCrossName() {
		return plannedCrossName;
	}

	public void setPlannedCrossName(String plannedCrossName) {
		this.plannedCrossName = plannedCrossName;
	}

	public CrossNewRequest plannedCrossDbId(String plannedCrossDbId) {
		this.plannedCrossDbId = plannedCrossDbId;
		return this;
	}

	public String getPlannedCrossDbId() {
		return plannedCrossDbId;
	}

	public void setPlannedCrossDbId(String plannedCrossDbId) {
		this.plannedCrossDbId = plannedCrossDbId;
	}
	public CrossNewRequest crossAttributes(List<CrossNewRequestCrossAttributes> crossAttributes) {
		this.crossAttributes = crossAttributes;
		return this;
	}

	public CrossNewRequest addCrossAttributesItem(CrossNewRequestCrossAttributes crossAttributesItem) {
		if (this.crossAttributes == null) {
			this.crossAttributes = new ArrayList<CrossNewRequestCrossAttributes>();
		}
		this.crossAttributes.add(crossAttributesItem);
		return this;
	}

	public List<CrossNewRequestCrossAttributes> getCrossAttributes() {
		return crossAttributes;
	}

	public void setCrossAttributes(List<CrossNewRequestCrossAttributes> crossAttributes) {
		this.crossAttributes = crossAttributes;
	}

	public CrossNewRequest crossName(String crossName) {
		this.crossName = crossName;
		return this;
	}

	public String getCrossName() {
		return crossName;
	}

	public void setCrossName(String crossName) {
		this.crossName = crossName;
	}

	public CrossNewRequest crossType(CrossType crossType) {
		this.crossType = crossType;
		return this;
	}

	public CrossType getCrossType() {
		return crossType;
	}

	public void setCrossType(CrossType crossType) {
		this.crossType = crossType;
	}

	public CrossNewRequest crossingProjectDbId(String crossingProjectDbId) {
		this.crossingProjectDbId = crossingProjectDbId;
		return this;
	}

	public String getCrossingProjectDbId() {
		return crossingProjectDbId;
	}

	public void setCrossingProjectDbId(String crossingProjectDbId) {
		this.crossingProjectDbId = crossingProjectDbId;
	}

	public CrossNewRequest crossingProjectName(String crossingProjectName) {
		this.crossingProjectName = crossingProjectName;
		return this;
	}

	public String getCrossingProjectName() {
		return crossingProjectName;
	}

	public void setCrossingProjectName(String crossingProjectName) {
		this.crossingProjectName = crossingProjectName;
	}

	public CrossNewRequest parent1(CrossParent parent1) {
		this.parent1 = parent1;
		return this;
	}

	public CrossParent getParent1() {
		return parent1;
	}

	public void setParent1(CrossParent parent1) {
		this.parent1 = parent1;
	}

	public CrossNewRequest parent2(CrossParent parent2) {
		this.parent2 = parent2;
		return this;
	}

	public CrossParent getParent2() {
		return parent2;
	}

	public void setParent2(CrossParent parent2) {
		this.parent2 = parent2;
	}

	public CrossNewRequest pollinationTimeStamp(OffsetDateTime pollinationTimeStamp) {
		this.pollinationTimeStamp = pollinationTimeStamp;
		return this;
	}

	public OffsetDateTime getPollinationTimeStamp() {
		return pollinationTimeStamp;
	}

	public void setPollinationTimeStamp(OffsetDateTime pollinationTimeStamp) {
		this.pollinationTimeStamp = pollinationTimeStamp;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CrossNewRequest crossNewRequest = (CrossNewRequest) o;
		return Objects.equals(this.additionalInfo, crossNewRequest.additionalInfo)
				&& Objects.equals(this.crossAttributes, crossNewRequest.crossAttributes)
				&& Objects.equals(this.crossName, crossNewRequest.crossName)
				&& Objects.equals(this.crossType, crossNewRequest.crossType)
				&& Objects.equals(this.crossingProjectDbId, crossNewRequest.crossingProjectDbId)
				&& Objects.equals(this.crossingProjectName, crossNewRequest.crossingProjectName)
				&& Objects.equals(this.externalReferences, crossNewRequest.externalReferences)
				&& Objects.equals(this.parent1, crossNewRequest.parent1)
				&& Objects.equals(this.parent2, crossNewRequest.parent2)
				&& Objects.equals(this.pollinationTimeStamp, crossNewRequest.pollinationTimeStamp);
	}

	@Override
	public int hashCode() {
		return Objects.hash(additionalInfo, crossAttributes, crossName, crossType, crossingProjectDbId,
				crossingProjectName, externalReferences, parent1, parent2, pollinationTimeStamp);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CrossNewRequest {\n");

		sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
		sb.append("    crossAttributes: ").append(toIndentedString(crossAttributes)).append("\n");
		sb.append("    crossName: ").append(toIndentedString(crossName)).append("\n");
		sb.append("    crossType: ").append(toIndentedString(crossType)).append("\n");
		sb.append("    crossingProjectDbId: ").append(toIndentedString(crossingProjectDbId)).append("\n");
		sb.append("    crossingProjectName: ").append(toIndentedString(crossingProjectName)).append("\n");
		sb.append("    externalReferences: ").append(toIndentedString(externalReferences)).append("\n");
		sb.append("    parent1: ").append(toIndentedString(parent1)).append("\n");
		sb.append("    parent2: ").append(toIndentedString(parent2)).append("\n");
		sb.append("    pollinationTimeStamp: ").append(toIndentedString(pollinationTimeStamp)).append("\n");
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
