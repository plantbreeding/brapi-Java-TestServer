package org.brapi.test.BrAPITestServer.repository.core;

import org.brapi.test.BrAPITestServer.model.entity.LocationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LocationRepository extends PagingAndSortingRepository<LocationEntity, String>{
	Page<LocationEntity> findByLocationType(String locationType, Pageable pageReq);
	long countByLocationType(String locationType);
}
