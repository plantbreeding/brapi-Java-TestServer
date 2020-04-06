package org.brapi.test.BrAPITestServer.repository.geno;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.brapi.test.BrAPITestServer.model.entity.geno.SampleEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationVariableEntity;
import org.brapi.test.BrAPITestServer.service.CustomRepositorySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import io.swagger.model.geno.SampleSearchRequest;

public class SampleRepositoryImpl implements SampleRepositoryCustom {
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private CustomRepositorySearchService<SampleEntity> customRepositorySearchService;
	
	public SampleRepositoryImpl(CustomRepositorySearchService<SampleEntity> customRepositorySearchService) {
		this.customRepositorySearchService = customRepositorySearchService;
	}

	@Override
	public Page<SampleEntity> findBySearch(SampleSearchRequest request, Pageable pageRequest) {
		Map<String, Object> params = new HashMap<>();
		String queryStr = buildQueryString(request, params);
		Page<SampleEntity> page = customRepositorySearchService.findAllBySearch(queryStr, params, pageRequest, SampleEntity.class, em);
		return page;
	}

	private String buildQueryString(SampleSearchRequest request, Map<String, Object> params) {
		String queryStr = "select s from SampleEntity s where 1 = 1 ";

//		if (request.getSampleDbId() != null && !request.getSampleDbId().isEmpty()) {
//			queryStr += "AND s.id IN :sampleDbIds ";
//			params.put("sampleDbIds", request.getSampleDbId());
//		}
//		if (request.getObservationUnitDbId() != null && !request.getObservationUnitDbId().isEmpty()) {
//			queryStr += "AND s.observationUnit.id IN :observationUnitDbIds ";
//			params.put("observationUnitDbIds", request.getObservationUnitDbId());
//		}
//		if (request.getPlateDbId() != null && !request.getPlateDbId().isEmpty()) {
//			queryStr += "AND s.plate.id IN :plateDbIds ";
//			params.put("plateDbIds", request.getPlateDbId());
//		}
//		if (request.getGermplasmDbId() != null && !request.getGermplasmDbId().isEmpty()) {
//			queryStr += "AND s.observationUnit.germplasm.id IN :germplasmDbIds ";
//			params.put("germplasmDbIds", request.getGermplasmDbId());
//		}
		
		return queryStr;
	}
}
