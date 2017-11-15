package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

public class StudyGermplasm {
	private String studyDbId;
	private String trialName;
	private List<GermplasmEntity> data;
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
	public List<GermplasmEntity> getData() {
		return data;
	}
	public void setData(List<GermplasmEntity> data) {
		this.data = data;
	}

}
