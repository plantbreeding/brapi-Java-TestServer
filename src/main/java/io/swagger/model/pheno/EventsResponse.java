package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.Context;
import io.swagger.model.Metadata;

public class EventsResponse implements BrAPIResponse<EventsResponseResult> {
	@JsonProperty("@context")
	private Context _atContext = null;

	@JsonProperty("metadata")
	private Metadata metadata = null;

	@JsonProperty("result")
	private EventsResponseResult result = null;

	public EventsResponse _atContext(Context _atContext) {
		this._atContext = _atContext;
		return this;
	}

	public void set_atContext(Context _atContext) {
		this._atContext = _atContext;
	}

	public EventsResponse metadata(Metadata metadata) {
		this.metadata = metadata;
		return this;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	public EventsResponse result(EventsResponseResult result) {
		this.result = result;
		return this;
	}

	public EventsResponseResult getResult() {
		return result;
	}

	public void setResult(EventsResponseResult result) {
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
		EventsResponse eventsResponse = (EventsResponse) o;
		return Objects.equals(this._atContext, eventsResponse._atContext)
				&& Objects.equals(this.metadata, eventsResponse.metadata)
				&& Objects.equals(this.result, eventsResponse.result);
	}

	@Override
	public int hashCode() {
		return Objects.hash(_atContext, metadata, result);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class EventsResponse {\n");

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
