package org.brapi.test.BrAPITestServer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.model.entity.GermplasmAttributeDefinitionEntity;
import org.brapi.test.BrAPITestServer.model.entity.GermplasmAttributeValueEntity;
import org.brapi.test.BrAPITestServer.model.rest.GermplasmAttributeDefinition;
import org.brapi.test.BrAPITestServer.model.rest.GermplasmAttributeCategory;
import org.brapi.test.BrAPITestServer.model.rest.GermplasmAttributeValuesWrapper;
import org.brapi.test.BrAPITestServer.model.rest.GermplasmAttributeValue;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.brapi.test.BrAPITestServer.repository.GermplasmAttributeCategoryRepository;
import org.brapi.test.BrAPITestServer.repository.GermplasmAttributeDefinitionRepository;
import org.brapi.test.BrAPITestServer.repository.GermplasmAttributeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GermplasmAttributeService {
	
	private GermplasmAttributeDefinitionRepository attributeRepository;
	private GermplasmAttributeCategoryRepository categoryRepository;
	private GermplasmAttributeValueRepository attributeValueRepository;
	
	@Autowired
	public GermplasmAttributeService(GermplasmAttributeDefinitionRepository attributeRepository, 
			GermplasmAttributeCategoryRepository categoryRepository, GermplasmAttributeValueRepository attributeValueRepository) {
		this.categoryRepository = categoryRepository;
		this.attributeRepository = attributeRepository;
		this.attributeValueRepository = attributeValueRepository;
	}

	public List<GermplasmAttributeDefinition> getGermplasmAttributes(String attributeCategoryDbId, MetaData metaData) {
		List<GermplasmAttributeDefinition> attributes;
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		
		if(attributeCategoryDbId == null) {
			attributes = attributeRepository
					.findAll(pageReq)
					.map(this::mapFromEntityToAttribute)
					.getContent();
		}else {
			attributes = attributeRepository
					.findByAttributeCategory_Id(attributeCategoryDbId, pageReq)
					.map(this::mapFromEntityToAttribute)
					.getContent();
		}
		
		PagingUtility.calculateMetaData(metaData);
		return attributes;
	}
	
	private GermplasmAttributeDefinition mapFromEntityToAttribute(GermplasmAttributeDefinitionEntity entity) {
		GermplasmAttributeDefinition attrib = new GermplasmAttributeDefinition();
		attrib.setAttributeCategoryDbId(entity.getAttributeCategory().getId());
		attrib.setCode(entity.getCode());
		attrib.setDatatype(entity.getDatatype());
		attrib.setDescription(entity.getDescription());
		attrib.setName(entity.getName());
		attrib.setUri(entity.getUri());
		attrib.setValues(entity.getValues()
				.stream()
				.map(v -> {return v.getValue();})
				.collect(Collectors.toList()));
		return attrib;
	}

	public List<GermplasmAttributeCategory> getGermplasmAttributeCategories(MetaData metaData) {
		
		List<GermplasmAttributeCategory> categories = categoryRepository
				.findAll(PagingUtility.getPageRequest(metaData))
				.map(c -> {
					GermplasmAttributeCategory cat = new GermplasmAttributeCategory();
					cat.setAttributeCategoryDbId(c.getId());
					cat.setName(c.getName());
					return cat;
				})
				.getContent();
		PagingUtility.calculateMetaData(metaData);
		
		return categories;
	}

	public GermplasmAttributeValuesWrapper getGermplasmAttributeValues(String germplasmDbId, List<String> attributeList,
			MetaData metaData) {
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		Page<GermplasmAttributeValueEntity> valuesPage;
		if(attributeList == null || attributeList.isEmpty()) {
			valuesPage = attributeValueRepository.findByGermplasm_Id(germplasmDbId, pageReq);
		}else {
			valuesPage = attributeValueRepository.findByGermplasm_IdAndGermplasmAttributeDefinition_IdIsIn(germplasmDbId, attributeList, pageReq);
		}
		
		//TODO this wrapper is unnessesary
		GermplasmAttributeValuesWrapper wrapper = new GermplasmAttributeValuesWrapper();
		wrapper.setGermplasmDbId(germplasmDbId);
		wrapper.setData(valuesPage.map(this::mapFromEntityToValue).getContent());
		
		PagingUtility.calculateMetaData(metaData, valuesPage);
		return wrapper;
	}

	
	private GermplasmAttributeValue mapFromEntityToValue(GermplasmAttributeValueEntity entity) {
		GermplasmAttributeValue attrib = new GermplasmAttributeValue();
		attrib.setAttributeCode(entity.getGermplasmAttributeDefinition().getCode());
		attrib.setAttributeDbId(entity.getGermplasmAttributeDefinition().getId());
		attrib.setAttributeName(entity.getGermplasmAttributeDefinition().getName());
		attrib.setDeterminedDate(entity.getDeterminedDate());
		attrib.setValue(entity.getValue());
		return attrib;
	}

}
