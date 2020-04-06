package org.brapi.test.BrAPITestServer.model.entity.geno.vendor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

@Entity
@Table(name="vendor_spec_status")
public class VendorSpecStatusEntity extends BrAPIBaseEntity {
	@Column
	private String vendorSpecPlatformDbId;
	@Column
    private String statusName;
	@Column
    private String statusDescription;
	public String getVendorSpecPlatformDbId() {
		return vendorSpecPlatformDbId;
	}
	public void setVendorSpecPlatformDbId(String vendorSpecPlatformDbId) {
		this.vendorSpecPlatformDbId = vendorSpecPlatformDbId;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getStatusDescription() {
		return statusDescription;
	}
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
}
