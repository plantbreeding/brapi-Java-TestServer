package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.Context;
import io.swagger.model.Metadata;

public class ObservationDeleteResponse implements BrAPIResponse<ObservationDeleteResponseResult>{
	@JsonProperty("@context")
	private Context _atContext = null;

	@JsonProperty("metadata")
	private Metadata metadata = null;

	@JsonProperty("result")
	private ObservationDeleteResponseResult result = null;

	public ObservationDeleteResponse _atContext(Context _atContext) {
		this._atContext = _atContext;
		return this;
	}

	public Context getAtContext() {
		return _atContext;
	}

	public void set_atContext(Context _atContext) {
		this._atContext = _atContext;
	}

	public ObservationDeleteResponse metadata(Metadata metadata) {
		this.metadata = metadata;
		return this;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	public ObservationDeleteResponse result(ObservationDeleteResponseResult result) {
		this.result = result;
		return this;
	}

	public ObservationDeleteResponseResult getResult() {
		return result;
	}

	public void setResult(ObservationDeleteResponseResult result) {
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
		ObservationDeleteResponse observationDeleteResponse = (ObservationDeleteResponse) o;
		return Objects.equals(this._atContext, observationDeleteResponse._atContext)
				&& Objects.equals(this.metadata, observationDeleteResponse.metadata)
				&& Objects.equals(this.result, observationDeleteResponse.result);
	}

	@Override
	public int hashCode() {
		return Objects.hash(_atContext, metadata, result);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ObservationDeleteResponse {\n");

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
