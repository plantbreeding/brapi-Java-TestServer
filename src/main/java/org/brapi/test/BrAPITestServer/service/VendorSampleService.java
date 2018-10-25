package org.brapi.test.BrAPITestServer.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.PlateEntity;
import org.brapi.test.BrAPITestServer.model.entity.SampleEntity;
import org.brapi.test.BrAPITestServer.model.entity.vendor.VendorSpecEntity;
import org.brapi.test.BrAPITestServer.repository.SampleRepository;
import org.brapi.test.BrAPITestServer.repository.TaxonRepository;
import org.brapi.test.BrAPITestServer.repository.VendorSampleRepository;
import org.brapi.test.BrAPITestServer.repository.VendorSpecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.model.VendorContact;
import io.swagger.model.VendorOrderRequestPlates;
import io.swagger.model.VendorPlate;
import io.swagger.model.VendorPlateGetResponse;
import io.swagger.model.VendorPlatesSubmissionRequest;
import io.swagger.model.VendorSample;
import io.swagger.model.VendorSpecification;
import io.swagger.model.VendorSpecificationService;
import io.swagger.model.VendorSpecificationService.ServicePlatformMarkerTypeEnum;

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

	public String savePlates(VendorPlatesSubmissionRequest request) throws BrAPIServerException {
		if (request.getPlates() == null) {
			throw new BrAPIServerException("No plate data in request");
		}
		
		String submissionId = null;
		List<VendorPlate> storedPlates = new ArrayList<VendorPlate>();

		for (VendorOrderRequestPlates newPlate : request.getPlates()) {
			PlateEntity plateEntity = convertToEntity(newPlate);
			PlateEntity storedPlateEntity = vendorSampleRepository.save(plateEntity);

			String vendorPlateDbId = storedPlateEntity.getId();
			List<SampleEntity> storedSamples = saveVendorSamples(newPlate.getSamples(), vendorPlateDbId);
			storedPlateEntity.setSamples(storedSamples);

			storedPlates.add(convertFromEntity(storedPlateEntity));
		}
		return submissionId;
	}

	private List<SampleEntity> saveVendorSamples(List<VendorSample> samples, String vendorPlateDbId) {
		List<SampleEntity> storedSamples = new ArrayList<>();
		for (VendorSample newSample : samples) {

			SampleEntity sampleEntity = convertToEntity(newSample);
			PlateEntity plate = vendorSampleRepository.findById(vendorPlateDbId).orElse(new PlateEntity());
			sampleEntity.setPlate(plate);
			storedSamples.add(sampleRepository.save(sampleEntity));
		}
		return storedSamples;
	}

	private SampleEntity convertToEntity(VendorSample newSample) {
		SampleEntity sampleEntity = new SampleEntity();
		sampleEntity.setTissueType(newSample.getTissueType());

		if (StringUtils.isNumeric(newSample.getWell())) {
			sampleEntity.setPlateIndex(Integer.parseInt(newSample.getWell()));
		} else if (StringUtils.isNumeric(newSample.getColumn())) {
			sampleEntity.setPlateIndex(Integer.parseInt(newSample.getColumn()));
		} else if (StringUtils.isNumeric(newSample.getRow())) {
			sampleEntity.setPlateIndex(Integer.parseInt(newSample.getRow()));
		}

		return sampleEntity;
	}

	private VendorPlate convertFromEntity(PlateEntity entity) {
		VendorPlate plate = new VendorPlate();
		plate.setClientPlateId(entity.getClientPlateDbId());

		plate.setSamples(entity.getSamples().stream().map((sampleEntity) -> {
			VendorSample sample = new VendorSample();
			sample.setTissueType(sampleEntity.getTissueType());

			if (sampleEntity.getPlateIndex() != null) {
				sample.setColumn(String.valueOf(sampleEntity.getPlateIndex() % 12));
				sample.setRow(String.valueOf(sampleEntity.getPlateIndex() / 12));
				sample.setWell(String.valueOf(sampleEntity.getPlateIndex()));
			}

			return sample;
		}).collect(Collectors.toList()));


		return plate;
	}

	private PlateEntity convertToEntity(VendorOrderRequestPlates newPlate) {
		PlateEntity plateEntity = new PlateEntity();
		plateEntity.setClientPlateDbId(newPlate.getClientPlateId());
		plateEntity.setFiles(new ArrayList<>());
		plateEntity.setStatusTimeStamp(new Date());

		return plateEntity;
	}

	public VendorSpecification getVendorSpec() {
		Optional<VendorSpecEntity> vendorSpecOpt = vendorSpecRepository.findById("1");
		VendorSpecification spec = null;
		if (vendorSpecOpt.isPresent()) {
			spec = convertFromEntity(vendorSpecOpt.get());
		}
		return spec;
	}

	private VendorSpecification convertFromEntity(VendorSpecEntity specEntity) {
		VendorSpecification spec = new VendorSpecification();
		spec.setAdditionalInfo(new HashMap<>());
		spec.setVendorContact(
				new VendorContact()
				.vendorAddress(specEntity.getVendorAddress())
				.vendorCity(specEntity.getVendorCity())
				.vendorContactName(specEntity.getContactName())
				.vendorCountry(specEntity.getVendorCountry())
				.vendorDescription(specEntity.getVendorDescription())
				.vendorEmail(specEntity.getVendorEmail())
				.vendorName(specEntity.getVendorName())
				.vendorPhone(specEntity.getVendorPhone())
				.vendorURL(specEntity.getVendorURL())
				);

		spec.setServices(specEntity.getPlatforms().stream().map((platformEntity) -> {
			VendorSpecificationService service = new VendorSpecificationService()
			.serviceDescription(platformEntity.getPlatformURL())
			.serviceId(platformEntity.getId())
			.serviceName(platformEntity.getPlatformName())
			.servicePlatformMarkerType(ServicePlatformMarkerTypeEnum.FIXED)
			.servicePlatformName(platformEntity.getPlatformName())
			.specificRequirements(new HashMap<>());

			return service;
		}).collect(Collectors.toList()));

		return spec;
	}

	public VendorPlateGetResponse getPlateSubmission(String submissionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
