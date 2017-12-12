package org.brapi.test.BrAPITestServer.model.rest;

import java.util.List;

public class GermplasmAttributeValuesWrapper {
	// TODO this is model shouldnt need to exist
	private String germplasmDbId;
	private List<GermplasmAttributeValue> data;
	public String getGermplasmDbId() {
		return germplasmDbId;
	}
	public void setGermplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
	}
	public List<GermplasmAttributeValue> getData() {
		return data;
	}
	public void setData(List<GermplasmAttributeValue> data) {
		this.data = data;
	}

}
