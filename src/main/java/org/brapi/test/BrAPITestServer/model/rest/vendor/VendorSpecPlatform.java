package org.brapi.test.BrAPITestServer.model.rest.vendor;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.brapi.test.BrAPITestServer.model.entity.BaseEntity;

public class VendorSpecPlatform {
    private String platformName;
    private String platformDescription;
    private String platformURL;
    private String contactName;
    private String contactEmail;
    private String contactPhone;
    private String shippingAddress;
    private List<VendorSpecDeliverable> deliverables;
    private VendorSpecStandardRequirement standardRequirements;
    private String specificRequirements;
    private List<VendorSpecStatus> statuses;
    private VendorSpecReferenceSystem taxonomyIdSystem;
    private VendorSpecReferenceSystem tissueIdSystem;
	public String getPlatformName() {
		return platformName;
	}
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
	public String getPlatformDescription() {
		return platformDescription;
	}
	public void setPlatformDescription(String platformDescription) {
		this.platformDescription = platformDescription;
	}
	public String getPlatformURL() {
		return platformURL;
	}
	public void setPlatformURL(String platformURL) {
		this.platformURL = platformURL;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public List<VendorSpecDeliverable> getDeliverables() {
		return deliverables;
	}
	public void setDeliverables(List<VendorSpecDeliverable> deliverables) {
		this.deliverables = deliverables;
	}
	public VendorSpecStandardRequirement getStandardRequirements() {
		return standardRequirements;
	}
	public void setStandardRequirements(VendorSpecStandardRequirement standardRequirements) {
		this.standardRequirements = standardRequirements;
	}
	public String getSpecificRequirements() {
		return specificRequirements;
	}
	public void setSpecificRequirements(String specificRequirements) {
		this.specificRequirements = specificRequirements;
	}
	public List<VendorSpecStatus> getStatuses() {
		return statuses;
	}
	public void setStatuses(List<VendorSpecStatus> statuses) {
		this.statuses = statuses;
	}
	public VendorSpecReferenceSystem getTaxonomyIdSystem() {
		return taxonomyIdSystem;
	}
	public void setTaxonomyIdSystem(VendorSpecReferenceSystem taxonomyIdSystem) {
		this.taxonomyIdSystem = taxonomyIdSystem;
	}
	public VendorSpecReferenceSystem getTissueIdSystem() {
		return tissueIdSystem;
	}
	public void setTissueIdSystem(VendorSpecReferenceSystem tissueIdSystem) {
		this.tissueIdSystem = tissueIdSystem;
	}
}
