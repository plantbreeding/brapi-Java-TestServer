package org.brapi.test.BrAPITestServer.controller.core;

import io.swagger.model.Metadata;
import io.swagger.model.core.Location;
import io.swagger.model.core.LocationListResponse;
import io.swagger.model.core.LocationListResponseResult;
import io.swagger.model.core.LocationNewRequest;
import io.swagger.model.core.LocationSearchRequest;
import io.swagger.model.core.LocationSingleResponse;
import io.swagger.annotations.*;
import io.swagger.api.core.LocationsApi;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.core.LocationService;
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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
@Controller
public class LocationsApiController extends BrAPIController implements LocationsApi {

	private static final Logger log = LoggerFactory.getLogger(LocationsApiController.class);

	private final HttpServletRequest request;
	private final LocationService locationService;

	@org.springframework.beans.factory.annotation.Autowired
	public LocationsApiController(LocationService locationService, HttpServletRequest request) {
		this.locationService = locationService;
		this.request = request;
	}

	public ResponseEntity<LocationListResponse> locationsGet(
			@Valid @RequestParam(value = "locationType", required = false) String locationType,
			@Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<Location> data = locationService.findLocations(locationType, externalReferenceID, externalReferenceSource, metadata);
		return responseOK(new LocationListResponse(), new LocationListResponseResult(), data, metadata);
	}

	public ResponseEntity<LocationSingleResponse> locationsLocationDbIdGet(
			@PathVariable("locationDbId") String locationDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Location data = locationService.getLocation(locationDbId);
		return responseOK(new LocationSingleResponse(), data);
	}

	public ResponseEntity<LocationSingleResponse> locationsLocationDbIdPut(
			@PathVariable("locationDbId") String locationDbId,
			@Valid @RequestBody LocationNewRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Location data = locationService.updateLocation(locationDbId, body);
		return responseOK(new LocationSingleResponse(), data);
	}

	public ResponseEntity<LocationListResponse> locationsPost(@Valid @RequestBody List<LocationNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		List<Location> data = locationService.saveLocations(body);
		return responseOK(new LocationListResponse(), new LocationListResponseResult(), data);
	}

	public ResponseEntity<LocationListResponse> searchLocationsPost(@Valid @RequestBody LocationSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body);
		List<Location> data = locationService.findLocations(body, metadata);
		return responseOK(new LocationListResponse(), new LocationListResponseResult(), data, metadata);
	}

	public ResponseEntity<LocationListResponse> searchLocationsSearchResultsDbIdGet(
			@ApiParam(value = "Permanent unique identifier which references the search results", required = true) @PathVariable("searchResultsDbId") String searchResultsDbId,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		return new ResponseEntity<LocationListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}
}
