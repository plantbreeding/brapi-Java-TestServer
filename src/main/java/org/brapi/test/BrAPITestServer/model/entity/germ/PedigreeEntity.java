package org.brapi.test.BrAPITestServer.model.entity.germ;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

import io.swagger.model.germ.ParentType;

@Entity
@Table(name="pedigree")
public class PedigreeEntity extends BrAPIBaseEntity{
	@OneToOne(cascade = CascadeType.ALL)
    private GermplasmEntity germplasm;
	@OneToOne
    private CrossingProjectEntity crossingProject;
	@Column
    private Integer crossingYear;
	@Column
    private String familyCode;
	@Column
    private String pedigree;
	@OneToOne(cascade = CascadeType.ALL)
    private PedigreeEntity parent1;
	@Column
	private ParentType parent1Type;
	@OneToOne(cascade = CascadeType.ALL)
    private PedigreeEntity parent2;
	@Column
	private ParentType parent2Type;
	@Column
	private String notation;
    
	public CrossingProjectEntity getCrossingProject() {
		return crossingProject;
	}
	public void setCrossingProject(CrossingProjectEntity crossingProject) {
		this.crossingProject = crossingProject;
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
	public ParentType getParent1Type() {
		return parent1Type;
	}
	public void setParent1Type(ParentType parent1Type) {
		this.parent1Type = parent1Type;
	}
	public ParentType getParent2Type() {
		return parent2Type;
	}
	public void setParent2Type(ParentType parent2Type) {
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
