package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trait")
public class TraitEntity extends BrAPIBaseEntity implements OntologyInterface{
	@Column
	private String name;
	@Column
	private String traitClass;
	@Column
	private String description;
	@Column
	private String mainAbbreviation;
	@Column
	private String entity;
	@Column
	private String attribute;
	@Column
	private String status;
	@Column
	private String xref;
	@Column
	private String defaultValue;

	@OneToMany(mappedBy = "trait", cascade = CascadeType.ALL)
	private List<TraitSynonymEntity> synonyms;
	@OneToMany(mappedBy = "trait", cascade = CascadeType.ALL)
	private List<TraitAbbreviationEntity> alternativeAbbreviations;
	@OneToMany(mappedBy = "trait")
	private List<VariableBaseEntity> variables;
	@OneToOne
	private OntologyEntity ontology;
	@JoinTable
	@OneToMany(cascade = CascadeType.ALL)
	private List<OntologyReferenceEntity> ontologyReference;
	
	
	public OntologyEntity getOntology() {
		return ontology;
	}

	public void setOntology(OntologyEntity ontology) {
		this.ontology = ontology;
	}

	public List<OntologyReferenceEntity> getOntologyReference() {
		return ontologyReference;
	}

	public void setOntologyReference(List<OntologyReferenceEntity> ontologyReference) {
		this.ontologyReference = ontologyReference;
	}

	public List<TraitAbbreviationEntity> getAlternativeAbbreviations() {
		return alternativeAbbreviations;
	}

	public String getAttribute() {
		return attribute;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public String getDescription() {
		return description;
	}

	public String getEntity() {
		return entity;
	}

	public String getMainAbbreviation() {
		return mainAbbreviation;
	}

	public String getName() {
		return name;
	}

	public String getStatus() {
		return status;
	}

	public List<TraitSynonymEntity> getSynonyms() {
		return synonyms;
	}

	public List<VariableBaseEntity> getVariables() {
		return variables;
	}

	public String getXref() {
		return xref;
	}

	public void setAlternativeAbbreviations(List<TraitAbbreviationEntity> alternativeAbbreviations) {
		this.alternativeAbbreviations = alternativeAbbreviations;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public void setMainAbbreviation(String mainAbbreviation) {
		this.mainAbbreviation = mainAbbreviation;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setSynonyms(List<TraitSynonymEntity> synonyms) {
		this.synonyms = synonyms;
	}

	public void setVariables(List<VariableBaseEntity> variables) {
		this.variables = variables;
	}

	public void setXref(String xref) {
		this.xref = xref;
	}

	public String getTraitClass() {
		return traitClass;
	}

	public void setTraitClass(String traitClass) {
		this.traitClass = traitClass;
	}

}
