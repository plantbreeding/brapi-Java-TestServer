package org.brapi.test.BrAPITestServer.repository;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.brapi.test.BrAPITestServer.model.entity.GenomeMapEntity;
import org.brapi.test.BrAPITestServer.service.CustomRepositorySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.swagger.model.GenomeMapSearchRequest;

public class GenomeMapRepositoryImpl implements GenomeMapRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private CustomRepositorySearchService<GenomeMapEntity> customRepositorySearchService;
	
	public GenomeMapRepositoryImpl(CustomRepositorySearchService<GenomeMapEntity> customRepositorySearchService) {
		this.customRepositorySearchService = customRepositorySearchService;
	}

	@Override
	public Page<GenomeMapEntity> findBySearch(GenomeMapSearchRequest request, Pageable pageRequest) {
		Map<String, Object> params = new HashMap<>();
		String queryStr = buildQueryString(request, params);
		Page<GenomeMapEntity> page = customRepositorySearchService.findAllBySearch(queryStr, params, pageRequest, GenomeMapEntity.class, em);
		return page;
	}
	
	public String buildQueryString(GenomeMapSearchRequest request, Map<String, Object> params) {
		String queryStr = "SELECT g FROM GenomeMapEntity g where 1 = 1 ";

		if (request.getCommonCropName() != null) {
			queryStr += "AND g.commonCropName = :commonCropName ";
			params.put("commonCropName", request.getCommonCropName());
		}
		if (request.getScientificName() != null) {
			queryStr += "AND g.scientificName = :scientificName ";
			params.put("scientificName", request.getScientificName());
		}
		if (request.getSpeciesId() != null) {
			queryStr += "AND g.species = :species ";
			params.put("species", request.getSpeciesId());
		}
		if (request.getType() != null) {
			queryStr += "AND g.type = :type ";
			params.put("type", request.getType());
		}
		
		return queryStr;
	}
}
