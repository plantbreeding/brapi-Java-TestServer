package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.SearchRequest;
import java.util.ArrayList;
import java.util.List;

public class SampleSearchRequest extends SearchRequest {
	@JsonProperty("commonCropNames")
	private List<String> commonCropNames = null;

	@JsonProperty("germplasmDbIds")
	private List<String> germplasmDbIds = null;

	@JsonProperty("germplasmNames")
	private List<String> germplasmNames = null;

	@JsonProperty("observationUnitDbIds")
	private List<String> observationUnitDbIds = null;

	@JsonProperty("plateDbIds")
	private List<String> plateDbIds = null;

	@JsonProperty("plateNames")
	private List<String> plateNames = null;

	@JsonProperty("programDbIds")
	private List<String> programDbIds = null;

	@JsonProperty("programNames")
	private List<String> programNames = null;

	@JsonProperty("sampleDbIds")
	private List<String> sampleDbIds = null;

	@JsonProperty("sampleGroupDbIds")
	private List<String> sampleGroupDbIds = null;

	@JsonProperty("sampleNames")
	private List<String> sampleNames = null;

	@JsonProperty("studyDbIds")
	private List<String> studyDbIds = null;

	@JsonProperty("studyNames")
	private List<String> studyNames = null;

	@JsonProperty("trialDbIds")
	private List<String> trialDbIds = null;

	@JsonProperty("trialNames")
	private List<String> trialNames = null;

	public SampleSearchRequest commonCropNames(List<String> commonCropNames) {
		this.commonCropNames = commonCropNames;
		return this;
	}

	public SampleSearchRequest addCommonCropNamesItem(String commonCropNamesItem) {
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

	public SampleSearchRequest germplasmDbIds(List<String> germplasmDbIds) {
		this.germplasmDbIds = germplasmDbIds;
		return this;
	}

	public SampleSearchRequest addGermplasmDbIdsItem(String germplasmDbIdsItem) {
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

	public SampleSearchRequest germplasmNames(List<String> germplasmNames) {
		this.germplasmNames = germplasmNames;
		return this;
	}

	public SampleSearchRequest addGermplasmNamesItem(String germplasmNamesItem) {
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

	public SampleSearchRequest observationUnitDbIds(List<String> observationUnitDbIds) {
		this.observationUnitDbIds = observationUnitDbIds;
		return this;
	}

	public SampleSearchRequest addObservationUnitDbIdsItem(String observationUnitDbIdsItem) {
		if (this.observationUnitDbIds == null) {
			this.observationUnitDbIds = new ArrayList<String>();
		}
		this.observationUnitDbIds.add(observationUnitDbIdsItem);
		return this;
	}

	public List<String> getObservationUnitDbIds() {
		return observationUnitDbIds;
	}

	public void setObservationUnitDbIds(List<String> observationUnitDbIds) {
		this.observationUnitDbIds = observationUnitDbIds;
	}

	public SampleSearchRequest plateDbIds(List<String> plateDbIds) {
		this.plateDbIds = plateDbIds;
		return this;
	}

	public SampleSearchRequest addPlateDbIdsItem(String plateDbIdsItem) {
		if (this.plateDbIds == null) {
			this.plateDbIds = new ArrayList<String>();
		}
		this.plateDbIds.add(plateDbIdsItem);
		return this;
	}

	public List<String> getPlateDbIds() {
		return plateDbIds;
	}

	public void setPlateDbIds(List<String> plateDbIds) {
		this.plateDbIds = plateDbIds;
	}

	public SampleSearchRequest plateNames(List<String> plateNames) {
		this.plateNames = plateNames;
		return this;
	}

	public SampleSearchRequest addPlateNamesItem(String plateNamesItem) {
		if (this.plateNames == null) {
			this.plateNames = new ArrayList<String>();
		}
		this.plateNames.add(plateNamesItem);
		return this;
	}

	public List<String> getPlateNames() {
		return plateNames;
	}

	public void setPlateNames(List<String> plateNames) {
		this.plateNames = plateNames;
	}

	public SampleSearchRequest programDbIds(List<String> programDbIds) {
		this.programDbIds = programDbIds;
		return this;
	}

	public SampleSearchRequest addProgramDbIdsItem(String programDbIdsItem) {
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

	public SampleSearchRequest programNames(List<String> programNames) {
		this.programNames = programNames;
		return this;
	}

	public SampleSearchRequest addProgramNamesItem(String programNamesItem) {
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

	public SampleSearchRequest sampleDbIds(List<String> sampleDbIds) {
		this.sampleDbIds = sampleDbIds;
		return this;
	}

	public SampleSearchRequest addSampleDbIdsItem(String sampleDbIdsItem) {
		if (this.sampleDbIds == null) {
			this.sampleDbIds = new ArrayList<String>();
		}
		this.sampleDbIds.add(sampleDbIdsItem);
		return this;
	}

	public List<String> getSampleDbIds() {
		return sampleDbIds;
	}

	public void setSampleDbIds(List<String> sampleDbIds) {
		this.sampleDbIds = sampleDbIds;
	}

	public SampleSearchRequest sampleGroupDbIds(List<String> sampleGroupDbIds) {
		this.sampleGroupDbIds = sampleGroupDbIds;
		return this;
	}

	public SampleSearchRequest addSampleGroupDbIdsItem(String sampleGroupDbIdsItem) {
		if (this.sampleGroupDbIds == null) {
			this.sampleGroupDbIds = new ArrayList<String>();
		}
		this.sampleGroupDbIds.add(sampleGroupDbIdsItem);
		return this;
	}

	public List<String> getSampleGroupDbIds() {
		return sampleGroupDbIds;
	}

	public void setSampleGroupDbIds(List<String> sampleGroupDbIds) {
		this.sampleGroupDbIds = sampleGroupDbIds;
	}

	public SampleSearchRequest sampleNames(List<String> sampleNames) {
		this.sampleNames = sampleNames;
		return this;
	}

	public SampleSearchRequest addSampleNamesItem(String sampleNamesItem) {
		if (this.sampleNames == null) {
			this.sampleNames = new ArrayList<String>();
		}
		this.sampleNames.add(sampleNamesItem);
		return this;
	}

	public List<String> getSampleNames() {
		return sampleNames;
	}

	public void setSampleNames(List<String> sampleNames) {
		this.sampleNames = sampleNames;
	}

	public SampleSearchRequest studyDbIds(List<String> studyDbIds) {
		this.studyDbIds = studyDbIds;
		return this;
	}

	public SampleSearchRequest addStudyDbIdsItem(String studyDbIdsItem) {
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

	public SampleSearchRequest studyNames(List<String> studyNames) {
		this.studyNames = studyNames;
		return this;
	}

	public SampleSearchRequest addStudyNamesItem(String studyNamesItem) {
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

	public SampleSearchRequest trialDbIds(List<String> trialDbIds) {
		this.trialDbIds = trialDbIds;
		return this;
	}

	public SampleSearchRequest addTrialDbIdsItem(String trialDbIdsItem) {
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

	public SampleSearchRequest trialNames(List<String> trialNames) {
		this.trialNames = trialNames;
		return this;
	}

	public SampleSearchRequest addTrialNamesItem(String trialNamesItem) {
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
		SampleSearchRequest sampleSearchRequest = (SampleSearchRequest) o;
		return Objects.equals(this.commonCropNames, sampleSearchRequest.commonCropNames)
				&& Objects.equals(this.externalReferenceIds, sampleSearchRequest.externalReferenceIds)
				&& Objects.equals(this.externalReferenceSources, sampleSearchRequest.externalReferenceSources)
				&& Objects.equals(this.germplasmDbIds, sampleSearchRequest.germplasmDbIds)
				&& Objects.equals(this.germplasmNames, sampleSearchRequest.germplasmNames)
				&& Objects.equals(this.observationUnitDbIds, sampleSearchRequest.observationUnitDbIds)
				&& Objects.equals(this.page, sampleSearchRequest.page)
				&& Objects.equals(this.pageSize, sampleSearchRequest.pageSize)
				&& Objects.equals(this.plateDbIds, sampleSearchRequest.plateDbIds)
				&& Objects.equals(this.plateNames, sampleSearchRequest.plateNames)
				&& Objects.equals(this.programDbIds, sampleSearchRequest.programDbIds)
				&& Objects.equals(this.programNames, sampleSearchRequest.programNames)
				&& Objects.equals(this.sampleDbIds, sampleSearchRequest.sampleDbIds)
				&& Objects.equals(this.sampleGroupDbIds, sampleSearchRequest.sampleGroupDbIds)
				&& Objects.equals(this.sampleNames, sampleSearchRequest.sampleNames)
				&& Objects.equals(this.studyDbIds, sampleSearchRequest.studyDbIds)
				&& Objects.equals(this.studyNames, sampleSearchRequest.studyNames)
				&& Objects.equals(this.trialDbIds, sampleSearchRequest.trialDbIds)
				&& Objects.equals(this.trialNames, sampleSearchRequest.trialNames);
	}

	@Override
	public int hashCode() {
		return Objects.hash(commonCropNames, externalReferenceIds, externalReferenceSources, germplasmDbIds,
				germplasmNames, observationUnitDbIds, page, pageSize, plateDbIds, plateNames, programDbIds,
				programNames, sampleDbIds, sampleGroupDbIds, sampleNames, studyDbIds, studyNames, trialDbIds,
				trialNames);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class SampleSearchRequest {\n");

		sb.append("    commonCropNames: ").append(toIndentedString(commonCropNames)).append("\n");
		sb.append("    externalReferenceIds: ").append(toIndentedString(externalReferenceIds)).append("\n");
		sb.append("    externalReferenceSources: ").append(toIndentedString(externalReferenceSources)).append("\n");
		sb.append("    germplasmDbIds: ").append(toIndentedString(germplasmDbIds)).append("\n");
		sb.append("    germplasmNames: ").append(toIndentedString(germplasmNames)).append("\n");
		sb.append("    observationUnitDbIds: ").append(toIndentedString(observationUnitDbIds)).append("\n");
		sb.append("    page: ").append(toIndentedString(page)).append("\n");
		sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
		sb.append("    plateDbIds: ").append(toIndentedString(plateDbIds)).append("\n");
		sb.append("    plateNames: ").append(toIndentedString(plateNames)).append("\n");
		sb.append("    programDbIds: ").append(toIndentedString(programDbIds)).append("\n");
		sb.append("    programNames: ").append(toIndentedString(programNames)).append("\n");
		sb.append("    sampleDbIds: ").append(toIndentedString(sampleDbIds)).append("\n");
		sb.append("    sampleGroupDbIds: ").append(toIndentedString(sampleGroupDbIds)).append("\n");
		sb.append("    sampleNames: ").append(toIndentedString(sampleNames)).append("\n");
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
		if (this.observationUnitDbIds != null)
			count += this.observationUnitDbIds.size();
		if (this.plateDbIds != null)
			count += this.plateDbIds.size();
		if (this.plateNames != null)
			count += this.plateNames.size();
		if (this.programDbIds != null)
			count += this.programDbIds.size();
		if (this.programNames != null)
			count += this.programNames.size();
		if (this.sampleDbIds != null)
			count += this.sampleDbIds.size();
		if (this.sampleGroupDbIds != null)
			count += this.sampleGroupDbIds.size();
		if (this.sampleNames != null)
			count += this.sampleNames.size();
		if (this.studyDbIds != null)
			count += this.studyDbIds.size();
		if (this.studyNames != null)
			count += this.studyNames.size();
		if (this.trialDbIds != null)
			count += this.trialDbIds.size();
		if (this.trialNames != null)
			count += this.trialNames.size();
		return count;
	}
}
