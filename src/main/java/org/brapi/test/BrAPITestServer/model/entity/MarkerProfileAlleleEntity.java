package org.brapi.test.BrAPITestServer.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="marker_profile_allele")
public class MarkerProfileAlleleEntity extends BaseEntity{
	@Column
	private String markerProfileDbId;
	@Column
	private String markerName;
	@Column
	private String allele;
	public String getMarkerProfileDbId() {
		return markerProfileDbId;
	}
	public void setMarkerProfileDbId(String markerProfileDbId) {
		this.markerProfileDbId = markerProfileDbId;
	}
	public String getMarkerName() {
		return markerName;
	}
	public void setMarkerName(String markerName) {
		this.markerName = markerName;
	}
	public String getAllele() {
		return allele;
	}
	public void setAllele(String allele) {
		this.allele = allele;
	}
}
