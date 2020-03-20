package org.brapi.test.BrAPITestServer.controller.germ;

import io.swagger.model.germ.Body;
import io.swagger.model.germ.SeedLotListResponse;
import io.swagger.model.germ.SeedLotNewRequest;
import io.swagger.model.germ.SeedLotSingleResponse;
import io.swagger.model.germ.SeedLotTransactionListResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.germ.SeedlotsApi;

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
public class SeedlotsApiController implements SeedlotsApi {

    private static final Logger log = LoggerFactory.getLogger(SeedlotsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SeedlotsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<SeedLotListResponse> seedlotsGet(@ApiParam(value = "Unique id for a seed lot on this server") @Valid @RequestParam(value = "seedLotDbId", required = false) String seedLotDbId
,@ApiParam(value = "The internal id of the germplasm") @Valid @RequestParam(value = "germplasmDbId", required = false) String germplasmDbId
,@ApiParam(value = "Search for Germplasm by an external reference") @Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID
,@ApiParam(value = "Search for Germplasm by an external reference") @Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource
,@ApiParam(value = "Used to request a specific page of data to be returned.  The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page
,@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<SeedLotListResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", SeedLotListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<SeedLotListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SeedLotListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<SeedLotListResponse> seedlotsPost(@ApiParam(value = ""  )  @Valid @RequestBody List<SeedLotNewRequest> body
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<SeedLotListResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", SeedLotListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<SeedLotListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SeedLotListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<SeedLotSingleResponse> seedlotsSeedLotDbIdGet(@ApiParam(value = "Unique id for a seed lot on this server",required=true) @PathVariable("seedLotDbId") String seedLotDbId
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<SeedLotSingleResponse>(objectMapper.readValue("{\n  \"result\" : \"\",\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", SeedLotSingleResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<SeedLotSingleResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SeedLotSingleResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<SeedLotSingleResponse> seedlotsSeedLotDbIdPut(@ApiParam(value = "Unique id for a seed lot on this server",required=true) @PathVariable("seedLotDbId") String seedLotDbId
,@ApiParam(value = ""  )  @Valid @RequestBody SeedLotNewRequest body
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<SeedLotSingleResponse>(objectMapper.readValue("{\n  \"result\" : \"\",\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", SeedLotSingleResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<SeedLotSingleResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SeedLotSingleResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<SeedLotTransactionListResponse> seedlotsSeedLotDbIdTransactionsGet(@ApiParam(value = "Unique id for a seed lot on this server",required=true) @PathVariable("seedLotDbId") String seedLotDbId
,@ApiParam(value = "Unique id for a Transaction that has occured") @Valid @RequestParam(value = "transactionDbId", required = false) String transactionDbId
,@ApiParam(value = "Filter results to only include transactions directed to the specific Seed Lot (TO), away from the specific Seed Lot (FROM), or both (BOTH). The default value for this parameter is BOTH", allowableValues = "TO, FROM, BOTH") @Valid @RequestParam(value = "transactionDirection", required = false) String transactionDirection
,@ApiParam(value = "Used to request a specific page of data to be returned.  The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page
,@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<SeedLotTransactionListResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", SeedLotTransactionListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<SeedLotTransactionListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SeedLotTransactionListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<SeedLotTransactionListResponse> seedlotsTransactionsGet(@ApiParam(value = "Unique id for a transaction on this server") @Valid @RequestParam(value = "transactionDbId", required = false) String transactionDbId
,@ApiParam(value = "Unique id for a seed lot on this server") @Valid @RequestParam(value = "seedLotDbId", required = false) String seedLotDbId
,@ApiParam(value = "The internal id of the germplasm") @Valid @RequestParam(value = "germplasmDbId", required = false) String germplasmDbId
,@ApiParam(value = "Search for Germplasm by an external reference") @Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID
,@ApiParam(value = "Search for Germplasm by an external reference") @Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource
,@ApiParam(value = "Used to request a specific page of data to be returned.  The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page
,@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<SeedLotTransactionListResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", SeedLotTransactionListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<SeedLotTransactionListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SeedLotTransactionListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<SeedLotTransactionListResponse> seedlotsTransactionsPost(@ApiParam(value = ""  )  @Valid @RequestBody Body body
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<SeedLotTransactionListResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", SeedLotTransactionListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<SeedLotTransactionListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SeedLotTransactionListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
