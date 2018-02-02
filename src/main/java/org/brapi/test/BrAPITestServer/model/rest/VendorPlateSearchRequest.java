package org.brapi.test.BrAPITestServer.model.rest;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericRequest;

public class VendorPlateSearchRequest extends GenericRequest {
	private List<String> vendorProjectDbIds;
	private List<String> vendorPlateDbIds;
	private List<String> clientPlateDbIds;
	private boolean sampleInfo;
	
	public List<String> getVendorProjectDbIds() {
		return vendorProjectDbIds;
	}
	public void setVendorProjectDbIds(List<String> vendorProjectDbIds) {
		this.vendorProjectDbIds = vendorProjectDbIds;
	}
	public List<String> getVendorPlateDbIds() {
		return vendorPlateDbIds;
	}
	public void setVendorPlateDbIds(List<String> vendorPlateDbIds) {
		this.vendorPlateDbIds = vendorPlateDbIds;
	}
	public List<String> getClientPlateDbIds() {
		return clientPlateDbIds;
	}
	public void setClientPlateDbIds(List<String> clientPlateDbIds) {
		this.clientPlateDbIds = clientPlateDbIds;
	}
	public boolean isSampleInfo() {
		return sampleInfo;
	}
	public void setSampleInfo(boolean sampleInfo) {
		this.sampleInfo = sampleInfo;
	}
	
}
