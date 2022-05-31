package io.swagger.model.core;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.GeoJSONSearchArea;
import io.swagger.model.SearchRequest;
import io.swagger.model.SearchRequestParametersPaging;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

/**
 * LocationSearchRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class LocationSearchRequest extends SearchRequestParametersPaging implements SearchRequest {
	@JsonProperty("externalReferenceIDs")
	@Valid
	private List<String> externalReferenceIDs = null;

	@JsonProperty("externalReferenceSources")
	@Valid
	private List<String> externalReferenceSources = null;

	@JsonProperty("locationDbIds")
	@Valid
	private List<String> locationDbIds = null;

	@JsonProperty("locationNames")
	@Valid
	private List<String> locationNames = null;

	@JsonProperty("abbreviations")
	@Valid
	private List<String> abbreviations = null;

	@JsonProperty("altitudeMax")
	private BigDecimal altitudeMax = null;

	@JsonProperty("altitudeMin")
	private BigDecimal altitudeMin = null;

	@JsonProperty("coordinates")
	private GeoJSONSearchArea coordinates = null;

	@JsonProperty("countryCodes")
	@Valid
	private List<String> countryCodes = null;

	@JsonProperty("countryNames")
	@Valid
	private List<String> countryNames = null;

	@JsonProperty("instituteAddresses")
	@Valid
	private List<String> instituteAddresses = null;

	@JsonProperty("instituteNames")
	@Valid
	private List<String> instituteNames = null;

	@JsonProperty("locationTypes")
	@Valid
	private List<String> locationTypes = null;

	public LocationSearchRequest externalReferenceIDs(List<String> externalReferenceIDs) {
		this.externalReferenceIDs = externalReferenceIDs;
		return this;
	}

	public LocationSearchRequest addExternalReferenceIDsItem(String externalReferenceIDsItem) {
		if (this.externalReferenceIDs == null) {
			this.externalReferenceIDs = new ArrayList<String>();
		}
		this.externalReferenceIDs.add(externalReferenceIDsItem);
		return this;
	}

	/**
	 * List of external references for the trait to search for
	 * 
	 * @return externalReferenceIDs
	 **/
	@ApiModelProperty(example = "[\"http://purl.obolibrary.org/obo/ro.owl\",\"14a19841\"]", value = "List of external references for the trait to search for")

	public List<String> getExternalReferenceIDs() {
		return externalReferenceIDs;
	}

	public void setExternalReferenceIDs(List<String> externalReferenceIDs) {
		this.externalReferenceIDs = externalReferenceIDs;
	}

	public LocationSearchRequest externalReferenceSources(List<String> externalReferenceSources) {
		this.externalReferenceSources = externalReferenceSources;
		return this;
	}

	public LocationSearchRequest addExternalReferenceSourcesItem(String externalReferenceSourcesItem) {
		if (this.externalReferenceSources == null) {
			this.externalReferenceSources = new ArrayList<String>();
		}
		this.externalReferenceSources.add(externalReferenceSourcesItem);
		return this;
	}

	/**
	 * List of external references sources for the trait to search for
	 * 
	 * @return externalReferenceSources
	 **/
	@ApiModelProperty(example = "[\"OBO Library\",\"Field App Name\"]", value = "List of external references sources for the trait to search for")

	public List<String> getExternalReferenceSources() {
		return externalReferenceSources;
	}

	public void setExternalReferenceSources(List<String> externalReferenceSources) {
		this.externalReferenceSources = externalReferenceSources;
	}

	public LocationSearchRequest locationDbIds(List<String> locationDbIds) {
		this.locationDbIds = locationDbIds;
		return this;
	}

	public LocationSearchRequest addLocationDbIdsItem(String locationDbIdsItem) {
		if (this.locationDbIds == null) {
			this.locationDbIds = new ArrayList<String>();
		}
		this.locationDbIds.add(locationDbIdsItem);
		return this;
	}

	/**
	 * The location ids to search for
	 * 
	 * @return locationDbIds
	 **/
	@ApiModelProperty(example = "[\"b28911cf\",\"5071d1e4\"]", value = "The location ids to search for")

	public List<String> getLocationDbIds() {
		return locationDbIds;
	}

	public void setLocationDbIds(List<String> locationDbIds) {
		this.locationDbIds = locationDbIds;
	}

	public LocationSearchRequest locationNames(List<String> locationNames) {
		this.locationNames = locationNames;
		return this;
	}

	public LocationSearchRequest addLocationNamesItem(String locationNamesItem) {
		if (this.locationNames == null) {
			this.locationNames = new ArrayList<String>();
		}
		this.locationNames.add(locationNamesItem);
		return this;
	}

	/**
	 * A human readable names to search for
	 * 
	 * @return locationNames
	 **/
	@ApiModelProperty(example = "[\"Location Alpha\",\"The Large Hadron Collider\"]", value = "A human readable names to search for")

	public List<String> getLocationNames() {
		return locationNames;
	}

	public void setLocationNames(List<String> locationNames) {
		this.locationNames = locationNames;
	}

	public LocationSearchRequest abbreviations(List<String> abbreviations) {
		this.abbreviations = abbreviations;
		return this;
	}

	public LocationSearchRequest addAbbreviationsItem(String abbreviationsItem) {
		if (this.abbreviations == null) {
			this.abbreviations = new ArrayList<String>();
		}
		this.abbreviations.add(abbreviationsItem);
		return this;
	}

	/**
	 * An abbreviation which represents this location
	 * 
	 * @return abbreviations
	 **/
	@ApiModelProperty(example = "[\"L1\",\"LHC\"]", value = "An abbreviation which represents this location")

	public List<String> getAbbreviations() {
		return abbreviations;
	}

	public void setAbbreviations(List<String> abbreviations) {
		this.abbreviations = abbreviations;
	}

	public LocationSearchRequest altitudeMax(BigDecimal altitudeMax) {
		this.altitudeMax = altitudeMax;
		return this;
	}

	/**
	 * The maximum altitude to search for
	 * 
	 * @return altitudeMax
	 **/
	@ApiModelProperty(example = "200", value = "The maximum altitude to search for")

	@Valid
	public BigDecimal getAltitudeMax() {
		return altitudeMax;
	}

	public void setAltitudeMax(BigDecimal altitudeMax) {
		this.altitudeMax = altitudeMax;
	}

	public LocationSearchRequest altitudeMin(BigDecimal altitudeMin) {
		this.altitudeMin = altitudeMin;
		return this;
	}

	/**
	 * The minimum altitude to search for
	 * 
	 * @return altitudeMin
	 **/
	@ApiModelProperty(example = "20", value = "The minimum altitude to search for")

	@Valid
	public BigDecimal getAltitudeMin() {
		return altitudeMin;
	}

	public void setAltitudeMin(BigDecimal altitudeMin) {
		this.altitudeMin = altitudeMin;
	}

	public LocationSearchRequest coordinates(GeoJSONSearchArea coordinates) {
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
	public GeoJSONSearchArea getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(GeoJSONSearchArea coordinates) {
		this.coordinates = coordinates;
	}

	public LocationSearchRequest countryCodes(List<String> countryCodes) {
		this.countryCodes = countryCodes;
		return this;
	}

	public LocationSearchRequest addCountryCodesItem(String countryCodesItem) {
		if (this.countryCodes == null) {
			this.countryCodes = new ArrayList<String>();
		}
		this.countryCodes.add(countryCodesItem);
		return this;
	}

	/**
	 * [ISO_3166-1_alpha-3](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-3) spec
	 * 
	 * @return countryCodes
	 **/
	@ApiModelProperty(example = "[\"USA\",\"PER\"]", value = "[ISO_3166-1_alpha-3](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-3) spec")

	public List<String> getCountryCodes() {
		return countryCodes;
	}

	public void setCountryCodes(List<String> countryCodes) {
		this.countryCodes = countryCodes;
	}

	public LocationSearchRequest countryNames(List<String> countryNames) {
		this.countryNames = countryNames;
		return this;
	}

	public LocationSearchRequest addCountryNamesItem(String countryNamesItem) {
		if (this.countryNames == null) {
			this.countryNames = new ArrayList<String>();
		}
		this.countryNames.add(countryNamesItem);
		return this;
	}

	/**
	 * The full name of the country to search for
	 * 
	 * @return countryNames
	 **/
	@ApiModelProperty(example = "[\"United States of America\",\"Peru\"]", value = "The full name of the country to search for")

	public List<String> getCountryNames() {
		return countryNames;
	}

	public void setCountryNames(List<String> countryNames) {
		this.countryNames = countryNames;
	}

	public LocationSearchRequest instituteAddresses(List<String> instituteAddresses) {
		this.instituteAddresses = instituteAddresses;
		return this;
	}

	public LocationSearchRequest addInstituteAddressesItem(String instituteAddressesItem) {
		if (this.instituteAddresses == null) {
			this.instituteAddresses = new ArrayList<String>();
		}
		this.instituteAddresses.add(instituteAddressesItem);
		return this;
	}

	/**
	 * The street address of the institute to search for
	 * 
	 * @return instituteAddresses
	 **/
	@ApiModelProperty(example = "[\"123 Main Street\",\"456 Side Street\"]", value = "The street address of the institute to search for")

	public List<String> getInstituteAddresses() {
		return instituteAddresses;
	}

	public void setInstituteAddresses(List<String> instituteAddresses) {
		this.instituteAddresses = instituteAddresses;
	}

	public LocationSearchRequest instituteNames(List<String> instituteNames) {
		this.instituteNames = instituteNames;
		return this;
	}

	public LocationSearchRequest addInstituteNamesItem(String instituteNamesItem) {
		if (this.instituteNames == null) {
			this.instituteNames = new ArrayList<String>();
		}
		this.instituteNames.add(instituteNamesItem);
		return this;
	}

	/**
	 * The name of the institute to search for
	 * 
	 * @return instituteNames
	 **/
	@ApiModelProperty(example = "[\"The Institute\",\"The Other Institute\"]", value = "The name of the institute to search for")

	public List<String> getInstituteNames() {
		return instituteNames;
	}

	public void setInstituteNames(List<String> instituteNames) {
		this.instituteNames = instituteNames;
	}

	public LocationSearchRequest locationTypes(List<String> locationTypes) {
		this.locationTypes = locationTypes;
		return this;
	}

	public LocationSearchRequest addLocationTypesItem(String locationTypesItem) {
		if (this.locationTypes == null) {
			this.locationTypes = new ArrayList<String>();
		}
		this.locationTypes.add(locationTypesItem);
		return this;
	}

	/**
	 * The type of location this represents (ex. Breeding Location, Storage
	 * Location, etc)
	 * 
	 * @return locationTypes
	 **/
	@ApiModelProperty(example = "[\"Nursery\",\"Storage Location\"]", value = "The type of location this represents (ex. Breeding Location, Storage Location, etc)")

	public List<String> getLocationTypes() {
		return locationTypes;
	}

	public void setLocationTypes(List<String> locationTypes) {
		this.locationTypes = locationTypes;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		LocationSearchRequest locationSearchRequest = (LocationSearchRequest) o;
		return Objects.equals(this.externalReferenceIDs, locationSearchRequest.externalReferenceIDs)
				&& Objects.equals(this.externalReferenceSources, locationSearchRequest.externalReferenceSources)
				&& Objects.equals(this.locationDbIds, locationSearchRequest.locationDbIds)
				&& Objects.equals(this.locationNames, locationSearchRequest.locationNames)
				&& Objects.equals(this.abbreviations, locationSearchRequest.abbreviations)
				&& Objects.equals(this.altitudeMax, locationSearchRequest.altitudeMax)
				&& Objects.equals(this.altitudeMin, locationSearchRequest.altitudeMin)
				&& Objects.equals(this.coordinates, locationSearchRequest.coordinates)
				&& Objects.equals(this.countryCodes, locationSearchRequest.countryCodes)
				&& Objects.equals(this.countryNames, locationSearchRequest.countryNames)
				&& Objects.equals(this.instituteAddresses, locationSearchRequest.instituteAddresses)
				&& Objects.equals(this.instituteNames, locationSearchRequest.instituteNames)
				&& Objects.equals(this.locationTypes, locationSearchRequest.locationTypes) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(externalReferenceIDs, externalReferenceSources, locationDbIds, locationNames, abbreviations,
				altitudeMax, altitudeMin, coordinates, countryCodes, countryNames, instituteAddresses, instituteNames,
				locationTypes, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class LocationSearchRequest {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    externalReferenceIDs: ").append(toIndentedString(externalReferenceIDs)).append("\n");
		sb.append("    externalReferenceSources: ").append(toIndentedString(externalReferenceSources)).append("\n");
		sb.append("    locationDbIds: ").append(toIndentedString(locationDbIds)).append("\n");
		sb.append("    locationNames: ").append(toIndentedString(locationNames)).append("\n");
		sb.append("    abbreviations: ").append(toIndentedString(abbreviations)).append("\n");
		sb.append("    altitudeMax: ").append(toIndentedString(altitudeMax)).append("\n");
		sb.append("    altitudeMin: ").append(toIndentedString(altitudeMin)).append("\n");
		sb.append("    coordinates: ").append(toIndentedString(coordinates)).append("\n");
		sb.append("    countryCodes: ").append(toIndentedString(countryCodes)).append("\n");
		sb.append("    countryNames: ").append(toIndentedString(countryNames)).append("\n");
		sb.append("    instituteAddresses: ").append(toIndentedString(instituteAddresses)).append("\n");
		sb.append("    instituteNames: ").append(toIndentedString(instituteNames)).append("\n");
		sb.append("    locationTypes: ").append(toIndentedString(locationTypes)).append("\n");
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

	@Override
	public Integer getTotalParameterCount() {
		Integer count = 0;
		if (this.externalReferenceIDs != null)
			count += this.externalReferenceIDs.size();
		if (this.externalReferenceSources != null)
			count += this.externalReferenceSources.size();
		if (this.locationDbIds != null)
			count += this.locationDbIds.size();
		if (this.locationNames != null)
			count += this.locationNames.size();
		if (this.abbreviations != null)
			count += this.abbreviations.size();
		if (this.altitudeMax != null)
			count += 1;
		if (this.altitudeMin != null)
			count += 1;
		if (this.coordinates != null)
			count += 1;
		if (this.countryCodes != null)
			count += this.countryCodes.size();
		if (this.countryNames != null)
			count += this.countryNames.size();
		if (this.instituteAddresses != null)
			count += this.instituteAddresses.size();
		if (this.instituteNames != null)
			count += this.instituteNames.size();
		if (this.locationTypes != null)
			count += this.locationTypes.size();
		return count;
	}
}
