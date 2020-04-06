package org.brapi.test.BrAPITestServer.service.geno;

import java.util.List;
import java.util.Optional;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.geno.PlateEntity;
import org.brapi.test.BrAPITestServer.model.entity.geno.SampleEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationUnitEntity;
import org.brapi.test.BrAPITestServer.repository.geno.PlateRepository;
import org.brapi.test.BrAPITestServer.repository.geno.SampleRepository;
import org.brapi.test.BrAPITestServer.repository.pheno.ObservationUnitRepository;
import org.brapi.test.BrAPITestServer.service.DateUtility;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.geno.Sample;
import io.swagger.model.geno.SampleSearchRequest;
import io.swagger.model.geno.SampleSingleResponse;

@Service
public class SampleService {
	private SampleRepository sampleRepository;
	private ObservationUnitRepository observationUnitRepository;
	private SearchService searchService;
	private PlateRepository plateRepository;

	@Autowired
	public SampleService(SampleRepository sampleRepository, ObservationUnitRepository observationUnitRepository,
			PlateRepository plateRepository, SearchService searchService) {
		this.sampleRepository = sampleRepository;
		this.observationUnitRepository = observationUnitRepository;
		this.plateRepository = plateRepository;
		this.searchService = searchService;
	}

	public SampleSingleResponse saveSample(Sample sample) {
		Optional<ObservationUnitEntity> unitOpt = this.observationUnitRepository
				.findById(sample.getObservationUnitDbId());
		Optional<PlateEntity> plateOpt = plateRepository.findById(sample.getPlateDbId());
		SampleSingleResponse id = new SampleSingleResponse();
		if (validateInput(sample, unitOpt)) {
			ObservationUnitEntity unit = unitOpt.get();
			SampleEntity entity = new SampleEntity();
//			entity.setNotes(sample.getNotes());
			entity.setObservationUnit(unit);
//			entity.setPlateIndex(sample.getPlateIndex());
			entity.setSampleTimestamp(DateUtility.toDate(sample.getSampleTimestamp()));
			entity.setSampleType(sample.getSampleType());
			entity.setTakenBy(sample.getTakenBy());
			entity.setTissueType(sample.getTissueType());
			if (plateOpt.isPresent()) {
				entity.setPlate(plateOpt.get());
			}

			entity = sampleRepository.save(entity);

//			id.setSampleId(entity.getId());
//			id.setSampleDbId(entity.getId());
		}
		return id;

	}

	private boolean validateInput(Sample sample, Optional<ObservationUnitEntity> unitOpt) {
		boolean valid = unitOpt.isPresent();
		if (valid) {
			ObservationUnitEntity unit = unitOpt.get();
			valid = valid && isNullEmptyOrEqual(sample.getGermplasmDbId(), unit.getGermplasm().getId());
			valid = valid && isNullEmptyOrEqual(sample.getStudyDbId(), unit.getStudy().getId());
//			valid = valid && isNullEmptyOrEqual(sample.getPlotDbId(), String.valueOf(unit.getPlotNumber()));
//			valid = valid && isNullEmptyOrEqual(sample.getPlantDbId(), String.valueOf(unit.getPlantNumber()));
		}
		return valid;
	}

	private boolean isNullEmptyOrEqual(String actual, String expected) {
		return actual == null || actual.equalsIgnoreCase("") || actual.equals(expected);
	}

	public Sample getSample(String sampleId) {

		Optional<SampleEntity> detailOptional = sampleRepository.findById(sampleId);
		Sample sample = null;

		if (detailOptional.isPresent()) {
			sample = convertFromEntity(detailOptional.get());
		}
		return sample;
	}

	private Sample convertFromEntity(SampleEntity entity) {
		Sample sample = new Sample();
		if (entity.getObservationUnit() != null) {
			ObservationUnitEntity unit = entity.getObservationUnit();
			sample.setObservationUnitDbId(unit.getId());
//			sample.setPlantDbId(String.valueOf(unit.getPlantNumber()));
//			sample.setPlotDbId(String.valueOf(unit.getPlotNumber()));

			if (unit.getGermplasm() != null) {
				sample.setGermplasmDbId(unit.getGermplasm().getId());
			}
			if (unit.getStudy() != null) {
				sample.setStudyDbId(unit.getStudy().getId());
			}
		}
		sample.setPlateDbId(entity.getPlate() == null ? "" : entity.getPlate().getId());
//		sample.setNotes(entity.getNotes());
//		sample.setPlateIndex(entity.getPlateIndex());
		sample.setSampleDbId(entity.getId());
		sample.setSampleTimestamp(DateUtility.toOffsetDateTime(entity.getSampleTimestamp()));
		sample.setSampleType(entity.getSampleType());
		sample.setTakenBy(entity.getTakenBy());
		sample.setTissueType(entity.getTissueType());

		return sample;
	}

	public List<Sample> getSampleSearch(String sampleDbId, String observationUnitDbId, String plateDbId,
			String germplasmDbId, Metadata metaData) {
		SampleSearchRequest request = new SampleSearchRequest();
//		if(sampleDbId != null) {
//			request.addSampleDbIdItem(sampleDbId);
//		}
//		if(observationUnitDbId != null) {
//			request.addObservationUnitDbIdItem(observationUnitDbId);
//		}
//		if(plateDbId != null) {
//			request.addPlateDbIdItem(plateDbId);
//		}
//		if(germplasmDbId != null) {
//			request.addGermplasmDbIdItem(germplasmDbId);
//		}
		
		return searchSamples(request, metaData);
	}

	public List<Sample> getSampleSearch(SampleSearchRequest request, Metadata metaData) {
		return searchSamples(request, metaData);
	}

	private List<Sample> searchSamples(SampleSearchRequest request, Metadata metaData) {

		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Page<SampleEntity> entitiesPage = sampleRepository.findBySearch(request, pageReq);

		PagingUtility.calculateMetaData(metaData, entitiesPage);

		return entitiesPage.map(this::convertFromEntity).getContent();
	}

//	public List<Sample> searchSamples(SampleSearchRequest request, Metadata metadata) throws BrAPIServerException {
//		Pageable pageReq = PagingUtility.getPageRequest(metadata);
//		SampleSearchRequest depRequest = convertRequest(request);
//		Page<SampleEntity> page = sampleRepository.findBySearch(depRequest, pageReq);
//		List<Sample> samples = page.map(this::convertFromEntity).getContent();
//		PagingUtility.calculateMetaData(metadata, page);
//		return samples;
//	}

	private SampleSearchRequest convertRequest(SampleSearchRequest request) {
		SampleSearchRequest req = new SampleSearchRequest();
//		req.setGermplasmDbId(request.getGermplasmDbIds());
//		req.setObservationUnitDbId(request.getObservationUnitDbIds());
//		req.setPlateDbId(request.getPlateDbIds());
//		req.setSampleDbId(request.getSampleDbIds());
		return req;
	}

}
