package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="location")
public class LocationEntity extends BaseEntity{
	@Column
	private String locationType;
	@Column
	private String name;
	@Column
	private String abbreviation;
	@Column
	private String countryCode;
	@Column
	private String countryName;
	@Column
	private float latitude;
	@Column
	private float longitude;
	@Column
	private float altitude;
	@Column
	private String instituteName;
	@Column
	private String instituteAddress;
	@OneToMany(mappedBy="locationDbId", targetEntity=LocationAdditionalInfoEntity.class)
	private List<LocationAdditionalInfoEntity> additionalInfo;

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
	public String getInstituteAddress() {
		return instituteAddress;
	}
	public void setInstituteAddress(String instituteAddress) {
		this.instituteAddress = instituteAddress;
	}
	public List<LocationAdditionalInfoEntity> getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(List<LocationAdditionalInfoEntity> additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

}
