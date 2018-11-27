package org.brapi.test.BrAPITestServer.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.brapi.test.BrAPITestServer.model.entity.StudyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import io.swagger.model.StudySearchRequest;
import io.swagger.model.StudySearchRequest.SortByEnum;
import io.swagger.model.StudySearchRequest.SortOrderEnum;

public class StudyRepositoryImpl implements StudyRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Page<StudyEntity> findBySearch(StudySearchRequest request, SortByEnum sortBy, SortOrderEnum sortOrder, Pageable pageReq) {

		Map<String, Object> params = new HashMap<>();
		String queryStr = buildQueryString(request, sortBy, sortOrder, params);

		TypedQuery<StudyEntity> query = em.createQuery(queryStr, StudyEntity.class);
		for (Entry<String, Object> entry : params.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		
		query.setFirstResult((int) pageReq.getOffset());
		query.setMaxResults(pageReq.getPageSize());

		List<StudyEntity> content = query.getResultList();
		PageImpl<StudyEntity> page = new PageImpl<StudyEntity>(content, pageReq, content.size());

		return page;
	}

	private String buildQueryString(StudySearchRequest request, SortByEnum sortBy, SortOrderEnum sortOrder, Map<String, Object> params) {
		String queryStr = "select distinct s from StudyEntity s "
				+ "JOIN s.seasons season "
				+ "JOIN s.observationUnits ou "
				+ "JOIN ou.observations observation where 1=1 " ;

		if (request.getStudyTypeDbIds() != null && !request.getStudyTypeDbIds().isEmpty()) {
			queryStr += "AND s.studyType.id IN :studyTypeDbIds ";
			params.put("studyTypeDbIds", request.getStudyTypeDbIds());
		}
		if (request.getStudyTypeNames() != null && !request.getStudyTypeNames().isEmpty()) {
			queryStr += "AND s.studyType.name IN :studyTypeNames ";
			params.put("studyTypeNames", request.getStudyTypeNames());
		}
		if (request.getProgramDbIds() != null && !request.getProgramDbIds().isEmpty()) {
			queryStr += "AND s.trial.program.id IN :programDbIds ";
			params.put("programDbIds", request.getProgramDbIds());
		}
		if (request.getTrialDbIds() != null && !request.getTrialDbIds().isEmpty()) {
			queryStr += "AND s.trial.id IN :trialDbIds ";
			params.put("trialDbIds", request.getTrialDbIds());
		}
		if (request.getStudyDbIds() != null && !request.getStudyDbIds().isEmpty()) {
			queryStr += "AND s.id IN :studyDbIds ";
			params.put("studyDbIds", request.getStudyDbIds());
		}
		if (request.getProgramNames() != null && !request.getProgramNames().isEmpty()) {
			queryStr += "AND s.trial.program.name IN :programNames ";
			params.put("programNames", request.getProgramNames());
		}
		if (request.getStudyNames() != null && !request.getStudyNames().isEmpty()) {
			queryStr += "AND s.studyName IN :studyNames ";
			params.put("studyNames", request.getStudyNames());
		}
		if (request.getLocationDbIds() != null && !request.getLocationDbIds().isEmpty()) {
			queryStr += "AND s.location.id IN :locationDbIds ";
			params.put("locationDbIds", request.getLocationDbIds());
		}
		if (request.getSeasonDbIds() != null && !request.getSeasonDbIds().isEmpty()) {
			queryStr += "AND season.id IN :seasonDbIds ";
			params.put("seasonDbIds", request.getSeasonDbIds());
		}
		if (request.getGermplasmDbIds() != null && !request.getGermplasmDbIds().isEmpty()) {
			queryStr += "AND ou.germplasm.id IN :germplasmDbIds ";
			params.put("germplasmDbIds", request.getGermplasmDbIds());
		}
		if (request.getObservationVariableDbIds() != null && !request.getObservationVariableDbIds().isEmpty()) {
			queryStr += "AND observation.observationVariable.id IN :observationVariableDbIds ";
			params.put("observationVariableDbIds", request.getObservationVariableDbIds());
		}
		if (request.isActive() != null) {
			queryStr += "AND :active = s.active ";
			params.put("active", request.isActive());
		}
		
		queryStr += buildSort(sortOrder, sortBy);
		
		return queryStr;
	}
	
	private String buildSort(SortOrderEnum sortOrder, SortByEnum sortBy) {		
		String sortOrderStr = "asc";
		if (sortOrder != null) {
			switch (sortOrder) {
			case DESC:
				sortOrderStr = "desc";
				break;
			case ASC:
			default:
				sortOrderStr = "asc";
				break;
			}
		}

		String sortByStr = "s.id";
		if (sortBy != null) {
			switch (sortBy) {
			case GERMPLASMDBID:
				sortByStr = "ou.germplasm.id";
				break;
			case LOCATIONDBID:
				sortByStr = "location.id";
				break;
			case OBSERVATIONVARIABLEDBID:
				sortByStr = "observation.observationVariable.id";
				break;
			case PROGRAMDBID:
				sortByStr = "trial.program.id";
				break;
			case PROGRAMNAME:
				sortByStr = "trial.program.name";
				break;
			case SEASONDBID:
				sortByStr = "season.id";
				break;
			case STUDYDBID:
				sortByStr = "s.id";
				break;
			case STUDYLOCATION:
				sortByStr = "location.id";
				break;
			case STUDYTYPEDBID:
				sortByStr = "studyType.id";
				break;
			case STUDYTYPENAME:
				sortByStr = "studyType.name";
				break;
			case TRIALDBID:
				sortByStr = "trial.id ";
				break;
			case STUDYNAME:
			default:
				sortByStr = "studyName";
				break;
			}
		}

		return "ORDER BY " + sortByStr + " " + sortOrderStr;
	}
}
