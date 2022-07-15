package org.brapi.test.BrAPITestServer.controller.core;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.Metadata;
import io.swagger.model.core.Location;
import io.swagger.model.core.LocationListResponse;
import io.swagger.model.core.LocationListResponseResult;
import io.swagger.model.core.LocationNewRequest;
import io.swagger.model.core.LocationSearchRequest;
import io.swagger.model.core.LocationSingleResponse;
import io.swagger.api.core.LocationsApi;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity.SearchRequestTypes;
import org.brapi.test.BrAPITestServer.service.SearchService;
import org.brapi.test.BrAPITestServer.service.core.LocationService;
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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
@Controller
public class LocationsApiController extends BrAPIController implements LocationsApi {

	private static final Logger log = LoggerFactory.getLogger(LocationsApiController.class);

	private final HttpServletRequest request;
	private final LocationService locationService;
	private final SearchService searchService;

	@org.springframework.beans.factory.annotation.Autowired
	public LocationsApiController(LocationService locationService, SearchService searchService, HttpServletRequest request) {
		this.locationService = locationService;
		this.searchService = searchService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<LocationListResponse> locationsGet(
			@Valid @RequestParam(value = "locationType", required = false) String locationType,
			@Valid @RequestParam(value = "locationDbId", required = false) String locationDbId,
			@Valid @RequestParam(value = "locationName", required = false) String locationName,
			@Valid @RequestParam(value = "parentLocationDbId", required = false) String parentLocationDbId,
			@Valid @RequestParam(value = "parentLocationName", required = false) String parentLocationName,
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
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<Location> data = locationService.findLocations(locationDbId, locationType, locationName, parentLocationDbId, parentLocationName, commonCropName, programDbId, externalReferenceId, externalReferenceID, externalReferenceSource, metadata);
		return responseOK(new LocationListResponse(), new LocationListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<LocationSingleResponse> locationsLocationDbIdGet(
			@PathVariable("locationDbId") String locationDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Location data = locationService.getLocation(locationDbId);
		return responseOK(new LocationSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<LocationSingleResponse> locationsLocationDbIdPut(
			@PathVariable("locationDbId") String locationDbId,
			@Valid @RequestBody LocationNewRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		Location data = locationService.updateLocation(locationDbId, body);
		return responseOK(new LocationSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<LocationListResponse> locationsPost(@Valid @RequestBody List<LocationNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		List<Location> data = locationService.saveLocations(body);
		return responseOK(new LocationListResponse(), new LocationListResponseResult(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchLocationsPost(@Valid @RequestBody LocationSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body);
		String searchReqDbId = searchService.saveSearchRequest(body, SearchRequestTypes.LOCATIONS);
		if (searchReqDbId != null) {
			return responseAccepted(searchReqDbId);
		} else {
			List<Location> data = locationService.findLocations(body, metadata);
			return responseOK(new LocationListResponse(), new LocationListResponseResult(), data, metadata);
		}
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchLocationsSearchResultsDbIdGet(
			String searchResultsDbId,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		SearchRequestEntity request = searchService.findById(searchResultsDbId);
		if (request != null) {
			LocationSearchRequest body = request.getParameters(LocationSearchRequest.class);
			List<Location> data = locationService.findLocations(body, metadata);
			return responseOK(new LocationListResponse(), new LocationListResponseResult(), data, metadata);
		}else {
			return responseAccepted(searchResultsDbId);
		}
	}
}
