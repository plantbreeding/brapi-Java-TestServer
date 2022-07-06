package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class PedigreeNodeDEP {
	@JsonProperty("crossingProjectDbId")
	private String crossingProjectDbId = null;

	@JsonProperty("crossingYear")
	private Integer crossingYear = null;

	@JsonProperty("familyCode")
	private String familyCode = null;

	@JsonProperty("germplasmDbId")
	private String germplasmDbId = null;

	@JsonProperty("germplasmName")
	private String germplasmName = null;

	@JsonProperty("parents")

	private List<PedigreeNodeDEPParents> parents = null;

	@JsonProperty("pedigree")
	private String pedigree = null;

	@JsonProperty("siblings")

	private List<PedigreeNodeDEPSiblings> siblings = null;

	public PedigreeNodeDEP crossingProjectDbId(String crossingProjectDbId) {
		this.crossingProjectDbId = crossingProjectDbId;
		return this;
	}

	public String getCrossingProjectDbId() {
		return crossingProjectDbId;
	}

	public void setCrossingProjectDbId(String crossingProjectDbId) {
		this.crossingProjectDbId = crossingProjectDbId;
	}

	public PedigreeNodeDEP crossingYear(Integer crossingYear) {
		this.crossingYear = crossingYear;
		return this;
	}

	public Integer getCrossingYear() {
		return crossingYear;
	}

	public void setCrossingYear(Integer crossingYear) {
		this.crossingYear = crossingYear;
	}

	public PedigreeNodeDEP familyCode(String familyCode) {
		this.familyCode = familyCode;
		return this;
	}

	public String getFamilyCode() {
		return familyCode;
	}

	public void setFamilyCode(String familyCode) {
		this.familyCode = familyCode;
	}

	public PedigreeNodeDEP germplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
		return this;
	}

	public String getGermplasmDbId() {
		return germplasmDbId;
	}

	public void setGermplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
	}

	public PedigreeNodeDEP germplasmName(String germplasmName) {
		this.germplasmName = germplasmName;
		return this;
	}

	public String getGermplasmName() {
		return germplasmName;
	}

	public void setGermplasmName(String germplasmName) {
		this.germplasmName = germplasmName;
	}

	public PedigreeNodeDEP parents(List<PedigreeNodeDEPParents> parents) {
		this.parents = parents;
		return this;
	}

	public PedigreeNodeDEP addParentsItem(PedigreeNodeDEPParents parentsItem) {
		if (this.parents == null) {
			this.parents = new ArrayList<PedigreeNodeDEPParents>();
		}
		this.parents.add(parentsItem);
		return this;
	}

	public List<PedigreeNodeDEPParents> getParents() {
		return parents;
	}

	public void setParents(List<PedigreeNodeDEPParents> parents) {
		this.parents = parents;
	}

	public PedigreeNodeDEP pedigree(String pedigree) {
		this.pedigree = pedigree;
		return this;
	}

	public String getPedigree() {
		return pedigree;
	}

	public void setPedigree(String pedigree) {
		this.pedigree = pedigree;
	}

	public PedigreeNodeDEP siblings(List<PedigreeNodeDEPSiblings> siblings) {
		this.siblings = siblings;
		return this;
	}

	public PedigreeNodeDEP addSiblingsItem(PedigreeNodeDEPSiblings siblingsItem) {
		if (this.siblings == null) {
			this.siblings = new ArrayList<PedigreeNodeDEPSiblings>();
		}
		this.siblings.add(siblingsItem);
		return this;
	}

	public List<PedigreeNodeDEPSiblings> getSiblings() {
		return siblings;
	}

	public void setSiblings(List<PedigreeNodeDEPSiblings> siblings) {
		this.siblings = siblings;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PedigreeNodeDEP pedigreeNodeDEP = (PedigreeNodeDEP) o;
		return Objects.equals(this.crossingProjectDbId, pedigreeNodeDEP.crossingProjectDbId)
				&& Objects.equals(this.crossingYear, pedigreeNodeDEP.crossingYear)
				&& Objects.equals(this.familyCode, pedigreeNodeDEP.familyCode)
				&& Objects.equals(this.germplasmDbId, pedigreeNodeDEP.germplasmDbId)
				&& Objects.equals(this.germplasmName, pedigreeNodeDEP.germplasmName)
				&& Objects.equals(this.parents, pedigreeNodeDEP.parents)
				&& Objects.equals(this.pedigree, pedigreeNodeDEP.pedigree)
				&& Objects.equals(this.siblings, pedigreeNodeDEP.siblings);
	}

	@Override
	public int hashCode() {
		return Objects.hash(crossingProjectDbId, crossingYear, familyCode, germplasmDbId, germplasmName, parents,
				pedigree, siblings);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PedigreeNodeDEP {\n");

		sb.append("    crossingProjectDbId: ").append(toIndentedString(crossingProjectDbId)).append("\n");
		sb.append("    crossingYear: ").append(toIndentedString(crossingYear)).append("\n");
		sb.append("    familyCode: ").append(toIndentedString(familyCode)).append("\n");
		sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
		sb.append("    germplasmName: ").append(toIndentedString(germplasmName)).append("\n");
		sb.append("    parents: ").append(toIndentedString(parents)).append("\n");
		sb.append("    pedigree: ").append(toIndentedString(pedigree)).append("\n");
		sb.append("    siblings: ").append(toIndentedString(siblings)).append("\n");
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
