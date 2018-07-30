package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.api.SamplesApi;
import io.swagger.api.SamplesSearchApi;
import io.swagger.model.Metadata;
import io.swagger.model.NewSampleDbId;
import io.swagger.model.NewSampleDbIdResult;
import io.swagger.model.Sample;
import io.swagger.model.SampleResponse;
import io.swagger.model.SampleSearchRequest;
import io.swagger.model.SamplesResponse;
import io.swagger.model.SamplesResponseResult;

@RestController
public class SampleController extends BrAPIController implements SamplesApi, SamplesSearchApi {

	private SampleService sampleService;

	@Autowired
	public SampleController(SampleService sampleService) {
		this.sampleService = sampleService;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<SamplesResponse> samplesSearchGet(@Valid String sampleDbId, @Valid String observationUnitDbId,
			@Valid String plateDbId, @Valid String germplasmDbId, @Valid Integer pageSize, @Valid Integer page)
			throws BrAPIServerException {

		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<Sample> data = sampleService.getSampleSearch(sampleDbId, observationUnitDbId, plateDbId, germplasmDbId,
				metaData);

		SamplesResponseResult result = new SamplesResponseResult();
		result.setData(data);
		SamplesResponse response = new SamplesResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<SamplesResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<SamplesResponse> samplesSearchPost(@Valid SampleSearchRequest request)
			throws BrAPIServerException {

		Metadata metaData = generateMetaDataTemplate(request.getPage(), request.getPageSize());
		List<Sample> data = sampleService.getSampleSearch(request, metaData);

		SamplesResponseResult result = new SamplesResponseResult();
		result.setData(data);
		SamplesResponse response = new SamplesResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<SamplesResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@PreAuthorize("hasAuthority('ADMIN')")
	@Override
	public ResponseEntity<NewSampleDbId> samplesPut(@Valid Sample sample) {
		NewSampleDbIdResult result = sampleService.saveSample(sample);

		NewSampleDbId response = new NewSampleDbId();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<NewSampleDbId>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<SampleResponse> samplesSampleDbIdGet(@PathVariable("sampleDbId") String sampleDbId) {
		Sample result = sampleService.getSample(sampleDbId);

		SampleResponse response = new SampleResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<SampleResponse>(response, HttpStatus.OK);
	}
}
