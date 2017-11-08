package org.brapi.test.BrAPITestServer.model.rest;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class TrialSummary {
	private String trialDbId;
	private String trialName;
	private String programDbId;
	private String programName;
	private Date startDate;
	private Date endDate;
	private boolean active;
	private List<StudyIDWrapper> studies;
	private Map<String, String> additionalInfo;
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
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public List<StudyIDWrapper> getStudies() {
		return studies;
	}
	public void setStudies(List<StudyIDWrapper> studies) {
		this.studies = studies;
	}
	public Map<String, String> getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(Map<String, String> additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
}
