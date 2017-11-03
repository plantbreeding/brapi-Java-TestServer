package org.brapi.test.BrAPITestServer.controller;

import org.brapi.test.BrAPITestServer.model.Sample;
import org.brapi.test.BrAPITestServer.model.SampleDbIdWrapper;
import org.brapi.test.BrAPITestServer.model.SampleDetail;
import org.brapi.test.BrAPITestServer.model.metadata.SearchResults;
import org.brapi.test.BrAPITestServer.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController  extends BrAPIController{

	private SampleService sampleService;
	
	@Autowired
	public SampleController(SampleService sampleService) {
		this.sampleService = sampleService;
	}
	
	@RequestMapping(value="samples", method= {RequestMethod.PUT})
	public SearchResults<SampleDbIdWrapper> putSample(
			@RequestBody Sample sample){
		SampleDbIdWrapper id = sampleService.saveSample(sample);
		return SearchResults.withObject(id).withMetaData(null);
	}
	
	@RequestMapping(value="samples/{sampleId}", method= {RequestMethod.GET})
	public SearchResults<SampleDetail> getSample(
			@PathVariable(value="sampleId") String sampleId){
		SampleDetail sample = sampleService.getSample(sampleId);
		return SearchResults.withObject(sample).withMetaData(mockEmptyMetadata());
	}
}
