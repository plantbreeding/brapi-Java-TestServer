package org.brapi.test.BrAPITestServer.controller.core;

import org.threeten.bp.LocalDate;
import io.swagger.model.core.TrialListResponse;
import io.swagger.model.core.TrialNewRequest;
import io.swagger.model.core.TrialSingleResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.core.TrialsApi;

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
public class TrialsApiController implements TrialsApi {

    private static final Logger log = LoggerFactory.getLogger(TrialsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TrialsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<TrialListResponse> trialsGet(@ApiParam(value = "Filter active status true/false.") @Valid @RequestParam(value = "active", required = false) Boolean active
,@ApiParam(value = "Common name for the crop associated with this trial") @Valid @RequestParam(value = "commonCropName", required = false) String commonCropName
,@ApiParam(value = "Contact entities associated with this trial") @Valid @RequestParam(value = "contactDbId", required = false) String contactDbId
,@ApiParam(value = "Program filter to only return trials associated with given program id.") @Valid @RequestParam(value = "programDbId", required = false) String programDbId
,@ApiParam(value = "Filter by location") @Valid @RequestParam(value = "locationDbId", required = false) String locationDbId
,@ApiParam(value = "The start of the overlapping search date range. `searchDateRangeStart` must be before `searchDateRangeEnd`.  Return a Trial entity if any of the following cases are true  - `searchDateRangeStart` is before `trial.endDate` AND `searchDateRangeEnd` is null   - `searchDateRangeStart` is before `trial.endDate` AND `searchDateRangeEnd` is after `trial.startDate`  - `searchDateRangeEnd` is after `trial.startDate` AND `searchDateRangeStart` is null  - `searchDateRangeEnd` is after `trial.startDate` AND `searchDateRangeStart` is before `trial.endDate`") @Valid @RequestParam(value = "searchDateRangeStart", required = false) LocalDate searchDateRangeStart
,@ApiParam(value = "The start of the overlapping search date range. `searchDateRangeStart` must be before `searchDateRangeEnd`.  Return a Trial entity if any of the following cases are true  - `searchDateRangeStart` is before `trial.endDate` AND `searchDateRangeEnd` is null   - `searchDateRangeStart` is before `trial.endDate` AND `searchDateRangeEnd` is after `trial.startDate`  - `searchDateRangeEnd` is after `trial.startDate` AND `searchDateRangeStart` is null  - `searchDateRangeEnd` is after `trial.startDate` AND `searchDateRangeStart` is before `trial.endDate`") @Valid @RequestParam(value = "searchDateRangeEnd", required = false) LocalDate searchDateRangeEnd
,@ApiParam(value = "Filter by connected studyDbId") @Valid @RequestParam(value = "studyDbId", required = false) String studyDbId
,@ApiParam(value = "Filter by trialDbId") @Valid @RequestParam(value = "trialDbId", required = false) String trialDbId
,@ApiParam(value = "Filter by trial name") @Valid @RequestParam(value = "trialName", required = false) String trialName
,@ApiParam(value = "Filter by trial PUI") @Valid @RequestParam(value = "trialPUI", required = false) String trialPUI
,@ApiParam(value = "Sort order. Name of the field to sort by.", allowableValues = "trialDbId, trialName, programDbId, programName, locationDbId, startDate, endDate") @Valid @RequestParam(value = "sortBy", required = false) String sortBy
,@ApiParam(value = "Sort order direction: asc/desc", allowableValues = "asc, ASC, desc, DESC") @Valid @RequestParam(value = "sortOrder", required = false) String sortOrder
,@ApiParam(value = "Search for Germplasm by an external reference") @Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID
,@ApiParam(value = "Search for Germplasm by an external reference") @Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource
,@ApiParam(value = "Used to request a specific page of data to be returned.  The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page
,@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<TrialListResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", TrialListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<TrialListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<TrialListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<TrialListResponse> trialsPost(@ApiParam(value = ""  )  @Valid @RequestBody List<TrialNewRequest> body
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<TrialListResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", TrialListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<TrialListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<TrialListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<TrialSingleResponse> trialsTrialDbIdGet(@ApiParam(value = "The internal trialDbId",required=true) @PathVariable("trialDbId") String trialDbId
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<TrialSingleResponse>(objectMapper.readValue("{\n  \"result\" : \"\",\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", TrialSingleResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<TrialSingleResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<TrialSingleResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<TrialSingleResponse> trialsTrialDbIdPut(@ApiParam(value = "The internal trialDbId",required=true) @PathVariable("trialDbId") String trialDbId
,@ApiParam(value = ""  )  @Valid @RequestBody TrialNewRequest body
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<TrialSingleResponse>(objectMapper.readValue("{\n  \"result\" : \"\",\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", TrialSingleResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<TrialSingleResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<TrialSingleResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
