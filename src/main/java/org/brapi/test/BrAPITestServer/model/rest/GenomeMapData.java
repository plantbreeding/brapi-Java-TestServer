package org.brapi.test.BrAPITestServer.model.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_NULL)
public class GenomeMapData {
	private String markerDbId;
	private String markerName;
	private String location;
	private String linkageGroupName;
	public String getMarkerDbId() {
		return markerDbId;
	}
	public void setMarkerDbId(String markerDbId) {
		this.markerDbId = markerDbId;
	}
	public String getMarkerName() {
		return markerName;
	}
	public void setMarkerName(String markerName) {
		this.markerName = markerName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLinkageGroupName() {
		return linkageGroupName;
	}
	public void setLinkageGroupName(String linkageGroupName) {
		this.linkageGroupName = linkageGroupName;
	}
}
