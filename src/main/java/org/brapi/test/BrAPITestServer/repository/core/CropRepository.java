package org.brapi.test.BrAPITestServer.repository.core;

import org.brapi.test.BrAPITestServer.model.entity.core.CropEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CropRepository extends BrAPIRepository<CropEntity, String>{
	public Page<CropEntity> findByCropName(String cropName, Pageable pageRequest);
}
