package org.brapi.test.BrAPITestServer.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.brapi.test.BrAPITestServer.model.entity.MarkerEntity;
import org.brapi.test.BrAPITestServer.service.CustomRepositorySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.swagger.model.MarkersSearchRequest;
import io.swagger.model.MarkersSearchRequest.MatchMethodEnum;

public class MarkerRepositoryImpl implements MarkerRepositoryCustom {
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private CustomRepositorySearchService<MarkerEntity> customRepositorySearchService;
	
	public MarkerRepositoryImpl(CustomRepositorySearchService<MarkerEntity> customRepositorySearchService) {
		this.customRepositorySearchService = customRepositorySearchService;
	}

	@Override
	public Page<MarkerEntity> findBySearch(MarkersSearchRequest request, Pageable pageRequest) {
		Map<String, Object> params = new HashMap<>();
		String queryStr = buildQueryString(request, params);
		Page<MarkerEntity> page = customRepositorySearchService.findAllBySearch(queryStr, params, pageRequest, MarkerEntity.class, em);
		return page;
	}	
	
	private String buildQueryString(MarkersSearchRequest request, Map<String, Object> params) {
		String queryStr = "select m from MarkerEntity m where 1 = 1 ";

		if (request.getMarkerDbIds() != null && !request.getMarkerDbIds().isEmpty()) {
			List<String> dbids = request.getMarkerDbIds();
			if (MatchMethodEnum.CASE_INSENSITIVE.equals(request.getMatchMethod())) {
				dbids = dbids.stream().map(n -> n.toLowerCase()).collect(Collectors.toList());

				queryStr += "AND lower(m.id) IN :markerDbIds ";
				params.put("markerDbIds", dbids);
			} else if (MatchMethodEnum.WILDCARD.equals(request.getMatchMethod())) {
				queryStr += "AND (";
				int i = 0;
				for (String dbid : dbids) {
					if (i > 0)
						queryStr += "OR ";
					queryStr += "lower(m.id) LIKE :markerDbIds" + i + " ";
					params.put("markerDbIds" + i, dbid.toLowerCase().replaceAll("[\\*\\%]", "%").replaceAll("\\?", "_"));
					i++;
				}
				queryStr += ") ";
			} else {
				queryStr += "AND m.id IN :markerDbIds ";
				params.put("markerDbIds", dbids);
			}
		}

		List<String> names = new ArrayList<String>();
		if (request.getMarkerNames() != null) {
			names.addAll(request.getMarkerNames());
		}
		if (request.getName() != null) {
			names.add(request.getName());
		}
		if (!names.isEmpty()) {
			if (MatchMethodEnum.CASE_INSENSITIVE.equals(request.getMatchMethod())) {
				names = names.stream().map(n -> n.toLowerCase()).collect(Collectors.toList());

				queryStr += "AND lower(m.markerName) IN :markerNames ";
				params.put("markerNames", names);
			} else if (MatchMethodEnum.WILDCARD.equals(request.getMatchMethod())) {
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
			} else {
				queryStr += "AND m.markerName IN :markerNames ";
				params.put("markerNames", names);
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
