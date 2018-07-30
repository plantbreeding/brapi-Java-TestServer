package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.TraitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.api.TraitsApi;
import io.swagger.model.Metadata;
import io.swagger.model.TraitResponse;
import io.swagger.model.TraitSummary;
import io.swagger.model.TraitsResponse;
import io.swagger.model.TraitsResponseResult;

@RestController
public class TraitController extends BrAPIController implements TraitsApi {

	private TraitService traitService;

	public TraitController(TraitService traitService) {
		this.traitService = traitService;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<TraitsResponse> traitsGet(@Valid Integer pageSize, @Valid Integer page)
			throws BrAPIServerException {

		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<TraitSummary> data = traitService.getTraits(metaData);

		TraitsResponseResult result = new TraitsResponseResult();
		result.setData(data);
		TraitsResponse response = new TraitsResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		return new ResponseEntity<TraitsResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<TraitResponse> traitsTraitDbIdGet(@PathVariable("traitDbId") String traitDbId) {

		TraitSummary result = traitService.getTrait(traitDbId);

		TraitResponse response = new TraitResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<TraitResponse>(response, HttpStatus.OK);
	}
}
