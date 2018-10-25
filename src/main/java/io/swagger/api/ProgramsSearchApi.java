/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.0).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;

import io.swagger.model.ProgramsResponse;
import io.swagger.model.ProgramsSearchRequestDeprecated;
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
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-10-25T15:57:44.669-04:00[America/New_York]")

@Api(value = "programs-search", description = "the programs-search API")
public interface ProgramsSearchApi {

    @ApiOperation(value = "Search Programs", nickname = "programsSearchPost", notes = "DEPRECATED in v1.3 - see /search/programs", response = ProgramsResponse.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Programs","Search Services", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ProgramsResponse.class) })
    @RequestMapping(value = "/programs-search",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ProgramsResponse> programsSearchPost(@ApiParam(value = ""  )  @Valid @RequestBody ProgramsSearchRequestDeprecated body) throws BrAPIServerException;

}
