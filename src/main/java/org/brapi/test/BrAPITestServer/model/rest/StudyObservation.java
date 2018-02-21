package org.brapi.test.BrAPITestServer.model.rest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudyObservation {
	// TODO very similar to Phenotypes

	private String observationUnitDbId;
	private String observationUnitName;
	private String germplasmDbId;
	private String germplasmName;
	private String pedigree;
	private String entryNumber;
	private String entryType;
	private String plotNumber;
	private String plantNumber;
	private String blockNumber;
	@JsonProperty("X")
	private String xCoordinate;
	@JsonProperty("Y")
	private String yCoordinate;
	private String replicate;
	private List<ObservationUnitXref> observationUnitXref;
	private List<Observation> observations;
	

	public String getxCoordinate() {
		return xCoordinate;
	}
	public void setxCoordinate(String xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	public String getyCoordinate() {
		return yCoordinate;
	}
	public void setyCoordinate(String yCoordinate) {
		this.yCoordinate = yCoordinate;
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
