package org.brapi.test.BrAPITestServer.repository.germ;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.brapi.test.BrAPITestServer.model.entity.germ.GermplasmEntity;
import org.brapi.test.BrAPITestServer.service.CustomRepositorySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.swagger.model.germ.GermplasmSearchRequest;

public class GermplasmRepositoryImpl implements GermplasmRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private CustomRepositorySearchService<GermplasmEntity> customRepositorySearchService;
	
	public GermplasmRepositoryImpl(CustomRepositorySearchService<GermplasmEntity> customRepositorySearchService) {
		this.customRepositorySearchService = customRepositorySearchService;
	}

	@Override
	public Page<GermplasmEntity> findBySearch(GermplasmSearchRequest request, Pageable pageRequest) {
		Map<String, Object> params = new HashMap<>();
		String queryStr = buildQueryString(request, params);
		Page<GermplasmEntity> page = customRepositorySearchService.findAllBySearch(queryStr, params, pageRequest, GermplasmEntity.class, em);
		return page;
	}
	
	public String buildQueryString(GermplasmSearchRequest request, Map<String, Object> params) {
		String queryStr = "SELECT g FROM GermplasmEntity g where 1 = 1 ";

		if (request.getGermplasmDbIds() != null && !request.getGermplasmDbIds().isEmpty()) {
			queryStr += "AND g.id in :germplasmDbIds ";
			params.put("germplasmDbIds", request.getGermplasmDbIds());
		}
		if (request.getGenus() != null && !request.getGenus().isEmpty()) {
			queryStr += "AND g.genus in :genus ";
			params.put("genus", request.getGenus());
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
		if (request.getSpecies() != null && !request.getSpecies().isEmpty()) {
			queryStr += "AND g.species in :species ";
			params.put("species", request.getSpecies());
		}
		if (request.getAccessionNumbers() != null && !request.getAccessionNumbers().isEmpty()) {
			queryStr += "AND g.accessionNumber in :accessionNumbers ";
			params.put("accessionNumbers", request.getAccessionNumbers());
		}
		
		return queryStr;
	}
}
