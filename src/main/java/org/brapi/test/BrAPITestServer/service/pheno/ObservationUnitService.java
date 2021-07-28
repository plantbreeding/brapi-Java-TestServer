package org.brapi.test.BrAPITestServer.service.pheno;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.core.ProgramEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.StudyEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.TrialEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.GermplasmEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.SeedLotEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationUnitEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationUnitLevelRelationshipEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationUnitPositionEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.TreatmentEntity;
import org.brapi.test.BrAPITestServer.repository.pheno.ObservationUnitRepository;
import org.brapi.test.BrAPITestServer.service.GeoJSONUtility;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.brapi.test.BrAPITestServer.service.core.ProgramService;
import org.brapi.test.BrAPITestServer.service.core.StudyService;
import org.brapi.test.BrAPITestServer.service.core.TrialService;
import org.brapi.test.BrAPITestServer.service.germ.GermplasmService;
import org.brapi.test.BrAPITestServer.service.germ.SeedLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.IndexPagination;
import io.swagger.model.Metadata;
import io.swagger.model.pheno.Observation;
import io.swagger.model.pheno.ObservationTableHeaderRowEnum;
import io.swagger.model.pheno.ObservationTableObservationVariables;
import io.swagger.model.pheno.ObservationTreatment;
import io.swagger.model.pheno.ObservationUnit;
import io.swagger.model.pheno.ObservationUnitHierarchyLevel;
import io.swagger.model.pheno.ObservationUnitHierarchyLevelEnum;
import io.swagger.model.pheno.ObservationUnitLevelRelationship;
import io.swagger.model.pheno.ObservationUnitNewRequest;
import io.swagger.model.pheno.ObservationUnitPosition;
import io.swagger.model.pheno.ObservationUnitSearchRequest;
import io.swagger.model.pheno.ObservationUnitTable;
import io.swagger.model.pheno.ObservationVariable;
import io.swagger.model.pheno.ObservationVariableSearchRequest;

@Service
public class ObservationUnitService {
	private final ObservationUnitRepository observationUnitRepository;
	
	private final GermplasmService germplasmService;
	private final ObservationService observationService;
	private final StudyService studyService;
	private final TrialService trialService;
	private final ProgramService programService;
	private final SeedLotService seedLotService;
	private final ObservationVariableService observationVariableService;

	@Autowired
	public ObservationUnitService(ObservationUnitRepository observationUnitRepository, StudyService studyService, TrialService trialService, ProgramService programService,
			ObservationService observationService, GermplasmService germplasmService, SeedLotService seedLotService,
			ObservationVariableService observationVariableService) {
		this.observationUnitRepository = observationUnitRepository;
		
		this.studyService = studyService;
		this.trialService = trialService;
		this.programService = programService;
		this.germplasmService = germplasmService;
		this.observationService = observationService;
		this.seedLotService = seedLotService;
		this.observationVariableService = observationVariableService;
	}

	public List<ObservationUnit> findObservationUnits(String observationUnitDbId, String germplasmDbId,
			String studyDbId, String locationDbId, String trialDbId, String programDbId, String seasonDbId,
			String observationUnitLevelName, String observationUnitLevelOrder, String observationUnitLevelCode,
			Boolean includeObservations, String externalReferenceID, String externalReferenceSource,
			Metadata metadata) {
		ObservationUnitSearchRequest request = new ObservationUnitSearchRequest();
		if (observationUnitDbId != null)
			request.addObservationUnitDbIdsItem(observationUnitDbId);
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
			ObservationUnitLevelRelationship level = new ObservationUnitLevelRelationship();
			if (observationUnitLevelName != null)
				level.setLevelName(ObservationUnitHierarchyLevelEnum.fromValue(observationUnitLevelName));
			if (observationUnitLevelOrder != null)
				level.setLevelOrder(Integer.decode(observationUnitLevelOrder));
			if (observationUnitLevelCode != null)
				level.setLevelCode(observationUnitLevelCode);
			request.addObservationLevelsItem(level);
		}
		if (includeObservations != null)
			request.setIncludeObservations(includeObservations);
		if (externalReferenceID != null)
			request.addExternalReferenceIDsItem(externalReferenceID);
		if (externalReferenceSource != null)
			request.addExternalReferenceSourcesItem(externalReferenceSource);

		return findObservationUnits(request, metadata);
	}

	public ObservationUnitTable findObservationUnitsTable(String observationUnitDbId, String germplasmDbId,
			String observationVariableDbId, String studyDbId, String locationDbId, String trialDbId, String programDbId,
			String seasonDbId, String observationLevel) {
		List<ObservationUnit> observationUnits = findObservationUnits(null, germplasmDbId, studyDbId, locationDbId,
				trialDbId, programDbId, seasonDbId, null, null, null, true, null, null, null);
		ObservationVariableSearchRequest request = new ObservationVariableSearchRequest();
		request.setObservationUnitDbIds(
				observationUnits.stream().map(ou -> ou.getObservationUnitDbId()).collect(Collectors.toList()));
		List<ObservationVariable> variables = observationVariableService.findObservationVariables(request, null);
		ObservationUnitTable table = new ObservationUnitTable();
		table.setData(buildDataMatrix(observationUnits, variables));
		table.setHeaderRow(buildHeaderRow());
		table.setObservationVariables(variables.stream().map(this::convertVariables).collect(Collectors.toList()));
		return table;
	}

	public List<ObservationUnit> findObservationUnits(@Valid ObservationUnitSearchRequest request, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<ObservationUnitEntity> searchQuery = new SearchQueryBuilder<ObservationUnitEntity>(
				ObservationUnitEntity.class);
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
			searchQuery = searchQuery.join("position.levelRelationships", "levelRelationship")
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
							"*levelRelationship.levelOrder");
		}
		searchQuery = searchQuery.withExRefs(request.getExternalReferenceIDs(), request.getExternalReferenceSources())
				.appendList(request.getGermplasmDbIds(), "germplasm.id")
				.appendList(request.getGermplasmNames(), "germplasm.germplasmName")
				.appendList(request.getLocationDbIds(), "study.location.id")
				.appendList(request.getLocationNames(), "study.location.locationName")
				.appendList(request.getObservationUnitDbIds(), "id")
				.appendList(request.getProgramDbIds(), "program.id")
				.appendList(request.getProgramNames(), "program.name")
				.appendList(request.getStudyDbIds(), "study.id")
				.appendList(request.getStudyNames(), "study.studyName")
				.appendList(request.getTrialDbIds(), "trial.id")
				.appendList(request.getTrialNames(), "trial.trailName");

		Page<ObservationUnitEntity> page = observationUnitRepository.findAllBySearch(searchQuery, pageReq);
		List<ObservationUnit> observationUnits = page.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, page);
		
		if (request.isIncludeObservations() == null || !request.isIncludeObservations()) {
			for (ObservationUnit ou : observationUnits) {
				ou.setObservations(null);
			}
		}

		return observationUnits;
	}

	public ObservationUnit getObservationUnit(String observationUnitDbId) throws BrAPIServerException {
		return convertFromEntity(getObservationUnitEntity(observationUnitDbId, HttpStatus.NOT_FOUND));
	}

	public ObservationUnitEntity getObservationUnitEntity(String observationUnitDbId) throws BrAPIServerException {
		return getObservationUnitEntity(observationUnitDbId, HttpStatus.BAD_REQUEST);
	}

	public ObservationUnitEntity getObservationUnitEntity(String observationUnitDbId, HttpStatus errorStatus)
			throws BrAPIServerException {
		ObservationUnitEntity observationUnit = null;
		Optional<ObservationUnitEntity> entityOpt = observationUnitRepository.findById(observationUnitDbId);
		if (entityOpt.isPresent()) {
			observationUnit = entityOpt.get();
		} else {
			throw new BrAPIServerException(errorStatus, "observationUnitDbId not found: " + observationUnitDbId);
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
		ObservationUnitEntity savedEntity;
		Optional<ObservationUnitEntity> entityOpt = observationUnitRepository.findById(observationUnitDbId);
		if (entityOpt.isPresent()) {
			ObservationUnitEntity entity = entityOpt.get();
			updateEntity(entity, request);

			savedEntity = observationUnitRepository.save(entity);
		} else {
			throw new BrAPIServerException(HttpStatus.NOT_FOUND,
					"observationUnitDbId not found: " + observationUnitDbId);
		}

		return convertFromEntity(savedEntity);
	}

	public List<ObservationUnitHierarchyLevel> findObservationLevels(String studyDbId, String trialDbId,
			String programDbId, Metadata metadata) {
		List<ObservationUnit> units = findObservationUnits(null, null, studyDbId, null, trialDbId, programDbId, null,
				null, null, null, false, null, null, new Metadata().pagination(new IndexPagination()));
		List<ObservationUnitHierarchyLevel> levels = units.stream()
				.filter(unit -> unit.getObservationUnitPosition() != null)
				.filter(unit -> unit.getObservationUnitPosition().getObservationLevelRelationships() != null)
				.filter(unit -> unit.getObservationUnitPosition().getObservationLevel() != null).map(unit -> {
					List<ObservationUnitLevelRelationship> list = unit.getObservationUnitPosition()
							.getObservationLevelRelationships();
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
		ObservationUnit unit = new ObservationUnit();
		unit.setAdditionalInfo(entity.getAdditionalInfoMap());
		unit.setExternalReferences(entity.getExternalReferencesMap());
		if (entity.getGermplasm() != null) {
			unit.setGermplasmDbId(entity.getGermplasm().getId());
			unit.setGermplasmName(entity.getGermplasm().getGermplasmName());
		}
		if (entity.getObservations() != null) {
			unit.setObservations(entity.getObservations().stream().map(this.observationService::convertFromEntity)
					.collect(Collectors.toList()));
		}
		unit.setObservationUnitDbId(entity.getId());
		unit.setObservationUnitName(entity.getObservationUnitName());
		unit.setObservationUnitPosition(convertFromEntity(entity.getPosition()));
		unit.setObservationUnitPUI(entity.getObservationUnitPUI());
		if (entity.getSeedLot() != null)
			unit.setSeedLotDbId(entity.getSeedLot().getId());
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
		} else if (entity.getTrial() != null) {
			unit.setTrialDbId(entity.getTrial().getId());
			unit.setTrialName(entity.getTrial().getTrialName());
			if (entity.getTrial().getProgram() != null) {
				unit.setProgramDbId(entity.getTrial().getProgram().getId());
				unit.setProgramName(entity.getTrial().getProgram().getName());
			}
		} else if (entity.getProgram() != null) {
			unit.setProgramDbId(entity.getProgram().getId());
			unit.setProgramName(entity.getProgram().getName());
		}
		
		return unit;

	}

	private ObservationUnitPosition convertFromEntity(ObservationUnitPositionEntity entity) {
		ObservationUnitPosition position = null;
		if (entity != null) {
			position = new ObservationUnitPosition();
			position.setEntryType(entity.getEntryType());
			position.setGeoCoordinates(GeoJSONUtility.convertFromEntity(entity.getGeoCoordinates()));
			ObservationUnitLevelRelationship level = new ObservationUnitLevelRelationship();
			level.setLevelCode(entity.getLevelCode());
			level.setLevelName(entity.getLevelName());
			level.setLevelOrder(entity.getLevelOrder());
			position.setObservationLevel(level);
			if (entity.getObservationLevelRelationships() != null) {
				position.setObservationLevelRelationships(entity.getObservationLevelRelationships().stream()
						.map(this::convertFromEntity).collect(Collectors.toList()));
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

	private ObservationUnitLevelRelationship convertFromEntity(ObservationUnitLevelRelationshipEntity entity) {
		ObservationUnitLevelRelationship level = new ObservationUnitLevelRelationship();
		level.setLevelCode(entity.getLevelCode());
		level.setLevelName(entity.getLevelName());
		level.setLevelOrder(entity.getLevelOrder());
		return level;
	}

	private ObservationUnitEntity updateEntity(ObservationUnitEntity entity, ObservationUnitNewRequest body)
			throws BrAPIServerException {
		if (body.getAdditionalInfo() != null)
			entity.setAdditionalInfo(body.getAdditionalInfo());
		if (body.getExternalReferences() != null)
			entity.setExternalReferences(body.getExternalReferences());
		if (body.getGermplasmDbId() != null) {
			GermplasmEntity germplasm = germplasmService.getGermplasmEntity(body.getGermplasmDbId());
			entity.setGermplasm(germplasm);
		}
		if (body.getObservationUnitName() != null)
			entity.setObservationUnitName(body.getObservationUnitName());
		if (body.getObservationUnitPUI() != null)
			entity.setObservationUnitPUI(body.getObservationUnitPUI());
		if (body.getObservationUnitPosition() != null) {
			if (entity.getPosition() == null)
				entity.setPosition(new ObservationUnitPositionEntity());
			ObservationUnitPositionEntity position = entity.getPosition();
			updateEntity(position, body.getObservationUnitPosition());
			position.setObservationUnit(entity);
			entity.setPosition(position);
		}
		if (body.getSeedLotDbId() != null) {
			SeedLotEntity seedLot = seedLotService.getSeedLotEntity(body.getSeedLotDbId());
			entity.setSeedLot(seedLot);
		}
		if (body.getTreatments() != null)
			entity.setTreatments(body.getTreatments().stream().map(t -> {
				TreatmentEntity e = new TreatmentEntity();
				e.setFactor(t.getFactor());
				e.setModality(t.getModality());
				e.setObservationUnit(entity);
				return e;
			}).collect(Collectors.toList()));


		if (body.getStudyDbId() != null) {
			StudyEntity study = studyService.getStudyEntity(body.getStudyDbId());
			entity.setStudy(study);
		} else if (body.getTrialDbId() != null) {
			TrialEntity trial = trialService.getTrialEntity(body.getTrialDbId());
			entity.setTrial(trial);
		} else if (body.getProgramDbId() != null) {
			ProgramEntity program = programService.getProgramEntity(body.getProgramDbId());
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
			entity.setObservationLevelRelationships(position.getObservationLevelRelationships().stream()
					.map(level -> {
						ObservationUnitLevelRelationshipEntity relationshipEntity = new ObservationUnitLevelRelationshipEntity();
						relationshipEntity.setLevelCode(level.getLevelCode());
						relationshipEntity.setLevelName(level.getLevelName());
						relationshipEntity.setLevelOrder(level.getLevelOrder());
						relationshipEntity.setPosition(entity);
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

	private List<List<String>> buildDataMatrix(List<ObservationUnit> observationUnits,
			List<ObservationVariable> variables) {
		List<List<String>> data = new ArrayList<>();
		for (ObservationUnit unit : observationUnits) {
			List<String> row = new ArrayList<>();
			if (unit.getObservations() != null && !unit.getObservations().isEmpty()
					&& unit.getObservations().get(0).getSeason() != null)
				row.add(printIfNotNull(unit.getObservations().get(0).getSeason().getYear()));
			row.add(printIfNotNull(unit.getStudyDbId()));
			row.add(printIfNotNull(unit.getStudyName()));
			row.add(printIfNotNull(unit.getLocationDbId()));
			row.add(printIfNotNull(unit.getLocationName()));
			row.add(printIfNotNull(unit.getGermplasmDbId()));
			row.add(printIfNotNull(unit.getGermplasmName()));
			row.add(printIfNotNull(unit.getObservationUnitDbId()));
			if (unit.getObservationUnitPosition() != null) {
				row.add(printIfNotNull(unit.getObservationUnitPosition().getEntryType()));
				row.add(printIfNotNull(unit.getObservationUnitPosition().getPositionCoordinateX()));
				row.add(printIfNotNull(unit.getObservationUnitPosition().getPositionCoordinateY()));
			}

			for (ObservationVariable var : variables) {
				Optional<Observation> obsOption = unit.getObservations().stream().filter((obs) -> {
					return obs.getObservationVariableDbId() == var.getObservationVariableDbId();
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
		List<ObservationTableHeaderRowEnum> headers = Arrays.asList(ObservationTableHeaderRowEnum.values()).stream()
				.filter(h -> h != ObservationTableHeaderRowEnum.OBSERVATIONTIMESTAMP).collect(Collectors.toList());
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
