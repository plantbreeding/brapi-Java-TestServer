package org.brapi.test.BrAPITestServer.model.entity.pheno;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.CropEntity;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class VariableBaseEntity extends BrAPIPrimaryEntity implements OntologyReferenceHolder {

	@ManyToOne(fetch = FetchType.LAZY)
	private CropEntity crop;
	@ElementCollection
	private List<String> contextOfUse;
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
	@ManyToOne(fetch = FetchType.LAZY)
	private MethodEntity method;
	@ManyToOne(fetch = FetchType.LAZY)
	private OntologyEntity ontology;
	@ManyToOne(fetch = FetchType.LAZY)
	private ScaleEntity scale;
	@Column
	private String scientist;
	@Column
	private String status;
	@Column
	private Date submissionTimestamp;
	@ElementCollection
	private List<String> synonyms;
	@ManyToOne(fetch = FetchType.LAZY)
	private TraitEntity trait;
	@JoinTable
	@OneToMany(cascade = CascadeType.ALL)
	private List<OntologyReferenceEntity> ontologyReference;
	
	public List<OntologyReferenceEntity> getOntologyReference() {
		return ontologyReference;
	}
	public void setOntologyReference(List<OntologyReferenceEntity> ontologyReference) {
		this.ontologyReference = ontologyReference;
	}
	public CropEntity getCrop() {
		return crop;
	}
	public void setCrop(CropEntity crop) {
		this.crop = crop;
	}
	public List<String> getContextOfUse() {
		return contextOfUse;
	}
	public void setContextOfUse(List<String> contextOfUse) {
		this.contextOfUse = contextOfUse;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public String getDocumentationURL() {
		return documentationURL;
	}
	public void setDocumentationURL(String documentationURL) {
		this.documentationURL = documentationURL;
	}
	public String getGrowthStage() {
		return growthStage;
	}
	public void setGrowthStage(String growthStage) {
		this.growthStage = growthStage;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public MethodEntity getMethod() {
		return method;
	}
	public void setMethod(MethodEntity method) {
		this.method = method;
	}
	public OntologyEntity getOntology() {
		return ontology;
	}
	public void setOntology(OntologyEntity ontology) {
		this.ontology = ontology;
	}
	public ScaleEntity getScale() {
		return scale;
	}
	public void setScale(ScaleEntity scale) {
		this.scale = scale;
	}
	public String getScientist() {
		return scientist;
	}
	public void setScientist(String scientist) {
		this.scientist = scientist;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getSubmissionTimestamp() {
		return submissionTimestamp;
	}
	public void setSubmissionTimestamp(Date submissionTimestamp) {
		this.submissionTimestamp = submissionTimestamp;
	}
	public List<String> getSynonyms() {
		return synonyms;
	}
	public void setSynonyms(List<String> synonyms) {
		this.synonyms = synonyms;
	}
	public TraitEntity getTrait() {
		return trait;
	}
	public void setTrait(TraitEntity trait) {
		this.trait = trait;
	}
}