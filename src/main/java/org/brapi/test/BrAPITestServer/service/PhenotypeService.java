package org.brapi.test.BrAPITestServer.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.model.entity.ObservationEntity;
import org.brapi.test.BrAPITestServer.model.entity.ObservationUnitEntity;
import org.brapi.test.BrAPITestServer.repository.ObservationUnitRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.threeten.bp.OffsetDateTime;

import io.swagger.model.Metadata;
import io.swagger.model.NewObservationDbIdsObservations;
import io.swagger.model.ObservationSummaryPhenotype;
import io.swagger.model.ObservationTreatment;
import io.swagger.model.ObservationUnitPhenotype;
import io.swagger.model.ObservationUnitXref;
import io.swagger.model.ObservationUnitsTableResponse;
import io.swagger.model.PhenotypesRequest;
import io.swagger.model.PhenotypesSearchRequest;

@Service
public class PhenotypeService {

	private ObservationUnitRepository observationUnitRepository;

	public PhenotypeService(ObservationUnitRepository observationUnitRepository) {
		this.observationUnitRepository = observationUnitRepository;
	}

	public List<ObservationUnitPhenotype> getPhenotypes(PhenotypesSearchRequest request, Metadata metaData) {
		Page<ObservationUnitEntity> unitsPage = searchPhenotypes(request, metaData);
		List<ObservationUnitPhenotype> phenotypes = unitsPage.map(this::convertFromEntity).getContent();
		return phenotypes;
	}

	public List<ObservationUnitPhenotype> getPhenotypes(String germplasmDbId, String observationVariableDbId,
			String studyDbId, String locationDbId, String trialDbId, String programDbId, String seasonDbId,
			String observationLevel, OffsetDateTime observationTimeStampRangeStart, OffsetDateTime observationTimeStampRangeEnd,
			Metadata metaData) {
		PhenotypesSearchRequest request = new PhenotypesSearchRequest();
		request.setObservationLevel(observationLevel);
		request.setObservationTimeStampRangeEnd(observationTimeStampRangeEnd);
		request.setObservationTimeStampRangeStart(observationTimeStampRangeStart);
		
		request.setGermplasmDbIds(new ArrayList<>());
		request.getGermplasmDbIds().add(germplasmDbId);
		request.setLocationDbIds(new ArrayList<>());
		request.getLocationDbIds().add(locationDbId);
		request.setObservationVariableDbIds(new ArrayList<>());
		request.getObservationVariableDbIds().add(observationVariableDbId);
		request.setProgramDbIds(new ArrayList<>());
		request.getProgramDbIds().add(programDbId);
		request.setSeasonDbIds(new ArrayList<>());
		request.getSeasonDbIds().add(seasonDbId);
		request.setStudyDbIds(new ArrayList<>());
		request.getStudyDbIds().add(studyDbId);
		request.setTrialDbIds(new ArrayList<>());
		request.getTrialDbIds().add(trialDbId);
		
		Page<ObservationUnitEntity> unitsPage = searchPhenotypes(request, metaData);
		List<ObservationUnitPhenotype> phenotypes = unitsPage.map(this::convertFromEntity).getContent();
		return phenotypes;
	}

	public List<NewObservationDbIdsObservations> savePhenotypes(@Valid PhenotypesRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPhenotypesCsv(@Valid PhenotypesSearchRequest request, Metadata metaData) {

		Page<ObservationUnitEntity> unitsPage = searchPhenotypes(request, metaData);
		StringBuilder responseBuilder = new StringBuilder();
		List<String> variableDbIds = new ArrayList<>();
		for (ObservationUnitEntity entity : unitsPage) {
			responseBuilder.append(buildRowString(", ", variableDbIds, entity));
		}

		responseBuilder.insert(0, buildHeaderString(", ", variableDbIds));
		return responseBuilder.toString();
	}

	public ObservationUnitsTableResponse getPhenotypesTable(@Valid PhenotypesSearchRequest request, Metadata metaData) {
		Page<ObservationUnitEntity> unitsPage = searchPhenotypes(request, metaData);
		ObservationUnitsTableResponse response = new ObservationUnitsTableResponse();
		response.setHeaderRow(buildHeaderArray());
		List<List<String>> data = new ArrayList<>();
		List<String> variableDbIds = new ArrayList<>();
		List<String> variableNames = new ArrayList<>();
		for (ObservationUnitEntity obsUnit : unitsPage) {
			data.add(buildRecordArray(obsUnit, variableDbIds, variableNames));
		}
		response.setData(data);
		response.setObservationVariableDbIds(variableDbIds);
		response.setObservationVariableNames(variableNames);
		return response;
	}

	public String getPhenotypesTsv(@Valid PhenotypesSearchRequest request, Metadata metaData) {
		Page<ObservationUnitEntity> unitsPage = searchPhenotypes(request, metaData);
		StringBuilder responseBuilder = new StringBuilder();
		List<String> variableDbIds = new ArrayList<>();
		for (ObservationUnitEntity entity : unitsPage) {
			responseBuilder.append(buildRowString("\t", variableDbIds, entity));
		}

		responseBuilder.insert(0, buildHeaderString("\t", variableDbIds));
		return responseBuilder.toString();
	}

	private Page<ObservationUnitEntity> searchPhenotypes(PhenotypesSearchRequest request, Metadata metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);

		Page<ObservationUnitEntity> unitsPage;
		if (request.getObservationTimeStampRangeStart() != null || request.getObservationTimeStampRangeEnd() != null) {
			unitsPage = observationUnitRepository.findBySearch_byDate(
					SearchUtility.buildSearchParam(request.getGermplasmDbIds()),
					SearchUtility.buildSearchParam(request.getObservationVariableDbIds()),
					SearchUtility.buildSearchParam(request.getStudyDbIds()),
					SearchUtility.buildSearchParam(request.getLocationDbIds()),
					SearchUtility.buildSearchParam(request.getProgramDbIds()),
					SearchUtility.buildSearchParam(request.getSeasonDbIds()),
					SearchUtility.buildSearchParam(request.getObservationLevel()),
					new Date(request.getObservationTimeStampRangeStart().toEpochSecond()),
					new Date(request.getObservationTimeStampRangeEnd().toEpochSecond()), pageReq);
		} else {
			unitsPage = observationUnitRepository.findBySearch(
					SearchUtility.buildSearchParam(request.getGermplasmDbIds()),
					SearchUtility.buildSearchParam(request.getObservationVariableDbIds()),
					SearchUtility.buildSearchParam(request.getStudyDbIds()),
					SearchUtility.buildSearchParam(request.getLocationDbIds()),
					SearchUtility.buildSearchParam(request.getProgramDbIds()),
					SearchUtility.buildSearchParam(request.getSeasonDbIds()),
					SearchUtility.buildSearchParam(request.getObservationLevel()), pageReq);
		}

		PagingUtility.calculateMetaData(metaData, unitsPage);
		return unitsPage;
	}
	
	private ObservationUnitPhenotype convertFromEntity(ObservationUnitEntity entity) {
		ObservationUnitPhenotype pheno = new ObservationUnitPhenotype();
		pheno.setBlockNumber(String.valueOf(entity.getBlockNumber()));
		pheno.setEntryNumber(entity.getEntryNumber());
		pheno.setEntryType(entity.getEntryType());
		pheno.setGermplasmDbId(entity.getGermplasm().getId());
		pheno.setGermplasmName(entity.getGermplasm().getGermplasmName());
		pheno.setObservationUnitDbId(entity.getId());
		pheno.setObservationUnitName(entity.getObservationUnitName());
		pheno.setPlantNumber(String.valueOf(entity.getPlantNumber()));
		pheno.setPlotNumber(String.valueOf(entity.getPlotNumber()));
		pheno.setReplicate(entity.getReplicate());
		pheno.setX(entity.getX());
		pheno.setY(entity.getY());
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
			ob.setObservationVariableDbId(e.getObservationVariable().getId());
			ob.setObservationVariableName(e.getObservationVariable().getName());
			ob.setSeason(e.getSeason().getSeason() + " " + e.getSeason().getYear());
			ob.setValue(e.getValue());
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
	
	private String buildRowString(String separator, List<String> variableDbIds, ObservationUnitEntity entity) {
		List<String> rowArray = buildRecordArray(entity, variableDbIds, new ArrayList<>());
		StringBuilder row = new StringBuilder();
		for (String obsVal : rowArray) {
			row.append("\"" + obsVal + "\"" + separator);
		}
		row.append("\n");
		return row.toString();
	}

	private String buildHeaderString(String separator, List<String> variableDbIds) {
		StringBuilder headerRow = new StringBuilder();

		for (String title : buildHeaderArray()) {
			headerRow.append("\"" + title + "\"" + separator);
		}

		for (String var : variableDbIds) {
			headerRow.append("\"" + var + "\"" + separator);
		}

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

	private List<String> buildRecordArray(ObservationUnitEntity unit, List<String> variableDbIds,
			List<String> variableNames) {
		List<String> row = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
		row.add(sdf.format(unit.getStudy().getStartDate()));
		row.add(unit.getStudy().getId());
		row.add(unit.getStudy().getStudyName());
		row.add(unit.getStudy().getLocation().getId());
		row.add(unit.getStudy().getLocation().getName());
		row.add(unit.getGermplasm().getId());
		row.add(unit.getGermplasm().getGermplasmName());
		row.add(unit.getId());
		row.add(unit.getPlotNumber().toString());
		row.add(unit.getReplicate());
		row.add(unit.getBlockNumber().toString());
		row.add(unit.getEntryType());
		row.add(unit.getX());
		row.add(unit.getY());

		List<String> obsVals = new ArrayList<>();
		for (ObservationEntity obs : unit.getObservations()) {
			int varIndex = variableDbIds.indexOf(obs.getObservationVariable().getId());
			if (varIndex < 0) {
				variableDbIds.add(obs.getObservationVariable().getId());
				variableNames.add(obs.getObservationVariable().getName());
				obsVals.add(obs.getValue());
			} else {
				while (obsVals.size() - 1 < varIndex) {
					obsVals.add("");
				}
				obsVals.add(varIndex, obs.getValue());
			}
		}
		row.addAll(obsVals);
		return row;
	}

}
