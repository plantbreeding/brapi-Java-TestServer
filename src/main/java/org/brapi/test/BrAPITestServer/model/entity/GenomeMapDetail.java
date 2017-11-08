package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

public class GenomeMapDetail {
	private String mapDbId;
	private String name;
	private String type;
	private String unit;
	private List<LinkageGroup> linkageGroups;
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
	public List<LinkageGroup> getLinkageGroups() {
		return linkageGroups;
	}
	public void setLinkageGroups(List<LinkageGroup> linkageGroups) {
		this.linkageGroups = linkageGroups;
	}
}
