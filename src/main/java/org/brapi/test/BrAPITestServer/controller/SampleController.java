package org.brapi.test.BrAPITestServer.controller;

import org.brapi.test.BrAPITestServer.model.rest.Sample;
import org.brapi.test.BrAPITestServer.model.rest.SampleDbIdWrapper;
import org.brapi.test.BrAPITestServer.model.rest.SampleDetail;
import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResults;
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
	public GenericResults<SampleDbIdWrapper> putSample(
			@RequestBody Sample sample){
		SampleDbIdWrapper id = sampleService.saveSample(sample);
		return GenericResults.withObject(id).withMetaData(null);
	}
	
	@RequestMapping(value="samples/{sampleId}", method= {RequestMethod.GET})
	public GenericResults<SampleDetail> getSample(
			@PathVariable(value="sampleId") String sampleId){
		SampleDetail sample = sampleService.getSample(sampleId);
		return GenericResults.withObject(sample).withMetaData(generateEmptyMetadata());
	}
}
