package org.brapi.test.BrAPITestServer.model.entity;

public class LinkageGroup {
	private String linkageGroupDbId;
	private int markerCount;
	private int maxPosition;
	public String getLinkageGroupDbId() {
		return linkageGroupDbId;
	}
	public void setLinkageGroupDbId(String linkageGroupDbId) {
		this.linkageGroupDbId = linkageGroupDbId;
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
