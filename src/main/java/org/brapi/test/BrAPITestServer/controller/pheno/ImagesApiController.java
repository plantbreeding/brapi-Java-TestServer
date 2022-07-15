package org.brapi.test.BrAPITestServer.controller.pheno;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.Metadata;
import io.swagger.model.pheno.Image;
import io.swagger.model.pheno.ImageDeleteResponse;
import io.swagger.model.pheno.ImageDeleteResponseResult;
import io.swagger.model.pheno.ImageListResponse;
import io.swagger.model.pheno.ImageListResponseResult;
import io.swagger.model.pheno.ImageNewRequest;
import io.swagger.model.pheno.ImageSearchRequest;
import io.swagger.model.pheno.ImageSingleResponse;
import io.swagger.api.pheno.ImagesApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity.SearchRequestTypes;
import org.brapi.test.BrAPITestServer.service.SearchService;
import org.brapi.test.BrAPITestServer.service.pheno.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
@Controller
public class ImagesApiController extends BrAPIController implements ImagesApi {

	private static final Logger log = LoggerFactory.getLogger(ImagesApiController.class);

	private final ImageService imageService;
	private final SearchService searchService;
	private final HttpServletRequest request;

	@Autowired
	public ImagesApiController(ImageService imageService, SearchService searchService, HttpServletRequest request) {
		this.imageService = imageService;
		this.searchService = searchService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ImageListResponse> imagesGet(
			@RequestParam(value = "imageDbId", required = false) String imageDbId,
			@RequestParam(value = "imageName", required = false) String imageName,
			@RequestParam(value = "observationUnitDbId", required = false) String observationUnitDbId,
			@RequestParam(value = "observationDbId", required = false) String observationDbId,
			@RequestParam(value = "descriptiveOntologyTerm", required = false) String descriptiveOntologyTerm,
			@RequestParam(value = "commonCropName", required = false) String commonCropName,
			@RequestParam(value = "programDbId", required = false) String programDbId,
			@RequestParam(value = "externalReferenceId", required = false) String externalReferenceId,
			@RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<Image> data = imageService.findImages(imageDbId, imageName, observationUnitDbId, observationDbId,
				descriptiveOntologyTerm, commonCropName, programDbId, externalReferenceId, externalReferenceID,
				externalReferenceSource, metadata);
		return responseOK(new ImageListResponse(), new ImageListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ImageSingleResponse> imagesImageDbIdGet(@PathVariable("imageDbId") String imageDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Image data = imageService.getImage(imageDbId);
		return responseOK(new ImageSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<byte[]> imagesImageDbIdContentGet(@PathVariable("imageDbId") String imageDbId,
			@PathVariable("imageName") String imageName,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");

		byte[] data = imageService.getImageData(imageDbId);
		Image image = imageService.getImage(imageDbId);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType(image.getMimeType()));
		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		return new ResponseEntity<byte[]>(data, headers, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ImageSingleResponse> imagesImageDbIdImageContentPut(
			@PathVariable("imageDbId") String imageDbId, @RequestBody byte[] body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		Image data = imageService.updateImageContent(imageDbId, request.getRequestURL().toString(), body);
		return responseOK(new ImageSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ImageSingleResponse> imagesImageDbIdPut(@PathVariable("imageDbId") String imageDbId,
			@RequestBody ImageNewRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		Image data = imageService.updateImage(imageDbId, body);
		return responseOK(new ImageSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ImageListResponse> imagesPost(@RequestBody List<ImageNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		List<Image> data = imageService.saveImages(body);
		return responseOK(new ImageListResponse(), new ImageListResponseResult(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchImagesPost(@RequestBody ImageSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body);

		String searchReqDbId = searchService.saveSearchRequest(body, SearchRequestTypes.IMAGES);
		if (searchReqDbId != null) {
			return responseAccepted(searchReqDbId);
		} else {
			List<Image> data = imageService.findImages(body, metadata);
			return responseOK(new ImageListResponse(), new ImageListResponseResult(), data, metadata);
		}
	}

	@CrossOrigin
	@Override
	public ResponseEntity<? extends BrAPIResponse> searchImagesSearchResultsDbIdGet(
			@PathVariable("searchResultsDbId") String searchResultsDbId,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		SearchRequestEntity request = searchService.findById(searchResultsDbId);
		if (request != null) {
			ImageSearchRequest body = request.getParameters(ImageSearchRequest.class);
			List<Image> data = imageService.findImages(body, metadata);
			return responseOK(new ImageListResponse(), new ImageListResponseResult(), data, metadata);
		} else {
			return responseAccepted(searchResultsDbId);
		}
	}

	@Override
	public ResponseEntity<ImageDeleteResponse> deleteImagesPost(
			@RequestHeader(value = "Authorization", required = false) String authorization,
			@RequestBody ImageSearchRequest body) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body);

		List<String> data = imageService.deleteImages(body, metadata);
		return responseOK(new ImageDeleteResponse(), new ImageDeleteResponseResult(), data, metadata);

	}

}
