/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.0).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;

import io.swagger.model.SeasonsResponse;
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

@Api(value = "seasons", description = "the seasons API")
public interface SeasonsApi {

    @ApiOperation(value = "Get the Seasons", nickname = "seasonsGet", notes = "Call to retrive all seasons in the database.  A season is made of 2 parts  - The primary year   - A term which defines a segment of the year.  This could be a traditional season, like \"Spring\" or \"Summer\";  this could be a month, like \"May\" or \"June\";  or this could be an arbitrary season name which is meaningful to the breeding program like \"PlantingTime_3\" or \"Season E\"", response = SeasonsResponse.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Studies", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = SeasonsResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
        @ApiResponse(code = 403, message = "Forbidden", response = String.class) })
    @RequestMapping(value = "/seasons",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<SeasonsResponse> seasonsGet(@ApiParam(value = "The unique identifier for a season") @Valid @RequestParam(value = "seasonDbId", required = false) String seasonDbId,@ApiParam(value = "The term to describe a given season. Example \"Spring\" OR \"May\" OR \"PlantingTime7\"") @Valid @RequestParam(value = "season", required = false) String season,@ApiParam(value = "The 4 digit year of a season. Example \"2017\"") @Valid @RequestParam(value = "year", required = false) String year,@ApiParam(value = "Which result page is requested. The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong>Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization) throws BrAPIServerException;

}
