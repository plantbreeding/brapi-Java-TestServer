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

/**
 * GermplasmAttributeSearchRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
public class GermplasmAttributeSearchRequest extends SearchRequestParametersPaging implements SearchRequest {
	@JsonProperty("externalReferenceIDs")
	@Valid
	private List<String> externalReferenceIDs = null;

	@JsonProperty("externalReferenceSources")
	@Valid
	private List<String> externalReferenceSources = null;

	@JsonProperty("attributeDbIds")
	@Valid
	private List<String> attributeDbIds = null;

	@JsonProperty("attributeNames")
	@Valid
	private List<String> attributeNames = null;

	@JsonProperty("dataTypes")
	@Valid
	private List<TraitDataType> dataTypes = null;

	@JsonProperty("methodDbIds")
	@Valid
	private List<String> methodDbIds = null;

	@JsonProperty("ontologyDbIds")
	@Valid
	private List<String> ontologyDbIds = null;

	@JsonProperty("scaleDbIds")
	@Valid
	private List<String> scaleDbIds = null;

	@JsonProperty("studyDbId")
	@Valid
	private List<String> studyDbId = null;

	@JsonProperty("traitClasses")
	@Valid
	private List<String> traitClasses = null;

	@JsonProperty("traitDbIds")
	@Valid
	private List<String> traitDbIds = null;

	public GermplasmAttributeSearchRequest externalReferenceIDs(List<String> externalReferenceIDs) {
		this.externalReferenceIDs = externalReferenceIDs;
		return this;
	}

	public GermplasmAttributeSearchRequest addExternalReferenceIDsItem(String externalReferenceIDsItem) {
		if (this.externalReferenceIDs == null) {
			this.externalReferenceIDs = new ArrayList<String>();
		}
		this.externalReferenceIDs.add(externalReferenceIDsItem);
		return this;
	}

	/**
	 * List of external references for the trait to search for
	 * 
	 * @return externalReferenceIDs
	 **/
	@ApiModelProperty(example = "[\"http://purl.obolibrary.org/obo/ro.owl\",\"14a19841\"]", value = "List of external references for the trait to search for")

	public List<String> getExternalReferenceIDs() {
		return externalReferenceIDs;
	}

	public void setExternalReferenceIDs(List<String> externalReferenceIDs) {
		this.externalReferenceIDs = externalReferenceIDs;
	}

	public GermplasmAttributeSearchRequest externalReferenceSources(List<String> externalReferenceSources) {
		this.externalReferenceSources = externalReferenceSources;
		return this;
	}

	public GermplasmAttributeSearchRequest addExternalReferenceSourcesItem(String externalReferenceSourcesItem) {
		if (this.externalReferenceSources == null) {
			this.externalReferenceSources = new ArrayList<String>();
		}
		this.externalReferenceSources.add(externalReferenceSourcesItem);
		return this;
	}

	/**
	 * List of external references sources for the trait to search for
	 * 
	 * @return externalReferenceSources
	 **/
	@ApiModelProperty(example = "[\"OBO Library\",\"Field App Name\"]", value = "List of external references sources for the trait to search for")

	public List<String> getExternalReferenceSources() {
		return externalReferenceSources;
	}

	public void setExternalReferenceSources(List<String> externalReferenceSources) {
		this.externalReferenceSources = externalReferenceSources;
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

	/**
	 * List of Germplasm Attribute IDs to search for
	 * 
	 * @return attributeDbIds
	 **/
	@ApiModelProperty(example = "[\"2ef15c9f\",\"318e7f7d\"]", value = "List of Germplasm Attribute IDs to search for")

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

	/**
	 * List of human readable Germplasm Attribute names to search for
	 * 
	 * @return attributeNames
	 **/
	@ApiModelProperty(example = "[\"Plant Height 1\",\"Root Color\"]", value = "List of human readable Germplasm Attribute names to search for")

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

	/**
	 * List of scale data types to filter search results
	 * 
	 * @return dataTypes
	 **/
	@ApiModelProperty(example = "[\"Numerical\",\"Ordinal\",\"Text\"]", value = "List of scale data types to filter search results")
	@Valid
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

	/**
	 * List of methods to filter search results
	 * 
	 * @return methodDbIds
	 **/
	@ApiModelProperty(example = "[\"07e34f83\",\"d3d5517a\"]", value = "List of methods to filter search results")

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

	/**
	 * List of ontology IDs to search for
	 * 
	 * @return ontologyDbIds
	 **/
	@ApiModelProperty(example = "[\"f44f7b23\",\"a26b576e\"]", value = "List of ontology IDs to search for")

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

	/**
	 * List of scales to filter search results
	 * 
	 * @return scaleDbIds
	 **/
	@ApiModelProperty(example = "[\"a13ecffa\",\"7e1afe4f\"]", value = "List of scales to filter search results")

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

	/**
	 * The unique ID of a studies to filter on
	 * 
	 * @return studyDbId
	 **/
	@ApiModelProperty(example = "[\"5bcac0ae\",\"7f48e22d\"]", value = "The unique ID of a studies to filter on")

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

	/**
	 * List of trait classes to filter search results
	 * 
	 * @return traitClasses
	 **/
	@ApiModelProperty(example = "[\"morphological\",\"phenological\",\"agronomical\"]", value = "List of trait classes to filter search results")

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

	/**
	 * List of trait unique ID to filter search results
	 * 
	 * @return traitDbIds
	 **/
	@ApiModelProperty(example = "[\"ef81147b\",\"78d82fad\"]", value = "List of trait unique ID to filter search results")

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
		return Objects.equals(this.externalReferenceIDs, germplasmAttributeSearchRequest.externalReferenceIDs)
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
		return Objects.hash(externalReferenceIDs, externalReferenceSources, attributeDbIds, attributeNames, dataTypes,
				methodDbIds, ontologyDbIds, scaleDbIds, studyDbId, traitClasses, traitDbIds, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class GermplasmAttributeSearchRequest {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    externalReferenceIDs: ").append(toIndentedString(externalReferenceIDs)).append("\n");
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

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	@Override
	public Integer getTotalParameterCount() {
		Integer count = 0;
		if (this.externalReferenceIDs != null)
			count += this.externalReferenceIDs.size();
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
