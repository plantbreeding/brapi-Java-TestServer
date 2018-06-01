package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.service.MarkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.api.MarkersApi;
import io.swagger.api.MarkersSearchApi;
import io.swagger.model.Marker;
import io.swagger.model.MarkerResponse;
import io.swagger.model.MarkersResponse2;
import io.swagger.model.MarkersResponse2Result;
import io.swagger.model.MarkersSearchRequest;
import io.swagger.model.Metadata;

@RestController
public class MarkerController extends BrAPIController implements MarkersApi, MarkersSearchApi{
	private MarkersService markersService;

	@Autowired
	public MarkerController(MarkersService markersService) {
		this.markersService = markersService;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<MarkersResponse2> markersSearchGet(@Valid List<String> markerDbIds, @Valid String name,
			@Valid String matchMethod, @Valid Boolean includeSynonyms, @Valid String type, @Valid Integer pageSize,
			@Valid Integer page) {
		
		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<Marker> data = markersService.getMarkers(name, type, markerDbIds, matchMethod, includeSynonyms,
				metaData);
		
		MarkersResponse2Result result = new MarkersResponse2Result();
		result.setData(data);
		MarkersResponse2 response = new MarkersResponse2();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<MarkersResponse2>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<MarkersResponse2> markersSearchPost(@Valid MarkersSearchRequest request) {

		Metadata metaData = generateMetaDataTemplate(request.getPage(), request.getPageSize());
		List<Marker> data = markersService.getMarkers(request.getName(), request.getType(), request.getMarkerDbIds(),
				request.getMatchMethod().name(), request.isIncludeSynonyms(), metaData);
		
		MarkersResponse2Result result = new MarkersResponse2Result();
		result.setData(data);
		MarkersResponse2 response = new MarkersResponse2();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<MarkersResponse2>(response, HttpStatus.OK);
	}

	//Deprecated
	@CrossOrigin
	@Override
	public ResponseEntity<MarkersResponse2> markersGet(@Valid String name, @Valid String matchMethod,
			@Valid String include, @Valid String type, @Valid Integer pageSize, @Valid Integer page) {
		
		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<Marker> data = markersService.getMarkers(name, type, null, matchMethod,
				include.equalsIgnoreCase("synonyms"), metaData);
		
		MarkersResponse2Result result = new MarkersResponse2Result();
		result.setData(data);
		MarkersResponse2 response = new MarkersResponse2();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<MarkersResponse2>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<MarkerResponse> markersMarkerDbIdGet(String markerDbId) {
		Marker result = markersService.getMarker(markerDbId);

		MarkerResponse response = new MarkerResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<MarkerResponse>(response, HttpStatus.OK);
	}
}
