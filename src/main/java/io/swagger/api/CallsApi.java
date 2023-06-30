/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.0).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;

import io.swagger.model.CallsResponse;
import io.swagger.model.WSMIMEDataTypes;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

@Api(value = "calls", description = "the calls API")
public interface CallsApi {

    @ApiOperation(value = "Get the list of implemented Calls", nickname = "callsGet", notes = " Implementation Notes Having a consistent structure for the path string of each call is very important for teams to be able to connect and find errors. Read more on Github. Here are the rules for the path of each call that should be returned    Every word in the call path should match the documentation exactly, both in spelling and capitalization. Note that path strings are all lower case, but path parameters are camel case.  Each path should start relative to \"/\" and therefore should not include \"/\"  No leading or trailing slashes (\"/\")   Path parameters are wrapped in curly braces (\"{}\"). The name of the path parameter should be spelled exactly as it is specified in the documentation.     Examples GOOD    \"call\": \"germplasm/{germplasmDbId}/markerprofiles\" BAD    \"call\": \"germplasm/{id}/markerprofiles\" BAD    \"call\": \"germplasm/{germplasmDbId}/markerProfiles\" BAD    \"call\": \"germplasm/{germplasmdbid}/markerprofiles\" BAD    \"call\": \"brapi/v1/germplasm/{germplasmDbId}/markerprofiles\" BAD    \"call\": \"/germplasm/{germplasmDbId}/markerprofiles/\" BAD    \"call\": \"germplasm/<germplasmDbId>/markerprofiles\"    test-server.brapi.org/brapi/v1/calls", response = CallsResponse.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Calls", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = CallsResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
        @ApiResponse(code = 403, message = "Forbidden", response = String.class) })
    @RequestMapping(value = "/calls",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<CallsResponse> callsGet(@ApiParam(value = "DEPRECATED in v1.3 - see dataType (camel case)") @Valid @RequestParam(value = "datatype", required = false) String datatype,@ApiParam(value = "The data format supported by the call. Example: `json`") @Valid @RequestParam(value = "dataType", required = false) String dataType,@ApiParam(value = "Which result page is requested. The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong>Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization) throws BrAPIServerException;

}
