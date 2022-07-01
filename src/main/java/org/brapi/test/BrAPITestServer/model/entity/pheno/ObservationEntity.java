package org.brapi.test.BrAPITestServer.model.entity.pheno;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.brapi.test.BrAPITestServer.model.entity.GeoJSONEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.CropEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.ProgramEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.SeasonEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.StudyEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.TrialEntity;

@Entity
@Table(name = "observation")
public class ObservationEntity extends BrAPIPrimaryEntity {
	@Column
	private String collector;
	@Column
	private Date observationTimeStamp;
	@ManyToOne
	private ObservationVariableEntity observationVariable;
	@ManyToOne
	private SeasonEntity season;
	@Column
	private String uploadedBy;
	@Column
	private String value;
	@ManyToOne
	private CropEntity crop;
	@ManyToOne
	private ProgramEntity program;
	@ManyToOne
	private TrialEntity trial;
	@ManyToOne
	private StudyEntity study;
	@ManyToOne
	private ObservationUnitEntity observationUnit;
	@OneToOne(cascade = CascadeType.ALL)
	private GeoJSONEntity geoCoordinates;

	public GeoJSONEntity getGeoCoordinates() {
		return geoCoordinates;
	}

	public void setGeoCoordinates(GeoJSONEntity geoCoordinates) {
		this.geoCoordinates = geoCoordinates;
	}

	public CropEntity getCrop() {
		return crop;
	}

	public void setCrop(CropEntity crop) {
		this.crop = crop;
	}

	public ProgramEntity getProgram() {
		return program;
	}

	public void setProgram(ProgramEntity program) {
		this.program = program;
		if (program.getCrop() != null)
			setCrop(program.getCrop());
	}

	public TrialEntity getTrial() {
		return trial;
	}

	public void setTrial(TrialEntity trial) {
		this.trial = trial;
		if (trial.getProgram() != null)
			setProgram(trial.getProgram());
	}

	public StudyEntity getStudy() {
		return study;
	}

	public void setStudy(StudyEntity study) {
		this.study = study;
		if (study.getTrial() != null)
			setTrial(study.getTrial());
	}

	public String getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	public ObservationUnitEntity getObservationUnit() {
		return observationUnit;
	}

	public void setObservationUnit(ObservationUnitEntity observationUnit) {
		this.observationUnit = observationUnit;
		if (observationUnit.getStudy() != null)
			setStudy(observationUnit.getStudy());
	}

	public Date getObservationTimeStamp() {
		return observationTimeStamp;
	}

	public void setObservationTimeStamp(Date observationTimeStamp) {
		this.observationTimeStamp = observationTimeStamp;
	}

	public String getCollector() {
		return collector;
	}

	public void setCollector(String collector) {
		this.collector = collector;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ObservationVariableEntity getObservationVariable() {
		return observationVariable;
	}

	public void setObservationVariable(ObservationVariableEntity observationVariable) {
		this.observationVariable = observationVariable;
	}

	public SeasonEntity getSeason() {
		return season;
	}

	public void setSeason(SeasonEntity season) {
		this.season = season;
	}

}
