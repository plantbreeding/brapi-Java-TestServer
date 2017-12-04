package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="method")
public class MethodEntity extends BaseEntity{
	@Column
	private String name;
	@Column
	private String methodClass;
	@Column
	private String description;
	@Column
	private String formula;
	@Column
	private String reference;
	@OneToMany(mappedBy="method")
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
	public String getMethodClass() {
		return methodClass;
	}
	public void setMethodClass(String methodClass) {
		this.methodClass = methodClass;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFormula() {
		return formula;
	}
	public void setFormula(String formula) {
		this.formula = formula;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
}
