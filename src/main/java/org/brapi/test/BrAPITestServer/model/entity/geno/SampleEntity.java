package org.brapi.test.BrAPITestServer.model.entity.geno;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.ProgramEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.StudyEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.TrialEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationUnitEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.TaxonEntity;

@Entity
@Table(name="sample")
public class SampleEntity extends BrAPIPrimaryEntity{
	@Column
	private Integer plateColumn; 
	@Column
	private String concentration;
	@ManyToOne
	private ObservationUnitEntity observationUnit;
	@ManyToOne
	private ProgramEntity program;
	@ManyToOne
	private TrialEntity trial;
	@ManyToOne
	private StudyEntity study;
	@ManyToOne
	private PlateEntity plate;
	@Column
	private String plateRow; 
	@Column
	private String sampleBarcode; 
	@Column
	private String sampleDescription;
	@Column
	private String sampleGroupDbId;
	@Column
	private String sampleName;
	@Column
	private String samplePUI;
	@Column
	private Date sampleTimestamp;
	@Column
	private String sampleType;
	@Column
	private String takenBy;
	@OneToOne
	private TaxonEntity taxonId;
	@Column
	private String tissueType;
	@Column
	private String volume;
	@Column
	private String well;
	
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
	public String getWell() {
		return well;
	}
	public void setWell(String well) {
		this.well = well;
	}
	public String getSampleGroupDbId() {
		return sampleGroupDbId;
	}
	public void setSampleGroupDbId(String sampleGroupDbId) {
		this.sampleGroupDbId = sampleGroupDbId;
	}
	public String getConcentration() {
		return concentration;
	}
	public void setConcentration(String concentration) {
		this.concentration = concentration;
	}
	public ObservationUnitEntity getObservationUnit() {
		return observationUnit;
	}
	public void setObservationUnit(ObservationUnitEntity observationUnit) {
		this.observationUnit = observationUnit;
	}
	public PlateEntity getPlate() {
		return plate;
	}
	public void setPlate(PlateEntity plate) {
		this.plate = plate;
	}
	public Integer getPlateColumn() {
		return plateColumn;
	}
	public void setPlateColumn(Integer plateColumn) {
		this.plateColumn = plateColumn;
	}
	public String getPlateRow() {
		return plateRow;
	}
	public void setPlateRow(String plateRow) {
		this.plateRow = plateRow;
	}
	public String getSampleBarcode() {
		return sampleBarcode;
	}
	public void setSampleBarcode(String sampleBarcode) {
		this.sampleBarcode = sampleBarcode;
	}
	public String getSampleDescription() {
		return sampleDescription;
	}
	public void setSampleDescription(String sampleDescription) {
		this.sampleDescription = sampleDescription;
	}
	public String getSampleName() {
		return sampleName;
	}
	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}
	public String getSamplePUI() {
		return samplePUI;
	}
	public void setSamplePUI(String samplePUI) {
		this.samplePUI = samplePUI;
	}
	public Date getSampleTimestamp() {
		return sampleTimestamp;
	}
	public void setSampleTimestamp(Date sampleTimestamp) {
		this.sampleTimestamp = sampleTimestamp;
	}
	public String getSampleType() {
		return sampleType;
	}
	public void setSampleType(String sampleType) {
		this.sampleType = sampleType;
	}
	public String getTakenBy() {
		return takenBy;
	}
	public void setTakenBy(String takenBy) {
		this.takenBy = takenBy;
	}
	public TaxonEntity getTaxonId() {
		return taxonId;
	}
	public void setTaxonId(TaxonEntity taxonId) {
		this.taxonId = taxonId;
	}
	public String getTissueType() {
		return tissueType;
	}
	public void setTissueType(String tissueType) {
		this.tissueType = tissueType;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
}
