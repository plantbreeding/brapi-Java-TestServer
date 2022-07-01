package org.brapi.test.BrAPITestServer.controller.pheno;

import io.swagger.model.Metadata;
import io.swagger.model.pheno.Ontology;
import io.swagger.model.pheno.OntologyListResponse;
import io.swagger.model.pheno.OntologyListResponseResult;
import io.swagger.model.pheno.OntologyNewRequest;
import io.swagger.model.pheno.OntologySingleResponse;
import io.swagger.api.pheno.OntologiesApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.pheno.OntologyService;
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
import jakarta.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

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

	@CrossOrigin
	@Override
	public ResponseEntity<OntologyListResponse> ontologiesGet(
			@Valid @RequestParam(value = "ontologyDbId", required = false) String ontologyDbId,
			@Valid @RequestParam(value = "ontologyName", required = false) String ontologyName,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<Ontology> data = ontologyService.findOntologies(ontologyDbId, ontologyName, metadata);
		return responseOK(new OntologyListResponse(), new OntologyListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<OntologyListResponse> ontologiesPost(
			@RequestHeader(value = "Authorization", required = false) String authorization,
			@Valid @RequestBody List<OntologyNewRequest> body) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		List<Ontology> data = ontologyService.saveOntologies(body);
		return responseOK(new OntologyListResponse(), new OntologyListResponseResult(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<OntologySingleResponse> ontologiesOntologyDbIdGet(
			@PathVariable("ontologyDbId") String ontologyDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {
		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Ontology data = ontologyService.getOntology(ontologyDbId);
		return responseOK(new OntologySingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<OntologySingleResponse> ontologiesOntologyDbIdPut(
			@PathVariable("ontologyDbId") String ontologyDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization,
			@Valid @RequestBody OntologyNewRequest body) throws BrAPIServerException {
		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Ontology data = ontologyService.updateOntologies(ontologyDbId, body);
		return responseOK(new OntologySingleResponse(), data);
	}

}
