package org.brapi.test.BrAPITestServer.model.rest;

import java.util.List;

public class MarkerProfileKeys {
	private String germplasmDbId;
	private List<String> markerprofileDbIds;
	
	public String getGermplasmDbId() {
		return germplasmDbId;
	}
	public void setGermplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
	}
	public List<String> getMarkerprofileDbIds() {
		return markerprofileDbIds;
	}
	public void setMarkerprofileDbIds(List<String> markerprofileDbIds) {
		this.markerprofileDbIds = markerprofileDbIds;
	}
}
