package org.brapi.test.BrAPITestServer.model.entity;

public class AlleleMatrixSearchRequest {
	private String markerProfileDbId;
	private String markerDbId;
	private boolean expandHomozygotes;
	private String unknownString;
	private String sepPhased;
	private String sepUnphased;
	private String format;
	private int pageSize;
	private int page;
	public String getMarkerProfileDbId() {
		return markerProfileDbId;
	}
	public void setMarkerProfileDbId(String markerProfileDbId) {
		this.markerProfileDbId = markerProfileDbId;
	}
	public String getMarkerDbId() {
		return markerDbId;
	}
	public void setMarkerDbId(String markerDbId) {
		this.markerDbId = markerDbId;
	}
	public boolean isExpandHomozygotes() {
		return expandHomozygotes;
	}
	public void setExpandHomozygotes(boolean expandHomozygotes) {
		this.expandHomozygotes = expandHomozygotes;
	}
	public String getUnknownString() {
		return unknownString;
	}
	public void setUnknownString(String unknownString) {
		this.unknownString = unknownString;
	}
	public String getSepPhased() {
		return sepPhased;
	}
	public void setSepPhased(String sepPhased) {
		this.sepPhased = sepPhased;
	}
	public String getSepUnphased() {
		return sepUnphased;
	}
	public void setSepUnphased(String sepUnphased) {
		this.sepUnphased = sepUnphased;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
}
