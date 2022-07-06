package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.BrAPIDataModel;

import java.util.ArrayList;
import java.util.List;

public class VariantSet extends BrAPIDataModel {
	@JsonProperty("analysis")
	private List<Analysis> analysis = null;

	@JsonProperty("availableFormats")
	private List<VariantSetAvailableFormats> availableFormats = null;

	@JsonProperty("callSetCount")
	private Integer callSetCount = null;

	@JsonProperty("referenceSetDbId")
	private String referenceSetDbId = null;

	@JsonProperty("studyDbId")
	private String studyDbId = null;

	@JsonProperty("variantCount")
	private Integer variantCount = null;

	@JsonProperty("variantSetDbId")
	private String variantSetDbId = null;

	@JsonProperty("variantSetName")
	private String variantSetName = null;

	@JsonProperty("metadataFields")
	private List<VariantSetMetadataFields> metadataFields = null;

	public List<VariantSetMetadataFields> getMetadataFields() {
		return metadataFields;
	}

	public void setMetadataFields(List<VariantSetMetadataFields> metadataFields) {
		this.metadataFields = metadataFields;
	}

	public VariantSet addMetadataFieldsItem(VariantSetMetadataFields metadataFieldsItem) {
		if (this.metadataFields == null) {
			this.metadataFields = new ArrayList<VariantSetMetadataFields>();
		}
		this.metadataFields.add(metadataFieldsItem);
		return this;
	}

	public VariantSet analysis(List<Analysis> analysis) {
		this.analysis = analysis;
		return this;
	}

	public VariantSet addAnalysisItem(Analysis analysisItem) {
		if (this.analysis == null) {
			this.analysis = new ArrayList<Analysis>();
		}
		this.analysis.add(analysisItem);
		return this;
	}

	public List<Analysis> getAnalysis() {
		return analysis;
	}

	public void setAnalysis(List<Analysis> analysis) {
		this.analysis = analysis;
	}

	public VariantSet availableFormats(List<VariantSetAvailableFormats> availableFormats) {
		this.availableFormats = availableFormats;
		return this;
	}

	public VariantSet addAvailableFormatsItem(VariantSetAvailableFormats availableFormatsItem) {
		if (this.availableFormats == null) {
			this.availableFormats = new ArrayList<VariantSetAvailableFormats>();
		}
		this.availableFormats.add(availableFormatsItem);
		return this;
	}

	public List<VariantSetAvailableFormats> getAvailableFormats() {
		return availableFormats;
	}

	public void setAvailableFormats(List<VariantSetAvailableFormats> availableFormats) {
		this.availableFormats = availableFormats;
	}

	public VariantSet callSetCount(Integer callSetCount) {
		this.callSetCount = callSetCount;
		return this;
	}

	public Integer getCallSetCount() {
		return callSetCount;
	}

	public void setCallSetCount(Integer callSetCount) {
		this.callSetCount = callSetCount;
	}

	public VariantSet referenceSetDbId(String referenceSetDbId) {
		this.referenceSetDbId = referenceSetDbId;
		return this;
	}

	public String getReferenceSetDbId() {
		return referenceSetDbId;
	}

	public void setReferenceSetDbId(String referenceSetDbId) {
		this.referenceSetDbId = referenceSetDbId;
	}

	public VariantSet studyDbId(String studyDbId) {
		this.studyDbId = studyDbId;
		return this;
	}

	public String getStudyDbId() {
		return studyDbId;
	}

	public void setStudyDbId(String studyDbId) {
		this.studyDbId = studyDbId;
	}

	public VariantSet variantCount(Integer variantCount) {
		this.variantCount = variantCount;
		return this;
	}

	public Integer getVariantCount() {
		return variantCount;
	}

	public void setVariantCount(Integer variantCount) {
		this.variantCount = variantCount;
	}

	public VariantSet variantSetDbId(String variantSetDbId) {
		this.variantSetDbId = variantSetDbId;
		return this;
	}

	public String getVariantSetDbId() {
		return variantSetDbId;
	}

	public void setVariantSetDbId(String variantSetDbId) {
		this.variantSetDbId = variantSetDbId;
	}

	public VariantSet variantSetName(String variantSetName) {
		this.variantSetName = variantSetName;
		return this;
	}

	public String getVariantSetName() {
		return variantSetName;
	}

	public void setVariantSetName(String variantSetName) {
		this.variantSetName = variantSetName;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		VariantSet variantSet = (VariantSet) o;
		return Objects.equals(this.additionalInfo, variantSet.additionalInfo)
				&& Objects.equals(this.analysis, variantSet.analysis)
				&& Objects.equals(this.availableFormats, variantSet.availableFormats)
				&& Objects.equals(this.callSetCount, variantSet.callSetCount)
				&& Objects.equals(this.referenceSetDbId, variantSet.referenceSetDbId)
				&& Objects.equals(this.studyDbId, variantSet.studyDbId)
				&& Objects.equals(this.variantCount, variantSet.variantCount)
				&& Objects.equals(this.variantSetDbId, variantSet.variantSetDbId)
				&& Objects.equals(this.variantSetName, variantSet.variantSetName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(additionalInfo, analysis, availableFormats, callSetCount, referenceSetDbId, studyDbId,
				variantCount, variantSetDbId, variantSetName);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class VariantSet {\n");

		sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
		sb.append("    analysis: ").append(toIndentedString(analysis)).append("\n");
		sb.append("    availableFormats: ").append(toIndentedString(availableFormats)).append("\n");
		sb.append("    callSetCount: ").append(toIndentedString(callSetCount)).append("\n");
		sb.append("    referenceSetDbId: ").append(toIndentedString(referenceSetDbId)).append("\n");
		sb.append("    studyDbId: ").append(toIndentedString(studyDbId)).append("\n");
		sb.append("    variantCount: ").append(toIndentedString(variantCount)).append("\n");
		sb.append("    variantSetDbId: ").append(toIndentedString(variantSetDbId)).append("\n");
		sb.append("    variantSetName: ").append(toIndentedString(variantSetName)).append("\n");
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
