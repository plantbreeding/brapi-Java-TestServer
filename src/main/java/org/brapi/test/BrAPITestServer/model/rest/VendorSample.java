package org.brapi.test.BrAPITestServer.model.rest;

public class VendorSample {
    private String sampleDbId;
    private String well;
    private String row;
    private String column;
    private String concentration;
    private String volume;
    private String tissueType;
    private TaxonID taxonId;
    
	public String getSampleDbId() {
		return sampleDbId;
	}
	public void setSampleDbId(String sampleDbId) {
		this.sampleDbId = sampleDbId;
	}
	public String getWell() {
		return well;
	}
	public void setWell(String well) {
		this.well = well;
	}
	public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public String getConcentration() {
		return concentration;
	}
	public void setConcentration(String concentration) {
		this.concentration = concentration;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getTissueType() {
		return tissueType;
	}
	public void setTissueType(String tissueType) {
		this.tissueType = tissueType;
	}
	public TaxonID getTaxonId() {
		return taxonId;
	}
	public void setTaxonId(TaxonID taxonId) {
		this.taxonId = taxonId;
	}
}
