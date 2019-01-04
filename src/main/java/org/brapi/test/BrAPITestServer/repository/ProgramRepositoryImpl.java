package org.brapi.test.BrAPITestServer.repository;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.brapi.test.BrAPITestServer.model.entity.ProgramEntity;
import org.brapi.test.BrAPITestServer.service.CustomRepositorySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import io.swagger.model.ProgramsSearchRequest;

public class ProgramRepositoryImpl implements ProgramRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private CustomRepositorySearchService<ProgramEntity> customRepositorySearchService;
	
	public ProgramRepositoryImpl(CustomRepositorySearchService<ProgramEntity> customRepositorySearchService) {
		this.customRepositorySearchService = customRepositorySearchService;
	}

	@Override
	public Page<ProgramEntity> findAllBySearch(ProgramsSearchRequest request, Pageable pageReq) {
		Map<String, Object> params = new HashMap<>();
		String queryStr = buildQueryString(request, params);
		Page<ProgramEntity> page = customRepositorySearchService.findAllBySearch(queryStr, params, pageReq, ProgramEntity.class, em);
		return page;
	}

	public String buildQueryString(ProgramsSearchRequest request, Map<String, Object> params) {

		String query = "SELECT p FROM ProgramEntity p where 1=1  ";

		if (request.getAbbreviations() != null && !request.getAbbreviations().isEmpty()) {
			query += "AND p.abbreviation in :abbreviations ";
			params.put("abbreviations", request.getAbbreviations());
		}
		if (request.getLeadPersonDbIds() != null && !request.getLeadPersonDbIds().isEmpty()) {
			query += "AND p.leadPerson.id in :leadPersonDbIds ";
			params.put("leadPersonDbIds", request.getLeadPersonDbIds());
		}
		if (request.getLeadPersonNames() != null && !request.getLeadPersonNames().isEmpty()) {
			query += "AND (";
			int i = 0;
			for (String name : request.getLeadPersonNames()) {
				if (i > 0)
					query += "OR ";
				String wildcardName = "%" + name + "%";
				query += "(p.leadPerson.firstName LIKE :wildcardName" + i
						+ " OR p.leadPerson.lastName LIKE :wildcardName" + i
						+ " OR CONCAT(p.leadPerson.firstName, ' ', p.leadPerson.lastName) LIKE :wildcardName" + i
						+ ") ";
				params.put("wildcardName" + i, wildcardName);
				i++;
			}
			query += ") ";
		}
		if (request.getCommonCropNames() != null && !request.getCommonCropNames().isEmpty()) {
			query += "AND p.crop.cropName in :commonCropNames ";
			params.put("commonCropNames", request.getCommonCropNames());
		}
		if (request.getObjectives() != null && !request.getObjectives().isEmpty()) {
			query += "AND p.objective in :objectives ";
			params.put("objectives", request.getObjectives());
		}
		if (request.getProgramDbIds() != null && !request.getProgramDbIds().isEmpty()) {
			query += "AND p.id in :programDbIds ";
			params.put("programDbIds", request.getProgramDbIds());
		}
		if (request.getProgramNames() != null && !request.getProgramNames().isEmpty()) {
			query += "AND p.name in :programNames ";
			params.put("programNames", request.getProgramNames());
		}

		return query;
	}
}
