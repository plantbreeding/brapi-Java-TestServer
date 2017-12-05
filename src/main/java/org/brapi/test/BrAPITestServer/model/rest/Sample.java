package org.brapi.test.BrAPITestServer.model.rest;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Sample {
	private String plotId;
	private String plantId;
	private String takenBy;
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date sampleDate;
	private String sampleType;
	private String tissueType;
	private String notes;
	public String getPlotId() {
		return plotId;
	}
	public void setPlotId(String plotId) {
		this.plotId = plotId;
	}
	public String getPlantId() {
		return plantId;
	}
	public void setPlantId(String plantId) {
		this.plantId = plantId;
	}
	public String getTakenBy() {
		return takenBy;
	}
	public void setTakenBy(String takenBy) {
		this.takenBy = takenBy;
	}
	public Date getSampleDate() {
		return sampleDate;
	}
	public void setSampleDate(Date sampleDate) {
		this.sampleDate = sampleDate;
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

}
