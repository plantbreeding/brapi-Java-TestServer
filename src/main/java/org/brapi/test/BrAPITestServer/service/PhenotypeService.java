package org.brapi.test.BrAPITestServer.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.model.entity.ObservationUnitEntity;
import org.brapi.test.BrAPITestServer.model.rest.Observation;
import org.brapi.test.BrAPITestServer.model.rest.ObservationUnitXref;
import org.brapi.test.BrAPITestServer.model.rest.Phenotype;
import org.brapi.test.BrAPITestServer.model.rest.PhenotypesSearchRequest;
import org.brapi.test.BrAPITestServer.model.rest.Treatment;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.brapi.test.BrAPITestServer.repository.ObservationUnitRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PhenotypeService {

	private ObservationUnitRepository observationUnitRepository;

	public PhenotypeService(ObservationUnitRepository observationUnitRepository) {
		this.observationUnitRepository = observationUnitRepository;
	}

	public List<Phenotype> getPhenotypes(PhenotypesSearchRequest request, MetaData metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);

		Page<ObservationUnitEntity> unitsPage;
		if (request.getObservationTimeStampRange() != null && request.getObservationTimeStampRange().size() >= 2) {
			Date startDate = request.getObservationTimeStampRange().get(0);
			Date endDate = request.getObservationTimeStampRange().get(1);

			unitsPage = observationUnitRepository.findBySearch_byDate(
					SearchUtility.buildSearchParam(request.getGermplasmDbIds()),
					SearchUtility.buildSearchParam(request.getObservationVariableDbIds()),
					SearchUtility.buildSearchParam(request.getStudyDbIds()),
					SearchUtility.buildSearchParam(request.getLocationDbIds()),
					SearchUtility.buildSearchParam(request.getProgramDbIds()),
					SearchUtility.buildSearchParam(request.getSeasonDbIds()),
					SearchUtility.buildSearchParam(request.getObservationLevel()), startDate, endDate, pageReq);
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

		List<Phenotype> phenotypes = unitsPage.map(entity -> {
			Phenotype pheno = new Phenotype();
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
				Treatment treatment = new Treatment();
				treatment.setFactor(e.getFactor());
				treatment.setModality(e.getModality());
				return treatment;
			}).collect(Collectors.toList()));

			pheno.setObservations(entity.getObservations().stream().map(e -> {
				Observation ob = new Observation();
				ob.setCollector(e.getCollector());
				ob.setObservationDbId(e.getId());
				ob.setObservationTimeStamp(e.getObservationTimeStamp());
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
		}).getContent();

		return phenotypes;
	}

}
