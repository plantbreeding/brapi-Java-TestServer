package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="linkageGroup")
public class LinkageGroupEntity extends BaseEntity{
	@Column
	private String genomeMapDbId;
	@Column
	private String linkageGroupName; 
	@OneToMany(mappedBy="linkageGroup")
	private List<MarkerEntity> markers;
	public String getGenomeMapDbId() {
		return genomeMapDbId;
	}
	public void setGenomeMapDbId(String genomeMapDbId) {
		this.genomeMapDbId = genomeMapDbId;
	}
	public String getLinkageGroupName() {
		return linkageGroupName;
	}
	public void setLinkageGroupName(String linkageGroupName) {
		this.linkageGroupName = linkageGroupName;
	}
	public List<MarkerEntity> getMarkers() {
		return markers;
	}
	public void setMarkers(List<MarkerEntity> markers) {
		this.markers = markers;
	}
}
