package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.SearchRequest;
import io.swagger.model.pheno.TraitDataType;

import java.util.ArrayList;
import java.util.List;

public class GermplasmAttributeSearchRequest extends SearchRequest {
	@JsonProperty("attributeCategories")
	private List<String> attributeCategories = null;

	@JsonProperty("attributeDbIds")
	private List<String> attributeDbIds = null;

	@JsonProperty("attributeNames")
	private List<String> attributeNames = null;

	@JsonProperty("attributePUIs")
	private List<String> attributePUIs = null;

	@JsonProperty("commonCropNames")
	private List<String> commonCropNames = null;

	@JsonProperty("germplasmDbIds")
	private List<String> germplasmDbIds = null;

	@JsonProperty("germplasmNames")
	private List<String> germplasmNames = null;

	@JsonProperty("dataTypes")
	private List<TraitDataType> dataTypes = null;

	@JsonProperty("methodDbIds")
	private List<String> methodDbIds = null;

	@JsonProperty("methodNames")
	private List<String> methodNames = null;

	@JsonProperty("methodPUIs")
	private List<String> methodPUIs = null;

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

	public GermplasmAttributeSearchRequest attributeCategories(List<String> attributeCategories) {
		this.attributeCategories = attributeCategories;
		return this;
	}

	public GermplasmAttributeSearchRequest addAttributeCategoriesItem(String attributeCategories) {
		if (this.attributeCategories == null) {
			this.attributeCategories = new ArrayList<String>();
		}
		this.attributeCategories.add(attributeCategories);
		return this;
	}

	public List<String> getAttributeCategories() {
		return attributeCategories;
	}

	public void setAttributeCategories(List<String> attributeCategories) {
		this.attributeCategories = attributeCategories;
	}

	public GermplasmAttributeSearchRequest attributeDbIds(List<String> attributeDbIds) {
		this.attributeDbIds = attributeDbIds;
		return this;
	}

	public GermplasmAttributeSearchRequest addAttributeDbIdsItem(String attributeDbIdsItem) {
		if (this.attributeDbIds == null) {
			this.attributeDbIds = new ArrayList<String>();
		}
		this.attributeDbIds.add(attributeDbIdsItem);
		return this;
	}

	public List<String> getAttributeDbIds() {
		return attributeDbIds;
	}

	public void setAttributeDbIds(List<String> attributeDbIds) {
		this.attributeDbIds = attributeDbIds;
	}

	public GermplasmAttributeSearchRequest attributeNames(List<String> attributeNames) {
		this.attributeNames = attributeNames;
		return this;
	}

	public GermplasmAttributeSearchRequest addAttributeNamesItem(String attributeNamesItem) {
		if (this.attributeNames == null) {
			this.attributeNames = new ArrayList<String>();
		}
		this.attributeNames.add(attributeNamesItem);
		return this;
	}

	public List<String> getAttributeNames() {
		return attributeNames;
	}

	public void setAttributeNames(List<String> attributeNames) {
		this.attributeNames = attributeNames;
	}

	public GermplasmAttributeSearchRequest attributePUIs(List<String> attributePUIs) {
		this.attributePUIs = attributePUIs;
		return this;
	}

	public GermplasmAttributeSearchRequest addAttributePUIsItem(String attributePUIsItem) {
		if (this.attributePUIs == null) {
			this.attributePUIs = new ArrayList<String>();
		}
		this.attributePUIs.add(attributePUIsItem);
		return this;
	}

	public List<String> getAttributePUIs() {
		return attributePUIs;
	}

	public void setAttributePUIs(List<String> attributePUIs) {
		this.attributePUIs = attributePUIs;
	}

	public GermplasmAttributeSearchRequest commonCropNames(List<String> commonCropNames) {
		this.commonCropNames = commonCropNames;
		return this;
	}

	public GermplasmAttributeSearchRequest addCommonCropNamesItem(String commonCropNamesItem) {
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

	public GermplasmAttributeSearchRequest dataTypes(List<TraitDataType> dataTypes) {
		this.dataTypes = dataTypes;
		return this;
	}

	public GermplasmAttributeSearchRequest addDataTypesItem(TraitDataType dataTypesItem) {
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

	public GermplasmAttributeSearchRequest germplasmDbIds(List<String> germplasmDbIds) {
		this.germplasmDbIds = germplasmDbIds;
		return this;
	}

	public GermplasmAttributeSearchRequest addGermplasmDbIdsItem(String germplasmDbIdsItem) {
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

	public GermplasmAttributeSearchRequest germplasmNames(List<String> germplasmNames) {
		this.germplasmNames = germplasmNames;
		return this;
	}

	public GermplasmAttributeSearchRequest addGermplasmNamesItem(String germplasmNamesItem) {
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

	public GermplasmAttributeSearchRequest methodDbIds(List<String> methodDbIds) {
		this.methodDbIds = methodDbIds;
		return this;
	}

	public GermplasmAttributeSearchRequest addMethodDbIdsItem(String methodDbIdsItem) {
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

	public GermplasmAttributeSearchRequest methodNames(List<String> methodNames) {
		this.methodNames = methodNames;
		return this;
	}

	public GermplasmAttributeSearchRequest addMethodNamesItem(String methodNamesItem) {
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

	public GermplasmAttributeSearchRequest methodPUIs(List<String> methodPUIs) {
		this.methodPUIs = methodPUIs;
		return this;
	}

	public GermplasmAttributeSearchRequest addMethodPUIsItem(String methodPUIsItem) {
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

	public GermplasmAttributeSearchRequest ontologyDbIds(List<String> ontologyDbIds) {
		this.ontologyDbIds = ontologyDbIds;
		return this;
	}

	public GermplasmAttributeSearchRequest addOntologyDbIdsItem(String ontologyDbIdsItem) {
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

	public GermplasmAttributeSearchRequest programDbIds(List<String> programDbIds) {
		this.programDbIds = programDbIds;
		return this;
	}

	public GermplasmAttributeSearchRequest addProgramDbIdsItem(String programDbIdsItem) {
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

	public GermplasmAttributeSearchRequest programNames(List<String> programNames) {
		this.programNames = programNames;
		return this;
	}

	public GermplasmAttributeSearchRequest addProgramNamesItem(String programNamesItem) {
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

	public GermplasmAttributeSearchRequest scaleDbIds(List<String> scaleDbIds) {
		this.scaleDbIds = scaleDbIds;
		return this;
	}

	public GermplasmAttributeSearchRequest addScaleDbIdsItem(String scaleDbIdsItem) {
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

	public GermplasmAttributeSearchRequest scaleNames(List<String> scaleNames) {
		this.scaleNames = scaleNames;
		return this;
	}

	public GermplasmAttributeSearchRequest addScaleNamesItem(String scaleNamesItem) {
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

	public GermplasmAttributeSearchRequest scalePUIs(List<String> scalePUIs) {
		this.scalePUIs = scalePUIs;
		return this;
	}

	public GermplasmAttributeSearchRequest addScalePUIsItem(String scalePUIsItem) {
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

	public GermplasmAttributeSearchRequest studyDbId(List<String> studyDbId) {
		this.studyDbId = studyDbId;
		return this;
	}

	public GermplasmAttributeSearchRequest addStudyDbIdItem(String studyDbIdItem) {
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

	public GermplasmAttributeSearchRequest studyDbIds(List<String> studyDbIds) {
		this.studyDbIds = studyDbIds;
		return this;
	}

	public GermplasmAttributeSearchRequest addStudyDbIdsItem(String studyDbIdsItem) {
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

	public GermplasmAttributeSearchRequest studyNames(List<String> studyNames) {
		this.studyNames = studyNames;
		return this;
	}

	public GermplasmAttributeSearchRequest addStudyNamesItem(String studyNamesItem) {
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

	public GermplasmAttributeSearchRequest traitAttributePUIs(List<String> traitAttributePUIs) {
		this.traitAttributePUIs = traitAttributePUIs;
		return this;
	}

	public GermplasmAttributeSearchRequest addTraitAttributePUIsItem(String traitAttributePUIsItem) {
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

	public GermplasmAttributeSearchRequest traitAttributes(List<String> traitAttributes) {
		this.traitAttributes = traitAttributes;
		return this;
	}

	public GermplasmAttributeSearchRequest addTraitAttributesItem(String traitAttributesItem) {
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

	public GermplasmAttributeSearchRequest traitClasses(List<String> traitClasses) {
		this.traitClasses = traitClasses;
		return this;
	}

	public GermplasmAttributeSearchRequest addTraitClassesItem(String traitClassesItem) {
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

	public GermplasmAttributeSearchRequest traitDbIds(List<String> traitDbIds) {
		this.traitDbIds = traitDbIds;
		return this;
	}

	public GermplasmAttributeSearchRequest addTraitDbIdsItem(String traitDbIdsItem) {
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

	public GermplasmAttributeSearchRequest traitEntities(List<String> traitEntities) {
		this.traitEntities = traitEntities;
		return this;
	}

	public GermplasmAttributeSearchRequest addTraitEntitiesItem(String traitEntitiesItem) {
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

	public GermplasmAttributeSearchRequest traitEntityPUIs(List<String> traitEntityPUIs) {
		this.traitEntityPUIs = traitEntityPUIs;
		return this;
	}

	public GermplasmAttributeSearchRequest addTraitEntityPUIsItem(String traitEntityPUIsItem) {
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

	public GermplasmAttributeSearchRequest traitNames(List<String> traitNames) {
		this.traitNames = traitNames;
		return this;
	}

	public GermplasmAttributeSearchRequest addTraitNamesItem(String traitNamesItem) {
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

	public GermplasmAttributeSearchRequest traitPUIs(List<String> traitPUIs) {
		this.traitPUIs = traitPUIs;
		return this;
	}

	public GermplasmAttributeSearchRequest addTraitPUIsItem(String traitPUIsItem) {
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

	public GermplasmAttributeSearchRequest trialDbIds(List<String> trialDbIds) {
		this.trialDbIds = trialDbIds;
		return this;
	}

	public GermplasmAttributeSearchRequest addTrialDbIdsItem(String trialDbIdsItem) {
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

	public GermplasmAttributeSearchRequest trialNames(List<String> trialNames) {
		this.trialNames = trialNames;
		return this;
	}

	public GermplasmAttributeSearchRequest addTrialNamesItem(String trialNamesItem) {
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
		GermplasmAttributeSearchRequest germplasmAttributeSearchRequest = (GermplasmAttributeSearchRequest) o;
		return Objects.equals(this.attributeDbIds, germplasmAttributeSearchRequest.attributeDbIds)
				&& Objects.equals(this.attributeNames, germplasmAttributeSearchRequest.attributeNames)
				&& Objects.equals(this.attributePUIs, germplasmAttributeSearchRequest.attributePUIs)
				&& Objects.equals(this.commonCropNames, germplasmAttributeSearchRequest.commonCropNames)
				&& Objects.equals(this.dataTypes, germplasmAttributeSearchRequest.dataTypes)
				&& Objects.equals(this.externalReferenceIds, germplasmAttributeSearchRequest.externalReferenceIds)
				&& Objects.equals(this.externalReferenceSources,
						germplasmAttributeSearchRequest.externalReferenceSources)
				&& Objects.equals(this.methodDbIds, germplasmAttributeSearchRequest.methodDbIds)
				&& Objects.equals(this.methodNames, germplasmAttributeSearchRequest.methodNames)
				&& Objects.equals(this.methodPUIs, germplasmAttributeSearchRequest.methodPUIs)
				&& Objects.equals(this.ontologyDbIds, germplasmAttributeSearchRequest.ontologyDbIds)
				&& Objects.equals(this.page, germplasmAttributeSearchRequest.page)
				&& Objects.equals(this.pageSize, germplasmAttributeSearchRequest.pageSize)
				&& Objects.equals(this.programDbIds, germplasmAttributeSearchRequest.programDbIds)
				&& Objects.equals(this.programNames, germplasmAttributeSearchRequest.programNames)
				&& Objects.equals(this.scaleDbIds, germplasmAttributeSearchRequest.scaleDbIds)
				&& Objects.equals(this.scaleNames, germplasmAttributeSearchRequest.scaleNames)
				&& Objects.equals(this.scalePUIs, germplasmAttributeSearchRequest.scalePUIs)
				&& Objects.equals(this.studyDbId, germplasmAttributeSearchRequest.studyDbId)
				&& Objects.equals(this.studyDbIds, germplasmAttributeSearchRequest.studyDbIds)
				&& Objects.equals(this.studyNames, germplasmAttributeSearchRequest.studyNames)
				&& Objects.equals(this.traitAttributePUIs, germplasmAttributeSearchRequest.traitAttributePUIs)
				&& Objects.equals(this.traitAttributes, germplasmAttributeSearchRequest.traitAttributes)
				&& Objects.equals(this.traitClasses, germplasmAttributeSearchRequest.traitClasses)
				&& Objects.equals(this.traitDbIds, germplasmAttributeSearchRequest.traitDbIds)
				&& Objects.equals(this.traitEntities, germplasmAttributeSearchRequest.traitEntities)
				&& Objects.equals(this.traitEntityPUIs, germplasmAttributeSearchRequest.traitEntityPUIs)
				&& Objects.equals(this.traitNames, germplasmAttributeSearchRequest.traitNames)
				&& Objects.equals(this.traitPUIs, germplasmAttributeSearchRequest.traitPUIs)
				&& Objects.equals(this.trialDbIds, germplasmAttributeSearchRequest.trialDbIds)
				&& Objects.equals(this.trialNames, germplasmAttributeSearchRequest.trialNames);
	}

	@Override
	public int hashCode() {
		return Objects.hash(attributeDbIds, attributeNames, attributePUIs, commonCropNames, dataTypes,
				externalReferenceIds, externalReferenceSources, methodDbIds, methodNames, methodPUIs, ontologyDbIds,
				page, pageSize, programDbIds, programNames, scaleDbIds, scaleNames, scalePUIs, studyDbId, studyDbIds,
				studyNames, traitAttributePUIs, traitAttributes, traitClasses, traitDbIds, traitEntities,
				traitEntityPUIs, traitNames, traitPUIs, trialDbIds, trialNames);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class GermplasmAttributeSearchRequest {\n");

		sb.append("    attributeDbIds: ").append(toIndentedString(attributeDbIds)).append("\n");
		sb.append("    attributeNames: ").append(toIndentedString(attributeNames)).append("\n");
		sb.append("    attributePUIs: ").append(toIndentedString(attributePUIs)).append("\n");
		sb.append("    commonCropNames: ").append(toIndentedString(commonCropNames)).append("\n");
		sb.append("    dataTypes: ").append(toIndentedString(dataTypes)).append("\n");
		sb.append("    externalReferenceIds: ").append(toIndentedString(externalReferenceIds)).append("\n");
		sb.append("    externalReferenceSources: ").append(toIndentedString(externalReferenceSources)).append("\n");
		sb.append("    methodDbIds: ").append(toIndentedString(methodDbIds)).append("\n");
		sb.append("    methodNames: ").append(toIndentedString(methodNames)).append("\n");
		sb.append("    methodPUIs: ").append(toIndentedString(methodPUIs)).append("\n");
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

		if (this.attributeDbIds != null)
			count += this.attributeDbIds.size();
		if (this.attributeNames != null)
			count += this.attributeNames.size();
		if (this.attributePUIs != null)
			count += this.attributePUIs.size();
		if (this.commonCropNames != null)
			count += this.commonCropNames.size();
		if (this.dataTypes != null)
			count += this.dataTypes.size();
		if (this.externalReferenceIds != null)
			count += this.externalReferenceIds.size();
		if (this.externalReferenceSources != null)
			count += this.externalReferenceSources.size();
		if (this.methodDbIds != null)
			count += this.methodDbIds.size();
		if (this.methodNames != null)
			count += this.methodNames.size();
		if (this.methodPUIs != null)
			count += this.methodPUIs.size();
		if (this.ontologyDbIds != null)
			count += this.ontologyDbIds.size();
		if (this.programDbIds != null)
			count += this.programDbIds.size();
		if (this.programNames != null)
			count += this.programNames.size();
		if (this.scaleDbIds != null)
			count += this.scaleDbIds.size();
		if (this.scaleNames != null)
			count += this.scaleNames.size();
		if (this.scalePUIs != null)
			count += this.scalePUIs.size();
		if (this.studyDbId != null)
			count += this.studyDbId.size();
		if (this.studyDbIds != null)
			count += this.studyDbIds.size();
		if (this.studyNames != null)
			count += this.studyNames.size();
		if (this.traitAttributePUIs != null)
			count += this.traitAttributePUIs.size();
		if (this.traitAttributes != null)
			count += this.traitAttributes.size();
		if (this.traitClasses != null)
			count += this.traitClasses.size();
		if (this.traitDbIds != null)
			count += this.traitDbIds.size();
		if (this.traitEntities != null)
			count += this.traitEntities.size();
		if (this.traitEntityPUIs != null)
			count += this.traitEntityPUIs.size();
		if (this.traitNames != null)
			count += this.traitNames.size();
		if (this.traitPUIs != null)
			count += this.traitPUIs.size();
		if (this.trialDbIds != null)
			count += this.trialDbIds.size();
		if (this.trialNames != null)
			count += this.trialNames.size();

		return count;
	}
}
