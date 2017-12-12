package org.brapi.test.BrAPITestServer.model.rest;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class GermplasmAttributeValue {
	// TODO this is very similar to GermplasmAttribute and should be the sames
	private String attributeDbId;
	private String attributeName;
	private String attributeCode;
	private String value;
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date determinedDate;
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
	public Date getDeterminedDate() {
		return determinedDate;
	}
	public void setDeterminedDate(Date determinedDate) {
		this.determinedDate = determinedDate;
	}
	
}
