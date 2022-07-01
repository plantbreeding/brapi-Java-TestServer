package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.model.geno.AlleleMatrixPagination.DimensionEnum;

public class AlleleMatrixSearchRequestPagination {

	@JsonProperty("dimension")
	private DimensionEnum dimension = null;

	@JsonProperty("page")
	private Integer page = 0;

	@JsonProperty("pageSize")
	private Integer pageSize = 1000;

	public AlleleMatrixSearchRequestPagination dimension(DimensionEnum dimension) {
		this.dimension = dimension;
		return this;
	}

	public DimensionEnum getDimension() {
		return dimension;
	}

	public void setDimension(DimensionEnum dimension) {
		this.dimension = dimension;
	}

	public AlleleMatrixSearchRequestPagination page(Integer page) {
		this.page = page;
		return this;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public AlleleMatrixSearchRequestPagination pageSize(Integer pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AlleleMatrixSearchRequestPagination alleleMatrixSearchRequestPagination = (AlleleMatrixSearchRequestPagination) o;
		return Objects.equals(this.dimension, alleleMatrixSearchRequestPagination.dimension)
				&& Objects.equals(this.page, alleleMatrixSearchRequestPagination.page)
				&& Objects.equals(this.pageSize, alleleMatrixSearchRequestPagination.pageSize);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dimension, page, pageSize);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AlleleMatrixSearchRequestPagination {\n");

		sb.append("    dimension: ").append(toIndentedString(dimension)).append("\n");
		sb.append("    page: ").append(toIndentedString(page)).append("\n");
		sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
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
