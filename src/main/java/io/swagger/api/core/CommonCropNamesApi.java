/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.18).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api.core;

import io.swagger.model.core.CommonCropNamesResponse;
import jakarta.validation.Valid;
import io.swagger.annotations.*;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
@Api(value = "commoncropnames", description = "the commoncropnames API")
public interface CommonCropNamesApi {

	@ApiOperation(value = "Get the Common Crop Names", nickname = "commoncropnamesGet", notes = "List the common crop names for the crops available in a database server.   This call is ** required ** for multi-crop systems where data from multiple  crops may be stored in the same database server. A distinct database server  is defined by everything in the URL before \"/brapi/v2\", including host  name and base path.  This call is recommended for single crop systems to be compatible with  multi-crop clients. For a single crop system the response should contain  an array with exactly 1 element.   The common crop name can be used as a search parameter for Programs,  Studies, and Germplasm.", response = CommonCropNamesResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Common Crop Names", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = CommonCropNamesResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/commoncropnames", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<CommonCropNamesResponse> commoncropnamesGet(
			@ApiParam(value = "Used to request a specific page of data to be returned.  The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException;

}
