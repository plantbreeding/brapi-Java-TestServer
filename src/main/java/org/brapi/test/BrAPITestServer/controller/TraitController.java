package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.rest.TraitSummary;
import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResults;
import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResultsDataList;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.brapi.test.BrAPITestServer.service.TraitService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TraitController  extends BrAPIController{

	private TraitService traitService;
	
	public TraitController(TraitService traitService) {
		this.traitService = traitService;
	}
	
	@CrossOrigin
	@RequestMapping(path="brapi/v1/traits", method= {RequestMethod.GET})
	public GenericResults<GenericResultsDataList<TraitSummary>> getTraits(
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {

		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		List<TraitSummary> traits = traitService.getTraits(metaData);
		
		return GenericResults.withList(traits).withMetaData(metaData);
	}
	
	@CrossOrigin
	@RequestMapping(path="brapi/v1/traits/{traitDbId}", method= {RequestMethod.GET})
	public GenericResults<TraitSummary> getTrait(
			@PathVariable(value="traitDbId") String traitDbId){
		TraitSummary trait = traitService.getTrait(traitDbId);
		
		return GenericResults.withObject(trait).withMetaData(generateEmptyMetadata());
	}
}
