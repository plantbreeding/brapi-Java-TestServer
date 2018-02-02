package org.brapi.test.BrAPITestServer.model.rest;

import java.util.List;

public class VendorPlateRequest {
    private String vendorProjectDbId;
    private String clientPlateDbId;
    private String plateFormat;
    private String sampleType;
    private List<VendorSample> samples;
    
	public String getVendorProjectDbId() {
		return vendorProjectDbId;
	}
	public void setVendorProjectDbId(String vendorProjectDbId) {
		this.vendorProjectDbId = vendorProjectDbId;
	}
	public String getClientPlateDbId() {
		return clientPlateDbId;
	}
	public void setClientPlateDbId(String clientPlateDbId) {
		this.clientPlateDbId = clientPlateDbId;
	}
	public String getPlateFormat() {
		return plateFormat;
	}
	public void setPlateFormat(String plateFormat) {
		this.plateFormat = plateFormat;
	}
	public String getSampleType() {
		return sampleType;
	}
	public void setSampleType(String sampleType) {
		this.sampleType = sampleType;
	}
	public List<VendorSample> getSamples() {
		return samples;
	}
	public void setSamples(List<VendorSample> samples) {
		this.samples = samples;
	}
    
    
}
