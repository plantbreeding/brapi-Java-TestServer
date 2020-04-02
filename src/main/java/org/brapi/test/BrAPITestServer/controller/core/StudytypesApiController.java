package org.brapi.test.BrAPITestServer.controller.core;

import io.swagger.model.common.Metadata;
import io.swagger.model.core.StudyTypesResponse;
import io.swagger.model.core.StudyTypesResponseResult;

import io.swagger.api.core.StudytypesApi;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
@Controller
public class StudytypesApiController extends BrAPIController implements StudytypesApi {

	private static final Logger log = LoggerFactory.getLogger(StudytypesApiController.class);

	private final HttpServletRequest request;

	@Autowired
	public StudytypesApiController(HttpServletRequest request) {
		this.request = request;
	}

	public ResponseEntity<StudyTypesResponse> studytypesGet(
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		metadata.getPagination().setTotalCount(2);
		metadata.getPagination().setTotalPages(1);
		if (metadata.getPagination().getPageSize() < 2) {
			metadata.getPagination().setPageSize(2);
		}

		List<String> data = new ArrayList<>();
		if (metadata.getPagination().getCurrentPage() == 0) {
			data.add("Phenotyping");
			data.add("Genotyping");
		}

		return responseOK(new StudyTypesResponse(), new StudyTypesResponseResult(), data, metadata);
	}

}
