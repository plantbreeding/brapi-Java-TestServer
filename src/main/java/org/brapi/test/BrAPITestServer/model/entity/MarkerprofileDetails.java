package org.brapi.test.BrAPITestServer.model.entity;

import java.util.Map;

public class MarkerprofileDetails {
	private String markerprofileDbId;
	private String germplasmDbId;
	private String uniqueDisplayName;
	// TODO why is this missing private String sampleDbId;
	private String extractDbId;
	private String analysisMethod;
	private Map<String, String> data;
	public String getMarkerprofileDbId() {
		return markerprofileDbId;
	}
	public void setMarkerprofileDbId(String markerprofileDbId) {
		this.markerprofileDbId = markerprofileDbId;
	}
	public String getGermplasmDbId() {
		return germplasmDbId;
	}
	public void setGermplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
	}
	public String getUniqueDisplayName() {
		return uniqueDisplayName;
	}
	public void setUniqueDisplayName(String uniqueDisplayName) {
		this.uniqueDisplayName = uniqueDisplayName;
	}
	public String getExtractDbId() {
		return extractDbId;
	}
	public void setExtractDbId(String extractDbId) {
		this.extractDbId = extractDbId;
	}
	public String getAnalysisMethod() {
		return analysisMethod;
	}
	public void setAnalysisMethod(String analysisMethod) {
		this.analysisMethod = analysisMethod;
	}
	public Map<String, String> getData() {
		return data;
	}
	public void setData(Map<String, String> data) {
		this.data = data;
	}
}
