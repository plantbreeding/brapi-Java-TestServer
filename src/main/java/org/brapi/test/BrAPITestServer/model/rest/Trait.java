package org.brapi.test.BrAPITestServer.model.rest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Trait {
	private String traitDbId;
	private String name;
	@JsonProperty("class")
	private String traitClass;
	private String description;
	private List<String> synonyms;
	private String mainAbbreviation;
	private List<String> alternativeAbbreviations;
	private String entity;
	private String attribute;
	private String status;
	private String xref;
	public String getTraitDbId() {
		return traitDbId;
	}
	public void setTraitDbId(String traitDbId) {
		this.traitDbId = traitDbId;
	}
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
	public List<String> getSynonyms() {
		return synonyms;
	}
	public void setSynonyms(List<String> synonyms) {
		this.synonyms = synonyms;
	}
	public String getMainAbbreviation() {
		return mainAbbreviation;
	}
	public void setMainAbbreviation(String mainAbbreviation) {
		this.mainAbbreviation = mainAbbreviation;
	}
	public List<String> getAlternativeAbbreviations() {
		return alternativeAbbreviations;
	}
	public void setAlternativeAbbreviations(List<String> alternativeAbbreviations) {
		this.alternativeAbbreviations = alternativeAbbreviations;
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
}
