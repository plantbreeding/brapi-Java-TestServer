package org.brapi.test.BrAPITestServer.service;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.entity.ProgramEntity;
import org.brapi.test.BrAPITestServer.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.Program;

@Service
public class ProgramService {
	private ProgramRepository programRepository;
	
	@Autowired
	public ProgramService( ProgramRepository programRepository) {
		this.programRepository = programRepository;
	}

	public List<Program> searchPrograms(String abbreviation, String leadPerson, String name,
			String objective, String programDbId, Metadata metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);

		Page<ProgramEntity> page = programRepository.findAllBySearch(abbreviation, leadPerson, name,
				objective, programDbId, pageReq);
		List<Program> programs = page.map(this::convertFromEntity).getContent();

		PagingUtility.calculateMetaData(metaData, page);
		return programs;
	}
	
	private Program convertFromEntity(ProgramEntity entity) {
		Program program = new Program();
		program.setAbbreviation(entity.getAbbreviation());
		program.setLeadPerson(entity.getLeadPerson());
		program.setName(entity.getName());
		program.setObjective(entity.getObjective());
		program.setProgramDbId(entity.getId());
		
		return program;
	}
}
