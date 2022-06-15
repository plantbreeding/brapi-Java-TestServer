/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.34).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api.geno;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.Model202AcceptedSearchResponse;
import io.swagger.model.geno.PlateListResponse;
import io.swagger.model.geno.PlateNewRequest;
import io.swagger.model.geno.PlateSearchRequest;
import io.swagger.model.geno.PlateSingleResponse;
import io.swagger.model.geno.SampleSearchRequest;
import jakarta.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import io.swagger.annotations.*;

import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-06-02T18:30:00.206Z[GMT]")
@Validated
public interface PlatesApi {

	@ApiOperation(value = "Get a filtered list of Plates.", notes = "Get a filtered list of Plates. Each Plate is a collection of samples that are physically grouped together.", authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Plates", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = PlateListResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/plates", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<PlateListResponse> platesGet(
			@ApiParam(value = "sampleDbId") @Valid @RequestParam(value = "sampleDbId", required = false) String sampleDbId,
			@ApiParam(value = "sampleName") @Valid @RequestParam(value = "sampleName", required = false) String sampleName,
			@ApiParam(value = "sampleGroupDbId") @Valid @RequestParam(value = "sampleGroupDbId", required = false) String sampleGroupDbId,
			@ApiParam(value = "observationUnitDbId") @Valid @RequestParam(value = "observationUnitDbId", required = false) String observationUnitDbId,
			@ApiParam(value = "plateDbId") @Valid @RequestParam(value = "plateDbId", required = false) String plateDbId,
			@ApiParam(value = "plateName") @Valid @RequestParam(value = "plateName", required = false) String plateName,
			@ApiParam(value = "germplasmDbId") @Valid @RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,
			@ApiParam(value = "studyDbId") @Valid @RequestParam(value = "studyDbId", required = false) String studyDbId,
			@ApiParam(value = "trialDbId") @Valid @RequestParam(value = "trialDbId", required = false) String trialDbId,
			@ApiParam(value = "commonCropName") @Valid @RequestParam(value = "commonCropName", required = false) String commonCropName,
			@ApiParam(value = "programDbId") @Valid @RequestParam(value = "programDbId", required = false) String programDbId,
			@ApiParam(value = "externalReferenceID") @Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@ApiParam(value = "externalReferenceId") @Valid @RequestParam(value = "externalReferenceId", required = false) String externalReferenceId,
			@ApiParam(value = "externalReferenceSource") @Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@ApiParam(value = "page") @Valid @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "pageSize") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Get the details of a specific Plate.", notes = "Get the details of a specific Plate. Each Plate is a collection of samples that are physically grouped together.", authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Plates", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = PlateSingleResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class),
			@ApiResponse(code = 404, message = "Not Found", response = String.class) })
	@RequestMapping(value = "/plates/{plateDbId}", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<PlateSingleResponse> platesPlateDbIdGet(
			@ApiParam(value = "the internal DB id for a plate", required = true) @PathVariable("plateDbId") String plateDbId,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Submit new Plate entities to the server", notes = "Submit new Plate entities to the server", authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Plates", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = PlateListResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/plates", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<PlateListResponse> platesPost(@ApiParam(value = "") @Valid @RequestBody List<PlateNewRequest> body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Update the details of existing Plates", notes = "Update the details of existing Plates", authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Plates", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = PlateListResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class),
			@ApiResponse(code = 404, message = "Not Found", response = String.class) })
	@RequestMapping(value = "/plates", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	ResponseEntity<PlateListResponse> platesPut(@ApiParam(value = "") @Valid @RequestBody Map<String, PlateNewRequest> body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Submit a search request for `Plates`", notes = "Submit a search request for `Plates`<br/> Search requests allow a client to send a complex query for data. However, the server may not respond with the search results immediately.  If a server needs more time to process the request, it might respond with a `searchResultsDbId`.  Use the corresponding `GET /search/plates/{searchResultsDbId}` to retrieve the results of the search. <br/>  Review the <a target=\"_blank\" href=\"https://wiki.brapi.org/index.php/Search_Services#POST_Search_Entity\">Search Services documentation</a> for additional implementation details.", authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Plates", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = PlateListResponse.class),
			@ApiResponse(code = 202, message = "Accepted", response = Model202AcceptedSearchResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/search/plates", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<? extends BrAPIResponse> searchPlatesPost(
			@ApiParam(value = "") @Valid @RequestBody PlateSearchRequest body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Get the results of a `Plates` search request", notes = "Get the results of a `Plates` search request <br/> Clients should submit a search request using the corresponding `POST /search/plates` endpoint. Search requests allow a client to send a complex query for data. However, the server may not respond with the search results immediately.  If a server needs more time to process the request, it might respond with a `searchResultsDbId`.  Use this endpoint to retrieve the results of the search. <br/>  Review the <a target=\"_blank\" href=\"https://wiki.brapi.org/index.php/Search_Services#POST_Search_Entity\">Search Services documentation</a> for additional implementation details.", authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Plates", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = PlateListResponse.class),
			@ApiResponse(code = 202, message = "Accepted", response = Model202AcceptedSearchResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class),
			@ApiResponse(code = 404, message = "Not Found", response = String.class) })
	@RequestMapping(value = "/search/plates/{searchResultsDbId}", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<? extends BrAPIResponse> searchPlatesSearchResultsDbIdGet(
			@ApiParam(value = "Permanent unique identifier which references the search results", required = true) @PathVariable("searchResultsDbId") String searchResultsDbId,
			@ApiParam(value = "page") @Valid @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "pageSize") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

}
