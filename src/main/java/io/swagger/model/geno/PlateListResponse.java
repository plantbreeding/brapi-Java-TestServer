package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.model.BrAPIResponse;
import io.swagger.model.Context;
import io.swagger.model.Metadata;

public class PlateListResponse implements BrAPIResponse<PlateListResponseResult> {
	@JsonProperty("@context")
	private Context _atContext = null;

	@JsonProperty("metadata")
	private Metadata metadata = null;

	@JsonProperty("result")
	private PlateListResponseResult result = null;

	public PlateListResponse _atContext(Context _atContext) {
		this._atContext = _atContext;
		return this;
	}

	public Context getAtContext() {
		return _atContext;
	}

	public void set_atContext(Context _atContext) {
		this._atContext = _atContext;
	}

	public PlateListResponse metadata(Metadata metadata) {
		this.metadata = metadata;
		return this;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	public PlateListResponse result(PlateListResponseResult result) {
		this.result = result;
		return this;
	}

	public PlateListResponseResult getResult() {
		return result;
	}

	public void setResult(PlateListResponseResult result) {
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
		PlateListResponse plateListResponse = (PlateListResponse) o;
		return Objects.equals(this._atContext, plateListResponse._atContext)
				&& Objects.equals(this.metadata, plateListResponse.metadata)
				&& Objects.equals(this.result, plateListResponse.result);
	}

	@Override
	public int hashCode() {
		return Objects.hash(_atContext, metadata, result);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PlateListResponse {\n");

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
