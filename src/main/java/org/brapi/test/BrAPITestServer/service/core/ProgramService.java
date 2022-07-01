package org.brapi.test.BrAPITestServer.service.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.core.CropEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.PersonEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.ProgramEntity;
import org.brapi.test.BrAPITestServer.repository.core.ProgramRepository;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.brapi.test.BrAPITestServer.service.UpdateUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.core.Program;
import io.swagger.model.core.ProgramNewRequest;
import io.swagger.model.core.ProgramSearchRequest;
import io.swagger.model.core.ProgramSearchRequest.ProgramTypesEnum;

@Service
public class ProgramService {
	private ProgramRepository programRepository;
	private CropService cropService;
	private PeopleService peopleService;

	@Autowired
	public ProgramService(ProgramRepository programRepository, CropService cropService, PeopleService peopleService) {
		this.programRepository = programRepository;
		this.cropService = cropService;
		this.peopleService = peopleService;
	}

	public List<Program> findPrograms(String commonCropName, String abbreviation, String programName,
			String programDbId, ProgramTypesEnum programType, String externalReferenceId, String externalReferenceID,
			String externalReferenceSource, Metadata metadata) throws BrAPIServerException {
		ProgramSearchRequest request = new ProgramSearchRequest();
		if (abbreviation != null)
			request.addAbbreviationsItem(abbreviation);
		if (commonCropName != null)
			request.addCommonCropNamesItem(commonCropName);
		if (programName != null)
			request.addProgramNamesItem(programName);
		if (programDbId != null)
			request.addProgramDbIdsItem(programDbId);
		if (programType != null)
			request.addProgramTypesItem(programType);

		request.addExternalReferenceItem(externalReferenceId, externalReferenceID, externalReferenceSource);
		return findPrograms(request, metadata);
	}

	public List<Program> findPrograms(ProgramSearchRequest request, Metadata metadata) throws BrAPIServerException {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<ProgramEntity> searchQuery = new SearchQueryBuilder<ProgramEntity>(ProgramEntity.class)
				.withExRefs(request.getExternalReferenceIDs(), request.getExternalReferenceSources())
				.appendList(request.getAbbreviations(), "abbreviation")
				.appendList(request.getCommonCropNames(), "crop.cropName")
				.appendList(request.getLeadPersonDbIds(), "leadPerson.id")
				.appendNamesList(request.getLeadPersonNames(), "leadPerson.firstName", "leadPerson.middleName",
						"leadPerson.lastName")
				.appendList(request.getObjectives(), "objective")
				.appendList(request.getProgramDbIds(), "id")
				.appendList(request.getProgramNames(), "name")
				.appendEnumList(request.getProgramTypes(), "programType");
		

		Page<ProgramEntity> page = programRepository.findAllBySearch(searchQuery, pageReq);
		List<Program> programs = page.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, page);
		return programs;
	}

	public Program getProgram(String programDbId) throws BrAPIServerException {
		return convertFromEntity(getProgramEntity(programDbId, HttpStatus.NOT_FOUND));
	}

	public ProgramEntity getProgramEntity(String programDbId) throws BrAPIServerException {
		return getProgramEntity(programDbId, HttpStatus.BAD_REQUEST);
	}

	public ProgramEntity getProgramEntity(String programDbId, HttpStatus errorStatus) throws BrAPIServerException {
		ProgramEntity program = null;
		Optional<ProgramEntity> entityOpt = programRepository.findById(programDbId);
		if (entityOpt.isPresent()) {
			program = entityOpt.get();
		} else {
			throw new BrAPIServerDbIdNotFoundException("program", programDbId);
		}
		return program;
	}

	public Program updateProgram(String programDbId, ProgramNewRequest body) throws BrAPIServerException {
		ProgramEntity savedEntity;
		Optional<ProgramEntity> entityOpt = programRepository.findById(programDbId);
		if (entityOpt.isPresent()) {
			ProgramEntity entity = entityOpt.get();
			updateEntity(entity, body);

			savedEntity = programRepository.save(entity);
		} else {
			throw new BrAPIServerDbIdNotFoundException("program", programDbId);
		}

		return convertFromEntity(savedEntity);
	}

	public List<Program> savePrograms(List<ProgramNewRequest> body) throws BrAPIServerException {
		List<Program> savedPrograms = new ArrayList<>();

		for (ProgramNewRequest list : body) {
			ProgramEntity entity = new ProgramEntity();
			updateEntity(entity, list);
			ProgramEntity savedEntity = programRepository.save(entity);
			savedPrograms.add(convertFromEntity(savedEntity));
		}

		return savedPrograms;
	}

	private Program convertFromEntity(ProgramEntity entity) {
		Program program = new Program();
		program = UpdateUtility.convertFromEntity(entity, program);

		program.setAbbreviation(entity.getAbbreviation());
		program.setDocumentationURL(entity.getDocumentationURL());
		program.setObjective(entity.getObjective());
		program.setProgramDbId(entity.getId());
		program.setProgramName(entity.getName());
		program.setProgramType(entity.getProgramType());
		program.setFundingInformation(entity.getFundingInformation());

		if (entity.getCrop() != null) {
			program.setCommonCropName(entity.getCrop().getCropName());
		}
		if (entity.getLeadPerson() != null) {
			program.setLeadPersonDbId(entity.getLeadPerson().getId());
			program.setLeadPersonName(entity.getLeadPerson().getName());
		}
		
		return program;
	}

	private void updateEntity(ProgramEntity entity, ProgramNewRequest request) throws BrAPIServerException {
		entity = UpdateUtility.updateEntity(request, entity);

		entity.setAbbreviation(UpdateUtility.replaceField(request.getAbbreviation(), entity.getAbbreviation()));
		entity.setDocumentationURL(UpdateUtility.replaceField(request.getDocumentationURL(), entity.getDocumentationURL()));
		entity.setObjective(UpdateUtility.replaceField(request.getObjective(), entity.getObjective()));
		entity.setName(UpdateUtility.replaceField(request.getProgramName(), entity.getName()));
		entity.setProgramType(UpdateUtility.replaceField(request.getProgramType(), entity.getProgramType()));
		entity.setFundingInformation(UpdateUtility.replaceField(request.getFundingInformation(), entity.getFundingInformation()));

		String commonCropName = entity.getCrop() == null ? UpdateUtility.replaceField(request.getCommonCropName(), null)
				: UpdateUtility.replaceField(request.getCommonCropName(), entity.getCrop().getCropName());
		CropEntity crop = cropService.getCropEntity(commonCropName);
		entity.setCrop(crop);

		String leadPersonDbId = entity.getLeadPerson() == null
				? UpdateUtility.replaceField(request.getLeadPersonDbId(), null)
				: UpdateUtility.replaceField(request.getLeadPersonDbId(), entity.getLeadPerson().getId());
		PersonEntity person = peopleService.getPersonEntity(leadPersonDbId);
		entity.setLeadPerson(person);

	}

}
