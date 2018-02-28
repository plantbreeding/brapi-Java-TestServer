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
        
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attributeDbId == null) ? 0 : attributeDbId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GermplasmAttributeValue other = (GermplasmAttributeValue) obj;
		if (attributeDbId == null) {
			if (other.attributeDbId != null)
				return false;
		} else if (!attributeDbId.equals(other.attributeDbId))
			return false;
		return true;
	}
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
