package org.brapi.test.BrAPITestServer.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="trait_synonym")
public class TraitSynonymEntity extends BrAPIBaseEntity{
	@ManyToOne
	private TraitEntity trait;
	@Column
	private String synonym;
	
	public TraitEntity getTrait() {
		return trait;
	}
	public void setTrait(TraitEntity trait) {
		this.trait = trait;
	}
	public String getSynonym() {
		return synonym;
	}
	public void setSynonym(String synonym) {
		this.synonym = synonym;
	}
	
}
