package org.brapi.test.BrAPITestServer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.model.entity.PlateEntity;
import org.brapi.test.BrAPITestServer.model.entity.SampleEntity;
import org.brapi.test.BrAPITestServer.model.entity.TaxonEntity;
import org.brapi.test.BrAPITestServer.model.entity.vendor.VendorSpecEntity;
import org.brapi.test.BrAPITestServer.model.entity.vendor.VendorSpecStandardRequirementEntity;
import org.brapi.test.BrAPITestServer.model.rest.TaxonID;
import org.brapi.test.BrAPITestServer.model.rest.VendorPlate;
import org.brapi.test.BrAPITestServer.model.rest.VendorPlateFile;
import org.brapi.test.BrAPITestServer.model.rest.VendorPlateRequest;
import org.brapi.test.BrAPITestServer.model.rest.VendorPlateRequestList;
import org.brapi.test.BrAPITestServer.model.rest.VendorPlateSearchRequest;
import org.brapi.test.BrAPITestServer.model.rest.VendorSample;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.brapi.test.BrAPITestServer.model.rest.vendor.VendorSpec;
import org.brapi.test.BrAPITestServer.model.rest.vendor.VendorSpecBlankWell;
import org.brapi.test.BrAPITestServer.model.rest.vendor.VendorSpecDeliverable;
import org.brapi.test.BrAPITestServer.model.rest.vendor.VendorSpecPlatform;
import org.brapi.test.BrAPITestServer.model.rest.vendor.VendorSpecReferenceSystem;
import org.brapi.test.BrAPITestServer.model.rest.vendor.VendorSpecStandardRequirement;
import org.brapi.test.BrAPITestServer.model.rest.vendor.VendorSpecStatus;
import org.brapi.test.BrAPITestServer.repository.SampleRepository;
import org.brapi.test.BrAPITestServer.repository.TaxonRepository;
import org.brapi.test.BrAPITestServer.repository.VendorSampleRepository;
import org.brapi.test.BrAPITestServer.repository.VendorSpecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

	public List<VendorPlate> savePlates(VendorPlateRequestList request) {
		List<VendorPlate> storedPlates = new ArrayList<VendorPlate>();
		for (VendorPlateRequest newPlate : request.getPlates()) {
			PlateEntity plateEntity = convertToEntity(newPlate);
			PlateEntity storedPlateEntity = vendorSampleRepository.save(plateEntity);
			
			String vendorPlateDbId = storedPlateEntity.getId();
			List<SampleEntity> storedSamples = saveVendorSamples(newPlate.getSamples(), vendorPlateDbId);
			storedPlateEntity.setSamples(storedSamples);
			
			storedPlates.add(convertFromEntity(storedPlateEntity));
		}
		return storedPlates;
	}

	private List<SampleEntity> saveVendorSamples(List<VendorSample> samples, String vendorPlateDbId) {
		List<SampleEntity> storedSamples = new ArrayList<>();
		for (VendorSample newSample : samples) {

			TaxonEntity taxon = new TaxonEntity();
			taxon.setSourceName(newSample.getTaxonId().getSourceName());
			taxon.setTaxonId(newSample.getTaxonId().getTaxonId());
			TaxonEntity storedTaxon = taxonRepository.save(taxon);
			
			SampleEntity sampleEntity = convertToEntity(newSample);
			sampleEntity.setPlateDbId(vendorPlateDbId);
			sampleEntity.setTaxonId(storedTaxon);
			storedSamples.add(sampleRepository.save(sampleEntity));
		}
		return storedSamples;
	}

	private SampleEntity convertToEntity(VendorSample newSample) {
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
		plate.setStatusTimeStamp(entity.getStatusTimeStamp());
		plate.setVendorBarcode(entity.getVendorBarcode());
		plate.setVendorBarcodeImageURL(entity.getVendorBarcodeImageURL());
		plate.setVendorPlateDbId(entity.getId());
		plate.setVendorProjectDbId(entity.getVendorProjectDbId());

		plate.setSamples(entity.getSamples().stream().map((sampleEntity) -> {
			VendorSample sample = new VendorSample();
			sample.setColumn((sampleEntity.getPlateIndex() % 12) + "");
			sample.setConcentration(sampleEntity.getConcentration());
			sample.setRow((sampleEntity.getPlateIndex() / 12) + "");
			sample.setSampleDbId(sampleEntity.getId());
			sample.setTissueType(sampleEntity.getTissueType());
			sample.setVolume(sampleEntity.getVolume());
			sample.setWell(sampleEntity.getPlateIndex() + "");

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

	private PlateEntity convertToEntity(VendorPlateRequest newPlate) {
		PlateEntity plateEntity = new PlateEntity();
		plateEntity.setClientPlateDbId(newPlate.getClientPlateDbId());
		plateEntity.setPlateFormat(newPlate.getPlateFormat());
		plateEntity.setSampleType(newPlate.getSampleType());
		plateEntity.setVendorProjectDbId(newPlate.getVendorProjectDbId());
		return plateEntity;
	}

	public List<VendorPlate> searchPlates(String vendorProjectDbId, String vendorPlateDbId, String clientPlateDbId,
			boolean sampleInfo, MetaData metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		Page<PlateEntity> plates = vendorSampleRepository.findBySearch(
				SearchUtility.buildSearchParam(vendorProjectDbId),
				SearchUtility.buildSearchParam(vendorPlateDbId),
				SearchUtility.buildSearchParam(clientPlateDbId),
				pageReq);
		PagingUtility.calculateMetaData(metadata, plates);
		return plates.map((entity) -> {
			if(!sampleInfo) {
				entity.getSamples().clear();
			}
			return entity;
		}).map(this :: convertFromEntity).getContent();
	}

	public List<VendorPlate> searchPlates(VendorPlateSearchRequest request, MetaData metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		Page<PlateEntity> plates = vendorSampleRepository.findBySearch(
				SearchUtility.buildSearchParam(request.getVendorProjectDbIds()),
				SearchUtility.buildSearchParam(request.getVendorPlateDbIds()),
				SearchUtility.buildSearchParam(request.getClientPlateDbIds()),
				pageReq);
		PagingUtility.calculateMetaData(metadata, plates);
		return plates.map((entity) -> {
			if(! request.isSampleInfo()) {
				entity.getSamples().clear();
			}
			return entity;
		}).map(this :: convertFromEntity).getContent();
	}

	public VendorSpec getVendorSpec() {
		Optional<VendorSpecEntity> vendorSpecOpt = vendorSpecRepository.findById("1");
		VendorSpec spec = null;
		if(vendorSpecOpt.isPresent()) {
			spec = convertFromEntity(vendorSpecOpt.get());
		}
		return spec;
	}

	private VendorSpec convertFromEntity(VendorSpecEntity specEntity) {
		VendorSpec spec = new VendorSpec();
		spec.setAdditionalInfo(null);
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
			VendorSpecPlatform platform = new VendorSpecPlatform();
			platform.setContactEmail(platformEntity.getContactEmail());
			platform.setContactName(platformEntity.getContactName());
			platform.setContactPhone(platformEntity.getContactPhone());
			platform.setPlatformDescription(platformEntity.getPlatformDescription());
			platform.setPlatformName(platformEntity.getPlatformName());
			platform.setPlatformURL(platformEntity.getPlatformURL());
			platform.setShippingAddress(platformEntity.getShippingAddress());
			platform.setSpecificRequirements(null);
			
			platform.setDeliverables(platformEntity.getDeliverables().stream().map((deliverableEntity) -> {
				VendorSpecDeliverable deliverable = new VendorSpecDeliverable();
				deliverable.setDescription(deliverableEntity.getDescription());
				deliverable.setFormat(deliverableEntity.getFormat());
				deliverable.setName(deliverableEntity.getName());
				return deliverable;
			}).collect(Collectors.toList()));

			platform.setStatuses(platformEntity.getStatuses().stream().map((statusEntity) -> {
				VendorSpecStatus status = new VendorSpecStatus();
				status.setStatusDescription(statusEntity.getStatusDescription());
				status.setStatusName(statusEntity.getStatusName());
				return status;
			}).collect(Collectors.toList()));
			
			VendorSpecStandardRequirement requirement = new VendorSpecStandardRequirement();
			VendorSpecStandardRequirementEntity requirementEntity = platformEntity.getStandardRequirements();
			requirement.setInputFormatDetails(requirementEntity.getInputFormatDetails());
			requirement.setMaxConcentration(requirementEntity.getMaxConcentration());
			requirement.setMinConcentration(requirementEntity.getMinConcentration());
			requirement.setMinSampleNumber(requirementEntity.getMinSampleNumber());
			requirement.setMaxVolume(requirementEntity.getMaxVolume());
			requirement.setMinVolume(requirementEntity.getMinVolume());
			requirement.setPlateOrientation(requirementEntity.getPlateOrientation());
			requirement.setSampleTypeDetails(requirementEntity.getSampleTypeDetails());
			VendorSpecBlankWell blankWell = new VendorSpecBlankWell();
			blankWell.setNumberOfBlanksPerPlate(requirementEntity.getNumberOfBlanksPerPlate());
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
			
			platform.setTaxonomyIdSystem(new VendorSpecReferenceSystem());
			platform.getTaxonomyIdSystem().setName(platformEntity.getTaxonomyIdSystemName());
			platform.getTaxonomyIdSystem().setURI(platformEntity.getTaxonomyIdSystemURI());
			platform.setTissueIdSystem(new VendorSpecReferenceSystem());
			platform.getTissueIdSystem().setName(platformEntity.getTissueIdSystemName());
			platform.getTissueIdSystem().setURI(platformEntity.getTissueIdSystemURI());

			return platform;
		}).collect(Collectors.toList()));
		
		return spec;
	}

}
