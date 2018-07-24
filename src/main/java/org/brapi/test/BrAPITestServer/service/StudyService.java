package org.brapi.test.BrAPITestServer.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.model.entity.GermplasmEntity;
import org.brapi.test.BrAPITestServer.model.entity.ObservationEntity;
import org.brapi.test.BrAPITestServer.model.entity.ObservationUnitEntity;
import org.brapi.test.BrAPITestServer.model.entity.SeasonEntity;
import org.brapi.test.BrAPITestServer.model.entity.StudyAddtionalInfoEntity;
import org.brapi.test.BrAPITestServer.model.entity.StudyEntity;
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
import io.swagger.model.ObservationUnitPosition;
import io.swagger.model.ObservationUnitStudy;
import io.swagger.model.ObservationUnitXref;
import io.swagger.model.ObservationVariable;
import io.swagger.model.ObservationsTable;
import io.swagger.model.ObservationUnitPosition.EntryTypeEnum;
import io.swagger.model.Season;
import io.swagger.model.Study;
import io.swagger.model.StudyLastUpdate;
import io.swagger.model.StudyLayoutRequest;
import io.swagger.model.StudyObservationVariablesResponseResult;
import io.swagger.model.StudySearchRequest;
import io.swagger.model.StudySummary;
import io.swagger.model.StudyType;
import io.swagger.model.StudySearchRequest.SortByEnum;
import io.swagger.model.StudySearchRequest.SortOrderEnum;

@Service
public class StudyService {
	private SeasonRepository seasonRepository;
	private StudyTypeRepository studyTypeRepository;
	private StudyRepository studyRepository;
	private ObservationUnitRepository observationUnitRepository;
	private ObservationRepository observationRepository;
	private ObservationVariableService observationVariableService;
	private LocationService locationService;
	private ContactService contactService;

	@Autowired
	public StudyService(SeasonRepository seasonRepository, StudyTypeRepository studyTypeRepository,
			StudyRepository studyRepository, ObservationUnitRepository observationUnitRepository,
			ObservationRepository observationRepository, ObservationVariableService observationVariableService,
			LocationService locationService, ContactService contactService) {
		this.seasonRepository = seasonRepository;
		this.studyTypeRepository = studyTypeRepository;
		this.studyRepository = studyRepository;
		this.observationUnitRepository = observationUnitRepository;
		this.observationRepository = observationRepository;

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

	public List<StudySummary> getStudies(String studyType, String programDbId, String trialDbId, String studyDbId,
			String locationDbId, String seasonDbId, List<String> germplasmDbIds, List<String> observationVariableDbIds,
			Boolean active, String sortBy, String sortOrder, Metadata metaData) {

		return searchStudies(SearchUtility.buildSearchParam(studyType),
				SearchUtility.buildSearchParam(programDbId),
				SearchUtility.buildSearchParam(trialDbId), 
				SearchUtility.buildSearchParam(studyDbId),
				SearchUtility.buildSearchParam(""), 
				SearchUtility.buildSearchParam(""),
				SearchUtility.buildSearchParam(""), 
				SearchUtility.buildSearchParam(locationDbId),
				SearchUtility.buildSearchParam(seasonDbId), 
				SearchUtility.buildSearchParam(germplasmDbIds),
				SearchUtility.buildSearchParam(observationVariableDbIds), 
				active, SortByEnum.fromValue(sortBy), SortOrderEnum.fromValue(sortOrder), metaData);
	}

	public List<StudySummary> getStudies(StudySearchRequest request, Metadata metaData) {
		return searchStudies(SearchUtility.buildSearchParam(request.getStudyType()),
				SearchUtility.buildSearchParam(request.getProgramDbIds()),
				SearchUtility.buildSearchParam(request.getTrialDbIds()),
				SearchUtility.buildSearchParam(request.getStudyDbIds()),
				SearchUtility.buildSearchParam(request.getProgramNames()),
				SearchUtility.buildSearchParam(request.getStudyNames()),
				SearchUtility.buildSearchParam(request.getStudyLocations()),
				SearchUtility.buildSearchParam(request.getLocationDbIds()),
				SearchUtility.buildSearchParam(request.getSeasonDbId()),
				SearchUtility.buildSearchParam(request.getGermplasmDbIds()),
				SearchUtility.buildSearchParam(request.getObservationVariableDbIds()), 
				request.isActive(), request.getSortBy(), request.getSortOrder(), metaData);
	}

	private List<StudySummary> searchStudies(List<String> studyTypes, 
			List<String> programDbIds,
			List<String> trialDbIds, 
			List<String> studyDbIds, 
			List<String> programNames, 
			List<String> studyNames,
			List<String> studyLocations, 
			List<String> locationDbIds, 
			List<String> seasonDbIds,
			List<String> germplasmDbIds, 
			List<String> observationVariableDbIds, 
			Boolean active, SortByEnum sortBy, SortOrderEnum sortOrder, Metadata metaData) {

		boolean applyActiveFilter = true;
		if(active == null) {
			applyActiveFilter = false;
			active = Boolean.TRUE;
		}
		sortOrder = sortOrder == null ? SortOrderEnum.ASC : sortOrder;
		sortBy = sortBy == null ? SortByEnum.STUDYNAME : sortBy;
		Sort sort = Sort.by(Direction.fromString(sortOrder.toString()), sortBy.toString());
		Pageable pageReq = PagingUtility.getPageRequest(metaData, sort);
		Page<StudyEntity> studiesPage = studyRepository.findBySearch(studyTypes, programDbIds, trialDbIds, studyDbIds,
				programNames, studyNames, studyLocations, locationDbIds, seasonDbIds, germplasmDbIds,
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
				return e.getSeason() + " " + e.getYear();
			}).collect(Collectors.toList()));

			sum.setAdditionalInfo(new HashMap<>());
			for (StudyAddtionalInfoEntity e : entity.getAdditionalInfo()) {
				sum.getAdditionalInfo().put(e.getKey(), e.getValue());
			}

			return sum;
		}).getContent();
		return summaries;
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
			PagingUtility.calculateMetaData(metaData, germplasmPage);

			germplasms = new GermplasmSummaryList();
			germplasms.setData(germplasmPage.map((entity) -> {
				GermplasmSummary germplasm = new GermplasmSummary();
				germplasm.setAccessionNumber(entity.getAccessionNumber());
				// TODO unknown data
				// germplasm.setEntryNumber(entity.get);
				germplasm.setGermplasmDbId(entity.getId());
				germplasm.setGermplasmName(entity.getGermplasmName());
				germplasm.setGermplasmPUI(entity.getGermplasmPUI());
				germplasm.setPedigree(entity.getPedigree().getPedigree());
				germplasm.setSeedSource(entity.getGermplasmSeedSource());
				return germplasm;
			}).getContent());

			StudyEntity study = studyOption.get();
			germplasms.setStudyDbId(study.getId());
			germplasms.setTrialName(study.getTrial().getTrialName());
		}
		return germplasms;

	}

	public List<String> getObservationLevels(Metadata metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Page<String> levelsPage = observationUnitRepository.findObservationLevels(pageReq);
		PagingUtility.calculateMetaData(metaData, levelsPage);
		return levelsPage.getContent();
	}

	public List<ObservationUnitStudy> getStudyObservations(String studyDbId, String observationLevel, Metadata metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Page<ObservationUnitEntity> unitsPage;
		if (observationLevel == null) {
			unitsPage = observationUnitRepository.findAllByStudy_Id(studyDbId, pageReq);
		} else {
			unitsPage = observationUnitRepository.findAllByStudy_IdAndObservationLevel(studyDbId, observationLevel,
					pageReq);
		}
		PagingUtility.calculateMetaData(metaData, unitsPage);
		List<ObservationUnitStudy> observations = unitsPage.map((entity) -> {
			ObservationUnitStudy observation = new ObservationUnitStudy();
			observation.setBlockNumber(entity.getBlockNumber() == null ? null : entity.getBlockNumber().toString());
			observation.setEntryNumber(entity.getEntryNumber());
			observation.setEntryType(entity.getEntryType());
			observation.setGermplasmDbId(entity.getGermplasm().getId());
			observation.setGermplasmName(entity.getGermplasm().getGermplasmName());
			observation.setObservationUnitDbId(entity.getId());
			observation.setObservationUnitName(entity.getObservationUnitName());
			observation.setPedigree(entity.getPedigree().getPedigree());
			observation.setPlantNumber(entity.getPlantNumber() == null ? null : entity.getPlantNumber().toString());
			observation.setPlotNumber(entity.getPlotNumber() == null ? null : entity.getPlotNumber().toString());
			observation.setReplicate(entity.getReplicate());
			observation.setX(entity.getX());
			observation.setY(entity.getY());

			observation.setObservations(entity.getObservations().stream().map(e -> {
				ObservationSummary ob = new ObservationSummary();
				ob.setCollector(e.getCollector());
				ob.setObservationDbId(e.getId());
				ob.setObservationTimeStamp(DateUtility.toOffsetDateTime(e.getObservationTimeStamp()));
				ob.setObservationVariableDbId(e.getObservationVariable().getId());
				ob.setObservationVariableName(e.getObservationVariable().getName());
				ob.setValue(e.getValue());
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

	public ObservationsTable getStudyObservationUnitTable(String studyDbId, String format) {
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

	private List<String> buildHeaderRow() {
		String[] headerRow = { "year", "studyDbId", "studyName", "locationDbId", "locationName", "germplasmDbId",
				"germplasmName", "observationUnitDbId", "plotNumber", "replicate", "blockNumber",
				"observationTimestamp", "entryType", "X", "Y" };
		return Arrays.asList(headerRow);
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

			for(ObservationVariable var : variables) {
				Optional<ObservationEntity> obsOption = unit.getObservations().stream()
						.filter((obs) -> {
							return obs.getObservationVariable().getId() == var.getObservationVariableDbId();
						}).findFirst();
				if(obsOption.isPresent()) {
					row.add(obsOption.get().getValue());
				}else {
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
		List<ObservationUnitPosition> plots = unitsPage.map(entity -> {
			ObservationUnitPosition plot = new ObservationUnitPosition();
			plot.setBlockNumber(entity.getBlockNumber() == null ? null : entity.getBlockNumber().toString());
			plot.setEntryType(EntryTypeEnum.valueOf(entity.getEntryType()));
			plot.setGermplasmDbId(entity.getGermplasm().getId());
			plot.setGermplasmName(entity.getGermplasm().getGermplasmName());
			plot.setObservationLevel(entity.getObservationLevel());
			plot.setObservationUnitDbId(entity.getId());
			plot.setObservationUnitName(entity.getObservationUnitName());
			plot.setReplicate(entity.getReplicate());
			plot.setStudyDbId(entity.getStudy().getId());
			plot.setX(entity.getX());
			plot.setY(entity.getY());
			plot.setAdditionalInfo(new HashMap<>());
			return plot;
		}).getContent();
		return plots;
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
			ObservationUnitEntity unitEntity = observationUnitRepository.findById(unit.getObservationUnitDbId())
					.orElse(new ObservationUnitEntity());
			unitEntity.setObservations(new ArrayList<>());

			for (Observation observation : unit.getObservations()) {
				ObservationEntity observationEntity = convertToEntity(observation);
				unitEntity.getObservations().add(observationEntity);
			}

			ObservationUnitEntity storedEntity = observationUnitRepository.save(unitEntity);

			response.addObservationUnitDbIdsItem(storedEntity.getId());
		}
		return response;
	}

	public NewObservationDbIds saveStudyObservationUnitsTable(String studyDbId,
			@Valid NewObservationsTableRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ObservationUnitPosition> saveStudyPlotLayout(String studyDbId,
			@Valid StudyLayoutRequest studyLayoutRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	public NewObservationDbIds saveObservations(@Valid NewObservationsRequest newObservations) {
		// TODO Auto-generated method stub
		return null;
	}

}
