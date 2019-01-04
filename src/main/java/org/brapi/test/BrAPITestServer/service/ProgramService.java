package org.brapi.test.BrAPITestServer.service;

import java.util.List;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.ProgramEntity;
import org.brapi.test.BrAPITestServer.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.Program;
import io.swagger.model.ProgramsSearchRequest;

@Service
public class ProgramService {
	private ProgramRepository programRepository;
	private SearchService searchService;
	
	@Autowired
	public ProgramService( ProgramRepository programRepository, SearchService searchService) {
		this.programRepository = programRepository;
		this.searchService = searchService;
	}

	public List<Program> searchPrograms(String abbreviation, String leadPerson, String name,
			String objective, String programDbId, Metadata metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);

		ProgramsSearchRequest request = new ProgramsSearchRequest();
		if (abbreviation != null)
			request.addAbbreviationsItem(abbreviation);
		if (leadPerson != null)
			request.addLeadPersonNamesItem(leadPerson);
		if (name != null)
			request.addProgramNamesItem(name);
		if (objective != null)
			request.addObjectivesItem(objective);
		if (programDbId != null)
			request.addProgramDbIdsItem(programDbId);
		
		Page<ProgramEntity> page = programRepository.findAllBySearch(request, pageReq);
		List<Program> programs = page.map(this::convertFromEntity).getContent();

		PagingUtility.calculateMetaData(metaData, page);
		return programs;
	}
	
	private Program convertFromEntity(ProgramEntity entity) {
		Program program = new Program();
		program.setAbbreviation(entity.getAbbreviation());
		program.setCommonCropName(entity.getCrop().getCropName());
		program.setDocumentationURL(entity.getDocumentationURL());
		program.setLeadPerson(entity.getLeadPerson().getName());
		program.setLeadPersonDbId(entity.getLeadPerson().getId());
		program.setLeadPersonName(entity.getLeadPerson().getName());
		program.setName(entity.getName());
		program.setObjective(entity.getObjective());
		program.setProgramDbId(entity.getId());
		program.setProgramName(entity.getName());
		
		return program;
	}

	public List<Program> search(ProgramsSearchRequest request, Metadata metadata) throws BrAPIServerException {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		Page<ProgramEntity> page = programRepository.findAllBySearch(request, pageReq);
		List<Program> programs = page.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, page);
		return programs;
	}
}
