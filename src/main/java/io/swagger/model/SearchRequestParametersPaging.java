package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

public class SearchRequestParametersPaging {
	@JsonProperty("page")
	private Integer page = null;

	@JsonProperty("pageSize")
	private Integer pageSize = null;

	public SearchRequestParametersPaging page(Integer page) {
		this.page = page;
		return this;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public SearchRequestParametersPaging pageSize(Integer pageSize) {
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
		SearchRequestParametersPaging searchRequestParametersPaging = (SearchRequestParametersPaging) o;
		return Objects.equals(this.page, searchRequestParametersPaging.page)
				&& Objects.equals(this.pageSize, searchRequestParametersPaging.pageSize);
	}

	@Override
	public int hashCode() {
		return Objects.hash(page, pageSize);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class SearchRequestParametersPaging {\n");

		sb.append("    page: ").append(toIndentedString(page)).append("\n");
		sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
