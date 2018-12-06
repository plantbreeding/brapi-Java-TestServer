/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.0).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;

import io.swagger.model.GermplasmResponse;
import io.swagger.model.GermplasmSearchRequest;
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

@Api(value = "germplasm-search", description = "the germplasm-search API")
public interface GermplasmSearchApi {

    @ApiOperation(value = "Germplasm search through GET", nickname = "germplasmSearchGet", notes = "DEPRECATED in V1.3 - see GET /germplasm", response = GermplasmResponse.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Germplasm","Search Services", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = GermplasmResponse.class) })
    @RequestMapping(value = "/germplasm-search",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<GermplasmResponse> germplasmSearchGet(@ApiParam(value = "Permanent unique identifier (DOI, URI, etc.)") @Valid @RequestParam(value = "germplasmPUI", required = false) String germplasmPUI,@ApiParam(value = "Internal database identifier") @Valid @RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,@ApiParam(value = "Name of the germplasm") @Valid @RequestParam(value = "germplasmName", required = false) String germplasmName,@ApiParam(value = "The common crop name related to this germplasm") @Valid @RequestParam(value = "commonCropName", required = false) String commonCropName,@ApiParam(value = "Which result page is requested. The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize) throws BrAPIServerException;


    @ApiOperation(value = "Germplasm search through POST", nickname = "germplasmSearchPost", notes = "DEPRECATED in V1.3 - see POST /search/germplasm", response = GermplasmResponse.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Germplasm","Search Services", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = GermplasmResponse.class) })
    @RequestMapping(value = "/germplasm-search",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<GermplasmResponse> germplasmSearchPost(@ApiParam(value = ""  )  @Valid @RequestBody GermplasmSearchRequest body) throws BrAPIServerException;

}
