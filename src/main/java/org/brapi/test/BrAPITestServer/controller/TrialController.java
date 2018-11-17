package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.TrialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.api.TrialsApi;
import io.swagger.model.Metadata;
import io.swagger.model.Trial;
import io.swagger.model.TrialResponse;
import io.swagger.model.TrialSummary;
import io.swagger.model.TrialsResponse;
import io.swagger.model.TrialsResponseResult;

@RestController
public class TrialController extends BrAPIController implements TrialsApi {

	private TrialService trialService;

	public TrialController(TrialService trialService) {
		this.trialService = trialService;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<TrialsResponse> trialsGet(@Valid String commonCropName, @Valid String programDbId,
			@Valid String locationDbId, @Valid Boolean active, @Valid String sortBy, @Valid String sortOrder,
			@Valid Integer page, @Valid Integer pageSize, String authorization) throws BrAPIServerException {
		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<TrialSummary> data = trialService.getTrialSummaries(programDbId, locationDbId, active, sortBy, sortOrder,
				metaData);

		TrialsResponseResult result = new TrialsResponseResult();
		result.setData(data);
		TrialsResponse response = new TrialsResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<TrialsResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<TrialResponse> trialsTrialDbIdGet(@PathVariable("trialDbId") String trialDbId, String authorization)
			throws BrAPIServerException {

		Trial result = trialService.getTrialSummary(trialDbId);

		TrialResponse response = new TrialResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<TrialResponse>(response, HttpStatus.OK);
	}
}
