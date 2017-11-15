package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.rest.TrialSummary;
import org.brapi.test.BrAPITestServer.model.rest.TrialSummaryWithContact;
import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResults;
import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResultsDataList;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
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
	public GenericResults<GenericResultsDataList<TrialSummary>> getTrialSummaries(
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		List<TrialSummary> summaries = trialService.getTrialSummaries(metaData);
		
		return GenericResults.withList(summaries).withMetaData(metaData);
	}
	
	@RequestMapping(value="trials/{trialDbId}", method= {RequestMethod.GET})
	public GenericResults<TrialSummaryWithContact> getTrialSummary(
			@PathVariable(value="trialDbId") String trialDbId){
		TrialSummaryWithContact trial = trialService.getTrialSummary(trialDbId);
		return GenericResults.withObject(trial).withMetaData(generateEmptyMetadata());
	}
}
