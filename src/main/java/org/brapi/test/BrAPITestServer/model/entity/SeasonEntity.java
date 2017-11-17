package org.brapi.test.BrAPITestServer.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="season")
public class SeasonEntity extends BaseEntity{
	@Column
	private String season;
	@Column
	private int year;

	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
}
