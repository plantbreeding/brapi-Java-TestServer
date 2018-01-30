package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.rest.Marker;
import org.brapi.test.BrAPITestServer.model.rest.MarkersSearchRequest;
import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResults;
import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResultsDataList;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.brapi.test.BrAPITestServer.service.MarkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarkerController extends BrAPIController {
	private MarkersService markersService;

	@Autowired
	public MarkerController(MarkersService markersService) {
		this.markersService = markersService;
	}

	// Deprecated
	@RequestMapping(value = "markers", method = { RequestMethod.GET })
	public GenericResults<GenericResultsDataList<Marker>> getMarkers(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "matchMethod", defaultValue = "exact") String matchMethod,
			@RequestParam(value = "include", defaultValue = "synonyms") String synonyms,
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		List<Marker> markers = markersService.getMarkers(name, type, null, matchMethod,
				synonyms.equalsIgnoreCase("synonyms"), metaData);

		return GenericResults.withList(markers).withMetaData(metaData);
	}

	@RequestMapping(value = "markers-search", method = { RequestMethod.GET })
	public GenericResults<GenericResultsDataList<Marker>> getMarkersSearch(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "markerDbIds", required = false) List<String> markerDbIds,
			@RequestParam(value = "matchMethod", defaultValue = "exact") String matchMethod,
			@RequestParam(value = "includeSynonyms", defaultValue = "true") boolean includeSynonyms,
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {

		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		List<Marker> markers = markersService.getMarkers(name, type, markerDbIds, matchMethod, includeSynonyms,
				metaData);

		return GenericResults.withList(markers).withMetaData(metaData);
	}

	@RequestMapping(value = "markers-search", method = { RequestMethod.POST })
	public GenericResults<GenericResultsDataList<Marker>> postMarkersSearch(@RequestBody MarkersSearchRequest request) {

		MetaData metaData = generateMetaDataTemplate(request.getPage(), request.getPageSize());
		List<Marker> markers = markersService.getMarkers(request.getName(), request.getType(), request.getMarkerDbIds(),
				request.getMatchMethod(), request.isIncludeSynonyms(), metaData);

		return GenericResults.withList(markers).withMetaData(metaData);
	}

	@RequestMapping(value = "markers/{markerDbId}", method = { RequestMethod.GET })
	public GenericResults<Marker> getMarker(@PathVariable(value = "markerDbId") String markerDbId) {
		Marker marker = markersService.getMarker(markerDbId);

		return GenericResults.withObject(marker).withMetaData(generateEmptyMetadata());
	}
}
