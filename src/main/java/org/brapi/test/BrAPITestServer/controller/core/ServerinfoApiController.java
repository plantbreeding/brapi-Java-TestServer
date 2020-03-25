package org.brapi.test.BrAPITestServer.controller.core;

import io.swagger.model.core.CallsResponse;
import io.swagger.model.common.WSMIMEDataTypes;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.core.ServerinfoApi;

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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
@Controller
public class ServerinfoApiController implements ServerinfoApi {

	private static final Logger log = LoggerFactory.getLogger(ServerinfoApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public ServerinfoApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<CallsResponse> serverinfoGet(
			@Valid @RequestParam(value = "dataType", required = false) WSMIMEDataTypes dataType,
			@RequestHeader(value = "Authorization", required = false) String authorization) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<CallsResponse>(objectMapper.readValue(
						"{\n  \"result\" : {\n    \"documentationURL\" : \"institute.org/server\",\n    \"organizationName\" : \"The Institute\",\n    \"calls\" : [ {\n      \"dataTypes\" : [ \"application/json\" ],\n      \"versions\" : [ \"2.0\", \"2.1\" ],\n      \"methods\" : [ \"GET\", \"POST\" ],\n      \"service\" : \"germplasm/{germplasmDbId}/pedigree\"\n    }, {\n      \"dataTypes\" : [ \"application/json\" ],\n      \"versions\" : [ \"2.0\", \"2.1\" ],\n      \"methods\" : [ \"GET\", \"POST\" ],\n      \"service\" : \"germplasm/{germplasmDbId}/pedigree\"\n    } ],\n    \"contactEmail\" : \"contact@institute.org\",\n    \"serverName\" : \"The BrAPI Test Server\",\n    \"location\" : \"USA\",\n    \"organizationURL\" : \"institute.org/home\",\n    \"serverDescription\" : \"The BrAPI Test Server\nWeb Server - Apache Tomcat 7.0.32\nDatabase - Postgres 10\nSupported BrAPI Version - V2.0\"\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}",
						CallsResponse.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<CallsResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<CallsResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

}
