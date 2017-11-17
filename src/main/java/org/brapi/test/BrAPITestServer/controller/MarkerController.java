package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.rest.Marker;
import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResults;
import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResultsDataList;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.brapi.test.BrAPITestServer.service.MarkersService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarkerController  extends BrAPIController{
	private MarkersService markersService;
	
	@RequestMapping(value="markers", method= {RequestMethod.GET})
	public GenericResults<GenericResultsDataList<Marker>> getMarkers(
			@RequestParam String name,
			@RequestParam String type,
			@RequestParam String matchMethod,
			@RequestParam String synonyms,
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		List<Marker> markers = markersService.getMarkers(name, type, matchMethod, synonyms, metaData);
		
		return GenericResults.withList(markers).withMetaData(metaData);
	}
	
	@RequestMapping(value="markers/{markerDbId}", method= {RequestMethod.GET})
	public GenericResults<Marker> getMarker(
			@PathVariable(value="markerDbId") String markerDbId){
		Marker marker = markersService.getMarker(markerDbId);
		
		return GenericResults.withObject(marker).withMetaData(generateEmptyMetadata());
	}
}
