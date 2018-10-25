package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.api.CommoncropnamesApi;
import io.swagger.api.CropsApi;
import io.swagger.model.CommonCropNamesResponse;
import io.swagger.model.CommonCropNamesResponseResult;
import io.swagger.model.Metadata;

@RestController
public class CropController extends BrAPIController implements CropsApi, CommoncropnamesApi {
	CropService cropService;

	@Autowired
	public CropController(CropService cropService) {
		this.cropService = cropService;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<CommonCropNamesResponse> cropsGet(@Valid Integer pageSize, @Valid Integer page) throws BrAPIServerException {
		return commoncropnamesGet(pageSize, page, null);
	}
	
	@CrossOrigin
	@Override
	public ResponseEntity<CommonCropNamesResponse> commoncropnamesGet(@Valid Integer page, @Valid Integer pageSize,
			String authorization) throws BrAPIServerException {

		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<String> crops = cropService.getCrops(metaData);

		CommonCropNamesResponseResult result = new CommonCropNamesResponseResult();
		result.setData(crops);
		CommonCropNamesResponse response = new CommonCropNamesResponse();
		response.setMetadata(metaData);
		response.setResult(result);

		return new ResponseEntity<CommonCropNamesResponse>(response, HttpStatus.OK);
	}

}
