package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.Phenotype;
import org.brapi.test.BrAPITestServer.model.PhenotypesSearchRequest;
import org.brapi.test.BrAPITestServer.model.metadata.GenericResults;
import org.brapi.test.BrAPITestServer.model.metadata.GenericResultsDataList;
import org.brapi.test.BrAPITestServer.service.PhenotypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhenotypeController  extends BrAPIController{

	private PhenotypeService phenotypeService;
	
	@Autowired
	public PhenotypeController(PhenotypeService phenotypeService) {
		this.phenotypeService = phenotypeService;
	}
	
	@RequestMapping(value="phenotypes-search", method= {RequestMethod.POST})
	public GenericResults<GenericResultsDataList<Phenotype>> getPhenotypes(
			@RequestBody PhenotypesSearchRequest request) {
		List<Phenotype> phenotypes = phenotypeService.getPhenotypes(request);
		return GenericResults.withList(phenotypes).withMetaData(mockMetaData(request.getPage(), request.getPageSize()));
	}
}
