package org.brapi.test.BrAPITestServer.repository.core;

import org.brapi.test.BrAPITestServer.model.entity.core.ProgramEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import io.swagger.model.core.ProgramSearchRequest;

public interface ProgramRepositoryCustom{
	Page<ProgramEntity> findAllBySearch(ProgramSearchRequest request, Pageable pageReq);
}
