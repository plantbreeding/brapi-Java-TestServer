package org.brapi.test.BrAPITestServer.model.entity.geno;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;

@Entity
@Table(name="linkageGroup")
public class LinkageGroupEntity extends BrAPIPrimaryEntity{
	@ManyToOne
	private GenomeMapEntity genomeMap;
	@Column
	private String linkageGroupName; 
	@Column
	private Integer maxMarkerPosition;
	@OneToMany(mappedBy="linkageGroup")
	private List<MarkerEntity> markers;
	
	public Integer getMaxMarkerPosition() {
		return maxMarkerPosition;
	}
	public void setMaxMarkerPosition(Integer maxMarkerPosition) {
		this.maxMarkerPosition = maxMarkerPosition;
	}
	public GenomeMapEntity getGenomeMap() {
		return genomeMap;
	}
	public void setGenomeMap(GenomeMapEntity genomeMap) {
		this.genomeMap = genomeMap;
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
