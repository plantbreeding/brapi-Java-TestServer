package org.brapi.test.BrAPITestServer.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="trait_abbreviation")
public class TraitAbbreviationEntity extends BaseEntity{
	@Column
	private String traitDbId;
	@Column
	private String abbreviation;
	
	public String getTraitDbId() {
		return traitDbId;
	}
	public void setTraitDbId(String traitDbId) {
		this.traitDbId = traitDbId;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	
}
