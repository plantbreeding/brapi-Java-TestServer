package org.brapi.test.BrAPITestServer.model.metadata;

import java.util.List;

public class SearchResultsList<T> {
	private List<T> data;

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
}
