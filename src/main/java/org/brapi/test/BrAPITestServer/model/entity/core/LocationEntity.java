package org.brapi.test.BrAPITestServer.model.entity.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.brapi.test.BrAPITestServer.model.entity.GeoJSONEntity;

@Entity
@Table(name="location")
public class LocationEntity extends BrAPIPrimaryEntity{
	@Column
	private String abbreviation;
	@Column
	private String coordinateDescription;
	@Column
	private String coordinateUncertainty;
	@OneToOne
	private GeoJSONEntity coordinates;
	@Column
	private String countryCode;
	@Column
	private String countryName;
	@Column
	private String documentationURL;
	@Column
	private String environmentType;
	@Column
	private String exposure;
	@Column
	private String instituteAddress;
	@Column
	private String instituteName;
	@Column
	private String locationName;
	@Column
	private String locationType;
	@Column
	private String siteStatus;
	@Column
	private String slope;
	@Column
	private String topography;

	public String getCoordinateDescription() {
		return coordinateDescription;
	}
	public void setCoordinateDescription(String coordinateDescription) {
		this.coordinateDescription = coordinateDescription;
	}
	public String getCoordinateUncertainty() {
		return coordinateUncertainty;
	}
	public void setCoordinateUncertainty(String coordinateUncertainty) {
		this.coordinateUncertainty = coordinateUncertainty;
	}
	public GeoJSONEntity getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(GeoJSONEntity coordinates) {
		this.coordinates = coordinates;
	}
	public String getEnvironmentType() {
		return environmentType;
	}
	public void setEnvironmentType(String environmentType) {
		this.environmentType = environmentType;
	}
	public String getExposure() {
		return exposure;
	}
	public void setExposure(String exposure) {
		this.exposure = exposure;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getSiteStatus() {
		return siteStatus;
	}
	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}
	public String getSlope() {
		return slope;
	}
	public void setSlope(String slope) {
		this.slope = slope;
	}
	public String getTopography() {
		return topography;
	}
	public void setTopography(String topography) {
		this.topography = topography;
	}
	public String getDocumentationURL() {
		return documentationURL;
	}
	public void setDocumentationURL(String documentationURL) {
		this.documentationURL = documentationURL;
	}
	public String getLocationType() {
		return locationType;
	}
	public void setLocationType(String locationType) {
		this.locationType = locationType;
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

}
