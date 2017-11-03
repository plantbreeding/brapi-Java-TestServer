package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.Program;
import org.brapi.test.BrAPITestServer.model.metadata.SearchResults;
import org.brapi.test.BrAPITestServer.model.metadata.SearchResultsList;
import org.brapi.test.BrAPITestServer.service.ProgramService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProgramController  extends BrAPIController{

	private ProgramService programService;
	
	public ProgramController(ProgramService programService) {
		this.programService = programService;
	}
	
	public SearchResults<SearchResultsList<Program>> getPrograms(
			@RequestParam String programName,
			@RequestParam String abbreviation,
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		List<Program> programs = programService.getPrograms(programName, abbreviation, page, pageSize);
		return SearchResults.withList(programs).withMetaData(mockMetaData(page, pageSize));
	}
}
