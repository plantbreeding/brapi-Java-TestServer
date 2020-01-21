package org.brapi.test.BrAPITestServer.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.commons.lang3.math.NumberUtils;
import org.brapi.test.BrAPITestServer.model.entity.ObservationEntity;
import org.brapi.test.BrAPITestServer.model.entity.ObservationUnitEntity;
import org.brapi.test.BrAPITestServer.model.entity.ObservationVariableEntity;
import org.brapi.test.BrAPITestServer.model.entity.SeasonEntity;
import org.brapi.test.BrAPITestServer.repository.ObservationRepository;
import org.brapi.test.BrAPITestServer.repository.ObservationUnitRepository;
import org.brapi.test.BrAPITestServer.repository.ObservationVariableRepository;
import org.brapi.test.BrAPITestServer.repository.SeasonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.threeten.bp.OffsetDateTime;

import io.swagger.model.Metadata;
import io.swagger.model.NewObservationDbIdsObservations;
import io.swagger.model.ObservationSummary;
import io.swagger.model.ObservationSummaryPhenotype;
import io.swagger.model.ObservationTreatment;
import io.swagger.model.ObservationUnit;
import io.swagger.model.ObservationUnit.PositionCoordinateXTypeEnum;
import io.swagger.model.ObservationUnit.PositionCoordinateYTypeEnum;
import io.swagger.model.ObservationUnitPhenotype;
import io.swagger.model.ObservationUnitXref;
import io.swagger.model.ObservationUnitsTableResponse;
import io.swagger.model.PhenotypesRequest;
import io.swagger.model.PhenotypesRequestData;
import io.swagger.model.PhenotypesRequestObservation;
import io.swagger.model.PhenotypesSearchRequest;
import io.swagger.model.Season;

@Service
public class PhenotypeService {

	private ObservationUnitRepository observationUnitRepository;
	private ObservationRepository observationRepository;
	private ObservationVariableRepository observationVariableRepository;
	private SearchService searchService;
	private SeasonRepository seasonRepository;

	public PhenotypeService(ObservationUnitRepository observationUnitRepository,
			ObservationRepository observationRepository, ObservationVariableRepository observationVariableRepository,
			SeasonRepository seasonRepository, SearchService searchService) {
		this.observationUnitRepository = observationUnitRepository;
		this.observationRepository = observationRepository;
		this.observationVariableRepository = observationVariableRepository;
		this.seasonRepository = seasonRepository;
		this.searchService = searchService;
	}

	public List<ObservationUnitPhenotype> getPhenotypes(PhenotypesSearchRequest request, Metadata metaData) {
		Page<ObservationUnitEntity> unitsPage = searchPhenotypes(request, metaData);
		List<ObservationUnitPhenotype> phenotypes = unitsPage.map(this::convertFromEntity).getContent();
		return phenotypes;
	}

	public List<ObservationUnitPhenotype> getPhenotypes(String germplasmDbId, String observationVariableDbId,
			String studyDbId, String locationDbId, String trialDbId, String programDbId, String seasonDbId,
			String observationLevel, Date observationTimeStampRangeStart,
			Date observationTimeStampRangeEnd, Metadata metaData) {
		PhenotypesSearchRequest request = new PhenotypesSearchRequest();
		request.setObservationLevel(observationLevel);
		request.setObservationTimeStampRangeEnd(DateUtility.toOffsetDateTime(observationTimeStampRangeEnd));
		request.setObservationTimeStampRangeStart(DateUtility.toOffsetDateTime(observationTimeStampRangeStart));

		if (germplasmDbId != null)
			request.addGermplasmDbIdsItem(germplasmDbId);
		if (locationDbId != null)
			request.addLocationDbIdsItem(locationDbId);
		if (observationVariableDbId != null)
			request.addObservationVariableDbIdsItem(observationVariableDbId);
		if (programDbId != null)
			request.addProgramDbIdsItem(programDbId);
		if (seasonDbId != null)
			request.addSeasonDbIdsItem(seasonDbId);
		if (studyDbId != null)
			request.addStudyDbIdsItem(studyDbId);
		if (trialDbId != null)
			request.addTrialDbIdsItem(trialDbId);

		Page<ObservationUnitEntity> unitsPage = searchPhenotypes(request, metaData);
		List<ObservationUnitPhenotype> phenotypes = unitsPage.map(this::convertFromEntity).getContent();
		return phenotypes;
	}

	public List<NewObservationDbIdsObservations> savePhenotypes(@Valid PhenotypesRequest request) {
		List<NewObservationDbIdsObservations> newObservations = new ArrayList<>();
		for (PhenotypesRequestData observationUnit : request.getData()) {
			Optional<ObservationUnitEntity> unitEntityOption = observationUnitRepository
					.findById(observationUnit.getObservatioUnitDbId());
			if (unitEntityOption.isPresent()) {
				ObservationUnitEntity unitEntity = unitEntityOption.get();
				for (PhenotypesRequestObservation observation : observationUnit.getObservations()) {
					ObservationEntity obsEntity = convertToEntity(observation, unitEntity);
					ObservationEntity newObsEntity = observationRepository.save(obsEntity);

					newObservations.add(new NewObservationDbIdsObservations().observationDbId(newObsEntity.getId())
							.observationUnitDbId(newObsEntity.getObservationUnit().getId())
							.observationVariableDbId(newObsEntity.getObservationVariable().getId()));

				}
			}
		}

		return newObservations;
	}

	private ObservationEntity convertToEntity(PhenotypesRequestObservation observation,
			ObservationUnitEntity unitEntity) {
		Optional<ObservationVariableEntity> variableEntityOption = observationVariableRepository
				.findById(observation.getObservationVariableDbId());

		ObservationEntity entity = new ObservationEntity();
		entity.setCollector(observation.getCollector());
		entity.setObservationTimeStamp(DateUtility.toDate(observation.getObservationTimeStamp()));
		entity.setValue(observation.getValue());
		entity.setObservationUnit(unitEntity);
		if (variableEntityOption.isPresent()) {
			entity.setObservationVariable(variableEntityOption.get());
		}
		entity.setSeason(getSeasonFromString(observation.getSeason()));

		return entity;
	}

	private SeasonEntity getSeasonFromString(String season) {
		if (season != null) {
			// check dbid
			List<SeasonEntity> seasonEntities = seasonRepository
					.findBySearch(season, null, null, PageRequest.of(0, 1))
					.getContent();

			if (seasonEntities.isEmpty()) {
				// dbid not found, try name
				seasonEntities = seasonRepository
						.findBySearch(null, season, null, PageRequest.of(0, 1))
						.getContent();
			}

			if (seasonEntities.isEmpty()) {
				// name not found, try split name and year
				String[] seasonArr = season.split(" ", 2);
				if (seasonArr.length >= 2 && NumberUtils.isDigits(seasonArr[1])) {
					seasonEntities = seasonRepository
							.findBySearch(null, seasonArr[0], NumberUtils.toInt(seasonArr[1]), PageRequest.of(0, 1))
							.getContent();
				}
			}

			if (!seasonEntities.isEmpty()) {
				return seasonEntities.get(0);
			}
		}
		return null;
	}

	public ObservationUnitsTableResponse getPhenotypesTable(@Valid PhenotypesSearchRequest request, Metadata metaData) {
		Page<ObservationUnitEntity> unitsPage = searchPhenotypes(request, metaData);
		ObservationUnitsTableResponse response = new ObservationUnitsTableResponse();
		response.setHeaderRow(buildHeaderArray());
		List<List<String>> data = new ArrayList<>();
		List<ObservationVariableEntity> variables = getDistinctVariables(unitsPage.getContent());

		for (ObservationUnitEntity obsUnit : unitsPage) {
			data.add(buildRecordArray(obsUnit, variables));
		}

		response.setData(data);
		response.setObservationVariableDbIds(variables.stream().map((var) -> {
			return var.getId();
		}).collect(Collectors.toList()));
		response.setObservationVariableNames(variables.stream().map((var) -> {
			return var.getName();
		}).collect(Collectors.toList()));

		return response;
	}

	public String getPhenotypesCsv(@Valid PhenotypesSearchRequest request, Metadata metaData) {

		Page<ObservationUnitEntity> unitsPage = searchPhenotypes(request, metaData);
		StringBuilder responseBuilder = new StringBuilder();
		List<ObservationVariableEntity> variables = getDistinctVariables(unitsPage.getContent());

		responseBuilder.append(buildHeaderString(", ", variables));

		for (ObservationUnitEntity entity : unitsPage) {
			responseBuilder.append(buildRowString(", ", variables, entity));
		}

		return responseBuilder.toString();
	}

	public String getPhenotypesTsv(@Valid PhenotypesSearchRequest request, Metadata metaData) {
		Page<ObservationUnitEntity> unitsPage = searchPhenotypes(request, metaData);
		StringBuilder responseBuilder = new StringBuilder();
		List<ObservationVariableEntity> variables = getDistinctVariables(unitsPage.getContent());

		responseBuilder.append(buildHeaderString("\t", variables));

		for (ObservationUnitEntity entity : unitsPage) {
			responseBuilder.append(buildRowString("\t", variables, entity));
		}

		return responseBuilder.toString();
	}

	private List<ObservationVariableEntity> getDistinctVariables(List<ObservationUnitEntity> units) {
		List<ObservationVariableEntity> variables = new ArrayList<ObservationVariableEntity>();
		for (ObservationUnitEntity entity : units) {
			for (ObservationEntity observation : entity.getObservations()) {
				if (!variables.contains(observation.getObservationVariable())) {
					variables.add(observation.getObservationVariable());
				}
			}
		}
		return variables;
	}

	private Page<ObservationUnitEntity> searchPhenotypes(PhenotypesSearchRequest request, Metadata metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);

		Page<ObservationUnitEntity> unitsPage = observationUnitRepository.findBySearch(request, pageReq);

		PagingUtility.calculateMetaData(metaData, unitsPage);
		return unitsPage;
	}

	private ObservationUnitPhenotype convertFromEntity(ObservationUnitEntity entity) {
		ObservationUnitPhenotype pheno = new ObservationUnitPhenotype();
		pheno.setBlockNumber(String.valueOf(entity.getBlockNumber()));
		pheno.setEntryNumber(entity.getEntryNumber());
		pheno.setEntryType(entity.getEntryType());
		if (entity.getGermplasm() != null) {
			pheno.setGermplasmDbId(entity.getGermplasm().getId());
			pheno.setGermplasmName(entity.getGermplasm().getGermplasmName());
		}
		pheno.setObservationUnitDbId(entity.getId());
		pheno.setObservationUnitName(entity.getObservationUnitName());
		pheno.setPlantNumber(String.valueOf(entity.getPlantNumber()));
		pheno.setPlotNumber(String.valueOf(entity.getPlotNumber()));
		pheno.setReplicate(entity.getReplicate());
		pheno.setX(entity.getX());
		pheno.setPositionCoordinateX(entity.getX());
		pheno.setPositionCoordinateXType(io.swagger.model.ObservationUnitPhenotype.PositionCoordinateXTypeEnum.GRID_COL);
		pheno.setY(entity.getY());
		pheno.setPositionCoordinateY(entity.getY());
		pheno.setPositionCoordinateYType(io.swagger.model.ObservationUnitPhenotype.PositionCoordinateYTypeEnum.GRID_ROW);
		pheno.setObservationLevel(entity.getObservationLevel());
		pheno.setObservationLevels(entity.getObservationLevels());
		pheno.setProgramName(entity.getStudy().getTrial().getProgram().getName());
		pheno.setStudyDbId(entity.getStudy().getId());
		pheno.setStudyLocation(entity.getStudy().getLocation().getCountryName());
		pheno.setStudyLocationDbId(entity.getStudy().getLocation().getId());
		pheno.setStudyName(entity.getStudy().getStudyName());

		pheno.setTreatments(entity.getTreatments().stream().map(e -> {
			ObservationTreatment treatment = new ObservationTreatment();
			treatment.setFactor(e.getFactor());
			treatment.setModality(e.getModality());
			return treatment;
		}).collect(Collectors.toList()));

		pheno.setObservations(entity.getObservations().stream().map(e -> {
			ObservationSummaryPhenotype ob = new ObservationSummaryPhenotype();
			ob.setCollector(e.getCollector());
			ob.setObservationDbId(e.getId());
			ob.setObservationTimeStamp(DateUtility.toOffsetDateTime(e.getObservationTimeStamp()));
			ob.setValue(e.getValue());

			if (e.getObservationVariable() != null) {
				ob.setObservationVariableDbId(e.getObservationVariable().getId());
				ob.setObservationVariableName(e.getObservationVariable().getName());
			}
			if (e.getSeason() != null) {
				ob.setSeason(e.getSeason().getSeason() + " " + e.getSeason().getYear());
			}
			return ob;
		}).collect(Collectors.toList()));

		pheno.setObservationUnitXref(entity.getObservationUnitXref().stream().map(e -> {
			ObservationUnitXref xref = new ObservationUnitXref();
			xref.setId(e.getXref());
			xref.setSource(e.getSource());
			return xref;
		}).collect(Collectors.toList()));

		return pheno;
	}

	private String buildRowString(String separator, List<ObservationVariableEntity> variables,
			ObservationUnitEntity entity) {
		List<String> rowArray = buildRecordArray(entity, variables);
		StringBuilder row = new StringBuilder();

		for (String obsVal : rowArray) {
			row.append("\"" + obsVal + "\"" + separator);
		}

		row.delete(row.length() - separator.length(), row.length());
		row.append("\n");
		return row.toString();
	}

	private String buildHeaderString(String separator, List<ObservationVariableEntity> variables) {
		StringBuilder headerRow = new StringBuilder();

		for (String title : buildHeaderArray()) {
			headerRow.append("\"" + title + "\"" + separator);
		}

		for (ObservationVariableEntity var : variables) {
			headerRow.append("\"" + var.getId() + "\"" + separator);
		}

		headerRow.delete(headerRow.length() - separator.length(), headerRow.length());
		headerRow.append("\n");
		return headerRow.toString();
	}

	private List<String> buildHeaderArray() {
		List<String> headerRow = new ArrayList<>();
		headerRow.add("year");
		headerRow.add("studyDbId");
		headerRow.add("studyName");
		headerRow.add("locationDbId");
		headerRow.add("locationName");
		headerRow.add("germplasmDbId");
		headerRow.add("germplasmName");
		headerRow.add("observationUnitDbId");
		headerRow.add("plotNumber");
		headerRow.add("replicate");
		headerRow.add("blockNumber");
		headerRow.add("entryType");
		headerRow.add("X");
		headerRow.add("Y");

		return headerRow;
	}

	private List<String> buildRecordArray(ObservationUnitEntity unit, List<ObservationVariableEntity> variables) {
		List<String> row = new ArrayList<>();
		if (unit.getStudy() != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
			row.add(sdf.format(unit.getStudy().getStartDate()));
			row.add(unit.getStudy().getId());
			row.add(unit.getStudy().getStudyName());
			row.add(unit.getStudy().getLocation().getId());
			row.add(unit.getStudy().getLocation().getName());
		}
		if (unit.getGermplasm() != null) {
			row.add(unit.getGermplasm().getId());
			row.add(unit.getGermplasm().getGermplasmName());
		}
		row.add(unit.getId());
		row.add(unit.getPlotNumber().toString());
		row.add(unit.getReplicate());
		row.add(unit.getBlockNumber().toString());
		row.add(unit.getEntryType());
		row.add(unit.getX());
		row.add(unit.getY());

		List<String> obsVals = new ArrayList<>();
		for (ObservationVariableEntity variable : variables) {
			String foundValue = "";
			for (ObservationEntity obs : unit.getObservations()) {
				if (variable.getId().equals(obs.getObservationVariable().getId())) {
					foundValue = obs.getValue();
					break;
				}
			}

			obsVals.add(foundValue);
		}
		row.addAll(obsVals);
		return row;
	}

	public ObservationUnit convertUnit(ObservationUnitPhenotype pheno) {
		ObservationUnit unit = new ObservationUnit();
		unit.setBlockNumber(pheno.getBlockNumber());
		unit.setEntryNumber(pheno.getEntryNumber());
		unit.setEntryType(pheno.getEntryType());
		unit.setGermplasmDbId(pheno.getGermplasmDbId());
		unit.setGermplasmName(pheno.getGermplasmName());
		unit.setLocationDbId(pheno.getStudyLocationDbId());
		unit.setLocationName(pheno.getStudyLocation());
		unit.setObservationLevel(pheno.getObservationLevel());
		unit.setObservationLevels(pheno.getObservationLevels());
		unit.setObservationUnitDbId(pheno.getObservationUnitDbId());
		unit.setObservationUnitName(pheno.getObservationUnitName());
		unit.setObservationUnitXref(pheno.getObservationUnitXref());
		unit.setPlantNumber(pheno.getPlantNumber());
		unit.setPedigree("");
		unit.setPlotNumber(pheno.getPlotNumber());
		unit.setPositionCoordinateX(pheno.getPositionCoordinateX());
		if (pheno.getPositionCoordinateXType() != null)
			unit.setPositionCoordinateXType(
					PositionCoordinateXTypeEnum.fromValue(pheno.getPositionCoordinateXType().toString()));
		unit.setPositionCoordinateY(pheno.getPositionCoordinateY());
		if (pheno.getPositionCoordinateYType() != null)
			unit.setPositionCoordinateYType(
					PositionCoordinateYTypeEnum.fromValue(pheno.getPositionCoordinateYType().toString()));
		unit.setProgramName(pheno.getProgramName());
		unit.setReplicate(pheno.getReplicate());
		unit.setStudyDbId(pheno.getStudyDbId());
		unit.setStudyLocation(pheno.getStudyLocation());
		unit.setStudyLocationDbId(pheno.getStudyLocationDbId());
		unit.setStudyName(pheno.getStudyName());
		unit.setTreatments(pheno.getTreatments());
		unit.setX(pheno.getX());
		unit.setY(pheno.getY());

		unit.setObservations(pheno.getObservations().stream().map((op) -> {
			ObservationSummary o = new ObservationSummary();
			o.setCollector(op.getCollector());
			o.setObservationDbId(op.getObservationDbId());
			o.setObservationTimeStamp(op.getObservationTimeStamp());
			o.setObservationVariableDbId(op.getObservationVariableDbId());
			o.setObservationVariableName(op.getObservationVariableName());
			o.setValue(op.getValue());
			SeasonEntity season = getSeasonFromString(op.getSeason());
			if (season != null) {
				o.setSeason(new Season().season(season.getSeason()).seasonDbId(season.getId())
						.year(season.getYear().toString()));
			}
			return o;
		}).collect(Collectors.toList()));

		return unit;
	}
}
