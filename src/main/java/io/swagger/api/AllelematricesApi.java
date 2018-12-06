/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.0).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;

import io.swagger.model.AlleleMatrixDetailsResponse;
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

@Api(value = "allelematrices", description = "the allelematrices API")
public interface AllelematricesApi {

    @ApiOperation(value = "Get the Allele Matrix summaries", nickname = "allelematricesGet", notes = "This resource is used for reading and writing genomic matrices  GET provides a list of available matrices, optionally filtered by study;", response = AlleleMatrixDetailsResponse.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Marker Profiles", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = AlleleMatrixDetailsResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
        @ApiResponse(code = 403, message = "Forbidden", response = String.class) })
    @RequestMapping(value = "/allelematrices",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<AlleleMatrixDetailsResponse> allelematricesGet(@NotNull @ApiParam(value = "restricts the list of matrices to a specific study.", required = true) @Valid @RequestParam(value = "studyDbId", required = true) String studyDbId,@ApiParam(value = "Which result page is requested. The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong>Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization) throws BrAPIServerException;

}
