package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.ProgramService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.api.ProgramsApi;
import io.swagger.api.ProgramsSearchApi;
import io.swagger.model.Metadata;
import io.swagger.model.Program;
import io.swagger.model.ProgramsResponse;
import io.swagger.model.ProgramsResponseResult;
import io.swagger.model.ProgramsSearchRequestDeprecated;

@RestController
public class ProgramController extends BrAPIController implements ProgramsApi, ProgramsSearchApi {

	private ProgramService programService;

	public ProgramController(ProgramService programService) {
		this.programService = programService;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ProgramsResponse> programsGet(@Valid String commonCropName, @Valid String programName,
			@Valid String abbreviation, @Valid Integer page, @Valid Integer pageSize, String authorization)
			throws BrAPIServerException {

		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<Program> data = programService.searchPrograms(commonCropName, abbreviation, null, programName, null, null, metaData);

		ProgramsResponseResult result = new ProgramsResponseResult();
		result.setData(data);
		ProgramsResponse response = new ProgramsResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<ProgramsResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ProgramsResponse> programsSearchPost(@Valid @RequestBody ProgramsSearchRequestDeprecated request)
			throws BrAPIServerException {

		Metadata metaData = generateMetaDataTemplate(request.getPage(), request.getPageSize());
		List<Program> data = programService.searchPrograms(null, request.getAbbreviation(), request.getLeadPerson(),
				request.getName(), request.getObjective(), request.getProgramDbId(), metaData);

		ProgramsResponseResult result = new ProgramsResponseResult();
		result.setData(data);
		ProgramsResponse response = new ProgramsResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<ProgramsResponse>(response, HttpStatus.OK);
	}
}
