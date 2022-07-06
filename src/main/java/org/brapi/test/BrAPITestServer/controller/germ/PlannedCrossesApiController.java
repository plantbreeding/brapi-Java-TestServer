package org.brapi.test.BrAPITestServer.controller.germ;

import io.swagger.model.Metadata;
import io.swagger.model.germ.PlannedCross;
import io.swagger.model.germ.PlannedCrossNewRequest;
import io.swagger.model.germ.PlannedCrossesListResponse;
import io.swagger.model.germ.PlannedCrossesListResponseResult;
import io.swagger.annotations.ApiParam;
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
import jakarta.validation.Valid;
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
			@Valid @RequestParam(value = "crossingProjectDbId", required = false) String crossingProjectDbId,
			@Valid @RequestParam(value = "crossingProjectName", required = false) String crossingProjectName,
			@Valid @RequestParam(value = "plannedCrossDbId", required = false) String plannedCrossDbId,
			@Valid @RequestParam(value = "plannedCrossName", required = false) String plannedCrossName,
			@Valid @RequestParam(value = "status", required = false) String status,
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
		List<PlannedCross> data = crossService.findPlannedCrosses(crossingProjectDbId, crossingProjectName,
				plannedCrossDbId,plannedCrossName, status, commonCropName, programDbId, externalReferenceId, externalReferenceID,
				externalReferenceSource, metadata);
		return responseOK(new PlannedCrossesListResponse(), new PlannedCrossesListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<PlannedCrossesListResponse> plannedCrossesPost(
			@Valid @RequestBody List<PlannedCrossNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		List<PlannedCross> data = crossService.savePlannedCrosses(body);
		return responseOK(new PlannedCrossesListResponse(), new PlannedCrossesListResponseResult(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<PlannedCrossesListResponse> plannedCrossesPut(
			@Valid @RequestBody Map<String, PlannedCrossNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		List<PlannedCross> data = crossService.updatePlannedCrosses(body);
		return responseOK(new PlannedCrossesListResponse(), new PlannedCrossesListResponseResult(), data);
	}

}
