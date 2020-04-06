package org.brapi.test.BrAPITestServer.controller.germ;

import io.swagger.model.common.Metadata;
import io.swagger.model.germ.GermplasmAttribute;
import io.swagger.model.germ.GermplasmAttributeCategoryListResponse;
import io.swagger.model.germ.GermplasmAttributeCategoryListResponseResult;
import io.swagger.model.germ.GermplasmAttributeListResponse;
import io.swagger.model.germ.GermplasmAttributeListResponseResult;
import io.swagger.model.germ.GermplasmAttributeNewRequest;
import io.swagger.model.germ.GermplasmAttributeSearchRequest;
import io.swagger.model.germ.GermplasmAttributeSingleResponse;
import io.swagger.api.germ.AttributesApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.GermplasmAttributeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
@Controller
public class AttributesApiController extends BrAPIController implements AttributesApi {

	private static final Logger log = LoggerFactory.getLogger(AttributesApiController.class);

	private final GermplasmAttributeService attributeService;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public AttributesApiController(GermplasmAttributeService attributeService, HttpServletRequest request) {
		this.attributeService = attributeService;
		this.request = request;
	}

	public ResponseEntity<GermplasmAttributeCategoryListResponse> attributesCategoriesGet(
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		validateAcceptHeader(request);
		log.debug("Request: " + request.getRequestURI());

		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<String> crops = attributeService.getAttributesCategories(metadata);
		return responseOK(new GermplasmAttributeCategoryListResponse(),
				new GermplasmAttributeCategoryListResponseResult(), crops, metadata);
	}

	public ResponseEntity<GermplasmAttributeListResponse> attributesGet(
			@Valid @RequestParam(value = "attributeCategory", required = false) String attributeCategory,
			@Valid @RequestParam(value = "attributeDbId", required = false) String attributeDbId,
			@Valid @RequestParam(value = "attributeName", required = false) String attributeName,
			@Valid @RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,
			@Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<GermplasmAttribute> data = attributeService.findGermplasmAttributes(attributeCategory, attributeDbId,
				attributeName, germplasmDbId, externalReferenceID, externalReferenceSource, metadata);
		return responseOK(new GermplasmAttributeListResponse(), new GermplasmAttributeListResponseResult(), data,
				metadata);
	}

	public ResponseEntity<GermplasmAttributeListResponse> attributesPost(
			@Valid @RequestBody List<GermplasmAttributeNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		List<GermplasmAttribute> data = attributeService.saveGermplasmAttributes(body);
		return responseOK(new GermplasmAttributeListResponse(), new GermplasmAttributeListResponseResult(), data);
	}

	public ResponseEntity<GermplasmAttributeSingleResponse> attributesAttributeDbIdGet(
			@PathVariable("attributeDbId") String attributeDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		GermplasmAttribute data = attributeService.getGermplasmAttribute(attributeDbId);
		return responseOK(new GermplasmAttributeSingleResponse(), data);
	}

	public ResponseEntity<GermplasmAttributeSingleResponse> attributesAttributeDbIdPut(
			@PathVariable("attributeDbId") String attributeDbId, @Valid @RequestBody GermplasmAttributeNewRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		GermplasmAttribute data = attributeService.updateGermplasmAttribute(attributeDbId, body);
		return responseOK(new GermplasmAttributeSingleResponse(), data);
	}

	public ResponseEntity<GermplasmAttributeListResponse> searchAttributesPost(
			@Valid @RequestBody GermplasmAttributeSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body);
		List<GermplasmAttribute> data = attributeService.findGermplasmAttributes(body, metadata);
		return responseOK(new GermplasmAttributeListResponse(), new GermplasmAttributeListResponseResult(), data,
				metadata);
	}

	public ResponseEntity<GermplasmAttributeListResponse> searchAttributesSearchResultsDbIdGet(
			@PathVariable("searchResultsDbId") String searchResultsDbId,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		return new ResponseEntity<GermplasmAttributeListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}
}
