package org.brapi.test.BrAPITestServer.controller.germ;

import io.swagger.model.Metadata;
import io.swagger.model.germ.Cross;
import io.swagger.model.germ.CrossNewRequest;
import io.swagger.model.germ.CrossesListResponse;
import io.swagger.model.germ.CrossesListResponseResult;
import io.swagger.api.germ.CrossesApi;

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
public class CrossesApiController extends BrAPIController implements CrossesApi {

	private static final Logger log = LoggerFactory.getLogger(CrossesApiController.class);

	private final CrossService crossService;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public CrossesApiController(CrossService crossService, HttpServletRequest request) {
		this.crossService = crossService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<CrossesListResponse> crossesGet(
			@RequestParam(value = "crossingProjectDbId", required = false) String crossingProjectDbId,
			@RequestParam(value = "crossingProjectName", required = false) String crossingProjectName,
			@RequestParam(value = "crossDbId", required = false) String crossDbId,
			@RequestParam(value = "crossName", required = false) String crossName,
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
		List<Cross> data = crossService.findCrosses(crossingProjectDbId, crossingProjectName, crossDbId, crossName,
				commonCropName, programDbId, externalReferenceId, externalReferenceID, externalReferenceSource,
				metadata);
		return responseOK(new CrossesListResponse(), new CrossesListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<CrossesListResponse> crossesPost(@RequestBody List<CrossNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		List<Cross> data = crossService.saveCrosses(body);
		return responseOK(new CrossesListResponse(), new CrossesListResponseResult(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<CrossesListResponse> crossesPut(@RequestBody Map<String, CrossNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		List<Cross> data = crossService.updateCrosses(body);
		return responseOK(new CrossesListResponse(), new CrossesListResponseResult(), data);
	}

}
