package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.Germplasm;
import org.brapi.test.BrAPITestServer.model.MarkerprofileKeys;
import org.brapi.test.BrAPITestServer.model.Pedigree;
import org.brapi.test.BrAPITestServer.model.metadata.GenericResults;
import org.brapi.test.BrAPITestServer.model.metadata.GenericResultsDataList;
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

	@RequestMapping(path = "germplasm-search", method = { RequestMethod.GET, RequestMethod.POST })
	public GenericResults<GenericResultsDataList<Germplasm>> germplasmSearch(
			@RequestParam(value = "germplasmPUI") List<String> germplasmPUIs,
			@RequestParam(value = "germplasmDbId") List<String> germplasmDbIds,
			@RequestParam(value = "germplasmSpecies", required = false) List<String> germplasmSpecies,
			@RequestParam(value = "germplasmGenus", required = false) List<String> germplasmGenus,
			@RequestParam(value = "germplasmNames", required = false) List<String> germplasmNames,
			@RequestParam(value = "accessionNumbers", required = false) List<String> accessionNumbers,
			@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		List<Germplasm> germplasms = germplasmService.search(germplasmDbIds, germplasmGenus, germplasmNames,
				germplasmPUIs, germplasmSpecies, page, pageSize);

		return GenericResults.withList(germplasms).withMetaData(mockMetaData(page, pageSize));
	}

	@RequestMapping(value = "germplasm/{germplasmDbId}", method = { RequestMethod.GET })
	public GenericResults<Germplasm> germplasmSearchByDbId(@PathVariable(value = "germplasmDbId") String germplasmDbId) {
		Germplasm germplasm = germplasmService.searchByDbId(germplasmDbId);

		return GenericResults.withObject(germplasm).withMetaData(mockEmptyMetadata());
	}

	@RequestMapping(value = "germplasm/{germplasmDbId}/pedigree", method = { RequestMethod.GET })
	public GenericResults<Pedigree> pedigreeByGermplasmDbId(@PathVariable(value = "germplasmDbId") String germplasmDbId,
			@RequestParam(value = "notation") String notation) {
		Pedigree pedigree = germplasmService.searchPedigreeByDbId(germplasmDbId, notation);

		return GenericResults.withObject(pedigree).withMetaData(mockEmptyMetadata());
	}

	@RequestMapping(value = "germplasm/{germplasmDbId}/markerprofiles", method = { RequestMethod.GET })
	public GenericResults<MarkerprofileKeys> markerprofilesByGermplasmDbId(
			@PathVariable("germplasmDbId") String germplasmDbId) {
		MarkerprofileKeys markerprofile = germplasmService.searchMarkerprofilesByDbId(germplasmDbId);

		return GenericResults.withObject(markerprofile).withMetaData(mockEmptyMetadata());
	}
}
