package org.brapi.test.BrAPITestServer.controller.core;

import io.swagger.model.Metadata;
import io.swagger.model.core.CommonCropNamesResponse;
import io.swagger.model.core.CommonCropNamesResponseResult;
import io.swagger.api.core.CommonCropNamesApi;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.core.CropService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CommonCropNamesApiController extends BrAPIController implements CommonCropNamesApi {

	private static final Logger log = LoggerFactory.getLogger(CommonCropNamesApiController.class);

	private final CropService cropService;
	private final HttpServletRequest request;

	@Autowired
	public CommonCropNamesApiController(CropService cropService, HttpServletRequest request) {
		this.cropService = cropService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<CommonCropNamesResponse> commoncropnamesGet(
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		validateAcceptHeader(request);
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		log.debug("Request: " + request.getRequestURI());

		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<String> crops = cropService.getCrops(metadata);
		return responseOK(new CommonCropNamesResponse(), new CommonCropNamesResponseResult(), crops, metadata);
	}

}
