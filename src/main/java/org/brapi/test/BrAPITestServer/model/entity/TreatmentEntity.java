package org.brapi.test.BrAPITestServer.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="treatment")
public class TreatmentEntity extends BaseEntity{
	@Column
	private String observationUnitDbId;
	@Column
	private String factor;
	@Column
	private String modality;
	
	public String getObservationUnitDbId() {
		return observationUnitDbId;
	}
	public void setObservationUnitDbId(String observationUnitDbId) {
		this.observationUnitDbId = observationUnitDbId;
	}
	public String getFactor() {
		return factor;
	}
	public void setFactor(String factor) {
		this.factor = factor;
	}
	public String getModality() {
		return modality;
	}
	public void setModality(String modality) {
		this.modality = modality;
	}
}
