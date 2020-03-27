package org.brapi.test.BrAPITestServer.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedigree")
public class PedigreeEntity extends BrAPIBaseEntity{
	@OneToOne
    @JoinColumn(name = "germplasm_db_id")
    private GermplasmEntity germplasm;
	@Column
    private String crossingPlan;
	@Column
    private Integer crossingYear;
	@Column
    private String familyCode;
	@Column
    private String pedigree;
	@OneToOne
    @JoinColumn(name = "parent1_db_id")
    private PedigreeEntity parent1;
	@Column
	private String parent1Type;
	@OneToOne
    @JoinColumn(name = "parent2_db_id")
    private PedigreeEntity parent2;
	@Column
	private String parent2Type;
	@Column
	private String notation;
    
	public String getCrossingPlan() {
		return crossingPlan;
	}
	public void setCrossingPlan(String crossingPlan) {
		this.crossingPlan = crossingPlan;
	}
	public Integer getCrossingYear() {
		return crossingYear;
	}
	public void setCrossingYear(Integer crossingYear) {
		this.crossingYear = crossingYear;
	}
	public String getFamilyCode() {
		return familyCode;
	}
	public void setFamilyCode(String familyCode) {
		this.familyCode = familyCode;
	}
	public String getParent1Type() {
		return parent1Type;
	}
	public void setParent1Type(String parent1Type) {
		this.parent1Type = parent1Type;
	}
	public String getParent2Type() {
		return parent2Type;
	}
	public void setParent2Type(String parent2Type) {
		this.parent2Type = parent2Type;
	}
	public GermplasmEntity getGermplasm() {
		return germplasm;
	}
	public void setGermplasm(GermplasmEntity germplasm) {
		this.germplasm = germplasm;
	}
	public String getNotation() {
		return notation;
	}
	public void setNotation(String notation) {
		this.notation = notation;
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
