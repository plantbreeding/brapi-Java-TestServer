package org.brapi.test.BrAPITestServer.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.brapi.test.BrAPITestServer.model.entity.GermplasmEntity;
import org.brapi.test.BrAPITestServer.model.entity.ImageEntity;
import org.brapi.test.BrAPITestServer.service.CustomRepositorySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import io.swagger.model.pheno.ImageSearchRequest;

public class ImageRepositoryImpl implements ImageRepositoryCustom {
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private CustomRepositorySearchService<ImageEntity> customRepositorySearchService;
	
	public ImageRepositoryImpl(CustomRepositorySearchService<ImageEntity> customRepositorySearchService) {
		this.customRepositorySearchService = customRepositorySearchService;
	}

	@Override
	public Page<ImageEntity> findBySearch(ImageSearchRequest request, Pageable pageRequest) {
		Map<String, Object> params = new HashMap<>();
		String queryStr = buildQueryString(request, params);
		Page<ImageEntity> page = customRepositorySearchService.findAllBySearch(queryStr, params, pageRequest, ImageEntity.class, em);
		return page;
	}	
	
	private String buildQueryString(ImageSearchRequest request, Map<String, Object> params) {
		String queryStr = "select i from ImageEntity i where 1 = 1 ";
		
		if(request.getObservationUnitDbIds() != null && !request.getObservationUnitDbIds().isEmpty()) {
			queryStr += "AND i.observationUnit.id IN :observationUnitDbIds ";
			params.put("observationUnitDbIds", request.getObservationUnitDbIds());
		}
		if(request.getObservationDbIds() != null && !request.getObservationDbIds().isEmpty()) {
			queryStr += "AND i.observationDbIds IN :observationDbIds ";
			params.put("observationDbIds", request.getObservationDbIds());
		}
		if(request.getDescriptiveOntologyTerms() != null && !request.getDescriptiveOntologyTerms().isEmpty()) {
			queryStr += "AND i.descriptiveOntologyTerms IN :descriptiveOntologyTerms ";
			params.put("descriptiveOntologyTerms", request.getDescriptiveOntologyTerms());
		}
		return queryStr;
	}
}
