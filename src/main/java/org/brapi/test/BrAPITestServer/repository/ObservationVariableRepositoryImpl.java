package org.brapi.test.BrAPITestServer.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.brapi.test.BrAPITestServer.model.entity.ObservationUnitEntity;
import org.brapi.test.BrAPITestServer.model.entity.ObservationVariableEntity;
import org.brapi.test.BrAPITestServer.service.CustomRepositorySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import io.swagger.model.pheno.ObservationVariableSearchRequest;

public class ObservationVariableRepositoryImpl {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private CustomRepositorySearchService<ObservationVariableEntity> customRepositorySearchService;
	
	public ObservationVariableRepositoryImpl(CustomRepositorySearchService<ObservationVariableEntity> customRepositorySearchService) {
		this.customRepositorySearchService = customRepositorySearchService;
	}

	public Page<ObservationVariableEntity> findBySearch(ObservationVariableSearchRequest request, Pageable pageRequest) {
		Map<String, Object> params = new HashMap<>();
		String queryStr = buildQueryString(request, params);
		Page<ObservationVariableEntity> page = customRepositorySearchService.findAllBySearch(queryStr, params, pageRequest, ObservationVariableEntity.class, em);
		return page;
	}

	private String buildQueryString(ObservationVariableSearchRequest request, Map<String, Object> params) {
		String query = "select o from ObservationVariableEntity o where 1=1 ";

		if (request.getDataTypes() != null && !request.getDataTypes().isEmpty()) {
			List<String> dataTypes = request.getDataTypes().stream().map(d -> toString()).collect(Collectors.toList());
			query += "AND o.scale.dataType in :dataTypes ";
			params.put("dataTypes", dataTypes);
		}
		if (request.getMethodDbIds() != null && !request.getMethodDbIds().isEmpty()) {
			query += "AND o.method.id in :methodDbIds ";
			params.put("methodDbIds", request.getMethodDbIds());
		}
		if (request.getObservationVariableDbIds() != null && !request.getObservationVariableDbIds().isEmpty()) {
			query += "AND o.id in :observationVariableDbIds ";
			params.put("observationVariableDbIds", request.getObservationVariableDbIds());
		}
		if (request.getObservationVariableNames() != null && !request.getObservationVariableNames().isEmpty()) {
			query += "AND o.name in :observationVariableNames ";
			params.put("observationVariableNames", request.getObservationVariableNames());
		}
//		if (request.getObservationVariableXrefs() != null && !request.getObservationVariableXrefs().isEmpty()) {
//			query += "AND (o.xref in :observationVariableXrefs "
//					+ "OR o.scale.xref in :observationVariableXrefs "
//					+ "OR o.method.xref in :observationVariableXrefs "
//					+ "OR o.trait.xref in :observationVariableXrefs) ";
//			params.put("observationVariableXrefs", request.getObservationVariableXrefs());
//		}
		if (request.getOntologyDbIds() != null && !request.getOntologyDbIds().isEmpty()) {
			query += "AND o.ontology.id in :ontologyDbIds ";
			params.put("ontologyDbIds", request.getOntologyDbIds());
		}
		if (request.getScaleDbIds() != null && !request.getScaleDbIds().isEmpty()) {
			query += "AND o.scale.id in :scaleDbIds ";
			params.put("scaleDbIds", request.getScaleDbIds());
		}
//		if (request.getScaleXrefs() != null && !request.getScaleXrefs().isEmpty()) {
//			query += "AND o.scale.xref in :scaleXrefs ";
//			params.put("scaleXrefs", request.getScaleXrefs());
//		}
		if (request.getTraitClasses() != null && !request.getTraitClasses().isEmpty()) {
			query += "AND o.trait.traitClass in :traitClasses ";
			params.put("traitClasses", request.getTraitClasses());
		}
		if (request.getTraitDbIds() != null && !request.getTraitDbIds().isEmpty()) {
			query += "AND o.trait.id in :traitDbIds ";
			params.put("traitDbIds", request.getTraitDbIds());
		}
//		if (request.getTraitXrefs() != null && !request.getTraitXrefs().isEmpty()) {
//			query += "AND o.trait.xref in :traitXrefs ";
//			params.put("traitXrefs", request.getTraitXrefs());
//		}
//		
		return query;

	}

}
