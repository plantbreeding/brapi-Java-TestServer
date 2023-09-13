package org.brapi.test.BrAPITestServer.service.pheno;

import java.util.*;
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
import org.brapi.test.BrAPITestServer.service.GeoJSONUtility;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.brapi.test.BrAPITestServer.service.UpdateUtility;
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
import io.swagger.model.pheno.ObservationUnitLevel;
import io.swagger.model.pheno.ObservationUnitLevelRelationship;

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
			String observationUnitLevelRelationshipName, String observationUnitLevelRelationshipOrder,
			String observationUnitLevelRelationshipCode, String observationUnitLevelRelationshipDbId,
			String commonCropName, String externalReferenceId, String externalReferenceID,
			String externalReferenceSource, Metadata metadata) throws BrAPIServerException {
		ObservationSearchRequest request = buildObservationsSearchRequest(observationDbId, observationUnitDbId,
				germplasmDbId, observationVariableDbId, studyDbId, locationDbId, trialDbId, programDbId, seasonDbId,
				observationUnitLevelName, observationUnitLevelOrder, observationUnitLevelCode,
				observationTimeStampRangeStart, observationTimeStampRangeEnd, observationUnitLevelRelationshipName,
				observationUnitLevelRelationshipOrder, observationUnitLevelRelationshipCode,
				observationUnitLevelRelationshipDbId, commonCropName, externalReferenceId, externalReferenceID,
				externalReferenceSource);

		return findObservations(request, metadata);
	}

	private ObservationSearchRequest buildObservationsSearchRequest(String observationDbId, String observationUnitDbId,
			String germplasmDbId, String observationVariableDbId, String studyDbId, String locationDbId,
			String trialDbId, String programDbId, String seasonDbId, String observationUnitLevelName,
			String observationUnitLevelOrder, String observationUnitLevelCode, String observationTimeStampRangeStart,
			String observationTimeStampRangeEnd, String observationUnitLevelRelationshipName,
			String observationUnitLevelRelationshipOrder, String observationUnitLevelRelationshipCode,
			String observationUnitLevelRelationshipDbId, String commonCropName, String externalReferenceId,
			String externalReferenceID, String externalReferenceSource) throws BrAPIServerException {
		ObservationSearchRequest request = new ObservationSearchRequest();
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
		if (observationDbId != null)
			request.addObservationDbIdsItem(observationDbId);
		if (observationUnitDbId != null)
			request.addObservationUnitDbIdsItem(observationUnitDbId);
		if (observationVariableDbId != null)
			request.addObservationVariableDbIdsItem(observationVariableDbId);
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
		if (observationTimeStampRangeStart != null)
			request.setObservationTimeStampRangeStart(DateUtility.toOffsetDateTime(observationTimeStampRangeStart));
		if (observationTimeStampRangeEnd != null)
			request.setObservationTimeStampRangeEnd(DateUtility.toOffsetDateTime(observationTimeStampRangeEnd));

		request.addExternalReferenceItem(externalReferenceId, externalReferenceID, externalReferenceSource);

		return request;
	}

	public ObservationTable findObservationsTable(String observationUnitDbId, String germplasmDbId,
			String observationVariableDbId, String studyDbId, String locationDbId, String trialDbId, String programDbId,
			String seasonDbId, String observationLevel, String observationUnitLevelName,
			String observationUnitLevelOrder, String observationUnitLevelCode,
			String observationUnitLevelRelationshipName, String observationUnitLevelRelationshipOrder,
			String observationUnitLevelRelationshipCode, String observationUnitLevelRelationshipDbId,
			String observationTimeStampRangeStart, String observationTimeStampRangeEnd, String searchResultsDbId)
			throws BrAPIServerException {
		ObservationSearchRequest obsRequest = buildObservationsSearchRequest(null, observationUnitDbId, germplasmDbId,
				observationVariableDbId, studyDbId, locationDbId, trialDbId, programDbId, seasonDbId,
				observationUnitLevelName, observationUnitLevelOrder, observationUnitLevelCode,
				observationTimeStampRangeStart, observationTimeStampRangeEnd, observationUnitLevelRelationshipName,
				observationUnitLevelRelationshipOrder, observationUnitLevelRelationshipCode,
				observationUnitLevelRelationshipDbId, null, null, null, null);
		return findObservationsTable(obsRequest);
	}

	public ObservationTable findObservationsTable(ObservationSearchRequest obsRequest) {
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
		System.out.println(new Date() + ": converting "+page.getSize()+" entities");
		List<Observation> observations = page.map(this::convertFromEntity).getContent();
		System.out.println(new Date() + ": done converting entities");
		PagingUtility.calculateMetaData(metadata, page);
		return observations;
	}

	public Page<ObservationEntity> findObservationEntities(@Valid ObservationSearchRequest request, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<ObservationEntity> searchQuery = new SearchQueryBuilder<ObservationEntity>(
				ObservationEntity.class);
		searchQuery
				.leftJoinFetch("additionalInfo", "additionalInfo")
				.leftJoinFetch("observationVariable", "observationVariable")
				.leftJoinFetch("*observationVariable.crop", "varCrop")
				.leftJoinFetch("*observationVariable.method", "varMethod")
				.leftJoinFetch("*observationVariable.ontology", "varOntology")
				.leftJoinFetch("*observationVariable.scale", "varScale")
				.leftJoinFetch("*observationVariable.trait", "varTrait")
				.leftJoinFetch("season", "season")
				.leftJoinFetch("program", "program")
				.leftJoinFetch("trial", "trial")
				.leftJoinFetch("geoCoordinates", "geoCoordinates")
				.leftJoinFetch("observationUnit", "observationUnit")
				.leftJoinFetch("*observationUnit.position", "position")
				.leftJoinFetch("*position.geoCoordinates", "ouGeoCoordinates")
				.leftJoinFetch("*observationUnit.germplasm", "ouGermplasm")
				.leftJoinFetch("*ouGermplasm.pedigree", "pedigree")
				.leftJoinFetch("*observationUnit.study", "ouStudy")
				.leftJoinFetch("study", "study")
				.leftJoinFetch("*study.experimentalDesign", "experimentalDesign")
				.leftJoinFetch("*study.growthFacility", "growthFacility")
				.leftJoinFetch("*study.lastUpdate", "lastUpdate");
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
				.appendList(request.getCommonCropNames(), "crop.crop_name")
				.appendList(request.getProgramDbIds(), "program.id")
				.appendList(request.getProgramNames(), "program.name").appendList(request.getSeasonDbIds(), "season.id")
				.appendList(request.getStudyDbIds(), "study.id").appendList(request.getStudyNames(), "study.studyName")
				.appendList(request.getTrialDbIds(), "trial.id").appendList(request.getTrialNames(), "trial.trialName");

		System.out.println(new Date() + ": starting search");
		Page<ObservationEntity> page = observationRepository.findAllBySearch(searchQuery, pageReq);
		System.out.println(new Date() + ": search complete");

		System.out.println("fetching Obs xrefs: " + new Date());
		observationRepository.fetchXrefs(page, ObservationEntity.class);
		System.out.println("done fetching Obs xrefs: " + new Date());
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
			throw new BrAPIServerDbIdNotFoundException("observation", observationDbId, errorStatus);
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

	public List<String> deleteObservations(ObservationSearchRequest body, Metadata metadata) {
		List<String> deletedObservationDbIds = new ArrayList<>();

		if (body.getTotalParameterCount() > 0) {
			List<ObservationEntity> deletedObservations = findObservationEntities(body, metadata).getContent();
			observationRepository.deleteAll(deletedObservations);
			deletedObservationDbIds = deletedObservations.stream().map(obs -> obs.getId()).collect(Collectors.toList());
		}

		return deletedObservationDbIds;
	}

	public Observation updateObservation(String observationDbId, ObservationNewRequest request)
			throws BrAPIServerException {
		ObservationEntity entity = getObservationEntity(observationDbId, HttpStatus.NOT_FOUND);
		updateEntity(entity, request);
		ObservationEntity savedEntity = observationRepository.save(entity);

		return convertFromEntity(savedEntity);
	}

	public Observation convertFromEntity(ObservationEntity entity) {
		System.out.println(new Date() + ": converting obs: " + entity.getId());
		Observation observation = new Observation();
		if (entity != null) {
			UpdateUtility.convertFromEntity(entity, observation);

			observation.setCollector(entity.getCollector());
			observation.setGeoCoordinates(GeoJSONUtility.convertFromEntity(entity.getGeoCoordinates()));
			observation.setObservationDbId(entity.getId());
			observation.setObservationTimeStamp(DateUtility.toOffsetDateTime(entity.getObservationTimeStamp()));

			if (entity.getObservationVariable() != null) {
				observation.setObservationVariableDbId(entity.getObservationVariable().getId());
				observation.setObservationVariableName(entity.getObservationVariable().getName());
			}
			if (entity.getSeason() != null) {
				observation.setSeason(seasonService.convertFromEntity(entity.getSeason()));
			}
			observation.setUploadedBy(entity.getUploadedBy());
			observation.setValue(entity.getValue());

			if (entity.getObservationUnit() != null) {
				observation.setObservationUnitDbId(entity.getObservationUnit().getId());
				observation.setObservationUnitName(entity.getObservationUnit().getObservationUnitName());
				if (entity.getObservationUnit().getGermplasm() != null) {
					observation.setGermplasmDbId(entity.getObservationUnit().getGermplasm().getId());
					observation.setGermplasmName(entity.getObservationUnit().getGermplasm().getGermplasmName());
				}
				if (entity.getObservationUnit().getStudy() != null) {
					observation.setStudyDbId(entity.getObservationUnit().getStudy().getId());
				}
			} else if (entity.getStudy() != null) {
				observation.setStudyDbId(entity.getStudy().getId());
			}

		}

		return observation;
	}

	private void updateEntity(ObservationEntity entity, ObservationNewRequest observation) throws BrAPIServerException {
		UpdateUtility.updateEntity(observation, entity);

		if (observation.getCollector() != null)
			entity.setCollector(observation.getCollector());
		if (observation.getGeoCoordinates() != null)
			entity.setGeoCoordinates(GeoJSONUtility.convertToEntity(observation.getGeoCoordinates()));
		if (observation.getObservationTimeStamp() != null)
			entity.setObservationTimeStamp(DateUtility.toDate(observation.getObservationTimeStamp()));
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

		if (observation.getObservationUnitDbId() != null) {
			ObservationUnitEntity observationUnit = observationUnitService
					.getObservationUnitEntity(observation.getObservationUnitDbId());
			entity.setObservationUnit(observationUnit);
		} else if (observation.getStudyDbId() != null) {
			StudyEntity study = studyService.getStudyEntity(observation.getStudyDbId());
			entity.setStudy(study);
		}
	}

	private List<List<String>> buildDataMatrix(Page<ObservationEntity> observations,
			List<ObservationVariableEntity> variables) {
		List<List<String>> data = new ArrayList<>();
		for (ObservationEntity obs : observations) {
			List<String> row = new ArrayList<>();

			if (obs.getObservationUnit() != null) {
				ObservationUnitEntity obsUnit = obs.getObservationUnit();
				if (obsUnit.getStudy() != null) {
					StudyEntity study = obsUnit.getStudy();
					if (study.getSeasons() != null && !study.getSeasons().isEmpty()) {
						row.add(printIfNotNull(study.getSeasons().get(0).getYear())); // YEAR
					} else {
						row.add(""); // YEAR
					}

					row.add(printIfNotNull(study.getId())); // STUDYDBID
					row.add(printIfNotNull(study.getStudyName())); // STUDYNAME

//					if (study.getLocation() != null) {
//						row.add(printIfNotNull(study.getLocation().getId())); // LOCATIONDBID
//						row.add(printIfNotNull(study.getLocation().getLocationName())); // LOCATIONNAME
//					} else {
//						row.add(""); // LOCATIONDBID
//						row.add(""); // LOCATIONNAME
//					}

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

			} else {
				continue;
			}

			row.add(printIfNotNull(obs.getObservationTimeStamp())); // OBSERVATIONTIMESTAMP

			for (ObservationVariableEntity var : variables) {
				if (obs.getObservationVariable() != null && obs.getObservationVariable().getId() == var.getId()) {
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
