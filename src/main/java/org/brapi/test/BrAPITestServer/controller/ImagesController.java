package org.brapi.test.BrAPITestServer.controller;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.api.ImagesApi;
import io.swagger.model.ImageResponse;
import io.swagger.model.ImagesResponse;
import io.swagger.model.NewImageRequest;

@RestController
public class ImagesController extends BrAPIController implements ImagesApi {

	@Autowired
	public ImagesController() {
	}

	@Override
	public ResponseEntity<ImagesResponse> imagesGet(@Valid String imageDbId, @Valid String imageName,
			@Valid String observationUnitDbId, @Valid String observationDbId, @Valid String descriptiveOntologyTerm,
			@Valid Integer page, @Valid Integer pageSize, String authorization) throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ImageResponse> imagesImageDbIdGet(String imageDbId, String authorization)
			throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ImageResponse> imagesImageDbIdImagecontentPut(String imageDbId, @Valid Object body,
			String authorization) throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ImageResponse> imagesImageDbIdPut(String imageDbId, @Valid NewImageRequest body,
			String authorization) throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ImageResponse> imagesPost(@Valid NewImageRequest body, String authorization)
			throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
