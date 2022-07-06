package io.swagger.model.core;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.BrAPIDataModel;
import io.swagger.model.GeoJSON;

public class LocationNewRequest extends BrAPIDataModel {
	@JsonProperty("abbreviation")
	private String abbreviation = null;

	@JsonProperty("coordinateDescription")
	private String coordinateDescription = null;

	@JsonProperty("coordinateUncertainty")
	private String coordinateUncertainty = null;

	@JsonProperty("coordinates")
	private GeoJSON coordinates = null;

	@JsonProperty("countryCode")
	private String countryCode = null;

	@JsonProperty("countryName")
	private String countryName = null;

	@JsonProperty("documentationURL")
	private String documentationURL = null;

	@JsonProperty("environmentType")
	private String environmentType = null;

	@JsonProperty("exposure")
	private String exposure = null;

	@JsonProperty("instituteAddress")
	private String instituteAddress = null;

	@JsonProperty("instituteName")
	private String instituteName = null;

	@JsonProperty("locationName")
	private String locationName = null;

	@JsonProperty("locationType")
	private String locationType = null;

	@JsonProperty("siteStatus")
	private String siteStatus = null;

	@JsonProperty("slope")
	private String slope = null;

	@JsonProperty("topography")
	private String topography = null;

	@JsonProperty("parentLocationDbId")
	private String parentLocationDbId = null;

	@JsonProperty("parentLocationName")
	private String parentLocationName = null;

	public LocationNewRequest abbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
		return this;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public LocationNewRequest coordinateDescription(String coordinateDescription) {
		this.coordinateDescription = coordinateDescription;
		return this;
	}

	public String getCoordinateDescription() {
		return coordinateDescription;
	}

	public void setCoordinateDescription(String coordinateDescription) {
		this.coordinateDescription = coordinateDescription;
	}

	public LocationNewRequest coordinateUncertainty(String coordinateUncertainty) {
		this.coordinateUncertainty = coordinateUncertainty;
		return this;
	}

	public String getCoordinateUncertainty() {
		return coordinateUncertainty;
	}

	public void setCoordinateUncertainty(String coordinateUncertainty) {
		this.coordinateUncertainty = coordinateUncertainty;
	}

	public LocationNewRequest coordinates(GeoJSON coordinates) {
		this.coordinates = coordinates;
		return this;
	}

	public GeoJSON getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(GeoJSON coordinates) {
		this.coordinates = coordinates;
	}

	public LocationNewRequest countryCode(String countryCode) {
		this.countryCode = countryCode;
		return this;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public LocationNewRequest countryName(String countryName) {
		this.countryName = countryName;
		return this;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public LocationNewRequest documentationURL(String documentationURL) {
		this.documentationURL = documentationURL;
		return this;
	}

	public String getDocumentationURL() {
		return documentationURL;
	}

	public void setDocumentationURL(String documentationURL) {
		this.documentationURL = documentationURL;
	}

	public LocationNewRequest environmentType(String environmentType) {
		this.environmentType = environmentType;
		return this;
	}

	public String getEnvironmentType() {
		return environmentType;
	}

	public void setEnvironmentType(String environmentType) {
		this.environmentType = environmentType;
	}

	public LocationNewRequest exposure(String exposure) {
		this.exposure = exposure;
		return this;
	}

	public String getExposure() {
		return exposure;
	}

	public void setExposure(String exposure) {
		this.exposure = exposure;
	}

	public LocationNewRequest instituteAddress(String instituteAddress) {
		this.instituteAddress = instituteAddress;
		return this;
	}

	public String getInstituteAddress() {
		return instituteAddress;
	}

	public void setInstituteAddress(String instituteAddress) {
		this.instituteAddress = instituteAddress;
	}

	public LocationNewRequest instituteName(String instituteName) {
		this.instituteName = instituteName;
		return this;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public LocationNewRequest locationName(String locationName) {
		this.locationName = locationName;
		return this;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public LocationNewRequest locationType(String locationType) {
		this.locationType = locationType;
		return this;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public LocationNewRequest siteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
		return this;
	}

	public String getSiteStatus() {
		return siteStatus;
	}

	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}

	public LocationNewRequest slope(String slope) {
		this.slope = slope;
		return this;
	}

	public String getSlope() {
		return slope;
	}

	public void setSlope(String slope) {
		this.slope = slope;
	}

	public LocationNewRequest topography(String topography) {
		this.topography = topography;
		return this;
	}

	public String getTopography() {
		return topography;
	}

	public void setTopography(String topography) {
		this.topography = topography;
	}

	public LocationNewRequest parentLocationDbId(String parentLocationDbId) {
		this.parentLocationDbId = parentLocationDbId;
		return this;
	}

	public String getParentLocationDbId() {
		return parentLocationDbId;
	}

	public void setParentLocationDbId(String parentLocationDbId) {
		this.parentLocationDbId = parentLocationDbId;
	}

	public LocationNewRequest parentLocationName(String parentLocationName) {
		this.parentLocationName = parentLocationName;
		return this;
	}

	public String getParentLocationName() {
		return parentLocationName;
	}

	public void setParentLocationName(String parentLocationName) {
		this.parentLocationName = parentLocationName;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		LocationNewRequest locationNewRequest = (LocationNewRequest) o;
		return Objects.equals(this.abbreviation, locationNewRequest.abbreviation)
				&& Objects.equals(this.additionalInfo, locationNewRequest.additionalInfo)
				&& Objects.equals(this.coordinateDescription, locationNewRequest.coordinateDescription)
				&& Objects.equals(this.coordinateUncertainty, locationNewRequest.coordinateUncertainty)
				&& Objects.equals(this.coordinates, locationNewRequest.coordinates)
				&& Objects.equals(this.countryCode, locationNewRequest.countryCode)
				&& Objects.equals(this.countryName, locationNewRequest.countryName)
				&& Objects.equals(this.documentationURL, locationNewRequest.documentationURL)
				&& Objects.equals(this.environmentType, locationNewRequest.environmentType)
				&& Objects.equals(this.exposure, locationNewRequest.exposure)
				&& Objects.equals(this.externalReferences, locationNewRequest.externalReferences)
				&& Objects.equals(this.instituteAddress, locationNewRequest.instituteAddress)
				&& Objects.equals(this.instituteName, locationNewRequest.instituteName)
				&& Objects.equals(this.locationName, locationNewRequest.locationName)
				&& Objects.equals(this.locationType, locationNewRequest.locationType)
				&& Objects.equals(this.siteStatus, locationNewRequest.siteStatus)
				&& Objects.equals(this.slope, locationNewRequest.slope)
				&& Objects.equals(this.topography, locationNewRequest.topography)
				&& Objects.equals(this.parentLocationDbId, locationNewRequest.parentLocationDbId)
				&& Objects.equals(this.parentLocationName, locationNewRequest.parentLocationName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(abbreviation, additionalInfo, coordinateDescription, coordinateUncertainty, coordinates,
				countryCode, countryName, documentationURL, environmentType, exposure, externalReferences,
				instituteAddress, instituteName, locationName, locationType, siteStatus, slope, topography,
				parentLocationDbId, parentLocationName);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class LocationNewRequest {\n");

		sb.append("    abbreviation: ").append(toIndentedString(abbreviation)).append("\n");
		sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
		sb.append("    coordinateDescription: ").append(toIndentedString(coordinateDescription)).append("\n");
		sb.append("    coordinateUncertainty: ").append(toIndentedString(coordinateUncertainty)).append("\n");
		sb.append("    coordinates: ").append(toIndentedString(coordinates)).append("\n");
		sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
		sb.append("    countryName: ").append(toIndentedString(countryName)).append("\n");
		sb.append("    documentationURL: ").append(toIndentedString(documentationURL)).append("\n");
		sb.append("    environmentType: ").append(toIndentedString(environmentType)).append("\n");
		sb.append("    exposure: ").append(toIndentedString(exposure)).append("\n");
		sb.append("    externalReferences: ").append(toIndentedString(externalReferences)).append("\n");
		sb.append("    instituteAddress: ").append(toIndentedString(instituteAddress)).append("\n");
		sb.append("    instituteName: ").append(toIndentedString(instituteName)).append("\n");
		sb.append("    locationName: ").append(toIndentedString(locationName)).append("\n");
		sb.append("    locationType: ").append(toIndentedString(locationType)).append("\n");
		sb.append("    siteStatus: ").append(toIndentedString(siteStatus)).append("\n");
		sb.append("    slope: ").append(toIndentedString(slope)).append("\n");
		sb.append("    topography: ").append(toIndentedString(topography)).append("\n");
		sb.append("    parentLocationDbId: ").append(toIndentedString(parentLocationDbId)).append("\n");
		sb.append("    parentLocationName: ").append(toIndentedString(parentLocationName)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
