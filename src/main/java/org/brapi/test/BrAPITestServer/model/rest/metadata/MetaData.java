package org.brapi.test.BrAPITestServer.model.rest.metadata;

import java.util.List;

public class MetaData {
	private MetaDataPagination pagination;
	private List<MetaDataStatus> status;
	private List<MetaDataDatafiles> datafiles;

	public List<MetaDataStatus> getStatus() {
		return status;
	}

	public void setStatus(List<MetaDataStatus> status) {
		this.status = status;
	}

	public List<MetaDataDatafiles> getDatafiles() {
		return datafiles;
	}

	public void setDatafiles(List<MetaDataDatafiles> datafiles) {
		this.datafiles = datafiles;
	}

	public MetaDataPagination getPagination() {
		return pagination;
	}

	public void setPagination(MetaDataPagination pagination) {
		this.pagination = pagination;
	}
}
