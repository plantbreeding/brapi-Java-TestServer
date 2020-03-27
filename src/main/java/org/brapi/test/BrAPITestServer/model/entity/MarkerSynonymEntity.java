package org.brapi.test.BrAPITestServer.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="marker_synonym")
public class MarkerSynonymEntity extends BrAPIBaseEntity{
	@Column
	private String markerDbId;
	@Column
	private String synonym;

	public String getSynonym() {
		return synonym;
	}

	public void setSynonym(String synonym) {
		this.synonym = synonym;
	}

	public String getMarkerDbId() {
		return markerDbId;
	}

	public void setMarkerDbId(String markerDbId) {
		this.markerDbId = markerDbId;
	}
}
