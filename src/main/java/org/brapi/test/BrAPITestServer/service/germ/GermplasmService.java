package org.brapi.test.BrAPITestServer.service.germ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.geno.MarkerProfileEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.BreedingMethodEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.GermplasmEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.PedigreeEntity;
import org.brapi.test.BrAPITestServer.repository.geno.MarkerProfileRepository;
import org.brapi.test.BrAPITestServer.repository.germ.BreedingMethodRepository;
import org.brapi.test.BrAPITestServer.repository.germ.GermplasmRepository;
import org.brapi.test.BrAPITestServer.repository.germ.PedigreeRepository;
import org.brapi.test.BrAPITestServer.service.DateUtility;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.germ.BreedingMethod;
import io.swagger.model.germ.Germplasm;
import io.swagger.model.germ.GermplasmMCPD;
import io.swagger.model.germ.GermplasmMCPDCollectingInfo;
import io.swagger.model.germ.GermplasmMCPDCollectingInfoCollectingInstitutes;
import io.swagger.model.germ.GermplasmMCPDCollectingInfoCollectingSite;
import io.swagger.model.germ.GermplasmMCPDDonorInfo;
import io.swagger.model.germ.GermplasmMCPDDonorInfoDonorInstitute;
import io.swagger.model.germ.GermplasmNewRequestDonors;
import io.swagger.model.germ.GermplasmSearchRequest;
import io.swagger.model.germ.PedigreeNode;
import io.swagger.model.germ.PedigreeNodeSiblings;
import io.swagger.model.germ.ProgenyNode;
import io.swagger.model.germ.ProgenyNodeProgeny;
import io.swagger.model.germ.ProgenyNodeProgeny.ParentTypeEnum;
import io.swagger.model.germ.TaxonID;


@Service
public class GermplasmService {

	private GermplasmRepository germplasmRepository;
	private PedigreeRepository pedigreeRepository;
	private MarkerProfileRepository markerProfileRepository;
	private BreedingMethodRepository breedingMethodRepository;
	private SearchService searchService;

	@Autowired
	public GermplasmService(GermplasmRepository germplasmRepository, PedigreeRepository pedigreeRepository,
			MarkerProfileRepository markerProfileRepository, BreedingMethodRepository breedingMethodRepository,
			SearchService searchService) {
		this.germplasmRepository = germplasmRepository;
		this.pedigreeRepository = pedigreeRepository;
		this.markerProfileRepository = markerProfileRepository;
		this.breedingMethodRepository = breedingMethodRepository;
		this.searchService = searchService;
	}

	public List<Germplasm> search(String germplasmPUI, String germplasmDbId, String germplasmName,
			String commonCropName, Metadata metaData) {
//		GermplasmSearchRequest request = buildSearchRequest(germplasmPUI, germplasmDbId, germplasmName, commonCropName);
//		Page<Germplasm> results = germplasmRepository.findBySearch(request, PagingUtility.getPageRequest(metaData))
//				.map(this::convertFromEntity);
//
//		PagingUtility.calculateMetaData(metaData, results);
//		return results.getContent();
		return null;
	}

	private GermplasmSearchRequest buildSearchRequest(String germplasmPUI, String germplasmDbId, String germplasmName,
			String commonCropName) {
		GermplasmSearchRequest request = new GermplasmSearchRequest();
		if (germplasmPUI != null) {
			request.addGermplasmPUIsItem(germplasmPUI);
		}
		if (germplasmDbId != null) {
			request.addGermplasmDbIdsItem(germplasmDbId);
		}
		if (germplasmName != null) {
			request.addGermplasmNamesItem(germplasmName);
		}
		if (commonCropName != null) {
			request.addCommonCropNamesItem(commonCropName);
		}
		return request;
	}

	public List<Germplasm> search(GermplasmSearchRequest request, Metadata metaData) {

//		Page<Germplasm> results = germplasmRepository.findBySearch(request, PagingUtility.getPageRequest(metaData))
//				.map(this::convertFromEntity);
//
//		PagingUtility.calculateMetaData(metaData, results);
//		return results.getContent();
		return null;
	}

	private Germplasm convertFromEntity(GermplasmEntity entity) {
		Germplasm germ = new Germplasm();
		germ.setAccessionNumber(entity.getAccessionNumber());
//		germ.setBiologicalStatusOfAccessionCode(Integer.decode(entity.getBiologicalStatusOfAccessionCode()));
		germ.setCommonCropName(entity.getCommonCropName());
		germ.setCountryOfOriginCode(entity.getCountryOfOriginCode());
		germ.setBreedingMethodDbId(entity.getBreedingMethod().getId());
		germ.setDefaultDisplayName(entity.getDefaultDisplayName());
		germ.setDocumentationURL(entity.getDocumentationURL());
		germ.setGenus(entity.getGenus());
		germ.setGenus(entity.getGenus());
		germ.setGermplasmDbId(entity.getId());
		germ.setGermplasmName(entity.getGermplasmName());
		germ.setGermplasmPUI(entity.getGermplasmPUI());
		germ.setSeedSource(entity.getGermplasmSeedSource());
		germ.setInstituteCode(entity.getInstituteCode());
		germ.setInstituteName(entity.getInstituteName());
		germ.setPedigree(entity.getPedigree() == null ? null : entity.getPedigree().getPedigree());
		germ.setSpecies(entity.getSpecies());
		germ.setSpecies(entity.getSpecies());
		germ.setSpeciesAuthority(entity.getSpeciesAuthority());
		germ.setSubtaxa(entity.getSubtaxa());
		germ.setSubtaxaAuthority(entity.getSubtaxaAuthority());

		germ.setAcquisitionDate(DateUtility.toLocalDate(entity.getAcquisitionDate()));

		List<String> synonyms = entity.getSynonyms() == null ? null
				: Arrays.asList(entity.getSynonyms().split(" *, *"));
//		germ.setSynonyms(synonyms);

		if (entity.getTaxonIds() != null) {
			germ.setTaxonIds(entity.getTaxonIds().stream().map((t) -> {
				TaxonID taxonId = new TaxonID();
				taxonId.setSourceName(t.getSourceName());
				taxonId.setTaxonId(t.getTaxonId());
				return taxonId;
			}).collect(Collectors.toList()));
		}

//		if (entity.getTypeOfGermplasmStorageCode() != null) {
//			germ.setTypeOfGermplasmStorageCode(entity.getTypeOfGermplasmStorageCode().stream().map((code) -> {
//				return code.getStorageCode().toString();
//			}).collect(Collectors.toList()));
//		}

		if (entity.getDonors() != null) {
			germ.setDonors(entity.getDonors().stream().map((d) -> {
				GermplasmNewRequestDonors donor = new GermplasmNewRequestDonors();
				donor.setDonorAccessionNumber(d.getDonorAccessionNumber());
				donor.setDonorInstituteCode(d.getDonorInstituteCode());
				donor.setGermplasmPUI(d.getGermplasmPUI());
				return donor;
			}).collect(Collectors.toList()));
		}

		return germ;
	}

	public Germplasm convertFromEntityToSummary(GermplasmEntity entity, Map<String, String> entryMap) {
		Germplasm germ = new Germplasm();
		germ.setAccessionNumber(entity.getAccessionNumber());
//		germ.setBiologicalStatusOfAccessionCode(Integer.decode(entity.getBiologicalStatusOfAccessionCode()));
		germ.setCommonCropName(entity.getCommonCropName());
		germ.setCountryOfOriginCode(entity.getCountryOfOriginCode());
		germ.setBreedingMethodDbId(entity.getBreedingMethod().getId());
		germ.setDefaultDisplayName(entity.getDefaultDisplayName());
		germ.setDocumentationURL(entity.getDocumentationURL());
//		germ.setEntryNumber(entryMap.get(entity.getId()));
		germ.setGenus(entity.getGenus());
		germ.setGermplasmDbId(entity.getId());
		germ.setGermplasmName(entity.getGermplasmName());
		germ.setGermplasmPUI(entity.getGermplasmPUI());
		germ.setSeedSource(entity.getGermplasmSeedSource());
		germ.setInstituteCode(entity.getInstituteCode());
		germ.setInstituteName(entity.getInstituteName());
		germ.setPedigree(entity.getPedigree() == null ? null : entity.getPedigree().getPedigree());
		germ.setSpecies(entity.getSpecies());
		germ.setSpeciesAuthority(entity.getSpeciesAuthority());
		germ.setSubtaxa(entity.getSubtaxa());
		germ.setSubtaxaAuthority(entity.getSubtaxaAuthority());

		germ.setAcquisitionDate(DateUtility.toLocalDate(entity.getAcquisitionDate()));

		List<String> synonyms = entity.getSynonyms() == null ? null
				: Arrays.asList(entity.getSynonyms().split(" *, *"));
//		germ.setSynonyms(synonyms);

		if (entity.getTaxonIds() != null) {
			germ.setTaxonIds(entity.getTaxonIds().stream().map((t) -> {
				TaxonID taxonId = new TaxonID();
				taxonId.setSourceName(t.getSourceName());
				taxonId.setTaxonId(t.getTaxonId());
				return taxonId;
			}).collect(Collectors.toList()));
		}

//		if (entity.getTypeOfGermplasmStorageCode() != null) {
//			germ.setTypeOfGermplasmStorageCode(entity.getTypeOfGermplasmStorageCode().stream().map((code) -> {
//				return code.getStorageCode().toString();
//			}).collect(Collectors.toList()));
//		}

		if (entity.getDonors() != null) {
			germ.setDonors(entity.getDonors().stream().map((d) -> {
				GermplasmNewRequestDonors donor = new GermplasmNewRequestDonors();
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

	public PedigreeNode searchPedigreeByDbId(String germplasmDbId, String notation, Boolean includeSiblings) {
		PedigreeEntity entity;
		if (notation == null) {
			entity = pedigreeRepository.findByGermplasm_Id(germplasmDbId);
		} else {
			entity = pedigreeRepository.findByGermplasm_IdAndNotation(germplasmDbId, notation);
		}
		PedigreeNode pedigree = new PedigreeNode();
//		pedigree.setCrossingPlan(entity.getCrossingPlan());
//		pedigree.setCrossingYear(entity.getCrossingYear().toString());
//		pedigree.setDefaultDisplayName(entity.getGermplasm().getDefaultDisplayName());
		pedigree.setFamilyCode(entity.getFamilyCode());
		pedigree.setGermplasmDbId(germplasmDbId);
		pedigree.setPedigree(entity.getPedigree());

//		if (entity.getParent1() != null) {
//			pedigree.setParent1Id(entity.getParent1().getGermplasm().getId());
//			pedigree.setParent1DbId(entity.getParent1().getGermplasm().getId());
//			pedigree.setParent1Name(entity.getParent1().getGermplasm().getDefaultDisplayName());
//			pedigree.setParent1Type(Parent1TypeEnum.fromValue(entity.getParent1Type()));
//		}
//		if (entity.getParent2() != null) {
//			pedigree.setParent2Id(entity.getParent2().getGermplasm().getId());
//			pedigree.setParent2DbId(entity.getParent2().getGermplasm().getId());
//			pedigree.setParent2Name(entity.getParent2().getGermplasm().getDefaultDisplayName());
//			pedigree.setParent2Type(Parent2TypeEnum.fromValue(entity.getParent2Type()));
//		}

		pedigree.setSiblings(new ArrayList<>());
		if (includeSiblings != null && includeSiblings && entity.getParent1() != null && entity.getParent2() != null) {
			List<PedigreeEntity> siblingsPage = pedigreeRepository.findSiblings(entity.getParent1().getId(),
					entity.getParent2().getId());
			for (PedigreeEntity sibEntity : siblingsPage) {
				if (sibEntity.getId() != entity.getId()) {
					PedigreeNodeSiblings siblingsItem = new PedigreeNodeSiblings();
//					siblingsItem.setDefaultDisplayName(sibEntity.getGermplasm().getDefaultDisplayName());
					siblingsItem.setGermplasmDbId(sibEntity.getGermplasm().getId());
					pedigree.addSiblingsItem(siblingsItem);
				}
			}
		}
		return pedigree;
	}

	public ProgenyNode searchProgenyByDbId(String germplasmDbId) {
		List<PedigreeEntity> progenyPage = pedigreeRepository.findByParent1_IdOrParent2_Id(germplasmDbId,
				germplasmDbId);
		ProgenyNode result = new ProgenyNode();
		result.setProgeny(new ArrayList<>());
		result.setGermplasmDbId(germplasmDbId);
		progenyPage.forEach(entity -> {
			ProgenyNodeProgeny progeny = new ProgenyNodeProgeny();
//			progeny.setDefaultDisplayName(entity.getGermplasm().getDefaultDisplayName());
			progeny.setGermplasmDbId(entity.getGermplasm().getId());
			if (entity.getParent1().getGermplasm().getId() == germplasmDbId) {
				progeny.setParentType(ParentTypeEnum.fromValue(entity.getParent1Type()));
//				result.setDefaultDisplayName(entity.getParent1().getGermplasm().getDefaultDisplayName());
			} else {
				progeny.setParentType(ParentTypeEnum.fromValue(entity.getParent2Type()));
//				result.setDefaultDisplayName(entity.getParent2().getGermplasm().getDefaultDisplayName());
			}
			result.getProgeny().add(progeny);
		});

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
		bm.setBreedingMethodName(entity.getName());
		bm.setBreedingMethodName(entity.getName());
		return bm;
	}

	public GermplasmMCPD searchMCPDByDbId(String germplasmDbId) {
		Optional<GermplasmEntity> germOpt = germplasmRepository.findById(germplasmDbId);
		GermplasmMCPD mcpd = null;
		if (germOpt.isPresent()) {
			mcpd = convertFromEntityToMCPD(germOpt.get());
		}
		return mcpd;
	}

	private GermplasmMCPD convertFromEntityToMCPD(GermplasmEntity entity) {
		GermplasmMCPD mcpd = new GermplasmMCPD();
		mcpd.setAccessionNames(Arrays.asList(entity.getGermplasmName()));
		mcpd.setAccessionNumber(entity.getAccessionNumber());
//		mcpd.setAcquisitionDate(DateUtility.toDateString(entity.getAcquisitionDate()));
//		mcpd.setAcquisitionSourceCode(AcquisitionSourceCodeEnum._11);
		mcpd.setAlternateIDs(Arrays.asList(entity.getId(), entity.getGermplasmPUI(), entity.getAccessionNumber()));
		mcpd.setAncestralData(entity.getPedigree() == null ? null : entity.getPedigree().getPedigree());
//		mcpd.setBiologicalStatusOfAccessionCode(
//				BiologicalStatusOfAccessionCodeEnum.fromValue(entity.getBiologicalStatusOfAccessionCode()));
//		mcpd.setBreedingInstitutes(Arrays.asList(new GermplasmMCPDBreedingInstitutes()
//				.instituteCode(entity.getInstituteCode()).instituteName(entity.getInstituteName())));
		mcpd.setCommonCropName(entity.getCommonCropName());
		mcpd.setCountryOfOrigin(entity.getCountryOfOriginCode());
		mcpd.setGenus(entity.getGenus());
		mcpd.setGermplasmDbId(entity.getId());
		mcpd.setGermplasmPUI(entity.getGermplasmPUI());
		mcpd.setInstituteCode(entity.getInstituteCode());
//		mcpd.setMlsStatus(MlsStatusEnum._0);
		mcpd.setRemarks(entity.getDefaultDisplayName());
//		mcpd.setSafetyDuplicateInstitues(Arrays.asList(new GermplasmMCPDSafetyDuplicateInstitues()
//				.instituteCode(entity.getInstituteCode()).instituteName(entity.getInstituteName())));
		mcpd.setSpecies(entity.getSpecies());
		mcpd.setSpeciesAuthority(entity.getSpeciesAuthority());
		mcpd.setSubtaxon(entity.getSubtaxa());
		mcpd.setSubtaxonAuthority(entity.getSubtaxaAuthority());

//		mcpd.setStorageTypeCodes(entity.getTypeOfGermplasmStorageCode().stream().map((e) -> {
//			StorageTypeCodesEnum code = StorageTypeCodesEnum.fromValue(e.getStorageCode().toString());
//			return code;
//		}).collect(Collectors.toList()));

		mcpd.setCollectingInfo(
				new GermplasmMCPDCollectingInfo().collectingDate(DateUtility.toLocalDate(entity.getAcquisitionDate()))
						.collectingInstitutes(Arrays.asList(new GermplasmMCPDCollectingInfoCollectingInstitutes()
								.instituteAddress(entity.getInstituteName()).instituteCode(entity.getInstituteCode())
								.instituteName(entity.getInstituteName())))
						.collectingMissionIdentifier(entity.getId()).collectingNumber(entity.getAccessionNumber())
						.collectingSite(new GermplasmMCPDCollectingInfoCollectingSite()
								.coordinateUncertainty("20m")
								.elevation("20m")
								.georeferencingMethod("WGS84")
								.latitudeDecimal("+42.445295")
								.longitudeDecimal("-076.471934")
								.latitudeDegrees("42 26 43.1 N")
								.longitudeDegrees("76 28 19.0 W")
								.locationDescription(entity.getInstituteName())
								.spatialReferenceSystem("WGS84")));

		mcpd.setDonorInfo(new GermplasmMCPDDonorInfo().donorAccessionNumber(entity.getAccessionNumber())
				.donorInstitute(new GermplasmMCPDDonorInfoDonorInstitute().instituteCode(entity.getInstituteCode())
						.instituteName(entity.getInstituteName())));

		return mcpd;
	}

	public GermplasmEntity getGermplasmEntity(String germplasmDbId) {
		// TODO Auto-generated method stub
		return null;
	}
}
