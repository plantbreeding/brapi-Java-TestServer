package org.brapi.test.BrAPITestServer.model.entity.pheno;

import javax.persistence.*;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

@Entity
@Table(name="trait_synonym")
public class TraitSynonymEntity extends BrAPIBaseEntity{
	@ManyToOne(fetch = FetchType.LAZY)
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
