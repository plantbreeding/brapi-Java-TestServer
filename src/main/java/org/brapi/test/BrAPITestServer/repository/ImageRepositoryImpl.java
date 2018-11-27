package org.brapi.test.BrAPITestServer.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.brapi.test.BrAPITestServer.model.entity.ImageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import io.swagger.model.ImagesSearchRequest;
import io.swagger.model.SampleSearchRequestDep;

public class ImageRepositoryImpl implements ImageRepositoryCustom {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Page<ImageEntity> findBySearch(ImagesSearchRequest request, Pageable pageReq) {

		Map<String, Object> params = new HashMap<>();
		String queryStr = buildQueryString(request, params);
		
		TypedQuery<ImageEntity> query = em.createQuery(queryStr, ImageEntity.class);
		for(Entry<String, Object> entry: params.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		
		query.setFirstResult((int) pageReq.getOffset());
		query.setMaxResults(pageReq.getPageSize());
		
		List<ImageEntity> content = query.getResultList();
		PageImpl<ImageEntity> page = new PageImpl<>(content, pageReq, content.size());
		
		return page;
	}
	
	private String buildQueryString(ImagesSearchRequest request, Map<String, Object> params) {
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
