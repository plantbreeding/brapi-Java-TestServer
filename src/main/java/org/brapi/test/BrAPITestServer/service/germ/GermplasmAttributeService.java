package org.brapi.test.BrAPITestServer.service.germ;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.germ.GermplasmAttributeDefinitionEntity;
import org.brapi.test.BrAPITestServer.repository.germ.GermplasmAttributeDefinitionRepository;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.brapi.test.BrAPITestServer.service.pheno.ObservationVariableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.germ.GermplasmAttribute;
import io.swagger.model.germ.GermplasmAttributeNewRequest;
import io.swagger.model.germ.GermplasmAttributeSearchRequest;

@Service
public class GermplasmAttributeService {

	private GermplasmAttributeDefinitionRepository attributeRepository;
	private ObservationVariableService observationVariableService;

	@Autowired
	public GermplasmAttributeService(GermplasmAttributeDefinitionRepository attributeRepository,
			ObservationVariableService observationVariableService) {
		this.attributeRepository = attributeRepository;
		this.observationVariableService = observationVariableService;
	}

	public List<GermplasmAttribute> findGermplasmAttributes(@Valid String attributeCategory,
			@Valid String attributeDbId, @Valid String attributeName, @Valid String germplasmDbId,
			@Valid String externalReferenceID, @Valid String externalReferenceSource, Metadata metadata) {
		GermplasmAttributeSearchRequest request = new GermplasmAttributeSearchRequest();
		if (attributeDbId != null)
			request.addAttributeDbIdsItem(attributeDbId);
		if (attributeName != null)
			request.addAttributeNamesItem(attributeName);
		if (externalReferenceID != null)
			request.addExternalReferenceIDsItem(externalReferenceID);
		if (externalReferenceSource != null)
			request.addExternalReferenceSourcesItem(externalReferenceSource);

		return findGermplasmAttributes(request, metadata);
	}

	public List<GermplasmAttribute> findGermplasmAttributes(@Valid GermplasmAttributeSearchRequest request,
			Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<GermplasmAttributeDefinitionEntity> searchQuery = new SearchQueryBuilder<GermplasmAttributeDefinitionEntity>(
				GermplasmAttributeDefinitionEntity.class)
						.withExRefs(request.getExternalReferenceIDs(), request.getExternalReferenceSources())
						.appendList(request.getAttributeDbIds(), "id").appendList(request.getAttributeNames(), "name")
						.appendList(request.getMethodDbIds(), "method.id")
						.appendList(request.getOntologyDbIds(), "ontology.id")
						.appendList(request.getScaleDbIds(), "scale.id").appendList(request.getStudyDbId(), "study.id")
						.appendList(request.getTraitClasses(), "trait.traitClass")
						.appendList(request.getTraitDbIds(), "trait.id");

		Page<GermplasmAttributeDefinitionEntity> page = attributeRepository.findAllBySearch(searchQuery, pageReq);
		List<GermplasmAttribute> attributes = page.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, page);
		return attributes;
	}

	public GermplasmAttribute getGermplasmAttribute(String attributeDbId) throws BrAPIServerException {
		return convertFromEntity(getGermplasmAttributeDefinitionEntity(attributeDbId, HttpStatus.NOT_FOUND));
	}

	public GermplasmAttributeDefinitionEntity getGermplasmAttributeDefinitionEntity(String attributeDbId) throws BrAPIServerException {
		return getGermplasmAttributeDefinitionEntity(attributeDbId, HttpStatus.BAD_REQUEST);
	}

	public GermplasmAttributeDefinitionEntity getGermplasmAttributeDefinitionEntity(String attributeDbId, HttpStatus errorStatus)
			throws BrAPIServerException {
		GermplasmAttributeDefinitionEntity attribute = null;
		Optional<GermplasmAttributeDefinitionEntity> entityOpt = attributeRepository.findById(attributeDbId);
		if (entityOpt.isPresent()) {
			attribute = entityOpt.get();
		} else {
			throw new BrAPIServerDbIdNotFoundException("germplasm attribute", attributeDbId);
		}
		return attribute;
	}

	public List<GermplasmAttribute> saveGermplasmAttributes(@Valid List<GermplasmAttributeNewRequest> body) throws BrAPIServerException {
		List<GermplasmAttribute> savedGermplasmAttributes = new ArrayList<>();

		for (GermplasmAttributeNewRequest list : body) {

			GermplasmAttributeDefinitionEntity entity = new GermplasmAttributeDefinitionEntity();
			updateEntity(entity, list);

			GermplasmAttributeDefinitionEntity savedEntity = attributeRepository.save(entity);

			savedGermplasmAttributes.add(convertFromEntity(savedEntity));
		}

		return savedGermplasmAttributes;
	}

	public GermplasmAttribute updateGermplasmAttribute(String attributeDbId, @Valid GermplasmAttributeNewRequest body)
			throws BrAPIServerException {
		GermplasmAttributeDefinitionEntity savedEntity;
		Optional<GermplasmAttributeDefinitionEntity> entityOpt = attributeRepository.findById(attributeDbId);
		if (entityOpt.isPresent()) {
			GermplasmAttributeDefinitionEntity entity = entityOpt.get();
			updateEntity(entity, body);

			savedEntity = attributeRepository.save(entity);
		} else {
			throw new BrAPIServerDbIdNotFoundException("germplasm attribute", attributeDbId);
		}

		return convertFromEntity(savedEntity);
	}

	public List<String> getAttributesCategories(Metadata metadata) {
		List<GermplasmAttributeDefinitionEntity> attributes = attributeRepository.findAll();
		Set<String> categories = new HashSet<>();
		for (GermplasmAttributeDefinitionEntity entity : attributes) {
			if (entity.getAttributeCategory() != null)
				categories.add(entity.getAttributeCategory());
		}
		return PagingUtility.paginateSimpleList(new ArrayList<>(categories), metadata);
	}

	private GermplasmAttribute convertFromEntity(GermplasmAttributeDefinitionEntity entity) {
		GermplasmAttribute attrib = new GermplasmAttribute();
		observationVariableService.convertFromBaseEntity(entity, attrib);

		attrib.setAttributeName(entity.getName());
		attrib.setAttributeCategory(entity.getAttributeCategory());
		attrib.setAttributeDbId(entity.getId());
		attrib.setAttributeDescription(entity.getDescription());

		return attrib;

	}

	private void updateEntity(GermplasmAttributeDefinitionEntity entity, @Valid GermplasmAttributeNewRequest body) throws BrAPIServerException {

		observationVariableService.updateBaseEntity(entity, body);

		if (body.getAttributeName() != null)
			entity.setName(body.getAttributeName());
		if (body.getAttributeCategory() != null)
			entity.setAttributeCategory(body.getAttributeCategory());
		if (body.getAttributeDescription() != null)
			entity.setDescription(body.getAttributeDescription());
	}

}
