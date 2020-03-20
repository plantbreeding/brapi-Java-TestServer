package org.brapi.test.BrAPITestServer.controller.germ;

import io.swagger.model.germ.GermplasmAttributeValueListResponse;
import io.swagger.model.germ.GermplasmAttributeValueNewRequest;
import io.swagger.model.germ.GermplasmAttributeValueSingleResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.germ.AttributevaluesApi;

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
public class AttributevaluesApiController implements AttributevaluesApi {

    private static final Logger log = LoggerFactory.getLogger(AttributevaluesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public AttributevaluesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<GermplasmAttributeValueSingleResponse> attributevaluesAttributeValueDbIdGet(@ApiParam(value = "The unique id for an attribute value",required=true) @PathVariable("attributeValueDbId") String attributeValueDbId
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GermplasmAttributeValueSingleResponse>(objectMapper.readValue("{\n  \"result\" : \"\",\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", GermplasmAttributeValueSingleResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GermplasmAttributeValueSingleResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GermplasmAttributeValueSingleResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GermplasmAttributeValueSingleResponse> attributevaluesAttributeValueDbIdPut(@ApiParam(value = "The unique id for an attribute value",required=true) @PathVariable("attributeValueDbId") String attributeValueDbId
,@ApiParam(value = ""  )  @Valid @RequestBody GermplasmAttributeValueNewRequest body
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GermplasmAttributeValueSingleResponse>(objectMapper.readValue("{\n  \"result\" : \"\",\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", GermplasmAttributeValueSingleResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GermplasmAttributeValueSingleResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GermplasmAttributeValueSingleResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GermplasmAttributeValueListResponse> attributevaluesGet(@ApiParam(value = "The unique id for an attribute value") @Valid @RequestParam(value = "attributeValueDbId", required = false) String attributeValueDbId
,@ApiParam(value = "The unique id for an attribute") @Valid @RequestParam(value = "attributeDbId", required = false) String attributeDbId
,@ApiParam(value = "The human readable name for an attribute") @Valid @RequestParam(value = "attributeName", required = false) String attributeName
,@ApiParam(value = "Get all attributes associated with this germplasm") @Valid @RequestParam(value = "germplasmDbId", required = false) String germplasmDbId
,@ApiParam(value = "Search for Germplasm by an external reference") @Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID
,@ApiParam(value = "Search for Germplasm by an external reference") @Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource
,@ApiParam(value = "Used to request a specific page of data to be returned.  The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page
,@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GermplasmAttributeValueListResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", GermplasmAttributeValueListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GermplasmAttributeValueListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GermplasmAttributeValueListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GermplasmAttributeValueListResponse> attributevaluesPost(@ApiParam(value = ""  )  @Valid @RequestBody List<GermplasmAttributeValueNewRequest> body
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GermplasmAttributeValueListResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", GermplasmAttributeValueListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GermplasmAttributeValueListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GermplasmAttributeValueListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
