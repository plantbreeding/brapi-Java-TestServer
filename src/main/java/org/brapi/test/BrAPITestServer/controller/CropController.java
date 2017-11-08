package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResults;
import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResultsDataList;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.brapi.test.BrAPITestServer.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CropController  extends BrAPIController{
	CropService cropService;
	
	@Autowired
	public CropController(CropService cropService) {
		this.cropService = cropService;
	}

	@RequestMapping(path="crops", method= {RequestMethod.GET})
	public GenericResults<GenericResultsDataList<String>> getCrops(
			@RequestParam(value="pageSize", defaultValue="1000") int pageSize,
			@RequestParam(value="page", defaultValue="0") int page){
		
		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		List<String> crops = cropService.getCrops(metaData);

		return GenericResults
				.withList(crops)
				.withMetaData(metaData);
	}

}
