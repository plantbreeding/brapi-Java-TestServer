package org.brapi.test.BrAPITestServer.service;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.entity.ProgramEntity;
import org.brapi.test.BrAPITestServer.model.rest.Program;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.brapi.test.BrAPITestServer.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProgramService {
	private ProgramRepository programRepository;
	
	@Autowired
	public ProgramService( ProgramRepository programRepository) {
		this.programRepository = programRepository;
	}

	public List<Program> getPrograms(String programName, String abbreviation, MetaData metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);

		List<Program> programs;
		if (programName != null && abbreviation != null) {
			programs = programRepository.findAllByNameAndAbbreviation(programName, abbreviation, pageReq).map(this::convertFromEntity).getContent();
			metaData.getPagination().setTotalCount((int) programRepository.countByNameAndAbbreviation(programName, abbreviation));
		} else if (abbreviation != null) {
			programs = programRepository.findAllByAbbreviation(abbreviation, pageReq).map(this::convertFromEntity).getContent();
			metaData.getPagination().setTotalCount((int) programRepository.countByAbbreviation(abbreviation));
		} else if (programName != null) {
			programs = programRepository.findAllByName(programName, pageReq).map(this::convertFromEntity).getContent();
			metaData.getPagination().setTotalCount((int) programRepository.countByName(programName));
		} else {
			programs = programRepository.findAll(pageReq).map(this::convertFromEntity).getContent();
			metaData.getPagination().setTotalCount((int) programRepository.count());
		}

		PagingUtility.calculateMetaData(metaData);
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
