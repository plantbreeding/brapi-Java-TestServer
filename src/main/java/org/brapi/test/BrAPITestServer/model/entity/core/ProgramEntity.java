package org.brapi.test.BrAPITestServer.model.entity.core;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationUnitEntity;

@Entity
@Table(name="program")
public class ProgramEntity extends BrAPIPrimaryEntity{
	@Column
	private String name;
	@Column
	private String abbreviation;
	@Column
	private String objective;
	@Column
	private String documentationURL;
	@OneToOne
	private PersonEntity leadPerson;
	
	@ManyToOne
	private CropEntity crop;
	
	@OneToMany(mappedBy="program")
	private List<TrialEntity> trials;
	@OneToMany(mappedBy="program")
	private List<StudyEntity> studies;
	@OneToMany(mappedBy="program")
	private List<ObservationUnitEntity> observationUnits;
	@OneToMany(mappedBy="program")
	private List<ObservationEntity> observations;

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
	public String getDocumentationURL() {
		return documentationURL;
	}
	public void setDocumentationURL(String documentationURL) {
		this.documentationURL = documentationURL;
	}
	public PersonEntity getLeadPerson() {
		return leadPerson;
	}
	public void setLeadPerson(PersonEntity leadPerson) {
		this.leadPerson = leadPerson;
	}
	public CropEntity getCrop() {
		return crop;
	}
	public void setCrop(CropEntity crop) {
		this.crop = crop;
	}
	public List<TrialEntity> getTrials() {
		return trials;
	}
	public void setTrials(List<TrialEntity> trials) {
		this.trials = trials;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public String getObjective() {
		return objective;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}
}
