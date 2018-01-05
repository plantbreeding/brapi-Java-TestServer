package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.rest.AlleleFormatParams;
import org.brapi.test.BrAPITestServer.model.rest.AlleleMatrixSearchRequest;
import org.brapi.test.BrAPITestServer.model.rest.MarkerProfileDetails;
import org.brapi.test.BrAPITestServer.model.rest.MarkerProfileSummary;
import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResults;
import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResultsDataList;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.brapi.test.BrAPITestServer.service.MarkerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarkerProfileController extends BrAPIController {
	private MarkerProfileService markerProfileService;

	@Autowired
	public MarkerProfileController(MarkerProfileService markerProfileService) {
		this.markerProfileService = markerProfileService;
	}

	@RequestMapping(value = "markerProfiles", method = { RequestMethod.GET })
	public GenericResults<GenericResultsDataList<MarkerProfileSummary>> getMarkerProfiles(
			@RequestParam(required=false) String germplasmDbId,
			@RequestParam(required=false) String studyDbId, 
			@RequestParam(required=false) String sampleDbId, 
			@RequestParam(required=false) String extractDbId,
			@RequestParam(value = "methodDbId", required=false) String analysisMethod, 
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		List<MarkerProfileSummary> markerProfileSummaries = markerProfileService.getMarkerProfileSummeries(
				germplasmDbId, studyDbId, sampleDbId, extractDbId, analysisMethod, metaData);

		return GenericResults.withList(markerProfileSummaries).withMetaData(metaData);
	}

	@RequestMapping(value = "markerProfiles/{markerProfileDbId}", method = { RequestMethod.GET })
	public GenericResults<MarkerProfileDetails> getMarkerProfile(
			@PathVariable(value="markerProfileDbId") String markerProfileDbId,
			@RequestParam(defaultValue="false") boolean expandHomozygotes,
			@RequestParam(defaultValue="-") String unknownString,
			@RequestParam(defaultValue="|") String sepPhased,
			@RequestParam(defaultValue="/") String sepUnphased,
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "1") int page) {
		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		AlleleFormatParams params = new AlleleFormatParams();
		params.setExpandHomozygotes(expandHomozygotes);
		params.setSepPhased(sepPhased);
		params.setSepUnphased(sepUnphased);
		params.setUnknownString(unknownString);
		MarkerProfileDetails details = markerProfileService.getMarkerProfileDetails(markerProfileDbId, params, metaData);
		
		return GenericResults.withObject(details).withMetaData(metaData);
	}

	@RequestMapping(value = "allelematrix-search", method = { RequestMethod.GET })
	public GenericResults<GenericResultsDataList<List<String>>> getAlleleMatrix(
			@RequestParam(defaultValue="csv") String format,
			@RequestParam(defaultValue="false") boolean expandHomozygotes,
			@RequestParam(defaultValue="-") String unknownString,
			@RequestParam(defaultValue="|") String sepPhased,
			@RequestParam(defaultValue="/") String sepUnphased,
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		AlleleFormatParams params = markerProfileService.buildFormatParams(expandHomozygotes, sepPhased, sepUnphased, unknownString);

		List<List<String>> alleleMatrix = markerProfileService.getAlleleMatrix(format, params, metaData);
		
		return GenericResults.withList(alleleMatrix).withMetaData(metaData);
	}

	@RequestMapping(value = "allelematrix-search", method = { RequestMethod.POST })
	public GenericResults<GenericResultsDataList<List<String>>> getAlleleMatrix(
			@RequestBody AlleleMatrixSearchRequest request) {
		MetaData metaData = generateMetaDataTemplate(request.getPage(), request.getPageSize());
		List<List<String>> alleleMatrix = markerProfileService.getAlleleMatrix(request, metaData);
		
		return GenericResults.withList(alleleMatrix).withMetaData(metaData);
	}
}
