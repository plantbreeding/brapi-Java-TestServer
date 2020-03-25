package org.brapi.test.BrAPITestServer.controller.core;

import io.swagger.model.common.Metadata;
import io.swagger.model.core.CommonCropNamesResponse;
import io.swagger.model.core.CommonCropNamesResponseResult;
import io.swagger.api.core.CommoncropnamesApi;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.CropService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
@Controller
public class CommoncropnamesApiController extends BrAPIController implements CommoncropnamesApi {

	private static final Logger log = LoggerFactory.getLogger(CommoncropnamesApiController.class);

	private final CropService cropService;
	private final HttpServletRequest request;

	@Autowired
	public CommoncropnamesApiController(CropService cropService, HttpServletRequest request) {
		this.cropService = cropService;
		this.request = request;
	}

	public ResponseEntity<CommonCropNamesResponse> commoncropnamesGet(
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		validateAcceptHeader(request);
		log.debug("Request: " + request.getRequestURI());

		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<String> crops = cropService.getCrops(metadata);
		return responseOK(new CommonCropNamesResponse(), new CommonCropNamesResponseResult(), crops, metadata);
	}

}
