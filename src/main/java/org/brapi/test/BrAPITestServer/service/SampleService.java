package org.brapi.test.BrAPITestServer.service;

import java.util.List;
import java.util.Optional;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.ObservationUnitEntity;
import org.brapi.test.BrAPITestServer.model.entity.PlateEntity;
import org.brapi.test.BrAPITestServer.model.entity.SampleEntity;
import org.brapi.test.BrAPITestServer.repository.ObservationUnitRepository;
import org.brapi.test.BrAPITestServer.repository.PlateRepository;
import org.brapi.test.BrAPITestServer.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.NewSampleDbIdResult;
import io.swagger.model.Sample;
import io.swagger.model.SampleSearchRequest;
import io.swagger.model.SampleSearchRequestDep;

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

	public NewSampleDbIdResult saveSample(Sample sample) {
		SampleEntity entity = new SampleEntity();
		entity.setNotes(sample.getNotes());
		entity.setPlateIndex(sample.getPlateIndex());
		entity.setSampleTimestamp(DateUtility.toDate(sample.getSampleTimestamp()));
		entity.setSampleType(sample.getSampleType());
		entity.setTakenBy(sample.getTakenBy());
		entity.setTissueType(sample.getTissueType());
		if (sample.getPlateDbId() != null) {
			Optional<PlateEntity> plateOpt = plateRepository.findById(sample.getPlateDbId());
			if (plateOpt.isPresent()) {
				entity.setPlate(plateOpt.get());
			}
		}
		if (sample.getObservationUnitDbId() != null) {
			Optional<ObservationUnitEntity> unitOpt = this.observationUnitRepository
					.findById(sample.getObservationUnitDbId());
			if (unitOpt.isPresent()) {
				entity.setObservationUnit(unitOpt.get());
			}
		}

		entity = sampleRepository.save(entity);

		NewSampleDbIdResult id = new NewSampleDbIdResult();
		id.setSampleId(entity.getId());
		id.setSampleDbId(entity.getId());

		return id;

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
			sample.setPlantDbId(String.valueOf(unit.getPlantNumber()));
			sample.setPlotDbId(String.valueOf(unit.getPlotNumber()));

			if (unit.getGermplasm() != null) {
				sample.setGermplasmDbId(unit.getGermplasm().getId());
			}
			if (unit.getStudy() != null) {
				sample.setStudyDbId(unit.getStudy().getId());
			}
		}
		sample.setPlateDbId(entity.getPlate() == null ? "" : entity.getPlate().getId());
		sample.setNotes(entity.getNotes());
		sample.setPlateIndex(entity.getPlateIndex());
		sample.setSampleDbId(entity.getId());
		sample.setSampleTimestamp(DateUtility.toOffsetDateTime(entity.getSampleTimestamp()));
		sample.setSampleType(entity.getSampleType());
		sample.setTakenBy(entity.getTakenBy());
		sample.setTissueType(entity.getTissueType());

		return sample;
	}

	public List<Sample> getSampleSearch(String sampleDbId, String observationUnitDbId, String plateDbId,
			String germplasmDbId, Metadata metaData) {
		SampleSearchRequestDep request = new SampleSearchRequestDep();
		if (sampleDbId != null) {
			request.addSampleDbIdItem(sampleDbId);
		}
		if (observationUnitDbId != null) {
			request.addObservationUnitDbIdItem(observationUnitDbId);
		}
		if (plateDbId != null) {
			request.addPlateDbIdItem(plateDbId);
		}
		if (germplasmDbId != null) {
			request.addGermplasmDbIdItem(germplasmDbId);
		}

		return searchSamples(request, metaData);
	}

	public List<Sample> getSampleSearch(SampleSearchRequestDep request, Metadata metaData) {
		return searchSamples(request, metaData);
	}

	private List<Sample> searchSamples(SampleSearchRequestDep request, Metadata metaData) {

		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Page<SampleEntity> entitiesPage = sampleRepository.findBySearch(request, pageReq);

		PagingUtility.calculateMetaData(metaData, entitiesPage);

		return entitiesPage.map(this::convertFromEntity).getContent();
	}

	public List<Sample> searchSamples(SampleSearchRequest request, Metadata metadata) throws BrAPIServerException {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SampleSearchRequestDep depRequest = convertRequest(request);
		Page<SampleEntity> page = sampleRepository.findBySearch(depRequest, pageReq);
		List<Sample> samples = page.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, page);
		return samples;
	}

	private SampleSearchRequestDep convertRequest(SampleSearchRequest request) {
		SampleSearchRequestDep req = new SampleSearchRequestDep();
		req.setGermplasmDbId(request.getGermplasmDbIds());
		req.setObservationUnitDbId(request.getObservationUnitDbIds());
		req.setPlateDbId(request.getPlateDbIds());
		req.setSampleDbId(request.getSampleDbIds());
		return req;
	}

}
