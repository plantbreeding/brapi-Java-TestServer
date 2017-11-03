package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.TraitSummary;
import org.brapi.test.BrAPITestServer.model.metadata.SearchResults;
import org.brapi.test.BrAPITestServer.model.metadata.SearchResultsList;
import org.brapi.test.BrAPITestServer.service.TraitService;
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
	
	@RequestMapping(value="traits", method= {RequestMethod.GET})
	public SearchResults<SearchResultsList<TraitSummary>> getTraits(
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		
		List<TraitSummary> traits = traitService.getTraits(page, pageSize);
		
		return SearchResults.withList(traits).withMetaData(mockMetaData(page, pageSize));
	}
	
	@RequestMapping(value="traits/{traitDbId}", method= {RequestMethod.GET})
	public SearchResults<TraitSummary> getTrait(
			@PathVariable(value="traitDbId") String traitDbId){
		TraitSummary trait = traitService.getTrait(traitDbId);
		
		return SearchResults.withObject(trait).withMetaData(mockEmptyMetadata());
	}
}
