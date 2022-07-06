package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.SearchRequest;
import java.util.ArrayList;
import java.util.List;

public class ObservationVariableSearchRequest extends SearchRequest {
	@JsonProperty("commonCropNames")
	private List<String> commonCropNames = null;

	@JsonProperty("dataTypes")
	private List<TraitDataType> dataTypes = null;

	@JsonProperty("methodDbIds")
	private List<String> methodDbIds = null;

	@JsonProperty("methodNames")
	private List<String> methodNames = null;

	@JsonProperty("methodPUIs")
	private List<String> methodPUIs = null;

	@JsonProperty("observationVariableDbIds")
	private List<String> observationVariableDbIds = null;

	@JsonProperty("observationVariableNames")
	private List<String> observationVariableNames = null;

	@JsonProperty("observationVariablePUIs")
	private List<String> observationVariablePUIs = null;

	@JsonProperty("observationUnitDbIds")
	private List<String> observationUnitDbIds = null;

	@JsonProperty("ontologyDbIds")
	private List<String> ontologyDbIds = null;

	@JsonProperty("programDbIds")
	private List<String> programDbIds = null;

	@JsonProperty("programNames")
	private List<String> programNames = null;

	@JsonProperty("scaleDbIds")
	private List<String> scaleDbIds = null;

	@JsonProperty("scaleNames")
	private List<String> scaleNames = null;

	@JsonProperty("scalePUIs")
	private List<String> scalePUIs = null;

	@JsonProperty("studyDbId")
	private List<String> studyDbId = null;

	@JsonProperty("studyDbIds")
	private List<String> studyDbIds = null;

	@JsonProperty("studyNames")
	private List<String> studyNames = null;

	@JsonProperty("traitAttributePUIs")
	private List<String> traitAttributePUIs = null;

	@JsonProperty("traitAttributes")
	private List<String> traitAttributes = null;

	@JsonProperty("traitClasses")
	private List<String> traitClasses = null;

	@JsonProperty("traitDbIds")
	private List<String> traitDbIds = null;

	@JsonProperty("traitEntities")
	private List<String> traitEntities = null;

	@JsonProperty("traitEntityPUIs")
	private List<String> traitEntityPUIs = null;

	@JsonProperty("traitNames")
	private List<String> traitNames = null;

	@JsonProperty("traitPUIs")
	private List<String> traitPUIs = null;

	@JsonProperty("trialDbIds")
	private List<String> trialDbIds = null;

	@JsonProperty("trialNames")
	private List<String> trialNames = null;

	public ObservationVariableSearchRequest commonCropNames(List<String> commonCropNames) {
		this.commonCropNames = commonCropNames;
		return this;
	}

	public ObservationVariableSearchRequest addCommonCropNamesItem(String commonCropNamesItem) {
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

	public ObservationVariableSearchRequest dataTypes(List<TraitDataType> dataTypes) {
		this.dataTypes = dataTypes;
		return this;
	}

	public ObservationVariableSearchRequest addDataTypesItem(TraitDataType dataTypesItem) {
		if (this.dataTypes == null) {
			this.dataTypes = new ArrayList<TraitDataType>();
		}
		this.dataTypes.add(dataTypesItem);
		return this;
	}

	public List<TraitDataType> getDataTypes() {
		return dataTypes;
	}

	public void setDataTypes(List<TraitDataType> dataTypes) {
		this.dataTypes = dataTypes;
	}

	public ObservationVariableSearchRequest methodDbIds(List<String> methodDbIds) {
		this.methodDbIds = methodDbIds;
		return this;
	}

	public ObservationVariableSearchRequest addMethodDbIdsItem(String methodDbIdsItem) {
		if (this.methodDbIds == null) {
			this.methodDbIds = new ArrayList<String>();
		}
		this.methodDbIds.add(methodDbIdsItem);
		return this;
	}

	public List<String> getMethodDbIds() {
		return methodDbIds;
	}

	public void setMethodDbIds(List<String> methodDbIds) {
		this.methodDbIds = methodDbIds;
	}

	public ObservationVariableSearchRequest methodNames(List<String> methodNames) {
		this.methodNames = methodNames;
		return this;
	}

	public ObservationVariableSearchRequest addMethodNamesItem(String methodNamesItem) {
		if (this.methodNames == null) {
			this.methodNames = new ArrayList<String>();
		}
		this.methodNames.add(methodNamesItem);
		return this;
	}

	public List<String> getMethodNames() {
		return methodNames;
	}

	public void setMethodNames(List<String> methodNames) {
		this.methodNames = methodNames;
	}

	public ObservationVariableSearchRequest methodPUIs(List<String> methodPUIs) {
		this.methodPUIs = methodPUIs;
		return this;
	}

	public ObservationVariableSearchRequest addMethodPUIsItem(String methodPUIsItem) {
		if (this.methodPUIs == null) {
			this.methodPUIs = new ArrayList<String>();
		}
		this.methodPUIs.add(methodPUIsItem);
		return this;
	}

	public List<String> getMethodPUIs() {
		return methodPUIs;
	}

	public void setMethodPUIs(List<String> methodPUIs) {
		this.methodPUIs = methodPUIs;
	}

	public ObservationVariableSearchRequest observationVariableDbIds(List<String> observationVariableDbIds) {
		this.observationVariableDbIds = observationVariableDbIds;
		return this;
	}

	public ObservationVariableSearchRequest addObservationVariableDbIdsItem(String observationVariableDbIdsItem) {
		if (this.observationVariableDbIds == null) {
			this.observationVariableDbIds = new ArrayList<String>();
		}
		this.observationVariableDbIds.add(observationVariableDbIdsItem);
		return this;
	}

	public List<String> getObservationVariableDbIds() {
		return observationVariableDbIds;
	}

	public void setObservationVariableDbIds(List<String> observationVariableDbIds) {
		this.observationVariableDbIds = observationVariableDbIds;
	}

	public ObservationVariableSearchRequest observationVariableNames(List<String> observationVariableNames) {
		this.observationVariableNames = observationVariableNames;
		return this;
	}

	public ObservationVariableSearchRequest addObservationVariableNamesItem(String observationVariableNamesItem) {
		if (this.observationVariableNames == null) {
			this.observationVariableNames = new ArrayList<String>();
		}
		this.observationVariableNames.add(observationVariableNamesItem);
		return this;
	}

	public List<String> getObservationVariableNames() {
		return observationVariableNames;
	}

	public void setObservationVariableNames(List<String> observationVariableNames) {
		this.observationVariableNames = observationVariableNames;
	}

	public ObservationVariableSearchRequest observationVariablePUIs(List<String> observationVariablePUIs) {
		this.observationVariablePUIs = observationVariablePUIs;
		return this;
	}

	public ObservationVariableSearchRequest addObservationVariablePUIsItem(String observationVariablePUIsItem) {
		if (this.observationVariablePUIs == null) {
			this.observationVariablePUIs = new ArrayList<String>();
		}
		this.observationVariablePUIs.add(observationVariablePUIsItem);
		return this;
	}

	public List<String> getObservationVariablePUIs() {
		return observationVariablePUIs;
	}

	public void setObservationVariablePUIs(List<String> observationVariablePUIs) {
		this.observationVariablePUIs = observationVariablePUIs;
	}

	
	
	public ObservationVariableSearchRequest observationUnitDbIds(List<String> observationUnitDbIds) {
		this.observationUnitDbIds = observationUnitDbIds;
		return this;
	}

	public ObservationVariableSearchRequest addObservationUnitDbIdsItem(String observationUnitDbId) {
		if (this.observationUnitDbIds == null) {
			this.observationUnitDbIds = new ArrayList<String>();
		}
		this.observationUnitDbIds.add(observationUnitDbId);
		return this;
	}

	public List<String> getObservationUnitDbIds() {
		return observationUnitDbIds;
	}

	public void setObservationUnitDbIds(List<String> observationUnitDbIds) {
		this.observationUnitDbIds = observationUnitDbIds;
	}

	
	
	public ObservationVariableSearchRequest ontologyDbIds(List<String> ontologyDbIds) {
		this.ontologyDbIds = ontologyDbIds;
		return this;
	}

	public ObservationVariableSearchRequest addOntologyDbIdsItem(String ontologyDbIdsItem) {
		if (this.ontologyDbIds == null) {
			this.ontologyDbIds = new ArrayList<String>();
		}
		this.ontologyDbIds.add(ontologyDbIdsItem);
		return this;
	}

	public List<String> getOntologyDbIds() {
		return ontologyDbIds;
	}

	public void setOntologyDbIds(List<String> ontologyDbIds) {
		this.ontologyDbIds = ontologyDbIds;
	}

	public ObservationVariableSearchRequest programDbIds(List<String> programDbIds) {
		this.programDbIds = programDbIds;
		return this;
	}

	public ObservationVariableSearchRequest addProgramDbIdsItem(String programDbIdsItem) {
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

	public ObservationVariableSearchRequest programNames(List<String> programNames) {
		this.programNames = programNames;
		return this;
	}

	public ObservationVariableSearchRequest addProgramNamesItem(String programNamesItem) {
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

	public ObservationVariableSearchRequest scaleDbIds(List<String> scaleDbIds) {
		this.scaleDbIds = scaleDbIds;
		return this;
	}

	public ObservationVariableSearchRequest addScaleDbIdsItem(String scaleDbIdsItem) {
		if (this.scaleDbIds == null) {
			this.scaleDbIds = new ArrayList<String>();
		}
		this.scaleDbIds.add(scaleDbIdsItem);
		return this;
	}

	public List<String> getScaleDbIds() {
		return scaleDbIds;
	}

	public void setScaleDbIds(List<String> scaleDbIds) {
		this.scaleDbIds = scaleDbIds;
	}

	public ObservationVariableSearchRequest scaleNames(List<String> scaleNames) {
		this.scaleNames = scaleNames;
		return this;
	}

	public ObservationVariableSearchRequest addScaleNamesItem(String scaleNamesItem) {
		if (this.scaleNames == null) {
			this.scaleNames = new ArrayList<String>();
		}
		this.scaleNames.add(scaleNamesItem);
		return this;
	}

	public List<String> getScaleNames() {
		return scaleNames;
	}

	public void setScaleNames(List<String> scaleNames) {
		this.scaleNames = scaleNames;
	}

	public ObservationVariableSearchRequest scalePUIs(List<String> scalePUIs) {
		this.scalePUIs = scalePUIs;
		return this;
	}

	public ObservationVariableSearchRequest addScalePUIsItem(String scalePUIsItem) {
		if (this.scalePUIs == null) {
			this.scalePUIs = new ArrayList<String>();
		}
		this.scalePUIs.add(scalePUIsItem);
		return this;
	}

	public List<String> getScalePUIs() {
		return scalePUIs;
	}

	public void setScalePUIs(List<String> scalePUIs) {
		this.scalePUIs = scalePUIs;
	}

	public ObservationVariableSearchRequest studyDbId(List<String> studyDbId) {
		this.studyDbId = studyDbId;
		return this;
	}

	public ObservationVariableSearchRequest addStudyDbIdItem(String studyDbIdItem) {
		if (this.studyDbId == null) {
			this.studyDbId = new ArrayList<String>();
		}
		this.studyDbId.add(studyDbIdItem);
		return this;
	}

	public List<String> getStudyDbId() {
		return studyDbId;
	}

	public void setStudyDbId(List<String> studyDbId) {
		this.studyDbId = studyDbId;
	}

	public ObservationVariableSearchRequest studyDbIds(List<String> studyDbIds) {
		this.studyDbIds = studyDbIds;
		return this;
	}

	public ObservationVariableSearchRequest addStudyDbIdsItem(String studyDbIdsItem) {
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

	public ObservationVariableSearchRequest studyNames(List<String> studyNames) {
		this.studyNames = studyNames;
		return this;
	}

	public ObservationVariableSearchRequest addStudyNamesItem(String studyNamesItem) {
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

	public ObservationVariableSearchRequest traitAttributePUIs(List<String> traitAttributePUIs) {
		this.traitAttributePUIs = traitAttributePUIs;
		return this;
	}

	public ObservationVariableSearchRequest addTraitAttributePUIsItem(String traitAttributePUIsItem) {
		if (this.traitAttributePUIs == null) {
			this.traitAttributePUIs = new ArrayList<String>();
		}
		this.traitAttributePUIs.add(traitAttributePUIsItem);
		return this;
	}

	public List<String> getTraitAttributePUIs() {
		return traitAttributePUIs;
	}

	public void setTraitAttributePUIs(List<String> traitAttributePUIs) {
		this.traitAttributePUIs = traitAttributePUIs;
	}

	public ObservationVariableSearchRequest traitAttributes(List<String> traitAttributes) {
		this.traitAttributes = traitAttributes;
		return this;
	}

	public ObservationVariableSearchRequest addTraitAttributesItem(String traitAttributesItem) {
		if (this.traitAttributes == null) {
			this.traitAttributes = new ArrayList<String>();
		}
		this.traitAttributes.add(traitAttributesItem);
		return this;
	}

	public List<String> getTraitAttributes() {
		return traitAttributes;
	}

	public void setTraitAttributes(List<String> traitAttributes) {
		this.traitAttributes = traitAttributes;
	}

	public ObservationVariableSearchRequest traitClasses(List<String> traitClasses) {
		this.traitClasses = traitClasses;
		return this;
	}

	public ObservationVariableSearchRequest addTraitClassesItem(String traitClassesItem) {
		if (this.traitClasses == null) {
			this.traitClasses = new ArrayList<String>();
		}
		this.traitClasses.add(traitClassesItem);
		return this;
	}

	public List<String> getTraitClasses() {
		return traitClasses;
	}

	public void setTraitClasses(List<String> traitClasses) {
		this.traitClasses = traitClasses;
	}

	public ObservationVariableSearchRequest traitDbIds(List<String> traitDbIds) {
		this.traitDbIds = traitDbIds;
		return this;
	}

	public ObservationVariableSearchRequest addTraitDbIdsItem(String traitDbIdsItem) {
		if (this.traitDbIds == null) {
			this.traitDbIds = new ArrayList<String>();
		}
		this.traitDbIds.add(traitDbIdsItem);
		return this;
	}

	public List<String> getTraitDbIds() {
		return traitDbIds;
	}

	public void setTraitDbIds(List<String> traitDbIds) {
		this.traitDbIds = traitDbIds;
	}

	public ObservationVariableSearchRequest traitEntities(List<String> traitEntities) {
		this.traitEntities = traitEntities;
		return this;
	}

	public ObservationVariableSearchRequest addTraitEntitiesItem(String traitEntitiesItem) {
		if (this.traitEntities == null) {
			this.traitEntities = new ArrayList<String>();
		}
		this.traitEntities.add(traitEntitiesItem);
		return this;
	}

	public List<String> getTraitEntities() {
		return traitEntities;
	}

	public void setTraitEntities(List<String> traitEntities) {
		this.traitEntities = traitEntities;
	}

	public ObservationVariableSearchRequest traitEntityPUIs(List<String> traitEntityPUIs) {
		this.traitEntityPUIs = traitEntityPUIs;
		return this;
	}

	public ObservationVariableSearchRequest addTraitEntityPUIsItem(String traitEntityPUIsItem) {
		if (this.traitEntityPUIs == null) {
			this.traitEntityPUIs = new ArrayList<String>();
		}
		this.traitEntityPUIs.add(traitEntityPUIsItem);
		return this;
	}

	public List<String> getTraitEntityPUIs() {
		return traitEntityPUIs;
	}

	public void setTraitEntityPUIs(List<String> traitEntityPUIs) {
		this.traitEntityPUIs = traitEntityPUIs;
	}

	public ObservationVariableSearchRequest traitNames(List<String> traitNames) {
		this.traitNames = traitNames;
		return this;
	}

	public ObservationVariableSearchRequest addTraitNamesItem(String traitNamesItem) {
		if (this.traitNames == null) {
			this.traitNames = new ArrayList<String>();
		}
		this.traitNames.add(traitNamesItem);
		return this;
	}

	public List<String> getTraitNames() {
		return traitNames;
	}

	public void setTraitNames(List<String> traitNames) {
		this.traitNames = traitNames;
	}

	public ObservationVariableSearchRequest traitPUIs(List<String> traitPUIs) {
		this.traitPUIs = traitPUIs;
		return this;
	}

	public ObservationVariableSearchRequest addTraitPUIsItem(String traitPUIsItem) {
		if (this.traitPUIs == null) {
			this.traitPUIs = new ArrayList<String>();
		}
		this.traitPUIs.add(traitPUIsItem);
		return this;
	}

	public List<String> getTraitPUIs() {
		return traitPUIs;
	}

	public void setTraitPUIs(List<String> traitPUIs) {
		this.traitPUIs = traitPUIs;
	}

	public ObservationVariableSearchRequest trialDbIds(List<String> trialDbIds) {
		this.trialDbIds = trialDbIds;
		return this;
	}

	public ObservationVariableSearchRequest addTrialDbIdsItem(String trialDbIdsItem) {
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

	public ObservationVariableSearchRequest trialNames(List<String> trialNames) {
		this.trialNames = trialNames;
		return this;
	}

	public ObservationVariableSearchRequest addTrialNamesItem(String trialNamesItem) {
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
		ObservationVariableSearchRequest observationVariableSearchRequest = (ObservationVariableSearchRequest) o;
		return Objects.equals(this.commonCropNames, observationVariableSearchRequest.commonCropNames)
				&& Objects.equals(this.dataTypes, observationVariableSearchRequest.dataTypes)
				&& Objects.equals(this.externalReferenceIds, observationVariableSearchRequest.externalReferenceIds)
				&& Objects.equals(this.externalReferenceSources,
						observationVariableSearchRequest.externalReferenceSources)
				&& Objects.equals(this.methodDbIds, observationVariableSearchRequest.methodDbIds)
				&& Objects.equals(this.methodNames, observationVariableSearchRequest.methodNames)
				&& Objects.equals(this.methodPUIs, observationVariableSearchRequest.methodPUIs)
				&& Objects.equals(this.observationVariableDbIds,
						observationVariableSearchRequest.observationVariableDbIds)
				&& Objects.equals(this.observationVariableNames,
						observationVariableSearchRequest.observationVariableNames)
				&& Objects.equals(this.observationVariablePUIs,
						observationVariableSearchRequest.observationVariablePUIs)
				&& Objects.equals(this.ontologyDbIds, observationVariableSearchRequest.ontologyDbIds)
				&& Objects.equals(this.page, observationVariableSearchRequest.page)
				&& Objects.equals(this.pageSize, observationVariableSearchRequest.pageSize)
				&& Objects.equals(this.programDbIds, observationVariableSearchRequest.programDbIds)
				&& Objects.equals(this.programNames, observationVariableSearchRequest.programNames)
				&& Objects.equals(this.scaleDbIds, observationVariableSearchRequest.scaleDbIds)
				&& Objects.equals(this.scaleNames, observationVariableSearchRequest.scaleNames)
				&& Objects.equals(this.scalePUIs, observationVariableSearchRequest.scalePUIs)
				&& Objects.equals(this.studyDbId, observationVariableSearchRequest.studyDbId)
				&& Objects.equals(this.studyDbIds, observationVariableSearchRequest.studyDbIds)
				&& Objects.equals(this.studyNames, observationVariableSearchRequest.studyNames)
				&& Objects.equals(this.traitAttributePUIs, observationVariableSearchRequest.traitAttributePUIs)
				&& Objects.equals(this.traitAttributes, observationVariableSearchRequest.traitAttributes)
				&& Objects.equals(this.traitClasses, observationVariableSearchRequest.traitClasses)
				&& Objects.equals(this.traitDbIds, observationVariableSearchRequest.traitDbIds)
				&& Objects.equals(this.traitEntities, observationVariableSearchRequest.traitEntities)
				&& Objects.equals(this.traitEntityPUIs, observationVariableSearchRequest.traitEntityPUIs)
				&& Objects.equals(this.traitNames, observationVariableSearchRequest.traitNames)
				&& Objects.equals(this.traitPUIs, observationVariableSearchRequest.traitPUIs)
				&& Objects.equals(this.trialDbIds, observationVariableSearchRequest.trialDbIds)
				&& Objects.equals(this.trialNames, observationVariableSearchRequest.trialNames);
	}

	@Override
	public int hashCode() {
		return Objects.hash(commonCropNames, dataTypes, externalReferenceIds, externalReferenceSources, methodDbIds,
				methodNames, methodPUIs, observationVariableDbIds, observationVariableNames, observationVariablePUIs,
				ontologyDbIds, page, pageSize, programDbIds, programNames, scaleDbIds, scaleNames, scalePUIs, studyDbId,
				studyDbIds, studyNames, traitAttributePUIs, traitAttributes, traitClasses, traitDbIds, traitEntities,
				traitEntityPUIs, traitNames, traitPUIs, trialDbIds, trialNames);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ObservationVariableSearchRequest {\n");

		sb.append("    commonCropNames: ").append(toIndentedString(commonCropNames)).append("\n");
		sb.append("    dataTypes: ").append(toIndentedString(dataTypes)).append("\n");
		sb.append("    externalReferenceIds: ").append(toIndentedString(externalReferenceIds)).append("\n");
		sb.append("    externalReferenceSources: ").append(toIndentedString(externalReferenceSources)).append("\n");
		sb.append("    methodDbIds: ").append(toIndentedString(methodDbIds)).append("\n");
		sb.append("    methodNames: ").append(toIndentedString(methodNames)).append("\n");
		sb.append("    methodPUIs: ").append(toIndentedString(methodPUIs)).append("\n");
		sb.append("    observationVariableDbIds: ").append(toIndentedString(observationVariableDbIds)).append("\n");
		sb.append("    observationVariableNames: ").append(toIndentedString(observationVariableNames)).append("\n");
		sb.append("    observationVariablePUIs: ").append(toIndentedString(observationVariablePUIs)).append("\n");
		sb.append("    ontologyDbIds: ").append(toIndentedString(ontologyDbIds)).append("\n");
		sb.append("    page: ").append(toIndentedString(page)).append("\n");
		sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
		sb.append("    programDbIds: ").append(toIndentedString(programDbIds)).append("\n");
		sb.append("    programNames: ").append(toIndentedString(programNames)).append("\n");
		sb.append("    scaleDbIds: ").append(toIndentedString(scaleDbIds)).append("\n");
		sb.append("    scaleNames: ").append(toIndentedString(scaleNames)).append("\n");
		sb.append("    scalePUIs: ").append(toIndentedString(scalePUIs)).append("\n");
		sb.append("    studyDbId: ").append(toIndentedString(studyDbId)).append("\n");
		sb.append("    studyDbIds: ").append(toIndentedString(studyDbIds)).append("\n");
		sb.append("    studyNames: ").append(toIndentedString(studyNames)).append("\n");
		sb.append("    traitAttributePUIs: ").append(toIndentedString(traitAttributePUIs)).append("\n");
		sb.append("    traitAttributes: ").append(toIndentedString(traitAttributes)).append("\n");
		sb.append("    traitClasses: ").append(toIndentedString(traitClasses)).append("\n");
		sb.append("    traitDbIds: ").append(toIndentedString(traitDbIds)).append("\n");
		sb.append("    traitEntities: ").append(toIndentedString(traitEntities)).append("\n");
		sb.append("    traitEntityPUIs: ").append(toIndentedString(traitEntityPUIs)).append("\n");
		sb.append("    traitNames: ").append(toIndentedString(traitNames)).append("\n");
		sb.append("    traitPUIs: ").append(toIndentedString(traitPUIs)).append("\n");
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
		if (this.externalReferenceIds != null)
			count += this.externalReferenceIds.size();
		if (this.externalReferenceSources != null)
			count += this.externalReferenceSources.size();
		if (this.dataTypes != null)
			count += this.dataTypes.size();
		if (this.methodDbIds != null)
			count += this.methodDbIds.size();
		if (this.observationVariableDbIds != null)
			count += this.observationVariableDbIds.size();
		if (this.observationVariableNames != null)
			count += this.observationVariableNames.size();
		if (this.ontologyDbIds != null)
			count += this.ontologyDbIds.size();
		if (this.scaleDbIds != null)
			count += this.scaleDbIds.size();
		if (this.studyDbId != null)
			count += this.studyDbId.size();
		if (this.traitClasses != null)
			count += this.traitClasses.size();
		if (this.traitDbIds != null)
			count += this.traitDbIds.size();
		;
		return count;
	}
}
