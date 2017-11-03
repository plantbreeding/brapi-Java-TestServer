package org.brapi.test.BrAPITestServer.model.metadata;

import java.util.List;

public class SearchResults<ReturnType> {
	private MetaData metadata;
	private ReturnType results;
	
	public MetaData getMetadata() {
		return metadata;
	}
	public void setMetadata(MetaData metadata) {
		this.metadata = metadata;
	}
	public ReturnType getResults() {
		return results;
	}
	public void setResults(ReturnType results) {
		this.results = results;
	}
	public static <T> SearchResults<SearchResultsList<T>> withList(List<T> list) {
		SearchResultsList<T> data = new SearchResultsList<T>();
		data.setData(list);
		SearchResults<SearchResultsList<T>> result = new SearchResults<SearchResultsList<T>>();
		result.setResults(data);
		return result;
	}
	public  SearchResults<ReturnType> withMetaData(MetaData metadata) {
		this.setMetadata(metadata);
		return this;
	}
	public static <T> SearchResults<T> withObject(T obj) {
		SearchResults<T> result = new SearchResults<T>();
		result.setResults(obj);
		return result;
	}

}
