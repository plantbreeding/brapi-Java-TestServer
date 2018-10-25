package org.brapi.test.BrAPITestServer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.model.entity.GermplasmAttributeDefinitionEntity;
import org.brapi.test.BrAPITestServer.model.entity.GermplasmAttributeValueEntity;
import org.brapi.test.BrAPITestServer.repository.GermplasmAttributeCategoryRepository;
import org.brapi.test.BrAPITestServer.repository.GermplasmAttributeDefinitionRepository;
import org.brapi.test.BrAPITestServer.repository.GermplasmAttributeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.swagger.model.GermplasmAttribute;
import io.swagger.model.GermplasmAttributeCategory;
import io.swagger.model.GermplasmAttributeDef;
import io.swagger.model.Metadata;

@Service
public class GermplasmAttributeService {

	private GermplasmAttributeDefinitionRepository attributeRepository;
	private GermplasmAttributeCategoryRepository categoryRepository;
	private GermplasmAttributeValueRepository attributeValueRepository;

	@Autowired
	public GermplasmAttributeService(GermplasmAttributeDefinitionRepository attributeRepository,
			GermplasmAttributeCategoryRepository categoryRepository,
			GermplasmAttributeValueRepository attributeValueRepository) {
		this.categoryRepository = categoryRepository;
		this.attributeRepository = attributeRepository;
		this.attributeValueRepository = attributeValueRepository;
	}

	public List<GermplasmAttributeDef> getGermplasmAttributes(String attributeCategoryDbId, Metadata metaData) {
		Page<GermplasmAttributeDefinitionEntity> page;
		Pageable pageReq = PagingUtility.getPageRequest(metaData);

		if (attributeCategoryDbId == null) {
			page = attributeRepository.findAll(pageReq);
		} else {
			page = attributeRepository.findByAttributeCategory_Id(attributeCategoryDbId, pageReq);
		}
		PagingUtility.calculateMetaData(metaData, page);

		List<GermplasmAttributeDef> attributes = page.map(this::mapFromEntityToAttribute).getContent();
		return attributes;
	}

	private GermplasmAttributeDef mapFromEntityToAttribute(GermplasmAttributeDefinitionEntity entity) {
		GermplasmAttributeDef attrib = new GermplasmAttributeDef();
		attrib.setAttributeCategoryDbId(entity.getAttributeCategory().getId());
		attrib.setAttributeDbId(entity.getId());
		attrib.setCode(entity.getCode());
		attrib.setDatatype(entity.getDatatype());
		attrib.setDescription(entity.getDescription());
		attrib.setName(entity.getName());
		attrib.setUri(entity.getUri());
		attrib.setValues(entity.getValues().get(0).getValue());
		return attrib;
	}

	public List<GermplasmAttributeCategory> getGermplasmAttributeCategories(Metadata metaData) {

		List<GermplasmAttributeCategory> categories = categoryRepository.findAll(PagingUtility.getPageRequest(metaData))
				.map(c -> {
					GermplasmAttributeCategory cat = new GermplasmAttributeCategory();
					cat.setAttributeCategoryDbId(c.getId());
					cat.setName(c.getName());
					return cat;
				}).getContent();
		PagingUtility.calculateMetaData(metaData);

		return categories;
	}

	public List<GermplasmAttribute> getGermplasmAttributeValues(String germplasmDbId, List<String> attributeList,
			Metadata metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Page<GermplasmAttributeValueEntity> valuesPage;
		if (attributeList == null || attributeList.isEmpty()) {
			valuesPage = attributeValueRepository.findByGermplasm_Id(germplasmDbId, pageReq);
		} else {
			valuesPage = attributeValueRepository
					.findByGermplasm_IdAndGermplasmAttributeDefinition_IdIsIn(germplasmDbId, attributeList, pageReq);
		}

		PagingUtility.calculateMetaData(metaData, valuesPage);
		return valuesPage.map(this::mapFromEntityToValue).getContent();
	}

	private GermplasmAttribute mapFromEntityToValue(GermplasmAttributeValueEntity entity) {
		GermplasmAttribute attrib = new GermplasmAttribute();
		attrib.setAttributeCode(entity.getGermplasmAttributeDefinition().getCode());
		attrib.setAttributeDbId(entity.getGermplasmAttributeDefinition().getId());
		attrib.setAttributeName(entity.getGermplasmAttributeDefinition().getName());
		attrib.setDeterminedDate(DateUtility.toLocalDate(entity.getDeterminedDate()));
		attrib.setValue(entity.getValue());
		return attrib;
	}

}
