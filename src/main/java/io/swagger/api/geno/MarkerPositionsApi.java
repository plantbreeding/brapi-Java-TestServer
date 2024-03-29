/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.18).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api.geno;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.Model202AcceptedSearchResponse;
import io.swagger.model.geno.MarkerPositionsListResponse;
import io.swagger.model.geno.MarkerPositionSearchRequest;
import io.swagger.annotations.*;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
@Api(value = "markerpositions", description = "the markerpositions API")
public interface MarkerPositionsApi {

	@ApiOperation(value = "Get marker position info", nickname = "markerpositionsGet", notes = "Get marker position information, based on Map, Linkage Group, and Marker ID", response = MarkerPositionsListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Genome Maps", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = MarkerPositionsListResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/markerpositions", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<MarkerPositionsListResponse> markerpositionsGet(
			@ApiParam(value = "unique id of a map") @Valid @RequestParam(value = "mapDbId", required = false) String mapDbId,
			@ApiParam(value = "The chromosome identifier or the generic linkage group identifier if the chromosome is not applicable.") @Valid @RequestParam(value = "linkageGroupName", required = false) String linkageGroupName,
			@ApiParam(value = "The unique id for a marker") @Valid @RequestParam(value = "variantDbId", required = false) String variantDbId,
			@ApiParam(value = "The minimum position") @Valid @RequestParam(value = "minPosition", required = false) Integer minPosition,
			@ApiParam(value = "The maximum position") @Valid @RequestParam(value = "maxPosition", required = false) Integer maxPosition,
			@ApiParam(value = "Used to request a specific page of data to be returned.  The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Get marker position info", nickname = "searchMarkerpositionsPost", notes = "Get marker position information, based on Map, Linkage Group, and Marker ID", response = MarkerPositionsListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Genome Maps", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = MarkerPositionsListResponse.class),
			@ApiResponse(code = 202, message = "Accepted", response = Model202AcceptedSearchResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/search/markerpositions", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<? extends BrAPIResponse> searchMarkerpositionsPost(
			@ApiParam(value = "") @Valid @RequestBody MarkerPositionSearchRequest body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Get marker position info", nickname = "searchMarkerpositionsSearchResultsDbIdGet", notes = "Get marker position information, based on Map, Linkage Group, and Marker ID", response = MarkerPositionsListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Genome Maps", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = MarkerPositionsListResponse.class),
			@ApiResponse(code = 202, message = "Accepted", response = Model202AcceptedSearchResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/search/markerpositions/{searchResultsDbId}", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<? extends BrAPIResponse> searchMarkerpositionsSearchResultsDbIdGet(
			@ApiParam(value = "Permanent unique identifier which references the search results", required = true) @PathVariable("searchResultsDbId") String searchResultsDbId,
			@ApiParam(value = "Used to request a specific page of data to be returned.  The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

}
