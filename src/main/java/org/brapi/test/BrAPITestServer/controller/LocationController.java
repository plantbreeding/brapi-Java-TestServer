package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.api.LocationsApi;
import io.swagger.model.Location;
import io.swagger.model.LocationResponse;
import io.swagger.model.LocationsResponse;
import io.swagger.model.LocationsResponseResult;
import io.swagger.model.Metadata;

@RestController
public class LocationController extends BrAPIController implements LocationsApi {

	private LocationService locationService;

	@Autowired
	public LocationController(LocationService locationService) {
		this.locationService = locationService;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<LocationsResponse> locationsGet(@Valid String locationType, @Valid Integer pageSize,
			@Valid Integer page) throws BrAPIServerException {

		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<Location> data = locationService.getLocations(locationType, metaData);

		LocationsResponseResult result = new LocationsResponseResult();
		result.setData(data);
		LocationsResponse response = new LocationsResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<LocationsResponse>(response, HttpStatus.OK);

	}

	@CrossOrigin
	@Override
	public ResponseEntity<LocationResponse> locationsLocationDbIdGet(
			@PathVariable("locationDbId") String locationDbId) {

		Location result = locationService.getLocation(locationDbId);

		LocationResponse response = new LocationResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<LocationResponse>(response, HttpStatus.OK);
	}

}
