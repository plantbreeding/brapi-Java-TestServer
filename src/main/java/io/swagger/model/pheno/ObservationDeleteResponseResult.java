package io.swagger.model.pheno;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.BrAPIResponseResult;

import java.util.ArrayList;
import java.util.List;

public class ObservationDeleteResponseResult implements BrAPIResponseResult<String> {
	@JsonProperty("observationDbIds")
	private List<String> observationDbIds = new ArrayList<String>();

	public ObservationDeleteResponseResult observationDbIds(List<String> observationDbIds) {
		this.observationDbIds = observationDbIds;
		return this;
	}

	public ObservationDeleteResponseResult addObservationDbIdsItem(String observationDbIdsItem) {
		this.observationDbIds.add(observationDbIdsItem);
		return this;
	}

	public List<String> getObservationDbIds() {
		return observationDbIds;
	}

	public void setObservationDbIds(List<String> observationDbIds) {
		this.observationDbIds = observationDbIds;
	}

	@Override
	@JsonIgnore
	public List<String> getData() {
		return observationDbIds;
	}

	@Override
	@JsonIgnore
	public void setData(List<String> data) {
		this.observationDbIds = data;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ObservationDeleteResponseResult observationDeleteResponseResult = (ObservationDeleteResponseResult) o;
		return Objects.equals(this.observationDbIds, observationDeleteResponseResult.observationDbIds);
	}

	@Override
	public int hashCode() {
		return Objects.hash(observationDbIds);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ObservationDeleteResponseResult {\n");

		sb.append("    observationDbIds: ").append(toIndentedString(observationDbIds)).append("\n");
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
