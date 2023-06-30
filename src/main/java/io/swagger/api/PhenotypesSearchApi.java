/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.0).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;

import io.swagger.model.ObservationUnitsResponse;
import io.swagger.model.ObservationUnitsTableResponse1;
import io.swagger.model.PhenotypesSearchRequest;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

@Api(value = "phenotypes-search", description = "the phenotypes-search API")
public interface PhenotypesSearchApi {

    @ApiOperation(value = "Phenotype Search CSV", nickname = "phenotypesSearchCsvPost", notes = "DEPRECATED in v1.3 - See /search/observationtables", authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Phenotypes","Search Services", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK") })
    @RequestMapping(value = "/phenotypes-search/csv",
        produces = { "application/json", "text/csv" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<String> phenotypesSearchCsvPost(@ApiParam(value = ""  )  @Valid @RequestBody PhenotypesSearchRequest body) throws BrAPIServerException;


    @ApiOperation(value = "Phenotype Search", nickname = "phenotypesSearchGet", notes = "DEPRECATED in v1.3 - See GET /observationunits", response = ObservationUnitsResponse.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Phenotypes","Search Services", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ObservationUnitsResponse.class) })
    @RequestMapping(value = "/phenotypes-search",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<ObservationUnitsResponse> phenotypesSearchGet(@ApiParam(value = "The name or synonym of external genebank accession identifiers") @Valid @RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,@ApiParam(value = "The ID of traits, could be ontology ID, database ID or PUI") @Valid @RequestParam(value = "observationVariableDbId", required = false) String observationVariableDbId,@ApiParam(value = "The database ID / PK of the studies search parameter") @Valid @RequestParam(value = "studyDbId", required = false) String studyDbId,@ApiParam(value = "locations these traits were collected") @Valid @RequestParam(value = "locationDbId", required = false) String locationDbId,@ApiParam(value = "trial to search across") @Valid @RequestParam(value = "trialDbId", required = false) String trialDbId,@ApiParam(value = "program that have phenotyped this trait") @Valid @RequestParam(value = "programDbId", required = false) String programDbId,@ApiParam(value = "The year or Phenotyping campaign of a multi-annual study (trees, grape, ...)") @Valid @RequestParam(value = "seasonDbId", required = false) String seasonDbId,@ApiParam(value = "The type of the observationUnit. Returns only the observation unit of the specified type; the parent levels ID can be accessed through observationUnitStructure.") @Valid @RequestParam(value = "observationLevel", required = false) String observationLevel,@ApiParam(value = "Timestamp range start") @Valid @RequestParam(value = "observationTimeStampRangeStart", required = false) String observationTimeStampRangeStart,@ApiParam(value = "Timestamp range end") @Valid @RequestParam(value = "observationTimeStampRangeEnd", required = false) String observationTimeStampRangeEnd,@ApiParam(value = "Which result page is requested. The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize) throws BrAPIServerException;


    @ApiOperation(value = "Phenotype Search", nickname = "phenotypesSearchPost", notes = "DEPRECATED in v1.3 - See /search/observationunits", response = ObservationUnitsResponse.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Phenotypes","Search Services", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ObservationUnitsResponse.class) })
    @RequestMapping(value = "/phenotypes-search",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ObservationUnitsResponse> phenotypesSearchPost(@ApiParam(value = ""  )  @Valid @RequestBody PhenotypesSearchRequest body) throws BrAPIServerException;


    @ApiOperation(value = "Phenotype Search Table", nickname = "phenotypesSearchTablePost", notes = "DEPRECATED in v1.3 - See /search/observationtables", response = ObservationUnitsTableResponse1.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Phenotypes","Search Services", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ObservationUnitsTableResponse1.class) })
    @RequestMapping(value = "/phenotypes-search/table",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ObservationUnitsTableResponse1> phenotypesSearchTablePost(@ApiParam(value = ""  )  @Valid @RequestBody PhenotypesSearchRequest body) throws BrAPIServerException;


    @ApiOperation(value = "Phenotype Search TSV", nickname = "phenotypesSearchTsvPost", notes = "DEPRECATED in v1.3 - See /search/observationtables", authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Phenotypes","Search Services", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK") })
    @RequestMapping(value = "/phenotypes-search/tsv",
        produces = { "application/json", "text/csv" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<String> phenotypesSearchTsvPost(@ApiParam(value = ""  )  @Valid @RequestBody PhenotypesSearchRequest body) throws BrAPIServerException;

}
