package org.brapi.test.BrAPITestServer.controller.old;

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

import io.swagger.model.Metadata;
import io.swagger.model.VendorOrder;
import io.swagger.model.VendorOrderRequest;
import io.swagger.model.VendorOrderResponse;
import io.swagger.model.VendorOrderResponseResult;
import io.swagger.model.VendorOrderResultsResponse;
import io.swagger.model.VendorOrderResultsResponseResult;
import io.swagger.model.VendorOrderStatusResponse;
import io.swagger.model.VendorOrderStatusResponseResult;
import io.swagger.model.VendorOrderStatusResponseResult.StatusEnum;
import io.swagger.model.VendorOrdersResponse;
import io.swagger.model.VendorOrdersResponseResult;
import io.swagger.model.VendorPlate;
import io.swagger.model.VendorPlateGetResponse;
import io.swagger.model.VendorPlateGetResponse1;
import io.swagger.model.VendorPlateResponse;
import io.swagger.model.VendorPlatesResponse;
import io.swagger.model.VendorPlatesResponseResult;
import io.swagger.model.VendorPlatesSubmissionRequest;
import io.swagger.model.VendorPlatesSubmissionResponse;
import io.swagger.model.VendorResultFile;
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
		Metadata metadata = generateEmptyMetadata();
		
		List<VendorOrder> data = vendorSampleService.getOrders(orderId, submissionId, metadata);
		
		VendorOrdersResponseResult result = new VendorOrdersResponseResult();
		result.setData(data);
		VendorOrdersResponse response = new VendorOrdersResponse();
		response.setMetadata(metadata);
		response.setResult(result);
		return new ResponseEntity<VendorOrdersResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<VendorPlatesResponse> vendorOrdersOrderIdPlatesGet(@PathVariable("orderId") String orderId, String authorization)
			throws BrAPIServerException {
		Metadata metadata = generateEmptyMetadata();
		
		List<VendorPlate> data = vendorSampleService.getPlates(orderId, metadata);
		
		VendorPlatesResponseResult result = new VendorPlatesResponseResult();
		result.setData(data);
		VendorPlatesResponse response = new VendorPlatesResponse();
		response.setMetadata(metadata);
		response.setResult(result);
		return new ResponseEntity<VendorPlatesResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<VendorOrderResultsResponse> vendorOrdersOrderIdResultsGet(@PathVariable("orderId") String orderId, String authorization)
			throws BrAPIServerException {
		Metadata metadata = generateEmptyMetadata();
		
		List<VendorResultFile> data = vendorSampleService.getResultFiles(orderId, metadata);
		
		VendorOrderResultsResponseResult result = new VendorOrderResultsResponseResult();
		result.setData(data);
		VendorOrderResultsResponse response = new VendorOrderResultsResponse();
		response.setMetadata(metadata);
		response.setResult(result);
		return new ResponseEntity<VendorOrderResultsResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<VendorOrderStatusResponse> vendorOrdersOrderIdStatusGet(@PathVariable("orderId") String orderId, String authorization)
			throws BrAPIServerException {
		Metadata metadata = generateEmptyMetadata();
		
		StatusEnum status = vendorSampleService.getOrderStatus(orderId, metadata);
		
		VendorOrderStatusResponseResult result = new VendorOrderStatusResponseResult();
		result.setStatus(status);
		VendorOrderStatusResponse response = new VendorOrderStatusResponse();
		response.setMetadata(metadata);
		response.setResult(result);
		return new ResponseEntity<VendorOrderStatusResponse>(response, HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@CrossOrigin
	@Override
	public ResponseEntity<VendorOrderResponse> vendorOrdersPost(@Valid @RequestBody VendorOrderRequest body, String authorization)
			throws BrAPIServerException {
		Metadata metadata = generateEmptyMetadata();
		
		VendorOrderResponseResult result = vendorSampleService.saveOrder(body); 
		
		VendorOrderResponse response = new VendorOrderResponse();
		response.setMetadata(metadata);
		response.setResult(result);
		return new ResponseEntity<VendorOrderResponse>(response, HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@CrossOrigin
	@Override
	public ResponseEntity<VendorPlateResponse> vendorPlatesPost(@Valid @RequestBody VendorPlatesSubmissionRequest request, String authorization)
			throws BrAPIServerException {
		
		String submissionId = vendorSampleService.savePlates(request);

		VendorPlatesSubmissionResponse result = new VendorPlatesSubmissionResponse();
		result.setSubmissionId(submissionId);
		VendorPlateResponse response = new VendorPlateResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<VendorPlateResponse>(response, HttpStatus.OK);
	}


	@CrossOrigin
	@Override
	public ResponseEntity<VendorPlateGetResponse1> vendorPlatesSubmissionIdGet(@PathVariable("submissionId") String submissionId)
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
