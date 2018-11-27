package org.brapi.test.BrAPITestServer.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.brapi.test.BrAPITestServer.model.entity.SampleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import io.swagger.model.SampleSearchRequestDep;

public class SampleRepositoryImpl implements SampleRepositoryCustom {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Page<SampleEntity> findBySearch(SampleSearchRequestDep request, Pageable pageReq) {

		Map<String, Object> params = new HashMap<>();
		String queryStr = buildQueryString(request, params);

		TypedQuery<SampleEntity> query = em.createQuery(queryStr, SampleEntity.class);
		for (Entry<String, Object> entry : params.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}

		query.setFirstResult((int) pageReq.getOffset());
		query.setMaxResults(pageReq.getPageSize());

		List<SampleEntity> content = query.getResultList();
		PageImpl<SampleEntity> page = new PageImpl<>(content, pageReq, content.size());

		return page;
	}

	private String buildQueryString(SampleSearchRequestDep request, Map<String, Object> params) {
		String queryStr = "select s from SampleEntity s where 1 = 1 ";

		if (request.getSampleDbId() != null && !request.getSampleDbId().isEmpty()) {
			queryStr += "AND s.id IN :sampleDbIds ";
			params.put("sampleDbIds", request.getSampleDbId());
		}
		if (request.getObservationUnitDbId() != null && !request.getObservationUnitDbId().isEmpty()) {
			queryStr += "AND s.observationUnit.id IN :observationUnitDbIds ";
			params.put("observationUnitDbIds", request.getObservationUnitDbId());
		}
		if (request.getPlateDbId() != null && !request.getPlateDbId().isEmpty()) {
			queryStr += "AND s.plate.id IN :plateDbIds ";
			params.put("plateDbIds", request.getPlateDbId());
		}
		if (request.getGermplasmDbId() != null && !request.getGermplasmDbId().isEmpty()) {
			queryStr += "AND s.observationUnit.germplasm.id IN :germplasmDbIds ";
			params.put("germplasmDbIds", request.getGermplasmDbId());
		}
		
		return queryStr;
	}
}
