package org.brapi.test.BrAPITestServer.model.rest;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ObservationUnit {
//TODO similar to StudyObservationUnit and Observation
private String studyDbId;
private String obserationDbId;
private String observationUnitDbId;
private String observationUnitName;
private String observationLevel;
private String observationVariableDbId;
private String observationVariableName;
@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssXXX")
private Date observationTimestamp;
private String uploadedBy;
private String operator;
private String germplasmDbId;
private String germplasmName;
private String value;
public String getStudyDbId() {
	return studyDbId;
}
public void setStudyDbId(String studyDbId) {
	this.studyDbId = studyDbId;
}
public String getObserationDbId() {
	return obserationDbId;
}
public void setObserationDbId(String obserationDbId) {
	this.obserationDbId = obserationDbId;
}
public String getObservationUnitDbId() {
	return observationUnitDbId;
}
public void setObservationUnitDbId(String observationUnitDbId) {
	this.observationUnitDbId = observationUnitDbId;
}
public String getObservationUnitName() {
	return observationUnitName;
}
public void setObservationUnitName(String observationUnitName) {
	this.observationUnitName = observationUnitName;
}
public String getObservationLevel() {
	return observationLevel;
}
public void setObservationLevel(String observationLevel) {
	this.observationLevel = observationLevel;
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
public Date getObservationTimestamp() {
	return observationTimestamp;
}
public void setObservationTimestamp(Date observationTimestamp) {
	this.observationTimestamp = observationTimestamp;
}
public String getUploadedBy() {
	return uploadedBy;
}
public void setUploadedBy(String uploadedBy) {
	this.uploadedBy = uploadedBy;
}
public String getOperator() {
	return operator;
}
public void setOperator(String operator) {
	this.operator = operator;
}
public String getGermplasmDbId() {
	return germplasmDbId;
}
public void setGermplasmDbId(String germplasmDbId) {
	this.germplasmDbId = germplasmDbId;
}
public String getGermplasmName() {
	return germplasmName;
}
public void setGermplasmName(String germplasmName) {
	this.germplasmName = germplasmName;
}
public String getValue() {
	return value;
}
public void setValue(String value) {
	this.value = value;
}
}
