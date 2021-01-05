/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.18).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api.core;

import io.swagger.model.Model202AcceptedSearchResponse;
import io.swagger.model.core.ListNewRequest;
import io.swagger.model.core.ListResponse;
import io.swagger.model.core.ListSearchRequest;
import io.swagger.model.core.ListTypes;
import io.swagger.model.core.ListsListResponse;
import io.swagger.model.core.ListsSingleResponse;
import io.swagger.annotations.*;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
@Api(value = "lists", description = "the lists API")
public interface ListsApi {

	@ApiOperation(value = "Get filtered set of generic lists", nickname = "listsGet", notes = "Get filtered set of generic lists", response = ListsListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Lists", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ListsListResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/lists", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<ListsListResponse> listsGet(
			@ApiParam(value = "The type of objects contained by this generic list") @Valid @RequestParam(value = "listType", required = false) String listType,
			@ApiParam(value = "The human readable name of this generic list") @Valid @RequestParam(value = "listName", required = false) String listName,
			@ApiParam(value = "The unique ID of this generic list") @Valid @RequestParam(value = "listDbId", required = false) String listDbId,
			@ApiParam(value = "The source tag of this generic list") @Valid @RequestParam(value = "listSource", required = false) String listSource,
			@ApiParam(value = "Search for Germplasm by an external reference") @Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@ApiParam(value = "Search for Germplasm by an external reference") @Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@ApiParam(value = "Used to request a specific page of data to be returned.  The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Get the details of a specific List", nickname = "listsListDbIdGet", notes = "Get a specific generic lists", response = ListsSingleResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Lists", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ListsSingleResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class),
			@ApiResponse(code = 404, message = "Not Found", response = String.class) })
	@RequestMapping(value = "/lists/{listDbId}", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<ListsSingleResponse> listsListDbIdGet(
			@ApiParam(value = "The unique ID of this generic list", required = true) @PathVariable("listDbId") String listDbId,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Add Items to a specific List", nickname = "listsListDbIdItemsPost", notes = "Add new data to a specific generic lists", response = ListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Lists", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ListResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class),
			@ApiResponse(code = 404, message = "Not Found", response = String.class) })
	@RequestMapping(value = "/lists/{listDbId}/items", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<ListResponse> listsListDbIdItemsPost(
			@ApiParam(value = "The unique ID of this generic list", required = true) @PathVariable("listDbId") String listDbId,
			@ApiParam(value = "") @Valid @RequestBody ArrayList<String> body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Update an existing generic list", nickname = "listsListDbIdPut", notes = "Update an existing generic list", response = ListsSingleResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Lists", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ListsSingleResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class),
			@ApiResponse(code = 404, message = "Not Found", response = String.class) })
	@RequestMapping(value = "/lists/{listDbId}", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	ResponseEntity<ListsSingleResponse> listsListDbIdPut(
			@ApiParam(value = "The unique ID of this generic list", required = true) @PathVariable("listDbId") String listDbId,
			@ApiParam(value = "") @Valid @RequestBody ListNewRequest body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Create a New List", nickname = "listsPost", notes = "Create a new list", response = ListsListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Lists", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ListsListResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/lists", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<ListsListResponse> listsPost(@ApiParam(value = "") @Valid @RequestBody List<ListNewRequest> body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Submit a search request for Lists", nickname = "searchListsPost", notes = "Advanced searching for the list resource. See Search Services for additional implementation details.", response = ListsListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Lists", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ListsListResponse.class),
			@ApiResponse(code = 202, message = "Accepted", response = Model202AcceptedSearchResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/search/lists", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<ListsListResponse> searchListsPost(@ApiParam(value = "") @Valid @RequestBody ListSearchRequest body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException;

	@ApiOperation(value = "Get the results of a List search request", nickname = "searchListsSearchResultsDbIdGet", notes = "Advanced searching for the list resource. See Search Services for additional implementation details.", response = ListsListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Lists", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ListsListResponse.class),
			@ApiResponse(code = 202, message = "Accepted", response = Model202AcceptedSearchResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/search/lists/{searchResultsDbId}", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<ListsListResponse> searchListsSearchResultsDbIdGet(
			@ApiParam(value = "Permanent unique identifier which references the search results", required = true) @PathVariable("searchResultsDbId") String searchResultsDbId,
			@ApiParam(value = "Used to request a specific page of data to be returned.  The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException;

}
