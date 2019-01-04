package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.StudyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import io.swagger.model.StudySearchRequest;
import io.swagger.model.StudySearchRequest.SortByEnum;
import io.swagger.model.StudySearchRequest.SortOrderEnum;

public interface StudyRepositoryCustom {
	public Page<StudyEntity> findBySearch(StudySearchRequest request, Pageable pageReq);

}
