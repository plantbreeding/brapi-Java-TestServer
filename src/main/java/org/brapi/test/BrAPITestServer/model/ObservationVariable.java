package org.brapi.test.BrAPITestServer.model;

import java.util.Date;
import java.util.List;

public class ObservationVariable {
	private String observationVariableDbId;
	private String name;
	private String ontologyDbId;
	private String ontologyName;
	private List<String> synonyms;
	private List<String> contextOfUse;
	private String growthStage;
	private String status;
	private String xref;
	private String institution;
	private String scientist;
	private Date submissionTimestamp;
	private String language;
	private String crop;
	private Trait trait;
	private Method method;
	private Scale scale;
	private String defaultValue;
	public String getObservationVariableDbId() {
		return observationVariableDbId;
	}
	public void setObservationVariableDbId(String observationVariableDbId) {
		this.observationVariableDbId = observationVariableDbId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOntologyDbId() {
		return ontologyDbId;
	}
	public void setOntologyDbId(String ontologyDbId) {
		this.ontologyDbId = ontologyDbId;
	}
	public String getOntologyName() {
		return ontologyName;
	}
	public void setOntologyName(String ontologyName) {
		this.ontologyName = ontologyName;
	}
	public List<String> getSynonyms() {
		return synonyms;
	}
	public void setSynonyms(List<String> synonyms) {
		this.synonyms = synonyms;
	}
	public List<String> getContextOfUse() {
		return contextOfUse;
	}
	public void setContextOfUse(List<String> contextOfUse) {
		this.contextOfUse = contextOfUse;
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
	public Trait getTrait() {
		return trait;
	}
	public void setTrait(Trait trait) {
		this.trait = trait;
	}
	public Method getMethod() {
		return method;
	}
	public void setMethod(Method method) {
		this.method = method;
	}
	public Scale getScale() {
		return scale;
	}
	public void setScale(Scale scale) {
		this.scale = scale;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

}
