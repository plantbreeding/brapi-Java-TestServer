/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.18).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api.germ;

import io.swagger.model.germ.BreedingMethodListResponse;
import io.swagger.model.germ.BreedingMethodSingleResponse;
import io.swagger.annotations.*;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
@Api(value = "breedingmethods", description = "the breedingmethods API")
public interface BreedingMethodsApi {

	@ApiOperation(value = "Get the details of a specific Breeding Method", nickname = "breedingmethodsBreedingMethodDbIdGet", notes = "Get the details of a specific Breeding Method used to produce Germplasm", response = BreedingMethodSingleResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Germplasm", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = BreedingMethodSingleResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class),
			@ApiResponse(code = 404, message = "Not Found", response = String.class) })
	@RequestMapping(value = "/breedingmethods/{breedingMethodDbId}", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<BreedingMethodSingleResponse> breedingmethodsBreedingMethodDbIdGet(
			@ApiParam(value = "Internal database identifier for a breeding method", required = true) @PathVariable("breedingMethodDbId") String breedingMethodDbId,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Get the Breeding Methods", nickname = "breedingmethodsGet", notes = "Get the list of germplasm breeding methods available in a system.", response = BreedingMethodListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Germplasm", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = BreedingMethodListResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/breedingmethods", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<BreedingMethodListResponse> breedingmethodsGet(
			@ApiParam(value = "page") @Valid @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "pageSize") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

}
