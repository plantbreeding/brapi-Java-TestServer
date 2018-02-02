package org.brapi.test.BrAPITestServer.model.entity.vendor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BaseEntity;

@Entity
@Table(name="vendor_spec_well_position")
public class VendorSpecWellPositionEntity extends BaseEntity {
	@Column
	private String vendorSpecStandardRequirementDbId;
	@Column
	private String position;
	public String getVendorSpecStandardRequirementDbId() {
		return vendorSpecStandardRequirementDbId;
	}
	public void setVendorSpecStandardRequirementDbId(String vendorSpecStandardRequirementDbId) {
		this.vendorSpecStandardRequirementDbId = vendorSpecStandardRequirementDbId;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
}
