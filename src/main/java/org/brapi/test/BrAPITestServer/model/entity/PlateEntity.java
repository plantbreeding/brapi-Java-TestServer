package org.brapi.test.BrAPITestServer.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.vendor.VendorPlateSubmissionEntity;

import io.swagger.model.geno.PlateFormat;

@Entity
@Table(name="plate")
public class PlateEntity extends BaseEntity{
	@Column
    private String clientPlateDbId;
	@Column
    private String clientPlateBarcode;
	@Column
    private PlateFormat sampleSubmissionFormat;
	@Column
    private Date statusTimeStamp;
	@OneToMany(mappedBy="plate", cascade = CascadeType.ALL)
    private List<SampleEntity> samples;
	@ManyToOne
	private VendorPlateSubmissionEntity submission;	
	
	public VendorPlateSubmissionEntity getSubmission() {
		return submission;
	}
	public void setSubmission(VendorPlateSubmissionEntity submission) {
		this.submission = submission;
	}
	public String getClientPlateDbId() {
		return clientPlateDbId;
	}
	public void setClientPlateDbId(String clientPlateDbId) {
		this.clientPlateDbId = clientPlateDbId;
	}
	public String getClientPlateBarcode() {
		return clientPlateBarcode;
	}
	public void setClientPlateBarcode(String clientPlateBarcode) {
		this.clientPlateBarcode = clientPlateBarcode;
	}
	public PlateFormat getSampleSubmissionFormat() {
		return sampleSubmissionFormat;
	}
	public void setSampleSubmissionFormat(PlateFormat sampleSubmissionFormat) {
		this.sampleSubmissionFormat = sampleSubmissionFormat;
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
