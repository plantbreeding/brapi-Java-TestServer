/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.0).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;

import io.swagger.model.NewScaleRequest;
import io.swagger.model.ScaleResponse;
import io.swagger.model.ScalesResponse;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List; import java.util.ArrayList;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

@Api(value = "scales", description = "the scales API")
public interface ScalesApi {

    @ApiOperation(value = "Get the Scales", nickname = "scalesGet", notes = "Returns a list of Scales available on a server.  An Observation Variable has 3 critical parts: A Trait being observed, a Method for making the observation, and a Scale on which the observation can be measured and compared with other observations.", response = ScalesResponse.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Observation Variables", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ScalesResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
        @ApiResponse(code = 403, message = "Forbidden", response = String.class) })
    @RequestMapping(value = "/scales",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<ScalesResponse> scalesGet(@ApiParam(value = "Which result page is requested. The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong>Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization) throws BrAPIServerException;


    @ApiOperation(value = "Add a new Scale", nickname = "scalesPost", notes = "Create a new scale object in the database", response = ScaleResponse.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Observation Variables", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ScaleResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
        @ApiResponse(code = 403, message = "Forbidden", response = String.class) })
    @RequestMapping(value = "/scales",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ScaleResponse> scalesPost(@ApiParam(value = ""  )  @Valid @RequestBody NewScaleRequest body,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong>Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization) throws BrAPIServerException;


    @ApiOperation(value = "Get the details of a specific Scale", nickname = "scalesScaleDbIdGet", notes = "Retrieve details about a specific scale  An Observation Variable has 3 critical parts: A Trait being observed, a Method for making the observation, and a Scale on which the observation can be measured and compared with other observations.", response = ScaleResponse.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Observation Variables", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ScaleResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
        @ApiResponse(code = 403, message = "Forbidden", response = String.class),
        @ApiResponse(code = 404, message = "Not Found", response = String.class) })
    @RequestMapping(value = "/scales/{scaleDbId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<ScaleResponse> scalesScaleDbIdGet(@ApiParam(value = "Id of the scale to retrieve details of.",required=true) @PathVariable("scaleDbId") String scaleDbId,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong>Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization) throws BrAPIServerException;


    @ApiOperation(value = "Update an existing Scale", nickname = "scalesScaleDbIdPut", notes = "Update the details of an existing scale", response = ScaleResponse.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Observation Variables", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ScaleResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
        @ApiResponse(code = 403, message = "Forbidden", response = String.class),
        @ApiResponse(code = 404, message = "Not Found", response = String.class) })
    @RequestMapping(value = "/scales/{scaleDbId}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<ScaleResponse> scalesScaleDbIdPut(@ApiParam(value = "Id of the scale to retrieve details of.",required=true) @PathVariable("scaleDbId") String scaleDbId,@ApiParam(value = ""  )  @Valid @RequestBody NewScaleRequest body,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong>Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization) throws BrAPIServerException;

}
