package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

public class StudyObservationUnitTable {
	private List<String> headerRow;
	private List<String> observationVariableDbIds;
	private List<String> observationVariableNames;
	private List<List<Object>> data;
	public List<String> getHeaderRow() {
		return headerRow;
	}
	public void setHeaderRow(List<String> headerRow) {
		this.headerRow = headerRow;
	}
	public List<String> getObservationVariableDbIds() {
		return observationVariableDbIds;
	}
	public void setObservationVariableDbIds(List<String> observationVariableDbIds) {
		this.observationVariableDbIds = observationVariableDbIds;
	}
	public List<String> getObservationVariableNames() {
		return observationVariableNames;
	}
	public void setObservationVariableNames(List<String> observationVariableNames) {
		this.observationVariableNames = observationVariableNames;
	}
	public List<List<Object>> getData() {
		return data;
	}
	public void setData(List<List<Object>> data) {
		this.data = data;
	}
}
