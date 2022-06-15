package org.brapi.test.BrAPITestServer.service.geno;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.core.ProgramEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.StudyEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.TrialEntity;
import org.brapi.test.BrAPITestServer.model.entity.geno.PlateEntity;
import org.brapi.test.BrAPITestServer.repository.geno.PlateRepository;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.brapi.test.BrAPITestServer.service.UpdateUtility;
import org.brapi.test.BrAPITestServer.service.core.ProgramService;
import org.brapi.test.BrAPITestServer.service.core.StudyService;
import org.brapi.test.BrAPITestServer.service.core.TrialService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.geno.Plate;
import io.swagger.model.geno.PlateNewRequest;
import io.swagger.model.geno.PlateSearchRequest;

@Service
public class PlateService {
	private final PlateRepository plateRepository;
	private final ProgramService programService;
	private final TrialService trialService;
	private final StudyService studyService;

	public PlateService(PlateRepository plateRepository, ProgramService programService, TrialService trialService,
			StudyService studyService) {
		super();
		this.plateRepository = plateRepository;
		this.programService = programService;
		this.trialService = trialService;
		this.studyService = studyService;
	}

	public List<Plate> findPlates(String sampleDbId, String sampleName, String sampleGroupDbId,
			String observationUnitDbId, String plateDbId, String plateName, String germplasmDbId, String studyDbId,
			String trialDbId, String commonCropName, String programDbId, String externalReferenceId,
			String externalReferenceID, String externalReferenceSource, Metadata metadata) {
		PlateSearchRequest request = new PlateSearchRequest();
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

		return findPlates(request, metadata);
	}

	public List<Plate> findPlates(PlateSearchRequest request, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<PlateEntity> searchQuery = new SearchQueryBuilder<PlateEntity>(PlateEntity.class);
		if (request.getSampleDbIds() != null || request.getSampleNames() != null
				|| request.getSampleGroupDbIds() != null || request.getGermplasmDbIds() != null
				|| request.getGermplasmNames() != null || request.getObservationUnitDbIds() != null) {
			searchQuery.join("samples", "sample").appendList(request.getSampleDbIds(), "*sample.id")
					.appendList(request.getSampleNames(), "*sample.name")
					.appendList(request.getSampleGroupDbIds(), "*sample.groupDbId")
					.appendList(request.getGermplasmDbIds(), "*sample.observationUnit.germplasm.id")
					.appendList(request.getGermplasmNames(), "*sample.observationUnit.germplasm.germplasmName")
					.appendList(request.getObservationUnitDbIds(), "*sample.observationUnit.id");
		}

		searchQuery.withExRefs(request.getExternalReferenceIDs(), request.getExternalReferenceSources())
				.appendList(request.getPlateDbIds(), "id").appendList(request.getPlateNames(), "name")
				.appendList(request.getPlateBarcodes(), "barcode")
				.appendList(request.getCommonCropNames(), "program.crop.crop_name")
				.appendList(request.getProgramDbIds(), "program.id")
				.appendList(request.getProgramNames(), "program.name").appendList(request.getTrialDbIds(), "trial.id")
				.appendList(request.getTrialNames(), "trial.trialName").appendList(request.getStudyDbIds(), "study.id")
				.appendList(request.getStudyNames(), "study.studyName");

		Page<PlateEntity> page = plateRepository.findAllBySearch(searchQuery, pageReq);
		List<Plate> plates = page.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, page);
		return plates;
	}

	public Plate getPlate(String plateDbId) throws BrAPIServerException {
		return convertFromEntity(getPlateEntity(plateDbId));
	}

	public PlateEntity getPlateEntity(String plateDbId) throws BrAPIServerException {
		PlateEntity plate = null;
		Optional<PlateEntity> entityOpt = plateRepository.findById(plateDbId);
		if (entityOpt.isPresent()) {
			plate = entityOpt.get();
		} else {
			throw new BrAPIServerDbIdNotFoundException("plate", plateDbId);
		}
		return plate;
	}

	public List<Plate> savePlates(List<PlateNewRequest> body) throws BrAPIServerException {
		List<Plate> savedPlates = new ArrayList<>();

		for (PlateNewRequest plate : body) {
			PlateEntity entity = new PlateEntity();
			updateEntity(entity, plate);
			PlateEntity savedEntity = plateRepository.save(entity);
			savedPlates.add(convertFromEntity(savedEntity));
		}

		return savedPlates;
	}

	public List<Plate> updatePlates(Map<String, PlateNewRequest> requests) throws BrAPIServerException {
		List<Plate> savedplates = new ArrayList<>();

		for (Entry<String, PlateNewRequest> entry : requests.entrySet()) {
			PlateEntity savedEntity;
			Optional<PlateEntity> entityOpt = plateRepository.findById(entry.getKey());
			if (entityOpt.isPresent()) {
				PlateEntity entity = entityOpt.get();
				updateEntity(entity, entry.getValue());

				savedEntity = plateRepository.save(entity);
			} else {
				throw new BrAPIServerDbIdNotFoundException("plate", entry.getKey());
			}

			savedplates.add(convertFromEntity(savedEntity));
		}

		return savedplates;

	}

	private void updateEntity(PlateEntity entity, PlateNewRequest plate) throws BrAPIServerException {
		UpdateUtility.updateEntity(plate, entity);
		if (plate.getPlateName() != null) {
			entity.setPlateName(plate.getPlateName());
		}
		if (plate.getPlateBarcode() != null) {
			entity.setPlateBarcode(plate.getPlateBarcode());
		}
		if (plate.getPlateFormat() != null) {
			entity.setPlateFormat(plate.getPlateFormat());
		}
		if (plate.getSampleType() != null) {
			entity.setSampleType(plate.getSampleType());
		}
		if (plate.getStudyDbId() != null) {
			StudyEntity study = studyService.getStudyEntity(plate.getStudyDbId());
			entity.setStudy(study);
		} else if (plate.getTrialDbId() != null) {
			TrialEntity trial = trialService.getTrialEntity(plate.getTrialDbId());
			entity.setTrial(trial);
		} else if (plate.getProgramDbId() != null) {
			ProgramEntity program = programService.getProgramEntity(plate.getProgramDbId());
			entity.setProgram(program);
		}
	}

	private Plate convertFromEntity(PlateEntity entity) {
		Plate plate = new Plate();
		UpdateUtility.convertFromEntity(entity, plate);
		plate.setPlateDbId(entity.getId());
		plate.setPlateName(entity.getPlateName());
		plate.setPlateBarcode(entity.getPlateBarcode());
		plate.setPlateFormat(entity.getPlateFormat());
		plate.setSampleType(entity.getSampleType());

		if (entity.getStudy() != null) {
			plate.setStudyDbId(entity.getStudy().getId());
			if (entity.getStudy().getTrial() != null) {
				plate.setTrialDbId(entity.getStudy().getTrial().getId());
				if (entity.getStudy().getTrial().getProgram() != null) {
					plate.setProgramDbId(entity.getStudy().getTrial().getProgram().getId());
				}
			}
		} else if (entity.getTrial() != null) {
			plate.setTrialDbId(entity.getTrial().getId());
			if (entity.getTrial().getProgram() != null) {
				plate.setProgramDbId(entity.getTrial().getProgram().getId());
			}
		} else if (entity.getProgram() != null) {
			plate.setProgramDbId(entity.getProgram().getId());
		}
		return plate;
	}

}
