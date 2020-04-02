package org.brapi.test.BrAPITestServer.model.entity.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

@Entity
@Table(name = "study_experimental_design")
public class ExperimentalDesignEntity extends BrAPIBaseEntity {
	@Column
	private String PUI;
	@Column
	private String description;
	@OneToOne
	private StudyEntity study;

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
