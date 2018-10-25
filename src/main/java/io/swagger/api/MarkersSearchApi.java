/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.0).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;

import io.swagger.model.MarkersResponse;
import io.swagger.model.MarkersSearchRequest;
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

@Api(value = "markers-search", description = "the markers-search API")
public interface MarkersSearchApi {

    @ApiOperation(value = "Markers Search (GET)", nickname = "markersSearchGet", notes = " Scope: CORE.  Status: ACCEPTED. Implemented by: Germinate See Search Services for additional implementation details. Other service requests use the servers internal `markerDbId`. This service returns marker records that provide the markerDbId. For the requested name or synonym, returns an array (possibly empty) of marker records that match the search criteria. - If there is none, an empty array is returned. - If there is one or more than one match, returns an array of all marker records that match the search criteria. ", response = MarkersResponse.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Markers", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = MarkersResponse.class) })
    @RequestMapping(value = "/markers-search",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<MarkersResponse> markersSearchGet(@ApiParam(value = "The database IDs of the markers to search for") @Valid @RequestParam(value = "markerDbIds", required = false) List<String> markerDbIds,@ApiParam(value = "The search pattern for a marker name or synonym. Examples: \"11_10002\" \"11_1%\" \"11_1*\" \"11_10?02\"") @Valid @RequestParam(value = "name", required = false) String name,@ApiParam(value = "Possible values are 'case_insensitive', 'exact' (case sensitive), 'wildcard' (which is case insensitive). Wildcard uses both '*' and '%' for any number of characters and '?' for one character matching. Default is exact.") @Valid @RequestParam(value = "matchMethod", required = false) String matchMethod,@ApiParam(value = "Whether to include synonyms in the output.") @Valid @RequestParam(value = "includeSynonyms", required = false) Boolean includeSynonyms,@ApiParam(value = "The type of the marker.") @Valid @RequestParam(value = "type", required = false) String type,@ApiParam(value = "Which result page is requested. The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize) throws BrAPIServerException;


    @ApiOperation(value = "Markers Search (POST)", nickname = "markersSearchPost", notes = " Scope: CORE.  Status: ACCEPTED. Implemented by: Germinate See Search Services for additional implementation details. Other service requests use the servers internal `markerDbId`. This service returns marker records that provide the markerDbId. For the requested name or synonym, returns an array (possibly empty) of marker records that match the search criteria. - If there is none, an empty array is returned. - If there is one or more than one match, returns an array of all marker records that match the search criteria. ", response = MarkersResponse.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Markers", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = MarkersResponse.class) })
    @RequestMapping(value = "/markers-search",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<MarkersResponse> markersSearchPost(@ApiParam(value = "The database IDs of the markers to search for"  )  @Valid @RequestBody MarkersSearchRequest body) throws BrAPIServerException;

}
