package org.brapi.test.BrAPITestServer.repository.geno;

import org.brapi.test.BrAPITestServer.model.entity.geno.SampleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import io.swagger.model.geno.SampleSearchRequest;

public interface SampleRepositoryCustom {
	Page<SampleEntity> findBySearch(SampleSearchRequest request, Pageable pageReq);
}
