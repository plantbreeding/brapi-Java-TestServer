package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.VendorSpecificationPlatform;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * VendorSpecification
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-01T19:24:22.162Z")

public class VendorSpecification   {
  @JsonProperty("additionalInfo")
  @Valid
  private Map<String, String> additionalInfo = null;

  @JsonProperty("contactName")
  private String contactName = null;

  @JsonProperty("platforms")
  @Valid
  private List<VendorSpecificationPlatform> platforms = null;

  @JsonProperty("vendorAddress")
  private String vendorAddress = null;

  @JsonProperty("vendorCity")
  private String vendorCity = null;

  @JsonProperty("vendorCountry")
  private String vendorCountry = null;

  @JsonProperty("vendorDescription")
  private String vendorDescription = null;

  @JsonProperty("vendorEmail")
  private String vendorEmail = null;

  @JsonProperty("vendorName")
  private String vendorName = null;

  @JsonProperty("vendorPhone")
  private String vendorPhone = null;

  @JsonProperty("vendorURL")
  private String vendorURL = null;

  public VendorSpecification additionalInfo(Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  public VendorSpecification putAdditionalInfoItem(String key, String additionalInfoItem) {
    if (this.additionalInfo == null) {
      this.additionalInfo = new HashMap<String, String>();
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

  public VendorSpecification contactName(String contactName) {
    this.contactName = contactName;
    return this;
  }

   /**
   * The name or identifier of the primary vendor contact
   * @return contactName
  **/
  @ApiModelProperty(value = "The name or identifier of the primary vendor contact")


  public String getContactName() {
    return contactName;
  }

  public void setContactName(String contactName) {
    this.contactName = contactName;
  }

  public VendorSpecification platforms(List<VendorSpecificationPlatform> platforms) {
    this.platforms = platforms;
    return this;
  }

  public VendorSpecification addPlatformsItem(VendorSpecificationPlatform platformsItem) {
    if (this.platforms == null) {
      this.platforms = new ArrayList<VendorSpecificationPlatform>();
    }
    this.platforms.add(platformsItem);
    return this;
  }

   /**
   * List of platform specifications available at the vendor
   * @return platforms
  **/
  @ApiModelProperty(value = "List of platform specifications available at the vendor")

  @Valid

  public List<VendorSpecificationPlatform> getPlatforms() {
    return platforms;
  }

  public void setPlatforms(List<VendorSpecificationPlatform> platforms) {
    this.platforms = platforms;
  }

  public VendorSpecification vendorAddress(String vendorAddress) {
    this.vendorAddress = vendorAddress;
    return this;
  }

   /**
   * The street address of the vendor
   * @return vendorAddress
  **/
  @ApiModelProperty(value = "The street address of the vendor")


  public String getVendorAddress() {
    return vendorAddress;
  }

  public void setVendorAddress(String vendorAddress) {
    this.vendorAddress = vendorAddress;
  }

  public VendorSpecification vendorCity(String vendorCity) {
    this.vendorCity = vendorCity;
    return this;
  }

   /**
   * The name of the city where the vendor is located
   * @return vendorCity
  **/
  @ApiModelProperty(value = "The name of the city where the vendor is located")


  public String getVendorCity() {
    return vendorCity;
  }

  public void setVendorCity(String vendorCity) {
    this.vendorCity = vendorCity;
  }

  public VendorSpecification vendorCountry(String vendorCountry) {
    this.vendorCountry = vendorCountry;
    return this;
  }

   /**
   * The name of the country where the vendor is located
   * @return vendorCountry
  **/
  @ApiModelProperty(value = "The name of the country where the vendor is located")


  public String getVendorCountry() {
    return vendorCountry;
  }

  public void setVendorCountry(String vendorCountry) {
    this.vendorCountry = vendorCountry;
  }

  public VendorSpecification vendorDescription(String vendorDescription) {
    this.vendorDescription = vendorDescription;
    return this;
  }

   /**
   * A description of the vendor
   * @return vendorDescription
  **/
  @ApiModelProperty(value = "A description of the vendor")


  public String getVendorDescription() {
    return vendorDescription;
  }

  public void setVendorDescription(String vendorDescription) {
    this.vendorDescription = vendorDescription;
  }

  public VendorSpecification vendorEmail(String vendorEmail) {
    this.vendorEmail = vendorEmail;
    return this;
  }

   /**
   * The primary email address used to contact the vendor
   * @return vendorEmail
  **/
  @ApiModelProperty(value = "The primary email address used to contact the vendor")


  public String getVendorEmail() {
    return vendorEmail;
  }

  public void setVendorEmail(String vendorEmail) {
    this.vendorEmail = vendorEmail;
  }

  public VendorSpecification vendorName(String vendorName) {
    this.vendorName = vendorName;
    return this;
  }

   /**
   * The human readable name of the vendor
   * @return vendorName
  **/
  @ApiModelProperty(value = "The human readable name of the vendor")


  public String getVendorName() {
    return vendorName;
  }

  public void setVendorName(String vendorName) {
    this.vendorName = vendorName;
  }

  public VendorSpecification vendorPhone(String vendorPhone) {
    this.vendorPhone = vendorPhone;
    return this;
  }

   /**
   * The primary phone number used to contact the vendor
   * @return vendorPhone
  **/
  @ApiModelProperty(value = "The primary phone number used to contact the vendor")


  public String getVendorPhone() {
    return vendorPhone;
  }

  public void setVendorPhone(String vendorPhone) {
    this.vendorPhone = vendorPhone;
  }

  public VendorSpecification vendorURL(String vendorURL) {
    this.vendorURL = vendorURL;
    return this;
  }

   /**
   * The primary URL for the vendor
   * @return vendorURL
  **/
  @ApiModelProperty(value = "The primary URL for the vendor")


  public String getVendorURL() {
    return vendorURL;
  }

  public void setVendorURL(String vendorURL) {
    this.vendorURL = vendorURL;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VendorSpecification vendorSpecification = (VendorSpecification) o;
    return Objects.equals(this.additionalInfo, vendorSpecification.additionalInfo) &&
        Objects.equals(this.contactName, vendorSpecification.contactName) &&
        Objects.equals(this.platforms, vendorSpecification.platforms) &&
        Objects.equals(this.vendorAddress, vendorSpecification.vendorAddress) &&
        Objects.equals(this.vendorCity, vendorSpecification.vendorCity) &&
        Objects.equals(this.vendorCountry, vendorSpecification.vendorCountry) &&
        Objects.equals(this.vendorDescription, vendorSpecification.vendorDescription) &&
        Objects.equals(this.vendorEmail, vendorSpecification.vendorEmail) &&
        Objects.equals(this.vendorName, vendorSpecification.vendorName) &&
        Objects.equals(this.vendorPhone, vendorSpecification.vendorPhone) &&
        Objects.equals(this.vendorURL, vendorSpecification.vendorURL);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalInfo, contactName, platforms, vendorAddress, vendorCity, vendorCountry, vendorDescription, vendorEmail, vendorName, vendorPhone, vendorURL);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorSpecification {\n");
    
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    contactName: ").append(toIndentedString(contactName)).append("\n");
    sb.append("    platforms: ").append(toIndentedString(platforms)).append("\n");
    sb.append("    vendorAddress: ").append(toIndentedString(vendorAddress)).append("\n");
    sb.append("    vendorCity: ").append(toIndentedString(vendorCity)).append("\n");
    sb.append("    vendorCountry: ").append(toIndentedString(vendorCountry)).append("\n");
    sb.append("    vendorDescription: ").append(toIndentedString(vendorDescription)).append("\n");
    sb.append("    vendorEmail: ").append(toIndentedString(vendorEmail)).append("\n");
    sb.append("    vendorName: ").append(toIndentedString(vendorName)).append("\n");
    sb.append("    vendorPhone: ").append(toIndentedString(vendorPhone)).append("\n");
    sb.append("    vendorURL: ").append(toIndentedString(vendorURL)).append("\n");
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

