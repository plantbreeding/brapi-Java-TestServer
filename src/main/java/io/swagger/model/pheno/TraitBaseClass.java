package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ExternalReferences;
import io.swagger.model.OntologyReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * TraitBaseClass
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class TraitBaseClass {
	@JsonProperty("additionalInfo")
	@Valid
	private Map<String, Object> additionalInfo = null;
	@JsonProperty("alternativeAbbreviations")
	@Valid
	private List<String> alternativeAbbreviations = null;

	@JsonProperty("attribute")
	private String attribute = null;

	@JsonProperty("entity")
	private String entity = null;

	@JsonProperty("externalReferences")
	private ExternalReferences externalReferences = null;

	@JsonProperty("mainAbbreviation")
	private String mainAbbreviation = null;

	@JsonProperty("ontologyReference")
	private OntologyReference ontologyReference = null;

	@JsonProperty("status")
	private String status = null;

	@JsonProperty("synonyms")
	@Valid
	private List<String> synonyms = null;

	@JsonProperty("traitClass")
	private String traitClass = null;

	@JsonProperty("traitDescription")
	private String traitDescription = null;

	@JsonProperty("traitName")
	private String traitName = null;

	public TraitBaseClass additionalInfo(Map<String, Object> additionalInfo) {
		this.additionalInfo = additionalInfo;
		return this;
	}

	public TraitBaseClass putAdditionalInfoItem(String key, String additionalInfoItem) {
		if (this.additionalInfo == null) {
			this.additionalInfo = new HashMap<String, Object>();
		}
		this.additionalInfo.put(key, additionalInfoItem);
		return this;
	}

	/**
	 * Additional arbitrary info
	 * 
	 * @return additionalInfo
	 **/
	@ApiModelProperty(value = "Additional arbitrary info")

	public Map<String, Object> getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(Map<String, Object> additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	public TraitBaseClass alternativeAbbreviations(List<String> alternativeAbbreviations) {
		this.alternativeAbbreviations = alternativeAbbreviations;
		return this;
	}

	public TraitBaseClass addAlternativeAbbreviationsItem(String alternativeAbbreviationsItem) {
		if (this.alternativeAbbreviations == null) {
			this.alternativeAbbreviations = new ArrayList<String>();
		}
		this.alternativeAbbreviations.add(alternativeAbbreviationsItem);
		return this;
	}

	/**
	 * Other frequent abbreviations of the trait, if any. These abbreviations do not
	 * have to follow a convention
	 * 
	 * @return alternativeAbbreviations
	 **/
	@ApiModelProperty(example = "[\"H\",\"PH\",\"H1\"]", value = "Other frequent abbreviations of the trait, if any. These abbreviations do not have to follow a convention")

	public List<String> getAlternativeAbbreviations() {
		return alternativeAbbreviations;
	}

	public void setAlternativeAbbreviations(List<String> alternativeAbbreviations) {
		this.alternativeAbbreviations = alternativeAbbreviations;
	}

	public TraitBaseClass attribute(String attribute) {
		this.attribute = attribute;
		return this;
	}

	/**
	 * A trait can be decomposed as \"Trait\" = \"Entity\" + \"Attribute\", the
	 * attribute is the observed feature (or characteristic) of the entity e.g., for
	 * \"grain colour\", attribute = \"colour\"
	 * 
	 * @return attribute
	 **/
	@ApiModelProperty(example = "height", value = "A trait can be decomposed as \"Trait\" = \"Entity\" + \"Attribute\", the attribute is the observed feature (or characteristic) of the entity e.g., for \"grain colour\", attribute = \"colour\"")

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public TraitBaseClass entity(String entity) {
		this.entity = entity;
		return this;
	}

	/**
	 * A trait can be decomposed as \"Trait\" = \"Entity\" + \"Attribute\", the
	 * entity is the part of the plant that the trait refers to e.g., for \"grain
	 * colour\", entity = \"grain\"
	 * 
	 * @return entity
	 **/
	@ApiModelProperty(example = "Stalk", value = "A trait can be decomposed as \"Trait\" = \"Entity\" + \"Attribute\", the entity is the part of the plant that the trait refers to e.g., for \"grain colour\", entity = \"grain\"")

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public TraitBaseClass externalReferences(ExternalReferences externalReferences) {
		this.externalReferences = externalReferences;
		return this;
	}

	/**
	 * Get externalReferences
	 * 
	 * @return externalReferences
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public ExternalReferences getExternalReferences() {
		return externalReferences;
	}

	public void setExternalReferences(ExternalReferences externalReferences) {
		this.externalReferences = externalReferences;
	}

	public TraitBaseClass mainAbbreviation(String mainAbbreviation) {
		this.mainAbbreviation = mainAbbreviation;
		return this;
	}

	/**
	 * Main abbreviation for trait name. (examples: \"Carotenoid content\" =>
	 * \"CC\")
	 * 
	 * @return mainAbbreviation
	 **/
	@ApiModelProperty(example = "PH", value = "Main abbreviation for trait name. (examples: \"Carotenoid content\" => \"CC\")")

	public String getMainAbbreviation() {
		return mainAbbreviation;
	}

	public void setMainAbbreviation(String mainAbbreviation) {
		this.mainAbbreviation = mainAbbreviation;
	}

	public TraitBaseClass ontologyReference(OntologyReference ontologyReference) {
		this.ontologyReference = ontologyReference;
		return this;
	}

	/**
	 * Get ontologyReference
	 * 
	 * @return ontologyReference
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public OntologyReference getOntologyReference() {
		return ontologyReference;
	}

	public void setOntologyReference(OntologyReference ontologyReference) {
		this.ontologyReference = ontologyReference;
	}

	public TraitBaseClass status(String status) {
		this.status = status;
		return this;
	}

	/**
	 * Trait status (examples: \"recommended\", \"obsolete\", \"legacy\", etc.)
	 * 
	 * @return status
	 **/
	@ApiModelProperty(example = "recommended", value = "Trait status (examples: \"recommended\", \"obsolete\", \"legacy\", etc.)")

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TraitBaseClass synonyms(List<String> synonyms) {
		this.synonyms = synonyms;
		return this;
	}

	public TraitBaseClass addSynonymsItem(String synonymsItem) {
		if (this.synonyms == null) {
			this.synonyms = new ArrayList<String>();
		}
		this.synonyms.add(synonymsItem);
		return this;
	}

	/**
	 * Other trait names
	 * 
	 * @return synonyms
	 **/
	@ApiModelProperty(example = "[\"Height\",\"Plant Height\",\"Stalk Height\",\"Canopy Height\"]", value = "Other trait names")

	public List<String> getSynonyms() {
		return synonyms;
	}

	public void setSynonyms(List<String> synonyms) {
		this.synonyms = synonyms;
	}

	public TraitBaseClass traitClass(String traitClass) {
		this.traitClass = traitClass;
		return this;
	}

	/**
	 * Trait class. (examples: \"morphological\", \"phenological\", \"agronomical\",
	 * \"physiological\", \"abiotic stress\", \"biotic stress\", \"biochemical\",
	 * \"quality traits\", \"fertility\", etc.)
	 * 
	 * @return traitClass
	 **/
	@ApiModelProperty(example = "phenological", value = "Trait class. (examples: \"morphological\", \"phenological\", \"agronomical\", \"physiological\", \"abiotic stress\", \"biotic stress\", \"biochemical\", \"quality traits\", \"fertility\", etc.)")

	public String getTraitClass() {
		return traitClass;
	}

	public void setTraitClass(String traitClass) {
		this.traitClass = traitClass;
	}

	public TraitBaseClass traitDescription(String traitDescription) {
		this.traitDescription = traitDescription;
		return this;
	}

	/**
	 * The description of a trait
	 * 
	 * @return traitDescription
	 **/
	@ApiModelProperty(example = "The height of the plant", value = "The description of a trait")

	public String getTraitDescription() {
		return traitDescription;
	}

	public void setTraitDescription(String traitDescription) {
		this.traitDescription = traitDescription;
	}

	public TraitBaseClass traitName(String traitName) {
		this.traitName = traitName;
		return this;
	}

	/**
	 * The human readable name of a trait MIAPPE V1.1 (DM-86) Trait - Name of the
	 * (plant or environmental) trait under observation
	 * 
	 * @return traitName
	 **/
	@ApiModelProperty(example = "Height", value = "The human readable name of a trait  MIAPPE V1.1 (DM-86) Trait - Name of the (plant or environmental) trait under observation")

	public String getTraitName() {
		return traitName;
	}

	public void setTraitName(String traitName) {
		this.traitName = traitName;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		TraitBaseClass traitBaseClass = (TraitBaseClass) o;
		return Objects.equals(this.alternativeAbbreviations, traitBaseClass.alternativeAbbreviations)
				&& Objects.equals(this.attribute, traitBaseClass.attribute)
				&& Objects.equals(this.entity, traitBaseClass.entity)
				&& Objects.equals(this.externalReferences, traitBaseClass.externalReferences)
				&& Objects.equals(this.mainAbbreviation, traitBaseClass.mainAbbreviation)
				&& Objects.equals(this.ontologyReference, traitBaseClass.ontologyReference)
				&& Objects.equals(this.status, traitBaseClass.status)
				&& Objects.equals(this.synonyms, traitBaseClass.synonyms)
				&& Objects.equals(this.traitClass, traitBaseClass.traitClass)
				&& Objects.equals(this.traitDescription, traitBaseClass.traitDescription)
				&& Objects.equals(this.traitName, traitBaseClass.traitName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(alternativeAbbreviations, attribute, entity, externalReferences, mainAbbreviation,
				ontologyReference, status, synonyms, traitClass, traitDescription, traitName);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class TraitBaseClass {\n");

		sb.append("    alternativeAbbreviations: ").append(toIndentedString(alternativeAbbreviations)).append("\n");
		sb.append("    attribute: ").append(toIndentedString(attribute)).append("\n");
		sb.append("    entity: ").append(toIndentedString(entity)).append("\n");
		sb.append("    externalReferences: ").append(toIndentedString(externalReferences)).append("\n");
		sb.append("    mainAbbreviation: ").append(toIndentedString(mainAbbreviation)).append("\n");
		sb.append("    ontologyReference: ").append(toIndentedString(ontologyReference)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    synonyms: ").append(toIndentedString(synonyms)).append("\n");
		sb.append("    traitClass: ").append(toIndentedString(traitClass)).append("\n");
		sb.append("    traitDescription: ").append(toIndentedString(traitDescription)).append("\n");
		sb.append("    traitName: ").append(toIndentedString(traitName)).append("\n");
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
}
