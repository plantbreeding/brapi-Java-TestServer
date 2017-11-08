package org.brapi.test.BrAPITestServer.model.rest;

import java.util.List;

public class StudyObservationUnit {
//TODO very similar to StudyObservationVariable
private String observatioUnitDbId;
private String studyDbId;
private List<Observation> observations;
public String getObservatioUnitDbId() {
	return observatioUnitDbId;
}
public void setObservatioUnitDbId(String observatioUnitDbId) {
	this.observatioUnitDbId = observatioUnitDbId;
}
public String getStudyDbId() {
	return studyDbId;
}
public void setStudyDbId(String studyDbId) {
	this.studyDbId = studyDbId;
}
public List<Observation> getObservations() {
	return observations;
}
public void setObservations(List<Observation> observations) {
	this.observations = observations;
}
}
