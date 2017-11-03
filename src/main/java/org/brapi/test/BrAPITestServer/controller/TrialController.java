package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.TrialSummary;
import org.brapi.test.BrAPITestServer.model.TrialSummaryWithContact;
import org.brapi.test.BrAPITestServer.model.metadata.SearchResults;
import org.brapi.test.BrAPITestServer.model.metadata.SearchResultsList;
import org.brapi.test.BrAPITestServer.service.TrialService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrialController  extends BrAPIController{

	private TrialService trialService;
	
	public TrialController(TrialService trialService) {
		this.trialService = trialService;
	}
	

	@RequestMapping(value="trials", method= {RequestMethod.GET})
	public SearchResults<SearchResultsList<TrialSummary>> getTrialSummaries(
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		List<TrialSummary> summaries = trialService.getTrialSummaries(page, pageSize);
		
		return SearchResults.withList(summaries).withMetaData(mockMetaData(page, pageSize));
	}
	
	@RequestMapping(value="trials/{trialDbId}", method= {RequestMethod.GET})
	public SearchResults<TrialSummaryWithContact> getTrialSummary(
			@PathVariable(value="trialDbId") String trialDbId){
		TrialSummaryWithContact trial = trialService.getTrialSummary(trialDbId);
		return SearchResults.withObject(trial).withMetaData(mockEmptyMetadata());
	}
}
