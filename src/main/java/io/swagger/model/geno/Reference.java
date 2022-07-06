package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.model.BrAPIDataModel;
import java.util.ArrayList;
import java.util.List;

public class Reference extends BrAPIDataModel {

	@JsonProperty("commonCropName")
	private String commonCropName = null;

	@JsonProperty("isDerived")
	private Boolean isDerived = null;

	@JsonProperty("length")
	private Integer length = null;

	@JsonProperty("md5checksum")
	private String md5checksum = null;

	@JsonProperty("referenceDbId")
	private String referenceDbId = null;

	@JsonProperty("referenceName")
	private String referenceName = null;

	@JsonProperty("referenceSetDbId")
	private String referenceSetDbId = null;

	@JsonProperty("referenceSetName")
	private String referenceSetName = null;

	@JsonProperty("sourceAccessions")
	private List<String> sourceAccessions = null;

	@JsonProperty("sourceDivergence")
	private Float sourceDivergence = null;

	@JsonProperty("sourceGermplasm")
	private List<ReferenceSourceGermplasm> sourceGermplasm = null;

	@JsonProperty("sourceURI")
	private String sourceURI = null;

	@JsonProperty("species")
	private OntologyTerm species = null;

	public Reference commonCropName(String commonCropName) {
		this.commonCropName = commonCropName;
		return this;
	}

	public String getCommonCropName() {
		return commonCropName;
	}

	public void setCommonCropName(String commonCropName) {
		this.commonCropName = commonCropName;
	}

	public Reference isDerived(Boolean isDerived) {
		this.isDerived = isDerived;
		return this;
	}

	public Boolean isIsDerived() {
		return isDerived;
	}

	public void setIsDerived(Boolean isDerived) {
		this.isDerived = isDerived;
	}

	public Reference length(Integer length) {
		this.length = length;
		return this;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Reference md5checksum(String md5checksum) {
		this.md5checksum = md5checksum;
		return this;
	}

	public String getMd5checksum() {
		return md5checksum;
	}

	public void setMd5checksum(String md5checksum) {
		this.md5checksum = md5checksum;
	}

	public Reference referenceDbId(String referenceDbId) {
		this.referenceDbId = referenceDbId;
		return this;
	}

	public String getReferenceDbId() {
		return referenceDbId;
	}

	public void setReferenceDbId(String referenceDbId) {
		this.referenceDbId = referenceDbId;
	}

	public Reference referenceName(String referenceName) {
		this.referenceName = referenceName;
		return this;
	}

	public String getReferenceName() {
		return referenceName;
	}

	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}

	public Reference referenceSetDbId(String referenceSetDbId) {
		this.referenceSetDbId = referenceSetDbId;
		return this;
	}

	public String getReferenceSetDbId() {
		return referenceSetDbId;
	}

	public void setReferenceSetDbId(String referenceSetDbId) {
		this.referenceSetDbId = referenceSetDbId;
	}

	public Reference referenceSetName(String referenceSetName) {
		this.referenceSetName = referenceSetName;
		return this;
	}

	public String getReferenceSetName() {
		return referenceSetName;
	}

	public void setReferenceSetName(String referenceSetName) {
		this.referenceSetName = referenceSetName;
	}

	public Reference sourceAccessions(List<String> sourceAccessions) {
		this.sourceAccessions = sourceAccessions;
		return this;
	}

	public Reference addSourceAccessionsItem(String sourceAccessionsItem) {
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

	public Reference sourceDivergence(Float sourceDivergence) {
		this.sourceDivergence = sourceDivergence;
		return this;
	}

	public Float getSourceDivergence() {
		return sourceDivergence;
	}

	public void setSourceDivergence(Float sourceDivergence) {
		this.sourceDivergence = sourceDivergence;
	}

	public Reference sourceGermplasm(List<ReferenceSourceGermplasm> sourceGermplasm) {
		this.sourceGermplasm = sourceGermplasm;
		return this;
	}

	public Reference addSourceGermplasmItem(ReferenceSourceGermplasm sourceGermplasmItem) {
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

	public Reference sourceURI(String sourceURI) {
		this.sourceURI = sourceURI;
		return this;
	}

	public String getSourceURI() {
		return sourceURI;
	}

	public void setSourceURI(String sourceURI) {
		this.sourceURI = sourceURI;
	}

	public Reference species(OntologyTerm species) {
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
		Reference reference = (Reference) o;
		return Objects.equals(this.additionalInfo, reference.additionalInfo)
				&& Objects.equals(this.commonCropName, reference.commonCropName)
				&& Objects.equals(this.externalReferences, reference.externalReferences)
				&& Objects.equals(this.isDerived, reference.isDerived) && Objects.equals(this.length, reference.length)
				&& Objects.equals(this.md5checksum, reference.md5checksum)
				&& Objects.equals(this.referenceDbId, reference.referenceDbId)
				&& Objects.equals(this.referenceName, reference.referenceName)
				&& Objects.equals(this.referenceSetDbId, reference.referenceSetDbId)
				&& Objects.equals(this.referenceSetName, reference.referenceSetName)
				&& Objects.equals(this.sourceAccessions, reference.sourceAccessions)
				&& Objects.equals(this.sourceDivergence, reference.sourceDivergence)
				&& Objects.equals(this.sourceGermplasm, reference.sourceGermplasm)
				&& Objects.equals(this.sourceURI, reference.sourceURI)
				&& Objects.equals(this.species, reference.species);
	}

	@Override
	public int hashCode() {
		return Objects.hash(additionalInfo, commonCropName, externalReferences, isDerived, length, md5checksum,
				referenceDbId, referenceName, referenceSetDbId, referenceSetName, sourceAccessions, sourceDivergence,
				sourceGermplasm, sourceURI, species);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Reference {\n");

		sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
		sb.append("    commonCropName: ").append(toIndentedString(commonCropName)).append("\n");
		sb.append("    externalReferences: ").append(toIndentedString(externalReferences)).append("\n");
		sb.append("    isDerived: ").append(toIndentedString(isDerived)).append("\n");
		sb.append("    length: ").append(toIndentedString(length)).append("\n");
		sb.append("    md5checksum: ").append(toIndentedString(md5checksum)).append("\n");
		sb.append("    referenceDbId: ").append(toIndentedString(referenceDbId)).append("\n");
		sb.append("    referenceName: ").append(toIndentedString(referenceName)).append("\n");
		sb.append("    referenceSetDbId: ").append(toIndentedString(referenceSetDbId)).append("\n");
		sb.append("    referenceSetName: ").append(toIndentedString(referenceSetName)).append("\n");
		sb.append("    sourceAccessions: ").append(toIndentedString(sourceAccessions)).append("\n");
		sb.append("    sourceDivergence: ").append(toIndentedString(sourceDivergence)).append("\n");
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
