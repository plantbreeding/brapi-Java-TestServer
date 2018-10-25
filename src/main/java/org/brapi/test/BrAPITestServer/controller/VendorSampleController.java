package org.brapi.test.BrAPITestServer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.VendorSampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.model.VendorOrderRequest;
import io.swagger.model.VendorOrderResponse;
import io.swagger.model.VendorOrderResultsResponse;
import io.swagger.model.VendorOrderStatusResponse;
import io.swagger.model.VendorOrdersResponse;
import io.swagger.model.VendorPlate;
import io.swagger.model.VendorPlateGetResponse;
import io.swagger.model.VendorPlateGetResponse1;
import io.swagger.model.VendorPlateResponse;
import io.swagger.model.VendorPlatesResponse;
import io.swagger.model.VendorPlatesSubmissionRequest;
import io.swagger.model.VendorPlatesSubmissionResponse;
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
	@Override
	public ResponseEntity<VendorOrdersResponse> vendorOrdersGet(@Valid String orderId, @Valid String submissionId,
			String authorization) throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<VendorPlatesResponse> vendorOrdersOrderIdPlatesGet(String orderId, String authorization)
			throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<VendorOrderResultsResponse> vendorOrdersOrderIdResultsGet(String orderId, String authorization)
			throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<VendorOrderStatusResponse> vendorOrdersOrderIdStatusGet(String orderId, String authorization)
			throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<VendorOrderResponse> vendorOrdersPost(@Valid VendorOrderRequest body, String authorization)
			throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@CrossOrigin
	@Override
	public ResponseEntity vendorPlatesPost(@Valid @RequestBody VendorPlatesSubmissionRequest request, String authorization)
			throws BrAPIServerException {
		
		String submissionId = null;
		try {
			submissionId = vendorSampleService.savePlates(request);
		} catch (BrAPIServerException e) {
			return ResponseEntity.badRequest().body(e.getResponseMessage());
		}

		VendorPlatesSubmissionResponse result = new VendorPlatesSubmissionResponse();
		result.setSubmissionId(submissionId);
		VendorPlateResponse response = new VendorPlateResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<VendorPlateResponse>(response, HttpStatus.OK);
	}


	@CrossOrigin
	@Override
	public ResponseEntity<VendorPlateGetResponse1> vendorPlatesSubmissionIdGet(String submissionId)
			throws BrAPIServerException {
		VendorPlateGetResponse result = vendorSampleService.getPlateSubmission(submissionId);

		VendorPlateGetResponse1 response = new VendorPlateGetResponse1();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<VendorPlateGetResponse1>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<VendorSpecificationResponse> vendorSpecificationsGet(String authorization)
			throws BrAPIServerException {
		VendorSpecification result = vendorSampleService.getVendorSpec();

		VendorSpecificationResponse response = new VendorSpecificationResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<VendorSpecificationResponse>(response, HttpStatus.OK);
	}
}
