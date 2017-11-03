package org.brapi.test.BrAPITestServer.model.metadata;

import java.util.List;

public class GenericResults<ReturnType> {
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
	public static <T> GenericResults<GenericResultsDataList<T>> withList(List<T> list) {
		GenericResultsDataList<T> data = new GenericResultsDataList<T>();
		data.setData(list);
		GenericResults<GenericResultsDataList<T>> result = new GenericResults<GenericResultsDataList<T>>();
		result.setResults(data);
		return result;
	}
	public  GenericResults<ReturnType> withMetaData(MetaData metadata) {
		this.setMetadata(metadata);
		return this;
	}
	public static <T> GenericResults<T> withObject(T obj) {
		GenericResults<T> result = new GenericResults<T>();
		result.setResults(obj);
		return result;
	}

}
