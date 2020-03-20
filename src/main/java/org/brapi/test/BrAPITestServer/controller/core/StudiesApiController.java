package org.brapi.test.BrAPITestServer.controller.core;

import io.swagger.model.core.StudyListResponse;
import io.swagger.model.core.StudyNewRequest;
import io.swagger.model.core.StudySingleResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.core.StudiesApi;

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
public class StudiesApiController implements StudiesApi {

    private static final Logger log = LoggerFactory.getLogger(StudiesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public StudiesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<StudyListResponse> studiesGet(@ApiParam(value = "Common name for the crop associated with this study") @Valid @RequestParam(value = "commonCropName", required = false) String commonCropName
,@ApiParam(value = "Filter based on study type unique identifier") @Valid @RequestParam(value = "studyType", required = false) String studyType
,@ApiParam(value = "Program filter to only return studies associated with given program id.") @Valid @RequestParam(value = "programDbId", required = false) String programDbId
,@ApiParam(value = "Filter by location") @Valid @RequestParam(value = "locationDbId", required = false) String locationDbId
,@ApiParam(value = "Filter by season or year") @Valid @RequestParam(value = "seasonDbId", required = false) String seasonDbId
,@ApiParam(value = "Filter by trial") @Valid @RequestParam(value = "trialDbId", required = false) String trialDbId
,@ApiParam(value = "Filter by study DbId") @Valid @RequestParam(value = "studyDbId", required = false) String studyDbId
,@ApiParam(value = "Filter by study name") @Valid @RequestParam(value = "studyName", required = false) String studyName
,@ApiParam(value = "Filter by study code") @Valid @RequestParam(value = "studyCode", required = false) String studyCode
,@ApiParam(value = "Filter by study PUI") @Valid @RequestParam(value = "studyPUI", required = false) String studyPUI
,@ApiParam(value = "Filter by germplasm DbId") @Valid @RequestParam(value = "germplasmDbId", required = false) String germplasmDbId
,@ApiParam(value = "Filter by observation variable DbId") @Valid @RequestParam(value = "observationVariableDbId", required = false) String observationVariableDbId
,@ApiParam(value = "Filter active status true/false.") @Valid @RequestParam(value = "active", required = false) Boolean active
,@ApiParam(value = "Name of the field to sort by.", allowableValues = "studyDbId, trialDbId, programDbId, locationDbId, seasonDbId, studyType, studyName, studyLocation, programName") @Valid @RequestParam(value = "sortBy", required = false) String sortBy
,@ApiParam(value = "Sort order direction. Ascending/Descending.", allowableValues = "asc, ASC, desc, DESC") @Valid @RequestParam(value = "sortOrder", required = false) String sortOrder
,@ApiParam(value = "Search for Germplasm by an external reference") @Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID
,@ApiParam(value = "Search for Germplasm by an external reference") @Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource
,@ApiParam(value = "Used to request a specific page of data to be returned.  The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page
,@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<StudyListResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", StudyListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<StudyListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<StudyListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<StudyListResponse> studiesPost(@ApiParam(value = ""  )  @Valid @RequestBody List<StudyNewRequest> body
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<StudyListResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", StudyListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<StudyListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<StudyListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<StudySingleResponse> studiesStudyDbIdGet(@ApiParam(value = "Identifier of the study. Usually a number, could be alphanumeric.",required=true) @PathVariable("studyDbId") String studyDbId
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<StudySingleResponse>(objectMapper.readValue("{\n  \"result\" : \"\",\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", StudySingleResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<StudySingleResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<StudySingleResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<StudySingleResponse> studiesStudyDbIdPut(@ApiParam(value = "Identifier of the study. Usually a number, could be alphanumeric.",required=true) @PathVariable("studyDbId") String studyDbId
,@ApiParam(value = ""  )  @Valid @RequestBody StudyNewRequest body
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<StudySingleResponse>(objectMapper.readValue("{\n  \"result\" : \"\",\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", StudySingleResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<StudySingleResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<StudySingleResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
