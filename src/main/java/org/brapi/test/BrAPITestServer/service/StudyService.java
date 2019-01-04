package org.brapi.test.BrAPITestServer.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.commons.lang3.math.NumberUtils;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.GermplasmEntity;
import org.brapi.test.BrAPITestServer.model.entity.ObservationEntity;
import org.brapi.test.BrAPITestServer.model.entity.ObservationUnitEntity;
import org.brapi.test.BrAPITestServer.model.entity.ObservationUnitXrefEntity;
import org.brapi.test.BrAPITestServer.model.entity.ObservationVariableEntity;
import org.brapi.test.BrAPITestServer.model.entity.SeasonEntity;
import org.brapi.test.BrAPITestServer.model.entity.StudyAddtionalInfoEntity;
import org.brapi.test.BrAPITestServer.model.entity.StudyEntity;
import org.brapi.test.BrAPITestServer.model.entity.StudyTypeEntity;
import org.brapi.test.BrAPITestServer.model.entity.TreatmentEntity;
import org.brapi.test.BrAPITestServer.repository.GermplasmRepository;
import org.brapi.test.BrAPITestServer.repository.ObservationRepository;
import org.brapi.test.BrAPITestServer.repository.ObservationUnitRepository;
import org.brapi.test.BrAPITestServer.repository.ObservationVariableRepository;
import org.brapi.test.BrAPITestServer.repository.SeasonRepository;
import org.brapi.test.BrAPITestServer.repository.StudyRepository;
import org.brapi.test.BrAPITestServer.repository.StudyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.swagger.model.DataLink;
import io.swagger.model.GermplasmSummaryList;
import io.swagger.model.Metadata;
import io.swagger.model.NewObservationDbIds;
import io.swagger.model.NewObservationDbIdsObservations;
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
	private ObservationVariableRepository observationVariableRepository;
	private GermplasmRepository germplasmRepository;

	private ObservationVariableService observationVariableService;
	private LocationService locationService;
	private SearchService searchService;
	private GermplasmService germplasmService;
	private ContactService contactService;

	@Autowired
	public StudyService(SeasonRepository seasonRepository, StudyTypeRepository studyTypeRepository,
			StudyRepository studyRepository, ObservationUnitRepository observationUnitRepository,
			ObservationRepository observationRepository, GermplasmRepository germplasmRepository,
			ObservationVariableService observationVariableService, LocationService locationService,
			ContactService contactService, SearchService searchService, GermplasmService germplasmService,
			ObservationVariableRepository observationVariableRepository) {
		this.seasonRepository = seasonRepository;
		this.studyTypeRepository = studyTypeRepository;
		this.studyRepository = studyRepository;
		this.observationUnitRepository = observationUnitRepository;
		this.observationRepository = observationRepository;
		this.germplasmRepository = germplasmRepository;
		this.observationVariableRepository = observationVariableRepository;

		this.observationVariableService = observationVariableService;
		this.locationService = locationService;
		this.contactService = contactService;
		this.searchService = searchService;
		this.germplasmService = germplasmService;
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

	private Map<String, String> buildEntryMap(List<ObservationUnitEntity> observationUnitsPage) {
		Map<String, String> entryMap = new HashMap<>();
		for (ObservationUnitEntity obs : observationUnitsPage) {
			if (obs.getGermplasm() != null)
				entryMap.put(obs.getGermplasm().getId(), obs.getEntryNumber());
		}
		return entryMap;
	}

	private List<HeaderRowEnum> buildHeaderRow() {
		return Arrays.asList(HeaderRowEnum.values());
	}

	private Observation convertFromEntity(ObservationEntity entity) {
		Observation unit = new Observation();
		unit.setGermplasmDbId(entity.getObservationUnit().getGermplasm().getId());
		unit.setGermplasmName(entity.getObservationUnit().getGermplasm().getGermplasmName());
		unit.setObservationDbId(entity.getId());
		unit.setObservationLevel(entity.getObservationUnit().getObservationLevel());
		unit.setObservationTimeStamp(DateUtility.toOffsetDateTime(entity.getObservationTimeStamp()));
		unit.setObservationUnitDbId(entity.getObservationUnit().getId());
		unit.setObservationUnitName(entity.getObservationUnit().getObservationUnitName());
		if (entity.getObservationVariable() != null) {
			unit.setObservationVariableDbId(entity.getObservationVariable().getId());
			unit.setObservationVariableName(entity.getObservationVariable().getName());
		}
		unit.setOperator(entity.getObservationUnit().getOperator());
		unit.setStudyDbId(entity.getObservationUnit().getStudy().getId());
		unit.setSeason(convertFromEntity(entity.getSeason()));
		unit.setUploadedBy(entity.getObservationUnit().getUploadedBy());
		unit.setValue(entity.getValue());

		return unit;
	}

	private ObservationUnit convertFromEntity(ObservationUnitEntity entity) {
		ObservationUnit observation = new ObservationUnit();
		observation.setBlockNumber(entity.getBlockNumber() == null ? "0" : entity.getBlockNumber().toString());
		observation.setEntryNumber(entity.getEntryNumber());
		observation.setEntryType(entity.getEntryType());
		if (entity.getGermplasm() != null) {
			observation.setGermplasmDbId(entity.getGermplasm().getId());
			observation.setGermplasmName(entity.getGermplasm().getGermplasmName());
		}
		observation.setObservationUnitDbId(entity.getId());
		observation.setObservationUnitName(entity.getObservationUnitName());
		if (entity.getPedigree() != null)
			observation.setPedigree(entity.getPedigree().getPedigree());
		observation.setPlantNumber(entity.getPlantNumber() == null ? "0" : entity.getPlantNumber().toString());
		observation.setPlotNumber(entity.getPlotNumber() == null ? "0" : entity.getPlotNumber().toString());
		observation.setReplicate(entity.getReplicate());
		observation.setX(entity.getX());
		observation.setY(entity.getY());

		observation.setObservations(
				entity.getObservations().stream().map(this::convertFromEntityToSummary).collect(Collectors.toList()));

		observation.setObservationUnitXref(entity.getObservationUnitXref().stream().map(e -> {
			ObservationUnitXref xref = new ObservationUnitXref();
			xref.setId(e.getXref());
			xref.setSource(e.getSource());
			return xref;
		}).collect(Collectors.toList()));

		return observation;

	}

	private Season convertFromEntity(SeasonEntity entity) {
		Season season = new Season();
		if (entity != null) {
			season.setSeason(entity.getSeason());
			season.setSeasonDbId(entity.getId());
			season.setYear(entity.getYear().toString());
		}
		return season;
	}

	private Study convertFromEntity(StudyEntity entity) {
		Study study = new Study();

		study.setActive(String.valueOf(entity.isActive()));
		study.setCommonCropName(entity.getTrial().getProgram().getCrop().getCropName());
		study.setDocumentationURL(entity.getDocumentationURL());
		study.setEndDate(DateUtility.toLocalDate(entity.getEndDate()));
		study.setStartDate(DateUtility.toLocalDate(entity.getStartDate()));
		study.setStudyDbId(entity.getId());
		study.setStudyType(entity.getStudyType().getName());
		study.setStudyTypeName(entity.getStudyType().getName());
		study.setStudyTypeDbId(entity.getStudyType().getId());
		study.setTrialDbId(entity.getTrial().getId());
		study.setTrialName(entity.getTrial().getTrialName());
		study.setLicense(entity.getLicence());
		study.setLocation(locationService.convertFromEntity(entity.getLocation()));
		study.setStudyDescription(entity.getStudyDescription());
		study.setStudyName(entity.getStudyName());

		study.setLastUpdate(new StudyLastUpdate());
		study.getLastUpdate().setTimestamp(DateUtility.toOffsetDateTime(entity.getTimestamp()));
		study.getLastUpdate().setVersion(entity.getVersion());

		study.setContacts(
				entity.getContacts().stream().map(this.contactService::convertFromEntity).collect(Collectors.toList()));

		study.setDataLinks(entity.getDataLinks().stream().map(e -> {
			DataLink dataLink = new DataLink();
			dataLink.setName(e.getName());
			dataLink.setDataLinkName(e.getName());
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
		return study;
	}

	private ObservationUnitPosition convertFromEntityToPosition(ObservationUnitEntity entity) {
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

		if (entity.getGermplasm() != null) {
			plot.setGermplasmDbId(entity.getGermplasm().getId());
			plot.setGermplasmName(entity.getGermplasm().getGermplasmName());
		}

		return plot;
	}

	private ObservationSummary convertFromEntityToSummary(ObservationEntity entity) {
		ObservationSummary ob = new ObservationSummary();
		ob.setCollector(entity.getCollector());
		ob.setObservationDbId(entity.getId());
		ob.setObservationTimeStamp(DateUtility.toOffsetDateTime(entity.getObservationTimeStamp()));
		ob.setSeason(convertFromEntity(entity.getSeason()));
		ob.setValue(entity.getValue());
		if (entity.getObservationVariable() != null) {
			ob.setObservationVariableDbId(entity.getObservationVariable().getId());
			ob.setObservationVariableName(entity.getObservationVariable().getName());
		}
		return ob;
	}

	private StudySummary convertFromEntityToSummary(StudyEntity entity) {
		StudySummary sum = new StudySummary();
		sum.setActive(String.valueOf(entity.isActive()));
		sum.setCommonCropName(entity.getTrial().getProgram().getCrop().getCropName());
		sum.setDocumentationURL(entity.getDocumentationURL());
		sum.setEndDate(DateUtility.toLocalDate(entity.getEndDate()));
		sum.setLocationDbId(entity.getLocation().getId());
		sum.setLocationName(entity.getLocation().getName());
		sum.setName(entity.getStudyName());
		sum.setProgramDbId(entity.getTrial().getProgram().getId());
		sum.setProgramName(entity.getTrial().getProgram().getName());
		sum.setStartDate(DateUtility.toLocalDate(entity.getStartDate()));
		sum.setStudyDbId(entity.getId());
		sum.setStudyName(entity.getStudyName());
		sum.setStudyType(entity.getStudyType().getName());
		sum.setStudyTypeName(entity.getStudyType().getName());
		sum.setStudyTypeDbId(entity.getStudyType().getId());
		sum.setTrialDbId(entity.getTrial().getId());
		sum.setTrialName(entity.getTrial().getTrialName());

		sum.setSeasons(entity.getSeasons().stream().map(this::convertFromEntity).collect(Collectors.toList()));

		sum.setAdditionalInfo(new HashMap<>());
		for (StudyAddtionalInfoEntity e : entity.getAdditionalInfo()) {
			sum.getAdditionalInfo().put(e.getKey(), e.getValue());
		}

		return sum;
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

	public List<String> getObservationLevels(Metadata metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Page<String> levelsPage = observationUnitRepository.findObservationLevels(pageReq);
		PagingUtility.calculateMetaData(metaData, levelsPage);
		return levelsPage.getContent();
	}

	public List<Observation> getObservationUnits(String studyDbId, List<String> observationVariableDbIds,
			Metadata metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Page<ObservationEntity> observationsPage;
		if (observationVariableDbIds == null || observationVariableDbIds.isEmpty()) {
			observationsPage = observationRepository.findAllByObservationUnit_Study_Id(studyDbId, pageReq);
		} else {
			observationsPage = observationRepository.findAllByObservationUnit_Study_IdAndObservationVariable_IdIn(
					studyDbId, observationVariableDbIds, pageReq);
		}
		PagingUtility.calculateMetaData(metaData, observationsPage);
		List<Observation> units = observationsPage.map(this::convertFromEntity).getContent();

		return units;
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

	public List<StudySummary> getStudies(String studyType, String studyTypeDbId, String programDbId, String trialDbId,
			String studyDbId, String locationDbId, String seasonDbId, List<String> germplasmDbIds,
			List<String> observationVariableDbIds, Boolean active, String sortBy, String sortOrder, Metadata metaData) {

		StudySearchRequest request = new StudySearchRequest();
		if (studyType != null)
			request.addStudyTypeNamesItem(studyType);
		if (studyTypeDbId != null)
			request.addStudyTypeDbIdsItem(studyTypeDbId);
		if (programDbId != null)
			request.addProgramDbIdsItem(programDbId);
		if (trialDbId != null)
			request.addTrialDbIdsItem(trialDbId);
		if (studyDbId != null)
			request.addStudyDbIdsItem(studyDbId);
		if (locationDbId != null)
			request.addLocationDbIdsItem(locationDbId);
		if (seasonDbId != null)
			request.addSeasonDbIdsItem(seasonDbId);
		request.setGermplasmDbIds(germplasmDbIds);
		request.setObservationVariableDbIds(observationVariableDbIds);
		request.setActive(active);
		request.setSortBy(SortByEnum.fromValue(sortBy));
		request.setSortOrder(SortOrderEnum.fromValue(sortOrder));

		return searchStudies(request, metaData);
	}

	public List<StudySummary> getStudies(@Valid StudySearchRequestDep req, Metadata metaData) {
		StudySearchRequest newRequest = new StudySearchRequest().active(req.isActive())
				.germplasmDbIds(req.getGermplasmDbIds()).locationDbIds(req.getLocationDbIds())
				.observationVariableDbIds(req.getObservationVariableDbIds()).page(req.getPage())
				.pageSize(req.getPageSize()).programDbIds(req.getProgramDbIds()).programNames(req.getProgramNames())
				.seasonDbIds(req.getSeasonDbId()).studyDbIds(req.getStudyDbIds()).studyNames(req.getStudyNames())
				.trialDbIds(req.getTrialDbIds());

		if (req.getStudyType() != null)
			newRequest.addStudyTypeNamesItem(req.getStudyType());
		if (req.getSortBy() != null)
			newRequest.setSortBy(SortByEnum.fromValue(req.getSortBy().toString()));
		if (req.getSortOrder() != null)
			newRequest.setSortOrder(SortOrderEnum.fromValue(req.getSortOrder().toString()));

		return searchStudies(newRequest, metaData);
	}

	public Study getStudy(String studyDbId) {
		Optional<StudyEntity> entityOption = studyRepository.findById(studyDbId);
		Study study = null;
		if (entityOption.isPresent()) {
			study = convertFromEntity(entityOption.get());
		}
		return study;
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
				return germplasmService.convertFromEntityToSummary(entity, entryMap);
			}).getContent());

			StudyEntity study = studyOption.get();
			germplasms.setStudyDbId(study.getId());
			germplasms.setTrialName(study.getTrial().getTrialName());
		}
		return germplasms;

	}

	public List<ObservationUnit> getStudyObservations(String studyDbId, String observationLevel, Metadata metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Page<ObservationUnitEntity> unitsPage;
		if (observationLevel == null) {
			unitsPage = observationUnitRepository.findAllByStudy_Id(studyDbId, pageReq);
		} else {
			unitsPage = observationUnitRepository.findAllByStudy_IdAndObservationLevel(studyDbId, observationLevel,
					pageReq);
		}
		PagingUtility.calculateMetaData(metaData, unitsPage);
		List<ObservationUnit> observations = unitsPage.map(this::convertFromEntity).getContent();

		return observations;
	}

	public ObservationsTable getStudyObservationUnitTable(String studyDbId, Metadata metadata) {
		ObservationsTable tableWrapper = new ObservationsTable();

		tableWrapper.setHeaderRow(buildHeaderRow());

		List<ObservationVariable> variables = observationVariableService.getVariablesForStudy(studyDbId, metadata);
		tableWrapper.setObservationVariableDbIds(
				variables.stream().map(e -> e.getObservationVariableDbId()).collect(Collectors.toList()));
		tableWrapper.setObservationVariableNames(variables.stream().map(e -> e.getName()).collect(Collectors.toList()));

		List<ObservationUnitEntity> units = observationUnitRepository.findAllByStudy_Id(studyDbId);
		tableWrapper.setData(buildDataMatrix(units, variables));

		return tableWrapper;
	}

	public String getStudyObservationUnitTableText(String studyDbId, String sep) {
		ObservationsTable table = getStudyObservationUnitTable(studyDbId, new Metadata());
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

	public StudyObservationVariablesResponseResult getStudyObservationVariables(String studyDbId, Metadata metadata) {
		Study study = getStudy(studyDbId);
		StudyObservationVariablesResponseResult wrapper = null;
		if (study != null) {
			wrapper = new StudyObservationVariablesResponseResult();
			wrapper.setData(observationVariableService.getVariablesForStudy(studyDbId, metadata));
			wrapper.setStudyDbId(study.getStudyDbId());
			wrapper.setTrialName(study.getTrialName());
		}
		return wrapper;
	}

	public List<ObservationUnitPosition> getStudyPlotLayouts(String studyDbId, Metadata metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Page<ObservationUnitEntity> unitsPage = observationUnitRepository.findAllByStudy_Id(studyDbId, pageReq);
		PagingUtility.calculateMetaData(metaData, unitsPage);
		List<ObservationUnitPosition> plots = unitsPage.map(this::convertFromEntityToPosition).getContent();
		return plots;
	}

	public List<StudyType> getStudyTypes(String studyTypeDbId, Metadata metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		List<StudyType> studyTypes = new ArrayList<>();

		if (studyTypeDbId == null) {
			Page<StudyTypeEntity> page = studyTypeRepository.findAll(pageReq);
			PagingUtility.calculateMetaData(metaData, page);
			studyTypes = page.map(this::convertFromEntity).getContent();
		} else {
			Optional<StudyTypeEntity> studyOption = studyTypeRepository.findById(studyTypeDbId);
			if (studyOption.isPresent()) {
				metaData.getPagination().setTotalCount(1);
				PagingUtility.calculateMetaData(metaData);
				studyTypes.add(convertFromEntity(studyOption.get()));
			}
		}

		return studyTypes;
	}

	private StudyType convertFromEntity(StudyTypeEntity entity) {
		StudyType studyType = new StudyType();
		studyType.setDescription(entity.getDescription());
		studyType.setName(entity.getName());
		studyType.setStudyTypeDbId(entity.getId());
		studyType.setStudyTypeName(entity.getName());
		return studyType;
	}

	public NewObservationDbIds saveObservations(String studyDbId, @Valid NewObservationsRequest newObservations) {
		NewObservationDbIds newObsIds = new NewObservationDbIds();
		Optional<StudyEntity> studyOpt = studyRepository.findById(studyDbId);
		if (studyOpt.isPresent()) {
			for (NewObservationsRequestObservations newObs : newObservations.getObservations()) {
				Optional<ObservationUnitEntity> unitOpt = observationUnitRepository
						.findById(newObs.getObservationUnitDbId());
				if (unitOpt.isPresent()) {
					List<ObservationEntity> obsEntities = unitOpt.get().getObservations();
					boolean found = false;
					for (ObservationEntity obsEntity : obsEntities) {
						if (obsEntity.getId().equals(newObs.getObservationDbId())) {
							updateEntity(obsEntity, newObs);
							found = true;
						}
					}
					if (!found) {
						ObservationEntity obsEntity = new ObservationEntity();
						updateEntity(obsEntity, newObs);
						obsEntity.setObservationUnit(unitOpt.get());
						obsEntities.add(obsEntity);
					}

					unitOpt.get().setObservations(obsEntities);
					ObservationUnitEntity savedUnit = observationUnitRepository.save(unitOpt.get());

					for (ObservationEntity obsEntity : savedUnit.getObservations()) {
						NewObservationDbIdsObservations newId = new NewObservationDbIdsObservations()
								.observationDbId(obsEntity.getId()).observationUnitDbId(savedUnit.getId());
						if (obsEntity.getObservationVariable() != null)
							newId.setObservationVariableDbId(obsEntity.getObservationVariable().getId());

						newObsIds.addObservationsItem(newId);
					}
				}
			}
		}

		return newObsIds;
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

	public List<String> saveObservationUnits(String studyDbId, NewObservationsRequestWrapperDeprecated requestDep) {
		List<String> newUnitDbIds = new ArrayList<>();
		Optional<StudyEntity> studyOpt = studyRepository.findById(studyDbId);
		if (studyOpt.isPresent()) {
			List<NewObservationUnitRequest> requests = new ArrayList<>();
			for (NewObservationsRequestDeprecatedData unit : requestDep.getResult().getData()) {
				NewObservationUnitRequest request = new NewObservationUnitRequest();
				request.setStudyDbId(studyOpt.get().getId());
				request.setObservationUnitDbId(unit.getObservatioUnitDbId());
				request.setObservations(unit.getObservations().stream().map((oDep) -> {
					Observation o = new Observation();
					o.setObservationDbId(oDep.getObservationDbId());
					o.setObservationTimeStamp(oDep.getObservationTimeStamp());
					o.setObservationUnitDbId(unit.getObservatioUnitDbId());
					o.setObservationVariableDbId(oDep.getObservationVariableDbId());
					o.setValue(oDep.getValue());
					return o;
				}).collect(Collectors.toList()));

				requests.add(request);

				newUnitDbIds.addAll(saveObservationUnit(requests).getObservationUnitDbIds());
			}
		}
		return newUnitDbIds;
	}

	public NewObservationDbIds saveStudyObservationUnitsTable(String studyDbId,
			@Valid NewObservationsTableRequest request) {
		Optional<StudyEntity> studyOpt = studyRepository.findById(studyDbId);
		Set<NewObservationDbIdsObservations> observationDbIds = new HashSet<>();
		if (studyOpt.isPresent()) {
			for (List<String> row : request.getData()) {
				ObservationUnitEntity entity = buildEntityFromRow(row, request, studyDbId);
				if (entity.getStudy() == null) {
					entity.setStudy(studyOpt.get());
				}
				ObservationUnitEntity savedEntity = observationUnitRepository.save(entity);
				observationDbIds.addAll(savedEntity.getObservations().stream().map(e -> {
					return new NewObservationDbIdsObservations().observationDbId(e.getId())
							.observationUnitDbId(e.getObservationUnit().getId())
							.observationVariableDbId(e.getObservationVariable().getId());
				}).collect(Collectors.toSet()));
			}
		}
		NewObservationDbIds response = new NewObservationDbIds();
		response.setObservations(new ArrayList<>());
		response.getObservations().addAll(observationDbIds);
		return response;
	}

	private ObservationUnitEntity buildEntityFromRow(List<String> row, @Valid NewObservationsTableRequest request,
			String studyDbId) {
		ObservationUnitEntity entity = new ObservationUnitEntity();
		Date observationTimeStamp = new Date();
		for (int i = 0; i < row.size(); i++) {
			int varIndex = i - request.getHeaderRow().size();
			if (varIndex < 0) {
				HeaderRowEnum header = HeaderRowEnum.fromValue(request.getHeaderRow().get(i));
				if (header != null) {
					switch (header) {
					case BLOCKNUMBER:
						entity.setBlockNumber(Integer.parseInt(row.get(i)));
						break;
					case ENTRYTYPE:
						entity.setEntryType(row.get(i));
						break;
					case GERMPLASMDBID:
					case GERMPLASMNAME:
						Optional<GermplasmEntity> germOpt = germplasmRepository.findById(row.get(i));
						if (germOpt.isPresent())
							entity.setGermplasm(germOpt.get());
						break;
					case OBSERVATIONTIMESTAMP:
						observationTimeStamp = DateUtility.toDate(row.get(i));
						break;
					case OBSERVATIONUNITDBID:
						Optional<ObservationUnitEntity> unitOpt = observationUnitRepository.findById(row.get(i));
						if (unitOpt.isPresent()) {
							entity.setId(unitOpt.get().getId());
							entity.setObservations(unitOpt.get().getObservations());
						}
						break;
					case PLOTNUMBER:
						entity.setPlotNumber(Integer.parseInt(row.get(i)));
						break;
					case REPLICATE:
						entity.setReplicate(row.get(i));
						break;
					case STUDYDBID:
					case STUDYNAME:
						Optional<StudyEntity> studyOpt = studyRepository.findById(row.get(i));
						if (studyOpt.isPresent())
							entity.setStudy(studyOpt.get());
						break;
					case X:
						entity.setX(row.get(i));
						break;
					case Y:
						entity.setY(row.get(i));
						break;
					case YEAR:
					case LOCATIONDBID:
					case LOCATIONNAME:
					default:
						break;
					}
				}
			} else {
				Optional<ObservationVariableEntity> varOpt = observationVariableRepository
						.findById(request.getObservationVariableDbIds().get(varIndex));
				if (varOpt.isPresent()) {
					ObservationEntity observation = new ObservationEntity();
					observation.setObservationTimeStamp(observationTimeStamp);
					observation.setObservationUnit(entity);
					observation.setObservationVariable(varOpt.get());
					observation.setValue(row.get(i));
					if (entity.getObservations() == null)
						entity.setObservations(new ArrayList<>());
					entity.getObservations().add(observation);
				}
			}
		}
		return entity;
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
					unit.setX(layout.getX());
					unit.setX(layout.getPositionCoordinateX());
					unit.setY(layout.getY());
					unit.setY(layout.getPositionCoordinateY());
					unit.setEntryType(layout.getEntryType().name());
					unit.setReplicate(layout.getReplicate().toString());

					ObservationUnitEntity newUnit = observationUnitRepository.save(unit);
					positions.add(convertFromEntityToPosition(newUnit));
				}
			}
		}
		return positions;
	}

	public List<StudySummary> searchStudies(StudySearchRequest request, Metadata metaData) {

		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Page<StudyEntity> studiesPage = studyRepository.findBySearch(request, pageReq);
		PagingUtility.calculateMetaData(metaData, studiesPage);

		List<StudySummary> summaries = studiesPage.map(this::convertFromEntityToSummary).getContent();
		return summaries;
	}

	private void updateEntity(ObservationEntity entity, NewObservationsRequestObservations obs) {
		entity.setCollector(obs.getCollector());
		entity.setObservationTimeStamp(DateUtility.toDate(obs.getObservationTimeStamp()));
		entity.setValue(obs.getValue());

		if (entity.getObservationVariable() == null
				|| entity.getObservationVariable().getId() != obs.getObservationVariableDbId()) {
			ObservationVariableEntity observationVariable = observationVariableService
					.getVariableEntity(obs.getObservationVariableDbId());
			entity.setObservationVariable(observationVariable);
		}

		entity.setSeason(seasonRepository.findById("1").get());

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
}
