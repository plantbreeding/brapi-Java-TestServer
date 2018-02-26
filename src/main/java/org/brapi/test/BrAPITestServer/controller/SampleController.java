package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.rest.Sample;
import org.brapi.test.BrAPITestServer.model.rest.SampleDbIdWrapper;
import org.brapi.test.BrAPITestServer.model.rest.SampleSearchRequest;
import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResults;
import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResultsDataList;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.brapi.test.BrAPITestServer.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController extends BrAPIController {

	private SampleService sampleService;

	@Autowired
	public SampleController(SampleService sampleService) {
		this.sampleService = sampleService;
	}

	@CrossOrigin
	@RequestMapping(path="brapi/v1/samples", method = { RequestMethod.PUT })
	@PreAuthorize("hasAuthority('ADMIN')")
	public GenericResults<SampleDbIdWrapper> putSample(@RequestBody Sample sample) {
		SampleDbIdWrapper id = sampleService.saveSample(sample);
		return GenericResults.withObject(id).withMetaData(null);
	}

	@CrossOrigin
	@RequestMapping(path="brapi/v1/samples/{sampleId}", method = { RequestMethod.GET })
	public GenericResults<Sample> getSample(@PathVariable(value = "sampleId") String sampleId) {
		Sample sample = sampleService.getSample(sampleId);
		return GenericResults.withObject(sample).withMetaData(generateEmptyMetadata());
	}

	@CrossOrigin
	@RequestMapping(path="brapi/v1/samples-search", method = { RequestMethod.GET })
	public GenericResults<GenericResultsDataList<Sample>> getSampleSearch(
			@RequestParam(required = false) String sampleDbId,
			@RequestParam(required = false) String observationUnitDbId,
			@RequestParam(required = false) String plateDbId, @RequestParam(required = false) String germplasmDbId,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "1000") int pageSize) {

		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		List<Sample> samples = sampleService.getSampleSearch(sampleDbId, observationUnitDbId, plateDbId, germplasmDbId,
				metaData);

		return GenericResults.withList(samples).withMetaData(metaData);
	}

	@CrossOrigin
	@RequestMapping(path="brapi/v1/samples-search", method = { RequestMethod.POST })
	public GenericResults<GenericResultsDataList<Sample>> postSampleSearch(@RequestBody SampleSearchRequest request) {

		MetaData metaData = generateMetaDataTemplate(request);
		List<Sample> samples = sampleService.getSampleSearch(request, metaData);

		return GenericResults.withList(samples).withMetaData(metaData);
	}
}
