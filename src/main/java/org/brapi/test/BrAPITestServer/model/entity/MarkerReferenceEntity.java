package org.brapi.test.BrAPITestServer.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="marker_reference")
public class MarkerReferenceEntity extends BaseEntity{
	@Column
	private String markerDbId;
	@Column
	private String reference;
	@Column
	private boolean alternative;
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public boolean isAlternative() {
		return alternative;
	}
	public void setAlternative(boolean alternative) {
		this.alternative = alternative;
	}
	public String getMarkerDbId() {
		return markerDbId;
	}
	public void setMarkerDbId(String markerDbId) {
		this.markerDbId = markerDbId;
	}
}
