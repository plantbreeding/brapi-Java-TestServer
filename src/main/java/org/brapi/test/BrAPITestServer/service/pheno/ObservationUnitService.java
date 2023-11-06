package org.brapi.test.BrAPITestServer.service.pheno;

import io.swagger.model.IndexPagination;
import io.swagger.model.Metadata;
import io.swagger.model.pheno.*;
import jakarta.validation.Valid;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.ProgramEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.StudyEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.TrialEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.CrossEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.GermplasmEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.SeedLotEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.*;
import org.brapi.test.BrAPITestServer.repository.pheno.ObservationUnitRepository;
import org.brapi.test.BrAPITestServer.service.GeoJSONUtility;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.brapi.test.BrAPITestServer.service.UpdateUtility;
import org.brapi.test.BrAPITestServer.service.core.ProgramService;
import org.brapi.test.BrAPITestServer.service.core.StudyService;
import org.brapi.test.BrAPITestServer.service.core.TrialService;
import org.brapi.test.BrAPITestServer.service.germ.CrossService;
import org.brapi.test.BrAPITestServer.service.germ.GermplasmService;
import org.brapi.test.BrAPITestServer.service.germ.SeedLotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

@Service
public class ObservationUnitService {

	private static final Logger log = LoggerFactory.getLogger(ObservationUnitService.class);
	private final ObservationUnitRepository observationUnitRepository;
	private final GermplasmService germplasmService;
	private final CrossService crossService;
	private final ObservationService observationService;
	private final StudyService studyService;
	private final TrialService trialService;
	private final ProgramService programService;
	private final SeedLotService seedLotService;
	private final ObservationVariableService observationVariableService;

	@Autowired
	public ObservationUnitService(ObservationUnitRepository observationUnitRepository, StudyService studyService,
			TrialService trialService, ProgramService programService, ObservationService observationService,
			GermplasmService germplasmService, SeedLotService seedLotService, CrossService crossService,
			ObservationVariableService observationVariableService) {
		this.observationUnitRepository = observationUnitRepository;

		this.studyService = studyService;
		this.trialService = trialService;
		this.programService = programService;
		this.crossService = crossService;
		this.germplasmService = germplasmService;
		this.observationService = observationService;
		this.seedLotService = seedLotService;
		this.observationVariableService = observationVariableService;
	}

	public List<ObservationUnit> findObservationUnits(String observationUnitDbId, String observationUnitName,
			String germplasmDbId, String studyDbId, String locationDbId, String trialDbId, String programDbId,
			String seasonDbId, String observationUnitLevelName, String observationUnitLevelOrder,
			String observationUnitLevelCode, String observationUnitLevelRelationshipName,
			String observationUnitLevelRelationshipOrder, String observationUnitLevelRelationshipCode,
			String observationUnitLevelRelationshipDbId, String commonCropName, Boolean includeObservations,
			String externalReferenceId, String externalReferenceID, String externalReferenceSource, Metadata metadata) {
		ObservationUnitSearchRequest request = buildObservationUnitsSearchRequest(observationUnitDbId,
				observationUnitName, germplasmDbId, studyDbId, locationDbId, trialDbId, programDbId, seasonDbId,
				observationUnitLevelName, observationUnitLevelOrder, observationUnitLevelCode,
				observationUnitLevelRelationshipName, observationUnitLevelRelationshipOrder,
				observationUnitLevelRelationshipCode, observationUnitLevelRelationshipDbId, commonCropName,
				includeObservations, externalReferenceId, externalReferenceID, externalReferenceSource);
		return findObservationUnits(request, metadata);
	}

	private ObservationUnitSearchRequest buildObservationUnitsSearchRequest(String observationUnitDbId,
			String observationUnitName, String germplasmDbId, String studyDbId, String locationDbId, String trialDbId,
			String programDbId, String seasonDbId, String observationUnitLevelName, String observationUnitLevelOrder,
			String observationUnitLevelCode, String observationUnitLevelRelationshipName,
			String observationUnitLevelRelationshipOrder, String observationUnitLevelRelationshipCode,
			String observationUnitLevelRelationshipDbId, String commonCropName, Boolean includeObservations,
			String externalReferenceId, String externalReferenceID, String externalReferenceSource) {

		ObservationUnitSearchRequest request = new ObservationUnitSearchRequest();
		if (observationUnitDbId != null)
			request.addObservationUnitDbIdsItem(observationUnitDbId);
		if (observationUnitName != null)
			request.addObservationUnitNamesItem(observationUnitName);
		if (commonCropName != null)
			request.addCommonCropNamesItem(commonCropName);
		if (germplasmDbId != null)
			request.addGermplasmDbIdsItem(germplasmDbId);
		if (studyDbId != null)
			request.addStudyDbIdsItem(studyDbId);
		if (locationDbId != null)
			request.addLocationDbIdsItem(locationDbId);
		if (trialDbId != null)
			request.addTrialDbIdsItem(trialDbId);
		if (programDbId != null)
			request.addProgramDbIdsItem(programDbId);
		if (seasonDbId != null)
			request.addSeasonDbIdsItem(seasonDbId);
		if (observationUnitLevelName != null || observationUnitLevelOrder != null || observationUnitLevelCode != null) {
			ObservationUnitLevel level = new ObservationUnitLevel();
			if (observationUnitLevelName != null)
				level.setLevelName(ObservationUnitHierarchyLevelEnum.fromValue(observationUnitLevelName));
			if (observationUnitLevelOrder != null)
				level.setLevelOrder(Integer.decode(observationUnitLevelOrder));
			if (observationUnitLevelCode != null)
				level.setLevelCode(observationUnitLevelCode);
			request.addObservationLevelsItem(level);
		}
		if (observationUnitLevelRelationshipName != null || observationUnitLevelRelationshipOrder != null
				|| observationUnitLevelRelationshipCode != null) {
			ObservationUnitLevelRelationship level = new ObservationUnitLevelRelationship();
			if (observationUnitLevelRelationshipName != null)
				level.setLevelName(ObservationUnitHierarchyLevelEnum.fromValue(observationUnitLevelRelationshipName));
			if (observationUnitLevelRelationshipOrder != null)
				level.setLevelOrder(Integer.decode(observationUnitLevelRelationshipOrder));
			if (observationUnitLevelRelationshipCode != null)
				level.setLevelCode(observationUnitLevelRelationshipCode);
			if (observationUnitLevelRelationshipDbId != null)
				level.setObservationUnitDbId(observationUnitLevelRelationshipDbId);
			request.addObservationLevelRelationshipsItem(level);
		}
		if (includeObservations != null)
			request.setIncludeObservations(includeObservations);

		request.addExternalReferenceItem(externalReferenceId, externalReferenceID, externalReferenceSource);

		return request;
	}

	public ObservationUnitTable findObservationUnitsTable(String observationUnitDbId, String germplasmDbId,
			String observationVariableDbId, String studyDbId, String locationDbId, String trialDbId, String programDbId,
			String seasonDbId, String observationLevel, String observationUnitLevelName,
			String observationUnitLevelOrder, String observationUnitLevelCode,
			String observationUnitLevelRelationshipName, String observationUnitLevelRelationshipOrder,
			String observationUnitLevelRelationshipCode, String observationUnitLevelRelationshipDbId) {

		ObservationUnitSearchRequest ouRequest = buildObservationUnitsSearchRequest(observationUnitDbId, null,
				germplasmDbId, studyDbId, locationDbId, trialDbId, programDbId, seasonDbId, observationUnitLevelName,
				observationUnitLevelOrder, observationUnitLevelCode, observationUnitLevelRelationshipName,
				observationUnitLevelRelationshipOrder, observationUnitLevelRelationshipCode,
				observationUnitLevelRelationshipDbId, null, false, null, null, null);
		Page<ObservationUnitEntity> observationUnits = findObservationUnitEntities(ouRequest, null);

		ObservationVariableSearchRequest varRequest = new ObservationVariableSearchRequest();
		varRequest
				.setObservationUnitDbIds(observationUnits.stream().map(ou -> ou.getId()).collect(Collectors.toList()));
		List<ObservationVariable> variables = observationVariableService.findObservationVariables(varRequest, null);

		ObservationUnitTable table = new ObservationUnitTable();
		table.setData(buildDataMatrix(observationUnits, variables));
		table.setHeaderRow(buildHeaderRow());
		table.setObservationVariables(variables.stream().map(this::convertVariables).collect(Collectors.toList()));
		return table;
	}

	public List<ObservationUnit> findObservationUnits(@Valid ObservationUnitSearchRequest request, Metadata metadata) {
		Page<ObservationUnitEntity> page = findObservationUnitEntities(request, metadata);

		boolean includeObservations = request.isIncludeObservations() != null && request.isIncludeObservations();

		if(includeObservations) {
			log.debug("Fetching observations for OUs");
			for(ObservationUnitEntity entity : page) {
				log.trace("Fetching observations for OU: " + entity.getId());
				entity.getObservations();
			}
		}

		log.debug("converting "+page.getSize()+" entities");
		List<ObservationUnit> observationUnits = page.map(observationUnitEntity -> this.convertFromEntity(observationUnitEntity, includeObservations)).getContent();
		log.debug("done converting entities");
		PagingUtility.calculateMetaData(metadata, page);

		return observationUnits;
	}

	public Page<ObservationUnitEntity> findObservationUnitEntities(@Valid ObservationUnitSearchRequest request,
			Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<ObservationUnitEntity> searchQuery = new SearchQueryBuilder<ObservationUnitEntity>(
				ObservationUnitEntity.class);
		searchQuery.leftJoinFetch("germplasm", "germplasm")
				   .leftJoinFetch("*germplasm.pedigree", "pedigree")
				   .leftJoinFetch("cross", "cross")
				   .leftJoinFetch("position", "position")
				   .leftJoinFetch("*position.geoCoordinates", "geoCoordinates")
				   .leftJoinFetch("seedLot", "seedLot")
				   .leftJoinFetch("study", "study")
				   .leftJoinFetch("*study.experimentalDesign", "experimentalDesign")
				   .leftJoinFetch("*study.growthFacility", "growthFacility")
				   .leftJoinFetch("*study.lastUpdate", "lastUpdate")
				   .leftJoinFetch("*study.location", "studyLocation")
				   .leftJoinFetch("*study.trial", "studyTrial")
				   .leftJoinFetch("*studyTrial.program", "studyTrialProgram")
				   .leftJoinFetch("trial", "trial")
				   .leftJoinFetch("*trial.program", "trialProgram")
				   .leftJoinFetch("program", "program");

		if (request.getObservationVariableDbIds() != null || request.getObservationVariableNames() != null) {
			searchQuery = searchQuery.join("observations", "observation")
					.appendList(request.getObservationVariableDbIds(), "*observation.variable.id")
					.appendList(request.getObservationVariableNames(), "*observation.variable.name");
		}
		if (request.getSeasonDbIds() != null) {
			searchQuery = searchQuery.join("study.seasons", "season").appendList(request.getSeasonDbIds(),
					"*season.id");

		}
		if (request.getObservationLevels() != null) {
			searchQuery = searchQuery
					.appendEnumList(request.getObservationLevels().stream().filter(r -> r.getLevelName() != null)
							.map(r -> r.getLevelName()).collect(Collectors.toList()), "position.levelName")
					.appendList(request.getObservationLevels().stream().filter(r -> r.getLevelCode() != null)
							.map(r -> r.getLevelCode()).collect(Collectors.toList()), "position.levelCode")
					.appendIntList(request.getObservationLevels().stream().filter(r -> r.getLevelOrder() != null)
							.map(r -> r.getLevelOrder()).collect(Collectors.toList()), "position.levelOrder");
		}
		if (request.getObservationLevelRelationships() != null) {
			searchQuery = searchQuery.join("position.observationLevelRelationships", "levelRelationship")
					.appendEnumList(
							request.getObservationLevelRelationships().stream().filter(r -> r.getLevelName() != null)
									.map(r -> r.getLevelName()).collect(Collectors.toList()),
							"*levelRelationship.levelName")
					.appendList(
							request.getObservationLevelRelationships().stream().filter(r -> r.getLevelCode() != null)
									.map(r -> r.getLevelCode()).collect(Collectors.toList()),
							"*levelRelationship.levelCode")
					.appendIntList(
							request.getObservationLevelRelationships().stream().filter(r -> r.getLevelOrder() != null)
									.map(r -> r.getLevelOrder()).collect(Collectors.toList()),
							"*levelRelationship.levelOrder")
					.appendList(
							request.getObservationLevelRelationships().stream().filter(r -> r.getObservationUnitDbId() != null)
									.map(r -> r.getObservationUnitDbId()).collect(Collectors.toList()),
							"*levelRelationship.observationUnit.id");
		}
		searchQuery = searchQuery.withExRefs(request.getExternalReferenceIDs(), request.getExternalReferenceSources())
				.appendList(request.getGermplasmDbIds(), "germplasm.id")
				.appendList(request.getGermplasmNames(), "germplasm.germplasmName")
				.appendList(request.getLocationDbIds(), "study.location.id")
				.appendList(request.getLocationNames(), "study.location.locationName")
				.appendList(request.getObservationUnitDbIds(), "id").appendList(request.getProgramDbIds(), "program.id")
				.appendList(request.getProgramNames(), "program.name").appendList(request.getStudyDbIds(), "study.id")
				.appendList(request.getStudyNames(), "study.studyName").appendList(request.getTrialDbIds(), "trial.id")
				.appendList(request.getTrialNames(), "trial.trailName");

		log.debug("Starting search");
		Page<ObservationUnitEntity> page = observationUnitRepository.findAllBySearch(searchQuery, pageReq);
		log.debug("Search complete");

		if(!page.isEmpty()) {
			observationUnitRepository.fetchXrefs(page, ObservationUnitEntity.class);
			fetchTreatments(page);
			fetchObsUnitLevelRelationships(page);
		}
		return page;
	}

	private void fetchTreatments(Page<ObservationUnitEntity> page) {
		SearchQueryBuilder<ObservationUnitEntity> searchQuery = new SearchQueryBuilder<ObservationUnitEntity>(
				ObservationUnitEntity.class);
		searchQuery.leftJoinFetch("treatments", "treatments")
				   .appendList(page.stream().map(BrAPIBaseEntity::getId).collect(Collectors.toList()), "id");

		Page<ObservationUnitEntity> treatments = observationUnitRepository.findAllBySearch(searchQuery, PageRequest.of(0, page.getSize()));

		Map<String, List<TreatmentEntity>> treatmentsByOu = new HashMap<>();
		treatments.forEach(ou -> treatmentsByOu.put(ou.getId(), ou.getTreatments()));

		page.forEach(ou -> ou.setTreatments(treatmentsByOu.get(ou.getId())));
	}

	private void fetchObsUnitLevelRelationships(Page<ObservationUnitEntity> page) {
		SearchQueryBuilder<ObservationUnitEntity> searchQuery = new SearchQueryBuilder<ObservationUnitEntity>(
				ObservationUnitEntity.class);
		searchQuery.leftJoinFetch("position", "position")
				   .leftJoinFetch("*position.observationLevelRelationships", "observationLevelRelationships")
				   .appendList(page.stream().map(BrAPIBaseEntity::getId).collect(Collectors.toList()), "id");

		Page<ObservationUnitEntity> positions = observationUnitRepository.findAllBySearch(searchQuery, PageRequest.of(0, page.getSize()));

		Map<String, ObservationUnitPositionEntity> positionByOu = new HashMap<>();
		positions.forEach(ou -> positionByOu.put(ou.getId(), ou.getPosition()));

		page.forEach(ou -> {
			if(ou.getPosition() != null) {
				ou.getPosition()
				  .setObservationLevelRelationships(positionByOu.get(ou.getId())
																.getObservationLevelRelationships());
			}
		});
	}

	public ObservationUnit getObservationUnit(String observationUnitDbId) throws BrAPIServerException {
		return convertFromEntity(getObservationUnitEntity(observationUnitDbId, HttpStatus.NOT_FOUND));
	}

	public ObservationUnitEntity getObservationUnitEntity(String observationUnitDbId) throws BrAPIServerException {
		return getObservationUnitEntity(observationUnitDbId, HttpStatus.BAD_REQUEST);
	}

	public ObservationUnitEntity getObservationUnitEntity(String observationUnitDbId, HttpStatus errorStatus)
			throws BrAPIServerException {
		if(observationUnitDbId == null) {
			throw new BrAPIServerDbIdNotFoundException("observationUnit", "null", errorStatus);
		}
		ObservationUnitEntity observationUnit = null;
		Optional<ObservationUnitEntity> entityOpt = observationUnitRepository.findById(observationUnitDbId);
		if (entityOpt.isPresent()) {
			observationUnit = entityOpt.get();
		} else {
			throw new BrAPIServerDbIdNotFoundException("observationUnit", observationUnitDbId, errorStatus);
		}
		return observationUnit;
	}

	public List<ObservationUnit> saveObservationUnits(@Valid List<ObservationUnitNewRequest> requests)
			throws BrAPIServerException {
		List<ObservationUnit> savedObservationUnits = new ArrayList<>();

		for (ObservationUnitNewRequest request : requests) {
			ObservationUnitEntity entity = new ObservationUnitEntity();
			updateEntity(entity, request);
			ObservationUnitEntity savedEntity = observationUnitRepository.save(entity);
			savedObservationUnits.add(convertFromEntity(savedEntity));
		}

		return savedObservationUnits;
	}

	public List<ObservationUnit> updateObservationUnits(@Valid Map<String, ObservationUnitNewRequest> requests)
			throws BrAPIServerException {
		List<ObservationUnit> savedObservationUnits = new ArrayList<>();

		for (Entry<String, ObservationUnitNewRequest> entry : requests.entrySet()) {
			ObservationUnit saved = updateObservationUnit(entry.getKey(), entry.getValue());
			savedObservationUnits.add(saved);
		}

		return savedObservationUnits;
	}

	public ObservationUnit updateObservationUnit(String observationUnitDbId, @Valid ObservationUnitNewRequest request)
			throws BrAPIServerException {
		ObservationUnitEntity entity = getObservationUnitEntity(observationUnitDbId, HttpStatus.NOT_FOUND);
		updateEntity(entity, request);
		ObservationUnitEntity savedEntity = observationUnitRepository.save(entity);

		return convertFromEntity(savedEntity);
	}

	public List<ObservationUnitHierarchyLevel> findObservationLevels(String studyDbId, String trialDbId,
			String programDbId, Metadata metadata) {

		List<ObservationUnitLevel> allLevels = Arrays.asList(ObservationUnitHierarchyLevelEnum.values()).stream()
				.map(levelEnum -> {
					ObservationUnitLevel rel = new ObservationUnitLevel();
					rel.setLevelName(levelEnum);
					return rel;
				}).collect(Collectors.toList());

		ObservationUnitSearchRequest levelsSearch = buildObservationUnitsSearchRequest(null, null, null, studyDbId,
				null, trialDbId, programDbId, null, null, null, null, null, null, null, null, null, false, null, null,
				null);

		levelsSearch.setObservationLevels(allLevels);
		List<ObservationUnit> units = new ArrayList<>();
		List<ObservationUnit> someunits = findObservationUnits(levelsSearch,
				new Metadata().pagination(new IndexPagination()));
		units.addAll(someunits);

		levelsSearch.setObservationLevelRelationships(allLevels.stream().map(lvl -> {
			ObservationUnitLevelRelationship rel = new ObservationUnitLevelRelationship();
			rel.setLevelCode(lvl.getLevelCode());
			rel.setLevelName(lvl.getLevelName());
			rel.setLevelOrder(lvl.getLevelOrder());
			return rel;
		}).collect(Collectors.toList()));
		levelsSearch.setObservationLevels(null);
		List<ObservationUnit> moreUnits = findObservationUnits(levelsSearch,
				new Metadata().pagination(new IndexPagination()));
		units.addAll(moreUnits);

		List<ObservationUnitHierarchyLevel> levels = units.stream()
				.filter(unit -> unit.getObservationUnitPosition() != null)
				.filter(unit -> unit.getObservationUnitPosition().getObservationLevelRelationships() != null)
				.filter(unit -> unit.getObservationUnitPosition().getObservationLevel() != null)
				.filter(unit -> unit.getObservationUnitPosition().getObservationLevel().getLevelName() != null)
				.map(unit -> {
					List<ObservationUnitLevel> list = new ArrayList<>();
					for (ObservationUnitLevel level : unit.getObservationUnitPosition()
							.getObservationLevelRelationships()) {
						list.add(level);
					}
					list.add(unit.getObservationUnitPosition().getObservationLevel());
					return list;
				}).flatMap(list -> list.stream()).map(level -> level.getLevelName()).distinct().sorted()
				.map(levelName -> {
					ObservationUnitHierarchyLevel level = new ObservationUnitHierarchyLevel();
					level.setLevelName(levelName);
					level.setLevelOrder(levelName.ordinal());
					return level;
				}).collect(Collectors.toList());

		return PagingUtility.paginateSimpleList(levels, metadata);
	}

	private ObservationUnit convertFromEntity(ObservationUnitEntity entity) {
		return convertFromEntity(entity, true);
	}

	private ObservationUnit convertFromEntity(ObservationUnitEntity entity, boolean convertObservations) {
		log.trace("converting ou: " + entity.getId());
		ObservationUnit unit = new ObservationUnit();
		UpdateUtility.convertFromEntity(entity, unit);

		if (entity.getGermplasm() != null) {
			unit.setGermplasmDbId(entity.getGermplasm().getId());
			unit.setGermplasmName(entity.getGermplasm().getGermplasmName());
		}
		if (entity.getCross() != null) {
			unit.setCrossDbId(entity.getCross().getId());
			unit.setCrossName(entity.getCross().getName());
		}
		if (convertObservations && entity.getObservations() != null) {
			unit.setObservations(entity.getObservations().stream().map(this.observationService::convertFromEntity)
					.collect(Collectors.toList()));
		}
		unit.setObservationUnitDbId(entity.getId());
		unit.setObservationUnitName(entity.getObservationUnitName());
		unit.setObservationUnitPosition(convertFromEntity(entity.getPosition(), entity.getId()));
		unit.setObservationUnitPUI(entity.getObservationUnitPUI());
		if (entity.getSeedLot() != null) {
			unit.setSeedLotDbId(entity.getSeedLot().getId());
			unit.setSeedLotName(entity.getSeedLot().getName());
		}
		if (entity.getTreatments() != null)
			unit.setTreatments(
					entity.getTreatments().stream().map(this::convertFromEntity).collect(Collectors.toList()));

		if (entity.getStudy() != null) {
			unit.setStudyDbId(entity.getStudy().getId());
			unit.setStudyName(entity.getStudy().getStudyName());
			if (entity.getStudy().getLocation() != null) {
				unit.setLocationDbId(entity.getStudy().getLocation().getId());
				unit.setLocationName(entity.getStudy().getLocation().getLocationName());
			}
			if (entity.getStudy().getTrial() != null) {
				unit.setTrialDbId(entity.getStudy().getTrial().getId());
				unit.setTrialName(entity.getStudy().getTrial().getTrialName());
				if (entity.getStudy().getTrial().getProgram() != null) {
					unit.setProgramDbId(entity.getStudy().getTrial().getProgram().getId());
					unit.setProgramName(entity.getStudy().getTrial().getProgram().getName());
				}
			}
		} 
		if (entity.getTrial() != null) {
			unit.setTrialDbId(entity.getTrial().getId());
			unit.setTrialName(entity.getTrial().getTrialName());
			if (entity.getTrial().getProgram() != null) {
				unit.setProgramDbId(entity.getTrial().getProgram().getId());
				unit.setProgramName(entity.getTrial().getProgram().getName());
			}
		} 
		if (entity.getProgram() != null) {
			unit.setProgramDbId(entity.getProgram().getId());
			unit.setProgramName(entity.getProgram().getName());
		}

		return unit;

	}

	private ObservationUnitPosition convertFromEntity(ObservationUnitPositionEntity entity, String ouDbId) {
		ObservationUnitPosition position = null;
		if (entity != null) {
			position = new ObservationUnitPosition();
			position.setEntryType(entity.getEntryType());
			position.setGeoCoordinates(GeoJSONUtility.convertFromEntity(entity.getGeoCoordinates()));
			ObservationUnitLevel level = new ObservationUnitLevel();
			level.setLevelCode(entity.getLevelCode());
			level.setLevelName(entity.getLevelName());
			level.setLevelOrder(entity.getLevelOrder());
			position.setObservationLevel(level);
			if (entity.getObservationLevelRelationships() != null) {
				position.setObservationLevelRelationships(entity.getObservationLevelRelationships().stream()
						.map(rel -> this.convertFromEntity(rel, ouDbId)).collect(Collectors.toList()));
			}
			position.setPositionCoordinateX(entity.getPositionCoordinateX());
			position.setPositionCoordinateXType(entity.getPositionCoordinateXType());
			position.setPositionCoordinateY(entity.getPositionCoordinateY());
			position.setPositionCoordinateYType(entity.getPositionCoordinateYType());
		}
		return position;
	}

	private ObservationTreatment convertFromEntity(TreatmentEntity entity) {
		ObservationTreatment treatment = new ObservationTreatment();
		treatment.setFactor(entity.getFactor());
		treatment.setModality(entity.getModality());
		return treatment;
	}

	private ObservationUnitLevelRelationship convertFromEntity(ObservationUnitLevelRelationshipEntity entity, String ouDbId) {
		ObservationUnitLevelRelationship level = new ObservationUnitLevelRelationship();
		level.setLevelCode(entity.getLevelCode());
		level.setLevelName(entity.getLevelName());
		level.setLevelOrder(entity.getLevelOrder());
		if (ouDbId != null)
			level.setObservationUnitDbId(ouDbId);
		return level;
	}

	private ObservationUnitEntity updateEntity(ObservationUnitEntity entity, ObservationUnitNewRequest unit)
			throws BrAPIServerException {
		UpdateUtility.updateEntity(unit, entity);

		if (unit.getGermplasmDbId() != null) {
			GermplasmEntity germplasm = germplasmService.getGermplasmEntity(unit.getGermplasmDbId());
			entity.setGermplasm(germplasm);
		}
		if (unit.getCrossDbId() != null) {
			CrossEntity cross = crossService.getCrossEntity(unit.getCrossDbId(), false);
			entity.setCross(cross);
		}
		if (unit.getObservationUnitName() != null)
			entity.setObservationUnitName(unit.getObservationUnitName());
		if (unit.getObservationUnitPUI() != null)
			entity.setObservationUnitPUI(unit.getObservationUnitPUI());
		if (unit.getObservationUnitPosition() != null) {
			if (entity.getPosition() == null)
				entity.setPosition(new ObservationUnitPositionEntity());
			ObservationUnitPositionEntity position = entity.getPosition();
			updateEntity(position, unit.getObservationUnitPosition());
			position.setObservationUnit(entity);
			entity.setPosition(position);
		}
		if (unit.getSeedLotDbId() != null) {
			SeedLotEntity seedLot = seedLotService.getSeedLotEntity(unit.getSeedLotDbId());
			entity.setSeedLot(seedLot);
		}
		if (unit.getTreatments() != null)
			entity.setTreatments(unit.getTreatments().stream().map(t -> {
				TreatmentEntity e = new TreatmentEntity();
				e.setFactor(t.getFactor());
				e.setModality(t.getModality());
				e.setObservationUnit(entity);
				return e;
			}).collect(Collectors.toList()));

		if (unit.getStudyDbId() != null) {
			StudyEntity study = studyService.getStudyEntity(unit.getStudyDbId());
			entity.setStudy(study);
		} else if (unit.getTrialDbId() != null) {
			TrialEntity trial = trialService.getTrialEntity(unit.getTrialDbId());
			entity.setTrial(trial);
		} else if (unit.getProgramDbId() != null) {
			ProgramEntity program = programService.getProgramEntity(unit.getProgramDbId());
			entity.setProgram(program);
		}

		return entity;
	}

	private void updateEntity(ObservationUnitPositionEntity entity, ObservationUnitPosition position) {

		if (position.getEntryType() != null)
			entity.setEntryType(position.getEntryType());
		if (position.getGeoCoordinates() != null)
			entity.setGeoCoordinates(GeoJSONUtility.convertToEntity(position.getGeoCoordinates()));
		if (position.getObservationLevel() != null) {
			if (position.getObservationLevel().getLevelCode() != null)
				entity.setLevelCode(position.getObservationLevel().getLevelCode());
			if (position.getObservationLevel().getLevelName() != null)
				entity.setLevelName(position.getObservationLevel().getLevelName());
			if (position.getObservationLevel().getLevelOrder() != null)
				entity.setLevelOrder(position.getObservationLevel().getLevelOrder());
		}
		if (position.getObservationLevelRelationships() != null)
			entity.setObservationLevelRelationships(position.getObservationLevelRelationships().stream().map(level -> {
				ObservationUnitLevelRelationshipEntity relationshipEntity = new ObservationUnitLevelRelationshipEntity();
				try {
					relationshipEntity.setLevelCode(level.getLevelCode());
					relationshipEntity.setLevelName(level.getLevelName());
					relationshipEntity.setLevelOrder(level.getLevelOrder());
					if (level.getObservationUnitDbId() != null) {
						ObservationUnitEntity parentEntity = getObservationUnitEntity(level.getObservationUnitDbId());
						relationshipEntity.setObservationUnit(parentEntity);
					}
					relationshipEntity.setPosition(entity);
				} catch (BrAPIServerException e) {
					e.printStackTrace();
				}
				return relationshipEntity;
			}).collect(Collectors.toList()));
		if (position.getPositionCoordinateX() != null)
			entity.setPositionCoordinateX(position.getPositionCoordinateX());
		if (position.getPositionCoordinateXType() != null)
			entity.setPositionCoordinateXType(position.getPositionCoordinateXType());
		if (position.getPositionCoordinateY() != null)
			entity.setPositionCoordinateY(position.getPositionCoordinateY());
		if (position.getPositionCoordinateYType() != null)
			entity.setPositionCoordinateYType(position.getPositionCoordinateYType());

	}

	private List<List<String>> buildDataMatrix(Page<ObservationUnitEntity> observationUnits,
			List<ObservationVariable> variables) {
		List<List<String>> data = new ArrayList<>();
		for (ObservationUnitEntity obsUnit : observationUnits) {
			List<String> row = new ArrayList<>();

			if (obsUnit.getStudy() != null) {
				StudyEntity study = obsUnit.getStudy();
				if (study.getSeasons() != null && !study.getSeasons().isEmpty()) {
					row.add(printIfNotNull(study.getSeasons().get(0).getYear())); // YEAR
				} else {
					row.add(""); // YEAR
				}

				row.add(printIfNotNull(study.getId())); // STUDYDBID
				row.add(printIfNotNull(study.getStudyName())); // STUDYNAME
//
//				if (study.getLocation() != null) {
//					row.add(printIfNotNull(study.getLocation().getId())); // LOCATIONDBID
//					row.add(printIfNotNull(study.getLocation().getLocationName())); // LOCATIONNAME
//				} else {
//					row.add(""); // LOCATIONDBID
//					row.add(""); // LOCATIONNAME
//				}

			} else {
				row.add(""); // YEAR
				row.add(""); // STUDYDBID
				row.add(""); // STUDYNAME
				row.add(""); // LOCATIONDBID
				row.add(""); // LOCATIONNAME
			}

			if (obsUnit.getGermplasm() != null) {
				row.add(printIfNotNull(obsUnit.getGermplasm().getId())); // GERMPLASMDBID
				row.add(printIfNotNull(obsUnit.getGermplasm().getGermplasmName())); // GERMPLASMNAME
			} else {
				row.add(""); // GERMPLASMDBID
				row.add(""); // GERMPLASMNAME
			}

			row.add(printIfNotNull(obsUnit.getId())); // OBSERVATIONUNITDBID
			row.add(printIfNotNull(obsUnit.getObservationUnitName())); // OBSERVATIONUNITNAME

			if (obsUnit.getPosition() != null) {
				row.add(printIfNotNull(obsUnit.getPosition().getPositionCoordinateX())); // POSITIONCOORDINATEX
				row.add(printIfNotNull(obsUnit.getPosition().getPositionCoordinateY())); // POSITIONCOORDINATEY
				row.add(printIfNotNull(obsUnit.getPosition().getFieldCode())); // FIELD
				row.add(printIfNotNull(obsUnit.getPosition().getBlockCode())); // BLOCK
				row.add(printIfNotNull(obsUnit.getPosition().getEntryCode())); // ENTRY
				row.add(printIfNotNull(obsUnit.getPosition().getRepCode())); // REP
				row.add(printIfNotNull(obsUnit.getPosition().getPlotCode())); // PLOT
				row.add(printIfNotNull(obsUnit.getPosition().getPlantCode())); // PLANT
			} else {
				row.add(""); // POSITIONCOORDINATEX
				row.add(""); // POSITIONCOORDINATEY
				row.add(""); // FIELD
				row.add(""); // BLOCK
				row.add(""); // ENTRY
				row.add(""); // REP
				row.add(""); // PLOT
				row.add(""); // PLANT
			}

			for (ObservationVariable var : variables) {
				Optional<ObservationEntity> obsOption = obsUnit.getObservations().stream().filter((obs) -> {
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

	private String printIfNotNull(Object toPrint) {
		if (toPrint == null) {
			return "";
		}
		return toPrint.toString();
	}

	private List<ObservationTableHeaderRowEnum> buildHeaderRow() {
		List<ObservationTableHeaderRowEnum> headers = new ArrayList<>();
		headers.add(ObservationTableHeaderRowEnum.YEAR);
		headers.add(ObservationTableHeaderRowEnum.STUDYDBID);
		headers.add(ObservationTableHeaderRowEnum.STUDYNAME);
//		headers.add(ObservationTableHeaderRowEnum.LOCATIONDBID);
//		headers.add(ObservationTableHeaderRowEnum.LOCATIONNAME);
		headers.add(ObservationTableHeaderRowEnum.GERMPLASMDBID);
		headers.add(ObservationTableHeaderRowEnum.GERMPLASMNAME);
		headers.add(ObservationTableHeaderRowEnum.OBSERVATIONUNITDBID);
		headers.add(ObservationTableHeaderRowEnum.OBSERVATIONUNITNAME);
		headers.add(ObservationTableHeaderRowEnum.POSITIONCOORDINATEX);
		headers.add(ObservationTableHeaderRowEnum.POSITIONCOORDINATEY);
		headers.add(ObservationTableHeaderRowEnum.FIELD);
		headers.add(ObservationTableHeaderRowEnum.BLOCK);
		headers.add(ObservationTableHeaderRowEnum.ENTRY);
		headers.add(ObservationTableHeaderRowEnum.REP);
		headers.add(ObservationTableHeaderRowEnum.PLOT);
		headers.add(ObservationTableHeaderRowEnum.PLANT);

		return headers;
	}

	public String getObservationUnitTableText(ObservationUnitTable table, String sep) {
		StringBuilder responseBuilder = new StringBuilder();

		for (ObservationTableHeaderRowEnum header : table.getHeaderRow()) {
			responseBuilder.append("\"" + header.toString() + "\"");
			responseBuilder.append(sep);
		}
		int i = 1;
		for (ObservationTableObservationVariables header : table.getObservationVariables()) {
			responseBuilder.append("\"" + header.getObservationVariableDbId() + "\"");
			if (i < table.getObservationVariables().size()) {
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

	private ObservationTableObservationVariables convertVariables(ObservationVariable variable) {
		ObservationTableObservationVariables header = new ObservationTableObservationVariables();
		header.setObservationVariableDbId(variable.getObservationVariableDbId());
		header.setObservationVariableName(variable.getObservationVariableName());
		return header;
	}
}
