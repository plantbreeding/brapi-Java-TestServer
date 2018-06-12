package org.brapi.test.BrAPITestServer.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.model.entity.BreedingMethodEntity;
import org.brapi.test.BrAPITestServer.model.entity.GermplasmEntity;
import org.brapi.test.BrAPITestServer.model.entity.MarkerProfileEntity;
import org.brapi.test.BrAPITestServer.model.entity.PedigreeEntity;
import org.brapi.test.BrAPITestServer.repository.BreedingMethodRepository;
import org.brapi.test.BrAPITestServer.repository.GermplasmRepository;
import org.brapi.test.BrAPITestServer.repository.MarkerProfileRepository;
import org.brapi.test.BrAPITestServer.repository.PedigreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.swagger.model.BreedingMethod;
import io.swagger.model.Germplasm;
import io.swagger.model.GermplasmDonors;
import io.swagger.model.GermplasmMarkerprofilesList;
import io.swagger.model.Metadata;
import io.swagger.model.Pedigree;
import io.swagger.model.Pedigree.Parent1TypeEnum;
import io.swagger.model.Pedigree.Parent2TypeEnum;
import io.swagger.model.PedigreeSiblings;
import io.swagger.model.Progeny;
import io.swagger.model.ProgenyProgeny;
import io.swagger.model.ProgenyProgeny.ParentTypeEnum;
import io.swagger.model.TaxonID;

@Service
public class GermplasmService {

	private GermplasmRepository germplasmRepository;
	private PedigreeRepository pedigreeRepository;
	private MarkerProfileRepository markerProfileRepository;
	private BreedingMethodRepository breedingMethodRepository;

	@Autowired
	public GermplasmService(GermplasmRepository germplasmRepository, PedigreeRepository pedigreeRepository,
			MarkerProfileRepository markerProfileRepository, BreedingMethodRepository breedingMethodRepository) {
		this.germplasmRepository = germplasmRepository;
		this.pedigreeRepository = pedigreeRepository;
		this.markerProfileRepository = markerProfileRepository;
		this.breedingMethodRepository = breedingMethodRepository;
	}

	public List<Germplasm> search(String germplasmPUI, String germplasmDbId, String germplasmName,
			String commonCropName, Metadata metaData) {

		Page<Germplasm> results = germplasmRepository
				.findBySearch(SearchUtility.buildSearchParam(germplasmDbId), SearchUtility.buildSearchParam(""),
						SearchUtility.buildSearchParam(commonCropName), SearchUtility.buildSearchParam(germplasmName),
						SearchUtility.buildSearchParam(germplasmPUI), SearchUtility.buildSearchParam(""),
						SearchUtility.buildSearchParam(""), PagingUtility.getPageRequest(metaData))
				.map(this::convertFromEntity);

		PagingUtility.calculateMetaData(metaData, results);
		return results.getContent();
	}

	public List<Germplasm> search(List<String> germplasmDbIds, List<String> germplasmGenus,
			List<String> commonCropNames, List<String> germplasmNames, List<String> germplasmPUIs,
			List<String> germplasmSpecies, List<String> accessionNumbers, Metadata metaData) {

		Page<Germplasm> results = germplasmRepository
				.findBySearch(SearchUtility.buildSearchParam(germplasmDbIds),
						SearchUtility.buildSearchParam(germplasmGenus), SearchUtility.buildSearchParam(commonCropNames),
						SearchUtility.buildSearchParam(germplasmNames), SearchUtility.buildSearchParam(germplasmPUIs),
						SearchUtility.buildSearchParam(germplasmSpecies),
						SearchUtility.buildSearchParam(accessionNumbers), PagingUtility.getPageRequest(metaData))
				.map(this::convertFromEntity);

		PagingUtility.calculateMetaData(metaData, results);
		return results.getContent();
	}

	private Germplasm convertFromEntity(GermplasmEntity entity) {
		Germplasm germ = new Germplasm();
		germ.setAccessionNumber(entity.getAccessionNumber());
		germ.setBiologicalStatusOfAccessionCode(Integer.decode(entity.getBiologicalStatusOfAccessionCode()));
		germ.setCommonCropName(entity.getCommonCropName());
		germ.setCountryOfOriginCode(entity.getCountryOfOriginCode());
		germ.setBreedingMethodDbId(entity.getBreedingMethod().getId());
		germ.setDefaultDisplayName(entity.getDefaultDisplayName());
		germ.setGenus(entity.getGenus());
		germ.setGermplasmDbId(entity.getId());
		germ.setGermplasmName(entity.getGermplasmName());
		germ.setGermplasmPUI(entity.getGermplasmPUI());
		germ.setSeedSource(entity.getGermplasmSeedSource());
		germ.setInstituteCode(entity.getInstituteCode());
		germ.setPedigree(entity.getPedigree() == null ? null : entity.getPedigree().getPedigree());
		germ.setSpecies(entity.getSpecies());
		germ.setSubtaxa(entity.getSubtaxa());
		germ.setSubtaxaAuthority(entity.getSubtaxaAuthority());

		germ.setAcquisitionDate(DateUtility.toLocalDate(entity.getAcquisitionDate()));

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
			germ.setTypeOfGermplasmStorageCode(entity.getTypeOfGermplasmStorageCode().stream().map((code) -> {
				return code.getStorageCode().toString();
			}).collect(Collectors.toList()));
		}

		if (entity.getDonors() != null) {
			germ.setDonors(entity.getDonors().stream().map((d) -> {
				GermplasmDonors donor = new GermplasmDonors();
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

	public Pedigree searchPedigreeByDbId(String germplasmDbId, String notation, Boolean includeSiblings) {
		PedigreeEntity entity;
		if (notation == null) {
			entity = pedigreeRepository.findByGermplasm_Id(germplasmDbId);
		} else {
			entity = pedigreeRepository.findByGermplasm_IdAndNotation(germplasmDbId, notation);
		}
		Pedigree pedigree = new Pedigree();
		pedigree.setCrossingPlan(entity.getCrossingPlan());
		pedigree.setCrossingYear(entity.getCrossingYear().toString());
		pedigree.setDefaultDisplayName(entity.getGermplasm().getDefaultDisplayName());
		pedigree.setFamilyCode(entity.getFamilyCode());
		pedigree.setGermplasmDbId(germplasmDbId);
		pedigree.setPedigree(entity.getPedigree());
		
		if(entity.getParent1() != null) {
			pedigree.setParent1Id(entity.getParent1().getGermplasm().getId());
			pedigree.setParent1DbId(entity.getParent1().getGermplasm().getId());
			pedigree.setParent1Name(entity.getParent1().getGermplasm().getDefaultDisplayName());
			pedigree.setParent1Type(Parent1TypeEnum.fromValue(entity.getParent1Type()));
		}
		if(entity.getParent2() != null) {
			pedigree.setParent2Id(entity.getParent2().getGermplasm().getId());
			pedigree.setParent2DbId(entity.getParent2().getGermplasm().getId());
			pedigree.setParent2Name(entity.getParent2().getGermplasm().getDefaultDisplayName());
			pedigree.setParent2Type(Parent2TypeEnum.fromValue(entity.getParent2Type()));
		}
		
		if (includeSiblings != null && includeSiblings) {
			List<PedigreeEntity> siblingsPage = pedigreeRepository.findSiblings(entity.getParent1().getId(),
					entity.getParent2().getId());
			for (PedigreeEntity sibEntity : siblingsPage) {
				if (sibEntity.getId() != entity.getId()) {
					PedigreeSiblings siblingsItem = new PedigreeSiblings();
					siblingsItem.setDefaultDisplayName(sibEntity.getGermplasm().getDefaultDisplayName());
					siblingsItem.setGermplasmDbId(sibEntity.getGermplasm().getId());
					pedigree.addSiblingsItem(siblingsItem);
				}
			}
		}
		return pedigree;
	}

	public Progeny searchProgenyByDbId(String germplasmDbId) {
		List<PedigreeEntity> progenyPage = pedigreeRepository.findByParent1_IdOrParent2_Id(germplasmDbId,
				germplasmDbId);
		Progeny result = new Progeny();
		result.setProgeny(new ArrayList<>());
		result.setGermplasmDbId(germplasmDbId);
		progenyPage.forEach(entity -> {
			ProgenyProgeny progeny = new ProgenyProgeny();
			progeny.setDefaultDisplayName(entity.getGermplasm().getDefaultDisplayName());
			progeny.setGermplasmDbId(entity.getGermplasm().getId());
			if (entity.getParent1().getGermplasm().getId() == germplasmDbId) {
				progeny.setParentType(ParentTypeEnum.fromValue(entity.getParent1Type()));
				result.setDefaultDisplayName(entity.getParent1().getGermplasm().getDefaultDisplayName());
			} else {
				progeny.setParentType(ParentTypeEnum.fromValue(entity.getParent2Type()));
				result.setDefaultDisplayName(entity.getParent2().getGermplasm().getDefaultDisplayName());
			}
			result.getProgeny().add(progeny);
		});

		return result;
	}

	public GermplasmMarkerprofilesList searchMarkerProfilesByDbId(String germplasmDbId) {
		List<String> keys = markerProfileRepository.findByGermplasmDbId(germplasmDbId).stream()
				.map(MarkerProfileEntity::getId).collect(Collectors.toList());
		GermplasmMarkerprofilesList result = new GermplasmMarkerprofilesList();
		result.setGermplasmDbId(germplasmDbId);
		result.setMarkerprofileDbIds(keys);
		return result;
	}

	public BreedingMethod getBreedingMethod(String breedingMethodDbId) {
		Optional<BreedingMethodEntity> entityOp = breedingMethodRepository.findById(breedingMethodDbId);
		
		return convertFromEntity(entityOp.orElse(new BreedingMethodEntity()));
	}

	public List<BreedingMethod> getBreedingMethods(Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		Page<BreedingMethodEntity> page = breedingMethodRepository.findAll(pageReq);
		PagingUtility.calculateMetaData(metadata, page);
		return page.map(this::convertFromEntity).getContent();
	}

	private BreedingMethod convertFromEntity(BreedingMethodEntity entity) {
		BreedingMethod bm = new BreedingMethod();
		bm.setAbbreviation(entity.getAbbreviation());
		bm.setBreedingMethodDbId(entity.getId());
		bm.setDescription(entity.getDescription());
		bm.setName(entity.getName());
		return bm;
	}
}
