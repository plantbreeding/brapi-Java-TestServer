/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.0).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;

import io.swagger.model.CommonCropNamesResponse;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

@Api(value = "crops", description = "the crops API")
public interface CropsApi {

    @ApiOperation(value = "List supported crops", nickname = "cropsGet", notes = "For multi crop systems this is a useful call to list all the supported crops.   test-server.brapi.org/brapi/v1/crops", response = CommonCropNamesResponse.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Crops","Deprecated", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = CommonCropNamesResponse.class) })
    @RequestMapping(value = "/crops",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<CommonCropNamesResponse> cropsGet(@ApiParam(value = "Which result page is requested. The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize) throws BrAPIServerException;

}