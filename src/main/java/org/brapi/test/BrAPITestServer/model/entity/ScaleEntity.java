package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="scale")
public class ScaleEntity extends BaseEntity {
	@Column
	private String name;
	@Column
	private String dataType;
	@Column
	private Integer decimalPlaces;
	@Column
	private String xref;
	@ManyToOne
	private ScaleValidValueEntity validValue;
	@OneToMany(mappedBy="scale")
	private List<ObservationVariableEntity> observationVariables;

	public List<ObservationVariableEntity> getObservationVariables() {
		return observationVariables;
	}

	public void setObservationVariables(List<ObservationVariableEntity> observationVariables) {
		this.observationVariables = observationVariables;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Integer getDecimalPlaces() {
		return decimalPlaces;
	}

	public void setDecimalPlaces(Integer decimalPlaces) {
		this.decimalPlaces = decimalPlaces;
	}

	public String getXref() {
		return xref;
	}

	public void setXref(String xref) {
		this.xref = xref;
	}

	public ScaleValidValueEntity getValidValues() {
		return validValue;
	}

	public void setValidValues(ScaleValidValueEntity validValues) {
		this.validValue = validValues;
	}
}
