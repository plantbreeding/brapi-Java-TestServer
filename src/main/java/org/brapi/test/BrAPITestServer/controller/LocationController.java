package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.rest.Location;
import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResults;
import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResultsDataList;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.brapi.test.BrAPITestServer.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController  extends BrAPIController{

	private LocationService locationService;
	
	@Autowired
	public LocationController(LocationService locationService) {
		this.locationService = locationService;
	}

	@RequestMapping(value="locations", method= {RequestMethod.GET})
	public GenericResults<GenericResultsDataList<Location>> getLocations(
			@RequestParam(required=false) String locationType,
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		List<Location> locations = locationService.getLocations(locationType, metaData);
		
		return GenericResults.withList(locations).withMetaData(metaData);
		
	}
	
	@RequestMapping(value="locations/{locationDbId}", method= {RequestMethod.GET})
	public GenericResults<Location> getLocation(
			@PathVariable(value="locationDbId") String locationDbId) {
		Location location = locationService.getLocation(locationDbId);
		
		return GenericResults.withObject(location).withMetaData(generateEmptyMetadata());
		
	}
	
	
}
