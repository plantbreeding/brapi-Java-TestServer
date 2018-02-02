package org.brapi.test.BrAPITestServer.model.rest.vendor;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;

import org.brapi.test.BrAPITestServer.model.entity.BaseEntity;

public class VendorSpec {
	private String vendorName;
	private String vendorDescription;
	private String vendorURL;
	private String contactName;
	private String vendorEmail;
	private String vendorPhone;
	private String vendorAddress;
	private String vendorCity;
	private String vendorCountry;
	private String additionalInfo;
	private List<VendorSpecPlatform> platforms;
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorDescription() {
		return vendorDescription;
	}
	public void setVendorDescription(String vendorDescription) {
		this.vendorDescription = vendorDescription;
	}
	public String getVendorURL() {
		return vendorURL;
	}
	public void setVendorURL(String vendorURL) {
		this.vendorURL = vendorURL;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getVendorEmail() {
		return vendorEmail;
	}
	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}
	public String getVendorPhone() {
		return vendorPhone;
	}
	public void setVendorPhone(String vendorPhone) {
		this.vendorPhone = vendorPhone;
	}
	public String getVendorAddress() {
		return vendorAddress;
	}
	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}
	public String getVendorCity() {
		return vendorCity;
	}
	public void setVendorCity(String vendorCity) {
		this.vendorCity = vendorCity;
	}
	public String getVendorCountry() {
		return vendorCountry;
	}
	public void setVendorCountry(String vendorCountry) {
		this.vendorCountry = vendorCountry;
	}
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	public List<VendorSpecPlatform> getPlatforms() {
		return platforms;
	}
	public void setPlatforms(List<VendorSpecPlatform> platforms) {
		this.platforms = platforms;
	}

}
