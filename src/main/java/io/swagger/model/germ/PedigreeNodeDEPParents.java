package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PedigreeNodeDEPParents {
	@JsonProperty("germplasmDbId")
	private String germplasmDbId = null;

	@JsonProperty("germplasmName")
	private String germplasmName = null;

	@JsonProperty("parentType")
	private ParentType parentType = null;

	public PedigreeNodeDEPParents germplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
		return this;
	}

	public String getGermplasmDbId() {
		return germplasmDbId;
	}

	public void setGermplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
	}

	public PedigreeNodeDEPParents germplasmName(String germplasmName) {
		this.germplasmName = germplasmName;
		return this;
	}

	public String getGermplasmName() {
		return germplasmName;
	}

	public void setGermplasmName(String germplasmName) {
		this.germplasmName = germplasmName;
	}

	public PedigreeNodeDEPParents parentType(ParentType parentType) {
		this.parentType = parentType;
		return this;
	}

	public ParentType getParentType() {
		return parentType;
	}

	public void setParentType(ParentType parentType) {
		this.parentType = parentType;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PedigreeNodeDEPParents pedigreeNodeDEPParents = (PedigreeNodeDEPParents) o;
		return Objects.equals(this.germplasmDbId, pedigreeNodeDEPParents.germplasmDbId)
				&& Objects.equals(this.germplasmName, pedigreeNodeDEPParents.germplasmName)
				&& Objects.equals(this.parentType, pedigreeNodeDEPParents.parentType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(germplasmDbId, germplasmName, parentType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PedigreeNodeDEPParents {\n");

		sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
		sb.append("    germplasmName: ").append(toIndentedString(germplasmName)).append("\n");
		sb.append("    parentType: ").append(toIndentedString(parentType)).append("\n");
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
