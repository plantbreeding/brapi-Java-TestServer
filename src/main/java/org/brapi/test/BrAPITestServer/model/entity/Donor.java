package org.brapi.test.BrAPITestServer.model.entity;

public class Donor {
	private String donorAccessionNumber;
	private String donorInstituteCode;
	private String germplasmPUI;
	public String getDonorAccessionNumber() {
		return donorAccessionNumber;
	}
	public void setDonorAccessionNumber(String donorAccessionNumber) {
		this.donorAccessionNumber = donorAccessionNumber;
	}
	public String getDonorInstituteCode() {
		return donorInstituteCode;
	}
	public void setDonorInstituteCode(String donorInstituteCode) {
		this.donorInstituteCode = donorInstituteCode;
	}
	public String getGermplasmPUI() {
		return germplasmPUI;
	}
	public void setGermplasmPUI(String germplasmPUI) {
		this.germplasmPUI = germplasmPUI;
	}
}
