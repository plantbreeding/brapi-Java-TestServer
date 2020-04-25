package org.brapi.test.BrAPITestServer.controller.geno;

import io.swagger.model.Metadata;
import io.swagger.model.geno.ReferenceSet;
import io.swagger.model.geno.ReferenceSetsListResponse;
import io.swagger.model.geno.ReferenceSetsListResponseResult;
import io.swagger.model.geno.ReferenceSetsSearchRequest;
import io.swagger.model.geno.ReferenceSetsSingleResponse;

import io.swagger.api.geno.ReferencesetsApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.geno.ReferenceSetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
@Controller
public class ReferenceSetsApiController extends BrAPIController implements ReferencesetsApi {

	private static final Logger log = LoggerFactory.getLogger(ReferenceSetsApiController.class);

	private final ReferenceSetService referenceSetService;

	private final HttpServletRequest request;

	@Autowired
	public ReferenceSetsApiController(ReferenceSetService referenceSetService, HttpServletRequest request) {
		this.referenceSetService = referenceSetService;
		this.request = request;
	}

	public ResponseEntity<ReferenceSetsListResponse> referenceSetsGet(
			@Valid @RequestParam(value = "referenceSetDbId", required = false) String referenceSetDbId,
			@Valid @RequestParam(value = "accession", required = false) String accession,
			@Valid @RequestParam(value = "assemblyPUI", required = false) String assemblyPUI,
			@Valid @RequestParam(value = "md5checksum", required = false) String md5checksum,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<ReferenceSet> data = referenceSetService.findReferenceSets(referenceSetDbId, accession, assemblyPUI,
				md5checksum, metadata);
		return responseOK(new ReferenceSetsListResponse(), new ReferenceSetsListResponseResult(), data, metadata);
	}

	public ResponseEntity<ReferenceSetsSingleResponse> referenceSetsReferenceSetDbIdGet(
			@PathVariable("referenceSetDbId") String referenceSetDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		ReferenceSet data = referenceSetService.getReferenceSet(referenceSetDbId);
		return responseOK(new ReferenceSetsSingleResponse(), data);
	}

	public ResponseEntity<ReferenceSetsListResponse> searchReferenceSetsPost(
			@Valid @RequestBody ReferenceSetsSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body);
		List<ReferenceSet> data = referenceSetService.findReferenceSets(body, metadata);
		return responseOK(new ReferenceSetsListResponse(), new ReferenceSetsListResponseResult(), data, metadata);
	}

	public ResponseEntity<ReferenceSetsListResponse> searchReferenceSetsSearchResultsDbIdGet(
			@PathVariable("searchResultsDbId") String searchResultsDbId,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		return new ResponseEntity<ReferenceSetsListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

}
