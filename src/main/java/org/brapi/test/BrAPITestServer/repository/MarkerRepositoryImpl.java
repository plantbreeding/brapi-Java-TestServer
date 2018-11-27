package org.brapi.test.BrAPITestServer.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.brapi.test.BrAPITestServer.model.entity.ImageEntity;
import org.brapi.test.BrAPITestServer.model.entity.MarkerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import io.swagger.model.ImagesSearchRequest;
import io.swagger.model.MarkersSearchRequest;
import io.swagger.model.MarkersSearchRequest.MatchMethodEnum;

public class MarkerRepositoryImpl implements MarkerRepositoryCustom {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Page<MarkerEntity> findBySearch(MarkersSearchRequest request, Pageable pageReq) {

		Map<String, Object> params = new HashMap<>();
		String queryStr = buildQueryString(request, params);

		TypedQuery<MarkerEntity> query = em.createQuery(queryStr, MarkerEntity.class);
		for (Entry<String, Object> entry : params.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}

		query.setFirstResult((int) pageReq.getOffset());
		query.setMaxResults(pageReq.getPageSize());

		List<MarkerEntity> content = query.getResultList();
		PageImpl<MarkerEntity> page = new PageImpl<MarkerEntity>(content, pageReq, content.size());

		return page;
	}

	private String buildQueryString(MarkersSearchRequest request, Map<String, Object> params) {
		String queryStr = "select m from MarkerEntity m where 1 = 1 ";

		if (request.getMarkerDbIds() != null && !request.getMarkerDbIds().isEmpty()) {
			queryStr += "AND m.id IN :markerDbIds ";
			params.put("markerDbIds", request.getMarkerDbIds());
		}

		List<String> names = new ArrayList<String>();
		if (request.getMarkerNames() != null) {
			names.addAll(request.getMarkerNames());
		}
		if (request.getName() != null) {
			names.add(request.getName());
		}
		if (!names.isEmpty()) {
			if (request.getMatchMethod().equals(MatchMethodEnum.EXACT)) {
				queryStr += "AND m.markerName IN :markerNames ";
				params.put("markerNames", names);
			} else if (request.getMatchMethod().equals(MatchMethodEnum.CASE_INSENSITIVE)) {
				names = names.stream().map(n -> n.toLowerCase()).collect(Collectors.toList());

				queryStr += "AND lower(m.markerName) IN :markerNames ";
				params.put("markerNames", names);
			} else if (request.getMatchMethod().equals(MatchMethodEnum.WILDCARD)) {
				queryStr += "AND (";
				int i = 0;
				for (String name : names) {
					if (i > 0)
						queryStr += "OR ";
					queryStr += "lower(m.markerName) LIKE :markerName" + i + " ";
					params.put("markerName" + i, name.toLowerCase().replaceAll("[\\*\\%]", "%").replaceAll("\\?", "_"));
					i++;
				}
				queryStr += ") ";
			}
		}

		List<String> types = new ArrayList<String>();
		if (request.getTypes() != null) {
			types.addAll(request.getTypes());
		}
		if (request.getType() != null) {
			types.add(request.getType());
		}
		if (!types.isEmpty()) {
			queryStr += "AND m.type IN :types ";
			params.put("types", types);
		}

		return queryStr;
	}

}
