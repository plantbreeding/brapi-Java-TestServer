package org.brapi.test.BrAPITestServer.model.rest;

public class Season {
	private String seasonDbId;
	private String season;
	private int year;
	public String getSeasonDbId() {
		return seasonDbId;
	}
	public void setSeasonDbId(String seasonDbId) {
		this.seasonDbId = seasonDbId;
	}
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
