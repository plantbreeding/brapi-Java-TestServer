package org.brapi.test.BrAPITestServer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.MarkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.api.MarkersApi;
import io.swagger.api.MarkersSearchApi;
import io.swagger.model.Marker;
import io.swagger.model.MarkerResponse;
import io.swagger.model.MarkersResponse;
import io.swagger.model.MarkersResponseResult;
import io.swagger.model.MarkersSearchRequest;
import io.swagger.model.MarkersSearchRequest.MatchMethodEnum;
import io.swagger.model.Metadata;

@RestController
public class MarkerController extends BrAPIController implements MarkersApi, MarkersSearchApi{
	private MarkersService markersService;

	@Autowired
	public MarkerController(MarkersService markersService) {
		this.markersService = markersService;
	}

	@Override
	public ResponseEntity<MarkersResponse> markersGet(@Valid String markerDbId, @Valid String markerName,
			@Valid String name, @Valid String matchMethod, @Valid Boolean includeSynonyms, @Valid String include,
			@Valid String type, @Valid Integer page, @Valid Integer pageSize, String authorization)
			throws BrAPIServerException {
		
		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<Marker> data = markersService.getMarkers(name, type, null, MatchMethodEnum.fromValue(matchMethod),
				"synonyms".equals(include), metaData);
		
		MarkersResponseResult result = new MarkersResponseResult();
		result.setData(data);
		MarkersResponse response = new MarkersResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<MarkersResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<MarkerResponse> markersMarkerDbIdGet(@PathVariable("markerDbId") String markerDbId, String authorization)
			throws BrAPIServerException {
		Marker result = markersService.getMarker(markerDbId);

		MarkerResponse response = new MarkerResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<MarkerResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<MarkersResponse> markersSearchGet(@Valid ArrayList<String> markerDbIds, @Valid String name,
			@Valid String matchMethod, @Valid Boolean includeSynonyms, @Valid String type, @Valid Integer page,
			@Valid Integer pageSize) throws BrAPIServerException {
		
		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<Marker> data = markersService.getMarkers(name, type, markerDbIds, MatchMethodEnum.fromValue(matchMethod), includeSynonyms,
				metaData);
		
		MarkersResponseResult result = new MarkersResponseResult();
		result.setData(data);
		MarkersResponse response = new MarkersResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<MarkersResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<MarkersResponse> markersSearchPost(@Valid @RequestBody MarkersSearchRequest request) throws BrAPIServerException {

		Metadata metaData = generateMetaDataTemplate(request.getPage(), request.getPageSize());
		List<Marker> data = markersService.getMarkers(request.getName(), request.getType(), request.getMarkerDbIds(),
				request.getMatchMethod(), request.isIncludeSynonyms(), metaData);
		
		MarkersResponseResult result = new MarkersResponseResult();
		result.setData(data);
		MarkersResponse response = new MarkersResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<MarkersResponse>(response, HttpStatus.OK);
	}
}
