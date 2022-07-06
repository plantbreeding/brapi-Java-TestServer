package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.BrAPIDataModel;
import java.util.ArrayList;
import java.util.List;

public class PedigreeNode extends BrAPIDataModel {

	@JsonProperty("breedingMethodDbId")
	private String breedingMethodDbId = null;

	@JsonProperty("breedingMethodName")
	private String breedingMethodName = null;

	@JsonProperty("crossingProjectDbId")
	private String crossingProjectDbId = null;

	@JsonProperty("crossingYear")
	private Integer crossingYear = null;

	@JsonProperty("defaultDisplayName")
	private String defaultDisplayName = null;

	@JsonProperty("familyCode")
	private String familyCode = null;

	@JsonProperty("germplasmDbId")
	private String germplasmDbId = null;

	@JsonProperty("germplasmName")
	private String germplasmName = null;

	@JsonProperty("germplasmPUI")
	private String germplasmPUI = null;

	@JsonProperty("parents")
	private List<PedigreeNodeParents> parents = null;

	@JsonProperty("pedigreeString")
	private String pedigreeString = null;

	@JsonProperty("progeny")
	private List<PedigreeNodeParents> progeny = null;

	@JsonProperty("siblings")
	private List<PedigreeNodeSiblings> siblings = null;

	public PedigreeNode breedingMethodDbId(String breedingMethodDbId) {
		this.breedingMethodDbId = breedingMethodDbId;
		return this;
	}

	public String getBreedingMethodDbId() {
		return breedingMethodDbId;
	}

	public void setBreedingMethodDbId(String breedingMethodDbId) {
		this.breedingMethodDbId = breedingMethodDbId;
	}

	public PedigreeNode breedingMethodName(String breedingMethodName) {
		this.breedingMethodName = breedingMethodName;
		return this;
	}

	public String getBreedingMethodName() {
		return breedingMethodName;
	}

	public void setBreedingMethodName(String breedingMethodName) {
		this.breedingMethodName = breedingMethodName;
	}

	public PedigreeNode crossingProjectDbId(String crossingProjectDbId) {
		this.crossingProjectDbId = crossingProjectDbId;
		return this;
	}

	public String getCrossingProjectDbId() {
		return crossingProjectDbId;
	}

	public void setCrossingProjectDbId(String crossingProjectDbId) {
		this.crossingProjectDbId = crossingProjectDbId;
	}

	public PedigreeNode crossingYear(Integer crossingYear) {
		this.crossingYear = crossingYear;
		return this;
	}

	public Integer getCrossingYear() {
		return crossingYear;
	}

	public void setCrossingYear(Integer crossingYear) {
		this.crossingYear = crossingYear;
	}

	public PedigreeNode defaultDisplayName(String defaultDisplayName) {
		this.defaultDisplayName = defaultDisplayName;
		return this;
	}

	public String getDefaultDisplayName() {
		return defaultDisplayName;
	}

	public void setDefaultDisplayName(String defaultDisplayName) {
		this.defaultDisplayName = defaultDisplayName;
	}

	public PedigreeNode familyCode(String familyCode) {
		this.familyCode = familyCode;
		return this;
	}

	public String getFamilyCode() {
		return familyCode;
	}

	public void setFamilyCode(String familyCode) {
		this.familyCode = familyCode;
	}

	public PedigreeNode germplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
		return this;
	}

	public String getGermplasmDbId() {
		return germplasmDbId;
	}

	public void setGermplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
	}

	public PedigreeNode germplasmName(String germplasmName) {
		this.germplasmName = germplasmName;
		return this;
	}

	public String getGermplasmName() {
		return germplasmName;
	}

	public void setGermplasmName(String germplasmName) {
		this.germplasmName = germplasmName;
	}

	public PedigreeNode germplasmPUI(String germplasmPUI) {
		this.germplasmPUI = germplasmPUI;
		return this;
	}

	public String getGermplasmPUI() {
		return germplasmPUI;
	}

	public void setGermplasmPUI(String germplasmPUI) {
		this.germplasmPUI = germplasmPUI;
	}

	public PedigreeNode parents(List<PedigreeNodeParents> parents) {
		this.parents = parents;
		return this;
	}

	public PedigreeNode addParentsItem(PedigreeNodeParents parentsItem) {
		if (this.parents == null) {
			this.parents = new ArrayList<PedigreeNodeParents>();
		}
		this.parents.add(parentsItem);
		return this;
	}

	public List<PedigreeNodeParents> getParents() {
		return parents;
	}

	public void setParents(List<PedigreeNodeParents> parents) {
		this.parents = parents;
	}

	public PedigreeNode pedigreeString(String pedigreeString) {
		this.pedigreeString = pedigreeString;
		return this;
	}

	public String getPedigreeString() {
		return pedigreeString;
	}

	public void setPedigreeString(String pedigreeString) {
		this.pedigreeString = pedigreeString;
	}

	public PedigreeNode progeny(List<PedigreeNodeParents> progeny) {
		this.progeny = progeny;
		return this;
	}

	public PedigreeNode addProgenyItem(PedigreeNodeParents progenyItem) {
		if (this.progeny == null) {
			this.progeny = new ArrayList<PedigreeNodeParents>();
		}
		this.progeny.add(progenyItem);
		return this;
	}

	public List<PedigreeNodeParents> getProgeny() {
		return progeny;
	}

	public void setProgeny(List<PedigreeNodeParents> progeny) {
		this.progeny = progeny;
	}

	public PedigreeNode siblings(List<PedigreeNodeSiblings> siblings) {
		this.siblings = siblings;
		return this;
	}

	public PedigreeNode addSiblingsItem(PedigreeNodeSiblings siblingsItem) {
		if (this.siblings == null) {
			this.siblings = new ArrayList<PedigreeNodeSiblings>();
		}
		this.siblings.add(siblingsItem);
		return this;
	}

	public List<PedigreeNodeSiblings> getSiblings() {
		return siblings;
	}

	public void setSiblings(List<PedigreeNodeSiblings> siblings) {
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
		PedigreeNode pedigreeNode = (PedigreeNode) o;
		return Objects.equals(this.additionalInfo, pedigreeNode.additionalInfo)
				&& Objects.equals(this.breedingMethodDbId, pedigreeNode.breedingMethodDbId)
				&& Objects.equals(this.breedingMethodName, pedigreeNode.breedingMethodName)
				&& Objects.equals(this.crossingProjectDbId, pedigreeNode.crossingProjectDbId)
				&& Objects.equals(this.crossingYear, pedigreeNode.crossingYear)
				&& Objects.equals(this.defaultDisplayName, pedigreeNode.defaultDisplayName)
				&& Objects.equals(this.externalReferences, pedigreeNode.externalReferences)
				&& Objects.equals(this.familyCode, pedigreeNode.familyCode)
				&& Objects.equals(this.germplasmDbId, pedigreeNode.germplasmDbId)
				&& Objects.equals(this.germplasmName, pedigreeNode.germplasmName)
				&& Objects.equals(this.germplasmPUI, pedigreeNode.germplasmPUI)
				&& Objects.equals(this.parents, pedigreeNode.parents)
				&& Objects.equals(this.pedigreeString, pedigreeNode.pedigreeString)
				&& Objects.equals(this.progeny, pedigreeNode.progeny)
				&& Objects.equals(this.siblings, pedigreeNode.siblings);
	}

	@Override
	public int hashCode() {
		return Objects.hash(additionalInfo, breedingMethodDbId, breedingMethodName, crossingProjectDbId, crossingYear,
				defaultDisplayName, externalReferences, familyCode, germplasmDbId, germplasmName, germplasmPUI, parents,
				pedigreeString, progeny, siblings);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PedigreeNode {\n");

		sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
		sb.append("    breedingMethodDbId: ").append(toIndentedString(breedingMethodDbId)).append("\n");
		sb.append("    breedingMethodName: ").append(toIndentedString(breedingMethodName)).append("\n");
		sb.append("    crossingProjectDbId: ").append(toIndentedString(crossingProjectDbId)).append("\n");
		sb.append("    crossingYear: ").append(toIndentedString(crossingYear)).append("\n");
		sb.append("    defaultDisplayName: ").append(toIndentedString(defaultDisplayName)).append("\n");
		sb.append("    externalReferences: ").append(toIndentedString(externalReferences)).append("\n");
		sb.append("    familyCode: ").append(toIndentedString(familyCode)).append("\n");
		sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
		sb.append("    germplasmName: ").append(toIndentedString(germplasmName)).append("\n");
		sb.append("    germplasmPUI: ").append(toIndentedString(germplasmPUI)).append("\n");
		sb.append("    parents: ").append(toIndentedString(parents)).append("\n");
		sb.append("    pedigreeString: ").append(toIndentedString(pedigreeString)).append("\n");
		sb.append("    progeny: ").append(toIndentedString(progeny)).append("\n");
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
