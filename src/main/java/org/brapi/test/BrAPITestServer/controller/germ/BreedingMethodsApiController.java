package org.brapi.test.BrAPITestServer.controller.germ;

import io.swagger.model.Metadata;
import io.swagger.model.germ.BreedingMethod;
import io.swagger.model.germ.BreedingMethodListResponse;
import io.swagger.model.germ.BreedingMethodListResponseResult;
import io.swagger.model.germ.BreedingMethodSingleResponse;
import io.swagger.api.germ.BreedingMethodsApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.germ.BreedingMethodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
@Controller
public class BreedingMethodsApiController extends BrAPIController implements BreedingMethodsApi {

	private static final Logger log = LoggerFactory.getLogger(BreedingMethodsApiController.class);

	private final BreedingMethodService breedingMethodService;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public BreedingMethodsApiController(BreedingMethodService breedingMethodService, HttpServletRequest request) {
		this.breedingMethodService = breedingMethodService;
		this.request = request;
	}

	@CrossOrigin
	@Override
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

	@CrossOrigin
	@Override
	public ResponseEntity<BreedingMethodSingleResponse> breedingmethodsBreedingMethodDbIdGet(
			@PathVariable("breedingMethodDbId") String breedingMethodDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		BreedingMethod data = breedingMethodService.getBreedingMethod(breedingMethodDbId);
		return responseOK(new BreedingMethodSingleResponse(), data);
	}

}
