package io.swagger.model.germ;

import java.time.OffsetDateTime;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CrossPollinationEvents {
	@JsonProperty("pollinationNumber")
	private String pollinationNumber = null;

	@JsonProperty("pollinationSuccessful")
	private Boolean pollinationSuccessful = null;

	@JsonProperty("pollinationTimeStamp")
	private OffsetDateTime pollinationTimeStamp = null;

	public CrossPollinationEvents pollinationNumber(String pollinationNumber) {
		this.pollinationNumber = pollinationNumber;
		return this;
	}

	public String getPollinationNumber() {
		return pollinationNumber;
	}

	public void setPollinationNumber(String pollinationNumber) {
		this.pollinationNumber = pollinationNumber;
	}

	public CrossPollinationEvents pollinationSuccessful(Boolean pollinationSuccessful) {
		this.pollinationSuccessful = pollinationSuccessful;
		return this;
	}

	public Boolean isPollinationSuccessful() {
		return pollinationSuccessful;
	}

	public void setPollinationSuccessful(Boolean pollinationSuccessful) {
		this.pollinationSuccessful = pollinationSuccessful;
	}

	public CrossPollinationEvents pollinationTimeStamp(OffsetDateTime pollinationTimeStamp) {
		this.pollinationTimeStamp = pollinationTimeStamp;
		return this;
	}

	public OffsetDateTime getPollinationTimeStamp() {
		return pollinationTimeStamp;
	}

	public void setPollinationTimeStamp(OffsetDateTime pollinationTimeStamp) {
		this.pollinationTimeStamp = pollinationTimeStamp;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CrossPollinationEvents crossPollinationEvents = (CrossPollinationEvents) o;
		return Objects.equals(this.pollinationNumber, crossPollinationEvents.pollinationNumber)
				&& Objects.equals(this.pollinationSuccessful, crossPollinationEvents.pollinationSuccessful)
				&& Objects.equals(this.pollinationTimeStamp, crossPollinationEvents.pollinationTimeStamp);
	}

	@Override
	public int hashCode() {
		return Objects.hash(pollinationNumber, pollinationSuccessful, pollinationTimeStamp);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CrossPollinationEvents {\n");

		sb.append("    pollinationNumber: ").append(toIndentedString(pollinationNumber)).append("\n");
		sb.append("    pollinationSuccessful: ").append(toIndentedString(pollinationSuccessful)).append("\n");
		sb.append("    pollinationTimeStamp: ").append(toIndentedString(pollinationTimeStamp)).append("\n");
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
