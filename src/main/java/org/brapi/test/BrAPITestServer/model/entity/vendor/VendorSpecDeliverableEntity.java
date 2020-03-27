package org.brapi.test.BrAPITestServer.model.entity.vendor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

@Entity
@Table(name="vendor_spec_deliverable")
public class VendorSpecDeliverableEntity extends BrAPIBaseEntity {
	@Column
	private String vendorSpecPlatformDbId;
	@Column
    private String name;
	@Column
    private String description;
	@Column
    private String format;
	public String getVendorSpecPlatformDbId() {
		return vendorSpecPlatformDbId;
	}
	public void setVendorSpecPlatformDbId(String vendorSpecPlatformDbId) {
		this.vendorSpecPlatformDbId = vendorSpecPlatformDbId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
}
