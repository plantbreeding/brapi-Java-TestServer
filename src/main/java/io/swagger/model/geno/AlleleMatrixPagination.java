package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.model.Pagination;

public class AlleleMatrixPagination extends Pagination{

	@JsonProperty("dimension")
	private DimensionEnum dimension = null;

	@JsonProperty("page")
	private Integer page = null;
	
	public AlleleMatrixPagination dimension(DimensionEnum dimension) {
		this.dimension = dimension;
		return this;
	}

	public DimensionEnum getDimension() {
		return dimension;
	}

	public void setDimension(DimensionEnum dimension) {
		this.dimension = dimension;
	}

	public AlleleMatrixPagination page(Integer page) {
		this.page = page;
		return this;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}


	@Override
	@JsonIgnore
	public void setCurrentPage(Integer page) {
		this.page = page;
	}

	@Override
	@JsonIgnore
	public void setCurrentPage(String pageToken) {
		this.page = Integer.parseInt(pageToken);
	}

	@Override
	@JsonIgnore
	public Integer getCurrentPage() {
		return getPage();
	}
	
	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AlleleMatrixPagination alleleMatrixPagination = (AlleleMatrixPagination) o;
		return Objects.equals(this.dimension, alleleMatrixPagination.dimension)
				&& Objects.equals(this.page, alleleMatrixPagination.page)
				&& Objects.equals(this.pageSize, alleleMatrixPagination.pageSize)
				&& Objects.equals(this.totalCount, alleleMatrixPagination.totalCount)
				&& Objects.equals(this.totalPages, alleleMatrixPagination.totalPages);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dimension, page, pageSize, totalCount, totalPages);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AlleleMatrixPagination {\n");

		sb.append("    dimension: ").append(toIndentedString(dimension)).append("\n");
		sb.append("    page: ").append(toIndentedString(page)).append("\n");
		sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
		sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
		sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	public enum DimensionEnum {
		CALLSETS("CALLSETS"),

		VARIANTS("VARIANTS");

		private String value;

		DimensionEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static DimensionEnum fromValue(String text) {
			for (DimensionEnum b : DimensionEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}
}
