package org.brapi.test.BrAPITestServer.controller.core;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.Metadata;
import io.swagger.model.core.Program;
import io.swagger.model.core.ProgramListResponse;
import io.swagger.model.core.ProgramListResponseResult;
import io.swagger.model.core.ProgramNewRequest;
import io.swagger.model.core.ProgramSearchRequest;
import io.swagger.model.core.ProgramSingleResponse;
import io.swagger.model.germ.Germplasm;
import io.swagger.model.germ.GermplasmListResponse;
import io.swagger.model.germ.GermplasmListResponseResult;
import io.swagger.model.germ.GermplasmSearchRequest;
import io.swagger.annotations.*;
import io.swagger.api.core.ProgramsApi;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity.SearchRequestTypes;
import org.brapi.test.BrAPITestServer.service.SearchService;
import org.brapi.test.BrAPITestServer.service.core.ProgramService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
@Controller
public class ProgramsApiController extends BrAPIController implements ProgramsApi {

	private static final Logger log = LoggerFactory.getLogger(ProgramsApiController.class);

	private final ProgramService programService;
	private final SearchService searchService;
	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public ProgramsApiController(ProgramService programService, SearchService searchService, HttpServletRequest request) {
		this.programService = programService;
		this.searchService = searchService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ProgramListResponse> programsGet(
			@Valid @RequestParam(value = "commonCropName", required = false) String commonCropName,
			@Valid @RequestParam(value = "programName", required = false) String programName,
			@Valid @RequestParam(value = "programDbId", required = false) String programDbId,
			@Valid @RequestParam(value = "abbreviation", required = false) String abbreviation,
			@Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<Program> data = programService.findPrograms(commonCropName, abbreviation, programName, programDbId,
				externalReferenceID, externalReferenceSource, metadata);
		return responseOK(new ProgramListResponse(), new ProgramListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ProgramListResponse> programsPost(@Valid @RequestBody List<ProgramNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		List<Program> data = programService.savePrograms(body);
		return responseOK(new ProgramListResponse(), new ProgramListResponseResult(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ProgramSingleResponse> programsProgramDbIdGet(
			@ApiParam(value = "Filter by the common crop name. Exact match.", required = true) @PathVariable("programDbId") String programDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Program data = programService.getProgram(programDbId);
		return responseOK(new ProgramSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ProgramSingleResponse> programsProgramDbIdPut(
			@ApiParam(value = "Filter by the common crop name. Exact match.", required = true) @PathVariable("programDbId") String programDbId,
			@Valid @RequestBody ProgramNewRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Program data = programService.updateProgram(programDbId, body);
		return responseOK(new ProgramSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchProgramsPost(@Valid @RequestBody ProgramSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body);

		String searchReqDbId = searchService.saveSearchRequest(body, SearchRequestTypes.PROGRAMS);
		if (searchReqDbId != null) {
			return responseAccepted(searchReqDbId);
		} else {
			List<Program> data = programService.findPrograms(body, metadata);
			return responseOK(new ProgramListResponse(), new ProgramListResponseResult(), data, metadata);
		}
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchProgramsSearchResultsDbIdGet(
			@ApiParam(value = "Permanent unique identifier which references the search results", required = true) @PathVariable("searchResultsDbId") String searchResultsDbId,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		SearchRequestEntity request = searchService.findById(searchResultsDbId);
		if (request != null) {
			ProgramSearchRequest body = request.getParameters(ProgramSearchRequest.class);
			List<Program> data = programService.findPrograms(body, metadata);
			return responseOK(new ProgramListResponse(), new ProgramListResponseResult(), data, metadata);
		}else {
			return responseAccepted(searchResultsDbId);
		}
	}
}
