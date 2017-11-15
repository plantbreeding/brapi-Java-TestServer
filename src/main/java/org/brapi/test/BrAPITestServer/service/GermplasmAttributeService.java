package org.brapi.test.BrAPITestServer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.brapi.test.BrAPITestServer.model.entity.GermplasmAttributeCategoryEntity;
import org.brapi.test.BrAPITestServer.model.entity.GermplasmAttributeEntity;
import org.brapi.test.BrAPITestServer.model.rest.GermplasmAttribute;
import org.brapi.test.BrAPITestServer.model.rest.GermplasmAttributeCategory;
import org.brapi.test.BrAPITestServer.model.rest.GermplasmAttributeMasterWrapper;
import org.brapi.test.BrAPITestServer.model.rest.GermplasmAttributeWrapper;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.brapi.test.BrAPITestServer.repository.GermplasmAttributeCategoryRepository;
import org.brapi.test.BrAPITestServer.repository.GermplasmAttributeRepository;
import org.brapi.test.BrAPITestServer.repository.GermplasmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GermplasmAttributeService {
	
	private GermplasmAttributeRepository attributeRepository;
	private GermplasmAttributeCategoryRepository categoryRepository;
	
	@Autowired
	public GermplasmAttributeService(GermplasmAttributeRepository attributeRepository, 
			GermplasmAttributeCategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
		this.attributeRepository = attributeRepository;
	}

	public List<GermplasmAttribute> getGermplasmAttributes(String attributeCategoryDbId, MetaData metaData) {
		List<GermplasmAttribute> attributes;
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
	
	private GermplasmAttribute mapFromEntityToAttribute(GermplasmAttributeEntity entity) {
		GermplasmAttribute attrib = new GermplasmAttribute();
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

	public GermplasmAttributeMasterWrapper getGermplasmAttributes(String germplasmDbId, List<String> attributeList,
			MetaData metaData) {
		List<GermplasmAttributeWrapper> attributes;
		Pageable pageReq = PagingUtility.getPageRequest(metaData);
		if(attributeList == null || attributeList.isEmpty()) {
			attributes = attributeRepository
					.findByGermplasmDbId(germplasmDbId, pageReq)
					.map(this::mapFromEntityToWrapper)
					.getContent();
			metaData.getPagination().setTotalCount((int) attributeRepository.countByGermplasmDbId(germplasmDbId));
		}else {
			attributes = attributeRepository
					.findByGermplasmDbIdAndIdIsIn(germplasmDbId, attributeList, pageReq)
					.map(this::mapFromEntityToWrapper)
					.getContent();
			metaData.getPagination().setTotalCount((int) attributeRepository.countByGermplasmDbIdAndIdIsIn(germplasmDbId, attributeList));
		}
		
		//TODO this wrapper is unnessesary
		GermplasmAttributeMasterWrapper wrapper = new GermplasmAttributeMasterWrapper();
		wrapper.setGermplasmDbId(germplasmDbId);
		wrapper.setData(attributes);
		
		PagingUtility.calculateMetaData(metaData);
		return wrapper;
	}

	
	private GermplasmAttributeWrapper mapFromEntityToWrapper(GermplasmAttributeEntity entity) {
		GermplasmAttributeWrapper attrib = new GermplasmAttributeWrapper();
		attrib.setAttributeCode(entity.getCode());
		attrib.setAttributeDbId(entity.getId());
		attrib.setAttributeName(entity.getName());
		//TODO This mapping is broken, where does this data come from
//		attrib.setDeterminedDate(entity.getDeterminedDate());
//		attrib.setValue(value);
		return attrib;
	}

}
