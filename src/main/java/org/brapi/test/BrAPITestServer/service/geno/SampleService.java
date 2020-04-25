package org.brapi.test.BrAPITestServer.service.geno;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.geno.PlateEntity;
import org.brapi.test.BrAPITestServer.model.entity.geno.SampleEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationUnitEntity;
import org.brapi.test.BrAPITestServer.repository.geno.SampleRepository;
import org.brapi.test.BrAPITestServer.service.DateUtility;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.brapi.test.BrAPITestServer.service.pheno.ObservationUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.geno.Sample;
import io.swagger.model.geno.SampleNewRequest;
import io.swagger.model.geno.SampleSearchRequest;

@Service
public class SampleService {
	private SampleRepository sampleRepository;
	private PlateService plateService;
	private ObservationUnitService observationUnitservice;

	@Autowired
	public SampleService(SampleRepository sampleRepository, PlateService plateService,
			ObservationUnitService observationUnitservice) {
		this.sampleRepository = sampleRepository;
		this.observationUnitservice = observationUnitservice;
		this.plateService = plateService;
	}

	public List<Sample> findSamples(String sampleDbId, String observationUnitDbId, String plateDbId,
			String germplasmDbId, String studyDbId, String externalReferenceID, String externalReferenceSource,
			Metadata metadata) {
		SampleSearchRequest request = new SampleSearchRequest();
		if (sampleDbId != null)
			request.addSampleDbIdsItem(sampleDbId);
		if (observationUnitDbId != null)
			request.addObservationUnitDbIdsItem(observationUnitDbId);
		if (plateDbId != null)
			request.addPlateDbIdsItem(plateDbId);
		if (germplasmDbId != null)
			request.addGermplasmDbIdsItem(germplasmDbId);
		if (studyDbId != null)
			request.addStudyDbIdsItem(studyDbId);
		if (externalReferenceID != null)
			request.addExternalReferenceIDsItem(externalReferenceID);
		if (externalReferenceSource != null)
			request.addExternalReferenceSourcesItem(externalReferenceSource);

		return findSamples(request, metadata);
	}

	public List<Sample> findSamples(@Valid SampleSearchRequest request, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<SampleEntity> searchQuery = new SearchQueryBuilder<SampleEntity>(SampleEntity.class)
				.withExRefs(request.getExternalReferenceIDs(), request.getExternalReferenceSources())
				.appendList(request.getGermplasmDbIds(), "germplasm.id")
				.appendList(request.getGermplasmNames(), "germplasm.name")
				.appendList(request.getObservationUnitDbIds(), "observationUnit.id")
				.appendList(request.getPlateDbIds(), "plate.id").appendList(request.getSampleDbIds(), "id")
				.appendList(request.getStudyDbIds(), "observationUnit.study.id")
				.appendList(request.getStudyNames(), "observationUnit.study.name");

		Page<SampleEntity> page = sampleRepository.findAllBySearch(searchQuery, pageReq);
		List<Sample> samples = page.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, page);
		return samples;
	}

	public Sample getSample(String sampleDbId) throws BrAPIServerException {
		return convertFromEntity(getSampleEntity(sampleDbId));
	}

	public SampleEntity getSampleEntity(String sampleDbId) throws BrAPIServerException {
		SampleEntity sample = null;
		Optional<SampleEntity> entityOpt = sampleRepository.findById(sampleDbId);
		if (entityOpt.isPresent()) {
			sample = entityOpt.get();
		} else {
			throw new BrAPIServerException(HttpStatus.NOT_FOUND, "DbId not found: " + sampleDbId);
		}
		return sample;
	}

	public List<Sample> saveSamples(@Valid List<SampleNewRequest> body) throws BrAPIServerException {
		List<Sample> savedSamples = new ArrayList<>();

		for (SampleNewRequest list : body) {
			SampleEntity entity = new SampleEntity();
			updateEntity(entity, list);
			SampleEntity savedEntity = sampleRepository.save(entity);
			savedSamples.add(convertFromEntity(savedEntity));
		}

		return savedSamples;
	}

	public Sample updateSample(String sampleDbId, @Valid SampleNewRequest body) throws BrAPIServerException {
		SampleEntity savedEntity;
		Optional<SampleEntity> entityOpt = sampleRepository.findById(sampleDbId);
		if (entityOpt.isPresent()) {
			SampleEntity entity = entityOpt.get();
			updateEntity(entity, body);

			savedEntity = sampleRepository.save(entity);
		} else {
			throw new BrAPIServerException(HttpStatus.NOT_FOUND, "DbId not found: " + sampleDbId);
		}

		return convertFromEntity(savedEntity);
	}

	private Sample convertFromEntity(SampleEntity entity) {
		Sample sample = new Sample();
		sample.setAdditionalInfo(entity.getAdditionalInfoMap());
		sample.setColumn(entity.getPlateColumn());
		sample.setExternalReferences(entity.getExternalReferencesMap());

		if (entity.getObservationUnit() != null) {
			ObservationUnitEntity unit = entity.getObservationUnit();
			sample.setObservationUnitDbId(unit.getId());
			if (unit.getGermplasm() != null)
				sample.setGermplasmDbId(unit.getGermplasm().getId());
			if (unit.getStudy() != null) {
				sample.setStudyDbId(unit.getStudy().getId());
				if (unit.getStudy().getTrial() != null) {
					sample.setTrialDbId(unit.getStudy().getTrial().getId());
					if (unit.getStudy().getTrial().getProgram() != null) {
						sample.setProgramDbId(unit.getStudy().getTrial().getProgram().getId());
					}
				}
			}
		}
		if (entity.getPlate() != null) {
			sample.setPlateDbId(entity.getPlate().getId());
			sample.setPlateName(entity.getPlate().getPlateName());
		}
		sample.setRow(entity.getPlateRow());
		sample.setSampleBarcode(entity.getSampleBarcode());
		sample.setSampleDbId(entity.getId());
		sample.setSampleDescription(entity.getSampleDescription());
		sample.setSampleGroupDbId(entity.getSampleGroupDbId());
		sample.setSampleName(entity.getSampleName());
		sample.setSamplePUI(entity.getSamplePUI());
		sample.setSampleTimestamp(DateUtility.toOffsetDateTime(entity.getSampleTimestamp()));
		sample.setSampleType(entity.getSampleType());
		sample.setTakenBy(entity.getTakenBy());
		sample.setTissueType(entity.getTissueType());
		sample.setWell(entity.getWell());

		return sample;
	}

	private void updateEntity(SampleEntity entity, SampleNewRequest sample) throws BrAPIServerException {
		if (sample.getAdditionalInfo() != null)
			entity.setAdditionalInfo(sample.getAdditionalInfo());
		if (sample.getColumn() != null)
			entity.setPlateColumn(sample.getColumn());
		if (sample.getExternalReferences() != null)
			entity.setExternalReferences(sample.getExternalReferences());
		if (sample.getObservationUnitDbId() != null) {
			ObservationUnitEntity observationUnit = observationUnitservice
					.getObservationUnitEntity(sample.getObservationUnitDbId());
			entity.setObservationUnit(observationUnit);
		}
		if (sample.getPlateDbId() != null) {
			PlateEntity plate = plateService.getPlateEntity(sample.getPlateDbId());
			entity.setPlate(plate);
		}
		if (sample.getRow() != null)
			entity.setPlateRow(sample.getRow());
		if (sample.getSampleBarcode() != null)
			entity.setSampleBarcode(sample.getSampleBarcode());
		if (sample.getSampleDescription() != null)
			entity.setSampleDescription(sample.getSampleDescription());
		if (sample.getSampleGroupDbId() != null)
			entity.setSampleGroupDbId(sample.getSampleGroupDbId());
		if (sample.getSampleName() != null)
			entity.setSampleName(sample.getSampleName());
		if (sample.getSamplePUI() != null)
			entity.setSamplePUI(sample.getSamplePUI());
		if (sample.getSampleTimestamp() != null)
			entity.setSampleTimestamp(DateUtility.toDate(sample.getSampleTimestamp()));
		if (sample.getSampleType() != null)
			entity.setSampleType(sample.getSampleType());
		if (sample.getTakenBy() != null)
			entity.setTakenBy(sample.getTakenBy());
		if (sample.getTissueType() != null)
			entity.setTissueType(sample.getTissueType());
		if (sample.getWell() != null)
			entity.setWell(sample.getWell());
	}
}
