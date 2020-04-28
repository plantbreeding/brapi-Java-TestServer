package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Pagination;

import org.springframework.validation.annotation.Validated;

/**
 * TokenPagination
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class TokenPagination extends Pagination {
	@JsonProperty("currentPageToken")
	private String currentPageToken = null;

	@JsonProperty("nextPageToken")
	private String nextPageToken = null;

	@JsonProperty("prevPageToken")
	private String prevPageToken = null;

	public TokenPagination currentPageToken(String currentPageToken) {
		this.currentPageToken = currentPageToken;
		return this;
	}

	@Override
	public void setCurrentPage(Integer page) {
		this.currentPageToken = page.toString();

	}

	@Override
	public void setCurrentPage(String pageToken) {
		this.currentPageToken = pageToken;

	}

	@Override
	public Integer getCurrentPage() {
		if (currentPageToken != null)
			return Integer.parseInt(currentPageToken);
		return 0;

	}

	public String getCurrentPageToken() {
		return currentPageToken;
	}

	public void setCurrentPageToken(String currentPageToken) {
		this.currentPageToken = currentPageToken;
	}

	public TokenPagination nextPageToken(String nextPageToken) {
		this.nextPageToken = nextPageToken;
		return this;
	}

	/**
	 * The string token used to query the next page of data.
	 * 
	 * @return nextPageToken
	 **/
	@ApiModelProperty(example = "cb668f63", required = true, value = "The string token used to query the next page of data.")
	

	public String getNextPageToken() {
		return nextPageToken;
	}

	public void setNextPageToken(String nextPageToken) {
		this.nextPageToken = nextPageToken;
	}

	public TokenPagination prevPageToken(String prevPageToken) {
		this.prevPageToken = prevPageToken;
		return this;
	}

	/**
	 * The string token used to query the previous page of data.
	 * 
	 * @return prevPageToken
	 **/
	@ApiModelProperty(example = "9659857e", value = "The string token used to query the previous page of data.")

	public String getPrevPageToken() {
		return prevPageToken;
	}

	public void setPrevPageToken(String prevPageToken) {
		this.prevPageToken = prevPageToken;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		TokenPagination tokenPagination = (TokenPagination) o;
		return Objects.equals(this.currentPageToken, tokenPagination.currentPageToken)
				&& Objects.equals(this.nextPageToken, tokenPagination.nextPageToken)
				&& Objects.equals(this.prevPageToken, tokenPagination.prevPageToken) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(currentPageToken, nextPageToken, prevPageToken, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class TokenPagination {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    currentPageToken: ").append(toIndentedString(currentPageToken)).append("\n");
		sb.append("    nextPageToken: ").append(toIndentedString(nextPageToken)).append("\n");
		sb.append("    prevPageToken: ").append(toIndentedString(prevPageToken)).append("\n");
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
