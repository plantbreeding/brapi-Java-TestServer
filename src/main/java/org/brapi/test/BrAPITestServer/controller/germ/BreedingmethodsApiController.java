package org.brapi.test.BrAPITestServer.controller.germ;

import io.swagger.model.germ.BreedingMethodListResponse;
import io.swagger.model.germ.BreedingMethodSingleResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.germ.BreedingmethodsApi;

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
public class BreedingmethodsApiController implements BreedingmethodsApi {

    private static final Logger log = LoggerFactory.getLogger(BreedingmethodsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public BreedingmethodsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<BreedingMethodSingleResponse> breedingmethodsBreedingMethodDbIdGet(@ApiParam(value = "Internal database identifier for a breeding method",required=true) @PathVariable("breedingMethodDbId") String breedingMethodDbId
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BreedingMethodSingleResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"breedingMethodName\" : \"Male Backcross\",\n    \"description\" : \"Backcross to recover a specific gene.\",\n    \"abbreviation\" : \"MB\",\n    \"breedingMethodDbId\" : \"ffcce7ef\"\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", BreedingMethodSingleResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BreedingMethodSingleResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BreedingMethodSingleResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<BreedingMethodListResponse> breedingmethodsGet(@ApiParam(value = "Used to request a specific page of data to be returned.  The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page
,@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BreedingMethodListResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"data\" : [ {\n      \"breedingMethodName\" : \"Male Backcross\",\n      \"description\" : \"Backcross to recover a specific gene.\",\n      \"abbreviation\" : \"MB\",\n      \"breedingMethodDbId\" : \"ffcce7ef\"\n    }, {\n      \"breedingMethodName\" : \"Male Backcross\",\n      \"description\" : \"Backcross to recover a specific gene.\",\n      \"abbreviation\" : \"MB\",\n      \"breedingMethodDbId\" : \"ffcce7ef\"\n    } ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", BreedingMethodListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BreedingMethodListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BreedingMethodListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
