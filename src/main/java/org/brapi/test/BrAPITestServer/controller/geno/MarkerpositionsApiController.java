package org.brapi.test.BrAPITestServer.controller.geno;

import io.swagger.model.Metadata;
import io.swagger.model.geno.MarkerPosition;
import io.swagger.model.geno.MarkerPositionsListResponse;
import io.swagger.model.geno.MarkerPositionsListResponseResult;
import io.swagger.model.geno.MarkerPositionSearchRequest;

import io.swagger.api.geno.MarkerpositionsApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.geno.MarkerPositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
@Controller
public class MarkerpositionsApiController extends BrAPIController implements MarkerpositionsApi {

	private static final Logger log = LoggerFactory.getLogger(MarkerpositionsApiController.class);

	private final MarkerPositionService markerPositionService;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public MarkerpositionsApiController(MarkerPositionService markerPositionService, HttpServletRequest request) {
		this.markerPositionService = markerPositionService;
		this.request = request;
	}

	public ResponseEntity<MarkerPositionsListResponse> markerpositionsGet(
			@Valid @RequestParam(value = "mapDbId", required = false) String mapDbId,
			@Valid @RequestParam(value = "linkageGroupName", required = false) String linkageGroupName,
			@Valid @RequestParam(value = "variantDbId", required = false) String variantDbId,
			@Valid @RequestParam(value = "minPosition", required = false) Integer minPosition,
			@Valid @RequestParam(value = "maxPosition", required = false) Integer maxPosition,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<MarkerPosition> data = markerPositionService.findMarkerPositions(mapDbId, linkageGroupName, variantDbId, maxPosition,
				minPosition, metadata);
		return responseOK(new MarkerPositionsListResponse(), new MarkerPositionsListResponseResult(), data, metadata);
	}

	public ResponseEntity<MarkerPositionsListResponse> searchMarkerpositionsPost(
			@Valid @RequestBody MarkerPositionSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body);
		List<MarkerPosition> data = markerPositionService.findMarkerPositions(body, metadata);
		return responseOK(new MarkerPositionsListResponse(), new MarkerPositionsListResponseResult(), data, metadata);
	}

	public ResponseEntity<MarkerPositionsListResponse> searchMarkerpositionsSearchResultsDbIdGet(
			@PathVariable("searchResultsDbId") String searchResultsDbId,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		return new ResponseEntity<MarkerPositionsListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

}
