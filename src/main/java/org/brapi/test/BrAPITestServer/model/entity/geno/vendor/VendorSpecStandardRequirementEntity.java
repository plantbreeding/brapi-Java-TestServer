package org.brapi.test.BrAPITestServer.model.entity.geno.vendor;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

@Entity
@Table(name="vendor_spec_requirement")
public class VendorSpecStandardRequirementEntity extends BrAPIBaseEntity {
	@Column
    private String minConcentration;
	@Column
    private String maxConcentration;
	@Column
    private String minVolume;
	@Column
    private String maxVolume;
	@Column
    private String minSampleNumber;
	@OneToMany(mappedBy="vendorSpecStandardRequirementDbId")
    private List<VendorSpecSampleTypeEntity> sampleTypes;
	@Column
    private String sampleTypeDetails;
	@OneToMany(mappedBy="vendorSpecStandardRequirementDbId")
    private List<VendorSpecInputFormatEntity> inputFormats;
	@Column
    private String inputFormatDetails;
	@Column
    private String plateOrientation;
	@OneToMany(mappedBy="vendorSpecStandardRequirementDbId")
    private List<VendorSpecWellPositionEntity> blankWellPositions;
	
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
	public List<VendorSpecSampleTypeEntity> getSampleTypes() {
		return sampleTypes;
	}
	public void setSampleTypes(List<VendorSpecSampleTypeEntity> sampleTypes) {
		this.sampleTypes = sampleTypes;
	}
	public String getSampleTypeDetails() {
		return sampleTypeDetails;
	}
	public void setSampleTypeDetails(String sampleTypeDetails) {
		this.sampleTypeDetails = sampleTypeDetails;
	}
	public List<VendorSpecInputFormatEntity> getInputFormats() {
		return inputFormats;
	}
	public void setInputFormats(List<VendorSpecInputFormatEntity> inputFormats) {
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
	public List<VendorSpecWellPositionEntity> getBlankWellPositions() {
		return blankWellPositions;
	}
	public void setBlankWellPositions(List<VendorSpecWellPositionEntity> blankWellPositions) {
		this.blankWellPositions = blankWellPositions;
	}
}
