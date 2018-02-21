package org.brapi.test.BrAPITestServer.model.rest;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericRequest;

public class StudySearchRequest extends GenericRequest{
	private String studyType;
	private List<String> studyNames;
	private List<String> studyLocations;
	private List<String> programNames;
	private List<String> trialDbIds;
	private List<String> germplasmDbIds;
	private List<String> observationVariableDbIds;
	private boolean active = true;
	private String sortBy = "asc";
	private String sortOrder = "studyName";
	
	public String getStudyType() {
		return studyType;
	}
	public void setStudyType(String studyType) {
		this.studyType = studyType;
	}
	public List<String> getStudyNames() {
		return studyNames;
	}
	public void setStudyNames(List<String> studyNames) {
		this.studyNames = studyNames;
	}
	public List<String> getStudyLocations() {
		return studyLocations;
	}
	public void setStudyLocations(List<String> studyLocations) {
		this.studyLocations = studyLocations;
	}
	public List<String> getProgramNames() {
		return programNames;
	}
	public void setProgramNames(List<String> programNames) {
		this.programNames = programNames;
	}
	public List<String> getGermplasmDbIds() {
		return germplasmDbIds;
	}
	public void setGermplasmDbIds(List<String> germplasmDbIds) {
		this.germplasmDbIds = germplasmDbIds;
	}
	public List<String> getObservationVariableDbIds() {
		return observationVariableDbIds;
	}
	public void setObservationVariableDbIds(List<String> observationVariableDbIds) {
		this.observationVariableDbIds = observationVariableDbIds;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	public List<String> getTrialDbIds() {
		return trialDbIds;
	}
	public void setTrialDbIds(List<String> trialDbIds) {
		this.trialDbIds = trialDbIds;
	}
}
