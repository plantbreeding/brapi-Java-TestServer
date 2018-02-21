package org.brapi.test.BrAPITestServer.model.rest;

import java.util.List;

public class MarkersSearchRequest {

	private String name;
	private String type;
	private List<String> markerDbIds;
	private String matchMethod;
	private boolean includeSynonyms;
	private int pageSize;
	private int page;
	
	public MarkersSearchRequest() {
		// set defaults
		setMatchMethod("exact");
		setIncludeSynonyms(true);
		setPageSize(1000);
		setPage(0);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<String> getMarkerDbIds() {
		return markerDbIds;
	}
	public void setMarkerDbIds(List<String> markerDbIds) {
		this.markerDbIds = markerDbIds;
	}
	public String getMatchMethod() {
		return matchMethod;
	}
	public void setMatchMethod(String matchMethod) {
		this.matchMethod = matchMethod;
	}
	public boolean isIncludeSynonyms() {
		return includeSynonyms;
	}
	public void setIncludeSynonyms(boolean includeSynonyms) {
		this.includeSynonyms = includeSynonyms;
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
