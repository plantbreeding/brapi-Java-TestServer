package org.brapi.test.BrAPITestServer.controller.pheno;

import io.swagger.model.pheno.EventsResponse;
import org.threeten.bp.OffsetDateTime;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.pheno.EventsApi;

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
public class EventsApiController implements EventsApi {

    private static final Logger log = LoggerFactory.getLogger(EventsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public EventsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<EventsResponse> eventsGet(@ApiParam(value = "Filter based on study unique identifier in which the events occured") @Valid @RequestParam(value = "studyDbId", required = false) String studyDbId
,@ApiParam(value = "Filter based on an ObservationUnit unique identifier in which the events occured") @Valid @RequestParam(value = "observationUnitDbId", required = false) String observationUnitDbId
,@ApiParam(value = "Filter based on an Event Type") @Valid @RequestParam(value = "eventType", required = false) String eventType
,@ApiParam(value = "Filter based on an Date Range") @Valid @RequestParam(value = "dateRangeStart", required = false) OffsetDateTime dateRangeStart
,@ApiParam(value = "Filter based on an Date Range") @Valid @RequestParam(value = "dateRangeEnd", required = false) OffsetDateTime dateRangeEnd
,@ApiParam(value = "Used to request a specific page of data to be returned.  The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page
,@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<EventsResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"data\" : [ {\n      \"date\" : [ \"2018-10-08T18:15:11Z\", \"2018-11-09T18:16:12Z\" ],\n      \"eventDbId\" : \"8566d4cb\",\n      \"observationUnitDbIds\" : [ \"8439eaff\", \"d7682e7a\", \"305ae51c\" ],\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"eventDescription\" : \"A set of plots was watered\",\n      \"eventParameters\" : [ {\n        \"key\" : \"http://www.example.fr/vocabulary/2018#hasContact,\",\n        \"value\" : \"http://www.example.fr/id/agent/marie,\",\n        \"valueRdfType\" : \"http://xmlns.com/foaf/0.1/Agent,\"\n      }, {\n        \"key\" : \"fertilizer\",\n        \"value\" : \"nitrogen\"\n      } ],\n      \"eventType\" : \"Watering\",\n      \"eventTypeDbId\" : \"4e7d691e\",\n      \"studyDbId\" : \"2cc2001f\"\n    }, {\n      \"date\" : [ \"2018-10-08T18:15:11Z\", \"2018-11-09T18:16:12Z\" ],\n      \"eventDbId\" : \"8566d4cb\",\n      \"observationUnitDbIds\" : [ \"8439eaff\", \"d7682e7a\", \"305ae51c\" ],\n      \"additionalInfo\" : {\n        \"key\" : \"additionalInfo\"\n      },\n      \"eventDescription\" : \"A set of plots was watered\",\n      \"eventParameters\" : [ {\n        \"key\" : \"http://www.example.fr/vocabulary/2018#hasContact,\",\n        \"value\" : \"http://www.example.fr/id/agent/marie,\",\n        \"valueRdfType\" : \"http://xmlns.com/foaf/0.1/Agent,\"\n      }, {\n        \"key\" : \"fertilizer\",\n        \"value\" : \"nitrogen\"\n      } ],\n      \"eventType\" : \"Watering\",\n      \"eventTypeDbId\" : \"4e7d691e\",\n      \"studyDbId\" : \"2cc2001f\"\n    } ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", EventsResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<EventsResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<EventsResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
