package io.swagger.model.core;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.model.BrAPIResponse;
import io.swagger.model.Context;
import io.swagger.model.Metadata;

public class ListsSingleResponse implements BrAPIResponse<ListDetails> {
	@JsonProperty("@context")
	private Context _atContext = null;

	@JsonProperty("metadata")
	private Metadata metadata = null;

	@JsonProperty("result")
	private ListDetails result = null;

	public ListsSingleResponse() {
		this._atContext = new Context();
		this._atContext.add("context");
	}

	public ListsSingleResponse metadata(Metadata metadata) {
		this.metadata = metadata;
		return this;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	public ListsSingleResponse result(ListDetails result) {
		this.result = result;
		return this;
	}

	public ListDetails getResult() {
		return result;
	}

	public void setResult(ListDetails result) {
		this.result = result;
	}

	@Override
	public void set_atContext(Context _atContext) {
		this._atContext = _atContext;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ListsSingleResponse listsSingleResponse = (ListsSingleResponse) o;
		return Objects.equals(this._atContext, listsSingleResponse._atContext)
				&& Objects.equals(this.metadata, listsSingleResponse.metadata)
				&& Objects.equals(this.result, listsSingleResponse.result);
	}

	@Override
	public int hashCode() {
		return Objects.hash(_atContext, metadata, result);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ListsSingleResponse {\n");

		sb.append("    _atContext: ").append(toIndentedString(_atContext)).append("\n");
		sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
		sb.append("    result: ").append(toIndentedString(result)).append("\n");
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
