package org.brapi.test.BrAPITestServer.model.rest;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class VendorPlate {
    private String vendorProjectDbId;
    private String vendorPlateDbId;
    private String clientPlateDbId;
    private String vendorBarcode;
    private String vendorBarcodeImageURL;
    private String plateFormat;
    private String sampleType;
    private String status;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssXXX")
    private Date statusTimeStamp;
    private List<VendorSample> samples;
    private List<VendorPlateFile> files;
    
	public String getVendorProjectDbId() {
		return vendorProjectDbId;
	}
	public void setVendorProjectDbId(String vendorProjectDbId) {
		this.vendorProjectDbId = vendorProjectDbId;
	}
	public String getVendorPlateDbId() {
		return vendorPlateDbId;
	}
	public void setVendorPlateDbId(String vendorPlateDbId) {
		this.vendorPlateDbId = vendorPlateDbId;
	}
	public String getClientPlateDbId() {
		return clientPlateDbId;
	}
	public void setClientPlateDbId(String clientPlateDbId) {
		this.clientPlateDbId = clientPlateDbId;
	}
	public String getVendorBarcode() {
		return vendorBarcode;
	}
	public void setVendorBarcode(String vendorBarcode) {
		this.vendorBarcode = vendorBarcode;
	}
	public String getVendorBarcodeImageURL() {
		return vendorBarcodeImageURL;
	}
	public void setVendorBarcodeImageURL(String vendorBarcodeImageURL) {
		this.vendorBarcodeImageURL = vendorBarcodeImageURL;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getStatusTimeStamp() {
		return statusTimeStamp;
	}
	public void setStatusTimeStamp(Date statusTimeStamp) {
		this.statusTimeStamp = statusTimeStamp;
	}
	public List<VendorSample> getSamples() {
		return samples;
	}
	public void setSamples(List<VendorSample> samples) {
		this.samples = samples;
	}
	public List<VendorPlateFile> getFiles() {
		return files;
	}
	public void setFiles(List<VendorPlateFile> files) {
		this.files = files;
	}
}
