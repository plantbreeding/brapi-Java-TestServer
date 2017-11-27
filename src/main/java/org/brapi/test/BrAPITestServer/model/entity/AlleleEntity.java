package org.brapi.test.BrAPITestServer.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="allele")
public class AlleleEntity extends BaseEntity{
	@Column
	private String markerProfileDbId;
	@ManyToOne(cascade=CascadeType.DETACH)
	private MarkerEntity marker;
	@Column
	private String alleleCode;
	public String getMarkerProfileDbId() {
		return markerProfileDbId;
	}
	public void setMarkerProfileDbId(String markerProfileDbId) {
		this.markerProfileDbId = markerProfileDbId;
	}
	public String getAlleleCode() {
		return alleleCode;
	}
	public void setAlleleCode(String alleleCode) {
		this.alleleCode = alleleCode;
	}
	public MarkerEntity getMarker() {
		return marker;
	}
	public void setMarker(MarkerEntity marker) {
		this.marker = marker;
	}
}
