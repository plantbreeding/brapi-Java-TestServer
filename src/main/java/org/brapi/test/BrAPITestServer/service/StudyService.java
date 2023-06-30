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

import jakarta.validation.Valid;

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
import org.springframework.http.HttpStatus;
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
import io.swagger.model.ObservationTreatment;
import io.swagger.model.ObservationUnit;
import io.swagger.model.ObservationUnit.PositionCoordinateXTypeEnum;
import io.swagger.model.ObservationUnit.PositionCoordinateYTypeEnum;
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
			if (unit.getObservations() != null && !unit.getObservations().isEmpty()) {
				row.add(unit.getObservations().get(0).getSeason().getYear().toString());
				row.add(DateUtility.toTimeString(unit.getObservations().get(0).getObservationTimeStamp()));
			} else {
				row.add("");
				row.add("");
			}
			if (unit.getStudy() != null) {
				row.add(unit.getStudy().getId());
				row.add(unit.getStudy().getStudyName());
				if (unit.getStudy().getLocation() != null) {
					row.add(unit.getStudy().getLocation().getId());
					row.add(unit.getStudy().getLocation().getCountryName());
				} else {
					row.add("");
					row.add("");
				}
			} else {
				row.add("");
				row.add("");
				row.add("");
				row.add("");
			}
			if (unit.getGermplasm() != null) {
				row.add(unit.getGermplasm().getId());
				row.add(unit.getGermplasm().getGermplasmName());
			} else {
				row.add("");
				row.add("");
			}
			row.add(unit.getId());
			if (unit.getPlotNumber() != null)
				row.add(unit.getPlotNumber().toString());
			else
				row.add("");
			row.add(unit.getReplicate());
			if (unit.getBlockNumber() != null)
				row.add(unit.getBlockNumber().toString());
			else
				row.add("");
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

			for (int i = 0; i < row.size(); i++) {
				if (row.get(i) == null) {
					row.set(i, "");
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
		Observation obs = new Observation();
		if (entity.getObservationUnit() != null) {
			ObservationUnitEntity unit = entity.getObservationUnit();
			obs.setObservationLevel(unit.getObservationLevel());
			obs.setObservationUnitDbId(unit.getId());
			obs.setObservationUnitName(unit.getObservationUnitName());
			obs.setOperator(unit.getOperator());
			obs.setUploadedBy(unit.getUploadedBy());
			if (unit.getGermplasm() != null) {
				obs.setGermplasmDbId(unit.getGermplasm().getId());
				obs.setGermplasmName(unit.getGermplasm().getGermplasmName());
			}
			if (unit.getStudy() != null)
				obs.setStudyDbId(unit.getStudy().getId());
		}
		if (entity.getObservationVariable() != null) {
			obs.setObservationVariableDbId(entity.getObservationVariable().getId());
			obs.setObservationVariableName(entity.getObservationVariable().getName());
		}
		obs.setObservationDbId(entity.getId());
		obs.setObservationTimeStamp(DateUtility.toOffsetDateTime(entity.getObservationTimeStamp()));
		obs.setSeason(convertFromEntity(entity.getSeason()));
		obs.setValue(entity.getValue());

		return obs;
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
		if (entity.getStudy() != null) {
			observation.setStudyDbId(entity.getStudy().getId());
			observation.setStudyName(entity.getStudy().getStudyName());
			if (entity.getStudy().getLocation() != null) {
				observation.setLocationDbId(entity.getStudy().getLocation().getId());
				observation.setStudyLocationDbId(entity.getStudy().getLocation().getId());
				observation.setLocationName(entity.getStudy().getLocation().getName());
				observation.setStudyLocation(entity.getStudy().getLocation().getName());
			}
			if (entity.getStudy().getTrial() != null) {
				observation.setTrialDbId(entity.getStudy().getTrial().getId());
				observation.setTrialName(entity.getStudy().getTrial().getTrialName());
				if (entity.getStudy().getTrial().getProgram() != null) {
					observation.setProgramDbId(entity.getStudy().getTrial().getProgram().getId());
					observation.setProgramName(entity.getStudy().getTrial().getProgram().getName());
				}
			}
		}
		observation.setObservationLevel(entity.getObservationLevel());
		observation.setObservationLevels(entity.getObservationLevels());
		observation.setObservationUnitDbId(entity.getId());
		observation.setObservationUnitName(entity.getObservationUnitName());
		if (entity.getPedigree() != null)
			observation.setPedigree(entity.getPedigree().getPedigree());
		observation.setPlantNumber(entity.getPlantNumber() == null ? "0" : entity.getPlantNumber().toString());
		observation.setPlotNumber(entity.getPlotNumber() == null ? "0" : entity.getPlotNumber().toString());
		observation.setReplicate(entity.getReplicate());
		observation.setX(entity.getX());
		observation.setPositionCoordinateX(entity.getX());
		observation.setPositionCoordinateXType(PositionCoordinateXTypeEnum.GRID_COL);
		observation.setY(entity.getY());
		observation.setPositionCoordinateY(entity.getY());
		observation.setPositionCoordinateYType(PositionCoordinateYTypeEnum.GRID_ROW);

		if (entity.getObservations() != null)
			observation.setObservations(entity.getObservations().stream().map(this::convertFromEntityToSummary)
					.collect(Collectors.toList()));

		if (entity.getObservationUnitXref() != null) {
			observation.setObservationUnitXref(entity.getObservationUnitXref().stream().map(e -> {
				ObservationUnitXref xref = new ObservationUnitXref();
				xref.setId(e.getXref());
				xref.setSource(e.getSource());
				return xref;
			}).collect(Collectors.toList()));
		}

		if (entity.getTreatments() != null) {
			observation.setTreatments(entity.getTreatments().stream().map(e -> {
				ObservationTreatment treatment = new ObservationTreatment();
				treatment.setFactor(e.getFactor());
				treatment.setModality(e.getModality());
				return treatment;
			}).collect(Collectors.toList()));
		}

		return observation;

	}

	private Season convertFromEntity(SeasonEntity entity) {
		Season season = new Season();
		if (entity != null) {
			season.setSeason(entity.getSeason());
			season.setSeasonDbId(entity.getId());
			if (entity.getYear() != null)
				season.setYear(entity.getYear().toString());
		}
		return season;
	}

	private Study convertFromEntity(StudyEntity entity) {
		Study study = new Study();

		study.setActive(String.valueOf(entity.isActive()));
		study.setDocumentationURL(entity.getDocumentationURL());
		study.setEndDate(DateUtility.toLocalDate(entity.getEndDate()));
		study.setStartDate(DateUtility.toLocalDate(entity.getStartDate()));
		study.setStudyDbId(entity.getId());
		if (entity.getStudyType() != null) {
			study.setStudyType(entity.getStudyType().getName());
			study.setStudyTypeName(entity.getStudyType().getName());
			study.setStudyTypeDbId(entity.getStudyType().getId());
		}
		if (entity.getTrial() != null) {
			study.setTrialDbId(entity.getTrial().getId());
			study.setTrialName(entity.getTrial().getTrialName());
			if (entity.getTrial().getProgram() != null && entity.getTrial().getProgram().getCrop() != null)
				study.setCommonCropName(entity.getTrial().getProgram().getCrop().getCropName());
		}
		study.setLicense(entity.getLicence());
		study.setLocation(locationService.convertFromEntity(entity.getLocation()));
		study.setStudyDescription(entity.getStudyDescription());
		study.setStudyName(entity.getStudyName());

		study.setLastUpdate(new StudyLastUpdate());
		study.getLastUpdate().setTimestamp(DateUtility.toOffsetDateTime(entity.getTimestamp()));
		study.getLastUpdate().setVersion(entity.getVersion());

		if (entity.getContacts() != null) {
			study.setContacts(entity.getContacts().stream().map(this.contactService::convertFromEntity)
					.collect(Collectors.toList()));
		}

		if (entity.getDataLinks() != null) {
			study.setDataLinks(entity.getDataLinks().stream().map(e -> {
				DataLink dataLink = new DataLink();
				dataLink.setName(e.getName());
				dataLink.setDataLinkName(e.getName());
				dataLink.setType(e.getType());
				dataLink.setUrl(e.getUrl());
				return dataLink;
			}).collect(Collectors.toList()));
		}

		if (entity.getSeasons() != null) {
			study.setSeasons(entity.getSeasons().stream().map(e -> {
				return e.getSeason() + " " + e.getYear();
			}).collect(Collectors.toList()));
		}

		study.setAdditionalInfo(new HashMap<>());
		for (StudyAddtionalInfoEntity e : entity.getAdditionalInfo()) {
			study.getAdditionalInfo().put(e.getKey(), e.getValue());
		}
		return study;
	}

	private ObservationUnitPosition convertFromEntityToPosition(ObservationUnitEntity entity) {
		ObservationUnitPosition plot = new ObservationUnitPosition();
		plot.setBlockNumber(entity.getBlockNumber() == null ? null : entity.getBlockNumber().toString());
		if (entity.getEntryType() != null)
			plot.setEntryType(EntryTypeEnum.valueOf(entity.getEntryType()));
		plot.setObservationLevel(entity.getObservationLevel());
		plot.setObservationUnitDbId(entity.getId());
		plot.setObservationUnitName(entity.getObservationUnitName());
		plot.setReplicate(entity.getReplicate());
		if (entity.getStudy() != null)
			plot.setStudyDbId(entity.getStudy().getId());
		plot.setX(entity.getX());
		plot.setPositionCoordinateX(entity.getX());
		plot.setPositionCoordinateXType(io.swagger.model.ObservationUnitPosition.PositionCoordinateXTypeEnum.GRID_COL);
		plot.setY(entity.getY());
		plot.setPositionCoordinateY(entity.getY());
		plot.setPositionCoordinateYType(io.swagger.model.ObservationUnitPosition.PositionCoordinateYTypeEnum.GRID_ROW);
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
		sum.setDocumentationURL(entity.getDocumentationURL());
		sum.setEndDate(DateUtility.toLocalDate(entity.getEndDate()));
		sum.setName(entity.getStudyName());
		sum.setStartDate(DateUtility.toLocalDate(entity.getStartDate()));
		sum.setStudyDbId(entity.getId());
		sum.setStudyName(entity.getStudyName());
		if (entity.getLocation() != null) {
			sum.setLocationDbId(entity.getLocation().getId());
			sum.setLocationName(entity.getLocation().getName());
		}
		if (entity.getStudyType() != null) {
			sum.setStudyType(entity.getStudyType().getName());
			sum.setStudyTypeName(entity.getStudyType().getName());
			sum.setStudyTypeDbId(entity.getStudyType().getId());
		}
		if (entity.getTrial() != null) {
			sum.setTrialDbId(entity.getTrial().getId());
			sum.setTrialName(entity.getTrial().getTrialName());
			if (entity.getTrial().getProgram() != null) {
				sum.setProgramDbId(entity.getTrial().getProgram().getId());
				sum.setProgramName(entity.getTrial().getProgram().getName());
				if (entity.getTrial().getProgram().getCrop() != null)
					sum.setCommonCropName(entity.getTrial().getProgram().getCrop().getCropName());
			}
		}

		if (entity.getSeasons() != null)
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
		String obsID = observation.getObservationDbId() == null ? "" : observation.getObservationDbId();
		ObservationEntity entity = observationRepository.findById(obsID).orElse(new ObservationEntity());
		entity.setCollector(observation.getOperator());
		entity.setObservationTimeStamp(DateUtility.toDate(observation.getObservationTimeStamp()));
		entity.setValue(observation.getValue());
		ObservationVariableEntity variable = observationVariableService.getVariableEntity(observation.getObservationVariableDbId());
		entity.setObservationVariable(variable);
		if(observation.getSeason() != null) {
			SeasonEntity season = null;
			if(observation.getSeason().getSeasonDbId() != null) {
				season = seasonRepository.findById(observation.getSeason().getSeasonDbId()).orElse(null);
			}
			if(season == null) {
				season = new SeasonEntity();
				season.setSeason(observation.getSeason().getSeason());
				season.setYear(Integer.getInteger(observation.getSeason().getYear()));
				seasonRepository.save(season);
			}
			entity.setSeason(season);
		}
		
		return entity;
	}

	public List<String> getObservationLevels(Metadata metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Page<String> levelsPage = observationUnitRepository.findObservationLevels(pageReq);
		PagingUtility.calculateMetaData(metaData, levelsPage);
		List<String> levels = levelsPage.stream().filter(l -> l != null).distinct().collect(Collectors.toList());
		return levels;
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

	public List<Season> getSeasons(String seasonDbId, String season, String year, Metadata metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Integer yearInt = null;
		if (year != null) {
			try {
				yearInt = Integer.valueOf(year);
			} catch (NumberFormatException e) {
				yearInt = -1;
			}
		}
		Page<SeasonEntity> seasonPage = seasonRepository.findBySearch(seasonDbId, season, yearInt, pageReq);

		List<Season> seasons = seasonPage.map((entity) -> {
			Season seasonObj = new Season();
			seasonObj.setSeason(entity.getSeason());
			seasonObj.setSeasonDbId(entity.getId());
			seasonObj.setYear(String.valueOf(entity.getYear()));
			return seasonObj;
		}).getContent();

		PagingUtility.calculateMetaData(metaData, seasonPage);
		return seasons;
	}

	public List<StudySummary> getStudies(String commonCropName, String studyType, String studyTypeDbId,
			String programDbId, String trialDbId, String studyDbId, String locationDbId, String seasonDbId,
			List<String> germplasmDbIds, List<String> observationVariableDbIds, Boolean active, String sortBy,
			String sortOrder, Metadata metaData) {

		StudySearchRequest request = new StudySearchRequest();
		if (commonCropName != null)
			request.addCommonCropNamesItem(commonCropName);
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
					ObservationEntity newObsEntity = null;

					List<ObservationEntity> obsEntities = unitOpt.get().getObservations();
					for (ObservationEntity obsEntity : obsEntities) {
						if (obsEntity.getId().equals(newObs.getObservationDbId())) {
							newObsEntity = obsEntity;
							break;
						}
					}
					if (newObsEntity == null) {
						newObsEntity = new ObservationEntity();
						newObsEntity.setObservationUnit(unitOpt.get());
					}

					updateEntity(newObsEntity, newObs);
					ObservationEntity savedObsEntity = observationRepository.save(newObsEntity);

					NewObservationDbIdsObservations newId = new NewObservationDbIdsObservations()
							.observationDbId(savedObsEntity.getId())
							.observationUnitDbId(savedObsEntity.getObservationUnit().getId());
					if (savedObsEntity.getObservationVariable() != null)
						newId.setObservationVariableDbId(savedObsEntity.getObservationVariable().getId());

					newObsIds.addObservationsItem(newId);
				}
			}
		}

		return newObsIds;
	}

	public NewObservationUnitDbIds saveObservationUnit(@Valid List<NewObservationUnitRequest> request, String studyDbId)
			throws BrAPIServerException {

		Optional<StudyEntity> studyEntityOpt = studyRepository.findById(studyDbId);
		if (!studyEntityOpt.isPresent()) {
			throw new BrAPIServerException(HttpStatus.NOT_FOUND, "No study found for the given studyDbId");
		}

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

			unitEntity.setStudy(studyEntityOpt.get());

			final ObservationUnitEntity newUnitEntity = observationUnitRepository.save(unitEntity);

			if (unit.getObservationUnitXref() != null) {
				if(newUnitEntity.getObservationUnitXref() == null)
					newUnitEntity.setObservationUnitXref(new ArrayList<>());
				for (ObservationUnitXrefEntity xref : newUnitEntity.getObservationUnitXref()) {
					xref.setObservationUnitDbId(null);
				}
				List<ObservationUnitXrefEntity> xrefs = unit.getObservationUnitXref().stream().map((xref) -> {
					ObservationUnitXrefEntity entity = new ObservationUnitXrefEntity();
					entity.setObservationUnitDbId(newUnitEntity.getId());
					entity.setXref(xref.getId());
					entity.setSource(xref.getSource());
					return entity;
				}).collect(Collectors.toList());
				newUnitEntity.getObservationUnitXref().addAll(xrefs);
			}

			if (unit.getTreatments() != null) {
				if(newUnitEntity.getTreatments() == null)
					newUnitEntity.setTreatments(new ArrayList<>());
				for (TreatmentEntity treat : newUnitEntity.getTreatments()) {
					treat.setObservationUnitDbId(null);
				}
				List<TreatmentEntity> tratments = unit.getTreatments().stream().map((treatment) -> {
					TreatmentEntity entity = new TreatmentEntity();
					entity.setFactor(treatment.getFactor());
					entity.setModality(treatment.getModality());
					entity.setObservationUnitDbId(newUnitEntity.getId());
					return entity;
				}).collect(Collectors.toList());
				newUnitEntity.getTreatments().addAll(tratments);
			}

			ObservationUnitEntity newNewUnitEntity = observationUnitRepository.save(newUnitEntity);

			if (unit.getObservations() != null) {
				if(newUnitEntity.getObservations() == null)
					newUnitEntity.setObservations(new ArrayList<>());
				for (ObservationEntity obsEntity : newUnitEntity.getObservations()) {
					obsEntity.setObservationUnit(null);
				}
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

	public List<String> saveObservationUnits(String studyDbId, NewObservationsRequestWrapperDeprecated requestDep)
			throws BrAPIServerException {
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

				newUnitDbIds.addAll(saveObservationUnit(requests, studyDbId).getObservationUnitDbIds());
			}
		}
		return newUnitDbIds;
	}

	public NewObservationDbIds saveStudyObservationUnitsTable(String studyDbId,
			@Valid NewObservationsTableRequest request) {
		Optional<StudyEntity> studyOpt = studyRepository.findById(studyDbId);
		Set<NewObservationDbIdsObservations> observationDbIds = new HashSet<>();
		if (studyOpt.isPresent() && request.getData() != null) {
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
						entity.setBlockNumber(row.get(i));
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
						entity.setPlotNumber(row.get(i));
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
					if (layout.getBlockNumber() != null)
						unit.setBlockNumber(layout.getBlockNumber());
					if (layout.getX() != null)
						unit.setX(layout.getX());
					if (layout.getPositionCoordinateX() != null)
						unit.setX(layout.getPositionCoordinateX());
					if (layout.getY() != null)
						unit.setY(layout.getY());
					if (layout.getPositionCoordinateY() != null)
						unit.setY(layout.getPositionCoordinateY());
					if (layout.getEntryType() != null)
						unit.setEntryType(layout.getEntryType().name());
					if (layout.getReplicate() != null)
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
		if (obs.getCollector() != null)
			entity.setCollector(obs.getCollector());
		if (obs.getObservationTimeStamp() != null)
			entity.setObservationTimeStamp(DateUtility.toDate(obs.getObservationTimeStamp()));
		if (obs.getValue() != null)
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
		if (unit.getBlockNumber() != null)
			observationUnitEntity.setBlockNumber(unit.getBlockNumber());
		if (unit.getEntryNumber() != null)
			observationUnitEntity.setEntryNumber(unit.getEntryNumber());
		if (unit.getEntryType() != null)
			observationUnitEntity.setEntryType(unit.getEntryType());
		if (unit.getObservationLevel() != null)
			observationUnitEntity.setObservationLevel(unit.getObservationLevel());
		if (unit.getObservationUnitName() != null)
			observationUnitEntity.setObservationUnitName(unit.getObservationUnitName());
		if (unit.getPlantNumber() != null)
			observationUnitEntity.setPlantNumber(unit.getPlantNumber());
		if (unit.getPlotNumber() != null)
			observationUnitEntity.setPlotNumber(unit.getPlotNumber());
		if (unit.getReplicate() != null)
			observationUnitEntity.setReplicate(unit.getReplicate());
		if (unit.getX() != null)
			observationUnitEntity.setX(unit.getX());
		if (unit.getPositionCoordinateX() != null)
			observationUnitEntity.setX(unit.getPositionCoordinateX());
		if (unit.getPositionCoordinateY() != null)
			observationUnitEntity.setY(unit.getPositionCoordinateY());

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
