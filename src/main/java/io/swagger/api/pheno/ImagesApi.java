/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.18).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api.pheno;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.Model202AcceptedSearchResponse;
import io.swagger.model.pheno.ImageListResponse;
import io.swagger.model.pheno.ImageNewRequest;
import io.swagger.model.pheno.ImageSearchRequest;
import io.swagger.model.pheno.ImageSingleResponse;
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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
@Api(value = "images", description = "the images API")
public interface ImagesApi {

	@ApiOperation(value = "Get the image meta data summaries", nickname = "imagesGet", notes = "Get filtered set of image meta data  Implementation Notes  - ''imageURL'' should be a complete URL describing the location of the image. There is no BrAPI call for retrieving the image content, so it could be on a different path, or a different host.  - ''descriptiveOntologyTerm'' can be thought of as Tags for the image. These could be simple descriptive words, or ontology references, or full ontology URI''s.", response = ImageListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Images", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ImageListResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/images", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<ImageListResponse> imagesGet(
			@ApiParam(value = "The unique identifier for a image") @Valid @RequestParam(value = "imageDbId", required = false) String imageDbId,
			@ApiParam(value = "The human readable name of an image") @Valid @RequestParam(value = "imageName", required = false) String imageName,
			@ApiParam(value = "The unique identifier of the observation unit an image is portraying") @Valid @RequestParam(value = "observationUnitDbId", required = false) String observationUnitDbId,
			@ApiParam(value = "The unique identifier of the observation an image is associated with") @Valid @RequestParam(value = "observationDbId", required = false) String observationDbId,
			@ApiParam(value = "A descriptive term associated with an image") @Valid @RequestParam(value = "descriptiveOntologyTerm", required = false) String descriptiveOntologyTerm,
			@ApiParam(value = "Search for Germplasm by an external reference") @Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@ApiParam(value = "Search for Germplasm by an external reference") @Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@ApiParam(value = "Used to request a specific page of data to be returned.  The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Get the an image meta data summary", nickname = "imagesImageDbIdGet", notes = "Get one image meta data object  Implementation Notes  - ''imageURL'' should be a complete URL describing the location of the image. There is no BrAPI call for retrieving the image content, so it could be on a different path, or a different host.  - ''descriptiveOntologyTerm'' can be thought of as Tags for the image. These could be simple descriptive words, or ontology references, or full ontology URI''s.", response = ImageSingleResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Images", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ImageSingleResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class),
			@ApiResponse(code = 404, message = "Not Found", response = String.class) })
	@RequestMapping(value = "/images/{imageDbId}", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<ImageSingleResponse> imagesImageDbIdGet(
			@ApiParam(value = "The unique identifier for a image", required = true) @PathVariable("imageDbId") String imageDbId,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@RequestMapping(value = "/images/{imageDbId}/{imageName}", method = RequestMethod.GET)
	ResponseEntity<byte[]> imagesImageDbIdContentGet(
			@ApiParam(value = "The unique identifier for a image", required = true) @PathVariable("imageDbId") String imageDbId,
			@ApiParam(value = "The unique identifier for a image", required = true) @PathVariable("imageName") String imageName,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong>Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Update an image with the image file content", nickname = "imagesImageDbIdImagecontentPut", notes = "Update an image with the image file content  Implementation Notes  - This call should be paired with 'PUT /images/{imageDbId}' for full capability  - A server may choose to modify the image meta data object based on the actually image which has been uploaded.   - Image data may be stored in a database or file system. Servers should generate and provide the \"imageURL\" for retrieving the image, wherever it happens to live.", response = ImageSingleResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Images", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ImageSingleResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class),
			@ApiResponse(code = 404, message = "Not Found", response = String.class) })
	@RequestMapping(value = "/images/{imageDbId}/imagecontent", produces = { "application/json" }, consumes = {
			"image/*" }, method = RequestMethod.PUT)
	ResponseEntity<ImageSingleResponse> imagesImageDbIdImageContentPut(
			@ApiParam(value = "The unique identifier for a image", required = true) @PathVariable("imageDbId") String imageDbId,
			@ApiParam(value = "") @Valid @RequestBody byte[] body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Update an image meta data", nickname = "imagesImageDbIdPut", notes = "Update an image meta data object  Implementation Notes  - This call should be paired with 'PUT /images/{imageDbId}/imagecontent' for full capability  - A server may choose to modify the image meta data object based on the actually image which has been uploaded.   - Image data may be stored in a database or file system. Servers should generate and provide the \"imageURL\" as an absolute path for retrieving the image, wherever it happens to live.   - 'descriptiveOntologyTerm' can be thought of as Tags for the image. These could be simple descriptive words, or ontology references, or full ontology URI's.   - The '/images' calls support a GeoJSON object structure for describing their location. The BrAPI spec for GeoJSON only supports two of the possible geometries: Points and Polygons.   - With most images, the Point geometry should be used, and it should indicate the longitude and latitude of the camera.   - For top down images (ie from drones, cranes, etc), the Point geometry may be used to indicate the longitude and latitude of the centroid of the image content, and the Polygon geometry may be used to indicate the border of the image content.", response = ImageSingleResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Images", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ImageSingleResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class),
			@ApiResponse(code = 404, message = "Not Found", response = String.class) })
	@RequestMapping(value = "/images/{imageDbId}", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	ResponseEntity<ImageSingleResponse> imagesImageDbIdPut(
			@ApiParam(value = "The unique identifier for a image", required = true) @PathVariable("imageDbId") String imageDbId,
			@ApiParam(value = "") @Valid @RequestBody ImageNewRequest body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Create a new image meta data object", nickname = "imagesPost", notes = "Create a new image meta data object  Implementation Notes  - ''imageURL'' should be a complete URL describing the location of the image. There is no BrAPI call for retrieving the image content, so it could be on a different path, or a different host.  - ''descriptiveOntologyTerm'' can be thought of as Tags for the image. These could be simple descriptive words, or ontology references, or full ontology URI''s.  - The '/images' calls support a GeoJSON object structure for describing their location. The BrAPI spec for GeoJSON only supports two of the possible geometries: Points and Polygons.  - With most images, the Point geometry should be used, and it should indicate the longitude and latitude of the camera.  - For top down images (ie from drones, cranes, etc), the Point geometry may be used to indicate the longitude and latitude of the centroid of the image content, and the Polygon geometry may be used to indicate the border of the image content. '", response = ImageListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Images", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ImageListResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/images", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<ImageListResponse> imagesPost(@ApiParam(value = "") @Valid @RequestBody List<ImageNewRequest> body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Submit a search request for Images", nickname = "searchImagesPost", notes = "Get filtered set of image meta data  Implementation Notes  - ''imageURL'' should be a complete URL describing the location of the image. There is no BrAPI call for retrieving the image content, so it could be on a different path, or a different host.  - 'descriptiveOntologyTerm' can be thought of as Tags for the image. These could be simple descriptive words, or ontology references, or full ontology URI's.  See Search Services for additional implementation details.", response = ImageListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Images", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ImageListResponse.class),
			@ApiResponse(code = 202, message = "Accepted", response = Model202AcceptedSearchResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/search/images", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<? extends BrAPIResponse> searchImagesPost(
			@ApiParam(value = "") @Valid @RequestBody ImageSearchRequest body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Get the results of an Images search request", nickname = "searchImagesSearchResultsDbIdGet", notes = "Get filtered set of image meta data  Implementation Notes  - ''imageURL'' should be a complete URL describing the location of the image. There is no BrAPI call for retrieving the image content, so it could be on a different path, or a different host.  - ''descriptiveOntologyTerm'' can be thought of as Tags for the image. These could be simple descriptive words, or ontology references, or full ontology URI''s.", response = ImageListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Images", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ImageListResponse.class),
			@ApiResponse(code = 202, message = "Accepted", response = Model202AcceptedSearchResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class),
			@ApiResponse(code = 404, message = "Not Found", response = String.class) })
	@RequestMapping(value = "/search/images/{searchResultsDbId}", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<? extends BrAPIResponse> searchImagesSearchResultsDbIdGet(
			@ApiParam(value = "Permanent unique identifier which references the search results", required = true) @PathVariable("searchResultsDbId") String searchResultsDbId,
			@ApiParam(value = "Used to request a specific page of data to be returned.  The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

}
