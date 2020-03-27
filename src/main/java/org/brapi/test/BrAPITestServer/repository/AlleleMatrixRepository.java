package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.AlleleMatrixEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.brapi.test.BrAPITestServer.repository.core.BrAPIRepository;

public interface AlleleMatrixRepository extends BrAPIRepository<AlleleMatrixEntity, String>{
	public Page<AlleleMatrixEntity> findAllByStudy_Id(String studyDbId, Pageable pageReq);
}
