package org.brapi.test.BrAPITestServer.repository;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.brapi.test.BrAPITestServer.model.entity.SeasonEntity;
import org.brapi.test.BrAPITestServer.model.entity.StudyEntity;
import org.brapi.test.BrAPITestServer.service.CustomRepositorySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public class SeasonRepositoryImpl implements SeasonRepositoryCustom{

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private CustomRepositorySearchService<SeasonEntity> customRepositorySearchService;
	
	public SeasonRepositoryImpl(CustomRepositorySearchService<SeasonEntity> customRepositorySearchService) {
		this.customRepositorySearchService = customRepositorySearchService;
	}
	
	@Override
	public Page<SeasonEntity> findBySearch(String seasonDbId, String season, Integer year, Pageable pageRequest) {
		Map<String, Object> params = new HashMap<>();
		String queryStr = buildQueryString(seasonDbId, season, year, params);
		Page<SeasonEntity> page = customRepositorySearchService.findAllBySearch(queryStr, params, pageRequest, SeasonEntity.class, em);
		return page;
	}

	private String buildQueryString(String seasonDbId, String season, Integer year, Map<String, Object> params) {
		String queryStr = "select s from SeasonEntity s where 1=1 " ;

		if (seasonDbId != null) {
			queryStr += "AND s.id = :seasonDbId ";
			params.put("seasonDbId", seasonDbId);
		}
		if (season != null) {
			queryStr += "AND s.season = :season ";
			params.put("season", season);
		}
		if (year != null) {
			queryStr += "AND s.year = :year ";
			params.put("year", year);
		}
		
		return queryStr;
	}
	
}
