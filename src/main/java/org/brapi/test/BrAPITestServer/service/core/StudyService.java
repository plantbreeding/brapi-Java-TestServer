package org.brapi.test.BrAPITestServer.service.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.core.CropEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.DataLinkEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.EnvironmentParametersEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.ExperimentalDesignEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.GrowthFacilityEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.LocationEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.ObservationLevelEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.PersonEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.SeasonEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.StudyEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.StudyLastUpdateEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.TrialEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationVariableEntity;
import org.brapi.test.BrAPITestServer.repository.core.StudyRepository;
import org.brapi.test.BrAPITestServer.service.DateUtility;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.brapi.test.BrAPITestServer.service.UpdateUtility;
import org.brapi.test.BrAPITestServer.service.pheno.ObservationVariableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.DataLink;
import io.swagger.model.Metadata;
import io.swagger.model.core.Contact;
import io.swagger.model.core.EnvironmentParameter;
import io.swagger.model.core.SortBy;
import io.swagger.model.core.SortOrder;
import io.swagger.model.core.Study;
import io.swagger.model.core.StudyExperimentalDesign;
import io.swagger.model.core.StudyGrowthFacility;
import io.swagger.model.core.StudyNewRequest;
import io.swagger.model.core.StudyLastUpdate;
import io.swagger.model.core.StudySearchRequest;
import io.swagger.model.pheno.ObservationUnitHierarchyLevel;
import io.swagger.model.pheno.ObservationUnitHierarchyLevelEnum;

@Service
public class StudyService {
	private final StudyRepository studyRepository;

	private final TrialService trialService;
	private final CropService cropService;
	private final LocationService locationService;
	private final PeopleService peopleService;
	private final SeasonService seasonService;
	private final ObservationVariableService variableService;

	@Autowired
	public StudyService(StudyRepository studyRepository, TrialService trialService, CropService cropService,
			LocationService locationService, PeopleService peopleService, SeasonService seasonService,
			ObservationVariableService variableService) {
		this.studyRepository = studyRepository;

		this.locationService = locationService;
		this.peopleService = peopleService;
		this.seasonService = seasonService;
		this.trialService = trialService;
		this.cropService = cropService;
		this.variableService = variableService;
	}

	public List<Study> findStudies(String commonCropName, String studyType, String programDbId, String locationDbId,
			String seasonDbId, String trialDbId, String studyDbId, String studyName, String studyCode, String studyPUI,
			String germplasmDbId, String observationVariableDbId, String externalReferenceId,
			String externalReferenceID, String externalReferenceSource, Boolean active, String sortBy, String sortOrder,
			Metadata metadata) {

		StudySearchRequest request = new StudySearchRequest();
		if (commonCropName != null)
			request.addCommonCropNamesItem(commonCropName);
		if (studyType != null)
			request.addStudyTypesItem(studyType);
		if (programDbId != null)
			request.addProgramDbIdsItem(programDbId);
		if (locationDbId != null)
			request.addLocationDbIdsItem(locationDbId);
		if (seasonDbId != null)
			request.addSeasonDbIdsItem(seasonDbId);
		if (trialDbId != null)
			request.addTrialDbIdsItem(trialDbId);
		if (studyDbId != null)
			request.addStudyDbIdsItem(studyDbId);
		if (studyName != null)
			request.addStudyNamesItem(studyName);
		if (studyCode != null)
			request.addStudyCodesItem(studyCode);
		if (studyPUI != null)
			request.addStudyPUIsItem(studyPUI);
		if (germplasmDbId != null)
			request.addGermplasmDbIdsItem(germplasmDbId);
		if (observationVariableDbId != null)
			request.addObservationVariableDbIdsItem(observationVariableDbId);
		if (active != null)
			request.setActive(active);
		if (sortBy != null && SortBy.fromValue(sortBy) != null)
			request.setSortBy(SortBy.fromValue(sortBy));
		if (sortOrder != null && SortOrder.fromValue(sortOrder) != null)
			request.setSortOrder(SortOrder.fromValue(sortOrder));

		request.addExternalReferenceItem(externalReferenceId, externalReferenceID, externalReferenceSource);

		return findStudies(request, metadata);
	}

	public List<Study> findStudies(StudySearchRequest request, Metadata metaData) {

		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		SearchQueryBuilder<StudyEntity> searchQuery = new SearchQueryBuilder<StudyEntity>(StudyEntity.class);

		if (request.getSeasonDbIds() != null) {
			searchQuery = searchQuery.join("seasons", "season");
		}
		if (request.getGermplasmDbIds() != null || request.getGermplasmNames() != null
				|| request.getObservationVariableDbIds() != null || request.getObservationVariableNames() != null) {
			searchQuery = searchQuery.join("observationUnits", "obsunit");
		}
		if (request.getObservationVariableDbIds() != null || request.getObservationVariableNames() != null) {
			searchQuery = searchQuery.join("observationVariables", "variable");
		}

		searchQuery = searchQuery.withExRefs(request.getExternalReferenceIDs(), request.getExternalReferenceSources())
				.appendList(request.getCommonCropNames(), "crop.cropName")
				.appendList(request.getGermplasmDbIds(), "*obsunit.germplasm.id")
				.appendList(request.getGermplasmNames(), "*obsunit.germplasm.germplasmName")
				.appendList(request.getLocationDbIds(), "location.id")
				.appendList(request.getLocationNames(), "location.locationName")
				.appendList(request.getObservationVariableDbIds(), "*variable.id")
				.appendList(request.getObservationVariableNames(), "*variable.name")
				.appendList(request.getProgramDbIds(), "program.id")
				.appendList(request.getProgramNames(), "program.name")
				.appendList(request.getSeasonDbIds(), "*season.id").appendList(request.getStudyCodes(), "studyCode")
				.appendList(request.getStudyDbIds(), "id").appendList(request.getStudyNames(), "studyName")
				.appendList(request.getStudyPUIs(), "studyPUI").appendList(request.getStudyTypes(), "studyType")
				.appendList(request.getTrialDbIds(), "trial.id").appendList(request.getTrialNames(), "trial.trialName")
				.withSort(getSortByField(request.getSortBy()), request.getSortOrder());

		Page<StudyEntity> studiesPage = studyRepository.findAllBySearch(searchQuery, pageReq);
		PagingUtility.calculateMetaData(metaData, studiesPage);

		List<Study> studies = studiesPage.map(this::convertFromEntity).getContent();
		return studies;
	}

	public Study getStudy(String studyDbId) throws BrAPIServerException {
		return convertFromEntity(getStudyEntity(studyDbId, HttpStatus.NOT_FOUND));
	}

	public StudyEntity getStudyEntity(String studyDbId) throws BrAPIServerException {
		return getStudyEntity(studyDbId, HttpStatus.BAD_REQUEST);
	}

	public StudyEntity getStudyEntity(String studyDbId, HttpStatus errorStatus) throws BrAPIServerException {
		Optional<StudyEntity> entityOption = studyRepository.findById(studyDbId);
		StudyEntity study = null;
		if (entityOption.isPresent()) {
			study = entityOption.get();
		} else {
			throw new BrAPIServerDbIdNotFoundException("study", studyDbId, errorStatus);
		}
		return study;
	}

	public List<Study> saveStudies(List<StudyNewRequest> body) throws BrAPIServerException {
		List<Study> savedStudies = new ArrayList<>();

		for (StudyNewRequest study : body) {

			StudyEntity entity = new StudyEntity();
			updateEntity(entity, study);

			StudyEntity savedEntity = studyRepository.save(entity);

			savedStudies.add(convertFromEntity(savedEntity));
		}

		return savedStudies;
	}

	public Study updateStudy(String studyDbId, StudyNewRequest body) throws BrAPIServerException {
		StudyEntity entity = getStudyEntity(studyDbId, HttpStatus.NOT_FOUND);
		updateEntity(entity, body);
		StudyEntity savedEntity = studyRepository.save(entity);

		return convertFromEntity(savedEntity);
	}

	public List<String> getStudyTypes(Metadata metadata) {
		List<StudyEntity> studies = studyRepository.findAll();
		Set<String> types = new HashSet<>();
		for (StudyEntity entity : studies) {
			if (entity.getStudyType() != null)
				types.add(entity.getStudyType());
		}
		return PagingUtility.paginateSimpleList(new ArrayList<>(types), metadata);
	}

	private void updateEntity(StudyEntity entity, StudyNewRequest body) throws BrAPIServerException {
		entity = UpdateUtility.updateEntity(body, entity);

		if (body.isActive() != null)
			entity.setActive(body.isActive());
		if (body.getContacts() != null) {
			entity.setContacts(new ArrayList<>());
			for (Contact contact : body.getContacts()) {
				PersonEntity contactEntity;
				if (contact.getContactDbId() == null) {
					contactEntity = peopleService.saveContact(contact);
				} else {
					try {
						contactEntity = peopleService.getPersonEntity(contact.getContactDbId());
					} catch (BrAPIServerException e) {
						contactEntity = peopleService.saveContact(contact);
					}
				}
				entity.getContacts().add(contactEntity);
			}
		}
		if (body.getCulturalPractices() != null)
			entity.setCulturalPractices(body.getCulturalPractices());
		if (body.getDataLinks() != null)
			entity.setDataLinks(body.getDataLinks().stream().map(this::convertToEntity).collect(Collectors.toList()));
		if (body.getDocumentationURL() != null)
			entity.setDocumentationURL(body.getDocumentationURL());
		if (body.getEndDate() != null)
			entity.setEndDate(DateUtility.toDate(body.getEndDate()));
		if (body.getEnvironmentParameters() != null) {
			if (entity.getEnvironmentParameters() != null) {
				for (EnvironmentParametersEntity param : entity.getEnvironmentParameters()) {
					param.setStudy(null);
				}
			}
			entity.setEnvironmentParameters(
					body.getEnvironmentParameters().stream().map(this::convertToEntity).collect(Collectors.toList()));
		}
		if (body.getExperimentalDesign() != null)
			entity.setExperimentalDesign(convertToEntity(body.getExperimentalDesign(), entity));
		if (body.getGrowthFacility() != null)
			entity.setGrowthFacility(convertToEntity(body.getGrowthFacility(), entity));
		if (body.getLastUpdate() != null)
			entity.setLastUpdate(convertToEntity(body.getLastUpdate(), entity));
		if (body.getLicense() != null)
			entity.setLicense(body.getLicense());
		if (body.getLocationDbId() != null) {
			LocationEntity location = locationService.getLocationEntity(body.getLocationDbId());
			entity.setLocation(location);
		}
		if (body.getObservationLevels() != null) {
			entity.setObservationLevels(
					body.getObservationLevels().stream().map(this::convertToEntity).collect(Collectors.toList()));
		}
		if (body.getObservationUnitsDescription() != null)
			entity.setObservationUnitsDescription(body.getObservationUnitsDescription());
		if (body.getObservationVariableDbIds() != null) {
			entity.setObservationVariables(new ArrayList<>());
			for (String variableDbId : body.getObservationVariableDbIds()) {
				ObservationVariableEntity variableEntity = variableService.getObservationVariableEntity(variableDbId);
				entity.getObservationVariables().add(variableEntity);
			}
		}
		if (body.getSeasons() != null) {
			entity.setSeasons(new ArrayList<>());
			for (String season : body.getSeasons()) {
				SeasonEntity seasonEntity = seasonService.getSeasonEntity(season);
				entity.getSeasons().add(seasonEntity);
			}
		}
		if (body.getStartDate() != null)
			entity.setStartDate(DateUtility.toDate(body.getStartDate()));
		if (body.getStudyCode() != null)
			entity.setStudyCode(body.getStudyCode());
		if (body.getStudyDescription() != null)
			entity.setStudyDescription(body.getStudyDescription());
		if (body.getStudyName() != null)
			entity.setStudyName(body.getStudyName());
		if (body.getStudyPUI() != null)
			entity.setStudyPUI(body.getStudyPUI());
		if (body.getStudyType() != null)
			entity.setStudyType(body.getStudyType());

		if (body.getTrialDbId() != null) {
			TrialEntity trial = trialService.getTrialEntity(body.getTrialDbId());
			entity.setTrial(trial);
		} else if (body.getCommonCropName() != null) {
			CropEntity crop = cropService.getCropEntity(body.getCommonCropName());
			entity.setCrop(crop);
		}
	}

	private Study convertFromEntity(StudyEntity entity) {
		Study study = new Study();

		study.setActive(entity.isActive());
		study.setAdditionalInfo(entity.getAdditionalInfo());

		if (entity.getContacts() != null) {
			study.setContacts(entity.getContacts().stream().map(this.peopleService::convertToContact)
					.collect(Collectors.toList()));
		}
		study.setCulturalPractices(entity.getCulturalPractices());

		if (entity.getDataLinks() != null) {
			study.setDataLinks(
					entity.getDataLinks().stream().map(this::convertFromEntity).collect(Collectors.toList()));
		}

		study.setDocumentationURL(entity.getDocumentationURL());
		study.setEndDate(DateUtility.toOffsetDateTime(entity.getEndDate()));

		if (entity.getEnvironmentParameters() != null) {
			study.setEnvironmentParameters(entity.getEnvironmentParameters().stream().map(this::convertFromEntity)
					.collect(Collectors.toList()));
		}

		study.setExperimentalDesign(convertFromEntity(entity.getExperimentalDesign()));
		study.setExternalReferences(entity.getExternalReferencesMap());
		study.setGrowthFacility(convertFromEntity(entity.getGrowthFacility()));
		study.setLastUpdate(convertFromEntity(entity.getLastUpdate()));
		study.setLicense(entity.getLicense());

		if (entity.getLocation() != null) {
			study.setLocationDbId(entity.getLocation().getId());
			study.setLocationName(entity.getLocation().getLocationName());
		}

		if (entity.getObservationLevels() != null) {
			study.setObservationLevels(
					entity.getObservationLevels().stream().map(this::convertFromEntity).collect(Collectors.toList()));
		}

		study.setObservationUnitsDescription(entity.getObservationUnitsDescription());

		if (entity.getObservationVariables() != null) {
			study.setObservationVariableDbIds(entity.getObservationVariables().stream().map(e -> {
				return e.getId();
			}).collect(Collectors.toList()));
		}

		if (entity.getSeasons() != null) {
			study.setSeasons(entity.getSeasons().stream().map(e -> {
				return e.getId();
			}).collect(Collectors.toList()));
		}

		study.setStartDate(DateUtility.toOffsetDateTime(entity.getStartDate()));
		study.setStudyCode(entity.getStudyCode());
		study.setStudyDbId(entity.getId());
		study.setStudyDescription(entity.getStudyDescription());
		study.setStudyName(entity.getStudyName());
		study.setStudyPUI(entity.getStudyPUI());
		study.setStudyType(entity.getStudyType());

		if (entity.getTrial() != null) {
			study.setTrialDbId(entity.getTrial().getId());
			study.setTrialName(entity.getTrial().getTrialName());
			if (entity.getTrial().getProgram() != null) {
				if (entity.getTrial().getProgram().getCrop() != null) {
					study.setCommonCropName(entity.getTrial().getProgram().getCrop().getCropName());
				}
			}
		} 
		if (entity.getProgram() != null) {
			if (entity.getProgram().getCrop() != null) {
				study.setCommonCropName(entity.getProgram().getCrop().getCropName());
			}
		} 
		if (entity.getCrop() != null) {
			study.setCommonCropName(entity.getCrop().getCropName());
		}

		return study;
	}

	private ObservationUnitHierarchyLevel convertFromEntity(ObservationLevelEntity entity) {
		ObservationUnitHierarchyLevel level = null;
		if (entity != null) {
			level = new ObservationUnitHierarchyLevel();
			level.setLevelName(ObservationUnitHierarchyLevelEnum.fromValue(entity.getLevelName()));
			level.setLevelOrder(entity.getLevelOrder());
		}
		return level;
	}

	private ObservationLevelEntity convertToEntity(ObservationUnitHierarchyLevel level) {
		ObservationLevelEntity entity = null;
		if (level != null) {
			entity = new ObservationLevelEntity();
			entity.setLevelName(level.getLevelName().toString());
			entity.setLevelOrder(level.getLevelOrder());
		}
		return entity;
	}

	private StudyLastUpdate convertFromEntity(StudyLastUpdateEntity entity) {
		StudyLastUpdate update = null;
		if (entity != null) {
			update = new StudyLastUpdate();
			update.setTimestamp(DateUtility.toOffsetDateTime(entity.getTimestamp()));
			update.setVersion(entity.getVersion());
		}
		return update;
	}

	private StudyLastUpdateEntity convertToEntity(StudyLastUpdate update, StudyEntity study) {
		StudyLastUpdateEntity entity = null;
		if (update != null) {
			entity = new StudyLastUpdateEntity();
			entity.setTimestamp(DateUtility.toDate(update.getTimestamp()));
			entity.setVersion(update.getVersion());
			entity.setStudy(study);
		}
		return entity;
	}

	private StudyGrowthFacility convertFromEntity(GrowthFacilityEntity entity) {
		StudyGrowthFacility gf = null;
		if (entity != null) {
			gf = new StudyGrowthFacility();
			gf.setDescription(entity.getDescription());
			gf.setPUI(entity.getPUI());
		}
		return gf;
	}

	private GrowthFacilityEntity convertToEntity(StudyGrowthFacility facility, StudyEntity study) {
		GrowthFacilityEntity entity = null;
		if (facility != null) {
			entity = new GrowthFacilityEntity();
			entity.setDescription(facility.getDescription());
			entity.setPUI(facility.getPUI());
			entity.setStudy(study);
		}
		return entity;
	}

	private StudyExperimentalDesign convertFromEntity(ExperimentalDesignEntity entity) {
		StudyExperimentalDesign ed = null;
		if (entity != null) {
			ed = new StudyExperimentalDesign();
			ed.setDescription(entity.getDescription());
			ed.setPUI(entity.getPUI());
		}
		return ed;
	}

	private ExperimentalDesignEntity convertToEntity(StudyExperimentalDesign design, StudyEntity study) {
		ExperimentalDesignEntity entity = null;
		if (design != null) {
			entity = new ExperimentalDesignEntity();
			entity.setDescription(design.getDescription());
			entity.setPUI(design.getPUI());
			entity.setStudy(study);
		}
		return entity;
	}

	private DataLink convertFromEntity(DataLinkEntity entity) {
		DataLink link = null;
		if (entity != null) {
			link = new DataLink();
			link.setDataFormat(entity.getDataFormat());
			link.setDescription(entity.getDescription());
			link.setFileFormat(entity.getFileFormat());
			link.setName(entity.getName());
			link.setProvenance(entity.getProvenance());
			link.setScientificType(entity.getScientificType());
			link.setUrl(entity.getUrl());
			link.setVersion(entity.getVersion());
		}
		return link;
	}

	private DataLinkEntity convertToEntity(DataLink link) {
		DataLinkEntity entity = null;
		if (link != null) {
			entity = new DataLinkEntity();
			entity.setDataFormat(link.getDataFormat());
			entity.setDescription(link.getDescription());
			entity.setFileFormat(link.getFileFormat());
			entity.setName(link.getName());
			entity.setProvenance(link.getProvenance());
			entity.setScientificType(link.getScientificType());
			entity.setUrl(link.getUrl());
			entity.setVersion(link.getVersion());
		}
		return entity;
	}

	private EnvironmentParameter convertFromEntity(EnvironmentParametersEntity entity) {
		EnvironmentParameter ep = null;
		if (entity != null) {
			ep = new EnvironmentParameter();
			ep.setDescription(entity.getDescription());
			ep.setParameterName(entity.getParameterName());
			ep.setParameterPUI(entity.getParameterPUI());
			ep.setUnit(entity.getUnit());
			ep.setUnitPUI(entity.getUnitPUI());
			ep.setValue(entity.getValue());
			ep.setValuePUI(entity.getValuePUI());
		}
		return ep;
	}

	private EnvironmentParametersEntity convertToEntity(EnvironmentParameter param) {
		EnvironmentParametersEntity entity = null;
		if (param != null) {
			entity = new EnvironmentParametersEntity();
			entity.setDescription(param.getDescription());
			entity.setParameterName(param.getParameterName());
			entity.setParameterPUI(param.getParameterPUI());
			entity.setUnit(param.getUnit());
			entity.setUnitPUI(param.getUnitPUI());
			entity.setValue(param.getValue());
			entity.setValuePUI(param.getValuePUI());
		}
		return entity;
	}

	private String getSortByField(SortBy sortBy) {
		String sortByStr = "id";
		if (sortBy != null) {
			switch (sortBy) {
			case GERMPLASMDBID:
				sortByStr = "*obsunit.germplasm.id";
				break;
			case LOCATIONDBID:
				sortByStr = "location.id";
				break;
			case OBSERVATIONVARIABLEDBID:
				sortByStr = "*observation.observationVariable.id";
				break;
			case PROGRAMDBID:
				sortByStr = "trial.program.id";
				break;
			case PROGRAMNAME:
				sortByStr = "trial.program.name";
				break;
			case SEASONDBID:
				sortByStr = "*season.id";
				break;
			case STUDYDBID:
				sortByStr = "id";
				break;
			case STUDYLOCATION:
				sortByStr = "location.id";
				break;
			case TRIALDBID:
				sortByStr = "trial.id ";
				break;
			case STUDYTYPE:
				sortByStr = "studyName";
				break;
			case STUDYNAME:
			default:
				sortByStr = "studyName";
				break;
			}
		}
		return sortByStr;
	}

}
