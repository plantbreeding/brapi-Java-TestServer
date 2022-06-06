package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PedigreeNodeDEPSiblings {
	@JsonProperty("germplasmDbId")
	private String germplasmDbId = null;

	@JsonProperty("germplasmName")
	private String germplasmName = null;

	public PedigreeNodeDEPSiblings germplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
		return this;
	}

	public String getGermplasmDbId() {
		return germplasmDbId;
	}

	public void setGermplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
	}

	public PedigreeNodeDEPSiblings germplasmName(String germplasmName) {
		this.germplasmName = germplasmName;
		return this;
	}

	public String getGermplasmName() {
		return germplasmName;
	}

	public void setGermplasmName(String germplasmName) {
		this.germplasmName = germplasmName;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PedigreeNodeDEPSiblings pedigreeNodeDEPSiblings = (PedigreeNodeDEPSiblings) o;
		return Objects.equals(this.germplasmDbId, pedigreeNodeDEPSiblings.germplasmDbId)
				&& Objects.equals(this.germplasmName, pedigreeNodeDEPSiblings.germplasmName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(germplasmDbId, germplasmName);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PedigreeNodeDEPSiblings {\n");

		sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
		sb.append("    germplasmName: ").append(toIndentedString(germplasmName)).append("\n");
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
