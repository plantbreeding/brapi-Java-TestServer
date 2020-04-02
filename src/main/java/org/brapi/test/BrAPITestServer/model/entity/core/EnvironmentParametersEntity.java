package org.brapi.test.BrAPITestServer.model.entity.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

@Entity
@Table(name = "study_environment_parameter")
public class EnvironmentParametersEntity extends BrAPIBaseEntity {
	@Column
	private String description;
	@Column
	private String parameterName;
	@Column
	private String parameterPUI;
	@Column
	private String unit;
	@Column
	private String unitPUI;
	@Column
	private String value;
	@Column
	private String valuePUI;
	@ManyToOne
	private StudyEntity study;

	public StudyEntity getStudy() {
		return study;
	}

	public void setStudy(StudyEntity study) {
		this.study = study;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getParameterPUI() {
		return parameterPUI;
	}

	public void setParameterPUI(String parameterPUI) {
		this.parameterPUI = parameterPUI;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getUnitPUI() {
		return unitPUI;
	}

	public void setUnitPUI(String unitPUI) {
		this.unitPUI = unitPUI;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValuePUI() {
		return valuePUI;
	}

	public void setValuePUI(String valuePUI) {
		this.valuePUI = valuePUI;
	}

}
