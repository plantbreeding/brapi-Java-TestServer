package org.brapi.test.BrAPITestServer.model.entity;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="study")
public class StudyEntity extends BaseEntity{
	@Column
	private String studyName;
	@ManyToOne
	private StudyTypeEntity studyType;
	@Column
	private String studyDescription;
	@ManyToMany
	@JoinTable(name = "study_season", joinColumns = { @JoinColumn(name = "study_db_id", referencedColumnName="id") }, inverseJoinColumns = { @JoinColumn(name = "season_db_id", referencedColumnName="id") })
	private List<SeasonEntity> seasons;
	@Column
	private Date startDate;
	@Column
	private Date endDate;
	@Column
	private boolean active;
	@Column
	private String licence;
	@Column
	private String version;
	@Column
	private Date timestamp;
	@ManyToOne
	private TrialEntity trial;
	@OneToOne
	private LocationEntity location;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "study_contact", joinColumns = { @JoinColumn(name = "study_db_id", referencedColumnName="id") }, inverseJoinColumns = { @JoinColumn(name = "contact_db_id", referencedColumnName="id") })
	private List<ContactEntity> contacts;
	@OneToMany(mappedBy="studyDbId")
	private List<DataLinkEntity> dataLinks;
	@OneToMany(mappedBy="studyDbId")
	private List<StudyAddtionalInfoEntity> additionalInfo;
	@OneToMany(mappedBy="study")
	private List<ObservationUnitEntity> observationUnits;

	public StudyTypeEntity getStudyType() {
		return studyType;
	}
	public void setStudyType(StudyTypeEntity studyType) {
		this.studyType = studyType;
	}
	public String getStudyName() {
		return studyName;
	}
	public void setStudyName(String studyName) {
		this.studyName = studyName;
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
	public TrialEntity getTrial() {
		return trial;
	}
	public void setTrial(TrialEntity trial) {
		this.trial = trial;
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
	public String getLicence() {
		return licence;
	}
	public void setLicence(String licence) {
		this.licence = licence;
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
