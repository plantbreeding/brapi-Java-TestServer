package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="marker")
public class MarkerEntity extends BrAPIBaseEntity{
	@ManyToOne
	private LinkageGroupEntity linkageGroup;
	@Column
	private String markerName;
	@Column	
	private String type;
	@Column
	private Integer location;
	@OneToMany(mappedBy="markerDbId")
	private List<MarkerSynonymEntity> synonyms;
	@OneToMany(mappedBy="markerDbId")
	private List<MarkerReferenceEntity> refAlt;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "marker_marker_analysis_method", joinColumns = { @JoinColumn(name = "marker_db_id", referencedColumnName="id") }, inverseJoinColumns = { @JoinColumn(name = "marker_analysis_method_db_id", referencedColumnName="id") })
	private List<MarkerAnalysisMethodEntity> analysisMethods;
	
	public String getMarkerName() {
		return markerName;
	}
	public void setMarkerName(String markerName) {
		this.markerName = markerName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getLocation() {
		return location;
	}
	public void setLocation(Integer location) {
		this.location = location;
	}
	public List<MarkerSynonymEntity> getSynonyms() {
		return synonyms;
	}
	public void setSynonyms(List<MarkerSynonymEntity> synonyms) {
		this.synonyms = synonyms;
	}
	public List<MarkerReferenceEntity> getRefAlt() {
		return refAlt;
	}
	public void setRefAlt(List<MarkerReferenceEntity> refAlt) {
		this.refAlt = refAlt;
	}
	public List<MarkerAnalysisMethodEntity> getAnalysisMethods() {
		return analysisMethods;
	}
	public void setAnalysisMethods(List<MarkerAnalysisMethodEntity> analysisMethods) {
		this.analysisMethods = analysisMethods;
	}
	public LinkageGroupEntity getLinkageGroup() {
		return linkageGroup;
	}
	public void setLinkageGroup(LinkageGroupEntity linkageGroup) {
		this.linkageGroup = linkageGroup;
	}

}
