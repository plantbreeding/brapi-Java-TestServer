package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.rest.GenomeMapData;
import org.brapi.test.BrAPITestServer.model.rest.GenomeMapDetail;
import org.brapi.test.BrAPITestServer.model.rest.GenomeMapSummary;
import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResults;
import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResultsDataList;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.brapi.test.BrAPITestServer.service.GenomeMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	public GenericResults<GenericResultsDataList<GenomeMapSummary>> getMaps(
			@RequestParam(required=false) String speciesId,
			@RequestParam(required=false) String type,
			@RequestParam(defaultValue="0") int page,
			@RequestParam(defaultValue="1000") int pageSize){
		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		List<GenomeMapSummary> summaries = genomeMapService.getMapSummaries(speciesId, type, metaData);

		return GenericResults
				.withList(summaries)
				.withMetaData(generateMetaDataTemplate(page, pageSize));
	}
	
	@RequestMapping(value="maps/{mapDbId}", method= {RequestMethod.GET})
	public GenericResults<GenomeMapDetail> getMapDetail(
			@PathVariable(value = "mapDbId") String mapDbId,
			@RequestParam(defaultValue="0") int page,
			@RequestParam(defaultValue="1000") int pageSize){
		
		GenomeMapDetail detail = genomeMapService.getMapDetail(mapDbId);
		
		return GenericResults
				.withObject(detail)
				.withMetaData(generateEmptyMetadata());
	}

	@RequestMapping(value="maps/{mapDbId}/positions", method= {RequestMethod.GET})
	public GenericResults<GenericResultsDataList<GenomeMapData>> getMapData(
			@PathVariable(value= "mapDbId") String mapDbId,
			@RequestParam(required=false) String linkageGroupId,
			@RequestParam(required=false) String linkageGroupName,
			@RequestParam(value="min", defaultValue="0") int minPosition,
			@RequestParam(value="max", defaultValue="0") int maxPosition,
			@RequestParam(defaultValue="0") int page,
			@RequestParam(defaultValue="1000") int pageSize){

		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		String linkageGroup = linkageGroupName == null ? linkageGroupId : linkageGroupName;
		List<GenomeMapData> genomeData = genomeMapService.getMapPositions(mapDbId, linkageGroup, minPosition, maxPosition, metaData);
		
		return GenericResults
				.withList(genomeData)
				.withMetaData(generateMetaDataTemplate(page, pageSize));
	}


	@RequestMapping(value="maps/{mapDbId}/positions/{linkageGroupName}", method= {RequestMethod.GET})
	public GenericResults<GenericResultsDataList<GenomeMapData>> getMapDataLinkageGroup(
			@PathVariable(value= "mapDbId") String mapDbId,
			@PathVariable(value= "linkageGroupName") String linkageGroupName,
			@RequestParam(value="min", defaultValue="0") int minPosition,
			@RequestParam(value="max", defaultValue="0") int maxPosition,
			@RequestParam(defaultValue="0") int page,
			@RequestParam(defaultValue="1000") int pageSize){

		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		List<GenomeMapData> genomeData = genomeMapService.getMapPositions(mapDbId, linkageGroupName, minPosition, maxPosition, metaData);
		
		return GenericResults
				.withList(genomeData)
				.withMetaData(generateMetaDataTemplate(page, pageSize));
	}
	
	
}
