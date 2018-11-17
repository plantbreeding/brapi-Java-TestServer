package org.brapi.test.BrAPITestServer.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class VariableBaseEntity extends BaseEntity {
	@Column
	private String crop;
	@Column
	private String defaultValue;
	@Column
	private String documentationURL;
	@Column
	private String growthStage;
	@Column
	private String institution;
	@Column
	private String language;
	@Column
	private String scientist;
	@Column
	private String status;
	@Column
	private Date submissionTimestamp;
	@Column
	private String xref;

	@OneToMany(mappedBy="observationVariableDbId")
	private List<ObservationVariableSynonymEntity> synonyms;
	@ManyToOne
	private TraitEntity trait;
	@ManyToOne
	private ScaleEntity scale;
	@ManyToOne
	private MethodEntity method;
	@ManyToOne
	private OntologyEntity ontology;
	@JoinTable
	@OneToMany(cascade = CascadeType.ALL)
	private List<OntologyRefernceEntity> ontologyRefernce;
	@OneToMany(mappedBy="observationVariableDbId")
	private List<ObservationVariableContextEntity> contextOfUse;

	
	
	public List<OntologyRefernceEntity> getOntologyRefernce() {
		return ontologyRefernce;
	}

	public void setOntologyRefernce(List<OntologyRefernceEntity> ontologyRefernce) {
		this.ontologyRefernce = ontologyRefernce;
	}

	public List<ObservationVariableContextEntity> getContextOfUse() {
		return contextOfUse;
	}

	public String getCrop() {
		return crop;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public String getDocumentationURL() {
		return documentationURL;
	}

	public String getGrowthStage() {
		return growthStage;
	}

	public String getInstitution() {
		return institution;
	}

	public String getLanguage() {
		return language;
	}

	public MethodEntity getMethod() {
		return method;
	}

	public OntologyEntity getOntology() {
		return ontology;
	}

	public ScaleEntity getScale() {
		return scale;
	}

	public String getScientist() {
		return scientist;
	}

	public String getStatus() {
		return status;
	}

	public Date getSubmissionTimestamp() {
		return submissionTimestamp;
	}

	public List<ObservationVariableSynonymEntity> getSynonyms() {
		return synonyms;
	}

	public TraitEntity getTrait() {
		return trait;
	}

	public String getXref() {
		return xref;
	}

	public void setContextOfUse(List<ObservationVariableContextEntity> contextOfUse) {
		this.contextOfUse = contextOfUse;
	}

	public void setCrop(String crop) {
		this.crop = crop;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public void setDocumentationURL(String documentationURL) {
		this.documentationURL = documentationURL;
	}

	public void setGrowthStage(String growthStage) {
		this.growthStage = growthStage;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setMethod(MethodEntity method) {
		this.method = method;
	}

	public void setOntology(OntologyEntity ontology) {
		this.ontology = ontology;
	}

	public void setScale(ScaleEntity scale) {
		this.scale = scale;
	}

	public void setScientist(String scientist) {
		this.scientist = scientist;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setSubmissionTimestamp(Date submissionTimestamp) {
		this.submissionTimestamp = submissionTimestamp;
	}

	public void setSynonyms(List<ObservationVariableSynonymEntity> synonyms) {
		this.synonyms = synonyms;
	}

	public void setTrait(TraitEntity trait) {
		this.trait = trait;
	}

	public void setXref(String xref) {
		this.xref = xref;
	}

}