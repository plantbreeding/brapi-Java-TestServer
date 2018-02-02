package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.rest.VendorPlate;
import org.brapi.test.BrAPITestServer.model.rest.VendorPlateRequestList;
import org.brapi.test.BrAPITestServer.model.rest.VendorPlateSearchRequest;
import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResults;
import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResultsDataList;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.brapi.test.BrAPITestServer.model.rest.vendor.VendorSpec;
import org.brapi.test.BrAPITestServer.service.VendorSampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorSampleController extends BrAPIController {

	private VendorSampleService vendorSampleService;

	@Autowired
	public VendorSampleController(VendorSampleService sampleService) {
		this.vendorSampleService = sampleService;
	}

	@CrossOrigin
	@RequestMapping(value = "vendor/plate/{vendorPlateDbId}", method = { RequestMethod.GET })
	public GenericResults<VendorPlate> getPlateDetails(@PathVariable("vendorPlateDbId") String vendorPlateDbId) {
		VendorPlate vendorPlate = vendorSampleService.getPlate(vendorPlateDbId);
		return GenericResults.withObject(vendorPlate).withMetaData(generateEmptyMetadata());
	}

	@CrossOrigin
	@RequestMapping(value = "vendor/plates", method = { RequestMethod.POST })
	@PreAuthorize("hasAuthority('ADMIN')")
	public GenericResults<GenericResultsDataList<VendorPlate>> postPlateDetails(@RequestBody VendorPlateRequestList request) {
		List<VendorPlate> vendorPlate = vendorSampleService.savePlates(request);
		return GenericResults.withList(vendorPlate).withMetaData(generateEmptyMetadata());
	}

	@CrossOrigin
	@RequestMapping(value = "vendor/plate-search", method = { RequestMethod.GET })
	public GenericResults<GenericResultsDataList<VendorPlate>> getPlateSearch(
			@RequestParam(required = false) String vendorProjectDbId,
			@RequestParam(required = false) String vendorPlateDbId,
			@RequestParam(required = false) String clientPlateDbId, 
			@RequestParam(required = false) boolean sampleInfo,
			@RequestParam(defaultValue = "0") int page, 
			@RequestParam(defaultValue = "1000") int pageSize) {

		MetaData metadata = generateMetaDataTemplate(page, pageSize);
		List<VendorPlate> plates = vendorSampleService.searchPlates(vendorProjectDbId, vendorPlateDbId, clientPlateDbId, sampleInfo, metadata);
		return GenericResults.withList(plates).withMetaData(metadata);
	}

	@CrossOrigin
	@RequestMapping(value = "vendor/plate-search", method = { RequestMethod.POST })
	public GenericResults<GenericResultsDataList<VendorPlate>> postPlateSearch(@RequestBody VendorPlateSearchRequest request) {

		MetaData metadata = generateMetaDataTemplate(request);
		List<VendorPlate> vendorPlate = vendorSampleService.searchPlates(request, metadata);
		return GenericResults.withList(vendorPlate).withMetaData(metadata);
	}

	@CrossOrigin
	@RequestMapping(value = "vendor/specifications", method = { RequestMethod.GET })
	public GenericResults<VendorSpec> getVendorSpecs() {
		VendorSpec vendorSpec = vendorSampleService.getVendorSpec();
		return GenericResults.withObject(vendorSpec).withMetaData(generateEmptyMetadata());
	}
}
