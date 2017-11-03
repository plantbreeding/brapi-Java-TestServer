package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.Location;
import org.brapi.test.BrAPITestServer.model.metadata.SearchResults;
import org.brapi.test.BrAPITestServer.model.metadata.SearchResultsList;
import org.brapi.test.BrAPITestServer.service.LocationService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController  extends BrAPIController{

	private LocationService locationService;

	@RequestMapping(value="locations", method= {RequestMethod.GET})
	public SearchResults<SearchResultsList<Location>> getLocations(
			@RequestParam String locationType,
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		List<Location> locations = locationService.getLocations(locationType, page, pageSize);
		
		return SearchResults.withList(locations).withMetaData(mockMetaData(page, pageSize));
		
	}
	
	@RequestMapping(value="locations/{locationDbId}", method= {RequestMethod.GET})
	public SearchResults<Location> getLocation(
			@PathVariable(value="locationDbId") String locationDbId) {
		Location location = locationService.getLocation(locationDbId);
		
		return SearchResults.withObject(location).withMetaData(mockEmptyMetadata());
		
	}
	
	
}
