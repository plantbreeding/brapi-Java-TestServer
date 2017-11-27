package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

public class StudyObservationVariable {
	private String studyDbId;
	private String trialName;
	private List<ObservationVariableEntity> data;
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
	public List<ObservationVariableEntity> getData() {
		return data;
	}
	public void setData(List<ObservationVariableEntity> data) {
		this.data = data;
	}
}
