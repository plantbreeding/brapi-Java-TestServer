package org.brapi.test.BrAPITestServer.model.entity.germ;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

@Entity
@Table(name = "germplasm_institute")
public class GermplasmInstituteEntity extends BrAPIBaseEntity {

	@Column
	private String instituteCode;
	@Column
	private InstituteTypeEnum instituteType;
	@Column
	private String instituteName;
	@Column
	private String instituteAddress;
	@ManyToOne
	private GermplasmEntity germplasm;

	public enum InstituteTypeEnum {
		HOST, DONOR, BREEDING, COLLECTING, REDUNDANT
	}

	public String getInstituteCode() {
		return instituteCode;
	}

	public void setInstituteCode(String instituteCode) {
		this.instituteCode = instituteCode;
	}

	public InstituteTypeEnum getInstituteType() {
		return instituteType;
	}

	public void setInstituteType(InstituteTypeEnum instituteType) {
		this.instituteType = instituteType;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getInstituteAddress() {
		return instituteAddress;
	}

	public void setInstituteAddress(String instituteAddress) {
		this.instituteAddress = instituteAddress;
	}

	public GermplasmEntity getGermplasm() {
		return germplasm;
	}

	public void setGermplasm(GermplasmEntity germplasm) {
		this.germplasm = germplasm;
	}

}
