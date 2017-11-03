package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.GermplasmAttribute;
import org.brapi.test.BrAPITestServer.model.GermplasmAttributeMasterWrapper;
import org.brapi.test.BrAPITestServer.model.MarkerprofileKeys;
import org.brapi.test.BrAPITestServer.model.metadata.GenericResults;
import org.brapi.test.BrAPITestServer.model.metadata.GenericResultsDataList;
import org.brapi.test.BrAPITestServer.service.GermplasmAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GermplasmAttributeController extends BrAPIController{
	private GermplasmAttributeService germplasmAttributeService;
	
	@Autowired
	public GermplasmAttributeController(GermplasmAttributeService germplasmAttributeService) {
		this.germplasmAttributeService = germplasmAttributeService;
	}
	
	@RequestMapping(value="attributes", method= {RequestMethod.GET})
	public GenericResults<GenericResultsDataList<GermplasmAttribute>> getGermplasmAttributes(
				@RequestParam String attributeCategoryDbId,
				@RequestParam(defaultValue="0") int page,
				@RequestParam(defaultValue="1000") int pageSize){
		List<GermplasmAttribute> germplasmAttributes = germplasmAttributeService.getGermplasmAttributes(attributeCategoryDbId, page, pageSize);
		
		return GenericResults
				.withList(germplasmAttributes)
				.withMetaData(mockMetaData(page, pageSize));
	}
	
	@RequestMapping(value="attributes/categories", method= {RequestMethod.GET})
	public GenericResults<GenericResultsDataList<GermplasmAttribute>> getGermplasmAttributeCategories(
				@RequestParam(defaultValue="0") int page,
				@RequestParam(defaultValue="1000") int pageSize){
		
		List<GermplasmAttribute> germplasmAttributes = germplasmAttributeService.getGermplasmAttributeCategories(page, pageSize);
		return GenericResults
				.withList(germplasmAttributes)
				.withMetaData(mockMetaData(page, pageSize));
	}


	@RequestMapping(value = "germplasm/{germplasmDbId}/attributes", method = { RequestMethod.GET })
	public GenericResults<GermplasmAttributeMasterWrapper> getGermplasmAttributeByGermplasmDbId(
			@PathVariable("germplasmDbId") String germplasmDbId,
			@RequestParam List<String> attributeList, 
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		GermplasmAttributeMasterWrapper attribute = germplasmAttributeService.getGermplasmAttributes(germplasmDbId, attributeList, page, pageSize);

		return GenericResults.withObject(attribute).withMetaData(mockMetaData(page, pageSize));
	}
	
}
