/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.0).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;

import io.swagger.model.ListResponse;
import io.swagger.model.ListSummaryResponse;
import io.swagger.model.ListTypes;
import io.swagger.model.NewListRequest;
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

@Api(value = "lists", description = "the lists API")
public interface ListsApi {

    @ApiOperation(value = "Get the List Summaries", nickname = "listsGet", notes = "Get filtered set of generic lists", response = ListSummaryResponse.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Lists", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ListSummaryResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
        @ApiResponse(code = 403, message = "Forbidden", response = String.class) })
    @RequestMapping(value = "/lists",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<ListSummaryResponse> listsGet(@ApiParam(value = "The type of objects contained by this generic list") @Valid @RequestParam(value = "listType", required = false) ListTypes listType,@ApiParam(value = "The human readable name of this generic list") @Valid @RequestParam(value = "listName", required = false) String listName,@ApiParam(value = "The unique ID of this generic list") @Valid @RequestParam(value = "listDbId", required = false) String listDbId,@ApiParam(value = "The source tag of this generic list") @Valid @RequestParam(value = "listSource", required = false) String listSource,@ApiParam(value = "Which result page is requested. The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong>Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization) throws BrAPIServerException;


    @ApiOperation(value = "Get the details of a specific List", nickname = "listsListDbIdGet", notes = "Get a specific generic lists", response = ListResponse.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Lists", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ListResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
        @ApiResponse(code = 403, message = "Forbidden", response = String.class),
        @ApiResponse(code = 404, message = "Not Found", response = String.class) })
    @RequestMapping(value = "/lists/{listDbId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<ListResponse> listsListDbIdGet(@ApiParam(value = "The unique ID of this generic list",required=true) @PathVariable("listDbId") String listDbId,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong>Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization) throws BrAPIServerException;


    @ApiOperation(value = "Add Items to a specific List", nickname = "listsListDbIdItemsPost", notes = "Add new data to a specific generic lists", response = ListResponse.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Lists", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ListResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
        @ApiResponse(code = 403, message = "Forbidden", response = String.class),
        @ApiResponse(code = 404, message = "Not Found", response = String.class) })
    @RequestMapping(value = "/lists/{listDbId}/items",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ListResponse> listsListDbIdItemsPost(@ApiParam(value = "The unique ID of this generic list",required=true) @PathVariable("listDbId") String listDbId,@ApiParam(value = ""  )  @Valid @RequestBody List<String> body,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong>Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization) throws BrAPIServerException;


    @ApiOperation(value = "Update a specific List", nickname = "listsListDbIdPut", notes = "Update an existing generic list", response = ListResponse.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Lists", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ListResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
        @ApiResponse(code = 403, message = "Forbidden", response = String.class),
        @ApiResponse(code = 404, message = "Not Found", response = String.class) })
    @RequestMapping(value = "/lists/{listDbId}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<ListResponse> listsListDbIdPut(@ApiParam(value = "The unique ID of this generic list",required=true) @PathVariable("listDbId") String listDbId,@ApiParam(value = ""  )  @Valid @RequestBody NewListRequest body,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong>Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization) throws BrAPIServerException;


    @ApiOperation(value = "Create a New List", nickname = "listsPost", notes = "Create a new list", response = ListResponse.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Lists", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ListResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
        @ApiResponse(code = 403, message = "Forbidden", response = String.class) })
    @RequestMapping(value = "/lists",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ListResponse> listsPost(@ApiParam(value = ""  )  @Valid @RequestBody NewListRequest body,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong>Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization) throws BrAPIServerException;

}
