package org.brapi.test.BrAPITestServer.repository.pheno;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.brapi.test.BrAPITestServer.model.entity.geno.MarkerEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationUnitEntity;
import org.brapi.test.BrAPITestServer.service.CustomRepositorySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import io.swagger.model.pheno.ObservationSearchRequest;
import io.swagger.model.pheno.ObservationUnitSearchRequest;

public class ObservationUnitRepositoryImpl implements ObservationUnitRepositoryCustom{

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private CustomRepositorySearchService<ObservationUnitEntity> customRepositorySearchService;
	
	public ObservationUnitRepositoryImpl(CustomRepositorySearchService<ObservationUnitEntity> customRepositorySearchService) {
		this.customRepositorySearchService = customRepositorySearchService;
	}

	@Override
	public Page<ObservationUnitEntity> findBySearch(ObservationUnitSearchRequest request, Pageable pageRequest) {
		Map<String, Object> params = new HashMap<>();
		String queryStr = buildQueryString(request, params);
		Page<ObservationUnitEntity> page = customRepositorySearchService.findAllBySearch(queryStr, params, pageRequest, ObservationUnitEntity.class, em);
		return page;
	}

	private String buildQueryString(ObservationUnitSearchRequest request, Map<String, Object> params) {
		String queryStr = "select distinct o from ObservationUnitEntity o join o.observations observation  where 1 = 1 ";

		if (request.getGermplasmDbIds() != null && !request.getGermplasmDbIds().isEmpty()) {
			queryStr += "AND o.germplasm.id in :germplasmDbIds ";
			params.put("germplasmDbIds", request.getGermplasmDbIds());
		}
		if (request.getObservationVariableDbIds() != null && !request.getObservationVariableDbIds().isEmpty()) {
			queryStr += "AND observation.observationVariable.id in :observationVariableDbIds ";
			params.put("observationVariableDbIds", request.getObservationVariableDbIds());
		}
		if (request.getStudyDbIds() != null && !request.getStudyDbIds().isEmpty()) {
			queryStr += "AND o.study.id in :studyDbIds ";
			params.put("studyDbIds", request.getStudyDbIds());
		}
		if (request.getLocationDbIds() != null && !request.getLocationDbIds().isEmpty()) {
			queryStr += "AND o.study.location.id in :locationDbIds ";
			params.put("locationDbIds", request.getLocationDbIds());
		}
		if (request.getProgramDbIds() != null && !request.getProgramDbIds().isEmpty()) {
			queryStr += "AND o.study.trial.program.id in :programDbIds ";
			params.put("programDbIds", request.getProgramDbIds());
		}
//		if (request.getSeasonDbIds() != null && !request.getSeasonDbIds().isEmpty()) {
//			queryStr += "AND observation.season.id in :seasonDbIds ";
//			params.put("seasonDbIds", request.getSeasonDbIds());
//		}
//		if (request.getObservationLevel() != null) {
//			queryStr += "AND o.observationLevel in :observationLevel ";
//			params.put("observationLevel", request.getObservationLevel());
//		}
//		if (request.getObservationTimeStampRangeStart() != null && request.getObservationTimeStampRangeEnd() != null) {
//			queryStr += "AND observation.observationTimeStamp BETWEEN :observationTimeStart AND :observationTimeEnd ";
//			params.put("observationTimeStart", request.getObservationTimeStampRangeStart());
//			params.put("observationTimeEnd", request.getObservationTimeStampRangeEnd());
//		}else if(request.getObservationTimeStampRangeStart() != null) {
//			queryStr += "AND observation.observationTimeStamp >= :observationTimeStart ";
//			params.put("observationTimeStart", request.getObservationTimeStampRangeStart());			
//		}else if(request.getObservationTimeStampRangeEnd() != null) {
//			queryStr += "AND observation.observationTimeStamp <= :observationTimeEnd ";
//			params.put("observationTimeEnd", request.getObservationTimeStampRangeEnd());
//		}
		
		return queryStr;
	}
}
