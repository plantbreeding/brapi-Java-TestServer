package org.brapi.test.BrAPITestServer.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="observation")
public class ObservationEntity extends BrAPIBaseEntity{
	@Column
	private Date observationTimeStamp;
	@Column
	private String collector;
	@Column
	private String value;

	@ManyToOne
	private ObservationVariableEntity observationVariable;
	@ManyToOne
	private ObservationUnitEntity observationUnit;
	@ManyToOne
	private SeasonEntity season;
	
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
