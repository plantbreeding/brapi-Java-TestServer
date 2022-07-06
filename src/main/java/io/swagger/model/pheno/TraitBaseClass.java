package io.swagger.model.pheno;

import java.util.Objects;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.BrAPIDataModel;
import io.swagger.model.OntologyReference;

import java.util.ArrayList;
import java.util.List;
import org.brapi.test.BrAPITestServer.service.UpdateUtility;

public class TraitBaseClass extends BrAPIDataModel {
	@JsonProperty("alternativeAbbreviations")
	private Optional<List<String>> alternativeAbbreviations = null;

	@JsonProperty("attribute")
	private Optional<String> attribute = null;

	@JsonProperty("attributePUI")
	private Optional<String> attributePUI = null;

	@JsonProperty("entity")
	private Optional<String> entity = null;

	@JsonProperty("entityPUI")
	private Optional<String> entityPUI = null;

	@JsonProperty("mainAbbreviation")
	private Optional<String> mainAbbreviation = null;

	@JsonProperty("ontologyReference")
	private Optional<OntologyReference> ontologyReference = null;

	@JsonProperty("status")
	private Optional<String> status = null;

	@JsonProperty("synonyms")
	private Optional<List<String>> synonyms = null;

	@JsonProperty("traitClass")
	private Optional<String> traitClass = null;

	@JsonProperty("traitDescription")
	private Optional<String> traitDescription = null;

	@JsonProperty("traitName")
	private Optional<String> traitName = null;

	@JsonProperty("traitPUI")
	private Optional<String> traitPUI = null;

	public TraitBaseClass alternativeAbbreviations(List<String> alternativeAbbreviations) {
		this.alternativeAbbreviations = UpdateUtility.setField(alternativeAbbreviations);
		return this;
	}

	public TraitBaseClass addAlternativeAbbreviationsItem(String alternativeAbbreviationsItem) {
		if (this.alternativeAbbreviations == null) {
			this.alternativeAbbreviations = UpdateUtility.setField(new ArrayList<String>());
		}
		this.alternativeAbbreviations.get().add(alternativeAbbreviationsItem);
		return this;
	}

	public Optional<List<String>> getAlternativeAbbreviations() {
		return alternativeAbbreviations;
	}

	public void setAlternativeAbbreviations(List<String> alternativeAbbreviations) {
		this.alternativeAbbreviations = UpdateUtility.setField(alternativeAbbreviations);
	}

	public TraitBaseClass attribute(String attribute) {
		this.attribute = UpdateUtility.setField(attribute);
		return this;
	}

	public Optional<String> getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = UpdateUtility.setField(attribute);
	}

	public TraitBaseClass attributePUI(String attributePUI) {
		this.attributePUI = UpdateUtility.setField(attributePUI);
		return this;
	}

	public Optional<String> getAttributePUI() {
		return attributePUI;
	}

	public void setAttributePUI(String attributePUI) {
		this.attributePUI = UpdateUtility.setField(attributePUI);
	}

	public TraitBaseClass entity(String entity) {
		this.entity = UpdateUtility.setField(entity);
		return this;
	}

	public Optional<String> getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = UpdateUtility.setField(entity);
	}

	public TraitBaseClass entityPUI(String entityPUI) {
		this.entityPUI = UpdateUtility.setField(entityPUI);
		return this;
	}

	public Optional<String> getEntityPUI() {
		return entityPUI;
	}

	public void setEntityPUI(String entityPUI) {
		this.entityPUI = UpdateUtility.setField(entityPUI);
	}

	public TraitBaseClass mainAbbreviation(String mainAbbreviation) {
		this.mainAbbreviation = UpdateUtility.setField(mainAbbreviation);
		return this;
	}

	public Optional<String> getMainAbbreviation() {
		return mainAbbreviation;
	}

	public void setMainAbbreviation(String mainAbbreviation) {
		this.mainAbbreviation = UpdateUtility.setField(mainAbbreviation);
	}

	public TraitBaseClass ontologyReference(OntologyReference ontologyReference) {
		this.ontologyReference = UpdateUtility.setField(ontologyReference);
		return this;
	}

	public Optional<OntologyReference> getOntologyReference() {
		return ontologyReference;
	}

	public void setOntologyReference(OntologyReference ontologyReference) {
		this.ontologyReference = UpdateUtility.setField(ontologyReference);
	}

	public TraitBaseClass status(String status) {
		this.status = UpdateUtility.setField(status);
		return this;
	}

	public Optional<String> getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = UpdateUtility.setField(status);
	}

	public TraitBaseClass synonyms(List<String> synonyms) {
		this.synonyms = UpdateUtility.setField(synonyms);
		return this;
	}

	public TraitBaseClass addSynonymsItem(String synonymsItem) {
		if (this.synonyms == null) {
			this.synonyms = UpdateUtility.setField(new ArrayList<String>());
		}
		this.synonyms.get().add(synonymsItem);
		return this;
	}

	public Optional<List<String>> getSynonyms() {
		return synonyms;
	}

	public void setSynonyms(List<String> synonyms) {
		this.synonyms = UpdateUtility.setField(synonyms);
	}

	public TraitBaseClass traitClass(String traitClass) {
		this.traitClass = UpdateUtility.setField(traitClass);
		return this;
	}

	public Optional<String> getTraitClass() {
		return traitClass;
	}

	public void setTraitClass(String traitClass) {
		this.traitClass = UpdateUtility.setField(traitClass);
	}

	public TraitBaseClass traitDescription(String traitDescription) {
		this.traitDescription = UpdateUtility.setField(traitDescription);
		return this;
	}

	public Optional<String> getTraitDescription() {
		return traitDescription;
	}

	public void setTraitDescription(String traitDescription) {
		this.traitDescription = UpdateUtility.setField(traitDescription);
	}

	public TraitBaseClass traitName(String traitName) {
		this.traitName = UpdateUtility.setField(traitName);
		return this;
	}

	public Optional<String> getTraitName() {
		return traitName;
	}

	public void setTraitName(String traitName) {
		this.traitName = UpdateUtility.setField(traitName);
	}

	public TraitBaseClass traitPUI(String traitPUI) {
		this.traitPUI = UpdateUtility.setField(traitPUI);
		return this;
	}

	public Optional<String> getTraitPUI() {
		return traitPUI;
	}

	public void setTraitPUI(String traitPUI) {
		this.traitPUI = UpdateUtility.setField(traitPUI);
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

	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
