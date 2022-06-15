package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.BrAPIResponseResult;
import java.util.ArrayList;
import java.util.List;

public class PlateListResponseResult implements BrAPIResponseResult<Plate> {
	@JsonProperty("data")
	private List<Plate> data = new ArrayList<Plate>();

	public PlateListResponseResult data(List<Plate> data) {
		this.data = data;
		return this;
	}

	public PlateListResponseResult addDataItem(Plate dataItem) {
		this.data.add(dataItem);
		return this;
	}

	public List<Plate> getData() {
		return data;
	}

	public void setData(List<Plate> data) {
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
		PlateListResponseResult plateListResponseResult = (PlateListResponseResult) o;
		return Objects.equals(this.data, plateListResponseResult.data);
	}

	@Override
	public int hashCode() {
		return Objects.hash(data);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PlateListResponseResult {\n");

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
