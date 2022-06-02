package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.SearchRequest;
import io.swagger.model.SearchRequestParametersPaging;
import io.swagger.model.pheno.TraitDataType;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

public class GermplasmAttributeSearchRequest extends SearchRequest {

	@JsonProperty("attributeDbIds")
	private List<String> attributeDbIds = null;

	@JsonProperty("attributeNames")
	private List<String> attributeNames = null;

	@JsonProperty("dataTypes")
	private List<TraitDataType> dataTypes = null;

	@JsonProperty("methodDbIds")
	private List<String> methodDbIds = null;

	@JsonProperty("ontologyDbIds")
	private List<String> ontologyDbIds = null;

	@JsonProperty("scaleDbIds")
	private List<String> scaleDbIds = null;

	@JsonProperty("studyDbId")
	private List<String> studyDbId = null;

	@JsonProperty("traitClasses")
	private List<String> traitClasses = null;

	@JsonProperty("traitDbIds")
	private List<String> traitDbIds = null;

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

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		GermplasmAttributeSearchRequest germplasmAttributeSearchRequest = (GermplasmAttributeSearchRequest) o;
		return Objects.equals(this.externalReferenceIds, germplasmAttributeSearchRequest.externalReferenceIds)
				&& Objects.equals(this.externalReferenceSources,
						germplasmAttributeSearchRequest.externalReferenceSources)
				&& Objects.equals(this.attributeDbIds, germplasmAttributeSearchRequest.attributeDbIds)
				&& Objects.equals(this.attributeNames, germplasmAttributeSearchRequest.attributeNames)
				&& Objects.equals(this.dataTypes, germplasmAttributeSearchRequest.dataTypes)
				&& Objects.equals(this.methodDbIds, germplasmAttributeSearchRequest.methodDbIds)
				&& Objects.equals(this.ontologyDbIds, germplasmAttributeSearchRequest.ontologyDbIds)
				&& Objects.equals(this.scaleDbIds, germplasmAttributeSearchRequest.scaleDbIds)
				&& Objects.equals(this.studyDbId, germplasmAttributeSearchRequest.studyDbId)
				&& Objects.equals(this.traitClasses, germplasmAttributeSearchRequest.traitClasses)
				&& Objects.equals(this.traitDbIds, germplasmAttributeSearchRequest.traitDbIds) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(externalReferenceIds, externalReferenceSources, attributeDbIds, attributeNames, dataTypes,
				methodDbIds, ontologyDbIds, scaleDbIds, studyDbId, traitClasses, traitDbIds, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class GermplasmAttributeSearchRequest {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    externalReferenceIds: ").append(toIndentedString(externalReferenceIds)).append("\n");
		sb.append("    externalReferenceSources: ").append(toIndentedString(externalReferenceSources)).append("\n");
		sb.append("    attributeDbIds: ").append(toIndentedString(attributeDbIds)).append("\n");
		sb.append("    attributeNames: ").append(toIndentedString(attributeNames)).append("\n");
		sb.append("    dataTypes: ").append(toIndentedString(dataTypes)).append("\n");
		sb.append("    methodDbIds: ").append(toIndentedString(methodDbIds)).append("\n");
		sb.append("    ontologyDbIds: ").append(toIndentedString(ontologyDbIds)).append("\n");
		sb.append("    scaleDbIds: ").append(toIndentedString(scaleDbIds)).append("\n");
		sb.append("    studyDbId: ").append(toIndentedString(studyDbId)).append("\n");
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
		if (this.externalReferenceIds != null)
			count += this.externalReferenceIds.size();
		if (this.externalReferenceSources != null)
			count += this.externalReferenceSources.size();
		if (this.attributeDbIds != null)
			count += this.attributeDbIds.size();
		if (this.attributeNames != null)
			count += this.attributeNames.size();
		if (this.dataTypes != null)
			count += this.dataTypes.size();
		if (this.methodDbIds != null)
			count += this.methodDbIds.size();
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
		return count;
	}
}
