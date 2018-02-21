package org.brapi.test.BrAPITestServer.model.rest;

public class LinkageGroup {
	private String linkageGroupName;
	private int markerCount;
	private int maxPosition;
	
	public String getLinkageGroupName() {
		return linkageGroupName;
	}
	public void setLinkageGroupName(String linkageGroupName) {
		this.linkageGroupName = linkageGroupName;
	}
	public int getMarkerCount() {
		return markerCount;
	}
	public void setMarkerCount(int markerCount) {
		this.markerCount = markerCount;
	}
	public int getMaxPosition() {
		return maxPosition;
	}
	public void setMaxPosition(int maxPosition) {
		this.maxPosition = maxPosition;
	}
}
