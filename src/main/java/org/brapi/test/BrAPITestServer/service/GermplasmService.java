package org.brapi.test.BrAPITestServer.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.model.entity.GermplasmEntity;
import org.brapi.test.BrAPITestServer.model.entity.GermplasmTypeStorageCodeEntity;
import org.brapi.test.BrAPITestServer.model.entity.MarkerProfileEntity;
import org.brapi.test.BrAPITestServer.model.entity.PedigreeEntity;
import org.brapi.test.BrAPITestServer.model.rest.Donor;
import org.brapi.test.BrAPITestServer.model.rest.Germplasm;
import org.brapi.test.BrAPITestServer.model.rest.MarkerProfileKeys;
import org.brapi.test.BrAPITestServer.model.rest.Pedigree;
import org.brapi.test.BrAPITestServer.model.rest.TaxonID;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.brapi.test.BrAPITestServer.repository.GermplasmRepository;
import org.brapi.test.BrAPITestServer.repository.MarkerProfileRepository;
import org.brapi.test.BrAPITestServer.repository.PedigreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class GermplasmService {

	private GermplasmRepository germplasmRepository;
	private PedigreeRepository pedigreeRepository;
	private MarkerProfileRepository markerProfileRepository;

	@Autowired
	public GermplasmService(GermplasmRepository germplasmRepository, PedigreeRepository pedigreeRepository,
			MarkerProfileRepository markerProfileRepository) {
		this.germplasmRepository = germplasmRepository;
		this.pedigreeRepository = pedigreeRepository;
		this.markerProfileRepository = markerProfileRepository;
	}

	public List<Germplasm> search(List<String> germplasmDbIds, List<String> germplasmGenus, List<String> germplasmNames,
			List<String> germplasmPUIs, List<String> germplasmSpecies, List<String> accessionNumbers,
			MetaData metaData) {

		Page<Germplasm> results = germplasmRepository
				.findBySearch(SearchUtility.buildSearchParam(germplasmDbIds),
						SearchUtility.buildSearchParam(germplasmGenus), SearchUtility.buildSearchParam(germplasmNames),
						SearchUtility.buildSearchParam(germplasmPUIs), SearchUtility.buildSearchParam(germplasmSpecies),
						SearchUtility.buildSearchParam(accessionNumbers), PagingUtility.getPageRequest(metaData))
				.map(this::convertFromEntity);

		PagingUtility.calculateMetaData(metaData, results);
		return results.getContent();
	}

	private Germplasm convertFromEntity(GermplasmEntity entity) {
		Germplasm germ = new Germplasm();
		germ.setAccessionNumber(entity.getAccessionNumber());
		germ.setBiologicalStatusOfAccessionCode(entity.getBiologicalStatusOfAccessionCode());
		germ.setCommonCropName(entity.getCommonCropName());
		germ.setCountryOfOriginCode(entity.getCountryOfOriginCode());
		germ.setDefaultDisplayName(entity.getDefaultDisplayName());
		germ.setGenus(entity.getGenus());
		germ.setGermplasmDbId(entity.getId());
		germ.setGermplasmName(entity.getGermplasmName());
		germ.setGermplasmPUI(entity.getGermplasmPUI());
		germ.setGermplasmSeedSource(entity.getGermplasmSeedSource());
		germ.setInstituteCode(entity.getInstituteCode());
		germ.setPedigree(entity.getPedigree() == null ? null : entity.getPedigree().getPedigree());
		germ.setSpecies(entity.getSpecies());
		germ.setSubtaxa(entity.getSubtaxa());
		germ.setSubtaxaAuthority(entity.getSubtaxaAuthority());

		germ.setAcquisitionDate(entity.getAcquisitionDate());

		List<String> synonyms = entity.getSynonyms() == null ? null
				: Arrays.asList(entity.getSynonyms().split(" *, *"));
		germ.setSynonyms(synonyms);

		if (entity.getTaxonIds() != null) {
			germ.setTaxonIds(entity.getTaxonIds().stream().map((t) -> {
				TaxonID taxonId = new TaxonID();
				taxonId.setSourceName(t.getSourceName());
				taxonId.setTaxonId(t.getTaxonId());
				return taxonId;
			}).collect(Collectors.toList()));
		}

		if (entity.getTypeOfGermplasmStorageCode() != null) {
			germ.setTypeOfGermplasmStorageCode(entity.getTypeOfGermplasmStorageCode().stream()
					.map(GermplasmTypeStorageCodeEntity::getStorageCode).collect(Collectors.toList()));
		}

		if (entity.getDonors() != null) {
			germ.setDonors(entity.getDonors().stream().map((d) -> {
				Donor donor = new Donor();
				donor.setDonorAccessionNumber(d.getDonorAccessionNumber());
				donor.setDonorInstituteCode(d.getDonorInstituteCode());
				donor.setGermplasmPUI(d.getGermplasmPUI());
				return donor;
			}).collect(Collectors.toList()));
		}

		return germ;
	}

	public Germplasm searchByDbId(String germplasmDbId) {
		Germplasm germplasm = convertFromEntity(
				germplasmRepository.findById(germplasmDbId).orElse(new GermplasmEntity()));
		return germplasm;
	}

	public Pedigree searchPedigreeByDbId(String germplasmDbId, String notation) {
		PedigreeEntity entity;
		if (notation == null) {
			entity = pedigreeRepository.findByGermplasm_Id(germplasmDbId);
		} else {
			entity = pedigreeRepository.findByGermplasm_IdAndNotation(germplasmDbId, notation);
		}
		Pedigree pedigree = new Pedigree();
		pedigree.setDefaultDisplayName(entity.getDefaultDisplayName());
		pedigree.setGermplasmDbId(germplasmDbId);
		pedigree.setParent1Id(entity.getParent1().getId());
		pedigree.setParent2Id(entity.getParent2().getId());
		pedigree.setParent1DbId(entity.getParent1().getId());
		pedigree.setParent2DbId(entity.getParent2().getId());
		pedigree.setPedigree(entity.getPedigree());
		return pedigree;
	}

	public MarkerProfileKeys searchMarkerProfilesByDbId(String germplasmDbId) {
		MarkerProfileKeys keys = new MarkerProfileKeys();
		keys.setGermplasmDbId(germplasmDbId);
		keys.setMarkerProfilesDbIds(markerProfileRepository.findByGermplasmDbId(germplasmDbId).stream()
				.map(MarkerProfileEntity::getId).collect(Collectors.toList()));
		return keys;
	}

}
