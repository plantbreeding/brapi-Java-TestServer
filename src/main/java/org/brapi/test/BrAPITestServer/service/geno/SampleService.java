package org.brapi.test.BrAPITestServer.service.geno;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;

import jakarta.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.core.ProgramEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.StudyEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.TrialEntity;
import org.brapi.test.BrAPITestServer.model.entity.geno.PlateEntity;
import org.brapi.test.BrAPITestServer.model.entity.geno.SampleEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationUnitEntity;
import org.brapi.test.BrAPITestServer.repository.geno.SampleRepository;
import org.brapi.test.BrAPITestServer.service.DateUtility;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.brapi.test.BrAPITestServer.service.core.ProgramService;
import org.brapi.test.BrAPITestServer.service.core.StudyService;
import org.brapi.test.BrAPITestServer.service.core.TrialService;
import org.brapi.test.BrAPITestServer.service.pheno.ObservationUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.geno.Plate;
import io.swagger.model.geno.PlateNewRequest;
import io.swagger.model.geno.Sample;
import io.swagger.model.geno.SampleNewRequest;
import io.swagger.model.geno.SampleSearchRequest;

@Service
public class SampleService {
	private SampleRepository sampleRepository;
	private PlateService plateService;
	private ObservationUnitService observationUnitservice;
	private final StudyService studyService;
	private final TrialService trialService;
	private final ProgramService programService;

	@Autowired
	public SampleService(SampleRepository sampleRepository, PlateService plateService, StudyService studyService,
			TrialService trialService, ProgramService programService, ObservationUnitService observationUnitservice) {
		this.sampleRepository = sampleRepository;
		this.observationUnitservice = observationUnitservice;
		this.plateService = plateService;
		this.studyService = studyService;
		this.trialService = trialService;
		this.programService = programService;
	}

	public List<Sample> findSamples(String sampleDbId, String sampleName, String sampleGroupDbId,
			String observationUnitDbId, String plateDbId, String plateName, String germplasmDbId, String studyDbId,
			String trialDbId, String commonCropName, String programDbId, String externalReferenceId,
			String externalReferenceID, String externalReferenceSource, Metadata metadata) {
		SampleSearchRequest request = new SampleSearchRequest();
		if (sampleDbId != null)
			request.addSampleDbIdsItem(sampleDbId);
		if (sampleName != null)
			request.addSampleNamesItem(sampleName);
		if (sampleGroupDbId != null)
			request.addSampleGroupDbIdsItem(sampleGroupDbId);
		if (observationUnitDbId != null)
			request.addObservationUnitDbIdsItem(observationUnitDbId);
		if (plateDbId != null)
			request.addPlateDbIdsItem(plateDbId);
		if (plateName != null)
			request.addPlateNamesItem(plateName);
		if (germplasmDbId != null)
			request.addGermplasmDbIdsItem(germplasmDbId);
		if (commonCropName != null)
			request.addCommonCropNamesItem(commonCropName);
		if (programDbId != null)
			request.addProgramDbIdsItem(programDbId);
		if (trialDbId != null)
			request.addTrialDbIdsItem(trialDbId);
		if (studyDbId != null)
			request.addStudyDbIdsItem(studyDbId);

		request.addExternalReferenceItem(externalReferenceId, externalReferenceID, externalReferenceSource);

		return findSamples(request, metadata);
	}

	public List<Sample> findSamples(SampleSearchRequest request, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<SampleEntity> searchQuery = new SearchQueryBuilder<SampleEntity>(SampleEntity.class)
				.withExRefs(request.getExternalReferenceIDs(), request.getExternalReferenceSources())
				.appendList(request.getGermplasmDbIds(), "observationUnit.germplasm.id")
				.appendList(request.getGermplasmNames(), "observationUnit.germplasm.germplasmName")
				.appendList(request.getObservationUnitDbIds(), "observationUnit.id")
				.appendList(request.getPlateDbIds(), "plate.id").appendList(request.getPlateNames(), "plate.name")
				.appendList(request.getSampleDbIds(), "id").appendList(request.getSampleNames(), "name")
				.appendList(request.getSampleGroupDbIds(), "groupDbId")
				.appendList(request.getCommonCropNames(), "plate.program.crop.crop_name")
				.appendList(request.getProgramDbIds(), "plate.program.id")
				.appendList(request.getProgramNames(), "plate.program.name")
				.appendList(request.getTrialDbIds(), "plate.trial.id")
				.appendList(request.getTrialNames(), "plate.trial.trialName")
				.appendList(request.getStudyDbIds(), "plate.study.id")
				.appendList(request.getStudyNames(), "plate.study.studyName");

		Page<SampleEntity> page = sampleRepository.findAllBySearch(searchQuery, pageReq);
		List<Sample> samples = page.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, page);
		return samples;
	}

	public Sample getSample(String sampleDbId) throws BrAPIServerException {
		return convertFromEntity(getSampleEntity(sampleDbId, HttpStatus.NOT_FOUND));
	}

	public SampleEntity getSampleEntity(String sampleDbId) throws BrAPIServerException {
		return getSampleEntity(sampleDbId, HttpStatus.BAD_REQUEST);
	}

	public SampleEntity getSampleEntity(String sampleDbId, HttpStatus errorStatus) throws BrAPIServerException {
		SampleEntity sample = null;
		Optional<SampleEntity> entityOpt = sampleRepository.findById(sampleDbId);
		if (entityOpt.isPresent()) {
			sample = entityOpt.get();
		} else {
			throw new BrAPIServerDbIdNotFoundException("sample", sampleDbId, errorStatus);
		}
		return sample;
	}

	public List<Sample> saveSamples(List<SampleNewRequest> body) throws BrAPIServerException {
		List<Sample> savedSamples = new ArrayList<>();

		for (SampleNewRequest list : body) {
			SampleEntity entity = new SampleEntity();
			updateEntity(entity, list);
			SampleEntity savedEntity = sampleRepository.save(entity);
			savedSamples.add(convertFromEntity(savedEntity));
		}

		return savedSamples;
	}

	public Sample updateSample(String sampleDbId, SampleNewRequest body) throws BrAPIServerException {
		SampleEntity entity = getSampleEntity(sampleDbId, HttpStatus.NOT_FOUND);
		updateEntity(entity, body);
		SampleEntity savedEntity = sampleRepository.save(entity);

		return convertFromEntity(savedEntity);
	}

	public List<Sample> updateSamples(@Valid Map<String, SampleNewRequest> requests) throws BrAPIServerException {
		List<Sample> savedSamples = new ArrayList<>();

		for (Entry<String, SampleNewRequest> entry : requests.entrySet()) {
			Sample saved = updateSample(entry.getKey(), entry.getValue());
			savedSamples.add(saved);
		}

		return savedSamples;
	}

	private Sample convertFromEntity(SampleEntity entity) {
		Sample sample = new Sample();
		sample.setAdditionalInfo(entity.getAdditionalInfo());
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
		} else if (entity.getStudy() != null) {
			sample.setStudyDbId(entity.getStudy().getId());
			if (entity.getStudy().getTrial() != null) {
				sample.setTrialDbId(entity.getStudy().getTrial().getId());
				if (entity.getStudy().getTrial().getProgram() != null) {
					sample.setProgramDbId(entity.getStudy().getTrial().getProgram().getId());
				}
			}
		} else if (entity.getTrial() != null) {
			sample.setTrialDbId(entity.getTrial().getId());
			if (entity.getTrial().getProgram() != null) {
				sample.setProgramDbId(entity.getTrial().getProgram().getId());
			}
		} else if (entity.getProgram() != null) {
			sample.setProgramDbId(entity.getProgram().getId());
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
			entity.setStudy(observationUnit.getStudy());
			entity.setTrial(observationUnit.getTrial());
			entity.setProgram(observationUnit.getProgram());
		} else if (sample.getStudyDbId() != null) {
			StudyEntity study = studyService.getStudyEntity(sample.getStudyDbId());
			entity.setStudy(study);
			entity.setTrial(study.getTrial());
			entity.setProgram(study.getProgram());
		} else if (sample.getTrialDbId() != null) {
			TrialEntity trial = trialService.getTrialEntity(sample.getTrialDbId());
			entity.setTrial(trial);
			entity.setProgram(trial.getProgram());
		} else if (sample.getProgramDbId() != null) {
			ProgramEntity program = programService.getProgramEntity(sample.getProgramDbId());
			entity.setProgram(program);
		}

		if (sample.getPlateDbId() != null) {
			PlateEntity plate = plateService.getPlateEntity(sample.getPlateDbId());
			entity.setPlate(plate);
		} else if (sample.getPlateName() != null) {
			PlateNewRequest newPlate = new PlateNewRequest().plateName(sample.getPlateName());
			List<Plate> savedPlate = plateService.savePlates(Arrays.asList(newPlate));
			if (!savedPlate.isEmpty()) {
				PlateEntity newPlateEntity = plateService.getPlateEntity(savedPlate.get(0).getPlateDbId());
				entity.setPlate(newPlateEntity);
			}
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
