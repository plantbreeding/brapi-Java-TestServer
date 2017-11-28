package org.brapi.test.BrAPITestServer.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="trial")
public class TrialEntity extends BaseEntity{
	@Column
	private String trialName;
	@Column
	private Date startDate;
	@Column
	private Date endDate;
	@Column
	private boolean active;
	@Column
	private String datasetLicense;
	@Column
	private String datasetPUI;
	@ManyToOne
	private ProgramEntity program;
	@OneToMany(mappedBy="trialDbId")
	private List<ContactEntity> contacts;
	@OneToMany(mappedBy="trial")
	private List<StudyEntity> studies;
	@OneToMany(mappedBy="trialDbId")
	private List<TrialAdditionalInfoEntity> additionalInfo;

	public String getDatasetLicense() {
		return datasetLicense;
	}

	public void setDatasetLicense(String datasetLicense) {
		this.datasetLicense = datasetLicense;
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

	public List<TrialAdditionalInfoEntity> getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(List<TrialAdditionalInfoEntity> additionalInfo) {
		this.additionalInfo = additionalInfo;
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
