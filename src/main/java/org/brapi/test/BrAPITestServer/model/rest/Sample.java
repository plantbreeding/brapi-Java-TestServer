package org.brapi.test.BrAPITestServer.model.rest;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Sample {

    private String sampleDbId;
    private String observationUnitDbId;
    private String germplasmDbId;
    private String studyDbId;
    
	private String plotDbId;
	private String plantDbId;
	
	private String plateDbId;
	private Integer plateIndex; 
	private String takenBy;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssXXX")
	private Date sampleTimestamp;
	private String sampleType;
	private String tissueType;
	private String notes;
	
	public String getSampleDbId() {
		return sampleDbId;
	}
	public void setSampleDbId(String sampleDbId) {
		this.sampleDbId = sampleDbId;
	}
	public String getObservationUnitDbId() {
		return observationUnitDbId;
	}
	public void setObservationUnitDbId(String observationUnitDbId) {
		this.observationUnitDbId = observationUnitDbId;
	}
	public String getGermplasmDbId() {
		return germplasmDbId;
	}
	public void setGermplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
	}
	public String getStudyDbId() {
		return studyDbId;
	}
	public void setStudyDbId(String studyDbId) {
		this.studyDbId = studyDbId;
	}
	public String getPlateDbId() {
		return plateDbId;
	}
	public void setPlateDbId(String plateDbId) {
		this.plateDbId = plateDbId;
	}
	public Integer getPlateIndex() {
		return plateIndex;
	}
	public void setPlateIndex(Integer plateIndex) {
		this.plateIndex = plateIndex;
	}
	public Date getSampleTimestamp() {
		return sampleTimestamp;
	}
	public void setSampleTimestamp(Date sampleTimestamp) {
		this.sampleTimestamp = sampleTimestamp;
	}
	public String getTakenBy() {
		return takenBy;
	}
	public void setTakenBy(String takenBy) {
		this.takenBy = takenBy;
	}
	public String getSampleType() {
		return sampleType;
	}
	public void setSampleType(String sampleType) {
		this.sampleType = sampleType;
	}
	public String getTissueType() {
		return tissueType;
	}
	public void setTissueType(String tissueType) {
		this.tissueType = tissueType;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getPlotDbId() {
		return plotDbId;
	}
	public void setPlotDbId(String plotDbId) {
		this.plotDbId = plotDbId;
	}
	public String getPlantDbId() {
		return plantDbId;
	}
	public void setPlantDbId(String plantDbId) {
		this.plantDbId = plantDbId;
	}

}
