package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Scale extends ScaleBaseClass {
	@JsonProperty("scaleDbId")
	private String scaleDbId = null;

	public Scale scaleDbId(String scaleDbId) {
		this.scaleDbId = scaleDbId;
		return this;
	}

	public String getScaleDbId() {
		return scaleDbId;
	}

	public void setScaleDbId(String scaleDbId) {
		this.scaleDbId = scaleDbId;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Scale scale = (Scale) o;
		return Objects.equals(this.scaleDbId, scale.scaleDbId) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(scaleDbId, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Scale {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    scaleDbId: ").append(toIndentedString(scaleDbId)).append("\n");
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
