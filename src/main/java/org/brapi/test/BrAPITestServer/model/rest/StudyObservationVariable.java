package org.brapi.test.BrAPITestServer.model.rest;

import java.util.List;

public class StudyObservationVariable {
	private String studyDbId;
	private String trialName;
	private List<ObservationVariable> data;
	public String getStudyDbId() {
		return studyDbId;
	}
	public void setStudyDbId(String studyDbId) {
		this.studyDbId = studyDbId;
	}
	public String getTrialName() {
		return trialName;
	}
	public void setTrialName(String trialName) {
		this.trialName = trialName;
	}
	public List<ObservationVariable> getData() {
		return data;
	}
	public void setData(List<ObservationVariable> data) {
		this.data = data;
	}
}
