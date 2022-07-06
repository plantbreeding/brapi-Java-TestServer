package org.brapi.test.BrAPITestServer.controller.germ;

import io.swagger.model.Metadata;
import io.swagger.model.germ.CrossingProjectsSingleResponse;
import io.swagger.model.germ.CrossingProject;
import io.swagger.model.germ.CrossingProjectNewRequest;
import io.swagger.model.germ.CrossingProjectsListResponse;
import io.swagger.model.germ.CrossingProjectsListResponseResult;
import io.swagger.annotations.ApiParam;
import io.swagger.api.germ.CrossingProjectsApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.germ.CrossingProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
@Controller
public class CrossingProjectsApiController extends BrAPIController implements CrossingProjectsApi {

	private static final Logger log = LoggerFactory.getLogger(CrossingProjectsApiController.class);

	private final CrossingProjectService crossingProjectService;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public CrossingProjectsApiController(CrossingProjectService crossingProjectService, HttpServletRequest request) {
		this.crossingProjectService = crossingProjectService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<CrossingProjectsListResponse> crossingProjectsGet(
			@Valid @RequestParam(value = "crossingProjectDbId", required = false) String crossingProjectDbId,
			@Valid @RequestParam(value = "crossingProjectName", required = false) String crossingProjectName,
			@Valid @RequestParam(value = "includePotentialParents", required = false) Boolean includePotentialParents,
			@Valid @RequestParam(value = "commonCropName", required = false) String commonCropName,
			@Valid @RequestParam(value = "programDbId", required = false) String programDbId,
			@Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@Valid @RequestParam(value = "externalReferenceId", required = false) String externalReferenceId,
			@Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<CrossingProject> data = crossingProjectService.findCrossingProjects(crossingProjectDbId,
				crossingProjectName, includePotentialParents, commonCropName, programDbId, externalReferenceId,
				externalReferenceID, externalReferenceSource, metadata);
		return responseOK(new CrossingProjectsListResponse(), new CrossingProjectsListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<CrossingProjectsListResponse> crossingProjectsPost(
			@Valid @RequestBody List<CrossingProjectNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		List<CrossingProject> data = crossingProjectService.saveCrossingProjects(body);
		return responseOK(new CrossingProjectsListResponse(), new CrossingProjectsListResponseResult(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<CrossingProjectsSingleResponse> crossingProjectsCrossingProjectDbIdGet(
			@PathVariable("crossingProjectDbId") String crossingProjectDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		CrossingProject data = crossingProjectService.getCrossingProject(crossingProjectDbId);
		return responseOK(new CrossingProjectsSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<CrossingProjectsSingleResponse> crossingProjectsCrossingProjectDbIdPut(
			@PathVariable("crossingProjectDbId") String crossingProjectDbId,
			@Valid @RequestBody CrossingProjectNewRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		CrossingProject data = crossingProjectService.updateCrossingProject(crossingProjectDbId, body);
		return responseOK(new CrossingProjectsSingleResponse(), data);
	}

}
