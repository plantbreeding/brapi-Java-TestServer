package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.brapi.test.BrAPITestServer.model.GenomeMapData;
import org.brapi.test.BrAPITestServer.model.GenomeMapDetail;
import org.brapi.test.BrAPITestServer.model.GenomeMapSummary;
import org.brapi.test.BrAPITestServer.model.metadata.SearchResults;
import org.brapi.test.BrAPITestServer.model.metadata.SearchResultsList;
import org.brapi.test.BrAPITestServer.service.GenomeMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenomeMapController  extends BrAPIController{
	private GenomeMapService genomeMapService;
	
	@Autowired
	public GenomeMapController(GenomeMapService genomeMapService) {
		this.genomeMapService = genomeMapService;
	}
	
	@RequestMapping(value="maps", method= {RequestMethod.GET})
	public SearchResults<SearchResultsList<GenomeMapSummary>> getMaps(
			@RequestParam String speciesId,
			@RequestParam String type,
			@RequestParam(defaultValue="0") int page,
			@RequestParam(defaultValue="1000") int pageSize){
		List<GenomeMapSummary> summaries = genomeMapService.getMapSummaries(speciesId, type, page, pageSize);

		return SearchResults
				.withList(summaries)
				.withMetaData(mockMetaData(page, pageSize));
	}
	
	@RequestMapping(value="map/{mapDbId}", method= {RequestMethod.GET})
	public SearchResults<GenomeMapDetail> getMapDetail(
			@PathParam(value = "mapDbId") String mapDbId){
		GenomeMapDetail detail = genomeMapService.getMapDetail(mapDbId);
		
		return SearchResults
				.withObject(detail)
				.withMetaData(mockEmptyMetadata());
	}

	@RequestMapping(value="map/{mapDbId}/positions", method= {RequestMethod.GET})
	public SearchResults<SearchResultsList<GenomeMapData>> getMapData(
			@PathParam(value= "mapDbID") String mapDbId,
			@RequestParam String linkageGroupId,
			@RequestParam(value="min", defaultValue="0") int minPosition,
			@RequestParam(value="max", defaultValue="0") int maxPosition,
			@RequestParam(defaultValue="0") int page,
			@RequestParam(defaultValue="1000") int pageSize){
		List<GenomeMapData> genomeData = genomeMapService.getMapPositions(mapDbId, linkageGroupId, minPosition, maxPosition, page, pageSize);
		
		return SearchResults
				.withList(genomeData)
				.withMetaData(mockMetaData(page, pageSize));
	}
	
	
}
