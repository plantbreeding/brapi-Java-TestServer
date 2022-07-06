package io.swagger.model.core;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.GeoJSONSearchArea;
import io.swagger.model.SearchRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LocationSearchRequest extends SearchRequest {

	@JsonProperty("commonCropNames")
	private List<String> commonCropNames = null;

	@JsonProperty("parentLocationDbIds")
	private List<String> parentLocationDbIds = null;

	@JsonProperty("parentLocationNames")
	private List<String> parentLocationNames = null;

	@JsonProperty("programDbIds")
	private List<String> programDbIds = null;

	@JsonProperty("programNames")
	private List<String> programNames = null;

	@JsonProperty("locationDbIds")
	private List<String> locationDbIds = null;

	@JsonProperty("locationNames")
	private List<String> locationNames = null;

	@JsonProperty("abbreviations")
	private List<String> abbreviations = null;

	@JsonProperty("altitudeMax")
	private BigDecimal altitudeMax = null;

	@JsonProperty("altitudeMin")
	private BigDecimal altitudeMin = null;

	@JsonProperty("coordinates")
	private GeoJSONSearchArea coordinates = null;

	@JsonProperty("countryCodes")
	private List<String> countryCodes = null;

	@JsonProperty("countryNames")
	private List<String> countryNames = null;

	@JsonProperty("instituteAddresses")
	private List<String> instituteAddresses = null;

	@JsonProperty("instituteNames")
	private List<String> instituteNames = null;

	@JsonProperty("locationTypes")
	private List<String> locationTypes = null;

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

	public List<String> getLocationTypes() {
		return locationTypes;
	}

	public void setLocationTypes(List<String> locationTypes) {
		this.locationTypes = locationTypes;
	}

	public LocationSearchRequest commonCropNames(List<String> commonCropNames) {
		this.commonCropNames = commonCropNames;
		return this;
	}

	public LocationSearchRequest addCommonCropNamesItem(String commonCropNamesItem) {
		if (this.commonCropNames == null) {
			this.commonCropNames = new ArrayList<String>();
		}
		this.commonCropNames.add(commonCropNamesItem);
		return this;
	}

	public List<String> getCommonCropNames() {
		return commonCropNames;
	}

	public void setCommonCropNames(List<String> commonCropNames) {
		this.commonCropNames = commonCropNames;
	}

	public LocationSearchRequest parentLocationDbIds(List<String> parentLocationDbIds) {
		this.parentLocationDbIds = parentLocationDbIds;
		return this;
	}

	public LocationSearchRequest addParentLocationDbIdsItem(String parentLocationDbIdsItem) {
		if (this.parentLocationDbIds == null) {
			this.parentLocationDbIds = new ArrayList<String>();
		}
		this.parentLocationDbIds.add(parentLocationDbIdsItem);
		return this;
	}

	public List<String> getParentLocationDbIds() {
		return parentLocationDbIds;
	}

	public void setParentLocationDbIds(List<String> parentLocationDbIds) {
		this.parentLocationDbIds = parentLocationDbIds;
	}

	public LocationSearchRequest parentLocationNames(List<String> parentLocationNames) {
		this.parentLocationNames = parentLocationNames;
		return this;
	}

	public LocationSearchRequest addParentLocationNamesItem(String parentLocationNamesItem) {
		if (this.parentLocationNames == null) {
			this.parentLocationNames = new ArrayList<String>();
		}
		this.parentLocationNames.add(parentLocationNamesItem);
		return this;
	}

	public List<String> getParentLocationNames() {
		return parentLocationNames;
	}

	public void setParentLocationNames(List<String> parentLocationNames) {
		this.parentLocationNames = parentLocationNames;
	}

	public LocationSearchRequest programDbIds(List<String> programDbIds) {
		this.programDbIds = programDbIds;
		return this;
	}

	public LocationSearchRequest addProgramDbIdsItem(String programDbIdsItem) {
		if (this.programDbIds == null) {
			this.programDbIds = new ArrayList<String>();
		}
		this.programDbIds.add(programDbIdsItem);
		return this;
	}

	public List<String> getProgramDbIds() {
		return programDbIds;
	}

	public void setProgramDbIds(List<String> programDbIds) {
		this.programDbIds = programDbIds;
	}

	public LocationSearchRequest programNames(List<String> programNames) {
		this.programNames = programNames;
		return this;
	}

	public LocationSearchRequest addProgramNamesItem(String programNamesItem) {
		if (this.programNames == null) {
			this.programNames = new ArrayList<String>();
		}
		this.programNames.add(programNamesItem);
		return this;
	}

	public List<String> getProgramNames() {
		return programNames;
	}

	public void setProgramNames(List<String> programNames) {
		this.programNames = programNames;
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
		return Objects.equals(this.abbreviations, locationSearchRequest.abbreviations)
				&& Objects.equals(this.altitudeMax, locationSearchRequest.altitudeMax)
				&& Objects.equals(this.altitudeMin, locationSearchRequest.altitudeMin)
				&& Objects.equals(this.commonCropNames, locationSearchRequest.commonCropNames)
				&& Objects.equals(this.coordinates, locationSearchRequest.coordinates)
				&& Objects.equals(this.countryCodes, locationSearchRequest.countryCodes)
				&& Objects.equals(this.countryNames, locationSearchRequest.countryNames)
				&& Objects.equals(this.externalReferenceIds, locationSearchRequest.externalReferenceIds)
				&& Objects.equals(this.externalReferenceSources, locationSearchRequest.externalReferenceSources)
				&& Objects.equals(this.instituteAddresses, locationSearchRequest.instituteAddresses)
				&& Objects.equals(this.instituteNames, locationSearchRequest.instituteNames)
				&& Objects.equals(this.locationDbIds, locationSearchRequest.locationDbIds)
				&& Objects.equals(this.locationNames, locationSearchRequest.locationNames)
				&& Objects.equals(this.locationTypes, locationSearchRequest.locationTypes)
				&& Objects.equals(this.page, locationSearchRequest.page)
				&& Objects.equals(this.pageSize, locationSearchRequest.pageSize)
				&& Objects.equals(this.parentLocationDbIds, locationSearchRequest.parentLocationDbIds)
				&& Objects.equals(this.parentLocationNames, locationSearchRequest.parentLocationNames)
				&& Objects.equals(this.programDbIds, locationSearchRequest.programDbIds)
				&& Objects.equals(this.programNames, locationSearchRequest.programNames);
	}

	@Override
	public int hashCode() {
		return Objects.hash(abbreviations, altitudeMax, altitudeMin, commonCropNames, coordinates, countryCodes,
				countryNames, externalReferenceIds, externalReferenceSources, instituteAddresses, instituteNames,
				locationDbIds, locationNames, locationTypes, page, pageSize, parentLocationDbIds, parentLocationNames,
				programDbIds, programNames, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class LocationSearchRequest {\n");
		sb.append("    abbreviations: ").append(toIndentedString(abbreviations)).append("\n");
		sb.append("    altitudeMax: ").append(toIndentedString(altitudeMax)).append("\n");
		sb.append("    altitudeMin: ").append(toIndentedString(altitudeMin)).append("\n");
		sb.append("    commonCropNames: ").append(toIndentedString(commonCropNames)).append("\n");
		sb.append("    coordinates: ").append(toIndentedString(coordinates)).append("\n");
		sb.append("    countryCodes: ").append(toIndentedString(countryCodes)).append("\n");
		sb.append("    countryNames: ").append(toIndentedString(countryNames)).append("\n");
		sb.append("    externalReferenceIds: ").append(toIndentedString(externalReferenceIds)).append("\n");
		sb.append("    externalReferenceSources: ").append(toIndentedString(externalReferenceSources)).append("\n");
		sb.append("    instituteAddresses: ").append(toIndentedString(instituteAddresses)).append("\n");
		sb.append("    instituteNames: ").append(toIndentedString(instituteNames)).append("\n");
		sb.append("    locationDbIds: ").append(toIndentedString(locationDbIds)).append("\n");
		sb.append("    locationNames: ").append(toIndentedString(locationNames)).append("\n");
		sb.append("    locationTypes: ").append(toIndentedString(locationTypes)).append("\n");
		sb.append("    page: ").append(toIndentedString(page)).append("\n");
		sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
		sb.append("    parentLocationDbIds: ").append(toIndentedString(parentLocationDbIds)).append("\n");
		sb.append("    parentLocationNames: ").append(toIndentedString(parentLocationNames)).append("\n");
		sb.append("    programDbIds: ").append(toIndentedString(programDbIds)).append("\n");
		sb.append("    programNames: ").append(toIndentedString(programNames)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	@Override
	public Integer getTotalParameterCount() {
		Integer count = 0;
		if (this.externalReferenceIds != null)
			count += this.externalReferenceIds.size();
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
