package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.BrAPIDataModel;

import java.util.ArrayList;
import java.util.List;
import java.time.OffsetDateTime;

public class CallSet extends BrAPIDataModel {
	@JsonProperty("callSetDbId")
	private String callSetDbId = null;

	@JsonProperty("callSetName")
	private String callSetName = null;

	@JsonProperty("created")
	private OffsetDateTime created = null;

	@JsonProperty("sampleDbId")
	private String sampleDbId = null;

	@JsonProperty("studyDbId")
	private String studyDbId = null;

	@JsonProperty("updated")
	private OffsetDateTime updated = null;

	@JsonProperty("variantSetIds")

	private List<String> variantSetIds = null;

	public CallSet callSetDbId(String callSetDbId) {
		this.callSetDbId = callSetDbId;
		return this;
	}

	public String getCallSetDbId() {
		return callSetDbId;
	}

	public void setCallSetDbId(String callSetDbId) {
		this.callSetDbId = callSetDbId;
	}

	public CallSet callSetName(String callSetName) {
		this.callSetName = callSetName;
		return this;
	}

	public String getCallSetName() {
		return callSetName;
	}

	public void setCallSetName(String callSetName) {
		this.callSetName = callSetName;
	}

	public CallSet created(OffsetDateTime created) {
		this.created = created;
		return this;
	}

	public OffsetDateTime getCreated() {
		return created;
	}

	public void setCreated(OffsetDateTime created) {
		this.created = created;
	}

	public CallSet sampleDbId(String sampleDbId) {
		this.sampleDbId = sampleDbId;
		return this;
	}

	public String getSampleDbId() {
		return sampleDbId;
	}

	public void setSampleDbId(String sampleDbId) {
		this.sampleDbId = sampleDbId;
	}

	public CallSet studyDbId(String studyDbId) {
		this.studyDbId = studyDbId;
		return this;
	}

	public String getStudyDbId() {
		return studyDbId;
	}

	public void setStudyDbId(String studyDbId) {
		this.studyDbId = studyDbId;
	}

	public CallSet updated(OffsetDateTime updated) {
		this.updated = updated;
		return this;
	}

	public OffsetDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(OffsetDateTime updated) {
		this.updated = updated;
	}

	public CallSet variantSetIds(List<String> variantSetIds) {
		this.variantSetIds = variantSetIds;
		return this;
	}

	public CallSet addVariantSetIdsItem(String variantSetIdsItem) {
		if (this.variantSetIds == null) {
			this.variantSetIds = new ArrayList<String>();
		}
		this.variantSetIds.add(variantSetIdsItem);
		return this;
	}

	public List<String> getVariantSetIds() {
		return variantSetIds;
	}

	public void setVariantSetIds(List<String> variantSetIds) {
		this.variantSetIds = variantSetIds;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CallSet callSet = (CallSet) o;
		return Objects.equals(this.additionalInfo, callSet.additionalInfo)
				&& Objects.equals(this.callSetDbId, callSet.callSetDbId)
				&& Objects.equals(this.callSetName, callSet.callSetName)
				&& Objects.equals(this.created, callSet.created) && Objects.equals(this.sampleDbId, callSet.sampleDbId)
				&& Objects.equals(this.studyDbId, callSet.studyDbId) && Objects.equals(this.updated, callSet.updated)
				&& Objects.equals(this.variantSetIds, callSet.variantSetIds);
	}

	@Override
	public int hashCode() {
		return Objects.hash(additionalInfo, callSetDbId, callSetName, created, sampleDbId, studyDbId, updated,
				variantSetIds);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CallSet {\n");

		sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
		sb.append("    callSetDbId: ").append(toIndentedString(callSetDbId)).append("\n");
		sb.append("    callSetName: ").append(toIndentedString(callSetName)).append("\n");
		sb.append("    created: ").append(toIndentedString(created)).append("\n");
		sb.append("    sampleDbId: ").append(toIndentedString(sampleDbId)).append("\n");
		sb.append("    studyDbId: ").append(toIndentedString(studyDbId)).append("\n");
		sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
		sb.append("    variantSetIds: ").append(toIndentedString(variantSetIds)).append("\n");
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
