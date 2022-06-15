package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.Context;
import io.swagger.model.Metadata;

public class ReferenceSetsListResponse implements BrAPIResponse<ReferenceSetsListResponseResult> {
	@JsonProperty("@context")
	private Context _atContext = null;

	@JsonProperty("metadata")
	private Metadata metadata = null;

	@JsonProperty("result")
	private ReferenceSetsListResponseResult result = null;

	public ReferenceSetsListResponse _atContext(Context _atContext) {
		this._atContext = _atContext;
		return this;
	}

	public void set_atContext(Context _atContext) {
		this._atContext = _atContext;
	}

	public ReferenceSetsListResponse metadata(Metadata metadata) {
		this.metadata = metadata;
		return this;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	public ReferenceSetsListResponse result(ReferenceSetsListResponseResult result) {
		this.result = result;
		return this;
	}

	public ReferenceSetsListResponseResult getResult() {
		return result;
	}

	public void setResult(ReferenceSetsListResponseResult result) {
		this.result = result;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ReferenceSetsListResponse referenceSetsListResponse = (ReferenceSetsListResponse) o;
		return Objects.equals(this._atContext, referenceSetsListResponse._atContext)
				&& Objects.equals(this.metadata, referenceSetsListResponse.metadata)
				&& Objects.equals(this.result, referenceSetsListResponse.result);
	}

	@Override
	public int hashCode() {
		return Objects.hash(_atContext, metadata, result);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ReferenceSetsListResponse {\n");

		sb.append("    _atContext: ").append(toIndentedString(_atContext)).append("\n");
		sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
		sb.append("    result: ").append(toIndentedString(result)).append("\n");
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
