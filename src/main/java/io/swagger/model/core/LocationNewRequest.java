package io.swagger.model.core;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ExternalReferences;
import io.swagger.model.GeoJSON;

import java.util.HashMap;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

/**
 * LocationNewRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class LocationNewRequest {
	@JsonProperty("abbreviation")
	private String abbreviation = null;

	@JsonProperty("additionalInfo")
	@Valid
	private Map<String, Object> additionalInfo = null;

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

	@JsonProperty("externalReferences")
	private ExternalReferences externalReferences = null;

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

	/**
	 * An abbreviation which represents this location
	 * 
	 * @return abbreviation
	 **/
	@ApiModelProperty(example = "L1", value = "An abbreviation which represents this location")

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public LocationNewRequest additionalInfo(Map<String, Object> additionalInfo) {
		this.additionalInfo = additionalInfo;
		return this;
	}

	public LocationNewRequest putAdditionalInfoItem(String key, String additionalInfoItem) {
		if (this.additionalInfo == null) {
			this.additionalInfo = new HashMap<String, Object>();
		}
		this.additionalInfo.put(key, additionalInfoItem);
		return this;
	}

	/**
	 * Additional arbitrary info
	 * 
	 * @return additionalInfo
	 **/
	@ApiModelProperty(example = "{}", value = "Additional arbitrary info")

	public Map<String, Object> getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(Map<String, Object> additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public LocationNewRequest coordinateDescription(String coordinateDescription) {
		this.coordinateDescription = coordinateDescription;
		return this;
	}

	/**
	 * Describes the precision and landmarks of the coordinate values used for this
	 * location. (ex. the site, the nearest town, a 10 kilometers radius circle, +/-
	 * 20 meters, etc)
	 * 
	 * @return coordinateDescription
	 **/
	@ApiModelProperty(example = "North East corner of greenhouse", value = "Describes the precision and landmarks of the coordinate values used for this location. (ex. the site, the nearest town, a 10 kilometers radius circle, +/- 20 meters, etc)")

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

	/**
	 * Uncertainty associated with the coordinates in meters. Leave the value empty
	 * if the uncertainty is unknown.
	 * 
	 * @return coordinateUncertainty
	 **/
	@ApiModelProperty(example = "20", value = "Uncertainty associated with the coordinates in meters. Leave the value empty if the uncertainty is unknown.")

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

	/**
	 * Get coordinates
	 * 
	 * @return coordinates
	 **/
	@ApiModelProperty(value = "")

	@Valid
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

	/**
	 * [ISO_3166-1_alpha-3](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-3) spec
	 * MIAPPE V1.1 (DM-17) Geographic location (country) - The country where the
	 * experiment took place, either as a full name or preferably as a 2-letter
	 * code.
	 * 
	 * @return countryCode
	 **/
	@ApiModelProperty(example = "PER", value = " [ISO_3166-1_alpha-3](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-3) spec MIAPPE V1.1 (DM-17) Geographic location (country) - The country where the experiment took place, either as a full name or preferably as a 2-letter code.")

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

	/**
	 * The full name of the country where this location is MIAPPE V1.1 (DM-17)
	 * Geographic location (country) - The country where the experiment took place,
	 * either as a full name or preferably as a 2-letter code.
	 * 
	 * @return countryName
	 **/
	@ApiModelProperty(example = "Peru", value = "The full name of the country where this location is  MIAPPE V1.1 (DM-17) Geographic location (country) - The country where the experiment took place, either as a full name or preferably as a 2-letter code.")

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

	/**
	 * A URL to the human readable documentation of this object
	 * 
	 * @return documentationURL
	 **/
	@ApiModelProperty(example = "https://brapi.org", value = "A URL to the human readable documentation of this object")

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

	/**
	 * Describes the general type of environment of the location. (ex. forest,
	 * field, nursery, etc)
	 * 
	 * @return environmentType
	 **/
	@ApiModelProperty(example = "Nursery", value = "Describes the general type of environment of the location. (ex. forest, field, nursery, etc)")

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

	/**
	 * Describes the level of protection/exposure for things like sun light and
	 * wind.
	 * 
	 * @return exposure
	 **/
	@ApiModelProperty(example = "Structure, no exposure", value = "Describes the level of protection/exposure for things like sun light and wind.")

	public String getExposure() {
		return exposure;
	}

	public void setExposure(String exposure) {
		this.exposure = exposure;
	}

	public LocationNewRequest externalReferences(ExternalReferences externalReferences) {
		this.externalReferences = externalReferences;
		return this;
	}

	/**
	 * Get externalReferences
	 * 
	 * @return externalReferences
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public ExternalReferences getExternalReferences() {
		return externalReferences;
	}

	public void setExternalReferences(ExternalReferences externalReferences) {
		this.externalReferences = externalReferences;
	}

	public LocationNewRequest instituteAddress(String instituteAddress) {
		this.instituteAddress = instituteAddress;
		return this;
	}

	/**
	 * The street address of the institute representing this location MIAPPE V1.1
	 * (DM-16) Contact institution - Name and address of the institution responsible
	 * for the study.
	 * 
	 * @return instituteAddress
	 **/
	@ApiModelProperty(example = "71 Pilgrim Avenue Chevy Chase MD 20815", value = "The street address of the institute representing this location  MIAPPE V1.1 (DM-16) Contact institution - Name and address of the institution responsible for the study.")

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

	/**
	 * Each institute/laboratory can have several experimental field MIAPPE V1.1
	 * (DM-16) Contact institution - Name and address of the institution responsible
	 * for the study.
	 * 
	 * @return instituteName
	 **/
	@ApiModelProperty(example = "Plant Science Institute", value = "Each institute/laboratory can have several experimental field  MIAPPE V1.1 (DM-16) Contact institution - Name and address of the institution responsible for the study.")

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

	/**
	 * A human readable name for this location MIAPPE V1.1 (DM-18) Experimental site
	 * name - The name of the natural site, experimental field, greenhouse,
	 * phenotyping facility, etc. where the experiment took place.
	 * 
	 * @return locationName
	 **/
	@ApiModelProperty(example = "Location 1", value = "A human readable name for this location  MIAPPE V1.1 (DM-18) Experimental site name - The name of the natural site, experimental field, greenhouse, phenotyping facility, etc. where the experiment took place.")

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

	/**
	 * The type of location this represents (ex. Breeding Location, Storage
	 * Location, etc)
	 * 
	 * @return locationType
	 **/
	@ApiModelProperty(example = "Storage Location", value = "The type of location this represents (ex. Breeding Location, Storage Location, etc)")

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

	/**
	 * Description of the accessibility of the location (ex. Public, Private)
	 * 
	 * @return siteStatus
	 **/
	@ApiModelProperty(example = "Private", value = "Description of the accessibility of the location (ex. Public, Private)")

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

	/**
	 * Describes the approximate slope (height/distance) of the location.
	 * 
	 * @return slope
	 **/
	@ApiModelProperty(example = "0", value = "Describes the approximate slope (height/distance) of the location.")

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

	/**
	 * Describes the topography of the land at the location. (ex. Plateau, Cirque,
	 * Hill, Valley, etc)
	 * 
	 * @return topography
	 **/
	@ApiModelProperty(example = "Valley", value = "Describes the topography of the land at the location. (ex. Plateau, Cirque, Hill, Valley, etc)")

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
				instituteAddress, instituteName, locationName, locationType, siteStatus, slope, topography, parentLocationDbId, parentLocationName);
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

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
