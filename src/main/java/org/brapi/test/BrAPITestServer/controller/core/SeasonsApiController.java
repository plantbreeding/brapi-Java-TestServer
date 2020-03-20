package org.brapi.test.BrAPITestServer.controller.core;

import io.swagger.model.core.Season;
import io.swagger.model.core.SeasonListResponse;
import io.swagger.model.core.SeasonSingleResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.core.SeasonsApi;

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
public class SeasonsApiController implements SeasonsApi {

    private static final Logger log = LoggerFactory.getLogger(SeasonsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SeasonsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<SeasonListResponse> seasonsGet(@ApiParam(value = "The unique identifier for a season. For backward compatibility it can be a string like '2012', '1957-2004'") @Valid @RequestParam(value = "seasonDbId", required = false) String seasonDbId
,@ApiParam(value = "The term to describe a given season. Example \"Spring\" OR \"May\" OR \"Planting_Time_7\".") @Valid @RequestParam(value = "season", required = false) String season
,@ApiParam(value = "The 4 digit year of a season. Example \"2017\"") @Valid @RequestParam(value = "year", required = false) Integer year
,@ApiParam(value = "Used to request a specific page of data to be returned.  The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page
,@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<SeasonListResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"data\" : [ {\n      \"year\" : 2018,\n      \"seasonName\" : \"Spring\",\n      \"seasonDbId\" : \"Spring_2018\"\n    }, {\n      \"year\" : 2018,\n      \"seasonName\" : \"Spring\",\n      \"seasonDbId\" : \"Spring_2018\"\n    } ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", SeasonListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<SeasonListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SeasonListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<SeasonListResponse> seasonsPost(@ApiParam(value = ""  )  @Valid @RequestBody List<Season> body
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<SeasonListResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"data\" : [ {\n      \"year\" : 2018,\n      \"seasonName\" : \"Spring\",\n      \"seasonDbId\" : \"Spring_2018\"\n    }, {\n      \"year\" : 2018,\n      \"seasonName\" : \"Spring\",\n      \"seasonDbId\" : \"Spring_2018\"\n    } ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", SeasonListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<SeasonListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SeasonListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<SeasonSingleResponse> seasonsSeasonDbIdGet(@ApiParam(value = "The unique identifier for a season. For backward compatibility it can be a string like '2012', '1957-2004'",required=true) @PathVariable("seasonDbId") String seasonDbId
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<SeasonSingleResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"year\" : 2018,\n    \"seasonName\" : \"Spring\",\n    \"seasonDbId\" : \"Spring_2018\"\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", SeasonSingleResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<SeasonSingleResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SeasonSingleResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<SeasonSingleResponse> seasonsSeasonDbIdPut(@ApiParam(value = "The unique identifier for a season. For backward compatibility it can be a string like '2012', '1957-2004'",required=true) @PathVariable("seasonDbId") String seasonDbId
,@ApiParam(value = ""  )  @Valid @RequestBody List<Season> body
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<SeasonSingleResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"year\" : 2018,\n    \"seasonName\" : \"Spring\",\n    \"seasonDbId\" : \"Spring_2018\"\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", SeasonSingleResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<SeasonSingleResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SeasonSingleResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
