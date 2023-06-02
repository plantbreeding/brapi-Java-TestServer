package org.brapi.test.BrAPITestServer.controller.germ;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.Metadata;
import io.swagger.model.germ.Germplasm;
import io.swagger.model.germ.GermplasmListResponse;
import io.swagger.model.germ.GermplasmListResponseResult;
import io.swagger.model.germ.GermplasmMCPD;
import io.swagger.model.germ.GermplasmSingleResponse;
import io.swagger.model.germ.PedigreeNode;
import io.swagger.model.germ.ProgenyNode;
import io.swagger.model.germ.GermplasmMCPDResponse;
import io.swagger.model.germ.GermplasmNewRequest;
import io.swagger.model.germ.GermplasmPedigreeResponse;
import io.swagger.model.germ.GermplasmSearchRequest;
import io.swagger.model.germ.GermplasmProgenyResponse;
import io.swagger.api.germ.GermplasmApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity.SearchRequestTypes;
import org.brapi.test.BrAPITestServer.service.SearchService;
import org.brapi.test.BrAPITestServer.service.germ.GermplasmService;
import org.brapi.test.BrAPITestServer.service.germ.PedigreeService;
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

import java.util.Arrays;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
@Controller
public class GermplasmApiController extends BrAPIController implements GermplasmApi {

	private static final Logger log = LoggerFactory.getLogger(GermplasmApiController.class);

	private final GermplasmService germplasmService;
	private final PedigreeService pedigreeService;
	private final SearchService searchService;
	private final HttpServletRequest request;

	@Autowired
	public GermplasmApiController(GermplasmService germplasmService, PedigreeService pedigreeService,
			SearchService searchService, HttpServletRequest request) {
		this.germplasmService = germplasmService;
		this.pedigreeService = pedigreeService;
		this.searchService = searchService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmSingleResponse> germplasmGermplasmDbIdGet(
			@PathVariable("germplasmDbId") String germplasmDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Germplasm data = germplasmService.getGermplasm(germplasmDbId);
		return responseOK(new GermplasmSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmMCPDResponse> germplasmGermplasmDbIdMcpdGet(
			@PathVariable("germplasmDbId") String germplasmDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		GermplasmMCPD data = germplasmService.getGermplasmMCPD(germplasmDbId);
		return responseOK(new GermplasmMCPDResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmPedigreeResponse> germplasmGermplasmDbIdPedigreeGet(
			@PathVariable("germplasmDbId") String germplasmDbId,
			@RequestParam(value = "notation", required = false) String notation,
			@RequestParam(value = "includeSiblings", required = false) Boolean includeSiblings,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		PedigreeNode data = pedigreeService.getGermplasmPedigree(germplasmDbId, includeSiblings);
		return responseOK(new GermplasmPedigreeResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmProgenyResponse> germplasmGermplasmDbIdProgenyGet(
			@PathVariable("germplasmDbId") String germplasmDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		ProgenyNode data = pedigreeService.getGermplasmProgeny(germplasmDbId);
		return responseOK(new GermplasmProgenyResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmListResponse> germplasmGet(
			@RequestParam(value = "germplasmPUI", required = false) String germplasmPUI,
			@RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,
			@RequestParam(value = "germplasmName", required = false) String germplasmName,
			@RequestParam(value = "accessionNumber", required = false) String accessionNumber,
			@RequestParam(value = "collection", required = false) String collection,
			@RequestParam(value = "binomialName", required = false) String binomialName,
			@RequestParam(value = "genus", required = false) String genus,
			@RequestParam(value = "species", required = false) String species,
			@RequestParam(value = "trialDbId", required = false) String trialDbId,
			@RequestParam(value = "studyDbId", required = false) String studyDbId,
			@RequestParam(value = "synonym", required = false) String synonym,
			@RequestParam(value = "parentDbId", required = false) String parentDbId,
			@RequestParam(value = "progenyDbId", required = false) String progenyDbId,
			@RequestParam(value = "commonCropName", required = false) String commonCropName,
			@RequestParam(value = "programDbId", required = false) String programDbId,
			@RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
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
		List<Germplasm> data = germplasmService.findGermplasm(germplasmPUI, germplasmDbId, germplasmName,
				accessionNumber, collection, binomialName, genus, species, trialDbId, studyDbId, synonym, parentDbId,
				progenyDbId, commonCropName, programDbId, externalReferenceId, externalReferenceID,
				externalReferenceSource, metadata);
		return responseOK(new GermplasmListResponse(), new GermplasmListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmSingleResponse> germplasmGermplasmDbIdPut(
			@PathVariable("germplasmDbId") String germplasmDbId, @RequestBody GermplasmNewRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		Germplasm data = germplasmService.updateGermplasm(germplasmDbId, body);
		pedigreeService.updateGermplasmPedigree(Arrays.asList(data));
		return responseOK(new GermplasmSingleResponse(), data);
	}
	
	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmListResponse> germplasmPost(@RequestBody List<GermplasmNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		List<Germplasm> data = germplasmService.saveGermplasm(body);
		pedigreeService.updateGermplasmPedigree(data);
		return responseOK(new GermplasmListResponse(), new GermplasmListResponseResult(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchGermplasmPost(@RequestBody GermplasmSearchRequest body,
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
			List<Germplasm> data = germplasmService.findGermplasm(body, metadata);
			return responseOK(new GermplasmListResponse(), new GermplasmListResponseResult(), data, metadata);
		}
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchGermplasmSearchResultsDbIdGet(
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
			GermplasmSearchRequest body = request.getParameters(GermplasmSearchRequest.class);
			List<Germplasm> data = germplasmService.findGermplasm(body, metadata);
			return responseOK(new GermplasmListResponse(), new GermplasmListResponseResult(), data, metadata);
		} else {
			return responseAccepted(searchResultsDbId);
		}
	}
}
