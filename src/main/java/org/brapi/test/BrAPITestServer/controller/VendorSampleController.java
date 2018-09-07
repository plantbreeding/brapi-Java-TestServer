package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.VendorSampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiParam;
import io.swagger.model.Metadata;
import io.swagger.model.VendorPlate;
import io.swagger.model.VendorPlateRequest;
import io.swagger.model.VendorPlateResponse;
import io.swagger.model.VendorPlateSearchRequest;
import io.swagger.model.VendorPlatesResponse;
import io.swagger.model.VendorPlatesResponseResult;
import io.swagger.model.VendorSpecification;
import io.swagger.model.VendorSpecificationResponse;
import io.swagger.api.VendorApi;

@RestController
public class VendorSampleController extends BrAPIController implements VendorApi {

	private VendorSampleService vendorSampleService;

	@Autowired
	public VendorSampleController(VendorSampleService sampleService) {
		this.vendorSampleService = sampleService;
	}

	@CrossOrigin
	@PreAuthorize("hasAuthority('ADMIN')")
	@Override
	public ResponseEntity<VendorPlatesResponse> vendorPlatesPost(
			@ApiParam(value = "") @Valid @RequestBody VendorPlateRequest request) {
		List<VendorPlate> plates = vendorSampleService.savePlates(request);

		VendorPlatesResponseResult result = new VendorPlatesResponseResult();
		result.setPlates(plates);
		VendorPlatesResponse response = new VendorPlatesResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<VendorPlatesResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<VendorPlatesResponse> vendorPlatesSearchGet(@Valid String vendorProjectDbId,
			@Valid String vendorPlateDbId, @Valid String clientPlateDbId, @Valid Boolean sampleInfo,
			@Valid Integer pageSize, @Valid Integer page) throws BrAPIServerException {
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<VendorPlate> plates = vendorSampleService.searchPlates(vendorProjectDbId, vendorPlateDbId, clientPlateDbId,
				sampleInfo, metadata);

		VendorPlatesResponseResult result = new VendorPlatesResponseResult();
		result.setPlates(plates);
		VendorPlatesResponse response = new VendorPlatesResponse();
		response.setMetadata(metadata);
		response.setResult(result);
		return new ResponseEntity<VendorPlatesResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<VendorPlatesResponse> vendorPlatesSearchPost(
			@Valid @RequestBody VendorPlateSearchRequest request) throws BrAPIServerException {
		Metadata metadata = generateMetaDataTemplate(request.getPage(), request.getPageSize());
		List<VendorPlate> plates = vendorSampleService.searchPlates(request, metadata);

		VendorPlatesResponseResult result = new VendorPlatesResponseResult();
		result.setPlates(plates);
		VendorPlatesResponse response = new VendorPlatesResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<VendorPlatesResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<VendorPlateResponse> vendorPlatesVendorPlateDbIdGet(
			@PathVariable("vendorPlateDbId") String vendorPlateDbId) {
		VendorPlate result = vendorSampleService.getPlate(vendorPlateDbId);

		VendorPlateResponse response = new VendorPlateResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<VendorPlateResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<VendorSpecificationResponse> vendorSpecificationsGet() {
		VendorSpecification result = vendorSampleService.getVendorSpec();

		VendorSpecificationResponse response = new VendorSpecificationResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<VendorSpecificationResponse>(response, HttpStatus.OK);
	}
}
