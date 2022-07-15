package org.brapi.test.BrAPITestServer.model.entity.core;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationUnitEntity;

@Entity
@Table(name="crop")
public class CropEntity extends BrAPIPrimaryEntity {
	@Column(name="crop_name")
	private String cropName;
	
	@OneToMany(mappedBy="crop")
	private List<ProgramEntity> program;
	@OneToMany(mappedBy="crop")
	private List<TrialEntity> trials;
	@OneToMany(mappedBy="crop")
	private List<StudyEntity> studies;
	@OneToMany(mappedBy="crop")
	private List<ObservationUnitEntity> observationUnits;
	@OneToMany(mappedBy="crop")
	private List<ObservationEntity> observations;

	public List<ProgramEntity> getProgram() {
		return program;
	}

	public void setProgram(List<ProgramEntity> program) {
		this.program = program;
	}

	public List<TrialEntity> getTrials() {
		return trials;
	}

	public void setTrials(List<TrialEntity> trials) {
		this.trials = trials;
	}

	public List<StudyEntity> getStudies() {
		return studies;
	}

	public void setStudies(List<StudyEntity> studies) {
		this.studies = studies;
	}

	public List<ObservationUnitEntity> getObservationUnits() {
		return observationUnits;
	}

	public void setObservationUnits(List<ObservationUnitEntity> observationUnits) {
		this.observationUnits = observationUnits;
	}

	public List<ObservationEntity> getObservations() {
		return observations;
	}

	public void setObservations(List<ObservationEntity> observations) {
		this.observations = observations;
	}

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
}
