package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.SearchRequest;
import java.util.ArrayList;
import java.util.List;

public class VariantSetsSearchRequest extends SearchRequest {
	@JsonProperty("callSetDbIds")

	private List<String> callSetDbIds = null;

	@JsonProperty("commonCropNames")

	private List<String> commonCropNames = null;

	@JsonProperty("programDbIds")

	private List<String> programDbIds = null;

	@JsonProperty("programNames")

	private List<String> programNames = null;

	@JsonProperty("referenceDbIds")

	private List<String> referenceDbIds = null;

	@JsonProperty("referenceSetDbIds")

	private List<String> referenceSetDbIds = null;

	@JsonProperty("studyDbIds")

	private List<String> studyDbIds = null;

	@JsonProperty("studyNames")

	private List<String> studyNames = null;

	@JsonProperty("trialDbIds")

	private List<String> trialDbIds = null;

	@JsonProperty("trialNames")

	private List<String> trialNames = null;

	@JsonProperty("variantDbIds")

	private List<String> variantDbIds = null;

	@JsonProperty("variantSetDbIds")

	private List<String> variantSetDbIds = null;

	public VariantSetsSearchRequest callSetDbIds(List<String> callSetDbIds) {
		this.callSetDbIds = callSetDbIds;
		return this;
	}

	public VariantSetsSearchRequest addCallSetDbIdsItem(String callSetDbIdsItem) {
		if (this.callSetDbIds == null) {
			this.callSetDbIds = new ArrayList<String>();
		}
		this.callSetDbIds.add(callSetDbIdsItem);
		return this;
	}

	public List<String> getCallSetDbIds() {
		return callSetDbIds;
	}

	public void setCallSetDbIds(List<String> callSetDbIds) {
		this.callSetDbIds = callSetDbIds;
	}

	public VariantSetsSearchRequest commonCropNames(List<String> commonCropNames) {
		this.commonCropNames = commonCropNames;
		return this;
	}

	public VariantSetsSearchRequest addCommonCropNamesItem(String commonCropNamesItem) {
		if (this.commonCropNames == null) {
			this.commonCropNames = new ArrayList<String>();
		}
		this.commonCropNames.add(commonCropNamesItem);
		return this;
	}

	public List<String> getCommonCropNames() {
		return commonCropNames;
	}

	public void setCommonCropNames(List<String> commonCropNames) {
		this.commonCropNames = commonCropNames;
	}

	public VariantSetsSearchRequest programDbIds(List<String> programDbIds) {
		this.programDbIds = programDbIds;
		return this;
	}

	public VariantSetsSearchRequest addProgramDbIdsItem(String programDbIdsItem) {
		if (this.programDbIds == null) {
			this.programDbIds = new ArrayList<String>();
		}
		this.programDbIds.add(programDbIdsItem);
		return this;
	}

	public List<String> getProgramDbIds() {
		return programDbIds;
	}

	public void setProgramDbIds(List<String> programDbIds) {
		this.programDbIds = programDbIds;
	}

	public VariantSetsSearchRequest programNames(List<String> programNames) {
		this.programNames = programNames;
		return this;
	}

	public VariantSetsSearchRequest addProgramNamesItem(String programNamesItem) {
		if (this.programNames == null) {
			this.programNames = new ArrayList<String>();
		}
		this.programNames.add(programNamesItem);
		return this;
	}

	public List<String> getProgramNames() {
		return programNames;
	}

	public void setProgramNames(List<String> programNames) {
		this.programNames = programNames;
	}

	public VariantSetsSearchRequest referenceDbIds(List<String> referenceDbIds) {
		this.referenceDbIds = referenceDbIds;
		return this;
	}

	public VariantSetsSearchRequest addReferenceDbIdsItem(String referenceDbIdsItem) {
		if (this.referenceDbIds == null) {
			this.referenceDbIds = new ArrayList<String>();
		}
		this.referenceDbIds.add(referenceDbIdsItem);
		return this;
	}

	public List<String> getReferenceDbIds() {
		return referenceDbIds;
	}

	public void setReferenceDbIds(List<String> referenceDbIds) {
		this.referenceDbIds = referenceDbIds;
	}

	public VariantSetsSearchRequest referenceSetDbIds(List<String> referenceSetDbIds) {
		this.referenceSetDbIds = referenceSetDbIds;
		return this;
	}

	public VariantSetsSearchRequest addReferenceSetDbIdsItem(String referenceSetDbIdsItem) {
		if (this.referenceSetDbIds == null) {
			this.referenceSetDbIds = new ArrayList<String>();
		}
		this.referenceSetDbIds.add(referenceSetDbIdsItem);
		return this;
	}

	public List<String> getReferenceSetDbIds() {
		return referenceSetDbIds;
	}

	public void setReferenceSetDbIds(List<String> referenceSetDbIds) {
		this.referenceSetDbIds = referenceSetDbIds;
	}

	public VariantSetsSearchRequest studyDbIds(List<String> studyDbIds) {
		this.studyDbIds = studyDbIds;
		return this;
	}

	public VariantSetsSearchRequest addStudyDbIdsItem(String studyDbIdsItem) {
		if (this.studyDbIds == null) {
			this.studyDbIds = new ArrayList<String>();
		}
		this.studyDbIds.add(studyDbIdsItem);
		return this;
	}

	public List<String> getStudyDbIds() {
		return studyDbIds;
	}

	public void setStudyDbIds(List<String> studyDbIds) {
		this.studyDbIds = studyDbIds;
	}

	public VariantSetsSearchRequest studyNames(List<String> studyNames) {
		this.studyNames = studyNames;
		return this;
	}

	public VariantSetsSearchRequest addStudyNamesItem(String studyNamesItem) {
		if (this.studyNames == null) {
			this.studyNames = new ArrayList<String>();
		}
		this.studyNames.add(studyNamesItem);
		return this;
	}

	public List<String> getStudyNames() {
		return studyNames;
	}

	public void setStudyNames(List<String> studyNames) {
		this.studyNames = studyNames;
	}

	public VariantSetsSearchRequest trialDbIds(List<String> trialDbIds) {
		this.trialDbIds = trialDbIds;
		return this;
	}

	public VariantSetsSearchRequest addTrialDbIdsItem(String trialDbIdsItem) {
		if (this.trialDbIds == null) {
			this.trialDbIds = new ArrayList<String>();
		}
		this.trialDbIds.add(trialDbIdsItem);
		return this;
	}

	public List<String> getTrialDbIds() {
		return trialDbIds;
	}

	public void setTrialDbIds(List<String> trialDbIds) {
		this.trialDbIds = trialDbIds;
	}

	public VariantSetsSearchRequest trialNames(List<String> trialNames) {
		this.trialNames = trialNames;
		return this;
	}

	public VariantSetsSearchRequest addTrialNamesItem(String trialNamesItem) {
		if (this.trialNames == null) {
			this.trialNames = new ArrayList<String>();
		}
		this.trialNames.add(trialNamesItem);
		return this;
	}

	public List<String> getTrialNames() {
		return trialNames;
	}

	public void setTrialNames(List<String> trialNames) {
		this.trialNames = trialNames;
	}

	public VariantSetsSearchRequest variantDbIds(List<String> variantDbIds) {
		this.variantDbIds = variantDbIds;
		return this;
	}

	public VariantSetsSearchRequest addVariantDbIdsItem(String variantDbIdsItem) {
		if (this.variantDbIds == null) {
			this.variantDbIds = new ArrayList<String>();
		}
		this.variantDbIds.add(variantDbIdsItem);
		return this;
	}

	public List<String> getVariantDbIds() {
		return variantDbIds;
	}

	public void setVariantDbIds(List<String> variantDbIds) {
		this.variantDbIds = variantDbIds;
	}

	public VariantSetsSearchRequest variantSetDbIds(List<String> variantSetDbIds) {
		this.variantSetDbIds = variantSetDbIds;
		return this;
	}

	public VariantSetsSearchRequest addVariantSetDbIdsItem(String variantSetDbIdsItem) {
		if (this.variantSetDbIds == null) {
			this.variantSetDbIds = new ArrayList<String>();
		}
		this.variantSetDbIds.add(variantSetDbIdsItem);
		return this;
	}

	public List<String> getVariantSetDbIds() {
		return variantSetDbIds;
	}

	public void setVariantSetDbIds(List<String> variantSetDbIds) {
		this.variantSetDbIds = variantSetDbIds;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		VariantSetsSearchRequest variantSetsSearchRequest = (VariantSetsSearchRequest) o;
		return Objects.equals(this.callSetDbIds, variantSetsSearchRequest.callSetDbIds)
				&& Objects.equals(this.commonCropNames, variantSetsSearchRequest.commonCropNames)
				&& Objects.equals(this.externalReferenceIds, variantSetsSearchRequest.externalReferenceIds)
				&& Objects.equals(this.externalReferenceSources, variantSetsSearchRequest.externalReferenceSources)
				&& Objects.equals(this.page, variantSetsSearchRequest.page)
				&& Objects.equals(this.pageSize, variantSetsSearchRequest.pageSize)
				&& Objects.equals(this.programDbIds, variantSetsSearchRequest.programDbIds)
				&& Objects.equals(this.programNames, variantSetsSearchRequest.programNames)
				&& Objects.equals(this.referenceDbIds, variantSetsSearchRequest.referenceDbIds)
				&& Objects.equals(this.referenceSetDbIds, variantSetsSearchRequest.referenceSetDbIds)
				&& Objects.equals(this.studyDbIds, variantSetsSearchRequest.studyDbIds)
				&& Objects.equals(this.studyNames, variantSetsSearchRequest.studyNames)
				&& Objects.equals(this.trialDbIds, variantSetsSearchRequest.trialDbIds)
				&& Objects.equals(this.trialNames, variantSetsSearchRequest.trialNames)
				&& Objects.equals(this.variantDbIds, variantSetsSearchRequest.variantDbIds)
				&& Objects.equals(this.variantSetDbIds, variantSetsSearchRequest.variantSetDbIds);
	}

	@Override
	public int hashCode() {
		return Objects.hash(callSetDbIds, commonCropNames, externalReferenceIds, externalReferenceSources, page,
				pageSize, programDbIds, programNames, referenceDbIds, referenceSetDbIds, studyDbIds, studyNames,
				trialDbIds, trialNames, variantDbIds, variantSetDbIds);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class VariantSetsSearchRequest {\n");

		sb.append("    callSetDbIds: ").append(toIndentedString(callSetDbIds)).append("\n");
		sb.append("    commonCropNames: ").append(toIndentedString(commonCropNames)).append("\n");
		sb.append("    externalReferenceIds: ").append(toIndentedString(externalReferenceIds)).append("\n");
		sb.append("    externalReferenceSources: ").append(toIndentedString(externalReferenceSources)).append("\n");
		sb.append("    page: ").append(toIndentedString(page)).append("\n");
		sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
		sb.append("    programDbIds: ").append(toIndentedString(programDbIds)).append("\n");
		sb.append("    programNames: ").append(toIndentedString(programNames)).append("\n");
		sb.append("    referenceDbIds: ").append(toIndentedString(referenceDbIds)).append("\n");
		sb.append("    referenceSetDbIds: ").append(toIndentedString(referenceSetDbIds)).append("\n");
		sb.append("    studyDbIds: ").append(toIndentedString(studyDbIds)).append("\n");
		sb.append("    studyNames: ").append(toIndentedString(studyNames)).append("\n");
		sb.append("    trialDbIds: ").append(toIndentedString(trialDbIds)).append("\n");
		sb.append("    trialNames: ").append(toIndentedString(trialNames)).append("\n");
		sb.append("    variantDbIds: ").append(toIndentedString(variantDbIds)).append("\n");
		sb.append("    variantSetDbIds: ").append(toIndentedString(variantSetDbIds)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	@Override
	public Integer getTotalParameterCount() {
		Integer count = 0;

		if (this.callSetDbIds != null)
			count += this.callSetDbIds.size();
		if (this.commonCropNames != null)
			count += this.commonCropNames.size();
		if (this.externalReferenceIds != null)
			count += this.externalReferenceIds.size();
		if (this.externalReferenceSources != null)
			count += this.externalReferenceSources.size();
		if (this.programDbIds != null)
			count += this.programDbIds.size();
		if (this.programNames != null)
			count += this.programNames.size();
		if (this.referenceDbIds != null)
			count += this.referenceDbIds.size();
		if (this.referenceSetDbIds != null)
			count += this.referenceSetDbIds.size();
		if (this.studyDbIds != null)
			count += this.studyDbIds.size();
		if (this.studyNames != null)
			count += this.studyNames.size();
		if (this.trialDbIds != null)
			count += this.trialDbIds.size();
		if (this.trialNames != null)
			count += this.trialNames.size();
		if (this.variantDbIds != null)
			count += this.variantDbIds.size();
		if (this.variantSetDbIds != null)
			count += this.variantSetDbIds.size();
		return count;
	}
}
