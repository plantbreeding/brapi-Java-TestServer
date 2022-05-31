package org.brapi.test.BrAPITestServer.controller.geno;

import io.swagger.model.Metadata;
import io.swagger.model.geno.GenomeMap;
import io.swagger.model.geno.GenomeMapListResponse;
import io.swagger.model.geno.GenomeMapListResponseResult;
import io.swagger.model.geno.GenomeMapSingleResponse;
import io.swagger.model.geno.LinkageGroup;
import io.swagger.model.geno.LinkageGroupListResponse;
import io.swagger.model.geno.LinkageGroupListResponseResult;

import io.swagger.api.geno.MapsApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.geno.GenomeMapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
@Controller
public class MapsApiController extends BrAPIController implements MapsApi {

	private static final Logger log = LoggerFactory.getLogger(MapsApiController.class);

	private final GenomeMapService mapService;

	private final HttpServletRequest request;

	@Autowired
	public MapsApiController(GenomeMapService mapService, HttpServletRequest request) {
		this.mapService = mapService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GenomeMapListResponse> mapsGet(
			@Valid @RequestParam(value = "commonCropName", required = false) String commonCropName,
			@Valid @RequestParam(value = "mapPUI", required = false) String mapPUI,
			@Valid @RequestParam(value = "scientificName", required = false) String scientificName,
			@Valid @RequestParam(value = "type", required = false) String type,
			@Valid @RequestParam(value = "programDbId", required = false) String programDbId,
			@Valid @RequestParam(value = "trialDbId", required = false) String trialDbId,
			@Valid @RequestParam(value = "studyDbId", required = false) String studyDbId,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<GenomeMap> data = mapService.findMaps(commonCropName, mapPUI, scientificName, type, programDbId,
				trialDbId, studyDbId, metadata);
		return responseOK(new GenomeMapListResponse(), new GenomeMapListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<GenomeMapSingleResponse> mapsMapDbIdGet(
			@PathVariable("mapDbId") String mapDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		GenomeMap data = mapService.getMap(mapDbId);
		return responseOK(new GenomeMapSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<LinkageGroupListResponse> mapsMapDbIdLinkagegroupsGet(
			@PathVariable("mapDbId") String mapDbId,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<LinkageGroup> data = mapService.findLinkageGroups(mapDbId, metadata);
		return responseOK(new LinkageGroupListResponse(), new LinkageGroupListResponseResult(), data, metadata);
	}

}
