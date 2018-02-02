package org.brapi.test.BrAPITestServer.model.rest.vendor;

import org.brapi.test.BrAPITestServer.model.entity.BaseEntity;

public class VendorSpecStatus  {
    private String statusName;
    private String statusDescription;
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
