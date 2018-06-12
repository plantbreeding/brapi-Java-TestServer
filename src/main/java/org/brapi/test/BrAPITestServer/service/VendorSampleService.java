package org.brapi.test.BrAPITestServer.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.model.entity.PlateEntity;
import org.brapi.test.BrAPITestServer.model.entity.SampleEntity;
import org.brapi.test.BrAPITestServer.model.entity.TaxonEntity;
import org.brapi.test.BrAPITestServer.model.entity.vendor.VendorSpecEntity;
import org.brapi.test.BrAPITestServer.model.entity.vendor.VendorSpecStandardRequirementEntity;
import org.brapi.test.BrAPITestServer.repository.SampleRepository;
import org.brapi.test.BrAPITestServer.repository.TaxonRepository;
import org.brapi.test.BrAPITestServer.repository.VendorSampleRepository;
import org.brapi.test.BrAPITestServer.repository.VendorSpecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.TaxonID;
import io.swagger.model.VendorPlate;
import io.swagger.model.VendorPlateFile;
import io.swagger.model.VendorPlateRequest;
import io.swagger.model.VendorPlateRequestPlates;
import io.swagger.model.VendorPlateRequestSamples;
import io.swagger.model.VendorPlateSearchRequest;
import io.swagger.model.VendorSample;
import io.swagger.model.VendorSpecification;
import io.swagger.model.VendorSpecificationPlatform;
import io.swagger.model.VendorSpecificationPlatformDeliverables;
import io.swagger.model.VendorSpecificationPlatformStatuses;
import io.swagger.model.VendorSpecificationReferenceSystem;
import io.swagger.model.VendorSpecificationStandardRequirement;
import io.swagger.model.VendorSpecificationStandardRequirementBlankWellPosition;

@Service
public class VendorSampleService {
	private VendorSampleRepository vendorSampleRepository;
	private SampleRepository sampleRepository;
	private TaxonRepository taxonRepository;
	private VendorSpecRepository vendorSpecRepository;

	@Autowired
	public VendorSampleService(VendorSampleRepository vendorSampleRepository, SampleRepository sampleRepository,
			TaxonRepository taxonRepository, VendorSpecRepository vendorSpecRepository) {
		this.vendorSampleRepository = vendorSampleRepository;
		this.sampleRepository = sampleRepository;
		this.taxonRepository = taxonRepository;
		this.vendorSpecRepository = vendorSpecRepository;
	}

	public VendorPlate getPlate(String vendorPlateDbId) {
		Optional<PlateEntity> plateOpt = vendorSampleRepository.findById(vendorPlateDbId);
		VendorPlate plate = null;
		if (plateOpt.isPresent()) {
			plate = convertFromEntity(plateOpt.get());
		}
		return plate;
	}

	public List<VendorPlate> savePlates(VendorPlateRequest request) {
		List<VendorPlate> storedPlates = new ArrayList<VendorPlate>();
		for (VendorPlateRequestPlates newPlate : request.getPlates()) {
			PlateEntity plateEntity = convertToEntity(newPlate);
			PlateEntity storedPlateEntity = vendorSampleRepository.save(plateEntity);
			
			String vendorPlateDbId = storedPlateEntity.getId();
			List<SampleEntity> storedSamples = saveVendorSamples(newPlate.getSamples(), vendorPlateDbId);
			storedPlateEntity.setSamples(storedSamples);
			
			storedPlates.add(convertFromEntity(storedPlateEntity));
		}
		return storedPlates;
	}

	private List<SampleEntity> saveVendorSamples(List<VendorPlateRequestSamples> samples, String vendorPlateDbId) {
		List<SampleEntity> storedSamples = new ArrayList<>();
		for (VendorPlateRequestSamples newSample : samples) {

			TaxonEntity taxon = new TaxonEntity();
			taxon.setSourceName(newSample.getTaxonId().getSourceName());
			taxon.setTaxonId(newSample.getTaxonId().getTaxonId());
			TaxonEntity storedTaxon = taxonRepository.save(taxon);
			
			SampleEntity sampleEntity = convertToEntity(newSample);
			PlateEntity plate = vendorSampleRepository.findById(vendorPlateDbId).orElse(new PlateEntity());
			sampleEntity.setPlate(plate);
			sampleEntity.setTaxonId(storedTaxon);
			storedSamples.add(sampleRepository.save(sampleEntity));
		}
		return storedSamples;
	}

	private SampleEntity convertToEntity(VendorPlateRequestSamples newSample) {
		SampleEntity sampleEntity = new SampleEntity();
		sampleEntity.setConcentration(newSample.getConcentration());
		sampleEntity.setPlateIndex(Integer.parseInt(newSample.getWell()));
		sampleEntity.setTissueType(newSample.getTissueType());
		sampleEntity.setVolume(newSample.getVolume());
		return sampleEntity;
	}

	private VendorPlate convertFromEntity(PlateEntity entity) {
		VendorPlate plate = new VendorPlate();
		plate.setClientPlateDbId(entity.getClientPlateDbId());
		plate.setPlateFormat(entity.getPlateFormat());
		plate.setSampleType(entity.getSampleType());
		plate.setStatus(entity.getStatus());
		plate.setStatusTimeStamp(DateUtility.toOffsetDateTime(entity.getStatusTimeStamp()));
		plate.setVendorBarcode(entity.getVendorBarcode());
		plate.setVendorBarcodeImageURL(entity.getVendorBarcodeImageURL());
		plate.setVendorPlateDbId(entity.getId());
		plate.setVendorProjectDbId(entity.getVendorProjectDbId());
		plate.setSamples(entity.getSamples().stream().map((sampleEntity) -> {
			VendorSample sample = new VendorSample();
			sample.setColumn(String.valueOf(sampleEntity.getPlateIndex() % 12));
			sample.setConcentration(sampleEntity.getConcentration());
			sample.setRow(String.valueOf(sampleEntity.getPlateIndex() / 12));
			sample.setSampleDbId(sampleEntity.getId());
			sample.setTissueType(sampleEntity.getTissueType());
			sample.setVolume(sampleEntity.getVolume());
			sample.setWell(String.valueOf(sampleEntity.getPlateIndex()));

			TaxonID taxon = new TaxonID();
			taxon.setSourceName(sampleEntity.getTaxonId().getSourceName());
			taxon.setTaxonId(sampleEntity.getTaxonId().getTaxonId());
			sample.setTaxonId(taxon);

			return sample;
		}).collect(Collectors.toList()));
		
		plate.setFiles(entity.getFiles().stream().map((fileEntity) -> {
			VendorPlateFile file = new VendorPlateFile();
			file.setAdditionalInfo(null);
			file.setFilename(fileEntity.getFilename());
			file.setFileType(fileEntity.getFileType());
			file.setMd5sum(fileEntity.getMd5sum());
			file.setSampleDbIds(fileEntity.getSamples().stream()
					.map((e) -> {return e.getId();})
					.collect(Collectors.toList()));
			file.setURL(fileEntity.getURL());
			
			return file;
		}).collect(Collectors.toList()));

		return plate;
	}

	private PlateEntity convertToEntity(VendorPlateRequestPlates newPlate) {
		PlateEntity plateEntity = new PlateEntity();
		plateEntity.setClientPlateDbId(newPlate.getClientPlateDbId());
		plateEntity.setPlateFormat(newPlate.getPlateFormat());
		plateEntity.setSampleType(newPlate.getSampleType());
		plateEntity.setVendorProjectDbId(newPlate.getVendorProjectDbId());
		return plateEntity;
	}

	public List<VendorPlate> searchPlates(String vendorProjectDbId, String vendorPlateDbId, String clientPlateDbId,
			Boolean sampleInfo, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		Page<PlateEntity> plates = vendorSampleRepository.findBySearch(
				SearchUtility.buildSearchParam(vendorProjectDbId),
				SearchUtility.buildSearchParam(vendorPlateDbId),
				SearchUtility.buildSearchParam(clientPlateDbId),
				pageReq);
		PagingUtility.calculateMetaData(metadata, plates);
		return plates.map((entity) -> {
			if(sampleInfo == null || !sampleInfo) {
				entity.getSamples().clear();
			}
			return entity;
		}).map(this :: convertFromEntity).getContent();
	}

	public List<VendorPlate> searchPlates(VendorPlateSearchRequest request, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		Page<PlateEntity> plates = vendorSampleRepository.findBySearch(
				SearchUtility.buildSearchParam(request.getVendorProjectDbIds()),
				SearchUtility.buildSearchParam(request.getVendorPlateDbIds()),
				SearchUtility.buildSearchParam(request.getClientPlateDbIds()),
				pageReq);
		PagingUtility.calculateMetaData(metadata, plates);
		boolean includeSampleList = request.isSampleInfo() == null ? true : request.isSampleInfo();
		List<VendorPlate> data = plates.map((entity) -> {
			if(! includeSampleList) {
				entity.getSamples().clear();
			}
			return entity;
		}).map(this :: convertFromEntity).getContent();
		
		return data;
	}

	public VendorSpecification getVendorSpec() {
		Optional<VendorSpecEntity> vendorSpecOpt = vendorSpecRepository.findById("1");
		VendorSpecification spec = null;
		if(vendorSpecOpt.isPresent()) {
			spec = convertFromEntity(vendorSpecOpt.get());
		}
		return spec;
	}

	private VendorSpecification convertFromEntity(VendorSpecEntity specEntity) {
		VendorSpecification spec = new VendorSpecification();
		spec.setAdditionalInfo(new HashMap<>());
		spec.setContactName(specEntity.getContactName());
		spec.setVendorAddress(specEntity.getVendorAddress());
		spec.setVendorCity(specEntity.getVendorCity());
		spec.setVendorCountry(specEntity.getVendorCountry());
		spec.setVendorDescription(specEntity.getVendorDescription());
		spec.setVendorEmail(specEntity.getVendorEmail());
		spec.setVendorName(specEntity.getVendorName());
		spec.setVendorPhone(specEntity.getVendorPhone());
		spec.setVendorURL(specEntity.getVendorURL());
		
		spec.setPlatforms(specEntity.getPlatforms().stream().map((platformEntity) -> {
			VendorSpecificationPlatform platform = new VendorSpecificationPlatform();
			platform.setContactEmail(platformEntity.getContactEmail());
			platform.setContactName(platformEntity.getContactName());
			platform.setContactPhone(platformEntity.getContactPhone());
			platform.setPlatformDescription(platformEntity.getPlatformDescription());
			platform.setPlatformName(platformEntity.getPlatformName());
			platform.setPlatformURL(platformEntity.getPlatformURL());
			platform.setShippingAddress(platformEntity.getShippingAddress());
			platform.setSpecificRequirements(new HashMap<>());
			
			platform.setDeliverables(platformEntity.getDeliverables().stream().map((deliverableEntity) -> {
				VendorSpecificationPlatformDeliverables deliverable = new VendorSpecificationPlatformDeliverables();
				deliverable.setDescription(deliverableEntity.getDescription());
				deliverable.setFormat(deliverableEntity.getFormat());
				deliverable.setName(deliverableEntity.getName());
				return deliverable;
			}).collect(Collectors.toList()));

			platform.setStatuses(platformEntity.getStatuses().stream().map((statusEntity) -> {
				VendorSpecificationPlatformStatuses status = new VendorSpecificationPlatformStatuses();
				status.setStatusDescription(statusEntity.getStatusDescription());
				status.setStatusName(statusEntity.getStatusName());
				return status;
			}).collect(Collectors.toList()));
			
			VendorSpecificationStandardRequirement requirement = new VendorSpecificationStandardRequirement();
			VendorSpecStandardRequirementEntity requirementEntity = platformEntity.getStandardRequirements();
			requirement.setInputFormatDetails(requirementEntity.getInputFormatDetails());
			requirement.setMaxConcentration(requirementEntity.getMaxConcentration());
			requirement.setMinConcentration(requirementEntity.getMinConcentration());
			requirement.setMinSampleNumber(requirementEntity.getMinSampleNumber());
			requirement.setMaxVolume(requirementEntity.getMaxVolume());
			requirement.setMinVolume(requirementEntity.getMinVolume());
			requirement.setPlateOrientation(requirementEntity.getPlateOrientation());
			requirement.setSampleTypeDetails(requirementEntity.getSampleTypeDetails());
			VendorSpecificationStandardRequirementBlankWellPosition blankWell = new VendorSpecificationStandardRequirementBlankWellPosition();
			blankWell.setNumberOfBlanksPerPlate(requirementEntity.getBlankWellPositions().size());
			blankWell.setPositions(requirementEntity.getBlankWellPositions().stream()
					.map((e) -> {return e.getPosition();})
					.collect(Collectors.toList()));
			requirement.setBlankWellPosition(blankWell);
			requirement.setInputFormats(requirementEntity.getInputFormats().stream()
					.map((e) -> {return e.getInputFormat();})
					.collect(Collectors.toList()));
			requirement.setSampleTypes(requirementEntity.getSampleTypes().stream()
					.map((e) -> {return e.getSampleType();})
					.collect(Collectors.toList()));
			platform.setStandardRequirements(requirement);
			
			platform.setTaxonomyIdSystem(new VendorSpecificationReferenceSystem());
			platform.getTaxonomyIdSystem().setName(platformEntity.getTaxonomyIdSystemName());
			platform.getTaxonomyIdSystem().setURI(platformEntity.getTaxonomyIdSystemURI());
			platform.setTissueIdSystem(new VendorSpecificationReferenceSystem());
			platform.getTissueIdSystem().setName(platformEntity.getTissueIdSystemName());
			platform.getTissueIdSystem().setURI(platformEntity.getTissueIdSystemURI());

			return platform;
		}).collect(Collectors.toList()));
		
		return spec;
	}

}
