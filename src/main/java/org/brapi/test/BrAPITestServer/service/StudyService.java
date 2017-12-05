package org.brapi.test.BrAPITestServer.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.model.entity.GermplasmEntity;
import org.brapi.test.BrAPITestServer.model.entity.ObservationEntity;
import org.brapi.test.BrAPITestServer.model.entity.ObservationUnitEntity;
import org.brapi.test.BrAPITestServer.model.entity.StudyAddtionalInfoEntity;
import org.brapi.test.BrAPITestServer.model.entity.StudyEntity;
import org.brapi.test.BrAPITestServer.model.rest.DataLink;
import org.brapi.test.BrAPITestServer.model.rest.EntryType;
import org.brapi.test.BrAPITestServer.model.rest.GermplasmSummary;
import org.brapi.test.BrAPITestServer.model.rest.Observation;
import org.brapi.test.BrAPITestServer.model.rest.ObservationUnit;
import org.brapi.test.BrAPITestServer.model.rest.ObservationUnitXref;
import org.brapi.test.BrAPITestServer.model.rest.ObservationVariable;
import org.brapi.test.BrAPITestServer.model.rest.Season;
import org.brapi.test.BrAPITestServer.model.rest.Study;
import org.brapi.test.BrAPITestServer.model.rest.StudyGermplasm;
import org.brapi.test.BrAPITestServer.model.rest.StudyObservation;
import org.brapi.test.BrAPITestServer.model.rest.StudyObservationUnit;
import org.brapi.test.BrAPITestServer.model.rest.StudyObservationUnitRequest;
import org.brapi.test.BrAPITestServer.model.rest.StudyObservationUnitTable;
import org.brapi.test.BrAPITestServer.model.rest.StudyObservationUnitWrapper;
import org.brapi.test.BrAPITestServer.model.rest.StudyObservationVariable;
import org.brapi.test.BrAPITestServer.model.rest.StudyPlotLayout;
import org.brapi.test.BrAPITestServer.model.rest.StudySearchRequest;
import org.brapi.test.BrAPITestServer.model.rest.StudySummary;
import org.brapi.test.BrAPITestServer.model.rest.StudyType;
import org.brapi.test.BrAPITestServer.model.rest.Update;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
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

	public List<Season> getSeasons(int year, MetaData metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		List<Season> seasons = seasonRepository.findAllByYear(year, pageReq).map((entity) -> {
			Season season = new Season();
			season.setSeason(entity.getSeason());
			season.setSeasonDbId(entity.getId());
			season.setYear(entity.getYear());
			return season;
		}).getContent();
		metaData.getPagination().setTotalCount((int) seasonRepository.countByYear(year));
		PagingUtility.calculateMetaData(metaData);
		return seasons;
	}

	public List<StudyType> getStudyTypes(MetaData metaData) {
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

	public List<StudySummary> getStudies(String studyType, String programDbId, String locationDbId, String seasonDbId,
			List<String> germplasmDbIds, List<String> observationVariableDbIds, boolean active, String sortBy,
			String sortOrder, MetaData metaData) {

		return searchStudies(buildSearchParam(studyType), buildSearchParam(programDbId), buildSearchParam(null),
				buildSearchParam(null), buildSearchParam(null), buildSearchParam(locationDbId),
				buildSearchParam(seasonDbId), buildSearchParamList(germplasmDbIds),
				buildSearchParamList(observationVariableDbIds), active, sortBy, sortOrder, metaData);
	}

	private List<String> buildSearchParam(String param) {
		List<String> paramList = new ArrayList<>();
		if (param == null) {
			paramList.add("");
		} else {
			paramList.add(param);
		}
		return paramList;
	}

	private List<String> buildSearchParamList(List<String> params) {
		List<String> paramList = new ArrayList<>();
		if (params == null || params.isEmpty()) {
			paramList.add("");
		} else {
			paramList = params;
		}
		return paramList;
	}

	public List<StudySummary> getStudies(StudySearchRequest request, MetaData metaData) {
		return searchStudies(buildSearchParam(request.getStudyType()), buildSearchParamList(null),
				buildSearchParamList(request.getProgramNames()), buildSearchParamList(request.getStudyNames()),
				buildSearchParamList(request.getStudyLocations()), buildSearchParamList(null),
				buildSearchParamList(null), buildSearchParamList(request.getGermplasmDbIds()),
				buildSearchParamList(request.getObservationVariableDbIds()), request.isActive(), request.getSortBy(),
				request.getSortOrder(), metaData);
	}

	private List<StudySummary> searchStudies(List<String> studyTypes, List<String> programDbIds,
			List<String> programNames, List<String> studyNames, List<String> studyLocations, List<String> locationDbIds,
			List<String> seasonDbIds, List<String> germplasmDbIds, List<String> observationVariableDbIds,
			boolean active, String sortBy, String sortOrder, MetaData metaData) {
		Sort sort = Sort.by(Direction.fromString(sortOrder), sortBy);
		Pageable pageReq = PagingUtility.getPageRequest(metaData, sort);
		List<StudySummary> summaries = studyRepository.findBySearch(studyTypes, programDbIds, programNames, studyNames,
				studyLocations, locationDbIds, seasonDbIds, germplasmDbIds, observationVariableDbIds, active, pageReq)
				.map((entity) -> {
					StudySummary sum = new StudySummary();
					sum.setActive(entity.isActive());
					sum.setEndDate(entity.getEndDate());
					sum.setLocationDbId(entity.getLocation().getId());
					sum.setLocationName(entity.getLocation().getName());
					sum.setName(entity.getStudyName());
					sum.setProgramDbId(entity.getTrial().getProgram().getId());
					sum.setProgramName(entity.getTrial().getProgram().getName());
					sum.setStartDate(entity.getStartDate());
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

			study.setActive(entity.isActive());
			study.setEndDate(entity.getEndDate());
			study.setStartDate(entity.getStartDate());
			study.setStudyDbId(entity.getId());
			study.setStudyType(entity.getStudyType().getName());
			study.setTrialDbId(entity.getTrial().getId());
			study.setTrialName(entity.getTrial().getTrialName());
			study.setLicense(entity.getLicence());
			study.setLocation(locationService.convertFromEntity(entity.getLocation()));
			study.setStudyDescription(entity.getStudyDescription());
			study.setStudyName(entity.getStudyName());

			study.setLastUpdate(new Update());
			study.getLastUpdate().setTimestamp(entity.getTimestamp());
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

	public StudyObservationVariable getStudyObservationVariables(String studyDbId) {
		StudyObservationVariable wrapper = new StudyObservationVariable();
		wrapper.setData(observationVariableService.getVariablesForStudy(studyDbId));
		Study study = getStudy(studyDbId);
		wrapper.setStudyDbId(study.getStudyDbId());
		wrapper.setTrialName(study.getTrialName());
		return wrapper;
	}

	public StudyGermplasm getStudyGermplasm(String studyDbId, MetaData metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Page<GermplasmEntity> germplasmPage = studyRepository.findGermplasmsByStudy(studyDbId, pageReq);
		PagingUtility.calculateMetaData(metaData, germplasmPage);

		StudyGermplasm germplasms = new StudyGermplasm();
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
		StudyEntity study = studyRepository.findById(studyDbId).orElse(new StudyEntity());
		germplasms.setStudyDbId(study.getId());
		germplasms.setTrialName(study.getTrial().getTrialName());

		// TODO use Page.getTotalCount() instead of extra query

		return germplasms;
	}

	public List<String> getObservationLevels(MetaData metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Page<String> levelsPage = observationUnitRepository.findObservationLevels(pageReq);
		PagingUtility.calculateMetaData(metaData, levelsPage);
		return levelsPage.getContent();
	}

	public List<StudyObservation> getStudyObservations(String studyDbId, String observationLevel, MetaData metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Page<ObservationUnitEntity> unitsPage = observationUnitRepository
				.findAllByStudy_IdAndObservationLevel(studyDbId, observationLevel, pageReq);
		PagingUtility.calculateMetaData(metaData, unitsPage);
		List<StudyObservation> observations = unitsPage.map((entity) -> {
			StudyObservation observation = new StudyObservation();
			observation.setBlockNumber(entity.getBlockNumber());
			observation.setEntryNumber(entity.getEntryNumber());
			observation.setEntryType(entity.getEntryType());
			observation.setGermplasmDbId(entity.getGermplasm().getId());
			observation.setGermplasmName(entity.getGermplasm().getGermplasmName());
			observation.setObservationUnitDbId(entity.getId());
			observation.setObservationUnitName(entity.getObservationUnitName());
			observation.setPedigree(entity.getPedigree().getPedigree());
			observation.setPlantNumber(entity.getPlantNumber());
			observation.setPlotNumber(entity.getPlotNumber());
			observation.setReplicate(entity.getReplicate());
			observation.setX(entity.getX());
			observation.setY(entity.getY());

			observation.setObservations(entity.getObservations().stream().map(e -> {
				Observation ob = new Observation();
				ob.setCollector(e.getCollector());
				ob.setObservationDbId(e.getId());
				ob.setObservationTimeStamp(e.getObservationTimeStamp());
				ob.setObservationVariableDbId(e.getObservationVariable().getId());
				ob.setObservationVariableName(e.getObservationVariable().getName());
				ob.setSeason(e.getSeason().getSeason() + " " + e.getSeason().getYear());
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

	public void saveObservationUnits(StudyObservationUnitRequest request) {
		for (StudyObservationUnit unit : request.getResults().getData()) {
			ObservationUnitEntity unitEntity = observationUnitRepository.findById(unit.getObservatioUnitDbId())
					.orElse(new ObservationUnitEntity());
			unitEntity.setObservations(new ArrayList<>());

			for (Observation observation : unit.getObservations()) {
				ObservationEntity observationEntity = convertToEntity(observation);
				unitEntity.getObservations().add(observationEntity);
			}

			observationUnitRepository.save(unitEntity);
		}
	}

	private ObservationEntity convertToEntity(Observation observation) {
		ObservationEntity obe = observationRepository.findById(observation.getObservationDbId())
				.orElse(new ObservationEntity());
		obe.setCollector(observation.getCollector());
		obe.setObservationTimeStamp(observation.getObservationTimeStamp());
		obe.setValue(observation.getValue());
		obe.setObservationVariable(
				observationVariableService.getVariableEntity(observation.getObservationVariableDbId()));
		// TODO high probability this wont work
		obe.setSeason(seasonRepository.findById(observation.getSeason()).get());
		return obe;
	}

	public StudyObservationUnitTable getStudyObservationUnitTable(String studyDbId, String format) {
		StudyObservationUnitTable tableWrapper = new StudyObservationUnitTable();
		tableWrapper.setHeaderRow(buildHeaderRow());
		List<ObservationVariable> variables = observationVariableService.getVariablesForStudy(studyDbId);
		tableWrapper.setObservationVariableDbIds(variables.stream().map(e -> e.getObservationVariableDbId()).collect(Collectors.toList()));
		tableWrapper.setObservationVariableNames(variables.stream().map(e -> e.getName()).collect(Collectors.toList()));
		List<ObservationUnitEntity> units = observationUnitRepository.findAllByStudy_Id(studyDbId);
		tableWrapper.setData(buildDataMatrix(units));

		return tableWrapper;
	}

	private List<String> buildHeaderRow() {
		String[] headerRow = { "year", "studyDbId", "studyName", "locationDbId", "locationName", "germplasmDbId",
				"germplasmName", "observationUnitDbId", "plotNumber", "replicate", "blockNumber",
				"observationTimestamp", "entryType", "X", "Y" };
		return Arrays.asList(headerRow);
	}

	private List<List<Object>> buildDataMatrix(List<ObservationUnitEntity> units) {
		List<List<Object>> data = new ArrayList<>();
		for(ObservationUnitEntity unit: units) {
			for(ObservationEntity observation: unit.getObservations()) {
				List<Object> row = new ArrayList<>();
				row.add(observation.getSeason().getYear());
				row.add(unit.getStudy().getId());
				row.add(unit.getStudy().getStudyName());
				row.add(unit.getStudy().getLocation().getCountryName());
				row.add(unit.getGermplasm().getId());
				row.add(unit.getGermplasm().getGermplasmName());
				row.add(unit.getId());
				row.add(unit.getPlotNumber());
				row.add(unit.getReplicate());
				row.add(unit.getBlockNumber());
				row.add(observation.getObservationTimeStamp());
				row.add(unit.getEntryType());
				row.add(unit.getX());
				row.add(unit.getY());
				
				data.add(row);
			}
		}
		return data;
	}

	public void saveStudyObservationUnitTable(StudyObservationUnitTable studyObservationUnitTable) {
		StudyObservationUnitRequest request = new StudyObservationUnitRequest();
		request.setResults(new StudyObservationUnitWrapper());
		request.getResults().setData(buildObservationUnits(studyObservationUnitTable));
		saveObservationUnits(request);
	}

	private List<StudyObservationUnit> buildObservationUnits(StudyObservationUnitTable studyObservationUnitTable) {
		Map<String, StudyObservationUnit> unitsMap = new HashMap<>();
		for(List<Object> row : studyObservationUnitTable.getData()) {
			String observatioUnitDbId = (String) row.get(0);
			String collector = (String) row.get(1);
			Date observationTimeStamp = DateUtility.convertStringToDate((String) row.get(2));
			
			StudyObservationUnit unit;
			if(unitsMap.containsKey(observatioUnitDbId)) {
				unit = unitsMap.get(observatioUnitDbId);
			}else {
			    unit = new StudyObservationUnit();
			    unit.setObservatioUnitDbId(observatioUnitDbId);
			    unitsMap.put(observatioUnitDbId, unit);
			    unit.setObservations(new ArrayList<>());
			}
			
			for(int i = 3; i < row.size(); i++) {
				Observation observation = new Observation();
				observation.setCollector(collector);
				observation.setObservationTimeStamp(observationTimeStamp);
				observation.setObservationVariableDbId(studyObservationUnitTable.getHeaderRow().get(i));
				observation.setValue((String) row.get(i));
				unit.getObservations().add(observation);
			}
		}
		return new ArrayList<>(unitsMap.values());
	}

	public List<StudyPlotLayout> getStudyPlotLayouts(String studyDbId, MetaData metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Page<ObservationUnitEntity> unitsPage = observationUnitRepository.findAllByStudy_Id(studyDbId, pageReq);
		PagingUtility.calculateMetaData(metaData, unitsPage);
		List<StudyPlotLayout> plots = unitsPage.map(entity -> {
			StudyPlotLayout plot = new StudyPlotLayout();
			plot.setBlockNumber(entity.getBlockNumber());
			plot.setEntryType(EntryType.valueOf(entity.getEntryType()));
			plot.setGermplasmDbId(entity.getGermplasm().getId());
			plot.setGermplasmName(entity.getGermplasm().getGermplasmName());
			plot.setObservationLevel(entity.getObservationLevel());
			plot.setObservationUnitDbId(entity.getId());
			plot.setObservationUnitName(entity.getObservationUnitName());
			plot.setReplicate(entity.getReplicate());
			plot.setStudyDbId(entity.getStudy().getId());
			plot.setX(entity.getX());
			plot.setY(entity.getY());

			// TODO not sure where to get this additional info
			plot.setAdditionalInfo(null);
			return plot;
		}).getContent();
		return plots;
	}

	public List<ObservationUnit> getObservationUnits(String studyDbId, List<String> observationVariableDbIds,
			MetaData metaData) {
		// TODO This call doesnt make sense
		// it is a mix of ObservationUnits and Observations
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Page<ObservationEntity> observationsPage = observationRepository
				.findAllByObservationUnit_Study_IdAndObservationVariable_IdIn(studyDbId, observationVariableDbIds,
						pageReq);
		PagingUtility.calculateMetaData(metaData, observationsPage);
		List<ObservationUnit> units = observationsPage.map(entity -> {
			ObservationUnit unit = new ObservationUnit();
			unit.setGermplasmDbId(entity.getObservationUnit().getGermplasm().getId());
			unit.setGermplasmName(entity.getObservationUnit().getGermplasm().getGermplasmName());
			unit.setObserationDbId(entity.getId());
			unit.setObservationLevel(entity.getObservationUnit().getObservationLevel());
			unit.setObservationTimestamp(entity.getObservationTimeStamp());
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

}
