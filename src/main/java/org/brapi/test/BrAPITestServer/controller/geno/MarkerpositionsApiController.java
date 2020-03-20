package org.brapi.test.BrAPITestServer.controller.geno;

import io.swagger.model.geno.MarkerPositionListResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.geno.MarkerpositionsApi;

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
public class MarkerpositionsApiController implements MarkerpositionsApi {

    private static final Logger log = LoggerFactory.getLogger(MarkerpositionsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public MarkerpositionsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<MarkerPositionListResponse> markerpositionsGet(@ApiParam(value = "unique id of a map") @Valid @RequestParam(value = "mapDbId", required = false) String mapDbId
,@ApiParam(value = "The chromosome identifier or the generic linkage group identifier if the chromosome is not applicable.") @Valid @RequestParam(value = "linkageGroupName", required = false) String linkageGroupName
,@ApiParam(value = "The unique id for a marker") @Valid @RequestParam(value = "variantDbId", required = false) String variantDbId
,@ApiParam(value = "The minimum position") @Valid @RequestParam(value = "minPosition", required = false) Integer minPosition
,@ApiParam(value = "The maximum position") @Valid @RequestParam(value = "maxPosition", required = false) Integer maxPosition
,@ApiParam(value = "Used to request a specific page of data to be returned.  The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page
,@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<MarkerPositionListResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"data\" : [ {\n      \"mapDbId\" : \"3d52bdf3\",\n      \"linkageGroupName\" : \"Chromosome 3\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"variantDbId\" : \"a1eb250a\",\n      \"mapName\" : \"Genome Map 1\",\n      \"position\" : 2390,\n      \"variantName\" : \"Marker_2390\"\n    }, {\n      \"mapDbId\" : \"3d52bdf3\",\n      \"linkageGroupName\" : \"Chromosome 3\",\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"variantDbId\" : \"a1eb250a\",\n      \"mapName\" : \"Genome Map 1\",\n      \"position\" : 2390,\n      \"variantName\" : \"Marker_2390\"\n    } ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", MarkerPositionListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<MarkerPositionListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<MarkerPositionListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
