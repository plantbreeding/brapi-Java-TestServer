package org.brapi.test.BrAPITestServer.model.rest;

public class AlleleFormatParams {
	private String sepPhased;
	private String sepUnphased;
	private String unknownString;
	private boolean expandHomozygotes;
	public String getSepPhased() {
		return sepPhased;
	}
	public void setSepPhased(String sepPhased) {
		this.sepPhased = sepPhased;
	}
	public String getSepUnphased() {
		return sepUnphased;
	}
	public void setSepUnphased(String sepUnphased) {
		this.sepUnphased = sepUnphased;
	}
	public String getUnknownString() {
		return unknownString;
	}
	public void setUnknownString(String unknownString) {
		this.unknownString = unknownString;
	}
	public boolean isExpandHomozygotes() {
		return expandHomozygotes;
	}
	public void setExpandHomozygotes(boolean expandHomozygotes) {
		this.expandHomozygotes = expandHomozygotes;
	}
	
	
}
