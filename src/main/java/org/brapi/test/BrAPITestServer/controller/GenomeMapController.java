package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.service.GenomeMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.api.MapsApi;
import io.swagger.model.GenomeMap;
import io.swagger.model.GenomeMapsResponse;
import io.swagger.model.GenomeMapsResponseResult;
import io.swagger.model.MapDetails;
import io.swagger.model.MapDetailsResponse;
import io.swagger.model.MarkerSummaryLinkageGroup;
import io.swagger.model.MarkerSummaryMap;
import io.swagger.model.MarkersResponse;
import io.swagger.model.MarkersResponse1;
import io.swagger.model.MarkersResponse1Result;
import io.swagger.model.MarkersResponseResult;
import io.swagger.model.Metadata;

@RestController
public class GenomeMapController  extends BrAPIController implements MapsApi{
	private GenomeMapService genomeMapService;
	
	@Autowired
	public GenomeMapController(GenomeMapService genomeMapService) {
		this.genomeMapService = genomeMapService;
	}
	
	@CrossOrigin
	@Override
	public ResponseEntity<GenomeMapsResponse> mapsGet(@Valid String species, @Valid String type,
			@Valid Integer pageSize, @Valid Integer page) {
		
		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<GenomeMap> data = genomeMapService.getMapSummaries(species, type, metaData);

		GenomeMapsResponseResult result = new GenomeMapsResponseResult();
		result.setData(data);
		GenomeMapsResponse response = new GenomeMapsResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<GenomeMapsResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<MapDetailsResponse> mapsMapDbIdGet(String mapDbId, @Valid Integer pageSize,
			@Valid Integer page) {
		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		MapDetails result = genomeMapService.getMapDetail(metaData, mapDbId);

		MapDetailsResponse response = new MapDetailsResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<MapDetailsResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<MarkersResponse> mapsMapDbIdPositionsGet(String mapDbId, @Valid String linkageGroupId,
			@Valid String linkageGroupName, @Valid Integer pageSize, @Valid Integer page) {

		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		String linkageGroup = linkageGroupName == null ? linkageGroupId : linkageGroupName;
		List<MarkerSummaryMap> data = genomeMapService.getMapPositions(mapDbId, linkageGroup, metaData);
		
		MarkersResponseResult result = new MarkersResponseResult();
		result.setData(data);
		MarkersResponse response = new MarkersResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<MarkersResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<MarkersResponse1> mapsMapDbIdPositionsLinkageGroupNameGet(String mapDbId,
			String linkageGroupName, @Valid Integer min, @Valid Integer max, @Valid Integer pageSize,
			@Valid Integer page) {

		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<MarkerSummaryLinkageGroup> data = genomeMapService.getMapPositions(mapDbId, linkageGroupName, min, max, metaData);

		MarkersResponse1Result result = new MarkersResponse1Result();
		result.setData(data);
		MarkersResponse1 response = new MarkersResponse1();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<MarkersResponse1>(response, HttpStatus.OK);
	}
}
