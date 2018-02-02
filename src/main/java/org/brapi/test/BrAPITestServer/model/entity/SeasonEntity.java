package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="season")
public class SeasonEntity extends BaseEntity{
	@Column
	private String season;
	@Column
	private Integer year;
	@OneToMany(mappedBy="season")
	private List<ObservationEntity> observations;

	public List<ObservationEntity> getObservations() {
		return observations;
	}
	public void setObservations(List<ObservationEntity> observations) {
		this.observations = observations;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
}
