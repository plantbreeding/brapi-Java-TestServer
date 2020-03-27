package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.core.StudyEntity;

@Entity
@Table(name = "observation_unit")
public class ObservationUnitEntity extends BrAPIBaseEntity {
	@Column
	private String observationUnitName;
	@Column
	private String observationLevel;
	@Column
	private String uploadedBy;
	@Column
	private String operator;
	@Column
	private String entryNumber;
	@Column
	private String entryType;
	@Column
	private Integer plotNumber;
	@Column
	private Integer plantNumber;
	@Column
	private Integer blockNumber;
	@Column
	private String X;
	@Column
	private String Y;
	@Column
	private String replicate;
	@ManyToOne
	private StudyEntity study;
	@ManyToOne
	private GermplasmEntity germplasm;
	@ManyToOne
	private PedigreeEntity pedigree;
	@OneToMany(mappedBy="observationUnit", cascade=CascadeType.ALL)
	private List<ObservationEntity> observations;
	@OneToMany(mappedBy="observationUnit")
	private List<SampleEntity> samples;
	@OneToMany(mappedBy="observationUnitDbId", cascade=CascadeType.ALL)	
	private List<ObservationUnitXrefEntity> observationUnitXref;
	@OneToMany(mappedBy="observationUnit")	
	private List<ImageEntity> images;
	
	//TODO Specific fields for Phenotypes
	@Column
	private String observationLevels;
	@OneToMany(mappedBy="observationUnitDbId", cascade=CascadeType.ALL)
	private List<TreatmentEntity> treatments;
	
	public StudyEntity getStudy() {
		return study;
	}
	public void setStudy(StudyEntity study) {
		this.study = study;
	}
	public String getObservationLevels() {
		return observationLevels;
	}
	public void setObservationLevels(String observationLevels) {
		this.observationLevels = observationLevels;
	}
	public List<TreatmentEntity> getTreatments() {
		return treatments;
	}
	public void setTreatments(List<TreatmentEntity> treatments) {
		this.treatments = treatments;
	}
	public String getObservationUnitName() {
		return observationUnitName;
	}
	public void setObservationUnitName(String observationUnitName) {
		this.observationUnitName = observationUnitName;
	}
	public String getObservationLevel() {
		return observationLevel;
	}
	public void setObservationLevel(String observationLevel) {
		this.observationLevel = observationLevel;
	}
	public String getUploadedBy() {
		return uploadedBy;
	}
	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getEntryNumber() {
		return entryNumber;
	}
	public void setEntryNumber(String entryNumber) {
		this.entryNumber = entryNumber;
	}
	public String getEntryType() {
		return entryType;
	}
	public void setEntryType(String entryType) {
		this.entryType = entryType;
	}
	public Integer getPlotNumber() {
		return plotNumber;
	}
	public void setPlotNumber(Integer plotNumber) {
		this.plotNumber = plotNumber;
	}
	public Integer getPlantNumber() {
		return plantNumber;
	}
	public void setPlantNumber(Integer plantNumber) {
		this.plantNumber = plantNumber;
	}
	public Integer getBlockNumber() {
		return blockNumber;
	}
	public void setBlockNumber(Integer blockNumber) {
		this.blockNumber = blockNumber;
	}
	public String getX() {
		return X;
	}
	public void setX(String x) {
		X = x;
	}
	public String getY() {
		return Y;
	}
	public void setY(String y) {
		Y = y;
	}
	public String getReplicate() {
		return replicate;
	}
	public void setReplicate(String replicate) {
		this.replicate = replicate;
	}
	public GermplasmEntity getGermplasm() {
		return germplasm;
	}
	public void setGermplasm(GermplasmEntity germplasm) {
		this.germplasm = germplasm;
	}
	public PedigreeEntity getPedigree() {
		return pedigree;
	}
	public void setPedigree(PedigreeEntity pedigree) {
		this.pedigree = pedigree;
	}
	public List<ObservationEntity> getObservations() {
		return observations;
	}
	public void setObservations(List<ObservationEntity> observations) {
		this.observations = observations;
	}
	public List<ObservationUnitXrefEntity> getObservationUnitXref() {
		return observationUnitXref;
	}
	public void setObservationUnitXref(List<ObservationUnitXrefEntity> observationUnitXref) {
		this.observationUnitXref = observationUnitXref;
	}

}
