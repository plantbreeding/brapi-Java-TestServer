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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
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

	public ResponseEntity<CrossesListResponse> crossesGet(
			@Valid @RequestParam(value = "crossDbId", required = false) String crossDbId,
			@Valid @RequestParam(value = "crossingProjectDbId", required = false) String crossingProjectDbId,
			@Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<Cross> data = crossService.findCrosses(crossDbId, crossingProjectDbId, externalReferenceID, externalReferenceSource, metadata);
		return responseOK(new CrossesListResponse(), new CrossesListResponseResult(), data, metadata);
	}

	public ResponseEntity<CrossesListResponse> crossesPost(
			@Valid @RequestBody List<CrossNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		List<Cross> data = crossService.saveCrosses(body);
		return responseOK(new CrossesListResponse(), new CrossesListResponseResult(), data);
	}

	public ResponseEntity<CrossesListResponse> crossesPut(
			@Valid @RequestBody Map<String, CrossNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		List<Cross> data = crossService.updateCrosses(body);
		return responseOK(new CrossesListResponse(), new CrossesListResponseResult(), data);
	}

}
