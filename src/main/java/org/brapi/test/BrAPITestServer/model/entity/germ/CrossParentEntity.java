package org.brapi.test.BrAPITestServer.model.entity.germ;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationUnitEntity;

import io.swagger.model.germ.ParentType;

@Entity
@Table(name="cross_parent")
public class CrossParentEntity extends BrAPIBaseEntity {
	@ManyToOne
	private GermplasmEntity germplasm;
	@ManyToOne
	private ObservationUnitEntity observationUnit;
	@Column
	private ParentType parentType;
	@ManyToOne
	private CrossEntity cross;
	@ManyToOne
	private CrossingProjectEntity crossingProject;
	
	public CrossingProjectEntity getCrossingProject() {
		return crossingProject;
	}
	public void setCrossingProject(CrossingProjectEntity crossingProject) {
		this.crossingProject = crossingProject;
	}
	public CrossEntity getCross() {
		return cross;
	}
	public void setCross(CrossEntity cross) {
		this.cross = cross;
	}
	public GermplasmEntity getGermplasm() {
		return germplasm;
	}
	public void setGermplasm(GermplasmEntity germplasm) {
		this.germplasm = germplasm;
	}
	public ObservationUnitEntity getObservationUnit() {
		return observationUnit;
	}
	public void setObservationUnit(ObservationUnitEntity observationUnit) {
		this.observationUnit = observationUnit;
	}
	public ParentType getParentType() {
		return parentType;
	}
	public void setParentType(ParentType parentType) {
		this.parentType = parentType;
	} 
}
