package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.model.SearchRequest;
import java.util.ArrayList;
import java.util.List;

public class ReferenceSetsSearchRequest extends SearchRequest {
	@JsonProperty("accessions")
	private List<String> accessions = null;

	@JsonProperty("assemblyPUIs")
	private List<String> assemblyPUIs = null;

	@JsonProperty("commonCropNames")
	private List<String> commonCropNames = null;

	@JsonProperty("germplasmDbIds")
	private List<String> germplasmDbIds = null;

	@JsonProperty("germplasmNames")
	private List<String> germplasmNames = null;

	@JsonProperty("md5checksums")
	private List<String> md5checksums = null;

	@JsonProperty("programDbIds")
	private List<String> programDbIds = null;

	@JsonProperty("programNames")
	private List<String> programNames = null;

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

	public ReferenceSetsSearchRequest accessions(List<String> accessions) {
		this.accessions = accessions;
		return this;
	}

	public ReferenceSetsSearchRequest addAccessionsItem(String accessionsItem) {
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

	public ReferenceSetsSearchRequest assemblyPUIs(List<String> assemblyPUIs) {
		this.assemblyPUIs = assemblyPUIs;
		return this;
	}

	public ReferenceSetsSearchRequest addAssemblyPUIsItem(String assemblyPUIsItem) {
		if (this.assemblyPUIs == null) {
			this.assemblyPUIs = new ArrayList<String>();
		}
		this.assemblyPUIs.add(assemblyPUIsItem);
		return this;
	}

	public List<String> getAssemblyPUIs() {
		return assemblyPUIs;
	}

	public void setAssemblyPUIs(List<String> assemblyPUIs) {
		this.assemblyPUIs = assemblyPUIs;
	}

	public ReferenceSetsSearchRequest commonCropNames(List<String> commonCropNames) {
		this.commonCropNames = commonCropNames;
		return this;
	}

	public ReferenceSetsSearchRequest addCommonCropNamesItem(String commonCropNamesItem) {
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

	public ReferenceSetsSearchRequest germplasmDbIds(List<String> germplasmDbIds) {
		this.germplasmDbIds = germplasmDbIds;
		return this;
	}

	public ReferenceSetsSearchRequest addGermplasmDbIdsItem(String germplasmDbIdsItem) {
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

	public ReferenceSetsSearchRequest germplasmNames(List<String> germplasmNames) {
		this.germplasmNames = germplasmNames;
		return this;
	}

	public ReferenceSetsSearchRequest addGermplasmNamesItem(String germplasmNamesItem) {
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

	public ReferenceSetsSearchRequest md5checksums(List<String> md5checksums) {
		this.md5checksums = md5checksums;
		return this;
	}

	public ReferenceSetsSearchRequest addMd5checksumsItem(String md5checksumsItem) {
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

	public ReferenceSetsSearchRequest programDbIds(List<String> programDbIds) {
		this.programDbIds = programDbIds;
		return this;
	}

	public ReferenceSetsSearchRequest addProgramDbIdsItem(String programDbIdsItem) {
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

	public ReferenceSetsSearchRequest programNames(List<String> programNames) {
		this.programNames = programNames;
		return this;
	}

	public ReferenceSetsSearchRequest addProgramNamesItem(String programNamesItem) {
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

	public ReferenceSetsSearchRequest referenceSetDbIds(List<String> referenceSetDbIds) {
		this.referenceSetDbIds = referenceSetDbIds;
		return this;
	}

	public ReferenceSetsSearchRequest addReferenceSetDbIdsItem(String referenceSetDbIdsItem) {
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

	public ReferenceSetsSearchRequest studyDbIds(List<String> studyDbIds) {
		this.studyDbIds = studyDbIds;
		return this;
	}

	public ReferenceSetsSearchRequest addStudyDbIdsItem(String studyDbIdsItem) {
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

	public ReferenceSetsSearchRequest studyNames(List<String> studyNames) {
		this.studyNames = studyNames;
		return this;
	}

	public ReferenceSetsSearchRequest addStudyNamesItem(String studyNamesItem) {
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

	public ReferenceSetsSearchRequest trialDbIds(List<String> trialDbIds) {
		this.trialDbIds = trialDbIds;
		return this;
	}

	public ReferenceSetsSearchRequest addTrialDbIdsItem(String trialDbIdsItem) {
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

	public ReferenceSetsSearchRequest trialNames(List<String> trialNames) {
		this.trialNames = trialNames;
		return this;
	}

	public ReferenceSetsSearchRequest addTrialNamesItem(String trialNamesItem) {
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
		ReferenceSetsSearchRequest referenceSetsSearchRequest = (ReferenceSetsSearchRequest) o;
		return Objects.equals(this.accessions, referenceSetsSearchRequest.accessions)
				&& Objects.equals(this.assemblyPUIs, referenceSetsSearchRequest.assemblyPUIs)
				&& Objects.equals(this.md5checksums, referenceSetsSearchRequest.md5checksums)
				&& Objects.equals(this.referenceSetDbIds, referenceSetsSearchRequest.referenceSetDbIds)
				&& super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(accessions, assemblyPUIs, md5checksums, referenceSetDbIds, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ReferenceSetsSearchRequest {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    accession: ").append(toIndentedString(accessions)).append("\n");
		sb.append("    assemblyPUI: ").append(toIndentedString(assemblyPUIs)).append("\n");
		sb.append("    md5checksum: ").append(toIndentedString(md5checksums)).append("\n");
		sb.append("    referenceSetDbIds: ").append(toIndentedString(referenceSetDbIds)).append("\n");
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
		if (this.assemblyPUIs != null)
			count += this.assemblyPUIs.size();
		if (this.md5checksums != null)
			count += this.md5checksums.size();
		if (this.referenceSetDbIds != null)
			count += this.referenceSetDbIds.size();
		return count;
	}
}
