package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.BrAPIDataModel;

import java.util.ArrayList;
import java.util.List;

public class ReferenceSet extends BrAPIDataModel {

	@JsonProperty("assemblyPUI")
	private String assemblyPUI = null;

	@JsonProperty("commonCropName")
	private String commonCropName = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("isDerived")
	private Boolean isDerived = null;

	@JsonProperty("md5checksum")
	private String md5checksum = null;

	@JsonProperty("referenceSetDbId")
	private String referenceSetDbId = null;

	@JsonProperty("referenceSetName")
	private String referenceSetName = null;

	@JsonProperty("sourceAccessions")
	private List<String> sourceAccessions = null;

	@JsonProperty("sourceGermplasm")
	private List<ReferenceSourceGermplasm> sourceGermplasm = null;

	@JsonProperty("sourceURI")
	private String sourceURI = null;

	@JsonProperty("species")
	private OntologyTerm species = null;

	public ReferenceSet assemblyPUI(String assemblyPUI) {
		this.assemblyPUI = assemblyPUI;
		return this;
	}

	public String getAssemblyPUI() {
		return assemblyPUI;
	}

	public void setAssemblyPUI(String assemblyPUI) {
		this.assemblyPUI = assemblyPUI;
	}

	public ReferenceSet commonCropName(String commonCropName) {
		this.commonCropName = commonCropName;
		return this;
	}

	public String getCommonCropName() {
		return commonCropName;
	}

	public void setCommonCropName(String commonCropName) {
		this.commonCropName = commonCropName;
	}

	public ReferenceSet description(String description) {
		this.description = description;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ReferenceSet isDerived(Boolean isDerived) {
		this.isDerived = isDerived;
		return this;
	}

	public Boolean isIsDerived() {
		return isDerived;
	}

	public void setIsDerived(Boolean isDerived) {
		this.isDerived = isDerived;
	}

	public ReferenceSet md5checksum(String md5checksum) {
		this.md5checksum = md5checksum;
		return this;
	}

	public String getMd5checksum() {
		return md5checksum;
	}

	public void setMd5checksum(String md5checksum) {
		this.md5checksum = md5checksum;
	}

	public ReferenceSet referenceSetDbId(String referenceSetDbId) {
		this.referenceSetDbId = referenceSetDbId;
		return this;
	}

	public String getReferenceSetDbId() {
		return referenceSetDbId;
	}

	public void setReferenceSetDbId(String referenceSetDbId) {
		this.referenceSetDbId = referenceSetDbId;
	}

	public ReferenceSet referenceSetName(String referenceSetName) {
		this.referenceSetName = referenceSetName;
		return this;
	}

	public String getReferenceSetName() {
		return referenceSetName;
	}

	public void setReferenceSetName(String referenceSetName) {
		this.referenceSetName = referenceSetName;
	}

	public ReferenceSet sourceAccessions(List<String> sourceAccessions) {
		this.sourceAccessions = sourceAccessions;
		return this;
	}

	public ReferenceSet addSourceAccessionsItem(String sourceAccessionsItem) {
		if (this.sourceAccessions == null) {
			this.sourceAccessions = new ArrayList<String>();
		}
		this.sourceAccessions.add(sourceAccessionsItem);
		return this;
	}

	public List<String> getSourceAccessions() {
		return sourceAccessions;
	}

	public void setSourceAccessions(List<String> sourceAccessions) {
		this.sourceAccessions = sourceAccessions;
	}

	public ReferenceSet sourceGermplasm(List<ReferenceSourceGermplasm> sourceGermplasm) {
		this.sourceGermplasm = sourceGermplasm;
		return this;
	}

	public ReferenceSet addSourceGermplasmItem(ReferenceSourceGermplasm sourceGermplasmItem) {
		if (this.sourceGermplasm == null) {
			this.sourceGermplasm = new ArrayList<ReferenceSourceGermplasm>();
		}
		this.sourceGermplasm.add(sourceGermplasmItem);
		return this;
	}

	public List<ReferenceSourceGermplasm> getSourceGermplasm() {
		return sourceGermplasm;
	}

	public void setSourceGermplasm(List<ReferenceSourceGermplasm> sourceGermplasm) {
		this.sourceGermplasm = sourceGermplasm;
	}

	public ReferenceSet sourceURI(String sourceURI) {
		this.sourceURI = sourceURI;
		return this;
	}

	public String getSourceURI() {
		return sourceURI;
	}

	public void setSourceURI(String sourceURI) {
		this.sourceURI = sourceURI;
	}

	public ReferenceSet species(OntologyTerm species) {
		this.species = species;
		return this;
	}

	public OntologyTerm getSpecies() {
		return species;
	}

	public void setSpecies(OntologyTerm species) {
		this.species = species;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ReferenceSet referenceSet = (ReferenceSet) o;
		return Objects.equals(this.additionalInfo, referenceSet.additionalInfo)
				&& Objects.equals(this.assemblyPUI, referenceSet.assemblyPUI)
				&& Objects.equals(this.commonCropName, referenceSet.commonCropName)
				&& Objects.equals(this.description, referenceSet.description)
				&& Objects.equals(this.externalReferences, referenceSet.externalReferences)
				&& Objects.equals(this.isDerived, referenceSet.isDerived)
				&& Objects.equals(this.md5checksum, referenceSet.md5checksum)
				&& Objects.equals(this.referenceSetDbId, referenceSet.referenceSetDbId)
				&& Objects.equals(this.referenceSetName, referenceSet.referenceSetName)
				&& Objects.equals(this.sourceAccessions, referenceSet.sourceAccessions)
				&& Objects.equals(this.sourceGermplasm, referenceSet.sourceGermplasm)
				&& Objects.equals(this.sourceURI, referenceSet.sourceURI)
				&& Objects.equals(this.species, referenceSet.species);
	}

	@Override
	public int hashCode() {
		return Objects.hash(additionalInfo, assemblyPUI, commonCropName, description, externalReferences, isDerived,
				md5checksum, referenceSetDbId, referenceSetName, sourceAccessions, sourceGermplasm, sourceURI, species);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ReferenceSet {\n");

		sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
		sb.append("    assemblyPUI: ").append(toIndentedString(assemblyPUI)).append("\n");
		sb.append("    commonCropName: ").append(toIndentedString(commonCropName)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    externalReferences: ").append(toIndentedString(externalReferences)).append("\n");
		sb.append("    isDerived: ").append(toIndentedString(isDerived)).append("\n");
		sb.append("    md5checksum: ").append(toIndentedString(md5checksum)).append("\n");
		sb.append("    referenceSetDbId: ").append(toIndentedString(referenceSetDbId)).append("\n");
		sb.append("    referenceSetName: ").append(toIndentedString(referenceSetName)).append("\n");
		sb.append("    sourceAccessions: ").append(toIndentedString(sourceAccessions)).append("\n");
		sb.append("    sourceGermplasm: ").append(toIndentedString(sourceGermplasm)).append("\n");
		sb.append("    sourceURI: ").append(toIndentedString(sourceURI)).append("\n");
		sb.append("    species: ").append(toIndentedString(species)).append("\n");
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
