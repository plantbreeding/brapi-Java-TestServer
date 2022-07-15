package org.brapi.test.BrAPITestServer.controller.core;

import io.swagger.api.core.ProgramsApi;
import io.swagger.model.BrAPIResponse;
import io.swagger.model.Metadata;
import io.swagger.model.core.Program;
import io.swagger.model.core.ProgramListResponse;
import io.swagger.model.core.ProgramListResponseResult;
import io.swagger.model.core.ProgramNewRequest;
import io.swagger.model.core.ProgramSearchRequest;
import io.swagger.model.core.ProgramSearchRequest.ProgramTypesEnum;
import io.swagger.model.core.ProgramSingleResponse;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity.SearchRequestTypes;
import org.brapi.test.BrAPITestServer.service.SearchService;
import org.brapi.test.BrAPITestServer.service.core.ProgramService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ProgramsApiController(ProgramService programService, SearchService searchService,
			HttpServletRequest request) {
		this.programService = programService;
		this.searchService = searchService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ProgramListResponse> programsGet(
			@RequestParam(value = "commonCropName", required = false) String commonCropName,
			@RequestParam(value = "programName", required = false) String programName,
			@RequestParam(value = "programDbId", required = false) String programDbId,
			@RequestParam(value = "abbreviation", required = false) String abbreviation,
			@RequestParam(value = "programType", required = false) ProgramTypesEnum programType,
			@RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@RequestParam(value = "externalReferenceId", required = false) String externalReferenceId,
			@RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<Program> data = programService.findPrograms(commonCropName, abbreviation, programName, programDbId, programType, externalReferenceId, externalReferenceID, externalReferenceSource, metadata);
		return responseOK(new ProgramListResponse(), new ProgramListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ProgramListResponse> programsPost(@RequestBody List<ProgramNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		List<Program> data = programService.savePrograms(body);
		return responseOK(new ProgramListResponse(), new ProgramListResponseResult(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ProgramSingleResponse> programsProgramDbIdGet(@PathVariable("programDbId") String programDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Program data = programService.getProgram(programDbId);
		return responseOK(new ProgramSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ProgramSingleResponse> programsProgramDbIdPut(@PathVariable("programDbId") String programDbId,
			@RequestBody ProgramNewRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		Program data = programService.updateProgram(programDbId, body);
		return responseOK(new ProgramSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchProgramsPost(@RequestBody ProgramSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
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
			@PathVariable("searchResultsDbId") String searchResultsDbId,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		SearchRequestEntity request = searchService.findById(searchResultsDbId);
		if (request != null) {
			ProgramSearchRequest body = request.getParameters(ProgramSearchRequest.class);
			List<Program> data = programService.findPrograms(body, metadata);
			return responseOK(new ProgramListResponse(), new ProgramListResponseResult(), data, metadata);
		} else {
			return responseAccepted(searchResultsDbId);
		}
	}
}
