package org.brapi.test.BrAPITestServer.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="sample")
public class SampleEntity extends BaseEntity{
	@Column
	private String plateDbId;
	@Column
	private String plateIndex; 
	@Column
	private String takenBy;
	@Column
	private Date sampleTimestamp;
	@Column
	private String sampleType;
	@Column
	private String tissueType;
	@Column
	private String notes;
	@ManyToOne
	private ObservationUnitEntity observationUnit;
	
	public ObservationUnitEntity getObservationUnit() {
		return observationUnit;
	}
	public void setObservationUnit(ObservationUnitEntity observationUnit) {
		this.observationUnit = observationUnit;
	}
	public String getPlateDbId() {
		return plateDbId;
	}
	public void setPlateDbId(String plateDbId) {
		this.plateDbId = plateDbId;
	}
	public String getPlateIndex() {
		return plateIndex;
	}
	public void setPlateIndex(String plateIndex) {
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

}
