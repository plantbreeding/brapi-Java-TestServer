package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.SearchRequest;
import io.swagger.model.pheno.TraitDataType;

import java.util.ArrayList;
import java.util.List;

public class GermplasmAttributeValueSearchRequest extends SearchRequest {
	@JsonProperty("attributeDbIds")
	private List<String> attributeDbIds = null;

	@JsonProperty("attributeNames")
	private List<String> attributeNames = null;

	@JsonProperty("attributeValueDbIds")
	private List<String> attributeValueDbIds = null;

	@JsonProperty("commonCropNames")
	private List<String> commonCropNames = null;

	@JsonProperty("dataTypes")
	private List<TraitDataType> dataTypes = null;

	@JsonProperty("germplasmDbIds")
	private List<String> germplasmDbIds = null;

	@JsonProperty("germplasmNames")
	private List<String> germplasmNames = null;

	@JsonProperty("methodDbIds")
	private List<String> methodDbIds = null;

	@JsonProperty("ontologyDbIds")
	private List<String> ontologyDbIds = null;

	@JsonProperty("programDbIds")
	private List<String> programDbIds = null;

	@JsonProperty("programNames")
	private List<String> programNames = null;

	@JsonProperty("scaleDbIds")
	private List<String> scaleDbIds = null;

	@JsonProperty("traitClasses")
	private List<String> traitClasses = null;

	@JsonProperty("traitDbIds")
	private List<String> traitDbIds = null;

	public GermplasmAttributeValueSearchRequest attributeDbIds(List<String> attributeDbIds) {
		this.attributeDbIds = attributeDbIds;
		return this;
	}

	public GermplasmAttributeValueSearchRequest addAttributeDbIdsItem(String attributeDbIdsItem) {
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

	public GermplasmAttributeValueSearchRequest attributeNames(List<String> attributeNames) {
		this.attributeNames = attributeNames;
		return this;
	}

	public GermplasmAttributeValueSearchRequest addAttributeNamesItem(String attributeNamesItem) {
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

	public GermplasmAttributeValueSearchRequest attributeValueDbIds(List<String> attributeValueDbIds) {
		this.attributeValueDbIds = attributeValueDbIds;
		return this;
	}

	public GermplasmAttributeValueSearchRequest addAttributeValueDbIdsItem(String attributeValueDbIdsItem) {
		if (this.attributeValueDbIds == null) {
			this.attributeValueDbIds = new ArrayList<String>();
		}
		this.attributeValueDbIds.add(attributeValueDbIdsItem);
		return this;
	}

	public List<String> getAttributeValueDbIds() {
		return attributeValueDbIds;
	}

	public void setAttributeValueDbIds(List<String> attributeValueDbIds) {
		this.attributeValueDbIds = attributeValueDbIds;
	}

	public GermplasmAttributeValueSearchRequest commonCropNames(List<String> commonCropNames) {
		this.commonCropNames = commonCropNames;
		return this;
	}

	public GermplasmAttributeValueSearchRequest addCommonCropNamesItem(String commonCropNamesItem) {
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

	public GermplasmAttributeValueSearchRequest dataTypes(List<TraitDataType> dataTypes) {
		this.dataTypes = dataTypes;
		return this;
	}

	public GermplasmAttributeValueSearchRequest addDataTypesItem(TraitDataType dataTypesItem) {
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

	public GermplasmAttributeValueSearchRequest germplasmDbIds(List<String> germplasmDbIds) {
		this.germplasmDbIds = germplasmDbIds;
		return this;
	}

	public GermplasmAttributeValueSearchRequest addGermplasmDbIdsItem(String germplasmDbIdsItem) {
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

	public GermplasmAttributeValueSearchRequest germplasmNames(List<String> germplasmNames) {
		this.germplasmNames = germplasmNames;
		return this;
	}

	public GermplasmAttributeValueSearchRequest addGermplasmNamesItem(String germplasmNamesItem) {
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

	public GermplasmAttributeValueSearchRequest methodDbIds(List<String> methodDbIds) {
		this.methodDbIds = methodDbIds;
		return this;
	}

	public GermplasmAttributeValueSearchRequest addMethodDbIdsItem(String methodDbIdsItem) {
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

	public GermplasmAttributeValueSearchRequest ontologyDbIds(List<String> ontologyDbIds) {
		this.ontologyDbIds = ontologyDbIds;
		return this;
	}

	public GermplasmAttributeValueSearchRequest addOntologyDbIdsItem(String ontologyDbIdsItem) {
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

	public GermplasmAttributeValueSearchRequest programDbIds(List<String> programDbIds) {
		this.programDbIds = programDbIds;
		return this;
	}

	public GermplasmAttributeValueSearchRequest addProgramDbIdsItem(String programDbIdsItem) {
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

	public GermplasmAttributeValueSearchRequest programNames(List<String> programNames) {
		this.programNames = programNames;
		return this;
	}

	public GermplasmAttributeValueSearchRequest addProgramNamesItem(String programNamesItem) {
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

	public GermplasmAttributeValueSearchRequest scaleDbIds(List<String> scaleDbIds) {
		this.scaleDbIds = scaleDbIds;
		return this;
	}

	public GermplasmAttributeValueSearchRequest addScaleDbIdsItem(String scaleDbIdsItem) {
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

	public GermplasmAttributeValueSearchRequest traitClasses(List<String> traitClasses) {
		this.traitClasses = traitClasses;
		return this;
	}

	public GermplasmAttributeValueSearchRequest addTraitClassesItem(String traitClassesItem) {
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

	public GermplasmAttributeValueSearchRequest traitDbIds(List<String> traitDbIds) {
		this.traitDbIds = traitDbIds;
		return this;
	}

	public GermplasmAttributeValueSearchRequest addTraitDbIdsItem(String traitDbIdsItem) {
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

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		GermplasmAttributeValueSearchRequest germplasmAttributeValueSearchRequest = (GermplasmAttributeValueSearchRequest) o;
		return Objects.equals(this.attributeDbIds, germplasmAttributeValueSearchRequest.attributeDbIds)
				&& Objects.equals(this.attributeNames, germplasmAttributeValueSearchRequest.attributeNames)
				&& Objects.equals(this.attributeValueDbIds, germplasmAttributeValueSearchRequest.attributeValueDbIds)
				&& Objects.equals(this.commonCropNames, germplasmAttributeValueSearchRequest.commonCropNames)
				&& Objects.equals(this.dataTypes, germplasmAttributeValueSearchRequest.dataTypes)
				&& Objects.equals(this.externalReferenceIds, germplasmAttributeValueSearchRequest.externalReferenceIds)
				&& Objects.equals(this.externalReferenceSources,
						germplasmAttributeValueSearchRequest.externalReferenceSources)
				&& Objects.equals(this.germplasmDbIds, germplasmAttributeValueSearchRequest.germplasmDbIds)
				&& Objects.equals(this.germplasmNames, germplasmAttributeValueSearchRequest.germplasmNames)
				&& Objects.equals(this.methodDbIds, germplasmAttributeValueSearchRequest.methodDbIds)
				&& Objects.equals(this.ontologyDbIds, germplasmAttributeValueSearchRequest.ontologyDbIds)
				&& Objects.equals(this.page, germplasmAttributeValueSearchRequest.page)
				&& Objects.equals(this.pageSize, germplasmAttributeValueSearchRequest.pageSize)
				&& Objects.equals(this.programDbIds, germplasmAttributeValueSearchRequest.programDbIds)
				&& Objects.equals(this.programNames, germplasmAttributeValueSearchRequest.programNames)
				&& Objects.equals(this.scaleDbIds, germplasmAttributeValueSearchRequest.scaleDbIds)
				&& Objects.equals(this.traitClasses, germplasmAttributeValueSearchRequest.traitClasses)
				&& Objects.equals(this.traitDbIds, germplasmAttributeValueSearchRequest.traitDbIds);
	}

	@Override
	public int hashCode() {
		return Objects.hash(attributeDbIds, attributeNames, attributeValueDbIds, commonCropNames, dataTypes,
				externalReferenceIds, externalReferenceSources, germplasmDbIds, germplasmNames, methodDbIds,
				ontologyDbIds, page, pageSize, programDbIds, programNames, scaleDbIds, traitClasses, traitDbIds);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class GermplasmAttributeValueSearchRequest {\n");

		sb.append("    attributeDbIds: ").append(toIndentedString(attributeDbIds)).append("\n");
		sb.append("    attributeNames: ").append(toIndentedString(attributeNames)).append("\n");
		sb.append("    attributeValueDbIds: ").append(toIndentedString(attributeValueDbIds)).append("\n");
		sb.append("    commonCropNames: ").append(toIndentedString(commonCropNames)).append("\n");
		sb.append("    dataTypes: ").append(toIndentedString(dataTypes)).append("\n");
		sb.append("    externalReferenceIds: ").append(toIndentedString(externalReferenceIds)).append("\n");
		sb.append("    externalReferenceSources: ").append(toIndentedString(externalReferenceSources)).append("\n");
		sb.append("    germplasmDbIds: ").append(toIndentedString(germplasmDbIds)).append("\n");
		sb.append("    germplasmNames: ").append(toIndentedString(germplasmNames)).append("\n");
		sb.append("    methodDbIds: ").append(toIndentedString(methodDbIds)).append("\n");
		sb.append("    ontologyDbIds: ").append(toIndentedString(ontologyDbIds)).append("\n");
		sb.append("    page: ").append(toIndentedString(page)).append("\n");
		sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
		sb.append("    programDbIds: ").append(toIndentedString(programDbIds)).append("\n");
		sb.append("    programNames: ").append(toIndentedString(programNames)).append("\n");
		sb.append("    scaleDbIds: ").append(toIndentedString(scaleDbIds)).append("\n");
		sb.append("    traitClasses: ").append(toIndentedString(traitClasses)).append("\n");
		sb.append("    traitDbIds: ").append(toIndentedString(traitDbIds)).append("\n");
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
		if (this.attributeValueDbIds != null)
			count += this.attributeValueDbIds.size();
		if (this.commonCropNames != null)
			count += this.commonCropNames.size();
		if (this.dataTypes != null)
			count += this.dataTypes.size();
		if (this.externalReferenceIds != null)
			count += this.externalReferenceIds.size();
		if (this.externalReferenceSources != null)
			count += this.externalReferenceSources.size();
		if (this.germplasmDbIds != null)
			count += this.germplasmDbIds.size();
		if (this.germplasmNames != null)
			count += this.germplasmNames.size();
		if (this.methodDbIds != null)
			count += this.methodDbIds.size();
		if (this.ontologyDbIds != null)
			count += this.ontologyDbIds.size();
		if (this.programDbIds != null)
			count += this.programDbIds.size();
		if (this.programNames != null)
			count += this.programNames.size();
		if (this.scaleDbIds != null)
			count += this.scaleDbIds.size();
		if (this.traitClasses != null)
			count += this.traitClasses.size();
		if (this.traitDbIds != null)
			count += this.traitDbIds.size();
		return count;
	}
}
