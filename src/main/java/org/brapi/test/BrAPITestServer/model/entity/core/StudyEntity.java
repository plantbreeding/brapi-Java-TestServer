package org.brapi.test.BrAPITestServer.model.entity.core;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationUnitEntity;

@Entity
@Table(name = "study")
public class StudyEntity extends BrAPIPrimaryEntity {

	@Column
	private boolean active;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "study_contact", joinColumns = {
			@JoinColumn(name = "study_db_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "person_db_id", referencedColumnName = "id") })
	private List<PersonEntity> contacts;
	@Column
	private String culturalPractices;
	@OneToMany(mappedBy = "study")
	private List<DataLinkEntity> dataLinks;
	@Column
	private String documentationURL;
	@Column
	private Date endDate;
	@OneToMany(mappedBy = "study")
	private List<EnvironmentParametersEntity> environmentParameters;
	@OneToOne(mappedBy = "study", cascade = CascadeType.ALL, orphanRemoval = true)
	private ExperimentalDesignEntity experimentalDesign;
	@OneToOne(mappedBy = "study", cascade = CascadeType.ALL, orphanRemoval = true)
	private GrowthFacilityEntity growthFacility;
	@OneToOne(mappedBy = "study", cascade = CascadeType.ALL, orphanRemoval = true)
	private StudyLastUpdateEntity lastUpdate;
	@Column
	private String license;
	@OneToOne
	private LocationEntity location;
	@OneToMany(mappedBy = "study")
	private List<ObservationLevelEntity> observationLevels;
	@Column
	private String observationUnitsDescription;
	@ManyToMany
	@JoinTable(name = "study_season", joinColumns = {
			@JoinColumn(name = "study_db_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "season_db_id", referencedColumnName = "id") })
	private List<SeasonEntity> seasons;
	@Column
	private Date startDate;
	@Column
	private String studyCode;
	@Column
	private String studyDescription;
	@Column
	private String studyName;
	@Column
	private String studyPUI;
	@Column
	private String studyType;
	
	@ManyToOne
	private CropEntity crop;
	@ManyToOne
	private ProgramEntity program;
	@ManyToOne
	private TrialEntity trial;

	@OneToMany(mappedBy="study")
	private List<ObservationUnitEntity> observationUnits;
	@OneToMany(mappedBy="study")
	private List<ObservationEntity> observations;

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

	public List<ObservationUnitEntity> getObservationUnits() {
		return observationUnits;
	}

	public void setObservationUnits(List<ObservationUnitEntity> observationUnits) {
		this.observationUnits = observationUnits;
	}

	public List<ObservationEntity> getObservations() {
		return observations;
	}

	public void setObservations(List<ObservationEntity> observations) {
		this.observations = observations;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<PersonEntity> getContacts() {
		return contacts;
	}

	public void setContacts(List<PersonEntity> contacts) {
		this.contacts = contacts;
	}

	public String getCulturalPractices() {
		return culturalPractices;
	}

	public void setCulturalPractices(String culturalPractices) {
		this.culturalPractices = culturalPractices;
	}

	public List<DataLinkEntity> getDataLinks() {
		return dataLinks;
	}

	public void setDataLinks(List<DataLinkEntity> dataLinks) {
		this.dataLinks = dataLinks;
	}

	public String getDocumentationURL() {
		return documentationURL;
	}

	public void setDocumentationURL(String documentationURL) {
		this.documentationURL = documentationURL;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<EnvironmentParametersEntity> getEnvironmentParameters() {
		return environmentParameters;
	}

	public void setEnvironmentParameters(List<EnvironmentParametersEntity> environmentParameters) {
		this.environmentParameters = environmentParameters;
	}

	public ExperimentalDesignEntity getExperimentalDesign() {
		return experimentalDesign;
	}

	public void setExperimentalDesign(ExperimentalDesignEntity experimentalDesign) {
		this.experimentalDesign = experimentalDesign;
	}

	public GrowthFacilityEntity getGrowthFacility() {
		return growthFacility;
	}

	public void setGrowthFacility(GrowthFacilityEntity growthFacility) {
		this.growthFacility = growthFacility;
	}

	public StudyLastUpdateEntity getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(StudyLastUpdateEntity lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public LocationEntity getLocation() {
		return location;
	}

	public void setLocation(LocationEntity location) {
		this.location = location;
	}

	public List<ObservationLevelEntity> getObservationLevels() {
		return observationLevels;
	}

	public void setObservationLevels(List<ObservationLevelEntity> observationLevels) {
		this.observationLevels = observationLevels;
	}

	public String getObservationUnitsDescription() {
		return observationUnitsDescription;
	}

	public void setObservationUnitsDescription(String observationUnitsDescription) {
		this.observationUnitsDescription = observationUnitsDescription;
	}

	public List<SeasonEntity> getSeasons() {
		return seasons;
	}

	public void setSeasons(List<SeasonEntity> seasons) {
		this.seasons = seasons;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getStudyCode() {
		return studyCode;
	}

	public void setStudyCode(String studyCode) {
		this.studyCode = studyCode;
	}

	public String getStudyDescription() {
		return studyDescription;
	}

	public void setStudyDescription(String studyDescription) {
		this.studyDescription = studyDescription;
	}

	public String getStudyName() {
		return studyName;
	}

	public void setStudyName(String studyName) {
		this.studyName = studyName;
	}

	public String getStudyPUI() {
		return studyPUI;
	}

	public void setStudyPUI(String studyPUI) {
		this.studyPUI = studyPUI;
	}

	public String getStudyType() {
		return studyType;
	}

	public void setStudyType(String studyType) {
		this.studyType = studyType;
	}

	public TrialEntity getTrial() {
		return trial;
	}

	public void setTrial(TrialEntity trial) {
		this.trial = trial;
		if (trial.getProgram() != null)
			setProgram(trial.getProgram());
	}
}
