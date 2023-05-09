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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ReferencesApiController(ReferenceService referenceService, SearchService searchService,
			HttpServletRequest request) {
		this.referenceService = referenceService;
		this.searchService = searchService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ReferencesListResponse> referencesGet(
			@RequestParam(value = "referenceDbId", required = false) String referenceDbId,
			@RequestParam(value = "referenceSetDbId", required = false) String referenceSetDbId,
			@RequestParam(value = "accession", required = false) String accession,
			@RequestParam(value = "md5checksum", required = false) String md5checksum,
			@RequestParam(value = "isDerived", required = false) Boolean isDerived,
			@RequestParam(value = "minLength", required = false) Integer minLength,
			@RequestParam(value = "maxLength", required = false) Integer maxLength,
			@RequestParam(value = "trialDbId", required = false) String trialDbId,
			@RequestParam(value = "studyDbId", required = false) String studyDbId,
			@RequestParam(value = "commonCropName", required = false) String commonCropName,
			@RequestParam(value = "programDbId", required = false) String programDbId,
			@RequestParam(value = "externalReferenceId", required = false) String externalReferenceId,
			@RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<Reference> data = referenceService.findReferences(referenceDbId, referenceSetDbId, accession, md5checksum,
				isDerived, minLength, maxLength, trialDbId, studyDbId, commonCropName, programDbId, externalReferenceId,
				externalReferenceSource, metadata);
		return responseOK(new ReferencesListResponse(), new ReferencesListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ReferenceBasesResponse> referencesReferenceDbIdBasesGet(
			@PathVariable("referenceDbId") String referenceDbId,
			@RequestParam(value = "start", required = false) Integer start,
			@RequestParam(value = "end", required = false) Integer end,
			@RequestParam(value = "pageToken", required = false) String pageToken,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
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
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Reference data = referenceService.getReference(referenceDbId);
		return responseOK(new ReferenceSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchReferencesPost(@RequestBody ReferencesSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
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
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		SearchRequestEntity request = searchService.findById(searchResultsDbId);
		if (request != null) {
			ReferencesSearchRequest body = request.getParameters(ReferencesSearchRequest.class);
			List<Reference> data = referenceService.findReferences(body, metadata);
			return responseOK(new ReferencesListResponse(), new ReferencesListResponseResult(), data, metadata);
		} else {
			return responseAccepted(searchResultsDbId);
		}
	}

}
