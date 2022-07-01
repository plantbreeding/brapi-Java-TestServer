package org.brapi.test.BrAPITestServer.model.entity.geno;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.ProgramEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.StudyEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.TrialEntity;
import org.brapi.test.BrAPITestServer.model.entity.geno.vendor.VendorPlateSubmissionEntity;

import io.swagger.model.geno.PlateFormat;
import io.swagger.model.geno.SampleType;

@Entity
@Table(name="plate")
public class PlateEntity extends BrAPIPrimaryEntity{
	@Column
    private String clientPlateDbId;
	@Column
    private String clientPlateBarcode;
	@Column
    private String plateName;
	@Column
    private String plateBarcode;
	@Column
    private PlateFormat plateFormat ;
	@Column
    private SampleType sampleType;
	@Column
    private PlateFormat sampleSubmissionFormat;
	@Column
    private Date statusTimeStamp;
	@OneToMany(mappedBy="plate", cascade = CascadeType.ALL)
    private List<SampleEntity> samples;
	@ManyToOne
	private VendorPlateSubmissionEntity submission;	
	@ManyToOne
	private ProgramEntity program;		
	@ManyToOne
	private TrialEntity trial;		
	@ManyToOne
	private StudyEntity study;	
	
	public String getPlateBarcode() {
		return plateBarcode;
	}
	public void setPlateBarcode(String plateBarcode) {
		this.plateBarcode = plateBarcode;
	}
	public PlateFormat getPlateFormat() {
		return plateFormat;
	}
	public void setPlateFormat(PlateFormat plateFormat) {
		this.plateFormat = plateFormat;
	}
	public SampleType getSampleType() {
		return sampleType;
	}
	public void setSampleType(SampleType sampleType) {
		this.sampleType = sampleType;
	}
	public ProgramEntity getProgram() {
		return program;
	}
	public void setProgram(ProgramEntity program) {
		this.program = program;
	}
	public TrialEntity getTrial() {
		return trial;
	}
	public void setTrial(TrialEntity trial) {
		this.trial = trial;
	}
	public StudyEntity getStudy() {
		return study;
	}
	public void setStudy(StudyEntity study) {
		this.study = study;
	}
	public String getPlateName() {
		return plateName;
	}
	public void setPlateName(String plateName) {
		this.plateName = plateName;
	}
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
