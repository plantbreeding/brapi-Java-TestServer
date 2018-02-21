package org.brapi.test.BrAPITestServer.model.rest;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_NULL)
public class Observation {
	private String observationDbId;
	private String observationVariableDbId;
	private String observationVariableName;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssXXX")
	private Date observationTimeStamp;
	private String season;
	private String collector;
	private String value;
	public String getObservationDbId() {
		return observationDbId;
	}
	public void setObservationDbId(String observationDbId) {
		this.observationDbId = observationDbId;
	}
	public String getObservationVariableDbId() {
		return observationVariableDbId;
	}
	public void setObservationVariableDbId(String observationVariableDbId) {
		this.observationVariableDbId = observationVariableDbId;
	}
	public String getObservationVariableName() {
		return observationVariableName;
	}
	public void setObservationVariableName(String observationVariableName) {
		this.observationVariableName = observationVariableName;
	}
	public Date getObservationTimeStamp() {
		return observationTimeStamp;
	}
	public void setObservationTimeStamp(Date observationTimeStamp) {
		this.observationTimeStamp = observationTimeStamp;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getCollector() {
		return collector;
	}
	public void setCollector(String collector) {
		this.collector = collector;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
