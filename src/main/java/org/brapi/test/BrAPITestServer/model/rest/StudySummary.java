package org.brapi.test.BrAPITestServer.model.rest;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StudySummary {
	private String studyDbId;
	private String name;
	private String trialDbId;
	private String trialName;
	private String studyType;
	private List<String> seasons;
	private String locationDbId;
	private String locationName;
	private String programDbId;
	private String programName;
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date startDate;
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	private boolean active;
	private Map<String, String> additionalInfo;
	public String getStudyDbId() {
		return studyDbId;
	}
	public void setStudyDbId(String studyDbId) {
		this.studyDbId = studyDbId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTrialDbId() {
		return trialDbId;
	}
	public void setTrialDbId(String trialDbId) {
		this.trialDbId = trialDbId;
	}
	public String getTrialName() {
		return trialName;
	}
	public void setTrialName(String trialName) {
		this.trialName = trialName;
	}
	public String getStudyType() {
		return studyType;
	}
	public void setStudyType(String studyType) {
		this.studyType = studyType;
	}
	public List<String> getSeasons() {
		return seasons;
	}
	public void setSeasons(List<String> seasons) {
		this.seasons = seasons;
	}
	public String getLocationDbId() {
		return locationDbId;
	}
	public void setLocationDbId(String locationDbId) {
		this.locationDbId = locationDbId;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getProgramDbId() {
		return programDbId;
	}
	public void setProgramDbId(String programDbId) {
		this.programDbId = programDbId;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Map<String, String> getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(Map<String, String> additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
}
