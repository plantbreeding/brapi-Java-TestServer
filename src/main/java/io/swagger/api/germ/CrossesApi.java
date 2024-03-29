/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.18).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api.germ;

import io.swagger.model.germ.CrossNewRequest;
import io.swagger.model.germ.CrossesListResponse;
import io.swagger.annotations.*;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
@Api(value = "crosses", description = "the crosses API")
public interface CrossesApi {

	@ApiOperation(value = "Get a filtered list of Cross entities", nickname = "crossesGet", notes = "Get a filtered list of Cross entities.", response = CrossesListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Crosses", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = CrossesListResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/crosses", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<CrossesListResponse> crossesGet(
			@ApiParam(value = "crossingProjectDbId") @Valid @RequestParam(value = "crossingProjectDbId", required = false) String crossingProjectDbId,
			@ApiParam(value = "crossingProjectName") @Valid @RequestParam(value = "crossingProjectName", required = false) String crossingProjectName,
			@ApiParam(value = "crossDbId") @Valid @RequestParam(value = "crossDbId", required = false) String crossDbId,
			@ApiParam(value = "crossName") @Valid @RequestParam(value = "crossName", required = false) String crossName,
			@ApiParam(value = "commonCropName") @Valid @RequestParam(value = "commonCropName", required = false) String commonCropName,
			@ApiParam(value = "programDbId") @Valid @RequestParam(value = "programDbId", required = false) String programDbId,
			@ApiParam(value = "externalReferenceID") @Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@ApiParam(value = "externalReferenceId") @Valid @RequestParam(value = "externalReferenceId", required = false) String externalReferenceId,
			@ApiParam(value = "externalReferenceSource") @Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@ApiParam(value = "page") @Valid @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "pageSize") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Create new Cross entities on this server", nickname = "crossesPost", notes = "Create new Cross entities on this server", response = CrossesListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Crosses", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = CrossesListResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/crosses", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<CrossesListResponse> crossesPost(
			@ApiParam(value = "") @Valid @RequestBody List<CrossNewRequest> body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Update existing Cross entities on this server", nickname = "crossesPut", notes = "Update existing Cross entities on this server", response = CrossesListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Crosses", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = CrossesListResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/crosses", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	ResponseEntity<CrossesListResponse> crossesPut(
			@ApiParam(value = "") @Valid @RequestBody Map<String, CrossNewRequest> body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

}
