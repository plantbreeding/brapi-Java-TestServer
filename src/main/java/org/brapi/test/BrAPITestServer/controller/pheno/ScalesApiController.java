package org.brapi.test.BrAPITestServer.controller.pheno;

import io.swagger.model.pheno.ScaleBaseClass;
import io.swagger.model.pheno.ScaleListResponse;
import io.swagger.model.pheno.ScaleNewRequest;
import io.swagger.model.pheno.ScaleSingleResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.pheno.ScalesApi;

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
public class ScalesApiController implements ScalesApi {

    private static final Logger log = LoggerFactory.getLogger(ScalesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ScalesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ScaleListResponse> scalesGet(@ApiParam(value = "The unique identifier for a scale") @Valid @RequestParam(value = "scaleDbId", required = false) String scaleDbId
,@ApiParam(value = "The unique identifier for an observation variable") @Valid @RequestParam(value = "observationVariableDbId", required = false) String observationVariableDbId
,@ApiParam(value = "Search for Germplasm by an external reference") @Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID
,@ApiParam(value = "Search for Germplasm by an external reference") @Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource
,@ApiParam(value = "Used to request a specific page of data to be returned.  The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page
,@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ScaleListResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", ScaleListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ScaleListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ScaleListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ScaleListResponse> scalesPost(@ApiParam(value = ""  )  @Valid @RequestBody List<ScaleNewRequest> body
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ScaleListResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", ScaleListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ScaleListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ScaleListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ScaleSingleResponse> scalesScaleDbIdGet(@ApiParam(value = "Id of the scale to retrieve details of.",required=true) @PathVariable("scaleDbId") String scaleDbId
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ScaleSingleResponse>(objectMapper.readValue("{\n  \"result\" : \"\",\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", ScaleSingleResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ScaleSingleResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ScaleSingleResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ScaleSingleResponse> scalesScaleDbIdPut(@ApiParam(value = "Id of the scale to retrieve details of.",required=true) @PathVariable("scaleDbId") String scaleDbId
,@ApiParam(value = ""  )  @Valid @RequestBody ScaleBaseClass body
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ScaleSingleResponse>(objectMapper.readValue("{\n  \"result\" : \"\",\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", ScaleSingleResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ScaleSingleResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ScaleSingleResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
