package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.GenomeMapEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.swagger.model.GenomeMapSearchRequest;

public interface GenomeMapRepositoryCustom{
	public Page<GenomeMapEntity> findBySearch(GenomeMapSearchRequest request, Pageable pageRequest);

}
