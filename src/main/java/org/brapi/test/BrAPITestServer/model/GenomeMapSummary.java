package org.brapi.test.BrAPITestServer.model;

import java.util.Date;

public class GenomeMapSummary {
	private String mapDbId;
	private String name;
	private String species;
	private String type;
	private String unit;
	private Date publishedDate;
	private int markerCount;
	private int linkageGroupCount;
	private String comments;
	public String getMapDbId() {
		return mapDbId;
	}
	public void setMapDbId(String mapDbId) {
		this.mapDbId = mapDbId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	public int getMarkerCount() {
		return markerCount;
	}
	public void setMarkerCount(int markerCount) {
		this.markerCount = markerCount;
	}
	public int getLinkageGroupCount() {
		return linkageGroupCount;
	}
	public void setLinkageGroupCount(int linkageGroupCount) {
		this.linkageGroupCount = linkageGroupCount;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
}
