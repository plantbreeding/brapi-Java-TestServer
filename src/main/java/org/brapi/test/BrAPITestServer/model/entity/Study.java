package org.brapi.test.BrAPITestServer.model.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Study {
	private String studyDbId;
	private String studyName;
	private String studyType;
	private String studyDescription;
	private List<String> seasons;
	private String trialDbId;
	private String trialName;
	private Date startDate;
	private Date endDate;
	private boolean active;
	private String license;
	private Location location;
	private List<Contact> contacts;
	private List<DataLink> dataLinks;
	private Update lastUpdate;
	private Map<String, String> additionalInfo;
	public String getStudyDbId() {
		return studyDbId;
	}
	public void setStudyDbId(String studyDbId) {
		this.studyDbId = studyDbId;
	}
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
	public List<String> getSeasons() {
		return seasons;
	}
	public void setSeasons(List<String> seasons) {
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
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	public List<DataLink> getDataLinks() {
		return dataLinks;
	}
	public void setDataLinks(List<DataLink> dataLinks) {
		this.dataLinks = dataLinks;
	}
	public Update getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Update lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public Map<String, String> getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(Map<String, String> additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
}
