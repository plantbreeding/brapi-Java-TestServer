package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.SampleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import io.swagger.model.SampleSearchRequestDep;

public interface SampleRepositoryCustom {
	Page<SampleEntity> findBySearch(SampleSearchRequestDep request, Pageable pageReq);
}
