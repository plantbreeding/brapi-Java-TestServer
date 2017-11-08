package org.brapi.test.BrAPITestServer.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Method {
	private String methodDbId;
	private String name;
	@JsonProperty("class")
	private String methodClass;
	private String description;
	private String formula;
	private String reference;
	public String getMethodDbId() {
		return methodDbId;
	}
	public void setMethodDbId(String methodDbId) {
		this.methodDbId = methodDbId;
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
