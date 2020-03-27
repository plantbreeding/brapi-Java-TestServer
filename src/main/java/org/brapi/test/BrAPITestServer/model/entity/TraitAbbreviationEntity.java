package org.brapi.test.BrAPITestServer.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="trait_abbreviation")
public class TraitAbbreviationEntity extends BrAPIBaseEntity{
	@ManyToOne
	private TraitEntity trait;
	@Column
	private String abbreviation;
	
	public TraitEntity getTrait() {
		return trait;
	}
	public void setTrait(TraitEntity trait) {
		this.trait = trait;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	
}
