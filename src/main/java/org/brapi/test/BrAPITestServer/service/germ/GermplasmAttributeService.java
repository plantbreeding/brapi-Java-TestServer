package org.brapi.test.BrAPITestServer.service.germ;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import jakarta.validation.Valid;

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

	public List<GermplasmAttribute> findGermplasmAttributes(String attributeCategory, String attributeDbId,
			String attributeName, String attributePUI, String germplasmDbId, String methodDbId, String methodName,
			String methodPUI, String scaleDbId, String scaleName, String scalePUI, String traitDbId, String traitName,
			String traitPUI, String commonCropName, String programDbId, String externalReferenceId,
			String externalReferenceID, String externalReferenceSource, Metadata metadata) {
		
		GermplasmAttributeSearchRequest request = new GermplasmAttributeSearchRequest();
		if (attributeCategory != null)
			request.addAttributeCategoriesItem(attributeCategory);
		if (attributeDbId != null)
			request.addAttributeDbIdsItem(attributeDbId);
		if (attributeName != null)
			request.addAttributeNamesItem(attributeName);
		if (attributePUI != null)
			request.addAttributePUIsItem(attributePUI);
		if (germplasmDbId != null)
			request.addGermplasmDbIdsItem(germplasmDbId);
		if (methodDbId != null)
			request.addMethodDbIdsItem(methodDbId);
		if (methodName != null)
			request.addMethodNamesItem(methodName);
		if (methodPUI != null)
			request.addMethodPUIsItem(methodPUI);
		if (attributeName != null)
			request.addScaleDbIdsItem(scaleDbId);
		if (scaleName != null)
			request.addScaleNamesItem(scaleName);
		if (scalePUI != null)
			request.addScalePUIsItem(scalePUI);
		if (traitDbId != null)
			request.addTraitDbIdsItem(traitDbId);
		if (traitName != null)
			request.addTraitNamesItem(traitName);
		if (traitPUI != null)
			request.addTraitPUIsItem(traitPUI);
		if (commonCropName != null)
			request.addCommonCropNamesItem(commonCropName);
		if (programDbId != null)
			request.addProgramDbIdsItem(programDbId);

		request.addExternalReferenceItem(externalReferenceId, externalReferenceID, externalReferenceSource);

		return findGermplasmAttributes(request, metadata);
	}

	public List<GermplasmAttribute> findGermplasmAttributes(@Valid GermplasmAttributeSearchRequest request,
			Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<GermplasmAttributeDefinitionEntity> searchQuery = new SearchQueryBuilder<GermplasmAttributeDefinitionEntity>(
				GermplasmAttributeDefinitionEntity.class);
		if(request.getGermplasmDbIds() != null || request.getGermplasmNames() != null) {
			searchQuery = searchQuery.join("values", "attribValue")
					.appendList(request.getGermplasmDbIds(), "*attribValue.germplasm.id")
					.appendList(request.getGermplasmNames(), "*attribValue.germplasm.name");
		}
		if (request.getProgramDbIds() != null || request.getProgramNames() != null || request.getTrialDbIds() != null
				|| request.getTrialNames() != null || request.getStudyDbIds() != null
				|| request.getStudyNames() != null) {
			searchQuery = searchQuery.join("values", "attribValue")
					.join("*attribValue.germplasm", "germplasm")
					.join("*germplasm.observationUnits", "obsunit")
					.appendList(request.getProgramDbIds(), "*obsunit.program.id")
					.appendList(request.getProgramNames(), "*obsunit.program.name")
					.appendList(request.getTrialDbIds(), "*obsunit.trial.id")
					.appendList(request.getTrialNames(), "*obsunit.trial.name")
					.appendList(request.getStudyDbIds(), "*obsunit.study.id")
					.appendList(request.getStudyNames(), "*obsunit.study.studyName");
		}
		
		searchQuery.withExRefs(request.getExternalReferenceIDs(), request.getExternalReferenceSources())
						.appendList(request.getAttributeDbIds(), "id")
						.appendList(request.getAttributeNames(), "name")
						.appendList(request.getAttributePUIs(), "attributePUI")
						.appendList(request.getAttributeCategories(), "attributeCategory")
						.appendEnumList(request.getDataTypes(), "datatype")
						.appendList(request.getMethodDbIds(), "method.id")
						.appendList(request.getMethodNames(), "method.name")
						.appendList(request.getMethodPUIs(), "method.methodPUI")
						.appendList(request.getScaleDbIds(), "scale.id")
						.appendList(request.getScaleNames(), "scale.name")
						.appendList(request.getScalePUIs(), "scale.scalePUI")
						.appendList(request.getTraitClasses(), "trait.traitClass")
						.appendList(request.getTraitDbIds(), "trait.id")
						.appendList(request.getTraitNames(), "trait.name")
						.appendList(request.getTraitPUIs(), "trait.traitPUI")
						.appendList(request.getTraitAttributes(), "trait.attribute")
						.appendList(request.getTraitAttributePUIs(), "trait.attributePUI")
						.appendList(request.getTraitEntities(), "trait.entity")
						.appendList(request.getTraitEntityPUIs(), "trait.entityPUI")
						.appendList(request.getOntologyDbIds(), "ontology.id")
						.appendList(request.getCommonCropNames(), "crop.crop_name");
	
		Page<GermplasmAttributeDefinitionEntity> page = attributeRepository.findAllBySearch(searchQuery, pageReq);
		List<GermplasmAttribute> attributes = page.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, page);
		return attributes;
	}

	public GermplasmAttribute getGermplasmAttribute(String attributeDbId) throws BrAPIServerException {
		return convertFromEntity(getGermplasmAttributeDefinitionEntity(attributeDbId, HttpStatus.NOT_FOUND));
	}

	public GermplasmAttributeDefinitionEntity getGermplasmAttributeDefinitionEntity(String attributeDbId)
			throws BrAPIServerException {
		return getGermplasmAttributeDefinitionEntity(attributeDbId, HttpStatus.BAD_REQUEST);
	}

	public GermplasmAttributeDefinitionEntity getGermplasmAttributeDefinitionEntity(String attributeDbId,
			HttpStatus errorStatus) throws BrAPIServerException {
		GermplasmAttributeDefinitionEntity attribute = null;
		Optional<GermplasmAttributeDefinitionEntity> entityOpt = attributeRepository.findById(attributeDbId);
		if (entityOpt.isPresent()) {
			attribute = entityOpt.get();
		} else {
			throw new BrAPIServerDbIdNotFoundException("germplasm attribute", attributeDbId);
		}
		return attribute;
	}

	public List<GermplasmAttribute> saveGermplasmAttributes(@Valid List<GermplasmAttributeNewRequest> body)
			throws BrAPIServerException {
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
		attrib.setAttributePUI(entity.getPUI());

		return attrib;

	}

	private void updateEntity(GermplasmAttributeDefinitionEntity entity, @Valid GermplasmAttributeNewRequest body)
			throws BrAPIServerException {

		observationVariableService.updateBaseEntity(entity, body);

		if (body.getAttributeName() != null)
			entity.setName(body.getAttributeName());
		if (body.getAttributeCategory() != null)
			entity.setAttributeCategory(body.getAttributeCategory());
		if (body.getAttributeDescription() != null)
			entity.setDescription(body.getAttributeDescription());
	}

}
