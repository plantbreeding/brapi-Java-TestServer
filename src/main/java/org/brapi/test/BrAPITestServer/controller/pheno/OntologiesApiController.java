package org.brapi.test.BrAPITestServer.controller.pheno;

import io.swagger.model.pheno.OntologyListResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.pheno.OntologiesApi;

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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
@Controller
public class OntologiesApiController implements OntologiesApi {

    private static final Logger log = LoggerFactory.getLogger(OntologiesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public OntologiesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<OntologyListResponse> ontologiesGet(@ApiParam(value = "Used to request a specific page of data to be returned.  The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page
,@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<OntologyListResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"data\" : [ {\n      \"documentationURL\" : \"https://wiki.brapi.org/ontology\",\n      \"licence\" : \"MIT Open source licence\",\n      \"copyright\" : \"Copyright 1987, Bob Robertson\",\n      \"ontologyDbId\" : \"18e186cd\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"ontologyName\" : \"The Official Ontology\",\n      \"description\" : \"This is an example ontology that does not exist\",\n      \"version\" : \"V1.3.2\",\n      \"authors\" : \"Bob Robertson, Rob Robertson\"\n    }, {\n      \"documentationURL\" : \"https://wiki.brapi.org/ontology\",\n      \"licence\" : \"MIT Open source licence\",\n      \"copyright\" : \"Copyright 1987, Bob Robertson\",\n      \"ontologyDbId\" : \"18e186cd\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"ontologyName\" : \"The Official Ontology\",\n      \"description\" : \"This is an example ontology that does not exist\",\n      \"version\" : \"V1.3.2\",\n      \"authors\" : \"Bob Robertson, Rob Robertson\"\n    } ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", OntologyListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<OntologyListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<OntologyListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
