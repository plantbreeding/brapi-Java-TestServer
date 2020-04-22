package org.brapi.test.BrAPITestServer.model.entity.geno;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.StudyEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.GermplasmEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationUnitEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.TaxonEntity;

@Entity
@Table(name="sample")
public class SampleEntity extends BrAPIBaseEntity{
	@ManyToOne
	private PlateEntity plate;
	@Column
	private Integer plateIndex; 
	@Column
	private String takenBy;
	@Column
	private Date sampleTimestamp;
	@Column
	private String sampleType;
	@Column
	private String tissueType;
	@Column
	private String notes;
	@Column
	private String concentration;
	@Column
	private String volume;
	@OneToOne
	private TaxonEntity taxonId;
	@ManyToOne
	private ObservationUnitEntity observationUnit;
	@ManyToOne
	private StudyEntity study;
	@ManyToOne
	private GermplasmEntity germplasm;
	
	public StudyEntity getStudy() {
		return study;
	}
	public void setStudy(StudyEntity study) {
		this.study = study;
	}
	public GermplasmEntity getGermplasm() {
		return germplasm;
	}
	public void setGermplasm(GermplasmEntity germplasm) {
		this.germplasm = germplasm;
	}
	public String getConcentration() {
		return concentration;
	}
	public void setConcentration(String concentration) {
		this.concentration = concentration;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public TaxonEntity getTaxonId() {
		return taxonId;
	}
	public void setTaxonId(TaxonEntity taxonId) {
		this.taxonId = taxonId;
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
	public Integer getPlateIndex() {
		return plateIndex;
	}
	public void setPlateIndex(Integer plateIndex) {
		this.plateIndex = plateIndex;
	}
	public Date getSampleTimestamp() {
		return sampleTimestamp;
	}
	public void setSampleTimestamp(Date sampleTimestamp) {
		this.sampleTimestamp = sampleTimestamp;
	}
	public String getTakenBy() {
		return takenBy;
	}
	public void setTakenBy(String takenBy) {
		this.takenBy = takenBy;
	}
	public String getSampleType() {
		return sampleType;
	}
	public void setSampleType(String sampleType) {
		this.sampleType = sampleType;
	}
	public String getTissueType() {
		return tissueType;
	}
	public void setTissueType(String tissueType) {
		this.tissueType = tissueType;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}

}
