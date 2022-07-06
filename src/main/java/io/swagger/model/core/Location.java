package io.swagger.model.core;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Location extends LocationNewRequest {
	@JsonProperty("locationDbId")
	private String locationDbId = null;

	public Location locationDbId(String locationDbId) {
		this.locationDbId = locationDbId;
		return this;
	}

	public String getLocationDbId() {
		return locationDbId;
	}

	public void setLocationDbId(String locationDbId) {
		this.locationDbId = locationDbId;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Location location = (Location) o;
		return Objects.equals(this.locationDbId, location.locationDbId) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(locationDbId, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Location {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    locationDbId: ").append(toIndentedString(locationDbId)).append("\n");
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
