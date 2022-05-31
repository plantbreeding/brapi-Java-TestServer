package org.brapi.test.BrAPITestServer.service.pheno;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import jakarta.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.core.SeasonEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.StudyEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationUnitEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationVariableEntity;
import org.brapi.test.BrAPITestServer.repository.pheno.ObservationRepository;
import org.brapi.test.BrAPITestServer.service.DateUtility;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.brapi.test.BrAPITestServer.service.core.SeasonService;
import org.brapi.test.BrAPITestServer.service.core.StudyService;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
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
	private final StudyService studyService;
	private final ObservationVariableService observationVariableService;

	public ObservationService(ObservationRepository observationRepository, SeasonService seasonService,
			@Lazy ObservationUnitService observationUnitService, StudyService studyService,
			ObservationVariableService observationVariableService) {
		this.observationRepository = observationRepository;
		this.seasonService = seasonService;
		this.observationUnitService = observationUnitService;
		this.studyService = studyService;
		this.observationVariableService = observationVariableService;
	}

	public List<Observation> findObservations(String observationDbId, String observationUnitDbId, String germplasmDbId,
			String observationVariableDbId, String studyDbId, String locationDbId, String trialDbId, String programDbId,
			String seasonDbId, String observationUnitLevelName, String observationUnitLevelOrder,
			String observationUnitLevelCode, String observationTimeStampRangeStart, String observationTimeStampRangeEnd,
			String externalReferenceID, String externalReferenceSource, Metadata metadata) throws BrAPIServerException {
		ObservationSearchRequest request = buildObservationsSearchRequest(observationDbId, observationUnitDbId,
				germplasmDbId, observationVariableDbId, studyDbId, locationDbId, trialDbId, programDbId, seasonDbId,
				observationUnitLevelName, observationUnitLevelOrder, observationUnitLevelCode,
				observationTimeStampRangeStart, observationTimeStampRangeEnd, externalReferenceID,
				externalReferenceSource);

		return findObservations(request, metadata);
	}

	private ObservationSearchRequest buildObservationsSearchRequest(String observationDbId, String observationUnitDbId,
			String germplasmDbId, String observationVariableDbId, String studyDbId, String locationDbId,
			String trialDbId, String programDbId, String seasonDbId, String observationUnitLevelName,
			String observationUnitLevelOrder, String observationUnitLevelCode, String observationTimeStampRangeStart,
			String observationTimeStampRangeEnd, String externalReferenceID, String externalReferenceSource)
			throws BrAPIServerException {
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
			request.setObservationTimeStampRangeStart(DateUtility.toOffsetDateTime(observationTimeStampRangeStart));
		if (observationTimeStampRangeEnd != null)
			request.setObservationTimeStampRangeEnd(DateUtility.toOffsetDateTime(observationTimeStampRangeEnd));
		if (externalReferenceID != null)
			request.addExternalReferenceIDsItem(externalReferenceID);
		if (externalReferenceSource != null)
			request.addExternalReferenceSourcesItem(externalReferenceSource);

		return request;
	}

	public ObservationTable findObservationsTable(String observationUnitDbId, String germplasmDbId,
			String observationVariableDbId, String studyDbId, String locationDbId, String trialDbId, String programDbId,
			String seasonDbId, String observationTimeStampRangeStart, String observationTimeStampRangeEnd)
			throws BrAPIServerException {
		ObservationSearchRequest obsRequest = buildObservationsSearchRequest(null, observationUnitDbId, germplasmDbId,
				observationVariableDbId, studyDbId, locationDbId, trialDbId, programDbId, seasonDbId,
				ObservationUnitHierarchyLevelEnum.PLOT.name(), null, null, observationTimeStampRangeStart,
				observationTimeStampRangeEnd, null, null);
		Page<ObservationEntity> observations = findObservationEntities(obsRequest, null);

		List<ObservationVariableEntity> variables = observations.stream().map(obs -> obs.getObservationVariable())
				.filter(vid -> vid != null).distinct().collect(Collectors.toList());

		ObservationTable table = new ObservationTable();
		table.setData(buildDataMatrix(observations, variables));
		table.setHeaderRow(buildHeaderRow());
		table.setObservationVariables(variables.stream().map(this::convertVariables).collect(Collectors.toList()));
		return table;
	}

	public List<Observation> findObservations(@Valid ObservationSearchRequest request, Metadata metadata) {
		Page<ObservationEntity> page = findObservationEntities(request, metadata);
		List<Observation> observations = page.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, page);
		return observations;
	}

	public Page<ObservationEntity> findObservationEntities(@Valid ObservationSearchRequest request, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<ObservationEntity> searchQuery = new SearchQueryBuilder<ObservationEntity>(
				ObservationEntity.class);
		if (request.getObservationLevels() != null) {
			searchQuery = searchQuery
					.appendEnumList(
							request.getObservationLevels().stream().filter(r -> r.getLevelName() != null)
									.map(r -> r.getLevelName()).collect(Collectors.toList()),
							"observationUnit.position.level.levelName")
					.appendList(
							request.getObservationLevels().stream().filter(r -> r.getLevelCode() != null)
									.map(r -> r.getLevelCode()).collect(Collectors.toList()),
							"observationUnit.position.level.levelCode")
					.appendIntList(
							request.getObservationLevels().stream().filter(r -> r.getLevelOrder() != null)
									.map(r -> r.getLevelOrder()).collect(Collectors.toList()),
							"observationUnit.position.level.levelOrder");
		}
		if (request.getObservationLevelRelationships() != null) {
			searchQuery = searchQuery.join("observationUnit.position.levelRelationships", "levelRelationship")
					.appendEnumList(
							request.getObservationLevelRelationships().stream().filter(r -> r.getLevelName() != null)
									.map(r -> r.getLevelName()).collect(Collectors.toList()),
							"levelRelationship.levelName")
					.appendList(
							request.getObservationLevelRelationships().stream().filter(r -> r.getLevelCode() != null)
									.map(r -> r.getLevelCode()).collect(Collectors.toList()),
							"levelRelationship.levelCode")
					.appendIntList(
							request.getObservationLevelRelationships().stream().filter(r -> r.getLevelOrder() != null)
									.map(r -> r.getLevelOrder()).collect(Collectors.toList()),
							"levelRelationship.levelOrder");
		}
		searchQuery = searchQuery.withExRefs(request.getExternalReferenceIDs(), request.getExternalReferenceSources())
				.appendList(request.getGermplasmDbIds(), "observationUnit.germplasm.id")
				.appendList(request.getGermplasmNames(), "observationUnit.germplasm.germplasmName")
				.appendList(request.getLocationDbIds(), "study.location.id")
				.appendList(request.getLocationNames(), "study.location.locationName")
				.appendList(request.getObservationDbIds(), "id")
				.appendList(request.getObservationUnitDbIds(), "observationUnit.id")
				.appendDateRange(request.getObservationTimeStampRangeStart(), request.getObservationTimeStampRangeEnd(),
						"observationTimeStamp")
				.appendList(request.getObservationVariableDbIds(), "observationVariable.id")
				.appendList(request.getObservationVariableNames(), "observationVariable.name")
				.appendList(request.getProgramDbIds(), "program.id")
				.appendList(request.getProgramNames(), "programName").appendList(request.getSeasonDbIds(), "season.id")
				.appendList(request.getStudyDbIds(), "study.id").appendList(request.getStudyNames(), "study.studyName")
				.appendList(request.getTrialDbIds(), "trial.id").appendList(request.getTrialNames(), "trial.trialName");

		Page<ObservationEntity> page = observationRepository.findAllBySearch(searchQuery, pageReq);
		return page;
	}

	public Observation getObservation(String observationDbId) throws BrAPIServerException {
		return convertFromEntity(getObservationEntity(observationDbId, HttpStatus.NOT_FOUND));
	}

	public ObservationEntity getObservationEntity(String observationDbId) throws BrAPIServerException {
		return getObservationEntity(observationDbId, HttpStatus.BAD_REQUEST);
	}

	public ObservationEntity getObservationEntity(String observationDbId, HttpStatus errorStatus)
			throws BrAPIServerException {
		ObservationEntity observation = null;
		Optional<ObservationEntity> entityOpt = observationRepository.findById(observationDbId);
		if (entityOpt.isPresent()) {
			observation = entityOpt.get();
		} else {
			throw new BrAPIServerDbIdNotFoundException("observation", observationDbId);
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
			throw new BrAPIServerDbIdNotFoundException("observation", observationDbId);
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

			if (entity.getObservationVariable() != null) {
				unit.setObservationVariableDbId(entity.getObservationVariable().getId());
				unit.setObservationVariableName(entity.getObservationVariable().getName());
			}
			if (entity.getSeason() != null) {
				unit.setSeason(seasonService.convertFromEntity(entity.getSeason()));
			}
			unit.setUploadedBy(entity.getUploadedBy());
			unit.setValue(entity.getValue());

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
			} else if (entity.getStudy() != null) {
				unit.setStudyDbId(entity.getStudy().getId());
			}

		}

		return unit;
	}

	private void updateEntity(ObservationEntity entity, ObservationNewRequest body) throws BrAPIServerException {
		if (body.getAdditionalInfo() != null)
			entity.setAdditionalInfo(body.getAdditionalInfo());
		if (body.getCollector() != null)
			entity.setCollector(body.getCollector());
		if (body.getExternalReferences() != null)
			entity.setExternalReferences(body.getExternalReferences());
		if (body.getObservationTimeStamp() != null)
			entity.setObservationTimeStamp(DateUtility.toDate(body.getObservationTimeStamp()));
		if (body.getObservationVariableDbId() != null) {
			ObservationVariableEntity observationVariable = observationVariableService
					.getObservationVariableEntity(body.getObservationVariableDbId());
			entity.setObservationVariable(observationVariable);
		}
		if (body.getSeason() != null && body.getSeason().getSeasonDbId() != null) {
			SeasonEntity season = seasonService.getSeasonEntity(body.getSeason().getSeasonDbId());
			entity.setSeason(season);
		}
		if (body.getUploadedBy() != null)
			entity.setUploadedBy(body.getUploadedBy());
		if (body.getValue() != null)
			entity.setValue(body.getValue());

		if (body.getObservationUnitDbId() != null) {
			ObservationUnitEntity observationUnit = observationUnitService
					.getObservationUnitEntity(body.getObservationUnitDbId());
			entity.setObservationUnit(observationUnit);
		} else if (body.getStudyDbId() != null) {
			StudyEntity study = studyService.getStudyEntity(body.getStudyDbId());
			entity.setStudy(study);
		}
	}

	private List<List<String>> buildDataMatrix(Page<ObservationEntity> observations,
			List<ObservationVariableEntity> variables) {
		List<List<String>> data = new ArrayList<>();
		for (ObservationEntity obs : observations) {
			List<String> row = new ArrayList<>();

			if(obs.getObservationUnit() != null) {
				ObservationUnitEntity obsUnit = obs.getObservationUnit();
				if (obsUnit.getStudy() != null) {
					StudyEntity study = obsUnit.getStudy();
					if (study.getSeasons() != null && !study.getSeasons().isEmpty()) {
						row.add(printIfNotNull(study.getSeasons().get(0).getYear())); //YEAR
					}else {
						row.add(""); //YEAR
					}
	
					row.add(printIfNotNull(study.getId())); //STUDYDBID
					row.add(printIfNotNull(study.getStudyName())); //STUDYNAME
					
					if (study.getLocation() != null) {
						row.add(printIfNotNull(study.getLocation().getId())); //LOCATIONDBID
						row.add(printIfNotNull(study.getLocation().getLocationName())); //LOCATIONNAME
					}else {
						row.add(""); //LOCATIONDBID
						row.add(""); //LOCATIONNAME
					}
					
				} else {
					row.add(""); //YEAR
					row.add(""); //STUDYDBID
					row.add(""); //STUDYNAME
					row.add(""); //LOCATIONDBID
					row.add(""); //LOCATIONNAME
				}

				if(obsUnit.getGermplasm() != null) {
					row.add(printIfNotNull(obsUnit.getGermplasm().getId())); //GERMPLASMDBID
					row.add(printIfNotNull(obsUnit.getGermplasm().getGermplasmName())); //GERMPLASMNAME
				}else {
					row.add(""); //GERMPLASMDBID
					row.add(""); //GERMPLASMNAME
				}

				row.add(printIfNotNull(obsUnit.getId())); //OBSERVATIONUNITDBID
				row.add(printIfNotNull(obsUnit.getObservationUnitName())); //OBSERVATIONUNITNAME
				
				if(obsUnit.getPosition() != null) {
					row.add(printIfNotNull(obsUnit.getPosition().getPositionCoordinateX())); //POSITIONCOORDINATEX
					row.add(printIfNotNull(obsUnit.getPosition().getPositionCoordinateY())); //POSITIONCOORDINATEY
					row.add(printIfNotNull(obsUnit.getPosition().getFieldCode())); //FIELD
					row.add(printIfNotNull(obsUnit.getPosition().getBlockCode())); //BLOCK
					row.add(printIfNotNull(obsUnit.getPosition().getEntryCode())); //ENTRY
					row.add(printIfNotNull(obsUnit.getPosition().getRepCode())); //REP
					row.add(printIfNotNull(obsUnit.getPosition().getPlotCode())); //PLOT
					row.add(printIfNotNull(obsUnit.getPosition().getPlantCode())); //PLANT
				}else {
					row.add(""); //POSITIONCOORDINATEX
					row.add(""); //POSITIONCOORDINATEY
					row.add(""); //FIELD
					row.add(""); //BLOCK
					row.add(""); //ENTRY
					row.add(""); //REP
					row.add(""); //PLOT
					row.add(""); //PLANT
				}
					
			}else {
				row.add(""); //YEAR
				row.add(""); //STUDYDBID
				row.add(""); //STUDYNAME
				row.add(""); //LOCATIONDBID
				row.add(""); //LOCATIONNAME
				row.add(""); //GERMPLASMDBID
				row.add(""); //GERMPLASMNAME
				row.add(""); //OBSERVATIONUNITDBID
				row.add(""); //OBSERVATIONUNITNAME
				row.add(""); //POSITIONCOORDINATEX
				row.add(""); //POSITIONCOORDINATEY
				row.add(""); //FIELD
				row.add(""); //BLOCK
				row.add(""); //ENTRY
				row.add(""); //REP
				row.add(""); //PLOT
				row.add(""); //PLANT
			}
			
			
			row.add(printIfNotNull(obs.getObservationTimeStamp())); //OBSERVATIONTIMESTAMP

			for (ObservationVariableEntity var : variables) {
				if (obs.getObservationVariable().getId() == var.getId()) {
					row.add(obs.getValue());
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
		headers.add(ObservationTableHeaderRowEnum.LOCATIONDBID);
		headers.add(ObservationTableHeaderRowEnum.LOCATIONNAME);
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
		headers.add(ObservationTableHeaderRowEnum.OBSERVATIONTIMESTAMP);
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

	private ObservationTableObservationVariables convertVariables(ObservationVariableEntity variable) {
		ObservationTableObservationVariables header = new ObservationTableObservationVariables();
		header.setObservationVariableDbId(variable.getId());
		header.setObservationVariableName(variable.getName());
		return header;
	}
}
