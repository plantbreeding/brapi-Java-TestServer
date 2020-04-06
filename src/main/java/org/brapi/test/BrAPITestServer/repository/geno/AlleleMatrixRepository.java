package org.brapi.test.BrAPITestServer.repository.geno;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.brapi.test.BrAPITestServer.model.entity.geno.AlleleMatrixEntity;
import org.brapi.test.BrAPITestServer.repository.core.BrAPIRepository;

public interface AlleleMatrixRepository extends BrAPIRepository<AlleleMatrixEntity, String>{
	public Page<AlleleMatrixEntity> findAllByStudy_Id(String studyDbId, Pageable pageReq);
}
