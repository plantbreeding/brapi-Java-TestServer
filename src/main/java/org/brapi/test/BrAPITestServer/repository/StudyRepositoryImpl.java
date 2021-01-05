package org.brapi.test.BrAPITestServer.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.brapi.test.BrAPITestServer.model.entity.SampleEntity;
import org.brapi.test.BrAPITestServer.model.entity.StudyEntity;
import org.brapi.test.BrAPITestServer.service.CustomRepositorySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import io.swagger.model.SampleSearchRequestDep;
import io.swagger.model.StudySearchRequest;
import io.swagger.model.StudySearchRequest.SortByEnum;
import io.swagger.model.StudySearchRequest.SortOrderEnum;

public class StudyRepositoryImpl implements StudyRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private CustomRepositorySearchService<StudyEntity> customRepositorySearchService;
	
	public StudyRepositoryImpl(CustomRepositorySearchService<StudyEntity> customRepositorySearchService) {
		this.customRepositorySearchService = customRepositorySearchService;
	}

	@Override
	public Page<StudyEntity> findBySearch(StudySearchRequest request, Pageable pageRequest) {
		Map<String, Object> params = new HashMap<>();
		String queryStr = buildQueryString(request, params);
		Page<StudyEntity> page = customRepositorySearchService.findAllBySearch(queryStr, params, pageRequest, StudyEntity.class, em);
		return page;
	}

	private String buildQueryString(StudySearchRequest request, Map<String, Object> params) {
		String queryStr = "select distinct s from StudyEntity s "
				+ "LEFT JOIN s.seasons season "
				+ "LEFT JOIN s.observationUnits ou "
				+ "LEFT JOIN ou.observations observation where 1=1 " ;

		if (request.getCommonCropNames() != null && !request.getCommonCropNames().isEmpty()) {
			queryStr += "AND s.trial.program.crop.cropName IN :commonCropNames ";
			params.put("commonCropNames", request.getCommonCropNames());
		}
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
		
		queryStr += buildSort(request.getSortOrder(), request.getSortBy());
		
		return queryStr;
	}
	
	private String buildSort(SortOrderEnum sortOrder, SortByEnum sortBy) {		
		String sortOrderStr = "asc";
		if (sortOrder != null) {
			switch (sortOrder) {
			case DESC:
			case DESC_LOWER:
				sortOrderStr = "desc";
				break;
			case ASC:
			case ASC_LOWER:
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
				sortByStr = "s.location.id";
				break;
			case OBSERVATIONVARIABLEDBID:
				sortByStr = "observation.observationVariable.id";
				break;
			case PROGRAMDBID:
				sortByStr = "s.trial.program.id";
				break;
			case PROGRAMNAME:
				sortByStr = "s.trial.program.name";
				break;
			case SEASONDBID:
				sortByStr = "season.id";
				break;
			case STUDYDBID:
				sortByStr = "s.id";
				break;
			case STUDYLOCATION:
				sortByStr = "s.location.id";
				break;
			case STUDYTYPEDBID:
				sortByStr = "s.studyType.id";
				break;
			case STUDYTYPENAME:
				sortByStr = "s.studyType.name";
				break;
			case TRIALDBID:
				sortByStr = "s.trial.id ";
				break;
			case STUDYNAME:
			default:
				sortByStr = "s.studyName";
				break;
			}
		}

		return "ORDER BY " + sortByStr + " " + sortOrderStr;
	}
}
