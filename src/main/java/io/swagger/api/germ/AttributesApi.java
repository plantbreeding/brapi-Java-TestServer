/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.18).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api.germ;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.Model202AcceptedSearchResponse;
import io.swagger.model.germ.GermplasmAttributeCategoryListResponse;
import io.swagger.model.germ.GermplasmAttributeListResponse;
import io.swagger.model.germ.GermplasmAttributeNewRequest;
import io.swagger.model.germ.GermplasmAttributeSearchRequest;
import io.swagger.model.germ.GermplasmAttributeSingleResponse;
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
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
@Api(value = "attributes", description = "the attributes API")
public interface AttributesApi {

	@ApiOperation(value = "Get the details for a specific Germplasm Attribute", nickname = "attributesAttributeDbIdGet", notes = "Get the details for a specific Germplasm Attribute", response = GermplasmAttributeSingleResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Germplasm Attributes", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = GermplasmAttributeSingleResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/attributes/{attributeDbId}", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<GermplasmAttributeSingleResponse> attributesAttributeDbIdGet(
			@ApiParam(value = "The unique id for an attribute", required = true) @PathVariable("attributeDbId") String attributeDbId,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Update an existing Germplasm Attribute", nickname = "attributesAttributeDbIdPut", notes = "Update an existing Germplasm Attribute", response = GermplasmAttributeSingleResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Germplasm Attributes", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = GermplasmAttributeSingleResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/attributes/{attributeDbId}", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	ResponseEntity<GermplasmAttributeSingleResponse> attributesAttributeDbIdPut(
			@ApiParam(value = "The unique id for an attribute", required = true) @PathVariable("attributeDbId") String attributeDbId,
			@ApiParam(value = "") @Valid @RequestBody GermplasmAttributeNewRequest body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Get the Categories of Germplasm Attributes", nickname = "attributesCategoriesGet", notes = "List all available attribute categories.", response = GermplasmAttributeCategoryListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Germplasm Attributes", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = GermplasmAttributeCategoryListResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/attributes/categories", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<GermplasmAttributeCategoryListResponse> attributesCategoriesGet(
			@ApiParam(value = "page") @Valid @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "pageSize") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Get the Germplasm Attributes", nickname = "attributesGet", notes = "List available attributes.", response = GermplasmAttributeListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Germplasm Attributes", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = GermplasmAttributeListResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/attributes", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<GermplasmAttributeListResponse> attributesGet(
			@ApiParam(value = "attributeCategory") @Valid @RequestParam(value = "attributeCategory", required = false) String attributeCategory,
			@ApiParam(value = "attributeDbId") @Valid @RequestParam(value = "attributeDbId", required = false) String attributeDbId,
			@ApiParam(value = "attributeName") @Valid @RequestParam(value = "attributeName", required = false) String attributeName,
			@ApiParam(value = "germplasmDbId") @Valid @RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,
			@ApiParam(value = "externalReferenceId") @Valid @RequestParam(value = "externalReferenceId", required = false) String externalReferenceId,
			@ApiParam(value = "externalReferenceID") @Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@ApiParam(value = "externalReferenceSource") @Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@ApiParam(value = "page") @Valid @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "pageSize") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Create new Germplasm Attributes", nickname = "attributesPost", notes = "Create new Germplasm Attributes", response = GermplasmAttributeListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Germplasm Attributes", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = GermplasmAttributeListResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/attributes", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<GermplasmAttributeListResponse> attributesPost(
			@ApiParam(value = "") @Valid @RequestBody List<GermplasmAttributeNewRequest> body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Submit a search request for Germplasm Attributes", nickname = "searchAttributesPost", notes = "Search for a set of Germplasm Attributes based on some criteria          See Search Services for additional implementation details.", response = GermplasmAttributeListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Germplasm Attributes", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = GermplasmAttributeListResponse.class),
			@ApiResponse(code = 202, message = "Accepted", response = Model202AcceptedSearchResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/search/attributes", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<? extends BrAPIResponse> searchAttributesPost(
			@ApiParam(value = "") @Valid @RequestBody GermplasmAttributeSearchRequest body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Get the results of a Germplasm Attributes search request", nickname = "searchAttributesSearchResultsDbIdGet", notes = "Get the results of a Germplasm Attributes search request  See Search Services for additional implementation details.", response = GermplasmAttributeListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Germplasm Attributes", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = GermplasmAttributeListResponse.class),
			@ApiResponse(code = 202, message = "Accepted", response = Model202AcceptedSearchResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class),
			@ApiResponse(code = 404, message = "Not Found", response = String.class) })
	@RequestMapping(value = "/search/attributes/{searchResultsDbId}", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<? extends BrAPIResponse> searchAttributesSearchResultsDbIdGet(
			@ApiParam(value = "Permanent unique identifier which references the search results", required = true) @PathVariable("searchResultsDbId") String searchResultsDbId,
			@ApiParam(value = "page") @Valid @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "pageSize") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

}