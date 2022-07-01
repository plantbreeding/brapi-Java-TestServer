package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Germplasm extends GermplasmNewRequest {
	@JsonProperty("germplasmDbId")
	private String germplasmDbId = null;

	public Germplasm germplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
		return this;
	}

	public String getGermplasmDbId() {
		return germplasmDbId;
	}

	public void setGermplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Germplasm germplasm = (Germplasm) o;
		return Objects.equals(this.germplasmDbId, germplasm.germplasmDbId) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(germplasmDbId, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Germplasm {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
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
