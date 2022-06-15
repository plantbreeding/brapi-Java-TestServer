package org.brapi.test.BrAPITestServer.controller.germ;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity.SearchRequestTypes;
import org.brapi.test.BrAPITestServer.service.SearchService;
import org.brapi.test.BrAPITestServer.service.germ.PedigreeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import io.swagger.annotations.ApiParam;
import io.swagger.api.germ.PedigreeApi;
import io.swagger.model.BrAPIResponse;
import io.swagger.model.Metadata;
import io.swagger.model.germ.PedigreeListResponse;
import io.swagger.model.germ.PedigreeListResponseResult;
import io.swagger.model.germ.PedigreeNode;
import io.swagger.model.germ.PedigreeSearchRequest;
import jakarta.validation.Valid;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-06-03T22:50:47.807Z[GMT]")
@RestController
public class PedigreeApiController extends BrAPIController implements PedigreeApi {

	private static final Logger log = LoggerFactory.getLogger(PedigreeApiController.class);

	private final HttpServletRequest request;
	private final PedigreeService pedigreeService;
	private final SearchService searchService;

	@Autowired
	public PedigreeApiController(PedigreeService pedigreeService, SearchService searchService,
			HttpServletRequest request) {
		this.pedigreeService = pedigreeService;
		this.searchService = searchService;
		this.request = request;
	}

	@Override
	public ResponseEntity<PedigreeListResponse> pedigreeGet(
			@Valid @RequestParam(value = "germplasmPUI", required = false) String germplasmPUI,
			@Valid @RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,
			@Valid @RequestParam(value = "germplasmName", required = false) String germplasmName,
			@Valid @RequestParam(value = "accessionNumber", required = false) String accessionNumber,
			@Valid @RequestParam(value = "collection", required = false) String collection,
			@Valid @RequestParam(value = "familyCode", required = false) String familyCode,
			@Valid @RequestParam(value = "binomialName", required = false) String binomialName,
			@Valid @RequestParam(value = "genus", required = false) String genus,
			@Valid @RequestParam(value = "species", required = false) String species,
			@Valid @RequestParam(value = "trialDbId", required = false) String trialDbId,
			@Valid @RequestParam(value = "studyDbId", required = false) String studyDbId,
			@Valid @RequestParam(value = "synonym", required = false) String synonym,
			@Valid @RequestParam(value = "includeParents", required = false) Boolean includeParents,
			@Valid @RequestParam(value = "includeSiblings", required = false) Boolean includeSiblings,
			@Valid @RequestParam(value = "includeProgeny", required = false) Boolean includeProgeny,
			@Valid @RequestParam(value = "includeFullTree", required = false) Boolean includeFullTree,
			@Valid @RequestParam(value = "pedigreeDepth", required = false) Integer pedigreeDepth,
			@Valid @RequestParam(value = "progenyDepth", required = false) Integer progenyDepth,
			@Valid @RequestParam(value = "commonCropName", required = false) String commonCropName,
			@Valid @RequestParam(value = "programDbId", required = false) String programDbId,
			@Valid @RequestParam(value = "externalReferenceId", required = false) String externalReferenceId,
			@Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<PedigreeNode> data = pedigreeService.findPedigree(germplasmPUI, germplasmDbId, germplasmName, accessionNumber,
				collection, binomialName, genus, species, trialDbId, studyDbId, synonym, commonCropName, programDbId,
				externalReferenceId, externalReferenceSource, metadata);
		return responseOK(new PedigreeListResponse(), new PedigreeListResponseResult(), data, metadata);
	}

	@Override
	public ResponseEntity<PedigreeListResponse> pedigreePost(
			@RequestHeader(value = "Authorization", required = false) String authorization,
			@Valid @RequestBody List<PedigreeNode> body) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		List<PedigreeNode> data = pedigreeService.savePedigreeNodes(body);
		return responseOK(new PedigreeListResponse(), new PedigreeListResponseResult(), data);
	}

	@Override
	public ResponseEntity<PedigreeListResponse> pedigreePut(
			@RequestHeader(value = "Authorization", required = false) String authorization,
			@Valid @RequestBody Map<String, PedigreeNode> body) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		List<PedigreeNode> data = pedigreeService.updatePedigreeNodes(body);
		return responseOK(new PedigreeListResponse(), new PedigreeListResponseResult(), data);
	}

	public ResponseEntity<? extends BrAPIResponse> searchPedigreePost(
			@RequestHeader(value = "Authorization", required = false) String authorization,
			@Valid @RequestBody PedigreeSearchRequest body) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body);

		String searchReqDbId = searchService.saveSearchRequest(body, SearchRequestTypes.PEDIGREE);
		if (searchReqDbId != null) {
			return responseAccepted(searchReqDbId);
		} else {
			List<PedigreeNode> data = pedigreeService.findPedigree(body, metadata);
			return responseOK(new PedigreeListResponse(), new PedigreeListResponseResult(), data, metadata);
		}

	}

	public ResponseEntity<? extends BrAPIResponse> searchPedigreeSearchResultsDbIdGet(
			@ApiParam(value = "Unique identifier which references the search results", required = true) @PathVariable("searchResultsDbId") String searchResultsDbId,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		SearchRequestEntity request = searchService.findById(searchResultsDbId);
		if (request != null) {
			PedigreeSearchRequest body = request.getParameters(PedigreeSearchRequest.class);
			List<PedigreeNode> data = pedigreeService.findPedigree(body, metadata);
			return responseOK(new PedigreeListResponse(), new PedigreeListResponseResult(), data, metadata);
		} else {
			return responseAccepted(searchResultsDbId);
		}
	}
}
