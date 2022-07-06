package io.swagger.model.core;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.model.SearchRequest;
import java.util.ArrayList;
import java.util.List;

public class ProgramSearchRequest extends SearchRequest {
	@JsonProperty("abbreviations")
	private List<String> abbreviations = null;

	@JsonProperty("commonCropNames")
	private List<String> commonCropNames = null;

	@JsonProperty("leadPersonDbIds")
	private List<String> leadPersonDbIds = null;

	@JsonProperty("leadPersonNames")
	private List<String> leadPersonNames = null;

	@JsonProperty("objectives")
	private List<String> objectives = null;

	@JsonProperty("page")
	private Integer page = null;

	@JsonProperty("pageSize")
	private Integer pageSize = null;

	@JsonProperty("programDbIds")
	private List<String> programDbIds = null;

	@JsonProperty("programNames")
	private List<String> programNames = null;

	@JsonProperty("programTypes")
	private List<ProgramTypesEnum> programTypes = null;

	public enum ProgramTypesEnum {
		STANARD("STANARD"), PROJECT("PROJECT");

		private String value;

		ProgramTypesEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static ProgramTypesEnum fromValue(String text) {
			for (ProgramTypesEnum b : ProgramTypesEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	public ProgramSearchRequest abbreviations(List<String> abbreviations) {
		this.abbreviations = abbreviations;
		return this;
	}

	public ProgramSearchRequest addAbbreviationsItem(String abbreviationsItem) {
		if (this.abbreviations == null) {
			this.abbreviations = new ArrayList<String>();
		}
		this.abbreviations.add(abbreviationsItem);
		return this;
	}

	public List<String> getAbbreviations() {
		return abbreviations;
	}

	public void setAbbreviations(List<String> abbreviations) {
		this.abbreviations = abbreviations;
	}

	public ProgramSearchRequest commonCropNames(List<String> commonCropNames) {
		this.commonCropNames = commonCropNames;
		return this;
	}

	public ProgramSearchRequest addCommonCropNamesItem(String commonCropNamesItem) {
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

	public ProgramSearchRequest leadPersonDbIds(List<String> leadPersonDbIds) {
		this.leadPersonDbIds = leadPersonDbIds;
		return this;
	}

	public ProgramSearchRequest addLeadPersonDbIdsItem(String leadPersonDbIdsItem) {
		if (this.leadPersonDbIds == null) {
			this.leadPersonDbIds = new ArrayList<String>();
		}
		this.leadPersonDbIds.add(leadPersonDbIdsItem);
		return this;
	}

	public List<String> getLeadPersonDbIds() {
		return leadPersonDbIds;
	}

	public void setLeadPersonDbIds(List<String> leadPersonDbIds) {
		this.leadPersonDbIds = leadPersonDbIds;
	}

	public ProgramSearchRequest leadPersonNames(List<String> leadPersonNames) {
		this.leadPersonNames = leadPersonNames;
		return this;
	}

	public ProgramSearchRequest addLeadPersonNamesItem(String leadPersonNamesItem) {
		if (this.leadPersonNames == null) {
			this.leadPersonNames = new ArrayList<String>();
		}
		this.leadPersonNames.add(leadPersonNamesItem);
		return this;
	}

	public List<String> getLeadPersonNames() {
		return leadPersonNames;
	}

	public void setLeadPersonNames(List<String> leadPersonNames) {
		this.leadPersonNames = leadPersonNames;
	}

	public ProgramSearchRequest objectives(List<String> objectives) {
		this.objectives = objectives;
		return this;
	}

	public ProgramSearchRequest addObjectivesItem(String objectivesItem) {
		if (this.objectives == null) {
			this.objectives = new ArrayList<String>();
		}
		this.objectives.add(objectivesItem);
		return this;
	}

	public List<String> getObjectives() {
		return objectives;
	}

	public void setObjectives(List<String> objectives) {
		this.objectives = objectives;
	}

	public ProgramSearchRequest programDbIds(List<String> programDbIds) {
		this.programDbIds = programDbIds;
		return this;
	}

	public ProgramSearchRequest addProgramDbIdsItem(String programDbIdsItem) {
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

	public ProgramSearchRequest programNames(List<String> programNames) {
		this.programNames = programNames;
		return this;
	}

	public ProgramSearchRequest addProgramNamesItem(String programNamesItem) {
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

	public ProgramSearchRequest programTypes(List<ProgramTypesEnum> programTypes) {
		this.programTypes = programTypes;
		return this;
	}

	public ProgramSearchRequest addProgramTypesItem(ProgramTypesEnum programTypesItem) {
		if (this.programTypes == null) {
			this.programTypes = new ArrayList<ProgramTypesEnum>();
		}
		this.programTypes.add(programTypesItem);
		return this;
	}

	public List<ProgramTypesEnum> getProgramTypes() {
		return programTypes;
	}

	public void setProgramTypes(List<ProgramTypesEnum> programTypes) {
		this.programTypes = programTypes;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ProgramSearchRequest programSearchRequest = (ProgramSearchRequest) o;
		return Objects.equals(this.abbreviations, programSearchRequest.abbreviations)
				&& Objects.equals(this.commonCropNames, programSearchRequest.commonCropNames)
				&& Objects.equals(this.externalReferenceIds, programSearchRequest.externalReferenceIds)
				&& Objects.equals(this.externalReferenceSources, programSearchRequest.externalReferenceSources)
				&& Objects.equals(this.leadPersonDbIds, programSearchRequest.leadPersonDbIds)
				&& Objects.equals(this.leadPersonNames, programSearchRequest.leadPersonNames)
				&& Objects.equals(this.objectives, programSearchRequest.objectives)
				&& Objects.equals(this.page, programSearchRequest.page)
				&& Objects.equals(this.pageSize, programSearchRequest.pageSize)
				&& Objects.equals(this.programDbIds, programSearchRequest.programDbIds)
				&& Objects.equals(this.programNames, programSearchRequest.programNames)
				&& Objects.equals(this.programTypes, programSearchRequest.programTypes);
	}

	@Override
	public int hashCode() {
		return Objects.hash(abbreviations, commonCropNames, externalReferenceIds,
				externalReferenceSources, leadPersonDbIds, leadPersonNames, objectives, page, pageSize, programDbIds,
				programNames, programTypes);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ProgramSearchRequest {\n");

		sb.append("    abbreviations: ").append(toIndentedString(abbreviations)).append("\n");
		sb.append("    commonCropNames: ").append(toIndentedString(commonCropNames)).append("\n");
		sb.append("    externalReferenceIds: ").append(toIndentedString(externalReferenceIds)).append("\n");
		sb.append("    externalReferenceSources: ").append(toIndentedString(externalReferenceSources)).append("\n");
		sb.append("    leadPersonDbIds: ").append(toIndentedString(leadPersonDbIds)).append("\n");
		sb.append("    leadPersonNames: ").append(toIndentedString(leadPersonNames)).append("\n");
		sb.append("    objectives: ").append(toIndentedString(objectives)).append("\n");
		sb.append("    page: ").append(toIndentedString(page)).append("\n");
		sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
		sb.append("    programDbIds: ").append(toIndentedString(programDbIds)).append("\n");
		sb.append("    programNames: ").append(toIndentedString(programNames)).append("\n");
		sb.append("    programTypes: ").append(toIndentedString(programTypes)).append("\n");
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
		if (this.abbreviations != null)
			count += this.abbreviations.size();
		if (this.commonCropNames != null)
			count += this.commonCropNames.size();
		if (this.externalReferenceIds != null)
			count += this.externalReferenceIds.size();
		if (this.externalReferenceSources != null)
			count += this.externalReferenceSources.size();
		if (this.leadPersonDbIds != null)
			count += this.leadPersonDbIds.size();
		if (this.leadPersonNames != null)
			count += this.leadPersonNames.size();
		if (this.objectives != null)
			count += this.objectives.size();
		if (this.programDbIds != null)
			count += this.programDbIds.size();
		if (this.programNames != null)
			count += this.programNames.size();
		if (this.programTypes != null)
			count += this.programTypes.size();
		return count;
	}
}
