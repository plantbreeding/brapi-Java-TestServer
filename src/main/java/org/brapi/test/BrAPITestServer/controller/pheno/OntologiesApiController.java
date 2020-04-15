package org.brapi.test.BrAPITestServer.controller.pheno;

import io.swagger.model.Metadata;
import io.swagger.model.pheno.Ontology;
import io.swagger.model.pheno.OntologyListResponse;
import io.swagger.model.pheno.OntologyListResponseResult;

import io.swagger.api.pheno.OntologiesApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.pheno.OntologyService;
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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
@Controller
public class OntologiesApiController extends BrAPIController implements OntologiesApi {

	private static final Logger log = LoggerFactory.getLogger(OntologiesApiController.class);

	private final OntologyService ontologyService;

	private final HttpServletRequest request;

	@Autowired
	public OntologiesApiController(OntologyService ontologyService, HttpServletRequest request) {
		this.ontologyService = ontologyService;
		this.request = request;
	}

	public ResponseEntity<OntologyListResponse> ontologiesGet(
			@Valid @RequestParam(value = "ontologyDbId", required = false) String ontologyDbId,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<Ontology> data = ontologyService.findOntologies(ontologyDbId, metadata);
		return responseOK(new OntologyListResponse(), new OntologyListResponseResult(), data, metadata);
	}

}
