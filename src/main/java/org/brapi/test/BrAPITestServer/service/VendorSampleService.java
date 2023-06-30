package org.brapi.test.BrAPITestServer.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import jakarta.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.PlateEntity;
import org.brapi.test.BrAPITestServer.model.entity.SampleEntity;
import org.brapi.test.BrAPITestServer.model.entity.vendor.VendorFileEntity;
import org.brapi.test.BrAPITestServer.model.entity.vendor.VendorOrderEntity;
import org.brapi.test.BrAPITestServer.model.entity.vendor.VendorPlateSubmissionEntity;
import org.brapi.test.BrAPITestServer.model.entity.vendor.VendorSpecEntity;
import org.brapi.test.BrAPITestServer.repository.VendorOrderRepository;
import org.brapi.test.BrAPITestServer.repository.VendorPlateRepository;
import org.brapi.test.BrAPITestServer.repository.VendorSpecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Measurement;
import io.swagger.model.Metadata;
import io.swagger.model.VendorContact;
import io.swagger.model.VendorOntologyReference;
import io.swagger.model.VendorOrder;
import io.swagger.model.VendorOrderRequest;
import io.swagger.model.VendorOrderRequest.SampleTypeEnum;
import io.swagger.model.VendorOrderRequestPlates;
import io.swagger.model.VendorOrderResponseResult;
import io.swagger.model.VendorOrderStatusResponseResult.StatusEnum;
import io.swagger.model.VendorPlate;
import io.swagger.model.VendorPlateGetResponse;
import io.swagger.model.VendorPlatesSubmissionRequest;
import io.swagger.model.VendorResultFile;
import io.swagger.model.VendorSample;
import io.swagger.model.VendorSpecification;
import io.swagger.model.VendorSpecificationService;
import io.swagger.model.VendorSpecificationService.ServicePlatformMarkerTypeEnum;

@Service
public class VendorSampleService {
	private VendorPlateRepository vendorPlateRepository;
	private VendorOrderRepository vendorOrderRepository;
	private VendorSpecRepository vendorSpecRepository;

	@Autowired
	public VendorSampleService(VendorPlateRepository vendorPlateRepository, VendorSpecRepository vendorSpecRepository,
			VendorOrderRepository vendorOrderRepository) {
		this.vendorPlateRepository = vendorPlateRepository;
		this.vendorSpecRepository = vendorSpecRepository;
		this.vendorOrderRepository = vendorOrderRepository;
	}

	private VendorPlate convertFromEntity(PlateEntity entity) {
		VendorPlate plate = new VendorPlate();
		plate.setClientPlateBarcode(entity.getClientPlateBarcode());
		plate.setClientPlateId(entity.getClientPlateDbId());
		plate.setSampleSubmissionFormat(entity.getSampleSubmissionFormat());
		if (entity.getSamples() != null)
			plate.setSamples(entity.getSamples().stream().map(this::convertFromEntity).collect(Collectors.toList()));

		return plate;
	}

	private VendorSample convertFromEntity(SampleEntity entity) {
		VendorSample sample = new VendorSample();
		sample.setClientSampleBarCode(entity.getId());
		sample.setClientSampleId(entity.getId());
		sample.setComments(entity.getNotes());
		sample.setConcentration(new Measurement().value(new BigDecimal(entity.getConcentration())).units("ppm"));
		if (entity.getObservationUnit() != null) {
			sample.setOrganismName(entity.getObservationUnit().getGermplasm().getCommonCropName());
			sample.setSpeciesName(entity.getObservationUnit().getGermplasm().getSpecies());
		}
		sample.setTaxonomyOntologyReference(new VendorOntologyReference());
		sample.setTissueType(entity.getTissueType());
		sample.setTissueTypeOntologyReference(new VendorOntologyReference());
		sample.setVolume(new Measurement().value(new BigDecimal(entity.getVolume())).units("ml"));

		sample.setColumn(String.valueOf((entity.getPlateIndex() % 12) + 1));
		sample.setRow(String.valueOf((entity.getPlateIndex() / 8) + 1));
		sample.setWell(String.valueOf((entity.getPlateIndex()) + 1));

		return sample;
	}

	private VendorResultFile convertFromEntity(VendorFileEntity entity) {
		VendorResultFile file = new VendorResultFile();
		file.setAdditionalInfo(new HashMap<>());
		if (entity.getSamples() != null)
			file.setClientSampleIds(entity.getSamples().stream().map(e -> e.getId()).collect(Collectors.toList()));
		file.setFileName(entity.getFilename());
		file.setFileType(entity.getFileType());
		file.setFileURL(entity.getURL());
		file.setMd5sum(entity.getMd5sum());
		return file;
	}

	private VendorOrder convertFromEntity(VendorOrderEntity entity) {
		VendorOrder order = new VendorOrder();
		order.setClientId(entity.getClientPlateDbId());
		if (entity.getPlateSubmission() != null)
			order.setNumberOfSamples(entity.getPlateSubmission().getNumberOfSamples());
		order.setOrderId(entity.getId());
		order.setRequiredServiceInfo(entity.getRequiredServiceInfo());
		if (entity.getServiceIds() != null && !entity.getServiceIds().isEmpty())
			order.setServiceId(entity.getServiceIds().get(0));

		return order;
	}

	private VendorPlateGetResponse convertFromEntity(VendorPlateSubmissionEntity entity) {
		VendorPlateGetResponse response = new VendorPlateGetResponse();
		response.setClientId(entity.getClientId());
		response.setNumberOfSamples(entity.getNumberOfSamples());
		if (entity.getPlates() != null)
			response.setPlates(
					entity.getPlates().stream().map(this::convertFromEntityToSummary).collect(Collectors.toList()));

		return response;
	}

	private VendorSpecification convertFromEntity(VendorSpecEntity specEntity) {
		VendorSpecification spec = new VendorSpecification();
		spec.setAdditionalInfo(new HashMap<>());
		spec.setVendorContact(new VendorContact().vendorAddress(specEntity.getVendorAddress())
				.vendorCity(specEntity.getVendorCity()).vendorContactName(specEntity.getContactName())
				.vendorCountry(specEntity.getVendorCountry()).vendorDescription(specEntity.getVendorDescription())
				.vendorEmail(specEntity.getVendorEmail()).vendorName(specEntity.getVendorName())
				.vendorPhone(specEntity.getVendorPhone()).vendorURL(specEntity.getVendorURL()));

		if (specEntity.getPlatforms() != null) {
			spec.setServices(specEntity.getPlatforms().stream().map((platformEntity) -> {
				VendorSpecificationService service = new VendorSpecificationService()
						.serviceDescription(platformEntity.getPlatformURL()).serviceId(platformEntity.getId())
						.serviceName(platformEntity.getPlatformName())
						.servicePlatformMarkerType(ServicePlatformMarkerTypeEnum.FIXED)
						.servicePlatformName(platformEntity.getPlatformName()).specificRequirements(new HashMap<>());

				return service;
			}).collect(Collectors.toList()));
		}

		return spec;
	}

	private VendorOrderRequestPlates convertFromEntityToSummary(PlateEntity entity) {
		VendorOrderRequestPlates plate = new VendorOrderRequestPlates();
		plate.setClientPlateBarcode(entity.getClientPlateBarcode());
		plate.setClientPlateId(entity.getClientPlateDbId());
		plate.setSampleSubmissionFormat(entity.getSampleSubmissionFormat());
		if (entity.getSamples() != null)
			plate.setSamples(entity.getSamples().stream().map(this::convertFromEntity).collect(Collectors.toList()));
		return plate;
	}

	private VendorOrderEntity convertToEntity(@Valid VendorOrderRequest request) {
		VendorOrderEntity entity = new VendorOrderEntity();
		entity.setClientPlateBarcode(request.getClientId());
		entity.setClientPlateDbId(request.getClientId());
		entity.setRequiredServiceInfo(request.getRequiredServiceInfo());
		entity.setSampleType(request.getSampleType());
		entity.setServiceIds(request.getServiceIds());

		if (request.getClientId() != null && request.getClientId().contains("reject")) {
			entity.setStatus(StatusEnum.REJECTED);
		} else {
			entity.setStatus(StatusEnum.RECEIVED);
		}
		entity.setStatusTimeStamp(new Date());

		entity.setPlateSubmission(convertToEntity(request, entity));

		return entity;
	}

	private VendorPlateSubmissionEntity convertToEntity(VendorOrderRequest plates, VendorOrderEntity order) {
		VendorPlateSubmissionEntity entity = new VendorPlateSubmissionEntity();
		entity.setClientId(order.getClientPlateDbId());
		entity.setNumberOfSamples(plates.getNumberOfSamples());
		entity.setOrder(order);
		entity.setSampleType(plates.getSampleType());
		if (plates.getPlates() != null)
			entity.setPlates(plates.getPlates().stream().map(this::convertToEntity).collect(Collectors.toList()));
		return entity;
	}

	private PlateEntity convertToEntity(VendorOrderRequestPlates newPlate) {
		PlateEntity plateEntity = new PlateEntity();
		plateEntity.setClientPlateDbId(newPlate.getClientPlateId());
		plateEntity.setStatusTimeStamp(new Date());

		return plateEntity;
	}

	private VendorOrderEntity convertToEntity(VendorPlatesSubmissionRequest request) {
		VendorOrderEntity entity = new VendorOrderEntity();
		entity.setClientPlateBarcode(request.getClientId());
		entity.setClientPlateDbId(request.getClientId());
		if (request.getSampleType() != null)
			entity.setSampleType(SampleTypeEnum.fromValue(request.getSampleType().toString()));
		entity.setStatus(StatusEnum.RECEIVED);
		entity.setStatusTimeStamp(new Date());

		entity.setPlateSubmission(convertToEntity(request, entity));

		return entity;
	}

	private VendorPlateSubmissionEntity convertToEntity(VendorPlatesSubmissionRequest plates, VendorOrderEntity order) {
		VendorPlateSubmissionEntity entity = new VendorPlateSubmissionEntity();
		entity.setClientId(order.getClientPlateDbId());
		entity.setNumberOfSamples(plates.getNumberOfSamples());
		entity.setOrder(order);
		if (plates.getSampleType() != null)
			entity.setSampleType(SampleTypeEnum.fromValue(plates.getSampleType().toString()));
		entity.setPlates(plates.getPlates().stream().map(this::convertToEntity).collect(Collectors.toList()));
		return entity;
	}

	public List<VendorOrder> getOrders(@Valid String orderId, @Valid String submissionId, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		List<VendorOrder> orders = new ArrayList<>();
		if (orderId != null) {
			Optional<VendorOrderEntity> orderEntity = vendorOrderRepository.findById(orderId);
			if (orderEntity.isPresent()) {
				metadata.getPagination().setTotalCount(1);
				metadata.getPagination().setTotalPages(1);
				orders.add(convertFromEntity(orderEntity.get()));
			}
		} else if (submissionId != null) {
			Page<VendorOrderEntity> page = vendorOrderRepository.findByPlateSubmission_Id(submissionId, pageReq);
			PagingUtility.calculateMetaData(metadata, page);
			orders = page.map(this::convertFromEntity).getContent();
		} else {
			Page<VendorOrderEntity> page = vendorOrderRepository.findAll(pageReq);
			PagingUtility.calculateMetaData(metadata, page);
			orders = page.map(this::convertFromEntity).getContent();
		}
		return orders;
	}

	public StatusEnum getOrderStatus(String orderId, Metadata metadata) {
		StatusEnum status = null;
		if (orderId != null) {
			Optional<VendorOrderEntity> orderEntity = vendorOrderRepository.findById(orderId);
			if (orderEntity.isPresent()) {
				status = orderEntity.get().getStatus();
				updateStatus(orderEntity.get());
			}
		}
		return status;
	}

	public List<VendorPlate> getPlates(String orderId, Metadata metadata) {
		List<VendorPlate> plates = new ArrayList<>();
		if (orderId != null) {
			Optional<VendorOrderEntity> orderEntity = vendorOrderRepository.findById(orderId);
			if (orderEntity.isPresent()) {
				plates = orderEntity.get().getPlateSubmission().getPlates().stream().map(this::convertFromEntity)
						.collect(Collectors.toList());
				metadata.getPagination().setTotalCount(plates.size());
				metadata.getPagination().setTotalPages(1);
			}
		}
		return plates;
	}

	public VendorPlateGetResponse getPlateSubmission(String submissionId) {
		VendorPlateGetResponse response = null;
		if (submissionId != null) {
			Optional<VendorPlateSubmissionEntity> submissionEntity = vendorPlateRepository.findById(submissionId);
			if (submissionEntity.isPresent()) {
				response = convertFromEntity(submissionEntity.get());
			}
		}
		return response;
	}

	public List<VendorResultFile> getResultFiles(String orderId, Metadata metadata) {
		List<VendorResultFile> files = new ArrayList<>();
		if (orderId != null) {
			Optional<VendorOrderEntity> orderEntity = vendorOrderRepository.findById(orderId);
			if (orderEntity.isPresent()) {
				files = orderEntity.get().getFiles().stream().map(this::convertFromEntity).collect(Collectors.toList());
				metadata.getPagination().setTotalCount(files.size());
				metadata.getPagination().setTotalPages(1);
			}
		}
		return files;
	}

	public VendorSpecification getVendorSpec() {
		Optional<VendorSpecEntity> vendorSpecOpt = vendorSpecRepository.findById("1");
		VendorSpecification spec = null;
		if (vendorSpecOpt.isPresent()) {
			spec = convertFromEntity(vendorSpecOpt.get());
		}
		return spec;
	}

	public VendorOrderResponseResult saveOrder(@Valid VendorOrderRequest body) {
		VendorOrderEntity newEntity = vendorOrderRepository.save(convertToEntity(body));

		VendorOrderResponseResult result = new VendorOrderResponseResult();
		result.setOrderId(newEntity.getId());

		return result;
	}

	public String savePlates(VendorPlatesSubmissionRequest request) throws BrAPIServerException {
		if (request.getPlates() == null) {
			throw new BrAPIServerException(HttpStatus.BAD_REQUEST, "No plate data in request");
		}

		VendorOrderEntity entity = convertToEntity(request);
		VendorOrderEntity newEntity = vendorOrderRepository.save(entity);
		String submissionId = newEntity.getPlateSubmission().getId();

		return submissionId;
	}

	private void updateStatus(VendorOrderEntity order) {
		StatusEnum newStatus = StatusEnum.REGISTERED;
		switch (order.getStatus()) {
		case REGISTERED:
			newStatus = StatusEnum.RECEIVED;
			break;
		case RECEIVED:
			newStatus = StatusEnum.INPROGRESS;
			break;
		case INPROGRESS:
			newStatus = StatusEnum.COMPLETED;
			break;
		case COMPLETED:
			newStatus = StatusEnum.REGISTERED;
			updateResultFiles(order);
			break;
		case REJECTED:
		default:
			newStatus = StatusEnum.REJECTED;
			break;
		}
		order.setStatus(newStatus);
		order.setStatusTimeStamp(new Date());
		VendorOrderEntity saved = vendorOrderRepository.save(order);
	}

	private void updateResultFiles(VendorOrderEntity order) {
		List<VendorFileEntity> files = new ArrayList<>();
		VendorFileEntity entity = new VendorFileEntity();
		entity.setFilename("example_file_" + order.getId() + ".vcf");
		entity.setFileType("application/vcf");
		entity.setMd5sum("8DEA19500BC44D35E2D7B6A68ABA552B");
		entity.setURL("https://brapi.org/" + entity.getFilename());
		entity.setOrder(order);
		entity.setAdditionalInfo("");
		if (order.getPlateSubmission() != null && order.getPlateSubmission().getPlates() != null
				&& !order.getPlateSubmission().getPlates().isEmpty()) {
			entity.setSamples(order.getPlateSubmission().getPlates().get(0).getSamples());
		}

		files.add(entity);
		order.setFiles(files);
		System.out.println(order.getFiles().get(0).getSamples());
	}

}
