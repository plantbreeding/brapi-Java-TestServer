package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

public class Marker {
	private String markerDbId;
	private String defaultDisplayName;
	private String type;
	private List<String> synonyms;
	private List<String> refAlt;
	private List<String> analysisMethods;
	public String getMarkerDbId() {
		return markerDbId;
	}
	public void setMarkerDbId(String markerDbId) {
		this.markerDbId = markerDbId;
	}
	public String getDefaultDisplayName() {
		return defaultDisplayName;
	}
	public void setDefaultDisplayName(String defaultDisplayName) {
		this.defaultDisplayName = defaultDisplayName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<String> getSynonyms() {
		return synonyms;
	}
	public void setSynonyms(List<String> synonyms) {
		this.synonyms = synonyms;
	}
	public List<String> getRefAlt() {
		return refAlt;
	}
	public void setRefAlt(List<String> refAlt) {
		this.refAlt = refAlt;
	}
	public List<String> getAnalysisMethods() {
		return analysisMethods;
	}
	public void setAnalysisMethods(List<String> analysisMethods) {
		this.analysisMethods = analysisMethods;
	}
	
}
