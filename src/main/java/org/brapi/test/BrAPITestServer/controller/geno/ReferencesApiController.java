package org.brapi.test.BrAPITestServer.controller.geno;

import io.swagger.model.geno.ReferenceBasesResponse;
import io.swagger.model.geno.ReferenceSingleResponse;
import io.swagger.model.geno.ReferencesListResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.geno.ReferencesApi;

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
public class ReferencesApiController implements ReferencesApi {

    private static final Logger log = LoggerFactory.getLogger(ReferencesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ReferencesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ReferencesListResponse> referencesGet(@ApiParam(value = "The ID of the `Reference` to be retrieved.") @Valid @RequestParam(value = "referenceDbId", required = false) String referenceDbId
,@ApiParam(value = "The ID of the `ReferenceSet` to be retrieved.") @Valid @RequestParam(value = "referenceSetDbId", required = false) String referenceSetDbId
,@ApiParam(value = "If set, return the reference sets for which the `accession` matches this string (case-sensitive, exact match).") @Valid @RequestParam(value = "accession", required = false) String accession
,@ApiParam(value = "If specified, return the references for which the `md5checksum` matches this string (case-sensitive, exact match).") @Valid @RequestParam(value = "md5checksum", required = false) String md5checksum
,@ApiParam(value = "If the reference is derived from a source sequence") @Valid @RequestParam(value = "isDerived", required = false) Boolean isDerived
,@ApiParam(value = "The minimum length of the reference sequences to be retrieved.") @Valid @RequestParam(value = "minLength", required = false) Integer minLength
,@ApiParam(value = "The maximum length of the reference sequences to be retrieved.") @Valid @RequestParam(value = "maxLength", required = false) Integer maxLength
,@ApiParam(value = "Used to request a specific page of data to be returned.  The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page
,@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ReferencesListResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"data\" : [ {\n      \"referenceDbId\" : \"referenceDbId\",\n      \"isDerived\" : true,\n      \"sourceURI\" : \"sourceURI\",\n      \"species\" : {\n        \"termURI\" : \"termURI\",\n        \"term\" : \"term\"\n      },\n      \"md5checksum\" : \"md5checksum\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"length\" : 0,\n      \"sourceDivergence\" : 6.0274563,\n      \"sourceAccessions\" : [ \"sourceAccessions\", \"sourceAccessions\" ],\n      \"referenceName\" : \"referenceName\"\n    }, {\n      \"referenceDbId\" : \"referenceDbId\",\n      \"isDerived\" : true,\n      \"sourceURI\" : \"sourceURI\",\n      \"species\" : {\n        \"termURI\" : \"termURI\",\n        \"term\" : \"term\"\n      },\n      \"md5checksum\" : \"md5checksum\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"length\" : 0,\n      \"sourceDivergence\" : 6.0274563,\n      \"sourceAccessions\" : [ \"sourceAccessions\", \"sourceAccessions\" ],\n      \"referenceName\" : \"referenceName\"\n    } ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", ReferencesListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ReferencesListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ReferencesListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ReferenceBasesResponse> referencesReferenceDbIdBasesGet(@ApiParam(value = "The ID of the `Reference` to be retrieved.",required=true) @PathVariable("referenceDbId") String referenceDbId
,@ApiParam(value = "The start position (0-based) of this query. Defaults to 0. Genomic positions are non-negative integers less than reference length. Requests spanning the join of circular genomes are represented as two requests one on each side of the join (position 0).") @Valid @RequestParam(value = "start", required = false) Integer start
,@ApiParam(value = "The end position (0-based, exclusive) of this query. Defaults to the length of this `Reference`.") @Valid @RequestParam(value = "end", required = false) Integer end
,@ApiParam(value = "The continuation token, which is used to page through large result sets. To get the next page of results, set this parameter to the value of `next_page_token` from the previous response.") @Valid @RequestParam(value = "pageToken", required = false) String pageToken
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ReferenceBasesResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"sequence\" : \"sequence\",\n    \"offset\" : 0,\n    \"nextPageToken\" : \"nextPageToken\"\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", ReferenceBasesResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ReferenceBasesResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ReferenceBasesResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ReferenceSingleResponse> referencesReferenceDbIdGet(@ApiParam(value = "The ID of the `Reference` to be retrieved.",required=true) @PathVariable("referenceDbId") String referenceDbId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ReferenceSingleResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"referenceDbId\" : \"referenceDbId\",\n    \"isDerived\" : true,\n    \"sourceURI\" : \"sourceURI\",\n    \"species\" : {\n      \"termURI\" : \"termURI\",\n      \"term\" : \"term\"\n    },\n    \"md5checksum\" : \"md5checksum\",\n    \"additionalInfo\" : {\n      \"key\" : \"additionalInfo\"\n    },\n    \"length\" : 0,\n    \"sourceDivergence\" : 6.0274563,\n    \"sourceAccessions\" : [ \"sourceAccessions\", \"sourceAccessions\" ],\n    \"referenceName\" : \"referenceName\"\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", ReferenceSingleResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ReferenceSingleResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ReferenceSingleResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
