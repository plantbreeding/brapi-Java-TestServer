package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pedigree")
public class PedigreeEntity extends BaseEntity{
	@OneToMany
    private List<GermplasmEntity> germplasm;
	@Column
    private String defaultDisplayName;
	@Column
    private String pedigree;
	@Column
    private String parent1Id;
	@Column
    private String parent2Id;
	@Column
	private String notation;
    
	public List<GermplasmEntity> getGermplasm() {
		return germplasm;
	}
	public void setGermplasm(List<GermplasmEntity> germplasm) {
		this.germplasm = germplasm;
	}
	public String getNotation() {
		return notation;
	}
	public void setNotation(String notation) {
		this.notation = notation;
	}
	public String getDefaultDisplayName() {
		return defaultDisplayName;
	}
	public void setDefaultDisplayName(String defaultDisplayName) {
		this.defaultDisplayName = defaultDisplayName;
	}
	public String getPedigree() {
		return pedigree;
	}
	public void setPedigree(String pedigree) {
		this.pedigree = pedigree;
	}
	public String getParent1Id() {
		return parent1Id;
	}
	public void setParent1Id(String parent1Id) {
		this.parent1Id = parent1Id;
	}
	public String getParent2Id() {
		return parent2Id;
	}
	public void setParent2Id(String parent2Id) {
		this.parent2Id = parent2Id;
	}
    
}
