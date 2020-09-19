package org.brapi.test.BrAPITestServer.controller.germ;

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
import org.brapi.test.BrAPITestServer.service.germ.GermplasmService;
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
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
@Controller
public class GermplasmApiController extends BrAPIController implements GermplasmApi {

	private static final Logger log = LoggerFactory.getLogger(GermplasmApiController.class);

	private final GermplasmService germplasmService;

	private final HttpServletRequest request;

	@Autowired
	public GermplasmApiController(GermplasmService germplasmService, HttpServletRequest request) {
		this.germplasmService = germplasmService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmSingleResponse> germplasmGermplasmDbIdGet(
			@PathVariable("germplasmDbId") String germplasmDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
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
		validateAcceptHeader(request);
		GermplasmMCPD data = germplasmService.getGermplasmMCPD(germplasmDbId);
		return responseOK(new GermplasmMCPDResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmPedigreeResponse> germplasmGermplasmDbIdPedigreeGet(
			@PathVariable("germplasmDbId") String germplasmDbId,
			@Valid @RequestParam(value = "notation", required = false) String notation,
			@Valid @RequestParam(value = "includeSiblings", required = false) Boolean includeSiblings,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		PedigreeNode data = germplasmService.getGermplasmPedigree(germplasmDbId, notation, includeSiblings);
		return responseOK(new GermplasmPedigreeResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmProgenyResponse> germplasmGermplasmDbIdProgenyGet(
			@PathVariable("germplasmDbId") String germplasmDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		ProgenyNode data = germplasmService.getGermplasmProgeny(germplasmDbId);
		return responseOK(new GermplasmProgenyResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmSingleResponse> germplasmGermplasmDbIdPut(
			@PathVariable("germplasmDbId") String germplasmDbId, @Valid @RequestBody GermplasmNewRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Germplasm data = germplasmService.updateGermplasm(germplasmDbId, body);
		return responseOK(new GermplasmSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmListResponse> germplasmGet(
			@Valid @RequestParam(value = "germplasmPUI", required = false) String germplasmPUI,
			@Valid @RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,
			@Valid @RequestParam(value = "germplasmName", required = false) String germplasmName,
			@Valid @RequestParam(value = "commonCropName", required = false) String commonCropName,
			@Valid @RequestParam(value = "accessionNumber", required = false) String accessionNumber,
			@Valid @RequestParam(value = "collection", required = false) String collection,
			@Valid @RequestParam(value = "genus", required = false) String genus,
			@Valid @RequestParam(value = "species", required = false) String species,
			@Valid @RequestParam(value = "studyDbId", required = false) String studyDbId,
			@Valid @RequestParam(value = "synonym", required = false) String synonym,
			@Valid @RequestParam(value = "parentDbId", required = false) String parentDbId,
			@Valid @RequestParam(value = "progenyDbId", required = false) String progenyDbId,
			@Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<Germplasm> data = germplasmService.findGermplasm(germplasmPUI, germplasmDbId, germplasmName,
				commonCropName, accessionNumber, collection, genus, species, studyDbId, synonym, parentDbId,
				progenyDbId, externalReferenceID, externalReferenceSource, metadata);
		return responseOK(new GermplasmListResponse(), new GermplasmListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmListResponse> germplasmPost(@Valid @RequestBody List<GermplasmNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		List<Germplasm> data = germplasmService.saveGermplasm(body);
		return responseOK(new GermplasmListResponse(), new GermplasmListResponseResult(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmListResponse> searchGermplasmPost(@Valid @RequestBody GermplasmSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body);
		List<Germplasm> data = germplasmService.findGermplasm(body, metadata);
		return responseOK(new GermplasmListResponse(), new GermplasmListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmListResponse> searchGermplasmSearchResultsDbIdGet(
			@PathVariable("searchResultsDbId") String searchResultsDbId,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		return new ResponseEntity<GermplasmListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}
}
