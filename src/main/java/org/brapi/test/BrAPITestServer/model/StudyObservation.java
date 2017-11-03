package org.brapi.test.BrAPITestServer.model;

import java.util.List;

public class StudyObservation {
	// TODO very similar to Phenotypes

	private String observationUnitDbId;
	private String observationUnitName;
	private String germplasmDbId;
	private String germplasmName;
	private String pedigree;
	private String entryNumber;
	private String entryType;
	private int plotNumber;
	private int plantNumber;
	private int blockNumber;
	private String X;
	private String Y;
	private String replicate;
	private List<ObservationUnitXref> observationUnitXref;
	private List<Observation> observations;
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
	public String getPedigree() {
		return pedigree;
	}
	public void setPedigree(String pedigree) {
		this.pedigree = pedigree;
	}
	public String getEntryNumber() {
		return entryNumber;
	}
	public void setEntryNumber(String entryNumber) {
		this.entryNumber = entryNumber;
	}
	public String getEntryType() {
		return entryType;
	}
	public void setEntryType(String entryType) {
		this.entryType = entryType;
	}
	public int getPlotNumber() {
		return plotNumber;
	}
	public void setPlotNumber(int plotNumber) {
		this.plotNumber = plotNumber;
	}
	public int getPlantNumber() {
		return plantNumber;
	}
	public void setPlantNumber(int plantNumber) {
		this.plantNumber = plantNumber;
	}
	public int getBlockNumber() {
		return blockNumber;
	}
	public void setBlockNumber(int blockNumber) {
		this.blockNumber = blockNumber;
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
	public String getReplicate() {
		return replicate;
	}
	public void setReplicate(String replicate) {
		this.replicate = replicate;
	}
	public List<ObservationUnitXref> getObservationUnitXref() {
		return observationUnitXref;
	}
	public void setObservationUnitXref(List<ObservationUnitXref> observationUnitXref) {
		this.observationUnitXref = observationUnitXref;
	}
	public List<Observation> getObservations() {
		return observations;
	}
	public void setObservations(List<Observation> observations) {
		this.observations = observations;
	}
}
