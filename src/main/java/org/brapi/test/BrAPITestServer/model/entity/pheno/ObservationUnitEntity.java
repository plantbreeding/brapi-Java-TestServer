package org.brapi.test.BrAPITestServer.model.entity.pheno;

import java.util.List;

import javax.persistence.*;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.CropEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.ProgramEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.StudyEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.TrialEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.CrossEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.GermplasmEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.SeedLotEntity;

@Entity
@Table(name = "observation_unit")
public class ObservationUnitEntity extends BrAPIPrimaryEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	private CrossEntity cross;
	@ManyToOne(fetch = FetchType.LAZY)
	private GermplasmEntity germplasm;
	@Column
	private String observationUnitName;
	@Column
	private String observationUnitPUI;
	@ManyToOne(fetch = FetchType.LAZY)
	private SeedLotEntity seedLot;
	@OneToMany(mappedBy="observationUnit", cascade=CascadeType.ALL)
	private List<TreatmentEntity> treatments;
	@OneToOne(mappedBy="observationUnit", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private ObservationUnitPositionEntity position;
	@ManyToOne(fetch = FetchType.LAZY)
	private CropEntity crop;
	@ManyToOne(fetch = FetchType.LAZY)
	private ProgramEntity program;
	@ManyToOne(fetch = FetchType.LAZY)
	private TrialEntity trial;
	@ManyToOne(fetch = FetchType.LAZY)
	private StudyEntity study;
	@OneToMany(mappedBy="observationUnit", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ObservationEntity> observations;
	
	
	public CrossEntity getCross() {
		return cross;
	}
	public void setCross(CrossEntity cross) {
		this.cross = cross;
	}
	public CropEntity getCrop() {
		return crop;
	}
	public void setCrop(CropEntity crop) {
		this.crop = crop;
	}
	public ProgramEntity getProgram() {
		return program;
	}
	public void setProgram(ProgramEntity program) {
		this.program = program;
		if (program.getCrop() != null)
			setCrop(program.getCrop());
	}
	public TrialEntity getTrial() {
		return trial;
	}
	public void setTrial(TrialEntity trial) {
		this.trial = trial;
		if (trial.getProgram() != null)
			setProgram(trial.getProgram());
	}
	public StudyEntity getStudy() {
		return study;
	}
	public void setStudy(StudyEntity study) {
		this.study = study;
		if (study.getTrial() != null)
			setTrial(study.getTrial());
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
