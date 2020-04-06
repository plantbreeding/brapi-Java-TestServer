package org.brapi.test.BrAPITestServer.model.entity.geno.vendor;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

@Entity
@Table(name="vendor_spec")
public class VendorSpecEntity extends BrAPIBaseEntity {
	@Column
	private String vendorName;
	@Column
	private String vendorDescription;
	@Column
	private String vendorURL;
	@Column
	private String contactName;
	@Column
	private String vendorEmail;
	@Column
	private String vendorPhone;
	@Column
	private String vendorAddress;
	@Column
	private String vendorCity;
	@Column
	private String vendorCountry;
	@OneToMany(mappedBy="vendorSpecDbId")
	private List<VendorSpecPlatformEntity> platforms;
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
	public List<VendorSpecPlatformEntity> getPlatforms() {
		return platforms;
	}
	public void setPlatforms(List<VendorSpecPlatformEntity> platforms) {
		this.platforms = platforms;
	}

}
