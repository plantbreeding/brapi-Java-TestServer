package org.brapi.test.BrAPITestServer.model.rest;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SampleDetail {
	private String studyDbId;
	private String locationDbId;
	private String plotId;
	private String plantId;
	private String sampleId;
	private String plotDbId;
	private String plantDbId;
	private String sampleDbId;
	private String takenBy;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssXXX")
	private Date sampleTimestamp;
	private String sampleType;
	private String tissueType;
	private String notes;
	private String studyName;
	private String season;
	private String locationName;
	private int entryNumber;
	private int plotNumber;
	private String germplasmDbId;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssXXX")
	private Date plantingTimestamp;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssXXX")
	private Date harvestTimestamp;
    
    
	public String getStudyDbId() {
		return studyDbId;
	}
	public void setStudyDbId(String studyDbId) {
		this.studyDbId = studyDbId;
	}
	public String getLocationDbId() {
		return locationDbId;
	}
	public void setLocationDbId(String locationDbId) {
		this.locationDbId = locationDbId;
	}
	public String getPlotId_dep() {
		return plotId;
	}
	public void setPlotId_dep(String plotId) {
		this.plotId = plotId;
	}
	public String getPlantId_dep() {
		return plantId;
	}
	public void setPlantId_dep(String plantId) {
		this.plantId = plantId;
	}
	public String getSampleId_dep() {
		return sampleId;
	}
	public void setSampleId_dep(String sampleId) {
		this.sampleId = sampleId;
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
	public String getSampleDbId() {
		return sampleDbId;
	}
	public void setSampleDbId(String sampleDbId) {
		this.sampleDbId = sampleDbId;
	}
	public String getTakenBy() {
		return takenBy;
	}
	public void setTakenBy(String takenBy) {
		this.takenBy = takenBy;
	}
	public Date getSampleTimestamp() {
		return sampleTimestamp;
	}
	public void setSampleTimestamp(Date sampleTimestamp) {
		this.sampleTimestamp = sampleTimestamp;
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
	public String getStudyName() {
		return studyName;
	}
	public void setStudyName(String studyName) {
		this.studyName = studyName;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public int getEntryNumber() {
		return entryNumber;
	}
	public void setEntryNumber(int entryNumber) {
		this.entryNumber = entryNumber;
	}
	public int getPlotNumber() {
		return plotNumber;
	}
	public void setPlotNumber(int plotNumber) {
		this.plotNumber = plotNumber;
	}
	public String getGermplasmDbId() {
		return germplasmDbId;
	}
	public void setGermplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
	}
	public Date getPlantingTimestamp() {
		return plantingTimestamp;
	}
	public void setPlantingTimestamp(Date plantingTimestamp) {
		this.plantingTimestamp = plantingTimestamp;
	}
	public Date getHarvestTimestamp() {
		return harvestTimestamp;
	}
	public void setHarvestTimestamp(Date harvestTimestamp) {
		this.harvestTimestamp = harvestTimestamp;
	}
}
