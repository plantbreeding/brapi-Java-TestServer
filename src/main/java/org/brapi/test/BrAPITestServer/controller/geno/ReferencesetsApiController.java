package org.brapi.test.BrAPITestServer.controller.geno;

import io.swagger.model.geno.ReferenceSetsListResponse;
import io.swagger.model.geno.ReferenceSetsSingleResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.geno.ReferencesetsApi;

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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
@Controller
public class ReferencesetsApiController implements ReferencesetsApi {

    private static final Logger log = LoggerFactory.getLogger(ReferencesetsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ReferencesetsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ReferenceSetsListResponse> referencesetsGet(@ApiParam(value = "The ID of the `ReferenceSet` to be retrieved.") @Valid @RequestParam(value = "referenceSetDbId", required = false) String referenceSetDbId
,@ApiParam(value = "If set, return the reference sets for which the `accession` matches this string (case-sensitive, exact match).") @Valid @RequestParam(value = "accession", required = false) String accession
,@ApiParam(value = "If set, return the reference sets for which the `assemblyId` matches this string (case-sensitive, exact match).") @Valid @RequestParam(value = "assemblyPUI", required = false) String assemblyPUI
,@ApiParam(value = "If set, return the reference sets for which the `md5checksum` matches this string (case-sensitive, exact match).") @Valid @RequestParam(value = "md5checksum", required = false) String md5checksum
,@ApiParam(value = "Used to request a specific page of data to be returned.  The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page
,@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ReferenceSetsListResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"data\" : [ {\n      \"isDerived\" : true,\n      \"sourceURI\" : \"sourceURI\",\n      \"species\" : {\n        \"termURI\" : \"termURI\",\n        \"term\" : \"term\"\n      },\n      \"md5checksum\" : \"md5checksum\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"assemblyPUI\" : \"assemblyPUI\",\n      \"description\" : \"description\",\n      \"referenceSetDbId\" : \"referenceSetDbId\",\n      \"referenceSetName\" : \"referenceSetName\",\n      \"sourceAccessions\" : [ \"sourceAccessions\", \"sourceAccessions\" ]\n    }, {\n      \"isDerived\" : true,\n      \"sourceURI\" : \"sourceURI\",\n      \"species\" : {\n        \"termURI\" : \"termURI\",\n        \"term\" : \"term\"\n      },\n      \"md5checksum\" : \"md5checksum\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"assemblyPUI\" : \"assemblyPUI\",\n      \"description\" : \"description\",\n      \"referenceSetDbId\" : \"referenceSetDbId\",\n      \"referenceSetName\" : \"referenceSetName\",\n      \"sourceAccessions\" : [ \"sourceAccessions\", \"sourceAccessions\" ]\n    } ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", ReferenceSetsListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ReferenceSetsListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ReferenceSetsListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ReferenceSetsSingleResponse> referencesetsReferenceSetDbIdGet(@ApiParam(value = "The ID of the `ReferenceSet` to be retrieved.",required=true) @PathVariable("referenceSetDbId") String referenceSetDbId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ReferenceSetsSingleResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"isDerived\" : true,\n    \"sourceURI\" : \"sourceURI\",\n    \"species\" : {\n      \"termURI\" : \"termURI\",\n      \"term\" : \"term\"\n    },\n    \"md5checksum\" : \"md5checksum\",\n    \"additionalInfo\" : {\n      \"key\" : \"additionalInfo\"\n    },\n    \"assemblyPUI\" : \"assemblyPUI\",\n    \"description\" : \"description\",\n    \"referenceSetDbId\" : \"referenceSetDbId\",\n    \"referenceSetName\" : \"referenceSetName\",\n    \"sourceAccessions\" : [ \"sourceAccessions\", \"sourceAccessions\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", ReferenceSetsSingleResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ReferenceSetsSingleResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ReferenceSetsSingleResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
