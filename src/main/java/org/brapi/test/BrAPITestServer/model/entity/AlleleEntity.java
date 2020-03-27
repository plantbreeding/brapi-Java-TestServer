package org.brapi.test.BrAPITestServer.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="allele")
public class AlleleEntity extends BrAPIBaseEntity{
	@ManyToOne(cascade=CascadeType.DETACH)
	private MarkerProfileEntity markerProfile;
	@ManyToOne(cascade=CascadeType.DETACH)
	private MarkerEntity marker;
	@ManyToOne(cascade=CascadeType.DETACH)
	private SampleEntity sample;
	@ManyToOne(cascade=CascadeType.DETACH)
	private AlleleMatrixEntity matrix;
	@Column
	private String alleleCode;

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
	public MarkerProfileEntity getMarkerProfile() {
		return markerProfile;
	}
	public void setMarkerProfile(MarkerProfileEntity markerProfile) {
		this.markerProfile = markerProfile;
	}
	public SampleEntity getSample() {
		return sample;
	}
	public void setSample(SampleEntity sample) {
		this.sample = sample;
	}
}
