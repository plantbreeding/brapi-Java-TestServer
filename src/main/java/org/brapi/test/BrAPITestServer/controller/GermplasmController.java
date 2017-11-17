package org.brapi.test.BrAPITestServer.controller;

import java.util.ArrayList;
import java.util.List;

import org.brapi.test.BrAPITestServer.model.rest.Germplasm;
import org.brapi.test.BrAPITestServer.model.rest.GermplasmSearchRequest;
import org.brapi.test.BrAPITestServer.model.rest.MarkerProfileKeys;
import org.brapi.test.BrAPITestServer.model.rest.Pedigree;
import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResults;
import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResultsDataList;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.brapi.test.BrAPITestServer.service.GermplasmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GermplasmController extends BrAPIController {

	GermplasmService germplasmService;

	@Autowired
	public GermplasmController(GermplasmService germplasmService) {
		super();
		this.germplasmService = germplasmService;
	}

	@RequestMapping(path = "germplasm-search", method = { RequestMethod.GET })
	public GenericResults<GenericResultsDataList<Germplasm>> germplasmSearch(
			@RequestParam(value = "germplasmPUI", required = false, defaultValue="") List<String> germplasmPUIs,
			@RequestParam(value = "germplasmDbId", required = false, defaultValue="") List<String> germplasmDbIds,
			@RequestParam(value = "germplasmSpecies", required = false, defaultValue="") List<String> germplasmSpecies,
			@RequestParam(value = "germplasmGenus", required = false, defaultValue="") List<String> germplasmGenus,
			@RequestParam(value = "germplasmNames", required = false, defaultValue="") List<String> germplasmNames,
			@RequestParam(value = "accessionNumbers", required = false, defaultValue="") List<String> accessionNumbers,
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		
		MetaData metaData = generateMetaDataTemplate(page, pageSize);
		List<Germplasm> germplasms = germplasmService.search(germplasmDbIds, germplasmGenus, germplasmNames,
				germplasmPUIs, germplasmSpecies, accessionNumbers, metaData);

		return GenericResults.withList(germplasms).withMetaData(metaData);
	}

	@RequestMapping(path = "germplasm-search", method = { RequestMethod.POST })
	public GenericResults<GenericResultsDataList<Germplasm>> germplasmSearch(
			GermplasmSearchRequest request) {
		
		MetaData metaData = generateMetaDataTemplate(request.getPage(), request.getPageSize());
		List<Germplasm> germplasms = germplasmService.search(request.getGermplasmDbIds(), request.getGermplasmGenus(), request.getGermplasmNames(),
				request.getGermplasmPUIs(), request.getGermplasmSpecies(), request.getAccessionNumbers(), metaData);

		return GenericResults.withList(germplasms).withMetaData(metaData);
	}

	@RequestMapping(value = "germplasm/{germplasmDbId}", method = { RequestMethod.GET })
	public GenericResults<Germplasm> germplasmSearchByDbId(@PathVariable(value = "germplasmDbId") String germplasmDbId) {
		Germplasm germplasm = germplasmService.searchByDbId(germplasmDbId);

		return GenericResults.withObject(germplasm).withMetaData(generateEmptyMetadata());
	}

	@RequestMapping(value = "germplasm/{germplasmDbId}/pedigree", method = { RequestMethod.GET })
	public GenericResults<Pedigree> pedigreeByGermplasmDbId(@PathVariable(value = "germplasmDbId", required=true) String germplasmDbId,
			@RequestParam(value = "notation", required=false) String notation) {
		Pedigree pedigree = germplasmService.searchPedigreeByDbId(germplasmDbId, notation);

		return GenericResults.withObject(pedigree).withMetaData(generateEmptyMetadata());
	}

	@RequestMapping(value = "germplasm/{germplasmDbId}/markerProfiles", method = { RequestMethod.GET })
	public GenericResults<MarkerProfileKeys> markerProfilesByGermplasmDbId(
			@PathVariable("germplasmDbId") String germplasmDbId) {
		MarkerProfileKeys markerProfile = germplasmService.searchMarkerProfilesByDbId(germplasmDbId);

		return GenericResults.withObject(markerProfile).withMetaData(generateEmptyMetadata());
	}
}
