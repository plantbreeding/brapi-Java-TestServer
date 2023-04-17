package org.brapi.test.BrAPITestServer.controller.geno;

import javax.servlet.http.HttpServletRequest;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity.SearchRequestTypes;
import org.brapi.test.BrAPITestServer.service.SearchService;
import org.brapi.test.BrAPITestServer.service.geno.AlleleMatrixService;
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

import io.swagger.api.geno.AlleleMatrixApi;
import io.swagger.model.BrAPIResponse;
import io.swagger.model.Metadata;
import io.swagger.model.geno.AlleleMatrixResponse;
import io.swagger.model.geno.AlleleMatrixSearchRequest;
import io.swagger.model.geno.AlleleMatrix;
import jakarta.validation.Valid;

@Controller
public class AlleleMatrixApiController extends BrAPIController implements AlleleMatrixApi {
	private static final Logger log = LoggerFactory.getLogger(AlleleMatrixApiController.class);

	private final AlleleMatrixService alleleMatrixService;
	private final SearchService searchService;
	private final HttpServletRequest request;

	@Autowired
	public AlleleMatrixApiController(AlleleMatrixService alleleMatrixService, SearchService searchService,
			HttpServletRequest request) {
		this.alleleMatrixService = alleleMatrixService;
		this.searchService = searchService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<AlleleMatrixResponse> allelematrixGet(
			@Valid @RequestParam(value = "dimensionVariantPage", required = false) Integer dimensionVariantPage,
			@Valid @RequestParam(value = "dimensionVariantPageSize", required = false) Integer dimensionVariantPageSize,
			@Valid @RequestParam(value = "dimensionCallSetPage", required = false) Integer dimensionCallSetPage,
			@Valid @RequestParam(value = "dimensionCallSetPageSize", required = false) Integer dimensionCallSetPageSize,
			@Valid @RequestParam(value = "preview", required = false) Boolean preview,
			@Valid @RequestParam(value = "dataMatrixNames", required = false) String dataMatrixNames,
			@Valid @RequestParam(value = "dataMatrixAbbreviations", required = false) String dataMatrixAbbreviations,
			@Valid @RequestParam(value = "positionRange", required = false) String positionRange,
			@Valid @RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,
			@Valid @RequestParam(value = "germplasmName", required = false) String germplasmName,
			@Valid @RequestParam(value = "germplasmPUI", required = false) String germplasmPUI,
			@Valid @RequestParam(value = "alleleMatrixSetDbId", required = false) String callSetDbId,
			@Valid @RequestParam(value = "variantDbId", required = false) String variantDbId,
			@Valid @RequestParam(value = "variantSetDbId", required = false) String variantSetDbId,
			@Valid @RequestParam(value = "expandHomozygotes", required = false) Boolean expandHomozygotes,
			@Valid @RequestParam(value = "unknownString", required = false) String unknownString,
			@Valid @RequestParam(value = "sepPhased", required = false) String sepPhased,
			@Valid @RequestParam(value = "sepUnphased", required = false) String sepUnphased,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateEmptyMetadata();

		AlleleMatrix data = alleleMatrixService.findAlleleMatrix(dimensionVariantPage, dimensionVariantPageSize,
				dimensionCallSetPage, dimensionCallSetPageSize, preview, dataMatrixNames,
				dataMatrixAbbreviations, positionRange, germplasmDbId, germplasmName, germplasmPUI, callSetDbId,
				variantDbId, variantSetDbId, expandHomozygotes, unknownString, sepPhased, sepUnphased, metadata);

		return responseOK(new AlleleMatrixResponse(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchAllelematrixPost(
			@Valid @RequestBody AlleleMatrixSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {
		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateEmptyMetadata();

		String searchReqDbId = searchService.saveSearchRequest(body, SearchRequestTypes.CALLS);
		if (searchReqDbId != null) {
			return responseAccepted(searchReqDbId);
		} else {
			AlleleMatrix data = alleleMatrixService.findAlleleMatrix(body, metadata);
			return responseOK(new AlleleMatrixResponse(), data, metadata);
		}
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchAllelematrixSearchResultsDbIdGet(
			@PathVariable("searchResultsDbId") String searchResultsDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {
		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateEmptyMetadata();
		SearchRequestEntity request = searchService.findById(searchResultsDbId);
		if (request != null) {
			AlleleMatrixSearchRequest body = request.getParameters(AlleleMatrixSearchRequest.class);
			AlleleMatrix data = alleleMatrixService.findAlleleMatrix(body, metadata);
			return responseOK(new AlleleMatrixResponse(), data, metadata);
		} else {
			return responseAccepted(searchResultsDbId);
		}
	}

}
