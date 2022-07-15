package org.brapi.test.BrAPITestServer.controller.geno;

import io.swagger.model.Metadata;
import io.swagger.model.geno.VendorOrder;
import io.swagger.model.geno.VendorOrderListResponse;
import io.swagger.model.geno.VendorOrderListResponseResult;
import io.swagger.model.geno.VendorOrderStatusResponse;
import io.swagger.model.geno.VendorOrderStatusResponseResult;
import io.swagger.model.geno.VendorOrderSubmission;
import io.swagger.model.geno.VendorOrderSubmissionRequest;
import io.swagger.model.geno.VendorOrderSubmissionSingleResponse;
import io.swagger.model.geno.VendorPlate;
import io.swagger.model.geno.VendorPlateListResponse;
import io.swagger.model.geno.VendorPlateListResponseResult;
import io.swagger.model.geno.VendorPlateSubmission;
import io.swagger.model.geno.VendorPlateSubmissionId;
import io.swagger.model.geno.VendorPlateSubmissionIdSingleResponse;
import io.swagger.model.geno.VendorPlateSubmissionRequest;
import io.swagger.model.geno.VendorPlateSubmissionSingleResponse;
import io.swagger.model.geno.VendorResultFile;
import io.swagger.model.geno.VendorResultFileListResponse;
import io.swagger.model.geno.VendorResultFileListResponseResult;
import io.swagger.model.geno.VendorSpecification;
import io.swagger.model.geno.VendorSpecificationSingleResponse;
import io.swagger.api.geno.VendorApi;

import org.brapi.test.BrAPITestServer.controller.core.BrAPIController;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.geno.VendorSampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
@Controller
public class VendorApiController extends BrAPIController implements VendorApi {

	private static final Logger log = LoggerFactory.getLogger(VendorApiController.class);

	private final VendorSampleService vendorSampleService;

	private final HttpServletRequest request;

	@Autowired
	public VendorApiController(VendorSampleService vendorSampleService, HttpServletRequest request) {
		this.vendorSampleService = vendorSampleService;
		this.request = request;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<VendorOrderListResponse> vendorOrdersGet(
			@RequestParam(value = "orderId", required = false) String orderId,
			@RequestParam(value = "submissionId", required = false) String submissionId,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<VendorOrder> data = vendorSampleService.getOrders(orderId, submissionId, metadata);
		return responseOK(new VendorOrderListResponse(), new VendorOrderListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<VendorPlateListResponse> vendorOrdersOrderIdPlatesGet(@PathVariable("orderId") String orderId,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<VendorPlate> data = vendorSampleService.getPlates(orderId, metadata);
		return responseOK(new VendorPlateListResponse(), new VendorPlateListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<VendorResultFileListResponse> vendorOrdersOrderIdResultsGet(
			@PathVariable("orderId") String orderId, @RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<VendorResultFile> data = vendorSampleService.getResultFiles(orderId, metadata);
		return responseOK(new VendorResultFileListResponse(), new VendorResultFileListResponseResult(), data, metadata);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<VendorOrderStatusResponse> vendorOrdersOrderIdStatusGet(
			@PathVariable("orderId") String orderId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		VendorOrderStatusResponseResult data = vendorSampleService.getOrderStatus(orderId);
		return responseOK(new VendorOrderStatusResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<VendorOrderSubmissionSingleResponse> vendorOrdersPost(
			@RequestBody VendorOrderSubmissionRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		VendorOrderSubmission data = vendorSampleService.saveOrder(body);
		return responseOK(new VendorOrderSubmissionSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<VendorPlateSubmissionIdSingleResponse> vendorPlatesPost(
			@RequestBody VendorPlateSubmissionRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_USER");
		validateAcceptHeader(request);
		VendorPlateSubmissionId data = vendorSampleService.savePlates(body);
		return responseOK(new VendorPlateSubmissionIdSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<VendorPlateSubmissionSingleResponse> vendorPlatesSubmissionIdGet(
			@PathVariable("submissionId") String submissionId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		VendorPlateSubmission data = vendorSampleService.getPlateSubmission(submissionId);
		return responseOK(new VendorPlateSubmissionSingleResponse(), data);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<VendorSpecificationSingleResponse> vendorSpecificationsGet(
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateSecurityContext(request, "ROLE_ANONYMOUS", "ROLE_USER");
		validateAcceptHeader(request);
		VendorSpecification data = vendorSampleService.getVendorSpec();
		return responseOK(new VendorSpecificationSingleResponse(), data);
	}

}
