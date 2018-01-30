package org.brapi.test.BrAPITestServer.model.rest;

public class TaxonID implements BaseRestModel{
	private String sourceName;
	private String taxonId;
	
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public String getTaxonId() {
		return taxonId;
	}
	public void setTaxonId(String taxonId) {
		this.taxonId = taxonId;
	}
}
