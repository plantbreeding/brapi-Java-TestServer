package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.BrAPIResponseResult;

import java.util.ArrayList;
import java.util.List;

public class PedigreeListResponseResult implements BrAPIResponseResult<PedigreeNode> {
	@JsonProperty("data")
	private List<PedigreeNode> data = new ArrayList<PedigreeNode>();

	public PedigreeListResponseResult data(List<PedigreeNode> data) {
		this.data = data;
		return this;
	}

	public PedigreeListResponseResult addDataItem(PedigreeNode dataItem) {
		this.data.add(dataItem);
		return this;
	}

	public List<PedigreeNode> getData() {
		return data;
	}

	public void setData(List<PedigreeNode> data) {
		this.data = data;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PedigreeListResponseResult pedigreeListResponseResult = (PedigreeListResponseResult) o;
		return Objects.equals(this.data, pedigreeListResponseResult.data);
	}

	@Override
	public int hashCode() {
		return Objects.hash(data);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PedigreeListResponseResult {\n");

		sb.append("    data: ").append(toIndentedString(data)).append("\n");
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
