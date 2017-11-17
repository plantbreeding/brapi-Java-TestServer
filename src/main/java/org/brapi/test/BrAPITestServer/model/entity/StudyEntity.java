package org.brapi.test.BrAPITestServer.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="study")
public class StudyEntity extends BaseEntity{
	@Column
	private String studyName;
	@Column
	private String studyType;
	@Column
	private String studyDescription;
	@ManyToMany
	@JoinTable(name = "study_season", joinColumns = { @JoinColumn(name = "study_db_id", referencedColumnName="id") }, inverseJoinColumns = { @JoinColumn(name = "season_db_id", referencedColumnName="id") })
	private List<SeasonEntity> seasons;
	@Column
	private String trialDbId;
	@Column
	private String trialName;
	@Column
	private Date startDate;
	@Column
	private Date endDate;
	@Column
	private boolean active;
	@Column
	private String license;
	@Column
	private String version;
	@Column
	private Date timestamp;
	@OneToOne
	private LocationEntity location;
	@OneToMany(mappedBy="studyDbId", targetEntity=ContactEntity.class)
	private List<ContactEntity> contacts;
	@OneToMany(mappedBy="studyDbId", targetEntity=DataLinkEntity.class)
	private List<DataLinkEntity> dataLinks;
	@OneToMany(mappedBy="studyDbId", targetEntity=StudyAddtionalInfoEntity.class)
	private List<StudyAddtionalInfoEntity> additionalInfo;

	public String getStudyName() {
		return studyName;
	}
	public void setStudyName(String studyName) {
		this.studyName = studyName;
	}
	public String getStudyType() {
		return studyType;
	}
	public void setStudyType(String studyType) {
		this.studyType = studyType;
	}
	public String getStudyDescription() {
		return studyDescription;
	}
	public void setStudyDescription(String studyDescription) {
		this.studyDescription = studyDescription;
	}
	public List<SeasonEntity> getSeasons() {
		return seasons;
	}
	public void setSeasons(List<SeasonEntity> seasons) {
		this.seasons = seasons;
	}
	public String getTrialDbId() {
		return trialDbId;
	}
	public void setTrialDbId(String trialDbId) {
		this.trialDbId = trialDbId;
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
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public LocationEntity getLocation() {
		return location;
	}
	public void setLocation(LocationEntity location) {
		this.location = location;
	}
	public List<ContactEntity> getContacts() {
		return contacts;
	}
	public void setContacts(List<ContactEntity> contacts) {
		this.contacts = contacts;
	}
	public List<DataLinkEntity> getDataLinks() {
		return dataLinks;
	}
	public void setDataLinks(List<DataLinkEntity> dataLinks) {
		this.dataLinks = dataLinks;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public List<StudyAddtionalInfoEntity> getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(List<StudyAddtionalInfoEntity> additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
}
