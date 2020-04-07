package org.brapi.test.BrAPITestServer.controller.germ;

import io.swagger.model.Metadata;
import io.swagger.model.germ.BreedingMethod;
import io.swagger.model.germ.BreedingMethodListResponse;
import io.swagger.model.germ.BreedingMethodListResponseResult;
import io.swagger.model.germ.BreedingMethodSingleResponse;
import io.swagger.model.germ.GermplasmAttributeValue;
import io.swagger.model.germ.GermplasmAttributeValueListResponse;
import io.swagger.model.germ.GermplasmAttributeValueListResponseResult;
import io.swagger.model.germ.GermplasmAttributeValueSingleResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.germ.BreedingmethodsApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.germ.BreedingMethodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
@Controller
public class BreedingmethodsApiController extends BrAPIController implements BreedingmethodsApi {

	private static final Logger log = LoggerFactory.getLogger(BreedingmethodsApiController.class);

	private final BreedingMethodService breedingMethodService;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public BreedingmethodsApiController(BreedingMethodService breedingMethodService, HttpServletRequest request) {
		this.breedingMethodService = breedingMethodService;
		this.request = request;
	}

	public ResponseEntity<BreedingMethodListResponse> breedingmethodsGet(
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<BreedingMethod> data = breedingMethodService.findBreedingMethods(metadata);
		return responseOK(new BreedingMethodListResponse(), new BreedingMethodListResponseResult(), data,
				metadata);
	}

	public ResponseEntity<BreedingMethodSingleResponse> breedingmethodsBreedingMethodDbIdGet(
			@PathVariable("breedingMethodDbId") String breedingMethodDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		BreedingMethod data = breedingMethodService.getBreedingMethod(breedingMethodDbId);
		return responseOK(new BreedingMethodSingleResponse(), data);
	}

}
