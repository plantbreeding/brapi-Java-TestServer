package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

public class StudyGermplasm {
	private String studyDbId;
	private String trialName;
	private List<GermplasmSummary> data;
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
	public List<GermplasmSummary> getData() {
		return data;
	}
	public void setData(List<GermplasmSummary> data) {
		this.data = data;
	}
}
