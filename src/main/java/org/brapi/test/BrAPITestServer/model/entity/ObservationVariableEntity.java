package org.brapi.test.BrAPITestServer.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="observation_variable")
public class ObservationVariableEntity extends BaseEntity{
	@Column
	private String name;
	@Column
	private String growthStage;
	@Column
	private String status;
	@Column
	private String xref;
	@Column
	private String institution;
	@Column
	private String scientist;
	@Column
	private Date submissionTimestamp;
	@Column
	private String language;
	@Column
	private String crop;
	@Column
	private String defaultValue;
	@ManyToOne
	private TraitEntity trait;
	@ManyToOne
	private MethodEntity method;
	@ManyToOne
	private ScaleEntity scale;
	@ManyToOne
	private OntologyEntity ontology;
	@OneToMany(mappedBy="observationVariableDbId")
	private List<ObservationVariableSynonymEntity> synonyms;
	@OneToMany(mappedBy="observationVariableDbId")
	private List<ObservationVariableContextEntity> contextOfUse;
	@OneToMany(mappedBy="observationVariable")
	private List<ObservationEntity> observations;
	

	public List<ObservationEntity> getObservations() {
		return observations;
	}
	public void setObservations(List<ObservationEntity> observations) {
		this.observations = observations;
	}
	public OntologyEntity getOntology() {
		return ontology;
	}
	public void setOntology(OntologyEntity ontology) {
		this.ontology = ontology;
	}
	public List<ObservationVariableSynonymEntity> getSynonyms() {
		return synonyms;
	}
	public void setSynonyms(List<ObservationVariableSynonymEntity> synonyms) {
		this.synonyms = synonyms;
	}
	public List<ObservationVariableContextEntity> getContextOfUse() {
		return contextOfUse;
	}
	public void setContextOfUse(List<ObservationVariableContextEntity> contextOfUse) {
		this.contextOfUse = contextOfUse;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrowthStage() {
		return growthStage;
	}
	public void setGrowthStage(String growthStage) {
		this.growthStage = growthStage;
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
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getScientist() {
		return scientist;
	}
	public void setScientist(String scientist) {
		this.scientist = scientist;
	}
	public Date getSubmissionTimestamp() {
		return submissionTimestamp;
	}
	public void setSubmissionTimestamp(Date submissionTimestamp) {
		this.submissionTimestamp = submissionTimestamp;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCrop() {
		return crop;
	}
	public void setCrop(String crop) {
		this.crop = crop;
	}
	public TraitEntity getTrait() {
		return trait;
	}
	public void setTrait(TraitEntity trait) {
		this.trait = trait;
	}
	public MethodEntity getMethod() {
		return method;
	}
	public void setMethod(MethodEntity method) {
		this.method = method;
	}
	public ScaleEntity getScale() {
		return scale;
	}
	public void setScale(ScaleEntity scale) {
		this.scale = scale;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

}
