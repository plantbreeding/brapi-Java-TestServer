package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.BrAPIResponseResult;

import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
public class VariantSetsListResponseResult implements BrAPIResponseResult<VariantSet> {
	@JsonProperty("data")

	private List<VariantSet> data = new ArrayList<VariantSet>();

	public VariantSetsListResponseResult data(List<VariantSet> data) {
		this.data = data;
		return this;
	}

	public VariantSetsListResponseResult addDataItem(VariantSet dataItem) {
		this.data.add(dataItem);
		return this;
	}

	public List<VariantSet> getData() {
		return data;
	}

	public void setData(List<VariantSet> data) {
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
		VariantSetsListResponseResult variantSetsListResponseResult = (VariantSetsListResponseResult) o;
		return Objects.equals(this.data, variantSetsListResponseResult.data);
	}

	@Override
	public int hashCode() {
		return Objects.hash(data);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class VariantSetsListResponseResult {\n");

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
