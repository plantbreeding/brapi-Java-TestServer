package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.rest.GermplasmAttributeDefinition;
import org.brapi.test.BrAPITestServer.model.rest.GermplasmAttributeCategory;
import org.brapi.test.BrAPITestServer.model.rest.GermplasmAttributeValuesWrapper;
import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResults;
import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResultsDataList;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.brapi.test.BrAPITestServer.service.GermplasmAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	@CrossOrigin
	@RequestMapping(value="attributes", method= {RequestMethod.GET})
	public GenericResults<GenericResultsDataList<GermplasmAttributeDefinition>> getGermplasmAttributes(
				@RequestParam(required=false) String attributeCategoryDbId,
				@RequestParam(defaultValue="0") int page,
				@RequestParam(defaultValue="1000") int pageSize){
		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		List<GermplasmAttributeDefinition> germplasmAttributes = germplasmAttributeService.getGermplasmAttributes(attributeCategoryDbId,metaData);
		
		return GenericResults
				.withList(germplasmAttributes)
				.withMetaData(metaData);
	}
	
	@CrossOrigin
	@RequestMapping(value="attributes/categories", method= {RequestMethod.GET})
	public GenericResults<GenericResultsDataList<GermplasmAttributeCategory>> getGermplasmAttributeCategories(
				@RequestParam(defaultValue="0") int page,
				@RequestParam(defaultValue="1000") int pageSize){

		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		List<GermplasmAttributeCategory> germplasmAttributes = germplasmAttributeService.getGermplasmAttributeCategories(metaData);
		return GenericResults
				.withList(germplasmAttributes)
				.withMetaData(metaData);
	}


	@CrossOrigin
	@RequestMapping(value = "germplasm/{germplasmDbId}/attributes", method = { RequestMethod.GET })
	public GenericResults<GermplasmAttributeValuesWrapper> getGermplasmAttributeByGermplasmDbId(
			@PathVariable("germplasmDbId") String germplasmDbId,
			@RequestParam(required=false) List<String> attributeList, 
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		GermplasmAttributeValuesWrapper attribute = germplasmAttributeService.getGermplasmAttributeValues(germplasmDbId, attributeList,metaData);

		return GenericResults.withObject(attribute).withMetaData(metaData);
	}
	
}
