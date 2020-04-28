package org.brapi.test.BrAPITestServer.service.pheno;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.core.SeasonEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationUnitEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationVariableEntity;
import org.brapi.test.BrAPITestServer.repository.pheno.ObservationRepository;
import org.brapi.test.BrAPITestServer.service.DateUtility;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.brapi.test.BrAPITestServer.service.core.SeasonService;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.WSMIMEDataTypes;
import io.swagger.model.pheno.Observation;
import io.swagger.model.pheno.ObservationNewRequest;
import io.swagger.model.pheno.ObservationSearchRequest;
import io.swagger.model.pheno.ObservationTable;
import io.swagger.model.pheno.ObservationTableHeaderRowEnum;
import io.swagger.model.pheno.ObservationTableObservationVariables;
import io.swagger.model.pheno.ObservationUnitHierarchyLevelEnum;
import io.swagger.model.pheno.ObservationUnitLevelRelationship;
import io.swagger.model.pheno.ObservationVariable;
import io.swagger.model.pheno.ObservationVariableSearchRequest;

@Service
public class ObservationService {

	private final ObservationRepository observationRepository;
	private final SeasonService seasonService;
	private final ObservationUnitService observationUnitService;
	private final ObservationVariableService observationVariableService;

	public ObservationService(ObservationRepository observationRepository, SeasonService seasonService,
			@Lazy ObservationUnitService observationUnitService,
			ObservationVariableService observationVariableService) {
		this.observationRepository = observationRepository;
		this.seasonService = seasonService;
		this.observationUnitService = observationUnitService;
		this.observationVariableService = observationVariableService;
	}

	public List<Observation> findObservations(String observationDbId, String observationUnitDbId, String germplasmDbId,
			String observationVariableDbId, String studyDbId, String locationDbId, String trialDbId, String programDbId,
			String seasonDbId, String observationUnitLevelName, String observationUnitLevelOrder,
			String observationUnitLevelCode, OffsetDateTime observationTimeStampRangeStart,
			OffsetDateTime observationTimeStampRangeEnd, String externalReferenceID, String externalReferenceSource,
			Metadata metadata) {
		ObservationSearchRequest request = new ObservationSearchRequest();
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
		if (observationDbId != null)
			request.addObservationDbIdsItem(observationDbId);
		if (observationUnitDbId != null)
			request.addObservationUnitDbIdsItem(observationUnitDbId);
		if (observationVariableDbId != null)
			request.addObservationVariableDbIdsItem(observationVariableDbId);
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
		if (observationTimeStampRangeStart != null)
			request.setObservationTimeStampRangeStart(observationTimeStampRangeStart);
		if (observationTimeStampRangeEnd != null)
			request.setObservationTimeStampRangeEnd(observationTimeStampRangeEnd);
		if (externalReferenceID != null)
			request.addExternalReferenceIDsItem(externalReferenceID);
		if (externalReferenceSource != null)
			request.addExternalReferenceSourcesItem(externalReferenceSource);

		return findObservations(request, metadata);
	}

	public ObservationTable findObservationsTable(WSMIMEDataTypes accept, String observationUnitDbId,
			String germplasmDbId, String observationVariableDbId, String studyDbId, String locationDbId,
			String trialDbId, String programDbId, String seasonDbId, OffsetDateTime observationTimeStampRangeStart,
			OffsetDateTime observationTimeStampRangeEnd) {
		List<Observation> observations = findObservations(null, observationUnitDbId, germplasmDbId,
				observationVariableDbId, studyDbId, locationDbId, trialDbId, programDbId, seasonDbId, null, null, null,
				observationTimeStampRangeStart, observationTimeStampRangeEnd, null, null, null);
		ObservationVariableSearchRequest request = new ObservationVariableSearchRequest();
		request.setObservationVariableDbIds(
				observations.stream().map(ou -> ou.getObservationVariableDbId()).collect(Collectors.toList()));
		List<ObservationVariable> variables = observationVariableService.findObservationVariables(request, null);
		ObservationTable table = new ObservationTable();
		table.setData(buildDataMatrix(observations, variables));
		table.setHeaderRow(buildHeaderRow());
		table.setObservationVariables(variables.stream().map(this::convertVariables).collect(Collectors.toList()));
		return table;
	}

	public List<Observation> findObservations(@Valid ObservationSearchRequest request, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<ObservationEntity> searchQuery = new SearchQueryBuilder<ObservationEntity>(
				ObservationEntity.class);
		if (request.getObservationLevels() != null) {
			searchQuery = searchQuery
					.appendEnumList(
							request.getObservationLevels().stream().filter(r -> r.getLevelName() != null)
									.map(r -> r.getLevelName()).collect(Collectors.toList()),
							"observationUnit.position.level.name")
					.appendList(
							request.getObservationLevels().stream().filter(r -> r.getLevelCode() != null)
									.map(r -> r.getLevelCode()).collect(Collectors.toList()),
							"observationUnit.position.level.code")
					.appendIntList(
							request.getObservationLevels().stream().filter(r -> r.getLevelOrder() != null)
									.map(r -> r.getLevelOrder()).collect(Collectors.toList()),
							"observationUnit.position.level.order");
		}
		if (request.getObservationLevelRelationships() != null) {
			searchQuery = searchQuery.join("observationUnit.position.levelRelationships", "levelRelationship")
					.appendEnumList(
							request.getObservationLevelRelationships().stream().filter(r -> r.getLevelName() != null)
									.map(r -> r.getLevelName()).collect(Collectors.toList()),
							"levelRelationship.name")
					.appendList(
							request.getObservationLevelRelationships().stream().filter(r -> r.getLevelCode() != null)
									.map(r -> r.getLevelCode()).collect(Collectors.toList()),
							"levelRelationship.code")
					.appendIntList(
							request.getObservationLevelRelationships().stream().filter(r -> r.getLevelOrder() != null)
									.map(r -> r.getLevelOrder()).collect(Collectors.toList()),
							"levelRelationship.order");
		}
		searchQuery = searchQuery.withExRefs(request.getExternalReferenceIDs(), request.getExternalReferenceSources())
				.appendList(request.getGermplasmDbIds(), "observationUnit.germplasm.id")
				.appendList(request.getGermplasmNames(), "observationUnit.germplasm.name")
				.appendList(request.getLocationDbIds(), "observationUnit.study.location.id")
				.appendList(request.getLocationNames(), "observationUnit.study.location.name")
				.appendList(request.getObservationDbIds(), "id")
				.appendList(request.getObservationUnitDbIds(), "observationUnit.id")
				.appendDateRange(request.getObservationTimeStampRangeStart(), request.getObservationTimeStampRangeEnd(),
						"observationTimeStamp")
				.appendList(request.getObservationVariableDbIds(), "observationVariable.id")
				.appendList(request.getObservationVariableNames(), "observationVariable.name")
				.appendList(request.getProgramDbIds(), "observationUnit.study.trial.program.id")
				.appendList(request.getProgramNames(), "observationUnit.study.trial.program.name")
				.appendList(request.getSeasonDbIds(), "season.id")
				.appendList(request.getStudyDbIds(), "observationUnit.study.id")
				.appendList(request.getStudyNames(), "observationUnit.study.name")
				.appendList(request.getTrialDbIds(), "observationUnit.study.trial.id")
				.appendList(request.getTrialNames(), "observationUnit.study.trial.name");

		Page<ObservationEntity> page = observationRepository.findAllBySearch(searchQuery, pageReq);
		List<Observation> observations = page.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, page);
		return observations;
	}

	public Observation getObservation(String observationDbId) throws BrAPIServerException {
		return convertFromEntity(getObservationEntity(observationDbId));
	}

	public ObservationEntity getObservationEntity(String observationDbId) throws BrAPIServerException {
		ObservationEntity observation = null;
		Optional<ObservationEntity> entityOpt = observationRepository.findById(observationDbId);
		if (entityOpt.isPresent()) {
			observation = entityOpt.get();
		} else {
			throw new BrAPIServerException(HttpStatus.NOT_FOUND, "DbId not found: " + observationDbId);
		}
		return observation;
	}

	public List<Observation> saveObservations(@Valid List<ObservationNewRequest> requests) throws BrAPIServerException {
		List<Observation> savedObservations = new ArrayList<>();

		for (ObservationNewRequest request : requests) {
			ObservationEntity entity = new ObservationEntity();
			updateEntity(entity, request);
			ObservationEntity savedEntity = observationRepository.save(entity);
			savedObservations.add(convertFromEntity(savedEntity));
		}

		return savedObservations;
	}

	public List<Observation> updateObservations(@Valid Map<String, ObservationNewRequest> requests)
			throws BrAPIServerException {
		List<Observation> savedObservations = new ArrayList<>();

		for (Entry<String, ObservationNewRequest> entry : requests.entrySet()) {
			Observation saved = updateObservation(entry.getKey(), entry.getValue());
			savedObservations.add(saved);
		}

		return savedObservations;
	}

	public Observation updateObservation(String observationDbId, @Valid ObservationNewRequest request)
			throws BrAPIServerException {
		ObservationEntity savedEntity;
		Optional<ObservationEntity> entityOpt = observationRepository.findById(observationDbId);
		if (entityOpt.isPresent()) {
			ObservationEntity entity = entityOpt.get();
			updateEntity(entity, request);

			savedEntity = observationRepository.save(entity);
		} else {
			throw new BrAPIServerException(HttpStatus.NOT_FOUND, "DbId not found: " + observationDbId);
		}

		return convertFromEntity(savedEntity);
	}

	public Observation convertFromEntity(ObservationEntity entity) {
		Observation unit = new Observation();
		if (entity != null) {
			unit = new Observation();
			unit.setAdditionalInfo(entity.getAdditionalInfoMap());
			unit.setCollector(entity.getCollector());
			unit.setExternalReferences(entity.getExternalReferencesMap());
			unit.setObservationDbId(entity.getId());
			unit.setObservationTimeStamp(DateUtility.toOffsetDateTime(entity.getObservationTimeStamp()));
			if (entity.getObservationUnit() != null) {
				unit.setObservationUnitDbId(entity.getObservationUnit().getId());
				unit.setObservationUnitName(entity.getObservationUnit().getObservationUnitName());
				if (entity.getObservationUnit().getGermplasm() != null) {
					unit.setGermplasmDbId(entity.getObservationUnit().getGermplasm().getId());
					unit.setGermplasmName(entity.getObservationUnit().getGermplasm().getGermplasmName());
				}
				if (entity.getObservationUnit().getStudy() != null) {
					unit.setStudyDbId(entity.getObservationUnit().getStudy().getId());
				}
			}
			if (entity.getObservationVariable() != null) {
				unit.setObservationVariableDbId(entity.getObservationVariable().getId());
				unit.setObservationVariableName(entity.getObservationVariable().getName());
			}
			if (entity.getSeason() != null) {
				unit.setSeason(seasonService.convertFromEntity(entity.getSeason()));
			}
			unit.setUploadedBy(entity.getUploadedBy());
			unit.setValue(entity.getValue());
		}

		return unit;
	}

	private void updateEntity(ObservationEntity entity, ObservationNewRequest observation) throws BrAPIServerException {
		if (observation.getAdditionalInfo() != null)
			entity.setAdditionalInfo(observation.getAdditionalInfo());
		if (observation.getCollector() != null)
			entity.setCollector(observation.getCollector());
		if (observation.getExternalReferences() != null)
			entity.setExternalReferences(observation.getExternalReferences());
		if (observation.getObservationTimeStamp() != null)
			entity.setObservationTimeStamp(DateUtility.toDate(observation.getObservationTimeStamp()));
		if (observation.getObservationUnitDbId() != null) {
			ObservationUnitEntity observationUnit = observationUnitService
					.getObservationUnitEntity(observation.getObservationUnitDbId());
			entity.setObservationUnit(observationUnit);
		}
		if (observation.getObservationVariableDbId() != null) {
			ObservationVariableEntity observationVariable = observationVariableService
					.getObservationVariableEntity(observation.getObservationVariableDbId());
			entity.setObservationVariable(observationVariable);
		}
		if (observation.getSeason() != null && observation.getSeason().getSeasonDbId() != null) {
			SeasonEntity season = seasonService.getSeasonEntity(observation.getSeason().getSeasonDbId());
			entity.setSeason(season);
		}
		if (observation.getUploadedBy() != null)
			entity.setUploadedBy(observation.getUploadedBy());
		if (observation.getValue() != null)
			entity.setValue(observation.getValue());
	}

	private List<List<String>> buildDataMatrix(List<Observation> observations, List<ObservationVariable> variables) {
		List<List<String>> data = new ArrayList<>();
		for (Observation obs : observations) {
			List<String> row = new ArrayList<>();
			row.add(obs.getSeason().getYear().toString());
			row.add(obs.getStudyDbId());
			row.add(obs.getGermplasmDbId());
			row.add(obs.getGermplasmName());
			row.add(obs.getObservationUnitDbId());
			row.add(obs.getObservationTimeStamp().toString());

			for (ObservationVariable var : variables) {
				if (obs.getObservationVariableDbId() == var.getObservationVariableDbId()) {
					row.add(obs.getValue());
				} else {
					row.add("");
				}
			}
			data.add(row);
		}
		return data;
	}

	private List<ObservationTableHeaderRowEnum> buildHeaderRow() {
		List<ObservationTableHeaderRowEnum> headers = Arrays.asList(ObservationTableHeaderRowEnum.values());
		return headers;
	}

	public String getObservationTableText(ObservationTable table, String sep) {
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
