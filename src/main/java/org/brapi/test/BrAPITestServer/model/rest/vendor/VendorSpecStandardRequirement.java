package org.brapi.test.BrAPITestServer.model.rest.vendor;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.brapi.test.BrAPITestServer.model.entity.BaseEntity;

public class VendorSpecStandardRequirement {
    private String minConcentration;
    private String maxConcentration;
    private String minVolume;
    private String maxVolume;
    private String minSampleNumber;
    private List<String> sampleTypes;
    private String sampleTypeDetails;
    private List<String> inputFormats;
    private String inputFormatDetails;
    private String plateOrientation;
    private VendorSpecBlankWell blankWellPosition;
	public String getMinConcentration() {
		return minConcentration;
	}
	public void setMinConcentration(String minConcentration) {
		this.minConcentration = minConcentration;
	}
	public String getMaxConcentration() {
		return maxConcentration;
	}
	public void setMaxConcentration(String maxConcentration) {
		this.maxConcentration = maxConcentration;
	}
	public String getMinVolume() {
		return minVolume;
	}
	public void setMinVolume(String minVolume) {
		this.minVolume = minVolume;
	}
	public String getMaxVolume() {
		return maxVolume;
	}
	public void setMaxVolume(String maxVolume) {
		this.maxVolume = maxVolume;
	}
	public String getMinSampleNumber() {
		return minSampleNumber;
	}
	public void setMinSampleNumber(String minSampleNumber) {
		this.minSampleNumber = minSampleNumber;
	}
	public List<String> getSampleTypes() {
		return sampleTypes;
	}
	public void setSampleTypes(List<String> sampleTypes) {
		this.sampleTypes = sampleTypes;
	}
	public String getSampleTypeDetails() {
		return sampleTypeDetails;
	}
	public void setSampleTypeDetails(String sampleTypeDetails) {
		this.sampleTypeDetails = sampleTypeDetails;
	}
	public List<String> getInputFormats() {
		return inputFormats;
	}
	public void setInputFormats(List<String> inputFormats) {
		this.inputFormats = inputFormats;
	}
	public String getInputFormatDetails() {
		return inputFormatDetails;
	}
	public void setInputFormatDetails(String inputFormatDetails) {
		this.inputFormatDetails = inputFormatDetails;
	}
	public String getPlateOrientation() {
		return plateOrientation;
	}
	public void setPlateOrientation(String plateOrientation) {
		this.plateOrientation = plateOrientation;
	}
	public VendorSpecBlankWell getBlankWellPosition() {
		return blankWellPosition;
	}
	public void setBlankWellPosition(VendorSpecBlankWell blankWellPosition) {
		this.blankWellPosition = blankWellPosition;
	}
}
