package org.brapi.test.BrAPITestServer.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.vendor.VendorFileEntity;

@Entity
@Table(name="plate")
public class PlateEntity extends BaseEntity{
	@Column
    private String vendorProjectDbId;
	@Column
    private String clientPlateDbId;
	@Column
    private String vendorBarcode;
	@Column
    private String vendorBarcodeImageURL;
	@Column
    private String plateFormat;
	@Column
    private String sampleType;
	@Column
    private String status;
	@Column
    private Date statusTimeStamp;
	@OneToMany(mappedBy="plate", cascade = CascadeType.ALL)
    private List<SampleEntity> samples;
	@OneToMany(mappedBy="plateDbId")
	private List<VendorFileEntity> files;
	
	public List<VendorFileEntity> getFiles() {
		return files;
	}
	public void setFiles(List<VendorFileEntity> files) {
		this.files = files;
	}
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
	public List<SampleEntity> getSamples() {
		return samples;
	}
	public void setSamples(List<SampleEntity> samples) {
		this.samples = samples;
	}
}
