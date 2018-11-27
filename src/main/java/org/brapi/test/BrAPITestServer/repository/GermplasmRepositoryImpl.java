package org.brapi.test.BrAPITestServer.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.brapi.test.BrAPITestServer.model.entity.GermplasmEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import io.swagger.model.GermplasmSearchRequest;

public class GermplasmRepositoryImpl implements GermplasmRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Page<GermplasmEntity> findBySearch(GermplasmSearchRequest request, Pageable pageReq) {

		Map<String, List<String>> params = new HashMap<>();
		String queryStr = buildQueryString(request, params);

		TypedQuery<GermplasmEntity> query = em.createQuery(queryStr, GermplasmEntity.class);
		for (Entry<String, List<String>> entry : params.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}

		query.setFirstResult((int) pageReq.getOffset());
		query.setMaxResults(pageReq.getPageSize());

		List<GermplasmEntity> content = query.getResultList();
		PageImpl<GermplasmEntity> page = new PageImpl<>(content, pageReq, content.size());

		return page;
	}

	private String buildQueryString(GermplasmSearchRequest request, Map<String, List<String>> params) {

		String queryStr = "SELECT g FROM GermplasmEntity g where 1 = 1 ";

		if (request.getGermplasmDbIds() != null && !request.getGermplasmDbIds().isEmpty()) {
			queryStr += "AND g.id in :germplasmDbIds ";
			params.put("germplasmDbIds", request.getGermplasmDbIds());
		}
		if (request.getGermplasmGenus() != null && !request.getGermplasmGenus().isEmpty()) {
			queryStr += "AND g.genus in :genus ";
			params.put("genus", request.getGermplasmGenus());
		}
		if (request.getCommonCropNames() != null && !request.getCommonCropNames().isEmpty()) {
			queryStr += "AND g.commonCropName in :commonCropName ";
			params.put("commonCropName", request.getCommonCropNames());
		}
		if (request.getGermplasmNames() != null && !request.getGermplasmNames().isEmpty()) {
			queryStr += "AND g.germplasmName in :names ";
			params.put("names", request.getGermplasmNames());
		}
		if (request.getGermplasmPUIs() != null && !request.getGermplasmPUIs().isEmpty()) {
			queryStr += "AND g.germplasmPUI in :puis ";
			params.put("puis", request.getGermplasmPUIs());
		}
		if (request.getGermplasmSpecies() != null && !request.getGermplasmSpecies().isEmpty()) {
			queryStr += "AND g.species in :species ";
			params.put("species", request.getGermplasmSpecies());
		}
		if (request.getAccessionNumbers() != null && !request.getAccessionNumbers().isEmpty()) {
			queryStr += "AND g.accessionNumber in :accessionNumbers ";
			params.put("accessionNumbers", request.getAccessionNumbers());
		}
		
		return queryStr;
	}
}
