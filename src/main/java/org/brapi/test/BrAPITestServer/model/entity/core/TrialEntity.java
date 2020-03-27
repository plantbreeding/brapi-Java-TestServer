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

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.brapi.test.BrAPITestServer.model.entity.ContactEntity;

@Entity
@Table(name="trial")
public class TrialEntity extends BrAPIPrimaryEntity{
	@Column
	private String trialName;
	@Column
	private Date startDate;
	@Column
	private Date endDate;
	@Column
	private boolean active;
	@Column
	private String datasetLicence;
	@Column
	private String datasetPUI;
	@Column
	private String documentationURL;
	@ManyToOne
	private ProgramEntity program;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "trial_contact", joinColumns = { @JoinColumn(name = "trial_db_id", referencedColumnName="id") }, inverseJoinColumns = { @JoinColumn(name = "contact_db_id", referencedColumnName="id") })
	private List<ContactEntity> contacts;
	@OneToMany(mappedBy="trial")
	private List<StudyEntity> studies;

	public String getDocumentationURL() {
		return documentationURL;
	}

	public void setDocumentationURL(String documentationURL) {
		this.documentationURL = documentationURL;
	}

	public String getDatasetLicence() {
		return datasetLicence;
	}

	public void setDatasetLicence(String datasetLicence) {
		this.datasetLicence = datasetLicence;
	}

	public String getDatasetPUI() {
		return datasetPUI;
	}

	public void setDatasetPUI(String datasetPUI) {
		this.datasetPUI = datasetPUI;
	}

	public ProgramEntity getProgram() {
		return program;
	}

	public void setProgram(ProgramEntity program) {
		this.program = program;
	}

	public List<StudyEntity> getStudies() {
		return studies;
	}

	public void setStudies(List<StudyEntity> studies) {
		this.studies = studies;
	}

	public String getTrialName() {
		return trialName;
	}

	public void setTrialName(String trialName) {
		this.trialName = trialName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<ContactEntity> getContacts() {
		return contacts;
	}

	public void setContacts(List<ContactEntity> contacts) {
		this.contacts = contacts;
	}
}
