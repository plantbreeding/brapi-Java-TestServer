package org.brapi.test.BrAPITestServer.model.entity.germ;

import javax.persistence.*;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;

@Entity
@Table(name="germplasm_donor")
public class DonorEntity extends BrAPIPrimaryEntity{
	@ManyToOne(fetch = FetchType.LAZY)
	private GermplasmEntity germplasm;
	@Column
	private String donorAccessionNumber;
	@Column
	private String donorInstituteCode;
	@Column
	private String donorInstituteName;
	@Column
	private String germplasmPUI;
	
	public String getDonorInstituteName() {
		return donorInstituteName;
	}
	public void setDonorInstituteName(String donorInstituteName) {
		this.donorInstituteName = donorInstituteName;
	}
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
	public GermplasmEntity getGermplasm() {
		return germplasm;
	}
	public void setGermplasm(GermplasmEntity germplasm) {
		this.germplasm = germplasm;
	}
	
}
