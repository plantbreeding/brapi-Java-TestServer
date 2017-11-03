package org.brapi.test.BrAPITestServer.model;

import java.util.List;

public class MarkerprofileKeys {
	private String germplasmDbId;
	private List<String> markerprofilesDbIds;
	
	public String getGermplasmDbId() {
		return germplasmDbId;
	}
	public void setGermplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
	}
	public List<String> getMarkerprofilesDbIds() {
		return markerprofilesDbIds;
	}
	public void setMarkerprofilesDbIds(List<String> markerprofilesDbIds) {
		this.markerprofilesDbIds = markerprofilesDbIds;
	}
}
