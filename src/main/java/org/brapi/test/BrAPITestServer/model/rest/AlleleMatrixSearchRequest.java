package org.brapi.test.BrAPITestServer.model.rest;

import java.util.List;

public class AlleleMatrixSearchRequest {
	private List<String> markerProfileDbIds;
	private List<String> markerDbIds;
	private List<String> matrixDbIds;
	private boolean expandHomozygotes;
	private String unknownString;
	private String sepPhased;
	private String sepUnphased;
	private String format;
	private int pageSize;
	private int page;


	public List<String> getMarkerProfileDbIds() {
		return markerProfileDbIds;
	}
	public void setMarkerProfileDbIds(List<String> markerProfileDbIds) {
		this.markerProfileDbIds = markerProfileDbIds;
	}
	public List<String> getMarkerDbIds() {
		return markerDbIds;
	}
	public void setMarkerDbIds(List<String> markerDbIds) {
		this.markerDbIds = markerDbIds;
	}
	public List<String> getMatrixDbIds() {
		return matrixDbIds;
	}
	public void setMatrixDbIds(List<String> matrixDbIds) {
		this.matrixDbIds = matrixDbIds;
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
