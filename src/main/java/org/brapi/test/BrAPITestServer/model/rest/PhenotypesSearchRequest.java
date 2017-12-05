package org.brapi.test.BrAPITestServer.model.rest;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PhenotypesSearchRequest {
	private List<String> germplasmDbIds;
	private List<String> observationVariableDbIds;
	private List<String> studyDbIds;
	private List<String> locationDbIds;
	private List<String> programDbIds;
	private List<String> seasonDbIds;
	private List<String> observationLevel;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssXXX")
	private List<Date> observationTimeStampRange;
	private int pageSize;
	private int page;
	public List<String> getGermplasmDbIds() {
		return germplasmDbIds;
	}
	public void setGermplasmDbIds(List<String> germplasmDbIds) {
		this.germplasmDbIds = germplasmDbIds;
	}
	public List<String> getObservationVariableDbIds() {
		return observationVariableDbIds;
	}
	public void setObservationVariableDbIds(List<String> observationVariableDbIds) {
		this.observationVariableDbIds = observationVariableDbIds;
	}
	public List<String> getStudyDbIds() {
		return studyDbIds;
	}
	public void setStudyDbIds(List<String> studyDbIds) {
		this.studyDbIds = studyDbIds;
	}
	public List<String> getLocationDbIds() {
		return locationDbIds;
	}
	public void setLocationDbIds(List<String> locationDbIds) {
		this.locationDbIds = locationDbIds;
	}
	public List<String> getProgramDbIds() {
		return programDbIds;
	}
	public void setProgramDbIds(List<String> programDbIds) {
		this.programDbIds = programDbIds;
	}
	public List<String> getSeasonDbIds() {
		return seasonDbIds;
	}
	public void setSeasonDbIds(List<String> seasonDbIds) {
		this.seasonDbIds = seasonDbIds;
	}
	public List<String> getObservationLevel() {
		return observationLevel;
	}
	public void setObservationLevel(List<String> observationLevel) {
		this.observationLevel = observationLevel;
	}
	public List<Date> getObservationTimeStampRange() {
		return observationTimeStampRange;
	}
	public void setObservationTimeStampRange(List<Date> observationTimeStampRange) {
		this.observationTimeStampRange = observationTimeStampRange;
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
