package org.brapi.test.BrAPITestServer.model.entity.core;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationUnitEntity;

@Entity
@Table(name = "trial")
public class TrialEntity extends BrAPIPrimaryEntity {
	@Column
	private Boolean active;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "trial_contact", joinColumns = {
			@JoinColumn(name = "trial_db_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "contact_db_id", referencedColumnName = "id") })
	private List<ContactEntity> contacts;
	@OneToMany(mappedBy = "trial")
	private List<DatasetAuthorshipEntity> datasetAuthorships;
	@Column
	private String documentationURL;
	@Column
	private Date endDate;
	@OneToMany(mappedBy = "trial")
	private List<PublicationEntity> publications;
	@Column
	private Date startDate;
	@Column
	private String trialDescription;
	@Column
	private String trialName;
	@Column
	private String trialPUI;

	@ManyToOne
	private CropEntity crop;
	@ManyToOne
	private ProgramEntity program;
	
	@OneToMany(mappedBy = "trial")
	private List<StudyEntity> studies;
	@OneToMany(mappedBy="trial")
	private List<ObservationUnitEntity> observationUnits;
	@OneToMany(mappedBy="trial")
	private List<ObservationEntity> observations;
	
	public CropEntity getCrop() {
		return crop;
	}
	public void setCrop(CropEntity crop) {
		this.crop = crop;
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
	public Boolean isActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public List<ContactEntity> getContacts() {
		return contacts;
	}
	public void setContacts(List<ContactEntity> contacts) {
		this.contacts = contacts;
	}
	public List<DatasetAuthorshipEntity> getDatasetAuthorships() {
		return datasetAuthorships;
	}
	public void setDatasetAuthorships(List<DatasetAuthorshipEntity> datasetAuthorships) {
		this.datasetAuthorships = datasetAuthorships;
	}
	public String getDocumentationURL() {
		return documentationURL;
	}
	public void setDocumentationURL(String documentationURL) {
		this.documentationURL = documentationURL;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public ProgramEntity getProgram() {
		return program;
	}
	public void setProgram(ProgramEntity program) {
		this.program = program;
		setCrop(program.getCrop());
	}
	public List<PublicationEntity> getPublications() {
		return publications;
	}
	public void setPublications(List<PublicationEntity> publications) {
		this.publications = publications;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getTrialDescription() {
		return trialDescription;
	}
	public void setTrialDescription(String trialDescription) {
		this.trialDescription = trialDescription;
	}
	public String getTrialName() {
		return trialName;
	}
	public void setTrialName(String trialName) {
		this.trialName = trialName;
	}
	public String getTrialPUI() {
		return trialPUI;
	}
	public void setTrialPUI(String trialPUI) {
		this.trialPUI = trialPUI;
	}
	public List<StudyEntity> getStudies() {
		return studies;
	}
	public void setStudies(List<StudyEntity> studies) {
		this.studies = studies;
	}

}
