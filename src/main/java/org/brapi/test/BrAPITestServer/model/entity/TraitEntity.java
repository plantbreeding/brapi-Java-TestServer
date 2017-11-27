package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "trait")
public class TraitEntity extends BaseEntity {
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

	@OneToMany(mappedBy = "traitDbId")
	private List<TraitSynonymEntity> synonyms;
	@OneToMany(mappedBy = "traitDbId")
	private List<TraitAbbreviationEntity> alternativeAbbreviations;
	@OneToMany(mappedBy = "trait")
	private List<ObservationVariableEntity> observationVariables;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTraitClass() {
		return traitClass;
	}

	public void setTraitClass(String traitClass) {
		this.traitClass = traitClass;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMainAbbreviation() {
		return mainAbbreviation;
	}

	public void setMainAbbreviation(String mainAbbreviation) {
		this.mainAbbreviation = mainAbbreviation;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getXref() {
		return xref;
	}

	public void setXref(String xref) {
		this.xref = xref;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public List<TraitSynonymEntity> getSynonyms() {
		return synonyms;
	}

	public void setSynonyms(List<TraitSynonymEntity> synonyms) {
		this.synonyms = synonyms;
	}

	public List<TraitAbbreviationEntity> getAlternativeAbbreviations() {
		return alternativeAbbreviations;
	}

	public void setAlternativeAbbreviations(List<TraitAbbreviationEntity> alternativeAbbreviations) {
		this.alternativeAbbreviations = alternativeAbbreviations;
	}

	public List<ObservationVariableEntity> getObservationVariables() {
		return observationVariables;
	}

	public void setObservationVariables(List<ObservationVariableEntity> observationVariables) {
		this.observationVariables = observationVariables;
	}
	
}
