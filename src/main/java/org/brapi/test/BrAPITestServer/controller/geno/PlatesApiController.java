package org.brapi.test.BrAPITestServer.controller.geno;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.Metadata;
import io.swagger.model.geno.Plate;
import io.swagger.model.geno.PlateListResponse;
import io.swagger.model.geno.PlateListResponseResult;
import io.swagger.model.geno.PlateNewRequest;
import io.swagger.model.geno.PlateSearchRequest;
import io.swagger.model.geno.PlateSingleResponse;
import io.swagger.api.geno.PlatesApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity.SearchRequestTypes;
import org.brapi.test.BrAPITestServer.service.SearchService;
import org.brapi.test.BrAPITestServer.service.geno.PlateService;
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
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
@Controller
public class PlatesApiController extends BrAPIController implements PlatesApi {

	private static final Logger log = LoggerFactory.getLogger(PlatesApiController.class);

	private final PlateService plateService;
	private final SearchService searchService;
	private final HttpServletRequest request;

	@Autowired
	public PlatesApiController(PlateService plateService, SearchService searchService, HttpServletRequest request) {
		this.plateService = plateService;
		this.searchService = searchService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<PlateListResponse> platesGet(
			@RequestParam(value = "sampleDbId", required = false) String sampleDbId,
			@RequestParam(value = "sampleName", required = false) String sampleName,
			@RequestParam(value = "sampleGroupDbId", required = false) String sampleGroupDbId,
			@RequestParam(value = "observationUnitDbId", required = false) String observationUnitDbId,
			@RequestParam(value = "plateDbId", required = false) String plateDbId,
			@RequestParam(value = "plateName", required = false) String plateName,
			@RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,
			@RequestParam(value = "studyDbId", required = false) String studyDbId,
			@RequestParam(value = "trialDbId", required = false) String trialDbId,
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
		List<Plate> data = plateService.findPlates(sampleDbId, sampleName, sampleGroupDbId, observationUnitDbId,
				plateDbId, plateName, germplasmDbId, studyDbId, trialDbId, commonCropName, programDbId,
				externalReferenceId, externalReferenceID, externalReferenceSource, metadata);
		return responseOK(new PlateListResponse(), new PlateListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<PlateListResponse> platesPost(@RequestBody List<PlateNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		List<Plate> data = plateService.savePlates(body);
		return responseOK(new PlateListResponse(), new PlateListResponseResult(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<PlateListResponse> platesPut(@RequestBody Map<String, PlateNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		List<Plate> data = plateService.updatePlates(body);
		return responseOK(new PlateListResponse(), new PlateListResponseResult(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<PlateSingleResponse> platesPlateDbIdGet(@PathVariable("plateDbId") String plateDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Plate data = plateService.getPlate(plateDbId);
		return responseOK(new PlateSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchPlatesPost(@RequestBody PlateSearchRequest body,
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
			List<Plate> data = plateService.findPlates(body, metadata);
			return responseOK(new PlateListResponse(), new PlateListResponseResult(), data, metadata);
		}
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchPlatesSearchResultsDbIdGet(
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
			PlateSearchRequest body = request.getParameters(PlateSearchRequest.class);
			List<Plate> data = plateService.findPlates(body, metadata);
			return responseOK(new PlateListResponse(), new PlateListResponseResult(), data, metadata);
		} else {
			return responseAccepted(searchResultsDbId);
		}
	}

}
