/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.18).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api.germ;

import io.swagger.model.germ.CrossingProjectsSingleResponse;
import io.swagger.model.germ.CrossingProjectNewRequest;
import io.swagger.model.germ.CrossingProjectsListResponse;
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
@Api(value = "crossingprojects", description = "the crossingprojects API")
public interface CrossingProjectsApi {

	@ApiOperation(value = "Get a filtered list of Crossing Projects", nickname = "crossingprojectsCrossingProjectDbIdGet", notes = "Get a filtered list of Crossing Projects.", response = CrossingProjectsSingleResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Crossing Projects", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = CrossingProjectsSingleResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/crossingprojects/{crossingProjectDbId}", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<CrossingProjectsSingleResponse> crossingProjectsCrossingProjectDbIdGet(
			@ApiParam(value = "Search for Crossing Projects with this unique id", required = true) @PathVariable("crossingProjectDbId") String crossingProjectDbId,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Update an existing Crossing Project", nickname = "crossingprojectsCrossingProjectDbIdPut", notes = "Update an existing Crossing Project entity on this server", response = CrossingProjectsSingleResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Crossing Projects", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = CrossingProjectsSingleResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/crossingprojects/{crossingProjectDbId}", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	ResponseEntity<CrossingProjectsSingleResponse> crossingProjectsCrossingProjectDbIdPut(
			@ApiParam(value = "Search for Crossing Projects with this unique id", required = true) @PathVariable("crossingProjectDbId") String crossingProjectDbId,
			@ApiParam(value = "") @Valid @RequestBody CrossingProjectNewRequest body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Get a filtered list of Crossing Projects", nickname = "crossingprojectsGet", notes = "Get a filtered list of Crossing Projects.", response = CrossingProjectsListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Crossing Projects", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = CrossingProjectsListResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/crossingprojects", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<CrossingProjectsListResponse> crossingProjectsGet(
			@ApiParam(value = "crossingProjectDbId") @Valid @RequestParam(value = "crossingProjectDbId", required = false) String crossingProjectDbId,
			@ApiParam(value = "crossingProjectName") @Valid @RequestParam(value = "crossingProjectName", required = false) String crossingProjectName,
			@ApiParam(value = "includePotentialParents") @Valid @RequestParam(value = "includePotentialParents", required = false) Boolean includePotentialParents,
			@ApiParam(value = "commonCropName") @Valid @RequestParam(value = "commonCropName", required = false) String commonCropName,
			@ApiParam(value = "programDbId") @Valid @RequestParam(value = "programDbId", required = false) String programDbId,
			@ApiParam(value = "externalReferenceID") @Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@ApiParam(value = "externalReferenceId") @Valid @RequestParam(value = "externalReferenceId", required = false) String externalReferenceId,
			@ApiParam(value = "externalReferenceSource") @Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@ApiParam(value = "page") @Valid @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "pageSize") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Create new Crossing Project entities on this server", nickname = "crossingprojectsPost", notes = "Create new Crossing Project entities on this server", response = CrossingProjectsListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Crossing Projects", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = CrossingProjectsListResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/crossingprojects", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<CrossingProjectsListResponse> crossingProjectsPost(
			@ApiParam(value = "") @Valid @RequestBody List<CrossingProjectNewRequest> body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

}
