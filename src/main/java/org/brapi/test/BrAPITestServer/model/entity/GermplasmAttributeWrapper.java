package org.brapi.test.BrAPITestServer.model.entity;

public class GermplasmAttributeWrapper {
	// TODO this is very similar to GermplasmAttribute and should be the sames
	private String attributeDbId;
	private String attributeName;
	private String attributeCode;
	private String value;
	private String determinedDate;
	public String getAttributeDbId() {
		return attributeDbId;
	}
	public void setAttributeDbId(String attributeDbId) {
		this.attributeDbId = attributeDbId;
	}
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	public String getAttributeCode() {
		return attributeCode;
	}
	public void setAttributeCode(String attributeCode) {
		this.attributeCode = attributeCode;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDeterminedDate() {
		return determinedDate;
	}
	public void setDeterminedDate(String determinedDate) {
		this.determinedDate = determinedDate;
	}
	
}
