package org.brapi.test.BrAPITestServer.model.entity;

public class TaxonID {
	//TODO This class doesnt make sense to me, might be a product of loose typing
	private String ncbiTaxon;
	private String ciradTaxon;
	public String getNcbiTaxon() {
		return ncbiTaxon;
	}
	public void setNcbiTaxon(String ncbiTaxon) {
		this.ncbiTaxon = ncbiTaxon;
	}
	public String getCiradTaxon() {
		return ciradTaxon;
	}
	public void setCiradTaxon(String ciradTaxon) {
		this.ciradTaxon = ciradTaxon;
	}
}
