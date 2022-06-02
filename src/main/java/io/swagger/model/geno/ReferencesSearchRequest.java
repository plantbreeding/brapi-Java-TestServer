package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.model.SearchRequest;
import java.util.ArrayList;
import java.util.List;

public class ReferencesSearchRequest extends SearchRequest {
	@JsonProperty("accessions")
	private List<String> accessions = null;

	@JsonProperty("isDerived")
	private Boolean isDerived = null;

	@JsonProperty("maxLength")
	private Integer maxLength = null;

	@JsonProperty("md5checksums")
	private List<String> md5checksums = null;

	@JsonProperty("minLength")
	private Integer minLength = null;

	@JsonProperty("referenceDbIds")
	private List<String> referenceDbIds = null;

	@JsonProperty("referenceSetDbIds")
	private List<String> referenceSetDbIds = null;

	@JsonProperty("commonCropNames")
	private List<String> commonCropNames = null;

	@JsonProperty("germplasmDbIds")
	private List<String> germplasmDbIds = null;

	@JsonProperty("germplasmNames")
	private List<String> germplasmNames = null;

	@JsonProperty("programDbIds")
	private List<String> programDbIds = null;

	@JsonProperty("programNames")
	private List<String> programNames = null;

	@JsonProperty("studyDbIds")
	private List<String> studyDbIds = null;

	@JsonProperty("studyNames")
	private List<String> studyNames = null;

	@JsonProperty("trialDbIds")
	private List<String> trialDbIds = null;

	@JsonProperty("trialNames")
	private List<String> trialNames = null;

	public ReferencesSearchRequest accessions(List<String> accessions) {
		this.accessions = accessions;
		return this;
	}

	public ReferencesSearchRequest addAccessionsItem(String accessionsItem) {
		if (this.accessions == null) {
			this.accessions = new ArrayList<String>();
		}
		this.accessions.add(accessionsItem);
		return this;
	}

	public List<String> getAccessions() {
		return accessions;
	}

	public void setAccessions(List<String> accessions) {
		this.accessions = accessions;
	}

	public ReferencesSearchRequest isDerived(Boolean isDerived) {
		this.isDerived = isDerived;
		return this;
	}

	public Boolean isIsDerived() {
		return isDerived;
	}

	public void setIsDerived(Boolean isDerived) {
		this.isDerived = isDerived;
	}

	public ReferencesSearchRequest maxLength(Integer maxLength) {
		this.maxLength = maxLength;
		return this;
	}

	public Integer getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}

	public ReferencesSearchRequest md5checksums(List<String> md5checksums) {
		this.md5checksums = md5checksums;
		return this;
	}

	public ReferencesSearchRequest addMd5checksumsItem(String md5checksumsItem) {
		if (this.md5checksums == null) {
			this.md5checksums = new ArrayList<String>();
		}
		this.md5checksums.add(md5checksumsItem);
		return this;
	}

	public List<String> getMd5checksums() {
		return md5checksums;
	}

	public void setMd5checksums(List<String> md5checksums) {
		this.md5checksums = md5checksums;
	}

	public ReferencesSearchRequest minLength(Integer minLength) {
		this.minLength = minLength;
		return this;
	}

	public Integer getMinLength() {
		return minLength;
	}

	public void setMinLength(Integer minLength) {
		this.minLength = minLength;
	}

	public ReferencesSearchRequest referenceDbIds(List<String> referenceDbIds) {
		this.referenceDbIds = referenceDbIds;
		return this;
	}

	public ReferencesSearchRequest addReferenceDbIdsItem(String referenceDbIdsItem) {
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

	public ReferencesSearchRequest referenceSetDbIds(List<String> referenceSetDbIds) {
		this.referenceSetDbIds = referenceSetDbIds;
		return this;
	}

	public ReferencesSearchRequest addReferenceSetDbIdsItem(String referenceSetDbIdsItem) {
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

	public ReferencesSearchRequest commonCropNames(List<String> commonCropNames) {
		this.commonCropNames = commonCropNames;
		return this;
	}

	public ReferencesSearchRequest addCommonCropNamesItem(String commonCropNamesItem) {
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

	public ReferencesSearchRequest germplasmDbIds(List<String> germplasmDbIds) {
		this.germplasmDbIds = germplasmDbIds;
		return this;
	}

	public ReferencesSearchRequest addGermplasmDbIdsItem(String germplasmDbIdsItem) {
		if (this.germplasmDbIds == null) {
			this.germplasmDbIds = new ArrayList<String>();
		}
		this.germplasmDbIds.add(germplasmDbIdsItem);
		return this;
	}

	public List<String> getGermplasmDbIds() {
		return germplasmDbIds;
	}

	public void setGermplasmDbIds(List<String> germplasmDbIds) {
		this.germplasmDbIds = germplasmDbIds;
	}

	public ReferencesSearchRequest germplasmNames(List<String> germplasmNames) {
		this.germplasmNames = germplasmNames;
		return this;
	}

	public ReferencesSearchRequest addGermplasmNamesItem(String germplasmNamesItem) {
		if (this.germplasmNames == null) {
			this.germplasmNames = new ArrayList<String>();
		}
		this.germplasmNames.add(germplasmNamesItem);
		return this;
	}

	public List<String> getGermplasmNames() {
		return germplasmNames;
	}

	public void setGermplasmNames(List<String> germplasmNames) {
		this.germplasmNames = germplasmNames;
	}

	public ReferencesSearchRequest programDbIds(List<String> programDbIds) {
		this.programDbIds = programDbIds;
		return this;
	}

	public ReferencesSearchRequest addProgramDbIdsItem(String programDbIdsItem) {
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

	public ReferencesSearchRequest programNames(List<String> programNames) {
		this.programNames = programNames;
		return this;
	}

	public ReferencesSearchRequest addProgramNamesItem(String programNamesItem) {
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

	public ReferencesSearchRequest studyDbIds(List<String> studyDbIds) {
		this.studyDbIds = studyDbIds;
		return this;
	}

	public ReferencesSearchRequest addStudyDbIdsItem(String studyDbIdsItem) {
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

	public ReferencesSearchRequest studyNames(List<String> studyNames) {
		this.studyNames = studyNames;
		return this;
	}

	public ReferencesSearchRequest addStudyNamesItem(String studyNamesItem) {
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

	public ReferencesSearchRequest trialDbIds(List<String> trialDbIds) {
		this.trialDbIds = trialDbIds;
		return this;
	}

	public ReferencesSearchRequest addTrialDbIdsItem(String trialDbIdsItem) {
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

	public ReferencesSearchRequest trialNames(List<String> trialNames) {
		this.trialNames = trialNames;
		return this;
	}

	public ReferencesSearchRequest addTrialNamesItem(String trialNamesItem) {
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

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ReferencesSearchRequest referencesSearchRequest = (ReferencesSearchRequest) o;
		return Objects.equals(this.accessions, referencesSearchRequest.accessions)
				&& Objects.equals(this.commonCropNames, referencesSearchRequest.commonCropNames)
				&& Objects.equals(this.externalReferenceIds, referencesSearchRequest.externalReferenceIds)
				&& Objects.equals(this.externalReferenceSources, referencesSearchRequest.externalReferenceSources)
				&& Objects.equals(this.germplasmDbIds, referencesSearchRequest.germplasmDbIds)
				&& Objects.equals(this.germplasmNames, referencesSearchRequest.germplasmNames)
				&& Objects.equals(this.isDerived, referencesSearchRequest.isDerived)
				&& Objects.equals(this.maxLength, referencesSearchRequest.maxLength)
				&& Objects.equals(this.md5checksums, referencesSearchRequest.md5checksums)
				&& Objects.equals(this.minLength, referencesSearchRequest.minLength)
				&& Objects.equals(this.page, referencesSearchRequest.page)
				&& Objects.equals(this.pageSize, referencesSearchRequest.pageSize)
				&& Objects.equals(this.programDbIds, referencesSearchRequest.programDbIds)
				&& Objects.equals(this.programNames, referencesSearchRequest.programNames)
				&& Objects.equals(this.referenceDbIds, referencesSearchRequest.referenceDbIds)
				&& Objects.equals(this.referenceSetDbIds, referencesSearchRequest.referenceSetDbIds)
				&& Objects.equals(this.studyDbIds, referencesSearchRequest.studyDbIds)
				&& Objects.equals(this.studyNames, referencesSearchRequest.studyNames)
				&& Objects.equals(this.trialDbIds, referencesSearchRequest.trialDbIds)
				&& Objects.equals(this.trialNames, referencesSearchRequest.trialNames);
	}

	@Override
	public int hashCode() {
		return Objects.hash(accessions, commonCropNames, externalReferenceIds, externalReferenceSources, germplasmDbIds,
				germplasmNames, isDerived, maxLength, md5checksums, minLength, page, pageSize, programDbIds,
				programNames, referenceDbIds, referenceSetDbIds, studyDbIds, studyNames, trialDbIds, trialNames,
				super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ReferencesSearchRequest {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    accessions: ").append(toIndentedString(accessions)).append("\n");
		sb.append("    commonCropNames: ").append(toIndentedString(commonCropNames)).append("\n");
		sb.append("    externalReferenceIds: ").append(toIndentedString(externalReferenceIds)).append("\n");
		sb.append("    externalReferenceSources: ").append(toIndentedString(externalReferenceSources)).append("\n");
		sb.append("    germplasmDbIds: ").append(toIndentedString(germplasmDbIds)).append("\n");
		sb.append("    germplasmNames: ").append(toIndentedString(germplasmNames)).append("\n");
		sb.append("    isDerived: ").append(toIndentedString(isDerived)).append("\n");
		sb.append("    maxLength: ").append(toIndentedString(maxLength)).append("\n");
		sb.append("    md5checksums: ").append(toIndentedString(md5checksums)).append("\n");
		sb.append("    minLength: ").append(toIndentedString(minLength)).append("\n");
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
		if (this.accessions != null)
			count += this.accessions.size();
		if (this.commonCropNames != null)
			count += this.commonCropNames.size();
		if (this.externalReferenceIds != null)
			count += this.externalReferenceIds.size();
		if (this.externalReferenceSources != null)
			count += this.externalReferenceSources.size();
		if (this.germplasmDbIds != null)
			count += this.germplasmDbIds.size();
		if (this.germplasmNames != null)
			count += this.germplasmNames.size();
		if (this.isDerived != null)
			count += 1;
		if (this.maxLength != null)
			count += 1;
		if (this.md5checksums != null)
			count += this.md5checksums.size();
		if (this.minLength != null)
			count += 1;
		if (this.referenceDbIds != null)
			count += this.referenceDbIds.size();
		if (this.referenceSetDbIds != null)
			count += this.referenceSetDbIds.size();
		if (this.programDbIds != null)
			count += this.programDbIds.size();
		if (this.programNames != null)
			count += this.programNames.size();
		if (this.trialDbIds != null)
			count += this.trialDbIds.size();
		if (this.trialNames != null)
			count += this.trialNames.size();
		if (this.studyDbIds != null)
			count += this.studyDbIds.size();
		if (this.studyNames != null)
			count += this.studyNames.size();
		return count;
	}
}
