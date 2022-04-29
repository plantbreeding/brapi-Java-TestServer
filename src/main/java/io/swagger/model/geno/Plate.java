package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

public class Plate {
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
	
	@JsonProperty("plateName")
	private String plateName = null;

	public Plate plateName(String plateName) {
		this.plateName = plateName;
		return this;
	}

	public String getPlateName() {
		return plateName;
	}

	public void setPlateName(String plateName) {
		this.plateName = plateName;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Plate sample = (Plate) o;
		return Objects.equals(this.plateDbId, sample.plateDbId) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(plateDbId, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Sample {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    sampleDbId: ").append(toIndentedString(plateDbId)).append("\n");
		sb.append("    plateName: ").append(toIndentedString(plateName)).append("\n");
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
