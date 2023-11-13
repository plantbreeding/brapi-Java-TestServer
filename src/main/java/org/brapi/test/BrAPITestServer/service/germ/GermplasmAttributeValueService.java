package org.brapi.test.BrAPITestServer.service.germ;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import jakarta.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.germ.GermplasmAttributeValueEntity;
import org.brapi.test.BrAPITestServer.repository.germ.GermplasmAttributeValueRepository;
import org.brapi.test.BrAPITestServer.service.DateUtility;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.germ.GermplasmAttributeValue;
import io.swagger.model.germ.GermplasmAttributeValueNewRequest;
import io.swagger.model.germ.GermplasmAttributeValueSearchRequest;

@Service
public class GermplasmAttributeValueService {

	private GermplasmAttributeValueRepository attributeValueRepository;
	private GermplasmAttributeService attributeService;
	private GermplasmService germplasmService;

	@Autowired
	public GermplasmAttributeValueService(GermplasmAttributeValueRepository attributeValueRepository,
			GermplasmAttributeService attributeService, GermplasmService germplasmService) {
		this.attributeValueRepository = attributeValueRepository;
		this.attributeService = attributeService;
		this.germplasmService = germplasmService;
	}

	public List<GermplasmAttributeValue> findGermplasmAttributeValues(String attributeValueDbId, String attributeDbId,
			String attributeName, String germplasmDbId, String commonCropName, String programDbId,
			String externalReferenceId, String externalReferenceID, String externalReferenceSource, Metadata metadata) {

		GermplasmAttributeValueSearchRequest request = new GermplasmAttributeValueSearchRequest();
		if (attributeValueDbId != null)
			request.addAttributeValueDbIdsItem(attributeValueDbId);
		if (attributeDbId != null)
			request.addAttributeDbIdsItem(attributeDbId);
		if (attributeName != null)
			request.addAttributeNamesItem(attributeName);
		if (germplasmDbId != null)
			request.addGermplasmDbIdsItem(germplasmDbId);
		if (commonCropName != null)
			request.addCommonCropNamesItem(commonCropName);
		if (programDbId != null)
			request.addProgramDbIdsItem(programDbId);

		request.addExternalReferenceItem(externalReferenceId, externalReferenceID, externalReferenceSource);

		return findGermplasmAttributeValues(request, metadata);
	}

	public List<GermplasmAttributeValue> findGermplasmAttributeValues(
			@Valid GermplasmAttributeValueSearchRequest request, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<GermplasmAttributeValueEntity> searchQuery = new SearchQueryBuilder<GermplasmAttributeValueEntity>(
				GermplasmAttributeValueEntity.class)
						.withExRefs(request.getExternalReferenceIDs(), request.getExternalReferenceSources())
						.appendList(request.getAttributeValueDbIds(), "id")
						.appendList(request.getAttributeDbIds(), "attribute.id")
						.appendList(request.getAttributeNames(), "attribute.name")
						.appendList(request.getMethodDbIds(), "attribute.method.id")
						.appendList(request.getOntologyDbIds(), "attribute.ontology.id")
						.appendList(request.getScaleDbIds(), "attribute.scale.id")
						.appendList(request.getTraitClasses(), "attribute.trait.traitClass")
						.appendList(request.getTraitDbIds(), "attribute.trait.id")
						.appendList(request.getGermplasmDbIds(), "germplasm.id")
						.appendList(request.getGermplasmNames(), "germplasm.germplasmName");

		Page<GermplasmAttributeValueEntity> page = attributeValueRepository.findAllBySearch(searchQuery, pageReq);
		List<GermplasmAttributeValue> attributeValues = page.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, page);
		return attributeValues;
	}

	public GermplasmAttributeValue getGermplasmAttributeValue(String attributeValueDbId) throws BrAPIServerException {
		return convertFromEntity(getGermplasmAttributeValueEntity(attributeValueDbId, HttpStatus.NOT_FOUND));
	}

	public GermplasmAttributeValueEntity getGermplasmAttributeValueEntity(String attributeValueDbId)
			throws BrAPIServerException {
		return getGermplasmAttributeValueEntity(attributeValueDbId, HttpStatus.BAD_REQUEST);
	}

	public GermplasmAttributeValueEntity getGermplasmAttributeValueEntity(String attributeValueDbId,
			HttpStatus errorStatus) throws BrAPIServerException {
		GermplasmAttributeValueEntity attributeValue = null;
		Optional<GermplasmAttributeValueEntity> entityOpt = attributeValueRepository.findById(attributeValueDbId);
		if (entityOpt.isPresent()) {
			attributeValue = entityOpt.get();
		} else {
			throw new BrAPIServerDbIdNotFoundException("germplasm attribute value", attributeValueDbId, errorStatus);
		}
		return attributeValue;
	}

	public List<GermplasmAttributeValue> saveGermplasmAttributeValues(
			@Valid List<GermplasmAttributeValueNewRequest> body) throws BrAPIServerException {
		List<GermplasmAttributeValue> savedValues = new ArrayList<>();

		for (GermplasmAttributeValueNewRequest list : body) {

			GermplasmAttributeValueEntity entity = new GermplasmAttributeValueEntity();
			updateEntity(entity, list);

			GermplasmAttributeValueEntity savedEntity = attributeValueRepository.save(entity);

			savedValues.add(convertFromEntity(savedEntity));
		}

		return savedValues;
	}

	public GermplasmAttributeValue updateGermplasmAttributeValue(String attributeValueDbId,
			GermplasmAttributeValueNewRequest body) throws BrAPIServerException {
		GermplasmAttributeValueEntity entity = getGermplasmAttributeValueEntity(attributeValueDbId,
				HttpStatus.NOT_FOUND);
		updateEntity(entity, body);
		GermplasmAttributeValueEntity savedEntity = attributeValueRepository.save(entity);

		return convertFromEntity(savedEntity);
	}

	private GermplasmAttributeValue convertFromEntity(GermplasmAttributeValueEntity entity) {
		GermplasmAttributeValue value = new GermplasmAttributeValue();

		value.setAdditionalInfo(entity.getAdditionalInfo());
		if (entity.getAttribute() != null) {
			value.setAttributeDbId(entity.getAttribute().getId());
			value.setAttributeName(entity.getAttribute().getName());
		}
		value.setAttributeValueDbId(entity.getId());
		value.setDeterminedDate(DateUtility.toOffsetDateTime(entity.getDeterminedDate()));
		value.setExternalReferences(entity.getExternalReferencesMap());
		if (entity.getGermplasm() != null) {
			value.setGermplasmDbId(entity.getGermplasm().getId());
			value.setGermplasmName(entity.getGermplasm().getGermplasmName());
		}
		value.setValue(entity.getValue());

		return value;

	}

	private void updateEntity(GermplasmAttributeValueEntity entity, @Valid GermplasmAttributeValueNewRequest value)
			throws BrAPIServerException {

		if (value.getAdditionalInfo() != null)
			entity.setAdditionalInfo(value.getAdditionalInfo());
		if (value.getAttributeDbId() != null)
			entity.setAttribute(attributeService.getGermplasmAttributeDefinitionEntity(value.getAttributeDbId()));
		if (value.getDeterminedDate() != null)
			entity.setDeterminedDate(DateUtility.toDate(value.getDeterminedDate()));
		if (value.getExternalReferences() != null)
			entity.setExternalReferences(value.getExternalReferences());
		if (value.getGermplasmDbId() != null)
			entity.setGermplasm(germplasmService.getGermplasmEntity(value.getGermplasmDbId()));
		if (value.getValue() != null)
			entity.setValue(value.getValue());
	}

}
