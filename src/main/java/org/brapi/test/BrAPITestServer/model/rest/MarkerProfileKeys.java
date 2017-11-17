package org.brapi.test.BrAPITestServer.model.rest;

import java.util.List;

public class MarkerProfileKeys {
	private String germplasmDbId;
	private List<String> markerprofilesDbIds;
	
	public String getGermplasmDbId() {
		return germplasmDbId;
	}
	public void setGermplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
	}
	public List<String> getMarkerProfilesDbIds() {
		return markerprofilesDbIds;
	}
	public void setMarkerProfilesDbIds(List<String> markerProfilesDbIds) {
		this.markerprofilesDbIds = markerProfilesDbIds;
	}
}
