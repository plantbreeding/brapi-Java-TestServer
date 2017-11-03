package org.brapi.test.BrAPITestServer.controller;

import org.brapi.test.BrAPITestServer.model.AlleleMatrixSearchRequest;
import org.brapi.test.BrAPITestServer.model.MarkerprofileDetails;
import org.brapi.test.BrAPITestServer.model.MarkerprofileSummary;

import java.util.List;
import org.brapi.test.BrAPITestServer.model.metadata.SearchResults;
import org.brapi.test.BrAPITestServer.model.metadata.SearchResultsList;
import org.brapi.test.BrAPITestServer.service.MarkerprofileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarkerprofileController extends BrAPIController {
	private MarkerprofileService markerprofileService;

	@Autowired
	public MarkerprofileController(MarkerprofileService markerprofileService) {
		this.markerprofileService = markerprofileService;
	}

	@RequestMapping(value = "markerprofiles", method = { RequestMethod.GET })
	public SearchResults<SearchResultsList<MarkerprofileSummary>> getMarkerprofiles(
			@RequestParam String germplasmDbId,
			@RequestParam String studyDbId, 
			@RequestParam String sampleDbId, 
			@RequestParam String extractDbId,
			@RequestParam String methodDbId, 
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		List<MarkerprofileSummary> markerprofileSummaries = markerprofileService.getMarkerprofileSummeries(
				germplasmDbId, studyDbId, sampleDbId, extractDbId, methodDbId, page, pageSize);

		return SearchResults.withList(markerprofileSummaries).withMetaData(mockMetaData(page, pageSize));
	}

	@RequestMapping(value = "markerprofiles/{markerprofileDbId}", method = { RequestMethod.GET })
	public SearchResults<MarkerprofileDetails> getMarkerprofile(
			@PathVariable(value="markerprofileDbId") String markerprofileDbId,
			@RequestParam(defaultValue="false") boolean expandHomozygotes,
			@RequestParam(defaultValue="-") String unknownString,
			@RequestParam(defaultValue="|") String sepPhased,
			@RequestParam(defaultValue="/") String sepUnphased,
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "1") int page) {
		MarkerprofileDetails details = markerprofileService.getMarkerprofileDetails(markerprofileDbId, expandHomozygotes, unknownString, sepPhased, sepUnphased, page, pageSize);
		
		return SearchResults.withObject(details).withMetaData(mockMetaData(page, pageSize));
	}

	@RequestMapping(value = "allelematrix-search", method = { RequestMethod.GET })
	public SearchResults<SearchResultsList<List<String>>> getAlleleMatrix(
			@RequestParam(defaultValue="false") String format,
			@RequestParam(defaultValue="false") boolean expandHomozygotes,
			@RequestParam(defaultValue="-") String unknownString,
			@RequestParam(defaultValue="|") String sepPhased,
			@RequestParam(defaultValue="/") String sepUnphased,
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		List<List<String>> alleleMatrix = markerprofileService.getAlleleMatrix(format, expandHomozygotes, unknownString, sepPhased, sepUnphased, page, pageSize);
		
		return SearchResults.withList(alleleMatrix).withMetaData(mockMetaData(page, pageSize));
	}

	@RequestMapping(value = "allelematrix-search", method = { RequestMethod.POST })
	public SearchResults<SearchResultsList<List<String>>> getAlleleMatrix(
			@RequestBody AlleleMatrixSearchRequest request) {
		List<List<String>> alleleMatrix = markerprofileService.getAlleleMatrix(request);
		
		return SearchResults.withList(alleleMatrix).withMetaData(mockMetaData(request.getPage(), request.getPageSize()));
	}
}
