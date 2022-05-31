package org.brapi.test.BrAPITestServer.controller.geno;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.Metadata;
import io.swagger.model.geno.Reference;
import io.swagger.model.geno.ReferenceBases;
import io.swagger.model.geno.ReferencesListResponse;
import io.swagger.model.geno.ReferencesListResponseResult;
import io.swagger.model.geno.ReferenceBasesResponse;
import io.swagger.model.geno.ReferenceSingleResponse;
import io.swagger.model.geno.ReferencesSearchRequest;
import io.swagger.model.germ.Germplasm;
import io.swagger.model.germ.GermplasmListResponse;
import io.swagger.model.germ.GermplasmListResponseResult;
import io.swagger.model.germ.GermplasmSearchRequest;
import io.swagger.api.geno.ReferencesApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity.SearchRequestTypes;
import org.brapi.test.BrAPITestServer.service.SearchService;
import org.brapi.test.BrAPITestServer.service.geno.ReferenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
@Controller
public class ReferencesApiController extends BrAPIController implements ReferencesApi {

	private static final Logger log = LoggerFactory.getLogger(ReferencesApiController.class);

	private final ReferenceService referenceService;
	private final SearchService searchService;
	private final HttpServletRequest request;

	@Autowired
	public ReferencesApiController(ReferenceService referenceService, SearchService searchService, HttpServletRequest request) {
		this.referenceService = referenceService;
		this.searchService = searchService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ReferencesListResponse> referencesGet(
			@Valid @RequestParam(value = "referenceDbId", required = false) String referenceDbId,
			@Valid @RequestParam(value = "referenceSetDbId", required = false) String referenceSetDbId,
			@Valid @RequestParam(value = "accession", required = false) String accession,
			@Valid @RequestParam(value = "md5checksum", required = false) String md5checksum,
			@Valid @RequestParam(value = "isDerived", required = false) Boolean isDerived,
			@Valid @RequestParam(value = "minLength", required = false) Integer minLength,
			@Valid @RequestParam(value = "maxLength", required = false) Integer maxLength,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<Reference> data = referenceService.findReferences(referenceDbId, referenceSetDbId, accession, md5checksum,
				isDerived, minLength, maxLength, metadata);
		return responseOK(new ReferencesListResponse(), new ReferencesListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ReferenceBasesResponse> referencesReferenceDbIdBasesGet(
			@PathVariable("referenceDbId") String referenceDbId,
			@Valid @RequestParam(value = "start", required = false) Integer start,
			@Valid @RequestParam(value = "end", required = false) Integer end,
			@Valid @RequestParam(value = "pageToken", required = false) String pageToken,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		ReferenceBases data = referenceService.getReferenceBases(referenceDbId, start, end, pageToken);
		return responseOK(new ReferenceBasesResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ReferenceSingleResponse> referencesReferenceDbIdGet(
			@PathVariable("referenceDbId") String referenceDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Reference data = referenceService.getReference(referenceDbId);
		return responseOK(new ReferenceSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchReferencesPost(@Valid @RequestBody ReferencesSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body);

		String searchReqDbId = searchService.saveSearchRequest(body, SearchRequestTypes.GERMPLASM);
		if (searchReqDbId != null) {
			return responseAccepted(searchReqDbId);
		} else {
			List<Reference> data = referenceService.findReferences(body, metadata);
			return responseOK(new ReferencesListResponse(), new ReferencesListResponseResult(), data, metadata);
		}
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchReferencesSearchResultsDbIdGet(
			@PathVariable("searchResultsDbId") String searchResultsDbId,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		SearchRequestEntity request = searchService.findById(searchResultsDbId);
		if (request != null) {
			ReferencesSearchRequest body = request.getParameters(ReferencesSearchRequest.class);
			List<Reference> data = referenceService.findReferences(body, metadata);
			return responseOK(new ReferencesListResponse(), new ReferencesListResponseResult(), data, metadata);
		}else {
			return responseAccepted(searchResultsDbId);
		}
	}

}
