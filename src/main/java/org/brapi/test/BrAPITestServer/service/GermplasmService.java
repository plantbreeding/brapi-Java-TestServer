package org.brapi.test.BrAPITestServer.service;

import java.util.ArrayList;
import java.util.List;

import org.brapi.test.BrAPITestServer.model.Donor;
import org.brapi.test.BrAPITestServer.model.Germplasm;
import org.brapi.test.BrAPITestServer.model.MarkerprofileKeys;
import org.brapi.test.BrAPITestServer.model.Pedigree;
import org.brapi.test.BrAPITestServer.model.TaxonID;
import org.springframework.stereotype.Service;

@Service
public class GermplasmService {

	public List<Germplasm> search(List<String> germplasmDbIds, List<String> germplasmGenus,
			List<String> germplasmNames, List<String> germplasmPUIs, List<String> germplasmSpecies, int page,
			int pageSize) {

		List<Germplasm> results = new ArrayList<Germplasm>();

		results.add(mockGermplasm(germplasmDbIds, germplasmGenus, germplasmNames, germplasmPUIs, germplasmSpecies));
		return results;
	}

	public Germplasm searchByDbId(String germplasmDbId) {
		List<String> germplasmDbIds = new ArrayList<String>();
		germplasmDbIds.add(germplasmDbId);
		return mockGermplasm(germplasmDbIds, null, null, null, null);
	}

	public Pedigree searchPedigreeByDbId(String germplasmDbId, String notation) {
		return mockPedigree(germplasmDbId);
	}

	public MarkerprofileKeys searchMarkerprofilesByDbId(String germplasmDbId) {
		return mockMarkerprofile(germplasmDbId);
	}
	
	private MarkerprofileKeys mockMarkerprofile(String germplasmDbId) {
		MarkerprofileKeys markerprofile = new MarkerprofileKeys();
		markerprofile.setGermplasmDbId(germplasmDbId);
		List<String> markerprofilesDbIds = new ArrayList<String>();
		markerprofilesDbIds.add("3939");
		markerprofilesDbIds.add("4484");
		markerprofilesDbIds.add("3993");
		markerprofile.setMarkerprofilesDbIds(markerprofilesDbIds);
		
		return markerprofile;
	}

	private Pedigree mockPedigree(String germplasmDbId) {
		Pedigree pedigree = new Pedigree();
		pedigree.setDefaultDisplayName("382");
		pedigree.setGermplasmDbId(germplasmDbId);
		pedigree.setParent1Id("166");
		pedigree.setParent2Id("143");
		pedigree.setPedigree("Cree / Bonanza");
		
		return pedigree;
	}
	
	private Germplasm mockGermplasm(List<String> germplasmDbIds, List<String> germplasmGenus,
			List<String> germplasmNames, List<String> germplasmPUIs, List<String> germplasmSpecies) {
		Germplasm germplasm = new Germplasm();

		germplasm.setAccessionNumber("ITC0609");
		germplasm.setAcquisitionDate("19470131");
		germplasm.setBiologicalStatusOfAccessionCode(412);
		germplasm.setCommonCropName("banana");
		germplasm.setCountryOfOriginCode("UNK");
		germplasm.setDefaultDisplayName("Pahang");
		List<Donor> donors = new ArrayList<Donor>();
		germplasm.setDonors(donors);
		germplasm.setGenus("Musa");
		germplasm.setGermplasmDbId("01BEL084609");
		germplasm.setGermplasmName("Pahang");
		germplasm.setGermplasmPUI("http://www.crop-diversity.org/mgis/accession/01BEL084609");
		germplasm.setGermplasmSeedSource("Female GID:4/Male GID:4");
		germplasm.setInstituteCode("01BEL084");
		germplasm.setInstituteName("ITC");
		germplasm.setPedigree("TOBA97/SW90.1057");
		germplasm.setSpecies("acuminata");
		germplasm.setSpeciesAuthority("speciesAuthority");
		germplasm.setSubtaxa("sp malaccensis var pahang");
		germplasm.setSynonyms(new ArrayList<String>());
		List<TaxonID> taxonIDs = new ArrayList<TaxonID>();
		germplasm.setTaxonIds(taxonIDs);
		germplasm.setTypeOfGermplasmStorageCode(new ArrayList<Integer>());
		
		if(germplasmDbIds != null && !germplasmDbIds.isEmpty()) {
			germplasm.setGermplasmDbId(germplasmDbIds.get(0));
		}
		if(germplasmGenus != null && !germplasmGenus.isEmpty()) {
			germplasm.setGenus(germplasmGenus.get(0));
		}
		if(germplasmNames != null && !germplasmNames.isEmpty()) {
			germplasm.setGermplasmName(germplasmNames.get(0));
		}
		if(germplasmPUIs != null && !germplasmPUIs.isEmpty()) {
			germplasm.setGermplasmPUI(germplasmPUIs.get(0));
		}
		if(germplasmSpecies != null && !germplasmSpecies.isEmpty()) {
			germplasm.setSpecies(germplasmSpecies.get(0));
		}
		
		
		return germplasm;
	}

}
