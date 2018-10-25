/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.0).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;

import io.swagger.model.ImageResponse;
import io.swagger.model.ImagesResponse;
import io.swagger.model.NewImageRequest;
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

@Api(value = "images", description = "the images API")
public interface ImagesApi {

    @ApiOperation(value = "Get the image meta data summaries", nickname = "imagesGet", notes = "Get filtered set of image meta data  Implementation Notes  - 'imageURL' should be a complete URL decribing the location of the image. There is no BrAPI call for retireiving the image content, so it could be on a different path, or a different host.  - 'descriptiveOntologyTerm' can be thought of as Tags for the image. These could be simple descriptive words, or ontology references, or full ontology URI's.  ", response = ImagesResponse.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Images", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ImagesResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
        @ApiResponse(code = 403, message = "Forbidden", response = String.class) })
    @RequestMapping(value = "/images",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<ImagesResponse> imagesGet(@ApiParam(value = "The unique identifier for a image") @Valid @RequestParam(value = "imageDbId", required = false) String imageDbId,@ApiParam(value = "The human readable name of an image") @Valid @RequestParam(value = "imageName", required = false) String imageName,@ApiParam(value = "The unique identifier of the observation unit an image is portraying") @Valid @RequestParam(value = "observationUnitDbId", required = false) String observationUnitDbId,@ApiParam(value = "The unique identifier of the observation an image is accosiated with") @Valid @RequestParam(value = "observationDbId", required = false) String observationDbId,@ApiParam(value = "A descriptive term associated with an image") @Valid @RequestParam(value = "descriptiveOntologyTerm", required = false) String descriptiveOntologyTerm,@ApiParam(value = "Which result page is requested. The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong>Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization) throws BrAPIServerException;


    @ApiOperation(value = "Get the an image meta data summary", nickname = "imagesImageDbIdGet", notes = "Get one image meta data object  Implementation Notes  - 'imageURL' should be a complete URL decribing the location of the image. There is no BrAPI call for retireiving the image content, so it could be on a different path, or a different host.  - 'descriptiveOntologyTerm' can be thought of as Tags for the image. These could be simple descriptive words, or ontology references, or full ontology URI's. ", response = ImageResponse.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Images", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ImageResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
        @ApiResponse(code = 403, message = "Forbidden", response = String.class),
        @ApiResponse(code = 404, message = "Not Found", response = String.class) })
    @RequestMapping(value = "/images/{imageDbId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<ImageResponse> imagesImageDbIdGet(@ApiParam(value = "The unique identifier for a image",required=true) @PathVariable("imageDbId") String imageDbId,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong>Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization) throws BrAPIServerException;


    @ApiOperation(value = "Update an image with the image file content", nickname = "imagesImageDbIdImagecontentPut", notes = "Update an image with the image file content  Implementation Notes  - This call should be paired with 'PUT /images/{imageDbId}' for full capability  - A server may choose to modify the image meta data object based on the actually image which has been uploaded.   - Image data may be stored in a database or file system. Servers should generate and provide the \"imageURL\" for retrieving the image, wherever it happens to live.  ", response = ImageResponse.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Images", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ImageResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
        @ApiResponse(code = 403, message = "Forbidden", response = String.class),
        @ApiResponse(code = 404, message = "Not Found", response = String.class) })
    @RequestMapping(value = "/images/{imageDbId}/imagecontent",
        produces = { "application/json" }, 
        consumes = { "image/_*" },
        method = RequestMethod.PUT)
    ResponseEntity<ImageResponse> imagesImageDbIdImagecontentPut(@ApiParam(value = "The unique identifier for a image",required=true) @PathVariable("imageDbId") String imageDbId,@ApiParam(value = ""  )  @Valid @RequestBody Object body,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong>Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization) throws BrAPIServerException;


    @ApiOperation(value = "Update an image meta data", nickname = "imagesImageDbIdPut", notes = "Update an image meta data object  Implementation Notes  - This call should be paired with 'PUT /images/{imageDbId}/imagecontent' for full capability  - A server may choose to modify the image meta data object based on the actually image which has been uploaded.   - Image data may be stored in a database or file system. Servers should generate and provide the \"imageURL\" as an absolute path for retrieving the image, wherever it happens to live.   - 'descriptiveOntologyTerm' can be thought of as Tags for the image. These could be simple descriptive words, or ontology references, or full ontology URI's. ", response = ImageResponse.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Images", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ImageResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
        @ApiResponse(code = 403, message = "Forbidden", response = String.class),
        @ApiResponse(code = 404, message = "Not Found", response = String.class) })
    @RequestMapping(value = "/images/{imageDbId}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<ImageResponse> imagesImageDbIdPut(@ApiParam(value = "The unique identifier for a image",required=true) @PathVariable("imageDbId") String imageDbId,@ApiParam(value = ""  )  @Valid @RequestBody NewImageRequest body,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong>Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization) throws BrAPIServerException;


    @ApiOperation(value = "Create a new image meta data object", nickname = "imagesPost", notes = "Create a new image meta data object  Implementation Notes  - 'imageURL' should be a complete URL decribing the location of the image. There is no BrAPI call for retireiving the image content, so it could be on a different path, or a different host.  - 'descriptiveOntologyTerm' can be thought of as Tags for the image. These could be simple descriptive words, or ontology references, or full ontology URI's. ", response = ImageResponse.class, authorizations = {
        @Authorization(value = "AuthorizationToken")
    }, tags={ "Images", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ImageResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
        @ApiResponse(code = 403, message = "Forbidden", response = String.class) })
    @RequestMapping(value = "/images",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ImageResponse> imagesPost(@ApiParam(value = ""  )  @Valid @RequestBody NewImageRequest body,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong>Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization) throws BrAPIServerException;

}
