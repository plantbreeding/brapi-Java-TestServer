package org.brapi.test.BrAPITestServer.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.commons.lang3.math.NumberUtils;
import org.brapi.test.BrAPITestServer.model.entity.GermplasmEntity;
import org.brapi.test.BrAPITestServer.model.entity.ObservationEntity;
import org.brapi.test.BrAPITestServer.model.entity.ObservationUnitEntity;
import org.brapi.test.BrAPITestServer.model.entity.ObservationUnitXrefEntity;
import org.brapi.test.BrAPITestServer.model.entity.SeasonEntity;
import org.brapi.test.BrAPITestServer.model.entity.StudyAddtionalInfoEntity;
import org.brapi.test.BrAPITestServer.model.entity.StudyEntity;
import org.brapi.test.BrAPITestServer.model.entity.TreatmentEntity;
import org.brapi.test.BrAPITestServer.repository.GermplasmRepository;
import org.brapi.test.BrAPITestServer.repository.ObservationRepository;
import org.brapi.test.BrAPITestServer.repository.ObservationUnitRepository;
import org.brapi.test.BrAPITestServer.repository.SeasonRepository;
import org.brapi.test.BrAPITestServer.repository.StudyRepository;
import org.brapi.test.BrAPITestServer.repository.StudyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import io.swagger.model.DataLink;
import io.swagger.model.GermplasmSummary;
import io.swagger.model.GermplasmSummaryList;
import io.swagger.model.Metadata;
import io.swagger.model.NewObservationDbIds;
import io.swagger.model.NewObservationUnitDbIds;
import io.swagger.model.NewObservationUnitRequest;
import io.swagger.model.NewObservationsRequest;
import io.swagger.model.NewObservationsRequestDeprecatedData;
import io.swagger.model.NewObservationsRequestObservations;
import io.swagger.model.NewObservationsRequestWrapperDeprecated;
import io.swagger.model.NewObservationsTableRequest;
import io.swagger.model.Observation;
import io.swagger.model.ObservationSummary;
import io.swagger.model.ObservationUnit;
import io.swagger.model.ObservationUnitPosition;
import io.swagger.model.ObservationUnitXref;
import io.swagger.model.ObservationVariable;
import io.swagger.model.ObservationsTable;
import io.swagger.model.ObservationsTable.HeaderRowEnum;
import io.swagger.model.ObservationUnitPosition.EntryTypeEnum;
import io.swagger.model.Season;
import io.swagger.model.Study;
import io.swagger.model.StudyLastUpdate;
import io.swagger.model.StudyLayoutRequest;
import io.swagger.model.StudyLayoutRequestLayout;
import io.swagger.model.StudyObservationVariablesResponseResult;
import io.swagger.model.StudySearchRequest;
import io.swagger.model.StudySummary;
import io.swagger.model.StudyType;
import io.swagger.model.StudySearchRequest.SortByEnum;
import io.swagger.model.StudySearchRequest.SortOrderEnum;
import io.swagger.model.StudySearchRequestDep;

@Service
public class StudyService {
	private SeasonRepository seasonRepository;
	private StudyTypeRepository studyTypeRepository;
	private StudyRepository studyRepository;
	private ObservationUnitRepository observationUnitRepository;
	private ObservationRepository observationRepository;
	private GermplasmRepository germplasmRepository;

	private ObservationVariableService observationVariableService;
	private LocationService locationService;
	private ContactService contactService;

	@Autowired
	public StudyService(SeasonRepository seasonRepository, StudyTypeRepository studyTypeRepository,
			StudyRepository studyRepository, ObservationUnitRepository observationUnitRepository,
			ObservationRepository observationRepository, GermplasmRepository germplasmRepository,
			ObservationVariableService observationVariableService, LocationService locationService,
			ContactService contactService) {
		this.seasonRepository = seasonRepository;
		this.studyTypeRepository = studyTypeRepository;
		this.studyRepository = studyRepository;
		this.observationUnitRepository = observationUnitRepository;
		this.observationRepository = observationRepository;
		this.germplasmRepository = germplasmRepository;

		this.observationVariableService = observationVariableService;
		this.locationService = locationService;
		this.contactService = contactService;
	}

	public List<Season> getSeasons(String year, Metadata metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Page<SeasonEntity> seasonPage;
		if (year == null) {
			seasonPage = seasonRepository.findAll(pageReq);
		} else {
			seasonPage = seasonRepository.findAllByYear(Integer.parseInt(year), pageReq);
		}
		List<Season> seasons = seasonPage.map((entity) -> {
			Season season = new Season();
			season.setSeason(entity.getSeason());
			season.setSeasonDbId(entity.getId());
			season.setYear(String.valueOf(entity.getYear()));
			return season;
		}).getContent();

		PagingUtility.calculateMetaData(metaData, seasonPage);
		return seasons;
	}

	public List<StudyType> getStudyTypes(Metadata metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		List<StudyType> studyTypes = studyTypeRepository.findAll(pageReq).map((entity) -> {
			StudyType studyType = new StudyType();
			studyType.setDescription(entity.getDescription());
			studyType.setName(entity.getName());
			return studyType;
		}).getContent();
		metaData.getPagination().setTotalCount((int) studyTypeRepository.count());
		PagingUtility.calculateMetaData(metaData);
		return studyTypes;
	}

	public List<StudySummary> getStudies(String studyType, String studyTypeDbId, String programDbId, String trialDbId, String studyDbId,
			String locationDbId, String seasonDbId, List<String> germplasmDbIds, List<String> observationVariableDbIds,
			Boolean active, String sortBy, String sortOrder, Metadata metaData) {

		return searchStudies(SearchUtility.buildSearchParam(studyType), 
				SearchUtility.buildSearchParam(studyTypeDbId),
				SearchUtility.buildSearchParam(programDbId),
				SearchUtility.buildSearchParam(trialDbId), 
				SearchUtility.buildSearchParam(studyDbId),
				SearchUtility.buildSearchParam(""), 
				SearchUtility.buildSearchParam(""),
				SearchUtility.buildSearchParam(locationDbId),
				SearchUtility.buildSearchParam(seasonDbId), 
				SearchUtility.buildSearchParam(germplasmDbIds),
				SearchUtility.buildSearchParam(observationVariableDbIds), 
				active, SortByEnum.fromValue(sortBy),
				SortOrderEnum.fromValue(sortOrder), metaData);
	}

	public List<StudySummary> getStudies(StudySearchRequest request, Metadata metaData) {
		return searchStudies(SearchUtility.buildSearchParam(request.getStudyTypeDbIds()),
				SearchUtility.buildSearchParam(request.getStudyTypeNames()),
				SearchUtility.buildSearchParam(request.getProgramDbIds()),
				SearchUtility.buildSearchParam(request.getTrialDbIds()),
				SearchUtility.buildSearchParam(request.getStudyDbIds()),
				SearchUtility.buildSearchParam(request.getProgramNames()),
				SearchUtility.buildSearchParam(request.getStudyNames()),
				SearchUtility.buildSearchParam(request.getLocationDbIds()),
				SearchUtility.buildSearchParam(request.getSeasonDbIds()),
				SearchUtility.buildSearchParam(request.getGermplasmDbIds()),
				SearchUtility.buildSearchParam(request.getObservationVariableDbIds()), request.isActive(),
				request.getSortBy(), request.getSortOrder(), metaData);
	}

	private List<StudySummary> searchStudies(List<String> studyTypeDbIds, List<String> studyTypeNames, List<String> programDbIds,
			List<String> trialDbIds, List<String> studyDbIds, List<String> programNames, List<String> studyNames,
			List<String> locationDbIds, List<String> seasonDbIds,
			List<String> germplasmDbIds, List<String> observationVariableDbIds, Boolean active, SortByEnum sortBy,
			SortOrderEnum sortOrder, Metadata metaData) {

		boolean applyActiveFilter = true;
		if (active == null) {
			applyActiveFilter = false;
			active = Boolean.TRUE;
		}
		Pageable pageReq = PagingUtility.getPageRequest(metaData, buildSort(sortOrder, sortBy));
		Page<StudyEntity> studiesPage = studyRepository.findBySearch(studyTypeDbIds, studyTypeNames, programDbIds, trialDbIds, studyDbIds,
				programNames, studyNames, locationDbIds, seasonDbIds, germplasmDbIds,
				observationVariableDbIds, applyActiveFilter, active, pageReq);
		PagingUtility.calculateMetaData(metaData, studiesPage);

		List<StudySummary> summaries = studiesPage.map((entity) -> {
			StudySummary sum = new StudySummary();
			sum.setActive(String.valueOf(entity.isActive()));
			sum.setEndDate(DateUtility.toLocalDate(entity.getEndDate()));
			sum.setLocationDbId(entity.getLocation().getId());
			sum.setLocationName(entity.getLocation().getName());
			sum.setName(entity.getStudyName());
			sum.setProgramDbId(entity.getTrial().getProgram().getId());
			sum.setProgramName(entity.getTrial().getProgram().getName());
			sum.setStartDate(DateUtility.toLocalDate(entity.getStartDate()));
			sum.setStudyDbId(entity.getId());
			sum.setStudyType(entity.getStudyType().getName());
			sum.setTrialDbId(entity.getTrial().getId());
			sum.setTrialName(entity.getTrial().getTrialName());

			sum.setSeasons(entity.getSeasons().stream().map(e -> {
				Season season = new Season();
				season.setSeason(e.getSeason());
				season.setSeasonDbId(e.getId());
				season.setYear(e.getYear().toString());
				return season;
			}).collect(Collectors.toList()));

			sum.setAdditionalInfo(new HashMap<>());
			for (StudyAddtionalInfoEntity e : entity.getAdditionalInfo()) {
				sum.getAdditionalInfo().put(e.getKey(), e.getValue());
			}

			return sum;
		}).getContent();
		return summaries;
	}

	private Sort buildSort(SortOrderEnum sortOrder, SortByEnum sortBy) {
		String sortOrderStr = "asc";
		if (sortOrder != null) {
			switch (sortOrder) {
			case DESC:
				sortOrderStr = "desc";
				break;
			case ASC:
			default:
				sortOrderStr = "asc";
				break;
			}
		}

		String sortByStr = "id";
		if (sortBy != null) {
			switch (sortBy) {
			case GERMPLASMDBID:
				sortByStr = "ou.germplasm.id";
				break;
			case LOCATIONDBID:
				sortByStr = "location.id";
				break;
			case OBSERVATIONVARIABLEDBID:
				sortByStr = "observation.observationVariable.id";
				break;
			case PROGRAMDBID:
				sortByStr = "trial.program.id";
				break;
			case PROGRAMNAME:
				sortByStr = "trial.program.name";
				break;
			case SEASONDBID:
				sortByStr = "season.id";
				break;
			case STUDYDBID:
				sortByStr = "id";
				break;
			case STUDYLOCATION:
				sortByStr = "location.id";
				break;
			case STUDYTYPEDBID:
				sortByStr = "studyType.id";
				break;
			case STUDYTYPENAME:
				sortByStr = "studyType.name";
				break;
			case TRIALDBID:
				sortByStr = "trial.id ";
				break;
			case STUDYNAME:
			default:
				sortByStr = "studyName";
				break;
			}
		}

		Sort sort = Sort.by(Direction.fromString(sortOrderStr), sortByStr);

		return sort;
	}

	public Study getStudy(String studyDbId) {
		Optional<StudyEntity> entityOption = studyRepository.findById(studyDbId);
		Study study = null;
		if (entityOption.isPresent()) {
			StudyEntity entity = entityOption.get();
			study = new Study();

			study.setActive(String.valueOf(entity.isActive()));
			study.setEndDate(DateUtility.toLocalDate(entity.getEndDate()));
			study.setStartDate(DateUtility.toLocalDate(entity.getStartDate()));
			study.setStudyDbId(entity.getId());
			study.setStudyType(entity.getStudyType().getName());
			study.setTrialDbId(entity.getTrial().getId());
			study.setTrialName(entity.getTrial().getTrialName());
			study.setLicense(entity.getLicence());
			study.setLocation(locationService.convertFromEntity(entity.getLocation()));
			study.setStudyDescription(entity.getStudyDescription());
			study.setStudyName(entity.getStudyName());

			study.setLastUpdate(new StudyLastUpdate());
			study.getLastUpdate().setTimestamp(DateUtility.toOffsetDateTime(entity.getTimestamp()));
			study.getLastUpdate().setVersion(entity.getVersion());

			study.setContacts(entity.getContacts().stream().map(this.contactService::convertFromEntity)
					.collect(Collectors.toList()));

			study.setDataLinks(entity.getDataLinks().stream().map(e -> {
				DataLink dataLink = new DataLink();
				dataLink.setName(e.getName());
				dataLink.setType(e.getType());
				dataLink.setUrl(e.getUrl());
				return dataLink;
			}).collect(Collectors.toList()));

			study.setSeasons(entity.getSeasons().stream().map(e -> {
				return e.getSeason() + " " + e.getYear();
			}).collect(Collectors.toList()));

			study.setAdditionalInfo(new HashMap<>());
			for (StudyAddtionalInfoEntity e : entity.getAdditionalInfo()) {
				study.getAdditionalInfo().put(e.getKey(), e.getValue());
			}
		}
		return study;
	}

	public StudyObservationVariablesResponseResult getStudyObservationVariables(String studyDbId) {
		Study study = getStudy(studyDbId);
		StudyObservationVariablesResponseResult wrapper = null;
		if (study != null) {
			wrapper = new StudyObservationVariablesResponseResult();
			wrapper.setData(observationVariableService.getVariablesForStudy(studyDbId));
			wrapper.setStudyDbId(study.getStudyDbId());
			wrapper.setTrialName(study.getTrialName());
		}
		return wrapper;
	}

	public GermplasmSummaryList getStudyGermplasm(String studyDbId, Metadata metaData) {
		Optional<StudyEntity> studyOption = studyRepository.findById(studyDbId);
		GermplasmSummaryList germplasms = null;
		if (studyOption.isPresent()) {
			Pageable pageReq = PagingUtility.getPageRequest(metaData);
			Page<GermplasmEntity> germplasmPage = studyRepository.findGermplasmsByStudy(studyDbId, pageReq);
			List<ObservationUnitEntity> observationUnitsPage = observationUnitRepository.findAllByStudy_Id(studyDbId);
			PagingUtility.calculateMetaData(metaData, germplasmPage);

			Map<String, String> entryMap = buildEntryMap(observationUnitsPage);

			germplasms = new GermplasmSummaryList();
			germplasms.setData(germplasmPage.map((entity) -> {
				GermplasmSummary germplasm = new GermplasmSummary();
				germplasm.setAccessionNumber(entity.getAccessionNumber());
				germplasm.setEntryNumber(entryMap.get(entity.getId()));
				germplasm.setGermplasmDbId(entity.getId());
				germplasm.setGermplasmName(entity.getGermplasmName());
				germplasm.setGermplasmPUI(entity.getGermplasmPUI());
				germplasm.setPedigree(entity.getPedigree().getPedigree());
				germplasm.setSeedSource(entity.getGermplasmSeedSource());
				if (entity.getSynonyms() != null) {
					germplasm.setSynonyms(Arrays.asList(entity.getSynonyms().split(",")));
				}
				return germplasm;
			}).getContent());

			StudyEntity study = studyOption.get();
			germplasms.setStudyDbId(study.getId());
			germplasms.setTrialName(study.getTrial().getTrialName());
		}
		return germplasms;

	}

	private Map<String, String> buildEntryMap(List<ObservationUnitEntity> observationUnitsPage) {
		Map<String, String> entryMap = new HashMap<>();
		for (ObservationUnitEntity obs : observationUnitsPage) {
			entryMap.put(obs.getGermplasm().getId(), obs.getEntryNumber());
		}
		return entryMap;
	}

	public List<String> getObservationLevels(Metadata metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Page<String> levelsPage = observationUnitRepository.findObservationLevels(pageReq);
		PagingUtility.calculateMetaData(metaData, levelsPage);
		return levelsPage.getContent();
	}

	public List<ObservationUnit> getStudyObservations(String studyDbId, String observationLevel,
			Metadata metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Page<ObservationUnitEntity> unitsPage;
		if (observationLevel == null) {
			unitsPage = observationUnitRepository.findAllByStudy_Id(studyDbId, pageReq);
		} else {
			unitsPage = observationUnitRepository.findAllByStudy_IdAndObservationLevel(studyDbId, observationLevel,
					pageReq);
		}
		PagingUtility.calculateMetaData(metaData, unitsPage);
		List<ObservationUnit> observations = unitsPage.map((entity) -> {
			ObservationUnit observation = new ObservationUnit();
			observation.setBlockNumber(entity.getBlockNumber() == null ? "0" : entity.getBlockNumber().toString());
			observation.setEntryNumber(entity.getEntryNumber());
			observation.setEntryType(entity.getEntryType());
			observation.setGermplasmDbId(entity.getGermplasm().getId());
			observation.setGermplasmName(entity.getGermplasm().getGermplasmName());
			observation.setObservationUnitDbId(entity.getId());
			observation.setObservationUnitName(entity.getObservationUnitName());
			observation.setPedigree(entity.getPedigree().getPedigree());
			observation.setPlantNumber(entity.getPlantNumber() == null ? "0" : entity.getPlantNumber().toString());
			observation.setPlotNumber(entity.getPlotNumber() == null ? "0" : entity.getPlotNumber().toString());
			observation.setReplicate(entity.getReplicate());
			observation.setX(entity.getX());
			observation.setY(entity.getY());

			observation.setObservations(entity.getObservations().stream().map(e -> {
				ObservationSummary ob = new ObservationSummary();
				ob.setCollector(e.getCollector());
				ob.setObservationDbId(e.getId());
				ob.setObservationTimeStamp(DateUtility.toOffsetDateTime(e.getObservationTimeStamp()));
				ob.setValue(e.getValue());
				if (e.getObservationVariable() != null) {
					ob.setObservationVariableDbId(e.getObservationVariable().getId());
					ob.setObservationVariableName(e.getObservationVariable().getName());
				}
				return ob;
			}).collect(Collectors.toList()));

			observation.setObservationUnitXref(entity.getObservationUnitXref().stream().map(e -> {
				ObservationUnitXref xref = new ObservationUnitXref();
				xref.setId(e.getXref());
				xref.setSource(e.getSource());
				return xref;
			}).collect(Collectors.toList()));

			return observation;
		}).getContent();

		return observations;
	}

	public void saveObservationUnits(NewObservationsRequestWrapperDeprecated request) {
		for (NewObservationsRequestDeprecatedData unit : request.getResult().getData()) {
			ObservationUnitEntity unitEntity = observationUnitRepository.findById(unit.getObservatioUnitDbId())
					.orElse(new ObservationUnitEntity());
			unitEntity.setObservations(new ArrayList<>());

			for (NewObservationsRequestObservations observation : unit.getObservations()) {
				ObservationEntity observationEntity = convertToEntity(observation);
				unitEntity.getObservations().add(observationEntity);
			}

			observationUnitRepository.save(unitEntity);
		}
	}

	private ObservationEntity convertToEntity(Observation observation) {
		ObservationEntity obe = observationRepository.findById(observation.getObservationDbId())
				.orElse(new ObservationEntity());
		obe.setCollector(observation.getOperator());
		obe.setObservationTimeStamp(DateUtility.toDate(observation.getObservationTimeStamp()));
		obe.setValue(observation.getValue());
		obe.setObservationVariable(
				observationVariableService.getVariableEntity(observation.getObservationVariableDbId()));
		return obe;
	}

	private ObservationEntity convertToEntity(NewObservationsRequestObservations observation) {
		ObservationEntity obe = observationRepository.findById(observation.getObservationDbId())
				.orElse(new ObservationEntity());
		obe.setCollector(observation.getCollector());
		obe.setObservationTimeStamp(DateUtility.toDate(observation.getObservationTimeStamp()));
		obe.setValue(observation.getValue());
		obe.setObservationVariable(
				observationVariableService.getVariableEntity(observation.getObservationVariableDbId()));
		return obe;
	}

	public ObservationsTable getStudyObservationUnitTable(String studyDbId) {
		ObservationsTable tableWrapper = new ObservationsTable();

		tableWrapper.setHeaderRow(buildHeaderRow());

		List<ObservationVariable> variables = observationVariableService.getVariablesForStudy(studyDbId);
		tableWrapper.setObservationVariableDbIds(
				variables.stream().map(e -> e.getObservationVariableDbId()).collect(Collectors.toList()));
		tableWrapper.setObservationVariableNames(variables.stream().map(e -> e.getName()).collect(Collectors.toList()));

		List<ObservationUnitEntity> units = observationUnitRepository.findAllByStudy_Id(studyDbId);
		tableWrapper.setData(buildDataMatrix(units, variables));

		return tableWrapper;
	}

	private List<HeaderRowEnum> buildHeaderRow() {
		return Arrays.asList(HeaderRowEnum.values());
	}

	private List<List<String>> buildDataMatrix(List<ObservationUnitEntity> units, List<ObservationVariable> variables) {
		List<List<String>> data = new ArrayList<>();
		for (ObservationUnitEntity unit : units) {
			List<String> row = new ArrayList<>();
			row.add(unit.getObservations().get(0).getSeason().getYear().toString());
			row.add(unit.getStudy().getId());
			row.add(unit.getStudy().getStudyName());
			row.add(unit.getStudy().getLocation().getId());
			row.add(unit.getStudy().getLocation().getCountryName());
			row.add(unit.getGermplasm().getId());
			row.add(unit.getGermplasm().getGermplasmName());
			row.add(unit.getId());
			row.add(unit.getPlotNumber().toString());
			row.add(unit.getReplicate());
			row.add(unit.getBlockNumber().toString());
			row.add(DateUtility.toTimeString(unit.getObservations().get(0).getObservationTimeStamp()));
			row.add(unit.getEntryType());
			row.add(unit.getX());
			row.add(unit.getY());

			for (ObservationVariable var : variables) {
				Optional<ObservationEntity> obsOption = unit.getObservations().stream().filter((obs) -> {
					return obs.getObservationVariable().getId() == var.getObservationVariableDbId();
				}).findFirst();
				if (obsOption.isPresent()) {
					row.add(obsOption.get().getValue());
				} else {
					row.add("");
				}
			}
			data.add(row);
		}
		return data;
	}

	public List<ObservationUnitPosition> getStudyPlotLayouts(String studyDbId, Metadata metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Page<ObservationUnitEntity> unitsPage = observationUnitRepository.findAllByStudy_Id(studyDbId, pageReq);
		PagingUtility.calculateMetaData(metaData, unitsPage);
		List<ObservationUnitPosition> plots = unitsPage.map(this::convertFromEntity).getContent();
		return plots;
	}

	private ObservationUnitPosition convertFromEntity(ObservationUnitEntity entity) {
		ObservationUnitPosition plot = new ObservationUnitPosition();
		plot.setBlockNumber(entity.getBlockNumber() == null ? null : entity.getBlockNumber().toString());
		plot.setEntryType(EntryTypeEnum.valueOf(entity.getEntryType()));
		plot.setObservationLevel(entity.getObservationLevel());
		plot.setObservationUnitDbId(entity.getId());
		plot.setObservationUnitName(entity.getObservationUnitName());
		plot.setReplicate(entity.getReplicate());
		plot.setStudyDbId(entity.getStudy().getId());
		plot.setX(entity.getX());
		plot.setY(entity.getY());
		plot.setAdditionalInfo(new HashMap<>());

		if(entity.getGermplasm() != null) {
			plot.setGermplasmDbId(entity.getGermplasm().getId());
			plot.setGermplasmName(entity.getGermplasm().getGermplasmName());
		}
		
		return plot;
	}

	public List<Observation> getObservationUnits(String studyDbId, List<String> observationVariableDbIds,
			Metadata metaData) {
		// TODO This call doesnt make sense
		// it is a mix of ObservationUnits and Observations
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Page<ObservationEntity> observationsPage;
		if (observationVariableDbIds == null || observationVariableDbIds.isEmpty()) {
			observationsPage = observationRepository.findAllByObservationUnit_Study_Id(studyDbId, pageReq);
		} else {
			observationsPage = observationRepository.findAllByObservationUnit_Study_IdAndObservationVariable_IdIn(
					studyDbId, observationVariableDbIds, pageReq);
		}
		PagingUtility.calculateMetaData(metaData, observationsPage);
		List<Observation> units = observationsPage.map(entity -> {
			Observation unit = new Observation();
			unit.setGermplasmDbId(entity.getObservationUnit().getGermplasm().getId());
			unit.setGermplasmName(entity.getObservationUnit().getGermplasm().getGermplasmName());
			unit.setObservationDbId(entity.getId());
			unit.setObservationLevel(entity.getObservationUnit().getObservationLevel());
			unit.setObservationTimeStamp(DateUtility.toOffsetDateTime(entity.getObservationTimeStamp()));
			unit.setObservationUnitDbId(entity.getObservationUnit().getId());
			unit.setObservationUnitName(entity.getObservationUnit().getObservationUnitName());
			unit.setObservationVariableDbId(entity.getObservationVariable().getId());
			unit.setObservationVariableName(entity.getObservationVariable().getName());
			unit.setOperator(entity.getObservationUnit().getOperator());
			unit.setStudyDbId(entity.getObservationUnit().getStudy().getId());
			unit.setUploadedBy(entity.getObservationUnit().getUploadedBy());
			unit.setValue(entity.getValue());

			return unit;
		}).getContent();

		return units;
	}

	public NewObservationUnitDbIds saveObservationUnit(@Valid List<NewObservationUnitRequest> request) {
		NewObservationUnitDbIds response = new NewObservationUnitDbIds();
		for (NewObservationUnitRequest unit : request) {
			ObservationUnitEntity unitEntity;
			Optional<ObservationUnitEntity> unitEntityOpt = observationUnitRepository
					.findById(unit.getObservationUnitDbId() == null ? "" : unit.getObservationUnitDbId());
			if (unitEntityOpt.isPresent()) {
				unitEntity = updateEntity(unitEntityOpt.get(), unit);
			} else {
				unitEntity = updateEntity(new ObservationUnitEntity(), unit);
			}

			final ObservationUnitEntity newUnitEntity = observationUnitRepository.save(unitEntity);

			if (unit.getObservationUnitXref() == null) {
				newUnitEntity.setObservationUnitXref(null);
			} else {
				newUnitEntity.setObservationUnitXref(unit.getObservationUnitXref().stream().map((xref) -> {
					ObservationUnitXrefEntity entity = new ObservationUnitXrefEntity();
					entity.setObservationUnitDbId(newUnitEntity.getId());
					entity.setXref(xref.getId());
					entity.setSource(xref.getSource());
					return entity;
				}).collect(Collectors.toList()));
			}

			if (unit.getTreatments() == null) {
				newUnitEntity.setTreatments(null);
			} else {
				newUnitEntity.setTreatments(unit.getTreatments().stream().map((treatment) -> {
					TreatmentEntity entity = new TreatmentEntity();
					entity.setFactor(treatment.getFactor());
					entity.setModality(treatment.getModality());
					entity.setObservationUnitDbId(newUnitEntity.getId());
					return entity;
				}).collect(Collectors.toList()));
			}

			ObservationUnitEntity newNewUnitEntity = observationUnitRepository.save(newUnitEntity);

			if (unit.getObservations() != null) {
				for (Observation observation : unit.getObservations()) {
					ObservationEntity observationEntity = convertToEntity(observation);
					observationEntity.setObservationUnit(newNewUnitEntity);
					observationRepository.save(observationEntity);
				}
			}

			response.addObservationUnitDbIdsItem(newNewUnitEntity.getId());
		}
		return response;
	}

	private ObservationUnitEntity updateEntity(ObservationUnitEntity observationUnitEntity,
			NewObservationUnitRequest unit) {
		observationUnitEntity.setBlockNumber(NumberUtils.toInt(unit.getBlockNumber()));
		observationUnitEntity.setEntryNumber(unit.getEntryNumber());
		observationUnitEntity.setEntryType(unit.getEntryType());
		observationUnitEntity.setObservationLevel(unit.getObservationLevel());
		observationUnitEntity.setObservationUnitName(unit.getObservationUnitName());
		observationUnitEntity.setPlantNumber(NumberUtils.toInt(unit.getPlantNumber()));
		observationUnitEntity.setPlotNumber(NumberUtils.toInt(unit.getPlotNumber()));
		observationUnitEntity.setReplicate(unit.getReplicate());
		observationUnitEntity.setX(unit.getX());
		observationUnitEntity.setY(unit.getY());

		if (unit.getGermplasmDbId() == null) {
			observationUnitEntity.setGermplasm(null);
		} else {
			Optional<GermplasmEntity> germOpt = germplasmRepository.findById(unit.getGermplasmDbId());
			if (germOpt.isPresent()) {
				observationUnitEntity.setGermplasm(germOpt.get());
			}
		}
		if (unit.getStudyDbId() == null) {
			observationUnitEntity.setStudy(null);
		} else {
			Optional<StudyEntity> studyOpt = studyRepository.findById(unit.getStudyDbId());
			if (studyOpt.isPresent()) {
				observationUnitEntity.setStudy(studyOpt.get());
			}
		}

		return observationUnitEntity;
	}

	public NewObservationDbIds saveStudyObservationUnitsTable(String studyDbId,
			@Valid NewObservationsTableRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ObservationUnitPosition> saveStudyPlotLayout(String studyDbId,
			@Valid StudyLayoutRequest studyLayoutRequest) {
		List<ObservationUnitPosition> positions = new ArrayList<>();
		Optional<StudyEntity> studyOpt = studyRepository.findById(studyDbId);
		if (studyOpt.isPresent()) {
			for (StudyLayoutRequestLayout layout : studyLayoutRequest.getLayout()) {
				Optional<ObservationUnitEntity> unitOpt = observationUnitRepository
						.findById(layout.getObservationUnitDbId());
				if (unitOpt.isPresent()) {
					ObservationUnitEntity unit = unitOpt.get();
					unit.setBlockNumber(layout.getBlockNumber());
					unit.setX(layout.getX().toString());
					unit.setY(layout.getY().toString());
					unit.setEntryType(layout.getEntryType().name());
					unit.setReplicate(layout.getReplicate().toString());

					ObservationUnitEntity newUnit = observationUnitRepository.save(unit);
					positions.add(convertFromEntity(newUnit));
				}
			}
		}
		return positions;
	}

	public NewObservationDbIds saveObservations(@Valid NewObservationsRequest newObservations) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getStudyObservationUnitTableText(String studyDbId, String sep) {
		ObservationsTable table = getStudyObservationUnitTable(studyDbId);
		StringBuilder responseBuilder = new StringBuilder();

		for (HeaderRowEnum header : table.getHeaderRow()) {
			responseBuilder.append("\"" + header.toString() + "\"");
			responseBuilder.append(sep);
		}
		int i = 1;
		for (String header : table.getObservationVariableDbIds()) {
			responseBuilder.append("\"" + header + "\"");
			if (i < table.getObservationVariableDbIds().size()) {
				responseBuilder.append(sep);
			}
			i++;
		}
		responseBuilder.append("\n");

		for (List<String> row : table.getData()) {
			int j = 1;
			for (String item : row) {
				responseBuilder.append("\"" + item + "\"");
				if (j < row.size()) {
					responseBuilder.append(sep);
				}
				j++;
			}
			responseBuilder.append("\n");
		}

		return responseBuilder.toString();
	}

	public List<StudySummary> getStudies(@Valid StudySearchRequestDep req, Metadata metaData) {
		StudySearchRequest newRequest = new StudySearchRequest()
				.active(req.isActive())
				.germplasmDbIds(req.getGermplasmDbIds())
				.locationDbIds(req.getLocationDbIds())
				.observationVariableDbIds(req.getObservationVariableDbIds())
				.page(req.getPage())
				.pageSize(req.getPageSize())
				.programDbIds(req.getProgramDbIds())
				.programNames(req.getProgramNames())
				.seasonDbIds(req.getSeasonDbId())
				.studyDbIds(req.getStudyDbIds())
				.studyNames(req.getStudyNames())
				.studyTypeNames(Arrays.asList(req.getStudyType()))
				.trialDbIds(req.getTrialDbIds());

		newRequest.setSortBy(SortByEnum.fromValue(req.getSortBy().toString()));
		newRequest.setSortOrder(SortOrderEnum.fromValue(req.getSortOrder().toString()));
		
		return getStudies(newRequest, metaData);
	}
}
