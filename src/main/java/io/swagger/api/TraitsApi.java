/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.0).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;

import io.swagger.model.NewTraitRequest;
import io.swagger.model.TraitResponse;
import io.swagger.model.TraitSummaryResponse;
import io.swagger.model.TraitsResponse;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

@Api(value = "traits", description = "the traits API")
public interface TraitsApi {

    @ApiOperation(value = "Get the Traits", nickname = "traitsGet", notes = "Call to retrieve a list of traits available in the system and their associated variables.  An Observation Variable has 3 critical parts: A Trait being observed, a Method for making the observation, and a Scale on which the observation can be measured and compared with other observations.", response = TraitsResponse.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Observation Variables", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = TraitsResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
        @ApiResponse(code = 403, message = "Forbidden", response = String.class) })
    @RequestMapping(value = "/traits",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<TraitsResponse> traitsGet(@ApiParam(value = "Which result page is requested. The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong>Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization) throws BrAPIServerException;


    @ApiOperation(value = "Add a new Trait", nickname = "traitsPost", notes = "Create a new trait object in the database", response = TraitResponse.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Observation Variables", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = TraitResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
        @ApiResponse(code = 403, message = "Forbidden", response = String.class) })
    @RequestMapping(value = "/traits",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<TraitResponse> traitsPost(@ApiParam(value = ""  )  @Valid @RequestBody NewTraitRequest body,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong>Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization) throws BrAPIServerException;


    @ApiOperation(value = "Get the details of a specific Trait", nickname = "traitsTraitDbIdGet", notes = "Retrieve the details of a single trait  An Observation Variable has 3 critical parts: A Trait being observed, a Method for making the observation, and a Scale on which the observation can be measured and compared with other observations.", response = TraitSummaryResponse.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Observation Variables", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = TraitSummaryResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
        @ApiResponse(code = 403, message = "Forbidden", response = String.class),
        @ApiResponse(code = 404, message = "Not Found", response = String.class) })
    @RequestMapping(value = "/traits/{traitDbId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<TraitSummaryResponse> traitsTraitDbIdGet(@ApiParam(value = "Id of the trait to retrieve details of.",required=true) @PathVariable("traitDbId") String traitDbId,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong>Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization) throws BrAPIServerException;


    @ApiOperation(value = "Update an existing Trait", nickname = "traitsTraitDbIdPut", notes = "Update an existing trait", response = TraitResponse.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Observation Variables", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = TraitResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
        @ApiResponse(code = 403, message = "Forbidden", response = String.class),
        @ApiResponse(code = 404, message = "Not Found", response = String.class) })
    @RequestMapping(value = "/traits/{traitDbId}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<TraitResponse> traitsTraitDbIdPut(@ApiParam(value = "Id of the trait to retrieve details of.",required=true) @PathVariable("traitDbId") String traitDbId,@ApiParam(value = ""  )  @Valid @RequestBody NewTraitRequest body,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong>Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization) throws BrAPIServerException;

}
