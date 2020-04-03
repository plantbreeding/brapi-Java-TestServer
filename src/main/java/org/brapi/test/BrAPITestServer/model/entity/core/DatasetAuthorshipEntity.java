package org.brapi.test.BrAPITestServer.model.entity.core;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

@Entity
@Table(name = "trial_dataset_authorship")
public class DatasetAuthorshipEntity extends BrAPIBaseEntity {
	@Column
	private String datasetPUI;
	@Column 
	private String license;
	@Column
	private Date publicReleaseDate;
	@Column
	private Date submissionDate;
	@ManyToOne
	private TrialEntity trial;
	
	public TrialEntity getTrial() {
		return trial;
	}
	public void setTrial(TrialEntity trial) {
		this.trial = trial;
	}
	public String getDatasetPUI() {
		return datasetPUI;
	}
	public void setDatasetPUI(String datasetPUI) {
		this.datasetPUI = datasetPUI;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public Date getPublicReleaseDate() {
		return publicReleaseDate;
	}
	public void setPublicReleaseDate(Date publicReleaseDate) {
		this.publicReleaseDate = publicReleaseDate;
	}
	public Date getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}
}
