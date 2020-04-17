package org.brapi.test.BrAPITestServer.model.entity.pheno;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.StudyEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.GermplasmEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.SeedLotEntity;

@Entity
@Table(name = "observation_unit")
public class ObservationUnitEntity extends BrAPIPrimaryEntity {
	@ManyToOne
	private StudyEntity study;
	@ManyToOne
	private GermplasmEntity germplasm;
	@Column
	private String observationUnitName;
	@Column
	private String observationUnitPUI;
	@ManyToOne
	private SeedLotEntity seedLot;
	@OneToMany(mappedBy="observationUnit", cascade=CascadeType.ALL)
	private List<TreatmentEntity> treatments;
	@OneToOne(mappedBy="observationUnit", cascade=CascadeType.ALL)
	private ObservationUnitPositionEntity position;
	@OneToMany(mappedBy="observationUnit", cascade=CascadeType.ALL)
	private List<ObservationEntity> observations;
	
	public StudyEntity getStudy() {
		return study;
	}
	public void setStudy(StudyEntity study) {
		this.study = study;
	}
	public GermplasmEntity getGermplasm() {
		return germplasm;
	}
	public void setGermplasm(GermplasmEntity germplasm) {
		this.germplasm = germplasm;
	}
	public String getObservationUnitName() {
		return observationUnitName;
	}
	public void setObservationUnitName(String observationUnitName) {
		this.observationUnitName = observationUnitName;
	}
	public String getObservationUnitPUI() {
		return observationUnitPUI;
	}
	public void setObservationUnitPUI(String observationUnitPUI) {
		this.observationUnitPUI = observationUnitPUI;
	}
	public SeedLotEntity getSeedLot() {
		return seedLot;
	}
	public void setSeedLot(SeedLotEntity seedLot) {
		this.seedLot = seedLot;
	}
	public List<TreatmentEntity> getTreatments() {
		return treatments;
	}
	public void setTreatments(List<TreatmentEntity> treatments) {
		this.treatments = treatments;
	}
	public ObservationUnitPositionEntity getPosition() {
		return position;
	}
	public void setPosition(ObservationUnitPositionEntity position) {
		this.position = position;
	}
	public List<ObservationEntity> getObservations() {
		return observations;
	}
	public void setObservations(List<ObservationEntity> observations) {
		this.observations = observations;
	}
}
