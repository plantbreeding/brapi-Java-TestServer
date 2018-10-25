package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Location
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-10-25T15:57:44.669-04:00[America/New_York]")

public class Location   {
  @JsonProperty("abbreviation")
  private String abbreviation = null;

  @JsonProperty("abreviation")
  private String abreviation = null;

  @JsonProperty("additionalInfo")
  @Valid
  private Map<String, String> additionalInfo = null;

  @JsonProperty("altitude")
  private BigDecimal altitude = null;

  @JsonProperty("countryCode")
  private String countryCode = null;

  @JsonProperty("countryName")
  private String countryName = null;

  @JsonProperty("documentationURL")
  private String documentationURL = null;

  @JsonProperty("instituteAddress")
  private String instituteAddress = null;

  @JsonProperty("instituteAdress")
  private String instituteAdress = null;

  @JsonProperty("instituteName")
  private String instituteName = null;

  @JsonProperty("latitude")
  private BigDecimal latitude = null;

  @JsonProperty("locationDbId")
  private String locationDbId = null;

  @JsonProperty("locationName")
  private String locationName = null;

  @JsonProperty("locationType")
  private String locationType = null;

  @JsonProperty("longitude")
  private BigDecimal longitude = null;

  @JsonProperty("name")
  private String name = null;

  public Location abbreviation(String abbreviation) {
    this.abbreviation = abbreviation;
    return this;
  }

  /**
   * An abbreviation which represents this location
   * @return abbreviation
  **/
  @ApiModelProperty(value = "An abbreviation which represents this location")


  public String getAbbreviation() {
    return abbreviation;
  }

  public void setAbbreviation(String abbreviation) {
    this.abbreviation = abbreviation;
  }

  public Location abreviation(String abreviation) {
    this.abreviation = abreviation;
    return this;
  }

  /**
   * Deprecated  Use abbreviation 
   * @return abreviation
  **/
  @ApiModelProperty(value = "Deprecated  Use abbreviation ")


  public String getAbreviation() {
    return abreviation;
  }

  public void setAbreviation(String abreviation) {
    this.abreviation = abreviation;
  }

  public Location additionalInfo(Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  public Location putAdditionalInfoItem(String key, String additionalInfoItem) {
    if (this.additionalInfo == null) {
      this.additionalInfo = null;
    }
    this.additionalInfo.put(key, additionalInfoItem);
    return this;
  }

  /**
   * Additional arbitrary info
   * @return additionalInfo
  **/
  @ApiModelProperty(value = "Additional arbitrary info")


  public Map<String, String> getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public Location altitude(BigDecimal altitude) {
    this.altitude = altitude;
    return this;
  }

  /**
   * The altitude of this location
   * @return altitude
  **/
  @ApiModelProperty(value = "The altitude of this location")

  @Valid

  public BigDecimal getAltitude() {
    return altitude;
  }

  public void setAltitude(BigDecimal altitude) {
    this.altitude = altitude;
  }

  public Location countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  /**
   * [ISO_3166-1_alpha-3](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-3) spec
   * @return countryCode
  **/
  @ApiModelProperty(value = "[ISO_3166-1_alpha-3](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-3) spec")


  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public Location countryName(String countryName) {
    this.countryName = countryName;
    return this;
  }

  /**
   * The full name of the country where this location is
   * @return countryName
  **/
  @ApiModelProperty(value = "The full name of the country where this location is")


  public String getCountryName() {
    return countryName;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }

  public Location documentationURL(String documentationURL) {
    this.documentationURL = documentationURL;
    return this;
  }

  /**
   * A URL to the human readable documentation of this object
   * @return documentationURL
  **/
  @ApiModelProperty(value = "A URL to the human readable documentation of this object")


  public String getDocumentationURL() {
    return documentationURL;
  }

  public void setDocumentationURL(String documentationURL) {
    this.documentationURL = documentationURL;
  }

  public Location instituteAddress(String instituteAddress) {
    this.instituteAddress = instituteAddress;
    return this;
  }

  /**
   * The street address of the institute representing this location
   * @return instituteAddress
  **/
  @ApiModelProperty(value = "The street address of the institute representing this location")


  public String getInstituteAddress() {
    return instituteAddress;
  }

  public void setInstituteAddress(String instituteAddress) {
    this.instituteAddress = instituteAddress;
  }

  public Location instituteAdress(String instituteAdress) {
    this.instituteAdress = instituteAdress;
    return this;
  }

  /**
   * Deprecated  Use instituteAddress 
   * @return instituteAdress
  **/
  @ApiModelProperty(value = "Deprecated  Use instituteAddress ")


  public String getInstituteAdress() {
    return instituteAdress;
  }

  public void setInstituteAdress(String instituteAdress) {
    this.instituteAdress = instituteAdress;
  }

  public Location instituteName(String instituteName) {
    this.instituteName = instituteName;
    return this;
  }

  /**
   * each institute/laboratory can have several experimental field
   * @return instituteName
  **/
  @ApiModelProperty(value = "each institute/laboratory can have several experimental field")


  public String getInstituteName() {
    return instituteName;
  }

  public void setInstituteName(String instituteName) {
    this.instituteName = instituteName;
  }

  public Location latitude(BigDecimal latitude) {
    this.latitude = latitude;
    return this;
  }

  /**
   * The latitude of this location
   * @return latitude
  **/
  @ApiModelProperty(value = "The latitude of this location")

  @Valid

  public BigDecimal getLatitude() {
    return latitude;
  }

  public void setLatitude(BigDecimal latitude) {
    this.latitude = latitude;
  }

  public Location locationDbId(String locationDbId) {
    this.locationDbId = locationDbId;
    return this;
  }

  /**
   * string identifier
   * @return locationDbId
  **/
  @ApiModelProperty(value = "string identifier")


  public String getLocationDbId() {
    return locationDbId;
  }

  public void setLocationDbId(String locationDbId) {
    this.locationDbId = locationDbId;
  }

  public Location locationName(String locationName) {
    this.locationName = locationName;
    return this;
  }

  /**
   * A human readable name for this location
   * @return locationName
  **/
  @ApiModelProperty(value = "A human readable name for this location")


  public String getLocationName() {
    return locationName;
  }

  public void setLocationName(String locationName) {
    this.locationName = locationName;
  }

  public Location locationType(String locationType) {
    this.locationType = locationType;
    return this;
  }

  /**
   * The type of location this represents (ex. Breeding Location, Storage Location, etc)
   * @return locationType
  **/
  @ApiModelProperty(value = "The type of location this represents (ex. Breeding Location, Storage Location, etc)")


  public String getLocationType() {
    return locationType;
  }

  public void setLocationType(String locationType) {
    this.locationType = locationType;
  }

  public Location longitude(BigDecimal longitude) {
    this.longitude = longitude;
    return this;
  }

  /**
   * the longitude of this location
   * @return longitude
  **/
  @ApiModelProperty(value = "the longitude of this location")

  @Valid

  public BigDecimal getLongitude() {
    return longitude;
  }

  public void setLongitude(BigDecimal longitude) {
    this.longitude = longitude;
  }

  public Location name(String name) {
    this.name = name;
    return this;
  }

  /**
   * DEPRECATED in v1.3 - Use \"locationName\"
   * @return name
  **/
  @ApiModelProperty(value = "DEPRECATED in v1.3 - Use \"locationName\"")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Location location = (Location) o;
    return Objects.equals(this.abbreviation, location.abbreviation) &&
        Objects.equals(this.abreviation, location.abreviation) &&
        Objects.equals(this.additionalInfo, location.additionalInfo) &&
        Objects.equals(this.altitude, location.altitude) &&
        Objects.equals(this.countryCode, location.countryCode) &&
        Objects.equals(this.countryName, location.countryName) &&
        Objects.equals(this.documentationURL, location.documentationURL) &&
        Objects.equals(this.instituteAddress, location.instituteAddress) &&
        Objects.equals(this.instituteAdress, location.instituteAdress) &&
        Objects.equals(this.instituteName, location.instituteName) &&
        Objects.equals(this.latitude, location.latitude) &&
        Objects.equals(this.locationDbId, location.locationDbId) &&
        Objects.equals(this.locationName, location.locationName) &&
        Objects.equals(this.locationType, location.locationType) &&
        Objects.equals(this.longitude, location.longitude) &&
        Objects.equals(this.name, location.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(abbreviation, abreviation, additionalInfo, altitude, countryCode, countryName, documentationURL, instituteAddress, instituteAdress, instituteName, latitude, locationDbId, locationName, locationType, longitude, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Location {\n");
    
    sb.append("    abbreviation: ").append(toIndentedString(abbreviation)).append("\n");
    sb.append("    abreviation: ").append(toIndentedString(abreviation)).append("\n");
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    altitude: ").append(toIndentedString(altitude)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    countryName: ").append(toIndentedString(countryName)).append("\n");
    sb.append("    documentationURL: ").append(toIndentedString(documentationURL)).append("\n");
    sb.append("    instituteAddress: ").append(toIndentedString(instituteAddress)).append("\n");
    sb.append("    instituteAdress: ").append(toIndentedString(instituteAdress)).append("\n");
    sb.append("    instituteName: ").append(toIndentedString(instituteName)).append("\n");
    sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
    sb.append("    locationDbId: ").append(toIndentedString(locationDbId)).append("\n");
    sb.append("    locationName: ").append(toIndentedString(locationName)).append("\n");
    sb.append("    locationType: ").append(toIndentedString(locationType)).append("\n");
    sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

