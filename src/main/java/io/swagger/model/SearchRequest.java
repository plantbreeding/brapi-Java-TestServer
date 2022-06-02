package io.swagger.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class SearchRequest {
	@JsonIgnore
	public abstract Integer getTotalParameterCount();

	@JsonProperty("page")
	protected Integer page = null;

	@JsonProperty("pageSize")
	protected Integer pageSize = null;

	@JsonProperty("pageToken")
	protected String pageToken = null;

	@JsonProperty("externalReferenceIds")
	protected List<String> externalReferenceIds = null;

	@JsonProperty("externalReferenceSources")
	protected List<String> externalReferenceSources = null;

	final public SearchRequest page(Integer page) {
		this.page = page;
		return this;
	}

	final public Integer getPage() {
		return page;
	}

	final public void setPage(Integer page) {
		this.page = page;
	}

	final public SearchRequest pageSize(Integer pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	final public Integer getPageSize() {
		return pageSize;
	}

	final public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public SearchRequest pageToken(String pageToken) {
		this.pageToken = pageToken;
		return this;
	}

	public String getPageToken() {
		return pageToken;
	}

	public void setPageToken(String pageToken) {
		this.pageToken = pageToken;
	}

	final public SearchRequest externalReferenceIDs(List<String> externalReferenceIds) {
		this.externalReferenceIds = externalReferenceIds;
		return this;
	}

	final private SearchRequest addExternalReferenceIDsItem(String externalReferenceId) {
		if (this.externalReferenceIds == null) {
			this.externalReferenceIds = new ArrayList<String>();
		}
		this.externalReferenceIds.add(externalReferenceId);
		return this;
	}

	final public List<String> getExternalReferenceIDs() {
		return externalReferenceIds;
	}

	final public void setExternalReferenceIDs(List<String> externalReferenceIds) {
		this.externalReferenceIds = externalReferenceIds;
	}

	final public SearchRequest externalReferenceSources(List<String> externalReferenceSources) {
		this.externalReferenceSources = externalReferenceSources;
		return this;
	}

	final private SearchRequest addExternalReferenceSourcesItem(String externalReferenceSourcesItem) {
		if (this.externalReferenceSources == null) {
			this.externalReferenceSources = new ArrayList<String>();
		}
		this.externalReferenceSources.add(externalReferenceSourcesItem);
		return this;
	}

	final public List<String> getExternalReferenceSources() {
		return externalReferenceSources;
	}

	final public void setExternalReferenceSources(List<String> externalReferenceSources) {
		this.externalReferenceSources = externalReferenceSources;
	}

	public void addExternalReferenceItem(String externalReferenceId, String externalReferenceID,
			String externalReferenceSource) {
		if (externalReferenceId != null) {
			this.addExternalReferenceIDsItem(externalReferenceId);
		} else if (externalReferenceID != null) {
			this.addExternalReferenceIDsItem(externalReferenceID);
		}

		if (externalReferenceSource != null) {
			this.addExternalReferenceSourcesItem(externalReferenceSource);
		}

	}
}
