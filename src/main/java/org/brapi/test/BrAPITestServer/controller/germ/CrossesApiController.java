package org.brapi.test.BrAPITestServer.controller.germ;

import io.swagger.model.germ.CrossNewRequest;
import io.swagger.model.germ.CrossesListResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.germ.CrossesApi;

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
public class CrossesApiController implements CrossesApi {

	private static final Logger log = LoggerFactory.getLogger(CrossesApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public CrossesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<CrossesListResponse> crossesGet(
			@Valid @RequestParam(value = "crossingProjectDbId", required = false) String crossingProjectDbId,
			@Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<CrossesListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						CrossesListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<CrossesListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<CrossesListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<CrossesListResponse> crossesPost(
			@Valid @RequestBody List<CrossNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<CrossesListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						CrossesListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<CrossesListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<CrossesListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<CrossesListResponse> crossesPut(
			@Valid @RequestBody Map<String, CrossNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<CrossesListResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						CrossesListResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<CrossesListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<CrossesListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

}
