package org.brapi.test.BrAPITestServer.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="trait_synonym")
public class TraitSynonymEntity extends BaseEntity{
	@Column
	private String traitDbId;
	@Column
	private String synonym;
	
	public String getTraitDbId() {
		return traitDbId;
	}
	public void setTraitDbId(String traitDbId) {
		this.traitDbId = traitDbId;
	}
	public String getSynonym() {
		return synonym;
	}
	public void setSynonym(String synonym) {
		this.synonym = synonym;
	}
	
}
