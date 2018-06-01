package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.api.CommonCropNamesApi;
import io.swagger.api.CropsApi;
import io.swagger.model.CommonCropNamesResponse;
import io.swagger.model.CommonCropNamesResponseResult;
import io.swagger.model.Metadata;

@RestController
public class CropController  extends BrAPIController implements CropsApi, CommonCropNamesApi{
	CropService cropService;
	
	@Autowired
	public CropController(CropService cropService) {
		this.cropService = cropService;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<CommonCropNamesResponse> cropsGet(@Valid Integer pageSize, @Valid Integer page) {

		Metadata metaData = generateMetaDataTemplate(page, pageSize);
		List<String> crops = cropService.getCrops(metaData);

		CommonCropNamesResponseResult result = new CommonCropNamesResponseResult();
		result.setData(crops);
		CommonCropNamesResponse response = new CommonCropNamesResponse();
		response.setMetadata(metaData);
		response.setResult(result);
		
		return new ResponseEntity<CommonCropNamesResponse>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<CommonCropNamesResponse> commonCropNamesGet(@Valid Integer pageSize, @Valid Integer page) {

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
