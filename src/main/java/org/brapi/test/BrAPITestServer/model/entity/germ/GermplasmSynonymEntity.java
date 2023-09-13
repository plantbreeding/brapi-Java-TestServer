package org.brapi.test.BrAPITestServer.model.entity.germ;

import javax.persistence.*;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

@Entity
@Table(name = "germplasm_synonym")
public class GermplasmSynonymEntity extends BrAPIBaseEntity {
	@Column
	private String synonym;
	@Column
	private String type;
	@ManyToOne(fetch = FetchType.LAZY)
	private GermplasmEntity germplasm;
	
	public GermplasmEntity getGermplasm() {
		return germplasm;
	}
	public void setGermplasm(GermplasmEntity germplasm) {
		this.germplasm = germplasm;
	}
	public String getSynonym() {
		return synonym;
	}
	public void setSynonym(String synonym) {
		this.synonym = synonym;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
