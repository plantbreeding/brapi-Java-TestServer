package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.ProgramEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import io.swagger.model.ProgramsSearchRequest;

public interface ProgramRepositoryCustom{
	Page<ProgramEntity> findAllBySearch(ProgramsSearchRequest request, Pageable pageReq);
}
