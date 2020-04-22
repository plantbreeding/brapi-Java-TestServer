package org.brapi.test.BrAPITestServer.model.entity.pheno;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.SeasonEntity;

@Entity
@Table(name="observation")
public class ObservationEntity extends BrAPIPrimaryEntity{
	@Column
	private String collector;
	@Column
	private Date observationTimeStamp;
	@ManyToOne
	private ObservationUnitEntity observationUnit;
	@ManyToOne
	private ObservationVariableEntity observationVariable;
	@ManyToOne
	private SeasonEntity season;
	@Column
	private String uploadedBy;
	@Column
	private String value;
	
	public String getUploadedBy() {
		return uploadedBy;
	}
	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}
	public ObservationUnitEntity getObservationUnit() {
		return observationUnit;
	}
	public void setObservationUnit(ObservationUnitEntity observationUnit) {
		this.observationUnit = observationUnit;
	}
	public Date getObservationTimeStamp() {
		return observationTimeStamp;
	}
	public void setObservationTimeStamp(Date observationTimeStamp) {
		this.observationTimeStamp = observationTimeStamp;
	}
	public String getCollector() {
		return collector;
	}
	public void setCollector(String collector) {
		this.collector = collector;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public ObservationVariableEntity getObservationVariable() {
		return observationVariable;
	}
	public void setObservationVariable(ObservationVariableEntity observationVariable) {
		this.observationVariable = observationVariable;
	}
	public SeasonEntity getSeason() {
		return season;
	}
	public void setSeason(SeasonEntity season) {
		this.season = season;
	}
	
}
