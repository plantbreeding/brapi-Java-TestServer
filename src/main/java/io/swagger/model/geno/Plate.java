package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Plate extends PlateNewRequest {

	@JsonProperty("plateDbId")
	private String plateDbId = null;

	public Plate plateDbId(String plateDbId) {
		this.plateDbId = plateDbId;
		return this;
	}

	public String getPlateDbId() {
		return plateDbId;
	}

	public void setPlateDbId(String plateDbId) {
		this.plateDbId = plateDbId;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Plate plate = (Plate) o;
		return Objects.equals(this.additionalInfo, plate.additionalInfo)
				&& Objects.equals(this.externalReferences, plate.externalReferences)
				&& Objects.equals(this.plateDbId, plate.plateDbId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(additionalInfo, externalReferences, plateDbId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Plate {\n");

		sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
		sb.append("    externalReferences: ").append(toIndentedString(externalReferences)).append("\n");
		sb.append("    plateDbId: ").append(toIndentedString(plateDbId)).append("\n");
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
