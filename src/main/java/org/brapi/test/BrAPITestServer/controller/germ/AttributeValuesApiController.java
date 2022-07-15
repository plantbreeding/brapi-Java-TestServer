package org.brapi.test.BrAPITestServer.controller.germ;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.Metadata;
import io.swagger.model.germ.GermplasmAttributeValue;
import io.swagger.model.germ.GermplasmAttributeValueListResponse;
import io.swagger.model.germ.GermplasmAttributeValueListResponseResult;
import io.swagger.model.germ.GermplasmAttributeValueSingleResponse;
import io.swagger.model.germ.GermplasmAttributeValueNewRequest;
import io.swagger.model.germ.GermplasmAttributeValueSearchRequest;
import io.swagger.api.germ.AttributeValuesApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity.SearchRequestTypes;
import org.brapi.test.BrAPITestServer.service.SearchService;
import org.brapi.test.BrAPITestServer.service.germ.GermplasmAttributeValueService;
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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
@Controller
public class AttributeValuesApiController extends BrAPIController implements AttributeValuesApi {

	private static final Logger log = LoggerFactory.getLogger(AttributeValuesApiController.class);

	private final GermplasmAttributeValueService attributeValueService;
	private final SearchService searchService;
	private final HttpServletRequest request;

	@Autowired
	public AttributeValuesApiController(GermplasmAttributeValueService attributeValueService,
			SearchService searchService, HttpServletRequest request) {
		this.attributeValueService = attributeValueService;
		this.searchService = searchService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmAttributeValueListResponse> attributevaluesGet(
			@RequestParam(value = "attributeValueDbId", required = false) String attributeValueDbId,
			@RequestParam(value = "attributeDbId", required = false) String attributeDbId,
			@RequestParam(value = "attributeName", required = false) String attributeName,
			@RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,
			@RequestParam(value = "commonCropName", required = false) String commonCropName,
			@RequestParam(value = "programDbId", required = false) String programDbId,
			@RequestParam(value = "externalReferenceID", required = false) String externalReferenceId,
			@RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<GermplasmAttributeValue> data = attributeValueService.findGermplasmAttributeValues(attributeValueDbId,
				attributeDbId, attributeName, germplasmDbId, commonCropName, programDbId, externalReferenceId,
				externalReferenceID, externalReferenceSource, metadata);
		return responseOK(new GermplasmAttributeValueListResponse(), new GermplasmAttributeValueListResponseResult(),
				data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmAttributeValueListResponse> attributevaluesPost(
			@RequestBody List<GermplasmAttributeValueNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		List<GermplasmAttributeValue> data = attributeValueService.saveGermplasmAttributeValues(body);
		return responseOK(new GermplasmAttributeValueListResponse(), new GermplasmAttributeValueListResponseResult(),
				data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmAttributeValueSingleResponse> attributevaluesAttributeValueDbIdGet(
			@PathVariable("attributeValueDbId") String attributeValueDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		GermplasmAttributeValue data = attributeValueService.getGermplasmAttributeValue(attributeValueDbId);
		return responseOK(new GermplasmAttributeValueSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GermplasmAttributeValueSingleResponse> attributevaluesAttributeValueDbIdPut(
			@PathVariable("attributeValueDbId") String attributeValueDbId,
			@RequestBody GermplasmAttributeValueNewRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		GermplasmAttributeValue data = attributeValueService.updateGermplasmAttributeValue(attributeValueDbId, body);
		return responseOK(new GermplasmAttributeValueSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchAttributevaluesPost(
			@RequestBody GermplasmAttributeValueSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body);

		String searchReqDbId = searchService.saveSearchRequest(body, SearchRequestTypes.GERMPLASM_ATTRIBUTE_VALUES);
		if (searchReqDbId != null) {
			return responseAccepted(searchReqDbId);
		} else {
			List<GermplasmAttributeValue> data = attributeValueService.findGermplasmAttributeValues(body, metadata);
			return responseOK(new GermplasmAttributeValueListResponse(),
					new GermplasmAttributeValueListResponseResult(), data, metadata);
		}
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchAttributevaluesSearchResultsDbIdGet(
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
			GermplasmAttributeValueSearchRequest body = request
					.getParameters(GermplasmAttributeValueSearchRequest.class);
			List<GermplasmAttributeValue> data = attributeValueService.findGermplasmAttributeValues(body, metadata);
			return responseOK(new GermplasmAttributeValueListResponse(),
					new GermplasmAttributeValueListResponseResult(), data, metadata);
		} else {
			return responseAccepted(searchResultsDbId);
		}
	}
}
