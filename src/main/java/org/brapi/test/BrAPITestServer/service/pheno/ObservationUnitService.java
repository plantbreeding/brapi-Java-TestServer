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
import org.brapi.test.BrAPITestServer.model.entity.core.StudyEntity;
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
import org.brapi.test.BrAPITestServer.service.core.StudyService;
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
	private final SeedLotService seedLotService;
	private final ObservationVariableService observationVariableService;

	@Autowired
	public ObservationUnitService(ObservationUnitRepository observationUnitRepository, StudyService studyService,
			ObservationService observationService, GermplasmService germplasmService, SeedLotService seedLotService,
			ObservationVariableService observationVariableService) {
		this.observationUnitRepository = observationUnitRepository;
		this.studyService = studyService;
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

	public ObservationUnitTable findObservationUnitsTable(String observationUnitDbId,
			String germplasmDbId, String observationVariableDbId, String studyDbId, String locationDbId,
			String trialDbId, String programDbId, String seasonDbId, String observationLevel) {
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
							.map(r -> r.getLevelName()).collect(Collectors.toList()), "position.level.name")
					.appendList(request.getObservationLevels().stream().filter(r -> r.getLevelCode() != null)
							.map(r -> r.getLevelCode()).collect(Collectors.toList()), "position.level.code")
					.appendIntList(request.getObservationLevels().stream().filter(r -> r.getLevelOrder() != null)
							.map(r -> r.getLevelOrder()).collect(Collectors.toList()), "position.level.order");
		}
		if (request.getObservationLevelRelationships() != null) {
			searchQuery = searchQuery.join("position.levelRelationships", "levelRelationship")
					.appendEnumList(
							request.getObservationLevelRelationships().stream().filter(r -> r.getLevelName() != null)
									.map(r -> r.getLevelName()).collect(Collectors.toList()),
							"*levelRelationship.name")
					.appendList(
							request.getObservationLevelRelationships().stream().filter(r -> r.getLevelCode() != null)
									.map(r -> r.getLevelCode()).collect(Collectors.toList()),
							"*levelRelationship.code")
					.appendIntList(
							request.getObservationLevelRelationships().stream().filter(r -> r.getLevelOrder() != null)
									.map(r -> r.getLevelOrder()).collect(Collectors.toList()),
							"*levelRelationship.order");
		}
		searchQuery = searchQuery.withExRefs(request.getExternalReferenceIDs(), request.getExternalReferenceSources())
				.appendList(request.getGermplasmDbIds(), "germplasm.id")
				.appendList(request.getGermplasmNames(), "germplasm.name")
				.appendList(request.getLocationDbIds(), "study.location.id")
				.appendList(request.getLocationNames(), "study.location.name")
				.appendList(request.getObservationUnitDbIds(), "id")
				.appendList(request.getProgramDbIds(), "study.trial.program.id")
				.appendList(request.getProgramNames(), "study.trial.program.name")
				.appendList(request.getStudyDbIds(), "study.id").appendList(request.getStudyNames(), "study.name")
				.appendList(request.getTrialDbIds(), "study.trial.id")
				.appendList(request.getTrialNames(), "study.trial.name");

		Page<ObservationUnitEntity> page = observationUnitRepository.findAllBySearch(searchQuery, pageReq);
		List<ObservationUnit> observationUnits = page.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, page);
		return observationUnits;
	}

	public ObservationUnit getObservationUnit(String observationUnitDbId) throws BrAPIServerException {
		return convertFromEntity(getObservationUnitEntity(observationUnitDbId));
	}

	public ObservationUnitEntity getObservationUnitEntity(String observationUnitDbId) throws BrAPIServerException {
		ObservationUnitEntity observationUnit = null;
		Optional<ObservationUnitEntity> entityOpt = observationUnitRepository.findById(observationUnitDbId);
		if (entityOpt.isPresent()) {
			observationUnit = entityOpt.get();
		} else {
			throw new BrAPIServerException(HttpStatus.NOT_FOUND, "DbId not found: " + observationUnitDbId);
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
			throw new BrAPIServerException(HttpStatus.NOT_FOUND, "DbId not found: " + observationUnitDbId);
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

	private ObservationUnitEntity updateEntity(ObservationUnitEntity entity, ObservationUnitNewRequest unit)
			throws BrAPIServerException {
		if (unit.getAdditionalInfo() != null)
			entity.setAdditionalInfo(unit.getAdditionalInfo());
		if (unit.getExternalReferences() != null)
			entity.setExternalReferences(unit.getExternalReferences());
		if (unit.getGermplasmDbId() != null) {
			GermplasmEntity germplasm = germplasmService.getGermplasmEntity(unit.getGermplasmDbId());
			entity.setGermplasm(germplasm);
		}
		if (unit.getObservationUnitName() != null)
			entity.setObservationUnitName(unit.getObservationUnitName());
		if (unit.getObservationUnitPUI() != null)
			entity.setObservationUnitPUI(unit.getObservationUnitPUI());
		if (unit.getObservationUnitPosition() != null) {
			if (entity.getPosition() == null)
				entity.setPosition(new ObservationUnitPositionEntity());
			updateEntity(entity.getPosition(), unit.getObservationUnitPosition());
		}
		if (unit.getSeedLotDbId() != null) {
			SeedLotEntity seedLot = seedLotService.getSeedLotEntity(unit.getSeedLotDbId());
			entity.setSeedLot(seedLot);
		}
		if (unit.getStudyDbId() != null) {
			StudyEntity study = studyService.getStudyEntity(unit.getStudyDbId());
			entity.setStudy(study);
		}
		if (unit.getTreatments() != null)
			entity.setTreatments(unit.getTreatments().stream().map(t -> {
				TreatmentEntity e = new TreatmentEntity();
				e.setFactor(t.getFactor());
				e.setModality(t.getFactor());
				return e;
			}).collect(Collectors.toList()));

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
					.map(this::convertToEntity).collect(Collectors.toList()));
		if (position.getPositionCoordinateX() != null)
			entity.setPositionCoordinateX(position.getPositionCoordinateX());
		if (position.getPositionCoordinateXType() != null)
			entity.setPositionCoordinateXType(position.getPositionCoordinateXType());
		if (position.getPositionCoordinateY() != null)
			entity.setPositionCoordinateY(position.getPositionCoordinateY());
		if (position.getPositionCoordinateYType() != null)
			entity.setPositionCoordinateYType(position.getPositionCoordinateYType());
	}

	private ObservationUnitLevelRelationshipEntity convertToEntity(ObservationUnitLevelRelationship level) {
		ObservationUnitLevelRelationshipEntity entity = new ObservationUnitLevelRelationshipEntity();
		entity.setLevelCode(level.getLevelCode());
		entity.setLevelName(level.getLevelName());
		entity.setLevelOrder(level.getLevelOrder());
		return entity;
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
