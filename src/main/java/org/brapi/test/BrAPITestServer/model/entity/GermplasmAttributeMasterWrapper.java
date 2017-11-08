package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

public class GermplasmAttributeMasterWrapper {
	// TODO this is model shouldnt need to exist
	private String germplasmDbId;
	private List<GermplasmAttributeWrapper> data;
	public String getGermplasmDbId() {
		return germplasmDbId;
	}
	public void setGermplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
	}
	public List<GermplasmAttributeWrapper> getData() {
		return data;
	}
	public void setData(List<GermplasmAttributeWrapper> data) {
		this.data = data;
	}

}
