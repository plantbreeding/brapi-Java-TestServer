package org.brapi.test.BrAPITestServer.model.entity.vendor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

@Entity
@Table(name="vendor_spec_input_format")
public class VendorSpecInputFormatEntity extends BrAPIBaseEntity {
	@Column
	private String vendorSpecStandardRequirementDbId;
	@Column
	private String inputFormat;
	public String getVendorSpecStandardRequirementDbId() {
		return vendorSpecStandardRequirementDbId;
	}
	public void setVendorSpecStandardRequirementDbId(String vendorSpecStandardRequirementDbId) {
		this.vendorSpecStandardRequirementDbId = vendorSpecStandardRequirementDbId;
	}
	public String getInputFormat() {
		return inputFormat;
	}
	public void setInputFormat(String inputFormat) {
		this.inputFormat = inputFormat;
	}
}
