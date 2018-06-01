package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.VendorSpecificationPlatformDeliverables;
import io.swagger.model.VendorSpecificationPlatformStatuses;
import io.swagger.model.VendorSpecificationReferenceSystem;
import io.swagger.model.VendorSpecificationStandardRequirement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * VendorSpecificationPlatform
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-01T19:24:22.162Z")

public class VendorSpecificationPlatform   {
  @JsonProperty("contactEmail")
  private String contactEmail = null;

  @JsonProperty("contactName")
  private String contactName = null;

  @JsonProperty("contactPhone")
  private String contactPhone = null;

  @JsonProperty("deliverables")
  @Valid
  private List<VendorSpecificationPlatformDeliverables> deliverables = null;

  @JsonProperty("platformDescription")
  private String platformDescription = null;

  @JsonProperty("platformName")
  private String platformName = null;

  @JsonProperty("platformURL")
  private String platformURL = null;

  @JsonProperty("shippingAddress")
  private String shippingAddress = null;

  @JsonProperty("specificRequirements")
  private Object specificRequirements = null;

  @JsonProperty("standardRequirements")
  private VendorSpecificationStandardRequirement standardRequirements = null;

  @JsonProperty("statuses")
  @Valid
  private List<VendorSpecificationPlatformStatuses> statuses = null;

  @JsonProperty("taxonomyIdSystem")
  private VendorSpecificationReferenceSystem taxonomyIdSystem = null;

  @JsonProperty("tissueIdSystem")
  private VendorSpecificationReferenceSystem tissueIdSystem = null;

  public VendorSpecificationPlatform contactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
    return this;
  }

   /**
   * The primary email address to contact a particular vendor platform
   * @return contactEmail
  **/
  @ApiModelProperty(value = "The primary email address to contact a particular vendor platform")


  public String getContactEmail() {
    return contactEmail;
  }

  public void setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
  }

  public VendorSpecificationPlatform contactName(String contactName) {
    this.contactName = contactName;
    return this;
  }

   /**
   * The name or identifier of the primary vendor platfrom contact
   * @return contactName
  **/
  @ApiModelProperty(value = "The name or identifier of the primary vendor platfrom contact")


  public String getContactName() {
    return contactName;
  }

  public void setContactName(String contactName) {
    this.contactName = contactName;
  }

  public VendorSpecificationPlatform contactPhone(String contactPhone) {
    this.contactPhone = contactPhone;
    return this;
  }

   /**
   * The phone number used to contact the vendor about a particular platform
   * @return contactPhone
  **/
  @ApiModelProperty(value = "The phone number used to contact the vendor about a particular platform")


  public String getContactPhone() {
    return contactPhone;
  }

  public void setContactPhone(String contactPhone) {
    this.contactPhone = contactPhone;
  }

  public VendorSpecificationPlatform deliverables(List<VendorSpecificationPlatformDeliverables> deliverables) {
    this.deliverables = deliverables;
    return this;
  }

  public VendorSpecificationPlatform addDeliverablesItem(VendorSpecificationPlatformDeliverables deliverablesItem) {
    if (this.deliverables == null) {
      this.deliverables = new ArrayList<VendorSpecificationPlatformDeliverables>();
    }
    this.deliverables.add(deliverablesItem);
    return this;
  }

   /**
   * List of specific deliverables provided by the vendor platform
   * @return deliverables
  **/
  @ApiModelProperty(value = "List of specific deliverables provided by the vendor platform")

  @Valid

  public List<VendorSpecificationPlatformDeliverables> getDeliverables() {
    return deliverables;
  }

  public void setDeliverables(List<VendorSpecificationPlatformDeliverables> deliverables) {
    this.deliverables = deliverables;
  }

  public VendorSpecificationPlatform platformDescription(String platformDescription) {
    this.platformDescription = platformDescription;
    return this;
  }

   /**
   * Description of the vendor platform
   * @return platformDescription
  **/
  @ApiModelProperty(value = "Description of the vendor platform")


  public String getPlatformDescription() {
    return platformDescription;
  }

  public void setPlatformDescription(String platformDescription) {
    this.platformDescription = platformDescription;
  }

  public VendorSpecificationPlatform platformName(String platformName) {
    this.platformName = platformName;
    return this;
  }

   /**
   * The human readable name of a platform
   * @return platformName
  **/
  @ApiModelProperty(value = "The human readable name of a platform")


  public String getPlatformName() {
    return platformName;
  }

  public void setPlatformName(String platformName) {
    this.platformName = platformName;
  }

  public VendorSpecificationPlatform platformURL(String platformURL) {
    this.platformURL = platformURL;
    return this;
  }

   /**
   * The URL for a vendor platform
   * @return platformURL
  **/
  @ApiModelProperty(value = "The URL for a vendor platform")


  public String getPlatformURL() {
    return platformURL;
  }

  public void setPlatformURL(String platformURL) {
    this.platformURL = platformURL;
  }

  public VendorSpecificationPlatform shippingAddress(String shippingAddress) {
    this.shippingAddress = shippingAddress;
    return this;
  }

   /**
   * The street address for a vendor platform
   * @return shippingAddress
  **/
  @ApiModelProperty(value = "The street address for a vendor platform")


  public String getShippingAddress() {
    return shippingAddress;
  }

  public void setShippingAddress(String shippingAddress) {
    this.shippingAddress = shippingAddress;
  }

  public VendorSpecificationPlatform specificRequirements(Object specificRequirements) {
    this.specificRequirements = specificRequirements;
    return this;
  }

   /**
   * Additional arbitrary requirements for a particular platform
   * @return specificRequirements
  **/
  @ApiModelProperty(value = "Additional arbitrary requirements for a particular platform")


  public Object getSpecificRequirements() {
    return specificRequirements;
  }

  public void setSpecificRequirements(Object specificRequirements) {
    this.specificRequirements = specificRequirements;
  }

  public VendorSpecificationPlatform standardRequirements(VendorSpecificationStandardRequirement standardRequirements) {
    this.standardRequirements = standardRequirements;
    return this;
  }

   /**
   * Set of standard requirements for a vendor platform
   * @return standardRequirements
  **/
  @ApiModelProperty(value = "Set of standard requirements for a vendor platform")

  @Valid

  public VendorSpecificationStandardRequirement getStandardRequirements() {
    return standardRequirements;
  }

  public void setStandardRequirements(VendorSpecificationStandardRequirement standardRequirements) {
    this.standardRequirements = standardRequirements;
  }

  public VendorSpecificationPlatform statuses(List<VendorSpecificationPlatformStatuses> statuses) {
    this.statuses = statuses;
    return this;
  }

  public VendorSpecificationPlatform addStatusesItem(VendorSpecificationPlatformStatuses statusesItem) {
    if (this.statuses == null) {
      this.statuses = new ArrayList<VendorSpecificationPlatformStatuses>();
    }
    this.statuses.add(statusesItem);
    return this;
  }

   /**
   * List of possible status messages for a vendor platform
   * @return statuses
  **/
  @ApiModelProperty(value = "List of possible status messages for a vendor platform")

  @Valid

  public List<VendorSpecificationPlatformStatuses> getStatuses() {
    return statuses;
  }

  public void setStatuses(List<VendorSpecificationPlatformStatuses> statuses) {
    this.statuses = statuses;
  }

  public VendorSpecificationPlatform taxonomyIdSystem(VendorSpecificationReferenceSystem taxonomyIdSystem) {
    this.taxonomyIdSystem = taxonomyIdSystem;
    return this;
  }

   /**
   * Details about the systems used to track taxonomies
   * @return taxonomyIdSystem
  **/
  @ApiModelProperty(value = "Details about the systems used to track taxonomies")

  @Valid

  public VendorSpecificationReferenceSystem getTaxonomyIdSystem() {
    return taxonomyIdSystem;
  }

  public void setTaxonomyIdSystem(VendorSpecificationReferenceSystem taxonomyIdSystem) {
    this.taxonomyIdSystem = taxonomyIdSystem;
  }

  public VendorSpecificationPlatform tissueIdSystem(VendorSpecificationReferenceSystem tissueIdSystem) {
    this.tissueIdSystem = tissueIdSystem;
    return this;
  }

   /**
   * Details about the systems used to track sample IDs
   * @return tissueIdSystem
  **/
  @ApiModelProperty(value = "Details about the systems used to track sample IDs")

  @Valid

  public VendorSpecificationReferenceSystem getTissueIdSystem() {
    return tissueIdSystem;
  }

  public void setTissueIdSystem(VendorSpecificationReferenceSystem tissueIdSystem) {
    this.tissueIdSystem = tissueIdSystem;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VendorSpecificationPlatform vendorSpecificationPlatform = (VendorSpecificationPlatform) o;
    return Objects.equals(this.contactEmail, vendorSpecificationPlatform.contactEmail) &&
        Objects.equals(this.contactName, vendorSpecificationPlatform.contactName) &&
        Objects.equals(this.contactPhone, vendorSpecificationPlatform.contactPhone) &&
        Objects.equals(this.deliverables, vendorSpecificationPlatform.deliverables) &&
        Objects.equals(this.platformDescription, vendorSpecificationPlatform.platformDescription) &&
        Objects.equals(this.platformName, vendorSpecificationPlatform.platformName) &&
        Objects.equals(this.platformURL, vendorSpecificationPlatform.platformURL) &&
        Objects.equals(this.shippingAddress, vendorSpecificationPlatform.shippingAddress) &&
        Objects.equals(this.specificRequirements, vendorSpecificationPlatform.specificRequirements) &&
        Objects.equals(this.standardRequirements, vendorSpecificationPlatform.standardRequirements) &&
        Objects.equals(this.statuses, vendorSpecificationPlatform.statuses) &&
        Objects.equals(this.taxonomyIdSystem, vendorSpecificationPlatform.taxonomyIdSystem) &&
        Objects.equals(this.tissueIdSystem, vendorSpecificationPlatform.tissueIdSystem);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contactEmail, contactName, contactPhone, deliverables, platformDescription, platformName, platformURL, shippingAddress, specificRequirements, standardRequirements, statuses, taxonomyIdSystem, tissueIdSystem);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorSpecificationPlatform {\n");
    
    sb.append("    contactEmail: ").append(toIndentedString(contactEmail)).append("\n");
    sb.append("    contactName: ").append(toIndentedString(contactName)).append("\n");
    sb.append("    contactPhone: ").append(toIndentedString(contactPhone)).append("\n");
    sb.append("    deliverables: ").append(toIndentedString(deliverables)).append("\n");
    sb.append("    platformDescription: ").append(toIndentedString(platformDescription)).append("\n");
    sb.append("    platformName: ").append(toIndentedString(platformName)).append("\n");
    sb.append("    platformURL: ").append(toIndentedString(platformURL)).append("\n");
    sb.append("    shippingAddress: ").append(toIndentedString(shippingAddress)).append("\n");
    sb.append("    specificRequirements: ").append(toIndentedString(specificRequirements)).append("\n");
    sb.append("    standardRequirements: ").append(toIndentedString(standardRequirements)).append("\n");
    sb.append("    statuses: ").append(toIndentedString(statuses)).append("\n");
    sb.append("    taxonomyIdSystem: ").append(toIndentedString(taxonomyIdSystem)).append("\n");
    sb.append("    tissueIdSystem: ").append(toIndentedString(tissueIdSystem)).append("\n");
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

