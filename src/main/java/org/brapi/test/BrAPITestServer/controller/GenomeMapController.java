package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.GenomeMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.api.MapsApi;
import io.swagger.model.GenomeMap;
import io.swagger.model.GenomeMapDetails;
import io.swagger.model.GenomeMapsResponse;
import io.swagger.model.GenomeMapsResponseResult;
import io.swagger.model.MapDetailsResponse;
import io.swagger.model.MarkerSummaryLinkageGroup;
import io.swagger.model.MarkerSummaryLinkageGroupResponse;
import io.swagger.model.MarkerSummaryLinkageGroupResponseResult;
import io.swagger.model.MarkerSummaryMap;
import io.swagger.model.MarkerSummaryMapResponse;
import io.swagger.model.MarkerSummaryMapResponseResult;
import io.swagger.model.Metadata;

@RestController
public class GenomeMapController extends BrAPIController implements MapsApi {
	private GenomeMapService genomeMapService;

	@Autowired
	public GenomeMapController(GenomeMapService genomeMapService) {
		this.genomeMapService = genomeMapService;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GenomeMapsResponse> mapsGet(@Valid String species, @Valid String commonCropName,
			@Valid String scientificName, @Valid String type, @Valid Integer page, @Valid Integer pageSize,
			String authorization) throws BrAPIServerException {

		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<GenomeMap> data = genomeMapService.getMapSummaries(species, commonCropName, scientificName, type, metaData);

		GenomeMapsResponseResult result = new GenomeMapsResponseResult();
		result.setData(data);
		GenomeMapsResponse response = new GenomeMapsResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<GenomeMapsResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<MapDetailsResponse> mapsMapDbIdGet(@PathVariable("mapDbId") String mapDbId, @Valid Integer page,
			@Valid Integer pageSize, String authorization) throws BrAPIServerException {
		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		GenomeMapDetails result = genomeMapService.getMapDetail(metaData, mapDbId);

		MapDetailsResponse response = new MapDetailsResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<MapDetailsResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<MarkerSummaryMapResponse> mapsMapDbIdPositionsGet(@PathVariable("mapDbId") String mapDbId, @Valid String linkageGroupId,
			@Valid String linkageGroupName, @Valid Integer page, @Valid Integer pageSize, String authorization)
			throws BrAPIServerException {
		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		String linkageGroup = linkageGroupName == null ? linkageGroupId : linkageGroupName;
		List<MarkerSummaryMap> data = genomeMapService.getMapPositions(mapDbId, linkageGroup, metaData);

		MarkerSummaryMapResponseResult result = new MarkerSummaryMapResponseResult();
		result.setData(data);
		MarkerSummaryMapResponse response = new MarkerSummaryMapResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<MarkerSummaryMapResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<MarkerSummaryLinkageGroupResponse> mapsMapDbIdPositionsLinkageGroupNameGet(@PathVariable("mapDbId") String mapDbId,
			String linkageGroupName, @Valid Integer min, @Valid Integer max, @Valid Integer page,
			@Valid Integer pageSize, String authorization) throws BrAPIServerException {

		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<MarkerSummaryLinkageGroup> data = genomeMapService.getMapPositions(mapDbId, linkageGroupName, min, max,
				metaData);

		MarkerSummaryLinkageGroupResponseResult result = new MarkerSummaryLinkageGroupResponseResult();
		result.setData(data);
		MarkerSummaryLinkageGroupResponse response = new MarkerSummaryLinkageGroupResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<MarkerSummaryLinkageGroupResponse>(response, HttpStatus.OK);
	}
}
