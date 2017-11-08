package org.brapi.test.BrAPITestServer.model.rest;

public class Scale {

	private String scaleDbId;
	private String name;
	private String datatype;
	private String decimalPlaces;
	private String xref;
	private ValidValue validValues;

	public String getScaleDbId() {
		return scaleDbId;
	}

	public void setScaleDbId(String scaleDbId) {
		this.scaleDbId = scaleDbId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	public String getDecimalPlaces() {
		return decimalPlaces;
	}

	public void setDecimalPlaces(String decimalPlaces) {
		this.decimalPlaces = decimalPlaces;
	}

	public String getXref() {
		return xref;
	}

	public void setXref(String xref) {
		this.xref = xref;
	}

	public ValidValue getValidValues() {
		return validValues;
	}

	public void setValidValues(ValidValue validValues) {
		this.validValues = validValues;
	}
}
