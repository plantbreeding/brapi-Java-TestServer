package org.brapi.test.BrAPITestServer.controller.germ;

import io.swagger.model.Metadata;
import io.swagger.model.germ.PlannedCross;
import io.swagger.model.germ.PlannedCrossNewRequest;
import io.swagger.model.germ.PlannedCrossesListResponse;
import io.swagger.model.germ.PlannedCrossesListResponseResult;
import io.swagger.api.germ.PlannedCrossesApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.germ.CrossService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
@Controller
public class PlannedCrossesApiController extends BrAPIController implements PlannedCrossesApi {

	private static final Logger log = LoggerFactory.getLogger(PlannedCrossesApiController.class);

	private final CrossService crossService;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public PlannedCrossesApiController(CrossService crossService, HttpServletRequest request) {
		this.crossService = crossService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<PlannedCrossesListResponse> plannedCrossesGet(
			@RequestParam(value = "crossingProjectDbId", required = false) String crossingProjectDbId,
			@RequestParam(value = "crossingProjectName", required = false) String crossingProjectName,
			@RequestParam(value = "plannedCrossDbId", required = false) String plannedCrossDbId,
			@RequestParam(value = "plannedCrossName", required = false) String plannedCrossName,
			@RequestParam(value = "status", required = false) String status,
			@RequestParam(value = "commonCropName", required = false) String commonCropName,
			@RequestParam(value = "programDbId", required = false) String programDbId,
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
		List<PlannedCross> data = crossService.findPlannedCrosses(crossingProjectDbId, crossingProjectName,
				plannedCrossDbId, plannedCrossName, status, commonCropName, programDbId, externalReferenceId,
				externalReferenceID, externalReferenceSource, metadata);
		return responseOK(new PlannedCrossesListResponse(), new PlannedCrossesListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<PlannedCrossesListResponse> plannedCrossesPost(@RequestBody List<PlannedCrossNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		List<PlannedCross> data = crossService.savePlannedCrosses(body);
		return responseOK(new PlannedCrossesListResponse(), new PlannedCrossesListResponseResult(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<PlannedCrossesListResponse> plannedCrossesPut(
			@RequestBody Map<String, PlannedCrossNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		List<PlannedCross> data = crossService.updatePlannedCrosses(body);
		return responseOK(new PlannedCrossesListResponse(), new PlannedCrossesListResponseResult(), data);
	}

}
