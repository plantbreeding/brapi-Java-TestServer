package org.brapi.test.BrAPITestServer.model.rest;

import java.util.List;

public class VendorPlateFile {
	private String filename;
	private String URL;
	private String md5sum;
	private String fileType;
	private List<String> sampleDbIds;
    private String additionalInfo;
    
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getMd5sum() {
		return md5sum;
	}
	public void setMd5sum(String md5sum) {
		this.md5sum = md5sum;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public List<String> getSampleDbIds() {
		return sampleDbIds;
	}
	public void setSampleDbIds(List<String> sampleDbIds) {
		this.sampleDbIds = sampleDbIds;
	}
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
}
