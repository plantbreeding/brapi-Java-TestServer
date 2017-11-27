package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="marker_profile")
public class MarkerProfileEntity extends BaseEntity {
	@Column
	private String germplasmDbId;
	@Column
	private String uniqueDisplayName;
	@Column
	private String sampleDbId;
	@Column
	private String extractDbId;
	@Column
	private String analysisMethod;
	@OneToMany(mappedBy="markerProfileDbId", targetEntity=AlleleEntity.class)
	private List<AlleleEntity> alleles;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "study_marker_profile", joinColumns = { @JoinColumn(name = "marker_profile_db_id", referencedColumnName="id") }, inverseJoinColumns = { @JoinColumn(name = "study_db_id", referencedColumnName="id") })
	private List<StudyEntity> studies;
	
	public String getGermplasmDbId() {
		return germplasmDbId;
	}
	public void setGermplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
	}
	public String getUniqueDisplayName() {
		return uniqueDisplayName;
	}
	public void setUniqueDisplayName(String uniqueDisplayName) {
		this.uniqueDisplayName = uniqueDisplayName;
	}
	public String getSampleDbId() {
		return sampleDbId;
	}
	public void setSampleDbId(String sampleDbId) {
		this.sampleDbId = sampleDbId;
	}
	public String getExtractDbId() {
		return extractDbId;
	}
	public void setExtractDbId(String extractDbId) {
		this.extractDbId = extractDbId;
	}
	public String getAnalysisMethod() {
		return analysisMethod;
	}
	public void setAnalysisMethod(String analysisMethod) {
		this.analysisMethod = analysisMethod;
	}
	public int getResultCount() {
		return alleles.size();
	}
	public List<AlleleEntity> getAlleles() {
		return alleles;
	}
	public void setAlleles(List<AlleleEntity> alleles) {
		this.alleles = alleles;
	}
	
}
