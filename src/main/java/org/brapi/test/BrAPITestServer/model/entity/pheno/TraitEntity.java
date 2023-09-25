package org.brapi.test.BrAPITestServer.model.entity.pheno;

import java.util.List;

import javax.persistence.*;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;

@Entity
@Table(name = "trait")
public class TraitEntity extends BrAPIPrimaryEntity implements OntologyReferenceHolder{
	@ElementCollection
	private List<String> alternativeAbbreviations;
	@Column
	private String attribute;
	@Column
	private String attributePUI;
	@Column
	private String entity;
	@Column
	private String entityPUI;
	@Column
	private String mainAbbreviation;
	@OneToOne(fetch = FetchType.LAZY)
	private OntologyEntity ontology;
	@JoinTable
	@OneToMany(cascade = CascadeType.ALL)
	private List<OntologyReferenceEntity> ontologyReference;
	@Column
	private String status;
	@ElementCollection
	private List<String> synonyms;
	@Column
	private String traitClass;
	@Column
	private String traitDescription;
	@Column
	private String traitName;
	@Column
	private String traitPUI;
	@OneToMany(mappedBy = "trait")
	private List<VariableBaseEntity> variables;
	
	public String getAttributePUI() {
		return attributePUI;
	}
	public void setAttributePUI(String attributePUI) {
		this.attributePUI = attributePUI;
	}
	public String getEntityPUI() {
		return entityPUI;
	}
	public void setEntityPUI(String entityPUI) {
		this.entityPUI = entityPUI;
	}
	public String getTraitPUI() {
		return traitPUI;
	}
	public void setTraitPUI(String traitPUI) {
		this.traitPUI = traitPUI;
	}
	public List<String> getAlternativeAbbreviations() {
		return alternativeAbbreviations;
	}
	public void setAlternativeAbbreviations(List<String> alternativeAbbreviations) {
		this.alternativeAbbreviations = alternativeAbbreviations;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public String getMainAbbreviation() {
		return mainAbbreviation;
	}
	public void setMainAbbreviation(String mainAbbreviation) {
		this.mainAbbreviation = mainAbbreviation;
	}
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<String> getSynonyms() {
		return synonyms;
	}
	public void setSynonyms(List<String> synonyms) {
		this.synonyms = synonyms;
	}
	public String getTraitClass() {
		return traitClass;
	}
	public void setTraitClass(String traitClass) {
		this.traitClass = traitClass;
	}
	public String getTraitDescription() {
		return traitDescription;
	}
	public void setTraitDescription(String traitDescription) {
		this.traitDescription = traitDescription;
	}
	public String getTraitName() {
		return traitName;
	}
	public void setTraitName(String traitName) {
		this.traitName = traitName;
	}
	public List<VariableBaseEntity> getVariables() {
		return variables;
	}
	public void setVariables(List<VariableBaseEntity> variables) {
		this.variables = variables;
	}
}
