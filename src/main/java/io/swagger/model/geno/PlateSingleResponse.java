package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.Context;
import io.swagger.model.Metadata;

public class PlateSingleResponse implements BrAPIResponse<Plate> {
	@JsonProperty("@context")
	private Context _atContext = null;

	@JsonProperty("metadata")
	private Metadata metadata = null;

	@JsonProperty("result")
	private Plate result = null;

	public PlateSingleResponse _atContext(Context _atContext) {
		this._atContext = _atContext;
		return this;
	}

	public Context getAtContext() {
		return _atContext;
	}

	public void set_atContext(Context _atContext) {
		this._atContext = _atContext;
	}

	public PlateSingleResponse metadata(Metadata metadata) {
		this.metadata = metadata;
		return this;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	public PlateSingleResponse result(Plate result) {
		this.result = result;
		return this;
	}

	public Plate getResult() {
		return result;
	}

	public void setResult(Plate result) {
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
		PlateSingleResponse plateSingleResponse = (PlateSingleResponse) o;
		return Objects.equals(this._atContext, plateSingleResponse._atContext)
				&& Objects.equals(this.metadata, plateSingleResponse.metadata)
				&& Objects.equals(this.result, plateSingleResponse.result);
	}

	@Override
	public int hashCode() {
		return Objects.hash(_atContext, metadata, result);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PlateSingleResponse {\n");

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
