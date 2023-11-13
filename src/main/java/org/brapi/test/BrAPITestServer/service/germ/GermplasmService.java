package org.brapi.test.BrAPITestServer.service.germ;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import io.swagger.model.germ.*;
import jakarta.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import org.brapi.test.BrAPITestServer.model.entity.ExternalReferenceEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.CropEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.*;
import org.brapi.test.BrAPITestServer.model.entity.germ.GermplasmInstituteEntity.InstituteTypeEnum;
import org.brapi.test.BrAPITestServer.model.entity.pheno.TaxonEntity;
import org.brapi.test.BrAPITestServer.repository.germ.GermplasmDonorRepository;
import org.brapi.test.BrAPITestServer.repository.germ.GermplasmRepository;
import org.brapi.test.BrAPITestServer.service.DateUtility;
import org.brapi.test.BrAPITestServer.service.GeoJSONUtility;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.brapi.test.BrAPITestServer.service.UpdateUtility;
import org.brapi.test.BrAPITestServer.service.core.CropService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.IndexPagination;
import io.swagger.model.Metadata;
import io.swagger.model.germ.GermplasmMCPD.AcquisitionSourceCodeEnum;
import io.swagger.model.germ.GermplasmMCPD.MlsStatusEnum;

@Service
public class GermplasmService {
	private static final Logger log = LoggerFactory.getLogger(GermplasmService.class);
	private final GermplasmRepository germplasmRepository;
	private final GermplasmDonorRepository donorRepository;
	private final BreedingMethodService breedingMethodService;
	private final CropService cropService;

	@Autowired
	public GermplasmService(GermplasmRepository germplasmRepository, GermplasmDonorRepository donorRepository,
			BreedingMethodService breedingMethodService, CropService cropService) {
		this.germplasmRepository = germplasmRepository;
		this.donorRepository = donorRepository;

		this.breedingMethodService = breedingMethodService;
		this.cropService = cropService;
	}

	public List<Germplasm> findGermplasm(String germplasmPUI, String germplasmDbId, String germplasmName,
			String accessionNumber, String collection, String binomialName, String genus, String species,
			String trialDbId, String studyDbId, String synonym, String parentDbId, String progenyDbId,
			String commonCropName, String programDbId, String externalReferenceId, String externalReferenceID,
			String externalReferenceSource, Metadata metadata) {

		GermplasmSearchRequest request = new GermplasmSearchRequest();
		if (germplasmPUI != null)
			request.addGermplasmPUIsItem(germplasmPUI);
		if (germplasmDbId != null)
			request.addGermplasmDbIdsItem(germplasmDbId);
		if (germplasmName != null)
			request.addGermplasmNamesItem(germplasmName);
		if (accessionNumber != null)
			request.addAccessionNumbersItem(accessionNumber);
		if (collection != null)
			request.addCollectionsItem(collection);
		if (binomialName != null)
			request.addBinomialNamesItem(binomialName);
		if (genus != null)
			request.addGenusItem(genus);
		if (species != null)
			request.addSpeciesItem(species);
		if (trialDbId != null)
			request.addTrialDbIdsItem(trialDbId);
		if (studyDbId != null)
			request.addStudyDbIdsItem(studyDbId);
		if (synonym != null)
			request.addSynonymsItem(synonym);
		if (parentDbId != null)
			request.addParentDbIdsItem(parentDbId);
		if (progenyDbId != null)
			request.addProgenyDbIdsItem(progenyDbId);
		if (commonCropName != null)
			request.addCommonCropNamesItem(commonCropName);
		if (programDbId != null)
			request.addProgramDbIdsItem(programDbId);

		request.addExternalReferenceItem(externalReferenceId, externalReferenceID, externalReferenceSource);

		return findGermplasm(request, metadata);
	}

	public List<Germplasm> findGermplasm(@Valid GermplasmSearchRequest request, Metadata metadata) {
		log.debug("starting germplasm search");
		Page<GermplasmEntity> page = findGermplasmEntities(request, metadata);
		log.debug("germplasm search complete, converting germplasm entities");
		List<Germplasm> germplasms = page.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, page);
		log.debug("done converting");
		return germplasms;
	}

	public Page<GermplasmEntity> findGermplasmEntities(@Valid GermplasmSearchRequest request, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<GermplasmEntity> searchQuery = new SearchQueryBuilder<GermplasmEntity>(
				GermplasmEntity.class);
		searchQuery.leftJoinFetch("synonyms", "synonyms")
				.leftJoinFetch("breedingMethod", "breedingMethod")
				.leftJoinFetch("crop", "crop")
				.leftJoinFetch("pedigree", "pedigree")
				.leftJoinFetch("*pedigree.crossingProject", "crossingProject");

		if (request.getProgramDbIds() != null || request.getProgramNames() != null || request.getTrialDbIds() != null
				|| request.getTrialNames() != null || request.getStudyDbIds() != null
				|| request.getStudyNames() != null) {
			searchQuery = searchQuery.join("observationUnits", "obsunit")
					.appendList(request.getProgramDbIds(), "*obsunit.program.id")
					.appendList(request.getProgramNames(), "*obsunit.program.name")
					.appendList(request.getTrialDbIds(), "*obsunit.trial.id")
					.appendList(request.getTrialNames(), "*obsunit.trial.name")
					.appendList(request.getStudyDbIds(), "*obsunit.study.id")
					.appendList(request.getStudyNames(), "*obsunit.study.studyName");
		}
		if (request.getSynonyms() != null) {
			searchQuery = searchQuery.join("synonyms", "synonym").appendList(request.getSynonyms(), "*synonym.synonym");
		}
		if (request.getInstituteCodes() != null) {
			searchQuery = searchQuery.join("institutes", "institute").appendList(request.getSynonyms(),
					"*institute.instituteCode");
		}

		searchQuery.withExRefs(request.getExternalReferenceIDs(), request.getExternalReferenceSources())
				.appendList(request.getAccessionNumbers(), "accessionNumber")
				.appendList(request.getCollections(), "collection")
				.appendList(request.getCommonCropNames(), "crop.cropName").appendList(request.getGermplasmDbIds(), "id")
				.appendList(request.getGermplasmNames(), "germplasmName")
				.appendList(request.getGermplasmPUIs(), "germplasmPUI")
				.appendList(request.getParentDbIds(), "pedigree.parent1.germplasm.id")
				// .appendList(request.getProgenyDbIds(), "*progeny.germplasmDbId")
				.appendList(request.getGenus(), "genus").appendList(request.getSpecies(), "species")
				.appendNamesList(request.getBinomialNames(), "genus", "genus", "species")
				.appendList(request.getFamilyCodes(), "familyCode");

		Page<GermplasmEntity> page = germplasmRepository.findAllBySearch(searchQuery, pageReq);

		if(!page.isEmpty()) {
			log.debug("fetching xrefs");
			fetchXrefs(page);
			log.debug("fetching attributes");
			fetchAttributes(page);
			log.debug("fetching donors");
			fetchDonors(page);
			log.debug("fetching origins");
			fetchOrigin(page);
			log.debug("fetching institutes");
			fetchInstitutes(page);
			log.debug("fetching taxons");
			fetchTaxons(page);
			log.debug("fetching storage codes");
			fetchStorageCodes(page);
			log.debug("fetching pedigree edges");
			fetchPedigreeEdges(page);
		}

		return page;
	}

	private void fetchXrefs(Page<GermplasmEntity> page) {
		SearchQueryBuilder<GermplasmEntity> searchQuery = new SearchQueryBuilder<GermplasmEntity>(GermplasmEntity.class);
		searchQuery.leftJoinFetch("externalReferences", "externalReferences")
				.leftJoinFetch("pedigree", "pedigree")
				   .appendList(page.stream().map(BrAPIBaseEntity::getId).collect(Collectors.toList()), "id");

		Page<GermplasmEntity> xrefs = germplasmRepository.findAllBySearch(searchQuery, PageRequest.of(0, page.getSize()));

		Map<String, List<ExternalReferenceEntity>> xrefByEntity = new HashMap<>();
		xrefs.forEach(entity -> xrefByEntity.put(entity.getId(), entity.getExternalReferences()));

		page.forEach(entity -> entity.setExternalReferences(xrefByEntity.get(entity.getId())));
	}

	private void fetchAttributes(Page<GermplasmEntity> page) {
		SearchQueryBuilder<GermplasmEntity> searchQuery = new SearchQueryBuilder<GermplasmEntity>(
				GermplasmEntity.class);
		searchQuery.leftJoinFetch("attributes", "attributes")
				   .appendList(page.stream().map(BrAPIBaseEntity::getId).collect(Collectors.toList()), "id");

		Page<GermplasmEntity> attributes = germplasmRepository.findAllBySearch(searchQuery, PageRequest.of(0, page.getSize()));

		Map<String, List<GermplasmAttributeValueEntity>> attributesByGerm = new HashMap<>();
		attributes.forEach(germ -> attributesByGerm.put(germ.getId(), germ.getAttributes()));

		page.forEach(germ -> germ.setAttributes(attributesByGerm.get(germ.getId())));
	}

	private void fetchDonors(Page<GermplasmEntity> page) {
		SearchQueryBuilder<GermplasmEntity> searchQuery = new SearchQueryBuilder<GermplasmEntity>(
				GermplasmEntity.class);
		searchQuery.leftJoinFetch("donors", "donors")
				   .appendList(page.stream().map(BrAPIBaseEntity::getId).collect(Collectors.toList()), "id");

		Page<GermplasmEntity> donors = germplasmRepository.findAllBySearch(searchQuery, PageRequest.of(0, page.getSize()));

		Map<String, List<DonorEntity>> donorsByGerm = new HashMap<>();
		donors.forEach(germ -> donorsByGerm.put(germ.getId(), germ.getDonors()));

		page.forEach(germ -> germ.setDonors(donorsByGerm.get(germ.getId())));
	}

	private void fetchOrigin(Page<GermplasmEntity> page) {
		SearchQueryBuilder<GermplasmEntity> searchQuery = new SearchQueryBuilder<GermplasmEntity>(
				GermplasmEntity.class);
		searchQuery.leftJoinFetch("germplasmOrigin", "germplasmOrigin")
				   .appendList(page.stream().map(BrAPIBaseEntity::getId).collect(Collectors.toList()), "id");

		Page<GermplasmEntity> origins = germplasmRepository.findAllBySearch(searchQuery, PageRequest.of(0, page.getSize()));

		Map<String, List<GermplasmOriginEntity>> originsByGerm = new HashMap<>();
		origins.forEach(germ -> originsByGerm.put(germ.getId(), germ.getGermplasmOrigin()));

		page.forEach(germ -> germ.setGermplasmOrigin(originsByGerm.get(germ.getId())));
	}

	private void fetchInstitutes(Page<GermplasmEntity> page) {
		SearchQueryBuilder<GermplasmEntity> searchQuery = new SearchQueryBuilder<GermplasmEntity>(
				GermplasmEntity.class);
		searchQuery.leftJoinFetch("institutes", "institutes")
				   .appendList(page.stream().map(BrAPIBaseEntity::getId).collect(Collectors.toList()), "id");

		Page<GermplasmEntity> institutes = germplasmRepository.findAllBySearch(searchQuery, PageRequest.of(0, page.getSize()));

		Map<String, List<GermplasmInstituteEntity>> institutesByGerm = new HashMap<>();
		institutes.forEach(germ -> institutesByGerm.put(germ.getId(), germ.getInstitutes()));

		page.forEach(germ -> germ.setInstitutes(institutesByGerm.get(germ.getId())));
	}

	private void fetchTaxons(Page<GermplasmEntity> page) {
		SearchQueryBuilder<GermplasmEntity> searchQuery = new SearchQueryBuilder<GermplasmEntity>(
				GermplasmEntity.class);
		searchQuery.leftJoinFetch("taxonIds", "taxonIds")
				   .appendList(page.stream().map(BrAPIBaseEntity::getId).collect(Collectors.toList()), "id");

		Page<GermplasmEntity> taxonIds = germplasmRepository.findAllBySearch(searchQuery, PageRequest.of(0, page.getSize()));

		Map<String, List<TaxonEntity>> taxonIdsByGerm = new HashMap<>();
		taxonIds.forEach(germ -> taxonIdsByGerm.put(germ.getId(), germ.getTaxonIds()));

		page.forEach(germ -> germ.setTaxonIds(taxonIdsByGerm.get(germ.getId())));
	}

	private void fetchStorageCodes(Page<GermplasmEntity> page) {
		SearchQueryBuilder<GermplasmEntity> searchQuery = new SearchQueryBuilder<GermplasmEntity>(
				GermplasmEntity.class);
		searchQuery.leftJoinFetch("typeOfGermplasmStorageCode", "typeOfGermplasmStorageCode")
				   .appendList(page.stream().map(BrAPIBaseEntity::getId).collect(Collectors.toList()), "id");

		Page<GermplasmEntity> storageCodes = germplasmRepository.findAllBySearch(searchQuery, PageRequest.of(0, page.getSize()));

		Map<String, List<GermplasmStorageTypesEnum>> storageCodesByGerm = new HashMap<>();
		storageCodes.forEach(germ -> storageCodesByGerm.put(germ.getId(), germ.getTypeOfGermplasmStorageCode()));

		page.forEach(germ -> germ.setTypeOfGermplasmStorageCode(storageCodesByGerm.get(germ.getId())));
	}

	private void fetchPedigreeEdges(Page<GermplasmEntity> page) {
		SearchQueryBuilder<GermplasmEntity> searchQuery = new SearchQueryBuilder<GermplasmEntity>(
				GermplasmEntity.class);
		searchQuery.leftJoinFetch("pedigree", "pedigree")
				   .leftJoinFetch("*pedigree.crossingProject", "crossingProject")
				   .leftJoinFetch("*pedigree.edges", "pedigreeEdges")
				   .leftJoinFetch("*pedigreeEdges.conncetedNode", "connectedNode")
				   .appendList(page.stream()
								   .map(BrAPIBaseEntity::getId)
								   .collect(Collectors.toList()), "id");

		Page<GermplasmEntity> pedigree = germplasmRepository.findAllBySearch(searchQuery, PageRequest.of(0, page.getSize()));

		Map<String, PedigreeNodeEntity> pedigreeByGerm = new HashMap<>();
		pedigree.forEach(germ -> pedigreeByGerm.put(germ.getId(), germ.getPedigree()));

		page.forEach(germ -> {
			germ.setPedigree(pedigreeByGerm.get(germ.getId()));
		});
	}

	public Germplasm getGermplasm(String germplasmDbId) throws BrAPIServerException {
		return convertFromEntity(getGermplasmEntity(germplasmDbId, HttpStatus.NOT_FOUND));
	}

	public GermplasmMCPD getGermplasmMCPD(String germplasmDbId) throws BrAPIServerException {
		return convertFromEntityToMCPD(getGermplasmEntity(germplasmDbId, HttpStatus.NOT_FOUND));
	}

	public GermplasmEntity getGermplasmEntity(String germplasmDbId) throws BrAPIServerException {
		return getGermplasmEntity(germplasmDbId, HttpStatus.BAD_REQUEST);
	}

	public GermplasmEntity getGermplasmEntity(String germplasmDbId, HttpStatus errorStatus)
			throws BrAPIServerException {
		GermplasmEntity germplasm = null;
		Optional<GermplasmEntity> entityOpt = germplasmRepository.findById(germplasmDbId);
		if (entityOpt.isPresent()) {
			germplasm = entityOpt.get();
			germplasmRepository.refresh(germplasm);
		} else {
			throw new BrAPIServerDbIdNotFoundException("germplasm", germplasmDbId, errorStatus);
		}
		return germplasm;
	}

	public Germplasm updateGermplasm(String germplasmDbId, GermplasmNewRequest body)
			throws BrAPIServerException {
		GermplasmEntity entity = getGermplasmEntity(germplasmDbId, HttpStatus.NOT_FOUND);
		updateEntity(entity, body);
		GermplasmEntity savedEntity = germplasmRepository.saveAndFlush(entity);

		return convertFromEntity(savedEntity);
	}

	// TODO: evaluate performance!
	public List<Germplasm> saveGermplasm(@Valid List<GermplasmNewRequest> body) throws BrAPIServerException {
		List<GermplasmEntity> toSave = new ArrayList<>();
		for (GermplasmNewRequest germplasm : body) {
			GermplasmEntity entity = new GermplasmEntity();
			updateEntity(entity, germplasm);  // TODO: does updateEntity need to hit the database?
			toSave.add(entity);
		}
		// Save batch.
		return germplasmRepository.saveAllAndFlush(toSave)
				.stream()
				.map(this::convertFromEntity)
				.collect(Collectors.toList());
	}

	private Germplasm convertFromEntity(GermplasmEntity entity) {
		Germplasm germ = new Germplasm();
		UpdateUtility.convertFromEntity(entity, germ);

		germ.setAccessionNumber(entity.getAccessionNumber());
		germ.setAcquisitionDate(DateUtility.toLocalDate(entity.getAcquisitionDate()));
		if (entity.getBiologicalStatusOfAccessionCode() != null) {
			germ.setBiologicalStatusOfAccessionCode(entity.getBiologicalStatusOfAccessionCode());
			germ.setBiologicalStatusOfAccessionDescription(
					entity.getBiologicalStatusOfAccessionCode().getDescription());
		}
		if (entity.getBreedingMethod() != null) {
			germ.setBreedingMethodDbId(entity.getBreedingMethod().getId());
			germ.setBreedingMethodName(entity.getBreedingMethod().getName());
		}
		germ.setCollection(entity.getCollection());
		if (entity.getCrop() != null)
			germ.setCommonCropName(entity.getCrop().getCropName());
		germ.setCountryOfOriginCode(entity.getCountryOfOriginCode());
		germ.setDefaultDisplayName(entity.getDefaultDisplayName());
		germ.setDocumentationURL(entity.getDocumentationURL());
		if (entity.getDonors() != null)
			germ.setDonors(entity.getDonors().stream().map(this::convertFromEntity).collect(Collectors.toList()));
		germ.setGenus(entity.getGenus());
		germ.setGermplasmDbId(entity.getId());
		germ.setGermplasmName(entity.getGermplasmName());
		if (entity.getGermplasmOrigin() != null)
			germ.setGermplasmOrigin(
					entity.getGermplasmOrigin().stream().map(this::convertFromEntity).collect(Collectors.toList()));
		germ.setGermplasmPreprocessing(entity.getGermplasmPreprocessing());
		germ.setGermplasmPUI(entity.getGermplasmPUI());
		if (entity.getHostInstitute() != null) {
			germ.setInstituteCode(entity.getHostInstitute().getInstituteCode());
			germ.setInstituteName(entity.getHostInstitute().getInstituteName());
		}
		if (entity.getPedigree() != null)
			germ.setPedigree(PedigreeService.getPedigreeString(entity.getPedigree()));
		
		germ.setSeedSource(entity.getSeedSource());
		germ.setSeedSourceDescription(entity.getSeedSourceDescription());
		germ.setSpecies(entity.getSpecies());
		germ.setSpeciesAuthority(entity.getSpeciesAuthority());
		if (entity.getTypeOfGermplasmStorageCode() != null) {
			germ.setStorageTypes(entity.getTypeOfGermplasmStorageCode().stream().map(e -> {
				return new GermplasmStorageTypes(e);
			}).collect(Collectors.toList()));
		}
		germ.setSubtaxa(entity.getSubtaxa());
		germ.setSubtaxaAuthority(entity.getSubtaxaAuthority());
		if (entity.getSynonyms() != null)
			germ.setSynonyms(entity.getSynonyms().stream().map(this::convertFromEntity).collect(Collectors.toList()));
		if (entity.getTaxonIds() != null)
			germ.setTaxonIds(entity.getTaxonIds().stream().map(this::convertFromEntity).collect(Collectors.toList()));

		return germ;
	}

	private void updateEntity(GermplasmEntity entity, GermplasmNewRequest request) throws BrAPIServerException {
		UpdateUtility.updateEntity(request, entity);

		if (request.getAccessionNumber() != null)
			entity.setAccessionNumber(request.getAccessionNumber());
		if (request.getAcquisitionDate() != null) {
			entity.setAcquisitionDate(DateUtility.toDate(request.getAcquisitionDate()));
			entity.setAcquisitionSourceCode(AcquisitionSourceCodeEnum._99);
		}
		if (request.getBiologicalStatusOfAccessionCode() != null)
			entity.setBiologicalStatusOfAccessionCode(request.getBiologicalStatusOfAccessionCode());
		if (request.getBreedingMethodDbId() != null) {
			// TODO: the DbId is all we need to insert.
			BreedingMethodEntity method = new BreedingMethodEntity();
			method.setId(request.getBreedingMethodDbId());
//					breedingMethodService
//					.getBreedingMethodEntity(request.getBreedingMethodDbId());
			entity.setBreedingMethod(method);
		}
		if (request.getCollection() != null)
			entity.setCollection(request.getCollection());
		if (request.getCommonCropName() != null) {
			// TODO: can we drop or batch?
			CropEntity crop = cropService.findCropEntity(request.getCommonCropName());
			if (crop == null) {
				crop = cropService.saveCropEntity(request.getCommonCropName());
			}
			entity.setCrop(crop);
		}
		if (request.getCountryOfOriginCode() != null)
			entity.setCountryOfOriginCode(request.getCountryOfOriginCode());
		if (request.getDefaultDisplayName() != null)
			entity.setDefaultDisplayName(request.getDefaultDisplayName());
		if (request.getDocumentationURL() != null)
			entity.setDocumentationURL(request.getDocumentationURL());
		if (request.getDonors() != null)
			updateDonorEntities(request.getDonors(), entity);
		if (request.getGenus() != null)
			entity.setGenus(request.getGenus());
		if (request.getGermplasmName() != null)
			entity.setGermplasmName(request.getGermplasmName());
		if (request.getGermplasmOrigin() != null)
			updateOriginEntities(request.getGermplasmOrigin(), entity);
		if (request.getGermplasmPreprocessing() != null)
			entity.setGermplasmPreprocessing(request.getGermplasmPreprocessing());
		if (request.getGermplasmPUI() != null)
			entity.setGermplasmPUI(request.getGermplasmPUI());
		if (request.getInstituteCode() != null || request.getInstituteName() != null)
			entity.setHostInstitute(request.getInstituteCode(), request.getInstituteName());
		entity.setMlsStatus(MlsStatusEnum.EMPTY);
		if (request.getPedigree() != null) {
			if(entity.getPedigree() == null) {
				entity.setPedigree(new PedigreeNodeEntity());
			}
			entity.getPedigree().setPedigreeString(request.getPedigree());
		}
		if (request.getSeedSource() != null)
			entity.setSeedSource(request.getSeedSource());
		if (request.getSeedSourceDescription() != null)
			entity.setSeedSourceDescription(request.getSeedSourceDescription());
		if (request.getSpecies() != null)
			entity.setSpecies(request.getSpecies());
		if (request.getSpeciesAuthority() != null)
			entity.setSpeciesAuthority(request.getSpeciesAuthority());
		if (request.getStorageTypes() != null)
			entity.setTypeOfGermplasmStorageCode(request.getStorageTypes().stream().filter(st -> st != null)
					.map(st -> st.getCode()).collect(Collectors.toList()));
		if (request.getSubtaxa() != null)
			entity.setSubtaxa(request.getSubtaxa());
		if (request.getSubtaxaAuthority() != null)
			entity.setSubtaxaAuthority(request.getSubtaxaAuthority());
		if (request.getSynonyms() != null)
			updateSynonymEntities(request.getSynonyms(), entity);
		if (request.getTaxonIds() != null)
			updateTaxonEntities(request.getTaxonIds(), entity);
	}

	private void updateTaxonEntities(List<TaxonID> taxonIds, GermplasmEntity entity) {
		if (entity.getTaxonIds() != null) {
			for (TaxonEntity oldEntity : entity.getTaxonIds()) {
				oldEntity.setGermplasm(null);
			}
		}
		entity.setTaxonIds(new ArrayList<>());
		for (TaxonID taxonId : taxonIds) {
			TaxonEntity newEntity = new TaxonEntity();
			newEntity.setGermplasm(entity);
			newEntity.setSourceName(taxonId.getSourceName());
			newEntity.setTaxonId(taxonId.getTaxonId());
			entity.getTaxonIds().add(newEntity);
		}
	}

	private void updateSynonymEntities(List<GermplasmNewRequestSynonyms> synonyms, GermplasmEntity entity) {
		if (entity.getSynonyms() != null) {
			for (GermplasmSynonymEntity oldEntity : entity.getSynonyms()) {
				oldEntity.setGermplasm(null);
			}
		}
		entity.setSynonyms(new ArrayList<>());
		for (GermplasmNewRequestSynonyms synonym : synonyms) {
			GermplasmSynonymEntity newEntity = new GermplasmSynonymEntity();
			newEntity.setGermplasm(entity);
			newEntity.setSynonym(synonym.getSynonym());
			newEntity.setType(synonym.getType());
			entity.getSynonyms().add(newEntity);
		}
	}

	public GermplasmEntity findByUnknownIdentity(String germplasmStr) {
		List<String> germplasmList = Arrays.asList(germplasmStr);
		Metadata metadata = new Metadata().pagination(new IndexPagination());

		// germplasmDbId
		GermplasmSearchRequest request = new GermplasmSearchRequest().germplasmDbIds(germplasmList);
		Page<GermplasmEntity> page = findGermplasmEntities(request, metadata);
		if (page.hasContent()) {
			return page.getContent().get(0);
		}
		// germplasmNames
		request = new GermplasmSearchRequest().germplasmNames(germplasmList);
		page = findGermplasmEntities(request, metadata);
		if (page.hasContent()) {
			return page.getContent().get(0);
		}
		// synonyms
		request = new GermplasmSearchRequest().synonyms(germplasmList);
		page = findGermplasmEntities(request, metadata);
		if (page.hasContent()) {
			return page.getContent().get(0);
		}
		// accessionNumbers
		request = new GermplasmSearchRequest().accessionNumbers(germplasmList);
		page = findGermplasmEntities(request, metadata);
		if (page.hasContent()) {
			return page.getContent().get(0);
		}
		// germplasmPUIs
		request = new GermplasmSearchRequest().germplasmPUIs(germplasmList);
		page = findGermplasmEntities(request, metadata);
		if (page.hasContent()) {
			return page.getContent().get(0);
		}

		return null;
	}

	private void updateOriginEntities(List<GermplasmOrigin> origins, GermplasmEntity entity) {
		if (entity.getGermplasmOrigin() != null) {
			for (GermplasmOriginEntity oldEntity : entity.getGermplasmOrigin()) {
				oldEntity.setGermplasm(null);
			}
		}
		entity.setGermplasmOrigin(new ArrayList<>());
		for (GermplasmOrigin origin : origins) {
			GermplasmOriginEntity newEntity = new GermplasmOriginEntity();
			newEntity.setGermplasm(entity);
			newEntity.setCoordinateUncertainty(origin.getCoordinateUncertainty());
			newEntity.setCoordinates(GeoJSONUtility.convertToEntity(origin.getCoordinates()));
			entity.getGermplasmOrigin().add(newEntity);
		}
	}

	private void updateDonorEntities(List<GermplasmNewRequestDonors> donors, GermplasmEntity entity) {
		if (entity.getDonors() != null) {
			for (DonorEntity oldEntity : entity.getDonors()) {
				donorRepository.delete(oldEntity);
			}
		}
		entity.setDonors(new ArrayList<>());
		for (GermplasmNewRequestDonors donor : donors) {
			DonorEntity newEntity = new DonorEntity();
			newEntity.setGermplasm(entity);
			newEntity.setDonorAccessionNumber(donor.getDonorAccessionNumber());
			newEntity.setDonorInstituteCode(donor.getDonorInstituteCode());
			newEntity.setDonorInstituteName(donor.getDonorInstituteCode());
			newEntity.setGermplasmPUI(donor.getGermplasmPUI());
			entity.getDonors().add(newEntity);
		}
	}

	private GermplasmNewRequestDonors convertFromEntity(DonorEntity entity) {
		GermplasmNewRequestDonors donor = new GermplasmNewRequestDonors();
		donor.setDonorAccessionNumber(entity.getDonorAccessionNumber());
		donor.setDonorInstituteCode(entity.getDonorInstituteCode());
		donor.setGermplasmPUI(entity.getGermplasmPUI());
		return donor;
	}

	private GermplasmOrigin convertFromEntity(GermplasmOriginEntity entity) {
		GermplasmOrigin origin = new GermplasmOrigin();
		origin.setCoordinates(GeoJSONUtility.convertFromEntity(entity.getCoordinates()));
		origin.setCoordinateUncertainty(entity.getCoordinateUncertainty());
		return origin;
	}

	private GermplasmNewRequestSynonyms convertFromEntity(GermplasmSynonymEntity entity) {
		GermplasmNewRequestSynonyms synonym = new GermplasmNewRequestSynonyms();
		synonym.setSynonym(entity.getSynonym());
		synonym.setType(entity.getType());
		return synonym;
	}

	private TaxonID convertFromEntity(TaxonEntity entity) {
		TaxonID taxonId = new TaxonID();
		taxonId.setSourceName(entity.getSourceName());
		taxonId.setTaxonId(entity.getTaxonId());
		return taxonId;
	}

	private GermplasmMCPD convertFromEntityToMCPD(GermplasmEntity entity) {
		GermplasmMCPD mcpd = new GermplasmMCPD();
		mcpd.setAccessionNames(getAccessionNames(entity));
		mcpd.setAccessionNumber(entity.getAccessionNumber());
		mcpd.setAcquisitionDate(DateUtility.toLocalDate(entity.getAcquisitionDate()));
		mcpd.setAcquisitionSourceCode(entity.getAcquisitionSourceCode());
		mcpd.setAlternateIDs(getAlternateIDs(entity));
		if (entity.getPedigree() != null)
			mcpd.setAncestralData(entity.getPedigree().getPedigreeString());
		mcpd.setBiologicalStatusOfAccessionCode(entity.getBiologicalStatusOfAccessionCode());
		mcpd.setBreedingInstitutes(getBreedingInstitutes(entity.getInstitutes()));
		mcpd.setCollectingInfo(convertFromEntity(entity, entity.getGermplasmOrigin()));
		if (entity.getCrop() != null)
			mcpd.setCommonCropName(entity.getCrop().getCropName());
		mcpd.setCountryOfOrigin(entity.getCountryOfOriginCode());
		if (entity.getDonors() != null)
			mcpd.setDonorInfo(convertFromEntityToMCPD(entity.getDonors()));
		mcpd.setGenus(entity.getGenus());
		mcpd.setGermplasmDbId(entity.getId());
		mcpd.setGermplasmPUI(entity.getGermplasmPUI());
		if (entity.getHostInstitute() != null)
			mcpd.setInstituteCode(entity.getHostInstitute().getInstituteCode());
		mcpd.setMlsStatus(entity.getMlsStatus());
		mcpd.setRemarks(entity.getDefaultDisplayName());
		mcpd.setSpecies(entity.getSpecies());
		mcpd.setSpeciesAuthority(entity.getSpeciesAuthority());
		mcpd.setSubtaxon(entity.getSubtaxa());
		mcpd.setSubtaxonAuthority(entity.getSubtaxaAuthority());
		mcpd.setSafetyDuplicateInstitutes(getRedundantInstitutes(entity.getInstitutes()));
		mcpd.setStorageTypeCodes(entity.getTypeOfGermplasmStorageCode());

		return mcpd;
	}

	private List<String> getAlternateIDs(GermplasmEntity entity) {
		List<String> ids = new ArrayList<>();
		if (entity.getAccessionNumber() != null)
			ids.add(entity.getAccessionNumber());
		if (entity.getId() != null)
			ids.add(entity.getId());
		if (entity.getGermplasmPUI() != null)
			ids.add(entity.getGermplasmPUI());
		if (entity.getSynonyms() != null) {
			for (GermplasmSynonymEntity syn : entity.getSynonyms()) {
				ids.add(syn.getSynonym());
			}
		}

		return ids;
	}

	private List<String> getAccessionNames(GermplasmEntity entity) {
		List<String> names = new ArrayList<>();
		if (entity.getAccessionNumber() != null)
			names.add(entity.getAccessionNumber());
		if (entity.getGermplasmName() != null)
			names.add(entity.getGermplasmName());
		if (entity.getDefaultDisplayName() != null)
			names.add(entity.getDefaultDisplayName());
		if (entity.getSynonyms() != null) {
			for (GermplasmSynonymEntity syn : entity.getSynonyms()) {
				names.add(syn.getSynonym());
			}
		}

		return names;
	}

	private GermplasmMCPDDonorInfo convertFromEntityToMCPD(List<DonorEntity> entityList) {
		GermplasmMCPDDonorInfo donor = null;
		if (entityList != null && entityList.size() > 0) {
			DonorEntity entity = entityList.get(0);
			GermplasmMCPDDonorInfoDonorInstitute institute = new GermplasmMCPDDonorInfoDonorInstitute();
			institute.setInstituteCode(entity.getDonorInstituteCode());
			institute.setInstituteName(entity.getDonorInstituteName());

			donor = new GermplasmMCPDDonorInfo();
			donor.setDonorAccessionNumber(entity.getDonorAccessionNumber());
			donor.setDonorAccessionPui(entity.getGermplasmPUI());
			donor.setDonorInstitute(institute);
		}
		return donor;
	}

	private GermplasmMCPDCollectingInfo convertFromEntity(GermplasmEntity entity,
			List<GermplasmOriginEntity> originList) {
		GermplasmMCPDCollectingInfoCollectingSite site = null;
		if (originList != null && originList.size() > 0) {
			GermplasmOriginEntity origin = originList.get(0);
			site = new GermplasmMCPDCollectingInfoCollectingSite();
			site.setCoordinateUncertainty(origin.getCoordinateUncertainty());
			site.setGeoreferencingMethod("WGS84");
			site.setSpatialReferenceSystem("WGS84");
			site.setElevation(GeoJSONUtility.getElv(origin.getCoordinates()).toPlainString());
			BigDecimal lat = GeoJSONUtility.getLat(origin.getCoordinates());
			BigDecimal lon = GeoJSONUtility.getLon(origin.getCoordinates());
			site.setLatitudeDecimal(lat.toPlainString());
			site.setLatitudeDegrees(GeoJSONUtility.getDegreesStr(lat));
			site.setLongitudeDecimal(lon.toPlainString());
			site.setLongitudeDegrees(GeoJSONUtility.getDegreesStr(lon));
			if (getCollectingInstitutes(entity.getInstitutes()).size() > 0)
				site.setLocationDescription(
						getCollectingInstitutes(entity.getInstitutes()).get(0).getInstituteAddress());
		}

		GermplasmMCPDCollectingInfo info = new GermplasmMCPDCollectingInfo();
		info.setCollectingDate(DateUtility.toLocalDate(entity.getAcquisitionDate()));
		info.setCollectingInstitutes(getCollectingInstitutes(entity.getInstitutes()));
		info.setCollectingMissionIdentifier(entity.getCollection());
		info.setCollectingNumber(entity.getAccessionNumber());
		info.setCollectingSite(site);
		return info;
	}

	private List<GermplasmMCPDBreedingInstitutes> getBreedingInstitutes(List<GermplasmInstituteEntity> institutes) {
		List<GermplasmMCPDBreedingInstitutes> breedingInstitutes = new ArrayList<>();
		for (GermplasmInstituteEntity institute : institutes) {
			if (InstituteTypeEnum.BREEDING.equals(institute.getInstituteType())) {
				GermplasmMCPDBreedingInstitutes breedingInstitute = new GermplasmMCPDBreedingInstitutes();
				breedingInstitute.setInstituteCode(institute.getInstituteCode());
				breedingInstitute.setInstituteName(institute.getInstituteName());
				breedingInstitutes.add(breedingInstitute);
			}
		}
		return breedingInstitutes;
	}

	private List<GermplasmMCPDCollectingInfoCollectingInstitutes> getCollectingInstitutes(
			List<GermplasmInstituteEntity> institutes) {
		List<GermplasmMCPDCollectingInfoCollectingInstitutes> collectingInstitutes = new ArrayList<>();
		for (GermplasmInstituteEntity institute : institutes) {
			if (InstituteTypeEnum.COLLECTING.equals(institute.getInstituteType())) {
				GermplasmMCPDCollectingInfoCollectingInstitutes collectingInstitute = new GermplasmMCPDCollectingInfoCollectingInstitutes();
				collectingInstitute.setInstituteCode(institute.getInstituteCode());
				collectingInstitute.setInstituteName(institute.getInstituteName());
				collectingInstitute.setInstituteAddress(institute.getInstituteAddress());
				collectingInstitutes.add(collectingInstitute);
			}
		}
		return collectingInstitutes;
	}

	private List<GermplasmMCPDSafetyDuplicateInstitutes> getRedundantInstitutes(
			List<GermplasmInstituteEntity> institutes) {
		List<GermplasmMCPDSafetyDuplicateInstitutes> dupInstitutes = new ArrayList<>();
		for (GermplasmInstituteEntity institute : institutes) {
			if (InstituteTypeEnum.REDUNDANT.equals(institute.getInstituteType())) {
				GermplasmMCPDSafetyDuplicateInstitutes dupInstitute = new GermplasmMCPDSafetyDuplicateInstitutes();
				dupInstitute.setInstituteCode(institute.getInstituteCode());
				dupInstitute.setInstituteName(institute.getInstituteName());
				dupInstitutes.add(dupInstitute);
			}
		}
		return dupInstitutes;
	}

}
