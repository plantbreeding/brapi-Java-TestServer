package org.brapi.test.BrAPITestServer.controller.pheno;

import io.swagger.model.Metadata;
import io.swagger.model.pheno.Trait;
import io.swagger.model.pheno.TraitListResponse;
import io.swagger.model.pheno.TraitListResponseResult;
import io.swagger.model.pheno.TraitSingleResponse;
import io.swagger.model.pheno.TraitBaseClass;
import io.swagger.api.pheno.TraitsApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.pheno.TraitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
@Controller
public class TraitsApiController extends BrAPIController implements TraitsApi {

	private static final Logger log = LoggerFactory.getLogger(TraitsApiController.class);

	private final TraitService traitService;

	private final HttpServletRequest request;

	@Autowired
	public TraitsApiController(TraitService traitService, HttpServletRequest request) {
		this.traitService = traitService;
		this.request = request;
	}

	public ResponseEntity<TraitListResponse> traitsGet(
			@Valid @RequestParam(value = "traitDbId", required = false) String traitDbId,
			@Valid @RequestParam(value = "observationVariableDbId", required = false) String observationVariableDbId,
			@Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<Trait> data = traitService.findTraits(traitDbId, observationVariableDbId, externalReferenceID,
				externalReferenceSource, metadata);
		return responseOK(new TraitListResponse(), new TraitListResponseResult(), data, metadata);
	}

	public ResponseEntity<TraitListResponse> traitsPost(@Valid @RequestBody List<TraitBaseClass> body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		List<Trait> data = traitService.saveTraits(body);
		return responseOK(new TraitListResponse(), new TraitListResponseResult(), data);
	}

	public ResponseEntity<TraitSingleResponse> traitsTraitDbIdGet(@PathVariable("traitDbId") String traitDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Trait data = traitService.getTrait(traitDbId);
		return responseOK(new TraitSingleResponse(), data);
	}

	public ResponseEntity<TraitSingleResponse> traitsTraitDbIdPut(@PathVariable("traitDbId") String traitDbId,
			@Valid @RequestBody TraitBaseClass body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Trait data = traitService.updateTrait(traitDbId, body);
		return responseOK(new TraitSingleResponse(), data);
	}

}
