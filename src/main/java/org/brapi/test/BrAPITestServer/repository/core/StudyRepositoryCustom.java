package org.brapi.test.BrAPITestServer.repository.core;

import org.brapi.test.BrAPITestServer.model.entity.StudyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.swagger.model.core.StudySearchRequest;

public interface StudyRepositoryCustom {
	public Page<StudyEntity> findBySearch(StudySearchRequest request, Pageable pageReq);

}
