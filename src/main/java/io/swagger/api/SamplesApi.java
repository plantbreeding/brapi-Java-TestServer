/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.0).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;

import io.swagger.model.NewSampleDbId;
import io.swagger.model.Sample;
import io.swagger.model.SampleResponse;
import io.swagger.model.SamplesResponse;
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

@Api(value = "samples", description = "the samples API")
public interface SamplesApi {

    @ApiOperation(value = "Get the Samples", nickname = "samplesGet", notes = "Used to retrieve list of Samples from a Sample Tracking system based on some search criteria.", response = SamplesResponse.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Samples", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = SamplesResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
        @ApiResponse(code = 403, message = "Forbidden", response = String.class) })
    @RequestMapping(value = "/samples",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<SamplesResponse> samplesGet(@ApiParam(value = "the internal DB id for a sample") @Valid @RequestParam(value = "sampleDbId", required = false) String sampleDbId,@ApiParam(value = "the internal DB id for an observation unit where a sample was taken from") @Valid @RequestParam(value = "observationUnitDbId", required = false) String observationUnitDbId,@ApiParam(value = "the internal DB id for a plate of samples") @Valid @RequestParam(value = "plateDbId", required = false) String plateDbId,@ApiParam(value = "the internal DB id for a germplasm") @Valid @RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,@ApiParam(value = "Which result page is requested. The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong>Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization) throws BrAPIServerException;


    @ApiOperation(value = "Add a new Sample", nickname = "samplesPut", notes = "Call to register the event of a sample being taken. Sample ID is assigned as a result of the operation and returned in response.", response = NewSampleDbId.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Samples", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = NewSampleDbId.class),
        @ApiResponse(code = 400, message = "Bad Request", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
        @ApiResponse(code = 403, message = "Forbidden", response = String.class) })
    @RequestMapping(value = "/samples",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<NewSampleDbId> samplesPut(@ApiParam(value = ""  )  @Valid @RequestBody Sample body,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong>Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization) throws BrAPIServerException;


    @ApiOperation(value = "Get the details of a specific Sample", nickname = "samplesSampleDbIdGet", notes = "Used to retrieve the details of a single Sample from a Sample Tracking system.", response = SampleResponse.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Samples", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = SampleResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
        @ApiResponse(code = 403, message = "Forbidden", response = String.class),
        @ApiResponse(code = 404, message = "Not Found", response = String.class) })
    @RequestMapping(value = "/samples/{sampleDbId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<SampleResponse> samplesSampleDbIdGet(@ApiParam(value = "the internal DB id for a sample",required=true) @PathVariable("sampleDbId") String sampleDbId,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong>Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization) throws BrAPIServerException;

}
