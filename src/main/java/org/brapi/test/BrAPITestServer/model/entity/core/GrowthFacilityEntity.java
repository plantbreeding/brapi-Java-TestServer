package org.brapi.test.BrAPITestServer.model.entity.core;

import javax.persistence.*;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

@Entity
@Table(name = "study_growth_facility")
public class GrowthFacilityEntity extends BrAPIBaseEntity {
	@Column
	private String PUI;
	@Column
	private String description;
	@OneToOne(fetch = FetchType.LAZY)
	private StudyEntity study;

	public StudyEntity getStudy() {
		return study;
	}

	public void setStudy(StudyEntity study) {
		this.study = study;
	}

	public String getPUI() {
		return PUI;
	}

	public void setPUI(String pUI) {
		PUI = pUI;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
