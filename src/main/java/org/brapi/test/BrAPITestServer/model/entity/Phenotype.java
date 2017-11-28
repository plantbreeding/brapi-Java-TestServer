package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

public class Phenotype {
	private String observationUnitDbId;
	private String observationLevel;
	private String observationLevels;
	private String plotNumber;
	private String plantNumber;
	private String blockNumber;
	private String replicate;
	private String observationUnitName;
	private String germplasmDbId;
	private String germplasmName;
	private String studyDbId;
	private String studyName;
	private String studyLocationDbId;
	private String studyLocation;
	private String programName;
	private String X;
	private String Y;
	private String entryType;
	private String entryNumber;
	private List<Treatment> treatments;
	private List<ObservationUnitXrefEntity> observationUnitXref;
	private List<ObservationEntity> observations;
	public String getObservationUnitDbId() {
		return observationUnitDbId;
	}
	public void setObservationUnitDbId(String observationUnitDbId) {
		this.observationUnitDbId = observationUnitDbId;
	}
	public String getObservationLevel() {
		return observationLevel;
	}
	public void setObservationLevel(String observationLevel) {
		this.observationLevel = observationLevel;
	}
	public String getObservationLevels() {
		return observationLevels;
	}
	public void setObservationLevels(String observationLevels) {
		this.observationLevels = observationLevels;
	}
	public String getPlotNumber() {
		return plotNumber;
	}
	public void setPlotNumber(String plotNumber) {
		this.plotNumber = plotNumber;
	}
	public String getPlantNumber() {
		return plantNumber;
	}
	public void setPlantNumber(String plantNumber) {
		this.plantNumber = plantNumber;
	}
	public String getBlockNumber() {
		return blockNumber;
	}
	public void setBlockNumber(String blockNumber) {
		this.blockNumber = blockNumber;
	}
	public String getReplicate() {
		return replicate;
	}
	public void setReplicate(String replicate) {
		this.replicate = replicate;
	}
	public String getObservationUnitName() {
		return observationUnitName;
	}
	public void setObservationUnitName(String observationUnitName) {
		this.observationUnitName = observationUnitName;
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
	public String getStudyDbId() {
		return studyDbId;
	}
	public void setStudyDbId(String studyDbId) {
		this.studyDbId = studyDbId;
	}
	public String getStudyName() {
		return studyName;
	}
	public void setStudyName(String studyName) {
		this.studyName = studyName;
	}
	public String getStudyLocationDbId() {
		return studyLocationDbId;
	}
	public void setStudyLocationDbId(String studyLocationDbId) {
		this.studyLocationDbId = studyLocationDbId;
	}
	public String getStudyLocation() {
		return studyLocation;
	}
	public void setStudyLocation(String studyLocation) {
		this.studyLocation = studyLocation;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getX() {
		return X;
	}
	public void setX(String x) {
		X = x;
	}
	public String getY() {
		return Y;
	}
	public void setY(String y) {
		Y = y;
	}
	public String getEntryType() {
		return entryType;
	}
	public void setEntryType(String entryType) {
		this.entryType = entryType;
	}
	public String getEntryNumber() {
		return entryNumber;
	}
	public void setEntryNumber(String entryNumber) {
		this.entryNumber = entryNumber;
	}
	public List<Treatment> getTreatments() {
		return treatments;
	}
	public void setTreatments(List<Treatment> treatments) {
		this.treatments = treatments;
	}
	public List<ObservationUnitXrefEntity> getObservationUnitXref() {
		return observationUnitXref;
	}
	public void setObservationUnitXref(List<ObservationUnitXrefEntity> observationUnitXref) {
		this.observationUnitXref = observationUnitXref;
	}
	public List<ObservationEntity> getObservations() {
		return observations;
	}
	public void setObservations(List<ObservationEntity> observations) {
		this.observations = observations;
	}
}
