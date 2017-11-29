package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedigree")
public class PedigreeEntity extends BaseEntity{
	@OneToMany(mappedBy="pedigree")
    private List<GermplasmEntity> germplasm;
	@Column
    private String defaultDisplayName;
	@Column
    private String pedigree;
	@OneToOne
    @JoinColumn(name = "parent1_db_id")
    private PedigreeEntity parent1;
	@OneToOne
    @JoinColumn(name = "parent2_db_id")
    private PedigreeEntity parent2;
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
	public PedigreeEntity getParent1() {
		return parent1;
	}
	public void setParent1(PedigreeEntity parent1) {
		this.parent1 = parent1;
	}
	public PedigreeEntity getParent2() {
		return parent2;
	}
	public void setParent2(PedigreeEntity parent2) {
		this.parent2 = parent2;
	}
    
}
