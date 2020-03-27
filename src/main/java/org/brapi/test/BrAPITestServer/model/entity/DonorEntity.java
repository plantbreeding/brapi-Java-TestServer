package org.brapi.test.BrAPITestServer.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="donor")
public class DonorEntity extends BrAPIBaseEntity{
	@Column
	private String germplasmDbId;
	@Column
	private String donorAccessionNumber;
	@Column
	private String donorInstituteCode;
	@Column
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
	public String getGermplasmDbId() {
		return germplasmDbId;
	}
	public void setGermplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
	}
	
}
