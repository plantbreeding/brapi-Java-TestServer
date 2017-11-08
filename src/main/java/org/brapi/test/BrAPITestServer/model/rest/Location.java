package org.brapi.test.BrAPITestServer.model.rest;

import java.util.Map;

public class Location {
	private String locationDbId;
	private String locationType;
	private String name;
	private String abbreviation;
	private String countryCode;
	private String countryName;
	private float latitude;
	private float longitude;
	private float altitude;
	private String instituteName;
	private String instituteAdress;
	private Map<String, String> additionalInfo;
	public String getLocationDbId() {
		return locationDbId;
	}
	public void setLocationDbId(String locationDbId) {
		this.locationDbId = locationDbId;
	}
	public String getLocationType() {
		return locationType;
	}
	public void setLocationType(String locationType) {
		this.locationType = locationType;
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
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public float getAltitude() {
		return altitude;
	}
	public void setAltitude(float altitude) {
		this.altitude = altitude;
	}
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	public String getInstituteAdress() {
		return instituteAdress;
	}
	public void setInstituteAdress(String instituteAdress) {
		this.instituteAdress = instituteAdress;
	}
	public Map<String, String> getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(Map<String, String> additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
}
